# Scripts

## Overview

This folder contains all the scripts used to automate the workflow of the project, from data collection to model training and dashboard preparation. The scripts are organized by project stages and handle tasks such as data ingestion, storage, processing, and analysis using PostgreSQL, HDFS, Hive, Spark, and Superset.

## File Structure

- **build_projectdb.py**: Connects to PostgreSQL, drops existing tables, recreates them, and loads data using COPY FROM STDIN.
- **data_collection.sh**: Downloads the dataset from the source URL and unzips it into the appropriate directory.
- **data_storage.sh**: Sets up PostgreSQL, runs build_projectdb.py, and verifies data ingestion with test SQL queries.
- **model.py**: Creates a Spark session with Hive support, loads data from Hive, trains ML models (Linear Regression, Gradient Boosted Trees), and saves predictions and metrics.
- **stage1.sh**: Automates the Stage I workflow including data collection, database setup, and export to HDFS via Sqoop.
- **stage2.sh**: Automates Hive table creation and partitioning, and runs HiveQL queries for EDA.
- **stage3.sh**: Trains ML models using Spark MLlib, performs hyperparameter tuning and evaluation, and saves results.
- **stage4.sh**: Prepares data for dashboards and exports results for visualization in Superset.
- **to_hdfs.sh**: Imports PostgreSQL data into HDFS using Sqoop, compresses data with Avro + Snappy, and moves the .avsc file to the output folder.
