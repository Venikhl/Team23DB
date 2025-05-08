from pyspark.ml.regression import LinearRegression
from pyspark.ml.tuning import ParamGridBuilder, CrossValidator
from pyspark.ml.evaluation import RegressionEvaluator
def run(command):
    return os.popen(command).read()
# Argument parser
parser = argparse.ArgumentParser()
parser.add_argument("--train_path", required=True, help="Path to training data (JSON)")
parser.add_argument("--test_path", required=True, help="Path to test data (JSON)")
parser.add_argument("--model_output_path", required=True, help="HDFS path to save the trained model")
parser.add_argument("--prediction_output_path", required=True, help="HDFS path to save predictions")
args = parser.parse_args()

train_data = spark.read.json(args.train_path)
test_data = spark.read.json(args.test_path)


# Create Linear Regression Model
lr = LinearRegression()

# Fit the data to the pipeline stages
model_lr = lr.fit(train_data)
predictions = model_lr.transform(test_data)
predictions.select("label", "prediction").show()

 

# Evaluate the performance of the model
evaluator1_rmse = RegressionEvaluator(labelCol="labepl", predictionCol="prediction", metricName="rmse")
evaluator1_r2 = RegressionEvaluator(labelCol="label", predictionCol="prediction", metricName="r2")

rmse = evaluator1_rmse.evaluate(predictions)
r2 = evaluator1_r2.evaluate(predictions)

print("Root Mean Squared Error (RMSE) on test data = {}".format(rmse))
print("R^2 on test data = {}".format(r2))



lr = LinearRegression(featuresCol="features", labelCol="label")

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

cvModel = cv.fit(train_data)

bestModel = cvModel.bestModel
print(f"Best parameters: regParam={bestModel.getRegParam()}, elasticNet={bestModel.getElasticNetParam()}")

model1.write().overwrite().save(args.model_output_path)

# Run it from root directory of the repository
run(f"hdfs dfs -get {args.model_output_path} ../models/model1")

predictions = model1.transform(test_data)
predictions.show()

predictions.select("label", "prediction")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header","true")\
    .save(args.prediction_output_path)

# Run it from root directory of the repository
run(f"hdfs dfs -cat {args.prediction_output_path}/*.csv > ../output/model1_predictions.csv")