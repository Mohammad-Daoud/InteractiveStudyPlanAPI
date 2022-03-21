package com.university.studyplanapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class StudyPlanApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyPlanApiApplication.class, args);
    }

}
