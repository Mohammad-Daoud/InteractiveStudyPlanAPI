
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
DROP SCHEMA IF EXISTS `university`;
CREATE SCHEMA `university`;
USE `university`;

drop table if exists Administrator;
CREATE TABLE Administrator (
    fname VARCHAR(100),
    lname VARCHAR(100),
    username VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (username)
); 

insert into Administrator values('Mohammad', 'Daoud','mdaoud','mdaoud');
insert into Administrator values('Husam', 'Jbr','hjbr','hjbr');
insert into Administrator values('Hamzah', 'Amerah','hamerah','hamerah');

drop table if exists Student;
CREATE TABLE Student (
    studentID INT(10) NOT NULL,
    fname VARCHAR(100) NOT NULL,
    lname VARCHAR(100) NOT NULL,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    schoolName VARCHAR(100) NOT NULL UNIQUE,
    depName VARCHAR(100) NOT NULL UNIQUE,
    planYear INT(5) NOT NULL,
    PRIMARY KEY (studentID)
);
insert into Student values ('0173632','Mohammad', 'Daoud','mhm0173632','mhm0173632','kasit','cs', 2017);

drop table if exists Instructor;
CREATE TABLE Instructor (
    instructorID INT(10) NOT NULL,
    fname VARCHAR(100) NOT NULL,
    lname VARCHAR(100) NOT NULL,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    schoolName VARCHAR(100) NOT NULL UNIQUE,
    depName VARCHAR(100) NOT NULL UNIQUE,
    PRIMARY KEY (instructorID)
);
insert into Instructor values ('0123456','Heba', 'Saadeh','hib0123456','hib0123456','kasit','cs');

drop table if exists School;
CREATE TABLE School (
    schoolName VARCHAR(100) NOT NULL UNIQUE,
    schoolCode INT(100) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (schoolCode),
    FOREIGN KEY (schoolName)
        REFERENCES Instructor (schoolName),
    FOREIGN KEY (schoolName)
        REFERENCES Student (schoolName)
);
insert into School values ('kasit','1');

drop table if exists Department;
CREATE TABLE Department (
    depName VARCHAR(100) NOT NULL,
    depCode INT(100) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (depCode),
    CONSTRAINT depName FOREIGN KEY (depName)
        REFERENCES Instructor (depName),
    FOREIGN KEY (depName)
        REFERENCES Student (depName)
);
insert into Department values ('cs','1');

drop table if exists Advisor;
CREATE TABLE Advisor (
    studentID INT(10) NOT NULL,
    instructorID INT(10) NOT NULL,
    CONSTRAINT studentID FOREIGN KEY (studentID)
        REFERENCES Student (studentID),
    CONSTRAINT instructorID FOREIGN KEY (instructorID)
        REFERENCES Instructor (instructorID)
);

drop table if exists PlanPath;
CREATE TABLE PlanPath (
    namespace VARCHAR(48) NOT NULL,
    PRIMARY KEY (namespace)
);

insert into PlanPath values ('kasit.cs.2017');