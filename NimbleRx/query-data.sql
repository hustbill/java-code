-- Queries:
-- 1) How many people are exclusively students?
select count(*) from Student s where s.year<=4;

-- 2) How many people are exclusively teachers?
select count(*) from Teacher t  where t.teacherid  NOT in (select studentid from Student);

-- 3) How many people are both students and teachers?
select count(*) from Teacher t  where t.teacherid  in (select studentid from Student);

-- 4) Assume you have a student name Mickey Mouse, what is his Data Structure & Algorithm Grade in Spring 2010?
 select s.fname, s.lname, e.grade, c.coursenumber, c.name, st.secterm, st.secyear
  from Student s, Course c, Section st, Enrollment e
 where s.studentid=e.studentid and c.courseid=st.courseid 
    and st.secid = e.secid
   and s.fname='Mickey' and s.lname='Mouse'
   and c.courseid='100100'
   and st.secterm ='Spring'
   and st.secyear='2010';

-- 5) Assume you have a student name Minnie Mouse, what is her GPA?
select ROUND(sum(point) /count(point), 1) as GPA from  (
select point, count(point) from GpaLookup where grade in (
 select e.grade
  from Student s, Course c, Section st, Enrollment e
 where s.studentid=e.studentid and c.courseid=st.courseid 
    and st.secid = e.secid
   and s.fname='Minnie' and s.lname='Mouse'
   and st.secyear='2010') 
   group by point) as result;


-- 6) What is the median grade for all students taking Physics in Fall 2010?
 select grade as medin_grade from GpaLookup where point = (
     select ROUND(avg(point), 1) as median from (
	select point from GpaLookup where grade in (
	select e.grade from Section st, Course c, Enrollment e 
	  where 
	  st.courseid = c.courseid 
	    and st.secid = e.secid
	    and c.name = 'Physics'
	    and st.secterm = 'Fall'
	    and st.secyear = '2010' )) as foo);
    
    
-- 7) Assume you have a professor name Donald Duck, what courses did he teach in Summer 2010?
select c.name from Section st, Course c, Teacher t
    where st.courseid = c.courseid and t.teacherid = st.teacherid
    and st.secterm = 'Summer'
    and st.secyear = '2010'
    and t.fname ='Donald'
    and t.lname ='Duck' ;

-- 8) What courses has Minnie Mouse taken with Donald Duck as the professor?
select c.name from Student s, Course c, Teacher t, Enrollment e, Section st
where st.teacherid = t.teacherid and c.courseid = st.courseid and s.studentid = e.studentid and e.secid = st.secid
	and t.fname = 'Donald'
	and t.lname = 'Duck'
	and s.fname = 'Minnie'
	and s.lname ='Mouse'
   group by c.courseid;


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
	and s.lname ='Mouse';

-- 11) What classes have been taught by both Donald Duck and Snow White?
select c.name as cname, count(distinct t.teacherid) as count from Course c, Teacher t, Section st
where  t.teacherid = st.teacherid and st.courseid = c.courseid	
     and (( t.fname = 'Snow'
	and t.lname = 'White')
	or ( t.fname = 'Donald'
	and t.lname = 'Duck'))
  group by name
  having count(t.teacherid)>=2;

-- 12) Assume that Mickey Mouse has taken Data Structures & Algorithms several times, Spring 2010 for a C-, Summer 2010 for a B+, 
-- and Fall 2010 for a A-, and Winter 2010 for an A. What was his highest grade for Data Structure and Algorithms and what term was that in?
	select e.grade, st.secterm, st.secyear from Section st, Course c, Enrollment e, Student s
	  where 
	  st.courseid = c.courseid 
	    and st.secid = e.secid
	   and s.fname = 'Mickey'
	and s.lname ='Mouse'
	and c.coursenumber = 'CS223'
	and e.grade = ( select grade from GpaLookup where point = (
		select max(point)  from (
			select  point from GpaLookup where grade in (
			select e.grade from Section st, Course c, Enrollment e, Student s
			  where 
			  st.courseid = c.courseid 
			    and st.secid = e.secid
			   and s.fname = 'Mickey'
			and s.lname ='Mouse'
			and c.coursenumber = 'CS223')) as foo)
	   );


-- 13) How many classes did Snow White take in 2010?
select count(c.courseid) from Course c, Student s, Section st, Enrollment e
where c.courseid = st.courseid and s.studentid = e.studentid  and e.secid = st.secid
	and st.secyear = '2010'
	and  s.fname = 'Snow'
	and s.lname = 'White'
