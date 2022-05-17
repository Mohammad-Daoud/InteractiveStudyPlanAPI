package com.university.studyplanapi.studyTest;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.university.studyplanapi.controllers.LoginController;
import com.university.studyplanapi.model.plan.Plan;
import com.university.studyplanapi.services.LoginService;
import com.university.studyplanapi.services.StudyPlanService;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;

import static com.university.studyplanapi.io.DirectoryLoader.getResourceFilePath;

public class LoginTest {
    @Test
    public void test(){
        LoginController service = new LoginController();
//        service.getUserInfo("mdaoud","mdaoud");
        StudyPlanService studyPlanService = new StudyPlanService();
        Plan plan = new Plan("kasit","cs",2017);
        studyPlanService.getStudyPlan(plan);
    }
}
