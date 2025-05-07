# SQL

## Overview

This folder contains all the SQL and HiveQL scripts used for managing the database and analyzing data tables.

## File Structure

- **create_tables.sql**: Creates PostgreSQL tables in the team23_projectdb database with appropriate data types and constraints.
- **import_data.sql**: Loads CSV data into PostgreSQL tables using COPY FROM STDIN.
- **test_database.sql**: Tests database setup and data integrity using SELECT queries.
- **db.hql**: Creates the Hive database and an external table stored in HDFS using the Avro format.
- **create_trips_part_buck.hql**: Creates a partitioned and bucketed Hive table, partitioned by pickup_date and bucketed by vendor_id.
- **insert_into_trips_part_buck.hql**: Inserts data into the partitioned Hive table using dynamic partitioning.
- **q1.hql**: HiveQL query to calculate the average tip by month. Results are saved to a Hive table and exported as CSV.
- **q2.hql**: HiveQL query to calculate the average tip by hour. Results are saved to a Hive table and exported as CSV.
- **q3.hql**: HiveQL query to calculate the average tip by pickup and dropoff location. Results are saved to a Hive table and exported as CSV.
- **q4.hql**: HiveQL query to calculate the average tip by trip distance. Results are saved to a Hive table and exported as CSV.
- **q5.hql**: HiveQL query to calculate the average tip by fare amount. Results are saved to a Hive table and exported as CSV.
