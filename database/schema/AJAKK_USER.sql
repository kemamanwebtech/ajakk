
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
  PHONE_NO          int                                 comment 'User phone number',
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
  UPDATED           timestamp      comment 'Last update to the user',
  SUSPENDED         datetime                            comment 'Date and time until which the user is suspended (due to invalid data entry in UMB)',
  DES               varchar(256)                        comment 'Optional description for the user',

  constraint PK_AJAKK_USER primary key (AJAKK_USER_ID)
)
comment = 'Basic data of a AJAKK user';

-- insert dummy users
INSERT INTO AJAKK_USER 
(USER_NAME, STATUS, UPDATED, ROLE_ID)
VALUES
("acive", "Active", NOW(), 0),
("blocked", "Blocked", NOW(), 0),
("locked", "Locked", NOW(), 0),
("deleted", "Deleted", NOW(), 0),
("nonactive", "NotActive", NOW(), 0);

