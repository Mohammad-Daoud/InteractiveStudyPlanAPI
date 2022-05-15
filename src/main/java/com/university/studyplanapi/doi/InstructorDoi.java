package com.university.studyplanapi.doi;

import com.university.studyplanapi.doi.users.Instructor;
import com.university.studyplanapi.doi.users.UserType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.university.studyplanapi.config.DatabaseConfig.getConnection;

public class InstructorDoi implements UsersMethods<Instructor> {
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

    @Override
    public void add(Instructor instructor) {
        try (Connection conn = getConnection()) {
            String sql = "insert into Instructor(instructorID, fname, lname, username, password, schoolName, depName) " +
                    " values(?,?,?,?,?,?,?)";
            PreparedStatement pStmt = conn.prepareCall(sql);
            pStmt.setLong(1, instructor.getInstructorID());
            pStmt.setString(3, instructor.getLname());
            pStmt.setString(2, instructor.getFname());
            pStmt.setString(4, instructor.getUsername());
            pStmt.setString(5, instructor.getPassword());
            pStmt.setString(6, instructor.getSchoolName());
            pStmt.setString(7, instructor.getDepName());

            ResultSet rs = pStmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
