package com.university.studyplanapi.doi.users;

public class Instructor extends Administrator {
    private long instructorID;
    private String schoolName;
    private String depName;

    public Instructor() {
    }

    private Instructor(InstructorBuilder builder) {
        this.instructorID = builder.instructorID;
        setFname(builder.fname);
        setLname(builder.lname);
        setUsername(builder.username);
        setPassword(builder.password);
        this.schoolName = builder.schoolName;
        this.depName = builder.depName;
        setUserType(builder.userType);

    }

    public static class InstructorBuilder {
        private String fname;
        private String lname;
        private String username;
        private String password;
        private UserType userType;
        private long instructorID;
        private String schoolName;
        private String depName;

        public InstructorBuilder instructorID(long instructorID) {
            this.instructorID = instructorID;
            return this;
        }


        public InstructorBuilder firstName(String firstName) {
            this.fname = firstName;
            return this;
        }

        public InstructorBuilder lastName(String lastName) {
            this.lname = lastName;
            return this;
        }

        public InstructorBuilder username(String username) {
            this.username = username;
            return this;
        }

        public InstructorBuilder password(String password) {
            this.password = password;
            return this;
        }


        public InstructorBuilder schoolName(String schoolName) {
            this.schoolName = schoolName;
            return this;
        }

        public InstructorBuilder depName(String depName) {
            this.depName = depName;
            return this;
        }
        public InstructorBuilder userType(UserType userType) {
            this.userType = userType;
            return this;
        }

        public Instructor build() {
            return new Instructor(this);
        }
    }

    public long getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(long instructorID) {
        this.instructorID = instructorID;
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

    @Override
    public String toString() {
        return "Instructor{" +
                "instructorID=" + instructorID +
                "fname='" + getFname() + '\'' +
                ", lname='" + getLname() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", depName='" + depName + '\'' +
                ", userType=" + getUserType() +
                '}';
    }
}
