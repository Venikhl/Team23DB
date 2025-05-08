import argparse
import os
from pyspark.sql import SparkSession
from pyspark.ml.evaluation import RegressionEvaluator
from pyspark.ml.regression import LinearRegressionModel, GBTRegressionModel

# Helper function to run shell commands
def run(command):
    return os.popen(command).read()

# Parse command-line arguments
parser = argparse.ArgumentParser()
parser.add_argument("--prediction1_path", required=True, help="Path to Model 1 predictions CSV")
parser.add_argument("--prediction2_path", required=True, help="Path to Model 2 predictions CSV")
parser.add_argument("--output_path", required=True, help="Output path for evaluation CSV")
args = parser.parse_args()

# Initialize Spark session
spark = SparkSession.builder.appName("ModelEvaluation").getOrCreate()

# Load prediction CSVs
preds1 = spark.read.csv(args.prediction1_path, header=True, inferSchema=True)
preds2 = spark.read.csv(args.prediction2_path, header=True, inferSchema=True)

# Set up evaluators
evaluator_rmse = RegressionEvaluator(labelCol="label", predictionCol="prediction", metricName="rmse")
evaluator_r2 = RegressionEvaluator(labelCol="label", predictionCol="prediction", metricName="r2")

# Evaluate metrics for model1
rmse1 = float(evaluator_rmse.evaluate(preds1))
r2_1 = float(evaluator_r2.evaluate(preds1))

# Evaluate metrics for model2
rmse2 = float(evaluator_rmse.evaluate(preds2))
r2_2 = float(evaluator_r2.evaluate(preds2))

# Load saved models (paths remain hardcoded)
model1 = LinearRegressionModel.load("project/models/model1")
model2 = GBTRegressionModel.load("project/models/model2")

# Collect results into DataFrame
results = [
    [f"LinearRegressionModel({model1.uid})", rmse1, r2_1],
    [f"GBTRegressionModel({model2.uid})", rmse2, r2_2]
]
df = spark.createDataFrame(results, ["Model", "RMSE", "R2"])

# Show evaluation results
df.show(truncate=False)

# Write results to specified output path
df.coalesce(1)\
  .write\
  .mode("overwrite")\
  .format("csv")\
  .option("sep", ",")\
  .option("header", "true")\
  .save(args.output_path)

# Copy from HDFS to local file system
run(f"hdfs dfs -cat {args.output_path}/*.csv > ../output/evaluation.csv")
