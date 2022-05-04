package com.university.studyplanapi.controllers;


import com.university.studyplanapi.model.users.User;
import com.university.studyplanapi.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    LoginService service ;

    @GetMapping("/read/login")
    public User getUserInfo(@RequestParam String username,
                            @RequestParam String password){
        return service.getCredential(username, password);
    }


}
