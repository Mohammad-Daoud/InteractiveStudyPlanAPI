package com.university.studyplanapi.services;

import com.university.studyplanapi.exception.NotFoundException;
import com.university.studyplanapi.models.Category;
import com.university.studyplanapi.models.Course;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
public class StudyPlanService {
    private static Map<Integer, List<Course>> studyPlan = new HashMap<>();
    private static List<Course> courseGroup = new ArrayList<>();

    static {
        courseGroup.add(new Course.CourseBuilder()
                .category(Category.Obligatory_Specialization_Requirements)
                .courseID(301131)
                .courseName("PRINCIPLES OF STATISTICS")
                .creditHours(3)
                .prerequisite(null)
                .build());
        courseGroup.add(new Course.CourseBuilder()
                .category(Category.Obligatory_Specialization_Requirements)
                .courseID(302108)
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


    public List<Course> loadByCSV(String csvFilePath){

        List<Course> coursers = new ArrayList<>();
        try (FileReader fileReader = new FileReader(csvFilePath);
             BufferedReader bufferedReader= new BufferedReader(fileReader)) {
            loadPlans(coursers, bufferedReader);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return coursers;
    }

    private void loadPlans(List<Course> courses, BufferedReader bufferedReader) throws IOException {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            Course course = new Course.CourseBuilder()
                    .category(Category.valueOf(data[0]))
                    .courseID(Integer.parseInt(data[1]))
                    .courseName(data[2])
                    .creditHours(Integer.parseInt(data[3]))
                    .prerequisite(prerequisiteLoadHelper(data))
                    .build();

            courses.add(course);
        }
    }

    private List<String> prerequisiteLoadHelper(String[] data){
        List<String> prerequisiteGroup = new ArrayList<>();
        int iterator = 4;
        while(true){
            try{
                prerequisiteGroup.add(data[iterator]);
                iterator++;
            }catch (IndexOutOfBoundsException e){
                break;
            }
        }
        return prerequisiteGroup;
    }
}
