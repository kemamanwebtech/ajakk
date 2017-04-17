-- ------------------------------------------------------------------------
-- Abstract:     ajakk: create table EVENT
-- Version info: $Revision: 825 $
-- Copyright:    KWT
--
-- Description:
-- Table EVENT - list all of events
--
-- Restrictions: n/a
--

use ajakk;

drop table if exists EVENT;

create table EVENT (
  EVENT_ID          int         not null auto_increment comment 'Unique ID, primary key',
  NAME              varchar(64) not null                comment 'Event name',
  DES               varchar(256)                        comment 'Optional description for the event',
  TYPE               varchar(100)                        comment 'Event type',
  STATUS            enum(
    'InActive',
    'Active',
    'Completed',
    'Cancelled'
  )                             not null                comment 'Status of the event: InActive, Active, Completed or Cancelled',
  OWNER_ID          int         not null                comment 'Owner of the event',
  SECOND_OWNER_ID   int                                 comment 'Second owner of the event',
  CREATED           TIMESTAMP   not null default CURRENT_TIMESTAMP  comment 'Creation date of the event',
  UPDATED           datetime                            comment 'Last update to the event',
  CONFIRMED_DATE    datetime                            comment 'Date and time of the event',
  VENUE_ID	    int		                                  comment 'location of the event',
  constraint PK_EVENT primary key (EVENT_ID)
)
comment = 'Basic data of a AJAKK event';

-- Insert into EVENT
-- (NAME, DES, STATUS, OWNER_ID)
-- VALUES
-- ('Futsal at Cyberjaya', 'Play futsal at Cyberjaya la', 'Active', 1 ),
-- ('Futsal at Cyberjaya 1', 'Play futsal at Cyberjaya la 1', 'Active', 1 ),
-- ('Futsal at Cyberjaya 2', 'Play futsal at Cyberjaya la 2', 'Active', 1 ),
-- ('Futsal at Cyberjaya 3', 'Play futsal at Cyberjaya la 3', 'Active', 1 ),
-- ('Futsal at Cyberjaya 4', 'Play futsal at Cyberjaya la 4', 'Active', 1 ),
-- ('Futsal at Cyberjaya 5', 'Play futsal at Cyberjaya la 5', 'Active', 1 ),
-- ('Futsal at Cyberjaya 6', 'Play futsal at Cyberjaya la 6', 'Active', 1 ),
-- ('Futsal at Cyberjaya 7', 'Play futsal at Cyberjaya la 7', 'Active', 1 ),
-- ('Futsal at Cyberjaya 8', 'Play futsal at Cyberjaya la 8', 'Active', 1 ),
-- ('Futsal at Cyberjaya 9', 'Play futsal at Cyberjaya la 9', 'Active', 1 )
