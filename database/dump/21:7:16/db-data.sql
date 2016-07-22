CREATE DATABASE  IF NOT EXISTS `belian` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `belian`;
-- MySQL dump 10.13  Distrib 5.7.12, for osx10.9 (x86_64)
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
INSERT INTO `access_role` VALUES ('01f5388b-c63e-4d09-b3b5-dd6456dd0815','c79e78d0-3427-440c-b8fe-df126e667a8b','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('0442dff1-c1dd-45e7-8634-2b9d90904469','7bef1d92-0f15-43ef-b59b-5bc3e769d896','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('060d3480-7c9a-44c7-b572-d7b2c4067359','916b22eb-48fa-4000-b7a2-7fc1d47ced4e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('0a1a6c1d-e681-48c4-b400-be611a9f70b7','8a05b279-2f80-47b8-a2a7-63fbe96d327e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('0e9073d1-2be3-4a8a-9a82-5bd1166757e2','847a8df6-bc04-4de6-8d7d-28e41c00f422','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('195dd074-a5e5-4abe-bc9f-5e913229bbb6','2d7e5641-511d-43fd-a6d6-a482120f8aa5','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('1aa3a48c-ab0c-4949-945e-e9852a9b9a93','95dd39dd-512e-414e-b95c-0fc251887f98','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('22fbdfec-6afe-4f2f-bd69-ac6a9974ae82','5c37296e-ab30-4d07-bba3-342d4c403f48','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('2c661c0d-53b6-44c7-85bd-ba04da473be3','c0f3237c-23c2-49ab-bc9c-e00aa706d7e2','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('2d52482a-0a7a-4e49-83c6-9db73e4e051b','80aebe74-399c-4273-9145-956a077d3f5d','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('3202f4e4-fd87-41a8-ae71-fbefce6a2ef4','b54c8e49-c820-4292-9f74-9e47bd55711f','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('32915e9c-96bf-44b3-881a-2f7c917a4c92','d33784ca-abd5-422b-b45a-8c8ee13ddc0a','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('32cc538f-0445-4ec4-9d2e-3084e89062d1','7f17176c-f27a-432c-a106-0d7d87b0afb7','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('331300a2-cc8e-4417-abb3-45dadf814422','fca1cfcf-d199-4729-a321-e1ed01deb0f1','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('37484efd-9cb6-4f79-903f-e7d6687658cc','6861d3b3-8110-46ed-8a3a-830963597fa7','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('3a225b38-8dbd-482a-9c14-2f7f1c535068','88bf4008-c84a-4089-88c6-e9d8f077a196','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('48c06de3-442f-4125-a438-e370fabade36','f50dd16d-0e25-44b6-bd69-c28dfcc55300','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('48c4056e-33f6-4082-af20-0139f3e66371','8217c196-16b9-44fb-9662-8323220ee705','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('490e4434-7ea2-475e-a66c-ea7296b82c54','29ec80f0-0d4c-451c-ae5e-f195c4be1a27','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('4b15a790-2920-47f2-b805-33ecd48b9bac','2c0d9a06-cebd-4da2-b520-2e948aae3e53','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('4fffeab2-b09c-47fb-92b4-3981da252637','9e644628-121d-4954-8a66-8002cc866bda','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('541dd297-fd64-44ae-bcf4-fed612227962','4b3bb551-173e-46f5-b1e9-bdd719e3045e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('59d88282-5a3f-481b-9bb8-91679fbf4d91','f53b80db-1b89-4779-86e7-b065b5287bbb','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('5a2ce59a-60c2-4203-9d3b-7c5d038fe635','e916392a-0b3c-4543-ada7-93054383bb3b','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('5c2ddb84-b28c-40f6-81d5-351e0ea1037d','627fb961-6cf0-4148-9451-0d1422095eb7','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('5c9ab463-dc50-47a5-a601-f074734adf3c','abfd9a02-3b4b-47a0-9048-a65b6be0b3aa','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('6179118a-ff80-452a-a89d-8e0154725095','b662de02-f4a3-4f1a-819b-5d2aaf6a342b','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('6416ea67-8c7b-477e-811f-c5e4e45ca9c0','99623cbd-066f-4cc2-b9b3-1961bed131cc','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('6655f91e-4928-4c6f-b83a-f43b28f04454','770c420c-f809-43f7-969c-b493f0b4ef48','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('6adcd07b-62da-4e75-a076-80520a58eb32','5cdd1545-8fdb-4a79-b2a3-0662ed6fec30','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('6ed261e4-7608-49cd-9953-a04e3ff8dfed','affcf2e7-fd2c-4b39-beee-97b5dc5a1405','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('711417b0-a5ea-4c2e-8ab3-e5a96576b45b','8f6ec9c8-e9ed-49e1-ab7a-c4a868b8391e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('71479847-69f5-43fa-b7ce-00af42c28d4a','339d7200-9aa1-43d5-8683-e7118cb52839','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('724b174d-96ec-4152-a42c-2d03097b9aa9','342b0b64-291f-4d12-bdb8-77186895d21d','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('79450f94-0cbf-4c0d-ad76-3362a4abe180','4eca5501-a650-41d5-87c1-c091391d3608','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('89c3b455-3c46-4bc4-9a13-77c171e129b6','a4c43802-436f-407c-8793-323600c181d7','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('923b7b67-a1e4-478a-9769-e2ee32b685b1','ee3c3540-9c62-46df-a79e-f7b636a9ba1d','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('94863d4d-7d07-41d2-bc78-4f65260776d6','13989b38-ac2c-47b8-8708-5e27477af18d','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('96318b3e-baf7-479b-ab07-d0798114d3bd','e54e6ba5-7ffd-457b-a23e-8b6285867ba4','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('9659ee34-7845-4078-89bd-9ee9b9e37b78','855aab16-cb45-41c3-b62c-55185ff77dfc','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('9728b76b-eac0-44c4-9ba9-afca669e0a76','e8f89299-2138-4167-b5b7-52f6ae1667ca','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('9f52d7a0-217e-4084-9bb3-78c5c81dd536','07452775-a048-4071-8798-21dc943fe926','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('9fa511a1-e704-4018-a90a-57acea0ac5da','1adc4b8b-ad93-4658-8476-6bb13e2e810d','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('a055f787-df6a-4c93-af22-12797bf5ec39','69443009-4a15-4061-b9f0-08c08c8f50aa','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('a3e8ba06-d955-4929-bd36-f658f3796b6c','a4aa9ae0-5166-4d06-afd1-d2eea6f2417c','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('a3ef8fbd-46f9-43db-ab47-31d062c3fb20','74ad4867-9495-472f-97fc-36bf87895585','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('a7951344-6b9e-438f-af5c-7b94dee26b2d','83b19678-9f2f-49f4-ba25-0f31a8dee078','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('a8a90cc0-470f-456c-879b-77c0ed469dd7','9df71b1a-0e52-4445-98ea-b9a59ad81ac9','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('a91848d3-83d1-485a-9846-c83ff3699ac2','322d37f6-a667-481e-bc22-db212d0154ea','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('abecab92-51cb-4ca9-88a0-9446c1bc5ae3','4eb93eb7-2100-49ae-bd96-a39995ed5670','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('ac144c04-22c4-47fb-8fd4-3783a4f29a90','1cf392fc-4f93-4e38-9709-2beb84434951','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('ad389302-f250-4270-a937-75cf984c2f80','2bdc3f95-c5bd-47d9-adce-9e9df1042e2f','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('b31dbbf6-6b74-4aa9-9db4-6ebd3888ef91','355ca995-6bae-4638-bfd4-a9bfeff5eefb','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('b4f04a2c-d9a4-4b30-b75b-4572685e35a8','9178e8cd-4063-4fe9-a060-d2e3ac818ed1','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('bf839209-25d9-4ea7-8e4a-d771f7599e2e','6cbaf072-6925-46e9-b417-17326f3d8584','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('c2d02e3b-7b8a-47b4-bb08-30f37f9505fc','9b9deb26-0960-478c-8cac-4ac475c3ffc3','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('c655e02a-f2a3-4132-8bd7-9428cc1ce3af','0b503053-31eb-410d-90a6-ec6a9977bc1e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('c836928e-da88-414e-b572-db436cc948a4','4939e42f-06b5-4e44-b3ba-4106964f1f68','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('c9681985-0b2a-4537-822b-8f477bc15104','65414caf-3a73-4e3f-9a58-2d70c723b5bc','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('ce77f072-7ad1-4cb5-9e9e-0d9b89a853bd','314a3f13-a982-4915-a5cb-455eacbc27ae','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('cf2437ad-5e59-4f7a-8190-f537beabc623','58621810-2c8f-44ae-b9aa-b1e05ad32743','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('cff3c8ef-bd79-4d32-be37-b4a2e7dab027','90195ecb-4674-4614-a429-eebc24ffe773','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('d11fbe57-0eac-4f6f-bc22-14a0ed221733','fab64cd8-7762-412b-90fb-3d31d5576b45','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('d8a71d8e-344a-4c18-88ff-9ca2cffed715','b9935030-f5c1-479e-9ec1-795afc1c1e7e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('de2ab421-31cd-45b7-b6d7-5baf50797f2c','6e299ade-e10e-4940-ae83-bdf61505ed63','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('e1ae7cc5-aab3-4271-a744-9d17fca44e9c','9b9e014c-7a23-40c1-8841-30044564bf7f','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('e1ae7cc5-aab3-4271-a744-9d17fca44e9x','9b9e014c-7a23-40c1-8841-30044564bf7x','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('e51c5ad1-38c7-4699-9c92-50f070f7a7f3','4bf39427-b32a-434c-bd71-4d9493ea6eef','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('e6f44dd7-9616-4c85-aaa9-e5322ea39319','b44420c6-261b-44c5-a23a-7802a0506dab','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('e9b3d5e4-1259-48bc-b521-7abb7d72bc30','e4307d82-f3fa-4916-9e6b-7a4f894d847e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('ed0df929-8852-42ca-9006-e0ad6fd37a90','55b7e0fb-a178-478b-a09e-4b753f161aeb','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('ee5e29eb-cf8a-4c54-a709-da55952b8f80','5eda5016-f448-42dd-926b-52b10870e29c','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('f0c0441f-80df-4405-8927-c114d9c61edb','e4d249e1-4bd5-4291-9050-62a99f70f64c','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('f0f949d7-f756-4fdc-bacd-b6e145b9829d','5e8c4a66-e46a-4000-ae1c-bf536686b30f','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('f21a4567-0723-4569-abd7-8e59e3645767','0c586cf4-9bd2-4b93-b24b-d41ceca2aef4','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('f6e69991-8825-41e8-a6e7-24a4c6257c4d','dbc9175e-eb27-45e9-9e43-a1c12d6354e4','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('f7284b39-b584-4334-94f0-0631d3a9b429','4500a912-bbad-4590-9abb-d9ec92a311a5','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('fe2ef334-8861-41af-887a-a95992d46b74','8c7e1020-0824-4239-9a4e-46301c80b9cd','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1);
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
INSERT INTO `accessible_organization` VALUES ('7714d7de-6ef3-4551-a852-d9c9b10ae689','096b0105-de76-492c-9bb0-5e518b46d69c','f430829b-4c5b-4dcf-8191-803e666a49e7','0',0),('edfc0111-b7d5-4b38-a513-9bc8755d8956','096b0105-de76-492c-9bb0-5e518b46d69c','41f53d44-746a-4e63-9b53-052fc9991809','0',0);
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
INSERT INTO `accounting_period` VALUES ('1dcd41e7-bf7c-49fd-8c2a-d0bf5506c609','1009','September','2016-09-01','2016-09-30','December','fd09ce5b-a9dd-47d3-b3d6-68b362114291',1),('5e131062-59b2-4dd1-9726-1c5724ac0056','1006','Juni','2016-06-01','2016-06-30','June','fd09ce5b-a9dd-47d3-b3d6-68b362114291',0),('6159b683-0c5a-4250-be00-c34221c04d46','1002','Februari 2016','2016-02-01','2016-02-28','February','fd09ce5b-a9dd-47d3-b3d6-68b362114291',0),('7a8b67d8-094f-4155-9e87-342e2104ed74','1008','Agustus','2016-08-01','2016-08-31','August','fd09ce5b-a9dd-47d3-b3d6-68b362114291',0),('7e25f121-c2cd-42bb-aabe-1e8084674e0f','1004','April','2016-04-01','2016-04-30','April','fd09ce5b-a9dd-47d3-b3d6-68b362114291',0),('84a87056-15c1-448f-b489-6a4fc1b80092','1005','Mei','2016-05-01','2016-05-31','May','fd09ce5b-a9dd-47d3-b3d6-68b362114291',0),('aeb07940-a6af-471d-8967-7b17f7121eeb','1003','Maret','2016-03-01','2016-03-31','March','fd09ce5b-a9dd-47d3-b3d6-68b362114291',0),('c0ab6a97-2d03-489b-9a29-ba6aa84f4f92','1012','Desember','2016-12-01','2016-12-31','December','fd09ce5b-a9dd-47d3-b3d6-68b362114291',0),('c0fb97b8-2ef3-465f-be49-9bfdb7e72e97','1007','Juli','2016-07-01','2016-07-31','July','fd09ce5b-a9dd-47d3-b3d6-68b362114291',0),('e7918496-adff-4ba9-89cc-dd217329449e','1001','Januari 2016','2016-01-01','2016-01-31','January','fd09ce5b-a9dd-47d3-b3d6-68b362114291',0),('f5104550-7dbc-4dcc-8dfb-16a87286ec9d','1010','Oktober','2016-10-01','2016-10-31','October','fd09ce5b-a9dd-47d3-b3d6-68b362114291',0),('f8ba4d9f-028f-456a-a918-cca407afdb9b','1011','November','2016-11-01','2016-11-30','November','fd09ce5b-a9dd-47d3-b3d6-68b362114291',0),('fd09ce5b-a9dd-47d3-b3d6-68b362114291','1000','2016-2017','2016-01-01','2016-12-31','January',NULL,0);
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
INSERT INTO `address` VALUES ('045e2cf8-851b-4843-b749-3f3b2fdab3b7','jl sana sini','91837','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','10b4a630-cecb-4bd8-9848-83a905dbb0cc',0),('125dbeb9-4e48-48d4-aea3-077aba59c284','jl ok mike','9384','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','ff4eee76-ea62-49bd-b62b-8b0964da3502',0),('2cdb5e57-cb00-43bd-b8bf-591617c09c37','Jl Gusti Hamzah No. 51B','','1','OFFICE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','41f53d44-746a-4e63-9b53-052fc9991809',0),('52b6e978-bc09-4dc3-8218-941377ebbaa2','Jln Antara lain 9 no 18','651719','0','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','f430829b-4c5b-4dcf-8191-803e666a49e7',0);
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
INSERT INTO `asset` VALUES ('d4c84ba8-408f-4791-be30-a7b342e8b44b','Kompi 1','Kasir 1','2016-07-19',NULL,NULL,3200000,'1','0','cd07e3e3-7291-4c16-862d-b1b17b75f7f5','','41f53d44-746a-4e63-9b53-052fc9991809','d63be354-c04a-4a83-b137-962aaf2d7a4c',1);
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
INSERT INTO `asset_type` VALUES ('cd07e3e3-7291-4c16-862d-b1b17b75f7f5','EL','Elektronik',NULL,0);
/*!40000 ALTER TABLE `asset_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `audit_trail`
--

DROP TABLE IF EXISTS `audit_trail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `audit_trail` (
  `id` char(50) NOT NULL,
  `date` varchar(45) DEFAULT NULL,
  `type` char(6) DEFAULT NULL,
  `user` varchar(150) DEFAULT NULL,
  `company` varchar(150) DEFAULT NULL,
  `service` varchar(150) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit_trail`
--

LOCK TABLES `audit_trail` WRITE;
/*!40000 ALTER TABLE `audit_trail` DISABLE KEYS */;
INSERT INTO `audit_trail` VALUES ('b5d34772-907c-4a20-a63e-98b83802ba28','2016-07-20 19:14:05.789','0','Ani','SONY SUGEMA COLLEGE','Cashier Shift','Open new shift for cashier on Kasir 1',0);
/*!40000 ALTER TABLE `audit_trail` ENABLE KEYS */;
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
INSERT INTO `benefit` VALUES ('470a06fd-e10d-4645-a051-93ef0d1b3409','2016-07-01',NULL,250000,100,0,'2ca11c93-b245-4e36-86fa-4b590629a61b','Yearly','06e699ef-9a6f-464a-8b4c-03bb640c351d',0),('755c422f-af31-4601-b829-2cc3e3fecd7b','2016-07-01',NULL,0,100,12,'eb1c3396-2410-4357-b0fe-492b41b4ccf5','Yearly','06e699ef-9a6f-464a-8b4c-03bb640c351d',0),('bf040a47-f55c-41ea-bcac-770ad3b34315','2016-07-14',NULL,500000,0,0,'772e9a53-917c-4f08-904e-99aed099a952','Hourly','06e699ef-9a6f-464a-8b4c-03bb640c351d',0),('c13e0eb3-d632-4543-ac50-73df706295f9','2016-07-01',NULL,500000,100,0,'772e9a53-917c-4f08-904e-99aed099a952','Monthly','63ebacc0-3a90-4dd0-9dce-dd04336ff7ef',0);
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
INSERT INTO `benefit_type` VALUES ('2ca11c93-b245-4e36-86fa-4b590629a61b','THR','Tunjangan Hari Raya','',0),('772e9a53-917c-4f08-904e-99aed099a952','BNS','Bonus','',0),('eb1c3396-2410-4357-b0fe-492b41b4ccf5','Cuti','Cuti Tahunan','',0);
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
INSERT INTO `billable` VALUES ('04fc3ce9-63c7-43e5-961f-1d7c285c9d8b','2016-07-20','BLG1469019325828','1','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','41f53d44-746a-4e63-9b53-052fc9991809','c589af39-f795-4865-ae4b-5cea360a62be','10fe16f0-3f2c-4995-b6c3-5f5447597a12','b685e80a-5257-49c7-9c7d-11b986a49b29','d63be354-c04a-4a83-b137-962aaf2d7a4c',1),('27419b9b-4821-4882-abf0-a01f2d37762c','2016-07-10','INV23','1','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f430829b-4c5b-4dcf-8191-803e666a49e7',NULL,'c1597466-ba7a-497d-a40f-b2a4ed71a258','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('2965114b-0edf-4576-8b98-7c6125ca845a','2016-07-10','INV21','1','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f430829b-4c5b-4dcf-8191-803e666a49e7',NULL,'c1597466-ba7a-497d-a40f-b2a4ed71a258','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('40c7d20b-f04f-481e-97b5-eb758f4cad60','2016-07-10','INV22','1','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f430829b-4c5b-4dcf-8191-803e666a49e7',NULL,'c1597466-ba7a-497d-a40f-b2a4ed71a258','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('4a4a5714-d094-4cf0-8405-cb32a8d84e71','2016-07-20','PHS3','1','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','41f53d44-746a-4e63-9b53-052fc9991809','c589af39-f795-4865-ae4b-5cea360a62be','10fe16f0-3f2c-4995-b6c3-5f5447597a12','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','d63be354-c04a-4a83-b137-962aaf2d7a4c',1),('689e24d0-e679-450a-b3f6-c854e7248633','2016-07-20','INV1','1','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','41f53d44-746a-4e63-9b53-052fc9991809','c589af39-f795-4865-ae4b-5cea360a62be','0ba10d3e-67bf-439b-a8a0-14a698dc82a1','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,1),('7e56e604-6ab0-4295-86f4-2396b5187e30','2016-07-12','INV1','1','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','41f53d44-746a-4e63-9b53-052fc9991809',NULL,'10b4a630-cecb-4bd8-9848-83a905dbb0cc','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('9987fc9f-65e9-498d-9222-5caecd956ebb','2016-07-18','INV1','0','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','41f53d44-746a-4e63-9b53-052fc9991809','c589af39-f795-4865-ae4b-5cea360a62be','0e90867e-3ab2-4e2c-86e0-1a98c81a8d66','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('a8cc2df3-e00b-4ee6-aff8-f752f51e2ed9','2016-07-21','INV1','0','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','41f53d44-746a-4e63-9b53-052fc9991809','c589af39-f795-4865-ae4b-5cea360a62be','0e90867e-3ab2-4e2c-86e0-1a98c81a8d66','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('c6eb2431-9f02-4378-8c51-f95b262daa07','2016-07-20','INV3','1','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','41f53d44-746a-4e63-9b53-052fc9991809','c589af39-f795-4865-ae4b-5cea360a62be','0ba10d3e-67bf-439b-a8a0-14a698dc82a1','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,1),('e49e17c5-4fde-4807-89d7-3271b57fcb4b','2016-07-20','INV2','0','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','41f53d44-746a-4e63-9b53-052fc9991809','c589af39-f795-4865-ae4b-5cea360a62be','0ba10d3e-67bf-439b-a8a0-14a698dc82a1','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('eb9d99fc-5e56-446d-ad86-48ad5745bda2','2016-07-11','INV4','1','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f430829b-4c5b-4dcf-8191-803e666a49e7',NULL,'c1597466-ba7a-497d-a40f-b2a4ed71a258','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('eeeba6f8-79df-462b-967b-5629326e14d6','2016-07-28','INV1','0','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','41f53d44-746a-4e63-9b53-052fc9991809','c589af39-f795-4865-ae4b-5cea360a62be','0e90867e-3ab2-4e2c-86e0-1a98c81a8d66','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0);
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
INSERT INTO `cash_sales` VALUES ('04fc3ce9-63c7-43e5-961f-1d7c285c9d8b',1,'c4c10aee-a3a1-4e6c-a08b-62d4e26414df','','SHORTTERM');
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
INSERT INTO `cash_sales_line` VALUES ('d038912c-f933-4479-a929-9e4152047082',2200000,0,0,1,'','e1db32dc-f5f5-4b85-8d57-1f278355ba6b','7a7d5edb-d6ff-4b91-93db-d7a7e5a0caef','04fc3ce9-63c7-43e5-961f-1d7c285c9d8b',0);
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
INSERT INTO `cashier_shift` VALUES ('d63be354-c04a-4a83-b137-962aaf2d7a4c','2016-07-20','c589af39-f795-4865-ae4b-5cea360a62be','0','d4c84ba8-408f-4791-be30-a7b342e8b44b',0,'19:14:05',NULL,0);
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
INSERT INTO `company_structure` VALUES ('0a546a5d-bf4c-4cd3-ba0d-9a8a296f3753','2010-07-04',NULL,'f430829b-4c5b-4dcf-8191-803e666a49e7','HOLDING',NULL,0),('88eec066-12a7-44d8-aa62-7dc851db4b1b','2010-07-04',NULL,'41f53d44-746a-4e63-9b53-052fc9991809','COMPANY','0a546a5d-bf4c-4cd3-ba0d-9a8a296f3753',0);
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
INSERT INTO `contact` VALUES ('0995e906-796e-48c9-8e12-4ec6beca55b2','9841124','CELLPHONE','1','ff4eee76-ea62-49bd-b62b-8b0964da3502',0),('187a7f55-9dbc-4bc2-acea-5d58440c7ce3','78248724','CELLPHONE','1','10b4a630-cecb-4bd8-9848-83a905dbb0cc',0),('419f499c-6c53-424d-9260-992f891f80b0','0561 741467','OFFICEPHONE','1','41f53d44-746a-4e63-9b53-052fc9991809',0),('aedd88e7-1de3-4f97-8486-ffe389be4f1a','8918 717 171','OFFICEPHONE','0','f430829b-4c5b-4dcf-8191-803e666a49e7',0);
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_attendance`
--

DROP TABLE IF EXISTS `course_attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_attendance` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `fk_Schedule` char(50) DEFAULT NULL,
  `fk_staff` char(50) DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_attendance`
--

LOCK TABLES `course_attendance` WRITE;
/*!40000 ALTER TABLE `course_attendance` DISABLE KEYS */;
INSERT INTO `course_attendance` VALUES ('17ad85db-5c8c-4d8c-93ae-58a69da301b9','2016-07-16','f7b1772e-9907-456b-a45b-022bc9a61476',NULL,'41f53d44-746a-4e63-9b53-052fc9991809',0);
/*!40000 ALTER TABLE `course_attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_attendance_item`
--

DROP TABLE IF EXISTS `course_attendance_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_attendance_item` (
  `id` char(50) NOT NULL,
  `fk_person` char(50) DEFAULT NULL,
  `status` char(10) DEFAULT 'LEAVE',
  `fk_attendance` char(50) DEFAULT NULL,
  `fk_time_entry` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_attendance_item`
--

LOCK TABLES `course_attendance_item` WRITE;
/*!40000 ALTER TABLE `course_attendance_item` DISABLE KEYS */;
INSERT INTO `course_attendance_item` VALUES ('431f8ab3-1f3c-49c7-9b94-474bc323d1c6','c1597466-ba7a-497d-a40f-b2a4ed71a258','0','17ad85db-5c8c-4d8c-93ae-58a69da301b9',NULL,0),('45eef090-7204-4af7-95cd-b9f48271af65','99b9d50a-69cc-4496-a00d-4533ef3c1fca','0','17ad85db-5c8c-4d8c-93ae-58a69da301b9',NULL,0),('7273e5ff-38b8-4dd0-851c-0eeefaeb5d0d','10b4a630-cecb-4bd8-9848-83a905dbb0cc','0','17ad85db-5c8c-4d8c-93ae-58a69da301b9',NULL,0);
/*!40000 ALTER TABLE `course_attendance_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_discount`
--

DROP TABLE IF EXISTS `course_discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_discount` (
  `id` char(50) NOT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `fk_discount` char(50) DEFAULT NULL,
  `fk_registration` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_discount`
--

LOCK TABLES `course_discount` WRITE;
/*!40000 ALTER TABLE `course_discount` DISABLE KEYS */;
INSERT INTO `course_discount` VALUES ('a0920046-4263-4e4b-a8d3-4887722cd7e5',100000,'2179d992-14af-4bcc-a2b7-4debd7ecec31','77b3f036-1561-4f6f-af5d-b7cda587099b',0),('b6a943f1-20e4-4222-92cf-e0119142d570',300000,'624bada5-b5e6-48f8-ac19-588b17d0d087','7e5950af-f78a-4499-a74a-9117b6a3aaf7',0),('fa538e8d-10ac-4428-9dcc-f0360e5dac0c',1100000,'618ace95-a990-45c2-8ad5-7f9bebd5fc16','77b3f036-1561-4f6f-af5d-b7cda587099b',0);
/*!40000 ALTER TABLE `course_discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_installment`
--

DROP TABLE IF EXISTS `course_installment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_installment` (
  `id` char(50) NOT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `fk_course_registration` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_installment`
--

LOCK TABLES `course_installment` WRITE;
/*!40000 ALTER TABLE `course_installment` DISABLE KEYS */;
INSERT INTO `course_installment` VALUES ('27419b9b-4821-4882-abf0-a01f2d37762c',1200000,'Cicilan 1','77b3f036-1561-4f6f-af5d-b7cda587099b'),('2965114b-0edf-4576-8b98-7c6125ca845a',1000000,'Cicilan 2','77b3f036-1561-4f6f-af5d-b7cda587099b'),('40c7d20b-f04f-481e-97b5-eb758f4cad60',500000,'Cicilan 3','77b3f036-1561-4f6f-af5d-b7cda587099b'),('689e24d0-e679-450a-b3f6-c854e7248633',500000,'C1','982e7417-3d66-474a-a2e2-d2fe4a975e2f'),('7e56e604-6ab0-4295-86f4-2396b5187e30',4100000,'Bayar cash','7e5950af-f78a-4499-a74a-9117b6a3aaf7'),('9987fc9f-65e9-498d-9222-5caecd956ebb',1000000,'Cicilan 1','148d7670-8faf-463c-9d69-dfb04fe4965d'),('a8cc2df3-e00b-4ee6-aff8-f752f51e2ed9',2000000,'Cicilan 2','148d7670-8faf-463c-9d69-dfb04fe4965d'),('c6eb2431-9f02-4378-8c51-f95b262daa07',800000,'C3','982e7417-3d66-474a-a2e2-d2fe4a975e2f'),('e49e17c5-4fde-4807-89d7-3271b57fcb4b',1000000,'C2','982e7417-3d66-474a-a2e2-d2fe4a975e2f'),('eb9d99fc-5e56-446d-ad86-48ad5745bda2',500000,'Cicilan 4','77b3f036-1561-4f6f-af5d-b7cda587099b'),('eeeba6f8-79df-462b-967b-5629326e14d6',1200000,'Cicilan 3','148d7670-8faf-463c-9d69-dfb04fe4965d');
/*!40000 ALTER TABLE `course_installment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_item`
--

DROP TABLE IF EXISTS `course_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_item` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `fk_product_feature` char(50) DEFAULT NULL,
  `fk_course_registration` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_item`
--

LOCK TABLES `course_item` WRITE;
/*!40000 ALTER TABLE `course_item` DISABLE KEYS */;
INSERT INTO `course_item` VALUES ('1cb52664-f823-44ce-8bb0-977410516435',1,4200000,'7a7d5edb-d6ff-4b91-93db-d7a7e5a0caef','d3274933-6664-48bf-ad05-c6e6dd5e60eb','148d7670-8faf-463c-9d69-dfb04fe4965d',0),('1ed43f1b-1df7-4f1b-b1f9-9a26c563567b',1,2200000,'7a7d5edb-d6ff-4b91-93db-d7a7e5a0caef','9945cbf2-9e12-4d1f-9ca3-a47b763bde6f','982e7417-3d66-474a-a2e2-d2fe4a975e2f',0),('23985237-afa4-4fcc-9317-add739954a01',1,200000,'d2634d59-9cb6-43ed-a108-473f3410390b','407a4973-c132-4b92-a2cf-f1f58c54090a','77b3f036-1561-4f6f-af5d-b7cda587099b',0),('5f5edfca-d929-4c2c-846a-5b825b356af7',1,4200000,'7a7d5edb-d6ff-4b91-93db-d7a7e5a0caef','d3274933-6664-48bf-ad05-c6e6dd5e60eb','7e5950af-f78a-4499-a74a-9117b6a3aaf7',0),('afefe3f4-c931-4e49-9b93-e7f1887b8814',1,200000,'d2634d59-9cb6-43ed-a108-473f3410390b','407a4973-c132-4b92-a2cf-f1f58c54090a','7e5950af-f78a-4499-a74a-9117b6a3aaf7',0),('b3e2472e-8917-4864-b82e-b89bcbe8c280',1,4200000,'7a7d5edb-d6ff-4b91-93db-d7a7e5a0caef','d3274933-6664-48bf-ad05-c6e6dd5e60eb','77b3f036-1561-4f6f-af5d-b7cda587099b',0),('c6fbe402-17df-4f90-bcbe-36c23447b2d3',1,100000,'d2634d59-9cb6-43ed-a108-473f3410390b','36a68855-a7e5-4d8f-a3f1-30d64159d0bb','982e7417-3d66-474a-a2e2-d2fe4a975e2f',0);
/*!40000 ALTER TABLE `course_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_registration`
--

DROP TABLE IF EXISTS `course_registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_registration` (
  `id` char(50) NOT NULL,
  `fk_study_day` char(50) DEFAULT NULL,
  `fk_study_time` char(50) DEFAULT NULL,
  `fk_study_period` char(50) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `number` char(50) DEFAULT NULL,
  `fk_currency` char(50) DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `fk_staff` char(50) DEFAULT NULL,
  `fk_student` char(50) DEFAULT NULL,
  `fk_tax` char(50) DEFAULT NULL,
  `fk_room` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_registration`
--

LOCK TABLES `course_registration` WRITE;
/*!40000 ALTER TABLE `course_registration` DISABLE KEYS */;
INSERT INTO `course_registration` VALUES ('148d7670-8faf-463c-9d69-dfb04fe4965d','9623866f-7554-451d-a602-aa3125137712','42029710-abc5-45e4-ac75-7c7fd1d0dcd0','01835518-da9b-4069-9574-32a8048ff609','2016-07-21','CRS1','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','41f53d44-746a-4e63-9b53-052fc9991809','c589af39-f795-4865-ae4b-5cea360a62be','0e90867e-3ab2-4e2c-86e0-1a98c81a8d66','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('77b3f036-1561-4f6f-af5d-b7cda587099b','9623866f-7554-451d-a602-aa3125137712','42029710-abc5-45e4-ac75-7c7fd1d0dcd0','01835518-da9b-4069-9574-32a8048ff609','2016-07-10','CRS8','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f430829b-4c5b-4dcf-8191-803e666a49e7',NULL,'c1597466-ba7a-497d-a40f-b2a4ed71a258','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','44beff53-496d-49dd-acc3-ab8b4a4b6559',11),('7e5950af-f78a-4499-a74a-9117b6a3aaf7','9623866f-7554-451d-a602-aa3125137712','42029710-abc5-45e4-ac75-7c7fd1d0dcd0','01835518-da9b-4069-9574-32a8048ff609','2016-07-12','CRS1','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','41f53d44-746a-4e63-9b53-052fc9991809',NULL,'10b4a630-cecb-4bd8-9848-83a905dbb0cc','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','44beff53-496d-49dd-acc3-ab8b4a4b6559',6),('982e7417-3d66-474a-a2e2-d2fe4a975e2f','9623866f-7554-451d-a602-aa3125137712','42029710-abc5-45e4-ac75-7c7fd1d0dcd0','01835518-da9b-4069-9574-32a8048ff609','2016-07-20','CRS1','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','41f53d44-746a-4e63-9b53-052fc9991809','c589af39-f795-4865-ae4b-5cea360a62be','0ba10d3e-67bf-439b-a8a0-14a698dc82a1','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0);
/*!40000 ALTER TABLE `course_registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_schedule`
--

DROP TABLE IF EXISTS `course_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_schedule` (
  `id` char(50) NOT NULL,
  `day` char(15) DEFAULT NULL,
  `fk_room` char(50) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_schedule`
--

LOCK TABLES `course_schedule` WRITE;
/*!40000 ALTER TABLE `course_schedule` DISABLE KEYS */;
INSERT INTO `course_schedule` VALUES ('f7b1772e-9907-456b-a45b-022bc9a61476','Tuesday','44beff53-496d-49dd-acc3-ab8b4a4b6559','76cd4643-e667-459c-9f7c-8fb7bbe4649b');
/*!40000 ALTER TABLE `course_schedule` ENABLE KEYS */;
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
  `is_default` char(1) DEFAULT '0',
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
INSERT INTO `currency` VALUES ('82159e7e-7d44-44e9-acc6-09f85e99bac0','RMY','Ringgit Malaysia','0',0),('85c90912-97ff-47ce-9d6a-7d1650ab3ea9','IDR','Rupiah','1',1),('f4e2e57c-be85-49a8-b19b-66ed812b2785','USD','US Dollar','0',0);
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
INSERT INTO `deduction` VALUES ('99e512ea-5f20-43a0-9fd0-fc539b8d8e4e',50000,'703e5e3b-f54c-4950-82b8-979e6d0284ab','f576fa89-5590-4bfb-a4e0-95e2756bfd04',0);
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
INSERT INTO `deduction_type` VALUES ('703e5e3b-f54c-4950-82b8-979e6d0284ab','Cash Bon','Pinjaman cash',0);
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
INSERT INTO `disbursement` VALUES ('18859f3e-1d5a-4987-a579-e17d331b86f3'),('837d5303-42ee-4736-9c84-b481b362d4e9'),('f576fa89-5590-4bfb-a4e0-95e2756bfd04');
/*!40000 ALTER TABLE `disbursement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discount`
--

DROP TABLE IF EXISTS `discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discount` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `value` decimal(10,0) DEFAULT NULL,
  `is_percent` char(1) DEFAULT '0',
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
INSERT INTO `discount` VALUES ('2179d992-14af-4bcc-a2b7-4debd7ecec31','2016-07-05',NULL,'Anak Guru',100000,'0',0),('618ace95-a990-45c2-8ad5-7f9bebd5fc16','2016-07-05',NULL,'Mantan Siswa',25,'1',0),('624bada5-b5e6-48f8-ac19-588b17d0d087','2016-07-05',NULL,'Cash',300000,'0',0),('8cc51e82-9b76-4067-9659-7862bafaff1b','2016-07-05',NULL,'Ranking 1-5',150000,'0',0),('d6245e90-5db2-4d12-9d07-9f549fb1e883','2016-07-05',NULL,'Kakak-Adik',50000,'0',0),('f86e0034-5e69-47b4-bf5b-2e36b4f13d19','2016-07-05',NULL,'Ranking 6-10',100000,'0',0);
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;
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
INSERT INTO `employee` VALUES ('1eac1247-f5d9-457a-9be8-6ad92726b7b7','8ec6c4bc-a40e-4aa6-bbbb-fa37ddb84afa'),('37d15e48-af8f-462e-b818-9ce9575434df','fd46127d-40fa-45c2-9db9-5bab67ec1369'),('402a4e85-dec6-4e4d-adbe-40b04ff8a968','d5b99fa3-bd64-4e2a-94cc-4ba58fe15bdb'),('448aa546-4ead-42d7-a186-2536fcda218d','331fef79-8ce3-470c-ab10-8e8822771172'),('49de5652-2700-4ac8-bcf5-264f14049fda','1a998880-0aa2-4997-9919-374fd44b2f3f'),('514f88c5-b214-4b19-a268-c4ce837c984a','a08fe6a8-245b-438c-98e6-c49dc10bfc27'),('66a15946-b414-429b-a9db-bd031181d6e3','ff832e4c-b53c-4273-a793-48d9eb755e1d'),('6dc42b95-054a-44f7-9f4e-fc9860ee358d','134e7bd0-34c2-4fa4-a112-cb80ed57d749'),('85602db7-d78a-4b75-b903-ea38946257c0','19762b4c-4091-46ef-9907-4abf963bfcf2'),('ab2442f4-e1e2-48ad-b346-10dc7d6a3214','382d0cd2-4930-4dff-a812-b30219ada799'),('b90996b5-b2b7-4b32-95aa-abafba85cd87','598e5eb3-21a3-47f6-9b1a-c608a8c24d98'),('e65c2737-25cc-4eb5-a9f7-20d60e164bac','9830376f-bc22-407d-adc9-8a1ba965e588'),('fd77fcef-617c-4882-b246-418976893bd9','d19c1a99-e7d4-4975-a886-0f0175365633');
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
INSERT INTO `employment` VALUES ('06e699ef-9a6f-464a-8b4c-03bb640c351d','448aa546-4ead-42d7-a186-2536fcda218d','af5eb485-ee5f-44ab-a908-fa8947702fba'),('09d687d9-9a78-4d44-ace4-fbc76889fd7b','1eac1247-f5d9-457a-9be8-6ad92726b7b7','af5eb485-ee5f-44ab-a908-fa8947702fba'),('34110f33-93df-4fc8-93d9-34b5672448fd','b90996b5-b2b7-4b32-95aa-abafba85cd87','af5eb485-ee5f-44ab-a908-fa8947702fba'),('5260d4e9-770e-4b7c-b22f-fd8cdc96a718','6dc42b95-054a-44f7-9f4e-fc9860ee358d','af5eb485-ee5f-44ab-a908-fa8947702fba'),('63ebacc0-3a90-4dd0-9dce-dd04336ff7ef','ab2442f4-e1e2-48ad-b346-10dc7d6a3214','af5eb485-ee5f-44ab-a908-fa8947702fba'),('67647b1b-bd2a-4ee7-94c5-51b57a667b2d','402a4e85-dec6-4e4d-adbe-40b04ff8a968','af5eb485-ee5f-44ab-a908-fa8947702fba'),('77148623-ed53-4425-a2b4-c36bb6dde49a','85602db7-d78a-4b75-b903-ea38946257c0','af5eb485-ee5f-44ab-a908-fa8947702fba'),('9e399c23-e5d5-4840-9eae-08b6dca5c20a','49de5652-2700-4ac8-bcf5-264f14049fda','af5eb485-ee5f-44ab-a908-fa8947702fba'),('a1321ba5-f0e8-4088-9c36-19491bcf7ade','66a15946-b414-429b-a9db-bd031181d6e3','af5eb485-ee5f-44ab-a908-fa8947702fba'),('b01a1ff9-a133-4957-bf32-86e517d29102','fd77fcef-617c-4882-b246-418976893bd9','af5eb485-ee5f-44ab-a908-fa8947702fba'),('ba2a447b-2664-4a7f-8910-51fb69d684a4','37d15e48-af8f-462e-b818-9ce9575434df','af5eb485-ee5f-44ab-a908-fa8947702fba'),('bac11b62-5031-472d-b175-0c14411a5e30','514f88c5-b214-4b19-a268-c4ce837c984a','af5eb485-ee5f-44ab-a908-fa8947702fba'),('f9c19f03-6a11-434c-b5b1-f978ba6d0778','e65c2737-25cc-4eb5-a9f7-20d60e164bac','af5eb485-ee5f-44ab-a908-fa8947702fba');
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
INSERT INTO `employment_application` VALUES ('a429cd8a-a725-4383-8448-b3821710c17d','2016-07-12','ACCEPTED','REFERENCE','dfbdd782-b15a-42d0-9567-0c9f7d3dbfbf',NULL,'99b9d50a-69cc-4496-a00d-4533ef3c1fca',0);
/*!40000 ALTER TABLE `employment_application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `erp_mode`
--

DROP TABLE IF EXISTS `erp_mode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `erp_mode` (
  `id` char(50) NOT NULL,
  `segmentation` char(15) DEFAULT 'GENERAL',
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `erp_mode`
--

LOCK TABLES `erp_mode` WRITE;
/*!40000 ALTER TABLE `erp_mode` DISABLE KEYS */;
INSERT INTO `erp_mode` VALUES ('00000','EDUCATION',1);
/*!40000 ALTER TABLE `erp_mode` ENABLE KEYS */;
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
INSERT INTO `facility` VALUES ('47a0e26a-8925-42cc-9abd-0e35c98c1f8f','Room B','Ruang Kelas B','','ROOMS','718f1c84-3e66-4fee-b83c-84cbe80f4e43',0),('718f1c84-3e66-4fee-b83c-84cbe80f4e43','Head Office','Office Pancasila','','BUILDING',NULL,0),('92865bd0-c7d6-4504-b40e-1f706c4b579a','Room A','Ruang Kelas A','','ROOMS','718f1c84-3e66-4fee-b83c-84cbe80f4e43',0);
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
INSERT INTO `facility_organization` VALUES ('20ed1275-59e4-43dc-b465-1fc3a30470f6','1','718f1c84-3e66-4fee-b83c-84cbe80f4e43','41f53d44-746a-4e63-9b53-052fc9991809',0),('6e50ece9-2c9d-49d0-8e12-f3143adfe472','1','718f1c84-3e66-4fee-b83c-84cbe80f4e43','f430829b-4c5b-4dcf-8191-803e666a49e7',0),('7708b1a6-5f86-41d9-80aa-93346bf2c92e','1','47a0e26a-8925-42cc-9abd-0e35c98c1f8f','41f53d44-746a-4e63-9b53-052fc9991809',0),('7ef34657-a383-4e73-ae7b-91efdb5bd34d','1','92865bd0-c7d6-4504-b40e-1f706c4b579a','41f53d44-746a-4e63-9b53-052fc9991809',0),('d0dadff3-cba9-4b2f-945b-3f898f145726','1','47a0e26a-8925-42cc-9abd-0e35c98c1f8f','f430829b-4c5b-4dcf-8191-803e666a49e7',0),('ee2b8b42-a70e-4e75-8712-76153735c093','1','92865bd0-c7d6-4504-b40e-1f706c4b579a','f430829b-4c5b-4dcf-8191-803e666a49e7',0);
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
INSERT INTO `geographic` VALUES ('','RSJ','Rasau Jaya','CITY','',0),('68309a5f-4606-46d3-ad20-996ed6c782d0','KAL-BAR','Kalimantan Barat','PROVINCE','',0),('c4c10aee-a3a1-4e6c-a08b-62d4e26414df','PNK','Pontianak','CITY','',0),('f5a12273-368d-4d39-851a-05da7bb04ab9','IN-ID','Indonesia','COUNTRY','',0);
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
INSERT INTO `internal_organization` VALUES ('af5eb485-ee5f-44ab-a908-fa8947702fba'),('e8e7834b-b599-453c-a737-14fb05d0a908');
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
INSERT INTO `medical_sales` VALUES ('4a4a5714-d094-4cf0-8405-cb32a8d84e71',1,'19:13:56','Registered');
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
INSERT INTO `module` VALUES ('07452775-a048-4071-8798-21dc943fe926','PRODUCT','Product','','INVENTORY','0',0),('0b503053-31eb-410d-90a6-ec6a9977bc1e','FAMILY_FOLDER','Family Folder','','CLINIC','0',0),('0c586cf4-9bd2-4b93-b24b-d41ceca2aef4','CLINIC_SALES','Clinic Sales','','CLINIC','0',0),('13989b38-ac2c-47b8-8708-5e27477af18d','BENEFIT_TYPE','Benefit Type','','HR','0',0),('1adc4b8b-ad93-4658-8476-6bb13e2e810d','PURCHASE_ORDER_REQUEST','Purchase Order Request','','PROCUREMENT','0',0),('1cf392fc-4f93-4e38-9709-2beb84434951','DOCTORTYPE','Doctor Type','','CLINIC','0',0),('29ec80f0-0d4c-451c-ae5e-f195c4be1a27','COMPANY_STRUCTURE','Company Structure','','GENERAL','0',0),('2bdc3f95-c5bd-47d9-adce-9e9df1042e2f','BUDGET_APPROVER','Budget Approver','','ACCOUNTING','0',0),('2c0d9a06-cebd-4da2-b520-2e948aae3e53','INVOICE_REPORT','Invoice Report','','FINANCIAL','0',0),('2d7e5641-511d-43fd-a6d6-a482120f8aa5','BUDGET','Budget','','ACCOUNTING','0',0),('314a3f13-a982-4915-a5cb-455eacbc27ae','INBOX','Inbox Message','','SYSTEM','0',0),('322d37f6-a667-481e-bc22-db212d0154ea','EMPYAPP','Employment Application','','HR','0',0),('339d7200-9aa1-43d5-8683-e7118cb52839','STUDENT','Student','','EDUCATION','0',0),('342b0b64-291f-4d12-bdb8-77186895d21d','SALES_REPORT','Sales Report','','SALES','0',0),('355ca995-6bae-4638-bfd4-a9bfeff5eefb','INVOICE_OVERDUE_REPORT','Invoice Over Due Report','','FINANCIAL','0',0),('4500a912-bbad-4590-9abb-d9ec92a311a5','DISCOUNT','Discount Programm','Discount','PAYMENT','0',1),('4939e42f-06b5-4e44-b3ba-4106964f1f68','ACCOUNTINGPERIOD','Accounting Period','','ACCOUNTING','0',0),('4b3bb551-173e-46f5-b1e9-bdd719e3045e','COA','General Chart of Account','','ACCOUNTING','0',0),('4bf39427-b32a-434c-bd71-4d9493ea6eef','STOCK_OPNAME','Stock Opname','','INVENTORY','0',0),('4eb93eb7-2100-49ae-bd96-a39995ed5670','USER','User','Application User Module','SECURITY','1',0),('4eca5501-a650-41d5-87c1-c091391d3608','CASHSALES','Cash Sales','','SALES','0',0),('55b7e0fb-a178-478b-a09e-4b753f161aeb','MEDICATION','Medication','','CLINIC','0',0),('58621810-2c8f-44ae-b9aa-b1e05ad32743','SUPPLIER','Supplier','','PROCUREMENT','0',0),('5c37296e-ab30-4d07-bba3-342d4c403f48','INVITEM','Inventory Item','','INVENTORY','0',0),('5cdd1545-8fdb-4a79-b2a3-0662ed6fec30','POSITIONTYPERATE','Position Type Rate','','HR','0',0),('5e8c4a66-e46a-4000-ae1c-bf536686b30f','TRN_ORDER_REQ','Transfer Order Request','','INVENTORY','0',0),('5eda5016-f448-42dd-926b-52b10870e29c','STUDY_TIME','Study Time','','EDUCATION','0',0),('627fb961-6cf0-4148-9451-0d1422095eb7','PURCHASE_ORDER_APPROVER','Purchase Order Request Approver','','PROCUREMENT','0',0),('65414caf-3a73-4e3f-9a58-2d70c723b5bc','CURRENCY','Currency','GENERAL','ACCOUNTING','0',1),('6861d3b3-8110-46ed-8a3a-830963597fa7','TAX','Tax','','ACCOUNTING','0',0),('69443009-4a15-4061-b9f0-08c08c8f50aa','JOURNALENTRY','Journal Entry','','ACCOUNTING','0',0),('6cbaf072-6925-46e9-b417-17326f3d8584','EMPLOYMENT','Employment','','HR','0',0),('6e299ade-e10e-4940-ae83-bdf61505ed63','STUDENT_REGISTRATION','Student Registration','','EDUCATION','0',0),('74ad4867-9495-472f-97fc-36bf87895585','COURSE_ATTENDANCE','Course Attendance','EDUCATION','EDUCATION','0',1),('770c420c-f809-43f7-969c-b493f0b4ef48','CASHIER','Cashier','','SALES','0',0),('7bef1d92-0f15-43ef-b59b-5bc3e769d896','UOM','Unit of Measure','','INVENTORY','0',0),('7f17176c-f27a-432c-a106-0d7d87b0afb7','RECEIPT','Receipt','','PAYMENT','0',0),('80aebe74-399c-4273-9145-956a077d3f5d','ACCESS_ROLE','Role','Application Access Role','SECURITY','1',0),('8217c196-16b9-44fb-9662-8323220ee705','ASSET','Asset Management','','ASSET','0',0),('83b19678-9f2f-49f4-ba25-0f31a8dee078','PHARMACY_ORDER','Pharmacy Order','','PHARMACY','0',0),('847a8df6-bc04-4de6-8d7d-28e41c00f422','DOCTOR_APPOINTMENT','Doctor Appointment','','CLINIC','0',0),('855aab16-cb45-41c3-b62c-55185ff77dfc','PHARMACY_SALES','Pharmacy Sales','','PHARMACY','0',0),('88bf4008-c84a-4089-88c6-e9d8f077a196','JOURNALSETTING','Journal Setting','','ACCOUNTING','0',0),('8a05b279-2f80-47b8-a2a7-63fbe96d327e','AUDIT_TRAIL','Audit Trail','','SYSTEM','0',0),('8c7e1020-0824-4239-9a4e-46301c80b9cd','PAYMENT_METHOD_TYPE','Payment Method Type','','PAYMENT','0',0),('8f6ec9c8-e9ed-49e1-ab7a-c4a868b8391e','ORGANIZATIONACCOUNT','Organization Account','','ACCOUNTING','0',0),('90195ecb-4674-4614-a429-eebc24ffe773','POSITIONTYPE','Position Type','','HR','0',0),('916b22eb-48fa-4000-b7a2-7fc1d47ced4e','STOCK_ADJUSTMENT','Stock Adjustment','','INVENTORY','0',0),('9178e8cd-4063-4fe9-a060-d2e3ac818ed1','PAYCHECK','Paycheck','','PAYMENT','0',0),('95dd39dd-512e-414e-b95c-0fc251887f98','PRDCATEGORY','Product Category','','INVENTORY','0',0),('99623cbd-066f-4cc2-b9b3-1961bed131cc','GOODS_TRANSFER','Goods Transfer','','INVENTORY','0',0),('9b9deb26-0960-478c-8cac-4ac475c3ffc3','COURSE_REGISTRATION','Course Registration','','EDUCATION','0',0),('9b9e014c-7a23-40c1-8841-30044564bf7f','MODULE','Module','Application Module','SECURITY','1',0),('9b9e014c-7a23-40c1-8841-30044564bf7x','SYSTEM','System Access','System Access','SYSTEM','1',0),('9df71b1a-0e52-4445-98ea-b9a59ad81ac9','PATIENT','Patient','','CLINIC','0',0),('9e644628-121d-4954-8a66-8002cc866bda','STOCK_ADMIN','Stock Admin','','INVENTORY','0',0),('a4aa9ae0-5166-4d06-afd1-d2eea6f2417c','PERSON','Person Management','','GENERAL','0',0),('a4c43802-436f-407c-8793-323600c181d7','GOODS_RECEIVE','Goods Receive','','INVENTORY','0',0),('abfd9a02-3b4b-47a0-9048-a65b6be0b3aa','PRODUCT_RETUR','Product Retur','','INVENTORY','0',0),('affcf2e7-fd2c-4b39-beee-97b5dc5a1405','STUDY_PERIOD','Study Period','','EDUCATION','0',0),('b44420c6-261b-44c5-a23a-7802a0506dab','RECURRING_PAYMENT','Recurring Payment','','PAYMENT','0',0),('b54c8e49-c820-4292-9f74-9e47bd55711f','CASH_PURCHASE_ORDER','Cash Purchase Order','','PROCUREMENT','0',0),('b662de02-f4a3-4f1a-819b-5d2aaf6a342b','GOODS_ISSUE','Goods Issue','','INVENTORY','0',0),('b9935030-f5c1-479e-9ec1-795afc1c1e7e','FACILITY','Facility','','INVENTORY','0',0),('c0f3237c-23c2-49ab-bc9c-e00aa706d7e2','PROFIT_LOSS','Profit Loss Report','','FINANCIAL','0',0),('c79e78d0-3427-440c-b8fe-df126e667a8b','INVOICE_DUEDATE_REPORT','Invoice Due Date Report','','FINANCIAL','0',0),('d33784ca-abd5-422b-b45a-8c8ee13ddc0a','DEDUCTION_TYPE','Deduction Type','','PAYMENT','0',0),('dbc9175e-eb27-45e9-9e43-a1c12d6354e4','DOCTOR','Doctor','','CLINIC','0',0),('e4307d82-f3fa-4916-9e6b-7a4f894d847e','ORGANIZATION','Organization','','GENERAL','0',0),('e4d249e1-4bd5-4291-9050-62a99f70f64c','CLINIC_REPORT','Clinic Reports','','CLINIC','0',0),('e54e6ba5-7ffd-457b-a23e-8b6285867ba4','STUDY_ROOM','Study Room','','EDUCATION','0',0),('e8f89299-2138-4167-b5b7-52f6ae1667ca','POSITION','Position','','HR','0',0),('e916392a-0b3c-4543-ada7-93054383bb3b','MESSAGE','Message','','SYSTEM','0',0),('ee3c3540-9c62-46df-a79e-f7b636a9ba1d','STUDY_DAY','Study Day','EDUCATION','EDUCATION','0',1),('f50dd16d-0e25-44b6-bd69-c28dfcc55300','GEOGRAPHIC','Geographic','','GENERAL','0',0),('f53b80db-1b89-4779-86e7-b065b5287bbb','ASSET_TYPE','Asset Type','','ASSET','0',0),('fab64cd8-7762-412b-90fb-3d31d5576b45','COURSE_SCHEDULE','Course Schedule','','EDUCATION','0',0),('fca1cfcf-d199-4729-a321-e1ed01deb0f1','LABS_REGISTRATION','Laboratory Registration','','MEDICALLAB','0',0);
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
INSERT INTO `organization` VALUES ('41f53d44-746a-4e63-9b53-052fc9991809','EDUCATION'),('f430829b-4c5b-4dcf-8191-803e666a49e7','EDUCATION');
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
INSERT INTO `party` VALUES ('0ba10d3e-67bf-439b-a8a0-14a698dc82a1','Jaja Miharja',NULL,'2000-07-08','',1,'SDN2016070001'),('0e90867e-3ab2-4e2c-86e0-1a98c81a8d66','Lara Croft',NULL,'2016-07-08','',1,'SDN2016070001'),('10b4a630-cecb-4bd8-9848-83a905dbb0cc','Udin samsudin kumarudin',NULL,'2016-07-08','',1,'SDN2016070001'),('10fe16f0-3f2c-4995-b6c3-5f5447597a12','Anonymous',NULL,'2000-06-18','',0,'00000'),('162e071a-a97b-4235-911a-a6c8ab5c060c','Rahayu',NULL,'1988-07-13','',0,'000020'),('290d6982-4d52-4542-9595-c27dba0faa06','Taufik',NULL,'1988-07-13','',0,'000019'),('2d1b49df-59d0-45b7-be75-4df7737b6b56','Yuli',NULL,'1988-07-13','',0,'000017'),('41f53d44-746a-4e63-9b53-052fc9991809','SONY SUGEMA COLLEGE',NULL,'2014-07-04','0001',0,'0001'),('53a035b7-59cd-4197-80f6-7bec766eec23','Rohmat',NULL,'1988-07-13','',0,'000010'),('67cc81c5-3bd1-4a5a-9234-e99ab1c4a529','Dwi',NULL,'1988-07-13','',0,'000014'),('7763c58e-5215-4876-89c4-157290d26bd1','Eka',NULL,'1988-07-13','',0,'000018'),('99b9d50a-69cc-4496-a00d-4533ef3c1fca','Citra',NULL,'1988-07-12','',1,'000001'),('b21d3b50-7005-40b9-8ad5-5f53195fcff1','Dwita',NULL,'1988-07-13','',0,'000011'),('bc248df1-f3af-425b-90b5-e6e2ae292060','Purnama',NULL,'1988-07-13','',0,'000021'),('c1597466-ba7a-497d-a40f-b2a4ed71a258','rudi tabuti',NULL,'2016-07-08','',1,'SDN2016070002'),('c2c88ef4-9b54-4861-bbb9-dd0f7243a984','Ayu',NULL,'1988-07-13','',0,'000012'),('c589af39-f795-4865-ae4b-5cea360a62be','Ani',NULL,'1988-07-13','',0,'000013'),('d244ced8-9221-4988-93e4-ccedc2ee45e6','Desi',NULL,'1988-07-13','',0,'000015'),('d2928c7c-f2c2-4daf-97f7-721d1975394f','Dila',NULL,'2016-07-13','',0,'000016'),('f430829b-4c5b-4dcf-8191-803e666a49e7','Enterprise Holding',NULL,'2016-07-04','0000',0,'0000'),('ff4eee76-ea62-49bd-b62b-8b0964da3502','Mike sanders',NULL,'2016-07-08','',1,'SDN2016070001');
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
INSERT INTO `party_relationship` VALUES ('06e699ef-9a6f-464a-8b4c-03bb640c351d','2016-07-13',NULL,NULL,NULL,0),('09d687d9-9a78-4d44-ace4-fbc76889fd7b','2016-07-13',NULL,NULL,NULL,0),('17e6ccdf-5862-48e7-bc7f-bfe8f5e0d10e','2016-07-08',NULL,NULL,NULL,0),('22b90d7c-9388-4310-8ae1-42fcc20810e5','2016-07-08',NULL,NULL,NULL,0),('34110f33-93df-4fc8-93d9-34b5672448fd','2016-07-13',NULL,NULL,NULL,0),('5260d4e9-770e-4b7c-b22f-fd8cdc96a718','2016-07-13',NULL,NULL,NULL,0),('63ebacc0-3a90-4dd0-9dce-dd04336ff7ef','2016-07-16',NULL,NULL,NULL,0),('67647b1b-bd2a-4ee7-94c5-51b57a667b2d','2016-07-13',NULL,NULL,NULL,0),('77148623-ed53-4425-a2b4-c36bb6dde49a','2016-07-13',NULL,NULL,NULL,0),('959099df-b96b-4eb2-945f-7fec7782ca22','2016-07-08',NULL,NULL,NULL,0),('9dec4469-51ed-46be-8f91-cac0e47dacb9','2016-07-08',NULL,NULL,NULL,0),('9e399c23-e5d5-4840-9eae-08b6dca5c20a','2016-07-13',NULL,NULL,NULL,0),('a1321ba5-f0e8-4088-9c36-19491bcf7ade','2016-07-13',NULL,NULL,NULL,0),('b01a1ff9-a133-4957-bf32-86e517d29102','2016-07-13',NULL,NULL,NULL,0),('ba2a447b-2664-4a7f-8910-51fb69d684a4','2016-07-13',NULL,NULL,NULL,0),('bac11b62-5031-472d-b175-0c14411a5e30','2016-07-13',NULL,NULL,NULL,0),('f30e2333-99b4-4161-9b12-c70a4d70d43b','2016-07-08',NULL,NULL,NULL,0),('f9c19f03-6a11-434c-b5b1-f978ba6d0778','2016-07-13',NULL,NULL,NULL,0);
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
INSERT INTO `party_role` VALUES ('0a3bc391-08d7-4658-bae3-cfeb08592c4e','2016-07-08',NULL,'ff4eee76-ea62-49bd-b62b-8b0964da3502',0),('1eac1247-f5d9-457a-9be8-6ad92726b7b7','2016-07-13',NULL,'bc248df1-f3af-425b-90b5-e6e2ae292060',0),('37d15e48-af8f-462e-b818-9ce9575434df','2016-07-13',NULL,'53a035b7-59cd-4197-80f6-7bec766eec23',0),('402a4e85-dec6-4e4d-adbe-40b04ff8a968','2016-07-13',NULL,'d2928c7c-f2c2-4daf-97f7-721d1975394f',0),('42459447-4a9f-44aa-b1ed-d2ee0bd9570b','2016-07-08',NULL,'0ba10d3e-67bf-439b-a8a0-14a698dc82a1',0),('448aa546-4ead-42d7-a186-2536fcda218d','2016-07-13',NULL,'7763c58e-5215-4876-89c4-157290d26bd1',0),('49de5652-2700-4ac8-bcf5-264f14049fda','2016-07-13',NULL,'2d1b49df-59d0-45b7-be75-4df7737b6b56',0),('514f88c5-b214-4b19-a268-c4ce837c984a','2016-07-13',NULL,'d244ced8-9221-4988-93e4-ccedc2ee45e6',0),('66a15946-b414-429b-a9db-bd031181d6e3','2016-07-13',NULL,'290d6982-4d52-4542-9595-c27dba0faa06',0),('6dc42b95-054a-44f7-9f4e-fc9860ee358d','2016-07-13',NULL,'b21d3b50-7005-40b9-8ad5-5f53195fcff1',0),('85602db7-d78a-4b75-b903-ea38946257c0','2016-07-13',NULL,'c589af39-f795-4865-ae4b-5cea360a62be',0),('9a81283f-78a2-461d-86d2-599d7edd68d1','2016-07-08',NULL,'0e90867e-3ab2-4e2c-86e0-1a98c81a8d66',0),('a89588dd-464e-4f22-9f75-86b9631b4478','2016-07-08',NULL,'10b4a630-cecb-4bd8-9848-83a905dbb0cc',0),('ab2442f4-e1e2-48ad-b346-10dc7d6a3214','2016-07-12',NULL,'99b9d50a-69cc-4496-a00d-4533ef3c1fca',0),('af5eb485-ee5f-44ab-a908-fa8947702fba','2016-07-08',NULL,'41f53d44-746a-4e63-9b53-052fc9991809',0),('b0ad6fa6-73ba-46ff-8d97-3b06bb054942','2016-07-08',NULL,'c1597466-ba7a-497d-a40f-b2a4ed71a258',0),('b90996b5-b2b7-4b32-95aa-abafba85cd87','2016-07-13',NULL,'162e071a-a97b-4235-911a-a6c8ab5c060c',0),('e65c2737-25cc-4eb5-a9f7-20d60e164bac','2016-07-13',NULL,'c2c88ef4-9b54-4861-bbb9-dd0f7243a984',0),('e8e7834b-b599-453c-a737-14fb05d0a908','2016-07-08',NULL,'f430829b-4c5b-4dcf-8191-803e666a49e7',0),('fd77fcef-617c-4882-b246-418976893bd9','2016-07-13',NULL,'67cc81c5-3bd1-4a5a-9234-e99ab1c4a529',0);
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
INSERT INTO `pay_history` VALUES ('069eb775-78c7-45c3-a083-a9f6254ec856','2016-07-01',NULL,25000,'Hourly','06e699ef-9a6f-464a-8b4c-03bb640c351d',0),('1358232b-c92a-44b1-919a-46ac5230938d','2016-07-01',NULL,25000,'Hourly','63ebacc0-3a90-4dd0-9dce-dd04336ff7ef',0),('fdd08858-e047-4a2b-ae0b-7e4189ef76d5','2016-07-14',NULL,700000,'Hourly','06e699ef-9a6f-464a-8b4c-03bb640c351d',0);
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
  `fk_empployment` char(50) DEFAULT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paycheck`
--

LOCK TABLES `paycheck` WRITE;
/*!40000 ALTER TABLE `paycheck` DISABLE KEYS */;
INSERT INTO `paycheck` VALUES ('f576fa89-5590-4bfb-a4e0-95e2756bfd04','63ebacc0-3a90-4dd0-9dce-dd04336ff7ef','2016-07-01','2016-07-31');
/*!40000 ALTER TABLE `paycheck` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paycheck_item`
--

DROP TABLE IF EXISTS `paycheck_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paycheck_item` (
  `id` char(50) NOT NULL,
  `method` char(15) DEFAULT NULL,
  `account` char(50) DEFAULT NULL,
  `bank` varchar(150) DEFAULT NULL,
  `fk_paycheck` char(50) DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paycheck_item`
--

LOCK TABLES `paycheck_item` WRITE;
/*!40000 ALTER TABLE `paycheck_item` DISABLE KEYS */;
INSERT INTO `paycheck_item` VALUES ('75457a55-7e51-4380-b752-da8be639deb2','Cash','','','f576fa89-5590-4bfb-a4e0-95e2756bfd04',262500,0),('f92344af-fbf0-4f5e-8e07-8916b4f2a698','Transfer','83462','Bank Air','f576fa89-5590-4bfb-a4e0-95e2756bfd04',262500,0);
/*!40000 ALTER TABLE `paycheck_item` ENABLE KEYS */;
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
  `fk_staff` char(50) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `fk_currency` char(50) DEFAULT NULL,
  `fk_tax` char(50) DEFAULT NULL,
  `fk_payment_type` char(50) DEFAULT NULL,
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
INSERT INTO `payment` VALUES ('18859f3e-1d5a-4987-a579-e17d331b86f3','991249124','2016-07-20',575000,NULL,'','41f53d44-746a-4e63-9b53-052fc9991809','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('539a18f3-a167-4502-977c-eaaee191ca2a','','2016-07-20',500000,'c589af39-f795-4865-ae4b-5cea360a62be','','41f53d44-746a-4e63-9b53-052fc9991809','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','272e9a32-de09-411f-ac8a-2039377ec7bc',0),('6a228cb2-9b9d-4e94-a6ff-6c25c7ba1adf','PHS3','2016-07-20',10000,'c589af39-f795-4865-ae4b-5cea360a62be','Cashier Event','41f53d44-746a-4e63-9b53-052fc9991809','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','5032a36e-3c3d-45c3-a9c1-509cb0bb1371',0),('837d5303-42ee-4736-9c84-b481b362d4e9','32512421','2016-07-21',2000000,'c589af39-f795-4865-ae4b-5cea360a62be','','41f53d44-746a-4e63-9b53-052fc9991809','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('a02403c5-53f6-4519-b004-5ea5f911d86f','BLG1469019325828','2016-07-20',2420000,'c589af39-f795-4865-ae4b-5cea360a62be','Cashier Event','41f53d44-746a-4e63-9b53-052fc9991809','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b685e80a-5257-49c7-9c7d-11b986a49b29','272e9a32-de09-411f-ac8a-2039377ec7bc',0),('b86c7a63-d82a-49bc-bece-3b6307a0dae3','','2016-07-20',800000,'c589af39-f795-4865-ae4b-5cea360a62be','','41f53d44-746a-4e63-9b53-052fc9991809','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','272e9a32-de09-411f-ac8a-2039377ec7bc',0),('f576fa89-5590-4bfb-a4e0-95e2756bfd04',NULL,'2016-07-17',525000,'10fe16f0-3f2c-4995-b6c3-5f5447597a12','','f430829b-4c5b-4dcf-8191-803e666a49e7','85c90912-97ff-47ce-9d6a-7d1650ab3ea9',NULL,'272e9a32-de09-411f-ac8a-2039377ec7bc',0),('f7cde1de-3349-4ef4-99aa-ca206af45380','PHS3','2016-07-20',10000,'c589af39-f795-4865-ae4b-5cea360a62be','Cashier Event','41f53d44-746a-4e63-9b53-052fc9991809','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','272e9a32-de09-411f-ac8a-2039377ec7bc',0);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_application`
--

DROP TABLE IF EXISTS `payment_application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment_application` (
  `id` char(50) NOT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `fk_billing` char(50) DEFAULT NULL,
  `fk_receipt` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_application`
--

LOCK TABLES `payment_application` WRITE;
/*!40000 ALTER TABLE `payment_application` DISABLE KEYS */;
INSERT INTO `payment_application` VALUES ('33d1ca5d-ca0c-4231-987b-42023bd5356a',10000,'4a4a5714-d094-4cf0-8405-cb32a8d84e71','f7cde1de-3349-4ef4-99aa-ca206af45380',NULL),('359d61a8-310d-4da5-8074-d919ea64e8d4',800000,'c6eb2431-9f02-4378-8c51-f95b262daa07','b86c7a63-d82a-49bc-bece-3b6307a0dae3',NULL),('7d601570-5b45-4650-94a4-3f4b4d8ee502',10000,'4a4a5714-d094-4cf0-8405-cb32a8d84e71','6a228cb2-9b9d-4e94-a6ff-6c25c7ba1adf',NULL),('8e4b25b5-e940-46de-8cf4-24cf70701c77',500000,'689e24d0-e679-450a-b3f6-c854e7248633','539a18f3-a167-4502-977c-eaaee191ca2a',NULL),('9ea1b1aa-03d0-4c08-8cb5-e6c2d0425401',2420000,'04fc3ce9-63c7-43e5-961f-1d7c285c9d8b','a02403c5-53f6-4519-b004-5ea5f911d86f',NULL);
/*!40000 ALTER TABLE `payment_application` ENABLE KEYS */;
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
INSERT INTO `payment_method_type` VALUES ('272e9a32-de09-411f-ac8a-2039377ec7bc','Cash','Cash',0),('5032a36e-3c3d-45c3-a9c1-509cb0bb1371','Transfer','Bank Transfer',0);
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
  `fk_employee` char(50) DEFAULT NULL,
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
INSERT INTO `payroll_preference` VALUES ('4791e63b-cfdd-4d95-86cc-977de0ed78d1','2016-07-01',NULL,'5032a36e-3c3d-45c3-a9c1-509cb0bb1371',50,0,'83462','Bank Air','Hourly','63ebacc0-3a90-4dd0-9dce-dd04336ff7ef',0),('a31bdacb-62d9-4de6-a59e-1b9b2366fe8d','2016-07-01',NULL,'272e9a32-de09-411f-ac8a-2039377ec7bc',50,0,'','','Hourly','63ebacc0-3a90-4dd0-9dce-dd04336ff7ef',0);
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
INSERT INTO `person` VALUES ('0ba10d3e-67bf-439b-a8a0-14a698dc82a1','MALE','SINGLE'),('0e90867e-3ab2-4e2c-86e0-1a98c81a8d66','FEMALE','SINGLE'),('10b4a630-cecb-4bd8-9848-83a905dbb0cc','MALE','SINGLE'),('10fe16f0-3f2c-4995-b6c3-5f5447597a12','MALE','SINGLE'),('162e071a-a97b-4235-911a-a6c8ab5c060c','FEMALE','SINGLE'),('290d6982-4d52-4542-9595-c27dba0faa06','MALE','SINGLE'),('2d1b49df-59d0-45b7-be75-4df7737b6b56','FEMALE','SINGLE'),('53a035b7-59cd-4197-80f6-7bec766eec23','MALE','SINGLE'),('67cc81c5-3bd1-4a5a-9234-e99ab1c4a529','MALE','SINGLE'),('7763c58e-5215-4876-89c4-157290d26bd1','MALE','SINGLE'),('99b9d50a-69cc-4496-a00d-4533ef3c1fca','FEMALE','SINGLE'),('b21d3b50-7005-40b9-8ad5-5f53195fcff1','FEMALE','SINGLE'),('bc248df1-f3af-425b-90b5-e6e2ae292060','MALE','SINGLE'),('c1597466-ba7a-497d-a40f-b2a4ed71a258','MALE','SINGLE'),('c2c88ef4-9b54-4861-bbb9-dd0f7243a984','FEMALE','SINGLE'),('c589af39-f795-4865-ae4b-5cea360a62be','FEMALE','SINGLE'),('d244ced8-9221-4988-93e4-ccedc2ee45e6','FEMALE','SINGLE'),('d2928c7c-f2c2-4daf-97f7-721d1975394f','FEMALE','SINGLE'),('ff4eee76-ea62-49bd-b62b-8b0964da3502','MALE','SINGLE');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
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
INSERT INTO `pharmacy_sales` VALUES ('4a4a5714-d094-4cf0-8405-cb32a8d84e71','0');
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
INSERT INTO `pharmacy_sales_item` VALUES ('95e525aa-3829-450c-b105-7ce91a88c818','dadc2fa7-b45c-4e7e-a693-75fb6596c276',1,20000,0,0,'4a4a5714-d094-4cf0-8405-cb32a8d84e71','',0);
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
INSERT INTO `position` VALUES ('62b0d9de-3e70-47ee-a27f-a16e5841d194','2016-07-13',NULL,'2016-07-13',NULL,'Freelance','Contract','Monthly','Open',NULL,'f0c1bb2c-2f39-4477-9c6a-b5131afb37f7','f430829b-4c5b-4dcf-8191-803e666a49e7',0),('7beaf031-6bdb-4c79-b8ad-9a3ae2c94791','2016-07-13',NULL,'2016-07-13',NULL,'Freelance','Contract','Monthly','Open',NULL,'4eeb7d66-70ed-4935-8684-40409da9e46e','f430829b-4c5b-4dcf-8191-803e666a49e7',0),('a5441407-d33c-4bc6-857f-07566a55eeeb','2016-07-13',NULL,'2016-07-13',NULL,'Freelance','Contract','Monthly','Open',NULL,'fcc623ce-1e66-493e-989c-33a226c1117f','f430829b-4c5b-4dcf-8191-803e666a49e7',0),('c6e007e2-8728-4389-be64-2b8737734199','2016-07-13',NULL,'2016-07-13',NULL,'Freelance','Contract','Monthly','Open',NULL,'41a84b3f-f821-45c0-b036-059129b93fe5','f430829b-4c5b-4dcf-8191-803e666a49e7',0),('dfbdd782-b15a-42d0-9567-0c9f7d3dbfbf','2016-07-13',NULL,'2016-07-13',NULL,'Freelance','Contract','Monthly','Open',NULL,'7a5e597a-6627-4dae-b440-d36987a704b3','41f53d44-746a-4e63-9b53-052fc9991809',4),('e858ffbd-e80d-4f46-a46f-fc73a31b7fcf','2016-07-13',NULL,'2016-07-13',NULL,'Freelance','Contract','Monthly','Open',NULL,'e2860653-611d-45ac-91d2-71390561f45d','f430829b-4c5b-4dcf-8191-803e666a49e7',0),('f8f0bbd2-d592-4006-8ce9-07d3542471c4','2016-07-13',NULL,'2016-07-13',NULL,'Freelance','Contract','Monthly','Open',NULL,'2e1edd52-12b5-4e6b-a194-83a10d7d07f2','f430829b-4c5b-4dcf-8191-803e666a49e7',0);
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
INSERT INTO `position_fulfillment` VALUES ('53c7d889-3c7d-4992-add7-fd2a2e991e20','2016-07-13',NULL,'0','290d6982-4d52-4542-9595-c27dba0faa06','dfbdd782-b15a-42d0-9567-0c9f7d3dbfbf',0),('6cc70ce1-487f-4a8f-8b6a-3e2423f0539a','2016-07-13',NULL,'0','99b9d50a-69cc-4496-a00d-4533ef3c1fca','dfbdd782-b15a-42d0-9567-0c9f7d3dbfbf',0),('adbee145-e89c-4319-927c-7ade8ffe55e6','2016-07-13',NULL,'0','162e071a-a97b-4235-911a-a6c8ab5c060c','dfbdd782-b15a-42d0-9567-0c9f7d3dbfbf',0);
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
INSERT INTO `position_reporting_structure` VALUES ('54a7714c-66b5-49a4-b9f0-093aae30a1f5','2016-07-13',NULL,'0','0','7beaf031-6bdb-4c79-b8ad-9a3ae2c94791','dfbdd782-b15a-42d0-9567-0c9f7d3dbfbf',0);
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
INSERT INTO `position_responsibility` VALUES ('6eb9d86e-67c6-4295-8c6a-22b7b31ae0ce','2016-07-13',NULL,'0','dfbdd782-b15a-42d0-9567-0c9f7d3dbfbf',0);
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
INSERT INTO `position_type` VALUES ('2e1edd52-12b5-4e6b-a194-83a10d7d07f2','Mentor IPS','Mentor IPS',0),('41a84b3f-f821-45c0-b036-059129b93fe5','CEO','CEO',0),('4eeb7d66-70ed-4935-8684-40409da9e46e','Staff Administrasi','Staff Administrasi',0),('7a5e597a-6627-4dae-b440-d36987a704b3','Mentor Matematika','Mentor Matematika',3),('e2860653-611d-45ac-91d2-71390561f45d','Mentor B. Inggris','Mentor B. Inggris',0),('f0c1bb2c-2f39-4477-9c6a-b5131afb37f7','Mentor IPA','Mentor IPA',0),('fcc623ce-1e66-493e-989c-33a226c1117f','Mentor B. Indonesia','Mentor B. Indonesia',0);
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
INSERT INTO `position_type_rate` VALUES ('1b8c8cf4-acde-4454-b78d-43e1278e6edd','2016-07-12',NULL,25000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','7a5e597a-6627-4dae-b440-d36987a704b3','PAYROLL_RATE','PER_HOUR','',0),('1d0e0232-5265-42d2-8258-6a5aa7831708','2016-07-13',NULL,25000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','2e1edd52-12b5-4e6b-a194-83a10d7d07f2','PAYROLL_RATE','PER_HOUR','',0),('6bb25b33-ce06-4e32-a05e-7fe549fa6bdf','2016-07-13',NULL,1800000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','4eeb7d66-70ed-4935-8684-40409da9e46e','PAYROLL_RATE','PER_MONTH','',0),('974b63ff-da55-4052-b2ea-b7ccf6b3cf07','2016-07-13',NULL,50000000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','41a84b3f-f821-45c0-b036-059129b93fe5','PAYROLL_RATE','PER_MONTH','',0),('ac14ad24-354f-43ce-9127-fbc317475b85','2016-07-13',NULL,25000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e2860653-611d-45ac-91d2-71390561f45d','PAYROLL_RATE','PER_HOUR','',0),('e41cb39a-bb34-4793-a59b-120976261e60','2016-07-13',NULL,25000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f0c1bb2c-2f39-4477-9c6a-b5131afb37f7','PAYROLL_RATE','PER_HOUR','',0),('fd5d6a28-4051-42ab-996c-da910f678090','2016-07-13',NULL,25000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','fcc623ce-1e66-493e-989c-33a226c1117f','PAYROLL_RATE','PER_HOUR','',0);
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
  `code` varchar(150) DEFAULT NULL,
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
INSERT INTO `product` VALUES ('3f29559e-75ff-43c7-9bea-d8218304f649','IPS','Ilmu Pengetahuan Sosial','2016-07-11',NULL,'e1db32dc-f5f5-4b85-8d57-1f278355ba6b','c081a854-f0ea-451b-afe0-0e04406c6753','SERVICE',0,0),('76cd4643-e667-459c-9f7c-8fb7bbe4649b','MTK','Matematika','2016-07-11',NULL,'e1db32dc-f5f5-4b85-8d57-1f278355ba6b','c081a854-f0ea-451b-afe0-0e04406c6753','SERVICE',0,0),('7a7d5edb-d6ff-4b91-93db-d7a7e5a0caef','3SD','Bimbel 3 SD','2016-07-04',NULL,'e1db32dc-f5f5-4b85-8d57-1f278355ba6b','c081a854-f0ea-451b-afe0-0e04406c6753','SERVICE',0,0),('821216fb-9291-4200-b594-6b98844a5faf','B.INDO','Bahasa Indonesia','2016-07-11',NULL,'e1db32dc-f5f5-4b85-8d57-1f278355ba6b','c081a854-f0ea-451b-afe0-0e04406c6753','SERVICE',0,0),('baa6975f-1523-427b-93ad-0440a931f25b','IPA','Ilmu Pengetahuan Alam','2016-07-11',NULL,'e1db32dc-f5f5-4b85-8d57-1f278355ba6b','c081a854-f0ea-451b-afe0-0e04406c6753','SERVICE',0,0),('cc5fc1b3-aa08-4d72-be18-35edf7a53c11','ENGLISH','Bahasa Inggris','2016-07-11',NULL,'e1db32dc-f5f5-4b85-8d57-1f278355ba6b','c081a854-f0ea-451b-afe0-0e04406c6753','SERVICE',0,0),('d2634d59-9cb6-43ed-a108-473f3410390b','DAFTAR','Biaya Pendaftaran','2016-07-04',NULL,'e1db32dc-f5f5-4b85-8d57-1f278355ba6b','c081a854-f0ea-451b-afe0-0e04406c6753','SERVICE',0,0),('dadc2fa7-b45c-4e7e-a693-75fb6596c276','AAAA','AAA','2016-07-20',NULL,'e1db32dc-f5f5-4b85-8d57-1f278355ba6b','37350947-31d6-427d-b254-f6e9e9779834','FINISHGOOD',0,0);
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
INSERT INTO `product_category` VALUES ('37350947-31d6-427d-b254-f6e9e9779834','OBAT','OBAT','','MEDICAL',0),('c081a854-f0ea-451b-afe0-0e04406c6753','0001','Course','','EDUCATION',0);
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
INSERT INTO `product_component` VALUES ('3ed9f9e9-a847-4641-9101-a3c88e2c2699',1,'3f29559e-75ff-43c7-9bea-d8218304f649','7a7d5edb-d6ff-4b91-93db-d7a7e5a0caef','',0),('8223e8c3-36f7-4ca6-85a9-db24de8e4476',1,'76cd4643-e667-459c-9f7c-8fb7bbe4649b','7a7d5edb-d6ff-4b91-93db-d7a7e5a0caef','',0),('b5560656-8e47-4802-9f05-81c297a68be5',1,'cc5fc1b3-aa08-4d72-be18-35edf7a53c11','7a7d5edb-d6ff-4b91-93db-d7a7e5a0caef','',0),('d971ec7a-6020-4cf5-8c50-37fef9faaa3d',1,'baa6975f-1523-427b-93ad-0440a931f25b','7a7d5edb-d6ff-4b91-93db-d7a7e5a0caef','',0),('f1d7560c-3985-46f5-b3b8-52ec159a3829',1,'821216fb-9291-4200-b594-6b98844a5faf','7a7d5edb-d6ff-4b91-93db-d7a7e5a0caef','',0);
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
INSERT INTO `product_feature` VALUES ('36a68855-a7e5-4d8f-a3f1-30d64159d0bb','Reguler','Program','','d2634d59-9cb6-43ed-a108-473f3410390b',0),('407a4973-c132-4b92-a2cf-f1f58c54090a','Exclusive','Program','','d2634d59-9cb6-43ed-a108-473f3410390b',0),('7c519c4d-18ab-4f2c-8822-5ec07a8ab51b','Private','Program','','7a7d5edb-d6ff-4b91-93db-d7a7e5a0caef',0),('9945cbf2-9e12-4d1f-9ca3-a47b763bde6f','Reguler','Program','','7a7d5edb-d6ff-4b91-93db-d7a7e5a0caef',0),('d3274933-6664-48bf-ad05-c6e6dd5e60eb','Exclusive','Program','','7a7d5edb-d6ff-4b91-93db-d7a7e5a0caef',0),('f397758e-f598-496f-9465-fdc241eb4f8c','Intensif','Program','','7a7d5edb-d6ff-4b91-93db-d7a7e5a0caef',0);
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
  `fk_product_feature` char(50) DEFAULT NULL,
  `is_percent` char(1) DEFAULT '0',
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
INSERT INTO `product_price` VALUES ('06ff25b4-4e60-4f9d-94fe-a72a253101e6','2016-07-04',NULL,4200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'7a7d5edb-d6ff-4b91-93db-d7a7e5a0caef','d3274933-6664-48bf-ad05-c6e6dd5e60eb','0',0),('44d08cc3-8067-46bb-970e-c5d51d82234d','2016-07-04',NULL,100000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'d2634d59-9cb6-43ed-a108-473f3410390b','36a68855-a7e5-4d8f-a3f1-30d64159d0bb','0',0),('4c31e4a0-246b-4552-8ad0-f2b8dc9dd296','2016-07-04',NULL,200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'d2634d59-9cb6-43ed-a108-473f3410390b','407a4973-c132-4b92-a2cf-f1f58c54090a','0',0),('7a44b398-4709-47a7-be71-5061900fc1a4','2016-07-04',NULL,2200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'7a7d5edb-d6ff-4b91-93db-d7a7e5a0caef','9945cbf2-9e12-4d1f-9ca3-a47b763bde6f','0',0),('87ede86e-a6ee-494c-b296-1cb84967ed89','2016-07-20',NULL,20000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'dadc2fa7-b45c-4e7e-a693-75fb6596c276',NULL,'0',0);
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipt`
--

LOCK TABLES `receipt` WRITE;
/*!40000 ALTER TABLE `receipt` DISABLE KEYS */;
INSERT INTO `receipt` VALUES ('539a18f3-a167-4502-977c-eaaee191ca2a'),('6a228cb2-9b9d-4e94-a6ff-6c25c7ba1adf'),('a02403c5-53f6-4519-b004-5ea5f911d86f'),('b86c7a63-d82a-49bc-bece-3b6307a0dae3'),('f7cde1de-3349-4ef4-99aa-ca206af45380');
/*!40000 ALTER TABLE `receipt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recurring_payment`
--

DROP TABLE IF EXISTS `recurring_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recurring_payment` (
  `id` char(50) NOT NULL,
  `name` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recurring_payment`
--

LOCK TABLES `recurring_payment` WRITE;
/*!40000 ALTER TABLE `recurring_payment` DISABLE KEYS */;
INSERT INTO `recurring_payment` VALUES ('18859f3e-1d5a-4987-a579-e17d331b86f3','Bayar Tagihan Listrik'),('837d5303-42ee-4736-9c84-b481b362d4e9','Tagihan PDAM');
/*!40000 ALTER TABLE `recurring_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requirement`
--

DROP TABLE IF EXISTS `requirement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requirement` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `required_date` date DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `reason` varchar(250) DEFAULT NULL,
  `requirement_type` char(15) DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `fk_staff` char(50) DEFAULT NULL,
  `status` char(15) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requirement`
--

LOCK TABLES `requirement` WRITE;
/*!40000 ALTER TABLE `requirement` DISABLE KEYS */;
INSERT INTO `requirement` VALUES ('44beff53-496d-49dd-acc3-ab8b4a4b6559','2016-07-16','2016-07-16',1,'3SD (A)','Course programm for 3SD (A)','Work','41f53d44-746a-4e63-9b53-052fc9991809',NULL,'Inprogress',0);
/*!40000 ALTER TABLE `requirement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requirement_role`
--

DROP TABLE IF EXISTS `requirement_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requirement_role` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `type` char(15) DEFAULT NULL,
  `fk_requirement` char(50) DEFAULT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requirement_role`
--

LOCK TABLES `requirement_role` WRITE;
/*!40000 ALTER TABLE `requirement_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `requirement_role` ENABLE KEYS */;
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
  `year` int(11) DEFAULT NULL,
  `month` int(11) DEFAULT NULL,
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
INSERT INTO `sequence_number` VALUES ('094cfd08-c1b9-420c-a4ef-d927d38fad1f','2016-07-20',NULL,'41f53d44-746a-4e63-9b53-052fc9991809','PHS',4,0,0,2),('1e972777-e3cf-4063-9851-2f7beb380e60','2016-07-08',NULL,'41f53d44-746a-4e63-9b53-052fc9991809','SDN',2,2016,6,1),('22ebe1cc-a462-4c07-9f63-bf34aa6f0a0e','2016-07-21',NULL,'41f53d44-746a-4e63-9b53-052fc9991809','CRS',2,0,0,0),('2eb76916-c619-4346-860d-7f7337962ba3','2016-07-28',NULL,'41f53d44-746a-4e63-9b53-052fc9991809','INV',2,0,0,0),('331ae8c4-8f30-4f46-9c3c-56a323f4ec67','2016-07-21',NULL,'41f53d44-746a-4e63-9b53-052fc9991809','INV',2,0,0,0),('4914e5f7-e83b-4773-9771-ff78c6ea9dec','2016-07-11',NULL,'f430829b-4c5b-4dcf-8191-803e666a49e7','INV',5,0,0,3),('53a0af92-0dec-445c-9545-2fe2dbca48a7','2016-07-10',NULL,'f430829b-4c5b-4dcf-8191-803e666a49e7','INV',24,0,0,22),('66ad4f23-1754-464c-9636-27a43e3824cf','2016-07-08',NULL,'f430829b-4c5b-4dcf-8191-803e666a49e7','SDN',3,2016,6,2),('86fc4c34-2cfc-4f8a-a944-3befa361baad','2016-07-20',NULL,'41f53d44-746a-4e63-9b53-052fc9991809','INV',4,0,0,2),('8e119896-55eb-4a97-a506-2e1eb84ba957','2016-07-20',NULL,'41f53d44-746a-4e63-9b53-052fc9991809','BLMED',4,0,0,2),('b1c97fc3-2062-4630-a6b7-f680438e6329','2016-07-18',NULL,'41f53d44-746a-4e63-9b53-052fc9991809','INV',2,0,0,0),('b6fdb16f-6698-4846-9c34-99ed24aba1f1','2016-07-10',NULL,'f430829b-4c5b-4dcf-8191-803e666a49e7','CRS',9,0,0,7),('b76f476f-11b9-4b93-9a39-40b498f91a5a','2016-07-12',NULL,'41f53d44-746a-4e63-9b53-052fc9991809','CRS',2,0,0,0),('b915fdcc-f495-4db8-9679-725994256a2b','2016-07-12',NULL,'41f53d44-746a-4e63-9b53-052fc9991809','INV',2,0,0,0),('bec6e892-fa44-490c-ae21-4164611de119','2016-07-12',NULL,'f430829b-4c5b-4dcf-8191-803e666a49e7','INV',2,0,0,0),('f692f2d0-1e4c-413a-a451-747b25a2b211','2016-07-12',NULL,'f430829b-4c5b-4dcf-8191-803e666a49e7','CRS',2,0,0,0),('f873a331-a077-47a1-a05a-30f33f82c82f','2016-07-20',NULL,'41f53d44-746a-4e63-9b53-052fc9991809','CRS',2,0,0,0);
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
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` char(50) NOT NULL,
  `parent_name` varchar(150) DEFAULT NULL,
  `school_name` varchar(150) DEFAULT NULL,
  `source` char(15) DEFAULT 'Friend',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('0a3bc391-08d7-4658-bae3-cfeb08592c4e','Mike sanders senior','Mike street high','Friend'),('42459447-4a9f-44aa-b1ed-d2ee0bd9570b','Jaja Senior','Jaja school of dangdut','Friend'),('9a81283f-78a2-461d-86d2-599d7edd68d1','Lara Croft Sr.','School of michigan','Friend'),('a89588dd-464e-4f22-9f75-86b9631b4478','udin Sr.','Udin modeling school','Friend'),('b0ad6fa6-73ba-46ff-8d97-3b06bb054942','asfasf','asfasf','Friend');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_relationship`
--

DROP TABLE IF EXISTS `student_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_relationship` (
  `id` char(50) NOT NULL,
  `fk_student` char(50) DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_relationship`
--

LOCK TABLES `student_relationship` WRITE;
/*!40000 ALTER TABLE `student_relationship` DISABLE KEYS */;
INSERT INTO `student_relationship` VALUES ('17e6ccdf-5862-48e7-bc7f-bfe8f5e0d10e','b0ad6fa6-73ba-46ff-8d97-3b06bb054942','e8e7834b-b599-453c-a737-14fb05d0a908'),('22b90d7c-9388-4310-8ae1-42fcc20810e5','42459447-4a9f-44aa-b1ed-d2ee0bd9570b','af5eb485-ee5f-44ab-a908-fa8947702fba'),('959099df-b96b-4eb2-945f-7fec7782ca22','a89588dd-464e-4f22-9f75-86b9631b4478','e8e7834b-b599-453c-a737-14fb05d0a908'),('9dec4469-51ed-46be-8f91-cac0e47dacb9','9a81283f-78a2-461d-86d2-599d7edd68d1','af5eb485-ee5f-44ab-a908-fa8947702fba'),('f30e2333-99b4-4161-9b12-c70a4d70d43b','0a3bc391-08d7-4658-bae3-cfeb08592c4e','e8e7834b-b599-453c-a737-14fb05d0a908');
/*!40000 ALTER TABLE `student_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `study_day`
--

DROP TABLE IF EXISTS `study_day`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `study_day` (
  `id` char(50) NOT NULL,
  `is_sunday` char(1) DEFAULT '0',
  `is_monday` char(1) DEFAULT '0',
  `is_tuesday` char(1) DEFAULT '0',
  `is_wednesday` char(1) DEFAULT '0',
  `is_thrusday` char(1) DEFAULT '0',
  `is_friday` char(1) DEFAULT '0',
  `is_saturday` char(1) DEFAULT '0',
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `study_day`
--

LOCK TABLES `study_day` WRITE;
/*!40000 ALTER TABLE `study_day` DISABLE KEYS */;
INSERT INTO `study_day` VALUES ('9623866f-7554-451d-a602-aa3125137712','0','0','1','0','1','0','1',0),('99da7994-79ba-46e8-9617-fade59806df1','0','1','0','1','0','1','0',0);
/*!40000 ALTER TABLE `study_day` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `study_period`
--

DROP TABLE IF EXISTS `study_period`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `study_period` (
  `id` char(50) NOT NULL,
  `name` varchar(150) NOT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `study_period`
--

LOCK TABLES `study_period` WRITE;
/*!40000 ALTER TABLE `study_period` DISABLE KEYS */;
INSERT INTO `study_period` VALUES ('01835518-da9b-4069-9574-32a8048ff609','2016-2017','Tahun Ajaran 2016-2017',1);
/*!40000 ALTER TABLE `study_period` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `study_room`
--

DROP TABLE IF EXISTS `study_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `study_room` (
  `id` char(50) NOT NULL,
  `name` varchar(150) DEFAULT NULL,
  `fk_room` char(50) DEFAULT NULL,
  `fk_period` char(50) DEFAULT NULL,
  `fk_day` char(50) DEFAULT NULL,
  `fk_time` char(50) DEFAULT NULL,
  `fk_course` char(50) DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `fk_feature` char(50) DEFAULT NULL,
  `fk_staff` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `study_room`
--

LOCK TABLES `study_room` WRITE;
/*!40000 ALTER TABLE `study_room` DISABLE KEYS */;
INSERT INTO `study_room` VALUES ('44beff53-496d-49dd-acc3-ab8b4a4b6559',NULL,'92865bd0-c7d6-4504-b40e-1f706c4b579a','01835518-da9b-4069-9574-32a8048ff609','9623866f-7554-451d-a602-aa3125137712','42029710-abc5-45e4-ac75-7c7fd1d0dcd0','7a7d5edb-d6ff-4b91-93db-d7a7e5a0caef',NULL,'d3274933-6664-48bf-ad05-c6e6dd5e60eb',NULL,0);
/*!40000 ALTER TABLE `study_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `study_time`
--

DROP TABLE IF EXISTS `study_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `study_time` (
  `id` char(50) NOT NULL,
  `start` time DEFAULT NULL,
  `end` time DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `study_time`
--

LOCK TABLES `study_time` WRITE;
/*!40000 ALTER TABLE `study_time` DISABLE KEYS */;
INSERT INTO `study_time` VALUES ('42029710-abc5-45e4-ac75-7c7fd1d0dcd0','17:00:00','19:10:00',0),('a64a26a4-5ac8-4871-ac62-b0089605bbfc','15:00:00','17:00:00',0),('bfe87e87-caa9-4c72-9b1d-d829102e6560','19:10:00','21:10:00',0);
/*!40000 ALTER TABLE `study_time` ENABLE KEYS */;
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
  `is_default` char(1) DEFAULT '0',
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
INSERT INTO `tax` VALUES ('b685e80a-5257-49c7-9c7d-11b986a49b29','PPN','PPN',NULL,10,'0',0),('d4921463-e9ff-4c8e-b6ff-9a1730688fbb','R-PPN','R-PPN',NULL,0,'1',1);
/*!40000 ALTER TABLE `tax` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time_entry`
--

DROP TABLE IF EXISTS `time_entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `time_entry` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `start` time DEFAULT NULL,
  `end` time DEFAULT NULL,
  `hour` int(11) DEFAULT NULL,
  `comment` varchar(250) DEFAULT NULL,
  `fk_timesheet` char(50) DEFAULT NULL,
  `fk_work_effort` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time_entry`
--

LOCK TABLES `time_entry` WRITE;
/*!40000 ALTER TABLE `time_entry` DISABLE KEYS */;
INSERT INTO `time_entry` VALUES ('431f8ab3-1f3c-49c7-9b94-474bc323d1c6','2016-07-16','17:00:00','18:00:00',1,'Attendance time entry',NULL,'f7b1772e-9907-456b-a45b-022bc9a61476',0),('45eef090-7204-4af7-95cd-b9f48271af65','2016-07-16','17:00:00','18:00:00',1,'Attendance time entry','a46d6792-cc46-4bbb-9acc-e5e1220ea98e','f7b1772e-9907-456b-a45b-022bc9a61476',0),('7273e5ff-38b8-4dd0-851c-0eeefaeb5d0d','2016-07-16','17:00:00','18:00:00',1,'Attendance time entry',NULL,'f7b1772e-9907-456b-a45b-022bc9a61476',0);
/*!40000 ALTER TABLE `time_entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timesheet`
--

DROP TABLE IF EXISTS `timesheet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timesheet` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `fk_employee` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timesheet`
--

LOCK TABLES `timesheet` WRITE;
/*!40000 ALTER TABLE `timesheet` DISABLE KEYS */;
INSERT INTO `timesheet` VALUES ('a46d6792-cc46-4bbb-9acc-e5e1220ea98e','2016-07-01','2016-07-31','ab2442f4-e1e2-48ad-b346-10dc7d6a3214',0);
/*!40000 ALTER TABLE `timesheet` ENABLE KEYS */;
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
INSERT INTO `unit_of_measure` VALUES ('e1db32dc-f5f5-4b85-8d57-1f278355ba6b','Year','Year','',0);
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
INSERT INTO `user` VALUES ('134e7bd0-34c2-4fa4-a112-cb80ed57d749','Dwita','MeIghCTLlO0UD/3Ppghey5nA0GnUSaKap9jI/LVVfynO5ynSE94BnjB+AEl2vQLI','1','f19cb3fb-bd40-4b32-addb-37ebdd7feff1','0',0),('19762b4c-4091-46ef-9907-4abf963bfcf2','Ani','oRnkPvLv5t09waeLeJc/Jb83PeKrEjbcEpwUv/WjEa2+mfVgeCu63l7HVPqW219p','1','dc9599fe-211e-4727-85b0-10c33782130a','0',0),('1a998880-0aa2-4997-9919-374fd44b2f3f','Yuli','ZNMHN9Ls5fP1rQ6qsKlamSv5IwC4VnrwMOYlDWdo3cCM+p8WR2sg+wTt7Wp2mOcF','1','3dd23d3d-23c9-4738-8eda-1343069a7846','0',0),('331fef79-8ce3-470c-ab10-8e8822771172','Eka','sGHxyMlxsT4eUhqKYxN215vebxSRlk2YxSMOFLPK8K4FhFwIofC9ThTC0PSUZbqY','1','43d7baa2-1a31-4fdc-bd38-5f6cfcadc735','0',0),('382d0cd2-4930-4dff-a812-b30219ada799','Siti Jubaidah','cMhUMbzBya6fUmJwg0z2xeiMpuxthJQf6m7cInybSfzWqqlKitKlHQA5sXdsylV1','1','40bc3867-8582-47e4-bb2f-d0f22aed8596','0',0),('598e5eb3-21a3-47f6-9b1a-c608a8c24d98','Rahayu','oyUckzVCa4aCNBjC9RB5oZbDylOqehZrani0ltZc3g1KKLkIXX0YIC5gIJ4Arczd','1','f44e48d5-1b7d-4c6a-a9e3-1e8b6616662f','0',0),('8ec6c4bc-a40e-4aa6-bbbb-fa37ddb84afa','Purnama','MP+TQU6ElM6wO4UprlYNV9wqggG1jwedW+D4mDlZnwL7rkPNkw28e51PSZmnNdSF','1','bf73aa96-1505-43c0-ab89-7416b8cb77d0','0',0),('97dc9715-47eb-45d5-96ba-0a582fabdf3b','admin@belian.com','jIfSsj+ceSsamqTfmru/ZlLSRsjwUijQK4CJqi86fLNWb/nqSv2eY2rRrJxgpdDM','1',NULL,'0',0),('9830376f-bc22-407d-adc9-8a1ba965e588','Ayu','meySmhzfMj6ZogKHUMAFc8wvO8tW412n1pFgHvQP0vdN+K88k22kjlSdgB+mY/Oq','1','d3213e11-fdf2-44f0-901a-b3224f286409','0',0),('a08fe6a8-245b-438c-98e6-c49dc10bfc27','Desi','4KpN9DbzfOKIRrF+rKqr5QRSNdk9UspYBhmQG0fi/BY3vIPNaepA1xD/cbJq3j7V','1','4bb97bc8-690c-4794-818f-361ae310bb66','0',0),('d19c1a99-e7d4-4975-a886-0f0175365633','Dwi','j6HalMZVsy3Kshaou6pPDwI5qC34zReRTwi8e+9sCK9Ao0pjIzL4Mk07HnG9yTMP','1','f622dfbc-acc3-4fdf-ae7a-831fed2bfee6','0',0),('d5b99fa3-bd64-4e2a-94cc-4ba58fe15bdb','Dila','o29mLu17mpSh4KAAvC/QEmxutvvaZUNIPLcjHT0H9MRzVc4mlqT4KvfF6CC9cCNp','1','3f2239be-6aab-4457-a8f5-e613d874fd56','0',0),('fd46127d-40fa-45c2-9db9-5bab67ec1369','Rohmat','gi14VNwAgfRmlWwTccdrxDC5y9zYLbmzRma1p5InB+q3TPy6WyXoMAMtZ5aV6us9','1','a7f5f26e-56c4-4155-aa30-6d2a26090e80','0',0),('ff832e4c-b53c-4273-a793-48d9eb755e1d','Taufik','XKq+IwpRonF5SoTng0GCVNPnIEuojqcfnKz7rrwsdr/Fc+sKqOLv+DraP608UcK2','1','710bb3f6-2d63-40aa-ba3b-924e364e08c8','0',0);
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
INSERT INTO `user_role` VALUES ('1863f974-6b69-4086-9d87-bb6ac881fcb7','096b0105-de76-492c-9bb0-5e518b46d69c','382d0cd2-4930-4dff-a812-b30219ada799','0',0),('1d0721b0-5e98-41c9-82bd-4873d6d3a71c','096b0105-de76-492c-9bb0-5e518b46d69c','134e7bd0-34c2-4fa4-a112-cb80ed57d749','0',0),('51a2916a-1c98-4bb1-9600-5f05a110b2a0','096b0105-de76-492c-9bb0-5e518b46d69c','598e5eb3-21a3-47f6-9b1a-c608a8c24d98','0',0),('52c63a93-76fd-4550-bcc4-87686b47155f','096b0105-de76-492c-9bb0-5e518b46d69c','9830376f-bc22-407d-adc9-8a1ba965e588','0',0),('715e90dd-9533-4150-b071-d55b86a434ac','096b0105-de76-492c-9bb0-5e518b46d69c','8ec6c4bc-a40e-4aa6-bbbb-fa37ddb84afa','0',0),('815b319c-3629-4424-923e-beaefd44cada','096b0105-de76-492c-9bb0-5e518b46d69c','d19c1a99-e7d4-4975-a886-0f0175365633','0',0),('849138a5-4b4e-41ea-8f24-e4586e7f8ab9','096b0105-de76-492c-9bb0-5e518b46d69c','97dc9715-47eb-45d5-96ba-0a582fabdf3b','1',0),('90f8c667-fc87-4c57-80bc-9ea432b2ecac','096b0105-de76-492c-9bb0-5e518b46d69c','19762b4c-4091-46ef-9907-4abf963bfcf2','1',1),('96e4823e-6fe3-4e63-9e15-553b1b09bf92','096b0105-de76-492c-9bb0-5e518b46d69c','ff832e4c-b53c-4273-a793-48d9eb755e1d','0',0),('b9951d90-1dd6-490f-92c9-f9fa5df3f704','096b0105-de76-492c-9bb0-5e518b46d69c','a08fe6a8-245b-438c-98e6-c49dc10bfc27','0',0),('bc22a60a-e7fe-4811-9a67-82fb79e8e0cf','096b0105-de76-492c-9bb0-5e518b46d69c','331fef79-8ce3-470c-ab10-8e8822771172','0',0),('e2b894f7-b683-4acb-b0a5-119077d4b8bf','096b0105-de76-492c-9bb0-5e518b46d69c','1a998880-0aa2-4997-9919-374fd44b2f3f','0',0),('e75b0eaf-9206-4128-b0ee-1cef9ba1d8da','096b0105-de76-492c-9bb0-5e518b46d69c','fd46127d-40fa-45c2-9db9-5bab67ec1369','0',0),('f2962c2d-92a8-41e7-a040-7405d9efadce','096b0105-de76-492c-9bb0-5e518b46d69c','d5b99fa3-bd64-4e2a-94cc-4ba58fe15bdb','0',0);
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
INSERT INTO `user_setting` VALUES ('3dd23d3d-23c9-4738-8eda-1343069a7846','41f53d44-746a-4e63-9b53-052fc9991809','SONY SUGEMA COLLEGE',NULL,NULL,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','R-PPN','in_ID',25,'POS',0),('3f2239be-6aab-4457-a8f5-e613d874fd56','41f53d44-746a-4e63-9b53-052fc9991809','SONY SUGEMA COLLEGE',NULL,NULL,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','R-PPN','in_ID',25,'POS',0),('40bc3867-8582-47e4-bb2f-d0f22aed8596','41f53d44-746a-4e63-9b53-052fc9991809','SONY SUGEMA COLLEGE',NULL,NULL,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','R-PPN','in_ID',25,'POS',0),('43d7baa2-1a31-4fdc-bd38-5f6cfcadc735','41f53d44-746a-4e63-9b53-052fc9991809','SONY SUGEMA COLLEGE',NULL,NULL,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','R-PPN','in_ID',25,'POS',0),('4bb97bc8-690c-4794-818f-361ae310bb66','41f53d44-746a-4e63-9b53-052fc9991809','SONY SUGEMA COLLEGE',NULL,NULL,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','R-PPN','in_ID',25,'POS',0),('710bb3f6-2d63-40aa-ba3b-924e364e08c8','41f53d44-746a-4e63-9b53-052fc9991809','SONY SUGEMA COLLEGE',NULL,NULL,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','R-PPN','in_ID',25,'POS',0),('a7f5f26e-56c4-4155-aa30-6d2a26090e80','41f53d44-746a-4e63-9b53-052fc9991809','SONY SUGEMA COLLEGE',NULL,NULL,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','R-PPN','in_ID',25,'POS',0),('bf73aa96-1505-43c0-ab89-7416b8cb77d0','41f53d44-746a-4e63-9b53-052fc9991809','SONY SUGEMA COLLEGE',NULL,NULL,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','R-PPN','in_ID',25,'POS',0),('d3213e11-fdf2-44f0-901a-b3224f286409','41f53d44-746a-4e63-9b53-052fc9991809','SONY SUGEMA COLLEGE',NULL,NULL,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','R-PPN','in_ID',25,'POS',0),('dc9599fe-211e-4727-85b0-10c33782130a','41f53d44-746a-4e63-9b53-052fc9991809','SONY SUGEMA COLLEGE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','Pontianak','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','R-PPN','in_ID',25,'POS',1),('f19cb3fb-bd40-4b32-addb-37ebdd7feff1','41f53d44-746a-4e63-9b53-052fc9991809','SONY SUGEMA COLLEGE',NULL,NULL,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','R-PPN','in_ID',25,'POS',0),('f44e48d5-1b7d-4c6a-a9e3-1e8b6616662f','41f53d44-746a-4e63-9b53-052fc9991809','SONY SUGEMA COLLEGE',NULL,NULL,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','R-PPN','in_ID',25,'POS',0),('f622dfbc-acc3-4fdf-ae7a-831fed2bfee6','41f53d44-746a-4e63-9b53-052fc9991809','SONY SUGEMA COLLEGE',NULL,NULL,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','R-PPN','in_ID',25,'POS',0);
/*!40000 ALTER TABLE `user_setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_effort`
--

DROP TABLE IF EXISTS `work_effort`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_effort` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `work_effort_type` char(15) DEFAULT NULL,
  `work_effort_purpose` char(15) DEFAULT NULL,
  `fk_requirement` char(50) DEFAULT NULL,
  `fk_person` char(50) DEFAULT NULL,
  `start` time DEFAULT NULL,
  `end` time DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_effort`
--

LOCK TABLES `work_effort` WRITE;
/*!40000 ALTER TABLE `work_effort` DISABLE KEYS */;
INSERT INTO `work_effort` VALUES ('f7b1772e-9907-456b-a45b-022bc9a61476','2016-07-16','Task','Production',NULL,'99b9d50a-69cc-4496-a00d-4533ef3c1fca','17:00:00','18:00:00',0);
/*!40000 ALTER TABLE `work_effort` ENABLE KEYS */;
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

-- Dump completed on 2016-07-21 16:16:17
