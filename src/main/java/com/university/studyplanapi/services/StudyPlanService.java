package com.university.studyplanapi.services;

import com.university.studyplanapi.exception.NotFoundException;
import com.university.studyplanapi.models.Category;
import com.university.studyplanapi.models.Course;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudyPlanService {
    private static Map<Integer, List<Course>> studyPlan = new HashMap<>();
    private static List<Course> courseGroup = new ArrayList<>();

    static {
        courseGroup.add(new Course.CourseBuilder()
                .category(Category.Obligatory_Specialization_Requirements)
                .courseID("0301131")
                .courseName("PRINCIPLES OF STATISTICS")
                .creditHours(3)
                .prerequisite(null)
                .build());
        courseGroup.add(new Course.CourseBuilder()
                .category(Category.Obligatory_Specialization_Requirements)
                .courseID("0302108")
                .courseName("PHYSICS FOR COMPUTER SCIENCE")
                .creditHours(3)
                .prerequisite(null)
                .build());

        studyPlan.put(2017, courseGroup);
    }

    public List<Course> getStudyPlan(int year) {
        List<Course> tempPlanGroup = studyPlan.get(year);
        if (tempPlanGroup == null)
            throw new NotFoundException(year + " plan NOT FOUND");
        else
            return tempPlanGroup;
    }
}
