package com.university.studyplanapi.studyTest;


import com.university.studyplanapi.exception.NotNumberException;
import com.university.studyplanapi.services.IOService;
import com.university.studyplanapi.services.StudyPlanService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


public class planTest {

    private StudyPlanService normalService = new StudyPlanService();
    private IOService ioService = new IOService();
    private String correctPath = "C:\\Users\\mdss4\\Documents\\GraduationProject\\StudyPlanAPI\\src\\main\\resources\\kasit\\cs\\2017.csv";
    private String inCorrectNamePath = "C:\\Users\\mdss4\\Documents\\GraduationProject\\StudyPlanAPI\\src\\main\\resources\\kasit\\cs\\mohammad.csv";
    private String planTest = "[{category:Elective_Specialization_Requirements,courseID:'1901443',courseName:'GRAPH THEORY'," +
            "creditHours:3,preCount:1,prerequisites:[1901341]}, {category:Elective_Specialization_Requirements,courseID:'1901446'" +
            ",courseName:'COMPUTER SYSTEMS PERFORMANCE',creditHours:3,preCount:2,prerequisites:[1901322, 301131]}," +
            " {category:Elective_Specialization_Requirements,courseID:'1901452',courseName:'PATTERN RECOGNITION',creditHours:3,preCount:1,prerequisites:[1901359]}, {category:Elective_Specialization_Requirements,courseID:'1901457',courseName:'INFORMATION VISUALIZATION',creditHours:3,preCount:1,prerequisites:[1901359]}, {category:Elective_Specialization_Requirements,courseID:'1901459',courseName:'CERTIFIED SOFTWARE',creditHours:3,preCount:1,prerequisites:[1901233]}, {category:Elective_Specialization_Requirements,courseID:'1901461',courseName:'COMPUTER NETWORKS - 2',creditHours:3,preCount:1,prerequisites:[1901362]}, {category:Elective_Specialization_Requirements,courseID:'1901464',courseName:'PARALLEL PROCESSING',creditHours:3,preCount:1,prerequisites:[1901322]}, {category:Elective_Specialization_Requirements,courseID:'1901467',courseName:'MULTIMEDIA NETWORKING',creditHours:3,preCount:1,prerequisites:[1901362]}, {category:Elective_Specialization_Requirements,courseID:'1901469',courseName:'MOBILE WIRELESS NETWORKS',creditHours:3,preCount:1,prerequisites:[1901362]}, {category:Elective_Specialization_Requirements,courseID:'1901475',courseName:'OPERATING SYSTEMS PROGRAMMING',creditHours:3,preCount:2,prerequisites:[1901473, 1901237]}, {category:Elective_Specialization_Requirements,courseID:'1901494',courseName:'SPECIAL TOPICS',creditHours:3,preCount:1,prerequisites:[1901233]}, {category:Elective_Specialization_Requirements,courseID:'1902353',courseName:'HUMAN COMPUTER INTERACTION',creditHours:3,preCount:1,prerequisites:[1901359]}, {category:Elective_Specialization_Requirements,courseID:'1902454',courseName:'DIGITAL IMAGE PROCESSING',creditHours:3,preCount:1,prerequisites:[1901359]}, {category:Elective_Specialization_Requirements,courseID:'1902474',courseName:'SYSTEMS ANALYSIS AND DESIGN',creditHours:3,preCount:1,prerequisites:[1902223]}, {category:Elective_Specialization_Requirements,courseID:'1904341',courseName:'OPERATIONS RESEARCH',creditHours:3,preCount:1,prerequisites:[301131, 1904255]}, {category:Elective_Specialization_Requirements,courseID:'1904353',courseName:'WEB APPLICATION DEVELOPMENT - 2',creditHours:3,preCount:1,prerequisites:[1904121]}]";

    @Test
    public void loadPlanFromCSV(){
        assertThrows(NotNumberException.class, ()-> ioService.getStudyPlan(inCorrectNamePath));
        System.out.println(ioService.getStudyPlan(correctPath));
    }
    @Test
    public void getPlanTest(){
        System.out.println(normalService.getStudyPlan(2017));
    }


}
