package com.university.studyplanapi.doi;


import com.university.studyplanapi.doi.users.Student;
import com.university.studyplanapi.doi.users.UserType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.university.studyplanapi.config.DatabaseConfig.getConnection;

public class StudentDoi implements GetUserInfo<Student> {
    @Override
    public Student geInfo(String username, String password, String tableName) {
        Student student = new Student();
        boolean status ;
        try (Connection conn = getConnection()) {
            String sql = "SELECT * FROM " + tableName + " WHERE username = ? and password = ?";
            PreparedStatement pStmt = conn.prepareCall(sql);
            pStmt.setString(1, username);
            pStmt.setString(2, password);
            ResultSet rs = pStmt.executeQuery();
            status = rs.next();
            if (status) {
                student = new Student.StudentBuilder()
                        .studentID(Long.parseLong(rs.getString("studentID")))
                        .firstName(rs.getString("fname"))
                        .lastName(rs.getString("lname"))
                        .username(rs.getString("username"))
                        .password(rs.getString("password"))
                        .schoolName(rs.getString("schoolName"))
                        .depName(rs.getString("depName"))
                        .planYear(rs.getInt("planYear"))
                        .userType((UserType.valueOf(rs.getString("userType"))))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}
