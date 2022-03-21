package com.university.studyplanapi.controllers;


import com.university.studyplanapi.model.Course;
import com.university.studyplanapi.model.Plan;
import com.university.studyplanapi.services.IOService;
import com.university.studyplanapi.services.StudyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class StudyPlanController {
    @Autowired
    private StudyPlanService normalService;
    @Autowired
    private IOService ioService;

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping ("/read/get-plan")
    public List<Course> getPlan(@RequestBody Plan planCriteria){
        return normalService.getStudyPlan(planCriteria);
    }

    @CrossOrigin(origins = "http://localhost:8080,")
    @PostMapping ("/read/upload")
    public List<Course> getCsvPlan(@RequestBody Plan planCriteria){
        return ioService.getStudyPlan(planCriteria);
    }

}
