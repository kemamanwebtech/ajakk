-- MySQL dump 10.13  Distrib 5.6.36, for linux-glibc2.5 (x86_64)
--
-- Host: localhost    Database: ajakk
-- ------------------------------------------------------
-- Server version	5.6.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `AJAKK_PASS`
--

DROP TABLE IF EXISTS `AJAKK_PASS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AJAKK_PASS` (
  `AJAKK_USER_ID` int(11) NOT NULL COMMENT 'Identifies the user of the login, Unique ID, primary key',
  `ACCESS_PASS` varchar(41) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Encrypted password',
  `LAST_ACCESS` datetime DEFAULT NULL COMMENT 'Data and the time the access path was last used sucessfully',
  `LOGIN_FAILS` int(11) NOT NULL DEFAULT '0' COMMENT 'Number of failed login tries',
  `CREATED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Creation date of the credentials',
  `PASS_CHANGED` datetime DEFAULT NULL COMMENT 'Last change to the password',
  `LOCKED` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'Flag if the credentials are locked'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Credentials of Ajakk users.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AJAKK_PASS`
--

LOCK TABLES `AJAKK_PASS` WRITE;
/*!40000 ALTER TABLE `AJAKK_PASS` DISABLE KEYS */;
INSERT INTO `AJAKK_PASS` VALUES (23,'password',NULL,0,'2017-07-22 05:43:10',NULL,0);
/*!40000 ALTER TABLE `AJAKK_PASS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `AJAKK_USER`
--

DROP TABLE IF EXISTS `AJAKK_USER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AJAKK_USER` (
  `AJAKK_USER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Unique ID, primary key',
  `USER_NAME` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Username for login & display, not the actual user name',
  `EMAIl` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'User email',
  `PHONE_NO` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'User phone number',
  `SPORT` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LOCATION` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'user home location',
  `STATUS` enum('NotActive','Active','Blocked','Locked','Deleted') COLLATE utf8_unicode_ci NOT NULL COMMENT 'Status of the user: Active, Blocked by admin or Locked due to login failures',
  `ROLE_ID` int(11) NOT NULL COMMENT 'Role assigned to the user',
  `CREATED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Creation date of the user',
  `UPDATED` datetime DEFAULT NULL COMMENT 'Last update to the user',
  `SUSPENDED` datetime DEFAULT NULL COMMENT 'Date and time until which the user is suspended (due to invalid data entry in UMB)',
  `DES` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Optional description for the user',
  PRIMARY KEY (`AJAKK_USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Basic data of a AJAKK user';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AJAKK_USER`
--

LOCK TABLES `AJAKK_USER` WRITE;
/*!40000 ALTER TABLE `AJAKK_USER` DISABLE KEYS */;
INSERT INTO `AJAKK_USER` VALUES (1,'raf','m@gmail.com','019',NULL,'Kemaman','Active',0,'2017-07-19 15:57:55',NULL,NULL,NULL),(2,'Raf','mrafsyam@gmail.com','019',NULL,'Trg','Active',0,'2017-07-19 16:02:19',NULL,NULL,NULL),(3,'Halo','m@gmail.com','019',NULL,'Trg','Active',0,'2017-07-19 16:03:04',NULL,NULL,NULL),(4,'Raf','m1@gmail.com','11',NULL,'Trg','Active',0,'2017-07-20 01:46:36',NULL,NULL,NULL),(5,'m2','m2@gmail.com','019',NULL,'Cyber','Active',0,'2017-07-20 12:07:01',NULL,NULL,NULL),(6,'m3','m3@gmail.com','019',NULL,'Trg','Active',0,'2017-07-20 12:07:54',NULL,NULL,NULL),(7,'m4','m4@gmail.com','019',NULL,'Kemaman','Active',0,'2017-07-20 12:09:12',NULL,NULL,NULL),(8,'m5','m5@gmail.com','019',NULL,'kemaman','Active',0,'2017-07-20 12:12:01',NULL,NULL,NULL),(9,'m6','m6@gmail.com','019',NULL,'trg','Active',0,'2017-07-20 12:43:15',NULL,NULL,NULL),(10,'m7','m7@gmail.com','11',NULL,'trg','Active',0,'2017-07-20 12:46:57',NULL,NULL,NULL),(11,'m7','m7@gmail.com','11',NULL,'Trg','Active',0,'2017-07-20 12:49:21',NULL,NULL,NULL),(12,'m9','m9@gmail.com','011',NULL,'Trg','Active',0,'2017-07-20 12:58:59',NULL,NULL,NULL),(13,'Wan','m11@gmail.com','019',NULL,'Cyb','Active',0,'2017-07-22 04:37:16',NULL,NULL,NULL),(14,'Wan','m12@gmail.com','019',NULL,'Cyb','Active',0,'2017-07-22 04:41:55',NULL,NULL,NULL),(15,'Nadhir','m13@gmail.com','019',NULL,'Kemaman','Active',0,'2017-07-22 04:45:16',NULL,NULL,NULL),(16,'Nadhir','m13@gmail.com','019',NULL,'Cyb','Active',0,'2017-07-22 04:46:28',NULL,NULL,NULL),(17,'Awan','m14@gmail.com','019',NULL,'Kemaman','Active',0,'2017-07-22 04:47:40',NULL,NULL,NULL),(18,'Kea','m15@gmail.com','019',NULL,'asdasdasd','Active',0,'2017-07-22 04:49:17',NULL,NULL,NULL),(19,'asdsad','m16@gmail.com','111',NULL,'sdasda','Active',0,'2017-07-22 04:51:43',NULL,NULL,NULL),(20,'dasd','m17@gmail.com','2323',NULL,'asdas','Active',0,'2017-07-22 04:52:57',NULL,NULL,NULL),(21,'dasd','m18@gmail.com','019',NULL,'kemaman','Active',0,'2017-07-22 04:54:23',NULL,NULL,NULL),(22,'asdas','m19@gmail.com','019',NULL,'kemaman','Active',0,'2017-07-22 04:56:02',NULL,NULL,NULL),(23,'DASD','mrafsyam@gmail.com','09090',NULL,'assdada','Active',0,'2017-07-22 05:43:10',NULL,NULL,NULL);
/*!40000 ALTER TABLE `AJAKK_USER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EVENT`
--

DROP TABLE IF EXISTS `EVENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EVENT` (
  `EVENT_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Unique ID, primary key',
  `NAME` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Event name',
  `DES` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Optional description for the event',
  `TYPE` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Event type',
  `STATUS` enum('InActive','Active','Completed','Cancelled') COLLATE utf8_unicode_ci NOT NULL COMMENT 'Status of the event: InActive, Active, Completed or Cancelled',
  `OWNER_ID` int(11) NOT NULL COMMENT 'Owner of the event',
  `SECOND_OWNER_ID` int(11) DEFAULT NULL COMMENT 'Second owner of the event',
  `CREATED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Creation date of the event',
  `UPDATED` datetime DEFAULT NULL COMMENT 'Last update to the event',
  `CONFIRMED_DATE` datetime DEFAULT NULL COMMENT 'Date and time of the event',
  `VENUE_ID` int(11) DEFAULT NULL COMMENT 'location of the event (ID)',
  `LOC` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'location of the event (User Input)',
  `LOOKING_FOR` int(11) NOT NULL COMMENT 'No of participants needed',
  PRIMARY KEY (`EVENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Basic data of a AJAKK event';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EVENT`
--

LOCK TABLES `EVENT` WRITE;
/*!40000 ALTER TABLE `EVENT` DISABLE KEYS */;
INSERT INTO `EVENT` VALUES (9,'asdd',NULL,'Basketball','InActive',9,NULL,'2017-06-11 22:11:24',NULL,'2017-06-01 05:26:00',NULL,'Subang'),(10,'cxvxv',NULL,'Futsal','InActive',9,NULL,'2017-06-11 22:11:50',NULL,'2017-06-06 07:35:00',NULL,'Futsal'),(11,'Main2 saja',NULL,'Futsal','InActive',9,NULL,'2017-06-12 03:57:07',NULL,'2017-06-02 05:25:00',NULL,'KL'),(12,'Makan2',NULL,'Volunteer','InActive',9,NULL,'2017-06-12 20:05:33',NULL,'2017-06-28 06:35:00',NULL,'Cyberjaya'),(13,'buat lawak',NULL,'Volunteer','InActive',9,NULL,'2017-06-12 20:14:09',NULL,'2017-06-20 06:31:00',NULL,'Puchong'),(14,'tgk harimau',NULL,'Futsal','InActive',9,NULL,'2017-06-12 20:33:34',NULL,'2017-06-15 06:29:00',NULL,'Cyberjaya'),(15,'Makan2',NULL,'Futsal','InActive',9,NULL,'2017-06-15 22:08:21',NULL,'2017-06-01 08:39:00',NULL,'KL'),(16,'asdasd',NULL,'Futsal','InActive',9,NULL,'2017-06-15 22:09:15',NULL,'2017-06-02 05:25:00',NULL,'Puchong'),(17,'asdasdasdas',NULL,'Volunteer','InActive',9,NULL,'2017-06-15 22:09:51',NULL,'2017-06-02 07:42:00',NULL,'KL'),(18,'asdasd',NULL,'Basketball','InActive',9,NULL,'2017-06-15 22:10:26',NULL,'2017-06-02 05:25:00',NULL,'Cyberjaya'),(19,'adsdada',NULL,'Volunteer','InActive',9,NULL,'2017-06-15 22:14:55',NULL,'2017-06-01 05:23:00',NULL,'Cyberjaya'),(20,'asdasdasdasd',NULL,'Futsal','InActive',2,NULL,'2017-07-22 05:17:04',NULL,'2017-07-13 18:09:00',NULL,'KL');
/*!40000 ALTER TABLE `EVENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EVENT_PARTICIPANT`
--

DROP TABLE IF EXISTS `EVENT_PARTICIPANT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EVENT_PARTICIPANT` (
  `EVENT_ID` int(11) NOT NULL COMMENT 'Event ID',
  `AJAKK_USER_ID` int(11) NOT NULL COMMENT 'User ID',
  `NAME` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Event name',
  `DES` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Optional description for the event',
  `STATUS` enum('Maybe','NotAttending','Attending') COLLATE utf8_unicode_ci NOT NULL COMMENT 'Status of the event: Maybe, NotAttending, Attending',
  `CREATED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Creation date of the event',
  `UPDATED` datetime DEFAULT NULL COMMENT 'Last update to the event',
  PRIMARY KEY (`EVENT_ID`,`AJAKK_USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Basic data of AJAKK event participants';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EVENT_PARTICIPANT`
--

LOCK TABLES `EVENT_PARTICIPANT` WRITE;
/*!40000 ALTER TABLE `EVENT_PARTICIPANT` DISABLE KEYS */;
INSERT INTO `EVENT_PARTICIPANT` VALUES (3,9,NULL,NULL,'Attending','2017-06-12 05:22:46',NULL),(9,9,NULL,NULL,'Attending','2017-06-13 22:10:05',NULL),(11,2,NULL,NULL,'Attending','2017-07-20 13:02:48',NULL),(11,9,NULL,NULL,'Attending','2017-06-12 05:30:55',NULL),(12,9,NULL,NULL,'Attending','2017-06-13 22:10:26',NULL),(14,9,NULL,NULL,'Attending','2017-06-13 22:10:33',NULL),(16,2,NULL,NULL,'Attending','2017-07-20 13:03:04',NULL),(19,2,NULL,NULL,'Attending','2017-07-20 13:03:14',NULL);
/*!40000 ALTER TABLE `EVENT_PARTICIPANT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PATCH`
--

DROP TABLE IF EXISTS `PATCH`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PATCH` (
  `PATCH_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Unique ID, primary key',
  `FILE_NAME` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Exact file name of this patch',
  `DES` varchar(256) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Mandatory description for the patch',
  `APPLIED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Applied date of this patch',
  PRIMARY KEY (`PATCH_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='List of all ajakk db patches';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PATCH`
--

LOCK TABLES `PATCH` WRITE;
/*!40000 ALTER TABLE `PATCH` DISABLE KEYS */;
/*!40000 ALTER TABLE `PATCH` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RELATIONSHIP`
--

DROP TABLE IF EXISTS `RELATIONSHIP`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RELATIONSHIP` (
  `AJAKK_USER_ID_1` int(11) NOT NULL COMMENT 'User ID of userA',
  `AJAKK_USER_ID_2` int(11) NOT NULL COMMENT 'User ID of userB',
  `STATUS` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT 'relationship status : friend, blocked, not-friend',
  `REQUEST` tinyint(1) NOT NULL COMMENT 'true if friend-request is sent',
  `CREATED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Creation date of the event',
  `UPDATED` datetime DEFAULT NULL COMMENT 'Last update to the event',
  PRIMARY KEY (`AJAKK_USER_ID_1`,`AJAKK_USER_ID_2`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Relationship between user';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RELATIONSHIP`
--

LOCK TABLES `RELATIONSHIP` WRITE;
/*!40000 ALTER TABLE `RELATIONSHIP` DISABLE KEYS */;
/*!40000 ALTER TABLE `RELATIONSHIP` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `VENUE`
--

DROP TABLE IF EXISTS `VENUE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `VENUE` (
  `VENUE_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Unique ID of the venue',
  `OWNER_NAME` varchar(100) NOT NULL COMMENT 'Name of the owner of the venue',
  `OWNER_HP` int(11) NOT NULL COMMENT 'Phone contact number of the venue',
  `PAYMENT_DETAILS` varchar(100) DEFAULT NULL COMMENT 'Payment info for this venue',
  `VENUE_RATE` varchar(300) DEFAULT NULL COMMENT 'Rental rate of this venue',
  `LOCATION` varchar(100) NOT NULL COMMENT 'Location of the venue - what it is called',
  `LOC_GPS` varchar(100) NOT NULL,
  `LOC_ADDRESS` varchar(100) NOT NULL COMMENT 'Full address of the venue',
  `VENUE_PHOTO` varchar(100) DEFAULT NULL,
  `VENUE_DES` varchar(500) DEFAULT NULL,
  `VENUE_NAME` varchar(50) NOT NULL,
  PRIMARY KEY (`VENUE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `VENUE`
--

LOCK TABLES `VENUE` WRITE;
/*!40000 ALTER TABLE `VENUE` DISABLE KEYS */;
/*!40000 ALTER TABLE `VENUE` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-26  1:39:37
