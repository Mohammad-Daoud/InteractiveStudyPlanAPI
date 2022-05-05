package com.university.studyplanapi.controllers;


import com.university.studyplanapi.doi.users.Administrator;
import com.university.studyplanapi.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private LoginService service ;

    @GetMapping("/login")
    public Object getUserInfo(@RequestParam String username,
                                     @RequestParam String password){
        return service.getCredential(username, password);
    }


}
