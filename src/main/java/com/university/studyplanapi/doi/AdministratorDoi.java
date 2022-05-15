package com.university.studyplanapi.doi;

import com.university.studyplanapi.doi.users.Administrator;
import com.university.studyplanapi.doi.users.UserType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.university.studyplanapi.config.DatabaseConfig.getConnection;

public class AdministratorDoi implements UsersMethods<Administrator> {
    @Override
    public Administrator geInfo(String username, String password, String tableName) {
        Administrator administrator = new Administrator();
        boolean status ;
        try (Connection conn = getConnection()) {
            String sql = "SELECT * FROM " + tableName + " WHERE username = ? and password = ?";
            PreparedStatement pStmt = conn.prepareCall(sql);
            pStmt.setString(1, username);
            pStmt.setString(2, password);
            ResultSet rs = pStmt.executeQuery();
            status = rs.next();
            if (status) {
                administrator = new Administrator.AdministratorBuilder()
                        .firstName(rs.getString("fname"))
                        .lastName(rs.getString("lname"))
                        .username(rs.getString("username"))
                        .password(rs.getString("password"))
                        .userType((UserType.valueOf(rs.getString("userType"))))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return administrator;
    }

    @Override
    public void add(Administrator administrator) {
        try (Connection conn = getConnection()) {
            String sql = "insert into Administrator(fname, lname, username, password)" +
                    " values(?,?,?,?)";
            PreparedStatement pStmt = conn.prepareCall(sql);
            pStmt.setString(1, administrator.getFname());
            pStmt.setString(2, administrator.getLname());
            pStmt.setString(3, administrator.getUsername());
            pStmt.setString(4, administrator.getPassword());

            ResultSet rs = pStmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
