DROP DATABASE IF EXISTS team23_projectdb CASCADE;

CREATE DATABASE team23_projectdb LOCATION 'project/hive/warehouse';

USE team23_projectdb;

CREATE EXTERNAL TABLE IF NOT EXISTS trips
STORED AS AVRO
LOCATION 'project/warehouse/trips'
TBLPROPERTIES (
  'avro.schema.url'='project/warehouse/avsc/trips.avsc'
);

SHOW TABLES;
SELECT * FROM trips LIMIT 10;
