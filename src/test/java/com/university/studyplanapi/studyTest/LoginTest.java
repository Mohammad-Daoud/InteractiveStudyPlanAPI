package com.university.studyplanapi.studyTest;

import com.university.studyplanapi.services.LoginService;
import org.junit.Test;

public class LoginTest {
    @Test
    public void test(){
        LoginService service = new LoginService();
        System.out.println(service.getCredential("mdaoud","mdaoud"));
        System.out.println(service.getCredential("mhm0173632","mhm0173632"));
        System.out.println(service.getCredential("hib0123456","hib0123456"));
    }
}
