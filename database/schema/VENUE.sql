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

drop table if exists EVENT;

CREATE TABLE VENUE (
	VENUE_ID INT NOT NULL AUTO_INCREMENT 		comment 'Unique ID of the venue',
	OWNER_NAME varchar(100) NOT NULL			comment 'Name of the owner of the venue',
	OWNER_HP INT NOT NULL						comment 'Phone contact number of the venue',
	PAYMENT_DETAILS varchar(100)				comment 'Payment info for this venue',
	VENUE_RATE varchar(300) 					comment 'Rental rate of this venue',
	LOCATION varchar(100) NOT NULL				comment 'Location of the venue - what it is called',
	LOC_GPS varchar(100) NOT NULL,
	LOC_ADDRESS varchar(100) NOT NULL			comment 'Full address of the venue',
	VENUE_PHOTO varchar(100) ,
	VENUE_DES varchar(500) ,
	VENUE_NAME varchar(50) NOT NULL,	

	PRIMARY KEY (VENUE_ID)
) 
ENGINE=InnoDB
DEFAULT CHARSET=latin1
COLLATE=latin1_swedish_ci;

-- INSERT INTO VENUE (VENUE_ID, OWNER_NAME, OWNER_HP, PAYMENT_DETAILS, VENUE_RATE, LOCATION, LOC_GPS, LOC_ADDRESS, VENUE_PHOTO, VENUE_DES, VENUE_NAME) VALUES 
-- (1,'BOSS', 011221, 'BLABLA', 'BLABLABLA', 'MALAYSIA', '20505050', '81222 JAANAL', 'IMG/AS.PNG', 'BLABLA', 'KLCC');

