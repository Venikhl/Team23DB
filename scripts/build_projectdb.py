import psycopg2 as psql
from pprint import pprint
import os

file = os.path.join("secrets", ".psql.pass")
with open(file, "r") as f:
    password = f.read().strip()

conn_string = f"host=hadoop-04.uni.innopolis.ru port=5432 user=team23 dbname=team23_projectdb password={password}"

with psql.connect(conn_string) as conn:
    cur = conn.cursor()

    with open(os.path.join("sql", "create_tables.sql")) as file:
        cur.execute(file.read())
    conn.commit()

    with open(os.path.join("sql", "import_data.sql")) as file:
        command = file.read()
        with open(os.path.join("data", "taxi_trip_data.csv"), "r") as datafile:
            cur.copy_expert(command, datafile)
    conn.commit()

    with open(os.path.join("sql", "test_database.sql")) as file:
        for command in file.readlines():
            if command.strip():
                cur.execute(command)
                pprint(cur.fetchall())

