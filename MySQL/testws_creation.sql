create database if not exists testws;

use testws;

drop table if exists FOLLOWERS;

drop table if exists PERSON;

drop table if exists LOCATION;



create table LOCATION (
    ID int unsigned not null auto_increment,
    LOCATION_NAME varchar(255) not null,
    LOCATION_COORDINATE int unsigned not null,
    primary key (ID)
);

insert into LOCATION (LOCATION_NAME, LOCATION_COORDINATE)
values ('CAN CAFE', 241239);
insert into LOCATION (LOCATION_NAME, LOCATION_COORDINATE)
values ('CADU', 4723432);
insert into LOCATION (LOCATION_NAME, LOCATION_COORDINATE)
values ('KENNEDYS', 492314);
insert into LOCATION (LOCATION_NAME, LOCATION_COORDINATE)
values ('SHAMROCK', 8123432);
insert into LOCATION (LOCATION_NAME, LOCATION_COORDINATE)
values ('KILLIANS', 2212342);



create table PERSON (
    ID int unsigned not null auto_increment,
    FULL_NAME varchar(255) not null,
    AGE int unsigned not null,
    USER_LOCATION int unsigned,
    FOREIGN KEY (USER_LOCATION) REFERENCES LOCATION (ID),
    primary key (ID)
);

insert into PERSON (FULL_NAME, AGE, USER_LOCATION)
values ('Scala Johanson', 24, 2);
insert into PERSON (FULL_NAME, AGE, USER_LOCATION)
values ('Mona Lisa Harddrive', 47, 3);
insert into PERSON (FULL_NAME, AGE, USER_LOCATION)
values ('William Windows', 49, 5);
insert into PERSON (FULL_NAME, AGE, USER_LOCATION)
values ('Lenny Linux', 8, 3);
insert into PERSON (FULL_NAME, AGE)
values ('Eddie Larrison', 22);


CREATE TABLE FOLLOWERS(
  follow_id int not null primary key AUTO_INCREMENT,
  followedID int unsigned not null,  
  followerID int unsigned not null,  
  FOREIGN KEY (followedID) REFERENCES PERSON (ID),
  FOREIGN KEY (followerID) REFERENCES PERSON (ID)
);

insert into FOLLOWERS (followedID, followerID)
values (1, 2);
insert into FOLLOWERS (followedID, followerID)
values (1, 3);
insert into FOLLOWERS (followedID, followerID)
values (2, 1);
insert into FOLLOWERS (followedID, followerID)
values (2, 3);
insert into FOLLOWERS (followedID, followerID)
values (3, 5);



