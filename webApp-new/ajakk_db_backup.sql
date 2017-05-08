-- MySQL dump 10.13  Distrib 5.7.17, for linux-glibc2.5 (x86_64)
--
-- Host: localhost    Database: ajakk
-- ------------------------------------------------------
-- Server version	5.7.17

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
  `ACCESS_PASS` varchar(41) NOT NULL COMMENT 'Encrypted password',
  `LAST_ACCESS` datetime DEFAULT NULL COMMENT 'Data and the time the access path was last used sucessfully',
  `LOGIN_FAILS` int(11) NOT NULL DEFAULT '0' COMMENT 'Number of failed login tries',
  `CREATED` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Creation date of the credentials',
  `PASS_CHANGED` datetime DEFAULT NULL COMMENT 'Last change to the password',
  `LOCKED` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'Flag if the credentials are locked',
  PRIMARY KEY (`AJAKK_USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Credentials of Ajakk users.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AJAKK_PASS`
--

LOCK TABLES `AJAKK_PASS` WRITE;
/*!40000 ALTER TABLE `AJAKK_PASS` DISABLE KEYS */;
INSERT INTO `AJAKK_PASS` VALUES (0,'',NULL,0,'2017-05-06 03:59:06',NULL,0),(1,'password',NULL,0,'2017-03-06 09:43:39',NULL,0),(2,'password',NULL,0,'2017-03-06 09:43:39',NULL,0),(3,'password',NULL,0,'2017-03-06 09:43:39',NULL,0),(4,'password',NULL,0,'2017-03-06 09:43:39',NULL,0),(5,'password',NULL,0,'2017-03-06 09:43:39',NULL,0),(7,'zXZX',NULL,0,'2017-04-16 15:52:03',NULL,0),(8,'ddd',NULL,0,'2017-04-16 16:17:10',NULL,0),(9,'ddd',NULL,0,'2017-04-16 16:37:09',NULL,0),(10,'aaa',NULL,0,'2017-04-17 19:07:32',NULL,0),(11,'ccc',NULL,0,'2017-04-17 19:18:52',NULL,0),(12,'eee',NULL,0,'2017-04-17 19:25:14',NULL,0),(13,'mrafsyam@gmail.com',NULL,0,'2017-05-08 01:28:36',NULL,0),(14,'raf',NULL,0,'2017-05-08 02:28:11',NULL,0),(15,'password',NULL,0,'2017-05-08 02:51:32',NULL,0);
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
  `USER_NAME` varchar(64) NOT NULL COMMENT 'Username for login & display, not the actual user name',
  `EMAIl` varchar(256) DEFAULT NULL COMMENT 'User email',
  `PHONE_NO` int(11) DEFAULT NULL COMMENT 'User phone number',
  `STATUS` enum('NotActive','Active','Blocked','Locked','Deleted') NOT NULL COMMENT 'Status of the user: Active, Blocked by admin or Locked due to login failures',
  `ROLE_ID` int(11) NOT NULL COMMENT 'Role assigned to the user',
  `CREATED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Creation date of the user',
  `UPDATED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Last update to the user',
  `SUSPENDED` datetime DEFAULT NULL COMMENT 'Date and time until which the user is suspended (due to invalid data entry in UMB)',
  `DES` varchar(256) DEFAULT NULL COMMENT 'Optional description for the user',
  PRIMARY KEY (`AJAKK_USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1 COMMENT='Basic data of a AJAKK user';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AJAKK_USER`
--

LOCK TABLES `AJAKK_USER` WRITE;
/*!40000 ALTER TABLE `AJAKK_USER` DISABLE KEYS */;
INSERT INTO `AJAKK_USER` VALUES (1,'active',NULL,NULL,'Active',0,'2017-04-15 17:04:20','2017-04-15 17:04:20',NULL,NULL),(2,'blocked',NULL,NULL,'Blocked',0,'2017-04-15 17:04:20','2017-04-15 17:04:20',NULL,NULL),(3,'locked',NULL,NULL,'Locked',0,'2017-04-15 17:04:20','2017-04-15 17:04:20',NULL,NULL),(4,'deleted',NULL,NULL,'Deleted',0,'2017-04-15 17:04:20','2017-04-15 17:04:20',NULL,NULL),(5,'nonactive',NULL,NULL,'NotActive',0,'2017-04-15 17:04:20','2017-04-15 17:04:20',NULL,NULL),(6,'xcxzc','czxczx',0,'Active',0,'2017-04-16 07:48:42','2017-04-16 07:48:42',NULL,NULL),(7,'xx','ZxZX',0,'Active',0,'2017-04-16 07:52:03','2017-04-16 07:52:03',NULL,NULL),(8,'ddd','dd',33,'Active',0,'2017-04-16 08:17:10','2017-04-16 08:17:10',NULL,NULL),(9,'ddd','ddd',11,'Active',0,'2017-04-16 08:37:09','2017-04-16 08:37:09',NULL,NULL),(10,'aaa','aaa',0,'Active',0,'2017-04-17 11:07:31','2017-04-17 11:07:31',NULL,NULL),(11,'ccc','ccc',1,'Active',0,'2017-04-17 11:18:52','2017-04-17 11:18:52',NULL,NULL),(12,'eee','eee',11,'Active',0,'2017-04-17 11:25:14','2017-04-17 11:25:14',NULL,NULL),(15,'Raf','mrafsyam@gmail.com',183102718,'Active',0,'2017-05-07 18:51:32','2017-05-07 18:51:32',NULL,NULL);
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
  `NAME` varchar(64) NOT NULL COMMENT 'Event name',
  `DES` varchar(256) DEFAULT NULL COMMENT 'Optional description for the event',
  `TYPE` varchar(100) DEFAULT NULL COMMENT 'Event type',
  `STATUS` enum('InActive','Active','Completed','Cancelled') NOT NULL COMMENT 'Status of the event: InActive, Active, Completed or Cancelled',
  `OWNER_ID` int(11) NOT NULL COMMENT 'Owner of the event',
  `SECOND_OWNER_ID` int(11) DEFAULT NULL COMMENT 'Second owner of the event',
  `CREATED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Creation date of the event',
  `UPDATED` datetime DEFAULT NULL COMMENT 'Last update to the event',
  `CONFIRMED_DATE` datetime DEFAULT NULL COMMENT 'Date and time of the event',
  `VENUE_ID` int(11) DEFAULT NULL COMMENT 'location of the event (ID)',
  `LOC` varchar(256) DEFAULT NULL COMMENT 'location of the event (User Input)',
  PRIMARY KEY (`EVENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COMMENT='Basic data of a AJAKK event';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EVENT`
--

LOCK TABLES `EVENT` WRITE;
/*!40000 ALTER TABLE `EVENT` DISABLE KEYS */;
INSERT INTO `EVENT` VALUES (1,'test','vxcvxcv','Futsal','InActive',1,NULL,'2017-04-17 20:19:06',NULL,NULL,NULL,'xcvxcx'),(2,'test','test','Futsal','InActive',1,NULL,'2017-04-22 19:11:31',NULL,NULL,NULL,'test'),(3,'qweqwew','ewqwe','Basketball','InActive',1,NULL,'2017-04-22 19:25:55',NULL,NULL,NULL,'qweqw'),(4,'','','Futsal','InActive',1,NULL,'2017-05-05 19:58:40',NULL,NULL,NULL,'');
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
  `NAME` varchar(64) NOT NULL COMMENT 'Event name',
  `DES` varchar(256) DEFAULT NULL COMMENT 'Optional description for the event',
  `STATUS` enum('Maybe','NotAttending','Attending') NOT NULL COMMENT 'Status of the event: Maybe, NotAttending, Attending',
  `CREATED` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Creation date of the event',
  `UPDATED` datetime DEFAULT NULL COMMENT 'Last update to the event',
  PRIMARY KEY (`EVENT_ID`,`AJAKK_USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Basic data of AJAKK event participants';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EVENT_PARTICIPANT`
--

LOCK TABLES `EVENT_PARTICIPANT` WRITE;
/*!40000 ALTER TABLE `EVENT_PARTICIPANT` DISABLE KEYS */;
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
  `FILE_NAME` varchar(64) NOT NULL COMMENT 'Exact file name of this patch',
  `DES` varchar(256) NOT NULL COMMENT 'Mandatory description for the patch',
  `APPLIED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Applied date of this patch',
  PRIMARY KEY (`PATCH_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='List of all ajakk db patches';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PATCH`
--

LOCK TABLES `PATCH` WRITE;
/*!40000 ALTER TABLE `PATCH` DISABLE KEYS */;
/*!40000 ALTER TABLE `PATCH` ENABLE KEYS */;
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

-- Dump completed on 2017-05-08 15:17:03
