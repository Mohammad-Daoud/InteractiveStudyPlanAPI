
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
DROP SCHEMA IF EXISTS `UNIVERSITY`;
CREATE SCHEMA `UNIVERSITY`;
USE `UNIVERSITY`;

drop table if exists Administrator;
create table Administrator (
fname varchar(100) ,
lname varchar(100) ,
username varchar(100) not null ,
password varchar(255) not null,
primary key(username) 
); 
insert into Administrator values('Mohammad', 'Daoud','mdaoud','mdaoud');
insert into Administrator values('Husam', 'Jbr','hjbr','hjbr');
insert into Administrator values('Hamzah', 'Amerah','hamerah','hamerah');

drop table if exists Student;
create table Student (
studentID int(10) not null,
fname varchar(100) not null,
lname varchar(100) not null,
username varchar(100) not null unique,
password varchar(255) not null,
schoolName varchar(100) not null unique,
depName varchar(100) not null unique,
planYear int(5) not null,
primary key(studentID)
);
insert into Student values ('0173632','Mohammad', 'Daoud','mhm0173632','mhm0173632','kasit','cs','2017');

drop table if exists Instructor;
create table Instructor (
instructorID int(10) not null,
fname varchar(100) not null,
lname varchar(100) not null,
username varchar(100) not null unique,
password varchar(255) not null,
schoolName varchar(100) not null unique,
depName varchar(100) not null unique,
primary key(instructorID)
);
insert into Instructor values ('0123456','Heba', 'Saadeh','hib0123456','hib0123456','kasit','cs');

drop table if exists School;
create table School (
schoolName varchar(100) not null unique,
schoolCode int(100) not null auto_increment,
primary key(schoolCode),
foreign key(schoolName) references Instructor(schoolName),
foreign key(schoolName) references Student(schoolName)
);
insert into School values ('kasit','1');

drop table if exists Department;
create table Department (
depName varchar(100) not null,
depCode int(100) not null auto_increment,
primary key(depCode),
constraint depName foreign key(depName) references Instructor(depName),
 foreign key(depName) references Student(depName)
);
insert into Department values ('cs','1');

drop table if exists Advisor;
create table Advisor (
studentID int(10) not null,
instructorID int(10) not null,
constraint studentID foreign key (studentID) references Student(studentID),
constraint instructorID foreign key (instructorID) references Instructor(instructorID)
);

drop table if exists Course;
create table Course (
category varchar(38) not null,
courseID varchar (100)not null,
courseName varchar(255) not null unique,
creditHours int(1) not null,
preCount int(1),
depName varchar(100) not null,
primary key(courseID)
);

drop table if exists Prereq;
create table Prereq (
courseID varchar (100)not null,
prereqID varchar(100) not null,
primary key (prereqID),
foreign key (prereqID) references Course(courseID)
);

INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_University_Requirements','2220100','MILITARY SCIENCES',3,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_University_Requirements','3400100','NATIONAL CULTURE',3,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_University_Requirements','3400101','LEARNING & RESEARCH SKILLS',3,3);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_University_Requirements','3400102','COMMUNICATION SKILLS',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_University_Requirements','3400103','INTRODUCTION TO PHILOSOPHY AND CRITICAL THINKING',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_University_Requirements','3400104','HUMAN CIVILIZATION',3,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_University_Requirements','3400105','CAMPUS LIFE AND ETHICS',3,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_University_Requirements','400101','ISLAM AND CONTEMPORARY ISSUES',3,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_University_Requirements','2300101','ARAB-ISLAMIC CIVILIZATION',3,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_University_Requirements','2300102','JORDAN: HISTORY AND CIVILIZATION',3,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_University_Requirements','3400107','GREAT BOOKS',3,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_University_Requirements','3400108','JERUSALEM',3,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_University_Requirements','300102','ENVIRONMENTAL CULTURE',3,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_University_Requirements','400102','ISLAMIC CULTURE',3,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_University_Requirements','720100','HEALTH CULTURE',3,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_University_Requirements','1000102','LEGAL CULTURE',3,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_University_Requirements','1100100','PHYSICAL FITNESS CULTURE',3,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_University_Requirements','1600100','ELECTRONIC COMMERCE',3,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_University_Requirements','1601105','MANAGEMENT SKILLS',3,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_University_Requirements','1900101','SOCIAL MEDIA',3,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_University_Requirements','2000100','APPRECIATION OF ARTS',3,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_University_Requirements','2200103','FOREIGN LANGUAGE',3,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_University_Requirements','3400106','SPECIAL SUBJECT',3,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_University_Requirements','3400109','ENTREPRENEURSHIP & CREATIVITY',3,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Faculty_Requirements','301101','CALCULUS I',3,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Faculty_Requirements','1901101','DISCRETE MATHEMATICS',3,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Faculty_Requirements','1901233','DATA STRUCTURES-1',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Faculty_Requirements','1902202','DOCUMENTATION AND ETHICS',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Faculty_Requirements','1902223','INTRODUCTION TO DATABASE SYSTEMS',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Faculty_Requirements','1904101','FUNDAMENTALS OF INFORMATION TECHNOLOGY',3,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Faculty_Requirements','1904121','WEB APPLICATIONS DEVELOPMENT - 1',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Faculty_Requirements','1931102','COMPUTER SKILLS FOR SCIENTIFIC FACULTIES',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Specialization_Requirements','301131','PRINCIPLES OF STATISTICS',3,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Specialization_Requirements','302108','PHYSICS FOR COMPUTER SCIENCE',2,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Specialization_Requirements','302116','PHYSICS FOR COMPUTER SCIENCE-LAB',1,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Specialization_Requirements','1901204','LOGIC DESIGN',3,3);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Specialization_Requirements','1901234','DATA STRUCTURES-2',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Specialization_Requirements','1901237','PROGRAMMING METHODOLOGIES',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Specialization_Requirements','1901238','PROGRAMMING IN SPECIAL LANGUAGES',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Specialization_Requirements','1901241','THEORY OF COMPUTATION',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Specialization_Requirements','1901322','COMPUTER ORGANIZATION',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Specialization_Requirements','1901341','THEORY OF ALGORITHMS',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Specialization_Requirements','1901351','NUMERICAL ANALYSIS',3,2);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Specialization_Requirements','1901353','MODELING AND SIMULATION',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Specialization_Requirements','1901359','COMPUTER GRAPHICS',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Specialization_Requirements','1901362','COMPUTER NETWORKS-1',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Specialization_Requirements','1901376','SYSTEMS PROGRAMMING AND MANAGEMENT',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Specialization_Requirements','1901442','NETWORK PROGRAMMING',3,2);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Specialization_Requirements','1901463','COMPUTER SECURITY',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Specialization_Requirements','1901466','DISTRIBUTED SYSTEMS',3,2);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Specialization_Requirements','1901471','DESIGN AND IMPLEMENTATION OF PROGRAMMING LANGUAGES',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Specialization_Requirements','1901472','COMPILER CONSTRUCTION',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Specialization_Requirements','1901473','OPERATING SYSTEMS',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Specialization_Requirements','1901496','PROJECT-1',0,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Specialization_Requirements','1901497','PROJECT-2',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Specialization_Requirements','1901498','TRAINING',0,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Specialization_Requirements','1902342','ARTIFICIAL INTELLIGENCE',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Obligatory_Specialization_Requirements','1902371','INTRODUCTION TO SOFTWARE ENGINEERING',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_Specialization_Requirements','1901443','GRAPH THEORY',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_Specialization_Requirements','1901446','COMPUTER SYSTEMS PERFORMANCE',3,2);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_Specialization_Requirements','1901452','PATTERN RECOGNITION',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_Specialization_Requirements','1901457','INFORMATION VISUALIZATION',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_Specialization_Requirements','1901459','CERTIFIED SOFTWARE',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_Specialization_Requirements','1901461','COMPUTER NETWORKS - 2',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_Specialization_Requirements','1901464','PARALLEL PROCESSING',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_Specialization_Requirements','1901467','MULTIMEDIA NETWORKING',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_Specialization_Requirements','1901469','MOBILE WIRELESS NETWORKS',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_Specialization_Requirements','1901475','OPERATING SYSTEMS PROGRAMMING',3,2);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_Specialization_Requirements','1901494','SPECIAL TOPICS',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_Specialization_Requirements','1902353','HUMAN COMPUTER INTERACTION',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_Specialization_Requirements','1902454','DIGITAL IMAGE PROCESSING',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_Specialization_Requirements','1902474','SYSTEMS ANALYSIS AND DESIGN',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_Specialization_Requirements','1904341','OPERATIONS RESEARCH',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('Elective_Specialization_Requirements','1904353','WEB APPLICATION DEVELOPMENT - 2',3,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('General_Requirements','1900150','COMMUNITY SERVICE',0,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('General_Requirements','1902098','COMPUTER SKILLS PLACEMENT TEST',0,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('General_Requirements','1932099','BASICS OF COMPUTING',0,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('General_Requirements','3201098','ARABIC PLACEMENT TEST',0,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('General_Requirements','3201099','BASICS OF ARABIC',0,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('General_Requirements','3201100','ARABIC LANGUAGE SKILLS',0,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('General_Requirements','3202098','ENGLISH PLACEMENT TEST',0,0);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('General_Requirements','3202099','BASICS OF ENGLISH',0,1);
INSERT INTO Course(category,courseID,courseName,creditHours,preCount) VALUES ('General_Requirements','3202100','ENGLISH LANGUAGE SKILLS',0,1);
