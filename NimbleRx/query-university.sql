-- Queries:
-- 1) How many people are exclusively students?
select count(*) from students s where s.year<=4;
-- select s.fname, s.lname from students s where s.year<=4;
   
-- 2) How many people are exclusively teachers?
select count(*) from teachers t  where t.teacherid  NOT in (select studentid from students);
-- select t.fname, t.lname from teachers t  where t.teacherid  NOT in (select studentid from students);

-- 3) How many people are both students and teachers?
select count(*) from teachers t  where t.teacherid  in (select studentid from students);
-- select t.fname, t.lname from teachers t  where t.teacherid  in (select studentid from students);

-- 4) Assume you have a student name Mickey Mouse, what is his Data Structure & Algorithm Grade in Spring 2010?
 select s.fname, s.lname, sc.score, c.coursenumber, c.name, st.secterm, st.secyear
  from students s, stu_cou sc, courses c, section st
 where s.studentid=sc.studentid and c.courseid=sc.courseid 
    and st.courseid = sc.courseid
    and st.secid = sc.secid
   and s.fname='Mickey' and s.lname='Mouse'
   and c.courseid=100100
   and st.secterm ='Spring'
   and st.secyear='2010';

-- 5) Assume you have a student name Minnie Mouse, what is her GPA?

-- 6) What is the median grade for all students taking Physics in Fall 2010?
select score from section st, stu_cou sc, courses c
    where st.courseid = sc.courseid 
    and sc.courseid = c.courseid
    and c.name = 'Physics'
    and st.secterm = 'Fall'
    and st.secyear = '2010'; 

-- 7) Assume you have a professor name Donald Duck, what courses did he teach in Summer 2010?
select c.name from section st, tea_cou tc, courses c, teachers t
    where st.courseid = tc.courseid and c.courseid = tc.courseid and t.teacherid = tc.teacherid
    and st.secterm = 'Summer'
    and st.secyear = '2010'
    and t.fname ='Donald'
    and t.lname ='Duck' 

-- 8) What courses has Minnie Mouse taken with Donald Duck as the professor?
select c.name from students s, courses c, teachers t, tea_cou tc, stu_cou sc
where tc.teacherid = t.teacherid and c.courseid = sc.courseid and sc.studentid = s.studentid
	and t.fname = 'Donald'
	and t.lname = 'Duck'
	and s.fname = 'Minnie'
	and s.lname ='Mouse'
   group by c.courseid



-- 9) Assume that Snow White is both a student and a teacher. What classes has Snow White and Minnie Mouse taken together as students?
select c.name from courses c, students s, stu_cou sc
where  sc.courseid = c.courseid and sc.studentid = s.studentid	
     and (( s.fname = 'Snow'
	and s.lname = 'White')
	or ( s.fname = 'Minnie'
	and s.lname = 'Mouse'))
 group by c.courseid
having count(s.studentid) = 2;


-- 10) What classes has Snow White taught that Minnie Mouse has attended?
select c.name from students s, courses c, teachers t, tea_cou tc, stu_cou sc
where tc.teacherid = t.teacherid and c.courseid = sc.courseid and sc.studentid = s.studentid
	and t.fname = 'Snow'
	and t.lname = 'White'
	


select * from teachers t, courses c, tea_cou tc
where tc.teacherid = t.teacherid and tc.courseid = c.courseid
and t.fname = 'Snow'
	and t.lname = 'White'


select c.name from teachers t, courses c, tea_cou tc, stu_cou sc, students s
where tc.teacherid = t.teacherid and tc.courseid = c.courseid and sc.studentid = s.studentid 
and t.fname = 'Snow'
	and t.lname = 'White'
	and s.fname = 'Minnie'
	and s.lname ='Mouse'



-- 11) What classes have been taught by both Donald Duck and Snow White?
select c.coursenumber, c.name from courses c, teachers t, tea_cou tc
where  t.teacherid = tc.teacherid and tc.courseid = c.courseid	
     and (( t.fname = 'Snow'
	and t.lname = 'White')
	or ( t.fname = 'Donald'
	and t.lname = 'Duck'))
 group by c.courseid
having count(t.teacherid) = 2;


select c.coursenumber, c.name from courses c, teachers t, tea_cou tc
where  t.teacherid = tc.teacherid and tc.courseid = c.courseid	
     and t.fname = 'Snow'
	and t.lname = 'White'

-- 12) Assume that Mickey Mouse has taken Data Structures & Algorithms several times, Spring 2010 for a C-, Summer 2010 for a B+, 
-- and Fall 2010 for a A-, and Winter 2010 for an A. What was his highest grade for Data Structure and Algorithms and what term was that in?
select top 1 sc.score from section st, stu_cou sc, students s, courses c 
    where  sc.studentid = s.studentid and sc.courseid = c.courseid and sc.secid = st.secid
	and s.fname = 'Mickey'
	and s.lname ='Mouse'
	and c.coursenumber = 'CS223';


-- 13) How many classes did Snow White take in 2010?
select * from courses c, students s, section st, stu_cou sc
where c.courseid = st.courseid and s.studentid = sc.studentid and sc.courseid  = c.courseid
	and st.secyear = '2010'
	and  s.fname = 'Snow'
	and s.lname = 'White'
