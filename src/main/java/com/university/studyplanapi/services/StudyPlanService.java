package com.university.studyplanapi.services;

import com.university.studyplanapi.exception.NotFoundException;
import com.university.studyplanapi.models.Course;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudyPlanService implements PlanOperation<Integer>{
    private static final Map<Integer, List<Course>> STUDY_PLAN_GROUP = new HashMap<>();

    @Override
    public List<Course> getStudyPlan(Integer year) {
        List<Course> tempPlanGroup = STUDY_PLAN_GROUP.get(year);
        if (tempPlanGroup == null)
            throw new NotFoundException(year + " plan NOT FOUND");
        else
            return tempPlanGroup;
    }

    public static Map<Integer, List<Course>> getStudyPlanGroup() {
        return STUDY_PLAN_GROUP;
    }
}
