package com.university.studyplanapi.controllers;


import com.university.studyplanapi.model.plan.Course;
import com.university.studyplanapi.model.plan.Plan;
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

    @PostMapping ("/read/get-plan")
    public List<Course> getPlan(@RequestBody Plan planCriteria){
        return normalService.getStudyPlan(planCriteria);
    }

    @PostMapping ("/read/upload")
    public List<Course> getCsvPlan(@RequestBody Plan planCriteria){
        return ioService.getStudyPlan(planCriteria);
    }

}
