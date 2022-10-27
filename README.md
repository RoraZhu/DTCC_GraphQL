# DTCC-Restful APIs
This project implements Restful APIs for CTM, Alert & Trade Suite.

## Connect to Snowflake

Before running the project please set up the environmental variables to update the application.properties under src/main/resources with your snowflake connection details
```
spring.datasource.url=jdbc:snowflake://${SNOWFLAKE_ACCOUNTNAME}.us-east-1.snowflakecomputing.com:443?db=${SNOWFLAKE_DATABASE}&warehouse=${SNOWFLAKE_WAREHOUSE}&schema=GRAPHQL
spring.datasource.username=${SNOWFLAKE_USER}
spring.datasource.password=${SNOWFLAKE_PASSWORD}
