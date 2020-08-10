drop database registration_db if exists ;


create database registration_db if not exists


drop table if exists document ;
drop table if exists travel_path;
drop table if exists trip;
drop table if exists cab;
drop table if exists user;
drop table if exists profile;
drop table test_model if exists ;


CREATE TABLE `Profile` (
  `profileId` varchar(40),
  `user_photo_id` varchar(38),
  `valid_identity_id` varchar(38),
  `trips` int,
  `rating` int,
  PRIMARY KEY (`profileId`)
);

CREATE TABLE `User` (
  `userid` varchar(40),
  `email` varchar(30),
  `firstName` varchar(30),
  `lastName` varchar(30),
  `phone` varchar(15),
  `password` varchar(20),
  `profileType` int(2),
  `city` varchar(25),
  `profileId` varchar(40),
  PRIMARY KEY (`userid`)
);



CREATE TABLE `Cab` (
  `cabId` varchar(40),
  `cab_number` varchar(20),
  `registration_year` date,
  `cab_type` int,
  `userId` varchar(40),
  PRIMARY KEY (`cabId`)
);


CREATE TABLE `Document` (
  `documentId` varchar(40),
  `document_Type` int,
  `media_type` int,
  `path` varchar(100),
  `Document_for` varchar(2),
  `entity_id` varchar(38),
  PRIMARY KEY (`documentId`)
);


CREATE TABLE `Trip` (
  `tripId` varchar(40),
  `source` varchar(200),
  `destination` varchar(200),
  `status` int,
  `start_time` datetime,
  `end_time` datetime,
  `distance` float,
  `cost` float,
  `driver_rating` int,
  `driver_comment` varchar(500),
  `rider_comment` varchar(500),
  `driverId` varchar(40),
  `cabId` varchar(40),
  PRIMARY KEY (`tripId`)
);


CREATE TABLE `travel_path` (
  `id` varchar(40),
  `lattitude` varchar(15),
  `longitude` varchar(15),
  `tripid` varchar(40),
  PRIMARY KEY (`id`)
);
create table test_model
(
  id integer not null AUTO_INCREMENT primary key,
  comments varchar(255)
);


ALTER TABLE User
ADD CONSTRAINT FK_User_userId
FOREIGN KEY (profileId) REFERENCES Profile(profileId);

ALTER TABLE Cab
ADD CONSTRAINT FK_Cab_cabid
FOREIGN KEY (userId) REFERENCES User(userid);

ALTER TABLE Trip
ADD CONSTRAINT FK_Driverid
FOREIGN KEY (driverId) REFERENCES User(userid);

ALTER TABLE Trip
ADD CONSTRAINT FK_cabid
FOREIGN KEY (cabid) REFERENCES Cab(cabId);

ALTER TABLE travel_path
ADD CONSTRAINT FK_tripid
FOREIGN KEY (tripid) REFERENCES Trip(tripId);



