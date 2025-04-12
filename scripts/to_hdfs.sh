#!/bin/bash
set -e

bash scripts/data_storage.sh

hdfs dfs -rm -r -f /user/team23/project/warehouse/trips || true

password=$(head -n 1 secrets/.psql.pass)

sqoop import \
  --connect jdbc:postgresql://hadoop-04.uni.innopolis.ru/team23_projectdb \
  --username team23 \
  --password $password \
  --table trips \
  --warehouse-dir /user/team23/project/warehouse \
  --as-avrodatafile \
  --compress \
  --compression-codec org.apache.hadoop.io.compress.SnappyCodec \
  --m 1

echo "Done"
