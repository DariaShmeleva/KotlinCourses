CREATE TABLE toys
( id INT serial PRIMARY KEY ,
name VARCHAR(50) UNIQUE ,
type VARCHAR(50)        ,
price INT
);