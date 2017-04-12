-- ------------------------------------------------------------------------
-- Abstract:     ajakk: sample format for patch files
-- Version info: $Revision:  $
-- Copyright:    KWT
--
-- Description:
-- All patch scripts should use the following format
--
-- Restrictions: n/a
--

use ajakk;

-- This is a mandatory insertion to table PATCH. This is to make sure the patches are recorded 
INSERT INTO PATCH 
( FILE_NAME, DES )
	VALUES
( 'patch_000.sql', 'Added sample format for patch script' );


-- From here on, this should be your actual patch script
-- for example, 
-- ALTER TABLE VENUE
-- ADD VENUE_RATING varchar(256) 	comment 'Average rating of this venue',
-- AFTER VENUE_NAME;