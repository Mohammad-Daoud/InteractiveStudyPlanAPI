package com.university.studyplanapi.doi;

import com.university.studyplanapi.doi.users.Administrator;
import com.university.studyplanapi.doi.users.Instructor;
import com.university.studyplanapi.doi.users.UserType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.university.studyplanapi.config.DatabaseConfig.getConnection;

public class InstructorDoi implements GetUserInfo<Instructor>{
    @Override
    public Instructor geInfo(String username, String password, String tableName) {
        Instructor instructor = new Instructor();
        boolean status;
        try (Connection conn = getConnection()) {
            String sql = "SELECT * FROM " + tableName + " WHERE username = ? and password = ?";
            PreparedStatement pStmt = conn.prepareCall(sql);
            pStmt.setString(1, username);
            pStmt.setString(2, password);
            ResultSet rs = pStmt.executeQuery();
            status = rs.next();
            if (status) {
                instructor = new Instructor.InstructorBuilder()
                        .instructorID(Long.parseLong(rs.getString("instructorID")))
                        .firstName(rs.getString("fname"))
                        .lastName(rs.getString("lname"))
                        .username(rs.getString("username"))
                        .password(rs.getString("password"))
                        .schoolName(rs.getString("schoolName"))
                        .depName(rs.getString("depName"))
                        .userType((UserType.valueOf(rs.getString("userType"))))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instructor;
    }
}
