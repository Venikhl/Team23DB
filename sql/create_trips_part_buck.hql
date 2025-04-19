USE team23_projectdb;

DROP TABLE IF EXISTS trips_part_buck;

CREATE EXTERNAL TABLE trips_part_buck (
    trip_id              INT,
    vendor_id            INT,
    pickup_datetime      BIGINT,
    dropoff_datetime     BIGINT,
    passenger_count      INT,
    trip_distance        STRING,
    rate_code            INT,
    store_and_fwd_flag   STRING,
    payment_type         INT,
    fare_amount          STRING,
    extra                STRING,
    mta_tax              STRING,
    tip_amount           STRING,
    tolls_amount         STRING,
    imp_surcharge        STRING,
    total_amount         STRING,
    pickup_location_id   INT,
    dropoff_location_id  INT
)
PARTITIONED BY (pickup_date STRING)
CLUSTERED BY (vendor_id) INTO 7 BUCKETS
STORED AS AVRO
LOCATION 'project/hive/warehouse/trips_part_buck'
TBLPROPERTIES ('AVRO.COMPRESS'='SNAPPY');

