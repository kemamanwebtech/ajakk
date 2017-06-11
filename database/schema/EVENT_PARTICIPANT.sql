-- ------------------------------------------------------------------------
-- Abstract:     ajakk: create table EVENT_PARTICIPANT
-- Version info: $Revision: 825 $
-- Copyright:    KWT
--
-- Description:
--  o ...
--
-- Restrictions: n/a
--

use ajakk;

drop table if exists EVENT_PARTICIPANT;

create table EVENT_PARTICIPANT (
  EVENT_ID          int         not null                comment 'Event ID',
  AJAKK_USER_ID     int         not null                comment 'User ID',
  NAME              varchar(64)                         comment 'Event name',
  DES               varchar(256)                        comment 'Optional description for the event',
  STATUS            enum(
    'Maybe',
    'NotAttending',
    'Attending'
  )                             not null                comment 'Status of the event: Maybe, NotAttending, Attending',
  CREATED           timestamp    not null default now()  comment 'Creation date of the event',
  UPDATED           datetime                            comment 'Last update to the event',
  
  constraint PK_EVENT_PARTICIPANT primary key (EVENT_ID, AJAKK_USER_ID)
)
comment = 'Basic data of AJAKK event participants';
