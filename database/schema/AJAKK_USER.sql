
-- ------------------------------------------------------------------------
-- Abstract:     ajakk: create table AJAKK_USER
-- Version info: $Revision: 825 $
-- Copyright:    KWT
--
-- Description:
--  o ...
--
-- Restrictions: n/a
--

use ajakk;

drop table if exists AJAKK_USER;

create table AJAKK_USER (
  AJAKK_USER_ID     int         not null auto_increment comment 'Unique ID, primary key',
  USER_NAME         varchar(64) not null                comment 'Username for login & display, not the actual user name',
  EMAIl             varchar(256)                        comment 'User email',
  PHONE_NO          VARCHAR(20)                         comment 'User phone number',
  SPORT		    VARCHAR(50),
  STATUS            enum(
    'NotActive',  
    'Active',
    'Blocked',
    'Locked',
    'Deleted'
  )                             not null                comment 'Status of the user: Active, Blocked by admin or Locked due to login failures',
  -- LANGUAGE_ID       int         not null                comment 'Preferred language of the user',
  ROLE_ID           int         not null                comment 'Role assigned to the user',
  CREATED           TIMESTAMP    not null default CURRENT_TIMESTAMP  comment 'Creation date of the user',
  UPDATED           DATETIME							comment 'Last update to the user',
  SUSPENDED         datetime                            comment 'Date and time until which the user is suspended (due to invalid data entry in UMB)',
  DES               varchar(256)                        comment 'Optional description for the user',

  constraint PK_AJAKK_USER primary key (AJAKK_USER_ID)
)
comment = 'Basic data of a AJAKK user';

-- insert dummy users
INSERT INTO AJAKK_USER 
(USER_NAME, Email, PHONE_NO, STATUS, UPDATED, ROLE_ID, SPORT)
VALUES
("active", "admin@ajak.com", "1300-88-2525", "Active", NOW(), 0, "BASKETBALL"),
("blocked","admin@ajak.com", "1300-88-2525",  "Blocked", NOW(), 0, "FOOTBALL"),
("locked", "admin@ajak.com", "1300-88-2525",  "Locked", NOW(), 0, "FUTSAL"),
("deleted", "admin@ajak.com", "1300-88-2525",  "Deleted", NOW(), 0, "BASKETBALL"),
("nonactive", "admin@ajak.com", "1300-88-2525",  "NotActive", NOW(), 0, "BASKETBALL");

