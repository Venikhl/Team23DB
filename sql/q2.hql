USE team23_projectdb;

DROP TABLE IF EXISTS q2_results;

CREATE EXTERNAL TABLE q2_results (
    pickup_hour INT,
    avg_tip FLOAT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION 'project/hive/warehouse/q2';

SET hive.resultset.use.unique.column.names=false;

INSERT INTO q2_results
SELECT
    hour(from_unixtime(CAST(pickup_datetime / 1000 AS BIGINT))) AS pickup_hour,
    AVG(CAST(tip_amount AS FLOAT)) AS avg_tip
FROM trips_part_buck
GROUP BY hour(from_unixtime(CAST(pickup_datetime / 1000 AS BIGINT)))
ORDER BY pickup_hour;

SELECT * FROM q2_results;
