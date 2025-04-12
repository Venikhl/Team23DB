#!/bin/bash
set -e

echo "Download dataset"
bash scripts/data_collection.sh

echo "Load into PostgreSQL"
bash scripts/data_storage.sh

echo "Export to HDFS"
bash scripts/to_hdfs.sh

echo "Done"
