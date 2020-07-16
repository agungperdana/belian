CREATE DATABASE  IF NOT EXISTS `belian` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `belian`;
-- MariaDB dump 10.17  Distrib 10.4.13-MariaDB, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: belian
-- ------------------------------------------------------
-- Server version	10.4.13-MariaDB

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
-- Table structure for table `citizenship`
--

DROP TABLE IF EXISTS `citizenship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `citizenship` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `fk_passport` char(50) DEFAULT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `country_code` varchar(100) DEFAULT NULL,
  `country_name` varchar(200) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citizenship`
--

LOCK TABLES `citizenship` WRITE;
/*!40000 ALTER TABLE `citizenship` DISABLE KEYS */;
/*!40000 ALTER TABLE `citizenship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact` (
  `id` char(50) NOT NULL,
  `contact` varchar(250) DEFAULT NULL,
  `type` char(50) DEFAULT NULL,
  `is_active` char(1) DEFAULT '0',
  `fk_party` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

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
  `type` char(35) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `geographic`
--

LOCK TABLES `geographic` WRITE;
/*!40000 ALTER TABLE `geographic` DISABLE KEYS */;
INSERT INTO `geographic` VALUES ('24b65ed5-911a-4e5e-bdf9-040a82d2a04c','KAL BAR','Kalimantan Barat','','ee07b82c-4b2e-4817-bc34-88e0577b8c8f',NULL,NULL,NULL,NULL,0,'PROVINCE'),('2a164893-a571-4b96-8f2e-a7410f6490db','RW05','RW 05','','c94836ae-bff5-474a-a333-f8ccc8737278',NULL,NULL,NULL,NULL,0,'HAMLET'),('56135657-99cb-4549-b7d1-2bc535e629e4','PNK','Pontianak','','24b65ed5-911a-4e5e-bdf9-040a82d2a04c',NULL,NULL,NULL,NULL,0,'CITY'),('69359a1e-3af7-4b1e-9fb5-7d2125a4f420','RT01','RT 01','','2a164893-a571-4b96-8f2e-a7410f6490db',NULL,NULL,NULL,NULL,0,'NEIGHBOURHOOD'),('bf2efe57-fbdc-4307-9733-b9d89203f2c5','PNK-KT','Pontianak Kota','','56135657-99cb-4549-b7d1-2bc535e629e4',NULL,NULL,NULL,NULL,0,'DISTRICT'),('c94836ae-bff5-474a-a333-f8ccc8737278','DRT-SKIP','Darat Sekip','','bf2efe57-fbdc-4307-9733-b9d89203f2c5',NULL,NULL,NULL,NULL,0,'SUBDISTRICT'),('ee07b82c-4b2e-4817-bc34-88e0577b8c8f','INA','Indonesia','',NULL,NULL,NULL,NULL,NULL,0,'COUNTRY');
/*!40000 ALTER TABLE `geographic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marital_status`
--

DROP TABLE IF EXISTS `marital_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marital_status` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `type` char(35) DEFAULT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marital_status`
--

LOCK TABLES `marital_status` WRITE;
/*!40000 ALTER TABLE `marital_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `marital_status` ENABLE KEYS */;
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
INSERT INTO `module` VALUES ('13b174ef-fed6-4b16-98a1-d9bf3047988e','AUTHENTICATION','User Authentication','SYSTEM','Authentication service module','1',NULL,NULL,NULL,NULL,0),('8221d147-2540-4910-b05c-3ae1a7d76add','SCR-USR','Security User','SECURITY','','0',NULL,NULL,NULL,NULL,0),('a2151307-2c74-48ff-868d-24364126a14d','AUTHORIZATION','User Authorization','SYSTEM','','1',NULL,NULL,NULL,NULL,0),('aaf82d44-cce5-4c7a-9d3f-bbf328b01381','SCR-ROLE','Security Role','SECURITY','','0',NULL,NULL,NULL,NULL,0),('bbd4e3e4-ddb7-497e-862f-c5e3fdee44e7','GEOGRAPHIC','Geographic','SECURITY','','1',NULL,NULL,NULL,NULL,0),('fc283c30-3f7e-4bb3-ad37-7fb27640df69','SCR-MDL','Security Module','SECURITY','','0',NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `party`
--

DROP TABLE IF EXISTS `party`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `party` (
  `id` char(50) NOT NULL,
  `code` char(50) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `birth_place_code` varchar(100) DEFAULT NULL,
  `birth_place_name` varchar(200) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `tax_code` char(50) DEFAULT NULL,
  `type` char(15) DEFAULT NULL,
  `fk_person_information` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party`
--

LOCK TABLES `party` WRITE;
/*!40000 ALTER TABLE `party` DISABLE KEYS */;
INSERT INTO `party` VALUES ('7a7c06d8-d510-4437-9b0c-0e57fb3f977a','KS','Keraton Solution','PNK','Pontianak','2020-06-29','','ORGANIZATION',NULL,1),('7f4e4a0d-0d89-4658-805f-224fdbd24820','JMS','James Raja Guk ','PNK','Pontianak','2020-07-15','','PERSON','b7ccc4ab-e8cb-4d8f-a295-5ff7c0b8f521',0);
/*!40000 ALTER TABLE `party` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `party_address`
--

DROP TABLE IF EXISTS `party_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `party_address` (
  `id` char(50) NOT NULL,
  `address` varchar(250) DEFAULT NULL,
  `postal` char(15) DEFAULT NULL,
  `status` char(1) DEFAULT '0',
  `type` char(35) DEFAULT NULL,
  `location_code` varchar(100) DEFAULT NULL,
  `location_name` varchar(200) DEFAULT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party_address`
--

LOCK TABLES `party_address` WRITE;
/*!40000 ALTER TABLE `party_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `party_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `party_classification`
--

DROP TABLE IF EXISTS `party_classification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `party_classification` (
  `id` char(50) NOT NULL,
  `start` timestamp NULL DEFAULT NULL,
  `end` timestamp NULL DEFAULT NULL,
  `type` char(50) DEFAULT NULL,
  `value` varchar(200) DEFAULT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party_classification`
--

LOCK TABLES `party_classification` WRITE;
/*!40000 ALTER TABLE `party_classification` DISABLE KEYS */;
/*!40000 ALTER TABLE `party_classification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `party_contact`
--

DROP TABLE IF EXISTS `party_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `party_contact` (
  `id` char(50) NOT NULL,
  `contact` varchar(200) DEFAULT NULL,
  `type` char(50) DEFAULT NULL,
  `is_active` char(1) DEFAULT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party_contact`
--

LOCK TABLES `party_contact` WRITE;
/*!40000 ALTER TABLE `party_contact` DISABLE KEYS */;
/*!40000 ALTER TABLE `party_contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `party_relationship`
--

DROP TABLE IF EXISTS `party_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `party_relationship` (
  `id` char(50) NOT NULL,
  `start` timestamp NULL DEFAULT NULL,
  `end` timestamp NULL DEFAULT NULL,
  `fk_from_party` char(50) DEFAULT NULL,
  `fk_to_party` char(50) DEFAULT NULL,
  `type` char(50) DEFAULT NULL,
  `is_active` char(1) DEFAULT '0',
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party_relationship`
--

LOCK TABLES `party_relationship` WRITE;
/*!40000 ALTER TABLE `party_relationship` DISABLE KEYS */;
/*!40000 ALTER TABLE `party_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `party_role`
--

DROP TABLE IF EXISTS `party_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `party_role` (
  `id` char(50) NOT NULL,
  `start` timestamp NULL DEFAULT NULL,
  `end` timestamp NULL DEFAULT NULL,
  `type` char(35) DEFAULT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party_role`
--

LOCK TABLES `party_role` WRITE;
/*!40000 ALTER TABLE `party_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `party_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `party_skill`
--

DROP TABLE IF EXISTS `party_skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `party_skill` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `fk_type` char(50) DEFAULT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party_skill`
--

LOCK TABLES `party_skill` WRITE;
/*!40000 ALTER TABLE `party_skill` DISABLE KEYS */;
/*!40000 ALTER TABLE `party_skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `party_skill_type`
--

DROP TABLE IF EXISTS `party_skill_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `party_skill_type` (
  `id` char(50) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party_skill_type`
--

LOCK TABLES `party_skill_type` WRITE;
/*!40000 ALTER TABLE `party_skill_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `party_skill_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passport`
--

DROP TABLE IF EXISTS `passport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passport` (
  `id` char(50) NOT NULL,
  `number` varchar(150) DEFAULT NULL,
  `issued_date` date DEFAULT NULL,
  `expired_date` date DEFAULT NULL,
  `country_code` char(25) DEFAULT NULL,
  `country_name` varchar(200) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passport`
--

LOCK TABLES `passport` WRITE;
/*!40000 ALTER TABLE `passport` DISABLE KEYS */;
/*!40000 ALTER TABLE `passport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `physical_characteristic`
--

DROP TABLE IF EXISTS `physical_characteristic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `physical_characteristic` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `type` char(35) DEFAULT NULL,
  `value` varchar(150) DEFAULT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `physical_characteristic`
--

LOCK TABLES `physical_characteristic` WRITE;
/*!40000 ALTER TABLE `physical_characteristic` DISABLE KEYS */;
/*!40000 ALTER TABLE `physical_characteristic` ENABLE KEYS */;
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
INSERT INTO `role_module` VALUES ('283eefd4-287e-4f1f-87b3-25a7ab7bcede','aaec1e72-07e7-4591-a0c2-04065f255f6c','SCR-ROLE','0','1','1','1','1','1',0,'Security Role','SECURITY'),('53d11ba0-edba-4cd4-8ce4-479afd495e31','aaec1e72-07e7-4591-a0c2-04065f255f6c','SCR-USR','0','1','1','1','1','1',0,'Security User','SECURITY'),('5c63ea4a-8259-4bf9-a09a-51b82f883583','aaec1e72-07e7-4591-a0c2-04065f255f6c','SCR-MDL','0','1','1','1','1','1',0,'Security Module','SECURITY'),('7374f44c-aa08-4f88-8ff6-279eba8b7e6e','aaec1e72-07e7-4591-a0c2-04065f255f6c','OR','0','0','0','0','0','0',0,'Orai','SYSTEM'),('a6ee2c61-da8a-4fcf-9d41-a3291b721554','aaec1e72-07e7-4591-a0c2-04065f255f6c','AUTHENTICATION','0','1','1','1','1','1',1,'User Authentication','SYSTEM'),('dacc4b4b-21df-4d8e-b344-f3fb80257fc2','aaec1e72-07e7-4591-a0c2-04065f255f6c','AUTHORIZATION','0','1','1','1','1','1',1,'User Authorization','SYSTEM'),('fdae3a5a-1cf5-40a7-85ad-2d2fd023095e','aaec1e72-07e7-4591-a0c2-04065f255f6c','GEOGRAPHIC','0','1','1','1','1','1',1,'Geographic','SECURITY');
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

-- Dump completed on 2020-07-16 16:08:49
