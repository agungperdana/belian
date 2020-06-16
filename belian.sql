CREATE DATABASE  IF NOT EXISTS `belian` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `belian`;
-- MariaDB dump 10.17  Distrib 10.4.12-MariaDB, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: belian
-- ------------------------------------------------------
-- Server version	10.4.12-MariaDB

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
-- Table structure for table `geographic`
--

DROP TABLE IF EXISTS `geographic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `geographic` (
  `id` char(50) NOT NULL,
  `code` char(50) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `note` varchar(200) DEFAULT NULL,
  `fk_parent` varchar(50) DEFAULT NULL,
  `created_by` varchar(150) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT NULL,
  `last_updated_by` varchar(150) DEFAULT NULL,
  `last_updated_date` timestamp NULL DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `geographic`
--

LOCK TABLES `geographic` WRITE;
/*!40000 ALTER TABLE `geographic` DISABLE KEYS */;
/*!40000 ALTER TABLE `geographic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `module`
--

DROP TABLE IF EXISTS `module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `module` (
  `id` varchar(100) NOT NULL,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `module_group` varchar(100) CHARACTER SET cp1250 DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `is_enabled` char(1) DEFAULT '0',
  `created_by` varchar(100) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT NULL,
  `last_updated_by` varchar(100) DEFAULT NULL,
  `last_updated_date` timestamp NULL DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `module_code_UN` (`code`),
  UNIQUE KEY `module_name_UN` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `module`
--

LOCK TABLES `module` WRITE;
/*!40000 ALTER TABLE `module` DISABLE KEYS */;
INSERT INTO `module` VALUES ('13b174ef-fed6-4b16-98a1-d9bf3047988e','AUTHENTICATION','User Authentication','SYSTEM','','1',NULL,NULL,NULL,NULL,0),('8221d147-2540-4910-b05c-3ae1a7d76add','SCR-USR','Security User','SECURITY','','0',NULL,NULL,NULL,NULL,0),('a2151307-2c74-48ff-868d-24364126a14d','AUTHORIZATION','User Authorization','SYSTEM','','1',NULL,NULL,NULL,NULL,0),('aaf82d44-cce5-4c7a-9d3f-bbf328b01381','SCR-ROLE','Security Role','SECURITY','','0',NULL,NULL,NULL,NULL,0),('bbd4e3e4-ddb7-497e-862f-c5e3fdee44e7','GEOGRAPHIC','Geographic','SECURITY','','1',NULL,NULL,NULL,NULL,0),('fc283c30-3f7e-4bb3-ad37-7fb27640df69','SCR-MDL','Security Module','SECURITY','','0',NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` varchar(100) NOT NULL,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `group` varchar(100) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `is_enabled` char(1) DEFAULT '0',
  `created_by` varchar(100) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT NULL,
  `last_updated_by` varchar(100) DEFAULT NULL,
  `last_updated_date` timestamp NULL DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `module_code_UN` (`code`),
  UNIQUE KEY `module_name_UN` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('aaec1e72-07e7-4591-a0c2-04065f255f6c','SYS-ADM','System Administrator',NULL,'','1',NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_module`
--

DROP TABLE IF EXISTS `role_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_module` (
  `id` varchar(100) NOT NULL,
  `fk_role` varchar(100) DEFAULT NULL,
  `module_code` varchar(100) DEFAULT NULL,
  `is_enabled` char(1) DEFAULT '0',
  `is_read` char(1) DEFAULT '0',
  `is_edit` char(1) DEFAULT '0',
  `is_add` char(1) DEFAULT '0',
  `is_delete` char(1) DEFAULT '0',
  `is_print` char(1) DEFAULT '0',
  `version` bigint(10) DEFAULT 0,
  `module_name` varchar(150) DEFAULT NULL,
  `module_group` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_module`
--

LOCK TABLES `role_module` WRITE;
/*!40000 ALTER TABLE `role_module` DISABLE KEYS */;
INSERT INTO `role_module` VALUES ('283eefd4-287e-4f1f-87b3-25a7ab7bcede','aaec1e72-07e7-4591-a0c2-04065f255f6c','SCR-ROLE','0','1','1','1','1','1',0,'Security Role','SECURITY'),('53d11ba0-edba-4cd4-8ce4-479afd495e31','aaec1e72-07e7-4591-a0c2-04065f255f6c','SCR-USR','0','1','1','1','1','1',0,'Security User','SECURITY'),('5c63ea4a-8259-4bf9-a09a-51b82f883583','aaec1e72-07e7-4591-a0c2-04065f255f6c','SCR-MDL','0','1','1','1','1','1',0,'Security Module','SECURITY'),('a6ee2c61-da8a-4fcf-9d41-a3291b721554','aaec1e72-07e7-4591-a0c2-04065f255f6c','AUTHENTICATION','0','1','1','1','1','1',1,'User Authentication','SYSTEM'),('dacc4b4b-21df-4d8e-b344-f3fb80257fc2','aaec1e72-07e7-4591-a0c2-04065f255f6c','AUTHORIZATION','0','1','1','1','1','1',1,'User Authorization','SYSTEM'),('fdae3a5a-1cf5-40a7-85ad-2d2fd023095e','aaec1e72-07e7-4591-a0c2-04065f255f6c','GEOGRAPHIC','0','0','0','0','0','0',0,'Geographic','SECURITY');
/*!40000 ALTER TABLE `role_module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` varchar(100) NOT NULL,
  `name` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `is_enabled` char(1) DEFAULT '0',
  `is_expired` char(1) DEFAULT '0',
  `is_locked` char(1) DEFAULT '0',
  `created_by` varchar(100) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT NULL,
  `last_updated_by` varchar(100) DEFAULT NULL,
  `last_updated_date` timestamp NULL DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_UK` (`name`),
  UNIQUE KEY `user_email_UK` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('0000000000','admin','admin@belian.com','b0mneBIP3GjwF7Z8G0C/dkQmg1eiMLpeD03tFPX5N4/pG+25IuP7XMcBT2Q8psv+','1','0','0','0000000000',NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id` varchar(100) NOT NULL,
  `fk_user` varchar(100) DEFAULT NULL,
  `role_code` varchar(100) DEFAULT NULL,
  `is_enabled` char(1) DEFAULT '0',
  `role_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES ('1eea6ac9-8dac-4a1a-b634-e088d3b9e0b7','0000000000','SYS-ADM','1','System Administrator');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-16 10:28:16
