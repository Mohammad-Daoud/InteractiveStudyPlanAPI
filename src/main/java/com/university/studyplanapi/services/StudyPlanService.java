package com.university.studyplanapi.services;

import com.university.studyplanapi.models.Course;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudyPlanService {
    private static Map<Integer,List<Course>> studyPlan = new HashMap<>();
    private static List<Course> courseGroup = new ArrayList<>();
    static {
        courseGroup.add(new Course.CourseBuilder()
                                .courseID("0301131")
                                .courseName("PRINCIPLES OF STATISTICS")
                                .creditHours(3)
                                .prerequisite(null)
                                .build());
        courseGroup.add( new Course.CourseBuilder()
                .courseID("0302108")
                .courseName("PHYSICS FOR COMPUTER SCIENCE")
                .creditHours(3)
                .prerequisite(null)
                .build());

        studyPlan.put(2017, courseGroup);
    }

    public List<Course> getStudyPlan(int year){
        return studyPlan.get(year);
    }
}
