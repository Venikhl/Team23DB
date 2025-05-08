#!/bin/bash

# Fail on first error
set -e

echo "Starting Stage III pipeline..."

# Define HDFS paths
TRAIN_PATH="project/data/train"
TEST_PATH="project/data/test"
MODEL1_PATH="project/models/model1"
MODEL2_PATH="project/models/model2"
PRED1_PATH="project/output/model1_predictions"
PRED2_PATH="project/output/model2_predictions"
EVAL_PATH="project/output/evaluation"

# Step 2: Preprocess data
echo "Preprocessing data from Hive..."
spark-submit scripts/preprocess_data.py \
    --train_output_path "$TRAIN_PATH" \
    --test_output_path "$TEST_PATH"

# Step 3: Train Model 1
echo "Training Model 1..."
spark-submit scripts/train_model1.py \
    --train_path "$TRAIN_PATH" \
    --test_path "$TEST_PATH" \
    --model_output_path "$MODEL1_PATH" \
    --prediction_output_path "$PRED1_PATH"

# Step 4: Train Model 2
echo "Training Model 2..."
spark-submit scripts/train_model2.py \
    --train_path "$TRAIN_PATH" \
    --test_path "$TEST_PATH" \
    --model_output_path "$MODEL2_PATH" \
    --prediction_output_path "$PRED2_PATH"

# Step 5: Compare models
echo "Comparing Model 1 and Model 2..."
spark-submit --master yarn compare_models.py \
    --prediction1_path "$PRED1_PATH" \
    --prediction2_path "$PRED2_PATH" \
    --output_path "$EVAL_PATH"

# Step 6: Run pylint for code quality check
echo "Running pylint on all Python scripts..."
pylint scripts/*.py > output/pylint_report.txt || true

echo "Stage III complete. All outputs saved to HDFS and reports saved to local output folder."
