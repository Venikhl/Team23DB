USE team23_projectdb;

DROP TABLE IF EXISTS q4_results;

CREATE EXTERNAL TABLE q4_results (
    trip_distance FLOAT,
    avg_tip FLOAT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION 'project/hive/warehouse/q4';

SET hive.resultset.use.unique.column.names=false;

INSERT INTO q4_results
SELECT
    CAST(trip_distance AS FLOAT) AS trip_distance,
    AVG(CAST(tip_amount AS FLOAT)) AS avg_tip
FROM trips_part_buck
WHERE trip_distance RLIKE '^[0-9.]+$' AND tip_amount RLIKE '^[0-9.]+$'
GROUP BY CAST(trip_distance AS FLOAT);

SELECT * FROM q4_results;
