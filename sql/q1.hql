USE team23_projectdb;

DROP TABLE IF EXISTS q1_results;
CREATE TABLE q1_results (
    pickup_month STRING,
    avg_tip DOUBLE
);

INSERT INTO q1_results
SELECT
    from_unixtime(CAST(pickup_datetime / 1000 AS BIGINT), 'yyyy-MM') AS pickup_month,
    AVG(CAST(tip_amount AS DOUBLE)) AS avg_tip
FROM trips_part_buck
GROUP BY from_unixtime(CAST(pickup_datetime / 1000 AS BIGINT), 'yyyy-MM')
ORDER BY pickup_month;
