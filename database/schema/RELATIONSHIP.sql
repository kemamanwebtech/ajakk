-- ------------------------------------------------------------------------
-- Abstract:     ajakk: create table RELATIONSHIP
-- Version info: $Revision: 825 $
-- Copyright:    KWT
--
-- Description:
--  o ...
--
-- Restrictions: n/a
--

use ajakk;

drop table if exists RELATIONSHIP;

create table RELATIONSHIP (
  AJAKK_USER_ID_1    int         not null        		comment 'User ID of userA',
  AJAKK_USER_ID_2    int         not null           	comment 'User ID of userB',
  STATUS            VARCHAR(50)  not null 				comment 'relationship status : friend, blocked, not-friend',
  REQUEST		    boolean  	 not null 				comment 'true if friend-request is sent',
  CREATED           datetime    not null default now()  comment 'Creation date of the event',
  UPDATED           datetime                            comment 'Last update to the event',
  
  constraint PK_RELATIONSHIP primary key (AJAKK_USER_ID_1, AJAKK_USER_ID_2)
)
comment = 'Relationship between user';