drop database registration-db if exists ;

drop table test_model if exists ;

create database registration-db if not exists

create table test_model
(
  id integer not null AUTO_INCREMENT primary key,
  comments varchar(255)
);


