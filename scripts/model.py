from pyspark.sql import SparkSession
import logging

# Add here your team number
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

spark.sparkContext.setLogLevel("ERROR")

# You can now add your Spark ML code here...
print("Spark Session started successfully!")

# Show available databases
spark.sql("SHOW DATABASES").show()

# Set the active database to team23_projectdb
spark.sql("USE team23_projectdb")

# Show tables in the current database
spark.sql("SHOW TABLES").show()

# Query data from one of the tables to verify the connection and query
spark.sql("SELECT * FROM q1_results LIMIT 10").show()

spark.sql("SELECT * FROM trips LIMIT 10").show()

spark.sql("SELECT * FROM trips_part_buck LIMIT 10").show()