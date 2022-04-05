CREATE TABLE toys
( toy_id serial PRIMARY KEY,
toyname VARCHAR(50) UNIQUE ,
toytype VARCHAR(50)        ,
price INT
);