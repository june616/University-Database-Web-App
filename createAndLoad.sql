CREATE SCHEMA IF NOT EXISTS UniversityApplication;
USE UniversityApplication;

# ranking
DROP TABLE IF EXISTS CwruRanking;
DROP TABLE IF EXISTS ShanghaiRanking;
DROP TABLE IF EXISTS TimesRanking;
DROP TABLE IF EXISTS USNewsHistoricalRanking;

# school info

DROP TABLE IF EXISTS CIP;
DROP TABLE IF EXISTS DegreeLevel;
DROP TABLE IF EXISTS Degree;
DROP TABLE IF EXISTS Campus;


#person info
DROP TABLE IF EXISTS Collections;
DROP TABLE IF EXISTS Ratings;
DROP TABLE IF EXISTS CommentsLike;
DROP TABLE IF EXISTS Comments;
DROP TABLE IF EXISTS Reservations;

#person
DROP TABLE IF EXISTS Applicants;
DROP TABLE IF EXISTS Counselors;
DROP TABLE IF EXISTS Administrators;
DROP TABLE IF EXISTS Persons;

#school 
DROP TABLE IF EXISTS Universities;
DROP TABLE IF EXISTS States;

CREATE TABLE States(
PostalAbbreviation VARCHAR(255) NOT NULL,
LargestCity VARCHAR(255),
Capital VARCHAR(255),
StateName VARCHAR(255) NOT NULL,
Population INT,
TotalAreaSquareMiles INT,
PerCapitaPersonalIncome INT,
CONSTRAINT pk_States_PostalAbbreviation PRIMARY KEY(PostalAbbreviation)
);

LOAD DATA LOCAL INFILE '/Users/cxysmacbookair/eclipse-workspace/HigherEducationSearchAndMatch/Dataset-cleaned/states.csv' INTO TABLE States
 FIELDS TERMINATED BY ',' ENCLOSED BY ""
 LINES TERMINATED BY '\n'
 IGNORE 1 LINES;
CREATE TABLE Universities (
	UNITID INT,
	OPEID INT,
	OPEID6 INT,
	INSTNM LONGTEXT,
	CITY VARCHAR(255),
	STABBR VARCHAR(255),
	ZIP VARCHAR(255),
	ACCREDAGENCY VARCHAR(255),
	INSTURL VARCHAR(255),
	NPCURL VARCHAR(255),
	NUMBRANCH INT,
	CONTROL INT,
	LATITUDE FLOAT,
	LONGITUDE FLOAT,
	ADM_RATE FLOAT,
	ADM_RATE_ALL FLOAT,
	SATVR25 INT,
	SATVR75 INT,
	SATMT25 INT,
	SATMT75 INT,
	SATWR25 INT,
	SATWR75 INT,
	SATVRMID INT,
	SATMTMID INT,
	SATWRMID INT,
	ACTCM25 INT,
	ACTCM75 INT,
	ACTEN25 INT,
	ACTEN75 INT,
	ACTMT25 INT,
	ACTMT75 INT,
	ACTWR25 INT,
	ACTWR75 INT,
	ACTCMMID INT,
	ACTENMID INT,
	ACTMTMID INT,
	ACTWRMID INT,
	SAT_AVG_ALL INT,
	UGDS INT,
	PPTUG_EF FLOAT,
	CURROPER INT,
	TUITIONFEE_IN INT,
	TUITIONFEE_OUT INT,
	TUITIONFEE_PROG INT,
	PFTFAC FLOAT,
	MN_EARN_WNE_P6 INT,
	MD_EARN_WNE_P6 INT,
	MN_EARN_WNE_P7 INT,
	MN_EARN_WNE_P8 INT,
	MD_EARN_WNE_P8 INT,
	MN_EARN_WNE_P9 INT,
    MN_EARN_WNE_P10 INT,
	MD_EARN_WNE_P10 INT,

    CONSTRAINT pk_Universities_UNITID PRIMARY KEY (UNITID),
	CONSTRAINT fk_Universities_STABBR
    FOREIGN KEY (STABBR)
    REFERENCES  States(PostalAbbreviation)
    ON UPDATE CASCADE ON DELETE CASCADE
);

LOAD DATA LOCAL INFILE '/Users/cxysmacbookair/eclipse-workspace/HigherEducationSearchAndMatch/Dataset-cleaned/university.csv'
  INTO TABLE Universities 
  FIELDS TERMINATED BY ',' 
  LINES TERMINATED BY '\n'
  IGNORE 1 LINES;


CREATE TABLE CIP (
  CIPCODE VARCHAR(255),
  CIPTitle VARCHAR(255) ,
  CIPDefinition LONGTEXT,
  CONSTRAINT pk_CIP_CIPCODE PRIMARY KEY (CIPCODE)
);

LOAD DATA LOCAL INFILE '/Users/cxysmacbookair/eclipse-workspace/HigherEducationSearchAndMatch/Dataset-cleaned/CIP.csv'
  INTO TABLE CIP 
  FIELDS TERMINATED BY ',' 
  LINES TERMINATED BY '\n'
  IGNORE 1 LINES
  (CIPCODE,CIPTitle,CIPDefinition);
  
CREATE TABLE DegreeLevel (
  CREDLEV VARCHAR(255),
  CREDDESC LONGTEXT,
  CONSTRAINT pk_DegreeLevel_CREDLEV PRIMARY KEY (CREDLEV)
);

LOAD DATA LOCAL INFILE '/Users/cxysmacbookair/eclipse-workspace/HigherEducationSearchAndMatch/Dataset-cleaned/DegreeLevel.csv'
  INTO TABLE DegreeLevel 
  FIELDS TERMINATED BY ',' 
  LINES TERMINATED BY '\n'
  IGNORE 1 LINES
  (CREDLEV,CREDDESC);

CREATE TABLE Degree (
  degree_id INT auto_increment,
  UNITID INT ,
  CIPCODE VARCHAR(255),
  CREDLEV LONGTEXT,
  CONSTRAINT pk_Degree_degree_id PRIMARY KEY (degree_id),
  CONSTRAINT fk_Degree_UNITID
    FOREIGN KEY (UNITID)
    REFERENCES  Universities(UNITID)
    ON UPDATE CASCADE ON DELETE CASCADE
);
LOAD DATA LOCAL INFILE '/Users/cxysmacbookair/eclipse-workspace/HigherEducationSearchAndMatch/Dataset-cleaned/Degree.csv'
  INTO TABLE Degree 
  FIELDS TERMINATED BY ',' 
  LINES TERMINATED BY '\n'
  IGNORE 1 LINES
  (UNITID, CIPCODE,CREDLEV);

CREATE TABLE Campus (
  DapipId VARCHAR(255),
  UNITID INT ,
  LocationName VARCHAR(255),
  ParentName VARCHAR(255),
  ParentDapipId VARCHAR(255),
  LocationType VARCHAR(255),
  Address LONGTEXT,
  GeneralPhone VARCHAR(255),
  AdminName VARCHAR(255),
  AdminPhone VARCHAR(255),
  AdminEmail VARCHAR(255),
  Fax VARCHAR(255),
  CONSTRAINT pk_Campus_DapipId PRIMARY KEY (DapipId),
  CONSTRAINT fk_Campus_UNITID
    FOREIGN KEY (UNITID)
    REFERENCES  Universities(UNITID)
    ON UPDATE CASCADE ON DELETE CASCADE
);
LOAD DATA LOCAL INFILE '/Users/cxysmacbookair/eclipse-workspace/HigherEducationSearchAndMatch/Dataset-cleaned/Campus.csv'
  INTO TABLE Campus 
  FIELDS TERMINATED BY ',' 
  LINES TERMINATED BY '\n'
  IGNORE 1 LINES
  (DapipId,UNITID,LocationName,ParentName,ParentDapipId,LocationType,Address,GeneralPhone,AdminName,AdminPhone,AdminEmail,Fax);
  
CREATE TABLE Persons (
  PersonId INT,
  UserName VARCHAR(255),
  PassCode VARCHAR(255),
  FirstName VARCHAR(255),
  LastName VARCHAR(255),
  Email VARCHAR(255),
  CONSTRAINT pk_Persons_PersonId PRIMARY KEY (PersonId)
);
LOAD DATA LOCAL INFILE '/Users/cxysmacbookair/eclipse-workspace/HigherEducationSearchAndMatch/Dataset-cleaned/Persons.csv' INTO TABLE Persons
 FIELDS TERMINATED BY ',' ENCLOSED BY ""
 LINES TERMINATED BY '\n'
 IGNORE 1 LINES;
 
CREATE TABLE Administrators (
  PersonId INT,
  LastLogin TIMESTAMP,
  CONSTRAINT pk_Administrators_PersonId
    PRIMARY KEY (PersonId),
  CONSTRAINT fk_Administrators_PersonId
    FOREIGN KEY (PersonId)
    REFERENCES Persons(PersonId)
    ON UPDATE CASCADE ON DELETE CASCADE
);

LOAD DATA LOCAL INFILE '/Users/cxysmacbookair/eclipse-workspace/HigherEducationSearchAndMatch/Dataset-cleaned/Administrators.csv' INTO TABLE Administrators
 FIELDS TERMINATED BY ',' ENCLOSED BY ""
 LINES TERMINATED BY '\n'
 IGNORE 1 LINES;

CREATE TABLE Counselors (
  PersonId INT,
  Gender ENUM('female', 'male', 'unidentified'),
  YearsOfExperience INT,
  AcceptingNewStudent BOOLEAN,
  City VARCHAR(255),
  State VARCHAR(255),
  ZipCode VARCHAR(255),
  RaceEthnicity VARCHAR(255),
  CONSTRAINT pk_Counselors_PersonId
    PRIMARY KEY (PersonId),
  CONSTRAINT fk_Counselors_PersonId
    FOREIGN KEY (PersonId)
    REFERENCES Persons(PersonId)
    ON UPDATE CASCADE ON DELETE CASCADE
);

 LOAD DATA LOCAL INFILE '/Users/cxysmacbookair/eclipse-workspace/HigherEducationSearchAndMatch/Dataset-cleaned/Counselors.csv' INTO TABLE Counselors
 FIELDS TERMINATED BY ',' ENCLOSED BY ""
 LINES TERMINATED BY '\n'
 IGNORE 1 LINES;

CREATE TABLE Applicants (
  PersonId INT,
  Gender ENUM('female', 'male', 'unidentified'),
  DateOfBirth TIMESTAMP,
  SeekingCounselors BOOLEAN,
  HighSchool TEXT,
  City VARCHAR(255),
  State VARCHAR(255),
  ZipCode VARCHAR(255),
  RaceEthnicity VARCHAR(255),
  ParentEduLevel VARCHAR(255),
  CONSTRAINT pk_Applicants_PersonId
    PRIMARY KEY (PersonId),
  CONSTRAINT fk_Applicants_PersonId
    FOREIGN KEY (PersonId)
    REFERENCES Persons(PersonId)
    ON UPDATE CASCADE ON DELETE CASCADE
);

LOAD DATA LOCAL INFILE '/Users/cxysmacbookair/eclipse-workspace/HigherEducationSearchAndMatch/Dataset-cleaned/Applicants.csv' INTO TABLE Applicants
 FIELDS TERMINATED BY ',' ENCLOSED BY ""
 LINES TERMINATED BY '\n'
 IGNORE 1 LINES;

CREATE TABLE Ratings (
	RatingId INT AUTO_INCREMENT,
	RatingValue DECIMAL(2,1),
	PersonId INT, 
	UNITID INT,
    CONSTRAINT pk_Ratings_RatingId PRIMARY KEY (RatingId),
	CONSTRAINT fk_Ratings_UNITID
		FOREIGN KEY (UNITID)
		REFERENCES Universities(UNITID)
		ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT fk_Ratings_PersonId FOREIGN KEY (PersonId) # guess
		REFERENCES Persons(PersonId)
		ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT uq_Ratings UNIQUE (PersonId,UNITID)
);
LOAD DATA LOCAL INFILE '/Users/cxysmacbookair/eclipse-workspace/HigherEducationSearchAndMatch/Dataset-cleaned/rating.csv'
  INTO TABLE Ratings 
  FIELDS TERMINATED BY ',' 
  LINES TERMINATED BY '\n'
  IGNORE 1 LINES
  (RatingValue,PersonId,UNITID);
  
CREATE TABLE Collections (
	CollectionId INT AUTO_INCREMENT,
	PersonId INT, 
	UNITID INT,
	Notes LONGTEXT,
    CONSTRAINT pk_Collections_CollectionId PRIMARY KEY (CollectionId),
	CONSTRAINT fk_Collections_UNITID
		FOREIGN KEY (UNITID)
		REFERENCES Universities(UNITID)
		ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT fk_Collections_PersonId FOREIGN KEY (PersonId) # guess
		REFERENCES Persons(PersonId)
		ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT uq_Collections UNIQUE (PersonId,UNITID)
);

LOAD DATA LOCAL INFILE '/Users/cxysmacbookair/eclipse-workspace/HigherEducationSearchAndMatch/Dataset-cleaned/collection.csv'
  INTO TABLE Collections 
  FIELDS TERMINATED BY ';' 
  LINES TERMINATED BY '\n'
  IGNORE 1 LINES
  (PersonId,UNITID,Notes);

CREATE TABLE Comments (
	commentID INT AUTO_INCREMENT,
    content LONGTEXT,
    createAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNITID INT,
    applicantID INT,
    CONSTRAINT pk_Comments_commentID PRIMARY KEY(commentID),
    CONSTRAINT fk_Comments_UNITID FOREIGN KEY(UNITID)
	REFERENCES Universities(UNITID)
	ON UPDATE CASCADE ON DELETE CASCADE,
     CONSTRAINT fk_Comments_applicantID FOREIGN KEY(applicantID)
	 REFERENCES Persons(PersonId)
	 ON UPDATE CASCADE ON DELETE SET NULL
);
LOAD DATA LOCAL INFILE '/Users/cxysmacbookair/eclipse-workspace/HigherEducationSearchAndMatch/Dataset-cleaned/comments.csv' INTO TABLE Comments
FIELDS TERMINATED BY ';' 
LINES TERMINATED BY '\n'
IGNORE 1 LINES;

CREATE TABLE CommentsLike (
	likeID INT AUTO_INCREMENT,
    createAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PersonID INT,
    commentID INT,
    CONSTRAINT pk_CommentsLike_likeID PRIMARY KEY(likeID),
    CONSTRAINT fk_Commentslike_commentID FOREIGN KEY(commentID)
    REFERENCES Comments(commentID)
    ON UPDATE CASCADE ON DELETE CASCADE,
     CONSTRAINT fk_Commentslike_PersonID FOREIGN KEY(PersonID)
	 REFERENCES Persons(PersonId)
	 ON UPDATE CASCADE ON DELETE SET NULL,
     CONSTRAINT uq_CommentsLike UNIQUE (PersonId,commentId)
);
LOAD DATA LOCAL INFILE '/Users/cxysmacbookair/eclipse-workspace/HigherEducationSearchAndMatch/Dataset-cleaned/commentsLike.csv' INTO TABLE CommentsLike
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\n'
IGNORE 1 LINES;

CREATE TABLE Reservations (
	reservationID INT AUTO_INCREMENT,
    createAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    eventTitle VARCHAR(255),
    eventBegin TIMESTAMP DEFAULT '1970-01-01 00:00:01',
    eventEnd TIMESTAMP DEFAULT '1970-01-01 00:00:01',
    hostID INT,
    participantID INT,
    CONSTRAINT pk_Reservations_reservationID PRIMARY KEY(reservationID),
     CONSTRAINT fk_Reservations_hostID FOREIGN KEY(hostID)
	 REFERENCES Persons(PersonId)
	 ON UPDATE CASCADE ON DELETE CASCADE,
	 CONSTRAINT fk_Reservations_participantID FOREIGN KEY(participantID)
	 REFERENCES Persons(PersonId)
	 ON UPDATE CASCADE ON DELETE CASCADE
);


LOAD DATA LOCAL INFILE '/Users/cxysmacbookair/eclipse-workspace/HigherEducationSearchAndMatch/Dataset-cleaned/reservations.csv' INTO TABLE Reservations
FIELDS TERMINATED BY ';' ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES;


CREATE TABLE CwruRanking
(
CwruEntryID INT AUTO_INCREMENT,
WorldRank INT,
UniversityName VARCHAR(255),
UNITID INT,
EducationQuality INT,
AlumniEmployment INT,
FacultyQuality INT,
Publications INT,
Influence INT,
Citations INT,
Patents INT,
Score DECIMAL(5,2),
Year VARCHAR(255),
CONSTRAINT pk_CwruRanking_CwruEntryID PRIMARY KEY(CwruEntryID),
 CONSTRAINT fk_CwruRanking_UNITID FOREIGN KEY(UNITID)
 REFERENCES Universities(UNITID)
 ON UPDATE CASCADE ON DELETE SET NULL
);
LOAD DATA LOCAL INFILE '/Users/cxysmacbookair/eclipse-workspace/HigherEducationSearchAndMatch/Dataset-cleaned/cwruData.csv' INTO TABLE CwruRanking
FIELDS TERMINATED BY ',' ENCLOSED BY '"'
LINES TERMINATED BY '\n'
(WorldRank,UniversityName,UNITID,EducationQuality,AlumniEmployment,
FacultyQuality,Publications,Influence,Citations,Patents,Score,Year);

CREATE TABLE ShanghaiRanking
(
ShanghaiEntryID INT AUTO_INCREMENT,
WorldRank INT,
UniversityName VARCHAR(255),
UNITID INT,
Score DECIMAL(5,1),
Alumni DECIMAL(5,1),
Award DECIMAL(5,1),
Hici DECIMAL(5,1),
NS DECIMAL(5,1),
Pub DECIMAL(5,1),
Pcp DECIMAL(5,1),
Year VARCHAR(255),
CONSTRAINT pk_ShanghaiRanking_ShanghaiEntryID PRIMARY KEY(ShanghaiEntryID),
 CONSTRAINT fk_ShanghaiRanking_UNITID FOREIGN KEY(UNITID)
 REFERENCES Universities(UNITID)
 ON UPDATE CASCADE ON DELETE SET NULL
);
 LOAD DATA LOCAL INFILE '/Users/cxysmacbookair/eclipse-workspace/HigherEducationSearchAndMatch/Dataset-cleaned/shanghaiData.csv' INTO TABLE ShanghaiRanking
  FIELDS TERMINATED BY ',' ENCLOSED BY '"'
  LINES TERMINATED BY '\n'
  (WorldRank,UniversityName,UNITID,Score,Alumni,Award,Hici,NS,Pub,Pcp,Year);

CREATE TABLE TimesRanking
(
TimesEntryID INT AUTO_INCREMENT,
WorldRank INT,
UniversityName VARCHAR(255),
UNITID INT,
Teaching DECIMAL(5,1),
International DECIMAL(5,1),
Research DECIMAL(5,1),
Citations DECIMAL(5,1),
Income DECIMAL(5,1),
Score DECIMAL(5,1),
StudentNumber INT,
StudentStaffRatio DECIMAL(5,1),
InternationalStudentRatio DECIMAL(5,2),
FemaleStudentRatio DECIMAL(5,2),
Year VARCHAR(255),
CONSTRAINT pk_TimesRanking_TimesEntryID PRIMARY KEY(TimesEntryID),
 CONSTRAINT fk_TimesRanking_UNITID FOREIGN KEY(UNITID)
 REFERENCES Universities(UNITID)
 ON UPDATE CASCADE ON DELETE SET NULL
);
 LOAD DATA LOCAL INFILE '/Users/cxysmacbookair/eclipse-workspace/HigherEducationSearchAndMatch/Dataset-cleaned/timesData.csv' INTO TABLE TimesRanking
  FIELDS TERMINATED BY ',' ENCLOSED BY '"'
  LINES TERMINATED BY '\r\n'
  (WorldRank,UniversityName,UNITID,Teaching,International,Research,Citations,Income,Score,StudentNumber,
  StudentStaffRatio,InternationalStudentRatio,FemaleStudentRatio,Year);
  
CREATE TABLE USNewsHistoricalRanking
(
USNewsEntryID INT AUTO_INCREMENT,
UniversityName VARCHAR(255),
UNITID INT,
State VARCHAR(255),
Rank2022 INT,
Rank2021 INT,
Rank2020 INT,
Rank2019 INT,
Rank2018 INT,
Rank2017 INT,
Rank2016 INT,
Rank2015 INT,
Rank2014 INT,
Rank2013 INT,
CONSTRAINT pk_USNewsHistoricalRanking_USNewsEntryID PRIMARY KEY(USNewsEntryID),
 CONSTRAINT fk_USNewsHistoricalRanking_UNITID FOREIGN KEY(UNITID)
 REFERENCES Universities(UNITID)
 ON UPDATE CASCADE ON DELETE SET NULL
);

 LOAD DATA LOCAL INFILE '/Users/cxysmacbookair/eclipse-workspace/HigherEducationSearchAndMatch/Dataset-cleaned/usnewsHistoricalData.csv' INTO TABLE USNewsHistoricalRanking
  FIELDS TERMINATED BY ',' ENCLOSED BY '"'
  LINES TERMINATED BY '\r\n'
  IGNORE 1 LINES
  (UniversityName,UNITID,State,Rank2022,Rank2021,Rank2020,Rank2019,
  Rank2018,Rank2017,Rank2016,Rank2015,Rank2014,Rank2013);

