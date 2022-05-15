package com.university.studyplanapi.controllers;

import com.university.studyplanapi.doi.users.Administrator;
import com.university.studyplanapi.doi.users.Instructor;
import com.university.studyplanapi.doi.users.Student;
import com.university.studyplanapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student) {
        service.addStudent(student.getStudentID(),
                student.getFname(),
                student.getLname(),
                student.getUsername(),
                student.getPassword(),
                student.getSchoolName(),
                student.getDepName(),
                student.getPlanYear());
    }

    @PostMapping("/addInstructor")
    public void addInstructor(@RequestBody Instructor instructor) {
        service.addInstructor(instructor.getInstructorID(),
                instructor.getFname(),
                instructor.getLname(),
                instructor.getUsername(),
                instructor.getPassword(),
                instructor.getSchoolName(),
                instructor.getDepName());
    }

    @PostMapping("/addAdmin")
    public void addInstructor(@RequestBody Administrator administrator) {
        service.addAdmin(administrator.getFname(),
                administrator.getLname(),
                administrator.getUsername(),
                administrator.getPassword());
    }
}
