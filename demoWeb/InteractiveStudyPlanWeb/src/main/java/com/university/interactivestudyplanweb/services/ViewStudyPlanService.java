package com.university.interactivestudyplanweb.services;

import com.university.interactivestudyplanweb.handler.ResponseHandler;
import com.university.interactivestudyplanweb.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewStudyPlanService {
    private static final String PLAN_FILE_PATH = "C:/Users/mdss4/Documents/GraduationProject/StudyPlanAPI/src/main/resources/kasit/cs/";
    private final ResponseHandler<Course> COURSE_RESPONSE = new ResponseHandler<>();

    public List<Course>retrieveCSVPlan(int year){
        return COURSE_RESPONSE.postResponse(PLAN_FILE_PATH+year+".csv","upload");
    }
}
