-- ------------------------------------------------------------------------
-- Abstract:     ajakk: create table PATCH
-- Version info: $Revision:  $
-- Copyright:    KWT
--
-- Description:
-- Table PATCH - list of all applied patches to ajakk database
--
-- Restrictions: n/a
--

use ajakk;

drop table if exists PATCH;

create table PATCH (
  PATCH_ID    int           not null auto_increment             comment 'Unique ID, primary key',
  FILE_NAME   varchar(64)   not null                            comment 'Exact file name of this patch',
  DES         varchar(256)  not null                            comment 'Mandatory description for the patch',
  APPLIED     TIMESTAMP     not null default CURRENT_TIMESTAMP  comment 'Applied date of this patch',
  constraint PK_PATCH primary key (PATCH_ID)
)
comment = 'List of all ajakk db patches';