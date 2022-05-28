
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
DROP SCHEMA IF EXISTS `university`;
CREATE SCHEMA `university`;
USE `university`;

drop table if exists Administrator;
CREATE TABLE Administrator (
    fname VARCHAR(100),
    lname VARCHAR(100),
    usename VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    userType VARCHAR(10) DEFAULT 'ADMIN',
    PRIMARY KEY (usename)
);

insert into Administrator(fname, lname, usename, password) values('Mohammad', 'Daoud','mdaoud','mdaoud');
insert into Administrator(fname, lname, usename, password)  values('Husam', 'Jbr','hjbr','hjbr');
insert into Administrator(fname, lname, usename, password)  values('Hamza', 'Monther','hmonther','hmonther');
drop table if exists Student;
CREATE TABLE Student (
    studentID VARCHAR(10) NOT NULL,
    fname VARCHAR(100) NOT NULL,
    lname VARCHAR(100) NOT NULL,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    schoolName VARCHAR(100) NOT NULL,
    depName VARCHAR(100) NOT NULL,
    planYear INT(5) NOT NULL,
    userType VARCHAR(10) DEFAULT 'STUDENT',
    PRIMARY KEY (username)
);
insert into Student(studentID,fname, lname, username, password, schoolName, depName, planYear) values ("0173632",'Mohammad', 'Daoud','mhm0173632','mhm0173632','kasit','cs', 2017);
insert into Student(studentID,fname, lname, username, password, schoolName, depName, planYear) values ("0189136",'Husam', 'Jbr','hsa0189136','hsa0189136','kasit','cis', 2018);
insert into Student(studentID,fname, lname, username, password, schoolName, depName, planYear) values ("0189136",'Hamza', 'Amerah','hmz0189136','hmz0189136','kasit','cs', 2018);

drop table if exists Instructor;
CREATE TABLE Instructor (
    fname VARCHAR(100) NOT NULL,
    lname VARCHAR(100) NOT NULL,
    usename VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    schoolName VARCHAR(100) NOT NULL UNIQUE,
    depName VARCHAR(100) NOT NULL UNIQUE,
    userType VARCHAR(10) DEFAULT 'INSTRUCTOR',
    PRIMARY KEY (usename)
);
insert into Instructor(fname, lname, usename, password, schoolName, depName) values ('Heba', 'Saadeh','hib0123456','hib0123456','kasit','cs');


drop table if exists Course;
CREATE TABLE Course (
    courseID INT(7) NOT NULL,
    courseName VARCHAR(25),
    PRIMARY KEY (courseID)
);


INSERT INTO Course values (3202098,"ENGLISH PLACEMENT TEST");
INSERT INTO Course values (1901442,"NETWORK PROGRAMMING");
INSERT INTO Course values (1901351,"NUMERICAL ANALYSIS");
INSERT INTO Course values (1901233,"DATA STRUCTURES-1");
INSERT INTO Course values (1901353,"MODELING AND SIMULATION");
INSERT INTO Course values (1901376,"SYSTEMS PROGRAMMING AND MANAGEMENT");
INSERT INTO Course values (1901234,"DATA STRUCTURES-2");
INSERT INTO Course values (1901341,"THEORY OF ALGORITHMS");
INSERT INTO Course values (1901464,"PARALLEL PROCESSING");
INSERT INTO Course values (1901494,"SPECIAL TOPICS");
INSERT INTO Course values (1901469,"MOBILE WIRELESS NETWORKS");
INSERT INTO Course values (1901359,"COMPUTER GRAPHICS");
INSERT INTO Course values (1901237,"PROGRAMMING METHODOLOGIES");
INSERT INTO Course values (1901461,"COMPUTER NETWORKS - 2");
INSERT INTO Course values (1901446,"COMPUTER SYSTEMS PERFORMANCE");
INSERT INTO Course values (1901101,"DISCRETE MATHEMATICS");
INSERT INTO Course values (1901457,"INFORMATION VISUALIZATION");
INSERT INTO Course values (1901466,"DISTRIBUTED SYSTEMS");
INSERT INTO Course values (1901362,"COMPUTER NETWORKS-1");
INSERT INTO Course values (3202100,"ENGLISH LANGUAGE SKILLS");
INSERT INTO Course values (300102,"ENVIRONMENTAL CULTURE");
INSERT INTO Course values (1900150,"COMMUNITY SERVICE");
INSERT INTO Course values (1901496,"PROJECT-1");
INSERT INTO Course values (1932099,"BASICS OF COMPUTING");
INSERT INTO Course values (720100,"HEALTH CULTURE");
INSERT INTO Course values (3202099,"BASICS OF ENGLISH");
INSERT INTO Course values (1901463,"COMPUTER SECURITY");
INSERT INTO Course values (1901471,"DESIGN AND IMPLEMENTATION OF PROGRAMMING LANGUAGES");
INSERT INTO Course values (1901452,"PATTERN RECOGNITION");
INSERT INTO Course values (1902223,"INTRODUCTION TO DATABASE SYSTEMS");
INSERT INTO Course values (1901459,"CERTIFIED SOFTWARE");
INSERT INTO Course values (1901204,"LOGIC DESIGN");
INSERT INTO Course values (1901467,"MULTIMEDIA NETWORKING");
INSERT INTO Course values (1901241,"THEORY OF COMPUTATION");
INSERT INTO Course values (1901475,"OPERATING SYSTEMS PROGRAMMING");
INSERT INTO Course values (1901322,"COMPUTER ORGANIZATION");
INSERT INTO Course values (1902454,"DIGITAL IMAGE PROCESSING");
INSERT INTO Course values (3201098,"ARABIC PLACEMENT TEST");
INSERT INTO Course values (1904101,"FUNDAMENTALS OF INFORMATION TECHNOLOGY");
INSERT INTO Course values (1901473,"OPERATING SYSTEMS");
INSERT INTO Course values (1902371,"INTRODUCTION TO SOFTWARE ENGINEERING");
INSERT INTO Course values (1901472,"COMPILER CONSTRUCTION");
INSERT INTO Course values (3400105,"CAMPUS LIFE AND ETHICS");
INSERT INTO Course values (3201099,"BASICS OF ARABIC");
INSERT INTO Course values (1901498,"TRAINING");
INSERT INTO Course values (400102,"ISLAMIC CULTURE");
INSERT INTO Course values (1902098,"COMPUTER SKILLS PLACEMENT TEST");
INSERT INTO Course values (3400108,"JERUSALEM");
INSERT INTO Course values (1904341,"OPERATIONS RESEARCH");
INSERT INTO Course values (3400104,"HUMAN CIVILIZATION");
INSERT INTO Course values (1901497,"PROJECT-2");
INSERT INTO Course values (1901443,"GRAPH THEORY");
INSERT INTO Course values (1902202,"DOCUMENTATION AND ETHICS");
INSERT INTO Course values (3201100,"ARABIC LANGUAGE SKILLS");
INSERT INTO Course values (1902474,"SYSTEMS ANALYSIS AND DESIGN");
INSERT INTO Course values (1901238,"PROGRAMMING IN SPECIAL LANGUAGES");
INSERT INTO Course values (1904353,"WEB APPLICATION DEVELOPMENT - 2");
INSERT INTO Course values (2200103,"FOREIGN LANGUAGE");
INSERT INTO Course values (3400103,"INTRODUCTION TO PHILOSOPHY AND CRITICAL THINKING");
INSERT INTO Course values (3400100,"NATIONAL CULTURE");
INSERT INTO Course values (3400106,"SPECIAL SUBJECT");
INSERT INTO Course values (1902342,"ARTIFICIAL INTELLIGENCE");
INSERT INTO Course values (301101,"CALCULUS I");
INSERT INTO Course values (1902353,"HUMAN COMPUTER INTERACTION");
INSERT INTO Course values (2300101,"ARAB-ISLAMIC CIVILIZATION");
INSERT INTO Course values (3400101,"LEARNING & RESEARCH SKILLS");
INSERT INTO Course values (3400107,"GREAT BOOKS");
INSERT INTO Course values (301131,"PRINCIPLES OF STATISTICS");
INSERT INTO Course values (1600100,"ELECTRONIC COMMERCE");
INSERT INTO Course values (400101,"ISLAM AND CONTEMPORARY ISSUES");
INSERT INTO Course values (2300102,"JORDAN: HISTORY AND CIVILIZATION");
INSERT INTO Course values (302116,"PHYSICS FOR COMPUTER SCIENCE-LAB");
INSERT INTO Course values (1904121,"WEB APPLICATIONS DEVELOPMENT - 1");
INSERT INTO Course values (3400109,"ENTREPRENEURSHIP & CREATIVITY");
INSERT INTO Course values (2220100,"MILITARY SCIENCES");
INSERT INTO Course values (3400102,"COMMUNICATION SKILLS");
INSERT INTO Course values (2000100,"APPRECIATION OF ARTS");
INSERT INTO Course values (1931102,"COMPUTER SKILLS FOR SCIENTIFIC FACULTIES");
INSERT INTO Course values (1000102,"LEGAL CULTURE");
INSERT INTO Course values (1100100,"PHYSICAL FITNESS CULTURE");
INSERT INTO Course values (1601105,"MANAGEMENT SKILLS");
INSERT INTO Course values (1900101,"SOCIAL MEDIA");
INSERT INTO Course values (302108,"PHYSICS FOR COMPUTER SCIENCE");


drop table if exists Takes;
CREATE TABLE Takes (
    courseID INT(7),
    username VARCHAR(100),
    isTaken BOOLEAN,
    FOREIGN KEY (courseID)
        REFERENCES Course (courseID),
    FOREIGN KEY (username)
        REFERENCES Student (username)
);

-- INSERT INTO Takes values (1900150,'mhm0173632',0);
-- INSERT INTO Takes values (1901234,'mhm0173632',1);
-- INSERT INTO Takes values (1901233,'mhm0173632',0);
-- INSERT INTO Takes values (3202098,'mhm0173632',0);
-- INSERT INTO Takes values (1901496,'mhm0173632',0);
-- INSERT INTO Takes values (1901442,'mhm0173632',1);
-- INSERT INTO Takes values (1901376,'mhm0173632',0);
-- INSERT INTO Takes values (1931102,'mhm0173632',1);
-- INSERT INTO Takes values (1901466,'mhm0173632',1);
-- INSERT INTO Takes values (1901241,'mhm0173632',1);
-- INSERT INTO Takes values (1901471,'mhm0173632',0);
-- INSERT INTO Takes values (1901237,'mhm0173632',0);
-- INSERT INTO Takes values (1901498,'mhm0173632',0);
-- INSERT INTO Takes values (1904121,'mhm0173632',0);
-- INSERT INTO Takes values (3202100,'mhm0173632',0);
-- INSERT INTO Takes values (300102,'mhm0173632',0);
-- INSERT INTO Takes values (1901101,'mhm0173632',0);
-- INSERT INTO Takes values (302116,'mhm0173632',0);
-- INSERT INTO Takes values (1932099,'mhm0173632',0);
-- INSERT INTO Takes values (301131,'mhm0173632',1);
-- INSERT INTO Takes values (1901494,'mhm0173632',0);
-- INSERT INTO Takes values (1901464,'mhm0173632',1);
-- INSERT INTO Takes values (1901475,'mhm0173632',0);
-- INSERT INTO Takes values (3400105,'mhm0173632',1);
-- INSERT INTO Takes values (1902454,'mhm0173632',1);
-- INSERT INTO Takes values (1902098,'mhm0173632',1);
-- INSERT INTO Takes values (302108,'mhm0173632',0);
-- INSERT INTO Takes values (1904353,'mhm0173632',0);
-- INSERT INTO Takes values (1902223,'mhm0173632',1);
-- INSERT INTO Takes values (720100,'mhm0173632',0);
-- INSERT INTO Takes values (3202099,'mhm0173632',1);
-- INSERT INTO Takes values (1901497,'mhm0173632',1);
-- INSERT INTO Takes values (1901204,'mhm0173632',1);
-- INSERT INTO Takes values (1901463,'mhm0173632',1);
-- INSERT INTO Takes values (3400106,'mhm0173632',0);
-- INSERT INTO Takes values (1901322,'mhm0173632',1);
-- INSERT INTO Takes values (301101,'mhm0173632',0);
-- INSERT INTO Takes values (1901353,'mhm0173632',0);
-- INSERT INTO Takes values (1901473,'mhm0173632',1);
-- INSERT INTO Takes values (3201099,'mhm0173632',1);
-- INSERT INTO Takes values (1901472,'mhm0173632',1);
-- INSERT INTO Takes values (400102,'mhm0173632',1);
-- INSERT INTO Takes values (1904101,'mhm0173632',0);
-- INSERT INTO Takes values (1904341,'mhm0173632',1);
-- INSERT INTO Takes values (3400101,'mhm0173632',1);
-- INSERT INTO Takes values (1902474,'mhm0173632',1);
-- INSERT INTO Takes values (3400104,'mhm0173632',0);
-- INSERT INTO Takes values (1901469,'mhm0173632',0);
-- INSERT INTO Takes values (2300101,'mhm0173632',0);
-- INSERT INTO Takes values (1902353,'mhm0173632',1);
-- INSERT INTO Takes values (3400103,'mhm0173632',0);
-- INSERT INTO Takes values (1902371,'mhm0173632',1);
-- INSERT INTO Takes values (1902202,'mhm0173632',0);
-- INSERT INTO Takes values (3400108,'mhm0173632',0);
-- INSERT INTO Takes values (1901446,'mhm0173632',1);
-- INSERT INTO Takes values (3201100,'mhm0173632',1);
-- INSERT INTO Takes values (1901362,'mhm0173632',1);
-- INSERT INTO Takes values (3400109,'mhm0173632',0);
-- INSERT INTO Takes values (1901238,'mhm0173632',0);
-- INSERT INTO Takes values (2200103,'mhm0173632',1);
-- INSERT INTO Takes values (1901359,'mhm0173632',1);
-- INSERT INTO Takes values (3201098,'mhm0173632',1);
-- INSERT INTO Takes values (3400107,'mhm0173632',0);
-- INSERT INTO Takes values (3400100,'mhm0173632',1);
-- INSERT INTO Takes values (1600100,'mhm0173632',1);
-- INSERT INTO Takes values (1901457,'mhm0173632',0);
-- INSERT INTO Takes values (1901443,'mhm0173632',0);
-- INSERT INTO Takes values (3400102,'mhm0173632',0);
-- INSERT INTO Takes values (1902342,'mhm0173632',0);
-- INSERT INTO Takes values (2300102,'mhm0173632',0);
-- INSERT INTO Takes values (1901467,'mhm0173632',1);
-- INSERT INTO Takes values (1100100,'mhm0173632',1);
-- INSERT INTO Takes values (1601105,'mhm0173632',0);
-- INSERT INTO Takes values (1901459,'mhm0173632',1);
-- INSERT INTO Takes values (1901341,'mhm0173632',0);
-- INSERT INTO Takes values (1901461,'mhm0173632',0);
-- INSERT INTO Takes values (400101,'mhm0173632',1);
-- INSERT INTO Takes values (1900101,'mhm0173632',0);
-- INSERT INTO Takes values (2220100,'mhm0173632',1);
-- INSERT INTO Takes values (1901351,'mhm0173632',1);
-- INSERT INTO Takes values (1901452,'mhm0173632',0);
-- INSERT INTO Takes values (2000100,'mhm0173632',1);
-- INSERT INTO Takes values (1000102,'mhm0173632',0);


-- INSERT INTO Takes values (1901442,'hsa0189136',1);
-- INSERT INTO Takes values (1901233,'hsa0189136',0);
-- INSERT INTO Takes values (1901464,'hsa0189136',1);
-- INSERT INTO Takes values (3400106,'hsa0189136',1);
-- INSERT INTO Takes values (1901494,'hsa0189136',0);
-- INSERT INTO Takes values (3202098,'hsa0189136',1);
-- INSERT INTO Takes values (1901234,'hsa0189136',0);
-- INSERT INTO Takes values (301131,'hsa0189136',0);
-- INSERT INTO Takes values (1901475,'hsa0189136',0);
-- INSERT INTO Takes values (1901101,'hsa0189136',0);
-- INSERT INTO Takes values (1901353,'hsa0189136',0);
-- INSERT INTO Takes values (300102,'hsa0189136',1);
-- INSERT INTO Takes values (1901362,'hsa0189136',0);
-- INSERT INTO Takes values (3202100,'hsa0189136',1);
-- INSERT INTO Takes values (1902223,'hsa0189136',0);
-- INSERT INTO Takes values (1901376,'hsa0189136',1);
-- INSERT INTO Takes values (1901237,'hsa0189136',1);
-- INSERT INTO Takes values (1901466,'hsa0189136',0);
-- INSERT INTO Takes values (1902454,'hsa0189136',0);
-- INSERT INTO Takes values (302116,'hsa0189136',1);
-- INSERT INTO Takes values (1901469,'hsa0189136',0);
-- INSERT INTO Takes values (301101,'hsa0189136',0);
-- INSERT INTO Takes values (1901496,'hsa0189136',1);
-- INSERT INTO Takes values (1900150,'hsa0189136',0);
-- INSERT INTO Takes values (3400109,'hsa0189136',0);
-- INSERT INTO Takes values (1901467,'hsa0189136',1);
-- INSERT INTO Takes values (2200103,'hsa0189136',0);
-- INSERT INTO Takes values (302108,'hsa0189136',0);
-- INSERT INTO Takes values (1902474,'hsa0189136',1);
-- INSERT INTO Takes values (1901471,'hsa0189136',1);
-- INSERT INTO Takes values (1901204,'hsa0189136',1);
-- INSERT INTO Takes values (1904101,'hsa0189136',0);
-- INSERT INTO Takes values (1901241,'hsa0189136',1);
-- INSERT INTO Takes values (3202099,'hsa0189136',0);
-- INSERT INTO Takes values (1901359,'hsa0189136',1);
-- INSERT INTO Takes values (720100,'hsa0189136',1);
-- INSERT INTO Takes values (1901351,'hsa0189136',0);
-- INSERT INTO Takes values (400102,'hsa0189136',0);
-- INSERT INTO Takes values (3201099,'hsa0189136',1);
-- INSERT INTO Takes values (3400108,'hsa0189136',1);
-- INSERT INTO Takes values (1901322,'hsa0189136',1);
-- INSERT INTO Takes values (1902202,'hsa0189136',1);
-- INSERT INTO Takes values (1901463,'hsa0189136',0);
-- INSERT INTO Takes values (1902353,'hsa0189136',0);
-- INSERT INTO Takes values (1931102,'hsa0189136',0);
-- INSERT INTO Takes values (2000100,'hsa0189136',1);
-- INSERT INTO Takes values (1901461,'hsa0189136',0);
-- INSERT INTO Takes values (1902371,'hsa0189136',0);
-- INSERT INTO Takes values (1901498,'hsa0189136',1);
-- INSERT INTO Takes values (1932099,'hsa0189136',0);
-- INSERT INTO Takes values (1901497,'hsa0189136',0);
-- INSERT INTO Takes values (1901443,'hsa0189136',1);
-- INSERT INTO Takes values (1901459,'hsa0189136',1);
-- INSERT INTO Takes values (1904121,'hsa0189136',1);
-- INSERT INTO Takes values (1904353,'hsa0189136',1);
-- INSERT INTO Takes values (1901473,'hsa0189136',1);
-- INSERT INTO Takes values (1901446,'hsa0189136',0);
-- INSERT INTO Takes values (1901238,'hsa0189136',0);
-- INSERT INTO Takes values (3400107,'hsa0189136',1);
-- INSERT INTO Takes values (3201100,'hsa0189136',1);
-- INSERT INTO Takes values (1600100,'hsa0189136',0);
-- INSERT INTO Takes values (1901341,'hsa0189136',0);
-- INSERT INTO Takes values (1900101,'hsa0189136',1);
-- INSERT INTO Takes values (3400101,'hsa0189136',1);
-- INSERT INTO Takes values (1901452,'hsa0189136',0);
-- INSERT INTO Takes values (1901457,'hsa0189136',0);
-- INSERT INTO Takes values (2220100,'hsa0189136',0);
-- INSERT INTO Takes values (1901472,'hsa0189136',1);
-- INSERT INTO Takes values (3400105,'hsa0189136',1);
-- INSERT INTO Takes values (3201098,'hsa0189136',0);
-- INSERT INTO Takes values (1904341,'hsa0189136',0);
-- INSERT INTO Takes values (1902342,'hsa0189136',0);
-- INSERT INTO Takes values (1902098,'hsa0189136',1);
-- INSERT INTO Takes values (2300102,'hsa0189136',0);
-- INSERT INTO Takes values (400101,'hsa0189136',0);
-- INSERT INTO Takes values (1000102,'hsa0189136',0);
-- INSERT INTO Takes values (1100100,'hsa0189136',1);
-- INSERT INTO Takes values (3400104,'hsa0189136',0);
-- INSERT INTO Takes values (2300101,'hsa0189136',0);
-- INSERT INTO Takes values (3400102,'hsa0189136',0);
-- INSERT INTO Takes values (3400103,'hsa0189136',1);
-- INSERT INTO Takes values (1601105,'hsa0189136',0);
-- INSERT INTO Takes values (3400100,'hsa0189136',0);
