package com.university.studyplanapi.services;


import com.university.studyplanapi.exception.NotFoundException;
import com.university.studyplanapi.model.users.User;
import com.university.studyplanapi.model.users.UserType;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.university.studyplanapi.config.DatabaseConfig.getConnection;

@Service
public class LoginService {
    private String userType;

    public User getCredential(String username, String password) {
        if (isAuth(username, password)) {
            return new User.UserBuilder()
                    .username(username)
                    .password(password)
                    .userType(UserType.valueOf(userType))
                    .build();
        }
        throw new NotFoundException("USER NOT FOUND !!");
    }

    private boolean isAuth(String username, String password) {
        if (getCredentialHelper(username, password, "Administrator"))
            return true;
        else if (getCredentialHelper(username, password, "Instructor"))
            return true;
        else return getCredentialHelper(username, password, "Student");
    }

    private boolean getCredentialHelper(String username, String password, String tableName) {
        userType = "";
        boolean status = false;
        try (Connection conn = getConnection()) {
            String sql = "SELECT 1,userType FROM " + tableName + " WHERE username = ? and password = ?";
            PreparedStatement pStmt = conn.prepareCall(sql);
            pStmt.setString(1, username);
            pStmt.setString(2, password);
            ResultSet rs = pStmt.executeQuery();
            status = rs.next();
            userType = rs.getObject("userType", String.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }


}
