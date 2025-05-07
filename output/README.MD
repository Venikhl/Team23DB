# Output

## Overview

This folder contains the output files generated during the execution of the project. The files are organized to store results from various stages of the project, including Exploratory Data Analysis (EDA), Machine Learning (ML) model predictions, and model evaluations.

## File Structure

- **evaluation.csv**: A summary of model performance metrics (RMSE, R²) for each ML model built during Stage III of the project.
- **hive_results.txt**: Text file capturing the results of Hive queries executed during the EDA stage (Stage II).

### Model Predictions:

- **model1_predictions.csv**: Predictions made by the first ML model (Linear Regression).
- **model2_predictions.csv**: Predictions made by the second ML model (Gradient Boosting Trees).

### EDA Results:

- **q1.csv**: Result of the first EDA query (Average tip by month).
- **q1.jpg**: Visualization of the first EDA result (Average tip by month).
- **q2.csv**: Result of the second EDA query (Average tip by hour).
- **q2.jpg**: Visualization of the second EDA result (Average tip by hour).
- **q3.csv**: Result of the third EDA query (Tip by pickup/dropoff zones).
- **q3.jpg**: Visualization of the third EDA result (Tip by pickup/dropoff zones).
- **q4.csv:** Result of the fourth EDA query (Average tip by trip distance).
- **q4.jpg:** Visualization of the fourth EDA result (Tip by trip distance).
- **q5.csv:** Result of the fifth EDA query (Average tip by fare amount).
- **q5.jpg:** Visualization of the fifth EDA result (Tip by fare amount).

## Usage

- The JPG files provide quick visual insights into the data.
- The evaluation.csv file is a reference for understanding the performance of the ML models.

## How These Files Were Generated

- EDA CSV and JPG files were created using HiveQL queries on the processed dataset stored in Hive, followed by visualization in Apache Superset.
- ML model predictions were generated using Spark MLlib and saved directly in CSV format.
- The evaluation.csv was produced by comparing the models and saving the performance metrics.
