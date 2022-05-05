package com.university.studyplanapi.doi.users;

public class Student extends Administrator {
    private long studentID;
    private String schoolName;
    private String depName;
    private int planYear;
    public Student() {
    }

    private Student(StudentBuilder builder) {
        this.studentID = builder.studentID;
        setFname(builder.fname);
        setLname(builder.lname);
        setUsername(builder.username);
        setPassword(builder.password);
        this.schoolName = builder.schoolName;
        this.depName = builder.depName;
        this.planYear = builder.planYear;
        setUserType(builder.userType);


    }

    public static class StudentBuilder {
        private String fname;
        private String lname;
        private String username;
        private String password;
        private UserType userType;
        private long studentID;
        private String schoolName;
        private String depName;
        private int planYear;

        public StudentBuilder studentID(long studentID) {
            this.studentID = studentID;
            return this;
        }


        public StudentBuilder firstName(String firstName) {
            this.fname = firstName;
            return this;
        }

        public StudentBuilder lastName(String lastName) {
            this.lname = lastName;
            return this;
        }

        public StudentBuilder username(String username) {
            this.username = username;
            return this;
        }

        public StudentBuilder password(String password) {
            this.password = password;
            return this;
        }

        public StudentBuilder userType(UserType userType) {
            this.userType = userType;
            return this;
        }

        public StudentBuilder schoolName(String schoolName) {
            this.schoolName = schoolName;
            return this;
        }

        public StudentBuilder depName(String depName) {
            this.depName = depName;
            return this;
        }

        public StudentBuilder planYear (int planYear){
            this.planYear = planYear;
            return this;
        }
        public Student build() {
            return new Student(this);
        }
    }

    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public int getPlanYear() {
        return planYear;
    }

    public void setPlanYear(int planYear) {
        this.planYear = planYear;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "studentID=" + studentID +
                "fname='" + getFname() + '\'' +
                ", lname='" + getLname() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", depName='" + depName + '\'' +
                ", userType=" + getUserType() +
                ", planYear=" + planYear+
                '}';
    }


}
