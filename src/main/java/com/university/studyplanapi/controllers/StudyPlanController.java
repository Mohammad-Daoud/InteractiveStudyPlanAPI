package com.university.studyplanapi.controllers;


import com.university.studyplanapi.model.plan.Plan;
import com.university.studyplanapi.services.StudyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StudyPlanController {
    @Autowired
    private StudyPlanService normalService;


    @PostMapping ("/read/get-plan")
    public Object getPlan(@RequestBody Plan planCriteria){
        return normalService.getStudyPlan(planCriteria);
    }

}
