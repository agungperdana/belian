CREATE DATABASE  IF NOT EXISTS `belian` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `belian`;
-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: localhost    Database: belian
-- ------------------------------------------------------
-- Server version	5.7.13

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
-- Table structure for table `access_role`
--

DROP TABLE IF EXISTS `access_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `access_role` (
  `id` char(50) NOT NULL,
  `fk_module` char(50) DEFAULT NULL,
  `fk_role` char(50) DEFAULT NULL,
  `is_can_read` char(1) DEFAULT '0',
  `is_can_update` char(1) DEFAULT '0',
  `is_can_delete` char(1) DEFAULT '0',
  `is_can_create` char(1) DEFAULT '0',
  `is_can_print` char(1) DEFAULT '0',
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `access_role`
--

LOCK TABLES `access_role` WRITE;
/*!40000 ALTER TABLE `access_role` DISABLE KEYS */;
INSERT INTO `access_role` VALUES ('0442dff1-c1dd-45e7-8634-2b9d90904469','7bef1d92-0f15-43ef-b59b-5bc3e769d896','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('060d3480-7c9a-44c7-b572-d7b2c4067359','916b22eb-48fa-4000-b7a2-7fc1d47ced4e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('0e9073d1-2be3-4a8a-9a82-5bd1166757e2','847a8df6-bc04-4de6-8d7d-28e41c00f422','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('195dd074-a5e5-4abe-bc9f-5e913229bbb6','2d7e5641-511d-43fd-a6d6-a482120f8aa5','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('1aa3a48c-ab0c-4949-945e-e9852a9b9a93','95dd39dd-512e-414e-b95c-0fc251887f98','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('22fbdfec-6afe-4f2f-bd69-ac6a9974ae82','5c37296e-ab30-4d07-bba3-342d4c403f48','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('2d52482a-0a7a-4e49-83c6-9db73e4e051b','80aebe74-399c-4273-9145-956a077d3f5d','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('3202f4e4-fd87-41a8-ae71-fbefce6a2ef4','b54c8e49-c820-4292-9f74-9e47bd55711f','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('32915e9c-96bf-44b3-881a-2f7c917a4c92','d33784ca-abd5-422b-b45a-8c8ee13ddc0a','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('331300a2-cc8e-4417-abb3-45dadf814422','fca1cfcf-d199-4729-a321-e1ed01deb0f1','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('37484efd-9cb6-4f79-903f-e7d6687658cc','6861d3b3-8110-46ed-8a3a-830963597fa7','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('3a225b38-8dbd-482a-9c14-2f7f1c535068','88bf4008-c84a-4089-88c6-e9d8f077a196','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('48c06de3-442f-4125-a438-e370fabade36','f50dd16d-0e25-44b6-bd69-c28dfcc55300','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('48c4056e-33f6-4082-af20-0139f3e66371','8217c196-16b9-44fb-9662-8323220ee705','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('490e4434-7ea2-475e-a66c-ea7296b82c54','29ec80f0-0d4c-451c-ae5e-f195c4be1a27','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('4fffeab2-b09c-47fb-92b4-3981da252637','9e644628-121d-4954-8a66-8002cc866bda','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('541dd297-fd64-44ae-bcf4-fed612227962','4b3bb551-173e-46f5-b1e9-bdd719e3045e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('59d88282-5a3f-481b-9bb8-91679fbf4d91','f53b80db-1b89-4779-86e7-b065b5287bbb','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('5a2ce59a-60c2-4203-9d3b-7c5d038fe635','e916392a-0b3c-4543-ada7-93054383bb3b','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('5c2ddb84-b28c-40f6-81d5-351e0ea1037d','627fb961-6cf0-4148-9451-0d1422095eb7','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('5c9ab463-dc50-47a5-a601-f074734adf3c','abfd9a02-3b4b-47a0-9048-a65b6be0b3aa','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('6179118a-ff80-452a-a89d-8e0154725095','b662de02-f4a3-4f1a-819b-5d2aaf6a342b','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('6416ea67-8c7b-477e-811f-c5e4e45ca9c0','99623cbd-066f-4cc2-b9b3-1961bed131cc','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('6655f91e-4928-4c6f-b83a-f43b28f04454','770c420c-f809-43f7-969c-b493f0b4ef48','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('6adcd07b-62da-4e75-a076-80520a58eb32','5cdd1545-8fdb-4a79-b2a3-0662ed6fec30','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('711417b0-a5ea-4c2e-8ab3-e5a96576b45b','8f6ec9c8-e9ed-49e1-ab7a-c4a868b8391e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('724b174d-96ec-4152-a42c-2d03097b9aa9','342b0b64-291f-4d12-bdb8-77186895d21d','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('79450f94-0cbf-4c0d-ad76-3362a4abe180','4eca5501-a650-41d5-87c1-c091391d3608','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('89c3b455-3c46-4bc4-9a13-77c171e129b6','a4c43802-436f-407c-8793-323600c181d7','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('94863d4d-7d07-41d2-bc78-4f65260776d6','13989b38-ac2c-47b8-8708-5e27477af18d','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('9659ee34-7845-4078-89bd-9ee9b9e37b78','855aab16-cb45-41c3-b62c-55185ff77dfc','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('9728b76b-eac0-44c4-9ba9-afca669e0a76','e8f89299-2138-4167-b5b7-52f6ae1667ca','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('9f52d7a0-217e-4084-9bb3-78c5c81dd536','07452775-a048-4071-8798-21dc943fe926','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('9fa511a1-e704-4018-a90a-57acea0ac5da','1adc4b8b-ad93-4658-8476-6bb13e2e810d','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('a055f787-df6a-4c93-af22-12797bf5ec39','69443009-4a15-4061-b9f0-08c08c8f50aa','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('a3e8ba06-d955-4929-bd36-f658f3796b6c','a4aa9ae0-5166-4d06-afd1-d2eea6f2417c','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('a7951344-6b9e-438f-af5c-7b94dee26b2d','83b19678-9f2f-49f4-ba25-0f31a8dee078','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('a8a90cc0-470f-456c-879b-77c0ed469dd7','9df71b1a-0e52-4445-98ea-b9a59ad81ac9','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('a91848d3-83d1-485a-9846-c83ff3699ac2','322d37f6-a667-481e-bc22-db212d0154ea','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('abecab92-51cb-4ca9-88a0-9446c1bc5ae3','4eb93eb7-2100-49ae-bd96-a39995ed5670','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('ac144c04-22c4-47fb-8fd4-3783a4f29a90','1cf392fc-4f93-4e38-9709-2beb84434951','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('ad389302-f250-4270-a937-75cf984c2f80','2bdc3f95-c5bd-47d9-adce-9e9df1042e2f','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('b4f04a2c-d9a4-4b30-b75b-4572685e35a8','9178e8cd-4063-4fe9-a060-d2e3ac818ed1','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('bf839209-25d9-4ea7-8e4a-d771f7599e2e','6cbaf072-6925-46e9-b417-17326f3d8584','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('c655e02a-f2a3-4132-8bd7-9428cc1ce3af','0b503053-31eb-410d-90a6-ec6a9977bc1e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('c836928e-da88-414e-b572-db436cc948a4','4939e42f-06b5-4e44-b3ba-4106964f1f68','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('c9681985-0b2a-4537-822b-8f477bc15104','65414caf-3a73-4e3f-9a58-2d70c723b5bc','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('ce77f072-7ad1-4cb5-9e9e-0d9b89a853bd','314a3f13-a982-4915-a5cb-455eacbc27ae','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('cf2437ad-5e59-4f7a-8190-f537beabc623','58621810-2c8f-44ae-b9aa-b1e05ad32743','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('cff3c8ef-bd79-4d32-be37-b4a2e7dab027','90195ecb-4674-4614-a429-eebc24ffe773','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('d8a71d8e-344a-4c18-88ff-9ca2cffed715','b9935030-f5c1-479e-9ec1-795afc1c1e7e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('e1ae7cc5-aab3-4271-a744-9d17fca44e9c','9b9e014c-7a23-40c1-8841-30044564bf7f','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('e1ae7cc5-aab3-4271-a744-9d17fca44e9x','9b9e014c-7a23-40c1-8841-30044564bf7x','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('e51c5ad1-38c7-4699-9c92-50f070f7a7f3','4bf39427-b32a-434c-bd71-4d9493ea6eef','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('e9b3d5e4-1259-48bc-b521-7abb7d72bc30','e4307d82-f3fa-4916-9e6b-7a4f894d847e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('ed0df929-8852-42ca-9006-e0ad6fd37a90','55b7e0fb-a178-478b-a09e-4b753f161aeb','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('f0f949d7-f756-4fdc-bacd-b6e145b9829d','5e8c4a66-e46a-4000-ae1c-bf536686b30f','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('f6e69991-8825-41e8-a6e7-24a4c6257c4d','dbc9175e-eb27-45e9-9e43-a1c12d6354e4','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('fe2ef334-8861-41af-887a-a95992d46b74','8c7e1020-0824-4239-9a4e-46301c80b9cd','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1);
/*!40000 ALTER TABLE `access_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accessible_organization`
--

DROP TABLE IF EXISTS `accessible_organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accessible_organization` (
  `id` char(50) NOT NULL,
  `fk_role` char(50) DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `is_selected` char(1) DEFAULT '0',
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accessible_organization`
--

LOCK TABLES `accessible_organization` WRITE;
/*!40000 ALTER TABLE `accessible_organization` DISABLE KEYS */;
INSERT INTO `accessible_organization` VALUES ('af888d98-5c12-4ddd-b792-450ba5f3c660','096b0105-de76-492c-9bb0-5e518b46d69c','541e778c-d93b-4b99-95c1-0bfbdb6027e9','0',0),('b1fa99fe-7db5-4306-a90f-03042ebf270b','096b0105-de76-492c-9bb0-5e518b46d69c','0b7252be-8c14-42bf-b7bc-6e67ffb882d1','0',0),('b304024d-5933-401c-a303-e138ca14333a','096b0105-de76-492c-9bb0-5e518b46d69c','0da3d8c0-b756-4b86-93c7-1c4ecdb8dc86','0',0),('e17751e4-20f0-48ab-bfe4-3986f12453a9','096b0105-de76-492c-9bb0-5e518b46d69c','3b9d7ef1-d0dc-40b5-9e1e-e92e0e452b08','0',0);
/*!40000 ALTER TABLE `accessible_organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accounting_period`
--

DROP TABLE IF EXISTS `accounting_period`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accounting_period` (
  `id` char(50) NOT NULL,
  `number` char(50) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `date_from` date DEFAULT NULL,
  `date_to` date DEFAULT NULL,
  `month` char(10) DEFAULT 'January',
  `fk_accounting_period_parent` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounting_period`
--

LOCK TABLES `accounting_period` WRITE;
/*!40000 ALTER TABLE `accounting_period` DISABLE KEYS */;
/*!40000 ALTER TABLE `accounting_period` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `id` char(50) NOT NULL,
  `address` varchar(500) DEFAULT NULL,
  `postal` char(25) DEFAULT NULL,
  `status` char(1) DEFAULT '1',
  `type` char(10) DEFAULT 'HOME',
  `fk_geographic_city` char(50) DEFAULT NULL,
  `fk_geographic_province` char(50) DEFAULT NULL,
  `fk_geographic_country` char(50) DEFAULT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `approve_and_reviewable`
--

DROP TABLE IF EXISTS `approve_and_reviewable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `approve_and_reviewable` (
  `id` char(50) NOT NULL,
  `number` varchar(100) DEFAULT NULL,
  `fk_organization_requested` char(50) DEFAULT NULL,
  `fk_last_status` char(50) DEFAULT NULL,
  `comment` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `approve_and_reviewable`
--

LOCK TABLES `approve_and_reviewable` WRITE;
/*!40000 ALTER TABLE `approve_and_reviewable` DISABLE KEYS */;
INSERT INTO `approve_and_reviewable` VALUES ('996f5358-1c0d-456d-a4de-167469c504e8','POR1466223299881','3b9d7ef1-d0dc-40b5-9e1e-e92e0e452b08','89f67ac1-3b89-404d-bbbc-783214b5c6f0',NULL,2);
/*!40000 ALTER TABLE `approve_and_reviewable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `approveable`
--

DROP TABLE IF EXISTS `approveable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `approveable` (
  `id` char(50) NOT NULL,
  `number` char(50) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `approver_status` char(10) DEFAULT NULL,
  `request_status` char(10) DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `requester` char(50) DEFAULT NULL,
  `approver` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `approveable`
--

LOCK TABLES `approveable` WRITE;
/*!40000 ALTER TABLE `approveable` DISABLE KEYS */;
/*!40000 ALTER TABLE `approveable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asset`
--

DROP TABLE IF EXISTS `asset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asset` (
  `id` char(50) NOT NULL,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `acquired_date` date DEFAULT NULL,
  `last_serviced_date` date DEFAULT NULL,
  `next_serviced_date` date DEFAULT NULL,
  `buying_price` decimal(10,0) DEFAULT NULL,
  `is_active` char(1) DEFAULT '1',
  `is_disposed` char(1) DEFAULT '0',
  `fk_asset_type` char(50) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `fk_cashier_shift` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset`
--

LOCK TABLES `asset` WRITE;
/*!40000 ALTER TABLE `asset` DISABLE KEYS */;
INSERT INTO `asset` VALUES ('7de2e2ea-9440-4d22-b2a9-5756f5030e77','Cashier 1','Cashier 1','2016-06-18',NULL,NULL,3200000,'1','0','139094e4-7666-4b64-8b30-a6de0546d2a7','','3b9d7ef1-d0dc-40b5-9e1e-e92e0e452b08','6e351476-ea51-4c64-8c83-29e940ec3673',2);
/*!40000 ALTER TABLE `asset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asset_type`
--

DROP TABLE IF EXISTS `asset_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asset_type` (
  `id` char(50) NOT NULL,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `parent` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset_type`
--

LOCK TABLES `asset_type` WRITE;
/*!40000 ALTER TABLE `asset_type` DISABLE KEYS */;
INSERT INTO `asset_type` VALUES ('139094e4-7666-4b64-8b30-a6de0546d2a7','Computer','Computer',NULL,0);
/*!40000 ALTER TABLE `asset_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `benefit`
--

DROP TABLE IF EXISTS `benefit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `benefit` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `cost` decimal(10,0) DEFAULT NULL,
  `percent_employer_paid` decimal(10,0) DEFAULT NULL,
  `available_time` bigint(20) DEFAULT NULL,
  `fk_benefit_type` char(50) DEFAULT NULL,
  `period_type` char(15) DEFAULT NULL,
  `fk_employment` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benefit`
--

LOCK TABLES `benefit` WRITE;
/*!40000 ALTER TABLE `benefit` DISABLE KEYS */;
/*!40000 ALTER TABLE `benefit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `benefit_type`
--

DROP TABLE IF EXISTS `benefit_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `benefit_type` (
  `id` char(50) NOT NULL,
  `code` char(50) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benefit_type`
--

LOCK TABLES `benefit_type` WRITE;
/*!40000 ALTER TABLE `benefit_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `benefit_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billable`
--

DROP TABLE IF EXISTS `billable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billable` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `number` char(50) DEFAULT NULL,
  `is_paid` char(1) DEFAULT '0',
  `fk_currency` char(50) DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `fk_person_sales` char(50) DEFAULT NULL,
  `fk_person_customer` char(50) DEFAULT NULL,
  `fk_tax` char(50) DEFAULT NULL,
  `fk_cashier_shift` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billable`
--

LOCK TABLES `billable` WRITE;
/*!40000 ALTER TABLE `billable` DISABLE KEYS */;
INSERT INTO `billable` VALUES ('03175eef-c7cc-4af2-9f55-e1283ceb581f','2016-06-18','DRAPT-180616-2','1','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3b9d7ef1-d0dc-40b5-9e1e-e92e0e452b08','a60c79fb-e54b-41fe-aaab-a715e42edef4','504c9e43-02ff-4034-96ea-e76ca764231e','b685e80a-5257-49c7-9c7d-11b986a49b29',NULL,0),('39fbc6b4-c47a-4c27-a6e3-38ab146f0946','2016-06-18','BLG1466245874511','1','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3b9d7ef1-d0dc-40b5-9e1e-e92e0e452b08','504c9e43-02ff-4034-96ea-e76ca764231e','10fe16f0-3f2c-4995-b6c3-5f5447597a12','b685e80a-5257-49c7-9c7d-11b986a49b29','6e351476-ea51-4c64-8c83-29e940ec3673',1),('55432498-4ec8-44fa-a677-b5a4a304d742','2016-06-18','DRAPT-180616-2','1','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3b9d7ef1-d0dc-40b5-9e1e-e92e0e452b08','a60c79fb-e54b-41fe-aaab-a715e42edef4','504c9e43-02ff-4034-96ea-e76ca764231e','b685e80a-5257-49c7-9c7d-11b986a49b29',NULL,0),('70ac451e-2798-4f73-94da-794f794a3dcd','2016-06-18','DRAPT-180616-2','1','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3b9d7ef1-d0dc-40b5-9e1e-e92e0e452b08','a60c79fb-e54b-41fe-aaab-a715e42edef4','504c9e43-02ff-4034-96ea-e76ca764231e','b685e80a-5257-49c7-9c7d-11b986a49b29',NULL,0),('d2e25b48-2870-47ea-b12c-9eccd7f31b9a','2016-06-18','PHS1','1','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3b9d7ef1-d0dc-40b5-9e1e-e92e0e452b08','504c9e43-02ff-4034-96ea-e76ca764231e','10fe16f0-3f2c-4995-b6c3-5f5447597a12','b685e80a-5257-49c7-9c7d-11b986a49b29','6e351476-ea51-4c64-8c83-29e940ec3673',2);
/*!40000 ALTER TABLE `billable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bpjs`
--

DROP TABLE IF EXISTS `bpjs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bpjs` (
  `id` char(50) NOT NULL,
  `card_number` char(50) DEFAULT NULL,
  `is_active` char(1) DEFAULT '0',
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bpjs`
--

LOCK TABLES `bpjs` WRITE;
/*!40000 ALTER TABLE `bpjs` DISABLE KEYS */;
INSERT INTO `bpjs` VALUES ('9f739427-44e0-4079-bfab-b28bea9d100a','555 555 000','1',0);
/*!40000 ALTER TABLE `bpjs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `budget`
--

DROP TABLE IF EXISTS `budget`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `budget` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `type` char(10) DEFAULT 'Operating',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `budget`
--

LOCK TABLES `budget` WRITE;
/*!40000 ALTER TABLE `budget` DISABLE KEYS */;
/*!40000 ALTER TABLE `budget` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `budget_item`
--

DROP TABLE IF EXISTS `budget_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `budget_item` (
  `id` char(50) NOT NULL,
  `sequence` int(11) DEFAULT NULL,
  `purpose` varchar(250) DEFAULT NULL,
  `justification` varchar(250) DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `fk_budget` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `budget_item`
--

LOCK TABLES `budget_item` WRITE;
/*!40000 ALTER TABLE `budget_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `budget_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `budget_review`
--

DROP TABLE IF EXISTS `budget_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `budget_review` (
  `id` char(50) NOT NULL,
  `fk_budget` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `budget_review`
--

LOCK TABLES `budget_review` WRITE;
/*!40000 ALTER TABLE `budget_review` DISABLE KEYS */;
/*!40000 ALTER TABLE `budget_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `budget_revision`
--

DROP TABLE IF EXISTS `budget_revision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `budget_revision` (
  `id` char(50) NOT NULL,
  `sequence` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `fk_budget` char(50) DEFAULT NULL,
  `comment` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `budget_revision`
--

LOCK TABLES `budget_revision` WRITE;
/*!40000 ALTER TABLE `budget_revision` DISABLE KEYS */;
/*!40000 ALTER TABLE `budget_revision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `budget_revision_item`
--

DROP TABLE IF EXISTS `budget_revision_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `budget_revision_item` (
  `id` char(50) NOT NULL,
  `type` char(12) DEFAULT NULL,
  `fk_budget_item` char(50) DEFAULT NULL,
  `fk_budget_revision` char(50) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `budget_revision_item`
--

LOCK TABLES `budget_revision_item` WRITE;
/*!40000 ALTER TABLE `budget_revision_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `budget_revision_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `budget_role`
--

DROP TABLE IF EXISTS `budget_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `budget_role` (
  `id` char(50) NOT NULL,
  `fk_budget` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `budget_role`
--

LOCK TABLES `budget_role` WRITE;
/*!40000 ALTER TABLE `budget_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `budget_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `budget_status`
--

DROP TABLE IF EXISTS `budget_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `budget_status` (
  `id` char(50) NOT NULL,
  `fk_budget` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `budget_status`
--

LOCK TABLES `budget_status` WRITE;
/*!40000 ALTER TABLE `budget_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `budget_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cash_purchase_order`
--

DROP TABLE IF EXISTS `cash_purchase_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cash_purchase_order` (
  `id` char(50) NOT NULL,
  `fk_facility` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cash_purchase_order`
--

LOCK TABLES `cash_purchase_order` WRITE;
/*!40000 ALTER TABLE `cash_purchase_order` DISABLE KEYS */;
INSERT INTO `cash_purchase_order` VALUES ('607f39a6-f11a-4100-affb-e6774e6bceb2','f9a6bd79-b4b3-4fb7-9fbd-4c7187606fc1');
/*!40000 ALTER TABLE `cash_purchase_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cash_purchase_order_item`
--

DROP TABLE IF EXISTS `cash_purchase_order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cash_purchase_order_item` (
  `id` char(50) NOT NULL,
  `fk_cash_purchase_order` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cash_purchase_order_item`
--

LOCK TABLES `cash_purchase_order_item` WRITE;
/*!40000 ALTER TABLE `cash_purchase_order_item` DISABLE KEYS */;
INSERT INTO `cash_purchase_order_item` VALUES ('84233c28-8c6c-4767-b034-fd23f58dc04b','607f39a6-f11a-4100-affb-e6774e6bceb2'),('dbbf895d-3d53-42ce-8412-e39c49eecdaa','607f39a6-f11a-4100-affb-e6774e6bceb2');
/*!40000 ALTER TABLE `cash_purchase_order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cash_sales`
--

DROP TABLE IF EXISTS `cash_sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cash_sales` (
  `id` char(50) NOT NULL,
  `table_number` int(11) DEFAULT '1',
  `fk_geographic_location` char(50) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `cash_sales_type` char(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cash_sales`
--

LOCK TABLES `cash_sales` WRITE;
/*!40000 ALTER TABLE `cash_sales` DISABLE KEYS */;
INSERT INTO `cash_sales` VALUES ('39fbc6b4-c47a-4c27-a6e3-38ab146f0946',1,'c4c10aee-a3a1-4e6c-a08b-62d4e26414df','','SHORTTERM');
/*!40000 ALTER TABLE `cash_sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cash_sales_line`
--

DROP TABLE IF EXISTS `cash_sales_line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cash_sales_line` (
  `id` char(50) NOT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `discount` decimal(10,0) DEFAULT NULL,
  `charge` decimal(10,0) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_unit_of_measure` char(50) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `fk_cash_sales` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cash_sales_line`
--

LOCK TABLES `cash_sales_line` WRITE;
/*!40000 ALTER TABLE `cash_sales_line` DISABLE KEYS */;
INSERT INTO `cash_sales_line` VALUES ('013fad32-b5da-4cea-af7e-35d05176ae18',3000,0,0,1,'','7fd5cb7f-c6e5-4328-b275-07a0bc4f6722','4cb083d9-1ba1-4b01-99cb-f2529cbca845','39fbc6b4-c47a-4c27-a6e3-38ab146f0946',0),('d84aa3a0-b7c6-4e60-85cf-faa27463b2ec',5000,0,0,1,'','7fd5cb7f-c6e5-4328-b275-07a0bc4f6722','931b0d7e-cd0b-43da-a5b5-0abaef5bf292','39fbc6b4-c47a-4c27-a6e3-38ab146f0946',0);
/*!40000 ALTER TABLE `cash_sales_line` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cashier_shift`
--

DROP TABLE IF EXISTS `cashier_shift`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cashier_shift` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `employee` char(50) DEFAULT NULL,
  `is_closed` char(1) DEFAULT '0',
  `asset` char(50) DEFAULT NULL,
  `capital` decimal(10,0) DEFAULT NULL,
  `start` time DEFAULT NULL,
  `end` time DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cashier_shift`
--

LOCK TABLES `cashier_shift` WRITE;
/*!40000 ALTER TABLE `cashier_shift` DISABLE KEYS */;
INSERT INTO `cashier_shift` VALUES ('6e351476-ea51-4c64-8c83-29e940ec3673','2016-06-18','504c9e43-02ff-4034-96ea-e76ca764231e','0','7de2e2ea-9440-4d22-b2a9-5756f5030e77',100000,'11:36:17',NULL,0);
/*!40000 ALTER TABLE `cashier_shift` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_structure`
--

DROP TABLE IF EXISTS `company_structure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company_structure` (
  `id` char(50) NOT NULL,
  `date_from` date DEFAULT NULL,
  `date_to` date DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `type` char(10) DEFAULT NULL,
  `fk_company_structure_parent` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_structure`
--

LOCK TABLES `company_structure` WRITE;
/*!40000 ALTER TABLE `company_structure` DISABLE KEYS */;
INSERT INTO `company_structure` VALUES ('0f3b2d0c-7522-46ce-9a7a-0fa634ee9301','2010-06-17',NULL,'3b9d7ef1-d0dc-40b5-9e1e-e92e0e452b08','BRANCH','b2d27297-8f8b-496f-80e7-1bc6c664db11',0),('7e8e4bef-c7a7-403b-8d38-9c6022bed5fc','2010-06-17',NULL,'0da3d8c0-b756-4b86-93c7-1c4ecdb8dc86','BRANCH','b2d27297-8f8b-496f-80e7-1bc6c664db11',0),('b2d27297-8f8b-496f-80e7-1bc6c664db11','2010-06-17',NULL,'0b7252be-8c14-42bf-b7bc-6e67ffb882d1','COMPANY','f1d26fd5-06ed-4e19-b994-f0a26bd72205',0),('f1d26fd5-06ed-4e19-b994-f0a26bd72205','2010-06-17',NULL,'541e778c-d93b-4b99-95c1-0bfbdb6027e9','HOLDING',NULL,0);
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
  `contact` varchar(150) DEFAULT NULL,
  `type` char(12) DEFAULT 'PHONE',
  `status` char(1) DEFAULT '1',
  `fk_party` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currency`
--

DROP TABLE IF EXISTS `currency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `currency` (
  `id` char(50) NOT NULL,
  `code` char(15) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currency`
--

LOCK TABLES `currency` WRITE;
/*!40000 ALTER TABLE `currency` DISABLE KEYS */;
INSERT INTO `currency` VALUES ('82159e7e-7d44-44e9-acc6-09f85e99bac0','RMY','Ringgit Malaysia',0),('85c90912-97ff-47ce-9d6a-7d1650ab3ea9','IDR','Rupiah',0),('f4e2e57c-be85-49a8-b19b-66ed812b2785','USD','US Dollar',0);
/*!40000 ALTER TABLE `currency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deduction`
--

DROP TABLE IF EXISTS `deduction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deduction` (
  `id` char(50) NOT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `fk_doduction_type` char(50) DEFAULT NULL,
  `fk_paycheck` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deduction`
--

LOCK TABLES `deduction` WRITE;
/*!40000 ALTER TABLE `deduction` DISABLE KEYS */;
/*!40000 ALTER TABLE `deduction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deduction_type`
--

DROP TABLE IF EXISTS `deduction_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deduction_type` (
  `id` char(50) NOT NULL,
  `name` varchar(150) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deduction_type`
--

LOCK TABLES `deduction_type` WRITE;
/*!40000 ALTER TABLE `deduction_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `deduction_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disbursement`
--

DROP TABLE IF EXISTS `disbursement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disbursement` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disbursement`
--

LOCK TABLES `disbursement` WRITE;
/*!40000 ALTER TABLE `disbursement` DISABLE KEYS */;
/*!40000 ALTER TABLE `disbursement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor` (
  `id` char(50) NOT NULL,
  `fk_doctor_type` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES ('9e59f471-f728-4439-8f51-4dae16868327',NULL);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor_appointment`
--

DROP TABLE IF EXISTS `doctor_appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor_appointment` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `queue` int(11) DEFAULT NULL,
  `fk_doctor` char(50) DEFAULT NULL,
  `fk_patient` char(50) DEFAULT NULL,
  `status` char(10) DEFAULT NULL,
  `fk_medical_record` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor_appointment`
--

LOCK TABLES `doctor_appointment` WRITE;
/*!40000 ALTER TABLE `doctor_appointment` DISABLE KEYS */;
INSERT INTO `doctor_appointment` VALUES ('158d7dec-8111-4bf2-86be-29ff8b413bb8','2016-06-18','3b9d7ef1-d0dc-40b5-9e1e-e92e0e452b08','',1,2,'3ae6cf16-f92c-4e02-92c1-eea98256c531','6e869f14-99a9-4b38-882c-843cf0268d93','DONE',NULL);
/*!40000 ALTER TABLE `doctor_appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor_relationship`
--

DROP TABLE IF EXISTS `doctor_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor_relationship` (
  `id` char(50) NOT NULL,
  `fk_doctor_type` char(50) DEFAULT NULL,
  `fk_doctor` char(50) DEFAULT NULL,
  `fk_internal_organization` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor_relationship`
--

LOCK TABLES `doctor_relationship` WRITE;
/*!40000 ALTER TABLE `doctor_relationship` DISABLE KEYS */;
INSERT INTO `doctor_relationship` VALUES ('3ae6cf16-f92c-4e02-92c1-eea98256c531','2329c720-a14c-4e7b-8ab6-757bc64cb4d3','9e59f471-f728-4439-8f51-4dae16868327','9f2528c0-ba70-4841-864c-05d820c9fec3');
/*!40000 ALTER TABLE `doctor_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor_type`
--

DROP TABLE IF EXISTS `doctor_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor_type` (
  `id` char(50) NOT NULL,
  `code` char(50) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor_type`
--

LOCK TABLES `doctor_type` WRITE;
/*!40000 ALTER TABLE `doctor_type` DISABLE KEYS */;
INSERT INTO `doctor_type` VALUES ('2329c720-a14c-4e7b-8ab6-757bc64cb4d3','dr','Dokter Umum','',0),('2edac947-5161-4650-b426-366a534f1c2b','drg','Dokter Gigi','',0);
/*!40000 ALTER TABLE `doctor_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` char(50) NOT NULL,
  `fk_user` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('16ba1052-801c-4b80-9731-e23a6bc24f8b','a2501053-ee28-4073-b7a7-09844e6166e8'),('c3543237-5b5a-4879-bbda-5ca90ef47146','f45b1e51-26d1-4aad-9a32-936876b4879f');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employment`
--

DROP TABLE IF EXISTS `employment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employment` (
  `id` char(50) NOT NULL,
  `fk_employee` char(50) DEFAULT NULL,
  `fk_internal_organization` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employment`
--

LOCK TABLES `employment` WRITE;
/*!40000 ALTER TABLE `employment` DISABLE KEYS */;
INSERT INTO `employment` VALUES ('bea15201-d706-45ec-9126-5057b04827fd','c3543237-5b5a-4879-bbda-5ca90ef47146','9f2528c0-ba70-4841-864c-05d820c9fec3'),('dc6daf21-1de1-44d0-ad0d-6ff8dfe5cba7','16ba1052-801c-4b80-9731-e23a6bc24f8b','a30768a9-ca5f-4906-aa18-1a50155e881b');
/*!40000 ALTER TABLE `employment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employment_application`
--

DROP TABLE IF EXISTS `employment_application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employment_application` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `status_type` char(10) DEFAULT NULL,
  `source_type` char(15) DEFAULT NULL,
  `fk_position` char(50) DEFAULT NULL,
  `fk_person_referal` char(50) DEFAULT NULL,
  `fk_person_applicant` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employment_application`
--

LOCK TABLES `employment_application` WRITE;
/*!40000 ALTER TABLE `employment_application` DISABLE KEYS */;
/*!40000 ALTER TABLE `employment_application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facility`
--

DROP TABLE IF EXISTS `facility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facility` (
  `id` char(50) NOT NULL,
  `code` varchar(150) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `type` char(15) DEFAULT NULL,
  `fk_facility_parent` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facility`
--

LOCK TABLES `facility` WRITE;
/*!40000 ALTER TABLE `facility` DISABLE KEYS */;
INSERT INTO `facility` VALUES ('f9a6bd79-b4b3-4fb7-9fbd-4c7187606fc1','WH1','Warehouse 1','','WAREHOUSE',NULL,0);
/*!40000 ALTER TABLE `facility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facility_organization`
--

DROP TABLE IF EXISTS `facility_organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facility_organization` (
  `id` char(50) NOT NULL,
  `enabled` char(1) DEFAULT NULL,
  `fk_facility` char(50) DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facility_organization`
--

LOCK TABLES `facility_organization` WRITE;
/*!40000 ALTER TABLE `facility_organization` DISABLE KEYS */;
INSERT INTO `facility_organization` VALUES ('7025afa5-e044-4300-ad99-8aa9c00a8dd2','0','f9a6bd79-b4b3-4fb7-9fbd-4c7187606fc1','0b7252be-8c14-42bf-b7bc-6e67ffb882d1',0),('7eb0a060-22b6-4e75-bc97-e840f4946641','0','f9a6bd79-b4b3-4fb7-9fbd-4c7187606fc1','541e778c-d93b-4b99-95c1-0bfbdb6027e9',0),('a8569179-0e39-4299-8c76-f74db95face1','1','f9a6bd79-b4b3-4fb7-9fbd-4c7187606fc1','3b9d7ef1-d0dc-40b5-9e1e-e92e0e452b08',0),('a9714422-1e8f-490a-abac-770321c00763','0','f9a6bd79-b4b3-4fb7-9fbd-4c7187606fc1','0da3d8c0-b756-4b86-93c7-1c4ecdb8dc86',0);
/*!40000 ALTER TABLE `facility_organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `family_folder`
--

DROP TABLE IF EXISTS `family_folder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `family_folder` (
  `id` char(50) NOT NULL,
  `name` varchar(150) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `family_folder`
--

LOCK TABLES `family_folder` WRITE;
/*!40000 ALTER TABLE `family_folder` DISABLE KEYS */;
/*!40000 ALTER TABLE `family_folder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `family_member`
--

DROP TABLE IF EXISTS `family_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `family_member` (
  `id` char(50) NOT NULL,
  `fk_patient` char(50) DEFAULT NULL,
  `member_type` char(10) DEFAULT 'HEAD',
  `fk_folder` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `family_member`
--

LOCK TABLES `family_member` WRITE;
/*!40000 ALTER TABLE `family_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `family_member` ENABLE KEYS */;
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
  `name` varchar(150) DEFAULT NULL,
  `type` char(10) DEFAULT 'COUNTRY',
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `geographic`
--

LOCK TABLES `geographic` WRITE;
/*!40000 ALTER TABLE `geographic` DISABLE KEYS */;
INSERT INTO `geographic` VALUES ('','RSJ','Rasa Jaya','CITY','',0),('68309a5f-4606-46d3-ad20-996ed6c782d0','KAL-BAR','Kalimantan Barat','PROVINCE','',0),('c4c10aee-a3a1-4e6c-a08b-62d4e26414df','PNK','Pontianak','CITY','',0),('f5a12273-368d-4d39-851a-05da7bb04ab9','IN-ID','Indonesia','COUNTRY','',0);
/*!40000 ALTER TABLE `geographic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gl_account`
--

DROP TABLE IF EXISTS `gl_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gl_account` (
  `id` char(50) NOT NULL,
  `number` char(50) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `type` char(15) DEFAULT NULL,
  `fk_gl_account_parent` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gl_account`
--

LOCK TABLES `gl_account` WRITE;
/*!40000 ALTER TABLE `gl_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `gl_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gl_account_balance`
--

DROP TABLE IF EXISTS `gl_account_balance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gl_account_balance` (
  `id` char(50) NOT NULL,
  `fk_accounting_period` char(50) DEFAULT NULL,
  `fk_gl_account` char(50) DEFAULT NULL,
  `fk_currency` char(50) DEFAULT NULL,
  `debet_balance` decimal(10,0) DEFAULT NULL,
  `credit_balance` decimal(10,0) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gl_account_balance`
--

LOCK TABLES `gl_account_balance` WRITE;
/*!40000 ALTER TABLE `gl_account_balance` DISABLE KEYS */;
/*!40000 ALTER TABLE `gl_account_balance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods_issue`
--

DROP TABLE IF EXISTS `goods_issue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods_issue` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `fk_facility_source` char(50) DEFAULT NULL,
  `fk_transfer_request` char(50) DEFAULT NULL,
  `fk_person_issued_by` char(50) DEFAULT NULL,
  `version` varchar(45) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods_issue`
--

LOCK TABLES `goods_issue` WRITE;
/*!40000 ALTER TABLE `goods_issue` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods_issue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods_issue_item`
--

DROP TABLE IF EXISTS `goods_issue_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods_issue_item` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `fk_request_item` char(50) DEFAULT NULL,
  `fk_transfer_order` char(50) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods_issue_item`
--

LOCK TABLES `goods_issue_item` WRITE;
/*!40000 ALTER TABLE `goods_issue_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods_issue_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods_receive`
--

DROP TABLE IF EXISTS `goods_receive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods_receive` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `number` char(50) DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `fk_facility_destination` char(50) DEFAULT NULL,
  `fk_receiveable` char(50) DEFAULT NULL,
  `fk_person_received_by` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods_receive`
--

LOCK TABLES `goods_receive` WRITE;
/*!40000 ALTER TABLE `goods_receive` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods_receive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods_receive_item`
--

DROP TABLE IF EXISTS `goods_receive_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods_receive_item` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `fk_goods_receive` char(50) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods_receive_item`
--

LOCK TABLES `goods_receive_item` WRITE;
/*!40000 ALTER TABLE `goods_receive_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods_receive_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods_transfer`
--

DROP TABLE IF EXISTS `goods_transfer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods_transfer` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `number` char(50) DEFAULT NULL,
  `fk_organization_source` char(50) DEFAULT NULL,
  `fk_organization_destination` char(50) DEFAULT NULL,
  `fk_facility_from` char(50) DEFAULT NULL,
  `fk_facility_to` char(50) DEFAULT NULL,
  `fk_transfer_order_request` char(50) DEFAULT NULL,
  `fk_person_transfered_by` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods_transfer`
--

LOCK TABLES `goods_transfer` WRITE;
/*!40000 ALTER TABLE `goods_transfer` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods_transfer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods_transfer_item`
--

DROP TABLE IF EXISTS `goods_transfer_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods_transfer_item` (
  `id` char(50) NOT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `fk_transfer_order_request_item` char(50) DEFAULT NULL,
  `fk_goods_transfer` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods_transfer_item`
--

LOCK TABLES `goods_transfer_item` WRITE;
/*!40000 ALTER TABLE `goods_transfer_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods_transfer_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inbox`
--

DROP TABLE IF EXISTS `inbox`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inbox` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `is_open` char(1) DEFAULT '0',
  `title` varchar(150) DEFAULT NULL,
  `fk_sender` char(50) DEFAULT NULL,
  `fk_receiver` char(50) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `type` char(10) DEFAULT 'Standard',
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inbox`
--

LOCK TABLES `inbox` WRITE;
/*!40000 ALTER TABLE `inbox` DISABLE KEYS */;
/*!40000 ALTER TABLE `inbox` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `internal_organization`
--

DROP TABLE IF EXISTS `internal_organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `internal_organization` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `internal_organization`
--

LOCK TABLES `internal_organization` WRITE;
/*!40000 ALTER TABLE `internal_organization` DISABLE KEYS */;
INSERT INTO `internal_organization` VALUES ('9f2528c0-ba70-4841-864c-05d820c9fec3'),('a30768a9-ca5f-4906-aa18-1a50155e881b');
/*!40000 ALTER TABLE `internal_organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory_item`
--

DROP TABLE IF EXISTS `inventory_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventory_item` (
  `id` char(50) NOT NULL,
  `serial_number` varchar(50) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `onhand` decimal(10,0) DEFAULT NULL,
  `fk_facility` char(50) DEFAULT NULL,
  `expired_date` date DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory_item`
--

LOCK TABLES `inventory_item` WRITE;
/*!40000 ALTER TABLE `inventory_item` DISABLE KEYS */;
INSERT INTO `inventory_item` VALUES ('794bc229-0bdd-4157-ab66-8f48353d7bc2',NULL,'931b0d7e-cd0b-43da-a5b5-0abaef5bf292',23,'f9a6bd79-b4b3-4fb7-9fbd-4c7187606fc1','2019-06-18',1),('c42591e9-75c7-4de4-a4de-873d5a27fd2b',NULL,'4cb083d9-1ba1-4b01-99cb-f2529cbca845',23,'f9a6bd79-b4b3-4fb7-9fbd-4c7187606fc1','2019-06-18',1);
/*!40000 ALTER TABLE `inventory_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `journal_entry`
--

DROP TABLE IF EXISTS `journal_entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `journal_entry` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `total_debet` decimal(10,0) DEFAULT NULL,
  `total_credit` char(50) DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `fk_organization_account` char(50) DEFAULT NULL,
  `fk_accounting_period` char(50) DEFAULT NULL,
  `fk_currency` char(50) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `is_posted` char(1) DEFAULT '0',
  `is_auto` char(1) DEFAULT '0',
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `journal_entry`
--

LOCK TABLES `journal_entry` WRITE;
/*!40000 ALTER TABLE `journal_entry` DISABLE KEYS */;
/*!40000 ALTER TABLE `journal_entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `journal_entry_detail`
--

DROP TABLE IF EXISTS `journal_entry_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `journal_entry_detail` (
  `id` char(50) NOT NULL,
  `fk_gl_account` char(50) DEFAULT NULL,
  `type` char(6) DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `fk_journal_entry` char(50) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_journal_posting` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `journal_entry_detail`
--

LOCK TABLES `journal_entry_detail` WRITE;
/*!40000 ALTER TABLE `journal_entry_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `journal_entry_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `journal_posting`
--

DROP TABLE IF EXISTS `journal_posting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `journal_posting` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `type` char(6) DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `fk_gl_account_balance` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `journal_posting`
--

LOCK TABLES `journal_posting` WRITE;
/*!40000 ALTER TABLE `journal_posting` DISABLE KEYS */;
/*!40000 ALTER TABLE `journal_posting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `journal_setting`
--

DROP TABLE IF EXISTS `journal_setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `journal_setting` (
  `id` char(50) NOT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `fk_gl_account_cash` char(50) DEFAULT NULL,
  `fk_gl_account_sales` char(50) DEFAULT NULL,
  `fk_gl_account_ppn_payable` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `journal_setting`
--

LOCK TABLES `journal_setting` WRITE;
/*!40000 ALTER TABLE `journal_setting` DISABLE KEYS */;
/*!40000 ALTER TABLE `journal_setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laboratory`
--

DROP TABLE IF EXISTS `laboratory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `laboratory` (
  `id` char(50) NOT NULL,
  `is_bpjs` char(1) DEFAULT '0',
  `bpjs_payment_status` char(10) DEFAULT NULL,
  `lab_handling_status` char(10) DEFAULT NULL,
  `is_personal` char(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laboratory`
--

LOCK TABLES `laboratory` WRITE;
/*!40000 ALTER TABLE `laboratory` DISABLE KEYS */;
INSERT INTO `laboratory` VALUES ('03175eef-c7cc-4af2-9f55-e1283ceb581f','1','UNPAID','Registered','0');
/*!40000 ALTER TABLE `laboratory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laboratory_item`
--

DROP TABLE IF EXISTS `laboratory_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `laboratory_item` (
  `id` char(50) NOT NULL,
  `fk_product_service` char(50) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `discount` decimal(10,0) DEFAULT NULL,
  `charge` decimal(10,0) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_laboratory` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laboratory_item`
--

LOCK TABLES `laboratory_item` WRITE;
/*!40000 ALTER TABLE `laboratory_item` DISABLE KEYS */;
INSERT INTO `laboratory_item` VALUES ('a55cfcf7-3b93-461a-a50d-506b6e8462b7','0402afd1-d3d0-4cfa-a81d-33e489718ba9',1,75000,0,0,'','03175eef-c7cc-4af2-9f55-e1283ceb581f',0);
/*!40000 ALTER TABLE `laboratory_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_record`
--

DROP TABLE IF EXISTS `medical_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medical_record` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `anamnesis` varchar(250) DEFAULT NULL,
  `checking_result` varchar(250) DEFAULT NULL,
  `diagnosis` varchar(250) DEFAULT NULL,
  `fk_patient` char(50) DEFAULT NULL,
  `fk_doctor` char(50) DEFAULT NULL,
  `fk_doctor_appointment` char(50) DEFAULT NULL,
  `fk_medication` char(50) DEFAULT NULL,
  `fk_treatment` char(50) DEFAULT NULL,
  `fk_laboratory` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_record`
--

LOCK TABLES `medical_record` WRITE;
/*!40000 ALTER TABLE `medical_record` DISABLE KEYS */;
INSERT INTO `medical_record` VALUES ('1e9a746a-d25f-4ef3-bfd3-4267a4735502','2016-06-18','a','b','c',NULL,NULL,'158d7dec-8111-4bf2-86be-29ff8b413bb8','55432498-4ec8-44fa-a677-b5a4a304d742','70ac451e-2798-4f73-94da-794f794a3dcd','03175eef-c7cc-4af2-9f55-e1283ceb581f',0);
/*!40000 ALTER TABLE `medical_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_sales`
--

DROP TABLE IF EXISTS `medical_sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medical_sales` (
  `id` char(50) NOT NULL,
  `queue` int(11) DEFAULT NULL,
  `time` time DEFAULT NULL,
  `status` char(15) DEFAULT 'Registered',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_sales`
--

LOCK TABLES `medical_sales` WRITE;
/*!40000 ALTER TABLE `medical_sales` DISABLE KEYS */;
INSERT INTO `medical_sales` VALUES ('55432498-4ec8-44fa-a677-b5a4a304d742',2,'20:51:13','Registered'),('d2e25b48-2870-47ea-b12c-9eccd7f31b9a',1,'17:41:50','Finished');
/*!40000 ALTER TABLE `medical_sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medication`
--

DROP TABLE IF EXISTS `medication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medication` (
  `id` char(50) NOT NULL,
  `is_bpjs` char(1) DEFAULT '0',
  `bpjs_payment_status` char(10) DEFAULT NULL,
  `medication_status` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medication`
--

LOCK TABLES `medication` WRITE;
/*!40000 ALTER TABLE `medication` DISABLE KEYS */;
INSERT INTO `medication` VALUES ('55432498-4ec8-44fa-a677-b5a4a304d742','1','UNPAID',NULL);
/*!40000 ALTER TABLE `medication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medication_item`
--

DROP TABLE IF EXISTS `medication_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medication_item` (
  `id` char(50) NOT NULL,
  `fk_product_medicine` char(50) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `discount` decimal(10,0) DEFAULT NULL,
  `charge` decimal(10,0) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_medication` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medication_item`
--

LOCK TABLES `medication_item` WRITE;
/*!40000 ALTER TABLE `medication_item` DISABLE KEYS */;
INSERT INTO `medication_item` VALUES ('42e2d173-2db7-4a96-bd64-317972f9a0fb','4cb083d9-1ba1-4b01-99cb-f2529cbca845',1,2500,0,0,'','55432498-4ec8-44fa-a677-b5a4a304d742',0),('cbe556f5-0e01-4582-8a9b-7e3b539abdd7','931b0d7e-cd0b-43da-a5b5-0abaef5bf292',1,3000,0,0,'','55432498-4ec8-44fa-a677-b5a4a304d742',0);
/*!40000 ALTER TABLE `medication_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `title` varchar(150) DEFAULT NULL,
  `fk_sender` char(50) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `type` char(10) DEFAULT 'Draft',
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_receiver`
--

DROP TABLE IF EXISTS `message_receiver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message_receiver` (
  `id` char(50) NOT NULL,
  `fk_receiver` char(50) DEFAULT NULL,
  `fk_message` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_receiver`
--

LOCK TABLES `message_receiver` WRITE;
/*!40000 ALTER TABLE `message_receiver` DISABLE KEYS */;
/*!40000 ALTER TABLE `message_receiver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mix_role`
--

DROP TABLE IF EXISTS `mix_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mix_role` (
  `id` char(50) NOT NULL,
  `fk_party_from` char(50) DEFAULT NULL,
  `fk_party_to` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mix_role`
--

LOCK TABLES `mix_role` WRITE;
/*!40000 ALTER TABLE `mix_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `mix_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `module`
--

DROP TABLE IF EXISTS `module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `module` (
  `id` char(50) NOT NULL,
  `code` varchar(150) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `module_group` char(25) DEFAULT 'GENERAL',
  `is_enabled` char(1) DEFAULT '1',
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `module`
--

LOCK TABLES `module` WRITE;
/*!40000 ALTER TABLE `module` DISABLE KEYS */;
INSERT INTO `module` VALUES ('07452775-a048-4071-8798-21dc943fe926','PRODUCT','Product','','INVENTORY','0',0),('0b503053-31eb-410d-90a6-ec6a9977bc1e','FAMILY_FOLDER','Family Folder','','CLINIC','0',0),('13989b38-ac2c-47b8-8708-5e27477af18d','BENEFIT_TYPE','Benefit Type','','HR','0',0),('1adc4b8b-ad93-4658-8476-6bb13e2e810d','PURCHASE_ORDER_REQUEST','Purchase Order Request','','PROCUREMENT','0',0),('1cf392fc-4f93-4e38-9709-2beb84434951','DOCTORTYPE','Doctor Type','','CLINIC','0',0),('29ec80f0-0d4c-451c-ae5e-f195c4be1a27','COMPANY_STRUCTURE','Company Structure','','GENERAL','0',0),('2bdc3f95-c5bd-47d9-adce-9e9df1042e2f','BUDGET_APPROVER','Budget Approver','','ACCOUNTING','0',0),('2d7e5641-511d-43fd-a6d6-a482120f8aa5','BUDGET','Budget','','ACCOUNTING','0',0),('314a3f13-a982-4915-a5cb-455eacbc27ae','INBOX','Inbox Message','','SYSTEM','0',0),('322d37f6-a667-481e-bc22-db212d0154ea','EMPYAPP','Employment Application','','HR','0',0),('342b0b64-291f-4d12-bdb8-77186895d21d','SALES_REPORT','Sales Report','','SALES','0',0),('4939e42f-06b5-4e44-b3ba-4106964f1f68','ACCOUNTINGPERIOD','Accounting Period','','ACCOUNTING','0',0),('4b3bb551-173e-46f5-b1e9-bdd719e3045e','COA','General Chart of Account','','ACCOUNTING','0',0),('4bf39427-b32a-434c-bd71-4d9493ea6eef','STOCK_OPNAME','Stock Opname','','INVENTORY','0',0),('4eb93eb7-2100-49ae-bd96-a39995ed5670','USER','User','Application User Module','SECURITY','1',0),('4eca5501-a650-41d5-87c1-c091391d3608','CASHSALES','Cash Sales','','SALES','0',0),('55b7e0fb-a178-478b-a09e-4b753f161aeb','MEDICATION','Medication','','CLINIC','0',0),('58621810-2c8f-44ae-b9aa-b1e05ad32743','SUPPLIER','Supplier','','PROCUREMENT','0',0),('5c37296e-ab30-4d07-bba3-342d4c403f48','INVITEM','Inventory Item','','INVENTORY','0',0),('5cdd1545-8fdb-4a79-b2a3-0662ed6fec30','POSITIONTYPERATE','Position Type Rate','','HR','0',0),('5e8c4a66-e46a-4000-ae1c-bf536686b30f','TRN_ORDER_REQ','Transfer Order Request','','INVENTORY','0',0),('627fb961-6cf0-4148-9451-0d1422095eb7','PURCHASE_ORDER_APPROVER','Purchase Order Request Approver','','PROCUREMENT','0',0),('65414caf-3a73-4e3f-9a58-2d70c723b5bc','CURRENCY','Currency','GENERAL','ACCOUNTING','0',1),('6861d3b3-8110-46ed-8a3a-830963597fa7','TAX','Tax','','ACCOUNTING','0',0),('69443009-4a15-4061-b9f0-08c08c8f50aa','JOURNALENTRY','Journal Entry','','ACCOUNTING','0',0),('6cbaf072-6925-46e9-b417-17326f3d8584','EMPLOYMENT','Employment','','HR','0',0),('770c420c-f809-43f7-969c-b493f0b4ef48','CASHIER','Cashier','','SALES','0',0),('7bef1d92-0f15-43ef-b59b-5bc3e769d896','UOM','Unit of Measure','','INVENTORY','0',0),('80aebe74-399c-4273-9145-956a077d3f5d','ACCESS_ROLE','Role','Application Access Role','SECURITY','1',0),('8217c196-16b9-44fb-9662-8323220ee705','ASSET','Asset Management','','ASSET','0',0),('83b19678-9f2f-49f4-ba25-0f31a8dee078','PHARMACY_ORDER','Pharmacy Order','','PHARMACY','0',0),('847a8df6-bc04-4de6-8d7d-28e41c00f422','DOCTOR_APPOINTMENT','Doctor Appointment','','CLINIC','0',0),('855aab16-cb45-41c3-b62c-55185ff77dfc','PHARMACY_SALES','Pharmacy Sales','','PHARMACY','0',0),('88bf4008-c84a-4089-88c6-e9d8f077a196','JOURNALSETTING','Journal Setting','','ACCOUNTING','0',0),('8c7e1020-0824-4239-9a4e-46301c80b9cd','PAYMENT_METHOD_TYPE','Payment Method Type','','PAYMENT','0',0),('8f6ec9c8-e9ed-49e1-ab7a-c4a868b8391e','ORGANIZATIONACCOUNT','Organization Account','','ACCOUNTING','0',0),('90195ecb-4674-4614-a429-eebc24ffe773','POSITIONTYPE','Position Type','','HR','0',0),('916b22eb-48fa-4000-b7a2-7fc1d47ced4e','STOCK_ADJUSTMENT','Stock Adjustment','','INVENTORY','0',0),('9178e8cd-4063-4fe9-a060-d2e3ac818ed1','PAYCHECK','Paycheck','','PAYMENT','0',0),('95dd39dd-512e-414e-b95c-0fc251887f98','PRDCATEGORY','Product Category','','INVENTORY','0',0),('99623cbd-066f-4cc2-b9b3-1961bed131cc','GOODS_TRANSFER','Goods Transfer','','INVENTORY','0',0),('9b9e014c-7a23-40c1-8841-30044564bf7f','MODULE','Module','Application Module','SECURITY','1',0),('9b9e014c-7a23-40c1-8841-30044564bf7x','SYSTEM','System Access','System Access','SYSTEM','1',0),('9df71b1a-0e52-4445-98ea-b9a59ad81ac9','PATIENT','Patient','','CLINIC','0',0),('9e644628-121d-4954-8a66-8002cc866bda','STOCK_ADMIN','Stock Admin','','INVENTORY','0',0),('a4aa9ae0-5166-4d06-afd1-d2eea6f2417c','PERSON','Person Management','','GENERAL','0',0),('a4c43802-436f-407c-8793-323600c181d7','GOODS_RECEIVE','Goods Receive','','INVENTORY','0',0),('abfd9a02-3b4b-47a0-9048-a65b6be0b3aa','PRODUCT_RETUR','Product Retur','','INVENTORY','0',0),('b54c8e49-c820-4292-9f74-9e47bd55711f','CASH_PURCHASE_ORDER','Cash Purchase Order','','PROCUREMENT','0',0),('b662de02-f4a3-4f1a-819b-5d2aaf6a342b','GOODS_ISSUE','Goods Issue','','INVENTORY','0',0),('b9935030-f5c1-479e-9ec1-795afc1c1e7e','FACILITY','Facility','','INVENTORY','0',0),('d33784ca-abd5-422b-b45a-8c8ee13ddc0a','DEDUCTION_TYPE','Deduction Type','','PAYMENT','0',0),('dbc9175e-eb27-45e9-9e43-a1c12d6354e4','DOCTOR','Doctor','','CLINIC','0',0),('e4307d82-f3fa-4916-9e6b-7a4f894d847e','ORGANIZATION','Organization','','GENERAL','0',0),('e8f89299-2138-4167-b5b7-52f6ae1667ca','POSITION','Position','','HR','0',0),('e916392a-0b3c-4543-ada7-93054383bb3b','MESSAGE','Message','','SYSTEM','0',0),('f50dd16d-0e25-44b6-bd69-c28dfcc55300','GEOGRAPHIC','Geographic','','GENERAL','0',0),('f53b80db-1b89-4779-86e7-b065b5287bbb','ASSET_TYPE','Asset Type','','ASSET','0',0),('fca1cfcf-d199-4729-a321-e1ed01deb0f1','LABS_REGISTRATION','Laboratory Registration','','MEDICALLAB','0',0);
/*!40000 ALTER TABLE `module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item`
--

DROP TABLE IF EXISTS `order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_item` (
  `id` char(50) NOT NULL,
  `fk_purchase_order` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_payment`
--

DROP TABLE IF EXISTS `order_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_payment` (
  `id` char(50) NOT NULL,
  `fk_purchase_order` char(50) DEFAULT NULL,
  `fk_payment_item` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_payment`
--

LOCK TABLES `order_payment` WRITE;
/*!40000 ALTER TABLE `order_payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organization`
--

DROP TABLE IF EXISTS `organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organization` (
  `id` char(50) NOT NULL,
  `industry_type` char(12) DEFAULT 'GENERAL',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization`
--

LOCK TABLES `organization` WRITE;
/*!40000 ALTER TABLE `organization` DISABLE KEYS */;
INSERT INTO `organization` VALUES ('0b7252be-8c14-42bf-b7bc-6e67ffb882d1','MEDICAL'),('0da3d8c0-b756-4b86-93c7-1c4ecdb8dc86','MEDICAL'),('3b9d7ef1-d0dc-40b5-9e1e-e92e0e452b08','MEDICAL'),('541e778c-d93b-4b99-95c1-0bfbdb6027e9','GENERAL'),('5f1e725a-c099-4e9a-8ff0-6bad5b358c27','MEDICAL'),('e90147a4-da91-43d6-8124-5276d829b6d1','MEDICAL');
/*!40000 ALTER TABLE `organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organization_account`
--

DROP TABLE IF EXISTS `organization_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organization_account` (
  `id` char(50) NOT NULL,
  `name` varchar(150) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `status` char(1) DEFAULT '0',
  `fk_organization` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization_account`
--

LOCK TABLES `organization_account` WRITE;
/*!40000 ALTER TABLE `organization_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `organization_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organization_gl_account`
--

DROP TABLE IF EXISTS `organization_gl_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organization_gl_account` (
  `id` char(50) NOT NULL,
  `is_selected` char(1) DEFAULT '0',
  `fk_account` char(50) DEFAULT NULL,
  `fk_organization_account` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization_gl_account`
--

LOCK TABLES `organization_gl_account` WRITE;
/*!40000 ALTER TABLE `organization_gl_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `organization_gl_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organization_role`
--

DROP TABLE IF EXISTS `organization_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organization_role` (
  `id` char(50) NOT NULL,
  `fk_organization_from` char(50) DEFAULT NULL,
  `fk_organization_to` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization_role`
--

LOCK TABLES `organization_role` WRITE;
/*!40000 ALTER TABLE `organization_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `organization_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `party`
--

DROP TABLE IF EXISTS `party`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `party` (
  `id` char(50) NOT NULL,
  `name` varchar(150) DEFAULT NULL,
  `fk_geographic_birth_place` char(50) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `tax_code` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  `identity` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party`
--

LOCK TABLES `party` WRITE;
/*!40000 ALTER TABLE `party` DISABLE KEYS */;
INSERT INTO `party` VALUES ('0b7252be-8c14-42bf-b7bc-6e67ffb882d1','Johan Healthcare',NULL,'2010-06-01','',0,NULL),('0da3d8c0-b756-4b86-93c7-1c4ecdb8dc86','Clinic & Apotik Rasa',NULL,'2010-06-01','',0,NULL),('10fe16f0-3f2c-4995-b6c3-5f5447597a12','Anonymous',NULL,'2000-06-18','',0,'00000'),('3b9d7ef1-d0dc-40b5-9e1e-e92e0e452b08','Clinic & Apotik P.Aim',NULL,'2010-06-01','',0,NULL),('504c9e43-02ff-4034-96ea-e76ca764231e','dewi',NULL,'2016-06-18',NULL,0,'00000001'),('541e778c-d93b-4b99-95c1-0bfbdb6027e9','Johan Corporation',NULL,'2010-06-01','',0,NULL),('5f1e725a-c099-4e9a-8ff0-6bad5b358c27','PT Kimia Farma','68309a5f-4606-46d3-ad20-996ed6c782d0','2016-06-18',NULL,0,'00000101'),('a60c79fb-e54b-41fe-aaab-a715e42edef4','Dr. Johan Molana',NULL,'2005-06-17',NULL,0,'000000000'),('e90147a4-da91-43d6-8124-5276d829b6d1','PT Kable Farma','68309a5f-4606-46d3-ad20-996ed6c782d0','2016-06-18',NULL,0,'00000100');
/*!40000 ALTER TABLE `party` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `party_relationship`
--

DROP TABLE IF EXISTS `party_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `party_relationship` (
  `id` char(50) NOT NULL,
  `date_from` date DEFAULT NULL,
  `date_to` date DEFAULT NULL,
  `fk_role_from` char(50) DEFAULT NULL,
  `fk_role_to` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party_relationship`
--

LOCK TABLES `party_relationship` WRITE;
/*!40000 ALTER TABLE `party_relationship` DISABLE KEYS */;
INSERT INTO `party_relationship` VALUES ('3ae6cf16-f92c-4e02-92c1-eea98256c531','2016-06-18',NULL,NULL,NULL,0),('4b188994-6162-4c81-86fc-4895fe09f445','2016-06-18',NULL,NULL,NULL,0),('7a87f7e9-7927-450c-aa77-799f1d7076ef','2016-06-18',NULL,NULL,NULL,0),('a3d56d5f-4315-4db6-969c-f9f472c718ec','2016-06-18',NULL,NULL,NULL,0),('bea15201-d706-45ec-9126-5057b04827fd','2016-06-18',NULL,NULL,NULL,0),('dc6daf21-1de1-44d0-ad0d-6ff8dfe5cba7','2010-06-17',NULL,NULL,NULL,0);
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
  `date_from` date DEFAULT NULL,
  `date_to` date DEFAULT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party_role`
--

LOCK TABLES `party_role` WRITE;
/*!40000 ALTER TABLE `party_role` DISABLE KEYS */;
INSERT INTO `party_role` VALUES ('09403c5d-93b0-4250-9a2e-1451487b7b76','2016-06-18',NULL,'5f1e725a-c099-4e9a-8ff0-6bad5b358c27',0),('16ba1052-801c-4b80-9731-e23a6bc24f8b','2010-06-17',NULL,'a60c79fb-e54b-41fe-aaab-a715e42edef4',0),('6e869f14-99a9-4b38-882c-843cf0268d93','2016-06-18',NULL,'504c9e43-02ff-4034-96ea-e76ca764231e',0),('708a4896-aec2-49e3-ab9c-cf9e7dc0ccbb','2016-06-18',NULL,'e90147a4-da91-43d6-8124-5276d829b6d1',0),('9e59f471-f728-4439-8f51-4dae16868327','2016-06-18',NULL,'a60c79fb-e54b-41fe-aaab-a715e42edef4',0),('9f2528c0-ba70-4841-864c-05d820c9fec3','2016-06-18',NULL,'3b9d7ef1-d0dc-40b5-9e1e-e92e0e452b08',0),('a30768a9-ca5f-4906-aa18-1a50155e881b','2010-06-17',NULL,'541e778c-d93b-4b99-95c1-0bfbdb6027e9',0),('c3543237-5b5a-4879-bbda-5ca90ef47146','2016-06-18',NULL,'504c9e43-02ff-4034-96ea-e76ca764231e',0);
/*!40000 ALTER TABLE `party_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `id` char(50) NOT NULL,
  `fk_bpjs` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES ('6e869f14-99a9-4b38-882c-843cf0268d93','9f739427-44e0-4079-bfab-b28bea9d100a');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_relationship`
--

DROP TABLE IF EXISTS `patient_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient_relationship` (
  `id` char(50) NOT NULL,
  `fk_patient` char(50) DEFAULT NULL,
  `fk_internal_organization` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_relationship`
--

LOCK TABLES `patient_relationship` WRITE;
/*!40000 ALTER TABLE `patient_relationship` DISABLE KEYS */;
INSERT INTO `patient_relationship` VALUES ('4b188994-6162-4c81-86fc-4895fe09f445','6e869f14-99a9-4b38-882c-843cf0268d93','9f2528c0-ba70-4841-864c-05d820c9fec3');
/*!40000 ALTER TABLE `patient_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_history`
--

DROP TABLE IF EXISTS `pay_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_history` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `period_type` char(15) DEFAULT NULL,
  `fk_employment` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_history`
--

LOCK TABLES `pay_history` WRITE;
/*!40000 ALTER TABLE `pay_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `pay_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payable`
--

DROP TABLE IF EXISTS `payable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payable` (
  `id` char(50) NOT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payable`
--

LOCK TABLES `payable` WRITE;
/*!40000 ALTER TABLE `payable` DISABLE KEYS */;
/*!40000 ALTER TABLE `payable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paycheck`
--

DROP TABLE IF EXISTS `paycheck`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paycheck` (
  `id` char(50) NOT NULL,
  `fk_employee` char(50) DEFAULT NULL,
  `fk_employer` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paycheck`
--

LOCK TABLES `paycheck` WRITE;
/*!40000 ALTER TABLE `paycheck` DISABLE KEYS */;
/*!40000 ALTER TABLE `paycheck` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `id` char(50) NOT NULL,
  `reference` char(50) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `fk_payment_method_type` char(50) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES ('5ffc5715-2493-42e8-8dc0-3b73add3871f','','2016-06-18',8800,NULL,NULL,0),('82cda33a-5c64-46f0-9b62-9e996ef16548','','2016-06-18',17600,'45f796c0-db2f-4c28-9aa5-b7acf8eb2cef',NULL,0);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_item`
--

DROP TABLE IF EXISTS `payment_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment_item` (
  `id` char(50) NOT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_item`
--

LOCK TABLES `payment_item` WRITE;
/*!40000 ALTER TABLE `payment_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_method_type`
--

DROP TABLE IF EXISTS `payment_method_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment_method_type` (
  `id` char(50) NOT NULL,
  `name` varchar(150) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_method_type`
--

LOCK TABLES `payment_method_type` WRITE;
/*!40000 ALTER TABLE `payment_method_type` DISABLE KEYS */;
INSERT INTO `payment_method_type` VALUES ('0739d081-5701-42ef-9e90-e3e0bfbcf112','Mandiri Debit','Debit Bank Mandiri',0),('3ae9fec0-0091-48da-8862-58589a5b44c4','Mandiri CC','Credit Card Bank Mandiri',0),('45f796c0-db2f-4c28-9aa5-b7acf8eb2cef','Cash','Cash',0),('77234c65-dee4-4c10-8ae4-a97ca0311a88','BPJS','BPJS',0);
/*!40000 ALTER TABLE `payment_method_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payroll_preference`
--

DROP TABLE IF EXISTS `payroll_preference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payroll_preference` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `fk_payment_method_type` char(50) DEFAULT NULL,
  `percent` decimal(10,0) DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `bank_number` char(50) DEFAULT NULL,
  `bank_name` varchar(150) DEFAULT NULL,
  `period_type` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payroll_preference`
--

LOCK TABLES `payroll_preference` WRITE;
/*!40000 ALTER TABLE `payroll_preference` DISABLE KEYS */;
/*!40000 ALTER TABLE `payroll_preference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id` char(50) NOT NULL,
  `identity` varchar(100) DEFAULT NULL,
  `gender` char(10) DEFAULT 'MALE',
  `marital_status` char(10) DEFAULT 'SINGLE',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES ('10fe16f0-3f2c-4995-b6c3-5f5447597a12',NULL,'MALE','SINGLE'),('504c9e43-02ff-4034-96ea-e76ca764231e',NULL,'FEMALE','MARIED'),('a60c79fb-e54b-41fe-aaab-a715e42edef4',NULL,'MALE','MARIED');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_role`
--

DROP TABLE IF EXISTS `person_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person_role` (
  `id` char(50) NOT NULL,
  `fk_organization_to` char(50) DEFAULT NULL,
  `fk_organization_from` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_role`
--

LOCK TABLES `person_role` WRITE;
/*!40000 ALTER TABLE `person_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `person_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pharmacy_sales`
--

DROP TABLE IF EXISTS `pharmacy_sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pharmacy_sales` (
  `id` char(50) NOT NULL,
  `is_reference` char(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pharmacy_sales`
--

LOCK TABLES `pharmacy_sales` WRITE;
/*!40000 ALTER TABLE `pharmacy_sales` DISABLE KEYS */;
INSERT INTO `pharmacy_sales` VALUES ('d2e25b48-2870-47ea-b12c-9eccd7f31b9a','0');
/*!40000 ALTER TABLE `pharmacy_sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pharmacy_sales_item`
--

DROP TABLE IF EXISTS `pharmacy_sales_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pharmacy_sales_item` (
  `id` char(50) NOT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `discount` decimal(10,0) DEFAULT NULL,
  `charge` decimal(10,0) DEFAULT NULL,
  `fk_pharmacy_sales` char(50) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pharmacy_sales_item`
--

LOCK TABLES `pharmacy_sales_item` WRITE;
/*!40000 ALTER TABLE `pharmacy_sales_item` DISABLE KEYS */;
INSERT INTO `pharmacy_sales_item` VALUES ('4512a6a5-9aaa-4016-b777-3c1f3236cb6b','4cb083d9-1ba1-4b01-99cb-f2529cbca845',2,3000,0,0,'d2e25b48-2870-47ea-b12c-9eccd7f31b9a','',0),('a54e9dd0-fab3-4797-bcf4-70d2e72e84df','931b0d7e-cd0b-43da-a5b5-0abaef5bf292',2,5000,0,0,'d2e25b48-2870-47ea-b12c-9eccd7f31b9a','',0);
/*!40000 ALTER TABLE `pharmacy_sales_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `position` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `actual_start_date` date DEFAULT NULL,
  `actual_end_date` date DEFAULT NULL,
  `worktime_status` char(15) DEFAULT NULL,
  `temporary_status` char(15) DEFAULT NULL,
  `salary_status` char(15) DEFAULT NULL,
  `position_status_type` char(15) DEFAULT NULL,
  `fk_budget_item` char(50) DEFAULT NULL,
  `fk_position_type` char(50) DEFAULT NULL,
  `fk_organization_owner` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES ('ecaceb93-e90c-40a4-8374-6be9b46b8abc','2016-06-18',NULL,NULL,NULL,'Fulltime','Permanent','Monthly','Planned',NULL,'9b7fcac1-784c-4632-af90-419cababac54',NULL,5),('f97664ae-61bf-4816-b532-0bb9b2e6f2f0','2010-06-17',NULL,'2010-06-01',NULL,'Fulltime','Permanent','Monthly','Open',NULL,'17a5d46a-f12b-43d9-a7e7-38371d7df057',NULL,0);
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position_fulfillment`
--

DROP TABLE IF EXISTS `position_fulfillment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `position_fulfillment` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_person_employee` char(50) DEFAULT NULL,
  `fk_position` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position_fulfillment`
--

LOCK TABLES `position_fulfillment` WRITE;
/*!40000 ALTER TABLE `position_fulfillment` DISABLE KEYS */;
/*!40000 ALTER TABLE `position_fulfillment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position_reporting_structure`
--

DROP TABLE IF EXISTS `position_reporting_structure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `position_reporting_structure` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `is_primary` char(1) DEFAULT '0',
  `fk_position_reporting_to` char(50) DEFAULT NULL,
  `fk_position_parent` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position_reporting_structure`
--

LOCK TABLES `position_reporting_structure` WRITE;
/*!40000 ALTER TABLE `position_reporting_structure` DISABLE KEYS */;
/*!40000 ALTER TABLE `position_reporting_structure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position_responsibility`
--

DROP TABLE IF EXISTS `position_responsibility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `position_responsibility` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_position` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position_responsibility`
--

LOCK TABLES `position_responsibility` WRITE;
/*!40000 ALTER TABLE `position_responsibility` DISABLE KEYS */;
/*!40000 ALTER TABLE `position_responsibility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position_type`
--

DROP TABLE IF EXISTS `position_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `position_type` (
  `id` char(50) NOT NULL,
  `title` varchar(150) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position_type`
--

LOCK TABLES `position_type` WRITE;
/*!40000 ALTER TABLE `position_type` DISABLE KEYS */;
INSERT INTO `position_type` VALUES ('17a5d46a-f12b-43d9-a7e7-38371d7df057','CEO','CEO',0),('9b7fcac1-784c-4632-af90-419cababac54','Stock Admin','Stock Admin',0);
/*!40000 ALTER TABLE `position_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position_type_rate`
--

DROP TABLE IF EXISTS `position_type_rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `position_type_rate` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `fk_currency` char(50) DEFAULT NULL,
  `fk_position_type` char(50) DEFAULT NULL,
  `rate_type` char(50) DEFAULT NULL,
  `period_type` char(25) DEFAULT NULL,
  `comment` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position_type_rate`
--

LOCK TABLES `position_type_rate` WRITE;
/*!40000 ALTER TABLE `position_type_rate` DISABLE KEYS */;
/*!40000 ALTER TABLE `position_type_rate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` char(50) NOT NULL,
  `code` char(50) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `fk_unit_of_measure` char(50) DEFAULT NULL,
  `fk_product_category` char(50) DEFAULT NULL,
  `type` char(15) DEFAULT NULL,
  `minimal_stock` int(11) DEFAULT '0',
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('0402afd1-d3d0-4cfa-a81d-33e489718ba9','Cek gula darah','Cek gula darah','2016-06-18',NULL,'0d54d0aa-3def-4622-8fcf-8a8b8c9c6593','82d85217-3f21-4420-a47d-3f3542e332b2','SERVICE',0,0),('4cb083d9-1ba1-4b01-99cb-f2529cbca845','Amoxicillin 250gr','Amoxicillin 250gr','2010-06-18',NULL,'7fd5cb7f-c6e5-4328-b275-07a0bc4f6722','5c4fc0fc-3849-48d7-ba26-c7d00ff38530','FINISHGOOD',10,0),('6d83bdea-0f3b-459f-9df6-b1a6c33d20b0','Pemeriksaan dokter umum','Pemeriksaan dokter umum','2010-06-18',NULL,'0d54d0aa-3def-4622-8fcf-8a8b8c9c6593','82d85217-3f21-4420-a47d-3f3542e332b2','SERVICE',0,0),('931b0d7e-cd0b-43da-a5b5-0abaef5bf292','Paracetamol','Paracetamol','2010-06-18',NULL,'7fd5cb7f-c6e5-4328-b275-07a0bc4f6722','5c4fc0fc-3849-48d7-ba26-c7d00ff38530','FINISHGOOD',10,0);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_category`
--

DROP TABLE IF EXISTS `product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_category` (
  `id` char(50) NOT NULL,
  `code` char(50) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `industry_segmentation` char(30) DEFAULT 'GENERAL',
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_category`
--

LOCK TABLES `product_category` WRITE;
/*!40000 ALTER TABLE `product_category` DISABLE KEYS */;
INSERT INTO `product_category` VALUES ('5c4fc0fc-3849-48d7-ba26-c7d00ff38530','Tablet','Tablet','','MEDICAL',0),('82d85217-3f21-4420-a47d-3f3542e332b2','Tindakan','Tindakan','','MEDICAL',0);
/*!40000 ALTER TABLE `product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_code`
--

DROP TABLE IF EXISTS `product_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_code` (
  `id` char(50) NOT NULL,
  `code` char(50) DEFAULT NULL,
  `type` char(10) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_code`
--

LOCK TABLES `product_code` WRITE;
/*!40000 ALTER TABLE `product_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_component`
--

DROP TABLE IF EXISTS `product_component`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_component` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `fk_product_component` char(50) DEFAULT NULL,
  `fk_product_parent` char(50) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_component`
--

LOCK TABLES `product_component` WRITE;
/*!40000 ALTER TABLE `product_component` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_component` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_cost`
--

DROP TABLE IF EXISTS `product_cost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_cost` (
  `id` char(50) NOT NULL,
  `estimated` decimal(10,0) DEFAULT NULL,
  `fk_geographic_for_area` char(50) DEFAULT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `type` char(15) DEFAULT NULL,
  `fk_currency` char(50) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_cost`
--

LOCK TABLES `product_cost` WRITE;
/*!40000 ALTER TABLE `product_cost` DISABLE KEYS */;
INSERT INTO `product_cost` VALUES ('25988fd5-80e2-4ec0-931f-e3c7623568f4',1500,NULL,'2010-06-18',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','4cb083d9-1ba1-4b01-99cb-f2529cbca845',0),('a6ae8d10-a4f4-4b8c-b601-ba3130a434c5',4000,NULL,'2010-06-18',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','931b0d7e-cd0b-43da-a5b5-0abaef5bf292',0),('c0c45469-aa6a-473d-a3a4-7243321764f2',50000,NULL,'2016-06-18',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','0402afd1-d3d0-4cfa-a81d-33e489718ba9',0);
/*!40000 ALTER TABLE `product_cost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_feature`
--

DROP TABLE IF EXISTS `product_feature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_feature` (
  `id` char(50) NOT NULL,
  `value` varchar(150) DEFAULT NULL,
  `type` char(10) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_feature`
--

LOCK TABLES `product_feature` WRITE;
/*!40000 ALTER TABLE `product_feature` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_feature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_price`
--

DROP TABLE IF EXISTS `product_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_price` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `fk_currency` char(50) DEFAULT NULL,
  `type` char(10) DEFAULT NULL,
  `fk_geographic` char(50) DEFAULT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_price`
--

LOCK TABLES `product_price` WRITE;
/*!40000 ALTER TABLE `product_price` DISABLE KEYS */;
INSERT INTO `product_price` VALUES ('2fe183b5-7a55-44d5-849d-da1728805de8','2016-06-18',NULL,50000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'6d83bdea-0f3b-459f-9df6-b1a6c33d20b0',0),('37494209-6e93-488b-bdad-8a444b4e6da2','2010-06-18',NULL,50000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BPJS',NULL,NULL,'6d83bdea-0f3b-459f-9df6-b1a6c33d20b0',0),('3d55fc80-7b2b-41f6-92ba-2c000f31bf3f','2016-06-18',NULL,75000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BPJS',NULL,NULL,'0402afd1-d3d0-4cfa-a81d-33e489718ba9',0),('589c113d-5a4e-4534-9404-65fad85ae48a','2016-06-18',NULL,100000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'0402afd1-d3d0-4cfa-a81d-33e489718ba9',0),('5d738541-3cf1-4788-82d2-655bc351cba5','2010-06-18',NULL,5000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'931b0d7e-cd0b-43da-a5b5-0abaef5bf292',0),('61da72e2-60f3-4b93-8b18-df28f22f4120','2010-06-18',NULL,6500,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'931b0d7e-cd0b-43da-a5b5-0abaef5bf292',0),('77c250c8-4f83-4720-81cb-776acbb6db3d','2010-06-18',NULL,5000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'4cb083d9-1ba1-4b01-99cb-f2529cbca845',0),('8f33e156-9ae7-41a9-bc7c-ba8bd7cb8d08','2010-06-18',NULL,3000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BPJS',NULL,NULL,'931b0d7e-cd0b-43da-a5b5-0abaef5bf292',0),('8f839252-dbb1-4c29-974d-6b08082532b8','2010-06-18',NULL,6500,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'931b0d7e-cd0b-43da-a5b5-0abaef5bf292',0),('c471f4ff-070a-4245-9927-b122f1842ef6','2010-06-18',NULL,2500,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BPJS',NULL,NULL,'4cb083d9-1ba1-4b01-99cb-f2529cbca845',0),('df723b8c-79e7-4875-b225-62107bb5d71a','2010-06-18',NULL,5000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'4cb083d9-1ba1-4b01-99cb-f2529cbca845',0),('f37f90a4-9189-4bea-a571-0b4969c9866b','2010-06-18',NULL,3000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'4cb083d9-1ba1-4b01-99cb-f2529cbca845',0);
/*!40000 ALTER TABLE `product_price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_receivable`
--

DROP TABLE IF EXISTS `product_receivable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_receivable` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `number` char(50) DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `status` char(10) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_receivable`
--

LOCK TABLES `product_receivable` WRITE;
/*!40000 ALTER TABLE `product_receivable` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_receivable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_retur`
--

DROP TABLE IF EXISTS `product_retur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_retur` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `fk_supplier` char(50) DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `fk_facility` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_retur`
--

LOCK TABLES `product_retur` WRITE;
/*!40000 ALTER TABLE `product_retur` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_retur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_retur_item`
--

DROP TABLE IF EXISTS `product_retur_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_retur_item` (
  `id` char(50) NOT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `expired_date` date DEFAULT NULL,
  `fk_product_retur` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_retur_item`
--

LOCK TABLES `product_retur_item` WRITE;
/*!40000 ALTER TABLE `product_retur_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_retur_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_supplier`
--

DROP TABLE IF EXISTS `product_supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_supplier` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `fk_party_supplier` char(50) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_supplier`
--

LOCK TABLES `product_supplier` WRITE;
/*!40000 ALTER TABLE `product_supplier` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_order`
--

DROP TABLE IF EXISTS `purchase_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_order` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `number` char(50) DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_tax` char(50) DEFAULT NULL,
  `fk_supplier` char(50) DEFAULT NULL,
  `fk_purchaser` char(50) DEFAULT NULL,
  `fk_currency` char(50) DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `fk_purchase_order_request` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_order`
--

LOCK TABLES `purchase_order` WRITE;
/*!40000 ALTER TABLE `purchase_order` DISABLE KEYS */;
INSERT INTO `purchase_order` VALUES ('607f39a6-f11a-4100-affb-e6774e6bceb2','2016-06-18','CSPO3','2016-06-18',NULL,'b685e80a-5257-49c7-9c7d-11b986a49b29','e90147a4-da91-43d6-8124-5276d829b6d1','504c9e43-02ff-4034-96ea-e76ca764231e','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3b9d7ef1-d0dc-40b5-9e1e-e92e0e452b08','996f5358-1c0d-456d-a4de-167469c504e8',0);
/*!40000 ALTER TABLE `purchase_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_order_item`
--

DROP TABLE IF EXISTS `purchase_order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_order_item` (
  `id` char(50) NOT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_purchase_order_request_item` char(50) DEFAULT NULL,
  `expired_date` date DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_order_item`
--

LOCK TABLES `purchase_order_item` WRITE;
/*!40000 ALTER TABLE `purchase_order_item` DISABLE KEYS */;
INSERT INTO `purchase_order_item` VALUES ('84233c28-8c6c-4767-b034-fd23f58dc04b','4cb083d9-1ba1-4b01-99cb-f2529cbca845',25,NULL,'df4f3883-9579-415c-82e7-58aa27594a58','2019-06-18',0),('dbbf895d-3d53-42ce-8412-e39c49eecdaa','931b0d7e-cd0b-43da-a5b5-0abaef5bf292',25,NULL,'afa5e535-abf8-400b-bd3f-f8765e462ef2','2019-06-18',0);
/*!40000 ALTER TABLE `purchase_order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_order_request`
--

DROP TABLE IF EXISTS `purchase_order_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_order_request` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_order_request`
--

LOCK TABLES `purchase_order_request` WRITE;
/*!40000 ALTER TABLE `purchase_order_request` DISABLE KEYS */;
INSERT INTO `purchase_order_request` VALUES ('996f5358-1c0d-456d-a4de-167469c504e8','2016-06-18');
/*!40000 ALTER TABLE `purchase_order_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_order_request_item`
--

DROP TABLE IF EXISTS `purchase_order_request_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_order_request_item` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `fk_purchase_order_request` char(50) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_order_request_item`
--

LOCK TABLES `purchase_order_request_item` WRITE;
/*!40000 ALTER TABLE `purchase_order_request_item` DISABLE KEYS */;
INSERT INTO `purchase_order_request_item` VALUES ('afa5e535-abf8-400b-bd3f-f8765e462ef2',25,'996f5358-1c0d-456d-a4de-167469c504e8','931b0d7e-cd0b-43da-a5b5-0abaef5bf292','',0),('df4f3883-9579-415c-82e7-58aa27594a58',25,'996f5358-1c0d-456d-a4de-167469c504e8','4cb083d9-1ba1-4b01-99cb-f2529cbca845','',0);
/*!40000 ALTER TABLE `purchase_order_request_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_order_request_review`
--

DROP TABLE IF EXISTS `purchase_order_request_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_order_request_review` (
  `id` char(50) NOT NULL,
  `fk_purchase_order_request` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_order_request_review`
--

LOCK TABLES `purchase_order_request_review` WRITE;
/*!40000 ALTER TABLE `purchase_order_request_review` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_order_request_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_order_request_role`
--

DROP TABLE IF EXISTS `purchase_order_request_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_order_request_role` (
  `id` char(50) NOT NULL,
  `fk_purchase_order_request` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_order_request_role`
--

LOCK TABLES `purchase_order_request_role` WRITE;
/*!40000 ALTER TABLE `purchase_order_request_role` DISABLE KEYS */;
INSERT INTO `purchase_order_request_role` VALUES ('3ef07ea5-af9f-4156-b2ad-375af68e4a41','996f5358-1c0d-456d-a4de-167469c504e8'),('61c49b2c-9cb8-4477-ba8a-7b75b7eec6d6','996f5358-1c0d-456d-a4de-167469c504e8'),('a0b0b393-4431-48cf-995e-1196c3209c2d','996f5358-1c0d-456d-a4de-167469c504e8');
/*!40000 ALTER TABLE `purchase_order_request_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_order_request_status`
--

DROP TABLE IF EXISTS `purchase_order_request_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_order_request_status` (
  `id` char(50) NOT NULL,
  `fk_purchase_order_request` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_order_request_status`
--

LOCK TABLES `purchase_order_request_status` WRITE;
/*!40000 ALTER TABLE `purchase_order_request_status` DISABLE KEYS */;
INSERT INTO `purchase_order_request_status` VALUES ('89f67ac1-3b89-404d-bbbc-783214b5c6f0','996f5358-1c0d-456d-a4de-167469c504e8'),('9cc85924-39d0-4448-9942-a33aa2733bd7','996f5358-1c0d-456d-a4de-167469c504e8');
/*!40000 ALTER TABLE `purchase_order_request_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receipt`
--

DROP TABLE IF EXISTS `receipt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receipt` (
  `id` char(50) NOT NULL,
  `fk_billable` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipt`
--

LOCK TABLES `receipt` WRITE;
/*!40000 ALTER TABLE `receipt` DISABLE KEYS */;
INSERT INTO `receipt` VALUES ('5ffc5715-2493-42e8-8dc0-3b73add3871f','39fbc6b4-c47a-4c27-a6e3-38ab146f0946'),('82cda33a-5c64-46f0-9b62-9e996ef16548','d2e25b48-2870-47ea-b12c-9eccd7f31b9a');
/*!40000 ALTER TABLE `receipt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `review` (
  `id` char(50) NOT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `result` varchar(250) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` char(50) NOT NULL,
  `code` varchar(150) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `Note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('096b0105-de76-492c-9bb0-5e518b46d69c','Sys Admin','System Administrator','System Administrator',NULL);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roled`
--

DROP TABLE IF EXISTS `roled`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roled` (
  `id` char(50) NOT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `role_type` char(10) DEFAULT NULL,
  `is_done` char(1) DEFAULT '0',
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roled`
--

LOCK TABLES `roled` WRITE;
/*!40000 ALTER TABLE `roled` DISABLE KEYS */;
INSERT INTO `roled` VALUES ('3ef07ea5-af9f-4156-b2ad-375af68e4a41','504c9e43-02ff-4034-96ea-e76ca764231e','Initiator','1',0),('61c49b2c-9cb8-4477-ba8a-7b75b7eec6d6','a60c79fb-e54b-41fe-aaab-a715e42edef4','Approver','1',1),('a0b0b393-4431-48cf-995e-1196c3209c2d','3b9d7ef1-d0dc-40b5-9e1e-e92e0e452b08','Requested','1',0);
/*!40000 ALTER TABLE `roled` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequence_number`
--

DROP TABLE IF EXISTS `sequence_number`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sequence_number` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `person_id` char(50) DEFAULT NULL,
  `organization_id` char(50) DEFAULT NULL,
  `code` char(10) DEFAULT NULL,
  `sequence` bigint(20) DEFAULT '1',
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence_number`
--

LOCK TABLES `sequence_number` WRITE;
/*!40000 ALTER TABLE `sequence_number` DISABLE KEYS */;
INSERT INTO `sequence_number` VALUES ('17891cfd-3658-4a9a-8fa3-537a6e673ec4','2016-06-18',NULL,'0b7252be-8c14-42bf-b7bc-6e67ffb882d1','CsPO',2,0),('359f594a-d00c-4b5d-b346-f6d30e6026f0','2016-06-18',NULL,'3b9d7ef1-d0dc-40b5-9e1e-e92e0e452b08','PHS',2,0),('8b271fae-ade5-45f9-b75b-b862f91fcc0c','2016-06-18',NULL,'3b9d7ef1-d0dc-40b5-9e1e-e92e0e452b08','BLMED',2,0),('c958376a-d581-4b6d-b70d-c9d1c5a8916e','2016-06-18',NULL,'3b9d7ef1-d0dc-40b5-9e1e-e92e0e452b08','CsPO',4,2),('e5026f2e-4763-4cbf-880e-ea82c8c831d2','2016-06-18',NULL,'3b9d7ef1-d0dc-40b5-9e1e-e92e0e452b08','DrApt',2,1);
/*!40000 ALTER TABLE `sequence_number` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statuses`
--

DROP TABLE IF EXISTS `statuses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `statuses` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `type` char(10) DEFAULT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statuses`
--

LOCK TABLES `statuses` WRITE;
/*!40000 ALTER TABLE `statuses` DISABLE KEYS */;
INSERT INTO `statuses` VALUES ('89f67ac1-3b89-404d-bbbc-783214b5c6f0','2016-06-18','ok lanjut','Approved','a60c79fb-e54b-41fe-aaab-a715e42edef4',0),('9cc85924-39d0-4448-9942-a33aa2733bd7','2016-06-18','Just Created','Created','504c9e43-02ff-4034-96ea-e76ca764231e',0);
/*!40000 ALTER TABLE `statuses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_adjustment`
--

DROP TABLE IF EXISTS `stock_adjustment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock_adjustment` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `fk_facility` char(50) DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_adjustment`
--

LOCK TABLES `stock_adjustment` WRITE;
/*!40000 ALTER TABLE `stock_adjustment` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_adjustment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_adjustment_item`
--

DROP TABLE IF EXISTS `stock_adjustment_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock_adjustment_item` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `fk_stock_adjustment` char(50) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_adjustment_item`
--

LOCK TABLES `stock_adjustment_item` WRITE;
/*!40000 ALTER TABLE `stock_adjustment_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_adjustment_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_admin`
--

DROP TABLE IF EXISTS `stock_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock_admin` (
  `id` char(50) NOT NULL,
  `fk_employee` char(50) DEFAULT NULL,
  `fk_internal_organization` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_admin`
--

LOCK TABLES `stock_admin` WRITE;
/*!40000 ALTER TABLE `stock_admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_opname`
--

DROP TABLE IF EXISTS `stock_opname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock_opname` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `fk_facility` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_opname`
--

LOCK TABLES `stock_opname` WRITE;
/*!40000 ALTER TABLE `stock_opname` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_opname` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_opname_item`
--

DROP TABLE IF EXISTS `stock_opname_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock_opname_item` (
  `id` char(50) NOT NULL,
  `onhand` decimal(10,0) DEFAULT NULL,
  `opnamed` decimal(10,0) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `fk_parent` char(50) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_opname_item`
--

LOCK TABLES `stock_opname_item` WRITE;
/*!40000 ALTER TABLE `stock_opname_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_opname_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES ('09403c5d-93b0-4250-9a2e-1451487b7b76'),('708a4896-aec2-49e3-ab9c-cf9e7dc0ccbb');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier_relationship`
--

DROP TABLE IF EXISTS `supplier_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier_relationship` (
  `id` char(50) NOT NULL,
  `fk_supplier` char(50) DEFAULT NULL,
  `fk_internal_organization` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier_relationship`
--

LOCK TABLES `supplier_relationship` WRITE;
/*!40000 ALTER TABLE `supplier_relationship` DISABLE KEYS */;
INSERT INTO `supplier_relationship` VALUES ('7a87f7e9-7927-450c-aa77-799f1d7076ef','09403c5d-93b0-4250-9a2e-1451487b7b76','9f2528c0-ba70-4841-864c-05d820c9fec3'),('a3d56d5f-4315-4db6-969c-f9f472c718ec','708a4896-aec2-49e3-ab9c-cf9e7dc0ccbb','9f2528c0-ba70-4841-864c-05d820c9fec3');
/*!40000 ALTER TABLE `supplier_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tax`
--

DROP TABLE IF EXISTS `tax`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tax` (
  `id` char(50) NOT NULL,
  `code` char(50) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tax`
--

LOCK TABLES `tax` WRITE;
/*!40000 ALTER TABLE `tax` DISABLE KEYS */;
INSERT INTO `tax` VALUES ('b685e80a-5257-49c7-9c7d-11b986a49b29','PPN','PPN',NULL,10,0),('d4921463-e9ff-4c8e-b6ff-9a1730688fbb','R-PPN','R-PPN',NULL,10,0);
/*!40000 ALTER TABLE `tax` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transfer_order_request`
--

DROP TABLE IF EXISTS `transfer_order_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transfer_order_request` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transfer_order_request`
--

LOCK TABLES `transfer_order_request` WRITE;
/*!40000 ALTER TABLE `transfer_order_request` DISABLE KEYS */;
/*!40000 ALTER TABLE `transfer_order_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transfer_order_request_item`
--

DROP TABLE IF EXISTS `transfer_order_request_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transfer_order_request_item` (
  `id` char(50) NOT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_transfer_order` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transfer_order_request_item`
--

LOCK TABLES `transfer_order_request_item` WRITE;
/*!40000 ALTER TABLE `transfer_order_request_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `transfer_order_request_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treatment`
--

DROP TABLE IF EXISTS `treatment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `treatment` (
  `id` char(50) NOT NULL,
  `is_bpjs` char(1) DEFAULT '0',
  `bpjs_payment_status` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treatment`
--

LOCK TABLES `treatment` WRITE;
/*!40000 ALTER TABLE `treatment` DISABLE KEYS */;
INSERT INTO `treatment` VALUES ('70ac451e-2798-4f73-94da-794f794a3dcd','1','UNPAID');
/*!40000 ALTER TABLE `treatment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treatment_item`
--

DROP TABLE IF EXISTS `treatment_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `treatment_item` (
  `id` char(50) NOT NULL,
  `fk_product_treatment` char(50) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `discount` decimal(10,0) DEFAULT NULL,
  `charge` decimal(10,0) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_treatment` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treatment_item`
--

LOCK TABLES `treatment_item` WRITE;
/*!40000 ALTER TABLE `treatment_item` DISABLE KEYS */;
INSERT INTO `treatment_item` VALUES ('146a1cce-f02d-4882-9498-308f21d8e075','6d83bdea-0f3b-459f-9df6-b1a6c33d20b0',1,50000,0,0,'','70ac451e-2798-4f73-94da-794f794a3dcd',0);
/*!40000 ALTER TABLE `treatment_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unit_of_measure`
--

DROP TABLE IF EXISTS `unit_of_measure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unit_of_measure` (
  `id` char(50) NOT NULL,
  `code` char(25) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unit_of_measure`
--

LOCK TABLES `unit_of_measure` WRITE;
/*!40000 ALTER TABLE `unit_of_measure` DISABLE KEYS */;
INSERT INTO `unit_of_measure` VALUES ('0d54d0aa-3def-4622-8fcf-8a8b8c9c6593','Tindakan','Tindakan','',0),('27fa0f0c-8713-4622-94c2-3fb99f259ac7','Gr','Gram','',0),('5ddd4cf5-0ad0-43d8-b220-ec1ad202c34d','Sachet','Sachet','',0),('7fd5cb7f-c6e5-4328-b275-07a0bc4f6722','Tablet','Tablet','',0),('f887136e-4205-4f2c-a4ec-b217d3686ae8','Mg','Mili Gram','',0);
/*!40000 ALTER TABLE `unit_of_measure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` char(50) NOT NULL,
  `email` varchar(250) DEFAULT NULL,
  `password` varchar(250) DEFAULT NULL,
  `is_enabled` char(1) DEFAULT '1',
  `fk_user_setting` char(50) DEFAULT NULL,
  `is_deleteable` char(1) DEFAULT '0',
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('97dc9715-47eb-45d5-96ba-0a582fabdf3b','admin@belian.com','jIfSsj+ceSsamqTfmru/ZlLSRsjwUijQK4CJqi86fLNWb/nqSv2eY2rRrJxgpdDM','1',NULL,'0',0),('a2501053-ee28-4073-b7a7-09844e6166e8','Johan Molana','WKuJC7RTBW2ec1z3grSgRfqS7giZ1XJEluzmzQf+ZUuBlwK0VtDqNjjG8AaFP2q1','1','f8e01887-08e3-42f3-9d85-c7e0dcbb066c','0',1),('f45b1e51-26d1-4aad-9a32-936876b4879f','dewi','CjSLRkWcf8Q3XHpjbpZV/fg2uYdQ1iVwIwk8KyZi0jg5N7s5M+kc2rLzMYH+m7NF','1','bbc7bd83-2d72-423c-901d-e4b9e5938e4b','0',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id` char(50) NOT NULL,
  `fk_role` char(50) DEFAULT NULL,
  `fk_user` char(50) DEFAULT NULL,
  `is_enabled` char(1) DEFAULT '1',
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES ('21b2feff-6d26-4ce0-81a3-60b6a0589905','096b0105-de76-492c-9bb0-5e518b46d69c','f45b1e51-26d1-4aad-9a32-936876b4879f','1',1),('21c3a048-e0ed-41d6-ab0b-0bfad8e67d40','096b0105-de76-492c-9bb0-5e518b46d69c','a2501053-ee28-4073-b7a7-09844e6166e8','1',1),('849138a5-4b4e-41ea-8f24-e4586e7f8ab9','096b0105-de76-492c-9bb0-5e518b46d69c','97dc9715-47eb-45d5-96ba-0a582fabdf3b','1',0);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_setting`
--

DROP TABLE IF EXISTS `user_setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_setting` (
  `id` char(50) NOT NULL,
  `organization_id` char(50) DEFAULT NULL,
  `organization_name` varchar(150) DEFAULT NULL,
  `location_id` char(50) DEFAULT NULL,
  `location_name` varchar(150) DEFAULT NULL,
  `currency_id` char(50) DEFAULT NULL,
  `currency_name` varchar(150) DEFAULT NULL,
  `tax_id` char(50) DEFAULT NULL,
  `tax_name` varchar(150) DEFAULT NULL,
  `language` varchar(250) DEFAULT NULL,
  `row_per_page` int(11) DEFAULT '25',
  `printer_type` char(10) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_setting`
--

LOCK TABLES `user_setting` WRITE;
/*!40000 ALTER TABLE `user_setting` DISABLE KEYS */;
INSERT INTO `user_setting` VALUES ('bbc7bd83-2d72-423c-901d-e4b9e5938e4b','3b9d7ef1-d0dc-40b5-9e1e-e92e0e452b08','Clinic & Apotik P.Aim','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','Pontianak','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','b685e80a-5257-49c7-9c7d-11b986a49b29','PPN','in_ID',25,'POS',1),('f8e01887-08e3-42f3-9d85-c7e0dcbb066c','3b9d7ef1-d0dc-40b5-9e1e-e92e0e452b08','Clinic & Apotik P.Aim','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','Pontianak','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','b685e80a-5257-49c7-9c7d-11b986a49b29','PPN','in_ID',25,'POS',3);
/*!40000 ALTER TABLE `user_setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `working_shift`
--

DROP TABLE IF EXISTS `working_shift`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `working_shift` (
  `id` char(50) NOT NULL,
  `name` varchar(150) DEFAULT NULL,
  `start` time DEFAULT NULL,
  `end` time DEFAULT NULL,
  `is_active` char(1) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `working_shift`
--

LOCK TABLES `working_shift` WRITE;
/*!40000 ALTER TABLE `working_shift` DISABLE KEYS */;
/*!40000 ALTER TABLE `working_shift` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-18 20:55:42
