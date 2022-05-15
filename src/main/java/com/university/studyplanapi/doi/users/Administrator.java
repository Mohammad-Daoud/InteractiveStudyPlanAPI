package com.university.studyplanapi.doi.users;


public class Administrator {
    private String fname;
    private String lname;
    private String username;
    private String password;
    private UserType userType;

    public Administrator() {
    }

    private Administrator(AdministratorBuilder builder) {
        this.fname = builder.fname;
        this.lname = builder.lname;
        this.username = builder.username;
        this.password = builder.password;
        this.userType = builder.userType;
    }

    public static class AdministratorBuilder {
        private String fname;
        private String lname;
        private String username;
        private String password;
        private UserType userType;

        public AdministratorBuilder firstName(String firstName) {
            this.fname = firstName;
            return this;
        }

        public AdministratorBuilder lastName(String lastName) {
            this.lname = lastName;
            return this;
        }

        public AdministratorBuilder username(String username) {
            this.username = username;
            return this;
        }

        public AdministratorBuilder password(String password) {
            this.password = password;
            return this;
        }

        public AdministratorBuilder userType(UserType userType) {
            this.userType = userType;
            return this;
        }

        public Administrator build() {
            return new Administrator(this);
        }
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                '}';
    }
}
