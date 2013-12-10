create database if not exists testws;

use testws;

drop table if exists PERSON;

create table PERSON (
    ID int unsigned not null auto_increment,
    FULL_NAME varchar(255) not null,
    AGE int unsigned not null,
    primary key (ID)
);

insert into PERSON (FULL_NAME, AGE)
values ('Scala Johanson', 24);
insert into PERSON (FULL_NAME, AGE)
values ('Mona Lisa Harddrive', 47);
insert into PERSON (FULL_NAME, AGE)
values ('William Windows', 49);
insert into PERSON (FULL_NAME, AGE)
values ('Lenny Linux', 8);
insert into PERSON (FULL_NAME, AGE)
values ('Eddie Larrison', 22);
	

