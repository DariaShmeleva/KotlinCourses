CREATE TABLE toys
( toy_id serial PRIMARY KEY,
toyname VARCHAR(50) UNIQUE NOT NULL,
toytype VARCHAR(50)        NOT NULL,
price INT
);

insert into toys (toyname, toytype, price) values ('Molnia', 'car', 2000);
insert into toys (toyname, toytype, price) values ('Korabl', 'radiotoy', 2500);
insert into toys (toyname, toytype, price) values ('Barbie', 'doll', 1500);

select * from toys