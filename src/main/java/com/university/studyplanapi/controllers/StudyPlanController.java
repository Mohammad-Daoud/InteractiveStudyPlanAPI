package com.university.studyplanapi.controllers;


import com.university.studyplanapi.model.plan.Plan;
import com.university.studyplanapi.services.StudyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class StudyPlanController {
    @Autowired
    private StudyPlanService normalService;


    @PostMapping ("/read/get-plan/{username}")
    public Object getPlan(@RequestBody Plan planCriteria,
   @PathVariable String username){
        return normalService.getStudyPlan(planCriteria,username);
//        return normalService.getStudyPlan(planCriteria);
    }

}
