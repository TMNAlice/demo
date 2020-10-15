drop database Devices;

CREATE database Devices;

USE Devices;

CREATE TABLE devtab (
   	device_id INTEGER unsigned not null auto_increment,
   	number INTEGER unsigned not null,
   	name VARCHAR (120),
   	primary key (device_id)
   );

CREATE TABLE users (
    users_id INTEGER unsigned not null auto_increment,
   	login VARCHAR (120) not null,
   	pass_hash VARCHAR (256),
   	primary key (users_id)
   );

Insert into devtab (device_id, number, name) values (1, 1, "qwerty");
Insert into devtab (device_id, number, name) values (2, 2, "b2");


Insert into users (login, pass_hash) values ("guest","$2a$10$6mf3CesQx9eRGB4B3sjr8e1eSr5cYO/zt87bwYVdA4O8rmjDMDdHO");
--login guest password hello