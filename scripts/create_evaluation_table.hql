-- create_evaluation_table.hql
CREATE EXTERNAL TABLE IF NOT EXISTS evaluation (
    model STRING,
    rmse DOUBLE,
    r2 DOUBLE
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE
LOCATION '/project/output/evaluation.csv'
TBLPROPERTIES ("skip.header.line.count"="1");
