CREATE DATABASE  IF NOT EXISTS `belian` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `belian`;
-- MySQL dump 10.13  Distrib 5.6.13, for osx10.6 (i386)
--
-- Host: 127.0.0.1    Database: belian
-- ------------------------------------------------------
-- Server version	5.6.14

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
  `fk_module` char(50) NOT NULL,
  `fk_role` char(50) NOT NULL,
  `is_can_read` int(1) NOT NULL DEFAULT '0',
  `is_can_create` int(1) NOT NULL DEFAULT '0',
  `is_can_update` int(1) NOT NULL DEFAULT '0',
  `is_can_delete` int(1) NOT NULL DEFAULT '0',
  `is_can_print` int(1) NOT NULL DEFAULT '0',
  `version` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `access_role`
--

LOCK TABLES `access_role` WRITE;
/*!40000 ALTER TABLE `access_role` DISABLE KEYS */;
INSERT INTO `access_role` VALUES ('242bc0e4-8c03-486c-90ef-d3143ba4098f','7f2ca978-5f10-4c05-9e17-984ec9da2b79','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('2a3249af-eaf8-473d-9da6-79eaef519099','0869345c-0fa2-410a-9e98-c1cb2d6f8d36','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('2b9d3d26-6895-4a15-a63e-594ccd85abfa','caa96801-dd36-4353-bf5c-4ff567a32559','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('2bc06dff-3313-4cda-abc9-3a11fa40d140','ec21a8cd-f09d-495a-8937-af2ea2c28814','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('2cc11748-167e-4793-9293-2bf854a545b1','f4cdc2fa-00a3-4a16-8ce6-954097fd0d22','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('2ce66b2f-190a-46d4-bc92-386b209605c0','a809f8f1-3459-4c19-99d6-19aca3387be7','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('2e8bdac1-5c0e-4516-854e-50675ef4a77c','8ac8a10f-2b6a-4e11-9ab2-09f11ef07987','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('32f9326d-9180-404c-81c5-a00026cad5de','f9078819-5db9-4ef5-bf2f-25dcf6c492a2','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('4250a609-9f33-4a1a-8af7-82f5e270a568','b1da5435-019e-4ce8-93cc-e7a683d58dbd','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('44abbb5f-97ad-4320-9b9f-1a9efb5a594e','90a93f9f-16a6-4c21-8679-1c2a63074748','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('44c80c69-20c0-421b-b940-b0c020ba5ae3','d9c16b4c-751a-476e-bcbc-11fddd3fca7d','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('47685bf6-d804-4dc4-b7da-3cfc09edd449','ff4f36eb-ba8d-4fef-be81-a219622080b4','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('487c19bd-4933-40f0-8dc4-3e5e3ecf14ed','7f5cdc13-7e2c-4097-b176-34437bc8b3ef','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('530a647b-478b-4531-aada-3f19391a885c','df568e3f-2ad4-406d-a1ec-98731d6563cf','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('5404feb7-c7f4-4fda-904b-fc7fb759c09b','e9033bd4-f6a8-4969-8914-8975b0ee85a2','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('547cfb06-3d64-47ce-9f07-135ff47ca1ec','b5f3c75c-1bf0-4c64-9f2f-4d5d758c8705','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('5ab99e62-5a93-46fe-bf3c-7681a068e058','8a7e2927-5d7f-4ea6-8362-3781b8dc4c26','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('63e501b4-11b3-4f29-8dd3-86f959704179','fbd37f18-6fc4-467f-9e7e-8e8c170a0b6e','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('68296454-c72a-4634-80fb-271fb48797ce','73d73613-783f-4213-9c3d-e4ea39e65c7f','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('689e61ac-dcf2-4125-874a-76b6cb137dab','7604b1d1-f705-4fb2-94b9-5dd83c52b7ea','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('719441fc-fc71-4968-95ab-a3eb82f56763','8e347aac-fc53-4902-870e-e816e63e54af','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,1),('73b499c4-163e-4524-bdb1-f694fcb2acb6','24e01dde-16e8-43be-bbfa-75683163ccd4','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('78e04fb4-40e4-4dd7-a34a-c0dee2a2db5f','71dd0547-38aa-48ec-82a2-e9866b6c92a3','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('7eb90898-ba37-4986-8890-ea2091d722df','6a04cfc8-d24d-4a0e-9b07-c834a7fd98b1','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('890f8714-100d-49a4-b519-c59459ba7ca8','86bd5bb8-8ff4-466e-8c9c-a1a3d5df4b00','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('90c8afd4-2ca7-4b4d-9af2-b19ec12cf78d','a735e0de-d34c-4719-9ce4-35afcb4f1c20','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('958a2295-9a66-4744-b5a6-b2e7e8bff9ad','633fd3f6-a28a-47fb-a362-e026254d5c4a','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('987a57f9-dbeb-4490-9c23-92c008a0249d','80a6a49f-9a10-4e23-8782-c70dbb0d3601','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('a81ade86-ee18-4417-9c2b-9b1d7058cc80','e53520e3-4797-4d8a-a95f-2cd496bb413b','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,1),('b85ca58d-acdf-4c25-8c90-d96e19a60b07','b77fcfc7-2018-48ab-bb5e-7c4786bf2679','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('caddf641-3abe-485d-9c50-e155f9bd4a9f','b9d31ef8-f86b-43e8-8e14-1ad7b7c8baac','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('cc0be192-ffdb-4671-896d-ce3f9ec5f560','b308ed44-1182-43bd-aa2c-d5873d041ab0','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('d738ed41-2d3c-47b8-9cd2-28711b80308b','ab906774-b1a7-4c37-9152-36a756c77a7b','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('d7fa2523-9b66-46b5-a7f0-84614817e23d','c7dfa397-5797-4e92-838b-b916f8d08a93','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('f14d611b-c3bb-4593-8d9d-1bc7e244ef11','d26d38c5-2878-44e4-97b6-92614e3cebd8','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('f26119c2-7d83-49ca-8054-dd7e5051438a','b9e50355-1e76-4c9e-a93a-882d81ce0abc','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0),('f8819b3a-bb01-42a7-b657-41ab3a8e8f25','57cde854-4227-41bf-8f03-ae7c756ba73c','9105d604-df0e-4ded-9a36-d02e141470de',1,1,1,1,1,0);
/*!40000 ALTER TABLE `access_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `module`
--

DROP TABLE IF EXISTS `module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `module` (
  `id` char(50) NOT NULL,
  `code` char(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `note` varchar(150) DEFAULT NULL,
  `is_enabled` int(1) NOT NULL DEFAULT '1',
  `version` bigint(20) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `module`
--

LOCK TABLES `module` WRITE;
/*!40000 ALTER TABLE `module` DISABLE KEYS */;
INSERT INTO `module` VALUES ('0869345c-0fa2-410a-9e98-c1cb2d6f8d36','ORGADDRESS','Organization Address','',1,1),('24e01dde-16e8-43be-bbfa-75683163ccd4','ORGANIZATIONACCOUNT','Organization Account','',1,1),('57cde854-4227-41bf-8f03-ae7c756ba73c','ACCOUNTINGPERIOD','Accounting Period','',0,1),('633fd3f6-a28a-47fb-a362-e026254d5c4a','UOM','Unit of Measure','',1,1),('6a04cfc8-d24d-4a0e-9b07-c834a7fd98b1','PERSON','Person','',1,1),('71dd0547-38aa-48ec-82a2-e9866b6c92a3','PRSRELATIONSHIP','Person Relationship','',0,1),('73d73613-783f-4213-9c3d-e4ea39e65c7f','USER','User Module',NULL,0,1),('7604b1d1-f705-4fb2-94b9-5dd83c52b7ea','TAX','Tax','',0,1),('7f2ca978-5f10-4c05-9e17-984ec9da2b79','PRDCATEGORY','Product Category','',1,1),('7f5cdc13-7e2c-4097-b176-34437bc8b3ef','PTYROLETYPE','Party Role Type','',0,1),('80a6a49f-9a10-4e23-8782-c70dbb0d3601','FACILITY','Facility','',0,1),('86bd5bb8-8ff4-466e-8c9c-a1a3d5df4b00','PRSROLE','Person Role','',0,1),('8a7e2927-5d7f-4ea6-8362-3781b8dc4c26','CONTAINER','Container','',1,1),('8ac8a10f-2b6a-4e11-9ab2-09f11ef07987','PRDFEATURE','Product Feature','',0,1),('8e347aac-fc53-4902-870e-e816e63e54af','PARTY','Party','',0,0),('90a93f9f-16a6-4c21-8679-1c2a63074748','ORGCONTACT','Organization Contact','',0,1),('a735e0de-d34c-4719-9ce4-35afcb4f1c20','INVITEM','Inventory Item','',0,1),('a809f8f1-3459-4c19-99d6-19aca3387be7','GEOGRAPHIC','Geographic','',0,1),('ab906774-b1a7-4c37-9152-36a756c77a7b','CASHSALES','Cash Sales','',0,1),('b1da5435-019e-4ce8-93cc-e7a683d58dbd','PRDCOMPONENT','Product Component','',0,1),('b308ed44-1182-43bd-aa2c-d5873d041ab0','CASHACCOUNT','Cash Account','',0,1),('b5f3c75c-1bf0-4c64-9f2f-4d5d758c8705','ORGRELATIONSHIP','Organization Relationship','',0,1),('b77fcfc7-2018-48ab-bb5e-7c4786bf2679','CURRENCY','Currency','',1,1),('b9d31ef8-f86b-43e8-8e14-1ad7b7c8baac','PRDCODE','Product Code','',1,1),('b9e50355-1e76-4c9e-a93a-882d81ce0abc','PRODUCT','Product','',0,1),('c7dfa397-5797-4e92-838b-b916f8d08a93','PRDPRICE','Product Price','',1,1),('caa96801-dd36-4353-bf5c-4ff567a32559','ORGANIZATION','Organization','',0,1),('d26d38c5-2878-44e4-97b6-92614e3cebd8','PRSADDRESS','Person Address','',0,1),('d9c16b4c-751a-476e-bcbc-11fddd3fca7d','PRDCOST','Product Cost','',1,1),('df568e3f-2ad4-406d-a1ec-98731d6563cf','COA','Chart of Account','',0,1),('e53520e3-4797-4d8a-a95f-2cd496bb413b','RLE','Role','',0,0),('e9033bd4-f6a8-4969-8914-8975b0ee85a2','PTYRELTYPE','Party Relationship Type','',0,1),('ec21a8cd-f09d-495a-8937-af2ea2c28814','PRDSUPPLIER','Product Supplier','',0,1),('f4cdc2fa-00a3-4a16-8ce6-954097fd0d22','ORGROLE','Organization Role','',1,1),('f9078819-5db9-4ef5-bf2f-25dcf6c492a2','MODULE','Module',NULL,0,1),('fbd37f18-6fc4-467f-9e7e-8e8c170a0b6e','PRSCONTACT','Person Contact','',0,1),('ff4f36eb-ba8d-4fef-be81-a219622080b4','BANKACCOUNT','Bank Account','',0,1);
/*!40000 ALTER TABLE `module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` char(50) NOT NULL,
  `code` char(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `note` varchar(150) DEFAULT NULL,
  `version` bigint(20) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('9105d604-df0e-4ded-9a36-d02e141470de','ADMIN','Administrator','',0);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id` char(50) NOT NULL,
  `fk_role` char(50) NOT NULL,
  `fk_user` char(50) NOT NULL,
  `is_enabled` int(1) NOT NULL DEFAULT '1',
  `version` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES ('1ae9c285-5877-4ddd-a363-6f7bc235b27a','9105d604-df0e-4ded-9a36-d02e141470de','1d7b14f7-0cb8-4e8b-a727-db78b85f8e5a',0,0),('c3a413dd-7340-4420-91b4-c1d8d2303518','9105d604-df0e-4ded-9a36-d02e141470de','e8473383-1c45-40db-8f99-1d5260f7d295',1,0);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` char(50) NOT NULL,
  `name` varchar(150) NOT NULL,
  `email` varchar(150) NOT NULL,
  `password` varchar(150) DEFAULT NULL,
  `is_enabled` int(1) NOT NULL DEFAULT '0',
  `version` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1d7b14f7-0cb8-4e8b-a727-db78b85f8e5a','GUEST','guest@belian.com','3WVS9ZMCVIIDiqfMEBm86Af/RRk0AyiREDJEO8iPkFoIBMVmTsMqPtwAXAHG2kkb',1,0),('e8473383-1c45-40db-8f99-1d5260f7d295','Administrator','admin@belian.com','cTDRDZgobwe6HgVdUe+UVHxhGaTn1R8Hj8CSTKHRmLU+UkVMtRED+kRJ5Sqf0rRe',1,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-16 16:26:34
