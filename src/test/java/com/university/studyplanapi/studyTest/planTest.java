package com.university.studyplanapi.studyTest;


import com.university.studyplanapi.services.StudyPlanService;
import org.junit.Test;


public class planTest {

    private StudyPlanService service = new StudyPlanService();

    @Test
    public void getPlanTest(){
        System.out.println(service.getStudyPlan(2017));
    }

    @Test
    public void loadPlanFromCSV(){
        System.out.println(service
                .loadByCSV("C:\\Users\\mdss4\\Documents\\GraduationProject\\StudyPlanAPI\\src\\main\\resources\\kasit\\cs\\2017.csv"));
    }
}
