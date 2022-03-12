package com.university.studyplanapi.models;

import java.util.List;

public class Course {
    private Category category;
    private int courseID;
    private String courseName;
    private int creditHours;
    private List<String> prerequisite;

    private Course(CourseBuilder builder) {
        this.category = builder.category;
        this.courseID = builder.courseID;
        this.courseName = builder.courseName;
        this.creditHours = builder.creditHours;
        this.prerequisite = builder.prerequisite;
    }

    public static class CourseBuilder {
        private Category category;
        private int courseID;
        private String courseName;
        private int creditHours;
        private List<String> prerequisite;

        public CourseBuilder category(Category category) {
            this.category = category;
            return this;
        }

        public CourseBuilder courseID(int id) {
            this.courseID = id;
            return this;
        }

        public CourseBuilder courseName(String courseName) {
            this.courseName = courseName;
            return this;
        }

        public CourseBuilder creditHours(int creditHours) {
            this.creditHours = creditHours;
            return this;
        }

        public CourseBuilder prerequisite(List<String> prerequisite) {
            this.prerequisite = prerequisite;
            return this;
        }

        public Course build() {
            return new Course(this);
        }

    }

    public  int getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public List<String> getPrerequisite() {
        return prerequisite;
    }

    public Category getCategory() {
        return category;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public void setPrerequisite(List<String> prerequisite) {
        this.prerequisite = prerequisite;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "{" +
                "category:" + category +
                ", courseID:'" + courseID + '\'' +
                ", courseName:'" + courseName + '\'' +
                ", creditHours:" + creditHours +
                ", prerequisite:" + prerequisite +
                '}';
    }
}
