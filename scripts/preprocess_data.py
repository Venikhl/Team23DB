from pyspark.sql import SparkSession
from pyspark.sql import functions as F
from pyspark.ml.feature import (VectorAssembler, StringIndexer, StandardScaler)
from pyspark.ml import Transformer, Pipeline
from pyspark.sql.types import DoubleType
from pyspark.sql.functions import col
import math
import argparse
import os

def run(command):
    """Helper function to run shell commands"""
    return os.popen(command).read()

class CyclicalTransformer(Transformer):
    """Custom transformer for cyclical feature encoding"""
    def __init__(self, inputCol=None, maxVal=None):
        super(CyclicalTransformer, self).__init__()
        self.inputCol = inputCol
        self.maxVal = maxVal

    def _transform(self, df):
        return df.withColumn(f"{self.inputCol}_sin", F.sin(2 * math.pi * F.col(self.inputCol) / self.maxVal)) \
                 .withColumn(f"{self.inputCol}_cos", F.cos(2 * math.pi * F.col(self.inputCol) / self.maxVal))

def initialize_spark_session(team="team23"):
    """Initialize and return Spark session with Hive support"""
    warehouse = "project/hive/warehouse"
    return SparkSession.builder\
        .appName(f"{team} - spark ML")\
        .master("yarn")\
        .config("hive.metastore.uris", "thrift://hadoop-02.uni.innopolis.ru:9883")\
        .config("spark.sql.warehouse.dir", warehouse)\
        .config("spark.sql.avro.compression.codec", "snappy")\
        .enableHiveSupport()\
        .getOrCreate()

def load_and_preprocess_data(spark):
    """Load and preprocess the taxi trip data"""
    taxi = spark.read.format("avro").table('team23_projectdb.trips_part_buck')
    
    # Extract datetime components
    taxi = taxi.withColumn("pickup_timestamp", F.from_unixtime(F.col("pickup_datetime"))) \
        .withColumn("pickup_year", F.year("pickup_timestamp")) \
        .withColumn("pickup_month", F.month("pickup_timestamp")) \
        .withColumn("pickup_day", F.dayofmonth("pickup_timestamp")) \
        .withColumn("pickup_hour", F.hour("pickup_timestamp")) \
        .withColumn("pickup_minute", F.minute("pickup_timestamp")) \
        .withColumn("pickup_second", F.second("pickup_timestamp"))
    
    # Apply cyclical transformations
    transformers = [
        CyclicalTransformer(inputCol="pickup_month", maxVal=12),
        CyclicalTransformer(inputCol="pickup_day", maxVal=31),
        CyclicalTransformer(inputCol="pickup_hour", maxVal=24),
        CyclicalTransformer(inputCol="pickup_minute", maxVal=60),
        CyclicalTransformer(inputCol="pickup_second", maxVal=60)
    ]
    
    for transformer in transformers:
        taxi = transformer.transform(taxi)
    
    return taxi

def prepare_features(taxi):
    """Prepare features for ML pipeline"""
    # Define columns
    categorical_columns = ["rate_code", "payment_type"]
    numerical_columns = [
        "trip_distance", "tolls_amount", "imp_surcharge", 
        "total_amount", "pickup_year", "pickup_month_sin", "pickup_month_cos", 
        "pickup_day_sin", "pickup_day_cos", "pickup_hour_sin", "pickup_hour_cos", 
        "pickup_minute_sin", "pickup_minute_cos"
    ]
    
    # Cast to appropriate types
    for c in numerical_columns:
        taxi = taxi.withColumn(c, col(c).cast(DoubleType()))
    taxi = taxi.withColumn("tip_amount", col("tip_amount").cast(DoubleType()))
    
    # Create pipeline stages
    indexers = [StringIndexer(inputCol=col, outputCol=f"{col}_index") for col in categorical_columns]
    assembler = VectorAssembler(inputCols=numerical_columns, outputCol="numerical_features")
    scaler = StandardScaler(inputCol="numerical_features", outputCol="scaled_features", 
                          withStd=True, withMean=True)
    
    # Build and run pipeline
    pipeline = Pipeline(stages=indexers + [assembler, scaler])
    scaling_and_encoding_model = pipeline.fit(taxi)
    taxi_transformed = scaling_and_encoding_model.transform(taxi)
    
    # Final feature assembly
    final_assembler = VectorAssembler(
        inputCols=[f"{col}_index" for col in categorical_columns] + ["scaled_features"],
        outputCol="features"
    )
    
    return final_assembler.transform(taxi_transformed).select("features", col("tip_amount").alias("label"))

def save_datasets(train_data, test_data, output_path):
    """Save train and test datasets"""
    train_data.select("features", "label")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("json")\
    .save(f"{output_path}/train")


    test_data.select("features", "label")\
        .coalesce(1)\
        .write\
        .mode("overwrite")\
        .format("json")\
        .save(f"{output_path}/test")
        # Run it from root directory of the repository
    run(f"hdfs dfs -cat {output_path}/train/*.json > ../data/train.json")

    # Run it from root directory of the repository
    run(f"hdfs dfs -cat {output_path}/test/*.json > ../data/test.json")

def main():
    # Argument parser
    parser = argparse.ArgumentParser()
    parser.add_argument("--output_path", default="project/data",
                       help="HDFS path to save train/test datasets")
    args = parser.parse_args()

    # Initialize Spark
    spark = initialize_spark_session()

    try:
        # Load and preprocess data
        print("Loading and preprocessing data...")
        taxi = load_and_preprocess_data(spark)
        
        # Prepare features
        print("Preparing features...")
        transformed = prepare_features(taxi)
        
        # Split data
        train_data, test_data = transformed.randomSplit([0.6, 0.4], seed=42)
        
        # Save datasets
        print(f"Saving datasets to {args.output_path}...")
        save_datasets(train_data, test_data, args.output_path)
        
        print("Data preprocessing and splitting completed successfully!")
        
    finally:
        spark.stop()

if __name__ == "__main__":
    main()