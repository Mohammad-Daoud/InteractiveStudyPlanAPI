package com.university.studyplanapi.controllers;

import com.university.studyplanapi.ResponseHandler.ResponseStatus;
import com.university.studyplanapi.doi.users.Administrator;
import com.university.studyplanapi.doi.users.Instructor;
import com.university.studyplanapi.doi.users.Student;
import com.university.studyplanapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService service;
    @Autowired
    private ResponseStatus<Object> status;

    @PostMapping("/addStudent")
    public ResponseEntity<Object> addStudent(@RequestBody Student student) {
        Student tempStudent = service.addStudent(student.getStudentID(),
                student.getFname(),
                student.getLname(),
                student.getUsername(),
                student.getPassword(),
                student.getSchoolName(),
                student.getDepName(),
                student.getPlanYear());
        return status.getResponseStatus(tempStudent, "/{name}");
    }

    @PostMapping("/addInstructor")
    public ResponseEntity<Object> addInstructor(@RequestBody Instructor instructor) {
        Instructor tempIns = service.addInstructor(instructor.getInstructorID(),
                instructor.getFname(),
                instructor.getLname(),
                instructor.getUsername(),
                instructor.getPassword(),
                instructor.getSchoolName(),
                instructor.getDepName());
        return status.getResponseStatus(tempIns, "/{name}");
    }

    @PostMapping("/addAdmin")
    public ResponseEntity<Object> addInstructor(@RequestBody Administrator administrator) {
        Administrator tempAdmin = service.addAdmin(administrator.getFname(),
                administrator.getLname(),
                administrator.getUsername(),
                administrator.getPassword());
        return status.getResponseStatus(tempAdmin, "/{name}");
    }
}
