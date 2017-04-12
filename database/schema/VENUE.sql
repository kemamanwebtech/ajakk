use ajakk;

CREATE TABLE VENUE (
	VENUE_ID INT NOT NULL AUTO_INCREMENT,
	OWNER_NAME varchar(100) NOT NULL,
	OWNER_HP INT NOT NULL,
	PAYMENT_DETAILS varchar(100) NOT NULL,
	VENUE_RATE varchar(300) NOT NULL,
	LOCATION varchar(100) NOT NULL,
	LOC_GPS varchar(100) NOT NULL,
	LOC_ADDRESS varchar(100) NOT NULL,
	VENUE_PHOTO varchar(100) NOT NULL,
	VENUE_DES varchar(500) NOT NULL,
	VENUE_NAME varchar(50) NOT NULL,	

	PRIMARY KEY (VENUE_ID)
) 
ENGINE=InnoDB
DEFAULT CHARSET=latin1
COLLATE=latin1_swedish_ci;

INSERT INTO VENUE (VENUE_ID, OWNER_NAME, OWNER_HP, PAYMENT_DETAILS, VENUE_RATE, LOCATION, LOC_GPS, LOC_ADDRESS, VENUE_PHOTO, VENUE_DES, VENUE_NAME) VALUES 
(1,'BOSS', 011221, 'BLABLA', 'BLABLABLA', 'MALAYSIA', '20505050', '81222 JAANAL', 'IMG/AS.PNG', 'BLABLA', 'KLCC');

