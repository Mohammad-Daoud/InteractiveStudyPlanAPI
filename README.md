# InteractiveStudyPlanAPI
## Description
The REST API for handling all requests from **[Interactive Study Plan REST API](https://github.com/Mohammad-Daoud/InteractiveStudyPlanAPI.git)**.
and **[Interactive Study Plan Web](https://github.com/Mohammad-Daoud/InteractiveStudyPlanWeb.git)**.

## Installation
You should have ***Maven***, ***JDK 11***, and ***MySQL server .i.e 
MySQL Workbench***.

Fork the Project or Download the project as a ZIP file.
Run the **DB.sql** on your SQL server then you are ready to go ! 

Go to **src/main/java/com/university/studyplanapi/config/DatabaseConfig.java**
and change the url for Database Config of yours .i.e:

```
@Configuration
public class DatabaseConfig {
    @Bean
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university" ,
                    "root", "root");
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
```

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