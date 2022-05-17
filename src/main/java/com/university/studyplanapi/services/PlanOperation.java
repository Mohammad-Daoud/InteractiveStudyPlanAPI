package com.university.studyplanapi.services;

import com.university.studyplanapi.model.plan.Course;

import java.util.List;

public interface PlanOperation<T> {
    List<Course> getUploadedStudyPlan(T planCriteria);
}
