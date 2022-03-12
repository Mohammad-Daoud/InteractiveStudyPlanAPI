package com.university.studyplanapi.controllers;


import com.university.studyplanapi.models.Course;
import com.university.studyplanapi.services.StudyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudyPlanController {
    @Autowired
    private StudyPlanService service;

    @GetMapping("/read/get-plan")
    public List<Course> getPlan(@RequestParam int year){
        return service.getStudyPlan(year);
    }
}
