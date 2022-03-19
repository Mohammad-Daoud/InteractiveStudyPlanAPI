package com.university.interactivestudyplanweb.model;

public class Plan {
    private String schoolName;
    private String departmentName;
    private int year;

    public Plan(){}

    public Plan(String schoolName, String departmentName, int year) {
        this.schoolName = schoolName;
        this.departmentName = departmentName;
        this.year = year;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return schoolName +
                '/' +
                departmentName +
                '/' +
                year ;
    }
}
