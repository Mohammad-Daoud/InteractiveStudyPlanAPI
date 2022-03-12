package com.university.studyplanapi.studyTest;

import com.university.studyplanapi.services.StudyPlanService;
import org.junit.Test;


public class planTest {

    private StudyPlanService service = new StudyPlanService();

    @Test
    public void getPlanTest(){
        System.out.println(service.getStudyPlan(217));
    }
}
