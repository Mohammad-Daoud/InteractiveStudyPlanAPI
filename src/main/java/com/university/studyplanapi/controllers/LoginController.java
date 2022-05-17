package com.university.studyplanapi.controllers;


import com.university.studyplanapi.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
