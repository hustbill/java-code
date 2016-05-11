-- drop tables

drop table Student CASCADE;
drop table Department CASCADE;
drop table Teacher CASCADE;
drop table Course CASCADE;
drop table Section CASCADE;
drop table Enrollment CASCADE;
drop table GpaLookup CASCADE;

-- create tables

CREATE TABLE Student
(
  studentid CHAR(9) NOT NULL,
  fname VARCHAR(20) NOT NULL,
  lname VARCHAR(20) NOT NULL,
  depname VARCHAR(40) NOT NULL,
  year int NOT NULL,
  email VARCHAR(30) NOT NULL,
  phone VARCHAR(20) NOT NULL,
  PRIMARY KEY (studentid)
);

CREATE TABLE Department
(
  depid CHAR(4) NOT NULL,
  depname VARCHAR(40) NOT NULL,
  PRIMARY KEY (depid)
);

CREATE TABLE Teacher
(
  teacherid CHAR(9) NOT NULL,
  fname VARCHAR(20) NOT NULL,
  lname VARCHAR(20) NOT NULL,
  email VARCHAR(30) NOT NULL,
  phone VARCHAR(20) NOT NULL,
  office VARCHAR(20) NOT NULL,
  hours VARCHAR(20) NOT NULL,
  depid CHAR(4) NOT NULL,
  PRIMARY KEY (teacherid),
  FOREIGN KEY (depid) REFERENCES Department(depid)
);

CREATE TABLE Course
(
  courseid CHAR(6) NOT NULL,
  coursenumber VARCHAR(30) NOT NULL,
  name VARCHAR(60) NOT NULL,
  description VARCHAR(200),
  www VARCHAR(30),
  courselevel VARCHAR(10),
  credit NUMERIC(2,0) NOT NULL,
  depid CHAR(4) NOT NULL,
  PRIMARY KEY (courseid),
  FOREIGN KEY (depid) REFERENCES Department(depid)
);

CREATE TABLE Section
(
  secid INT NOT NULL,
  secterm CHAR(8) NOT NULL,
  secyear CHAR(4) NOT NULL,
  secbldg CHAR(6),
  secroom CHAR(4) ,
  sectime CHAR(10) ,
  courseid CHAR(6) NOT NULL,
  teacherid CHAR(9) NOT NULL,
  PRIMARY KEY (secid),
  FOREIGN KEY (courseid) REFERENCES Course(courseid)
);

CREATE TABLE Enrollment
(
  studentid CHAR(9) NOT NULL,
  secid INT NOT NULL,
  grade VARCHAR(4) NOT NULL,
  FOREIGN KEY (studentid) REFERENCES Student(studentid),
  FOREIGN KEY (secid) REFERENCES Section(secid)
);

CREATE TABLE GpaLookup
(
  grade VARCHAR(4) NOT NULL,
  point Numeric(2,1) NOT NULL,
  PRIMARY KEY (grade)
);
