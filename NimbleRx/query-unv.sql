-- Queries:
-- 1) How many people are exclusively students?
select count(*) from Student s where s.year<=4;
-- select s.fname, s.lname from Student s where s.year<=4;

-- 2) How many people are exclusively teachers?
select count(*) from Teacher t  where t.teacherid  NOT in (select studentid from Student);
-- select t.fname, t.lname from Teacher t  where t.teacherid  NOT in (select studentid from Student);

-- 3) How many people are both students and teachers?
select count(*) from Teacher t  where t.teacherid  in (select studentid from Student);
-- select t.fname, t.lname from Teacher t  where t.teacherid in (select studentid from Student);

-- 4) Assume you have a student name Mickey Mouse, what is his Data Structure & Algorithm Grade in Spring 2010?
 select s.fname, s.lname, e.score, c.coursenumber, c.name, st.secterm, st.secyear
  from Student s, Course c, Section st, Enrollment e
 where s.studentid=e.studentid and c.courseid=st.courseid 
    and st.secid = e.secid
   and s.fname='Mickey' and s.lname='Mouse'
   and c.courseid='100100'
   and st.secterm ='Spring'
   and st.secyear='2010';

-- 5) Assume you have a student name Minnie Mouse, what is her GPA?
 select e.score, c.coursenumber, c.name, st.secterm, st.secyear
  from Student s, Course c, Section st, Enrollment e
 where s.studentid=e.studentid and c.courseid=st.courseid 
    and st.secid = e.secid
   and s.fname='Minnie' and s.lname='Mouse'
   and st.secyear='2010';

CREATE TABLE GpaLookup
(
  grade VARCHAR(4) NOT NULL,
  point Numeric(2,1) NOT NULL
);

insert GpaLookup 
(grade, point)
values ('A', 4.0);

insert GpaLookup 
(grade, point)
values ('A', 4.0);

insert GpaLookup 
(grade, point)
values ('A', 4.0);

insert GpaLookup 
(grade, point)
values ('A-', 3.7);

insert GpaLookup 
(grade, point)
values ('B+', 3.3);

insert GpaLookup 
(grade, point)
values ('B', 3.0);

insert GpaLookup 
(grade, point)
values ('B-', 2.7);

insert GpaLookup 
(grade, point)
values ('C+', 2.3);

insert GpaLookup 
(grade, point)
values ('C', 2.0);

insert GpaLookup 
(grade, point)
values ('C-', 1.7);

insert GpaLookup 
(grade, point)
values ('D+', 1.3);

insert GpaLookup 
(grade, point)
values ('D', 1.0);

insert GpaLookup 
(grade, point)
values ('D-', 0.7);

insert GpaLookup 
(grade, point)
values ('F-', 0);


-- 6) What is the median grade for all students taking Physics in Fall 2010?
 select AVG(grade) as median from ( Select 
(
case e.score when 'A' then 4.0 when 'A-' then 3.7 when 'B+' then 3.3   when 'B' then 3.0 when 'B' then 2.7
when 'C+' then 2.3   when 'C+' then 2.0  when 'C-' then 1.7     when 'D+' then 1.3    when 'D' then 1.0  
 when 'D-' then 0.7   when 'F' then 0.0
END ) as grade

 from Section st, Course c, Enrollment e
    where st.courseid = c.courseid 
    and st.secid = e.secid
    and c.name = 'Physics'
    and st.secterm = 'Fall'
    and st.secyear = '2010')  as grade; 


select e.studentid, e.score

 from Section st, Course c, Enrollment e
    where st.courseid = c.courseid 
    and st.secid = e.secid
    and c.name = 'Physics'
    and st.secterm = 'Fall'
    and st.secyear = '2010'; 

-- 7) Assume you have a professor name Donald Duck, what courses did he teach in Summer 2010?
select c.name from Section st, Course c, Teacher t
    where st.courseid = c.courseid and t.teacherid = st.teacherid
    and st.secterm = 'Summer'
    and st.secyear = '2010'
    and t.fname ='Donald'
    and t.lname ='Duck' 

-- 8) What courses has Minnie Mouse taken with Donald Duck as the professor?
select c.name from Student s, Course c, Teacher t, Enrollment e, Section st
where st.teacherid = t.teacherid and c.courseid = st.courseid and s.studentid = e.studentid and e.secid = st.secid
	and t.fname = 'Donald'
	and t.lname = 'Duck'
	and s.fname = 'Minnie'
	and s.lname ='Mouse'
   group by c.courseid


-- 9) Assume that Snow White is both a student and a teacher. What classes has Snow White and Minnie Mouse taken together as students?
select c.name from Course c, Student s, Enrollment e, Section st
where  st.courseid = c.courseid and e.studentid = s.studentid	 and e.secid = st.secid
     and (( s.fname = 'Snow'
	and s.lname = 'White')
	or ( s.fname = 'Minnie'
	and s.lname = 'Mouse'))
 group by c.courseid
having count(s.studentid) = 2;


-- 10) What classes has Snow White taught that Minnie Mouse has attended?
select c.name, st.secterm, st.secyear from Teacher t, Course c, Section st, Student s, Enrollment e
where st.teacherid = t.teacherid and st.courseid = c.courseid and st.secid = e.secid 
and t.fname = 'Snow'
	and t.lname = 'White'
	and s.fname = 'Minnie'
	and s.lname ='Mouse'



CREATE TABLE t1 (s1 INT, s2 CHAR(5), s3 FLOAT);
INSERT INTO t1 VALUES (1,'1',1.0);
INSERT INTO t1 VALUES (2,'2',2.0);
SELECT sb1,sb2,sb3
  FROM (SELECT s1 AS sb1, s2 AS sb2, s3*2 AS sb3 FROM t1) AS sb
  WHERE sb1 > 1;

-- 11) What classes have been taught by both Donald Duck and Snow White?
select cname from 
(select c.name as cname, count(t.fname) as count from Course c, Teacher t, Section st
where  t.teacherid = st.teacherid and st.courseid = c.courseid	
     and (( t.fname = 'Snow'
	and t.lname = 'White')
	or ( t.fname = 'Donald'
	and t.lname = 'Duck'))
group by name) as names where count > 1 ;

-- 12) Assume that Mickey Mouse has taken Data Structures & Algorithms several times, Spring 2010 for a C-, Summer 2010 for a B+, 
-- and Fall 2010 for a A-, and Winter 2010 for an A. What was his highest grade for Data Structure and Algorithms and what term was that in?
select e.score from Section st, Enrollment e, Student s, Course c 
    where  e.studentid = s.studentid and st.courseid = c.courseid and st.secid = e.secid
	and s.fname = 'Mickey'
	and s.lname ='Mouse'
	and c.coursenumber = 'CS223';


-- 13) How many classes did Snow White take in 2010?
select * from Course c, Student s, Section st, Enrollment e
where c.courseid = st.courseid and s.studentid = e.studentid  and e.secid = st.secid
	and st.secyear = '2010'
	and  s.fname = 'Snow'
	and s.lname = 'White'
