package com.university.studyplanapi.model;

import java.util.List;

public class Course {
    private Category category;
    private long courseID;
    private String courseName;
    private int creditHours;
    private int preCount;
    private List<Integer> prerequisites;

    private Course(CourseBuilder builder) {
        this.category = builder.category;
        this.courseID = builder.courseID;
        this.courseName = builder.courseName;
        this.creditHours = builder.creditHours;
        this.preCount = builder.preCount;
        this.prerequisites = builder.prerequisites;
    }

    public static class CourseBuilder {
        private Category category;
        private long courseID;
        private String courseName;
        private int creditHours;
        private int preCount;
        private List<Integer> prerequisites;

        public CourseBuilder category(Category category) {
            this.category = category;
            return this;
        }

        public CourseBuilder courseID(long id) {
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

        public CourseBuilder preCount(int preCount){
            this.preCount = preCount;
            return this;
        }
        public CourseBuilder prerequisites(List<Integer> prerequisite) {
            this.prerequisites = prerequisite;
            return this;
        }

        public Course build() {
            return new Course(this);
        }

    }

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

    public List<Integer> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<Integer> prerequisites) {
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
