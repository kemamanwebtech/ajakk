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
  AJAKK_USER_ID      int        not null                comment 'Identifies the user of the login, Unique ID, primary key',                          
  ACCESS_PASS       varchar(41) not null                comment 'Encrypted password',
  LAST_ACCESS       datetime                            comment 'Data and the time the access path was last used sucessfully',
  LOGIN_FAILS       int         not null default 0      comment 'Number of failed login tries',
  CREATED           TIMESTAMP    not null default CURRENT_TIMESTAMP  comment 'Creation date of the credentials',
  PASS_CHANGED      datetime                            comment 'Last change to the password',
  LOCKED            tinyint(1)  not null default 0      comment 'Flag if the credentials are locked',
  constraint   PK_AJAKK_PASS primary key (AJAKK_USER_ID)
)
comment = 'Credentials of Ajakk users.';

-- insert dummy data
INSERT INTO AJAKK_PASS 
(AJAKK_USER_ID, ACCESS_PASS)
VALUES 
(1, "password"),
(2, "password"),
(3, "password"),
(4, "password"),
(5, "password");
