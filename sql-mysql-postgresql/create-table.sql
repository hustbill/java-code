CREATE TABLE Employee (
  Id int NOT NULL,
  Name VARCHAR(20), 
  Salary int,
  ManageId int
);

INSERT INTO Employee 
(Id, Name, Salary, ManageId)
values(1, 'Tom', 100, 3),  (2, 'Jacky', 200, 4), (3, 'Alice', 500, NULL), (4, 'Dan', 650, NULL);

SELECT * FROM Employee;

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      select DISTINCT Salary from Employee order by Salary desc Limit N, 1
    );
END

CREATE OR REPLACE FUNCTION increment(i integer) RETURNS integer AS $$
        BEGIN
                RETURN i + 1;
        END;
$$ LANGUAGE plpgsql;

  select id, getNthHighestSalary(2) from Employee;

