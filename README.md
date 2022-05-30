# InteractiveStudyPlanAPI
## Description
The REST API for handling all requests from **[Interactive Study Plan React](https://github.com/Mohammad-Daoud/StudyPlanReact)**.
and **[Interactive Study Plan Web](https://github.com/Mohammad-Daoud/InteractiveStudyPlanWeb.git)**.

## Installation
You should have ***Maven***, ***JDK 11***, and ***MySQL server .i.e 
MySQL Workbench***.

Fork the Project or Download the project as a ZIP file.
Run the **DB.sql** on your SQL server then you are ready to go ! 

Go to **src/main/java/com/university/studyplanapi/config/DatabaseConfig.java**
and change the url for Database Config of yours .i.e:

```java
@Configuration
public class DatabaseConfig {
    @Bean
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university" ,//your link here
                    "your username", "your password");
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
```
then go to **src/main/resources/application.properties**
and change the file path of ``file.upload-dir`` properties to the
`resources` directory on your machine .i.e:
```properties
# your file path 
file.upload-dir=/Users/mdss4/Documents/GraduationProject/StudyPlanAPI/src/main/resources/
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
or [Postman](https://www.postman.com/).

The project includes ***Swagger*** documentation,
This documentation is for you to know the calls that are implemented in the project.

Go to <http://localhost:8000/index.html> for the API calls. (after setting up the project)