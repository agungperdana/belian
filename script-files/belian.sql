-- MariaDB dump 10.19  Distrib 10.5.9-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: belian
-- ------------------------------------------------------
-- Server version	10.5.9-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
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
  `fk_party` char(50) DEFAULT NULL,
  `country_code` varchar(100) DEFAULT NULL,
  `country_name` varchar(200) DEFAULT NULL,
  `passport_number` varchar(100) DEFAULT NULL,
  `passport_issued_date` timestamp NULL DEFAULT NULL,
  `passport_expired_date` timestamp NULL DEFAULT NULL,
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
-- Table structure for table `company_structure`
--

DROP TABLE IF EXISTS `company_structure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company_structure` (
  `id` char(50) NOT NULL,
  `code` varchar(150) DEFAULT NULL,
  `name` varchar(250) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `type` varchar(100) DEFAULT 'HOLDING',
  `fk_parent` varchar(150) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_structure`
--

LOCK TABLES `company_structure` WRITE;
/*!40000 ALTER TABLE `company_structure` DISABLE KEYS */;
/*!40000 ALTER TABLE `company_structure` ENABLE KEYS */;
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
INSERT INTO `contact` VALUES ('1a7bac13-f27d-4592-8f07-9525509c8aa7','0-50','EMAIL','0','269816ec-04b4-4610-abe9-d1549f94a4a8',0),('92395b6f-0850-45ca-9147-15f71d846b94','USD 1,000 - USD 10,000','EMAIL','0','269816ec-04b4-4610-abe9-d1549f94a4a8',0),('c02c8428-871b-4217-8e18-18291a25be41','7777','OFFICE_PHONE','1','269816ec-04b4-4610-abe9-d1549f94a4a8',1),('d3c48b82-28ba-49cd-9ec0-6f806f600be3','9798797867565','OFFICE_PHONE','0','269816ec-04b4-4610-abe9-d1549f94a4a8',0),('eaf8d196-8e80-415c-b7ba-145390b420cd','Healthcare','EMAIL','1','269816ec-04b4-4610-abe9-d1549f94a4a8',0);
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
INSERT INTO `geographic` VALUES ('24b65ed5-911a-4e5e-bdf9-040a82d2a04c','KAL BAR','Kalimantan Barat','','ee07b82c-4b2e-4817-bc34-88e0577b8c8f',NULL,NULL,NULL,NULL,0,'PROVINCE'),('56135657-99cb-4549-b7d1-2bc535e629e4','PNK','Pontianak','','24b65ed5-911a-4e5e-bdf9-040a82d2a04c',NULL,NULL,NULL,NULL,0,'CITY'),('ac05b3b0-ac69-4fd5-9aa7-00c73acee1f9','KKR','Kabupaten Kubu Raya','Kabupaten Kubu Raye','24b65ed5-911a-4e5e-bdf9-040a82d2a04c',NULL,NULL,NULL,NULL,0,'REGENCY'),('bf2efe57-fbdc-4307-9733-b9d89203f2c5','PNK-KT','Pontianak Kota','','56135657-99cb-4549-b7d1-2bc535e629e4',NULL,NULL,NULL,NULL,0,'DISTRICT'),('ee07b82c-4b2e-4817-bc34-88e0577b8c8f','INA','Indonesia','',NULL,NULL,NULL,NULL,NULL,0,'COUNTRY');
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
INSERT INTO `marital_status` VALUES ('cd9d5303-4b3c-4444-b7a8-93fcf5916cc6','2021-07-01',NULL,'SINGLE','269816ec-04b4-4610-abe9-d1549f94a4a8',0),('e14f7f1d-865f-4ad2-841e-e9e598dbe9c1','2020-07-01','2021-07-31','MARRIED','abc9ba0d-8a76-496e-91eb-e77e14c505b0',1);
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
INSERT INTO `module` VALUES ('13b174ef-fed6-4b16-98a1-d9bf3047988e','AUTHENTICATION','User Authentication','SYSTEM','Authentication service module','1',NULL,NULL,NULL,NULL,0),('569c197c-dbbc-41e3-bdda-12d579a19d41','COM-STRC','Company Structure','GLOBAL',NULL,'1',NULL,NULL,NULL,NULL,0),('8221d147-2540-4910-b05c-3ae1a7d76add','SCR-USR','Security User','SECURITY','','1',NULL,NULL,NULL,NULL,0),('a2151307-2c74-48ff-868d-24364126a14d','AUTHORIZATION','User Authorization','SYSTEM','','1',NULL,NULL,NULL,NULL,0),('aaf82d44-cce5-4c7a-9d3f-bbf328b01381','SCR-ROLE','Security Role','SECURITY','','1',NULL,NULL,NULL,NULL,0),('b7d0ae65-5771-4b9f-bd32-85020386576c','PARTY','Party Management','GLOBAL','Organization and Person data management','1',NULL,NULL,NULL,NULL,0),('bbd4e3e4-ddb7-497e-862f-c5e3fdee44e7','GEOGRAPHIC','Geographic','SECURITY','','1',NULL,NULL,NULL,NULL,0),('fc283c30-3f7e-4bb3-ad37-7fb27640df69','SCR-MDL','Security Module','SECURITY','','1',NULL,NULL,NULL,NULL,0);
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
  `gender` char(8) DEFAULT 'MALE',
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
INSERT INTO `party` VALUES ('269816ec-04b4-4610-abe9-d1549f94a4a8','0088','PT ABC Corp Inc Ltd','PNK-KT','Pontianak Kota','2021-07-14','00 88 99 00','ORGANIZATION',NULL,0),('abc9ba0d-8a76-496e-91eb-e77e14c505b0','0089','Rudi Tabuti','KAL BAR','Kalimantan Barat','2021-06-27','555 555 555','PERSON','FEMALE',0);
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
INSERT INTO `party_address` VALUES ('d440721f-acf6-453f-b1ec-e21bcb767132','Jl Sana jl sini','71188','1','OFFICE','PNK-KT','Pontianak Kota','269816ec-04b4-4610-abe9-d1549f94a4a8',0),('e5b116b6-b6de-4045-ba40-a0dd273c07e4','Jl ABC Corp','71188','1','HOME','KKR','Kabupaten Kubu Raya','269816ec-04b4-4610-abe9-d1549f94a4a8',2);
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
INSERT INTO `party_classification` VALUES ('6ac3cf37-52c5-4352-ad15-9c6aff0b0eb8','2021-07-01 00:00:00',NULL,'SIZE_CLASSIFICATION','0-50','269816ec-04b4-4610-abe9-d1549f94a4a8',0),('71976c66-33c6-434f-9cc0-aaafa08527ef','2021-07-23 00:00:00','2021-07-31 00:00:00','INCOME_CLASSIFICATIONS','IDR 100,000,000 - 1,000,000,000','269816ec-04b4-4610-abe9-d1549f94a4a8',1),('af0f1d11-cd5d-4d27-a004-92148c3a74c2','2021-07-23 00:00:00','2021-07-31 00:00:00','INDUSTRY_CLASSIFICATION','Healthcare','269816ec-04b4-4610-abe9-d1549f94a4a8',1);
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
INSERT INTO `party_relationship` VALUES ('5d39eb68-e23b-4518-9b01-211466803fa9','2021-07-28 05:34:21','2021-07-31 00:00:00','269816ec-04b4-4610-abe9-d1549f94a4a8','abc9ba0d-8a76-496e-91eb-e77e14c505b0','EMPLOYMENT_RELATIONSHIP','0',1);
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
INSERT INTO `party_role` VALUES ('174ccf5d-ef78-451f-a2b9-300f24c56e9a','2021-07-01 00:00:00',NULL,'EMPLOYER','269816ec-04b4-4610-abe9-d1549f94a4a8',0),('fca8b43d-dde7-4dd0-bbdb-9d567435a5cc','2021-07-01 00:00:00','2021-07-31 00:00:00','SUPPLIER','269816ec-04b4-4610-abe9-d1549f94a4a8',1);
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
INSERT INTO `role` VALUES ('5a745a88-c5ac-4c80-a5bf-1038ff24021f','FIN-MGR','Finance Manager',NULL,'Financial Accounting Manager','1',NULL,NULL,NULL,NULL,0),('aaec1e72-07e7-4591-a0c2-04065f255f6c','SYS-ADM','System Administrator',NULL,'Super User','1',NULL,NULL,NULL,NULL,1);
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
INSERT INTO `role_module` VALUES ('02211d28-843f-4bf3-a8a5-91d7ecd83520','5a745a88-c5ac-4c80-a5bf-1038ff24021f','AUTHORIZATION','0','1','1','1','0','1',1,'User Authorization','SYSTEM'),('055f1c29-e89a-4cd0-87eb-9d541c3cafad','5a745a88-c5ac-4c80-a5bf-1038ff24021f','SCR-MDL','0','1','1','1','0','1',1,'Security Module','SECURITY'),('0ab1ed9c-7e21-4102-8c0a-cc95076b9d19','aaec1e72-07e7-4591-a0c2-04065f255f6c','PARTY','0','1','1','1','1','1',1,'Party Management','GLOBAL'),('121ccccb-b1d1-49d4-aaf8-bcf8aab7b611','aaec1e72-07e7-4591-a0c2-04065f255f6c','COM-STRC','0','1','1','1','1','1',1,'Company Structure','GLOBAL'),('239acbdd-37be-4690-9330-70ea9a669e50','5a745a88-c5ac-4c80-a5bf-1038ff24021f','PARTY','0','0','0','0','0','0',0,'Party Management','GLOBAL'),('283eefd4-287e-4f1f-87b3-25a7ab7bcede','aaec1e72-07e7-4591-a0c2-04065f255f6c','SCR-ROLE','0','1','1','1','1','1',0,'Security Role','SECURITY'),('35ee8720-1fe3-4637-a05b-5698e4bc11f6','5a745a88-c5ac-4c80-a5bf-1038ff24021f','SCR-USR','0','1','1','1','0','1',1,'Security User','SECURITY'),('3b8dbe76-a54e-4375-9ca0-3de7ec9aa302','5a745a88-c5ac-4c80-a5bf-1038ff24021f','AUTHENTICATION','0','1','1','1','0','1',1,'User Authentication','SYSTEM'),('53d11ba0-edba-4cd4-8ce4-479afd495e31','aaec1e72-07e7-4591-a0c2-04065f255f6c','SCR-USR','0','1','1','1','1','1',0,'Security User','SECURITY'),('5c63ea4a-8259-4bf9-a09a-51b82f883583','aaec1e72-07e7-4591-a0c2-04065f255f6c','SCR-MDL','0','1','1','1','1','1',0,'Security Module','SECURITY'),('6f8c0b95-1d2f-4bd5-aa6b-949902964e14','5a745a88-c5ac-4c80-a5bf-1038ff24021f','SCR-ROLE','0','1','1','1','0','1',1,'Security Role','SECURITY'),('8b58005c-911c-445e-94b3-0a2d43bad82b','5a745a88-c5ac-4c80-a5bf-1038ff24021f','GEOGRAPHIC','0','1','1','1','0','1',1,'Geographic','SECURITY'),('a6ee2c61-da8a-4fcf-9d41-a3291b721554','aaec1e72-07e7-4591-a0c2-04065f255f6c','AUTHENTICATION','0','1','1','1','1','1',1,'User Authentication','SYSTEM'),('b607d146-f1fb-492d-9e7f-4c4b87e12170','5a745a88-c5ac-4c80-a5bf-1038ff24021f','COM-STRC','0','0','0','0','0','0',0,'Company Structure','GLOBAL'),('dacc4b4b-21df-4d8e-b344-f3fb80257fc2','aaec1e72-07e7-4591-a0c2-04065f255f6c','AUTHORIZATION','0','1','1','1','1','1',1,'User Authorization','SYSTEM'),('fdae3a5a-1cf5-40a7-85ad-2d2fd023095e','aaec1e72-07e7-4591-a0c2-04065f255f6c','GEOGRAPHIC','0','1','1','1','1','1',1,'Geographic','SECURITY');
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
INSERT INTO `user` VALUES ('0000000000','admin','admin@belian.com','NI/911+uG1iQE2ijqxu+64j7+4nD/ljXBd+ZAxBD9UkYZr+vyyZo8rrweJ9AkYW6','1','0','0','0000000000',NULL,NULL,NULL,0),('d1e52e43-6530-4f19-bee4-9a92df15b4c3','James Borego','james@borego.com','5wJNwNGOFAqO9gl6d0Md7PFcZrw8XsznO0KYppWtcdR6OPnHtOyy98Ui5GM6za9I','1','0','0',NULL,NULL,NULL,NULL,3);
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
INSERT INTO `user_role` VALUES ('1eea6ac9-8dac-4a1a-b634-e088d3b9e0b7','0000000000','SYS-ADM','1','System Administrator'),('3f817a37-f350-4df6-aacb-010cf1ca2930','d1e52e43-6530-4f19-bee4-9a92df15b4c3','SYS-ADM','1','System Administrator'),('db87196d-0a5f-46cc-ba4c-7694b3a7236f','d1e52e43-6530-4f19-bee4-9a92df15b4c3','FIN-MGR','1','Finance Manager');
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

-- Dump completed on 2021-08-14 11:30:58
