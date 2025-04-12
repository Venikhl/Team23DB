COPY trips(
    vendor_id, pickup_datetime, dropoff_datetime,
    passenger_count, trip_distance, rate_code,
    store_and_fwd_flag, payment_type, fare_amount,
    extra, mta_tax, tip_amount, tolls_amount,
    imp_surcharge, total_amount,
    pickup_location_id, dropoff_location_id
)
FROM STDIN WITH CSV HEADER DELIMITER ',' NULL AS 'null';

