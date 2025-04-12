START TRANSACTION;

DROP TABLE IF EXISTS trips CASCADE;

CREATE TABLE IF NOT EXISTS trips (
    trip_id SERIAL PRIMARY KEY,
    vendor_id SMALLINT,
    pickup_datetime TIMESTAMP,
    dropoff_datetime TIMESTAMP,
    passenger_count SMALLINT,
    trip_distance NUMERIC(10, 2),
    rate_code SMALLINT,
    store_and_fwd_flag CHAR(1),
    payment_type SMALLINT,
    fare_amount NUMERIC(10, 2),
    extra NUMERIC(10, 2),
    mta_tax NUMERIC(10, 2),
    tip_amount NUMERIC(10, 2),
    tolls_amount NUMERIC(10, 2),
    imp_surcharge NUMERIC(10, 2),
    total_amount NUMERIC(10, 2),
    pickup_location_id SMALLINT,
    dropoff_location_id SMALLINT
);

COMMIT;

