USE team23_projectdb;

DROP TABLE IF EXISTS q3_results;
CREATE EXTERNAL TABLE q3_results (
    pickup_location_id INT,
    dropoff_location_id INT,
    avg_tip DOUBLE
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION 'project/hive/warehouse/q3';

SET hive.resultset.use.unique.column.names=false;

INSERT INTO q3_results
SELECT
    pickup_location_id,
    dropoff_location_id,
    AVG(CAST(tip_amount AS DOUBLE)) AS avg_tip
FROM trips_part_buck
GROUP BY pickup_location_id, dropoff_location_id
ORDER BY avg_tip DESC;

SELECT * FROM q3_results;
