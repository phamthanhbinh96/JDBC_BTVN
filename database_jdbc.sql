
CREATE TABLE class(
id INT(10) 	NOT NULL,
name VARCHAR(50) NOT NULL,
description VARCHAR(200) NOT NULL,
PRIMARY KEY ( id )
);
 
CREATE TABLE student(
id INT(10) UNIQUE NOT NULL,
name VARCHAR(50) NOT NULL,
class_id INT(10) NOT NULL,
PRIMARY KEY ( id )
);

INSERT INTO class
VALUES
(1,'itlab1','1st class'),
(2,'itlab2','2nd class'),
(3,'itlab3','3rd class'),
(4,'itlab4','4th class');	

INSERT INTO student
VALUES 
(1,'binh', 4),
(2,'a',3),
(3,'b',2),
(4,'c',1);

