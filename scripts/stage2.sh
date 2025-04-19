#!/bin/bash

set -e

password=$(head -n 1 secrets/.hive.pass)

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team23 -p "$password" -f sql/db.hql
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team23 -p "$password" -f sql/create_trips_part_buck.hql
hdfs dfs -rm -r -skipTrash project/hive/warehouse/trips_part_buck || true
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team23 -p "$password" -f sql/insert_into_trips_part_buck.hql

for i in {1..5}; do
  beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team23 -p "$password" -f sql/q$i.hql
  beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team23 -p "$password" -e "
  USE team23_projectdb;
  INSERT OVERWRITE DIRECTORY 'project/output/q$i'
  ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
  SELECT * FROM q${i}_results;
  "

  if [ "$i" == "1" ]; then
    echo "pickup_month,avg_tip" > output/q1.csv
  elif [ "$i" == "2" ]; then
    echo "pickup_hour,avg_tip" > output/q2.csv
  elif [ "$i" == "3" ]; then
    echo "pickup_location_id,dropoff_location_id,avg_tip" > output/q3.csv
  elif [ "$i" == "4" ]; then
    echo "trip_distance_bin,avg_tip" > output/q4.csv
  elif [ "$i" == "5" ]; then
    echo "fare_amount_bin,avg_tip" > output/q5.csv
  fi

  hdfs dfs -cat project/output/q${i}/* >> output/q${i}.csv
done
