-- ------------------------------------------------------------------------
-- Abstract:     ajakk: create table AJAKK_PASS
-- Version info: $Revision: 825 $
-- Copyright:    KWT
--
-- Description:
--  o ...
--
-- Restrictions: n/a
--

use ajakk;

drop table if exists AJAKK_PASS;

create table AJAKK_PASS (
  AJAKK_PASS_ID      int        not null auto_increment comment 'Unique ID, primary key',
  AJAKK_USER_ID      int        not null                comment 'Identifies the user of the login',                          
  ACCESS_NAME       varchar(64) not null                comment 'Login name',
  ACCESS_PASS       varchar(41) not null                comment 'Encrypted password',
  LAST_ACCESS       datetime                            comment 'Data and the time the access path was last used sucessfully',
  LOGIN_FAILS       int         not null default 0      comment 'Number of failed login tries',
  CREATED           datetime    not null default now()  comment 'Creation date of the credentials',
  PASS_CHANGED      datetime                            comment 'Last change to the password',
  LOCKED            tinyint(1)  not null default 0      comment 'Flag if the credentials are locked',
  constraint   PK_AJAKK_PASS primary key (AJAKK_PASS_ID)
)
comment = 'Credentials of Ajakk users.';
