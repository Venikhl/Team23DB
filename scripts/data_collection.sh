#!/bin/bash

set -e

rm -rf data/*

echo "Download"

kaggle datasets download -d neilclack/nyc-taxi-trip-data-google-public-data -p data

echo "Unzip"
unzip data/nyc-taxi-trip-data-google-public-data.zip -d data

rm data/nyc-taxi-trip-data-google-public-data.zip

echo "Dataset in ./data"

find data -maxdepth 1 -type f -name '*.csv' ! -name 'taxi_trip_data.csv' -delete

echo "Deleted trash"
