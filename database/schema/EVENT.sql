-- ------------------------------------------------------------------------
-- Abstract:     ajakk: create table EVENT
-- Version info: $Revision: 825 $
-- Copyright:    KWT
--
-- Description:
--  o ...
--
-- Restrictions: n/a
--

use ajakk;

drop table if exists EVENT;

create table EVENT (
  EVENT_ID          int         not null auto_increment comment 'Unique ID, primary key',
  NAME              varchar(64) not null                comment 'Event name',
  DES               varchar(256)                        comment 'Optional description for the event',
  STATUS            enum(
    'InActive',
    'Active',
    'Completed',
    'Cancelled'
  )                             not null                comment 'Status of the event: InActive, Active, Completed or Cancelled',
  OWNER_ID          int         not null                comment 'Owner of the event',
  SECOND_OWNER_ID   int                                 comment 'Second owner of the event',
  CREATED           datetime    not null default now()  comment 'Creation date of the event',
  UPDATED           datetime                            comment 'Last update to the event',
  CONFIRMED_DATE    datetime                            comment 'Date and time of the event',
  constraint PK_EVENT primary key (EVENT_ID)
)
comment = 'Basic data of a AJAKK event';