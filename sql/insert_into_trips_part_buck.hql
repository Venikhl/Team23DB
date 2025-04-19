USE team23_projectdb;

SET hive.exec.dynamic.partition = true;
SET hive.exec.dynamic.partition.mode = nonstrict;

SET hive.exec.max.dynamic.partitions = 1000;
SET hive.exec.max.dynamic.partitions.pernode = 1000;

INSERT OVERWRITE TABLE trips_part_buck
PARTITION (pickup_date)
SELECT
  trip_id,
  vendor_id,
  pickup_datetime,
  dropoff_datetime,
  passenger_count,
  trip_distance,
  rate_code,
  store_and_fwd_flag,
  payment_type,
  fare_amount,
  extra,
  mta_tax,
  tip_amount,
  tolls_amount,
  imp_surcharge,
  total_amount,
  pickup_location_id,
  dropoff_location_id,
  from_unixtime(CAST(pickup_datetime / 1000 AS BIGINT), 'yyyy-MM') AS pickup_date
FROM trips;
