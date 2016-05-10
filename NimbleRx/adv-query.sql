--How many undergraduate students are there in 11.521? Who are they?
select count(*)
  from students s, stu_cou sc, courses c
 where s.studentid=sc.studentid and c.courseid=sc.courseid
   and s.year<=4
   and c.courseid=100100;

   select s.fname, s.lname, c.coursenumber, c.name
  from students s, stu_cou sc, courses c
 where s.studentid=sc.studentid and c.courseid=sc.courseid
   and s.year<=4
   and c.courseid=100100;


 --  What (high-level) classes does Joe Ferreira instruct?
 select t.fname, t.lname, c.coursenumber, c.name
  from teachers t, tea_cou tc, courses c
 where t.teacherid=tc.teacherid and c.courseid=tc.courseid
   and t.fname='Joe' and t.lname='Ferreira';

select t.fname, t.lname, c.coursenumber, c.name
  from teachers t, tea_cou tc, courses c
 where t.teacherid=tc.teacherid and c.courseid=tc.courseid
   and t.fname='Joe' and t.lname='Ferreira'
   and c.courselevel='high';
    
-- Which course has more than two instructors?
 select c.courseid, c.coursenumber, c.name, count(t.teacherid) intructors
  from teachers t, tea_cou tc, courses c
 where t.teacherid=tc.teacherid and c.courseid=tc.courseid
 group by c.courseid, c.coursenumber, c.name
having count(t.teacherid)>=2;