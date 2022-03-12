package com.university.studyplanapi.models;

import java.util.List;

public class Course {
   private String courseID;
   private String courseName;
   private int creditHours;
   private List<Integer> prerequisite;

   private Course(CourseBuilder builder){
       this.courseID = builder.courseID;
       this.courseName = builder.courseName;
       this.creditHours = builder.creditHours;
       this.prerequisite = builder.prerequisite;
   }

   public static class CourseBuilder{
       private String courseID;
       private String courseName;
       private int creditHours;
       private List<Integer> prerequisite;


       public CourseBuilder courseID(String id){
           this.courseID= id;
           return this;
       }
       public CourseBuilder courseName(String courseName){
           this.courseName= courseName;
           return this;
       }
       public CourseBuilder creditHours(int creditHours){
           this.creditHours= creditHours;
           return this;
       }
       public CourseBuilder prerequisite(List<Integer> prerequisite){
           this.prerequisite= prerequisite;
           return this;
       }

       public Course build(){
           return new Course(this);
       }

   }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public List<Integer> getPrerequisite() {
        return prerequisite;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public void setPrerequisite(List<Integer> prerequisite) {
        this.prerequisite = prerequisite;
    }

    @Override
    public String toString() {
        return "{" +
                "courseID:" + courseID +
                ", courseName:'" + courseName +
                ", creditHours:" + creditHours +
                ", prerequisite:" + prerequisite +
                '}';
    }
}
