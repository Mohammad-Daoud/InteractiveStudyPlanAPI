package com.university.studyplanapi.services;

import com.university.studyplanapi.doi.StudentDoi;
import com.university.studyplanapi.exception.NotFoundException;
import com.university.studyplanapi.io.DirectoryCreator;
import com.university.studyplanapi.model.plan.Course;
import com.university.studyplanapi.model.plan.Plan;
import com.university.studyplanapi.utils.IDGenerator;
import com.university.studyplanapi.utils.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudyPlanService {
    @Autowired
    IOService service;
    private static final Map<Integer, List<Course>> STUDY_PLAN_GROUP = new HashMap<>();
    private static final DirectoryCreator DIRECTORY_WRITER = DirectoryCreator.getInstance();

    public Map<String, Object> getStudyPlan(Plan plan, String username) {
        StudentDoi studentDoi = new StudentDoi();
        Map<String, Object> studyPlan = new HashMap<>();
        studyPlan.put("studyPlan", service.getStudyPlan(plan));
        studyPlan.put("universityPlan",service.getUniversityPlan(plan));
        studyPlan.put("takes", studentDoi.getTakes(username));
        if (studyPlan.get("studyPlan") == null)
            throw new NotFoundException("the plan is not found");
        else return studyPlan;
    }

    public List<Course> getStudyPlan(Plan plan) {
        List<Course> studyPlan = service.getStudyPlan(plan);
        if (studyPlan == null)
            throw new NotFoundException("the plan is not found");
        else return studyPlan;
    }

    public void writeStudyPlan(Plan plan) {
        List<Course> planCourse = service.getUploadedStudyPlan(plan);
        DIRECTORY_WRITER.writeFile(plan, JSON.toJson(planCourse));
    }
    public void writeUniversityPlan(String fileName){
        List<Course> planCourse = service.getUniversityUploadedStudyPlan(fileName);
        DIRECTORY_WRITER.writeUniversityFile(JSON.toJson(planCourse));
    }
    public static Map<Integer, List<Course>> getStudyPlanGroup() {
        return STUDY_PLAN_GROUP;
    }

}
