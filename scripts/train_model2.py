from pyspark.sql import SparkSession
from pyspark.ml.regression import GBTRegressor
from pyspark.ml.tuning import ParamGridBuilder, CrossValidator
from pyspark.ml.evaluation import RegressionEvaluator
from pyspark.ml.feature import VectorAssembler
from pyspark.sql.functions import col, udf
from pyspark.sql.types import DoubleType
from pyspark.ml.linalg import Vectors, VectorUDT
import argparse
import os

def run(command):
    return os.popen(command).read()

# Initialize Spark
spark = SparkSession.builder.appName("train model2").getOrCreate()

# Parse arguments
parser = argparse.ArgumentParser()
parser.add_argument("--train_path", required=True, help="Path to training data (JSON)")
parser.add_argument("--test_path", required=True, help="Path to test data (JSON)")
parser.add_argument("--model_output_path", required=True, help="HDFS path to save the trained model")
parser.add_argument("--prediction_output_path", required=True, help="HDFS path to save predictions")
args = parser.parse_args()

# Load train and test data from JSON
train_data = spark.read.json(args.train_path)
test_data = spark.read.json(args.test_path)

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

# --- Phase 1: Standard GBT training ---
print("\n=== Training GBT model ===")
gbt = GBTRegressor(featuresCol="assembled_features", labelCol="label")
model_gbt = gbt.fit(train_data)

predictions = model_gbt.transform(test_data)
predictions.show()

evaluator2_rmse = RegressionEvaluator(labelCol="label", predictionCol="prediction", metricName="rmse")
evaluator2_r2 = RegressionEvaluator(labelCol="label", predictionCol="prediction", metricName="r2")

rmse2 = evaluator2_rmse.evaluate(predictions)
r22 = evaluator2_r2.evaluate(predictions)

print("Root Mean Squared Error (RMSE) on test data = {}".format(rmse2))
print("R^2 on test data = {}".format(r22))

# --- Phase 2: Cross-validation and hyperparameter tuning ---
print("\n=== Hyperparameter tuning with CrossValidator ===")
evaluator = RegressionEvaluator(labelCol="label", predictionCol="prediction", metricName="rmse")

gbt_cv = GBTRegressor(featuresCol="assembled_features", labelCol="label")
grid = ParamGridBuilder() \
    .addGrid(gbt_cv.maxDepth, [3, 5]) \
    .addGrid(gbt_cv.stepSize, [0.05, 0.1]) \
    .build()

cv = CrossValidator(
    estimator=gbt_cv,
    estimatorParamMaps=grid,
    evaluator=evaluator,
    numFolds=3,
    parallelism=4,
    seed=42,
    collectSubModels=False
)

cvModel = cv.fit(train_data)
model2 = cvModel.bestModel

print(f"Best maxDepth: {model2.getMaxDepth()}, Best stepSize: {model2.getStepSize()}")

# Save the best model to HDFS and copy locally
model2.write().overwrite().save(args.model_output_path)
run(f"hdfs dfs -get {args.model_output_path} ../models/model2")

# Predict and save
predictions = model2.transform(test_data)
predictions.show()

predictions.select("label", "prediction") \
    .coalesce(1) \
    .write \
    .mode("overwrite") \
    .format("csv") \
    .option("sep", ",") \
    .option("header", "true") \
    .save(args.prediction_output_path)

run(f"hdfs dfs -cat {args.prediction_output_path}/*.csv > ../output/model2_predictions.csv")

# Final evaluation
evaluator2_rmse = RegressionEvaluator(labelCol="label", predictionCol="prediction", metricName="rmse")
evaluator2_r2 = RegressionEvaluator(labelCol="label", predictionCol="prediction", metricName="r2")

rmse2 = evaluator2_rmse.evaluate(predictions)
r22 = evaluator2_r2.evaluate(predictions)

print("Root Mean Squared Error (RMSE) on test data = {}".format(rmse2))
print("R^2 on test data = {}".format(r22))
