package com.university.studyplanapi.services;


import com.university.studyplanapi.doi.AdministratorDoi;
import com.university.studyplanapi.doi.InstructorDoi;
import com.university.studyplanapi.doi.StudentDoi;
import com.university.studyplanapi.doi.users.Administrator;
import com.university.studyplanapi.doi.users.Instructor;
import com.university.studyplanapi.doi.users.Student;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public Student addStudent(long userID,
                              String fname,
                              String lname,
                              String username,
                              String password,
                              String schoolName,
                              String depName,
                              int planYear) {
        Student student = new Student.StudentBuilder()
                .studentID(userID)
                .firstName(fname)
                .lastName(lname)
                .username(username)
                .password(password)
                .schoolName(schoolName)
                .depName(depName)
                .planYear(planYear)
                .build();
        StudentDoi studentDoi = new StudentDoi();
        studentDoi.add(student);
        return student;
    }

    public Instructor addInstructor(long userID,
                                    String fname,
                                    String lname,
                                    String username,
                                    String password,
                                    String schoolName,
                                    String depName) {
        Instructor instructor = new Instructor.InstructorBuilder()
                .instructorID(userID)
                .firstName(fname)
                .lastName(lname)
                .username(username)
                .password(password)
                .schoolName(schoolName)
                .depName(depName)
                .build();
        InstructorDoi instructorDoi = new InstructorDoi();
        instructorDoi.add(instructor);
        return instructor;
    }

    public Administrator addAdmin(String fname,
                                  String lname,
                                  String username,
                                  String password) {
        Administrator administrator = new Administrator.AdministratorBuilder()
                .firstName(fname)
                .lastName(lname)
                .username(username)
                .password(password)
                .build();
        AdministratorDoi administratorDoi = new AdministratorDoi();
        administratorDoi.add(administrator);
        return administrator;
    }
}
