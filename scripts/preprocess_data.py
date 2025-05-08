from pyspark.sql import SparkSession

team = "team23"

# location of your Hive database in HDFS
warehouse = "project/hive/warehouse"

spark = SparkSession.builder\
        .appName("{} - spark ML".format(team))\
        .master("yarn")\
        .config("hive.metastore.uris", "thrift://hadoop-02.uni.innopolis.ru:9883")\
        .config("spark.sql.warehouse.dir", warehouse)\
        .config("spark.sql.avro.compression.codec", "snappy")\
        .enableHiveSupport()\
        .getOrCreate()

taxi = spark.read.format("avro").table('team23_projectdb.trips_part_buck')


from pyspark.sql import functions as F
from pyspark.ml.feature import VectorAssembler, VectorIndexer
from pyspark.ml import Transformer
import math

# Step 1: Decompose pickup_datetime and other time-related features into cyclical components
taxi = taxi.withColumn("pickup_timestamp", F.from_unixtime(F.col("pickup_datetime"))) \
    .withColumn("pickup_year", F.year("pickup_timestamp")) \
    .withColumn("pickup_month", F.month("pickup_timestamp")) \
    .withColumn("pickup_day", F.dayofmonth("pickup_timestamp")) \
    .withColumn("pickup_hour", F.hour("pickup_timestamp")) \
    .withColumn("pickup_minute", F.minute("pickup_timestamp")) \
    .withColumn("pickup_second", F.second("pickup_timestamp"))
# Step 2: Build a custom cyclical transformer
class CyclicalTransformer(Transformer):
    def __init__(self, inputCol=None, maxVal=None):
        super(CyclicalTransformer, self).__init__()
        self.inputCol = inputCol
        self.maxVal = maxVal

    def _transform(self, df):
        return df.withColumn(f"{self.inputCol}_sin", F.sin(2 * math.pi * F.col(self.inputCol) / self.maxVal)) \
                 .withColumn(f"{self.inputCol}_cos", F.cos(2 * math.pi * F.col(self.inputCol) / self.maxVal))
# Step 3: Apply cyclical transformations to time columns
month_cyclical = CyclicalTransformer(inputCol="pickup_month", maxVal=12)
day_cyclical = CyclicalTransformer(inputCol="pickup_day", maxVal=31)
hour_cyclical = CyclicalTransformer(inputCol="pickup_hour", maxVal=24)
minute_cyclical = CyclicalTransformer(inputCol="pickup_minute", maxVal=60)
second_cyclical = CyclicalTransformer(inputCol="pickup_second", maxVal=60)
taxi = month_cyclical.transform(taxi)
taxi = day_cyclical.transform(taxi)
taxi = hour_cyclical.transform(taxi)
taxi = minute_cyclical.transform(taxi)
taxi = second_cyclical.transform(taxi)
from pyspark.ml.feature import StringIndexer, StandardScaler, VectorAssembler
from pyspark.sql.types import DoubleType
from pyspark.ml import Pipeline
from pyspark.sql.functions import col

# Step 1: Define categorical columns
categorical_columns = ["rate_code", "payment_type"]

# Step 2: Define numerical columns
numerical_columns = [
    "trip_distance", "tolls_amount", "imp_surcharge", 
    "total_amount", "pickup_year", "pickup_month_sin", "pickup_month_cos", 
    "pickup_day_sin", "pickup_day_cos", "pickup_hour_sin", "pickup_hour_cos", 
    "pickup_minute_sin", "pickup_minute_cos"# , "pickup_second_sin", "pickup_second_cos"
]

for c in numerical_columns:
    taxi = taxi.withColumn(c, col(c).cast(DoubleType()))
taxi = taxi.withColumn("tip_amount", col("tip_amount").cast(DoubleType()))

# Step 3: Create StringIndexer for categorical features
indexers = [StringIndexer(inputCol=col, outputCol=f"{col}_index") for col in categorical_columns]

# Step 4: Create VectorAssembler for numerical features
assembler = VectorAssembler(inputCols=numerical_columns, outputCol="numerical_features")

# Step 5: Apply StandardScaler to scale the numerical features
scaler = StandardScaler(inputCol="numerical_features", outputCol="scaled_features", withStd=True, withMean=True)

# Step 6: Create a pipeline to apply both StringIndexer for categorical features and StandardScaler for numerical features
pipeline = Pipeline(stages=indexers + [assembler, scaler])

# Step 7: Fit and transform the data
scaling_and_encoding_model = pipeline.fit(taxi)
taxi_transformed = scaling_and_encoding_model.transform(taxi)

# Step 8: Combine scaled features and encoded categorical features into a single vector
final_assembler = VectorAssembler(
    inputCols=[f"{col}_index" for col in categorical_columns] + ["scaled_features"],
    outputCol="features"
)

# Apply final assembler to create the 'features' column
final_df = final_assembler.transform(taxi_transformed)

# Step 9: Select only the 'features' and rename 'tip_amount' to 'label'
final_df = final_df.select("features", col("tip_amount").alias("label"))

# Show the final DataFrame
final_df.show()
