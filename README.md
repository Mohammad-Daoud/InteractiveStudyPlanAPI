# InteractiveStudyPlanAPI
## Description
The REST API for handling all requests from **[Interactive Study Plan REST API](https://github.com/Mohammad-Daoud/InteractiveStudyPlanAPI.git)**.
and **[Interactive Study Plan Web](https://github.com/Mohammad-Daoud/InteractiveStudyPlanWeb.git)**

## Installation
You should have ***Maven***, ***JDK 11***, and ***MySQL server .i.e 
MySQL Workbench***.

Fork the Project or Download the project as a ZIP file.
Run the **DB.sql** on your SQL server then you are ready to go ! 

**NOTE**: Recommended before running the project.
``` 
mvn clean  
```

```
mvn install -Dmaven.test.skip=true 
```

## Calls For Test the API
You can test Each Call using [Swagger](https://swagger.io/) 
or [PostMan](https://www.postman.com/).

The project includes ***Swagger*** documentation,
This documentation is for you to know the calls that are implemented in the project.

Go to <http://localhost:8000/index.html> for the API calls. (after setting up the project)