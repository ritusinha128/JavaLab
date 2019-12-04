DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS subject;
DROP TABLE IF EXISTS marks;

CREATE TABLE student (
  USN VARCHAR(10) NOT NULL PRIMARY KEY,
  Name VARCHAR(100) NOT NULL,
  Category VARCHAR(20),
  City VARCHAR(20),
  Branch VARCHAR(10),
  Sem int,
  Gender VARCHAR(4),
  DOB VARCHAR(10)
);

CREATE TABLE subject (
 Code VARCHAR(5) NOT NULL PRIMARY KEY,
 Sub_Name VARCHAR(20), 
 Sub_sem int,
 Credits int
);


CREATE TABLE marks (
 Student_USN VARCHAR(10) NOT NULL,
 Sub_code VARCHAR(5) NOT NULL,
 Grade VARCHAR(2),
 Sem int
);