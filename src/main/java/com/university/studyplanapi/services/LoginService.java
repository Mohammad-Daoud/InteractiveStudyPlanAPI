package com.university.studyplanapi.services;


import com.university.studyplanapi.doi.AdministratorDoi;
import com.university.studyplanapi.doi.InstructorDoi;
import com.university.studyplanapi.doi.StudentDoi;
import com.university.studyplanapi.doi.users.Administrator;
import com.university.studyplanapi.doi.users.Instructor;
import com.university.studyplanapi.doi.users.Student;
import com.university.studyplanapi.exception.UnauthorizedException;
import com.university.studyplanapi.exception.NotFoundException;
import com.university.studyplanapi.doi.users.UserType;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.university.studyplanapi.config.DatabaseConfig.getConnection;

@Service
public class LoginService  {
    private UserType userType;

    public Object getCredential(String username, String password) {
        if (isAuth(username, password)) {
            switch (userType) {
                case ADMIN:
                    return getAdmin(username, password);
                case INSTRUCTOR:
                    return getInstructor(username, password);
                case STUDENT:
                    return getStudent(username, password);
                default:
                    throw new NotFoundException("User not found");
            }
        }
        throw new UnauthorizedException("Invalid Credential !!");
    }



    private boolean isAuth(String username, String password) {
        if (isAuthHelper(username, password, "Administrator")) {
            userType = UserType.ADMIN;
            return true;
        } else if (isAuthHelper(username, password, "Instructor")) {
            userType = UserType.INSTRUCTOR;
            return true;
        } else if (isAuthHelper(username, password, "Student")) {
            userType = UserType.STUDENT;
            return true;
        } else return false;
    }

    private boolean isAuthHelper(String username, String password, String tableName) {
        boolean status = false;
        try (Connection conn = getConnection()) {
            String sql = "SELECT 1 FROM " + tableName + " WHERE username = ? and password = ?";
            PreparedStatement pStmt = conn.prepareCall(sql);
            pStmt.setString(1, username);
            pStmt.setString(2, password);
            ResultSet rs = pStmt.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    private Administrator getAdmin(String username, String password){
        AdministratorDoi administrator = new AdministratorDoi();
        return administrator.geInfo(username,password,"Administrator");
    }
    private Instructor getInstructor(String username, String password){
        InstructorDoi instructor = new InstructorDoi();
        return instructor.geInfo(username,password,"Instructor");
    }
    private Student getStudent(String username, String password) {
        StudentDoi student = new StudentDoi();
        return student.geInfo(username, password , "Student");
    }



}
