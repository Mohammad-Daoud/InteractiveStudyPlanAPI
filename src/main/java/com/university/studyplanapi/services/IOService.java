package com.university.studyplanapi.services;

import com.university.studyplanapi.exception.NotNumberException;
import com.university.studyplanapi.model.plan.Category;
import com.university.studyplanapi.model.plan.Course;
import com.university.studyplanapi.model.plan.Plan;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.university.studyplanapi.io.DirectoryLoader.getResourceFilePath;


@Service
public class IOService implements PlanOperation<Plan> {
    private static final String CSV_EXTENSION = ".csv";
    @Override
    public List<Course> getStudyPlan(Plan planCriteria) {
        String csvFilePath = planCriteria.toString()+CSV_EXTENSION;
        List<Course> coursers = new ArrayList<>();
        int planYear = fileChecker(csvFilePath);
        try (FileReader fileReader = new FileReader(getResourceFilePath() + csvFilePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            loadPlans(coursers, bufferedReader);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        StudyPlanService.getStudyPlanGroup().put(planYear, coursers);
        return coursers;
    }

    private Integer fileChecker(String csvFilePath) {
        File fileToCheck = new File(csvFilePath);
        try {
            String tempFilename = fileToCheck.getName();
            return Integer.parseInt(FilenameUtils.removeExtension(tempFilename));
        } catch (NumberFormatException e) {
            throw new NotNumberException("THE FILE NAME SHOULD BE THE YEAR OF CREATION !");
        }
    }

    private void loadPlans(List<Course> courses, BufferedReader bufferedReader) throws IOException {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            Course course = new Course.CourseBuilder()
                    .category(Category.valueOf(data[0]))
                    .courseID(Long.parseLong(data[1]))
                    .courseName(data[2])
                    .creditHours(Integer.parseInt(data[3]))
                    .preCount(Integer.parseInt(data[4]))
                    .prerequisites(prerequisiteLoadHelper(data))
                    .build();

            courses.add(course);
        }
    }

    private List<Long> prerequisiteLoadHelper(String[] data) {
        List<Long> prerequisiteGroup = new ArrayList<>();
        int iterator = 5;
        while (true) {
            try {
                prerequisiteGroup.add(Long.valueOf(data[iterator]));
                iterator++;
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        return prerequisiteGroup;
    }
}
