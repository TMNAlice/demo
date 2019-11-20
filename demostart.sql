drop database Devices;

CREATE database Devices;

USE Devices;

CREATE TABLE devtab (
	device_id INTEGER unsigned not null auto_increment,
	number INTEGER unsigned not null,
	name VARCHAR (120),
	primary key (device_id)
);

CREATE TABLE  (
	device_id INTEGER unsigned not null auto_increment,
	number INTEGER unsigned not null,
	name VARCHAR (120),
	primary key (device_id)
);

Insert into devtab (number, name) values (1, "qwerty");
Insert into devtab (number, name) values (2, "b2");

--login guest password hello
insert into "user"("login", "pass_hash") values ('guest','$2a$10$6mf3CesQx9eRGB4B3sjr8e1eSr5cYO/zt87bwYVdA4O8rmjDMDdHO');
