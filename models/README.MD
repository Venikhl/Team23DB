# Models

## Overview

This folder contains the trained machine learning models built using Spark MLlib during Stage III of the project.

## File Structure

* model1/: Contains the first trained ML model (Linear Regression).
  * metadata/\_SUCCESS: Indicates successful model metadata creation.
  * metadata/part-00000: Stores the model metadata, including the model schema and configuration.

* model2/: Contains the second trained ML model (Gradient Boosting Trees).
  * metadata/\_SUCCESS: Indicates successful model metadata creation.
  * metadata/part-00000: Stores the model metadata, including the model schema and configuration.
  * treesMetadata/\_SUCCESS: Indicates successful tree metadata creation.
  * treesMetadata/part-00000-0fcf2560-9c47-4242-9687-9379ffb1b4ef-c000.snappy.parquet: Stores the structure of the individual trees in the Gradient Boosting model.
