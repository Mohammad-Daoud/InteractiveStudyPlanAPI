package com.university.studyplanapi.services;

import com.university.studyplanapi.model.Course;

import java.util.List;

public interface PlanOperation<T> {
    List<Course> getStudyPlan(T year);
}
