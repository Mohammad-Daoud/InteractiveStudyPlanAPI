package com.university.studyplanapi.studyTest;

import com.university.studyplanapi.controllers.LoginController;
import com.university.studyplanapi.services.LoginService;
import org.junit.Test;

public class LoginTest {
    @Test
    public void test(){
        LoginController service = new LoginController();
        service.getUserInfo("mdaoud","mdaoud");
    }
}
