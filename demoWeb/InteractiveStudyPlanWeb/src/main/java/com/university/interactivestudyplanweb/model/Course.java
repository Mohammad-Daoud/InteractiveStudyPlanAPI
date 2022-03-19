package com.university.interactivestudyplanweb.model;

import java.util.List;

public class Course {
    private Category category;
    private long courseID;
    private String courseName;
    private int creditHours;
    private int preCount;
    private List<String> prerequisites;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public long getCourseID() {
        return courseID;
    }

    public void setCourseID(long courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public int getPreCount() {
        return preCount;
    }

    public void setPreCount(int preCount) {
        this.preCount = preCount;
    }

    public List<String> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<String> prerequisites) {
        this.prerequisites = prerequisites;
    }

    @Override
    public String toString() {
        return "{" +
                "category:" + category +
                ",courseID:'" + courseID + '\'' +
                ",courseName:'" + courseName + '\'' +
                ",creditHours:" + creditHours +
                ",preCount:" + preCount +
                ",prerequisites:" + prerequisites +
                '}';
    }
}
