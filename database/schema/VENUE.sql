-- ------------------------------------------------------------------------
-- Abstract:     ajakk: create table VENUE
-- Version info: $Revision: 825 $
-- Copyright:    KWT
--
-- Description:
-- Table VENUE - list all of available venue
--
-- Restrictions: n/a
--

use ajakk;

drop table if exists VENUE;

CREATE TABLE VENUE (
	VENUE_ID INT NOT NULL AUTO_INCREMENT comment 'Unique ID of the venue',
	OWNER_NAME varchar(100) comment 'Name of the owner of the venue',
	OWNER_HP INT comment 'Phone contact number of the venue',
	PAYMENT_DETAILS varchar(100) comment 'Payment info for this venue',
	VENUE_RATE varchar(300) comment 'Rental rate of this venue',
	LOCATION varchar(100) NOT NULL comment 'Area of the venue i.e K. Lumpur, Subang Jaya, Cyberjaya, Puchong',
	LOC_GPS varchar(100) ,
	LOC_ADDRESS varchar(100) comment 'Full address of the venue',
	VENUE_PHOTO varchar(100) ,
	VENUE_DES varchar(500) ,
	VENUE_NAME varchar(50) comment 'Location of the venue - what it is called',
	PRIMARY KEY (VENUE_ID)
);

-- INSERT INTO VENUE (VENUE_ID, OWNER_NAME, OWNER_HP, PAYMENT_DETAILS, VENUE_RATE, LOCATION, LOC_GPS, LOC_ADDRESS, VENUE_PHOTO, VENUE_DES, VENUE_NAME) VALUES 
-- (1,'BOSS', 011221, 'BLABLA', 'BLABLABLA', 'MALAYSIA', '20505050', '81222 JAANAL', 'IMG/AS.PNG', 'BLABLA', 'KLCC');

