# DTCC-GraphQL API
This project implements graphQL APIs for CTM, Alert & Trade Suite.

## Connect to Snowflake

Before running the project please set up the environmental variables to update the application.properties under src/main/resources with your snowflake connection details
```
spring.datasource.url=jdbc:snowflake://${SNOWFLAKE_ACCOUNTNAME}.us-east-1.snowflakecomputing.com:443?db=${SNOWFLAKE_DATABASE}&warehouse=${SNOWFLAKE_WAREHOUSE}&schema=GRAPHQL
spring.datasource.username=${SNOWFLAKE_USER}
spring.datasource.password=${SNOWFLAKE_PASSWORD}
```

## Run application
URL: http://localhost:8080/apis/graphql  
HTTP method: POST  
Open postman -> body -> graphql -> query

## Sample Query

### find organizations which use Alert by political subdivision
```
findOrganizationsByPoliticalSubdivisionAndAlert(politicalSubdivision: "IA"){
    accessCode,
    accessCodeLeId,
    organization{
        orgId,
        organizationXref{
            org_id,
            orgXrefText,
            orgXrefType,
            orgXrefValue
        },
        orgLongName
    }
}
```

### find users by political subdivision and role
```
findUserInfoByPoliticalSubdivisionAndRoleName(politicalSubdivision: "IA", roleName: "Private HTTP Submit"){
    userType,
    userId,
    locations{
        locationId,
        locationName
    },
}
```

### find trades by political subdivision
```
findTradesByPoliticalSubdivision(politicalSubdivision: "IA"){
    tradeSideId,
    instructingParty{
        orgId
    },
    tradeTransConditionString,
    transportMessageId
}
```

### find trades by security type
```
findTradesBySecurityTypeLp(securityCodeTypeLp: "SWAP"){
    tradeSideId,
    counterParty{
        orgId
    },
    counterPartySideId
}
```

### find trades by external references type, value, and security type
```
findTradesBySecurityTypeAndXrefTypeAndXrefValue(securityCodeType: "SWAP", orgXrefType: "BIC", orgXrefValue: "RUZW8348"){
    counterParty{
        orgId
    },
    executingBroker{
        orgId,
        orgLongName
    }
}
```

### find trades by external references type, value, security type, and dates
```
 findTradesBySecurityTypeAndXrefTypeAndXrefValueAndDate(securityCodeType: "SWAP", orgXrefType: "BIC", orgXrefValue: "RUZW8348", startDate: "2002-01-01",endDate: "2010-12-31"){
    counterParty{
        orgId
    },
    executingBroker{
        orgId,
        orgLongName
    },
    tradeDateTime
 }
```

### find organization by id
```
findOrganizationById(id: 1){
    family{
        familyId,
        familyName,
        familyDescription
    }
}
```

### find family by id
```
findFamilyById(id: 1){
    familyId
    familyName
    familyDescription
}
```

### find trades by date
```
findTradesByDates(startDate: "2002-01-01", endDate: "2008-01-01"){
    tradeSideId,
    executingBroker{
        orgId
        }
    }
```

### Find trades that flowed from CTM to TradeSuite by political subdivision
```
findTradesuitePtasInTsByPoliticalSubdivision(politicalSubdivision: "NY"){
        ctmDetailRefId
        liveTradeDetails{
        tradeDetailId
    }
}

```
