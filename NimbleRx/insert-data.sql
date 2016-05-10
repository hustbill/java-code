-- insert data
insert into Student
(studentid, fname, lname, depname, year, email, phone)
values (100100100, 'Mickey','Mouse','ENCS',3,'mickey.mouse@wsu.edu','1-360-234-5678');

insert into Student
(studentid, fname, lname, depname, year, email, phone)
values (100100101, 'Minnie','Mouse','TPP',2,'minnie.mouse@wsu.edu','1-360-234-5432');

insert into Student
(studentid, fname, lname, depname, year, email, phone)
values (100100102, 'Snow','White','DUSP',5,'snow.white@wsu.edu','1-360-234-5238');


insert into Student
(studentid, fname, lname, depname, year, email, phone)
values (100100103, 'Jaecheol','kim','PHYS',5,'Jaecheol.kim@wsu.edu','1-360-234-5238');

insert into Student
(studentid, fname, lname, depname, year, email, phone)
values (100100104, 'Jacky','Lee','PHYS',3,'jack.lee@wsu.edu','1-360-234-5623');

insert into Student
(studentid, fname, lname, depname, year, email, phone)
values (100100105, 'Virat','Dang','Math',2,'virat.dang@wsu.edu','1-360-234-5432');

insert into Department
(depid, depname)
values ('v101','ENCS');

insert into Department
(depid, depname)
values ('v102','Engineering');

insert into Teacher
(teacherid, fname, lname, email, phone, office, hours, depid)
values (500100101, 'Donald','Duck','donald.duck@wsu.edu','1-360-674-3754','room 9-554','T1-2;W2-3', 'v101');

insert into Teacher
(teacherid, fname, lname, email, phone, office, hours, depid)
values (500100102, 'Marc','Johnson','marc.john@wsu.edu','1-360-674-4954','room 9-551','T1-2;W1-2','v102');

insert into Teacher
(teacherid, fname, lname, email, phone, office, hours,depid)
values (100100102, 'Snow','White','snow.white@wsu.edu','1-360-434-3438','room 9-552','T2-3;R3-4', 'v101');


insert into Course 
(courseid, coursenumber, name, description, www, courselevel, credit, depid)
values (100100, 'CS223','Data Structure & Algorithm','http://schedules.wsu.edu/List/Vancouver/20163/CS/223/01','This course ...','low',12, 'v101');

insert into Course
(courseid, coursenumber, name, description, www, courselevel, credit, depid)
values (100101, 'Phys101','Physics','http://schedules.wsu.edu/List/Vancouver/20163/Phys/202/01','This course ...','low',12, 'v102');


insert into Course
(courseid, coursenumber, name, description, www, courselevel, credit, depid)
values (100102, 'CS547','Computer Game Design','http://schedules.wsu.edu/List/Vancouver/20163/CS/547/01','This course ...','high',12, 'v101');

insert into Section 
(secid, secterm, secyear, secbldg, secroom, sectime, courseid, teacherid)
values(1000, 'Spring', '2010', '', '', '', 100100, 100100102);

insert into Section 
(secid, secterm, secyear, secbldg, secroom, sectime, courseid, teacherid)
values(1001, 'Fall', '2010', '', '', '', 100101, 500100102);

insert into Section 
(secid, secterm, secyear, secbldg, secroom, sectime, courseid, teacherid)
values(1002, 'Summer', '2010', '', '', '', 100102, 500100101);

insert into Section 
(secid, secterm, secyear, secbldg, secroom, sectime, courseid, teacherid)
values(1003, 'Summer', '2010', '', '', '', 100100, 500100101);

insert into Section 
(secid, secterm, secyear, secbldg, secroom, sectime, courseid, teacherid)
values(1004, 'Fall', '2010', '', '', '', 100100, 500100101);

insert into Section 
(secid, secterm, secyear, secbldg, secroom, sectime, courseid, teacherid)
values(1005, 'Winter', '2010', '', '', '', 100100, 500100101);


insert into Enrollment
(studentid, secid,  score)
values (100100100, 1000, 'C-');

insert into Enrollment
(studentid, secid, score)
values (100100101, 1001, 'B+');

insert into Enrollment
(studentid, secid, score)
values (100100103, 1001, 'A');

insert into Enrollment
(studentid, secid, score)
values (100100104, 1001, 'A-');


insert into Enrollment
(studentid, secid, score)
values (100100101, 1002, 'A-');

insert into Enrollment
(studentid, secid, score)
values (100100102, 1002, 'B-');


insert into Enrollment
(studentid, secid, score)
values (100100100, 1003, 'B+');

insert into Enrollment
(studentid, secid, score)
values (100100100, 1004, 'A-');

insert into Enrollment
(studentid, secid, score)
values (100100100, 1005, 'A');

insert into GpaLookup
(grade, point)
values ('A', 4.0);

insert into GpaLookup
(grade, point)
values ('A', 4.0);

insert into GpaLookup
(grade, point)
values ('A', 4.0);

insert into GpaLookup
(grade, point)
values ('A-', 3.7);

insert into GpaLookup
(grade, point)
values ('B+', 3.3);

insert into GpaLookup
(grade, point)
values ('B', 3.0);

insert into GpaLookup
(grade, point)
values ('B-', 2.7);

insert into GpaLookup
(grade, point)
values ('C+', 2.3);

insert into GpaLookup
(grade, point)
values ('C', 2.0);

insert into GpaLookup
(grade, point)
values ('C-', 1.7);

insert into GpaLookup
(grade, point)
values ('D+', 1.3);

insert into GpaLookup
(grade, point)
values ('D', 1.0);

insert into GpaLookup
(grade, point)
values ('D-', 0.7);

insert into GpaLookup
(grade, point)
values ('F-', 0);
