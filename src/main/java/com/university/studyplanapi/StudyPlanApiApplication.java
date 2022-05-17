package com.university.studyplanapi;

import com.university.studyplanapi.config.FileConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableConfigurationProperties({
        FileConfig.class
})
public class StudyPlanApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyPlanApiApplication.class, args);
    }

}
