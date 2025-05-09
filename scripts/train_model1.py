from pyspark.ml.regression import LinearRegression
from pyspark.ml.tuning import ParamGridBuilder, CrossValidator
from pyspark.ml.evaluation import RegressionEvaluator
from pyspark.ml.feature import VectorAssembler
from pyspark.sql import SparkSession
from pyspark.sql.functions import col, udf
from pyspark.sql.types import DoubleType
from pyspark.ml.linalg import Vectors, VectorUDT
import argparse
import os

# Initialize Spark session
spark = SparkSession.builder.appName("train model1").getOrCreate()

# Argument parser
parser = argparse.ArgumentParser()
parser.add_argument("--train_path", required=True, help="Path to training data (JSON)")
parser.add_argument("--test_path", required=True, help="Path to test data (JSON)")
parser.add_argument("--model_output_path", required=True, help="HDFS path to save the trained model")
parser.add_argument("--prediction_output_path", required=True, help="HDFS path to save predictions")
args = parser.parse_args()

# Load train and test data from JSON
train_data = spark.read.json(args.train_path)
test_data = spark.read.json(args.test_path)

# Convert label column to numeric type (Double)
train_data = train_data.withColumn("label", col("label").cast(DoubleType()))
test_data = test_data.withColumn("label", col("label").cast(DoubleType()))

# Convert the 'features' array to a vector column
def array_to_vector(features):
    return Vectors.dense(features)

vector_udf = udf(array_to_vector, VectorUDT())

# Apply UDF to convert features into a vector
train_data = train_data.withColumn("features", vector_udf(col("features.values")))
test_data = test_data.withColumn("features", vector_udf(col("features.values")))

# Now use VectorAssembler on the features column
assembler = VectorAssembler(inputCols=["features"], outputCol="assembled_features")

# Transform data to create the 'assembled_features' column
train_data = assembler.transform(train_data)
test_data = assembler.transform(test_data)

# Create Linear Regression Model
lr = LinearRegression(featuresCol="assembled_features", labelCol="label")

# Fit the model to the training data
model_lr = lr.fit(train_data)

# Make predictions on the test data
predictions = model_lr.transform(test_data)
predictions.select("label", "prediction").show()

# Evaluate the model performance
evaluator1_rmse = RegressionEvaluator(labelCol="label", predictionCol="prediction", metricName="rmse")
evaluator1_r2 = RegressionEvaluator(labelCol="label", predictionCol="prediction", metricName="r2")

rmse = evaluator1_rmse.evaluate(predictions)
r2 = evaluator1_r2.evaluate(predictions)

print("Root Mean Squared Error (RMSE) on test data = {}".format(rmse))
print("R^2 on test data = {}".format(r2))

# Hyperparameter tuning with CrossValidation
grid = ParamGridBuilder() \
    .addGrid(lr.regParam, [0.01, 0.1]) \
    .addGrid(lr.elasticNetParam, [0.0, 1.0]) \
    .build()

evaluator = RegressionEvaluator(metricName="rmse", labelCol="label", predictionCol="prediction")

cv = CrossValidator(
    estimator=lr,
    estimatorParamMaps=grid,
    evaluator=evaluator,
    numFolds=3,
    parallelism=4,
    seed=42
)

# Fit the cross-validation model
cvModel = cv.fit(train_data)

# Get the best model
bestModel = cvModel.bestModel
print(f"Best parameters: regParam={bestModel.getRegParam()}, elasticNet={bestModel.getElasticNetParam()}")

# Save the model to the specified output path
bestModel.write().overwrite().save(args.model_output_path)

# Run HDFS command to retrieve the model (useful for testing)
os.popen(f"hdfs dfs -get {args.model_output_path} ../models/model1").read()

# Load the best model for predictions
model1 = bestModel
predictions = model1.transform(test_data)
predictions.show()

# Save the predictions to the specified output path in CSV format
predictions.select("label", "prediction") \
    .coalesce(1) \
    .write \
    .mode("overwrite") \
    .format("csv") \
    .option("sep", ",") \
    .option("header", "true") \
    .save(args.prediction_output_path)

# Run HDFS command to get the predictions CSV
os.popen(f"hdfs dfs -cat {args.prediction_output_path}/*.csv > ../output/model1_predictions.csv").read()