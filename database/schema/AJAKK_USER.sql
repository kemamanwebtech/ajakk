
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
  STATUS            enum(
  	'NotActive',  
  	'Active',
    'Blocked',
    'Locked'
  )                             not null                comment 'Status of the user: Active, Blocked by admin or Locked due to login failures',
  -- LANGUAGE_ID       int         not null                comment 'Preferred language of the user',
  ROLE_ID           int         not null                comment 'Role assigned to the user',
  CREATED           datetime    not null default now()  comment 'Creation date of the user',
  UPDATED           datetime    not null default now()  comment 'Last update to the user',
  SUSPENDED         datetime                            comment 'Date and time until which the user is suspended (due to invalid data entry in UMB)',
  DES               varchar(256)                        comment 'Optional description for the user',

  constraint PK_AJAKK_USER primary key (AJAKK_USER_ID)
)
comment = 'Basic data of a AJAKK user';