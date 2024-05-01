# Device-Price-Prediction

## Getting Started
#### For the data manipulation and model creation check the jupyter notebook "Devices Price Classification System" With the details documented as markdown cells inside the notebook.

### Springboot Project
### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Python 3.x
- Jep library

### Apply the following commands in order:
#### Database creation inside docker container:
1. docker-compose up -d
#### Project Compilation and Running
2. gradle clean build  
3. ./gradlew bootRun
#### Database population
4. Call localhost:1337/api/excel/import with the content of the file jsonfied_data.txt as the body.
#### Predicting
5. Call localhost:1337/api/predict/{id} with the id of the device to view

#### All of the devices in the test file were applied this process and the results are added to the column price_range in test_predicted.xlsx
