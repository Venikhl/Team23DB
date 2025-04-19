USE team23_projectdb;

DROP TABLE IF EXISTS q5_results;

CREATE EXTERNAL TABLE q5_results (
    fare_amount FLOAT,
    avg_tip FLOAT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION 'project/hive/warehouse/q5';

SET hive.resultset.use.unique.column.names=false;

INSERT INTO q5_results
SELECT
    CAST(fare_amount AS FLOAT) AS fare_amount,
    AVG(CAST(tip_amount AS FLOAT)) AS avg_tip
FROM trips_part_buck
WHERE fare_amount RLIKE '^[0-9.]+$' AND tip_amount RLIKE '^[0-9.]+$'
GROUP BY CAST(fare_amount AS FLOAT);

SELECT * FROM q5_results;
