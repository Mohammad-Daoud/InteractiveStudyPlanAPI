package com.university.studyplanapi.controllers;


import com.university.studyplanapi.models.Course;
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

    @GetMapping("/read/get-plan")
    public List<Course> getPlan(@RequestParam int year){
        return normalService.getStudyPlan(year);
    }

    @GetMapping ("/read/upload")
    public List<Course> getCsvPlan(@RequestBody String csvFilePath){
        return ioService.getStudyPlan(csvFilePath);
    }

}
