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
INSERT INTO `access_role` VALUES ('01f5388b-c63e-4d09-b3b5-dd6456dd0815','c79e78d0-3427-440c-b8fe-df126e667a8b','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('0442dff1-c1dd-45e7-8634-2b9d90904469','7bef1d92-0f15-43ef-b59b-5bc3e769d896','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('060d3480-7c9a-44c7-b572-d7b2c4067359','916b22eb-48fa-4000-b7a2-7fc1d47ced4e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('0a1a6c1d-e681-48c4-b400-be611a9f70b7','8a05b279-2f80-47b8-a2a7-63fbe96d327e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('0e9073d1-2be3-4a8a-9a82-5bd1166757e2','847a8df6-bc04-4de6-8d7d-28e41c00f422','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('195dd074-a5e5-4abe-bc9f-5e913229bbb6','2d7e5641-511d-43fd-a6d6-a482120f8aa5','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('1aa3a48c-ab0c-4949-945e-e9852a9b9a93','95dd39dd-512e-414e-b95c-0fc251887f98','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('22fbdfec-6afe-4f2f-bd69-ac6a9974ae82','5c37296e-ab30-4d07-bba3-342d4c403f48','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('2c661c0d-53b6-44c7-85bd-ba04da473be3','c0f3237c-23c2-49ab-bc9c-e00aa706d7e2','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('2d52482a-0a7a-4e49-83c6-9db73e4e051b','80aebe74-399c-4273-9145-956a077d3f5d','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('3202f4e4-fd87-41a8-ae71-fbefce6a2ef4','b54c8e49-c820-4292-9f74-9e47bd55711f','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('32915e9c-96bf-44b3-881a-2f7c917a4c92','d33784ca-abd5-422b-b45a-8c8ee13ddc0a','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('32cc538f-0445-4ec4-9d2e-3084e89062d1','7f17176c-f27a-432c-a106-0d7d87b0afb7','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('331300a2-cc8e-4417-abb3-45dadf814422','fca1cfcf-d199-4729-a321-e1ed01deb0f1','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('37484efd-9cb6-4f79-903f-e7d6687658cc','6861d3b3-8110-46ed-8a3a-830963597fa7','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('3a225b38-8dbd-482a-9c14-2f7f1c535068','88bf4008-c84a-4089-88c6-e9d8f077a196','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('40e72f84-d3dc-4ce4-94de-c6c9716a5549','475038c2-e2fc-406a-ac8f-c6711c6480af','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('48c06de3-442f-4125-a438-e370fabade36','f50dd16d-0e25-44b6-bd69-c28dfcc55300','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('48c4056e-33f6-4082-af20-0139f3e66371','8217c196-16b9-44fb-9662-8323220ee705','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('490e4434-7ea2-475e-a66c-ea7296b82c54','29ec80f0-0d4c-451c-ae5e-f195c4be1a27','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('4b15a790-2920-47f2-b805-33ecd48b9bac','2c0d9a06-cebd-4da2-b520-2e948aae3e53','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('4fffeab2-b09c-47fb-92b4-3981da252637','9e644628-121d-4954-8a66-8002cc866bda','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('541dd297-fd64-44ae-bcf4-fed612227962','4b3bb551-173e-46f5-b1e9-bdd719e3045e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('59d88282-5a3f-481b-9bb8-91679fbf4d91','f53b80db-1b89-4779-86e7-b065b5287bbb','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('5a2ce59a-60c2-4203-9d3b-7c5d038fe635','e916392a-0b3c-4543-ada7-93054383bb3b','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('5c2ddb84-b28c-40f6-81d5-351e0ea1037d','627fb961-6cf0-4148-9451-0d1422095eb7','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('5c9ab463-dc50-47a5-a601-f074734adf3c','abfd9a02-3b4b-47a0-9048-a65b6be0b3aa','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('5f5930ba-8251-470e-a650-e240cfa1bde0','8971337a-2aea-41d3-930a-4e6f2fa3acc0','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('6179118a-ff80-452a-a89d-8e0154725095','b662de02-f4a3-4f1a-819b-5d2aaf6a342b','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('6416ea67-8c7b-477e-811f-c5e4e45ca9c0','99623cbd-066f-4cc2-b9b3-1961bed131cc','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('6655f91e-4928-4c6f-b83a-f43b28f04454','770c420c-f809-43f7-969c-b493f0b4ef48','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('6adcd07b-62da-4e75-a076-80520a58eb32','5cdd1545-8fdb-4a79-b2a3-0662ed6fec30','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('6ed261e4-7608-49cd-9953-a04e3ff8dfed','affcf2e7-fd2c-4b39-beee-97b5dc5a1405','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('711417b0-a5ea-4c2e-8ab3-e5a96576b45b','8f6ec9c8-e9ed-49e1-ab7a-c4a868b8391e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('71479847-69f5-43fa-b7ce-00af42c28d4a','339d7200-9aa1-43d5-8683-e7118cb52839','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('724b174d-96ec-4152-a42c-2d03097b9aa9','342b0b64-291f-4d12-bdb8-77186895d21d','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('79450f94-0cbf-4c0d-ad76-3362a4abe180','4eca5501-a650-41d5-87c1-c091391d3608','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('8675d849-03b8-4553-ac34-5b58df769501','88bdca27-a7cf-4a1e-9fdc-4d0f48a0ca19','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('89c3b455-3c46-4bc4-9a13-77c171e129b6','a4c43802-436f-407c-8793-323600c181d7','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('8c6f9ab1-f804-45c2-8504-9d9cc9d3199c','532efe0a-05ff-4f94-877d-a7f3f7509569','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('923b7b67-a1e4-478a-9769-e2ee32b685b1','ee3c3540-9c62-46df-a79e-f7b636a9ba1d','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('94863d4d-7d07-41d2-bc78-4f65260776d6','13989b38-ac2c-47b8-8708-5e27477af18d','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('96318b3e-baf7-479b-ab07-d0798114d3bd','e54e6ba5-7ffd-457b-a23e-8b6285867ba4','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('9659ee34-7845-4078-89bd-9ee9b9e37b78','855aab16-cb45-41c3-b62c-55185ff77dfc','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('9728b76b-eac0-44c4-9ba9-afca669e0a76','e8f89299-2138-4167-b5b7-52f6ae1667ca','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('9f52d7a0-217e-4084-9bb3-78c5c81dd536','07452775-a048-4071-8798-21dc943fe926','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('9fa511a1-e704-4018-a90a-57acea0ac5da','1adc4b8b-ad93-4658-8476-6bb13e2e810d','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('a055f787-df6a-4c93-af22-12797bf5ec39','69443009-4a15-4061-b9f0-08c08c8f50aa','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('a3e8ba06-d955-4929-bd36-f658f3796b6c','a4aa9ae0-5166-4d06-afd1-d2eea6f2417c','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('a3ef8fbd-46f9-43db-ab47-31d062c3fb20','74ad4867-9495-472f-97fc-36bf87895585','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('a62bb18e-1809-4476-9997-84521044e27d','4b0f494a-5d29-4412-b2c1-eaaab78f53f2','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('a7951344-6b9e-438f-af5c-7b94dee26b2d','83b19678-9f2f-49f4-ba25-0f31a8dee078','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('a8a90cc0-470f-456c-879b-77c0ed469dd7','9df71b1a-0e52-4445-98ea-b9a59ad81ac9','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('a91848d3-83d1-485a-9846-c83ff3699ac2','322d37f6-a667-481e-bc22-db212d0154ea','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('abecab92-51cb-4ca9-88a0-9446c1bc5ae3','4eb93eb7-2100-49ae-bd96-a39995ed5670','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('ac144c04-22c4-47fb-8fd4-3783a4f29a90','1cf392fc-4f93-4e38-9709-2beb84434951','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('ad389302-f250-4270-a937-75cf984c2f80','2bdc3f95-c5bd-47d9-adce-9e9df1042e2f','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('b31dbbf6-6b74-4aa9-9db4-6ebd3888ef91','355ca995-6bae-4638-bfd4-a9bfeff5eefb','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('b4f04a2c-d9a4-4b30-b75b-4572685e35a8','9178e8cd-4063-4fe9-a060-d2e3ac818ed1','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('ba3f64f6-9e81-43c6-a20e-7de6a6cf4d79','5eb48ec2-5634-4ee9-b5f7-43b2df6c8c83','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('bf839209-25d9-4ea7-8e4a-d771f7599e2e','6cbaf072-6925-46e9-b417-17326f3d8584','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('c2d02e3b-7b8a-47b4-bb08-30f37f9505fc','9b9deb26-0960-478c-8cac-4ac475c3ffc3','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('c655e02a-f2a3-4132-8bd7-9428cc1ce3af','0b503053-31eb-410d-90a6-ec6a9977bc1e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('c836928e-da88-414e-b572-db436cc948a4','4939e42f-06b5-4e44-b3ba-4106964f1f68','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('c9681985-0b2a-4537-822b-8f477bc15104','65414caf-3a73-4e3f-9a58-2d70c723b5bc','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('ce77f072-7ad1-4cb5-9e9e-0d9b89a853bd','314a3f13-a982-4915-a5cb-455eacbc27ae','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('cf2437ad-5e59-4f7a-8190-f537beabc623','58621810-2c8f-44ae-b9aa-b1e05ad32743','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('cff3c8ef-bd79-4d32-be37-b4a2e7dab027','90195ecb-4674-4614-a429-eebc24ffe773','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('d11fbe57-0eac-4f6f-bc22-14a0ed221733','fab64cd8-7762-412b-90fb-3d31d5576b45','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('d8a71d8e-344a-4c18-88ff-9ca2cffed715','b9935030-f5c1-479e-9ec1-795afc1c1e7e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('de2ab421-31cd-45b7-b6d7-5baf50797f2c','6e299ade-e10e-4940-ae83-bdf61505ed63','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('e1ae7cc5-aab3-4271-a744-9d17fca44e9c','9b9e014c-7a23-40c1-8841-30044564bf7f','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('e1ae7cc5-aab3-4271-a744-9d17fca44e9x','9b9e014c-7a23-40c1-8841-30044564bf7x','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('e51c5ad1-38c7-4699-9c92-50f070f7a7f3','4bf39427-b32a-434c-bd71-4d9493ea6eef','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('e6f44dd7-9616-4c85-aaa9-e5322ea39319','b44420c6-261b-44c5-a23a-7802a0506dab','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('e9b3d5e4-1259-48bc-b521-7abb7d72bc30','e4307d82-f3fa-4916-9e6b-7a4f894d847e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('ed0df929-8852-42ca-9006-e0ad6fd37a90','55b7e0fb-a178-478b-a09e-4b753f161aeb','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('ee5e29eb-cf8a-4c54-a709-da55952b8f80','5eda5016-f448-42dd-926b-52b10870e29c','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('f0c0441f-80df-4405-8927-c114d9c61edb','e4d249e1-4bd5-4291-9050-62a99f70f64c','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('f0f949d7-f756-4fdc-bacd-b6e145b9829d','5e8c4a66-e46a-4000-ae1c-bf536686b30f','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('f21a4567-0723-4569-abd7-8e59e3645767','0c586cf4-9bd2-4b93-b24b-d41ceca2aef4','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('f6e69991-8825-41e8-a6e7-24a4c6257c4d','dbc9175e-eb27-45e9-9e43-a1c12d6354e4','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('f7284b39-b584-4334-94f0-0631d3a9b429','4500a912-bbad-4590-9abb-d9ec92a311a5','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('fe2ef334-8861-41af-887a-a95992d46b74','8c7e1020-0824-4239-9a4e-46301c80b9cd','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1);
/*!40000 ALTER TABLE `access_role` ENABLE KEYS */;
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
  `is_closed` char(1) DEFAULT '0',
  `fk_accounting_period_parent` char(50) DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
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
INSERT INTO `accounting_period` VALUES ('136dacb0-aa82-40a9-bd31-24114603d871','03 2016','Maret 2016','2016-03-01','2016-03-31','March','0','893d791b-9ee7-4757-a8f3-530b109ea617','4a129f6b-7b21-4640-bf78-4da17201894a',0),('20614a90-7c7b-4587-a564-c8e3529ae456','04 2016','April 2016','2016-04-01','2016-04-30','April','0','893d791b-9ee7-4757-a8f3-530b109ea617','4a129f6b-7b21-4640-bf78-4da17201894a',0),('3ea8b2c9-9efe-430c-8593-012f53368c33','05 2016','Mei 2016','2016-05-01','2016-05-31','December','0','893d791b-9ee7-4757-a8f3-530b109ea617','4a129f6b-7b21-4640-bf78-4da17201894a',1),('40e51285-ec41-47bb-b1e4-5ba6c859c9b8','11 2016','November 2016','2016-11-01','2016-11-30','November','0','893d791b-9ee7-4757-a8f3-530b109ea617','4a129f6b-7b21-4640-bf78-4da17201894a',0),('4ab1def0-c2cb-41df-9fb8-064a2f6e8cff','06 2016','Juni 2016','2016-06-01','2016-06-30','June','0','893d791b-9ee7-4757-a8f3-530b109ea617','4a129f6b-7b21-4640-bf78-4da17201894a',0),('815d8827-dfe3-4cc6-b620-7abec8e8a7e9','09 2016','September 2016','2016-09-01','2016-09-30','September','0','893d791b-9ee7-4757-a8f3-530b109ea617','4a129f6b-7b21-4640-bf78-4da17201894a',0),('893d791b-9ee7-4757-a8f3-530b109ea617','2016 AMC','Aim Medical Center 2016','2016-01-01','2016-12-31','December','0',NULL,'4a129f6b-7b21-4640-bf78-4da17201894a',6),('89d79892-8350-4851-8f0e-700ba962db14','08 2016','Agustus 2016','2016-08-01','2016-08-31','August','0','893d791b-9ee7-4757-a8f3-530b109ea617','4a129f6b-7b21-4640-bf78-4da17201894a',0),('8f54bb62-0490-4ef1-88f4-84274219d040','07 2016','Juli 2016','2016-07-01','2016-07-31','July','0','893d791b-9ee7-4757-a8f3-530b109ea617','4a129f6b-7b21-4640-bf78-4da17201894a',0),('a2987fa1-aff3-4489-a216-2ed746a671f1','01 2016','Januari 2016','2016-01-01','2016-01-31','December','0','893d791b-9ee7-4757-a8f3-530b109ea617','4a129f6b-7b21-4640-bf78-4da17201894a',1),('b5d10c35-fa59-44be-8ef8-fec78ce6e64d','02 2016','Februari 2016','2016-02-01','2016-02-29','February','0','893d791b-9ee7-4757-a8f3-530b109ea617','4a129f6b-7b21-4640-bf78-4da17201894a',0),('cfc055f5-b2d6-4d31-b857-e15c4ba372fc','10 2016','Oktober 2016','2016-10-01','2016-10-31','October','0','893d791b-9ee7-4757-a8f3-530b109ea617','4a129f6b-7b21-4640-bf78-4da17201894a',0),('d675140a-b488-41e4-8190-519e5f079302','12 2016','Desember 2016','2016-12-01','2016-12-31','December','0','893d791b-9ee7-4757-a8f3-530b109ea617','4a129f6b-7b21-4640-bf78-4da17201894a',0);
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
INSERT INTO `asset` VALUES ('b584cc26-695b-4b8a-bdbc-3428c96f2697','Cashier 1','Cashier 1','2016-07-31',NULL,NULL,3200000,'1','0','8503f553-da8b-4182-963a-f2c3cae048a1','','4a129f6b-7b21-4640-bf78-4da17201894a',NULL,9);
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
INSERT INTO `asset_type` VALUES ('14cad3e6-996a-4c2e-a32d-ac680e68d737','ki','nonu','1e57fa0a-90fe-4f69-82e3-6bd82801b6d6',0),('1e57fa0a-90fe-4f69-82e3-6bd82801b6d6','ELD','Electronic Device',NULL,0),('3cd3b650-5765-4fe6-bb89-d727da64ebfc','COMP','Computer','1e57fa0a-90fe-4f69-82e3-6bd82801b6d6',0),('8503f553-da8b-4182-963a-f2c3cae048a1','CMN','Cash Machine','3cd3b650-5765-4fe6-bb89-d727da64ebfc',0);
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
INSERT INTO `audit_trail` VALUES ('0d13282f-2339-4ad4-9917-baeadac38480','2016-08-05 14:15:52.093','0','Nuri','Aim Poli Umum','Cashier Shift','Open new shift for cashier on Cashier 1',0),('4c397285-ecea-47da-a448-6c04ae563c27','2016-08-04 14:34:23.566','0','Nuri','Aim Apotik','Cashier Shift','Open new shift for cashier on Cashier 1',0),('5018d04d-4ad4-43e2-903a-19cbf8977b7e','2016-08-02 10:20:41.967','0','Nuri','Aim Medical Center','Cashier Shift','Open new shift for cashier on Cashier 1',0),('57ba7699-3aa3-4f90-a473-47c069619c11','2016-08-04 09:44:44.249','0','Nuri','Aim Apotik','Cashier Shift','Closed shift session for cashier on Cashier 1',0),('686b52bd-bff8-4c2f-8d4a-c8faa59b73ce','2016-08-05 14:12:08.002','0','Nuri','Aim Poli Umum','Cashier Shift','Closed shift session for cashier on Cashier 1',0),('6c310ab6-9a68-4d9e-84ef-8a4961385d8f','2016-08-05 14:10:42.689','0','Nuri','Aim Poli Umum','Cashier Shift','Open new shift for cashier on Cashier 1',0),('735832df-25e9-45f7-a6ff-fab3d8bace20','2016-08-05 14:16:03.088','0','Nuri','Aim Poli Umum','Cashier Shift','Closed shift session for cashier on Cashier 1',0),('7ac97428-9a42-4615-8925-5a439b99c413','2016-07-31 11:00:28.857','0','Nuri','Aim Medical Center','Cashier Shift','Open new shift for cashier on Cashier 1',0),('7f29b5b6-f3b7-4a69-bc42-ba9f9255049a','2016-08-03 08:50:56.97','0','Nuri','Aim Medical Center','Cashier Shift','Open new shift for cashier on Cashier 2',0),('b9174241-5c55-45bb-8378-479231ec11a5','2016-08-04 09:44:44.178','0','Nuri','Aim Apotik','Cashier Shift','Closed shift session for cashier on Cashier 2',0),('fdaa20b9-ca46-4f69-8280-8a40ad035ba0','2016-08-05 14:10:08.148','0','Nuri','Aim Poli Umum','Cashier Shift','Closed shift session for cashier on Cashier 1',0);
/*!40000 ALTER TABLE `audit_trail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auto_journal_sales`
--

DROP TABLE IF EXISTS `auto_journal_sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auto_journal_sales` (
  `id` char(50) NOT NULL,
  `fk_cash_account` char(50) DEFAULT NULL,
  `fk_service_sales_account` char(50) DEFAULT NULL,
  `fk_goods_sales_account` char(50) DEFAULT NULL,
  `fk_tax_sales_account` char(50) DEFAULT NULL,
  `fk_receivable_account` char(50) DEFAULT NULL,
  `fk_tuslah_payable_account` char(50) DEFAULT NULL,
  `fk_branch_cash_account` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auto_journal_sales`
--

LOCK TABLES `auto_journal_sales` WRITE;
/*!40000 ALTER TABLE `auto_journal_sales` DISABLE KEYS */;
INSERT INTO `auto_journal_sales` VALUES ('d2a96e2b-ae8b-4613-b1f4-c8c09dde9d75','3fe8dcfd-cc53-45ad-8eb1-5a25d571d442','a22b754e-720e-4788-9d30-f50bbf6b58a5','633de64e-12eb-4e4b-be74-135a4d088b9b','a361d66b-dc41-4b49-901f-bb9f33402e6b','9be13c2c-348c-4c2d-a37d-65e56b29cf05','f9efeedb-f677-4980-8bdf-b5dfa662d37d','2979a595-03eb-4156-b317-a9ea5fe5f57e',0);
/*!40000 ALTER TABLE `auto_journal_sales` ENABLE KEYS */;
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
  `rounding` decimal(10,0) DEFAULT '0',
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
INSERT INTO `billable` VALUES ('bcdfe93b-b7fc-43a1-b6e9-d90877fc4468','2016-08-15','BLG1471228183863','0','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','4a129f6b-7b21-4640-bf78-4da17201894a','b7337ad2-a0a9-47e3-a165-e02d0998a271','b01d8d84-9815-403c-9c44-12a385e997c4','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,NULL,0);
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
-- Table structure for table `carier_relationship`
--

DROP TABLE IF EXISTS `carier_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carier_relationship` (
  `id` char(50) NOT NULL,
  `fk_carrier` char(50) DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carier_relationship`
--

LOCK TABLES `carier_relationship` WRITE;
/*!40000 ALTER TABLE `carier_relationship` DISABLE KEYS */;
/*!40000 ALTER TABLE `carier_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrier`
--

DROP TABLE IF EXISTS `carrier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carrier` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrier`
--

LOCK TABLES `carrier` WRITE;
/*!40000 ALTER TABLE `carrier` DISABLE KEYS */;
/*!40000 ALTER TABLE `carrier` ENABLE KEYS */;
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
INSERT INTO `cash_sales` VALUES ('bcdfe93b-b7fc-43a1-b6e9-d90877fc4468',1,'c4c10aee-a3a1-4e6c-a08b-62d4e26414df','','SHORTTERM');
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
INSERT INTO `cash_sales_line` VALUES ('324cd845-2ecc-4f25-8835-ac82811f7d7c',810,0,0,10,'','8d41c267-ff40-466b-89b3-fff445a46b55','c267f236-325c-41f6-8a46-56763ecd4b12','bcdfe93b-b7fc-43a1-b6e9-d90877fc4468',0),('56b25ded-672a-4798-a2e3-d32096ae280b',162,0,0,5,'','8d41c267-ff40-466b-89b3-fff445a46b55','e0850b2e-6108-475c-b8d1-3d94274a563b','bcdfe93b-b7fc-43a1-b6e9-d90877fc4468',0);
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
  `fk_currency` char(50) DEFAULT NULL,
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
/*!40000 ALTER TABLE `cashier_shift` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clinic_sales`
--

DROP TABLE IF EXISTS `clinic_sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clinic_sales` (
  `id` char(50) NOT NULL,
  `is_bpjs` char(1) DEFAULT '0',
  `bpjs_payment_status` char(10) DEFAULT NULL,
  `medication_status` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clinic_sales`
--

LOCK TABLES `clinic_sales` WRITE;
/*!40000 ALTER TABLE `clinic_sales` DISABLE KEYS */;
/*!40000 ALTER TABLE `clinic_sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clinic_sales_item`
--

DROP TABLE IF EXISTS `clinic_sales_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clinic_sales_item` (
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
-- Dumping data for table `clinic_sales_item`
--

LOCK TABLES `clinic_sales_item` WRITE;
/*!40000 ALTER TABLE `clinic_sales_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `clinic_sales_item` ENABLE KEYS */;
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
INSERT INTO `company_structure` VALUES ('0b433d1c-a4d0-4ece-8d42-f87523178070','2014-01-01',NULL,'4a129f6b-7b21-4640-bf78-4da17201894a','BRANCH','643fe642-cd1b-4b71-9b3e-f3b2fb2effa4',0),('1a233763-467a-437f-9790-16a47b5e3f1b','2014-01-01',NULL,'4b6b0923-ee66-4459-817c-8a3615e77276','DIVISION','0b433d1c-a4d0-4ece-8d42-f87523178070',0),('2c966049-c985-4823-9109-2e45475aa378','2010-01-01',NULL,'b620d220-4d73-473f-b0ba-cad098570b6a','HOLDING',NULL,0),('31bfd6be-2ffa-45fd-b882-c94250565f3c','2014-01-01',NULL,'27fa30c5-4c84-4f2a-88ed-f93fa1ca558d','DIVISION','0b433d1c-a4d0-4ece-8d42-f87523178070',0),('63ab943f-6190-4e92-8361-08e204c1479a','2014-01-01',NULL,'bce962f9-7d57-49fa-bcee-cfc093b10b96','DIVISION','0b433d1c-a4d0-4ece-8d42-f87523178070',0),('643fe642-cd1b-4b71-9b3e-f3b2fb2effa4','2014-01-01',NULL,'b42b1e90-1bb2-4a6f-9962-230fd47c003e','COMPANY','2c966049-c985-4823-9109-2e45475aa378',0),('a14a9396-060a-4525-820e-03c7560341d5','2014-01-01',NULL,'977dce5c-bbe4-4abc-8df7-f8f3a4c167c7','DIVISION','b5c06ee9-3a16-423e-b2c1-d38c063a8677',0),('b5c06ee9-3a16-423e-b2c1-d38c063a8677','2014-01-01',NULL,'4b089faf-a54c-4870-bd4d-17128ae8aa42','BRANCH','643fe642-cd1b-4b71-9b3e-f3b2fb2effa4',0),('e91f03d5-8f73-4b04-be81-3d0f8902db52','2016-01-01',NULL,'b17aadd1-fb3a-48fd-b780-a34f89596102','DIVISION','0b433d1c-a4d0-4ece-8d42-f87523178070',0);
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
/*!40000 ALTER TABLE `course_installment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_installment_item`
--

DROP TABLE IF EXISTS `course_installment_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_installment_item` (
  `id` char(50) NOT NULL,
  `resource` char(50) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT '1',
  `uom` char(50) DEFAULT NULL,
  `unit_price` decimal(10,0) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_course_installment` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_installment_item`
--

LOCK TABLES `course_installment_item` WRITE;
/*!40000 ALTER TABLE `course_installment_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_installment_item` ENABLE KEYS */;
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
-- Table structure for table `deliverable`
--

DROP TABLE IF EXISTS `deliverable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deliverable` (
  `id` char(50) NOT NULL,
  `name` varchar(250) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deliverable`
--

LOCK TABLES `deliverable` WRITE;
/*!40000 ALTER TABLE `deliverable` DISABLE KEYS */;
/*!40000 ALTER TABLE `deliverable` ENABLE KEYS */;
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
INSERT INTO `employee` VALUES ('3597f3cd-18c2-45bc-9e88-e31b25194479','3f98d954-4f74-42a0-bd6d-84300d27bb95'),('62d9bf59-05e0-4259-9451-42946bc936c1','f4fc4447-782b-4fdb-a397-c188e47b58c9'),('a175ddcb-7be9-4d86-a469-05155a9a74ab','536b97d1-d63e-4dd1-86dc-7136b8d9d98d'),('b5ffb8f3-866a-4268-aa8f-871d5abf6778','ef8b3235-7cb8-480c-b94b-62563a058fa9'),('b858aa16-1bd2-4c24-adc1-e8006fff1add','53dcccf7-4b46-4b2c-8509-1045422ee2ba'),('de341cd3-19ec-4a11-a3cf-1f540a57f663','b9e55e5b-2f34-45e6-937d-69a930dd1a52');
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
INSERT INTO `employment` VALUES ('197249e1-1334-4abd-89ae-ee938ddf4731','a175ddcb-7be9-4d86-a469-05155a9a74ab','9e65fbc2-1c5c-457d-a393-915c96cd6fb7'),('8b6bd84b-7a91-49ed-9971-59362dea1486','b858aa16-1bd2-4c24-adc1-e8006fff1add','9e65fbc2-1c5c-457d-a393-915c96cd6fb7'),('b9fca74a-bd61-4b57-bacb-a3a0a7d50385','62d9bf59-05e0-4259-9451-42946bc936c1','8ae9b85b-b70f-45f4-920d-56d1ee76497d'),('cc84b08c-daf5-41b0-a062-172d494387e7','de341cd3-19ec-4a11-a3cf-1f540a57f663','8fa98ab8-ca51-4854-ad19-efffdf25e91a'),('de0349a1-d273-45c9-9d92-89e307e361d0','3597f3cd-18c2-45bc-9e88-e31b25194479','9e65fbc2-1c5c-457d-a393-915c96cd6fb7'),('f06a1407-3faa-4fa4-8ea2-d70c3b145c2a','b5ffb8f3-866a-4268-aa8f-871d5abf6778','82ce9e00-cf20-489e-9168-df5c4a632d12');
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
INSERT INTO `erp_mode` VALUES ('00000','MEDICAL',1);
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
INSERT INTO `facility` VALUES ('\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','PLT 01','Pallete Aim 01','','PALLETE','631f6b1b-111f-4c7a-9e43-e1491ab23907',0),('631f6b1b-111f-4c7a-9e43-e1491ab23907','WH01','Warehouse Aim','','WAREHOUSE',NULL,0);
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
INSERT INTO `facility_organization` VALUES ('1ce4a4d2-ebda-464e-8596-ed4646156e8b','0','631f6b1b-111f-4c7a-9e43-e1491ab23907','b620d220-4d73-473f-b0ba-cad098570b6a',0),('3321e36f-c1a6-400f-8147-e43f3f0bb39e','1','\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','b17aadd1-fb3a-48fd-b780-a34f89596102',0),('40695c88-fcf0-4671-b8eb-cb0aee0fb8d3','0','631f6b1b-111f-4c7a-9e43-e1491ab23907','4b6b0923-ee66-4459-817c-8a3615e77276',0),('43db5ff5-0212-42d6-a654-0cd39d4dd74f','1','\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','4b089faf-a54c-4870-bd4d-17128ae8aa42',0),('46fc11ba-f80a-4dea-a6c6-4b8354a00bb0','1','\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','4b6b0923-ee66-4459-817c-8a3615e77276',0),('4ef07911-c731-40dd-a5f3-94da22b929b4','1','\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','4a129f6b-7b21-4640-bf78-4da17201894a',0),('4f5889fc-f11a-4c7b-a651-778df0144bc7','0','631f6b1b-111f-4c7a-9e43-e1491ab23907','bce962f9-7d57-49fa-bcee-cfc093b10b96',0),('533192f4-b58b-47a1-9bfa-ad77839fa6e9','1','\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','b620d220-4d73-473f-b0ba-cad098570b6a',0),('5b5388b8-cefd-4ee7-8d38-87ceae3864d8','0','631f6b1b-111f-4c7a-9e43-e1491ab23907','977dce5c-bbe4-4abc-8df7-f8f3a4c167c7',0),('6e9acc8d-1b92-411c-afd5-48f9b3a1dde5','1','\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','977dce5c-bbe4-4abc-8df7-f8f3a4c167c7',0),('7b20a27a-75e5-4901-83ae-3b2e737f0aa8','0','631f6b1b-111f-4c7a-9e43-e1491ab23907','4b089faf-a54c-4870-bd4d-17128ae8aa42',0),('7c47abbc-25db-4813-8116-45915df1e3ff','0','631f6b1b-111f-4c7a-9e43-e1491ab23907','4a129f6b-7b21-4640-bf78-4da17201894a',0),('7f5ec58d-42af-402a-a99a-201861f3142e','0','631f6b1b-111f-4c7a-9e43-e1491ab23907','b17aadd1-fb3a-48fd-b780-a34f89596102',0),('80fa5183-7556-41cf-848e-c272ee89d812','0','631f6b1b-111f-4c7a-9e43-e1491ab23907','b42b1e90-1bb2-4a6f-9962-230fd47c003e',0),('9b68cc90-cce2-4dbd-aa70-2afcd9a2f660','1','\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','27fa30c5-4c84-4f2a-88ed-f93fa1ca558d',0),('ed665803-92d1-4a30-b503-98d5c9404163','1','\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','b42b1e90-1bb2-4a6f-9962-230fd47c003e',0),('fc32d5ef-f8d5-4be1-9f43-ca17e0bbd8aa','1','\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','bce962f9-7d57-49fa-bcee-cfc093b10b96',0),('fdaf1ea3-9af0-4ffe-911e-1df1ab7da41c','0','631f6b1b-111f-4c7a-9e43-e1491ab23907','27fa30c5-4c84-4f2a-88ed-f93fa1ca558d',0);
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
-- Table structure for table `financial_account`
--

DROP TABLE IF EXISTS `financial_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `financial_account` (
  `id` char(50) NOT NULL,
  `name` varchar(250) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `financial_account`
--

LOCK TABLES `financial_account` WRITE;
/*!40000 ALTER TABLE `financial_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `financial_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `financial_account_role`
--

DROP TABLE IF EXISTS `financial_account_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `financial_account_role` (
  `id` char(50) NOT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `fk_account` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `financial_account_role`
--

LOCK TABLES `financial_account_role` WRITE;
/*!40000 ALTER TABLE `financial_account_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `financial_account_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `financial_account_transaction`
--

DROP TABLE IF EXISTS `financial_account_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `financial_account_transaction` (
  `id` char(50) NOT NULL,
  `transaction_date` date DEFAULT NULL,
  `entry_date` date DEFAULT NULL,
  `fk_payment` char(50) DEFAULT NULL,
  `fk_account` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `financial_account_transaction`
--

LOCK TABLES `financial_account_transaction` WRITE;
/*!40000 ALTER TABLE `financial_account_transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `financial_account_transaction` ENABLE KEYS */;
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
INSERT INTO `geographic` VALUES ('68309a5f-4606-46d3-ad20-996ed6c782d0','KAL-BAR','Kalimantan Barat','PROVINCE','',0),('68309a5f-4606-46d3-ad20-996ed6c782dx','RSJ','Rasau Jaya','CITY','',0),('c4c10aee-a3a1-4e6c-a08b-62d4e26414df','PNK','Pontianak','CITY','',0),('d0ae6c1a-d6e2-4ca8-879d-52d74e6feb71','JABAR','Jawa Barat','PROVINCE','',0),('f5a12273-368d-4d39-851a-05da7bb04ab9','IN-ID','Indonesia','COUNTRY','',0);
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
INSERT INTO `gl_account` VALUES ('1574c4eb-34c3-4603-a4a4-45bcff15ea60','1002','Kas Umum','','Assets','f49a3d14-b639-4d46-ab7b-5457d3cbd00f',0),('24f5fccc-59c4-43f5-9a44-35f3ae2a38da','1011','Akun Bank (Syariah Mandiri)','','Assets','f49a3d14-b639-4d46-ab7b-5457d3cbd00f',0),('270ad66b-a7a9-4b0c-9a26-ba9760c114f4','2004','Pajak Gaji Terhutang','','Liabilities','88618627-e8d8-43e8-a790-a9d76882d835',1),('2bbab6e9-5c5e-40b6-92fd-525d525f38d4','3000','Owner Equity','','Equity','9dc4805f-d239-49c4-9934-54db1fcce388',0),('2ced690a-85eb-4bac-a745-db92d1b26fb8','3002','Johan Corp Investment','','Capital','3526547d-d056-479e-b5f4-c61c2fd05ae9',0),('2da81f71-8013-4aa9-a92a-87487ada1c94','1001','Kas Kasir','','Assets','f49a3d14-b639-4d46-ab7b-5457d3cbd00f',2),('3526547d-d056-479e-b5f4-c61c2fd05ae9','3001','Capital','','Capital','2bbab6e9-5c5e-40b6-92fd-525d525f38d4',0),('36f476e1-b97c-4e07-8b4a-899dc1edb976','3604','Pembelian Asset','','Expense','fb57e7c7-ab58-4a0c-acd7-ecbe09fcd5b1',0),('41cf31d7-ef92-4132-aa23-7c06e9d9d9ce','3201','Johan Corp Drawing','','Drawing','55b3a728-cacd-44bf-8b44-8e505b43bb2c',1),('48179971-d914-4378-a82c-eec141f1897c','2002','Pajak Terhutang','','Liabilities','88618627-e8d8-43e8-a790-a9d76882d835',0),('4b449bdc-6882-4286-86a1-223081928574','2001','Akun Hutang','','Liabilities','88618627-e8d8-43e8-a790-a9d76882d835',0),('4fbc06aa-d1fc-4aac-b9e8-6e0f55b35592','2005','Pajak Penjualan Terhutang','','Liabilities','88618627-e8d8-43e8-a790-a9d76882d835',0),('55b3a728-cacd-44bf-8b44-8e505b43bb2c','3200','Drawing','','Drawing','2bbab6e9-5c5e-40b6-92fd-525d525f38d4',0),('56958b7a-2e8e-4148-95d0-ad0433329341','3601','Pembayaran PDAM','','Expense','fb57e7c7-ab58-4a0c-acd7-ecbe09fcd5b1',0),('682d8f64-52fa-4189-af52-a38b6130a902','3603','Pembayaran TELKOM','','Expense','fb57e7c7-ab58-4a0c-acd7-ecbe09fcd5b1',0),('764e46ff-dffc-46fc-b24b-6cd3b985e5be','1004','Piutang Dagang','','Assets','f49a3d14-b639-4d46-ab7b-5457d3cbd00f',0),('820f1122-b177-4faf-b3fb-93e03bc37dde','1008','Barang Jadi','','Assets','f49a3d14-b639-4d46-ab7b-5457d3cbd00f',0),('853cc1cf-9611-43b6-a102-32542e574019','3602','Pembayaran PLN','','Expense','fb57e7c7-ab58-4a0c-acd7-ecbe09fcd5b1',0),('878fa124-4409-433c-b617-346f0f72008e','2006','Tuslah Terhutang','','Liabilities','88618627-e8d8-43e8-a790-a9d76882d835',0),('88618627-e8d8-43e8-a790-a9d76882d835','2000','Liabilitys','','Liabilities','9dc4805f-d239-49c4-9934-54db1fcce388',0),('88e1fdc3-397b-4fb2-8762-34fcb8117d86','3402','Penjualan Barang Jadi','','Revenue','b1d4647e-053f-4b08-8556-6b4d9f9ac82a',2),('8fe720b5-9fed-4e69-b6d3-d527cae1c6ab','1010','Akun Bank (BNI)','','Assets','f49a3d14-b639-4d46-ab7b-5457d3cbd00f',0),('9a89224d-5c0e-4bf7-a424-43a2c9952d28','1003','Akun Bank','','Assets','f49a3d14-b639-4d46-ab7b-5457d3cbd00f',0),('9d3a5e4c-c4c9-4758-83f6-2868ea42ce52','1007','Merchandise','','Assets','f49a3d14-b639-4d46-ab7b-5457d3cbd00f',1),('9dc4805f-d239-49c4-9934-54db1fcce388','00000','COA - Johan Corp','','Assets',NULL,0),('ab7014c8-da75-4811-b026-6dde1a0f87ec','3605','Pembayaran Gaji','','Expense','fb57e7c7-ab58-4a0c-acd7-ecbe09fcd5b1',0),('ac07af27-0170-4c88-8f4b-68cecb26bf60','1006','Pinjaman Jangka Pendek','','Assets','f49a3d14-b639-4d46-ab7b-5457d3cbd00f',0),('b1d4647e-053f-4b08-8556-6b4d9f9ac82a','3400','Revenue','','Revenue','2bbab6e9-5c5e-40b6-92fd-525d525f38d4',0),('b56b3bd0-46ee-4093-bee5-a3df47eecfe7','3401','Penjualan Jasa','','Revenue','b1d4647e-053f-4b08-8556-6b4d9f9ac82a',3),('c239d176-2c4a-45b5-a784-1e0068746efa','3800','Cogs','','Cogs','2bbab6e9-5c5e-40b6-92fd-525d525f38d4',0),('dc097b30-730a-459d-b3c0-bae518039a1f','1005','Pembayaran Uang Muka','','Assets','f49a3d14-b639-4d46-ab7b-5457d3cbd00f',0),('e74aeed0-b879-4818-bfaf-bde4748a1405','1009','Peralatan Kantor','','Assets','f49a3d14-b639-4d46-ab7b-5457d3cbd00f',0),('f49a3d14-b639-4d46-ab7b-5457d3cbd00f','1000','Asset','','Assets','9dc4805f-d239-49c4-9934-54db1fcce388',0),('f8c654cf-7fe7-4691-a722-5cfb4cc25f3b','2003','Bunga Hutang','','Liabilities','88618627-e8d8-43e8-a790-a9d76882d835',0),('fb57e7c7-ab58-4a0c-acd7-ecbe09fcd5b1','3600','Expense','','Expense','2bbab6e9-5c5e-40b6-92fd-525d525f38d4',0);
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
INSERT INTO `internal_organization` VALUES ('675f4ff3-367d-4142-8ce3-a657c0871710'),('82ce9e00-cf20-489e-9168-df5c4a632d12'),('8ae9b85b-b70f-45f4-920d-56d1ee76497d'),('8fa98ab8-ca51-4854-ad19-efffdf25e91a'),('9e65fbc2-1c5c-457d-a393-915c96cd6fb7');
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
INSERT INTO `inventory_item` VALUES ('00479c92-7b3d-4923-8977-dce4f3d2518e',NULL,'4e196243-c077-49e7-9ff6-b6d188a9f10a',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-02-28',0),('00baf6f8-49c8-4168-bb8e-f8b38634d025',NULL,'770068c9-eb27-4bfb-b29d-f0ec9fc23d8e',230,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-02-28',0),('00ef66b6-7e43-4891-9e9b-5780586d80cd',NULL,'9a6d59ef-1828-42ff-a4b8-54cf1a02ccbf',1,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('01b0f601-7ff7-4f46-a16c-8cdc17f739d3',NULL,'a6e3696d-0ee8-4baf-99b4-8e0771fbb187',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('01cc5d6a-2ca1-4dc7-a523-4981531d686d',NULL,'7efdbb21-13fd-4f57-b50d-0d16f29cef39',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-01-31',0),('01cc6b12-7239-4017-9db9-07ee08c0fa69',NULL,'5657e79e-8248-418d-8286-45852459a396',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-10-31',0),('0207b44b-9af4-4cb9-8d38-6cfd4c709fbe',NULL,'e9ded445-9be5-4b49-9785-fccd7a6b52fd',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2021-03-31',0),('0220bd35-f72c-4b82-9b73-231b2428069b',NULL,'554e6acf-fe8b-4b05-ae61-78459743c39d',12,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('026ce0ee-61a3-45ad-a2ec-5dadc0cdce4c',NULL,'b797a848-7080-4827-b406-1924ac7bcecf',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('02e34ba4-d828-4236-9d4c-6aca65a49552',NULL,'412a5592-b458-4ca6-9e93-ebc6459ad9f7',280,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-05-31',0),('03e4f6ec-a32c-4ee9-817c-b79c1fe35036',NULL,'665c04ae-578b-4cd8-b1e9-933f12d34994',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-12-31',0),('04003819-1514-4212-a208-b31e29eda9be',NULL,'1036ff8c-ba61-4479-8b3f-1089e236dd18',50,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2016-12-31',0),('04052276-fe43-4165-b863-659ef0d38992',NULL,'d81b8cfc-b9de-4275-bc14-d29dccbd0ed5',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('06c393a5-d619-49c2-a62c-49f40c7d6ba4',NULL,'223d66d3-f822-489e-a049-39bbc69145c7',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-02-28',0),('06dae1bf-6df6-40e3-9eb6-3880ddf48d46',NULL,'a08ad19a-61f0-46d4-87b8-8da6c8fe0e3f',12,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-06-30',0),('07e81633-1c35-4b80-8a07-251bb5616f6b',NULL,'ff17b5c0-4ddb-4aaf-aed0-27d0823c2784',50,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('083b2c01-bfb9-41aa-bbe8-3a53c099e6af',NULL,'c9964447-2625-43e3-85ca-67f5ba4e6cfb',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-12-31',0),('08464909-4507-4890-a153-659a8c8877c3',NULL,'0b74682d-2c3c-471b-81f7-0d3c1cdfc550',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-01-31',0),('08c7893c-6bfa-46d3-b77d-0f56bbb812c4',NULL,'04761771-d7fe-4fd2-bbea-d0054d8843c5',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-06-30',0),('09004318-2e63-4093-9e87-2489c6cde7a3',NULL,'87cfce04-958b-446e-b8d3-7c6d8f7cc662',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-06-30',0),('0942fe57-92b3-4bec-91bf-83d19bbbf27d',NULL,'f212b583-b619-4352-b7ae-bfd3677d4ad4',275,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('09863100-557c-4417-8461-967013fc816c',NULL,'f32709b7-59c6-4d10-91ed-75936038e844',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-12-31',0),('09b08d98-3acd-4f47-ad8a-12d110adf986',NULL,'b0e53c7d-fa19-4d03-8276-5fc5b8bb5973',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-10-31',0),('09b65c08-a61c-4999-825e-57c8eba2cb6c',NULL,'bcadd324-0f18-44f9-9fc3-efae346a55c6',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-01-31',0),('0a43953d-90e3-4594-ad01-6cb1b1514db5',NULL,'90cea514-a24c-4f8c-b37a-9b868acac2ae',12,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-02-28',0),('0b916956-f33b-492a-877e-75910d096026',NULL,'c4f5582b-8803-40b9-80b6-ab99209894d5',140,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2016-12-31',0),('0bb76072-210e-49b0-a2cb-a49a2905bd28',NULL,'bccdfffa-31da-4bc7-b7ba-6314936cac66',940,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-01-31',0),('0bbb09f2-18bb-48dd-a8c3-61e7c7f3bf31',NULL,'c4f1a4e0-097c-4c74-87d2-5c1ce0c781f9',20,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('0c0250b9-8da7-49a4-b6d2-e2c6e21e24cd',NULL,'3390b1de-aafb-4fee-8194-a69121f007db',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('0c29c3fc-d798-4a7c-874b-fa2187d12121',NULL,'ec38ce5b-96cd-4bd1-aede-f1f7364f5826',12,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-01-31',0),('0c309e9f-ece6-4ef2-8c8c-fe4c8d519fe7',NULL,'fa602e6e-5fa2-4940-962b-5a3a1e59ae1a',40,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('0c6ab700-8a1c-4080-baf3-fd303f44db2e',NULL,'6dee2dfe-043b-4bb7-a500-9a918d85d86b',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-12-31',0),('0c6cf2a5-8e76-44db-81df-927b0b4239b4',NULL,'4c661b0f-2e20-4d75-9dd6-c2b2a075f136',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-07-31',0),('0cdff84c-9fa9-4c9a-9de0-37306d7fc1b8',NULL,'ca67dff0-fdf8-416f-a4eb-ea18fc42d407',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('0d5961d8-e384-4001-9ff0-77dc0d14efb5',NULL,'a2cf4c47-125c-4e86-b578-9eb32c918cdc',8,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-11-30',0),('0d617b30-cd35-4d46-a44f-4f5abbd10d2e',NULL,'6f464606-9908-4437-ae5f-2949a0547126',540,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-01-31',0),('0e193342-7231-461e-894c-3aed10d50689',NULL,'3d78e24e-457a-4e4e-be79-a8ea7be2f184',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('0e4b2b7b-4604-4476-a6ad-3965e1ff79b2',NULL,'5ba92538-5b76-46c0-85cd-870ffb1b9db6',11,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-08-31',0),('0eedca13-aafb-496e-9c29-3dd8d263d288',NULL,'dee9470c-6103-48e6-81e5-12b09412553b',264,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-10-31',0),('0f17668e-b6fc-40e5-9bc2-87c85637d0e9',NULL,'93bcac5f-f791-47d7-8bd7-c4973506029d',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2021-01-31',0),('0f31f4a4-3a64-4c73-a489-4616e7e4575e',NULL,'bccb7f35-5065-4ef0-997a-839c35d8f804',1,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-04-30',0),('0f562d75-d6c5-4afd-976d-c96603215d17',NULL,'a5e168c0-d73f-4caf-860a-e5cc4cc47ffb',78,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-12-31',0),('0f57c117-2039-4ffd-a4fa-bab9e743cb2b',NULL,'36574898-6c20-4cc9-addc-8e6a68ca5cb9',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('0fcab848-f9b5-4831-a739-4a1a9054ca34',NULL,'752be6c7-a8e5-4f8b-a309-2f79926c6f47',12,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-02-28',0),('10150168-38a1-4326-914a-f608ee77592e',NULL,'007e27fa-9f94-47a2-a70a-115654f1ae31',120,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-12-31',0),('10a661f5-9bde-41f3-9b4f-ae70a3a859a9',NULL,'eed89e3a-292f-40c0-9d8d-f14085205184',20,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('10d4a626-4172-48d2-beaf-c5016a56a498',NULL,'940bd155-9e53-419b-b24a-bab1df49a63c',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('11052bae-5694-48e5-9571-ee676e793e05',NULL,'01a8e63d-6b82-431c-b434-26bce2e551d1',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-06-30',0),('11c82d89-b105-4f60-a7cc-8cbc6e9dc409',NULL,'635fb567-5a30-46a0-92e9-d24c2bf9340f',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-01-31',0),('11e861b2-1a91-4999-b66c-12d39a1ea80c',NULL,'746ec058-c48a-4a7d-a2db-907773279793',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-07-31',0),('12a17368-f3b2-4016-820f-e6fac3b507e3',NULL,'692315c9-fc59-4954-ac73-05aa49d2d9a1',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('1344d67f-44db-4034-becc-6c9f0f5cab67',NULL,'d997ed5d-8d3f-4951-8241-9627da3a6683',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2016-12-31',0),('15383a4d-53f4-4c95-932f-3cbf989d539e',NULL,'9b30e01a-1f13-4cb2-a30b-3545cf7e8fbc',230,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-02-28',0),('153e1aea-50d9-48a8-a793-785c041ecc7e',NULL,'b13ca82b-fbc6-436c-8645-802d56ff7f96',4,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('15481fea-e699-4607-9db9-451df5ef1b1c',NULL,'68172e37-b09a-4a41-b9b3-a1fa7714310e',5,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2016-12-31',0),('1560deb2-a05b-418e-822e-fbc4511ea243',NULL,'01b8a9fa-5733-4ee8-8c08-b20e26e5c167',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-01-31',0),('15e41e12-634b-434d-aa06-c146dfe4e0a7',NULL,'fd445b92-5917-47f7-8fb4-5f4702496e06',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-12-31',0),('1601d1d1-b834-4459-ad68-8bf649910571',NULL,'4f6f1a5c-8c63-4398-a1a7-d3fca7a0c400',12,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-06-30',0),('16540873-e8b3-4276-8bfc-dfde565abac1',NULL,'40858ddf-87fc-47ac-8f18-f1d67e2bdea9',30,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-08-31',0),('1702eb9d-5e54-4f1d-af7e-135f0d50e085',NULL,'353c2ac7-a726-4211-a776-43a1d29ba313',30,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('1810c4f2-ae8f-43ff-9902-64c3e7495815',NULL,'ac5376fc-baaa-42b0-98ff-e1ecd592912d',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('181394d3-4813-42a4-b9b5-f9c612836af0',NULL,'90b36043-8450-49a1-be3f-83b984481551',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('181bf985-ead9-423d-8212-f8e6b2657d87',NULL,'1177854c-af94-4c6b-b3ef-8545dc0c2a7c',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-07-31',0),('18bfac16-9649-4bfd-a036-e8214fa5c943',NULL,'ff0b0889-7927-4b8a-a0a8-39bfc31e2bbd',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('19a56c4d-975b-4992-b723-d8eede22202d',NULL,'10b7b0fa-494c-49b3-bd65-bdef8ad7d293',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-06-30',0),('1a108710-1bdf-4ed1-b321-c8e4637e3540',NULL,'b83db7ea-3f9a-40c7-9366-8cf56fe62584',7,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-02-28',0),('1a6186ac-d8a4-491b-aac7-9cb1e14831db',NULL,'61bb5f10-9e56-4152-b8ee-a08b606f4e4a',15,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-03-31',0),('1aea7f61-4af1-46b0-a008-0e665a51bee9',NULL,'cb1b81ea-20e3-4e77-8dc7-183cb222b81d',4,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-03-31',0),('1b0b4fba-a172-4e79-a8dd-8433cd6533e5',NULL,'86e73666-b52c-4b2f-95cd-dca03265be97',30,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-03-31',0),('1b9f7d2b-0d07-435a-9282-f0cbbd918299',NULL,'1efa96d9-713d-4a0f-be9b-1d681ab2f0e2',25,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-12-31',0),('1bc132bc-c801-458c-a24e-0e12a82ac049',NULL,'fff81e0f-ed13-4065-8c65-36a9ac7c72fe',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('1c046d97-4c21-46e9-b101-a20c912f5740',NULL,'24e58c5e-7f82-47ed-a56d-d384a29515ec',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-11-30',0),('1c1e372e-5b86-4a4e-a972-54348dbf4ba4',NULL,'bb27bc70-e246-4a79-962a-52775600eb4a',987,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('1ca6d97f-2f3d-4df9-9aeb-d9e30a4021da',NULL,'58e969cf-bf1c-4aeb-9029-04baeef1b071',50,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-12-31',0),('1ce5d766-f3dd-40c1-8c8b-566545a697d7',NULL,'616d646d-4e53-45c4-a584-f657a6cccb09',200,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-06-30',0),('1d3918be-6c97-4d22-b176-1751ebce2797',NULL,'9765d942-edbc-4d37-993f-6b4cc4fd8c92',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-08-31',0),('1d4c44b1-6e43-4140-af80-a202b3f49004',NULL,'7fc2f37e-fcaa-485b-a008-180b15bc9d79',400,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('1d534719-fa83-4a25-b992-93a17181302b',NULL,'c3c83d79-ff0e-4631-9a67-2cd941c54ce7',30,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('1e46ba91-7f49-4cbb-b1cf-03cd5f23722b',NULL,'05ea21d4-1ec4-4d21-a583-dbae13f5afee',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-12-31',0),('1ec363a6-b0ee-466e-b48a-8944bcdc4fe1',NULL,'1c477c16-a1b0-4982-8857-b9b7ee9fb986',5,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-01-31',0),('1ee95c27-57fe-439f-8dd5-02d98e12faa9',NULL,'35732a5c-88cb-4012-8712-4a60bf5628eb',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-03-31',0),('1f0085ce-7186-4f5a-b2ec-26d6b3e592e0',NULL,'3408fa37-27a1-4ba7-aabd-47da2341f48b',80,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-01-31',0),('1f04e620-283c-412a-940c-3b3dbc1e2fc9',NULL,'f50477dc-a0f6-4829-98bb-f376a115b3b7',12,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-06-30',0),('1f770e11-1e5e-46cc-9062-e5b7e8d0eec8',NULL,'579e5f38-ef72-448c-865f-8e80b04e25df',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-12-31',0),('1f92414c-16fc-4dff-9731-2e342a6050be',NULL,'a26b1643-5f37-4b51-b449-2c77bb73b2e2',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-03-31',0),('2067c804-996e-4c13-aa32-8fdb0a8dd512',NULL,'f716a70f-946f-4b3f-9f69-cd8016f608d9',30,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('20798b47-1715-489e-aa0a-9c0564e4ee09',NULL,'36f18236-d50a-435e-9869-968e0b2f0025',30,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-07-31',0),('20863f49-6e95-4039-9ecf-9f1356d8627f',NULL,'80b8cfbd-0752-460a-9a21-f5e8554aaacb',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-10-31',0),('20988580-eecb-4be3-aabe-d52b30fdf4f5',NULL,'9aa311e3-468a-4e00-b8e1-304a6c7539bf',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-02-28',0),('209ec6a6-7a73-40d0-838a-1ae9df98598f',NULL,'f660a9fc-459f-4277-ba19-e9dd28598262',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-08-31',0),('2226254a-15e1-4d23-8e5f-dfafb8d6e836',NULL,'8f2016f0-d21e-4d6f-a661-360fd72135c1',50,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-01-31',0),('2291cf79-5148-4334-987a-f2b4e577bcf5',NULL,'e815dcda-c91e-45e3-9fc1-dd2a575e6e73',40,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-10-31',0),('22ead9c4-4a25-47fd-9962-2fc051a4c26e',NULL,'53f9ec0d-c5a3-46f0-b51b-3a1f0fad63f8',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-07-31',0),('2352cd9e-9360-4d91-a531-47d513603a43',NULL,'e07d2c5c-d211-4ba1-ad34-706ef9c5c2f4',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-11-30',0),('24dad2cd-981a-4c23-9164-9ff4ad8f4726',NULL,'925acc48-43d4-49b0-869e-d7b5b198de62',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('24ea4eb3-6869-4c95-9648-252fdc1b1aff',NULL,'08a80cf4-0ef9-48d1-a79c-edd714b170c0',15,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-05-31',0),('2514d3f9-c0db-4c22-b675-a9f70afd5666',NULL,'27730e12-6012-4ac1-8c7c-17669fdf9916',4,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('2522a38c-a5a1-4c91-bbb9-1bd8131fe0c5',NULL,'4f829a87-bbba-452c-968a-7d3c063ec45b',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-12-31',0),('253249f0-315e-4749-84e7-e77030dd5278',NULL,'4b4313d1-4ec1-49cc-b023-a175c2696263',5,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('2576a0c6-ab34-4aa9-9eb8-f02a0580627e',NULL,'a42e340c-95ea-4b76-82ea-692dace6f11a',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-05-31',0),('25d348c5-8fe4-4fb4-9354-8dfd5a29f92f',NULL,'10fc4ac8-48e5-403c-b89e-45b88e772f96',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('25d68998-a8a3-416c-a3f3-dcc388fc78e2',NULL,'53d8fc10-c72b-46e4-ad97-dee6500c19d6',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2016-12-31',0),('25db913d-2259-4eaa-a52e-c62fab72c35c',NULL,'ec6fa4a1-8d0c-4b8d-b6cb-12fb11f43d7b',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('278538e2-877b-42d8-975e-239751c09553',NULL,'b58a6f2c-6b73-414d-a5b8-f2aca010713c',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('27de6454-6811-4b24-980e-eab519e66d50',NULL,'6d745229-9f24-4476-9dde-9fba11c73668',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-10-31',0),('27e7c5a4-e2d7-4804-a426-185b195a62bc',NULL,'979b84a9-1298-4b81-a180-eca8f1d01982',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-03-31',0),('28556d09-495e-4261-a7c5-9c35bae24bb6',NULL,'f8c1840f-43db-4e51-9269-26f9756f71f8',280,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('2957e850-a994-43d7-bdcb-2bb66b1ad606',NULL,'886a413c-7025-42fa-b945-90f0ddc80fa1',12,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('2a9b6755-a330-475e-93cc-6ebb2356d65d',NULL,'dcd20c6e-35f0-49f4-9d9d-d3ec1f966159',230,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('2a9fac20-fcd6-42b0-b1fc-a3c6781b7583',NULL,'9b45d4b2-297f-4b31-8029-343daa7a39a2',33,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('2b4307a4-c6b1-45e6-94ba-54f0beebb96d',NULL,'6a109be9-3ad5-4287-ab6f-2300dfbea49c',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-02-28',0),('2c72a663-59c0-4657-850c-dfd1d2b3d17b',NULL,'bf57047a-a2cd-4f22-9c1b-b0a8983fc974',30,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-01-31',0),('2c8607ac-16e7-4f05-8af6-0e163a3686c6',NULL,'d5867fc3-708d-4fd8-8b83-49598971cfda',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-03-31',0),('2cb0522d-9754-4d3b-a9ea-815ccdcebff4',NULL,'1af980d8-f07e-4d66-9c57-d998b4a1b47f',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('2ce1350b-3d58-421a-9ecd-9b78f05e1634',NULL,'2c5d4a47-3f91-4771-aadf-8ee49ac08206',25,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-06-30',0),('2d07266e-683e-479f-bc47-3bfd4551ae0e',NULL,'3dea9f95-b976-4f2f-b22e-aaaf3a890eec',4,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-06-30',0),('2d22c1c4-87e9-4cfb-aa95-c58bf3a30fce',NULL,'6977de00-516c-4a83-bb4a-c62cdf78c088',4,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-05-31',0),('2d7d01a4-e2be-4867-89aa-b244db2ca96e',NULL,'0f8b2430-75d7-49f2-bea0-ba53641982b3',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('2d98f08e-7cf4-436e-bf99-805bd0e446f3',NULL,'63c478b7-eeb8-4fb7-82c7-2d8fdd37a448',120,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('2de77168-a8fb-4731-b827-5fb7922b258c',NULL,'5af83213-24cf-410e-af75-65c824ee431f',1,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-07-31',0),('2ee42ca6-dced-4a7a-97f2-5ec609c841fb',NULL,'3dac8d81-16af-4e9b-9f3f-b3cca940035e',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-08-31',0),('2f37d949-56ba-4cb8-ab24-7209f1d5ed6d',NULL,'5598b1d3-8885-4b91-a415-8eae6cce5b33',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-08-31',0),('2f491c0c-7613-4ad5-b3ae-eaf4572cb6ad',NULL,'6c3b04c3-0627-4e1e-8bc5-4d19a2adabe8',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('300c7963-c5b6-4734-bfc2-238017ceb23e',NULL,'f584df16-bf95-4599-ad19-78169da7c723',310,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2016-08-31',0),('31f1ab2b-50d9-422c-bda3-314bc1b5c4af',NULL,'21d79dee-51b7-4840-9a9f-ff7dc3726f21',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-01-31',0),('331f0438-bed4-45f9-97ad-73ea54f48727',NULL,'848536e1-d0f1-499a-8cd1-40bfb1c2efe1',50,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('33523a3c-d244-4ee4-9aef-4831d9aa856d',NULL,'56df21f7-d44f-473c-9302-a84b3c40b8c4',20,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('336602ff-3f83-4100-931c-adf585700b80',NULL,'ec15592f-6863-4097-93de-a5abad4820e2',5,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('3393ab1a-f2e9-46a2-8df2-dc38c306abe1',NULL,'294e21e2-5410-4522-b947-588746f1293d',12,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-02-28',0),('34b06c13-10bc-4486-b39b-2fddb8ae85eb',NULL,'c2ebfa2f-486d-4784-bb85-8e5524da2ba4',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-07-31',0),('34baed7f-cedd-422d-95f7-fd3c2dca8e4d',NULL,'b8472f07-a2a4-41c5-b338-e3d5f2b16e39',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-03-31',0),('3565778d-8266-48a5-b886-5574222816d1',NULL,'de4c925c-658e-4d9b-aa04-761b50a2b364',30,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-12-31',0),('35941c20-41f2-4d37-9cc2-0db5893203d3',NULL,'8da8e399-bf10-4dfc-8363-82722c174366',50,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-12-31',0),('35fcd204-3232-4490-acc5-40cbdefe3406',NULL,'b994e8aa-85d4-402e-9b96-6e4b839b9e07',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-02-28',0),('363aef44-81a9-462d-a2ec-65cd87da8c7f',NULL,'d29a5c7d-225f-4b41-b036-88e2315ee949',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-09-30',0),('364448b1-6670-4a16-8d1b-4373a90af1fa',NULL,'86177d45-c973-47b6-8f6c-8118612b293c',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-10-31',0),('365cdc14-d92c-4f25-b600-2c45d2c38dbc',NULL,'2d35744d-b386-411d-88be-1900f1c93469',90,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2016-10-31',0),('36700bf7-fbb0-4958-aea0-bd031718ba9d',NULL,'7fcef193-3548-48fc-aeb2-9ef94dacb13f',20,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('3683cd4c-d25a-4147-af46-0ab8e467da10',NULL,'6adbd5fc-961e-4ccc-a08c-0a4dd9094b68',70,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-08-31',0),('369357e4-c9f9-49f2-9f0a-f1b7c9c32f16',NULL,'91fb4e05-b678-42fa-bb16-8022e2e24e22',5,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('36c0049e-ffaf-48b1-bade-100018cb013e',NULL,'afdf278b-e323-4208-8a00-0e639c63496f',8,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-06-30',0),('36cc4880-0190-439e-922a-56a4926d35a8',NULL,'a969df9a-af25-4798-9fa7-a2e72520e1f7',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-07-31',0),('376202a6-837e-4d3c-bcee-6c30fbca31d8',NULL,'ecb0ba82-2039-4da4-ab4f-b1b25d90e745',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-10-31',0),('377250e1-71fa-4b74-9635-0d108483359e',NULL,'1a963c74-95d3-4735-ac0c-55358c5a078c',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-05-31',0),('378a64a9-3549-4b07-a740-7d1b78db8212',NULL,'dc7b57d7-2ba4-451d-a5f1-0d0ae4c0c6f3',40,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('378d2ccc-1ad7-4af2-afe7-7fa7aa1035f7',NULL,'da9406ae-a2d9-43da-a0f6-a3a6d2bfdc1f',25,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2016-10-31',0),('382bb885-878d-4348-aff8-3615b40e6580',NULL,'de64e7fc-bcc1-431f-badd-e1ca9df3aa03',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-11-30',0),('382d85da-6936-4898-801b-edee006d8ac1',NULL,'c5ac1eb3-cb9b-4134-91db-a271a8e1b43e',774,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('384c85af-e968-48a0-a3d7-29a23a85a3d7',NULL,'f7d7c867-796b-4303-b251-a1f80c74eceb',225,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-02-28',0),('38d73317-a131-4866-adb3-c640d8e256d2',NULL,'d0e980e2-8899-4acd-9c83-5e0e6db0a7ca',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('39069de6-c0f0-4cd9-b20b-46a0ac189aae',NULL,'8b60e990-a11a-45bf-b90c-83ccda6aac8e',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-12-31',0),('3926da0c-231d-4624-88cd-e7b1d7a289b0',NULL,'1cb74234-3d39-4b32-bf58-4b07136eb87b',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('3aeec22b-c1b8-4b22-b4dc-cdb610982ed5',NULL,'ecf5648f-6127-407a-a854-0d33b13f7cc9',30,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-02-28',0),('3b2785fe-e385-4cd4-9bf0-f940264a45eb',NULL,'f5c029dc-c40e-4c0e-9d89-d00473706b36',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-02-28',0),('3b612f53-c333-41ba-9f48-0c9c7e891327',NULL,'5d1875c6-e3d3-4061-bd24-bdde0498a502',20,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('3bc9419c-a628-46fc-b2d9-f479f7ae54fb',NULL,'35c33b78-2ea8-4702-ae8f-54dd0ae438dd',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-12-31',0),('3d2b1744-776f-4a79-8d32-53769f534588',NULL,'bb427bf0-ee51-4e14-b585-f8d92e08e0ad',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-05-31',0),('3d3186a9-f8c3-4d06-8914-0bd34084fe2e',NULL,'c5404306-9de8-4113-9ff4-ff5856f00da7',19,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-05-31',0),('3d6bb40a-5302-4ad9-95ef-aa4a8ff5b96e',NULL,'ca2e5c36-4bbe-4c04-a356-e9ca17e4cc71',18,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('3d843530-216d-4d42-8500-fed86e0dc10e',NULL,'57eeb061-a4c6-4d90-b970-89facb3f46be',1,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-02-28',0),('3d87050e-fdf7-4fd2-b72e-d1d9eb6d09cc',NULL,'fcc00617-3270-499f-abf0-3a18d5305c2e',50,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-10-31',0),('3d8e322c-5cd7-4763-b4e2-d64674f4d20a',NULL,'1494e6ac-0838-409b-8171-27a4e9c793c6',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-07-31',0),('3d958bbb-18a4-4891-b78c-f7f844d73273',NULL,'44218b4c-d4ba-4c94-950e-f905c18d68f2',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-06-30',0),('3db366dc-cbdd-43de-9e11-e0d139d8c176',NULL,'b97239fd-c18c-4ea7-a8f4-27ca274aac66',50,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('3e1f1fb4-d224-43b9-9f70-6b8afffd5e02',NULL,'681f1db6-6a6c-41d4-8e48-df52a4d07135',4,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-07-31',0),('3e36351b-7cb4-488b-baba-07282649d674',NULL,'3e5946fb-f320-4e59-b4ac-017980a6a74a',36,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('3ee423d4-7796-4af8-a22b-e321c8cc3081',NULL,'254b8e87-0d5b-4fef-aaef-dcbd01f580a7',7,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('3f3f571b-f829-4f77-9280-52e665a6db8a',NULL,'3682c42c-eff3-4424-a820-ddcff5326572',50,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('3fab8b05-3f0b-4ac9-b656-cc6e7350d082',NULL,'d37f5f6d-53be-40ee-85c6-4edb83ce65c7',30,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('3fe33e48-fbb3-428f-a418-49c0110b51ad',NULL,'689937cd-f309-47a2-a1b7-812c792e5062',12,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-08-31',0),('40d7ae82-1d9c-439a-ac08-1f8aa43c3665',NULL,'17170adc-b545-44df-98f3-987692f559b4',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('41621d18-9fe4-492d-9c52-a0002efcbc88',NULL,'3c36cb75-c784-483d-a044-42bdd241254a',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-06-30',0),('41819042-4b84-42b2-bbed-e39633350e47',NULL,'d395d475-8136-4cf8-a162-5c9420acc2ff',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-02-28',0),('41951acd-9c06-4ad0-a5ed-694d79feff8e',NULL,'03ed3ffd-4174-4201-813b-31dd9c4e5793',9,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2021-01-31',0),('42c5eaf1-ebd6-4d78-81b3-bf47a90c78c6',NULL,'e5f22872-81b5-4b95-9918-8b1d9a53c654',4,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('42def445-88f7-4073-bd4e-8ec4f2ca291b',NULL,'dd4d9de7-b0b4-4bf2-a095-cb2e876a2899',130,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-03-31',0),('435b1ec5-a989-4cd6-a977-55b4c7080e73',NULL,'6663aebb-4ed2-48bf-8625-7f875052bc7b',5,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('43b8cf7d-b038-4a8f-af9b-3bcecc0bb1d3',NULL,'e30c8882-bef9-4f25-8321-ac843a963e44',20,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-12-30',0),('445d395e-1042-4b8a-9309-a3c6d192ba11',NULL,'9fd7b7e8-0265-463f-b973-bac85c31abf4',4,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-02-28',0),('44d41275-4f04-4f60-987d-77057ff9045c',NULL,'642632bb-2fdb-44e0-be92-e24ae6af802c',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-10-31',0),('44f52154-f80f-498a-b184-7a187d804c48',NULL,'4167a503-bf99-413a-aa33-d645212307f5',72,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-01-31',0),('45bd9ee4-143f-4aec-a1b0-d02ccf643c73',NULL,'5d50e9c0-84d0-4d31-8d02-f3825a3112fe',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('45d62701-344e-41d2-b4bf-13306198779e',NULL,'78beadff-493c-4956-a1f1-dc7745b357a7',80,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('46051525-0eff-4b6d-b0c5-55925a1701d2',NULL,'9bb8e3e3-3b08-411a-a7e6-43148c5cc4f6',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('4616b858-f2dc-4b57-bb14-235793b739a0',NULL,'63117b43-e0d4-4cb0-bd97-088027d7be28',12,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-08-31',0),('4630705f-2302-4f66-883d-b23e29f07af0',NULL,'8d590898-6df7-4a2b-98f6-7335961781ca',3260,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2021-07-25',0),('46a7a1ee-e943-494d-aa6f-2516773a1c46',NULL,'a4be3d32-ddb9-4ec1-85d3-74107f1cb9f7',40,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-03-31',0),('4709b934-6655-4658-bfae-7c664bce1eb7',NULL,'3970bb04-951f-4143-9f9a-9c5bedef7140',30,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-03-31',0),('47672a7d-5cc2-4851-8f4c-b16cf8a00ab7',NULL,'479eaf77-b6ff-4506-9add-222234d4bf8b',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('478a5136-4257-4387-b7d8-48656622d032',NULL,'8573a3b3-2381-4989-8194-1d966e8652ef',25,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2021-02-28',0),('47c2f819-e0a1-4e6b-b0a8-b9779f81b3d7',NULL,'b502f59b-35ef-43ad-b51e-d5c45d02b5d8',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-07-31',0),('485f5998-bb4e-4f61-9175-9563ae1dd3a3',NULL,'e80cb4ac-b07e-4600-bae7-a64c2a2f23c1',5,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-08-31',0),('48d7ad89-43ce-42a1-94b2-7a7805bf91f0',NULL,'79f1c6f1-c0c3-4a62-b7af-12c2618a554e',30,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2021-02-28',0),('49823ad5-b6af-49ef-893f-038866b36e17',NULL,'de9a4e71-d7f6-4596-ab92-cc4ca0856feb',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-12-31',0),('4ac5a371-909f-495a-bc5d-26d40b4299ca',NULL,'bbcb16ce-b29a-4b33-b633-ebecb8211ea3',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-05-31',0),('4ad90b26-cb44-4dfc-b793-e77cc44e3cd5',NULL,'baa27c38-f9aa-49a3-8bc4-f63796d77a83',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-12-31',0),('4adfa680-bb36-4f5b-94e6-300b9b56ce16',NULL,'bc857948-b661-4946-90dc-cb01ad88aaac',1,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-06-30',0),('4aefef26-8ac4-435c-828d-bfe0f7e2e89c',NULL,'28135593-39cf-4a2a-aee4-706f7ab6fddf',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-12-31',0),('4bd98397-d2b7-4cf7-aa03-ffa688b3950b',NULL,'28cba0ec-d341-4e33-abaa-878a82bcd5c9',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('4c3b2bbc-9e91-4523-8f67-4e9be2420e91',NULL,'ab8cc7d9-09f9-4d10-b6b2-fe0d97a82111',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-08-31',0),('4cf25233-fb10-4672-90c3-78e8c078543a',NULL,'ffd1c689-325e-4455-8816-ce31814996c8',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-12-31',0),('4cfe35ac-7b93-4026-83b1-7b9a0aa2df5e',NULL,'cb3ed9d0-cf8d-462a-9583-2f04218d69dc',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('4da4c9e9-6517-497e-b2c7-15fc433a12d8',NULL,'6076d39a-51dc-4d7f-b59b-8a81bd1e601d',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-06-30',0),('4ddb0c8a-0822-4387-bc03-ff6dea476b43',NULL,'a2f0a0e0-671f-4653-b4b6-5f2e80c97ad4',18,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-02-28',0),('4e538b14-ef80-4ae2-a021-06526d5b59a0',NULL,'d8125419-2e6a-4f03-91a0-ea1675890f32',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-01-31',0),('4e835e23-5a5a-41d3-88d6-ee9689245275',NULL,'9b1fd8eb-8c89-457d-ac6a-93c39ab1b8fd',0,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-10-31',0),('4e8a1e15-563d-471b-93f5-f6bc44f76757',NULL,'0dc97e5d-c36b-4bc9-bdbf-62bce2412dd0',1,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('4e926d4b-798c-4077-af03-f58850dd8398',NULL,'b77fcabc-a2e9-4157-94b1-176e5bb493d8',300,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-08-31',0),('4f19fcc2-5fb3-4be1-8606-0382fd2c9ae3',NULL,'63c4e0ef-6ebc-464d-adf9-1d5dce38473b',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-02-28',0),('502558b6-49c5-42ca-94c6-a6b53370d6dc',NULL,'81887fc2-e1b0-452d-9870-cf402bf80c24',1,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2021-01-31',0),('50c23111-9d60-442d-bbe7-2dfe740f1802',NULL,'b22ca306-7fd8-43ad-802d-1e6a2207999e',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-03-31',0),('5123a005-7e9a-495f-bf21-46111b3a5246',NULL,'aaea9111-5d11-460e-b898-c56762aa4455',12,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-01-31',0),('514efe35-4b1c-4c3b-96fc-4ed40b080805',NULL,'43659546-bd7c-4146-b6eb-27f8be761a4d',135,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-05-31',0),('51936f31-e245-4ab9-b246-9ff96d685dfc',NULL,'813771de-1fa7-46c2-b11d-f5352868396b',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-08-31',0),('519bc60b-923c-4193-9057-403ef1d3d65c',NULL,'742a55d2-b11b-481c-8cc2-20d85daac577',25,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-01-31',0),('522018bc-bb1b-4c8f-9766-7c70ee283cef',NULL,'64c9411a-f84d-48e2-9278-9f32f2be4827',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('527615f0-c2a2-44f5-a65e-6c820df0cdcd',NULL,'d1a4f5b8-dda2-4e1b-8d88-f8f5e76c3b7e',9,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2021-02-28',0),('5288cba6-7ad7-44d6-b8b6-d71ea441c38b',NULL,'c7874cc2-e364-48cc-b9b0-e1936d6dd360',50,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-10-31',0),('52b64e3d-475b-465c-938c-2afc77f03fa0',NULL,'d3ea4f01-19cd-40ec-8c10-3c640de65756',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-02-28',0),('53cc9f1e-9430-4832-b417-79c6566b676a',NULL,'d2662251-68b7-40b4-bdc2-0676f5426730',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-02-28',0),('551abfc4-783c-4352-86e7-a9b581aebf5a',NULL,'3bb38ddc-5073-46f7-ad04-d6862c1ac3c2',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-10-31',0),('5570d6ec-51d0-4e8b-9b91-dd62be46c8dd',NULL,'b85869e6-1f03-4be5-9f4a-74a0646c0272',12,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-03-31',0),('560326bc-45ff-43d8-a843-8023b219f5d8',NULL,'e00d89f5-d632-47da-bf5f-8cf9d7f4be9b',5,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-01-31',0),('5630ecbe-3ed6-4450-bd2f-9a4d563ca651',NULL,'a6f0a666-72ea-4f60-99c4-42d18487b833',470,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-12-31',0),('56ce271a-658b-4569-b93f-714d10059ec2',NULL,'b23d48e6-88f6-4415-a774-824d604613e7',12,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-06-30',0),('5704c184-89c9-49a9-9971-f0594d8ab36d',NULL,'b32bbb38-8c60-4dd3-80b7-5d2fedea25d6',210,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-07-31',0),('57144664-2079-42db-a21e-ee888a6174d6',NULL,'5463545e-fff0-4208-aec6-0d308efacdc1',5,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('5717bb17-3fa6-4da0-bdec-c091e2e551cb',NULL,'32f72db1-360a-4cc7-b444-c7c1a09b66cd',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('57438bf4-22b2-4509-8076-6c9a8052e08c',NULL,'981207d1-bb18-42a6-b9cc-665574d22b62',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-02-28',0),('5903342f-3256-4a51-b695-abc51b612676',NULL,'0d0a7ff1-8497-40bb-a4b2-848d7ac2749c',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('593a417c-e5a3-461a-ae6c-72698cd70660',NULL,'81bd16af-abfd-4a2a-b92b-15bc2240459c',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('5a06cf90-94a6-4151-8cae-41afebbe376b',NULL,'8e9a55ff-80e9-4d17-a3d5-4f93ec7ac323',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('5a48413f-8c78-4099-92df-fcceef80e0ab',NULL,'78e8bf51-ff4b-40af-b5af-8649051bc388',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('5b483055-4122-44b8-8dc4-c72e1204f8be',NULL,'f9383cdd-aaf2-472d-ad75-0496e33b5d64',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('5b584e16-2248-43cb-8f16-b40ae346a7fc',NULL,'b2b57a64-575c-4f01-8e49-6d75a13b0b6c',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-05-31',0),('5bf9ef1a-07f4-46d3-b455-ca5da4ae50ce',NULL,'06e325af-29b7-44d2-a87c-5bbe68355d45',200,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-10-31',0),('5d5ed238-5123-4370-99f2-7c96406e3c1a',NULL,'805eab32-9eb1-4345-8d2a-cca424169ae5',4,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-12-31',0),('5d683e06-2c66-4834-8104-f5f6dfbcee1f',NULL,'b27e43c2-9acb-4168-9f5d-4c4c0babcf5a',20,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('5e544824-042f-42e1-b3d5-a6f65a09c0bd',NULL,'c97186d7-0912-4977-8672-d968774c62a7',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-09-30',0),('5ec25674-e1d0-46c9-8148-90179feca8d4',NULL,'e0850b2e-6108-475c-b8d1-3d94274a563b',920,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-12-31',0),('604aaad6-ff77-4126-934b-9325cbd9d54d',NULL,'715941ea-e398-49a7-b9e2-53d8a5f0baf1',129,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-07-31',0),('60e1dd0a-f3d9-4bc3-abaf-48c7e5d7b89b',NULL,'08b45e7e-9a17-4a42-a545-f23327c35785',130,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('637a372c-d980-4f97-8ab0-3a2504ea91ef',NULL,'22e4608e-f78b-4604-9dd8-2666b21690c7',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-01-31',0),('6381aba8-5d47-4889-a779-0b743196c3f1',NULL,'4eb68a82-560b-41b0-bdd7-3c7bb9609939',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('63e168fe-c9e1-499b-941f-2804598b14f3',NULL,'35ab31ab-55d9-4b61-97e8-fc6b718fd265',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-05-31',0),('6408792b-d1af-46dd-805b-0c25ff83849e',NULL,'602bb8b3-b9ac-470b-b519-f767d37ff595',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('6444fdda-d2ce-43e3-ac38-906be96d865e',NULL,'cd61cb27-850a-48c4-8a5c-f51db64176e3',153,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('649018d1-1b42-453b-a8ba-01a9f0acf822',NULL,'ef269800-460b-4827-9444-2f295a5cdf6d',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-11-30',0),('649e5f24-dfe4-4b05-afbb-13b02291a7d1',NULL,'c7ebf076-3e1b-4c45-985c-3cd09fd3ecba',110,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-07-31',0),('64a7a118-14c1-40f0-84ba-840a2117a23f',NULL,'6ef114dd-7073-45bb-8b29-c3d8aae1c636',1,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-10-31',0),('64bcf9c2-78da-43ab-a941-ef025ba9c383',NULL,'76c588c8-fd4e-460c-bc82-32d0f60eed1a',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-03-31',0),('64c4cd08-d794-4d63-8a8f-104b3fb89266',NULL,'401f52f9-0183-4466-857b-aa5e512fa4b1',350,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-12-31',0),('6563f521-2be1-49f3-a378-d6fdda57fcf7',NULL,'46033846-68ce-4db7-904d-f882dfda42ff',45,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-10-31',0),('66853aa8-8a1a-4ecf-a808-27cde9579a32',NULL,'16865428-073d-4cc3-8da7-f55793296e21',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('67a9027e-4bee-46f0-9449-a0c29f7e880e',NULL,'7fddbe26-7a42-4719-9fda-115517d449f0',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('67aab981-f274-435b-a8a2-76cab23e48a5',NULL,'5fae8412-5d0f-46ca-a473-09bd9c0b1ca8',40,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-12-31',0),('68025464-426e-4d4f-90f6-9e1d48e094be',NULL,'53d674c2-6f13-48bb-b4e2-3d2a39541852',200,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-02-28',0),('682f0b94-edc9-49bf-a3e4-2d44f13cea47',NULL,'4effe726-17dd-4133-a179-cd6415fba98e',345,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-01-31',0),('683f0318-fdc4-4ac9-839a-2cc9999cb059',NULL,'eb3f3543-7d78-4cf7-b935-009353107611',25,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2021-02-28',0),('68711349-8ec8-4de2-93c6-58c086640c85',NULL,'a87e543d-44d6-4ce5-8cab-722c673e4b06',110,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-07-31',0),('68b36430-5d36-48c5-b7ca-4b5c68253b5d',NULL,'5c2fa992-184b-405e-b219-1041885afd21',7,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-08-31',0),('68daea87-bdd6-43a0-acc2-3a3f8a2d49a9',NULL,'f2d7c2ca-54a3-423f-9499-0f06333a9910',190,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-01-31',0),('69b553e9-6e8a-4406-90eb-f498b4dfa1e2',NULL,'c9458386-b9d4-4894-adb4-10fd81c841d3',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('69d0b26d-d0eb-46ef-b89e-cdbd1ee3a6e9',NULL,'33deee8e-779e-4354-9abc-c821cfd629dd',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-08-31',0),('6ac07292-40ba-44e9-8b75-d4ef10797bfa',NULL,'c0b87cc9-7dd5-4e92-b78c-5b065da4e621',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-01-31',0),('6b20a0f0-6c8e-46bb-b491-feb82b08184a',NULL,'33da234e-081b-4a4e-8e98-17cded390bba',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('6ce735bf-6a02-4b61-b756-a2b8c1355583',NULL,'528ead48-3584-468c-aaa1-5484a33230f7',200,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-06-30',0),('6d69255b-9ce1-4cea-b876-1726ea71e9f1',NULL,'751d2111-d008-4523-b8a2-153b5d85c7a1',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('6d797fae-2176-4bf6-9781-f7a3eb9e62ff',NULL,'05830da2-288e-4908-b338-4871b114a416',140,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-06-30',0),('6e6449aa-9413-42bc-b996-e996b4b4d8b3',NULL,'92c66aae-c96a-418e-984c-b4f6f45055b3',50,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-05-31',0),('6e92c9ba-894c-492f-beda-8d26e1e6bd57',NULL,'d9a62fb7-6ef1-4dd9-893a-0d1fb92ec830',124,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-03-31',0),('6eddb864-cfaf-4dac-b8d8-7104b6c92b06',NULL,'8b8953f3-3901-4053-86bd-4fe8191e3bad',12,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-03-31',0),('6f0d5d60-1a00-452d-8b79-550d5665286d',NULL,'68bc940c-4a69-4656-a72b-7eba9efc6987',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('6fc08729-b44d-42e4-873f-e2f45c61e21a',NULL,'b8eed9d5-a538-4c6e-ba3a-b4c05666d0af',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('707d8876-82f5-47bf-8c96-9037f7d2d3d5',NULL,'672947e3-41dd-4c7f-bf34-824b0dd04ee7',25,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-10-31',0),('7192824e-b1e3-41b6-877a-ccf547652ea7',NULL,'82b32d45-0766-4c17-bfa2-855793ee7e8e',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-11-30',0),('71e44d99-57d2-41d1-b7db-beb2ea20bf05',NULL,'d4a2c9ff-e6a9-4261-b6a8-9201a96e70ef',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-02-28',0),('720acf28-1ead-451c-914d-28a3f3e9646f',NULL,'aaf6a740-abb1-4a7d-b36b-2ecc0738e723',4,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-06-30',0),('72157d33-0fac-4923-b2f0-7098b660c293',NULL,'7c02890e-1b8f-4be3-84ad-b79727abe03b',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('722dab19-382e-4c55-967b-93e8837dc4da',NULL,'5368a724-8791-4235-a3c3-14be6a7c8366',5,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-02-28',0),('72681f84-5981-4e5f-9cd9-f8291ab06cbe',NULL,'3e700502-6382-4f52-a5df-175e7407dc4c',12,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-03-31',0),('72924cb5-9500-497c-b2a7-323f3657b1ef',NULL,'9e3c398b-3c45-49a6-bb2a-0367a986a1e6',4,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-03-31',0),('72df0050-1a4e-487e-8ca3-12f4ca7ad8a3',NULL,'8769c18d-f776-4753-86a9-2a97811c8a7d',1,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('732d1487-2615-4069-8d12-864fad055c6e',NULL,'a0eacb3f-5b0e-4833-b9b5-56ed95c0a9f9',20,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-03-31',0),('737588b0-c277-47c3-a63a-435470fa7105',NULL,'de368c77-e855-4ee6-bbb4-89194ee66380',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-01-31',0),('73f42adf-9b84-4201-8fa8-eb6de91dda05',NULL,'8ecd4d6f-3bf9-48bd-8cd9-a7b392a8973a',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('73f8fb81-7a61-4aa9-b6c6-6a688b574618',NULL,'c98a019a-981b-485b-86e4-7b3cc62d4d27',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-02-28',0),('742d89f4-2c2a-4d5e-81c3-13a1ad3cfd3d',NULL,'5062d5a6-46a9-40b3-8b47-d8967781b60a',110,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-07-31',0),('74ffcb5b-7d91-4ae2-8907-41258deefd8b',NULL,'c6379235-1283-482d-926b-b1ca038e1f2d',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-01-31',0),('755305b0-e74e-4644-a31e-f5b90e6f6b09',NULL,'6885ead4-766d-4d90-95b6-62b83e0d62f6',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('7596a1e9-5d8d-4daf-aaec-0a1fb07b5b03',NULL,'b8cf6bda-59f3-4a48-b9de-f5d8712fde54',4,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-06-30',0),('75bea621-b763-480f-a274-3e7ec8dc3142',NULL,'3161ee08-13f9-43d6-a312-043f441baf9b',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-05-31',0),('7600c3c1-5d38-4318-9a30-ca379b085689',NULL,'c9438eeb-a4e2-4532-a7b2-e7b0aa4aa16b',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-05-31',0),('762234da-caff-44d2-9d84-a987fc9297fc',NULL,'1aa9ec96-e467-4ddb-8397-5f59685a32ed',200,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('771d8bd8-e790-49b4-aa56-f60c9aeebdbd',NULL,'d30ecb66-2dbc-479c-b189-ab867dca4473',130,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('774f2a72-e674-4827-90f1-ab8cfbd33e52',NULL,'01b583c9-c515-4b30-9793-482d0a76f1d2',8,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('77696afb-bb4f-4a78-955a-76eb82f2e748',NULL,'3df8f1c8-101e-4352-8593-030d958186d4',18,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-01-31',0),('780880cf-61a8-4039-b5ab-95351036ae4a',NULL,'34cb8dc5-05db-4754-a6f0-753c331fcbe7',4,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-05-31',0),('78e93614-b5ae-4feb-ad22-e0aa91d68326',NULL,'25d4db4a-715f-4561-9441-06da16bf5f7a',70,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-05-31',0),('791980f2-57d9-4212-a705-c6f72b2b5f1c',NULL,'9a2c13fd-a142-46ec-8551-4bc86e1a7626',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-02-28',0),('7a18fb9d-05a4-434c-bfaa-198ec8eb0d9f',NULL,'dd0751e7-c88c-473e-94eb-955bd6e0ea8b',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-02-28',0),('7a64d713-4816-417f-b2ba-aeeb5f3703b6',NULL,'a86a1c82-5128-43d8-a865-376d8d6605a0',50,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-02-28',0),('7ab4424b-4d4c-41d0-afd3-b3eae0a3b981',NULL,'f5509dde-0cea-4281-9079-1dcf6a033ee2',200,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-07-31',0),('7b7ec96f-b8a0-403a-bc8a-50469431786a',NULL,'5794b252-93ea-4cee-aa14-dbc63204ecfa',40,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('7b972055-811c-4baa-80f0-625eb30a49c5',NULL,'05f7ca85-abef-44b7-856b-bd65718f0eae',30,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-01-31',0),('7c4d01fa-e9dc-483d-90c7-50ac9d297430',NULL,'35f2b105-7802-446d-881f-97f5f407a6ef',210,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('7c929413-3497-4306-ab43-8e1a17c96bd7',NULL,'90c07d25-db37-4060-ba5a-6e5af7dfdf4f',5,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-12-31',0),('7cadc285-22b5-474d-93e9-d4d9db69bee1',NULL,'ef1f9e0c-2dee-4fe4-b034-fd395366198c',8,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-07-31',0),('7d83e5f4-94dc-4ec6-8bd2-8abbd4e1d2f7',NULL,'3dc08832-a380-4356-b01b-cf00527a0630',72,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-10-31',0),('7ded5bed-431d-40c8-adaf-3b6add32fcb4',NULL,'d818a34d-5107-4798-9acc-3d6f0a2243ee',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2021-01-31',0),('7e62e4e0-cfa1-4560-8534-3ee499b8ea4e',NULL,'d39721eb-fa96-454f-bae9-d703cf4655be',3260,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2021-07-25',0),('7e9cf626-e889-4b30-95b7-6f2a47e7b0db',NULL,'9802b6fb-0db0-4e66-8938-26afdccbcb53',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-11-30',0),('7eb95707-7b43-46a9-b072-b4a9abd590ac',NULL,'f886c2b4-d114-4212-9569-b3f9ea49e1a1',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-10-31',0),('7f2d2f7e-580a-4370-9443-b005252c6170',NULL,'2fd63757-2ddc-4466-b04f-a3ca142b8591',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('7f613f1a-ddd1-4a5e-a29c-d680a45e6385',NULL,'7867372a-5231-4c40-be88-92a77ce74340',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-10-31',0),('802a0aff-66c6-4ccf-a745-7a2917077b64',NULL,'936f4c03-b603-41a6-b078-dbfe54b06563',170,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-05-31',0),('80867130-c9cd-4a39-9801-59e748bca247',NULL,'9eab9be0-7355-4001-86b3-d701aafa247a',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-12-31',0),('80e88b62-5c4b-4d22-a41d-cf55e2d9bea3',NULL,'830d777f-32bf-475f-b03b-aba72906c82c',390,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('817f78a6-0991-423e-aaec-789d89099d91',NULL,'1f43ba02-de8f-4b1a-8d5c-d5fabf862158',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-12-31',0),('81a857ae-752c-4647-a723-002c3638c358',NULL,'7819a076-6e2b-40d6-8fb5-82352074c6c5',20,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-08-31',0),('822eaee3-dfe3-4969-bac7-4338bf77c078',NULL,'c6cb3613-3b59-4d93-bad5-cbc307a5b147',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-01-31',0),('82e62645-f1e8-4205-a44e-e2bd1cb1048d',NULL,'32dbb41e-2878-40ad-a4f2-31b8b34400ed',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('8340eea5-85df-467b-a6c4-9356fd0f061d',NULL,'d56f271f-0d1f-47d9-a879-5d7dbddbf64c',12,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-12-31',0),('836e6b3c-f16e-4edc-a3c7-0025c6576529',NULL,'6ede563d-0aa2-4bdd-ab9d-199fb73117dd',24,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('83916a4b-db32-4b3a-ba65-9c36aefd544c',NULL,'59216eee-bf00-4692-950c-2cf34e629738',5,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-05-31',0),('847622e4-7355-4ac8-8140-892c3849a3d1',NULL,'cb080cf5-be76-4956-bca0-d1da336c171b',4,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-01-31',0),('84a5b4a0-ac59-4361-9795-6f65c5a94254',NULL,'26cc436a-c594-409c-8f35-c0cfbfd82a4c',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-02-28',0),('852739fa-7488-43f8-9f47-d0f5143f94bc',NULL,'36a7ee3c-cac2-47da-8a38-3fd1b2fe5e5c',5,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-11-30',0),('8587a0a0-05eb-4fec-a7ee-08c8de53f7e8',NULL,'56c34599-fb09-49f1-b19a-09dbe50f41fe',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-05-31',0),('85f20293-e1d1-422c-b354-7db84b80aca7',NULL,'2cc86f32-a7e0-4d34-82cd-b434a2b41768',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2021-05-31',0),('8606e7ac-8589-4eda-b633-22b05c6f7803',NULL,'78400bc3-34aa-4448-a70b-50a85ad93785',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('862f5b5f-f4df-42a1-aab5-3312a4d4c00e',NULL,'0c22a71d-831d-4f91-9006-aac28244e489',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('8693d0db-79b6-4267-8833-3e06803c7b9e',NULL,'ff34b5dd-f600-4492-9c76-8d34d8589e0f',40,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-08-31',0),('869d8b1f-ff5c-48e5-9f15-a7d88f26d3bd',NULL,'1aad43d9-279b-4527-8581-5c86a5885008',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2016-12-31',0),('86ca3289-92fc-400e-b855-a7620795c2f8',NULL,'1cbdf52a-e1bc-4242-b846-d9b8f5e323c3',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-07-31',0),('86dc5f28-3da8-4283-8fc2-44803be86466',NULL,'0b7c70bb-e354-4250-8931-5fe10e2a78f0',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-02-28',0),('86edb11f-71b9-4979-8698-2ce5f66bd45b',NULL,'acd3b56c-0811-498b-9324-640d56607ef2',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-06-30',0),('873f00ad-ffd7-4f55-bf51-750d9bd17900',NULL,'7f2f11f5-faf2-4327-96ba-6a444834947a',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('878d583b-678b-42f8-9a85-12cb01a8821c',NULL,'a63f33cd-561e-4f75-8fd8-6784c3716e31',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('878eb943-7d33-4d56-a609-a336826afbd4',NULL,'6d159603-dad6-4913-b824-7adf31304971',200,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2021-02-28',0),('88059cf5-0d48-45c6-ac51-b4d07249c87c',NULL,'fab5103b-073d-4952-8280-017ff9faed93',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('8833e1ef-76eb-4100-8917-ca200fc3b8b7',NULL,'bbdff218-6ed0-4984-bf91-194096003796',48,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('88a6cb86-58ed-40ad-bf10-9f76d28a2b0a',NULL,'e6c6610d-1978-42a2-8d28-7961a29e41b6',190,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-05-31',0),('88b4cf7b-20f9-4ba2-89d3-72089b0b9310',NULL,'5e0061bd-4ce4-4bfd-9568-d82450b30e36',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('897c06cf-3a1a-4fb7-b00b-4baaca264e44',NULL,'6d78718a-6d47-4434-ae4e-fb33df9a0714',80,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-06-30',0),('8afaca6d-db33-4fe9-9829-dbbca2610195',NULL,'32c00f0f-3f41-4b6f-b511-cc713e4a0376',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-11-30',0),('8b111380-4cb4-4594-849c-ae72359f0654',NULL,'e166d6d7-7cf8-4e5c-a13a-4499d9762f7f',60,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-08-31',0),('8cae04dd-a585-4c61-b0f9-35eb3898714a',NULL,'45aa3047-9d7f-47e7-acc4-5b66206c38ab',18,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-02-28',0),('8d569663-407f-4e16-9bbb-2dfd491cd460',NULL,'152f2e0e-1a2c-417f-82c1-b280460976fd',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-03-31',0),('8e7a8ad0-197f-4433-b079-0646568a5add',NULL,'162da676-a464-47e3-b74f-98c12165e8c3',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-02-28',0),('8ef77fe6-fc7a-45e1-8fbf-d8f5f24db80d',NULL,'adc12893-097d-4c38-bbbd-6264ed8bbf3e',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('8f32d7ea-44f9-4792-9135-8e9ad97b9c36',NULL,'4fccf62e-f6c6-46d9-948b-ff2c1f769fff',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-03-31',0),('8f3c114c-788e-499a-b2d2-7356d8c6762b',NULL,'0c87f638-2e75-413d-bd70-c5b89c144b3b',25,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2021-02-28',0),('8f51b97a-5ee7-46b9-a31c-efe5f55ed6a0',NULL,'abb5cb67-760d-4be3-b7a1-4ced780cf00c',95,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-12-31',0),('8f6ba7ad-fcea-44db-97d2-a69860509306',NULL,'90b93b2a-34f8-43f5-957f-cb47a4551120',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('8f74a13c-010e-4fbe-9fcb-0280bd1a18c9',NULL,'0f2fd2e2-3ab1-4a57-a327-2d11215facb4',1,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('8f8ff6fe-728f-4cb5-bbd9-e34defa8c842',NULL,'2d567563-1311-4d61-b599-4262498abbcf',120,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-01-31',0),('8fb69924-d7a6-46e0-be3f-5a9478827f51',NULL,'2223495a-8eef-4757-b33c-27fb7646d4f5',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2016-08-31',0),('901a226e-5494-4c4b-a45c-3adb5709aba8',NULL,'a75016e6-61e9-4521-8abb-65a4449cdd0b',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-07-31',0),('901aac34-7e38-4da1-8b2a-054dcf119a9b',NULL,'6e17ec90-63af-41c3-8cac-5bd946faaf82',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-11-30',0),('906cdcdf-421f-4890-a057-8b05e7843fd1',NULL,'bbecc8a4-1770-4f1a-89e7-5239fea66cb2',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-12-31',0),('90c5908b-304e-4535-9b43-4a545eb97ad6',NULL,'c7383f85-c820-45e2-a939-ce24c50ad173',30,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2016-12-31',0),('90eb6d4a-44d9-49f6-abae-e6e29791851e',NULL,'ac9cf706-1129-4ec9-98de-35e2e3406708',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-01-31',0),('914c211f-d466-47ed-90ae-718f0fe373da',NULL,'9b41758d-7e48-48ec-b404-68266f47a57d',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-02-28',0),('91be3120-b693-47a4-8d2d-48a9861782c1',NULL,'bead6344-7eff-4998-9733-67ba6c78599d',50,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('9215faa5-c9f0-480f-8cad-fd8cddea4720',NULL,'16861364-78e1-4079-8250-3653ad9e75ca',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('9224219f-ab0b-4941-ab17-238152d806b9',NULL,'e3b20e37-4d91-47d4-8558-99491bb737fd',90,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-12-31',0),('923e5b80-307e-46b6-afb3-bdd59e6ca8cd',NULL,'a576e481-1a6c-4809-b47e-2881bf29e1da',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-12-31',0),('9275f3c5-eddd-453c-9d8c-559af388c404',NULL,'59edbac4-7aae-4008-817d-eeeb02bd28c7',50,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-01-31',0),('9318eb3f-8566-47b7-afd6-d816888b9c3a',NULL,'9bdd597f-80b5-4660-8436-1c06fcf1a281',1,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-02-28',0),('932bf238-fbdd-446c-8a6b-10350b83f0c4',NULL,'275f070a-ae3d-4f29-a882-cd6bd9fca7e5',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('934dfa12-9184-4a85-9a3e-435ca017f5f9',NULL,'4542439b-97fb-4d26-8536-8feeb4dfc137',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-01-31',0),('937cc500-21d9-4215-abd3-c1acfda0e2a9',NULL,'45244017-1aa1-4e0a-9540-5006fef47712',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-08-31',0),('9394c257-a370-4407-9a88-61cb5751e3a4',NULL,'8af03560-3305-471c-8325-9b7acff96352',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-07-31',0),('93a8936e-c09a-497b-8c46-a5b63b8c492e',NULL,'964743e6-56d8-49bd-8441-67ac6fa3b795',70,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-12-31',0),('93e77e4f-4100-4f86-861a-3c3f9597e7f4',NULL,'c7e1658e-5de0-4f84-9b17-5d4aae07c76e',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('94765c7a-ccc9-4845-85db-ce37c009fbb2',NULL,'bcbc9ffe-fb49-4c43-bb91-85ddc9dddb71',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-07-31',0),('9497030a-4452-4d8f-909a-d0129e5bed32',NULL,'f22d2038-bf3b-4868-bdfc-c963a6e5c5ec',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('953f7e8a-344f-43c9-835b-06e312051379',NULL,'6f5dda22-2d2b-41a1-a350-3199c935c163',8,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-05-31',0),('95e65d09-8b03-4c1c-baf8-d50f6478903c',NULL,'c52ad20c-a94c-4cd5-aa1d-9ca21062c369',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-07-31',0),('95eec2c7-d347-46f4-bbdc-49e50b6189e7',NULL,'e6e9b82a-d5db-47d2-b2c8-d92f49d03713',50,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-08-31',0),('96737ca2-5d1e-46b9-a851-6269a0e057ee',NULL,'65cd8f3c-3823-4bdb-8c3b-1bc6f0430048',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('9705a3f5-f9c2-449c-ad65-537206f9c1d3',NULL,'58bddaf4-9a09-4467-a875-076afa91c497',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-10-31',0),('973f2355-2669-4c6d-8ebd-570352325556',NULL,'7fd16ed2-3b51-4d09-b5ed-4bad37a4f0f4',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-12-31',0),('97b62701-6356-4037-91eb-11d5fa07b51f',NULL,'ec29bc77-685a-40ae-a6fd-2c7f6eecd9f4',9,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-02-28',0),('97ed8ab0-1e7d-42d7-b88a-5536fc054250',NULL,'0dde6cd4-61ee-4ae4-b272-7ec50af92bc8',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-07-31',0),('9855afaf-c037-479d-8c10-a71461daa0b2',NULL,'de8c5b61-d15b-47dd-8cc2-a4a75be4c43b',8,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-01-31',0),('9856e8b4-ea4c-497e-b990-850851e85bc9',NULL,'94d89cc9-8269-4c90-b501-bb4f85d23f81',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-02-28',0),('9956fe24-7846-48e8-828a-731f99a5ae10',NULL,'e599645c-8615-4d84-ae88-b7f9e464feb0',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-07-31',0),('9a2ccf19-0ee1-4513-9671-7ab6ea0ea719',NULL,'c770feb5-f73f-4dda-868b-5577dbb125aa',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-03-31',0),('9a555480-75ae-44cf-af02-70abc300b3be',NULL,'db75c674-4ed2-44ce-bcd8-e1d3a51625fa',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('9ac49674-8b82-461f-8b18-51d1ffff19a8',NULL,'c04fb5e7-4366-4ed4-8427-e788be8af7a5',50,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-02-28',0),('9ae1fa62-6181-400e-8451-ccd7817c0193',NULL,'7da6917f-afda-45c7-a879-2eed000bfc5b',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-11-30',0),('9b2063f8-3018-4233-a826-61cc815b7543',NULL,'e090d829-4bf3-4c32-9cd8-78d1ef511b84',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('9c5ddff5-1a9b-480a-b62c-c522a223c491',NULL,'c5b2399d-dd5b-4657-8634-a29f56a6ab61',31,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-11-30',0),('9d08c4ca-4f8c-4d6d-82d8-19559645447f',NULL,'c2ba0874-6005-46c2-ace4-3ab3ab318a79',316,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('9d1c3c67-ec63-487c-b27a-aedcc34f8aaf',NULL,'084ecea3-20b9-47fd-a75b-b5bc0f6cbd69',25,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-11-30',0),('9d1ff2ff-93cb-4ed5-951a-fb5603a7edc2',NULL,'fd971fe4-4fdc-4eeb-97cb-b7d8f2853c50',5,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('9ddba299-47f8-40ff-b968-ae64dac1137c',NULL,'30176b2c-1c16-4774-9e4a-724306b412d3',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('9df89159-8516-4a20-b25f-349d432e62ac',NULL,'218005c1-4b36-4d3b-8b5b-5d4c6eb88186',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2021-02-28',0),('9e333672-4572-4847-96a6-52d9f6f7b3db',NULL,'9f9deb9f-6bff-441a-8f97-d5caca47ffff',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('9ef981f4-841e-4010-ab19-0fd76263e592',NULL,'3d56278b-58dd-4f82-9169-d8a478a21b43',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-01-31',0),('9f9db826-b22a-4bef-a551-3c88bb4490b2',NULL,'43eecce1-b6f8-4ed1-a8f6-3f029d3bc1d6',140,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-06-30',0),('9fc9c787-6031-4804-9975-7004cb4a06ce',NULL,'591dd6bb-f2f6-4b00-828f-5f7a869f361d',50,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('a044cd01-08bd-4134-84ed-b88448df12c1',NULL,'0a9a2f8d-36a7-45ea-9e2a-67b9fa59da98',50,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2099-12-31',0),('a06f6141-b159-45ff-9b14-7ec3af90d8ff',NULL,'a51eaf49-7f7f-4e87-a3a2-d0099ca70880',20,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('a0af4543-b3f1-4908-a965-63566a625c9c',NULL,'8c857058-ba14-46fd-b220-4cf196a557d1',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-03-31',0),('a15532ff-6c41-435b-9ec4-d9765b8a7406',NULL,'b7356652-f9bf-4916-8040-ed670178da93',1,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-02-28',0),('a171c08b-9c32-41cc-9499-703440a5b80f',NULL,'e93254d9-a933-43d9-b552-a0809afa4da2',90,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-01-31',0),('a20e8356-c1f8-4724-b1ea-570c145bd241',NULL,'eb392a11-14b8-4e54-a103-6ca7b5fcfa1c',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2021-03-31',0),('a2f6a947-cf17-40af-b0c4-34ba2c7ad471',NULL,'99d42967-f9d7-43d6-8667-d98b9f3d5944',76,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('a31b5cc8-9404-46bd-ae6d-2c0d70612b18',NULL,'37cdc631-a446-477e-b477-5f6d3568add5',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('a323220e-a180-464f-a6cc-6d32961749b2',NULL,'60725462-8375-40e5-8b76-2b92291b91a2',12,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-12-31',0),('a385d5ee-57f2-42d6-bb38-71999d6e7329',NULL,'3955cea0-71f2-40e7-a1c0-f30bcab88250',25,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('a472ed2f-e079-46a5-8861-0f75f7422d0f',NULL,'f9264f22-8676-4d49-bfc7-cc4f30adbafe',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('a4ffaf10-7577-443b-aded-29c3443c5646',NULL,'9b8d9856-f332-42c0-8400-ab7318cdd351',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('a5cb7ec0-5fe4-41ad-a8f7-66b35e8cf21e',NULL,'62d86106-b325-4359-b9ec-268e745553ed',25,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-06-30',0),('a62a5fc5-24b1-4992-a13b-46d16989e38d',NULL,'4ea9c4ef-d4f6-4754-94cf-d612c7ce9e6c',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-01-31',0),('a6e72a9f-7a8b-4c59-b6d4-4635470e9632',NULL,'1c4909bc-5c44-4efb-aaa7-3d0eb384c349',12,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-08-31',0),('a7080366-caa8-42e8-92a8-2255000fcc79',NULL,'2a55be02-7190-41d1-8726-90bccec8c4b1',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-03-31',0),('a72c0b03-bc78-406f-a4fd-c8cd53ad827f',NULL,'05b1a7cd-af33-4b66-97fc-8e799dbb9233',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-01-31',0),('a7f389d4-315b-45dc-a225-c395fa7bb5c9',NULL,'a98f5afa-f5c0-4922-a065-0d2f5f68001c',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-11-30',0),('a7ffa9e0-e9cb-400a-b852-b70c9ef36c62',NULL,'46d3047b-e587-4be6-8282-58ecba0fed31',25,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-03-31',0),('a82a71b1-4f19-4666-ba02-9a89ce85aa51',NULL,'e40889c8-9ad8-4ccf-b2be-b2deb2ca6964',84,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('a85d0a92-b9e8-4803-b4fa-05759336f072',NULL,'0bd09974-0132-4a30-98ae-ac6d2f95cb0b',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-02-28',0),('a866255b-3940-40ac-b221-1ca3fe5f3e69',NULL,'0db1619a-3d5d-4dd2-a294-af7ab18f09a5',12,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('a898e21f-3a73-4298-a243-acd9b3cfeaeb',NULL,'590bc58c-aa06-4cb8-997d-b7abf367c28b',30,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-07-31',0),('a8c51b25-b0a3-4948-962e-dfe22bfa3838',NULL,'1f908ff9-e0bb-49db-91f0-d098e5661987',5,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-05-31',0),('a915e3eb-2682-4fe5-95ee-bf57e0cfe178',NULL,'e49bac38-aa20-42a8-b709-d07fdbde475c',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-10-31',0),('a9499b36-e1cf-4904-85cb-66fd90c14fa3',NULL,'7c3e6810-d2a3-491f-aaaa-df23bc921154',12,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-12-31',0),('a9a2b51f-83f4-4e02-9d3c-8a8c6105b269',NULL,'09fb4270-b803-4287-ba6b-6c2d1fa0a2b8',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('a9e699ef-377f-4556-ae64-79a394323fc5',NULL,'8c2d9e22-6bc0-4525-8c22-3fb3d74077ab',5,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-03-31',0),('a9e70256-9e90-450a-abb2-098ee3042860',NULL,'52bb3edc-e029-4ced-8e97-2e2afc53a71d',3260,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2021-07-25',0),('aa0ef96a-8b68-404b-9227-2c2421c1cdf9',NULL,'6437460d-aebc-43e0-9172-ad29b40444ad',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-07-31',0),('aac05d9b-32c3-4a32-a4e5-53acd67a39c2',NULL,'eb415c97-7236-4ac9-9a09-944282ea9575',1,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-07-31',0),('ab9f9313-7025-436a-b6b1-f452d49bf578',NULL,'bc3117b5-90f1-40fa-bc79-119f1708f934',19,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-08-31',0),('abe36f3f-ddb9-4783-984a-eaed5e7ebdc1',NULL,'e2b230a9-e241-486c-838a-edb2493bdd5c',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-08-31',0),('abfa9cdc-55a9-4c31-b269-9efc3b6fdead',NULL,'a95f63f1-1949-4f90-8e3d-ff5b4e7e961a',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-11-30',0),('abfbb5a7-243c-43d7-8935-c94afbb58398',NULL,'941fa182-a1cb-4490-89a6-4ec3d660dee6',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('aca58130-a654-44dc-8361-2ce2c76e7724',NULL,'7445ba41-b22b-43b4-9430-6e085dc47bb0',12,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('acaa2ff3-010b-4531-b140-39f5cf835e7a',NULL,'89fad77b-ec05-4e93-98b7-2fbe43971f7f',50,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-10-31',0),('adcbb549-1b81-4f5d-a0e3-2d4a098c5d82',NULL,'e88437e1-6136-4b3f-a144-3af04b68d0cc',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-08-31',0),('ae224412-a758-49ec-a3b4-759e02736d34',NULL,'dfe53a5f-f3cd-4930-bf99-2ef553ea9cba',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('afe81497-1f6b-483c-8370-819316724a54',NULL,'bbcc0daf-3f4a-487a-b797-d6b2552c97b1',1,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-08-31',0),('b051b980-f57c-426e-90aa-ef3f6e55340e',NULL,'94e09848-c3cc-4302-89eb-25b1e4a7880d',12,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('b0fd5b70-4207-4df8-b00b-019dc9607b16',NULL,'433efd3b-65e9-4918-9b26-586aabdf8b9c',20,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2021-01-31',0),('b1d8edf5-e25b-470f-be78-f40c6b140280',NULL,'e6ca4f92-bec8-459a-85ca-9d71e75bf137',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-05-31',0),('b2790714-c21f-4605-83d3-3e5533ef4a32',NULL,'b475997b-5fd6-4f4c-9333-7c96ca4367a9',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-02-28',0),('b31046bf-08db-480a-ac4a-b0f3fefe0d43',NULL,'d62b1240-3a2b-4a40-8db0-5cd165cfa8f3',25,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-01-31',0),('b35313d9-7438-4948-8bf3-2be13e82cac9',NULL,'0aeeef06-348c-4b67-8750-5101f00a3f2c',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-08-31',0),('b36bd0e8-d218-487b-a9de-329231ea90d7',NULL,'c247ed0b-33d9-47b9-979c-4577f8b55f05',30,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-02-28',0),('b399129e-74c5-4387-992a-e171d94939ae',NULL,'c1ffa627-94af-4280-b9ba-8860742229dd',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-07-31',0),('b4032d5d-d230-4fcd-9da7-2e904c5f6639',NULL,'a4dc0839-9fda-45ca-ac7b-7c510434d303',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-06-30',0),('b49b6e0d-6e4b-4a53-89db-349976b3de11',NULL,'2c1f9606-af8f-42ac-ac91-9eb2f322f5d4',150,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-12-31',0),('b4b617b8-245c-4cdb-804d-7b4388e0823b',NULL,'3484a9b2-c960-4a19-a8fe-5a71bc8d2e74',90,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-02-28',0),('b58bbdd9-98ff-44c0-bb91-842248f580af',NULL,'3c4fcbe7-a749-4756-8385-27ec1f53c6ee',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-10-31',0),('b5cbf65e-a859-4284-8d57-7214aae4fbfc',NULL,'a49fe108-ce17-4da1-862b-23448b62fa99',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-07-31',0),('b69fe52b-2387-41b0-8dd3-483d66bdbe21',NULL,'2f49b0a4-86e3-4295-8f55-2fabd91b30f7',5,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-08-31',0),('b6c96ee7-6b41-4087-b219-726e803cf96d',NULL,'8c0032ee-f608-456f-8986-850db19c98c2',145,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-10-31',0),('b6fae79a-ccf9-47f9-957b-4dbc7d569fa9',NULL,'5c293368-1897-4eb3-9915-e1cf6351d918',80,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('b815c39e-bb9e-49c4-8239-8d546c0804bc',NULL,'05f6c643-47dd-4a0e-9e60-607c5a72e2b1',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-03-31',0),('b8a3e845-9890-4e8a-b816-af157a02e125',NULL,'99574587-106f-4cca-8241-5ee3aa395b1d',90,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-03-31',0),('b8c45ab3-a43b-4e5b-866a-a9e619862363',NULL,'e4226aff-9dc3-4214-bdd7-3db1100093b4',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-02-28',0),('b8e19289-54f0-4b03-bce2-7eddaca2723b',NULL,'3e28f39e-bbcf-43c6-88aa-f5c29c3b2307',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('b9192ebb-945e-4eb5-8a80-25925d6f9ff5',NULL,'44b4fbde-329c-4d62-aebf-e51e7317bf76',902,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-12-31',0),('b91ee26a-fe0b-41ad-94de-6cce33aeea70',NULL,'d9fa83ac-a786-4d41-b318-18c3a8acb8ff',30,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('b933f437-b6c9-446b-9857-907b33a750a6',NULL,'30a807fc-2faa-4c65-ab73-4f2f78ae9ced',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-05-31',0),('ba188121-6ec4-4725-8b3c-7297c6e7ecaf',NULL,'9d42b826-2089-429f-9f97-e686e146bf08',50,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-05-31',0),('ba2f2661-b21d-4524-bc74-81a08bb6d06f',NULL,'44315dc2-e2fa-44dd-8de8-8330ed4de153',60,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-10-31',0),('ba339b79-b82e-4160-bffe-576c98b19439',NULL,'88279a62-e47f-402f-8a4f-009765ad102c',170,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('ba5a5c26-4e30-4a5a-bed2-0578c5db0f73',NULL,'a009032a-47ee-4ca2-99dc-ca8576c39bdc',150,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-03-31',0),('ba660916-f084-4518-940e-ed3755c5f24d',NULL,'5e3725dd-9e90-41d5-834a-80bfb0b40a79',5,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('ba95b91f-09a6-4d8e-b60b-e285ca523d2c',NULL,'723ccfad-6157-4421-9647-3aa8fc6d4ada',30,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-03-31',0),('baf635ee-2560-4853-a187-bd8d0552a69b',NULL,'e8c6ebc2-4883-4850-b365-b2875c00f158',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2021-02-28',0),('bc3380a9-3bcf-483f-94d1-0c6b3fbae9f1',NULL,'5790faa7-4875-41cd-be5f-b17b890b1393',80,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2016-12-31',0),('bcb90092-4d81-463e-833f-437f26dc6ab0',NULL,'17d09027-7f78-4b74-aa2d-4f19102f3abc',70,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-03-31',0),('bcbb7753-09d5-4356-9ac6-126adeed243c',NULL,'3c961304-e675-4a2a-bd21-15dbfb7297fb',18,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('bce5a084-8706-475d-9158-dfd398c12d84',NULL,'7071cada-b946-433b-bf14-87dd877b3ab1',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-01-31',0),('bcf93d71-bd55-41f9-956a-32e5310a678a',NULL,'8ecd4d6f-3bf9-48bd-8cd9-a7b392a8973a',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-06-30',0),('bd037f17-c351-4a2d-81c7-889b725fb7e2',NULL,'2cf89940-2aa8-47d1-b496-00aac722bcee',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('be46080e-03dd-40b0-b8c3-cb3512d2cd1b',NULL,'e7e27f01-f901-4fa0-88df-2ff7d8eb9d26',90,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2016-08-31',0),('be88410d-1b4c-4cf5-a5b5-5f5ed8672425',NULL,'d8f244aa-5e52-470d-813e-9d856a95c577',300,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-02-28',0),('bf86d0bb-617f-4f4a-9af1-aa628a14a5e9',NULL,'69a092a5-158d-44df-90c8-025ce8f26d68',60,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-12-31',0),('bfa2c60d-289d-4670-84a7-20f25c704075',NULL,'39832a2f-9e73-472a-910b-4a5e4081ce99',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('c13aee29-8f3a-4c0c-9055-89d8450d01e7',NULL,'88de4ea2-80d9-4152-91aa-4817f82e8f89',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('c17682b7-a238-42a9-83f2-d6d1502f8d93',NULL,'c792c260-f339-4bc5-8647-ebee072b58d5',5,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-03-31',0),('c18be712-151f-4732-be26-0434780bb699',NULL,'6c9f3ce2-358a-4b37-8794-43ab3788b58c',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-08-31',0),('c1a128bf-7279-4e47-b71b-a50a6c82fe28',NULL,'280f4a60-3587-4a87-b219-c75d42cc6534',12,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('c1ad9d6b-7770-4995-9e35-07a01e064154',NULL,'6b0abda0-9adc-409b-94a3-e7b6723c4be3',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('c1bef2f4-9e6e-4610-88e0-5470a69cbd8e',NULL,'8fb05868-bcb3-4cbb-ace3-a7927e243a7b',4,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('c1f8df1b-0375-4cbe-ab5b-ce724b14106e',NULL,'fb09b5bb-4361-4bd1-a72e-2618b1347f50',12,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-06-30',0),('c28759ff-96c0-4679-b28f-2d0d55e69678',NULL,'706f8cc4-f647-4992-87c8-a17a2ec549f2',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2021-01-31',0),('c3f37e0a-c135-4d14-bf90-2948d9bbcada',NULL,'3c19cf31-4728-4f15-b413-11413f7181fa',50,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-03-31',0),('c519be05-d1c1-4ed3-944c-5df9a95e9ac4',NULL,'44be9244-8a08-401b-967d-785cc71d6a3a',34,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-10-31',0),('c51c3ab1-21de-47d5-ba0a-90eeea564ac7',NULL,'b3437189-8abe-4895-b6e3-f09f4a0fca5f',7,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('c692c7b7-0894-4a1a-915d-c170a0670f05',NULL,'7cb2bdf0-f0c3-4588-9798-541920f448a3',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-12-31',0),('c7bd8d8c-1265-4aa4-a1d4-a9c55e532e70',NULL,'7e21826c-82b4-4d84-82a7-b2b77078a96c',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-08-31',0),('c8014cf9-deb6-4f05-86a9-37165ed9bfc0',NULL,'b799a494-fbd0-41ad-87bd-6929ceec4043',30,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('c80942b8-cd9f-4595-95a7-288e59e564b7',NULL,'5abe998d-42be-49d3-a2dd-2a2aff059473',7,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('c82f5af9-7dc9-4930-b70c-1aca0f72f0d7',NULL,'ee3f7798-3a92-4dae-92c4-804317e4f8bc',20,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('c83e4621-8b69-45b5-a258-655e6df340cc',NULL,'c267f236-325c-41f6-8a46-56763ecd4b12',20,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('c861d9eb-70d3-4e0f-ab11-a75015c27b24',NULL,'c1b5c607-f976-40c3-9c8c-7a53d31fbabf',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-10-31',0),('c962a5dc-0f5a-4c35-9512-255aaf885b7b',NULL,'4e6b8e5d-2296-42a4-9cfc-35b0907fcdd1',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-10-31',0),('c9858441-524f-41a2-85c1-ad03b7641916',NULL,'71f37d5f-4a06-4757-9d36-e1691aea628f',24,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-07-31',0),('c9ab5e30-9fd3-4edf-885d-d63a5c1bddd2',NULL,'d60f5ae5-e8bf-42ca-b6e9-d6c8d818b875',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-03-31',0),('cabe4e01-244c-4172-897f-489cb1998ee3',NULL,'3252a452-2840-427c-9a77-2107111ff6af',11,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('cae73e4a-88be-4f7d-97d4-e0a4a0470ad6',NULL,'a8e411d5-e8c0-4648-9ca7-bbe90db1f4a7',1,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('cb1a3d28-9c19-4d76-af76-474a9c47b9ee',NULL,'8f7a2349-7fc0-45d6-89a0-792d076077ac',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2021-05-31',0),('cb33799d-5025-45ad-8824-b211a0cd1fe4',NULL,'986f7ca9-4ac0-4350-9b3f-a8d37aaead04',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-03-31',0),('cbb833a7-76ae-4639-be47-9a40e7bdad49',NULL,'9e8cc1ec-e2fe-41c1-af4c-ed7aab6c0df7',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('cd38b54e-8561-4e2e-90f7-fe8e5c5bddc8',NULL,'d0449520-ae74-4735-a545-e21a949f1031',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2016-10-31',0),('cdcf9f10-d50b-41cb-9d21-f9bf1ecf7552',NULL,'327685f6-7192-4d97-9e74-a3d82d88482f',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('cf3b4d55-0b13-4728-b35b-03293a8b9ce3',NULL,'0c4e33f7-256a-4275-a268-cdbf64495451',27,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-03-31',0),('cf6fcebf-aa68-40b2-b803-1928eecf8355',NULL,'be82505d-7012-4894-9797-5de0cbd3c1b8',5,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-03-31',0),('cf712f3c-e8cd-4c67-89c3-300141936a34',NULL,'b48edec6-7d45-4685-ac79-67d694fe6981',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-03-31',0),('cf77bb44-a160-45c2-a5e4-56fc18eed1b3',NULL,'25310c3d-2ca0-4dbb-9b8a-7d0c3754b11a',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-05-31',0),('d0a81c0e-8fc5-4e6e-94de-765de1df905c',NULL,'4631afb4-5070-441c-8577-a4a546362f3c',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('d0d453a7-2f80-485c-b8f3-31b549a5cfe8',NULL,'29aaecee-60e6-40ca-813f-91cd2156c033',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-10-31',0),('d1267cde-4744-4174-a481-611bf35c98de',NULL,'04715b9f-36c0-4c0f-9377-a8f4b42dadff',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-08-31',0),('d15aa3e9-060b-4368-b315-273f98e52797',NULL,'561e3e8a-72c4-4cc0-9a4e-55af1ee4d97a',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-03-31',0),('d1ea2dfd-ea07-44ba-9207-6f7befea0013',NULL,'48196acf-26db-4a60-b7f0-7377d408d8c4',55,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-06-30',0),('d2781073-9131-4cf8-bc59-3bca51df4720',NULL,'3fc3e6ff-2011-4022-bd3a-6c826cbc2411',80,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('d37a6e0e-f2d7-493c-82cb-4a5158286270',NULL,'70bc2b1a-2985-4f27-a201-38796f2b5fa5',15,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-03-31',0),('d4696024-5082-4f7d-9c01-7261078c1f8a',NULL,'e308ba64-e78e-4228-93d9-24a081bef865',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-03-31',0),('d49fb219-5ac2-4af5-8914-58b63ce197ef',NULL,'88c9f4f3-663d-48cc-885a-3c3a40389307',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-12-31',0),('d4b269bb-e0f7-421e-b860-1de15dea7628',NULL,'2b63d0e6-50cd-434f-a88c-dc2c40d3f1f0',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('d5e8661c-1014-49a7-9ec6-10a8619df260',NULL,'6e98c5ca-3261-495e-89d1-4a46156ca08c',130,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-03-31',0),('d67431fb-9a15-4cf2-9920-32ddecf6e3ee',NULL,'2816962b-cceb-4941-b477-977ba800e72d',25,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('d682b652-1dfb-442b-82cc-56338d8c47df',NULL,'cc980e92-7d48-44d2-af07-2c9f66675e5a',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-11-30',0),('d6be1c7e-4621-4969-9b4c-74f7f7e30e96',NULL,'a39c3b64-9c5d-4824-b80a-f5cf58c5297b',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-06-30',0),('d6d34b01-43c7-4e53-b09e-e4086fb5e454',NULL,'407fad1b-31fd-41a8-9e2e-26e407355981',225,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-05-31',0),('d6eb6b4b-2902-43a6-940e-74c112116240',NULL,'74a69361-60e9-4af8-8765-eac724021451',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('d6f6d1c7-e552-41d8-95c9-605c4aed087c',NULL,'65226da3-5150-408e-94f0-dd3c4eb90443',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-11-30',0),('d81a41cc-72c4-4a37-99bc-a35507667e22',NULL,'5f70495e-f309-4199-a38c-8272f1267a13',940,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('d847806a-5b9f-492f-8618-ddb6dbddb6d7',NULL,'626b88e8-5e08-437b-b5e9-649a410fac46',50,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('d867181b-643d-49fb-afc7-1c74e39c43c2',NULL,'140830b4-4847-445d-b32e-6ff9a315acf6',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('d8c063a2-3c35-4311-9490-3db055aeb0dc',NULL,'e4a44977-647c-44fd-b0d2-e6a3a566288b',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-01-31',0),('d9698871-c3b6-45f4-8ed7-82f45eb6b90f',NULL,'62e4d93e-949e-4136-9628-cca17c0eadd9',60,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-02-28',0),('da1036f4-ab93-49bd-bddb-932ee14db317',NULL,'29c26422-a1af-4fad-a14f-c5cf4550671e',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('da4e372f-ded1-420c-ae5a-ca6a2bb78e1b',NULL,'65452f02-fea6-4557-b2d1-16b5c7cb699a',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-08-31',0),('da67385f-f8aa-4b08-8293-8f6f162c6f86',NULL,'5b57adca-ba56-4bca-8f04-28e81565e91e',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-05-31',0),('da776562-4bda-4915-9a88-9b0992d44574',NULL,'71c2099c-5089-4be3-b714-5f53900cb009',240,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-03-31',0),('da8246d2-4b40-4a62-b6db-814a031f1efd',NULL,'5aef0cff-d054-45c2-a26e-98e57f13544b',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-01-31',0),('daa1079f-88a9-471c-9eff-712cc8831914',NULL,'18315342-7f0d-43e6-8710-71ce095f0f5f',80,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('dafb0c71-c423-4e75-acea-02be4c56b5c5',NULL,'6b42eaba-807c-4697-918d-e5d432bb83f2',9,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-08-31',0),('db000d4b-57b1-4862-b735-7e6b25b7c172',NULL,'2a3c9db2-6252-46a3-a3fe-57523bd96c01',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-02-28',0),('db050ca1-e66e-40c5-a7b9-8f92b838d2f4',NULL,'f499b6ec-2027-4ae3-a9f8-7d750045122f',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-10-31',0),('dbc6437b-e470-478b-9015-c853c11433f9',NULL,'b39aaef8-7805-4f05-9381-afec13f53977',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-08-31',0),('dcf0e528-ac51-4ca5-af3c-79a30e355e58',NULL,'0d95cd28-0fdb-453d-9a8f-3c02d52557ee',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('dd0ad2f0-f089-4a16-b284-0aa0b19a42bf',NULL,'b1e8d539-2fa7-4c11-bb0d-b6889fb8bced',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-01-31',0),('dd31926f-23f9-4955-96fa-e1639bec9461',NULL,'6e5cc3e8-2eab-4709-b6f6-02ffd02ccc99',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('de079dc0-9547-4c1d-989b-3126934d4ab7',NULL,'e75543d4-2e88-46ea-9c86-6f81cae97787',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-06-30',0),('df2de27c-b9a2-45f1-8a02-4751baa39f88',NULL,'87c22b7c-7853-4de3-9c4a-8fa1d955ce8d',500,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('dfd52d0a-996b-4ced-9a95-6e55af0b671a',NULL,'2d3ab83d-cda0-4f36-8974-c4f72b10cd20',300,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('e0065e38-fc57-4eec-a39d-d9a569fd7cf4',NULL,'7d2e8892-f80e-45f9-9a73-56d590bc0e87',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-12-31',0),('e043e219-4b98-4cc9-949f-723800e85d4e',NULL,'39ec1054-d8a8-4e7e-84fc-984740b0f8f2',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('e04f7453-e3e9-440f-958a-f19107aeb23c',NULL,'75b4abba-6596-457a-af5e-c2e9d257c28c',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-03-31',0),('e08b6622-6def-4f40-80a3-2e865ddb8b8b',NULL,'4462502a-223f-4d8a-9814-1ec1a96574c4',30,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-11-30',0),('e0e3ed3f-ff71-4b0f-b3b7-d7ade4bd22f2',NULL,'43afb9fc-1f57-4e00-a93b-bf51de20e7e1',15,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-10-31',0),('e1430c3b-9dc9-43bf-a909-2808b93b09a1',NULL,'6cbf8685-c3bc-4bd3-9dfe-9edf3a0eb35d',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-10-31',0),('e1947f4f-a6da-4720-9e8f-8c1e82da4fdd',NULL,'dcc86b92-d8d3-47bd-90a7-56deb8051b95',190,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-12-31',0),('e197cf42-e7d4-42d4-a9d0-2f784af0d542',NULL,'02969de9-2b60-4a29-bbe9-563ebd952079',24,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-02-28',0),('e1eb3214-907b-4c11-b466-50d6c4a87827',NULL,'b268586d-4579-4679-b24c-8ba634cac4dd',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-02-28',0),('e27513ca-7d08-4479-a3c0-d4162c5d98d2',NULL,'7402a1f5-7001-4009-a5c4-29b9e09f7a56',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-08-31',0),('e3859858-019d-41a6-9375-851e25810325',NULL,'3e9aef4d-7b15-4cab-9e07-84245b9a7090',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-03-31',0),('e4669fe1-4e1a-4498-afcf-74cae3914dda',NULL,'b77080a1-4dbd-4923-a5b5-bcdf7795740d',360,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('e4713e61-8237-4025-8243-840211075b1f',NULL,'8a47259e-e3d5-461c-bc20-184270f4f11b',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-11-30',0),('e4ecc162-cf7e-413e-9cd5-eb6de9a65fa2',NULL,'822121a6-1bd2-4bea-8e30-109fc6d72492',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-08-31',0),('e52dd51f-d44e-4a1c-9f27-e22bf425f9a1',NULL,'3cc43db8-3894-4bc1-9c71-a199f253e1c5',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-03-31',0),('e55c3965-66f6-468c-9a7e-1d9913fd09b7',NULL,'565834a0-66bc-4d40-84ed-e3c96d4fc77f',5,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('e6332f84-0cae-43ec-a847-b78d5a3699a0',NULL,'a73fc586-4831-41db-b1be-992e4b8a1687',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2021-03-31',0),('e6a654fd-b073-43f2-8057-4b2987bc1e42',NULL,'c8d40fe1-4615-48ca-84ac-2a08faa62232',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-05-31',0),('e6f68c09-b74a-4abc-ae3c-225a42cdc845',NULL,'78f0d0d4-0f97-41ad-b2ef-59bca9b38470',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-02-28',0),('e810a75f-611a-49da-b9ff-cc127d61aeff',NULL,'f1ff98e2-3203-49de-a537-0e22f16d8e3f',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('e81719e0-1a59-49dc-9745-ee9131c453f9',NULL,'ba451c8c-1999-4ee2-b4da-3e52f18e109a',200,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-01-31',0),('e8281c1c-d097-4aea-8f60-a1330f40bbb7',NULL,'ee715dd7-b854-4c08-ba5a-17e0b4ac8add',5,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('e82b4f4a-66f4-4ffe-b6ab-ec0a6e19a203',NULL,'ed875474-f3f2-4d79-b94f-9db4b3fe5ad0',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2016-07-31',0),('e84c669f-8286-48c6-be5a-960ab12ad6f9',NULL,'ce29f97c-702e-4ef5-a941-fee79081fe66',25,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-12-31',0),('e875045e-27a9-413e-9d57-8e1164aed14a',NULL,'552a43b5-8cb6-4d1d-94f3-1d85131a3d33',25,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-07-31',0),('e89ebc04-cc22-4bec-b8e3-7192ed2a2a18',NULL,'756a6964-9037-44fc-aa3b-ce6dd9cd062d',265,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-05-31',0),('e944e94d-7a93-469d-8234-d62579c7bfbd',NULL,'6f029a46-7aff-4d7d-be04-13e5b1f17e8f',80,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-02-28',0),('e9ed0185-37c7-4a71-8fdc-5e0acc991862',NULL,'f9a025ce-bd2b-4ae6-b627-acae3d66bdf1',60,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-10-31',0),('e9f8c944-e072-4adf-819c-8cf5578a4e2b',NULL,'66c61c70-fe7e-4b9c-b58b-72766e0d8413',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-01-31',0),('ea600720-fef3-4c59-8bee-6b0fa04df91e',NULL,'17b97205-0022-4a3d-aa41-9c715ac072dc',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-11-30',0),('ea8e25a7-e1d1-484c-b548-e5a1ffce3589',NULL,'7490d418-9e65-4162-b095-3706d98cec65',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-10-31',0),('eabbd347-9383-4fbd-9ff8-e87b0fdec2c7',NULL,'7de23c6c-a740-4950-9dc1-a559453a4ca6',185,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-06-30',0),('eb495f0d-0fde-4856-a103-96edbec6872d',NULL,'c5ce14c5-1410-4628-8421-e378e664a208',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-05-31',0),('ebdf63c8-4bf9-4ead-805e-7ab6c698b1f9',NULL,'f91c5830-2808-4e6e-9c23-320a015d0308',30,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-10-31',0),('ec228c87-4b03-4c6a-a4d4-3ff45947b2be',NULL,'f75d973c-f0b9-4d48-aa08-134e55c5c37b',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-03-31',0),('ec7782b9-9e7c-4231-926e-0a54f485752d',NULL,'6c07f9de-da43-4f10-b6df-1fc86d407e83',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-03-31',0),('ed43e877-8460-4d7b-8c7a-9ce564f50172',NULL,'1e266883-c6d2-41d3-8c11-cea3402a4948',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-10-31',0),('ed6c1a30-5c73-42a1-a502-bd83df07f664',NULL,'60b2c200-fffa-4abb-bd81-b0f0a7cfbb2f',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-10-31',0),('eda472e7-fb00-48d4-a652-c541888039a2',NULL,'69848a12-92b1-43a8-a17a-7508e5065415',18,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-08-31',0),('edabadbc-cdf6-4f86-9071-cabf01e129cb',NULL,'744997b4-9d98-44f3-8eff-6ed0583b6be1',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-02-28',0),('eeb2fd59-9203-410d-9956-4b3938b06a3c',NULL,'1706fcfd-6788-4c63-a45b-bddb2c7da5a0',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-06-30',0),('ef0fc540-5077-4b9c-ae27-19ac0bea059e',NULL,'4b062d45-5166-4864-88fa-3b8fe398a933',200,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-02-28',0),('ef264077-8d34-4836-97c0-21e34166312b',NULL,'0d3e03de-e3a6-41f9-99f0-f53f1764c3fd',12,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-08-31',0),('ef495e24-3aa9-42fa-b490-e8ea4cf719bf',NULL,'e2cf3f60-28f2-452a-b3f4-19b7dbb4caec',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-07-31',0),('ef9de750-943f-41e8-a7fd-c539dedde8c7',NULL,'8ad9ae17-93e0-49e6-8915-d346b3285e03',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-10-31',0),('efdfa4ad-6d63-428a-bd92-bda049963a81',NULL,'7e96a11f-735a-4afe-84d3-a229d863b834',20,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-07-31',0),('f062eb27-7b11-4898-9c79-403061937bce',NULL,'e6ca24a3-cd1f-42cb-b39b-f9569ffda976',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2016-10-31',0),('f11080e9-8f0b-43cf-9180-b5db3f3f17a1',NULL,'841c39b8-6ee9-48a1-9b58-2b480ad0c0d1',60,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-01-31',0),('f1126d8e-aad8-4b06-9ee3-8380a1f352f3',NULL,'2c7e34a0-931b-412a-9aa6-63af17f37815',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-10-31',0),('f11a3506-6e6b-40ba-982b-b4d9e0a6682a',NULL,'0f3778f1-cf32-45cb-b73a-701184d39bb8',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-06-30',0),('f2b2c0e3-ccae-497a-bb08-c402370f56be',NULL,'7a93e08d-12b3-4643-ac13-abb218ef0624',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-02-28',0),('f2dcf7b7-8634-48d7-811c-4744bdd83192',NULL,'3bcf2b03-f78d-4b94-9083-b6ef6ab40739',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('f386fb43-54e4-4a14-ba24-6fb3a24e7965',NULL,'70792786-2f74-4516-a571-39c9b8a3af9f',10,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('f439d0a5-0342-4501-a112-4fb0110296cf',NULL,'c7848e87-3983-4bf0-80dc-52e066e312ac',25,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('f49a9569-ab94-4a68-a4c4-405177689190',NULL,'edace783-6b08-4a15-9194-6cb363bc0f79',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('f53ab916-0f0f-4d5b-826c-032aedef10dd',NULL,'1055232b-f75f-432f-92fc-d252a55af5f1',50,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-02-28',0),('f619aa90-dd81-4a36-9989-a04e91826674',NULL,'6b2cb11a-7607-48e6-ab8d-850cb701e1c0',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('f6507e4a-ff42-4c43-91d5-8114d931900e',NULL,'8ff8e6a8-d2f8-4f90-9010-f2c74a9b803b',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('f697200a-3aa5-4264-9b5d-52f795e0eeff',NULL,'f7b6a5d2-8409-4f79-90da-be61ea52375f',120,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('f6ecbac9-872d-448a-be4f-fd171003673b',NULL,'23e015ae-9fe0-4fbd-b73c-782ebe70c2c0',12,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2021-02-28',0),('f7b0ce6b-6795-426f-9a77-fadfc56e603c',NULL,'f74b8998-8283-4843-a7d2-8e4ed5978497',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-12-31',0),('f7c4030e-2632-4f72-ab7a-9942266a7485',NULL,'e05eb9c7-ae9f-4ab0-a451-63b849918495',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-10-31',0),('f7de3011-6e21-462c-87c3-20829a5d44da',NULL,'7b1dcac2-0048-49b3-9f6d-88b48268c161',50,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('f8b7a18e-97bb-4197-8faa-7078efeb5969',NULL,'8c62ba4e-7a19-4733-a76e-c028a81c7a6e',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-11-30',0),('f93b8ad3-4127-4b1c-a3a6-8433e325f66b',NULL,'99bd428f-3d27-41e7-8604-53cc2c550c24',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('f9416dba-a084-4297-9575-aa16c8adb25c',NULL,'58251241-af23-4db9-8898-c5c598d15c9e',105,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('f94ac2d1-f3ed-4a41-b83a-84cdad8de02a',NULL,'e9d0f8af-54e1-49f9-b5e2-a19e42f0e05c',100,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('f96a034b-2f80-4811-8b53-fe1d6b648e7e',NULL,'d9542fb1-bfa9-4556-be69-60e36511ae01',120,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('f9f571b6-0de6-4357-894c-e4c5543845ed',NULL,'24c994b8-0141-4be3-a317-5d7260b90367',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('fa16b402-bf9a-485e-9b38-af9dc4823ef0',NULL,'5138aa27-233b-4d0f-bbfc-47152952a31f',1,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('fa206d6b-b345-4eee-9ed3-70259c1868e3',NULL,'f96599c9-4abc-494d-b9e1-5a95e9d04e73',25,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('fb0c5141-f617-4e71-a3df-c89429460339',NULL,'3d9d81c3-3528-40a0-a29a-a34658dc8075',2,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-05-31',0),('fb6591b0-d414-43fa-82b5-0ea6f7ae2914',NULL,'785f325c-93cd-4e3f-833a-7b448482f285',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('fc0464a2-8783-4d44-bed0-bd9f7b9d1b93',NULL,'7353aa67-3256-4ce2-9d6e-f20ddeb3be76',30,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-10-31',0),('fc724d90-3b12-4d67-9d03-8a3092d3fbfd',NULL,'41bd6355-9d61-47b9-bb0b-ceda1aae21fc',6,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('fc89377d-2940-4d95-9343-e1cecf4caeb9',NULL,'02537a79-aa55-4a81-8b22-f16f4cf0071e',170,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('fc966f7f-1d4f-4a9f-a373-0584617a3e58',NULL,'23e3d105-5d65-4bbf-a54f-fa527ee68aff',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2019-07-31',0),('fc9af668-4b29-434a-a3df-9871c2de3ee4',NULL,'940e364c-f540-402b-9228-3b00ab32c624',3,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-12-31',0),('fd95db70-a663-478b-b674-1b5ff4a83ddc',NULL,'a8138880-4276-4f9c-91c8-2a67243b75e5',50,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2017-10-31',0),('fe1873a3-61dd-4d03-bf24-13976d00e9a1',NULL,'1f82dfc0-8285-4c28-88b4-175234347c5d',4,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2018-12-31',0),('fe783212-2788-4371-9cc7-aab7fe92d5e5',NULL,'8a484956-eb83-4a2e-8591-c66825edb086',297,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"',NULL,0),('feaec4ab-6cb3-457d-8ce5-50a926be937c',NULL,'475990d7-a7ee-46c3-9ed3-ec1079542117',110,'\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','2020-03-31',0);
/*!40000 ALTER TABLE `inventory_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `message` varchar(250) DEFAULT NULL,
  `fk_customer` char(50) DEFAULT NULL,
  `fk_supplier` char(50) DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `fk_supplier_address` char(50) DEFAULT NULL,
  `fk_customer_address` char(50) DEFAULT NULL,
  `fk_supplier_contact` char(50) DEFAULT NULL,
  `fk_customer_contact` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice_item`
--

DROP TABLE IF EXISTS `invoice_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice_item` (
  `id` char(50) NOT NULL,
  `type` char(50) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `taxable` char(1) DEFAULT '0',
  `fk_product` char(50) DEFAULT NULL,
  `fk_product_feature` char(50) DEFAULT NULL,
  `fk_work_effort` char(50) DEFAULT NULL,
  `fk_time_entry` char(50) DEFAULT NULL,
  `fk_inventory_item` char(50) DEFAULT NULL,
  `fk_adjusted` char(50) DEFAULT NULL,
  `fk_sold_with` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice_item`
--

LOCK TABLES `invoice_item` WRITE;
/*!40000 ALTER TABLE `invoice_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice_role`
--

DROP TABLE IF EXISTS `invoice_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice_role` (
  `id` char(50) NOT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `fk_invoice` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice_role`
--

LOCK TABLES `invoice_role` WRITE;
/*!40000 ALTER TABLE `invoice_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice_status`
--

DROP TABLE IF EXISTS `invoice_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice_status` (
  `id` char(50) NOT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `fk_invoice` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice_status`
--

LOCK TABLES `invoice_status` WRITE;
/*!40000 ALTER TABLE `invoice_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice_term`
--

DROP TABLE IF EXISTS `invoice_term`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice_term` (
  `id` char(50) NOT NULL,
  `value` decimal(10,0) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `fk_invoice` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice_term`
--

LOCK TABLES `invoice_term` WRITE;
/*!40000 ALTER TABLE `invoice_term` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice_term` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_issuence`
--

DROP TABLE IF EXISTS `item_issuence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_issuence` (
  `id` char(50) NOT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `fk_inventory_item` char(50) DEFAULT NULL,
  `fk_shipment_item` char(50) DEFAULT NULL,
  `fk_picklist_item` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_issuence`
--

LOCK TABLES `item_issuence` WRITE;
/*!40000 ALTER TABLE `item_issuence` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_issuence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_issuence_role`
--

DROP TABLE IF EXISTS `item_issuence_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_issuence_role` (
  `id` char(50) NOT NULL,
  `type` char(25) DEFAULT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `fk_item_issuance` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_issuence_role`
--

LOCK TABLES `item_issuence_role` WRITE;
/*!40000 ALTER TABLE `item_issuence_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_issuence_role` ENABLE KEYS */;
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
  `number` char(50) DEFAULT NULL,
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
  `reference` char(50) DEFAULT NULL,
  `posting` char(50) DEFAULT NULL,
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
  `note` varchar(150) DEFAULT NULL,
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
  `fk_auto_journal_sales` char(50) DEFAULT NULL,
  `note` varchar(150) DEFAULT NULL,
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
INSERT INTO `journal_setting` VALUES ('3e16af91-d1c7-4e66-919d-3772339fb04c','4a129f6b-7b21-4640-bf78-4da17201894a','d2a96e2b-ae8b-4613-b1f4-c8c09dde9d75',NULL,0);
/*!40000 ALTER TABLE `journal_setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laboratory_sales`
--

DROP TABLE IF EXISTS `laboratory_sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `laboratory_sales` (
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
-- Dumping data for table `laboratory_sales`
--

LOCK TABLES `laboratory_sales` WRITE;
/*!40000 ALTER TABLE `laboratory_sales` DISABLE KEYS */;
/*!40000 ALTER TABLE `laboratory_sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laboratory_sales_item`
--

DROP TABLE IF EXISTS `laboratory_sales_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `laboratory_sales_item` (
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
-- Dumping data for table `laboratory_sales_item`
--

LOCK TABLES `laboratory_sales_item` WRITE;
/*!40000 ALTER TABLE `laboratory_sales_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `laboratory_sales_item` ENABLE KEYS */;
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
  `is_bpjs` char(1) DEFAULT '0',
  `tuslah` decimal(10,0) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_sales`
--

LOCK TABLES `medical_sales` WRITE;
/*!40000 ALTER TABLE `medical_sales` DISABLE KEYS */;
/*!40000 ALTER TABLE `medical_sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_treatment_sales`
--

DROP TABLE IF EXISTS `medical_treatment_sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medical_treatment_sales` (
  `id` char(50) NOT NULL,
  `is_bpjs` char(1) DEFAULT '0',
  `bpjs_payment_status` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_treatment_sales`
--

LOCK TABLES `medical_treatment_sales` WRITE;
/*!40000 ALTER TABLE `medical_treatment_sales` DISABLE KEYS */;
/*!40000 ALTER TABLE `medical_treatment_sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_treatment_sales_item`
--

DROP TABLE IF EXISTS `medical_treatment_sales_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medical_treatment_sales_item` (
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
-- Dumping data for table `medical_treatment_sales_item`
--

LOCK TABLES `medical_treatment_sales_item` WRITE;
/*!40000 ALTER TABLE `medical_treatment_sales_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `medical_treatment_sales_item` ENABLE KEYS */;
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
INSERT INTO `module` VALUES ('07452775-a048-4071-8798-21dc943fe926','PRODUCT','Product','','INVENTORY','0',0),('0b503053-31eb-410d-90a6-ec6a9977bc1e','FAMILY_FOLDER','Family Folder','','CLINIC','0',0),('0c586cf4-9bd2-4b93-b24b-d41ceca2aef4','CLINIC_SALES','Clinic Sales','','CLINIC','0',0),('13989b38-ac2c-47b8-8708-5e27477af18d','BENEFIT_TYPE','Benefit Type','','HR','0',0),('1adc4b8b-ad93-4658-8476-6bb13e2e810d','PURCHASE_ORDER_REQUEST','Purchase Order Request','','PROCUREMENT','0',0),('1cf392fc-4f93-4e38-9709-2beb84434951','DOCTORTYPE','Doctor Type','','CLINIC','0',0),('29ec80f0-0d4c-451c-ae5e-f195c4be1a27','COMPANY_STRUCTURE','Company Structure','','GENERAL','0',0),('2bdc3f95-c5bd-47d9-adce-9e9df1042e2f','BUDGET_APPROVER','Budget Approver','','ACCOUNTING','0',0),('2c0d9a06-cebd-4da2-b520-2e948aae3e53','INVOICE_REPORT','Invoice Report','','FINANCIAL','0',0),('2d7e5641-511d-43fd-a6d6-a482120f8aa5','BUDGET','Budget','','ACCOUNTING','0',0),('314a3f13-a982-4915-a5cb-455eacbc27ae','INBOX','Inbox Message','','SYSTEM','0',0),('322d37f6-a667-481e-bc22-db212d0154ea','EMPYAPP','Employment Application','','HR','0',0),('339d7200-9aa1-43d5-8683-e7118cb52839','STUDENT','Student','','EDUCATION','0',0),('342b0b64-291f-4d12-bdb8-77186895d21d','SALES_REPORT','Sales Report','','SALES','0',0),('355ca995-6bae-4638-bfd4-a9bfeff5eefb','INVOICE_OVERDUE_REPORT','Invoice Over Due Report','','FINANCIAL','0',0),('4500a912-bbad-4590-9abb-d9ec92a311a5','DISCOUNT','Discount Programm','Discount','PAYMENT','0',1),('475038c2-e2fc-406a-ac8f-c6711c6480af','SIMPLE_PHARMACY_INVOICE','Simple Pharmacy Invoice','','PHARMACY','0',0),('4939e42f-06b5-4e44-b3ba-4106964f1f68','ACCOUNTINGPERIOD','Accounting Period','','ACCOUNTING','0',0),('4b0f494a-5d29-4412-b2c1-eaaab78f53f2','GENERAL_LEDGER_REPORT','General Ledger Report','','FINANCIAL','0',0),('4b3bb551-173e-46f5-b1e9-bdd719e3045e','COA','General Chart of Account','','ACCOUNTING','0',0),('4bf39427-b32a-434c-bd71-4d9493ea6eef','STOCK_OPNAME','Stock Opname','','INVENTORY','0',0),('4eb93eb7-2100-49ae-bd96-a39995ed5670','USER','User','Application User Module','SECURITY','1',0),('4eca5501-a650-41d5-87c1-c091391d3608','CASHSALES','Cash Sales','','SALES','0',0),('532efe0a-05ff-4f94-877d-a7f3f7509569','WORKING_TIMESHEET','Working Timesheet','','PRODUCTION','0',0),('55b7e0fb-a178-478b-a09e-4b753f161aeb','MEDICATION','Medication','','CLINIC','0',0),('58621810-2c8f-44ae-b9aa-b1e05ad32743','SUPPLIER','Supplier','','PROCUREMENT','0',0),('5c37296e-ab30-4d07-bba3-342d4c403f48','INVITEM','Inventory Item','','INVENTORY','0',0),('5cdd1545-8fdb-4a79-b2a3-0662ed6fec30','POSITIONTYPERATE','Position Type Rate','','HR','0',0),('5e8c4a66-e46a-4000-ae1c-bf536686b30f','TRN_ORDER_REQ','Transfer Order Request','','INVENTORY','0',0),('5eb48ec2-5634-4ee9-b5f7-43b2df6c8c83','TRIAL_BALANCE_REPORT','Trial Balance Report','','FINANCIAL','0',0),('5eda5016-f448-42dd-926b-52b10870e29c','STUDY_TIME','Study Time','','EDUCATION','0',0),('627fb961-6cf0-4148-9451-0d1422095eb7','PURCHASE_ORDER_APPROVER','Purchase Order Request Approver','','PROCUREMENT','0',0),('65414caf-3a73-4e3f-9a58-2d70c723b5bc','CURRENCY','Currency','GENERAL','ACCOUNTING','0',1),('6861d3b3-8110-46ed-8a3a-830963597fa7','TAX','Tax','','ACCOUNTING','0',0),('69443009-4a15-4061-b9f0-08c08c8f50aa','JOURNALENTRY','Journal Entry','','ACCOUNTING','0',0),('6cbaf072-6925-46e9-b417-17326f3d8584','EMPLOYMENT','Employment','','HR','0',0),('6e299ade-e10e-4940-ae83-bdf61505ed63','STUDENT_REGISTRATION','Student Registration','','EDUCATION','0',0),('74ad4867-9495-472f-97fc-36bf87895585','COURSE_ATTENDANCE','Course Attendance','EDUCATION','EDUCATION','0',1),('770c420c-f809-43f7-969c-b493f0b4ef48','CASHIER','Cashier','','SALES','0',0),('7bef1d92-0f15-43ef-b59b-5bc3e769d896','UOM','Unit of Measure','','INVENTORY','0',0),('7f17176c-f27a-432c-a106-0d7d87b0afb7','RECEIPT','Receipt','','PAYMENT','0',0),('80aebe74-399c-4273-9145-956a077d3f5d','ACCESS_ROLE','Role','Application Access Role','SECURITY','1',0),('8217c196-16b9-44fb-9662-8323220ee705','ASSET','Asset Management','','ASSET','0',0),('83b19678-9f2f-49f4-ba25-0f31a8dee078','PHARMACY_ORDER','Pharmacy Order','','PHARMACY','0',0),('847a8df6-bc04-4de6-8d7d-28e41c00f422','DOCTOR_APPOINTMENT','Doctor Appointment','','CLINIC','0',0),('855aab16-cb45-41c3-b62c-55185ff77dfc','PHARMACY_SALES','Pharmacy Sales','','PHARMACY','0',0),('88bdca27-a7cf-4a1e-9fdc-4d0f48a0ca19','GENERAL_JOURNAL_REPORT','General Journal','','FINANCIAL','0',0),('88bf4008-c84a-4089-88c6-e9d8f077a196','JOURNALSETTING','Journal Setting','','ACCOUNTING','0',0),('8971337a-2aea-41d3-930a-4e6f2fa3acc0','CLINIC_SALES_INVOICE_REPORT','Clinic Invoice From Pharmacy','','PHARMACY','0',0),('8a05b279-2f80-47b8-a2a7-63fbe96d327e','AUDIT_TRAIL','Audit Trail','','SYSTEM','0',0),('8c7e1020-0824-4239-9a4e-46301c80b9cd','PAYMENT_METHOD_TYPE','Payment Method Type','','PAYMENT','0',0),('8f6ec9c8-e9ed-49e1-ab7a-c4a868b8391e','ORGANIZATIONACCOUNT','Organization Account','','ACCOUNTING','0',0),('90195ecb-4674-4614-a429-eebc24ffe773','POSITIONTYPE','Position Type','','HR','0',0),('916b22eb-48fa-4000-b7a2-7fc1d47ced4e','STOCK_ADJUSTMENT','Stock Adjustment','','INVENTORY','0',0),('9178e8cd-4063-4fe9-a060-d2e3ac818ed1','PAYCHECK','Paycheck','','PAYMENT','0',0),('95dd39dd-512e-414e-b95c-0fc251887f98','PRDCATEGORY','Product Category','','INVENTORY','0',0),('99623cbd-066f-4cc2-b9b3-1961bed131cc','GOODS_TRANSFER','Goods Transfer','','INVENTORY','0',0),('9b9deb26-0960-478c-8cac-4ac475c3ffc3','COURSE_REGISTRATION','Course Registration','','EDUCATION','0',0),('9b9e014c-7a23-40c1-8841-30044564bf7f','MODULE','Module','Application Module','SECURITY','1',0),('9b9e014c-7a23-40c1-8841-30044564bf7x','SYSTEM','System Access','System Access','SYSTEM','1',0),('9df71b1a-0e52-4445-98ea-b9a59ad81ac9','PATIENT','Patient','','CLINIC','0',0),('9e644628-121d-4954-8a66-8002cc866bda','STOCK_ADMIN','Stock Admin','','INVENTORY','0',0),('a4aa9ae0-5166-4d06-afd1-d2eea6f2417c','PERSON','Person Management','','GENERAL','0',0),('a4c43802-436f-407c-8793-323600c181d7','GOODS_RECEIVE','Goods Receive','','INVENTORY','0',0),('abfd9a02-3b4b-47a0-9048-a65b6be0b3aa','PRODUCT_RETUR','Product Retur','','INVENTORY','0',0),('affcf2e7-fd2c-4b39-beee-97b5dc5a1405','STUDY_PERIOD','Study Period','','EDUCATION','0',0),('b44420c6-261b-44c5-a23a-7802a0506dab','RECURRING_PAYMENT','Recurring Payment','','PAYMENT','0',0),('b54c8e49-c820-4292-9f74-9e47bd55711f','CASH_PURCHASE_ORDER','Cash Purchase Order','','PROCUREMENT','0',0),('b662de02-f4a3-4f1a-819b-5d2aaf6a342b','GOODS_ISSUE','Goods Issue','','INVENTORY','0',0),('b9935030-f5c1-479e-9ec1-795afc1c1e7e','FACILITY','Facility','','INVENTORY','0',0),('c0f3237c-23c2-49ab-bc9c-e00aa706d7e2','PROFIT_LOSS','Profit Loss Report','','FINANCIAL','0',0),('c79e78d0-3427-440c-b8fe-df126e667a8b','INVOICE_DUEDATE_REPORT','Invoice Due Date Report','','FINANCIAL','0',0),('d33784ca-abd5-422b-b45a-8c8ee13ddc0a','DEDUCTION_TYPE','Deduction Type','','PAYMENT','0',0),('dbc9175e-eb27-45e9-9e43-a1c12d6354e4','DOCTOR','Doctor','','CLINIC','0',0),('e4307d82-f3fa-4916-9e6b-7a4f894d847e','ORGANIZATION','Organization','','GENERAL','0',0),('e4d249e1-4bd5-4291-9050-62a99f70f64c','CLINIC_REPORT','Clinic Reports','','CLINIC','0',0),('e54e6ba5-7ffd-457b-a23e-8b6285867ba4','STUDY_ROOM','Study Room','','EDUCATION','0',0),('e8f89299-2138-4167-b5b7-52f6ae1667ca','POSITION','Position','','HR','0',0),('e916392a-0b3c-4543-ada7-93054383bb3b','MESSAGE','Message','','SYSTEM','0',0),('ee3c3540-9c62-46df-a79e-f7b636a9ba1d','STUDY_DAY','Study Day','EDUCATION','EDUCATION','0',1),('f50dd16d-0e25-44b6-bd69-c28dfcc55300','GEOGRAPHIC','Geographic','','GENERAL','0',0),('f53b80db-1b89-4779-86e7-b065b5287bbb','ASSET_TYPE','Asset Type','','ASSET','0',0),('fab64cd8-7762-412b-90fb-3d31d5576b45','COURSE_SCHEDULE','Course Schedule','','EDUCATION','0',0),('fca1cfcf-d199-4729-a321-e1ed01deb0f1','LABS_REGISTRATION','Laboratory Registration','','MEDICALLAB','0',0);
/*!40000 ALTER TABLE `module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `id` char(50) NOT NULL,
  `order_date` date DEFAULT NULL,
  `entry_date` date DEFAULT NULL,
  `fk_billing_address` char(50) DEFAULT NULL,
  `fk_shipping_address` char(50) DEFAULT NULL,
  `fk_placing_order` char(50) DEFAULT NULL,
  `fk_taking_order` char(50) DEFAULT NULL,
  `fk_ship_to` char(50) DEFAULT NULL,
  `fk_bill_to` char(50) DEFAULT NULL,
  `fk_ship_to_contact` char(50) DEFAULT NULL,
  `fk_bill_to_contact` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_adjustment`
--

DROP TABLE IF EXISTS `order_adjustment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_adjustment` (
  `id` char(50) NOT NULL,
  `fk_order` char(50) DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_adjustment`
--

LOCK TABLES `order_adjustment` WRITE;
/*!40000 ALTER TABLE `order_adjustment` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_adjustment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item`
--

DROP TABLE IF EXISTS `order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_item` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `unit_price` decimal(10,0) DEFAULT NULL,
  `fk_uom` char(50) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `fk_feature` char(50) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
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
-- Table structure for table `order_item_assosiation`
--

DROP TABLE IF EXISTS `order_item_assosiation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_item_assosiation` (
  `id` char(50) NOT NULL,
  `sales_item` char(50) DEFAULT NULL,
  `purchase_item` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item_assosiation`
--

LOCK TABLES `order_item_assosiation` WRITE;
/*!40000 ALTER TABLE `order_item_assosiation` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_item_assosiation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item_billing`
--

DROP TABLE IF EXISTS `order_item_billing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_item_billing` (
  `id` char(50) NOT NULL,
  `fk_order_item` char(50) DEFAULT NULL,
  `fk_invoice_item` char(50) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item_billing`
--

LOCK TABLES `order_item_billing` WRITE;
/*!40000 ALTER TABLE `order_item_billing` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_item_billing` ENABLE KEYS */;
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
-- Table structure for table `order_requirement_commitment`
--

DROP TABLE IF EXISTS `order_requirement_commitment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_requirement_commitment` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `fk_requirement` char(50) DEFAULT NULL,
  `fk_order_item` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_requirement_commitment`
--

LOCK TABLES `order_requirement_commitment` WRITE;
/*!40000 ALTER TABLE `order_requirement_commitment` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_requirement_commitment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_role`
--

DROP TABLE IF EXISTS `order_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_role` (
  `id` char(50) NOT NULL,
  `fk_person` char(50) DEFAULT NULL,
  `type` char(50) DEFAULT NULL,
  `fk_order` char(50) DEFAULT NULL,
  `percent_contribution` decimal(10,0) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_role`
--

LOCK TABLES `order_role` WRITE;
/*!40000 ALTER TABLE `order_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_status`
--

DROP TABLE IF EXISTS `order_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_status` (
  `id` char(50) NOT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `fk_order` char(50) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_status`
--

LOCK TABLES `order_status` WRITE;
/*!40000 ALTER TABLE `order_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_term`
--

DROP TABLE IF EXISTS `order_term`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_term` (
  `id` char(50) NOT NULL,
  `fk_order` char(50) DEFAULT NULL,
  `fk_order_item` char(50) DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `fk_term_type` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_term`
--

LOCK TABLES `order_term` WRITE;
/*!40000 ALTER TABLE `order_term` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_term` ENABLE KEYS */;
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
INSERT INTO `organization` VALUES ('27fa30c5-4c84-4f2a-88ed-f93fa1ca558d','MEDICAL'),('4a129f6b-7b21-4640-bf78-4da17201894a','MEDICAL'),('4b089faf-a54c-4870-bd4d-17128ae8aa42','MEDICAL'),('4b6b0923-ee66-4459-817c-8a3615e77276','MEDICAL'),('977dce5c-bbe4-4abc-8df7-f8f3a4c167c7','MEDICAL'),('b17aadd1-fb3a-48fd-b780-a34f89596102','MEDICAL'),('b42b1e90-1bb2-4a6f-9962-230fd47c003e','MEDICAL'),('b620d220-4d73-473f-b0ba-cad098570b6a','MEDICAL'),('bce962f9-7d57-49fa-bcee-cfc093b10b96','MEDICAL');
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
INSERT INTO `organization_account` VALUES ('55c18725-3d27-4693-8483-d48aeffcb0a2','COA Aim Medical Center','','1','4a129f6b-7b21-4640-bf78-4da17201894a',0);
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
INSERT INTO `organization_gl_account` VALUES ('02167382-49a3-4965-a17f-b518eefb599d','1','ab7014c8-da75-4811-b026-6dde1a0f87ec','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('1305d0d3-fb2c-4e42-a04e-c165812a6ecc','1','56958b7a-2e8e-4148-95d0-ad0433329341','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('1389250c-aa41-4352-bdcd-318ada069360','1','8fe720b5-9fed-4e69-b6d3-d527cae1c6ab','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('1f8565a7-014a-4fb0-b7c8-ea8986d4b297','1','36f476e1-b97c-4e07-8b4a-899dc1edb976','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('2683f4ea-1da3-4f58-8db9-e7bc44428676','1','ac07af27-0170-4c88-8f4b-68cecb26bf60','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('2979a595-03eb-4156-b317-a9ea5fe5f57e','1','1574c4eb-34c3-4603-a4a4-45bcff15ea60','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('320007e5-19fa-40bb-bbbf-7771e52b7a08','1','3526547d-d056-479e-b5f4-c61c2fd05ae9','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('3a7ebaad-01ff-4392-8837-f2c6ee644870','1','9a89224d-5c0e-4bf7-a424-43a2c9952d28','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('3d6e2982-6e08-4b2a-8b55-4930b9105591','1','4b449bdc-6882-4286-86a1-223081928574','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('3fe8dcfd-cc53-45ad-8eb1-5a25d571d442','1','2da81f71-8013-4aa9-a92a-87487ada1c94','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('4594d4b6-7f21-41a5-beef-15e798349205','1','c239d176-2c4a-45b5-a784-1e0068746efa','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('4618e5d8-5761-4d2b-98c7-0b21b9fb7397','1','f49a3d14-b639-4d46-ab7b-5457d3cbd00f','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('4fa1ec63-6c89-4884-85eb-3aa126f1d104','1','9d3a5e4c-c4c9-4758-83f6-2868ea42ce52','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('633de64e-12eb-4e4b-be74-135a4d088b9b','1','88e1fdc3-397b-4fb2-8762-34fcb8117d86','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('66bc75b5-3a0d-4902-9e33-d626c0487eb1','1','fb57e7c7-ab58-4a0c-acd7-ecbe09fcd5b1','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('7eb999bb-d869-4a06-bc11-f4e24cc3e21f','1','2ced690a-85eb-4bac-a745-db92d1b26fb8','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('84037af2-0956-4236-8bf7-507ffa51dcb3','1','e74aeed0-b879-4818-bfaf-bde4748a1405','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('8700478c-b6f6-4837-81c4-f29c6296597b','1','dc097b30-730a-459d-b3c0-bae518039a1f','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('87de8f99-3cc6-4c78-b400-8eae4793ed78','1','9dc4805f-d239-49c4-9934-54db1fcce388','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('9be13c2c-348c-4c2d-a37d-65e56b29cf05','1','764e46ff-dffc-46fc-b24b-6cd3b985e5be','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('a1535a54-b7fa-4bf3-b306-f687639e6bff','1','24f5fccc-59c4-43f5-9a44-35f3ae2a38da','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('a22b754e-720e-4788-9d30-f50bbf6b58a5','1','b56b3bd0-46ee-4093-bee5-a3df47eecfe7','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('a361d66b-dc41-4b49-901f-bb9f33402e6b','1','4fbc06aa-d1fc-4aac-b9e8-6e0f55b35592','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('a5b57b7b-0bea-4d2d-82c8-3e87ed911c04','1','f8c654cf-7fe7-4691-a722-5cfb4cc25f3b','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('b3978c75-2a9d-47ae-974c-5d373433bca3','1','48179971-d914-4378-a82c-eec141f1897c','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('b3a9c3dd-cb7b-496b-90b1-0a585c0ce19e','1','853cc1cf-9611-43b6-a102-32542e574019','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('beb36a02-849e-4312-8db1-77327483b6f6','1','41cf31d7-ef92-4132-aa23-7c06e9d9d9ce','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('c4d91711-a192-4a0e-a72f-35f1d8d023c2','1','682d8f64-52fa-4189-af52-a38b6130a902','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('c8741c05-5381-44ea-a33f-09365c07bcd6','1','55b3a728-cacd-44bf-8b44-8e505b43bb2c','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('cf66e8c9-3324-4802-b4e3-c1be3344eb36','1','270ad66b-a7a9-4b0c-9a26-ba9760c114f4','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('d1246d96-1712-4a4e-b9fd-a772ea5cf43d','1','2bbab6e9-5c5e-40b6-92fd-525d525f38d4','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('d6427394-8468-4642-a821-bcc606f78d62','0','878fa124-4409-433c-b617-346f0f72008e','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('eae55022-557d-4b5f-aa40-a92371e01de8','1','88618627-e8d8-43e8-a790-a9d76882d835','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('f1efef83-aa55-4e09-bca7-cc66380e39fc','1','b1d4647e-053f-4b08-8556-6b4d9f9ac82a','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('f9efeedb-f677-4980-8bdf-b5dfa662d37d','1','878fa124-4409-433c-b617-346f0f72008e','55c18725-3d27-4693-8483-d48aeffcb0a2',0),('f9efeedb-f677-4980-8bdf-b5dfa662d38c','1','820f1122-b177-4faf-b3fb-93e03bc37dde','55c18725-3d27-4693-8483-d48aeffcb0a2',0);
/*!40000 ALTER TABLE `organization_gl_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organization_period`
--

DROP TABLE IF EXISTS `organization_period`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organization_period` (
  `id` char(50) NOT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `fk_accounting_period` char(50) DEFAULT NULL,
  `is_closed` char(1) DEFAULT '0',
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization_period`
--

LOCK TABLES `organization_period` WRITE;
/*!40000 ALTER TABLE `organization_period` DISABLE KEYS */;
/*!40000 ALTER TABLE `organization_period` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `packaging_content`
--

DROP TABLE IF EXISTS `packaging_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `packaging_content` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `fk_shipment_item` char(50) DEFAULT NULL,
  `fk_shipment_package` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `packaging_content`
--

LOCK TABLES `packaging_content` WRITE;
/*!40000 ALTER TABLE `packaging_content` DISABLE KEYS */;
/*!40000 ALTER TABLE `packaging_content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `party`
--

DROP TABLE IF EXISTS `party`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `party` (
  `id` char(50) NOT NULL,
  `identity` varchar(50) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `fk_geographic_birth_place` char(50) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `tax_code` char(50) DEFAULT NULL,
  `is_removeable` char(1) DEFAULT '1',
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party`
--

LOCK TABLES `party` WRITE;
/*!40000 ALTER TABLE `party` DISABLE KEYS */;
INSERT INTO `party` VALUES ('27fa30c5-4c84-4f2a-88ed-f93fa1ca558d','00130','Aim Poli Gigi',NULL,'2014-07-25','','1',1),('4a129f6b-7b21-4640-bf78-4da17201894a','000100','Aim Medical Center',NULL,'2014-07-25','','1',0),('4b089faf-a54c-4870-bd4d-17128ae8aa42','00200','Rasau Medical Center',NULL,'2014-07-25','','1',0),('4b6b0923-ee66-4459-817c-8a3615e77276','00140','Aim Laboratory',NULL,'2014-07-25','','1',0),('78171b13-766f-495b-939d-e01b79e21931','00001','SYSADMIN',NULL,'1981-07-25','','0',0),('977dce5c-bbe4-4abc-8df7-f8f3a4c167c7','00210','Rasau Poli Umum',NULL,'2014-07-25','','1',0),('b01d8d84-9815-403c-9c44-12a385e997c4','00000','ANONYMOUS',NULL,'1980-07-25','','0',0),('b17aadd1-fb3a-48fd-b780-a34f89596102','00120','Aim Apotik',NULL,'2014-07-25','','1',1),('b42b1e90-1bb2-4a6f-9962-230fd47c003e','0001','Johan Healcare',NULL,'2016-07-28','','1',0),('b620d220-4d73-473f-b0ba-cad098570b6a','0000','Johan Corporation',NULL,'2014-07-25','','1',0),('b7337ad2-a0a9-47e3-a165-e02d0998a271','7357327325','sukhaa13',NULL,'2016-08-11','','1',0),('bce962f9-7d57-49fa-bcee-cfc093b10b96','000110','Aim Poli Umum',NULL,'2014-07-25','','1',2),('e7e49682-49d1-40cb-90b2-3ef428fed139','0000000','Dr Johan Molana',NULL,'2016-08-18','','1',0);
/*!40000 ALTER TABLE `party` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `party_rate`
--

DROP TABLE IF EXISTS `party_rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `party_rate` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `rate` decimal(10,0) DEFAULT NULL,
  `type` char(50) DEFAULT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party_rate`
--

LOCK TABLES `party_rate` WRITE;
/*!40000 ALTER TABLE `party_rate` DISABLE KEYS */;
/*!40000 ALTER TABLE `party_rate` ENABLE KEYS */;
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
INSERT INTO `party_relationship` VALUES ('cc84b08c-daf5-41b0-a062-172d494387e7','2016-08-11',NULL,0),('f06a1407-3faa-4fa4-8ea2-d70c3b145c2a','2016-08-18',NULL,0);
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
INSERT INTO `party_role` VALUES ('82ce9e00-cf20-489e-9168-df5c4a632d12','2016-08-18',NULL,'4b6b0923-ee66-4459-817c-8a3615e77276',0),('8fa98ab8-ca51-4854-ad19-efffdf25e91a','2016-08-11',NULL,'b620d220-4d73-473f-b0ba-cad098570b6a',0),('b5ffb8f3-866a-4268-aa8f-871d5abf6778','2016-08-18',NULL,'e7e49682-49d1-40cb-90b2-3ef428fed139',0),('de341cd3-19ec-4a11-a3cf-1f540a57f663','2016-08-11',NULL,'b7337ad2-a0a9-47e3-a165-e02d0998a271',0);
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
  `fk_party` char(50) DEFAULT NULL,
  `fk_type` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `name` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party_skill_type`
--

LOCK TABLES `party_skill_type` WRITE;
/*!40000 ALTER TABLE `party_skill_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `party_skill_type` ENABLE KEYS */;
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
  `fk_uom` char(50) DEFAULT NULL,
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
  `note` varchar(250) DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `fk_currency` char(50) DEFAULT NULL,
  `method_type` char(50) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
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
  `fk_invoice` char(50) DEFAULT NULL,
  `fk_payment` char(50) DEFAULT NULL,
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
INSERT INTO `payment_method_type` VALUES ('2b593bd7-6ecd-4c24-9eec-2a0e64125fc1','Asuransi BPJS','',0),('4e8ec81a-3b9f-4606-ad00-446514bc999f','Cash','Cash',0),('64789dac-e245-400b-9316-def1cf505ae4','Debit Mandiri','',0),('9055b97d-8c89-48ab-af9b-f190a1a29aa2','Debit BNI','',0),('e70074fe-ce55-4196-8d86-aed1f561fa64','Credit Card Mandiri','',0);
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
INSERT INTO `person` VALUES ('78171b13-766f-495b-939d-e01b79e21931','MALE','SINGLE'),('b01d8d84-9815-403c-9c44-12a385e997c4','MALE','SINGLE'),('b7337ad2-a0a9-47e3-a165-e02d0998a271','MALE','SINGLE'),('e7e49682-49d1-40cb-90b2-3ef428fed139','MALE','MARIED');
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
/*!40000 ALTER TABLE `pharmacy_sales_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pick_list`
--

DROP TABLE IF EXISTS `pick_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pick_list` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pick_list`
--

LOCK TABLES `pick_list` WRITE;
/*!40000 ALTER TABLE `pick_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `pick_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pick_list_item`
--

DROP TABLE IF EXISTS `pick_list_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pick_list_item` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT '1',
  `fk_inventory_item` char(50) DEFAULT NULL,
  `fk_pick_list` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pick_list_item`
--

LOCK TABLES `pick_list_item` WRITE;
/*!40000 ALTER TABLE `pick_list_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `pick_list_item` ENABLE KEYS */;
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
INSERT INTO `product` VALUES ('007e27fa-9f94-47a2-a70a-115654f1ae31','SUPER TETRA SOFT CAPSUL 250 MG (20 STP X 6 SOFT CAPSUL)','SUPER TETRA SOFT CAPSUL 250 MG (20 STP X 6 SOFT CAPSUL)','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',18,0),('01a8e63d-6b82-431c-b434-26bce2e551d1','ACIFAR 5 MG','ACIFAR 5 MG','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('01b583c9-c515-4b30-9793-482d0a76f1d2','NATUR E ADVANCE 32\'S PTH BESAR','NATUR E ADVANCE 32\'S PTH BESAR','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('01b8a9fa-5733-4ee8-8c08-b20e26e5c167','NEBACETIN POWDER 5 G','NEBACETIN POWDER 5 G','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('02537a79-aa55-4a81-8b22-f16f4cf0071e','GRATHEOS 50 MG','GRATHEOS 50 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('02969de9-2b60-4a29-bbe9-563ebd952079','DISMENO','DISMENO','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('03ed3ffd-4174-4201-813b-31dd9c4e5793','MKP LANG NO. 3 30 ML CAJUPUT','MKP LANG NO. 3 30 ML CAJUPUT','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('04715b9f-36c0-4c0f-9377-a8f4b42dadff','RATAN INJ','RATAN INJ','2016-08-08',NULL,'2edc961e-8693-429d-973a-299182d28690','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('04761771-d7fe-4fd2-bbea-d0054d8843c5','CIPROLEX','CIPROLEX','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('05830da2-288e-4908-b338-4871b114a416','OXICOBAL','OXICOBAL','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('05b1a7cd-af33-4b66-97fc-8e799dbb9233','GLYDERM CREAM 60 G','GLYDERM CREAM 60 G','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('05ea21d4-1ec4-4d21-a583-dbae13f5afee','ALBOTHYL SOLUTION 5 ML','ALBOTHYL SOLUTION 5 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('05f6c643-47dd-4a0e-9e60-607c5a72e2b1','NEUROBORAN INJ','NEUROBORAN INJ','2016-08-08',NULL,'038515dd-4524-496a-a4ae-ff7370ef60d9','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('05f7ca85-abef-44b7-856b-bd65718f0eae','ATORVASTATIN CALCIUM 10 MG (3 BLS X 10 TAB)','ATORVASTATIN CALCIUM 10 MG (3 BLS X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',6,0),('06e325af-29b7-44d2-a87c-5bbe68355d45','TREMENZA TAB (10 STP X 10 TAB)','TREMENZA TAB (10 STP X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',30,0),('084ecea3-20b9-47fd-a75b-b5bc0f6cbd69','ADEM SARI DUS 5\'S','ADEM SARI DUS 5\'S','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',3,0),('08a80cf4-0ef9-48d1-a79c-edd714b170c0','PERMEN WOODS BLACKKURANT','PERMEN WOODS BLACKKURANT','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('08b45e7e-9a17-4a42-a545-f23327c35785','PARIOS','PARIOS','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('09fb4270-b803-4287-ba6b-6c2d1fa0a2b8','WOODS ANTI 60 ML / MERAH TDK BERDAHAK','WOODS ANTI 60 ML / MERAH TDK BERDAHAK','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('0a9a2f8d-36a7-45ea-9e2a-67b9fa59da98','MASKER DIAPRO TIE-ON 3 PLY TALI (50 PCS)','MASKER DIAPRO TIE-ON 3 PLY TALI (50 PCS)','2016-08-08',NULL,'453077e2-a7fb-4f81-b6d8-936cbef4fab3','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',10,0),('0aeeef06-348c-4b67-8750-5101f00a3f2c','TRANSPULMIN BALSAM 10 G','TRANSPULMIN BALSAM 10 G','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('0b74682d-2c3c-471b-81f7-0d3c1cdfc550','FRESHCARE GREENTEA','FRESHCARE GREENTEA','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('0b7c70bb-e354-4250-8931-5fe10e2a78f0','BETADINE VAGINAL DOUCHE 100 ML PA','BETADINE VAGINAL DOUCHE 100 ML PA','2016-08-08',NULL,'f66bccf3-c3ab-46b6-b8b7-5b19a1fdda3a','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('0bd09974-0132-4a30-98ae-ac6d2f95cb0b','AMARYL 2 MG (5 STP X 10 TAB)','AMARYL 2 MG (5 STP X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('0c22a71d-831d-4f91-9006-aac28244e489','ALLOHEX (5 STP X 10 TAB)','ALLOHEX (5 STP X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('0c4e33f7-256a-4275-a268-cdbf64495451','CANDESARTAN CILEXETIN','CANDESARTAN CILEXETIN','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('0c87f638-2e75-413d-bd70-c5b89c144b3b','SANMOL 500 MG (Paracetamol 500mg)','SANMOL 500 MG (Paracetamol 500mg)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('0d0a7ff1-8497-40bb-a4b2-848d7ac2749c','HUFAGRIP PILEK 60 ML - BR','HUFAGRIP PILEK 60 ML - BR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('0d3e03de-e3a6-41f9-99f0-f53f1764c3fd','PIL CHIKIT','PIL CHIKIT','2016-08-08',NULL,'453077e2-a7fb-4f81-b6d8-936cbef4fab3','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',4,0),('0d95cd28-0fdb-453d-9a8f-3c02d52557ee','ACTIFED EXPECTORANT 60 ML (HIJAU)','ACTIFED EXPECTORANT 60 ML (HIJAU)','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('0db1619a-3d5d-4dd2-a294-af7ab18f09a5','KONDOM SUTRA MERAH 24 X 3\'S','KONDOM SUTRA MERAH 24 X 3\'S','2016-08-08',NULL,'eddf7518-491f-4713-bf70-85bab5a09938','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('0dc97e5d-c36b-4bc9-bdbf-62bce2412dd0','NOURISH SKIN 15 \'S','NOURISH SKIN 15 \'S','2016-08-08',NULL,'f66bccf3-c3ab-46b6-b8b7-5b19a1fdda3a','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('0dde6cd4-61ee-4ae4-b272-7ec50af92bc8','NEPROLIT','NEPROLIT','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('0f2fd2e2-3ab1-4a57-a327-2d11215facb4','DIANE 35 1X21 (BOX/21)','DIANE 35 1X21 (BOX/21)','2016-08-08',NULL,'f66bccf3-c3ab-46b6-b8b7-5b19a1fdda3a','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('0f3778f1-cf32-45cb-b73a-701184d39bb8','VICKS VAPORUB 25 G','VICKS VAPORUB 25 G','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('0f8b2430-75d7-49f2-bea0-ba53641982b3','NEBACETIN OINTMENT 5 G','NEBACETIN OINTMENT 5 G','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('1036ff8c-ba61-4479-8b3f-1089e236dd18','ECLID 100','ECLID 100','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('1055232b-f75f-432f-92fc-d252a55af5f1','RHINOS SR (5 BLS X 10 KAPSUL)','RHINOS SR (5 BLS X 10 KAPSUL)','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',10,0),('10b7b0fa-494c-49b3-bd65-bdef8ad7d293','KALPANAX 10 ML CAIR','KALPANAX 10 ML CAIR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('10fc4ac8-48e5-403c-b89e-45b88e772f96','PRORIS IBUPROFEN SUSP 60 ML - HJ','PRORIS IBUPROFEN SUSP 60 ML - HJ','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('1177854c-af94-4c6b-b3ef-8545dc0c2a7c','SUTRA 3\'S FIESTA BAGGY','SUTRA 3\'S FIESTA BAGGY','2016-08-08',NULL,'f66bccf3-c3ab-46b6-b8b7-5b19a1fdda3a','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('140830b4-4847-445d-b32e-6ff9a315acf6','MEDI-KLIN TR GEL 15 G','MEDI-KLIN TR GEL 15 G','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('1494e6ac-0838-409b-8171-27a4e9c793c6','BETADINE 30 ML','BETADINE 30 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('152f2e0e-1a2c-417f-82c1-b280460976fd','BECOM-ZET (10 STP X 10 KAPLET)','BECOM-ZET (10 STP X 10 KAPLET)','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',20,0),('162da676-a464-47e3-b74f-98c12165e8c3','GANDAPURA 100 ML IKA','GANDAPURA 100 ML IKA','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('16861364-78e1-4079-8250-3653ad9e75ca','KOMIX KIDS OBH','KOMIX KIDS OBH','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('16865428-073d-4cc3-8da7-f55793296e21','TERMOMETER RAKSA LOTUS','TERMOMETER RAKSA LOTUS','2016-08-08',NULL,'453077e2-a7fb-4f81-b6d8-936cbef4fab3','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('1706fcfd-6788-4c63-a45b-bddb2c7da5a0','MIRAPON SYR 100 ML','MIRAPON SYR 100 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('17170adc-b545-44df-98f3-987692f559b4','EM KAPSUL KOTAK 12 KAPSUL X 550 MG','EM KAPSUL KOTAK 12 KAPSUL X 550 MG','2016-08-08',NULL,'22f1f150-0533-4cdc-a229-9260b752421c','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('17b97205-0022-4a3d-aa41-9c715ac072dc','ANAKONIDIN OBH SYR 60 ML','ANAKONIDIN OBH SYR 60 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('17d09027-7f78-4b74-aa2d-4f19102f3abc','FARIZOL 500 MG','FARIZOL 500 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('18315342-7f0d-43e6-8710-71ce095f0f5f','ZN-DIAR','ZN-DIAR','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('1a963c74-95d3-4735-ac0c-55358c5a078c','SUTRA 3\'S FIESTA DURIAN','SUTRA 3\'S FIESTA DURIAN','2016-08-08',NULL,'f66bccf3-c3ab-46b6-b8b7-5b19a1fdda3a','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('1aa9ec96-e467-4ddb-8397-5f59685a32ed','FORTEN 12,5 MG','FORTEN 12,5 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('1aad43d9-279b-4527-8581-5c86a5885008','LYSINKU SYR','LYSINKU SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('1af980d8-f07e-4d66-9c57-d998b4a1b47f','ZIREA','ZIREA','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('1c477c16-a1b0-4982-8857-b9b7ee9fb986','GLUNOR XR 500 MG','GLUNOR XR 500 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('1c4909bc-5c44-4efb-aaa7-3d0eb384c349','NEO REUMACYL NEURO','NEO REUMACYL NEURO','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('1cb74234-3d39-4b32-bf58-4b07136eb87b','HYPAFIX 5CM X 5M','HYPAFIX 5CM X 5M','2016-08-08',NULL,'22f1f150-0533-4cdc-a229-9260b752421c','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('1cbdf52a-e1bc-4242-b846-d9b8f5e323c3','COMBANTRIN JERUK','COMBANTRIN JERUK','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('1e266883-c6d2-41d3-8c11-cea3402a4948','VIOSTIN DS','VIOSTIN DS','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('1efa96d9-713d-4a0f-be9b-1d681ab2f0e2','PERBAN MEDIRAYA 4 X 10 CM','PERBAN MEDIRAYA 4 X 10 CM','2016-08-08',NULL,'8f832dfa-55ee-405d-9dcd-795264b3c656','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('1f43ba02-de8f-4b1a-8d5c-d5fabf862158','SALEP ICTHYOL 15 G','SALEP ICTHYOL 15 G','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('1f82dfc0-8285-4c28-88b4-175234347c5d','TEH CELUP JATI CINA 45 G','TEH CELUP JATI CINA 45 G','2016-08-08',NULL,'22f1f150-0533-4cdc-a229-9260b752421c','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('1f908ff9-e0bb-49db-91f0-d098e5661987','OBAT BATUK IBU & ANAK 150 ML / OBIDA BESAR','OBAT BATUK IBU & ANAK 150 ML / OBIDA BESAR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('218005c1-4b36-4d3b-8b5b-5d4c6eb88186','BALSEM GOSOK LANG 10 G','BALSEM GOSOK LANG 10 G','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('21d79dee-51b7-4840-9a9f-ff7dc3726f21','AVAIL BIRU (DAY USE)','AVAIL BIRU (DAY USE)','2016-08-08',NULL,'453077e2-a7fb-4f81-b6d8-936cbef4fab3','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',3,0),('2223495a-8eef-4757-b33c-27fb7646d4f5','PSIDII SYR','PSIDII SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('223d66d3-f822-489e-a049-39bbc69145c7','BISCOR (3 STP X 10 MG)','BISCOR (3 STP X 10 MG)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('22e4608e-f78b-4604-9dd8-2666b21690c7','AMBEVEN','AMBEVEN','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('23e015ae-9fe0-4fbd-b73c-782ebe70c2c0','DIAFORM','DIAFORM','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('23e3d105-5d65-4bbf-a54f-fa527ee68aff','SUTRA 3\'S FIESTA BANANA','SUTRA 3\'S FIESTA BANANA','2016-08-08',NULL,'f66bccf3-c3ab-46b6-b8b7-5b19a1fdda3a','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('24c994b8-0141-4be3-a317-5d7260b90367','MINYAKASAI /TI -KNG','MINYAKASAI /TI -KNG','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('24e58c5e-7f82-47ed-a56d-d384a29515ec','HUFAGRIP SYR  60 ML  - KNG','HUFAGRIP SYR  60 ML  - KNG','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('25310c3d-2ca0-4dbb-9b8a-7d0c3754b11a','PRORIS FORTE SYR 50 ML - BIRU','PRORIS FORTE SYR 50 ML - BIRU','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('254b8e87-0d5b-4fef-aaef-dcbd01f580a7','METROLET SYR','METROLET SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('25d4db4a-715f-4561-9441-06da16bf5f7a','GRISEOFULVIN','GRISEOFULVIN','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('26cc436a-c594-409c-8f35-c0cfbfd82a4c','KANDISTATIN 12 ML','KANDISTATIN 12 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('275f070a-ae3d-4f29-a882-cd6bd9fca7e5','VERBAN ELASTIS 3\' 7,5 CM X 4,5 M GC','VERBAN ELASTIS 3\' 7,5 CM X 4,5 M GC','2016-08-08',NULL,'453077e2-a7fb-4f81-b6d8-936cbef4fab3','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('27730e12-6012-4ac1-8c7c-17669fdf9916','EVER E 250 30\'S / BTL','EVER E 250 30\'S / BTL','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('280f4a60-3587-4a87-b219-c75d42cc6534','HEU FUNG SAN CSL (1 KTK=4 LSN)','HEU FUNG SAN CSL (1 KTK=4 LSN)','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',2,0),('28135593-39cf-4a2a-aee4-706f7ab6fddf','DUREX PLEASUREMAX  3\'S','DUREX PLEASUREMAX  3\'S','2016-08-08',NULL,'f66bccf3-c3ab-46b6-b8b7-5b19a1fdda3a','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('2816962b-cceb-4941-b477-977ba800e72d','MICROGYNON (25X1X28)','MICROGYNON (25X1X28)','2016-08-08',NULL,'d39e1e7d-a7ac-4027-9762-43d58893f68f','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',5,0),('28cba0ec-d341-4e33-abaa-878a82bcd5c9','AMOXICILLIN 500 MG (10 STP X 10 KAPL)','AMOXICILLIN 500 MG (10 STP X 10 KAPL)','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',30,0),('294e21e2-5410-4522-b947-588746f1293d','COMBANTRIN 250 MG','COMBANTRIN 250 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('29aaecee-60e6-40ca-813f-91cd2156c033','FATIGON SPIRIT ( Vitamin)','FATIGON SPIRIT ( Vitamin)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('29c26422-a1af-4fad-a14f-c5cf4550671e','PAGODA PASTILLES APPLE10 GR/ K','PAGODA PASTILLES APPLE10 GR/ K','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('2a3c9db2-6252-46a3-a3fe-57523bd96c01','PEDIALYTE SOLUTION 500 ML','PEDIALYTE SOLUTION 500 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('2a55be02-7190-41d1-8726-90bccec8c4b1','FITKOM TAB STRAWBERY','FITKOM TAB STRAWBERY','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('2b63d0e6-50cd-434f-a88c-dc2c40d3f1f0','DIONICOL SYR','DIONICOL SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('2c1f9606-af8f-42ac-ac91-9eb2f322f5d4','RANCUS 150 MG','RANCUS 150 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('2c5d4a47-3f91-4771-aadf-8ee49ac08206','DIAPET','DIAPET','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('2c7e34a0-931b-412a-9aa6-63af17f37815','OBH COMBI PLUS MENTHOL 60 ML','OBH COMBI PLUS MENTHOL 60 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('2cc86f32-a7e0-4d34-82cd-b434a2b41768','LARUTAN CAP BADAK 500 ML','LARUTAN CAP BADAK 500 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',2,0),('2cf89940-2aa8-47d1-b496-00aac722bcee','PLANTACID FORTE SYR','PLANTACID FORTE SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('2d35744d-b386-411d-88be-1900f1c93469','INTERHISTIN','INTERHISTIN','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('2d3ab83d-cda0-4f36-8974-c4f72b10cd20','FG TROCHES (30 STP X 10 TROCHES)','FG TROCHES (30 STP X 10 TROCHES)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',50,0),('2d567563-1311-4d61-b599-4262498abbcf','FARSORBID 5 MG','FARSORBID 5 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('2f49b0a4-86e3-4295-8f55-2fabd91b30f7','ANTRAIN INJ','ANTRAIN INJ','2016-08-08',NULL,'2edc961e-8693-429d-973a-299182d28690','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('2fd63757-2ddc-4466-b04f-a3ca142b8591','METHYLPREDNISOLONE 4 MG (10 STP X 10 TABLET)','METHYLPREDNISOLONE 4 MG (10 STP X 10 TABLET)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',30,0),('30176b2c-1c16-4774-9e4a-724306b412d3','ETHAMBUTOL 500 MG (10 STP X 10 TAB)','ETHAMBUTOL 500 MG (10 STP X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',20,0),('30a807fc-2faa-4c65-ab73-4f2f78ae9ced','DAKTARIN SALEP 10 G','DAKTARIN SALEP 10 G','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('3161ee08-13f9-43d6-a312-043f441baf9b','VITAMIN B12 50\'S IPI','VITAMIN B12 50\'S IPI','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('3252a452-2840-427c-9a77-2107111ff6af','BRODAMOX 250 MG / 5 ML','BRODAMOX 250 MG / 5 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('327685f6-7192-4d97-9e74-a3d82d88482f','PAGODA PASTILLES STRAWBERRY  10 GR/ K','PAGODA PASTILLES STRAWBERRY  10 GR/ K','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('32c00f0f-3f41-4b6f-b511-cc713e4a0376','INFUS SET ANAK OTSUKA','INFUS SET ANAK OTSUKA','2016-08-08',NULL,'453077e2-a7fb-4f81-b6d8-936cbef4fab3','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('32dbb41e-2878-40ad-a4f2-31b8b34400ed','CANESTEN SALEP 5 G','CANESTEN SALEP 5 G','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('32f72db1-360a-4cc7-b444-c7c1a09b66cd','TEMPRA SYR 60 ML ( Paracetamol 160 mg )','TEMPRA SYR 60 ML ( Paracetamol 160 mg )','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('33001ff1-5e76-4d77-9454-f720b61534b9','MIRASIC  500 MG ( Paracetamol 500mg)','MIRASIC  500 MG ( Paracetamol 500mg)','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',3911,0),('3390b1de-aafb-4fee-8194-a69121f007db','SAKATONIK ABC STRAWBERRY \'30 TABLET HISAP','SAKATONIK ABC STRAWBERRY \'30 TABLET HISAP','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('33da234e-081b-4a4e-8e98-17cded390bba','DAKTARIN SALEP 5 G','DAKTARIN SALEP 5 G','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('33deee8e-779e-4354-9abc-c821cfd629dd','POLIDENT ADHESIVE 15 G','POLIDENT ADHESIVE 15 G','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('3408fa37-27a1-4ba7-aabd-47da2341f48b','CUSTODIOL','CUSTODIOL','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('3484a9b2-c960-4a19-a8fe-5a71bc8d2e74','AMLODIPINE BESYLATE 5 MG (3 STP X 10 TAB)','AMLODIPINE BESYLATE 5 MG (3 STP X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',20,0),('34cb8dc5-05db-4754-a6f0-753c331fcbe7','BUSCOPAN 20 MG','BUSCOPAN 20 MG','2016-08-08',NULL,'2edc961e-8693-429d-973a-299182d28690','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('353c2ac7-a726-4211-a776-43a1d29ba313','KOMX MINT 30\'S','KOMX MINT 30\'S','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('35732a5c-88cb-4012-8712-4a60bf5628eb','POLYSIL SUSPENSI 100 ML','POLYSIL SUSPENSI 100 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('35ab31ab-55d9-4b61-97e8-fc6b718fd265','DOMPERIDONE 10 MG HEXPHARM JAYA (10 STP X 10 TAB)','DOMPERIDONE 10 MG HEXPHARM JAYA (10 STP X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',30,0),('35c33b78-2ea8-4702-ae8f-54dd0ae438dd','FITKOM TAB JERUK','FITKOM TAB JERUK','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('35f2b105-7802-446d-881f-97f5f407a6ef','MIRASIC PLUS','MIRASIC PLUS','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('36574898-6c20-4cc9-addc-8e6a68ca5cb9','ASIFIT KAPLET (3 BLISTER X 10 KAPLET)','ASIFIT KAPLET (3 BLISTER X 10 KAPLET)','2016-08-08',NULL,'527476cb-2087-4a59-a239-e3e33c731cbc','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('3682c42c-eff3-4424-a820-ddcff5326572','RHINOFED TABLET (5 BLS X 10 TABLET)','RHINOFED TABLET (5 BLS X 10 TABLET)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',20,0),('36a7ee3c-cac2-47da-8a38-3fd1b2fe5e5c','BEDAK SALICYL 2% 60 G','BEDAK SALICYL 2% 60 G','2016-08-08',NULL,'453077e2-a7fb-4f81-b6d8-936cbef4fab3','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',2,0),('36f18236-d50a-435e-9869-968e0b2f0025','AMARYL 4 MG (3 STP X 10 TAB)','AMARYL 4 MG (3 STP X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('37cdc631-a446-477e-b477-5f6d3568add5','BYE BYE FEVER BAYI FOR BABY 10\'S','BYE BYE FEVER BAYI FOR BABY 10\'S','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',2,0),('3955cea0-71f2-40e7-a1c0-f30bcab88250','DIATABS','DIATABS','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('3970bb04-951f-4143-9f9a-9c5bedef7140','SISTENOL','SISTENOL','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('39832a2f-9e73-472a-910b-4a5e4081ce99','FRESHCARE HOT/STRONG','FRESHCARE HOT/STRONG','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('39ec1054-d8a8-4e7e-84fc-984740b0f8f2','ALKOHO 70 % CITO 300 CC','ALKOHO 70 % CITO 300 CC','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('3bb38ddc-5073-46f7-ad04-d6862c1ac3c2','GOLD G / TERIPANG / GAMAT KECIL 320 ML','GOLD G / TERIPANG / GAMAT KECIL 320 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('3bcf2b03-f78d-4b94-9083-b6ef6ab40739','IV ABBOCATH NO. 22','IV ABBOCATH NO. 22','2016-08-08',NULL,'453077e2-a7fb-4f81-b6d8-936cbef4fab3','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',2,0),('3c19cf31-4728-4f15-b413-11413f7181fa','VOLTAREN EC 50 MG (5 BLS X 10 TAB)','VOLTAREN EC 50 MG (5 BLS X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',10,0),('3c36cb75-c784-483d-a044-42bdd241254a','ZEVIT GROW 15 X 8 \' S','ZEVIT GROW 15 X 8 \' S','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('3c4fcbe7-a749-4756-8385-27ec1f53c6ee','BETADINE SALEP 5 GR','BETADINE SALEP 5 GR','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('3c961304-e675-4a2a-bd21-15dbfb7297fb','SULDOX','SULDOX','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('3cc43db8-3894-4bc1-9c71-a199f253e1c5','FRESHCARE CITRUS','FRESHCARE CITRUS','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('3d56278b-58dd-4f82-9169-d8a478a21b43','AMOXSAN DRY SYRUP 125 MG/5 ML 60 ML','AMOXSAN DRY SYRUP 125 MG/5 ML 60 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('3d78e24e-457a-4e4e-be79-a8ea7be2f184','ONDANSETRON 8 MG /4 ML(INDOFARMA)','ONDANSETRON 8 MG /4 ML(INDOFARMA)','2016-08-08',NULL,'2edc961e-8693-429d-973a-299182d28690','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('3d9d81c3-3528-40a0-a29a-a34658dc8075','Y\'RINS 120 ML','Y\'RINS 120 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('3dac8d81-16af-4e9b-9f3f-b3cca940035e','HABBASYI OIL / MINYAK HBBA 500 L ISI 75 KAPSUL KECIL','HABBASYI OIL / MINYAK HBBA 500 L ISI 75 KAPSUL KECIL','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('3dc08832-a380-4356-b01b-cf00527a0630','TOLAK ANGIN CAIR','TOLAK ANGIN CAIR','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('3dea9f95-b976-4f2f-b22e-aaaf3a890eec','FISHERMAN\'S 24 \'S SF MINT HJ PTH','FISHERMAN\'S 24 \'S SF MINT HJ PTH','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('3df8f1c8-101e-4352-8593-030d958186d4','FARMOTEN 12,5 MG','FARMOTEN 12,5 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('3e28f39e-bbcf-43c6-88aa-f5c29c3b2307','HUFADIAR SYR','HUFADIAR SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('3e5946fb-f320-4e59-b4ac-017980a6a74a','ANTIMO','ANTIMO','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('3e700502-6382-4f52-a5df-175e7407dc4c','VITALONG -C 500 MG 25X 4\'S','VITALONG -C 500 MG 25X 4\'S','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('3e9aef4d-7b15-4cab-9e07-84245b9a7090','SENSITIF UJI HAMIL','SENSITIF UJI HAMIL','2016-08-08',NULL,'eddf7518-491f-4713-bf70-85bab5a09938','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('3fc3e6ff-2011-4022-bd3a-6c826cbc2411','SVT 10 MG','SVT 10 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('401f52f9-0183-4466-857b-aa5e512fa4b1','FASGO','FASGO','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('407fad1b-31fd-41a8-9e2e-26e407355981','DANOXICILLIN','DANOXICILLIN','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('40858ddf-87fc-47ac-8f18-f1d67e2bdea9','KALBIOTIC 500 MG','KALBIOTIC 500 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('412a5592-b458-4ca6-9e93-ebc6459ad9f7','MEPTHICA 500 MG','MEPTHICA 500 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('4167a503-bf99-413a-aa33-d645212307f5','ANTANGIN JRG CAIR','ANTANGIN JRG CAIR','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('41bd6355-9d61-47b9-bb0b-ceda1aae21fc','KALPANAX KRIM 5GR','KALPANAX KRIM 5GR','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('433efd3b-65e9-4918-9b26-586aabdf8b9c','ALLERON (Chlorpheniramine maleat / CTM )','ALLERON (Chlorpheniramine maleat / CTM )','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('43659546-bd7c-4146-b6eb-27f8be761a4d','ALOFAR 300 MG (10 STP X 10 KAP)','ALOFAR 300 MG (10 STP X 10 KAP)','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('43afb9fc-1f57-4e00-a93b-bf51de20e7e1','FATIGON TAB 15 X 4\'S ( vitamin)','FATIGON TAB 15 X 4\'S ( vitamin)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('43eecce1-b6f8-4ed1-a8f6-3f029d3bc1d6','DIONICOL 500 MG','DIONICOL 500 MG','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('44218b4c-d4ba-4c94-950e-f905c18d68f2','KALK NELCO 100\'S','KALK NELCO 100\'S','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('44315dc2-e2fa-44dd-8de8-8330ed4de153','GLUMIN XR','GLUMIN XR','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('4462502a-223f-4d8a-9814-1ec1a96574c4','KOMIX JERUK NIPIS 30\'S','KOMIX JERUK NIPIS 30\'S','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('44b4fbde-329c-4d62-aebf-e51e7317bf76','OMEDESON','OMEDESON','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('44be9244-8a08-401b-967d-785cc71d6a3a','TIFLAM','TIFLAM','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('45244017-1aa1-4e0a-9540-5006fef47712','PANADOL ( Paracetamol 500mg )','PANADOL ( Paracetamol 500mg )','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('4542439b-97fb-4d26-8536-8feeb4dfc137','CLANEKSI DRY SYRUP 60 ML','CLANEKSI DRY SYRUP 60 ML','2016-08-08',NULL,'e7213b99-369f-4b28-92be-80fc0ec57886','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('45aa3047-9d7f-47e7-acc4-5b66206c38ab','DIVENS TAB','DIVENS TAB','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('46033846-68ce-4db7-904d-f882dfda42ff','NATRIUM DIKLOFENAC','NATRIUM DIKLOFENAC','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('4631afb4-5070-441c-8577-a4a546362f3c','KANNA KRIM 30 G','KANNA KRIM 30 G','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('46d3047b-e587-4be6-8282-58ecba0fed31','MIXAGRIIP FLU&BATUK','MIXAGRIIP FLU&BATUK','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('475990d7-a7ee-46c3-9ed3-ec1079542117','ERPAFLAM','ERPAFLAM','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('479eaf77-b6ff-4506-9add-222234d4bf8b','VICKS VAPORUB 10 G','VICKS VAPORUB 10 G','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('48196acf-26db-4a60-b7f0-7377d408d8c4','DACIN','DACIN','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('4b062d45-5166-4864-88fa-3b8fe398a933','PIRACETAM 400 MG','PIRACETAM 400 MG','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('4b4313d1-4ec1-49cc-b023-a175c2696263','CLORAMFECORT 10 GRAM','CLORAMFECORT 10 GRAM','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('4c661b0f-2e20-4d75-9dd6-c2b2a075f136','CURCUMA PLUS','CURCUMA PLUS','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('4e196243-c077-49e7-9ff6-b6d188a9f10a','VOLTAREN EMULGEL 5 G','VOLTAREN EMULGEL 5 G','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('4e6b8e5d-2296-42a4-9cfc-35b0907fcdd1','SAN-B-PLEX DROPS 30 ML','SAN-B-PLEX DROPS 30 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('4ea9c4ef-d4f6-4754-94cf-d612c7ce9e6c','NEO REUMACYL NK&SH CREAM 30 G','NEO REUMACYL NK&SH CREAM 30 G','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('4eb68a82-560b-41b0-bdd7-3c7bb9609939','SUTRA 3\'S FIESTA MINT','SUTRA 3\'S FIESTA MINT','2016-08-08',NULL,'f66bccf3-c3ab-46b6-b8b7-5b19a1fdda3a','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('4effe726-17dd-4133-a179-cd6415fba98e','GLUDEPATIC 500 MG','GLUDEPATIC 500 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('4f6f1a5c-8c63-4398-a1a7-d3fca7a0c400','KONDOM SUTRA HITAM 24 X 3\'S','KONDOM SUTRA HITAM 24 X 3\'S','2016-08-08',NULL,'eddf7518-491f-4713-bf70-85bab5a09938','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('4f829a87-bbba-452c-968a-7d3c063ec45b','HANSAPLAST PLESTER 1,25 X 5 M','HANSAPLAST PLESTER 1,25 X 5 M','2016-08-08',NULL,'8f832dfa-55ee-405d-9dcd-795264b3c656','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('4fccf62e-f6c6-46d9-948b-ff2c1f769fff','BODREXIN FLU  & BATUK  SYR 56 ML - BR','BODREXIN FLU  & BATUK  SYR 56 ML - BR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('5062d5a6-46a9-40b3-8b47-d8967781b60a','LEVOFLOTACIN 500 MG','LEVOFLOTACIN 500 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('5138aa27-233b-4d0f-bbfc-47152952a31f','PEDIALYTE BUBBLE GUM 500 ML','PEDIALYTE BUBBLE GUM 500 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('528ead48-3584-468c-aaa1-5484a33230f7','LEXAPRAM','LEXAPRAM','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('52bb3edc-e029-4ced-8e97-2e2afc53a71d','MIRASIC  500 MG ( Paracetamol 500mg)','MIRASIC  500 MG ( Paracetamol 500mg)','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',3911,0),('5368a724-8791-4235-a3c3-14be6a7c8366','CURBEPLEX SYR','CURBEPLEX SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('53d674c2-6f13-48bb-b4e2-3d2a39541852','SIMVASTATIN 10 MG HEXPHARM JAYA (5 STP X 10 TAB)','SIMVASTATIN 10 MG HEXPHARM JAYA (5 STP X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',20,0),('53d8fc10-c72b-46e4-ad97-dee6500c19d6','MICROLAC','MICROLAC','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('53f9ec0d-c5a3-46f0-b51b-3a1f0fad63f8','CENDO XITROL 5 ML','CENDO XITROL 5 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('5463545e-fff0-4208-aec6-0d308efacdc1','INCETRON 4 MG/2ML (1 BOX X 5 AMPUL)','INCETRON 4 MG/2ML (1 BOX X 5 AMPUL)','2016-08-08',NULL,'2edc961e-8693-429d-973a-299182d28690','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('552a43b5-8cb6-4d1d-94f3-1d85131a3d33','MIXAGRIP','MIXAGRIP','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('554e6acf-fe8b-4b05-ae61-78459743c39d','MADURASA ORANGE/ JERUK NIPIS (1 KOTAK @ 12 SACHET @ 25 G)','MADURASA ORANGE/ JERUK NIPIS (1 KOTAK @ 12 SACHET @ 25 G)','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',3,0),('5598b1d3-8885-4b91-a415-8eae6cce5b33','FOLEY CATHETER NO. 16','FOLEY CATHETER NO. 16','2016-08-08',NULL,'453077e2-a7fb-4f81-b6d8-936cbef4fab3','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('561e3e8a-72c4-4cc0-9a4e-55af1ee4d97a','DERMATIC ULTA 7 G','DERMATIC ULTA 7 G','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('5657e79e-8248-418d-8286-45852459a396','MINYAK ANGIN KAPAK 3 ML','MINYAK ANGIN KAPAK 3 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('565834a0-66bc-4d40-84ed-e3c96d4fc77f','PROPEPSA SYR','PROPEPSA SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('56c34599-fb09-49f1-b19a-09dbe50f41fe','DIGENTA CREAM 10 GRAM','DIGENTA CREAM 10 GRAM','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('56df21f7-d44f-473c-9302-a84b3c40b8c4','LANSOPRAZOLE 30 MG (2 STP X 10 KAPS)','LANSOPRAZOLE 30 MG (2 STP X 10 KAPS)','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',6,0),('5790faa7-4875-41cd-be5f-b17b890b1393','JUSTIN 20 MG','JUSTIN 20 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('5794b252-93ea-4cee-aa14-dbc63204ecfa','LANCET','LANCET','2016-08-08',NULL,'453077e2-a7fb-4f81-b6d8-936cbef4fab3','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('579e5f38-ef72-448c-865f-8e80b04e25df','BALSEM GELIGA 10 G LANG','BALSEM GELIGA 10 G LANG','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('57eeb061-a4c6-4d90-b970-89facb3f46be','SUPRASMA INJ','SUPRASMA INJ','2016-08-08',NULL,'038515dd-4524-496a-a4ae-ff7370ef60d9','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('58251241-af23-4db9-8898-c5c598d15c9e','FARGOXIN 0,25 MG','FARGOXIN 0,25 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('58bddaf4-9a09-4467-a875-076afa91c497','OBH COMBI PLUS MADU  60 ML','OBH COMBI PLUS MADU  60 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('58e969cf-bf1c-4aeb-9029-04baeef1b071','ZEGASE (10 BLS X 5 KAPL)','ZEGASE (10 BLS X 5 KAPL)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',5,0),('590bc58c-aa06-4cb8-997d-b7abf367c28b','OMEDOM','OMEDOM','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('591dd6bb-f2f6-4b00-828f-5f7a869f361d','CEFADROXIL 500 MG( 5 STP X 10 KAPS)','CEFADROXIL 500 MG( 5 STP X 10 KAPS)','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',20,0),('59216eee-bf00-4692-950c-2cf34e629738','OBAT BATUK IBU & ANAK 75 ML / OBIDA KECIL','OBAT BATUK IBU & ANAK 75 ML / OBIDA KECIL','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('59edbac4-7aae-4008-817d-eeeb02bd28c7','HEXOS MINT 50 X 5 \'S','HEXOS MINT 50 X 5 \'S','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('5abe998d-42be-49d3-a2dd-2a2aff059473','MIRATRIM SYR','MIRATRIM SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('5aef0cff-d054-45c2-a26e-98e57f13544b','PACDIN COUGH SYRUP 60 ML','PACDIN COUGH SYRUP 60 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('5af83213-24cf-410e-af75-65c824ee431f','THERMOLYTE PLUS 30\'S','THERMOLYTE PLUS 30\'S','2016-08-08',NULL,'f66bccf3-c3ab-46b6-b8b7-5b19a1fdda3a','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('5b57adca-ba56-4bca-8f04-28e81565e91e','MYLANTA SYR 50 ML / K','MYLANTA SYR 50 ML / K','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('5ba92538-5b76-46c0-85cd-870ffb1b9db6','BROADAMOX 125 MG/5 ML','BROADAMOX 125 MG/5 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('5c293368-1897-4eb3-9915-e1cf6351d918','ACTAPIN 10 MG (3 STP X 10 TAB)','ACTAPIN 10 MG (3 STP X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('5c2fa992-184b-405e-b219-1041885afd21','SCABIMITE 10 GRAM','SCABIMITE 10 GRAM','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('5d1875c6-e3d3-4061-bd24-bdde0498a502','PARATUSIN','PARATUSIN','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('5d50e9c0-84d0-4d31-8d02-f3825a3112fe','IV ABBOCATH NO. 24','IV ABBOCATH NO. 24','2016-08-08',NULL,'453077e2-a7fb-4f81-b6d8-936cbef4fab3','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',2,0),('5e0061bd-4ce4-4bfd-9568-d82450b30e36','INFUSAN NS DP (1 BOX X 24 KOLF) SANBE','INFUSAN NS DP (1 BOX X 24 KOLF) SANBE','2016-08-08',NULL,'f5d20b38-1fa8-4ae8-95af-94f638af73f7','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('5e3725dd-9e90-41d5-834a-80bfb0b40a79','CHLORAMPHENICOL 1% SALEP MATA 5 G','CHLORAMPHENICOL 1% SALEP MATA 5 G','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',2,0),('5f70495e-f309-4199-a38c-8272f1267a13','GRYCERYL GUAIACOLATE','GRYCERYL GUAIACOLATE','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('5fae8412-5d0f-46ca-a473-09bd9c0b1ca8','RHEMACOX 15 MG','RHEMACOX 15 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('602bb8b3-b9ac-470b-b519-f767d37ff595','VERBAN ELASTIS 6\' 15 CM X 4,5 M GC','VERBAN ELASTIS 6\' 15 CM X 4,5 M GC','2016-08-08',NULL,'453077e2-a7fb-4f81-b6d8-936cbef4fab3','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('60725462-8375-40e5-8b76-2b92291b91a2','ENTROSTOP','ENTROSTOP','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('6076d39a-51dc-4d7f-b59b-8a81bd1e601d','MINYAK GPU 60 ML','MINYAK GPU 60 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('60b2c200-fffa-4abb-bd81-b0f0a7cfbb2f','DERMARAL 10 GRAM','DERMARAL 10 GRAM','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('616d646d-4e53-45c4-a584-f657a6cccb09','ZENDALAT 10 MG','ZENDALAT 10 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('61bb5f10-9e56-4152-b8ee-a08b606f4e4a','BYE BYE FEVER ANAK','BYE BYE FEVER ANAK','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',2,0),('626b88e8-5e08-437b-b5e9-649a410fac46','ZYPRAZ 0,5 MG (5 STRIP X 10 TABLET)','ZYPRAZ 0,5 MG (5 STRIP X 10 TABLET)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','e919219f-1e49-465b-b139-e27b6b1f3a1c','FINISHGOOD',10,0),('62d86106-b325-4359-b9ec-268e745553ed','NALGESTAN (25 STP X 4 TABLET)','NALGESTAN (25 STP X 4 TABLET)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',12,0),('62e4d93e-949e-4136-9628-cca17c0eadd9','TAVORA 20 MG','TAVORA 20 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('63117b43-e0d4-4cb0-bd97-088027d7be28','ENERVON C 25 X 4\'S','ENERVON C 25 X 4\'S','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('635fb567-5a30-46a0-92e9-d24c2bf9340f','KALBIOTIC SYR','KALBIOTIC SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('63c478b7-eeb8-4fb7-82c7-2d8fdd37a448','GEMFIBROZIL 300 MG (10 BLS X 12 KAPS)','GEMFIBROZIL 300 MG (10 BLS X 12 KAPS)','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',24,0),('63c4e0ef-6ebc-464d-adf9-1d5dce38473b','LOSTACEF 250 MG SYR','LOSTACEF 250 MG SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('642632bb-2fdb-44e0-be92-e24ae6af802c','CAVIPLEX ( Vitamin)','CAVIPLEX ( Vitamin)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('6437460d-aebc-43e0-9172-ad29b40444ad','MINYAK TELON LANG 60 ML','MINYAK TELON LANG 60 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('64c9411a-f84d-48e2-9278-9f32f2be4827','DERMATIX ULTRA 7 G','DERMATIX ULTRA 7 G','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('65226da3-5150-408e-94f0-dd3c4eb90443','FORMULA 44 ANAK  27 ML STRAWBERRY','FORMULA 44 ANAK  27 ML STRAWBERRY','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('65452f02-fea6-4557-b2d1-16b5c7cb699a','ANDALAN POSPIL 0,75 MG','ANDALAN POSPIL 0,75 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('65cd8f3c-3823-4bdb-8c3b-1bc6f0430048','SALONPAS GELL 15 G','SALONPAS GELL 15 G','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('665c04ae-578b-4cd8-b1e9-933f12d34994','IV VENFLON NO. 20','IV VENFLON NO. 20','2016-08-08',NULL,'453077e2-a7fb-4f81-b6d8-936cbef4fab3','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',2,0),('6663aebb-4ed2-48bf-8625-7f875052bc7b','LACYFIR 5 GRAM','LACYFIR 5 GRAM','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('66c61c70-fe7e-4b9c-b58b-72766e0d8413','VERILE ACNE GEL 10 G','VERILE ACNE GEL 10 G','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('672947e3-41dd-4c7f-bf34-824b0dd04ee7','LAXING','LAXING','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('68172e37-b09a-4a41-b9b3-a1fa7714310e','CEFRIAXON INJ','CEFRIAXON INJ','2016-08-08',NULL,'038515dd-4524-496a-a4ae-ff7370ef60d9','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('681f1db6-6a6c-41d4-8e48-df52a4d07135','FISHERMAN\'S 24 \'S LEMON - KNG PTH','FISHERMAN\'S 24 \'S LEMON - KNG PTH','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('6885ead4-766d-4d90-95b6-62b83e0d62f6','SAFE CARE 10 ML','SAFE CARE 10 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('689937cd-f309-47a2-a1b7-812c792e5062','ESTER C HOLISTICARE','ESTER C HOLISTICARE','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('68bc940c-4a69-4656-a72b-7eba9efc6987','VITAMI B1 50\'S IPI','VITAMI B1 50\'S IPI','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('692315c9-fc59-4954-ac73-05aa49d2d9a1','COUNTERPAIN CR 15 G','COUNTERPAIN CR 15 G','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('6977de00-516c-4a83-bb4a-c62cdf78c088','FISHERMAN\'S 24 \'S MINT HJ','FISHERMAN\'S 24 \'S MINT HJ','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('69848a12-92b1-43a8-a17a-7508e5065415','LOSTACEF','LOSTACEF','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('69a092a5-158d-44df-90c8-025ce8f26d68','OMEPROKSIL','OMEPROKSIL','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('6a109be9-3ad5-4287-ab6f-2300dfbea49c','INFUSAN D5 DOUBLE PORT (1 BOX X 24 KOLF) SANBE','INFUSAN D5 DOUBLE PORT (1 BOX X 24 KOLF) SANBE','2016-08-08',NULL,'f5d20b38-1fa8-4ae8-95af-94f638af73f7','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('6adbd5fc-961e-4ccc-a08c-0a4dd9094b68','CETROL','CETROL','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('6b0abda0-9adc-409b-94a3-e7b6723c4be3','STIMUNO SIRUP 60 ML ORIGINAL','STIMUNO SIRUP 60 ML ORIGINAL','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('6b2cb11a-7607-48e6-ab8d-850cb701e1c0','VERBAN ELASTIS 4\' 10 CM X 4,5 M GC','VERBAN ELASTIS 4\' 10 CM X 4,5 M GC','2016-08-08',NULL,'453077e2-a7fb-4f81-b6d8-936cbef4fab3','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('6b42eaba-807c-4697-918d-e5d432bb83f2','CARSIDA SYR','CARSIDA SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('6c07f9de-da43-4f10-b6df-1fc86d407e83','BENAKOL DTM SYR','BENAKOL DTM SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('6c3b04c3-0627-4e1e-8bc5-4d19a2adabe8','SANAFLU KAPLET (25 STP X 4 KAPLET)','SANAFLU KAPLET (25 STP X 4 KAPLET)','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',12,0),('6c9f3ce2-358a-4b37-8794-43ab3788b58c','ENKASARI','ENKASARI','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('6cbf8685-c3bc-4bd3-9dfe-9edf3a0eb35d','ZENIREX SYR','ZENIREX SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('6d159603-dad6-4913-b824-7adf31304971','MEFINAL 500 MG KAPLET ( Asam Mefenamat 500mg / 10 STP X 10 KAPL)','MEFINAL 500 MG KAPLET ( Asam Mefenamat 500mg / 10 STP X 10 KAPL)','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',20,0),('6d745229-9f24-4476-9dde-9fba11c73668','KALK NELCO 30\'S','KALK NELCO 30\'S','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('6d78718a-6d47-4434-ae4e-fb33df9a0714','HUFADEXON 0,5 MG','HUFADEXON 0,5 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('6dee2dfe-043b-4bb7-a500-9a918d85d86b','BEDAK HEROCYN 75 G','BEDAK HEROCYN 75 G','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('6e17ec90-63af-41c3-8cac-5bd946faaf82','RIVANOL CITO 300 ML','RIVANOL CITO 300 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('6e5cc3e8-2eab-4709-b6f6-02ffd02ccc99','CAPTOPRIL 25 MG (10 STP X 10 TAB)','CAPTOPRIL 25 MG (10 STP X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',30,0),('6e98c5ca-3261-495e-89d1-4a46156ca08c','AMBEVEN','AMBEVEN','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('6ede563d-0aa2-4bdd-ab9d-199fb73117dd','BODREX','BODREX','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('6ef114dd-7073-45bb-8b29-c3d8aae1c636','KETOCONAZOLE 2% CREAM 15 G NOVELL','KETOCONAZOLE 2% CREAM 15 G NOVELL','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('6f029a46-7aff-4d7d-be04-13e5b1f17e8f','ZANTIFAR','ZANTIFAR','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('6f464606-9908-4437-ae5f-2949a0547126','METHILPREDNISOLON 8 MG','METHILPREDNISOLON 8 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('6f5dda22-2d2b-41a1-a350-3199c935c163','FLOTAVID 200 MG','FLOTAVID 200 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('706f8cc4-f647-4992-87c8-a17a2ec549f2','MKP LANG FAMILLY SIZE 210 ML CAJUPUT','MKP LANG FAMILLY SIZE 210 ML CAJUPUT','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('7071cada-b946-433b-bf14-87dd877b3ab1','ELKANA CL EMULSI 120 ML','ELKANA CL EMULSI 120 ML','2016-08-08',NULL,'e7213b99-369f-4b28-92be-80fc0ec57886','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('70792786-2f74-4516-a571-39c9b8a3af9f','MIRASIC - PLUS KAPL 10 X 10 \'S','MIRASIC - PLUS KAPL 10 X 10 \'S','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('70bc2b1a-2985-4f27-a201-38796f2b5fa5','FAKTU SUPP','FAKTU SUPP','2016-08-08',NULL,'21ee2def-bf0c-48ac-9f4f-1390dd5932fa','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('715941ea-e398-49a7-b9e2-53d8a5f0baf1','DEXTEEM PLUS','DEXTEEM PLUS','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('71c2099c-5089-4be3-b714-5f53900cb009','THERABEX TAB','THERABEX TAB','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('71f37d5f-4a06-4757-9d36-e1691aea628f','PROMAG TABLET (1 KOTAK @ 3 BLS @ 10 TABLET)','PROMAG TABLET (1 KOTAK @ 3 BLS @ 10 TABLET)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('723ccfad-6157-4421-9647-3aa8fc6d4ada','HEXAVASK 5 MG (Amlodipin 5mg / 3 STP X 10 TAB)','HEXAVASK 5 MG (Amlodipin 5mg / 3 STP X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',10,0),('7353aa67-3256-4ce2-9d6e-f20ddeb3be76','AZITHROMYCIN 500 MG','AZITHROMYCIN 500 MG','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('7402a1f5-7001-4009-a5c4-29b9e09f7a56','BURNAZIN 35 GRAM','BURNAZIN 35 GRAM','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('742a55d2-b11b-481c-8cc2-20d85daac577','INZANA','INZANA','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('7445ba41-b22b-43b4-9430-6e085dc47bb0','MADU TJ SACHET STRAWBERRY (1 KOTAK @ 12 SACHET @ 20 G)','MADU TJ SACHET STRAWBERRY (1 KOTAK @ 12 SACHET @ 20 G)','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',3,0),('744997b4-9d98-44f3-8eff-6ed0583b6be1','OBH COMBI FLU ANAK STRAWBERRY ML','OBH COMBI FLU ANAK STRAWBERRY ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('746ec058-c48a-4a7d-a2db-907773279793','BETADINE SALEP 10 GR','BETADINE SALEP 10 GR','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('7490d418-9e65-4162-b095-3706d98cec65','LOSTACEF 125 MG SYR','LOSTACEF 125 MG SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('74a69361-60e9-4af8-8765-eac724021451','GUANISTRIP SYR 60 ML','GUANISTRIP SYR 60 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('751d2111-d008-4523-b8a2-153b5d85c7a1','THERMOMETER DIGITAL FLEXIBEL  GC','THERMOMETER DIGITAL FLEXIBEL  GC','2016-08-08',NULL,'453077e2-a7fb-4f81-b6d8-936cbef4fab3','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('752be6c7-a8e5-4f8b-a309-2f79926c6f47','MADU TJ SACHET JERUK (1 KOTAK @ 12 SACHET @ 20 G)','MADU TJ SACHET JERUK (1 KOTAK @ 12 SACHET @ 20 G)','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',3,0),('756a6964-9037-44fc-aa3b-ce6dd9cd062d','GRALIXA 40 MG','GRALIXA 40 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('75b4abba-6596-457a-af5e-c2e9d257c28c','BABY COUGH SYR 60 ML UNI','BABY COUGH SYR 60 ML UNI','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('76c588c8-fd4e-460c-bc82-32d0f60eed1a','VERMINT 250 MG 30\'','VERMINT 250 MG 30\'','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('770068c9-eb27-4bfb-b29d-f0ec9fc23d8e','NO DROF','NO DROF','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('7819a076-6e2b-40d6-8fb5-82352074c6c5','ORPHEN (Chlorpheniramine Maleat / CTM )','ORPHEN (Chlorpheniramine Maleat / CTM )','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('78400bc3-34aa-4448-a70b-50a85ad93785','RHINOS JUNIOR SYRUP 60 ML','RHINOS JUNIOR SYRUP 60 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('785f325c-93cd-4e3f-833a-7b448482f285','KONVERMEX 250 MG','KONVERMEX 250 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('7867372a-5231-4c40-be88-92a77ce74340','TRANSPULMIN BB BALSAM 10 G','TRANSPULMIN BB BALSAM 10 G','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('78beadff-493c-4956-a1f1-dc7745b357a7','NEURALGIN','NEURALGIN','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('78e8bf51-ff4b-40af-b5af-8649051bc388','HABBATUSSAUDAH CAP KURMA AJWA ISI 120 KAPSUL KECIL','HABBATUSSAUDAH CAP KURMA AJWA ISI 120 KAPSUL KECIL','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('78f0d0d4-0f97-41ad-b2ef-59bca9b38470','STIMUNO FORTE KAPSUL (BOX ISI 1 BLISTER @ 10 KAPSUL)','STIMUNO FORTE KAPSUL (BOX ISI 1 BLISTER @ 10 KAPSUL)','2016-08-08',NULL,'f66bccf3-c3ab-46b6-b8b7-5b19a1fdda3a','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('79f1c6f1-c0c3-4a62-b7af-12c2618a554e','ANDALAN PIL KB (15 DUS X 2 BLS)','ANDALAN PIL KB (15 DUS X 2 BLS)','2016-08-08',NULL,'12d4dba0-5b13-493f-a364-890fbb8f0691','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',5,0),('7a93e08d-12b3-4643-ac13-abb218ef0624','GANDAPURA 30 ML IKA','GANDAPURA 30 ML IKA','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('7b1dcac2-0048-49b3-9f6d-88b48268c161','XONCE','XONCE','2016-08-08',NULL,'eddf7518-491f-4713-bf70-85bab5a09938','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('7c02890e-1b8f-4be3-84ad-b79727abe03b','WATER FOR INJECTION / WFI OTSU 25 ML','WATER FOR INJECTION / WFI OTSU 25 ML','2016-08-08',NULL,'2edc961e-8693-429d-973a-299182d28690','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('7c3e6810-d2a3-491f-aaaa-df23bc921154','MADU TJ RASA JERUK','MADU TJ RASA JERUK','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('7cb2bdf0-f0c3-4588-9798-541920f448a3','NEO REUMACYL CREAM 30 G MRH','NEO REUMACYL CREAM 30 G MRH','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('7d2e8892-f80e-45f9-9a73-56d590bc0e87','WOODS EXP 60 ML / BIRU','WOODS EXP 60 ML / BIRU','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('7da6917f-afda-45c7-a879-2eed000bfc5b','REDOXON EFF - JRK 10\'S','REDOXON EFF - JRK 10\'S','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('7de23c6c-a740-4950-9dc1-a559453a4ca6','MECOQUIN 500','MECOQUIN 500','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('7e21826c-82b4-4d84-82a7-b2b77078a96c','TEOSAL SYR','TEOSAL SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('7e96a11f-735a-4afe-84d3-a229d863b834','SALONPAS KOYO','SALONPAS KOYO','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',3,0),('7efdbb21-13fd-4f57-b50d-0d16f29cef39','ALLOPURINOL 300 MG HEXPHARM JAYA (10 STP X 10 TAB)','ALLOPURINOL 300 MG HEXPHARM JAYA (10 STP X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',50,0),('7f2f11f5-faf2-4327-96ba-6a444834947a','BALSEM GOSOK LANG 20 G','BALSEM GOSOK LANG 20 G','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('7fc2f37e-fcaa-485b-a008-180b15bc9d79','PARATUSIN','PARATUSIN','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('7fcef193-3548-48fc-aeb2-9ef94dacb13f','KOYO CABE 20\'S','KOYO CABE 20\'S','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',3,0),('7fd16ed2-3b51-4d09-b5ed-4bad37a4f0f4','IV VENFLON NO. 22','IV VENFLON NO. 22','2016-08-08',NULL,'453077e2-a7fb-4f81-b6d8-936cbef4fab3','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',2,0),('7fddbe26-7a42-4719-9fda-115517d449f0','MINYAK ANGIN BERUANG 18 ML/TI','MINYAK ANGIN BERUANG 18 ML/TI','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('805eab32-9eb1-4345-8d2a-cca424169ae5','VITAMIN C 50\'S IPI','VITAMIN C 50\'S IPI','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('80b8cfbd-0752-460a-9a21-f5e8554aaacb','ONDANSETRON 8 MG/4 ML (BERNOFAN)','ONDANSETRON 8 MG/4 ML (BERNOFAN)','2016-08-08',NULL,'2edc961e-8693-429d-973a-299182d28690','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('813771de-1fa7-46c2-b11d-f5352868396b','SAGESTAM CREAM 10 G','SAGESTAM CREAM 10 G','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('81887fc2-e1b0-452d-9870-cf402bf80c24','THROMBOPHOB GEL','THROMBOPHOB GEL','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('81bd16af-abfd-4a2a-b92b-15bc2240459c','PROMEDEX SYR 60 ML','PROMEDEX SYR 60 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('822121a6-1bd2-4bea-8e30-109fc6d72492','KANNA KRIM 15 G','KANNA KRIM 15 G','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('82b32d45-0766-4c17-bfa2-855793ee7e8e','EVER E 250 KTK 12\'S (2 STRIP)','EVER E 250 KTK 12\'S (2 STRIP)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('830d777f-32bf-475f-b03b-aba72906c82c','NEURODEX','NEURODEX','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('841c39b8-6ee9-48a1-9b58-2b480ad0c0d1','LODIA 2 MG (6 STP X 10 TABLET)','LODIA 2 MG (6 STP X 10 TABLET)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',10,0),('848536e1-d0f1-499a-8cd1-40bfb1c2efe1','PRIMODIAR 2 MG','PRIMODIAR 2 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('8573a3b3-2381-4989-8194-1d966e8652ef','SANMOL 500 MG (Paracetamol 500mg)','SANMOL 500 MG (Paracetamol 500mg)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('86177d45-c973-47b6-8f6c-8118612b293c','VOLTAREN EMULGEL 10 G','VOLTAREN EMULGEL 10 G','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('86e73666-b52c-4b2f-95cd-dca03265be97','ANDALAN LAKTASI PIL KB (30 AMPLOP X 1 BLISTER X 28 TABLET)','ANDALAN LAKTASI PIL KB (30 AMPLOP X 1 BLISTER X 28 TABLET)','2016-08-08',NULL,'12d4dba0-5b13-493f-a364-890fbb8f0691','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',5,0),('8769c18d-f776-4753-86a9-2a97811c8a7d','YOU C 1000 ORANGE 140 ML','YOU C 1000 ORANGE 140 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('87c22b7c-7853-4de3-9c4a-8fa1d955ce8d','CAPTOPRIL 50 MG (10 STP X 10 TAB)','CAPTOPRIL 50 MG (10 STP X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',30,0),('87cfce04-958b-446e-b8d3-7c6d8f7cc662','SUTEAR / HR','SUTEAR / HR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('88279a62-e47f-402f-8a4f-009765ad102c','SOPRALAN','SOPRALAN','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('886a413c-7025-42fa-b945-90f0ddc80fa1','GENTIAN VIOLET CITO','GENTIAN VIOLET CITO','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('88c9f4f3-663d-48cc-885a-3c3a40389307','MINYAK TAWON CC 20 ML','MINYAK TAWON CC 20 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('88de4ea2-80d9-4152-91aa-4817f82e8f89','VERMNIT KECIL','VERMNIT KECIL','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('89fad77b-ec05-4e93-98b7-2fbe43971f7f','CATAFLAM 50 MG (5 BLS X 10 TAB)','CATAFLAM 50 MG (5 BLS X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',10,0),('8a47259e-e3d5-461c-bc20-184270f4f11b','MINYAK TAWON DD 30 ML','MINYAK TAWON DD 30 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('8a484956-eb83-4a2e-8591-c66825edb086','ELTAZON','ELTAZON','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('8ad9ae17-93e0-49e6-8915-d346b3285e03','HUFAGRIP TMP 60 ML - MERAH','HUFAGRIP TMP 60 ML - MERAH','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('8af03560-3305-471c-8325-9b7acff96352','MYLANTA','MYLANTA','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('8b60e990-a11a-45bf-b90c-83ccda6aac8e','OBH COMBI FLU JAHE 60 ML','OBH COMBI FLU JAHE 60 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('8b8953f3-3901-4053-86bd-4fe8191e3bad','VERMOX 500 MG','VERMOX 500 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('8c0032ee-f608-456f-8986-850db19c98c2','DILAVASK 5 MG','DILAVASK 5 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('8c2d9e22-6bc0-4525-8c22-3fb3d74077ab','POLYSILANE','POLYSILANE','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('8c62ba4e-7a19-4733-a76e-c028a81c7a6e','FORMULA 44 DEWASA 27 ML','FORMULA 44 DEWASA 27 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('8c857058-ba14-46fd-b220-4cf196a557d1','NEURALGIN RHEMA (10 BLS X 10 KAPLET)','NEURALGIN RHEMA (10 BLS X 10 KAPLET)','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',30,0),('8d590898-6df7-4a2b-98f6-7335961781ca','MIRASIC  500 MG ( Paracetamol 500mg)','MIRASIC  500 MG ( Paracetamol 500mg)','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',3911,0),('8da8e399-bf10-4dfc-8363-82722c174366','PERBAN MEDIRAYA 4 X 5CM','PERBAN MEDIRAYA 4 X 5CM','2016-08-08',NULL,'8f832dfa-55ee-405d-9dcd-795264b3c656','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('8e9a55ff-80e9-4d17-a3d5-4f93ec7ac323','CALADINE LOTION 60 ML','CALADINE LOTION 60 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('8ecd4d6f-3bf9-48bd-8cd9-a7b392a8973a','BETADINE 15 ML','BETADINE 15 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('8f2016f0-d21e-4d6f-a661-360fd72135c1','MELOXICAM 7,5 MG (5 STP X 10 TAB)','MELOXICAM 7,5 MG (5 STP X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',20,0),('8f7a2349-7fc0-45d6-89a0-792d076077ac','LARUTAN CAP BADAK 200 ML','LARUTAN CAP BADAK 200 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',2,0),('8fb05868-bcb3-4cbb-ace3-a7927e243a7b','CORSATROCIN 200 SYR','CORSATROCIN 200 SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('8ff8e6a8-d2f8-4f90-9010-f2c74a9b803b','CAPTOPRIL 12,5 MG (10 STP X 10 TAB)','CAPTOPRIL 12,5 MG (10 STP X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',30,0),('90b36043-8450-49a1-be3f-83b984481551','PAGODA PASTILLES MINT 10 GR/ K','PAGODA PASTILLES MINT 10 GR/ K','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('90b93b2a-34f8-43f5-957f-cb47a4551120','BALSEM GELIGA 20 G LANG','BALSEM GELIGA 20 G LANG','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('90c07d25-db37-4060-ba5a-6e5af7dfdf4f','ALLOHEX SYR','ALLOHEX SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('90cea514-a24c-4f8c-b37a-9b868acac2ae','AKURAT TEST PACK','AKURAT TEST PACK','2016-08-08',NULL,'453077e2-a7fb-4f81-b6d8-936cbef4fab3','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',3,0),('91fb4e05-b678-42fa-bb16-8022e2e24e22','COPARCETIN SYR','COPARCETIN SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('925acc48-43d4-49b0-869e-d7b5b198de62','MKP LANG NO. 2 60 ML CAJUPUT','MKP LANG NO. 2 60 ML CAJUPUT','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('92c66aae-c96a-418e-984c-b4f6f45055b3','CORSALIT','CORSALIT','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('936f4c03-b603-41a6-b078-dbfe54b06563','ERYRA FORTE','ERYRA FORTE','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('93bcac5f-f791-47d7-8bd7-c4973506029d','VALISANBE 5 MG (10 STP X 10 TAB)','VALISANBE 5 MG (10 STP X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','e919219f-1e49-465b-b139-e27b6b1f3a1c','FINISHGOOD',20,0),('940bd155-9e53-419b-b24a-bab1df49a63c','MINYAK GPU 30 ML','MINYAK GPU 30 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('940e364c-f540-402b-9228-3b00ab32c624','CDR EFF 10\'S JERUK','CDR EFF 10\'S JERUK','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('941fa182-a1cb-4490-89a6-4ec3d660dee6','HUFAGRIP BP 60 ML  - HJ','HUFAGRIP BP 60 ML  - HJ','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('94d89cc9-8269-4c90-b501-bb4f85d23f81','OTOLIN 10 ML','OTOLIN 10 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('94e09848-c3cc-4302-89eb-25b1e4a7880d','BETADINE 5 ML','BETADINE 5 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('964743e6-56d8-49bd-8441-67ac6fa3b795','DEXTRAL FORTE','DEXTRAL FORTE','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('9765d942-edbc-4d37-993f-6b4cc4fd8c92','SUTRA 3\'S FIESTA STRAWBERRY','SUTRA 3\'S FIESTA STRAWBERRY','2016-08-08',NULL,'f66bccf3-c3ab-46b6-b8b7-5b19a1fdda3a','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('979b84a9-1298-4b81-a180-eca8f1d01982','EPEXOL 30 MG TABLET ( Ambroxol 30mg / 10 STP X 10 TAB)','EPEXOL 30 MG TABLET ( Ambroxol 30mg / 10 STP X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',20,0),('9802b6fb-0db0-4e66-8938-26afdccbcb53','OBH COMBI FLU ANAK ORANGE 60 ML','OBH COMBI FLU ANAK ORANGE 60 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('981207d1-bb18-42a6-b9cc-665574d22b62','HEMAVITON ACTION PAK NEW ( Vitamin )','HEMAVITON ACTION PAK NEW ( Vitamin )','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('984707b1-d587-4507-9309-a91b132bfb98','BODREX','BODREX','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('986f7ca9-4ac0-4350-9b3f-a8d37aaead04','LOKEV','LOKEV','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('99574587-106f-4cca-8241-5ee3aa395b1d','AMLODIPINE BESYLATE 10 MG (3 STP X 10 TAB)','AMLODIPINE BESYLATE 10 MG (3 STP X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',20,0),('99bd428f-3d27-41e7-8604-53cc2c550c24','STIMUNO SIRUP 60 ML GRAPE','STIMUNO SIRUP 60 ML GRAPE','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('99d42967-f9d7-43d6-8667-d98b9f3d5944','HELIXIM','HELIXIM','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('9a2c13fd-a142-46ec-8551-4bc86e1a7626','BETADINE KUMUR 100 ML','BETADINE KUMUR 100 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('9a6d59ef-1828-42ff-a4b8-54cf1a02ccbf','NOURISH SKIN 30 \'S','NOURISH SKIN 30 \'S','2016-08-08',NULL,'f66bccf3-c3ab-46b6-b8b7-5b19a1fdda3a','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('9aa311e3-468a-4e00-b8e1-304a6c7539bf','TREMENZA SYRUP 60 ML','TREMENZA SYRUP 60 ML','2016-08-08',NULL,'e7213b99-369f-4b28-92be-80fc0ec57886','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('9b1fd8eb-8c89-457d-ac6a-93c39ab1b8fd','THIMELON 4 MG','THIMELON 4 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('9b30e01a-1f13-4cb2-a30b-3545cf7e8fbc','AKNIL','AKNIL','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('9b41758d-7e48-48ec-b404-68266f47a57d','AKNIL','AKNIL','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('9b45d4b2-297f-4b31-8029-343daa7a39a2','GLUVAS 2 MG','GLUVAS 2 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('9b8d9856-f332-42c0-8400-ab7318cdd351','DUREX FETHERLITE 3\'S','DUREX FETHERLITE 3\'S','2016-08-08',NULL,'f66bccf3-c3ab-46b6-b8b7-5b19a1fdda3a','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('9bb8e3e3-3b08-411a-a7e6-43148c5cc4f6','EPEXOL SYRUP 120 ML (Ambroxol sy )','EPEXOL SYRUP 120 ML (Ambroxol sy )','2016-08-08',NULL,'e7213b99-369f-4b28-92be-80fc0ec57886','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('9bdd597f-80b5-4660-8436-1c06fcf1a281','FLUDEXIN SYR','FLUDEXIN SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('9d42b826-2089-429f-9f97-e686e146bf08','PHARMATON FORMULA (10 STP X 5 KAPS)','PHARMATON FORMULA (10 STP X 5 KAPS)','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',10,0),('9e3c398b-3c45-49a6-bb2a-0367a986a1e6','VITAMIN A 50\'S IPI','VITAMIN A 50\'S IPI','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('9e8cc1ec-e2fe-41c1-af4c-ed7aab6c0df7','H-BOOSTER SYRUP 50 ML','H-BOOSTER SYRUP 50 ML','2016-08-08',NULL,'0ff680e9-1408-4ee6-90f1-4666659b8efb','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('9eab9be0-7355-4001-86b3-d701aafa247a','HOT IN CREAM AROMATERAPHY','HOT IN CREAM AROMATERAPHY','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('9f9deb9f-6bff-441a-8f97-d5caca47ffff','DUREX EXTRA SAFE 3\'S','DUREX EXTRA SAFE 3\'S','2016-08-08',NULL,'f66bccf3-c3ab-46b6-b8b7-5b19a1fdda3a','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('9fd7b7e8-0265-463f-b973-bac85c31abf4','SABUN SUSU KAMBING 80 G','SABUN SUSU KAMBING 80 G','2016-08-08',NULL,'453077e2-a7fb-4f81-b6d8-936cbef4fab3','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',2,0),('a009032a-47ee-4ca2-99dc-ca8576c39bdc','KETOCONAZOLE 200 MG (10 STP X 5 TABLET)','KETOCONAZOLE 200 MG (10 STP X 5 TABLET)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',10,0),('a08ad19a-61f0-46d4-87b8-8da6c8fe0e3f','BODREXIN','BODREXIN','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('a0eacb3f-5b0e-4833-b9b5-56ed95c0a9f9','KALXETIN','KALXETIN','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('a26b1643-5f37-4b51-b449-2c77bb73b2e2','CINOLON-N CR 10 G','CINOLON-N CR 10 G','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('a2cf4c47-125c-4e86-b578-9eb32c918cdc','ETAPHEN SYR','ETAPHEN SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('a2f0a0e0-671f-4653-b4b6-5f2e80c97ad4','GAZERO HERBAL (1 KOTAK X 6 SACHET)','GAZERO HERBAL (1 KOTAK X 6 SACHET)','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',3,0),('a39c3b64-9c5d-4824-b80a-f5cf58c5297b','PANADOL COLD & FLU','PANADOL COLD & FLU','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('a42e340c-95ea-4b76-82ea-692dace6f11a','PARATUSIN SY 60 ML PRAFA','PARATUSIN SY 60 ML PRAFA','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('a49fe108-ce17-4da1-862b-23448b62fa99','RIVANOL CITO 100 ML','RIVANOL CITO 100 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('a4be3d32-ddb9-4ec1-85d3-74107f1cb9f7','LACYFIR 400 MG','LACYFIR 400 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('a4dc0839-9fda-45ca-ac7b-7c510434d303','GEL PENGURANG GATAL 30 ML','GEL PENGURANG GATAL 30 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('a51eaf49-7f7f-4e87-a3a2-d0099ca70880','DULCOLAX ISI 4','DULCOLAX ISI 4','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('a576e481-1a6c-4809-b47e-2881bf29e1da','VITAMIN B COMPLEX 50\'S IPI','VITAMIN B COMPLEX 50\'S IPI','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('a5e168c0-d73f-4caf-860a-e5cc4cc47ffb','LACTO B','LACTO B','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('a63f33cd-561e-4f75-8fd8-6784c3716e31','DIAPET SYR 60 ML','DIAPET SYR 60 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('a6e3696d-0ee8-4baf-99b4-8e0771fbb187','GLIBENCLAMIDE 5 MG (10 BLS X 10 TAB)','GLIBENCLAMIDE 5 MG (10 BLS X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',30,0),('a6f0a666-72ea-4f60-99c4-42d18487b833','PLANTACID FORTE TAB','PLANTACID FORTE TAB','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('a73fc586-4831-41db-b1be-992e4b8a1687','MINYAK SEREH SITRONELA LANG 60 ML','MINYAK SEREH SITRONELA LANG 60 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('a75016e6-61e9-4521-8abb-65a4449cdd0b','ANTIMO ANAK RASA JERUK','ANTIMO ANAK RASA JERUK','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('a8138880-4276-4f9c-91c8-2a67243b75e5','PARAMEX','PARAMEX','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('a86a1c82-5128-43d8-a865-376d8d6605a0','OFLOXACIN 400 MG','OFLOXACIN 400 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('a87e543d-44d6-4ce5-8cab-722c673e4b06','HANSAPLAST 100','HANSAPLAST 100','2016-08-08',NULL,'07d363af-0f3d-4d29-a09c-432ec3dc6707','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('a8e411d5-e8c0-4648-9ca7-bbe90db1f4a7','GATROFER INJ','GATROFER INJ','2016-08-08',NULL,'038515dd-4524-496a-a4ae-ff7370ef60d9','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('a95f63f1-1949-4f90-8e3d-ff5b4e7e961a','ANAKONIDIN OBH SYR 30 ML','ANAKONIDIN OBH SYR 30 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('a969df9a-af25-4798-9fa7-a2e72520e1f7','DULCOLACTOL SYR  60 ML','DULCOLACTOL SYR  60 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('a98f5afa-f5c0-4922-a065-0d2f5f68001c','SARI KURMA AL-JAZIRA 360 G','SARI KURMA AL-JAZIRA 360 G','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('aaea9111-5d11-460e-b898-c56762aa4455','NEO REUMACYL','NEO REUMACYL','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('aaf6a740-abb1-4a7d-b36b-2ecc0738e723','FISHERMAN\'S 24\'S CHERRY - MRH','FISHERMAN\'S 24\'S CHERRY - MRH','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('ab8cc7d9-09f9-4d10-b6b2-fe0d97a82111','NEUROBION PUTIH (Vitamin)','NEUROBION PUTIH (Vitamin)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('abb5cb67-760d-4be3-b7a1-4ced780cf00c','NEXA 500 MG','NEXA 500 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('ac5376fc-baaa-42b0-98ff-e1ecd592912d','ALKOHOL 70% CITO 100 CC','ALKOHOL 70% CITO 100 CC','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('ac9cf706-1129-4ec9-98de-35e2e3406708','BECOM-C KAPLET (10 STP X 10 KAPL)','BECOM-C KAPLET (10 STP X 10 KAPL)','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',20,0),('acd3b56c-0811-498b-9324-640d56607ef2','MINYAK ANGIN KAPAK 5 ML','MINYAK ANGIN KAPAK 5 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('adc12893-097d-4c38-bbbd-6264ed8bbf3e','INFUSAN RL DOUBLE PORT (1 BOX X 24 KOLF) SANBE','INFUSAN RL DOUBLE PORT (1 BOX X 24 KOLF) SANBE','2016-08-08',NULL,'f5d20b38-1fa8-4ae8-95af-94f638af73f7','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('afdf278b-e323-4208-8a00-0e639c63496f','INFUSAN RL SINGLE PORT (1 BOX X 24 KOLF) SANBE','INFUSAN RL SINGLE PORT (1 BOX X 24 KOLF) SANBE','2016-08-08',NULL,'f5d20b38-1fa8-4ae8-95af-94f638af73f7','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('b0e53c7d-fa19-4d03-8276-5fc5b8bb5973','MAXIMUS DIETARY HERBAL','MAXIMUS DIETARY HERBAL','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('b13ca82b-fbc6-436c-8645-802d56ff7f96','FISHERMAN\'S 24 \'S SF ORI - BR PTH','FISHERMAN\'S 24 \'S SF ORI - BR PTH','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('b1e8d539-2fa7-4c11-bb0d-b6889fb8bced','LAPIFED SYR','LAPIFED SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('b22ca306-7fd8-43ad-802d-1e6a2207999e','CENDO XITROL E 0 3,5 G','CENDO XITROL E 0 3,5 G','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('b23d48e6-88f6-4415-a774-824d604613e7','VEGETA HERBAL (1 HANGER X 12 SACHET)','VEGETA HERBAL (1 HANGER X 12 SACHET)','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',3,0),('b268586d-4579-4679-b24c-8ba634cac4dd','PEDITOX','PEDITOX','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('b27e43c2-9acb-4168-9f5d-4c4c0babcf5a','POLYCROL FORTE','POLYCROL FORTE','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('b2b57a64-575c-4f01-8e49-6d75a13b0b6c','VICKS INHALER','VICKS INHALER','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('b32bbb38-8c60-4dd3-80b7-5d2fedea25d6','PARANERVION TAB','PARANERVION TAB','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('b3437189-8abe-4895-b6e3-f09f4a0fca5f','BIOPLACENTON 15 GRAM','BIOPLACENTON 15 GRAM','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('b39aaef8-7805-4f05-9381-afec13f53977','SUTRA 3\'S FIESTA ULTRA SAFE','SUTRA 3\'S FIESTA ULTRA SAFE','2016-08-08',NULL,'f66bccf3-c3ab-46b6-b8b7-5b19a1fdda3a','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('b475997b-5fd6-4f4c-9333-7c96ca4367a9','AKNIL','AKNIL','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('b48edec6-7d45-4685-ac79-67d694fe6981','FOLAVIT 400µg Tablet (10 STP X 10 TAB)','FOLAVIT 400µg Tablet (10 STP X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',20,0),('b502f59b-35ef-43ad-b51e-d5c45d02b5d8','OMEPROS 30\'S','OMEPROS 30\'S','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('b58a6f2c-6b73-414d-a5b8-f2aca010713c','GARCIA KULIT MANGGIS KAPS 12 X 60 \'S','GARCIA KULIT MANGGIS KAPS 12 X 60 \'S','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('b7356652-f9bf-4916-8040-ed670178da93','VANQUIN PLUS 10 GRAM','VANQUIN PLUS 10 GRAM','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('b77080a1-4dbd-4923-a5b5-bcdf7795740d','NICHOSTAN 500 MG','NICHOSTAN 500 MG','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('b77fcabc-a2e9-4157-94b1-176e5bb493d8','PARACETAMOL MEF (Paracetamol 500mg)','PARACETAMOL MEF (Paracetamol 500mg)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',30,0),('b797a848-7080-4827-b406-1924ac7bcecf','OBAT GIGI BURUNG SAMCO','OBAT GIGI BURUNG SAMCO','2016-08-08',NULL,'453077e2-a7fb-4f81-b6d8-936cbef4fab3','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',2,0),('b799a494-fbd0-41ad-87bd-6929ceec4043','SELVIM 10 MG','SELVIM 10 MG','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('b83db7ea-3f9a-40c7-9366-8cf56fe62584','LYTACUR SYR','LYTACUR SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('b8472f07-a2a4-41c5-b338-e3d5f2b16e39','SOHOBION 5000 INJ','SOHOBION 5000 INJ','2016-08-08',NULL,'2edc961e-8693-429d-973a-299182d28690','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('b85869e6-1f03-4be5-9f4a-74a0646c0272','LELAP','LELAP','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',2,0),('b8cf6bda-59f3-4a48-b9de-f5d8712fde54','SUSU ETAWA 250 G','SUSU ETAWA 250 G','2016-08-08',NULL,'22f1f150-0533-4cdc-a229-9260b752421c','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('b8eed9d5-a538-4c6e-ba3a-b4c05666d0af','CETIRIZINE 5 MG / 5 ML SIRUP 60 ML','CETIRIZINE 5 MG / 5 ML SIRUP 60 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('b97239fd-c18c-4ea7-a8f4-27ca274aac66','MASKER 2 IN 1 / FAME MASK (1 BOX @ 50 PCS)','MASKER 2 IN 1 / FAME MASK (1 BOX @ 50 PCS)','2016-08-08',NULL,'453077e2-a7fb-4f81-b6d8-936cbef4fab3','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',10,0),('b994e8aa-85d4-402e-9b96-6e4b839b9e07','FRESHCARE LAVENDER','FRESHCARE LAVENDER','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('ba451c8c-1999-4ee2-b4da-3e52f18e109a','PIRACETAM 800 MG','PIRACETAM 800 MG','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('baa27c38-f9aa-49a3-8bc4-f63796d77a83','CEREBROVIT XCEL 10 CAPS','CEREBROVIT XCEL 10 CAPS','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('bb27bc70-e246-4a79-962a-52775600eb4a','CTM 4 MG','CTM 4 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('bb427bf0-ee51-4e14-b585-f8d92e08e0ad','HABBATUSSAUDAH CAP KURMA AJWA ISI 210 KAPSUL BESAR','HABBATUSSAUDAH CAP KURMA AJWA ISI 210 KAPSUL BESAR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('bbcb16ce-b29a-4b33-b633-ebecb8211ea3','SUTRA 3\'S FIESTA ALL NIGHT','SUTRA 3\'S FIESTA ALL NIGHT','2016-08-08',NULL,'f66bccf3-c3ab-46b6-b8b7-5b19a1fdda3a','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('bbcc0daf-3f4a-487a-b797-d6b2552c97b1','PANTOPUMP 40 ML','PANTOPUMP 40 ML','2016-08-08',NULL,'038515dd-4524-496a-a4ae-ff7370ef60d9','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('bbdff218-6ed0-4984-bf91-194096003796','FITBON PLUS','FITBON PLUS','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('bbecc8a4-1770-4f1a-89e7-5239fea66cb2','ANAKONIDIN SYR 30 ML','ANAKONIDIN SYR 30 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('bc3117b5-90f1-40fa-bc79-119f1708f934','FASGO SYR','FASGO SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('bc857948-b661-4946-90dc-cb01ad88aaac','YASMIN 1X21 SCT (BOX/21)','YASMIN 1X21 SCT (BOX/21)','2016-08-08',NULL,'f66bccf3-c3ab-46b6-b8b7-5b19a1fdda3a','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('bcadd324-0f18-44f9-9fc3-efae346a55c6','TRIAMCINOLONE','TRIAMCINOLONE','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('bcbc9ffe-fb49-4c43-bb91-85ddc9dddb71','FRUIT 18 JR KIDS 30\'S','FRUIT 18 JR KIDS 30\'S','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('bccb7f35-5065-4ef0-997a-839c35d8f804','SAKATONIK ABC ANTARIKSA \'30 TABLET HISAP','SAKATONIK ABC ANTARIKSA \'30 TABLET HISAP','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('bccdfffa-31da-4bc7-b7ba-6314936cac66','ANTASIDA DOEN','ANTASIDA DOEN','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('be82505d-7012-4894-9797-5de0cbd3c1b8','MINYAK TELON LANG 30 ML','MINYAK TELON LANG 30 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('bead6344-7eff-4998-9733-67ba6c78599d','ONE MED TEST KEHAMILAN','ONE MED TEST KEHAMILAN','2016-08-08',NULL,'eddf7518-491f-4713-bf70-85bab5a09938','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('bf57047a-a2cd-4f22-9c1b-b0a8983fc974','MATOVIT TAB','MATOVIT TAB','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('c04fb5e7-4366-4ed4-8427-e788be8af7a5','PRAVASTATIN 20 MG','PRAVASTATIN 20 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('c0b87cc9-7dd5-4e92-b78c-5b065da4e621','AMOXSAN 500 MG (10 STP X 10 KAPSUL)','AMOXSAN 500 MG (10 STP X 10 KAPSUL)','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',20,0),('c1a2f65d-8640-4296-a54b-aaa1e3d635d0','MIRASIC  500 MG ( Paracetamol 500mg)','MIRASIC  500 MG ( Paracetamol 500mg)','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',3911,0),('c1b5c607-f976-40c3-9c8c-7a53d31fbabf','K LIQUID CHLOROPHYL / KLOROFIL K LINK','K LIQUID CHLOROPHYL / KLOROFIL K LINK','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('c1ffa627-94af-4280-b9ba-8860742229dd','SUTRA 3\'S FIESTA ULTRA THIN','SUTRA 3\'S FIESTA ULTRA THIN','2016-08-08',NULL,'f66bccf3-c3ab-46b6-b8b7-5b19a1fdda3a','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('c247ed0b-33d9-47b9-979c-4577f8b55f05','RILLUS (5 BLS X 6 TAB)','RILLUS (5 BLS X 6 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',6,0),('c267f236-325c-41f6-8a46-56763ecd4b12','BETABLOX','BETABLOX','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('c2ba0874-6005-46c2-ace4-3ab3ab318a79','COPARCETIN','COPARCETIN','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('c2ebfa2f-486d-4784-bb85-8e5524da2ba4','ELKANA SYRUP 60 ML','ELKANA SYRUP 60 ML','2016-08-08',NULL,'e7213b99-369f-4b28-92be-80fc0ec57886','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('c3c83d79-ff0e-4631-9a67-2cd941c54ce7','KOMIX JAHE 30\'S','KOMIX JAHE 30\'S','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('c4f1a4e0-097c-4c74-87d2-5c1ce0c781f9','GRAFLOXIN 400','GRAFLOXIN 400','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('c4f5582b-8803-40b9-80b6-ab99209894d5','TEOSAL','TEOSAL','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('c52ad20c-a94c-4cd5-aa1d-9ca21062c369','SAGESTAM OINTMENT 10 G','SAGESTAM OINTMENT 10 G','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('c5404306-9de8-4113-9ff4-ff5856f00da7','SPUIT 3 CC','SPUIT 3 CC','2016-08-08',NULL,'453077e2-a7fb-4f81-b6d8-936cbef4fab3','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('c5ac1eb3-cb9b-4134-91db-a271a8e1b43e','NOVA B COMPLEX','NOVA B COMPLEX','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('c5b2399d-dd5b-4657-8634-a29f56a6ab61','BODREX EXTRA (25 STP X 4 TABLET)','BODREX EXTRA (25 STP X 4 TABLET)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',8,0),('c5ce14c5-1410-4628-8421-e378e664a208','ZUMAFIB','ZUMAFIB','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('c6379235-1283-482d-926b-b1ca038e1f2d','RATRIM','RATRIM','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('c6cb3613-3b59-4d93-bad5-cbc307a5b147','AVAIL HIJAU (PANTILINER)','AVAIL HIJAU (PANTILINER)','2016-08-08',NULL,'453077e2-a7fb-4f81-b6d8-936cbef4fab3','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',3,0),('c7383f85-c820-45e2-a939-ce24c50ad173','LEPTICA 75 CAP','LEPTICA 75 CAP','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('c770feb5-f73f-4dda-868b-5577dbb125aa','TEMPRA DROPS 15 ML','TEMPRA DROPS 15 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('c7848e87-3983-4bf0-80dc-52e066e312ac','INZA','INZA','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('c7874cc2-e364-48cc-b9b0-e1936d6dd360','PARAMEX','PARAMEX','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('c792c260-f339-4bc5-8647-ebee072b58d5','BUFECT SUSPENSI 60 ML 100 MG/5 ML','BUFECT SUSPENSI 60 ML 100 MG/5 ML','2016-08-08',NULL,'e7213b99-369f-4b28-92be-80fc0ec57886','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('c7e1658e-5de0-4f84-9b17-5d4aae07c76e','VEGE BLEND 21 JR KIDS 30\'S','VEGE BLEND 21 JR KIDS 30\'S','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('c7ebf076-3e1b-4c45-985c-3cd09fd3ecba','FARSIFEN 200 TAB','FARSIFEN 200 TAB','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('c8d40fe1-4615-48ca-84ac-2a08faa62232','TUNTAS PIL','TUNTAS PIL','2016-08-08',NULL,'22f1f150-0533-4cdc-a229-9260b752421c','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('c9438eeb-a4e2-4532-a7b2-e7b0aa4aa16b','VAGISTIN OVULA (BOX ISI 10 SUPP)','VAGISTIN OVULA (BOX ISI 10 SUPP)','2016-08-08',NULL,'21ee2def-bf0c-48ac-9f4f-1390dd5932fa','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',2,0),('c9458386-b9d4-4894-adb4-10fd81c841d3','MKP LANG 15 ML (NO.4)','MKP LANG 15 ML (NO.4)','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',2,0),('c97186d7-0912-4977-8672-d968774c62a7','COUNTERPAIN CR 30 G','COUNTERPAIN CR 30 G','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('c98a019a-981b-485b-86e4-7b3cc62d4d27','SANGOBION (Vitamin)','SANGOBION (Vitamin)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('c9964447-2625-43e3-85ca-67f5ba4e6cfb','ANAKONIDIN SYR 60 ML','ANAKONIDIN SYR 60 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('ca2e5c36-4bbe-4c04-a356-e9ca17e4cc71','VEGETA JERUK DUS 6\'S','VEGETA JERUK DUS 6\'S','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',3,0),('ca67dff0-fdf8-416f-a4eb-ea18fc42d407','PONSTAN FCT500 MG ( Asam Mefenamat 500mg /10 BLS X 10 TAB)','PONSTAN FCT500 MG ( Asam Mefenamat 500mg /10 BLS X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',30,0),('cb080cf5-be76-4956-bca0-d1da336c171b','KOMPOLAX SYR','KOMPOLAX SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('cb1b81ea-20e3-4e77-8dc7-183cb222b81d','FAXIDEN GEL 10 GRAM','FAXIDEN GEL 10 GRAM','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('cb3ed9d0-cf8d-462a-9583-2f04218d69dc','BETADINE VAGINAL DOUCHE 100 ML TA','BETADINE VAGINAL DOUCHE 100 ML TA','2016-08-08',NULL,'f66bccf3-c3ab-46b6-b8b7-5b19a1fdda3a','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('cc980e92-7d48-44d2-af07-2c9f66675e5a','SOFRATULLE 10X10CM 1X10\'','SOFRATULLE 10X10CM 1X10\'','2016-08-08',NULL,'453077e2-a7fb-4f81-b6d8-936cbef4fab3','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',2,0),('cd61cb27-850a-48c4-8a5c-f51db64176e3','BACTRIZOL FORTE','BACTRIZOL FORTE','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('ce29f97c-702e-4ef5-a941-fee79081fe66','NAPACIN','NAPACIN','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('d0449520-ae74-4735-a545-e21a949f1031','VISINE EYE DROPS 6 ML','VISINE EYE DROPS 6 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('d0e980e2-8899-4acd-9c83-5e0e6db0a7ca','LACTACYD WOMAN 60 ML','LACTACYD WOMAN 60 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('d1a4f5b8-dda2-4e1b-8d88-f8f5e76c3b7e','SANMOL SYR 60 ML (Paracetamol 125mg)','SANMOL SYR 60 ML (Paracetamol 125mg)','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('d2662251-68b7-40b4-bdc2-0676f5426730','NOSIB SALEP 14 G','NOSIB SALEP 14 G','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('d29a5c7d-225f-4b41-b036-88e2315ee949','POLIDENT ADHESIVE 6 G','POLIDENT ADHESIVE 6 G','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('d30ecb66-2dbc-479c-b189-ab867dca4473','VASTIGO','VASTIGO','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('d37f5f6d-53be-40ee-85c6-4edb83ce65c7','KOMIX OBH 30\'S','KOMIX OBH 30\'S','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('d395d475-8136-4cf8-a162-5c9420acc2ff','ANALSIK (10 STP X 10 KAPL)','ANALSIK (10 STP X 10 KAPL)','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','e919219f-1e49-465b-b139-e27b6b1f3a1c','FINISHGOOD',20,0),('d39721eb-fa96-454f-bae9-d703cf4655be','MIRASIC  500 MG ( Paracetamol 500mg)','MIRASIC  500 MG ( Paracetamol 500mg)','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',3911,0),('d3ea4f01-19cd-40ec-8c10-3c640de65756','AKNIL','AKNIL','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('d4a2c9ff-e6a9-4261-b6a8-9201a96e70ef','EYEFIT SYR','EYEFIT SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('d56f271f-0d1f-47d9-a879-5d7dbddbf64c','KASSA STERILL WACANA 16 X 20 CM NEW','KASSA STERILL WACANA 16 X 20 CM NEW','2016-08-08',NULL,'f66bccf3-c3ab-46b6-b8b7-5b19a1fdda3a','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('d5867fc3-708d-4fd8-8b83-49598971cfda','FITKOM TAB ANGGUR','FITKOM TAB ANGGUR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('d60f5ae5-e8bf-42ca-b6e9-d6c8d818b875','CENFRESH 0,6 ML @ 5\'S MINIDOSE','CENFRESH 0,6 ML @ 5\'S MINIDOSE','2016-08-08',NULL,'5e5eb7d7-403d-4da7-826c-df47d8dac604','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('d62b1240-3a2b-4a40-8db0-5cd165cfa8f3','BODREX F&B TDK BEDHK','BODREX F&B TDK BEDHK','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('d8125419-2e6a-4f03-91a0-ea1675890f32','AMPICILLIN 500 MG PHARMA LAB (10 STP X 10 TAB)','AMPICILLIN 500 MG PHARMA LAB (10 STP X 10 TAB)','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',30,0),('d818a34d-5107-4798-9acc-3d6f0a2243ee','MINYAK SEREH SITRONELA LANG 30 ML','MINYAK SEREH SITRONELA LANG 30 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('d81b8cfc-b9de-4275-bc14-d29dccbd0ed5','ASAM MEFENAMAT 500 MG (10 BLS X 10 TAB)','ASAM MEFENAMAT 500 MG (10 BLS X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',30,0),('d8f244aa-5e52-470d-813e-9d856a95c577','NIFEDIPINE','NIFEDIPINE','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('d9542fb1-bfa9-4556-be69-60e36511ae01','PIROXICAM 20 MG (10 BLS X 12 KAPS)','PIROXICAM 20 MG (10 BLS X 12 KAPS)','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',24,0),('d997ed5d-8d3f-4951-8241-9627da3a6683','ACARBOSE 50 MG','ACARBOSE 50 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('d9a62fb7-6ef1-4dd9-893a-0d1fb92ec830','ONDANSETRON 8MG','ONDANSETRON 8MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('d9fa83ac-a786-4d41-b318-18c3a8acb8ff','OMEPRAZOLE 20 MG (3 STP X 10 KAPS)','OMEPRAZOLE 20 MG (3 STP X 10 KAPS)','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',10,0),('da9406ae-a2d9-43da-a0f6-a3a6d2bfdc1f','ULTRAFLU','ULTRAFLU','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('db75c674-4ed2-44ce-bcd8-e1d3a51625fa','INERSON 15 GRAM','INERSON 15 GRAM','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('dc7b57d7-2ba4-451d-a5f1-0d0ae4c0c6f3','HEPASIL','HEPASIL','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('dcc86b92-d8d3-47bd-90a7-56deb8051b95','FASGO FORTE','FASGO FORTE','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('dcd20c6e-35f0-49f4-9d9d-d3ec1f966159','ALOFAR 100 MG (10 STP X 10 KAP)','ALOFAR 100 MG (10 STP X 10 KAP)','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('dd0751e7-c88c-473e-94eb-955bd6e0ea8b','ELROID','ELROID','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('dd4d9de7-b0b4-4bf2-a095-cb2e876a2899','REPASS','REPASS','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('de368c77-e855-4ee6-bbb4-89194ee66380','LIVRON B.PLEX (10 STP X 10 TAB)','LIVRON B.PLEX (10 STP X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',30,0),('de4c925c-658e-4d9b-aa04-761b50a2b364','CLOPIDOGREL 75 MG HJ (3 STP x 10 KAPLET)','CLOPIDOGREL 75 MG HJ (3 STP x 10 KAPLET)','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',20,0),('de64e7fc-bcc1-431f-badd-e1ca9df3aa03','VALISANBE 2 MG (10 STP X 10 TAB)','VALISANBE 2 MG (10 STP X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','e919219f-1e49-465b-b139-e27b6b1f3a1c','FINISHGOOD',20,0),('de8c5b61-d15b-47dd-8cc2-a4a75be4c43b','AVAIL PINK (NIGHT USE)','AVAIL PINK (NIGHT USE)','2016-08-08',NULL,'453077e2-a7fb-4f81-b6d8-936cbef4fab3','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',2,0),('de9a4e71-d7f6-4596-ab92-cc4ca0856feb','BRAXIDIN (10 STP X 10 TAB)','BRAXIDIN (10 STP X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','e919219f-1e49-465b-b139-e27b6b1f3a1c','FINISHGOOD',20,0),('dee9470c-6103-48e6-81e5-12b09412553b','DEXACAP 25 MG','DEXACAP 25 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('dfe53a5f-f3cd-4930-bf99-2ef553ea9cba','IV ABBOCATH NO. 26','IV ABBOCATH NO. 26','2016-08-08',NULL,'453077e2-a7fb-4f81-b6d8-936cbef4fab3','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',2,0),('e00d89f5-d632-47da-bf5f-8cf9d7f4be9b','TISSUE SUPER MAGIC MAN ISI 6 SACHET (HITAM)','TISSUE SUPER MAGIC MAN ISI 6 SACHET (HITAM)','2016-08-08',NULL,'22f1f150-0533-4cdc-a229-9260b752421c','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',2,0),('e05eb9c7-ae9f-4ab0-a451-63b849918495','INSTO 7,5 ML / HJ','INSTO 7,5 ML / HJ','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('e07d2c5c-d211-4ba1-ad34-706ef9c5c2f4','VITAL OIL O TELINGA','VITAL OIL O TELINGA','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('e0850b2e-6108-475c-b8d1-3d94274a563b','PARACETAMOL MEF','PARACETAMOL MEF','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('e090d829-4bf3-4c32-9cd8-78d1ef511b84','PAGODA PASTILLES JERUK 10 GR/ K','PAGODA PASTILLES JERUK 10 GR/ K','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('e166d6d7-7cf8-4e5c-a13a-4499d9762f7f','SVT 20 MG','SVT 20 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('e2b230a9-e241-486c-838a-edb2493bdd5c','HELIXIM SYR','HELIXIM SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('e2cf3f60-28f2-452a-b3f4-19b7dbb4caec','NEUROBION PINK (Viatmin )','NEUROBION PINK (Viatmin )','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('e308ba64-e78e-4228-93d9-24a081bef865','SANMAG TAB (10 STP X 10 TAB)','SANMAG TAB (10 STP X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','e919219f-1e49-465b-b139-e27b6b1f3a1c','FINISHGOOD',20,0),('e30c8882-bef9-4f25-8321-ac843a963e44','PILKAB (20 AMPLOP @ 1 BLISTER @ 28 TABLET)','PILKAB (20 AMPLOP @ 1 BLISTER @ 28 TABLET)','2016-08-08',NULL,'c99fc794-b3ff-4afa-af41-18505f9cded7','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',3,0),('e3b20e37-4d91-47d4-8558-99491bb737fd','PIRACETAM 1200 MG','PIRACETAM 1200 MG','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('e40889c8-9ad8-4ccf-b2be-b2deb2ca6964','DOGMATIL','DOGMATIL','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('e4226aff-9dc3-4214-bdd7-3db1100093b4','GANDAPURA 60 ML IKA','GANDAPURA 60 ML IKA','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('e49bac38-aa20-42a8-b709-d07fdbde475c','KINA','KINA','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('e4a44977-647c-44fd-b0d2-e6a3a566288b','HOT IN CREAM MRH','HOT IN CREAM MRH','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('e599645c-8615-4d84-ae88-b7f9e464feb0','OMEDON SYR','OMEDON SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('e5f22872-81b5-4b95-9918-8b1d9a53c654','FISHERMAN\'S 24 \'S ORI PTH','FISHERMAN\'S 24 \'S ORI PTH','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('e6c6610d-1978-42a2-8d28-7961a29e41b6','SALBRON 4 MG','SALBRON 4 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('e6ca24a3-cd1f-42cb-b39b-f9569ffda976','CAMIDRYL INJ','CAMIDRYL INJ','2016-08-08',NULL,'038515dd-4524-496a-a4ae-ff7370ef60d9','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('e6ca4f92-bec8-459a-85ca-9d71e75bf137','NEEDLE 23','NEEDLE 23','2016-08-08',NULL,'453077e2-a7fb-4f81-b6d8-936cbef4fab3','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('e6e9b82a-d5db-47d2-b2c8-d92f49d03713','INCIDAL-OD (5 STP X 10 KAPSUL)','INCIDAL-OD (5 STP X 10 KAPSUL)','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',10,0),('e75543d4-2e88-46ea-9c86-6f81cae97787','INFUS SET DEWASA OTSUKA','INFUS SET DEWASA OTSUKA','2016-08-08',NULL,'453077e2-a7fb-4f81-b6d8-936cbef4fab3','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('e7e27f01-f901-4fa0-88df-2ff7d8eb9d26','CARPIATON 100','CARPIATON 100','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('e80cb4ac-b07e-4600-bae7-a64c2a2f23c1','SCOPAMIN INJ','SCOPAMIN INJ','2016-08-08',NULL,'2edc961e-8693-429d-973a-299182d28690','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('e815dcda-c91e-45e3-9fc1-dd2a575e6e73','SINTROL','SINTROL','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('e88437e1-6136-4b3f-a144-3af04b68d0cc','ROHTO COOL 7 ML','ROHTO COOL 7 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('e8c6ebc2-4883-4850-b365-b2875c00f158','BEDAK HEROCYN BABY 100 G','BEDAK HEROCYN BABY 100 G','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('e93254d9-a933-43d9-b552-a0809afa4da2','FORTEN 50 MG','FORTEN 50 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('e9d0f8af-54e1-49f9-b5e2-a19e42f0e05c','CARPIATON 25 MG','CARPIATON 25 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('e9ded445-9be5-4b49-9785-fccd7a6b52fd','BEDAK CALADINE 60 G','BEDAK CALADINE 60 G','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('eb392a11-14b8-4e54-a103-6ca7b5fcfa1c','KAPSIDA KEMBANG BULAN','KAPSIDA KEMBANG BULAN','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('eb3f3543-7d78-4cf7-b935-009353107611','SANMOL 500 MG (Paracetamol 500mg)','SANMOL 500 MG (Paracetamol 500mg)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('eb415c97-7236-4ac9-9a09-944282ea9575','THERMOLYTE PLUS 10\'S','THERMOLYTE PLUS 10\'S','2016-08-08',NULL,'f66bccf3-c3ab-46b6-b8b7-5b19a1fdda3a','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('ec15592f-6863-4097-93de-a5abad4820e2','DUMIN RECTAL TUBE 125 MG/2,5 ML (5 ALUBAGS @1 RECTAL TUBE @2,5 ML)','DUMIN RECTAL TUBE 125 MG/2,5 ML (5 ALUBAGS @1 RECTAL TUBE @2,5 ML)','2016-08-08',NULL,'ea7c09e7-a2e5-4fc4-a060-1addffb654e7','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',2,0),('ec29bc77-685a-40ae-a6fd-2c7f6eecd9f4','MIRAPON SYR 60 ML','MIRAPON SYR 60 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('ec38ce5b-96cd-4bd1-aede-f1f7364f5826','REMASAL','REMASAL','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('ec6fa4a1-8d0c-4b8d-b6cb-12fb11f43d7b','SPASMNAL (10 STP X 10 TAB)','SPASMNAL (10 STP X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',20,0),('ecb0ba82-2039-4da4-ab4f-b1b25d90e745','ALODAN (10 STP X 10 TAB)','ALODAN (10 STP X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('ecf5648f-6127-407a-a854-0d33b13f7cc9','PROSTACUR','PROSTACUR','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('ed875474-f3f2-4d79-b94f-9db4b3fe5ad0','GUANISTREP SYR','GUANISTREP SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('edace783-6b08-4a15-9194-6cb363bc0f79','DUREX DUA LIMA3\'S','DUREX DUA LIMA3\'S','2016-08-08',NULL,'f66bccf3-c3ab-46b6-b8b7-5b19a1fdda3a','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('ee3f7798-3a92-4dae-92c4-804317e4f8bc','TRAMADOL 50 MG','TRAMADOL 50 MG','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('ee715dd7-b854-4c08-ba5a-17e0b4ac8add','MEDICATED OIL / SIE KUI OIL 20 CC','MEDICATED OIL / SIE KUI OIL 20 CC','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('eeb87659-05a0-48ec-8e63-9a13d4e24302','BODREX','BODREX','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('eed89e3a-292f-40c0-9d8d-f14085205184','GEEBIO','GEEBIO','2016-08-08',NULL,'489c80c3-8f63-46e8-ba22-91fe377e0443','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('ef1f9e0c-2dee-4fe4-b034-fd395366198c','NATUR E 32 \'S HJ BESAR','NATUR E 32 \'S HJ BESAR','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('ef269800-460b-4827-9444-2f295a5cdf6d','OBH HERBAL ANTANGIN 60 ML','OBH HERBAL ANTANGIN 60 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('f1ff98e2-3203-49de-a537-0e22f16d8e3f','TUZALOS KAPLET (25 STP X 4 KAPLET)','TUZALOS KAPLET (25 STP X 4 KAPLET)','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',12,0),('f212b583-b619-4352-b7ae-bfd3677d4ad4','VITAZYM','VITAZYM','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('f22d2038-bf3b-4868-bdfc-c963a6e5c5ec','ACYCLOVIR 400 MG (10 BLS X 10 TAB)','ACYCLOVIR 400 MG (10 BLS X 10 TAB)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',20,0),('f2d7c2ca-54a3-423f-9499-0f06333a9910','BRONCHOSAL 4 MG','BRONCHOSAL 4 MG','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('f32709b7-59c6-4d10-91ed-75936038e844','ALBOTHYL SOLUTION 10 ML','ALBOTHYL SOLUTION 10 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('f499b6ec-2027-4ae3-a9f8-7d750045122f','ROHTO O MATA','ROHTO O MATA','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('f50477dc-a0f6-4829-98bb-f376a115b3b7','BODREXIN','BODREXIN','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('f5509dde-0cea-4281-9079-1dcf6a033ee2','PRONICY 4 MG (10 BLS X 10 KAPL)','PRONICY 4 MG (10 BLS X 10 KAPL)','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',50,0),('f584df16-bf95-4599-ad19-78169da7c723','OMENIZOL','OMENIZOL','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('f5c029dc-c40e-4c0e-9d89-d00473706b36','BUFECT FORTE SYRUP 50 ML 200 MG/5 ML','BUFECT FORTE SYRUP 50 ML 200 MG/5 ML','2016-08-08',NULL,'e7213b99-369f-4b28-92be-80fc0ec57886','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('f660a9fc-459f-4277-ba19-e9dd28598262','VENTOLIN INHALER CFC FREE/CAN 200 DOSES','VENTOLIN INHALER CFC FREE/CAN 200 DOSES','2016-08-08',NULL,'e7213b99-369f-4b28-92be-80fc0ec57886','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('f716a70f-946f-4b3f-9f69-cd8016f608d9','ATORVASTATIN 20 MG','ATORVASTATIN 20 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('f74b8998-8283-4843-a7d2-8e4ed5978497','PARACETAMOL MEF SYR 60 ML ( Paracetamol 125mg )','PARACETAMOL MEF SYR 60 ML ( Paracetamol 125mg )','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('f75d973c-f0b9-4d48-aa08-134e55c5c37b','RHINOFED SUSPENSI 60 ML','RHINOFED SUSPENSI 60 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('f7b6a5d2-8409-4f79-90da-be61ea52375f','PIROXICAM 10 MG (10 BLS X 12 KAPS)','PIROXICAM 10 MG (10 BLS X 12 KAPS)','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',24,0),('f7d7c867-796b-4303-b251-a1f80c74eceb','CLYNDAMICYN 150','CLYNDAMICYN 150','2016-08-08',NULL,'a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('f886c2b4-d114-4212-9569-b3f9ea49e1a1','BODREX MIGRA (25 STP X 4 TABLET)','BODREX MIGRA (25 STP X 4 TABLET)','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',8,0),('f8c1840f-43db-4e51-9269-26f9756f71f8','ALPARA','ALPARA','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('f91c5830-2808-4e6e-9c23-320a015d0308','FORMUNO KAPLET (3 STP X 10 KAPL)','FORMUNO KAPLET (3 STP X 10 KAPL)','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',10,0),('f9264f22-8676-4d49-bfc7-cc4f30adbafe','FAKTU OITMEN 20 GRAM','FAKTU OITMEN 20 GRAM','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('f9383cdd-aaf2-472d-ad75-0496e33b5d64','PARASOL CREAM SPF 33 20 G','PARASOL CREAM SPF 33 20 G','2016-08-08',NULL,'0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('f96599c9-4abc-494d-b9e1-5a95e9d04e73','BODREX F&B BERDAHAK','BODREX F&B BERDAHAK','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('f9a025ce-bd2b-4ae6-b627-acae3d66bdf1','TOPCILLIN 500 MG','TOPCILLIN 500 MG','2016-08-08',NULL,'afe54bba-c2b1-4915-973f-24069d45d790','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('fa602e6e-5fa2-4940-962b-5a3a1e59ae1a','THIMELON 8 MG','THIMELON 8 MG','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('fab5103b-073d-4952-8280-017ff9faed93','INFUSAN D10 (1 BOX X 24 KOLF) SANBE','INFUSAN D10 (1 BOX X 24 KOLF) SANBE','2016-08-08',NULL,'f5d20b38-1fa8-4ae8-95af-94f638af73f7','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('fb09b5bb-4361-4bd1-a72e-2618b1347f50','BODREXIN','BODREXIN','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('fcc00617-3270-499f-abf0-3a18d5305c2e','PARAMEX','PARAMEX','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('fd445b92-5917-47f7-8fb4-5f4702496e06','MKP LANG NO . 1 / 120 ML CAJUPUT','MKP LANG NO . 1 / 120 ML CAJUPUT','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('fd971fe4-4fdc-4eeb-97cb-b7d8f2853c50','SANMOL DROPS 15 ML','SANMOL DROPS 15 ML','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('ff0b0889-7927-4b8a-a0a8-39bfc31e2bbd','HEMAVITON STAMINA PLUS PAK NEW ( Vitamin )','HEMAVITON STAMINA PLUS PAK NEW ( Vitamin )','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('ff17b5c0-4ddb-4aaf-aed0-27d0823c2784','VITACIMIN KEPING 2S- KNG','VITACIMIN KEPING 2S- KNG','2016-08-08',NULL,'eddf7518-491f-4713-bf70-85bab5a09938','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('ff34b5dd-f600-4492-9c76-8d34d8589e0f','PERILAX','PERILAX','2016-08-08',NULL,'8d41c267-ff40-466b-89b3-fff445a46b55','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0),('ffd1c689-325e-4455-8816-ce31814996c8','CDR FORTOS EFF 10\'S','CDR FORTOS EFF 10\'S','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','69ef7195-a44e-4139-99b9-2db4038814e2','FINISHGOOD',1,0),('fff81e0f-ed13-4065-8c65-36a9ac7c72fe','HUFABETAMIN SYR','HUFABETAMIN SYR','2016-08-08',NULL,'aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','c2e4cac8-8ca3-4575-8c0f-08067f275a2a','FINISHGOOD',1,0);
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
INSERT INTO `product_category` VALUES ('69ef7195-a44e-4139-99b9-2db4038814e2','OTC','OTC',NULL,'MEDICAL',0),('c2e4cac8-8ca3-4575-8c0f-08067f275a2a','ETHICAL','ETHICAL',NULL,'MEDICAL',0),('e919219f-1e49-465b-b139-e27b6b1f3a1c','PSIKOTROPIKA','PSIKOTROPIKA',NULL,'MEDICAL',0);
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
INSERT INTO `product_cost` VALUES ('004bedd6-a595-4e9a-9b7b-270b0fa46b30',17600,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','fab5103b-073d-4952-8280-017ff9faed93',0),('00dc26ad-0e12-4117-9e67-1a2aa1194000',57273,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','eb415c97-7236-4ac9-9a09-944282ea9575',0),('0190f380-0dbd-4bab-9286-c29dc93a3cbf',46600,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f9383cdd-aaf2-472d-ad75-0496e33b5d64',0),('0237a27d-accf-4728-8287-7139cf3bc033',9573,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','39ec1054-d8a8-4e7e-84fc-984740b0f8f2',0),('02497dd9-fae5-4981-a323-cba66277c479',286,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','616d646d-4e53-45c4-a584-f657a6cccb09',0),('025c6a56-9c28-4698-9d90-198af6613923',5891,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','45244017-1aa1-4e0a-9540-5006fef47712',0),('0304e743-5776-43dd-8fbb-ea8dfd4ec1ad',3273,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','ef1f9e0c-2dee-4fe4-b034-fd395366198c',0),('04c8ddd0-af6e-4a18-a368-541d6cc22bd1',82,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','bccdfffa-31da-4bc7-b7ba-6314936cac66',0),('04d1b307-3024-40e0-8fc0-79ba8b36ee0f',4909,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','fff81e0f-ed13-4065-8c65-36a9ac7c72fe',0),('05a51f1b-0f1b-4973-850c-439cedf402ab',2945,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','bbdff218-6ed0-4984-bf91-194096003796',0),('05e2e885-8b7c-4373-a024-b035e4ad35b0',8600,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','744997b4-9d98-44f3-8eff-6ed0583b6be1',0),('05eaf90f-9e26-4207-adb7-9a0a610a6c57',15600,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','4e6b8e5d-2296-42a4-9cfc-35b0907fcdd1',0),('07837e05-46a8-4a20-8590-db5eec32287b',550,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b97239fd-c18c-4ea7-a8f4-27ca274aac66',0),('084930a1-5a7f-4c41-abf6-11ddda61a09a',110000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3bb38ddc-5073-46f7-ad04-d6862c1ac3c2',0),('085e67fc-b30a-45de-b76d-ad6303c94da5',6382,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','9765d942-edbc-4d37-993f-6b4cc4fd8c92',0),('08bdcb55-f8b0-4316-b80b-7b27f42c0ff2',614,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c267f236-325c-41f6-8a46-56763ecd4b12',0),('090d375a-5e71-4b71-bc0a-de4ce9ee0b10',205,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','848536e1-d0f1-499a-8cd1-40bfb1c2efe1',0),('095126ce-1965-4c81-82e2-d8de7b3b938e',7200,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e4a44977-647c-44fd-b0d2-e6a3a566288b',0),('095610bc-ea83-4006-afd8-cd7921d00525',35700,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','0aeeef06-348c-4b67-8750-5101f00a3f2c',0),('0994343d-7799-451f-85c5-beaf56b7574f',6382,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','4eb68a82-560b-41b0-bdd7-3c7bb9609939',0),('0a6a271e-68c4-45eb-b329-d06459c22d47',2700,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','6ede563d-0aa2-4bdd-ab9d-199fb73117dd',0),('0ac4105e-c62d-4784-b0c9-2c2b869947d0',335,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','63c478b7-eeb8-4fb7-82c7-2d8fdd37a448',0),('0adb9676-084d-483b-b918-314923a5e6d5',22500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','81bd16af-abfd-4a2a-b92b-15bc2240459c',0),('0af4c422-4512-4fe6-bd1a-7dd93ac6a784',9818,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','eb392a11-14b8-4e54-a103-6ca7b5fcfa1c',0),('0b06483d-508e-4c34-a159-711e4fcd8564',12273,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','35c33b78-2ea8-4702-ae8f-54dd0ae438dd',0),('0b391f7a-2322-4d93-bb11-e2037c68fe43',385,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','cd61cb27-850a-48c4-8a5c-f51db64176e3',0),('0b4cc0c4-4776-41d9-86f2-953ca8d8335c',1039,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','a6f0a666-72ea-4f60-99c4-42d18487b833',0),('0bb6f207-e274-4ada-aa0c-0b21fcfe0743',180,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f7b6a5d2-8409-4f79-90da-be61ea52375f',0),('0bd64643-ff19-4293-99ef-eb1a953c3c54',2700,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','eeb87659-05a0-48ec-8e63-9a13d4e24302',0),('0bfffd39-f833-42c9-9d7b-d4673975c4de',15464,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','7fddbe26-7a42-4719-9fda-115517d449f0',0),('0ec342d7-fcc7-4a9c-8f6a-abc87367de0a',12355,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','0f3778f1-cf32-45cb-b73a-701184d39bb8',0),('0fabaa98-960d-4ea7-911c-7ad9a2720bef',696,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','554e6acf-fe8b-4b05-ae61-78459743c39d',0),('0ffef259-5182-48e6-8c3f-222634c57cdd',4745,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','8af03560-3305-471c-8325-9b7acff96352',0),('10dff67e-786c-4894-a0a6-375e42f1e03b',573,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','43eecce1-b6f8-4ed1-a8f6-3f029d3bc1d6',0),('10f8f5e2-5c9f-46f8-9845-2dca28c81c0a',3518,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','579e5f38-ef72-448c-865f-8e80b04e25df',0),('1106f393-8d67-40b9-aff4-262323709b12',82,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','5f70495e-f309-4199-a38c-8272f1267a13',0),('1120d88f-f774-4299-a982-8a0ac7d57bb5',16900,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','5e0061bd-4ce4-4bfd-9568-d82450b30e36',0),('11674eec-af99-46f0-bed3-16e8dbed0b79',1105,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3fc3e6ff-2011-4022-bd3a-6c826cbc2411',0),('1178c701-43a5-4832-8384-bb9f988acbd3',35182,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f32709b7-59c6-4d10-91ed-75936038e844',0),('11d59cd5-d9c8-490e-bdab-508ec8a9a317',704,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','7fc2f37e-fcaa-485b-a008-180b15bc9d79',0),('11f0f08e-2993-4a0f-ad59-da064981a07a',138500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','64c9411a-f84d-48e2-9278-9f32f2be4827',0),('1219680b-75b4-409e-b054-d1baa0c5b2af',704,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e3b20e37-4d91-47d4-8558-99491bb737fd',0),('12b8fed6-ed4b-4c14-ac86-60bab49fb886',97445,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','bcbc9ffe-fb49-4c43-bb91-85ddc9dddb71',0),('12bbfe48-7027-460d-9428-2e8c85a0b2e1',2300,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','58e969cf-bf1c-4aeb-9029-04baeef1b071',0),('13612cb7-9787-47d9-b32b-9bf67fa4e955',34101,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','86177d45-c973-47b6-8f6c-8118612b293c',0),('13c71690-831b-4f29-a8ff-a037cc920908',638,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','964743e6-56d8-49bd-8441-67ac6fa3b795',0),('145dab42-a84d-468a-9ebe-272b94a51b59',17427,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','88de4ea2-80d9-4152-91aa-4817f82e8f89',0),('1506b4ae-6ddd-4336-a78d-76f7a6e16955',4091,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','ac5376fc-baaa-42b0-98ff-e1ecd592912d',0),('15196135-e3b0-4df7-8d62-0173c3979a74',13500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e4226aff-9dc3-4214-bdd7-3db1100093b4',0),('16315f07-d32d-4934-92d5-198437e9fb42',11145,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','82b32d45-0766-4c17-bfa2-855793ee7e8e',0),('16940e75-d4f7-4b4e-b615-2ca4dce8644c',12091,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','6437460d-aebc-43e0-9172-ad29b40444ad',0),('16d3b163-a1d5-462e-a482-ffe1270f8ad8',950,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','2d3ab83d-cda0-4f36-8974-c4f72b10cd20',0),('171c68ce-f852-4aea-97af-62ba42e59281',11660,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','ec15592f-6863-4097-93de-a5abad4820e2',0),('17cf5340-7dda-4957-8bf2-3a8892429756',458,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','78beadff-493c-4956-a1f1-dc7745b357a7',0),('1810cbd6-730f-4b65-8a61-75b8214dee75',7527,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','1c4909bc-5c44-4efb-aaa7-3d0eb384c349',0),('183fa205-4d0e-4ecb-9681-fcc42815a4eb',1636,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','a8138880-4276-4f9c-91c8-2a67243b75e5',0),('18a6d7ed-008a-4f81-afc1-13f692e5d1c4',1391,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','48196acf-26db-4a60-b7f0-7377d408d8c4',0),('18df7bef-6812-4a73-b1d7-59bf131980c2',29000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','78e8bf51-ff4b-40af-b5af-8649051bc388',0),('1a084955-769a-42b0-976a-8a98aa076ef1',9982,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c98a019a-981b-485b-86e4-7b3cc62d4d27',0),('1ae619f0-1459-49d6-80b1-abd0d88dd4c0',2455,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','90b36043-8450-49a1-be3f-83b984481551',0),('1b16dd98-b803-44f5-846a-75d25bd7406d',4500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3e28f39e-bbcf-43c6-88aa-f5c29c3b2307',0),('1b21b1b6-878d-44f2-aaf3-7433b1b1843d',1665,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','ca2e5c36-4bbe-4c04-a356-e9ca17e4cc71',0),('1b70aea1-22b4-4343-9511-20ff6adb59b2',327,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3df8f1c8-101e-4352-8593-030d958186d4',0),('1cadc7cc-9bfb-4a96-a2d0-eb321dd7b3eb',401,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','2fd63757-2ddc-4466-b04f-a3ca142b8591',0),('1cdcaf19-4773-4f64-97b7-78cdea5b019f',3273,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','68bc940c-4a69-4656-a72b-7eba9efc6987',0),('1cea93fb-2707-4510-97a6-068594dab108',2782,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','94e09848-c3cc-4302-89eb-25b1e4a7880d',0),('1cf76983-86c0-462c-b2e4-c7e87d534384',9817,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','bccb7f35-5065-4ef0-997a-839c35d8f804',0),('1de09819-a4c5-48b3-bb4d-e88d2e794c11',14583,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','ee715dd7-b854-4c08-ba5a-17e0b4ac8add',0),('1e4c701d-a0ab-4912-9ffa-4c509acb29f6',1064,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','a75016e6-61e9-4521-8abb-65a4449cdd0b',0),('1ec95bcc-b1af-49fa-a694-87f9f2fd6962',49091,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','7402a1f5-7001-4009-a5c4-29b9e09f7a56',0),('1f541b0d-6c1f-47fb-8262-0fa76a1096b9',1636,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c7874cc2-e364-48cc-b9b0-e1936d6dd360',0),('1f81e77a-8be9-4287-9803-2f42bed09a44',1540,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3682c42c-eff3-4424-a820-ddcff5326572',0),('1f86dc72-6455-4b66-bd27-ee3c1dad874c',9573,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3c36cb75-c784-483d-a044-42bdd241254a',0),('1ffe2fc3-a71e-4296-ab5d-07a789dbc57a',14000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','925acc48-43d4-49b0-869e-d7b5b198de62',0),('20165c45-d68a-4198-8982-3cfcb6ee3e36',491,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','2d35744d-b386-411d-88be-1900f1c93469',0),('20427fa7-59ba-433a-a87c-6a67f40fec0d',23891,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','30a807fc-2faa-4c65-ab73-4f2f78ae9ced',0),('20951051-2c3d-4a43-83d7-9f1bb883b954',4500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f716a70f-946f-4b3f-9f69-cd8016f608d9',0),('2135549b-1636-4626-9700-0ae75203cfa9',1722,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','084ecea3-20b9-47fd-a75b-b5bc0f6cbd69',0),('21ca6314-5c03-4ffc-9086-64b85b12aec9',2700,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','ecf5648f-6127-407a-a854-0d33b13f7cc9',0),('223fe51f-010a-4306-a248-fee9007c417f',1421,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','5e3725dd-9e90-41d5-834a-80bfb0b40a79',0),('2285b56c-6d52-4216-a307-14489d620728',4091,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','6663aebb-4ed2-48bf-8625-7f875052bc7b',0),('22ed91c1-a821-46fc-bd5a-49c4f2cc58c8',274953,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3c19cf31-4728-4f15-b413-11413f7181fa',0),('235ff660-d249-447b-9fa4-74c535c3759b',589,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','7de23c6c-a740-4950-9dc1-a559453a4ca6',0),('24065d69-23fb-4584-8973-ce58bcc57c95',1636,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','23e015ae-9fe0-4fbd-b73c-782ebe70c2c0',0),('24308708-75db-4a3d-900a-569d10c4ede1',17333,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','8a47259e-e3d5-461c-bc20-184270f4f11b',0),('249b1a64-da15-4c51-bc96-5f19978c802d',7773,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','7490d418-9e65-4162-b095-3706d98cec65',0),('24a0dedf-f12d-4084-8ec3-010a6f8b701d',1023,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','69848a12-92b1-43a8-a17a-7508e5065415',0),('24cd6e55-f094-4eb6-a095-b0fbd2e60f78',1227,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','ff17b5c0-4ddb-4aaf-aed0-27d0823c2784',0),('25ea168f-8971-4232-a7e5-4d3cbcc1e048',2455,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','08a80cf4-0ef9-48d1-a79c-edd714b170c0',0),('266b667c-4473-4dd0-9200-05b91be72be0',23500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','dfe53a5f-f3cd-4930-bf99-2ef553ea9cba',0),('267e798d-394c-4b44-9a9d-7b487d7657ab',3682,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','dd0751e7-c88c-473e-94eb-955bd6e0ea8b',0),('26e8a941-131a-4981-967d-5a14fd294076',1718,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','4167a503-bf99-413a-aa33-d645212307f5',0),('2717d772-e7f3-45ed-a82e-ee850ab76c8f',4255,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3e700502-6382-4f52-a5df-175e7407dc4c',0),('271f822e-9e1e-4029-a177-944c50313475',18818,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','35732a5c-88cb-4012-8712-4a60bf5628eb',0),('275211e3-e0da-4d32-bb85-2e65ec0049dc',9491,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b8eed9d5-a538-4c6e-ba3a-b4c05666d0af',0),('2877288f-5446-4954-b543-ff80714116b2',18800,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','6b0abda0-9adc-409b-94a3-e7b6723c4be3',0),('28aa991b-2c98-4d09-924e-6e4e0050ab02',11455,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','4631afb4-5070-441c-8577-a4a546362f3c',0),('29270063-b6fb-4321-99d9-815dee52a5d4',818,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','353c2ac7-a726-4211-a776-43a1d29ba313',0),('2a05e637-b8e8-4f4e-832b-b8918baaa5ea',97445,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c7e1658e-5de0-4f84-9b17-5d4aae07c76e',0),('2afaf11d-2181-41d2-b1fe-5e688eb51aed',3764,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3e5946fb-f320-4e59-b4ac-017980a6a74a',0),('2b0d5594-303c-46ee-bada-a95e3e783b9e',8636,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','17170adc-b545-44df-98f3-987692f559b4',0),('2b392e70-d43f-4817-974e-c26944c6a0e0',2127,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3955cea0-71f2-40e7-a1c0-f30bcab88250',0),('2b72262f-b987-4709-9eda-5d6af10ee9a6',450,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e815dcda-c91e-45e3-9fc1-dd2a575e6e73',0),('2b9ce188-bd3c-4ab7-a761-eb6e323c3b2e',4745,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','71f37d5f-4a06-4757-9d36-e1691aea628f',0),('2ba42b84-0a7f-4d83-ac6b-9d3b2765696a',10636,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e5f22872-81b5-4b95-9918-8b1d9a53c654',0),('2bb224ea-34cc-46e1-9ee9-08149230fb22',23318,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','9bdd597f-80b5-4660-8436-1c06fcf1a281',0),('2bdb7e67-f680-42f7-a405-bb616482ded5',3682,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','ec29bc77-685a-40ae-a6fd-2c7f6eecd9f4',0),('2ce23c7e-c14c-43ca-9761-0487d64db1c2',356,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','ecb0ba82-2039-4da4-ab4f-b1b25d90e745',0),('2d2f5dc5-cd08-46f8-850c-3cfe69305302',750,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b48edec6-7d45-4685-ac79-67d694fe6981',0),('2ddfa43e-8861-4ad5-8389-91632f86416b',2500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','626b88e8-5e08-437b-b5e9-649a410fac46',0),('2e3fe856-81c7-4683-8262-15e9e275f5ae',3273,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3161ee08-13f9-43d6-a312-043f441baf9b',0),('2e4b6555-d12c-4b65-9949-dbca078e80d3',491,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','ba451c8c-1999-4ee2-b4da-3e52f18e109a',0),('2e52d02e-8fcb-4fc5-9155-f3cc0d589fec',27000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','26cc436a-c594-409c-8f35-c0cfbfd82a4c',0),('2e5e467c-fcad-4236-9546-0f84b8774532',13009,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','09fb4270-b803-4287-ba6b-6c2d1fa0a2b8',0),('2f191bd3-e07a-4e41-be1b-10e54105e358',4827,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','4f6f1a5c-8c63-4398-a1a7-d3fca7a0c400',0),('2f656202-d18a-4afa-9663-32b0f408f378',15272,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','6b2cb11a-7607-48e6-ab8d-850cb701e1c0',0),('2fb656d5-1a23-4e86-ae50-89d1df2fc383',2075,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','ca67dff0-fdf8-416f-a4eb-ea18fc42d407',0),('2fbf329b-8080-4cd3-86a5-be12374de3d1',8018,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e9ded445-9be5-4b49-9785-fccd7a6b52fd',0),('30808826-3812-4013-a99b-ea0761d3b0ed',982,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','a4be3d32-ddb9-4ec1-85d3-74107f1cb9f7',0),('30e82a39-6b84-4543-ae69-54863dacf93c',11045,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e2b230a9-e241-486c-838a-edb2493bdd5c',0),('30e8afcf-7be9-408b-a762-08882cd5f1b2',9000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','86e73666-b52c-4b2f-95cd-dca03265be97',0),('31172aea-cbc1-495f-a152-592313ea9d4a',1227,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','88279a62-e47f-402f-8a4f-009765ad102c',0),('3167cfc6-a138-4ba3-a700-889f1c3ad2ee',2618,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','1036ff8c-ba61-4479-8b3f-1089e236dd18',0),('31fac1ea-36d4-421c-8e14-3d36e078c566',76091,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','57eeb061-a4c6-4d90-b970-89facb3f46be',0),('323444e0-1db7-4d27-9cba-9bd1e7ee096b',18500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3bcf2b03-f78d-4b94-9083-b6ef6ab40739',0),('328e1994-041d-47cd-babd-c245cb32b3c9',18000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','162da676-a464-47e3-b74f-98c12165e8c3',0),('32c39fa4-5b16-4bef-a0bc-a988a5422179',1636,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','5fae8412-5d0f-46ca-a473-09bd9c0b1ca8',0),('338cc7ea-6eef-4f00-b17b-74cb45209c60',736,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','18315342-7f0d-43e6-8710-71ce095f0f5f',0),('3437acff-80aa-4054-acd0-265cac79577c',4091,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','fa602e6e-5fa2-4940-962b-5a3a1e59ae1a',0),('34525245-44c6-427a-8322-118a033e12cd',123,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e0850b2e-6108-475c-b8d1-3d94274a563b',0),('34a39aca-3a9e-4da7-8635-6726f5f31670',2127,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','9b1fd8eb-8c89-457d-ac6a-93c39ab1b8fd',0),('351efec3-3211-4ffb-b957-d2f9f22da093',5033,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','de4c925c-658e-4d9b-aa04-761b50a2b364',0),('361cc74e-f50b-4099-bd06-edc1e28dc52b',1964,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','6f5dda22-2d2b-41a1-a350-3199c935c163',0),('3646df90-155e-4185-a93f-bf5eee24afad',7609,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','bc3117b5-90f1-40fa-bc79-119f1708f934',0),('367895ff-3225-48ad-85b3-6124c961620c',1882,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3dc08832-a380-4356-b01b-cf00527a0630',0),('37336281-229c-4486-92e9-4f455089da1c',550,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','7445ba41-b22b-43b4-9430-6e085dc47bb0',0),('387e1d6a-51b9-45c6-909a-ce5dbeec70ec',15136,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','60b2c200-fffa-4abb-bd81-b0f0a7cfbb2f',0),('389f9710-fedc-4e34-a83d-b8cad128165f',153000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','5af83213-24cf-410e-af75-65c824ee431f',0),('3918ae3e-190c-4608-ac59-3d51341549d8',4500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','9b45d4b2-297f-4b31-8029-343daa7a39a2',0),('395b23f7-8d7d-4cf2-887b-50e2a7d32b12',36500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','7867372a-5231-4c40-be88-92a77ce74340',0),('397bef0b-f096-487c-98b1-87f656ce0185',15545,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c770feb5-f73f-4dda-868b-5577dbb125aa',0),('39d22098-6660-4aa0-b61c-133912d4df4d',3355,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','0db1619a-3d5d-4dd2-a294-af7ab18f09a5',0),('3ad780dc-1a1a-465d-b5d2-33b505a4afe8',573,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d30ecb66-2dbc-479c-b189-ab867dca4473',0),('3b1f674f-39a5-4653-8f85-0865328a1f48',8345,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f499b6ec-2027-4ae3-a9f8-7d750045122f',0),('3bc02eef-4d4b-41c1-9642-b7ecb89d55e0',10636,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b13ca82b-fbc6-436c-8645-802d56ff7f96',0),('3bc2aad5-4cf4-4dc4-b885-c2bc186c5fb2',18409,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e599645c-8615-4d84-ae88-b7f9e464feb0',0),('3c1af5f1-c25d-4727-9ca6-f1ccb5625ef0',6709,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','940bd155-9e53-419b-b24a-bab1df49a63c',0),('3cea58cd-e7ad-4699-8308-3b48a55eb703',30764,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','2cf89940-2aa8-47d1-b496-00aac722bcee',0),('3d574d89-5857-4458-a6ef-d6e4b05478d6',573,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','407fad1b-31fd-41a8-9e2e-26e407355981',0),('3d6a93d7-cc39-4824-a37a-adef0de0544d',12250,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','6076d39a-51dc-4d7f-b59b-8a81bd1e601d',0),('3dbee4c7-a966-4a77-ab79-f6d53ae498d3',8673,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','8ecd4d6f-3bf9-48bd-8cd9-a7b392a8973a',0),('3de01e26-9f06-4d55-8676-aa91370ee633',20499,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','4e196243-c077-49e7-9ff6-b6d188a9f10a',0),('3df3ec69-9c4c-4b2e-8d54-006e0810fded',21560,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','5463545e-fff0-4208-aec6-0d308efacdc1',0),('3e0537ba-3fd2-4f78-bba9-d521dc29aade',130336,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','561e3e8a-72c4-4cc0-9a4e-55af1ee4d97a',0),('3e54905b-76e9-4a2e-a172-782e9d7a9fbe',2700,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','984707b1-d587-4507-9309-a91b132bfb98',0),('3e8b447e-c5c0-4b24-803b-ac831023d3f4',6545,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','822121a6-1bd2-4bea-8e30-109fc6d72492',0),('3f05522a-ec3e-4a41-b48c-708569b4d603',4091,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','74a69361-60e9-4af8-8765-eac724021451',0),('3f38e752-e1ff-42b3-9fa6-bec4b8ef12d9',1640,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f886c2b4-d114-4212-9569-b3f9ea49e1a1',0),('3f447e10-9f20-44e3-bc2d-6e5b67f2c6ca',682,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','0c22a71d-831d-4f91-9006-aac28244e489',0),('3f680763-49dc-423e-a0cf-3366b26c386f',818,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','92c66aae-c96a-418e-984c-b4f6f45055b3',0),('3f881bda-815d-45fa-b8ff-601ae95ef73b',17700,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','6a109be9-3ad5-4287-ab6f-2300dfbea49c',0),('40155a20-dff4-4a6a-99b8-7c48c642718f',12355,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','22e4608e-f78b-4604-9dd8-2666b21690c7',0),('40183b5d-1407-4597-b720-594d0a2865cd',4500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','a5e168c0-d73f-4caf-860a-e5cc4cc47ffb',0),('40a2db2c-8f17-47b1-b916-d0b46b9fe88d',800,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','de9a4e71-d7f6-4596-ab92-cc4ca0856feb',0),('40f3d403-23b8-4889-afc1-abb685eaa022',4333,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c9458386-b9d4-4894-adb4-10fd81c841d3',0),('415096ae-54f0-4d1e-ad6d-5b1c0aff429b',16855,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','44218b4c-d4ba-4c94-950e-f905c18d68f2',0),('41993992-08ed-44ac-9c13-42e81d8be05a',5809,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d2662251-68b7-40b4-bdc2-0676f5426730',0),('42713ac8-b231-4ad4-a7eb-7991c6495690',6136,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','1706fcfd-6788-4c63-a45b-bddb2c7da5a0',0),('427defcd-bb36-45ad-b33e-07af305f2252',2045,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3970bb04-951f-4143-9f9a-9c5bedef7140',0),('431706eb-8747-4b84-b13f-321e5f11543b',4527,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','8769c18d-f776-4753-86a9-2a97811c8a7d',0),('43a45b4e-e602-40a3-ba4a-02b6b980f799',4255,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d818a34d-5107-4798-9acc-3d6f0a2243ee',0),('44ac3ffc-5c8d-451d-ad46-9b0a3ad02f51',14000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','275f070a-ae3d-4f29-a882-cd6bd9fca7e5',0),('453074c7-933a-4963-a3a7-7517fc0959e9',5727,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','a0eacb3f-5b0e-4833-b9b5-56ed95c0a9f9',0),('45437dc9-8c01-456f-8ed3-98bef703af96',450,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','17d09027-7f78-4b74-aa2d-4f19102f3abc',0),('454789da-9cb4-41fe-a54c-f9dc6882a10c',250,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','7efdbb21-13fd-4f57-b50d-0d16f29cef39',0),('45a31009-79ca-4023-bf84-d9b6208362f3',336,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','28cba0ec-d341-4e33-abaa-878a82bcd5c9',0),('45b88bad-996b-4b10-bf52-ca4764341774',4664,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b268586d-4579-4679-b24c-8ba634cac4dd',0),('45ec88cb-2058-403a-a183-1fdef5f19d82',1741,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','5c293368-1897-4eb3-9915-e1cf6351d918',0),('4632519f-59c2-4ef0-aafb-e7daaf557f39',9327,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3cc43db8-3894-4bc1-9c71-a199f253e1c5',0),('468c7a6a-6352-4707-b8dd-158ab931770b',9409,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','17b97205-0022-4a3d-aa41-9c715ac072dc',0),('46a0aa5f-bb08-48f1-9e60-209c4373a2d4',12845,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','9b8d9856-f332-42c0-8400-ab7318cdd351',0),('46a713c4-f825-4a9e-bf34-b901c214c554',245,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','35f2b105-7802-446d-881f-97f5f407a6ef',0),('46dee508-c7ef-404b-8bd8-a91dd9467f27',4909,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','91fb4e05-b678-42fa-bb16-8022e2e24e22',0),('470fa585-5d1b-4c28-ac19-b0162b9b68a2',1718,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','52bb3edc-e029-4ced-8e97-2e2afc53a71d',0),('482791a0-8a48-42c1-ac37-92b63ae8ad61',2500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','05f7ca85-abef-44b7-856b-bd65718f0eae',0),('48403fdf-00b0-46ca-9495-5b81629bd9f1',1718,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','8d590898-6df7-4a2b-98f6-7335961781ca',0),('4863cbf2-d7a7-4689-9726-7edf9edd91dc',2168,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c04fb5e7-4366-4ed4-8427-e788be8af7a5',0),('4897b207-e907-45a6-b96a-20723ed89cbf',491,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f9a025ce-bd2b-4ae6-b627-acae3d66bdf1',0),('49aa9596-5e76-4ddb-8024-2af83eaff179',1636,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','2c5d4a47-3f91-4771-aadf-8ee49ac08206',0),('4a2064f0-1f49-4b1b-8233-155ebe13dfca',18818,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','10fc4ac8-48e5-403c-b89e-45b88e772f96',0),('4c8674bc-07c8-4a84-936b-2ca0ff679bf6',1555,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','fb09b5bb-4361-4bd1-a72e-2618b1347f50',0),('4cbe3d46-88db-431d-976a-2b8ae3deb5f6',245,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','590bc58c-aa06-4cb8-997d-b7abf367c28b',0),('4cd7aa77-91a4-4e14-819d-dee96f39fbd9',2373,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','a49fe108-ce17-4da1-862b-23448b62fa99',0),('4d42fa63-3b72-44b7-8e5f-1f80422cb9a0',11291,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e88437e1-6136-4b3f-a144-3af04b68d0cc',0),('4d57cacd-46f2-464a-b0c6-6c62f7e5c593',1882,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','46d3047b-e587-4be6-8282-58ecba0fed31',0),('4e1f4c8a-0a83-4c2f-ae60-50f54b66365f',82,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','44b4fbde-329c-4d62-aebf-e51e7317bf76',0),('4e25c589-5caa-474d-984f-67c7f797ee93',6750,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','7fcef193-3548-48fc-aeb2-9ef94dacb13f',0),('4e3b2359-ec8b-4e93-b4de-94a0ea338a7e',1515,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','223d66d3-f822-489e-a049-39bbc69145c7',0),('4eb83ad6-0113-4ac2-b2a1-4870fc8f2c74',23000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','7fd16ed2-3b51-4d09-b5ed-4bad37a4f0f4',0),('5027e5fb-c969-4201-9450-2fbfcd4c6ec6',21400,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','78f0d0d4-0f97-41ad-b2ef-59bca9b38470',0),('51664341-8f60-4bd0-ac27-4a5c36a3a5ef',1200,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','6d159603-dad6-4913-b824-7adf31304971',0),('51a76669-92ca-42d2-92f4-b17c9e0277e6',9900,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','65cd8f3c-3823-4bdb-8c3b-1bc6f0430048',0),('51a7f230-ba7e-4bb8-9ef3-db7d757da3c9',112909,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b502f59b-35ef-43ad-b51e-d5c45d02b5d8',0),('51e23b62-c7d1-4f2d-81e6-de8aede5de29',24000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','1f82dfc0-8285-4c28-88b4-175234347c5d',0),('523ecac7-b68c-4e3c-b88f-43bf0afd6ec7',14500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','32c00f0f-3f41-4b6f-b511-cc713e4a0376',0),('525a1ec3-0580-425a-be4e-24cfc50747de',8345,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','edace783-6b08-4a15-9194-6cb363bc0f79',0),('52ec9f70-b46c-4f76-bf84-fed7a84905f7',52364,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d4a2c9ff-e6a9-4261-b6a8-9201a96e70ef',0),('5319ac1c-9df8-471d-9af4-5e756a7ab32d',1620,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c5b2399d-dd5b-4657-8634-a29f56a6ab61',0),('5350d6ae-491d-43e4-af78-760b022eb436',6545,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','1177854c-af94-4c6b-b3ef-8545dc0c2a7c',0),('54319f17-c849-4bfb-9ef0-f57f3df6fa96',11045,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','254b8e87-0d5b-4fef-aaef-dcbd01f580a7',0),('54754a72-92af-40d5-ba49-1d2b8e3de9ff',900,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','71c2099c-5089-4be3-b714-5f53900cb009',0),('551320f6-d543-4901-9484-a5326961d676',17818,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','602bb8b3-b9ac-470b-b519-f767d37ff595',0),('55bb98b3-c643-4769-b5a6-d89549d9ed7b',6382,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','1a963c74-95d3-4735-ac0c-55358c5a078c',0),('55caed13-028c-49c5-85ff-8a8c5a5fe1df',6955,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','acd3b56c-0811-498b-9324-640d56607ef2',0),('55fc7a6c-5e22-43b3-bdfa-436453dd8f2f',1227,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','56df21f7-d44f-473c-9302-a84b3c40b8c4',0),('5673df73-6e00-4801-a86c-c26029f91aee',7200,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','9eab9be0-7355-4001-86b3-d701aafa247a',0),('56b8aebc-00b4-4eac-98b0-3748e58dd35e',25200,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e2cf3f60-28f2-452a-b3f4-19b7dbb4caec',0),('57277dbb-326a-4769-9fd2-537f3c2fcf34',4664,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','ff0b0889-7927-4b8a-a0a8-39bfc31e2bbd',0),('577c95d4-dc23-42ed-8e67-f53a5e9f5fe7',4500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','1055232b-f75f-432f-92fc-d252a55af5f1',0),('58a74d2a-8e94-4118-95fd-71ee1f958ee3',7364,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','6dee2dfe-043b-4bb7-a500-9a918d85d86b',0),('5964815a-4edd-472b-8ea0-a8bed724c733',12845,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','9f9deb9f-6bff-441a-8f97-d5caca47ffff',0),('59e4822b-2768-4579-863f-6e6710eb3583',17350,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','adc12893-097d-4c38-bbbd-6264ed8bbf3e',0),('59f64a39-abed-4fb8-9ba3-87ba5cea204a',450,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','9b30e01a-1f13-4cb2-a30b-3545cf7e8fbc',0),('5aa3e9c4-9fd1-49e8-8d1c-88de88a9c2e2',30000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','78400bc3-34aa-4448-a70b-50a85ad93785',0),('5b6e61b0-8dcd-4ca0-9e25-36fea92daf76',2455,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','29c26422-a1af-4fad-a14f-c5cf4550671e',0),('5c16322e-598f-462c-971f-3fe2b64ddf22',33545,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','32f72db1-360a-4cc7-b444-c7c1a09b66cd',0),('5c671e3d-0849-4cdf-9cf2-3b8845d068c6',195,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d9542fb1-bfa9-4556-be69-60e36511ae01',0),('5ce3a306-36d3-42e9-ac45-9e7a3b34c066',1100,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d395d475-8136-4cf8-a162-5c9420acc2ff',0),('5d09c5f5-e4ad-4e5d-85ed-55d9dbec192d',4909,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','29aaecee-60e6-40ca-813f-91cd2156c033',0),('5d0a1f21-5989-42b9-bd78-3f4454c09bc9',1235,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','6e98c5ca-3261-495e-89d1-4a46156ca08c',0),('5d15d52e-7dd2-4fd0-a42b-ff7fdd831141',17182,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','4c661b0f-2e20-4d75-9dd6-c2b2a075f136',0),('5d1a79c7-1693-4924-8426-7c83dd66e40b',4664,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','a51eaf49-7f7f-4e87-a3a2-d0099ca70880',0),('5da6cd8f-6264-4c9f-b1c2-ecd732c4997c',2700,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','43afb9fc-1f57-4e00-a93b-bf51de20e7e1',0),('5df729b1-0531-43a6-a1ee-da0e94d03111',3273,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','a576e481-1a6c-4809-b47e-2881bf29e1da',0),('5ea2ca15-887b-46f1-8809-736e4794451d',2478,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e6e9b82a-d5db-47d2-b2c8-d92f49d03713',0),('5ec47aa5-a369-4d6a-b3be-57aea0cb8a06',450,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e93254d9-a933-43d9-b552-a0809afa4da2',0),('5f7f6460-2afe-4bae-be18-e905f66cbae2',7000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e00d89f5-d632-47da-bf5f-8cf9d7f4be9b',0),('60fd22db-7f15-4565-bbaf-286c8238ee7c',5605,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','37cdc631-a446-477e-b477-5f6d3568add5',0),('615b9473-d2ca-4190-a61c-6cfb0f00a987',458,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','6f464606-9908-4437-ae5f-2949a0547126',0),('621c54a0-a8d2-469b-9e35-152978d2d05e',205,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','dcd20c6e-35f0-49f4-9d9d-d3ec1f966159',0),('624e63b8-bbb4-416e-9f4f-91647793bf83',1636,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','1efa96d9-713d-4a0f-be9b-1d681ab2f0e2',0),('634c1bd4-e3b4-40f8-ab17-79305e0780e2',220,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','de368c77-e855-4ee6-bbb4-89194ee66380',0),('64378f7a-e5c1-4755-8251-a7389cb81aea',818,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','8da8e399-bf10-4dfc-8363-82722c174366',0),('65825d6f-752f-49a7-9942-9b80e6e5f74d',4000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','79f1c6f1-c0c3-4a62-b7af-12c2618a554e',0),('659d8dee-3671-4cbb-ac7d-7b706679cb54',4500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c8d40fe1-4615-48ca-84ac-2a08faa62232',0),('659f38d9-b085-40de-ad84-4ace5f368763',31091,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','ffd1c689-325e-4455-8816-ce31814996c8',0),('66b6a545-1641-4b2c-a4e5-9236f9cc22c7',5727,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','bbecc8a4-1770-4f1a-89e7-5239fea66cb2',0),('671a57f1-bb7a-49ec-b370-69c8ae6d5481',10182,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','16865428-073d-4cc3-8da7-f55793296e21',0),('673c5eda-9929-4b2c-9489-fbd74dea549d',519,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f22d2038-bf3b-4868-bdfc-c963a6e5c5ec',0),('676113d1-898a-4fb9-99e0-adb3ec98e70c',2455,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','70792786-2f74-4516-a571-39c9b8a3af9f',0),('67851607-453c-4ba5-a593-b373646801e7',750,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','979b84a9-1298-4b81-a180-eca8f1d01982',0),('67f034b8-fa8b-4816-aa3d-c4d211e39d30',13091,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e49bac38-aa20-42a8-b709-d07fdbde475c',0),('68dbea1e-d5c9-41b5-a66d-ca202ca341b6',11291,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','8e9a55ff-80e9-4d17-a3d5-4f93ec7ac323',0),('6967d7c5-f587-4a4c-9ecf-c05e73bbac84',27250,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','53f9ec0d-c5a3-46f0-b51b-3a1f0fad63f8',0),('69816455-98d4-47a1-8204-7bf114c5c3ac',226,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','412a5592-b458-4ca6-9e93-ebc6459ad9f7',0),('6a61ffc2-50df-4b3d-b05b-96394f3cac90',165890,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','bc857948-b661-4946-90dc-cb01ad88aaac',0),('6a734348-c045-4d90-9e81-cc1d39c6df2e',4500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','ff34b5dd-f600-4492-9c76-8d34d8589e0f',0),('6aac9ce8-b1ae-4d93-a8b8-43a6b3b8603e',9000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c9964447-2625-43e3-85ca-67f5ba4e6cfb',0),('6aad8c3a-1cf4-4635-89ad-f2e5d1cd1e08',3109,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','75b4abba-6596-457a-af5e-c2e9d257c28c',0),('6b49e595-777d-4f91-92e4-49d810df7d78',7527,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','03ed3ffd-4174-4201-813b-31dd9c4e5793',0),('6b686f13-5d60-4e41-ab5e-0199c4da5392',10083,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','9a2c13fd-a142-46ec-8551-4bc86e1a7626',0),('6bb0eb9c-ee35-429d-b778-e23df806d37f',9817,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3390b1de-aafb-4fee-8194-a69121f007db',0),('6bc7b33f-7702-4a50-81d4-b977b89a041d',1555,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','a08ad19a-61f0-46d4-87b8-8da6c8fe0e3f',0),('6c4e3917-9d07-4753-b778-ead1d1e438e0',17182,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','53d8fc10-c72b-46e4-ad97-dee6500c19d6',0),('6c527adb-8293-422f-b954-506302a4dfac',108818,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','0dc97e5d-c36b-4bc9-bdbf-62bce2412dd0',0),('6c66a744-cb95-43a9-becf-d1d45b8aec2c',270,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','53d674c2-6f13-48bb-b4e2-3d2a39541852',0),('6cd19b80-ed28-4f5c-bd4d-d62da9c20f40',6300,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','41bd6355-9d61-47b9-bb0b-ceda1aae21fc',0),('6d018366-b4d4-4205-91ea-684a2375444d',5318,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b8472f07-a2a4-41c5-b338-e3d5f2b16e39',0),('6f1efed9-b4d6-4965-b8dd-2214ecfdde1c',550,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','752be6c7-a8e5-4f8b-a309-2f79926c6f47',0),('6f43f912-fd5a-46bd-9dd8-5e57a1127a17',13750,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c9438eeb-a4e2-4532-a7b2-e7b0aa4aa16b',0),('6f55b624-f8f2-456c-b9bd-c2bc561f4fb3',818,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f7d7c867-796b-4303-b251-a1f80c74eceb',0),('6fbd2450-67f2-4155-ad3e-7e101eeaa4bf',245,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','6d78718a-6d47-4434-ae4e-fb33df9a0714',0),('6fe48b43-2a8c-41c9-9b57-dc209eff384e',1636,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c5404306-9de8-4113-9ff4-ff5856f00da7',0),('7007856b-26a3-45d9-bea3-80fcf7ee3746',130909,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','a8e411d5-e8c0-4648-9ca7-bbe90db1f4a7',0),('7018d092-4af6-4ed7-8885-52295aa67ca5',300,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','43659546-bd7c-4146-b6eb-27f8be761a4d',0),('7076d404-fd46-4d5a-8e18-3f1dff0cb08f',14800,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','9aa311e3-468a-4e00-b8e1-304a6c7539bf',0),('709bbe23-68cf-4f6e-b5de-311808f9eb83',3232,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','dc7b57d7-2ba4-451d-a5f1-0d0ae4c0c6f3',0),('70c9d51e-c4ca-4828-b949-b49a10033f27',848,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','007e27fa-9f94-47a2-a70a-115654f1ae31',0),('70ce638e-8b92-4d13-a2f6-9f4e049cc01e',245,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','02537a79-aa55-4a81-8b22-f16f4cf0071e',0),('70e10c1e-94d8-4bf3-bff4-ba63876676c8',818,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','69a092a5-158d-44df-90c8-025ce8f26d68',0),('726cdb0b-8139-4c00-a130-f1a92ceaa345',5155,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','a4dc0839-9fda-45ca-ac7b-7c510434d303',0),('731f4124-d7bd-45d1-ad0a-0a853e6ead23',82,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','bb27bc70-e246-4a79-962a-52775600eb4a',0),('73569461-10c8-451e-afcd-de0603860443',704,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','bcadd324-0f18-44f9-9fc3-efae346a55c6',0),('7359f632-e822-491f-8ee2-d3226815c0d3',11864,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','941fa182-a1cb-4490-89a6-4ec3d660dee6',0),('735f6be3-08e2-480b-b8d5-166d589725a8',4500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d3ea4f01-19cd-40ec-8c10-3c640de65756',0),('73786abc-26df-4085-a589-af754b342ffc',1309,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','08b45e7e-9a17-4a42-a545-f23327c35785',0),('7425dd8a-acb4-475c-88ae-db32397a44b8',12273,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b83db7ea-3f9a-40c7-9366-8cf56fe62584',0),('7444fffe-4ef9-4352-8127-ee5b7c083045',1473,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c7848e87-3983-4bf0-80dc-52e066e312ac',0),('74c43589-6210-4155-a84b-d05426a6fa2e',4009,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','5657e79e-8248-418d-8286-45852459a396',0),('75badd90-a581-4a1c-b132-7b0d1840af31',18900,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','33da234e-081b-4a4e-8e98-17cded390bba',0),('75fef743-0ebb-428d-8677-901fd4bd4137',1227,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','ee3f7798-3a92-4dae-92c4-804317e4f8bc',0),('768a33e2-663b-4c0a-b166-b75db1d09d64',3518,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','218005c1-4b36-4d3b-8b5b-5d4c6eb88186',0),('7698c1d4-3ad8-4e81-8b05-f5079d9fef90',16364,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e6ca24a3-cd1f-42cb-b39b-f9569ffda976',0),('769ff3cc-fc8b-4b15-8232-935b83004820',336,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d8125419-2e6a-4f03-91a0-ea1675890f32',0),('76c5ccfb-831d-4400-bf48-3492c623943d',11782,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d0449520-ae74-4735-a545-e21a949f1031',0),('772b7103-be02-4073-b6d0-f1cb5df6f836',13500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','4b4313d1-4ec1-49cc-b023-a175c2696263',0),('77429110-a725-4efc-9979-d58bfa847a9c',2209,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e166d6d7-7cf8-4e5c-a13a-4499d9762f7f',0),('77543a15-2167-45ad-a314-4def61283fbd',540,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','04761771-d7fe-4fd2-bbea-d0054d8843c5',0),('77f56eb5-016b-46e3-9bab-59b195ae95cb',4998,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','89fad77b-ec05-4e93-98b7-2fbe43971f7f',0),('7823dee6-daff-4657-8883-78185b5e97ff',4220,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','62d86106-b325-4359-b9ec-268e745553ed',0),('78453aa2-c850-4461-bd13-406e1edd70d6',29375,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','de8c5b61-d15b-47dd-8cc2-a4a75be4c43b',0),('78938ffa-cec5-47b5-b8fa-343ac43c8834',450,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','6adbd5fc-961e-4ccc-a08c-0a4dd9094b68',0),('790ec9e4-8578-4117-ad5a-c0b6b75719d8',9900,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','8ad9ae17-93e0-49e6-8915-d346b3285e03',0),('7a06cd68-6b31-445d-a6a4-b1501a868761',982,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','936f4c03-b603-41a6-b078-dbfe54b06563',0),('7a241b30-2a35-4046-9e5c-ae6151a3cf61',23500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c6cb3613-3b59-4d93-bad5-cbc307a5b147',0),('7a48289d-1838-47d0-95e4-9bc17e0ad633',8591,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','2f49b0a4-86e3-4295-8f55-2fabd91b30f7',0),('7a49bbbd-bdac-4ef0-a283-a61d38e32bec',12600,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','6885ead4-766d-4d90-95b6-62b83e0d62f6',0),('7a659698-dde4-43d2-8733-26b7dddeadaa',4909,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','62e4d93e-949e-4136-9628-cca17c0eadd9',0),('7aba1331-ba61-475c-8a01-7ddbd48735a9',17264,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','a42e340c-95ea-4b76-82ea-692dace6f11a',0),('7af7d24f-0620-45cf-9f80-de472f53a690',4418,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','689937cd-f309-47a2-a1b7-812c792e5062',0),('7af9ad72-1f93-4bea-81d8-5761a7199e2b',37000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3dac8d81-16af-4e9b-9f3f-b3cca940035e',0),('7b4a86f5-2dac-4dad-a091-07934c3d5339',48518,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','a969df9a-af25-4798-9fa7-a2e72520e1f7',0),('7c732ce0-8bb6-4544-a7fd-fb76c23a08ea',1227,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','8573a3b3-2381-4989-8194-1d966e8652ef',0),('7cb9aaa4-8e89-471c-b2da-d3b304df9f2f',818,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','742a55d2-b11b-481c-8cc2-20d85daac577',0),('7ce227fa-59fb-416f-adf5-87434b93913f',16364,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','6c9f3ce2-358a-4b37-8794-43ab3788b58c',0),('7d25c479-0989-4ac9-aa4b-3a18751589b4',193909,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','9a6d59ef-1828-42ff-a4b8-54cf1a02ccbf',0),('7d49c18a-ba80-4bcb-868a-4cdbe5831ab3',4909,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','65226da3-5150-408e-94f0-dd3c4eb90443',0),('7d4c4747-7c1f-4bc8-9ef6-54a74e1a6172',818,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d37f5f6d-53be-40ee-85c6-4edb83ce65c7',0),('7d987a7c-b794-461c-b4f6-e1d937cbe337',2625,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e30c8882-bef9-4f25-8321-ac843a963e44',0),('7e007072-dfd5-4dd8-83e9-97e5003034e5',27720,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','5138aa27-233b-4d0f-bbfc-47152952a31f',0),('7e09fd54-9b62-424a-bc73-0921915f180b',327,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b799a494-fbd0-41ad-87bd-6929ceec4043',0),('7e66bb67-5348-4ec5-86db-f6a2af9b94b2',18500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','5d50e9c0-84d0-4d31-8d02-f3825a3112fe',0),('7e75a249-22f4-434c-bcfa-570d75fba392',2455,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3c961304-e675-4a2a-bd21-15dbfb7297fb',0),('7eb3a8d7-7e25-486b-859e-9d04890148e8',1268,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c4f1a4e0-097c-4c74-87d2-5c1ce0c781f9',0),('7f26c516-213c-4a93-a0b4-8a951a3aaf17',6627,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','8c2d9e22-6bc0-4525-8c22-3fb3d74077ab',0),('7fd782d8-747a-4946-a02d-e084c8aac013',220,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f5509dde-0cea-4281-9079-1dcf6a033ee2',0),('80175d60-41fe-490d-a93b-c45993fa372f',1227,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','7b1dcac2-0048-49b3-9f6d-88b48268c161',0),('804007f9-c6d1-4399-96b3-877ba7c7bd43',12727,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','9e8cc1ec-e2fe-41c1-af4c-ed7aab6c0df7',0),('80873e73-f213-451f-bd34-b83f18faef4c',17000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','0f8b2430-75d7-49f2-bea0-ba53641982b3',0),('80c93fbd-e6dd-49b6-bd3d-9be9cca7a0a9',7364,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','5368a724-8791-4235-a3c3-14be6a7c8366',0),('80e144e8-0cc8-4592-acbe-c08a4506caf7',818,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e6ca4f92-bec8-459a-85ca-9d71e75bf137',0),('8154f762-039f-4d0d-a80a-17d31d5f8b22',28636,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','94d89cc9-8269-4c90-b501-bb4f85d23f81',0),('8249a69a-c6f1-41e9-9d77-82b909bf9fd1',4909,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','60725462-8375-40e5-8b76-2b92291b91a2',0),('82532baf-e750-4026-bd99-8f241b67d2d9',245,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','4effe726-17dd-4133-a179-cd6415fba98e',0),('8260c467-05c5-4c17-8d03-29314a5baf49',712,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f212b583-b619-4352-b7ae-bfd3677d4ad4',0),('833b8ffc-db32-45ee-848e-c79249f1f240',250,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','93bcac5f-f791-47d7-8bd7-c4973506029d',0),('83fab7ed-3f3b-48ed-86c4-85c6ba28287f',916,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','591dd6bb-f2f6-4b00-828f-5f7a869f361d',0),('849d952d-8fd8-44ad-ab91-5ed09f359036',7980,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','61bb5f10-9e56-4152-b8ee-a08b606f4e4a',0),('84a9ec01-8de3-40c8-bdfb-3f82313c1ade',13909,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e80cb4ac-b07e-4600-bae7-a64c2a2f23c1',0),('85274715-5f8e-48ec-a1dc-cd9aece56d7d',466,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b32bbb38-8c60-4dd3-80b7-5d2fedea25d6',0),('85ad2603-3bac-4793-84d0-f4e2baf97aa8',30600,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','76c588c8-fd4e-460c-bc82-32d0f60eed1a',0),('86a13d54-10e6-489d-a13f-c967f37467e3',9000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','70bc2b1a-2985-4f27-a201-38796f2b5fa5',0),('871c0e8d-db81-4e43-ab4c-16936b6f2ac6',6218,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','cb080cf5-be76-4956-bca0-d1da336c171b',0),('87c7f255-c5e3-4103-8052-d419d19444df',52020,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','27730e12-6012-4ac1-8c7c-17669fdf9916',0),('8859f6dc-ec12-498e-866d-cfbb7f331361',6750,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','be82505d-7012-4894-9797-5de0cbd3c1b8',0),('8888c2e2-ea59-43d6-9cba-3c4d03c11806',36600,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','140830b4-4847-445d-b32e-6ff9a315acf6',0),('88d7ac0e-af0d-4fbb-9089-fc3995ee0085',2455,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','ec38ce5b-96cd-4bd1-aede-f1f7364f5826',0),('8905f80d-41c7-4698-b631-a9ea2b333303',21682,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','05ea21d4-1ec4-4d21-a583-dbae13f5afee',0),('89638b35-52a1-4c58-88ce-6f8418224dd2',188,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','401f52f9-0183-4466-857b-aa5e512fa4b1',0),('8ac7bde8-7bae-4952-8dfd-26e619ac0d78',21500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f75d973c-f0b9-4d48-aa08-134e55c5c37b',0),('8b1c2261-055b-4064-85bb-93f460431a8d',270,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e6c6610d-1978-42a2-8d28-7961a29e41b6',0),('8b48c5a3-774f-43fd-8ab3-40bf1ff6ac78',573,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','0dde6cd4-61ee-4ae4-b272-7ec50af92bc8',0),('8b4aacc5-450f-4791-a1e4-61b727f213b0',12273,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','6c07f9de-da43-4f10-b6df-1fc86d407e83',0),('8b61bab9-5988-41af-aa60-3b069af93e11',1718,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','33001ff1-5e76-4d77-9454-f720b61534b9',0),('8ba0743b-9478-428a-8c3c-554dcc59dd27',491,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','986f7ca9-4ac0-4350-9b3f-a8d37aaead04',0),('8baaf8ad-acb5-4a31-9445-49b5ba23d222',5727,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','a95f63f1-1949-4f90-8e3d-ff5b4e7e961a',0),('8c052b4f-25e1-48a1-a643-3a55cdf0b2ed',9818,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','58bddaf4-9a09-4467-a875-076afa91c497',0),('8cf393ea-35e4-4503-b5ec-c616c8287f03',13009,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','7d2e8892-f80e-45f9-9a73-56d590bc0e87',0),('8d61fa6a-c509-4d68-bea2-d1e47c882bf1',23500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','21d79dee-51b7-4840-9a9f-ff7dc3726f21',0),('8e14c133-ba53-425b-b88e-47109d7ef46a',8600,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','9802b6fb-0db0-4e66-8938-26afdccbcb53',0),('8e5a2ca9-93b4-46c2-843b-5daafd745ade',368,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','dcc86b92-d8d3-47bd-90a7-56deb8051b95',0),('9005c64d-0c4b-48fe-9fc9-45dcb2227a65',260,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','35ab31ab-55d9-4b61-97e8-fc6b718fd265',0),('904ea999-bf92-4248-ac8b-33bdb1d05bef',1636,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','99d42967-f9d7-43d6-8667-d98b9f3d5944',0),('907a8b1d-6598-4e6a-866d-5e63770f14c3',24955,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3d9d81c3-3528-40a0-a29a-a34658dc8075',0),('9088ec96-999f-4e20-b574-23d78b9c564e',11050,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','813771de-1fa7-46c2-b11d-f5352868396b',0),('9090e910-7bcd-4415-a211-c6a43abf1668',2300,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','665c04ae-578b-4cd8-b1e9-933f12d34994',0),('90e3224e-aa99-46d7-a63a-81c53ca88845',4991,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b27e43c2-9acb-4168-9f5d-4c4c0babcf5a',0),('92a3585b-e1f9-4551-ba87-4592367cad72',11291,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b2b57a64-575c-4f01-8e49-6d75a13b0b6c',0),('92f5d2dd-7618-4943-8e2b-9c10bb2b84f1',15450,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','9bb8e3e3-3b08-411a-a7e6-43148c5cc4f6',0),('936138df-9d55-4e37-9d70-6d44923c8ea8',21682,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','635fb567-5a30-46a0-92e9-d24c2bf9340f',0),('93d006c6-65f8-47d6-b3e3-077b42d3165e',5727,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','a2cf4c47-125c-4e86-b578-9eb32c918cdc',0),('93dc4ec3-475f-4405-95e6-f9dd31f19f12',20455,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','8fb05868-bcb3-4cbb-ace3-a7927e243a7b',0),('9407fb74-e7a2-4a32-a8b4-831502a3ee0d',10636,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3dea9f95-b976-4f2f-b22e-aaaf3a890eec',0),('940b07b4-6efb-4c09-af35-5d4f901dedc9',650,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f1ff98e2-3203-49de-a537-0e22f16d8e3f',0),('9529dca8-0dbc-4766-be3b-4eadc3f9192e',20481,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','cc980e92-7d48-44d2-af07-2c9f66675e5a',0),('953096a9-fc60-4706-a391-3d7d4f5c5338',32455,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','0d95cd28-0fdb-453d-9a8f-3c02d52557ee',0),('96b4137c-1d82-4000-9ca3-a80893e23b15',11400,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e75543d4-2e88-46ea-9c86-6f81cae97787',0),('9765c608-a632-4a25-96db-3a2d76b8e3d1',123,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','2d567563-1311-4d61-b599-4262498abbcf',0),('98167198-5889-4b3b-a09f-a0b7c30bd3e0',16609,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','28135593-39cf-4a2a-aee4-706f7ab6fddf',0),('981e4c85-27f5-47fa-aa8e-7952298b08ed',5318,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','6cbf8685-c3bc-4bd3-9dfe-9edf3a0eb35d',0),('993cc880-dfca-4a05-9e34-e93e1aedde68',483,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c6379235-1283-482d-926b-b1ca038e1f2d',0),('99aa4178-5c4c-44cf-a102-f2d4fd4a89e7',9041,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','8b60e990-a11a-45bf-b90c-83ccda6aac8e',0),('99df64d4-4648-4dd8-92a9-6d5450c9394e',677,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','30176b2c-1c16-4774-9e4a-724306b412d3',0),('9a540863-1cbf-43e4-bb94-9a91ab618b41',18500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','01b8a9fa-5733-4ee8-8c08-b20e26e5c167',0),('9a57394a-0e4e-4afb-b275-5ca81435d37c',11045,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','63c4e0ef-6ebc-464d-adf9-1d5dce38473b',0),('9acd2cbb-c1a3-40d6-8ef2-1c00f3d7b20e',12500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','33deee8e-779e-4354-9abc-c821cfd629dd',0),('9b661b16-5e98-4434-b840-2800ec3902d8',13664,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b0e53c7d-fa19-4d03-8276-5fc5b8bb5973',0),('9bfb4361-da45-4f01-a542-63350503024d',3682,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','830d777f-32bf-475f-b03b-aba72906c82c',0),('9c65f608-283d-4a81-a227-150f83f787b8',6136,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','cb1b81ea-20e3-4e77-8dc7-183cb222b81d',0),('9c9493ed-59ef-46aa-a198-219d62e265f0',6545,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c1ffa627-94af-4280-b9ba-8860742229dd',0),('9ca3637b-bba4-4dfc-90c2-58a92082e413',135000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','bbcc0daf-3f4a-487a-b797-d6b2552c97b1',0),('9ce3d4b5-fb57-4a76-9c7c-a9b8c664585b',5690,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f91c5830-2808-4e6e-9c23-320a015d0308',0),('9d2c1105-9683-432e-b4ea-36c1cf6f291e',818,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','4462502a-223f-4d8a-9814-1ec1a96574c4',0),('9d5e0cc8-0574-4f08-abae-b4317c8f1a26',245,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','dee9470c-6103-48e6-81e5-12b09412553b',0),('9d85acb6-feee-4a64-bd38-333a5d48b382',93270,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','0f2fd2e2-3ab1-4a57-a327-2d11215facb4',0),('9dad5d88-1fc8-4aae-9676-18d90efaada2',49909,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','81887fc2-e1b0-452d-9870-cf402bf80c24',0),('9dcdd8ec-47c9-4ef1-ba5e-636dc4a0429a',4500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','9b41758d-7e48-48ec-b404-68266f47a57d',0),('9e33a621-0368-4a02-a398-fb7bbf6a3149',818,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','528ead48-3584-468c-aaa1-5484a33230f7',0),('9e674e43-d588-4b07-be02-38a2aa129479',47100,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','0b7c70bb-e354-4250-8931-5fe10e2a78f0',0),('9f1143f6-5f23-4239-9dd1-535c4fa8f8dd',6982,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b85869e6-1f03-4be5-9f4a-74a0646c0272',0),('9f5abbaf-4fce-49ab-a5b2-c78d6324a243',4500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','5ba92538-5b76-46c0-85cd-870ffb1b9db6',0),('9faf8459-7702-4d40-887d-540bb1e91e6d',12273,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d997ed5d-8d3f-4951-8241-9627da3a6683',0),('9fd91203-16c3-4dae-80b5-516f7b5f768f',286,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','dd4d9de7-b0b4-4bf2-a095-cb2e876a2899',0),('a12d1a39-e138-448d-9781-9adb92cede08',10636,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','05f6c643-47dd-4a0e-9e60-607c5a72e2b1',0),('a173032f-4546-4474-9178-f4258c02d4c9',47600,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','4542439b-97fb-4d26-8536-8feeb4dfc137',0),('a190ec0b-0a77-40d2-987f-07e01feb6681',5591,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','7e96a11f-735a-4afe-84d3-a229d863b834',0),('a2115f4b-5667-4bbc-bb71-557d884b6f82',45000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','bb427bf0-ee51-4e14-b585-f8d92e08e0ad',0),('a283365b-b8a9-4ba6-87c2-3ed6eaa8dde2',3542,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','5aef0cff-d054-45c2-a26e-98e57f13544b',0),('a2ad39e0-e0f0-417e-9e1d-4e62df0d8683',84682,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b58a6f2c-6b73-414d-a5b8-f2aca010713c',0),('a306ec50-e9a2-48d6-9342-7789f0733e93',1473,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','ce29f97c-702e-4ef5-a941-fee79081fe66',0),('a3d78071-508a-436d-99bf-f277384b408c',221,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','1aa9ec96-e467-4ddb-8397-5f59685a32ed',0),('a419baf7-038a-4915-827a-c54e9f2c11ef',16200,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','a26b1643-5f37-4b51-b449-2c77bb73b2e2',0),('a57935cf-35b1-4f03-962a-3e4391243681',61855,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','05b1a7cd-af33-4b66-97fc-8e799dbb9233',0),('a582e5da-9977-4973-a13b-5dfec9a4037c',10636,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','aaf6a740-abb1-4a7d-b36b-2ecc0738e723',0),('a5cae3e2-b177-47bf-9a31-990579e60deb',27000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','1e266883-c6d2-41d3-8c11-cea3402a4948',0),('a61f851b-3c7c-408c-b349-fa20934b60a8',20455,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','34cb8dc5-05db-4754-a6f0-753c331fcbe7',0),('a6646099-2048-426f-ab02-dfe37d920d31',100000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c1b5c607-f976-40c3-9c8c-7a53d31fbabf',0),('a778f15c-41be-4976-90bd-32f5b9fe0163',45000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','565834a0-66bc-4d40-84ed-e3c96d4fc77f',0),('a80186df-31e7-4570-9602-2dd39f74032b',17591,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','68172e37-b09a-4a41-b9b3-a1fa7714310e',0),('a844859a-519c-4fcf-96f2-ebefcc071d35',6382,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','90b93b2a-34f8-43f5-957f-cb47a4551120',0),('a89b1013-cba6-471d-b01c-587c26494f12',1391,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f96599c9-4abc-494d-b9e1-5a95e9d04e73',0),('a8cd9837-1dfa-4f4e-8fa1-c11d7258971c',7386,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','36f18236-d50a-435e-9869-968e0b2f0025',0),('a9a6ac62-5495-4e80-b286-daa90904729b',767,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','723ccfad-6157-4421-9647-3aa8fc6d4ada',0),('a9bb2426-c111-43d0-a71b-0c14c17abddc',286,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','a87e543d-44d6-4ce5-8cab-722c673e4b06',0),('aa16ee53-e323-41d6-8bb6-75cea02ca385',8100,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','7a93e08d-12b3-4643-ac13-abb218ef0624',0),('aa338840-872c-4ffa-abaa-cc4d91433aee',4500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','9e3c398b-3c45-49a6-bb2a-0367a986a1e6',0),('aadaf711-dd72-48bb-9fa8-c4e174a4ee99',818,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','433efd3b-65e9-4918-9b26-586aabdf8b9c',0),('ab3cbd82-f1d7-42fe-8174-dcbe25e28a69',36818,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','5c2fa992-184b-405e-b219-1041885afd21',0),('ab5ce816-cf4a-41d7-be1c-84082f07f085',14973,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','87cfce04-958b-446e-b8d3-7c6d8f7cc662',0),('ab86ebdc-934f-4da8-b6b2-21f3b8c8f4b6',327,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','715941ea-e398-49a7-b9e2-53d8a5f0baf1',0),('aba2d359-166b-4125-9e9f-2544b7a311ae',12273,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','0c4e33f7-256a-4275-a268-cdbf64495451',0),('abb7124f-d806-4118-8595-8b4096749b07',1350,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','abb5cb67-760d-4be3-b7a1-4ced780cf00c',0),('ac1772e8-72b6-42c3-82cd-79be51509abd',373,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','a009032a-47ee-4ca2-99dc-ca8576c39bdc',0),('ac3a5aa8-3f1b-4d93-ba07-124270e88b11',2455,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','bead6344-7eff-4998-9733-67ba6c78599d',0),('aca5e308-9f3d-48bd-a820-08591e4837e8',550,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','8c857058-ba14-46fd-b220-4cf196a557d1',0),('ad5d7986-5f09-4e0f-850a-28710678f41f',11700,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','7cb2bdf0-f0c3-4588-9798-541920f448a3',0),('aef3da97-1bba-4509-b719-eeefc14ec7e5',434,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3484a9b2-c960-4a19-a8fe-5a71bc8d2e74',0),('afcaf43d-bb46-4251-8417-ec3b847978b7',5000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','0bd09974-0132-4a30-98ae-ac6d2f95cb0b',0),('b1d2f7fd-68f0-4800-83be-fb7ae0749bff',1636,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','fcc00617-3270-499f-abf0-3a18d5305c2e',0),('b35ab83b-9861-4ab8-9f01-4576fd752104',21500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','751d2111-d008-4523-b8a2-153b5d85c7a1',0),('b4a759d8-1ce1-4ee2-98ab-a0efa0540565',79,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','a6e3696d-0ee8-4baf-99b4-8e0771fbb187',0),('b568a27a-b90d-430e-a86c-d36663a6eb61',188,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','58251241-af23-4db9-8898-c5c598d15c9e',0),('b5a120cb-61e9-4b24-a0a9-49d16752f260',7691,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','6d745229-9f24-4476-9dde-9fba11c73668',0),('b5e03d0d-c9b6-4739-8a3a-d5f70e7b6ee1',164,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','756a6964-9037-44fc-aa3b-ce6dd9cd062d',0),('b5f7b67c-7411-4878-b605-de15d81a47e2',1227,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','25d4db4a-715f-4561-9441-06da16bf5f7a',0),('b60497c5-193b-4636-a036-5fd94778ccde',327,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','4b062d45-5166-4864-88fa-3b8fe398a933',0),('b62dfe1c-4442-465d-bd0e-3cc6978b5893',12273,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','2a55be02-7190-41d1-8726-90bccec8c4b1',0),('b63557a8-8c17-40d8-b625-56b63db2c087',7364,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','785f325c-93cd-4e3f-833a-7b448482f285',0),('b641cec4-2164-4186-82ea-e673d79e296d',35750,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d29a5c7d-225f-4b41-b036-88e2315ee949',0),('b65e4c9c-7e5b-4c9a-b3fd-15889cec9bda',11045,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','90c07d25-db37-4060-ba5a-6e5af7dfdf4f',0),('b6f73539-d4f2-462a-b908-367e08f1905e',1227,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','59edbac4-7aae-4008-817d-eeeb02bd28c7',0),('b71fff27-14b1-4382-92c8-94719c8f7a3f',1391,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d62b1240-3a2b-4a40-8db0-5cd165cfa8f3',0),('b74bfe97-df17-427f-8f85-bab01ad9774b',205,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c7ebf076-3e1b-4c45-985c-3cd09fd3ecba',0),('b8984ac0-3238-45c5-a9b8-45252a2860fb',2250,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','40858ddf-87fc-47ac-8f18-f1d67e2bdea9',0),('b8f7b2d0-a562-4fc2-a27c-1becd4a0250b',21027,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','692315c9-fc59-4954-ac73-05aa49d2d9a1',0),('b9062cfb-3f9c-456e-9953-4e4e1a7d287f',17636,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','59216eee-bf00-4692-950c-2cf34e629738',0),('b90ee6ad-0d8c-4536-8c2c-4d3240e4223e',23000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d60f5ae5-e8bf-42ca-b6e9-d6c8d818b875',0),('ba18a039-4d63-41dd-9318-8fbc3561f21f',26418,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','fd445b92-5917-47f7-8fb4-5f4702496e06',0),('ba21f9e6-bad6-4e75-aaf8-fa6aaa412a78',5236,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','6e17ec90-63af-41c3-8cac-5bd946faaf82',0),('ba5085e9-6ea8-40f9-beb2-0998b43352ff',9327,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','0b74682d-2c3c-471b-81f7-0d3c1cdfc550',0),('ba8cbed8-23ee-44b1-8145-5004b4a39f53',188,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c4f5582b-8803-40b9-80b6-ab99209894d5',0),('baab7ca9-8a87-4fbc-81d8-505fb3dfac06',5318,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f74b8998-8283-4843-a7d2-8e4ed5978497',0),('bb218ad7-08a4-40e3-8053-fb8cf2d8598d',295,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','46033846-68ce-4db7-904d-f882dfda42ff',0),('be4a01d7-be4f-4460-b595-9f21de15fc09',20455,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','7e21826c-82b4-4d84-82a7-b2b77078a96c',0),('bfdee164-feb6-492b-bae9-1291caeabcf9',7036,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','5d1875c6-e3d3-4061-bd24-bdde0498a502',0),('bff01858-e9fc-4bb0-92e8-4ec00b50ee1d',6955,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','aaea9111-5d11-460e-b898-c56762aa4455',0),('c071e2ea-04ac-4e47-a7f9-d19166d6a64e',1636,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','5062d5a6-46a9-40b3-8b47-d8967781b60a',0),('c07262d2-bf0a-4f9d-b71f-ad1fc0f6badf',2318,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','8f7a2349-7fc0-45d6-89a0-792d076077ac',0),('c1088aaf-a555-456b-bb8d-d19c70a3cb07',5200,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','36a7ee3c-cac2-47da-8a38-3fd1b2fe5e5c',0),('c1eefc72-70cf-4f43-8eb0-66b07e511bcd',409,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','5794b252-93ea-4cee-aa14-dbc63204ecfa',0),('c2ac0bd4-e8e3-4a4e-a945-a3a27431f0e7',21273,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','db75c674-4ed2-44ce-bcd8-e1d3a51625fa',0),('c37d9b0c-84f8-4265-a028-7a56cd9002ca',205,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','87c22b7c-7853-4de3-9c4a-8fa1d955ce8d',0),('c396c102-ea46-42dc-8e5b-693923a715fb',34364,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','1aad43d9-279b-4527-8581-5c86a5885008',0),('c3b17d76-acb0-472c-bbd1-9e083ad3e785',3561,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','280f4a60-3587-4a87-b219-c75d42cc6534',0),('c4125792-131b-4b2b-a9ab-98f7e74eb764',31091,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','940e364c-f540-402b-9228-3b00ab32c624',0),('c4353522-ec8d-48ad-bf88-991beee81f45',12355,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','24e58c5e-7f82-47ed-a56d-d384a29515ec',0),('c4f7d227-8a07-496f-8d3d-006dcd285e7e',7955,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','ef269800-460b-4827-9444-2f295a5cdf6d',0),('c5486305-0c4f-4d85-a7c8-eb113dad64db',25000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','9fd7b7e8-0265-463f-b973-bac85c31abf4',0),('c5d0ee9e-091f-49df-aba9-634d97fcc522',18500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f5c029dc-c40e-4c0e-9d89-d00473706b36',0),('c67cf70a-3a36-443c-8348-8a6e97c0e779',35875,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b22ca306-7fd8-43ad-802d-1e6a2207999e',0),('c6968508-ad26-4011-9da6-7fa259515241',4909,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','6b42eaba-807c-4697-918d-e5d432bb83f2',0),('c6ac4e96-b801-4343-9d23-e9a5383977c3',3355,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','642632bb-2fdb-44e0-be92-e24ae6af802c',0),('c6db8d98-7860-44fd-9dc7-11d0b5a29f28',286,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','6f029a46-7aff-4d7d-be04-13e5b1f17e8f',0),('c71dcac3-66a3-4fa1-8f0a-0bf842c83724',13100,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c792c260-f339-4bc5-8647-ebee072b58d5',0),('c752f151-d3a1-4850-81c1-6eb2d37de0a9',4500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b475997b-5fd6-4f4c-9333-7c96ca4367a9',0),('c7e96864-3a3c-4882-86ba-adbd88c8c229',2455,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','886a413c-7025-42fa-b945-90f0ddc80fa1',0),('c81e56e1-a095-4528-bdd2-f7ac679e8873',1050,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','06e325af-29b7-44d2-a87c-5bbe68355d45',0),('c839626d-2986-439b-8068-e0b5f90a6208',458,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f8c1840f-43db-4e51-9269-26f9756f71f8',0),('c8511610-3980-469a-9fbc-24761f76aeb2',4909,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','5abe998d-42be-49d3-a2dd-2a2aff059473',0),('c853b730-77b4-42da-a87c-462c14e17e51',2414,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e7e27f01-f901-4fa0-88df-2ff7d8eb9d26',0),('c868ca5e-7696-45ac-bd70-70e89f3e09bf',32727,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','2223495a-8eef-4757-b33c-27fb7646d4f5',0),('c8d54f43-99e3-4ed0-a278-41dac5a62091',818,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','16861364-78e1-4079-8250-3653ad9e75ca',0),('c98de700-f453-4dd9-9207-3b253a0e9ab6',102682,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f9264f22-8676-4d49-bfc7-cc4f30adbafe',0),('c9bf42a5-1938-4945-9d1b-fc5351fbb0fe',1440,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','1c477c16-a1b0-4982-8857-b9b7ee9fb986',0),('ca3a72a6-6868-4ecc-bc19-683f00e7672f',0,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e9d0f8af-54e1-49f9-b5e2-a19e42f0e05c',0),('cab95500-87a5-401e-8d83-ac4a42da84a6',1105,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f584df16-bf95-4599-ad19-78169da7c723',0),('cad0d13c-adaf-4927-b380-38ac7dce614e',10636,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','6977de00-516c-4a83-bb4a-c62cdf78c088',0),('cad66fbf-2002-4303-adef-02809a3a7ebb',6955,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','01b583c9-c515-4b30-9793-482d0a76f1d2',0),('cad68647-5b5e-4c51-9378-015f21761081',160,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','de64e7fc-bcc1-431f-badd-e1ca9df3aa03',0),('caf80903-962e-41e9-bdd8-23e266f7a6b2',2455,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','da9406ae-a2d9-43da-a0f6-a3a6d2bfdc1f',0),('cb949546-f5c1-4e99-8f4f-01b464637022',6545,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b39aaef8-7805-4f05-9381-afec13f53977',0),('cc1cfdee-1a67-4344-89f4-90bc68d3be6e',40500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','cb3ed9d0-cf8d-462a-9583-2f04218d69dc',0),('cc67d1a5-8508-4758-ad7c-d6d87d281c26',540,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','ec6fa4a1-8d0c-4b8d-b6cb-12fb11f43d7b',0),('ccc7bb04-607a-45fa-8c55-2742fd34facb',12600,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','24c994b8-0141-4be3-a317-5d7260b90367',0),('cd24f3f9-822a-49a6-87f5-aae7e82e72c1',5318,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e8c6ebc2-4883-4850-b365-b2875c00f158',0),('cd69e461-fbc7-46c4-89df-9b7546258eb5',12273,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e07d2c5c-d211-4ba1-ad34-706ef9c5c2f4',0),('cdfec542-e036-4e4c-9556-30f12a5f50a8',6382,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','23e3d105-5d65-4bbf-a54f-fa527ee68aff',0),('ceefb841-608a-4dea-8e6f-be56b0daaa77',4600,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','7c02890e-1b8f-4be3-84ad-b79727abe03b',0),('d013b050-b2a6-47c3-93fc-ace5197312ce',9409,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c7383f85-c820-45e2-a939-ce24c50ad173',0),('d0373f18-e122-4bdf-ab98-20e9db846df7',6534,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c247ed0b-33d9-47b9-979c-4577f8b55f05',0),('d10644ca-52dd-40d2-8fe7-b8a31afbd079',49909,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','56c34599-fb09-49f1-b19a-09dbe50f41fe',0),('d1317f5c-4070-420c-bdd4-b142df81bccb',4173,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','45aa3047-9d7f-47e7-acc4-5b66206c38ab',0),('d166f24d-cfe3-4eb2-ade0-1275787fa756',43000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','7071cada-b946-433b-bf14-87dd877b3ab1',0),('d1dfe03d-5a4a-4c13-9d96-27775e4ca624',19350,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c2ebfa2f-486d-4784-bb85-8e5524da2ba4',0),('d23a8a6c-55c8-4417-8981-864a9013058f',6545,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','4f829a87-bbba-452c-968a-7d3c063ec45b',0),('d2d2ec8b-d98f-4201-8dbc-0fc3818dcc4b',1227,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','0c87f638-2e75-413d-bd70-c5b89c144b3b',0),('d3d74ff4-ee1a-47d2-9d43-10a6e0c4b4f4',6136,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3252a452-2840-427c-9a77-2107111ff6af',0),('d48f4ca7-23e5-42ba-bb03-6af7b8744d46',2455,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e090d829-4bf3-4c32-9cd8-78d1ef511b84',0),('d49607f7-d9f1-4d70-b99d-67a38ff7ffb6',3020,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c0b87cc9-7dd5-4e92-b78c-5b065da4e621',0),('d4c5b7cd-8f31-4253-a351-2bb3eda513f1',16364,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b1e8d539-2fa7-4c11-bb0d-b6889fb8bced',0),('d4c9f710-bfcc-4f75-a61a-f5b4861a7e44',46227,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','706f8cc4-f647-4992-87c8-a17a2ec549f2',0),('d5225e40-15af-4fc0-bd9e-43ff5b9f930b',13418,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','ab8cc7d9-09f9-4d10-b6b2-fe0d97a82111',0),('d5a3ae8f-047f-4412-844e-e804d5f1fb28',180,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d8f244aa-5e52-470d-813e-9d856a95c577',0),('d5ee71a7-db08-413c-87e2-f1ee66ddedc0',28636,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','1af980d8-f07e-4d66-9c57-d998b4a1b47f',0),('d6a6c3df-a050-45a1-8c3c-24b399b01b09',18561,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','32dbb41e-2878-40ad-a4f2-31b8b34400ed',0),('d6b68be0-b086-41fb-bcc9-41ec24f6248d',18800,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d0e980e2-8899-4acd-9c83-5e0e6db0a7ca',0),('d7728a9f-1e22-48cd-b17b-62c411245526',32727,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','7da6917f-afda-45c7-a879-2eed000bfc5b',0),('d7e040d3-1883-46d9-a20b-614cebc9bf36',286,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c2ba0874-6005-46c2-ace4-3ab3ab318a79',0),('d9c4aa45-45d7-4644-8bce-c8ee9c99fab9',380,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','8f2016f0-d21e-4d6f-a661-360fd72135c1',0),('d9cfb124-a17e-49fd-ba31-a4a4871e7d0c',3352,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','9d42b826-2089-429f-9f97-e686e146bf08',0),('d9d19f5e-1600-4124-b507-720a694a8830',371,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d9fa83ac-a786-4d41-b318-18c3a8acb8ff',0),('da4ee265-76dd-4668-94eb-abf7a0271a6f',620,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','0a9a2f8d-36a7-45ea-9e2a-67b9fa59da98',0),('dabea1cd-b36d-43dd-89a4-c0efe6222640',24545,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','65452f02-fea6-4557-b2d1-16b5c7cb699a',0),('db2c9932-93bd-4aee-a4e0-ff7c07f8e389',7364,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','7353aa67-3256-4ce2-9d6e-f20ddeb3be76',0),('db5d5aec-40cd-41ee-b97c-71d238cd1f3a',8250,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','90cea514-a24c-4f8c-b37a-9b868acac2ae',0),('dba8f2ad-50f8-498d-b84a-de0b15813de8',15873,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','1494e6ac-0838-409b-8171-27a4e9c793c6',0),('dbccc67b-8ee0-4420-8935-3d7244444854',25932,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','2a3c9db2-6252-46a3-a3fe-57523bd96c01',0),('dbd7ea6c-8300-4a43-a9e2-7a8643fe8439',818,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','7819a076-6e2b-40d6-8fb5-82352074c6c5',0),('dc04139c-a9da-4c17-b605-3d41419ddc21',18800,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','99bd428f-3d27-41e7-8604-53cc2c550c24',0),('dc26f682-ca99-47b8-96ef-8e7c41ef6d7d',9818,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','2c7e34a0-931b-412a-9aa6-63af17f37815',0),('dc5a1f4d-3fd1-4c14-90df-920b11173feb',4500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d56f271f-0d1f-47d9-a879-5d7dbddbf64c',0),('dc719793-8680-4e23-bda8-62daa9cb2587',5236,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','02969de9-2b60-4a29-bbe9-563ebd952079',0),('dc88ace9-0238-469d-915e-153787e1f4ce',3682,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e40889c8-9ad8-4ccf-b2be-b2deb2ca6964',0),('dccbc9d6-64ef-4d29-a85a-8adc8a8ded48',40909,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','fd971fe4-4fdc-4eeb-97cb-b7d8f2853c50',0),('dd894923-8baa-48c7-ad0f-f92c22a1e828',695,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','8c0032ee-f608-456f-8986-850db19c98c2',0),('dda6beca-a98b-4851-96dc-780ccd0d9a39',5645,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','80b8cfbd-0752-460a-9a21-f5e8554aaacb',0),('ddc4c074-2db3-4fa0-b03b-3024e360683f',9327,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b994e8aa-85d4-402e-9b96-6e4b839b9e07',0),('ddd36eae-cd84-429b-9ffb-6513df0307e2',900,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','a86a1c82-5128-43d8-a865-376d8d6605a0',0),('ddda277c-d7ad-439a-8229-06dd00399df0',89880,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f660a9fc-459f-4277-ba19-e9dd28598262',0),('ddff1897-332d-4293-ae05-8d276236f47f',164,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','8a484956-eb83-4a2e-8591-c66825edb086',0),('de179adc-e33c-4792-b037-6509af82344e',1636,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','552a43b5-8cb6-4d1d-94f3-1d85131a3d33',0),('deb22ae3-a101-4e0a-b6a3-3bdbe99582ae',125,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','6e5cc3e8-2eab-4709-b6f6-02ffd02ccc99',0),('dec21100-a464-4353-b499-eb6855b2703c',15900,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','afdf278b-e323-4208-8a00-0e639c63496f',0),('df7275af-89fa-47c4-81b8-a06911a4aa0d',62500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','1cb74234-3d39-4b32-bf58-4b07136eb87b',0),('dfba2273-4c6e-4173-a2eb-ada18163a4f8',18818,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','8b8953f3-3901-4053-86bd-4fe8191e3bad',0),('dfdcb389-1743-41ea-8f6d-4ba522831bee',10636,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','681f1db6-6a6c-41d4-8e48-df52a4d07135',0),('e044808d-e58c-457b-a777-bf04fb5f8bbb',597,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','770068c9-eb27-4bfb-b29d-f0ec9fc23d8e',0),('e0b071c1-70cd-4489-841a-6a2da1f35870',1227,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','eb3f3543-7d78-4cf7-b935-009353107611',0),('e12617b6-13b9-432d-a519-9105063e74b3',13173,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','1cbdf52a-e1bc-4242-b846-d9b8f5e323c3',0),('e1ee7ec9-9cf0-499c-98fd-de2e82d66a91',32068,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','1f908ff9-e0bb-49db-91f0-d098e5661987',0),('e24a461f-8309-4925-8aa7-f058503d723a',327,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','2c1f9606-af8f-42ac-ac91-9eb2f322f5d4',0),('e2902476-1a50-4d51-abc2-d1d0b778589a',2192,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b23d48e6-88f6-4415-a774-824d604613e7',0),('e2da63ef-4458-48bd-8c75-9869f1b76aa5',9818,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e05eb9c7-ae9f-4ab0-a451-63b849918495',0),('e3507129-91d1-461b-84f7-8746a2569fc1',6136,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3d78e24e-457a-4e4e-be79-a8ea7be2f184',0),('e371d628-fa94-44a2-891b-3acf0a46c96c',10391,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','294e21e2-5410-4522-b947-588746f1293d',0),('e483de99-a875-4976-9a1a-857205157c19',32973,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c97186d7-0912-4977-8672-d968774c62a7',0),('e49878eb-d2ca-4abf-aed9-1184555e0791',409,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','05830da2-288e-4908-b338-4871b114a416',0),('e4ee08e2-07e8-4424-ac71-07ae1f95b1aa',17400,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c52ad20c-a94c-4cd5-aa1d-9ca21062c369',0),('e50bb22a-9fb7-4e11-a7a4-8a4df130877d',9491,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','0d0a7ff1-8497-40bb-a4b2-848d7ac2749c',0),('e50f6979-a229-495a-a080-e7c51de73e0a',11200,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','2816962b-cceb-4941-b477-977ba800e72d',0),('e5bc4e37-416f-40d1-8903-23ca59c26200',2536,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','10b7b0fa-494c-49b3-bd65-bdef8ad7d293',0),('e63e8b95-54db-4ef3-8f16-bdb05fa44d39',1718,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d39721eb-fa96-454f-bae9-d703cf4655be',0),('e70d1ee8-7d9b-44be-8a06-82361519685c',21600,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','25310c3d-2ca0-4dbb-9b8a-7d0c3754b11a',0),('e8123f62-050f-4c85-b2ba-c3e92c80e289',818,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','7c3e6810-d2a3-491f-aaaa-df23bc921154',0),('e836138c-6da5-45eb-aa21-c1c737c6c579',7036,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b7356652-f9bf-4916-8040-ed670178da93',0),('e868004a-76d8-49c7-ba09-8080b045655c',2864,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','eed89e3a-292f-40c0-9d8d-f14085205184',0),('e8ba4091-1cf5-4023-8f04-2c9daea5764d',26250,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','a98f5afa-f5c0-4922-a065-0d2f5f68001c',0),('e90c789c-8f12-4662-8aee-d1b2407568d1',99,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','8ff8e6a8-d2f8-4f90-9010-f2c74a9b803b',0),('e916f9cd-c8cc-4f72-a0bf-c3e8ad7126aa',4745,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','1f43ba02-de8f-4b1a-8d5c-d5fabf862158',0),('e94a8e14-5d54-435f-bc8e-a1c51f42554a',6382,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','7f2f11f5-faf2-4327-96ba-6a444834947a',0),('eb7663c2-d741-4454-8ef6-fdbe7c764531',1555,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f50477dc-a0f6-4829-98bb-f376a115b3b7',0),('eba7bf61-cbaf-4c9d-b686-69d4ab32d699',532,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3408fa37-27a1-4ba7-aabd-47da2341f48b',0),('ec096033-f135-4b78-9025-cf97e8ed899d',1718,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c1a2f65d-8640-4296-a54b-aaa1e3d635d0',0),('ec744dbe-8279-4870-92be-0158cbf85d05',3477,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','bf57047a-a2cd-4f22-9c1b-b0a8983fc974',0),('ec8edfbe-2193-43c0-823f-bc31beb2228a',6136,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c5ce14c5-1410-4628-8421-e378e664a208',0),('ed03a3f3-7c92-4ac3-9379-947b97b2cd5d',2618,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d9a62fb7-6ef1-4dd9-893a-0d1fb92ec830',0),('ed14772e-2a6b-4c64-aadc-b233eb29fe66',2864,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','01a8e63d-6b82-431c-b434-26bce2e551d1',0),('ed820930-13ac-428a-9a2e-1621998fca2f',1512,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','a2f0a0e0-671f-4653-b4b6-5f2e80c97ad4',0),('ed9818ba-b450-42c6-aa26-e2cd5c3eb069',12764,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','baa27c38-f9aa-49a3-8bc4-f63796d77a83',0),('ee1affc2-53f9-4998-8730-f0e55630c1da',9409,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','5b57adca-ba56-4bca-8f04-28e81565e91e',0),('ee3112d7-1979-4530-9cc8-82c9bfe7fe17',9327,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','39832a2f-9e73-472a-910b-4a5e4081ce99',0),('ee379e74-a2b5-4c0d-90b7-0e469c815fcf',11455,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','44be9244-8a08-401b-967d-785cc71d6a3a',0),('ef20f271-551b-453b-92e4-fea54cf60bea',818,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c3c83d79-ff0e-4631-9a67-2cd941c54ce7',0),('ef5b84b9-2b8a-4f46-a55f-f594917011d8',1227,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b77fcabc-a2e9-4157-94b1-176e5bb493d8',0),('efe0affb-b51f-4290-92eb-10f226671291',6791,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','4fccf62e-f6c6-46d9-948b-ff2c1f769fff',0),('f003f9a6-44ec-4525-93c7-ef45a6c99a1d',12750,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','88c9f4f3-663d-48cc-885a-3c3a40389307',0),('f02a63da-b425-45c1-bde8-f9655a3ca0d2',3682,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','63117b43-e0d4-4cb0-bd97-088027d7be28',0),('f167a9aa-eb5b-4d92-8d00-87e44de724b5',18636,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','36574898-6c20-4cc9-addc-8e6a68ca5cb9',0),('f1d0007c-ee93-46b8-acba-400aeae70f8a',231,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d81b8cfc-b9de-4275-bc14-d29dccbd0ed5',0),('f2abc12f-6276-4aa3-9b85-bbfd8744377e',11127,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d1a4f5b8-dda2-4e1b-8d88-f8f5e76c3b7e',0),('f3fa381c-02e4-4ffd-abf2-2739eefaca75',7527,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','a73fc586-4831-41db-b1be-992e4b8a1687',0),('f48b887c-c8a3-4e70-86be-23a8612644ad',7773,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','a39c3b64-9c5d-4824-b80a-f5cf58c5297b',0),('f4b05689-0447-48a7-b4c2-9e6372bad0ef',4091,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','ed875474-f3f2-4d79-b94f-9db4b3fe5ad0',0),('f513af0e-a8f3-4d46-a362-d4ba7f3c0b4d',1636,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','5790faa7-4875-41cd-be5f-b17b890b1393',0),('f52635ed-2b7b-4d30-9ba8-ca33a2e96926',4745,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','981207d1-bb18-42a6-b9cc-665574d22b62',0),('f5634e9c-f87b-473f-9641-153a591c2e65',2455,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','327685f6-7192-4d97-9e74-a3d82d88482f',0),('f5851cf3-9464-4e5f-89ef-66b82768cfff',12682,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','4ea9c4ef-d4f6-4754-94cf-d612c7ce9e6c',0),('f5e85ff0-296e-4893-b49f-04dbb4cca480',13091,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','66c61c70-fe7e-4b9c-b58b-72766e0d8413',0),('f646861c-6bdc-46f3-923b-58c7ef87b623',900,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','841c39b8-6ee9-48a1-9b58-2b480ad0c0d1',0),('f66a52dc-f870-4d4a-a5c1-36b18a265759',9000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','04715b9f-36c0-4c0f-9377-a8f4b42dadff',0),('f6ac7ba1-8674-408e-bb13-ada69cad8029',4750,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','2cc86f32-a7e0-4d34-82cd-b434a2b41768',0),('f6c0a451-901b-42c5-816a-d703083efb3e',8182,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3c4fcbe7-a749-4756-8385-27ec1f53c6ee',0),('f6cb55f6-68c8-4b26-9855-b682c3cf8d04',4500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','805eab32-9eb1-4345-8d2a-cca424169ae5',0),('f76d3180-b45e-4f23-9596-6d18c455d56c',1200,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','ac9cf706-1129-4ec9-98de-35e2e3406708',0),('f817e092-a0cf-46f1-ac63-a38caddcd5ea',8500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','5598b1d3-8885-4b91-a415-8eae6cce5b33',0),('f8ede8aa-b055-4d1d-9d4c-3e5dc23b8a3a',327,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','475990d7-a7ee-46c3-9ed3-ec1079542117',0),('f8f0839d-d795-4a91-b30a-9be8bb3ad54b',330,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','6c3b04c3-0627-4e1e-8bc5-4d19a2adabe8',0),('f91c5199-e5fb-4151-a347-3bcbb78c3868',6545,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','bbcb16ce-b29a-4b33-b633-ebecb8211ea3',0),('f976fae0-a09d-447f-9463-141cebdc40f1',850,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','99574587-106f-4cca-8241-5ee3aa395b1d',0),('f97f5fb0-e8fb-4e8b-aeca-235b0ca99ea2',1718,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','0d3e03de-e3a6-41f9-99f0-f53f1764c3fd',0),('f9dc09ff-ae84-4fd6-aaf7-64494ffc6200',1718,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','44315dc2-e2fa-44dd-8de8-8330ed4de153',0),('fa82fb3a-3db3-4094-9ab0-453f9c07b5f2',20710,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3d56278b-58dd-4f82-9169-d8a478a21b43',0),('fb1418d9-63ca-4f18-afcb-e286695f954e',13418,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','746ec058-c48a-4a7d-a2db-907773279793',0),('fb4bd8f7-1bc4-44cd-bd57-ddab51b1318c',700,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e308ba64-e78e-4228-93d9-24a081bef865',0),('fb731099-bdeb-4c8e-a60a-5b5b8476f8eb',6364,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','6ef114dd-7073-45bb-8b29-c3d8aae1c636',0),('fbadc0db-5b51-49b6-bbbd-f829e23db3b9',180,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','f2d7c2ca-54a3-423f-9499-0f06333a9910',0),('fc068f4d-a760-4047-8a1c-da0720ea9adc',8509,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','a63f33cd-561e-4f75-8fd8-6784c3716e31',0),('fc0cc39f-706a-449a-81fa-adb60e99334b',12273,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d5867fc3-708d-4fd8-8b83-49598971cfda',0),('fc487867-2833-4f98-a335-96c15b49302c',54000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b8cf6bda-59f3-4a48-b9de-f5d8712fde54',0),('fccc7efe-9b94-4f6a-8a3a-a16d84203547',8117,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b797a848-7080-4827-b406-1924ac7bcecf',0),('fcef479d-c3ad-4f90-ac40-1fc370ab934e',12273,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b3437189-8abe-4895-b6e3-f09f4a0fca5f',0),('fd216898-b95e-4a13-82f6-4eb0ebf35d13',82,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','c5ac1eb3-cb9b-4134-91db-a271a8e1b43e',0),('fd71230d-2d01-4fc6-8263-319fd17d39bf',5891,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','479eaf77-b6ff-4506-9add-222234d4bf8b',0),('fd7a2900-b0a8-4f28-ad3d-fab348da05df',2209,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','672947e3-41dd-4c7f-bf34-824b0dd04ee7',0),('fe29f41f-b569-4b43-8306-aeb1ce24f9c9',18000,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','3e9aef4d-7b15-4cab-9e07-84245b9a7090',0),('fe527cd2-24fd-4eb7-abe4-6b1fa76cfa2b',205,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','b77080a1-4dbd-4923-a5b5-bcdf7795740d',0),('fe79422c-1635-4204-9f5d-d1df1f5a9df3',4500,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','2b63d0e6-50cd-434f-a88c-dc2c40d3f1f0',0),('fe888fc3-55a8-4a0d-9785-ed456936f69c',1600,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','152f2e0e-1a2c-417f-82c1-b280460976fd',0),('feb54d91-6d9d-4e9f-8444-1824122a2844',4909,NULL,'2016-08-08',NULL,'PURCHASE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','8c62ba4e-7a19-4733-a76e-c028a81c7a6e',0);
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
INSERT INTO `product_price` VALUES ('0023c774-23e1-4d23-bd25-7425d0ed84a4','2016-08-08',NULL,5693,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'d3ea4f01-19cd-40ec-8c10-3c640de65756',NULL,'0',0),('00293991-68a1-4168-913a-8c75c7a503f2','2016-08-08',NULL,32485,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'78f0d0d4-0f97-41ad-b2ef-59bca9b38470',NULL,'0',0),('00321fff-37fe-4d5a-81b6-e36997dd0b5d','2016-08-08',NULL,4450,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'579e5f38-ef72-448c-865f-8e80b04e25df',NULL,'0',0),('00717b4a-a0c7-489a-b9d0-efaed1853113','2016-08-08',NULL,2699,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'5fae8412-5d0f-46ca-a473-09bd9c0b1ca8',NULL,'0',0),('0076348d-c25d-4c64-9a7d-230a94395042','2016-08-08',NULL,6480,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'fa602e6e-5fa2-4940-962b-5a3a1e59ae1a',NULL,'0',0),('0082027a-03d1-48a8-a550-53a531546822','2016-08-08',NULL,8694,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'bbecc8a4-1770-4f1a-89e7-5239fea66cb2',NULL,'0',0),('009726c4-3e48-48d6-a7c3-5c0faece3ec2','2016-08-08',NULL,1898,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'ac9cf706-1129-4ec9-98de-35e2e3406708',NULL,'0',0),('00ad32f8-f2fe-4e6c-8570-907c8cfdf139','2016-08-08',NULL,16249,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'9f9deb9f-6bff-441a-8f97-d5caca47ffff',NULL,'0',0),('00c0e841-cf7a-4d72-8c1c-8ca34d6bca8c','2016-08-08',NULL,10626,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e00d89f5-d632-47da-bf5f-8cf9d7f4be9b',NULL,'0',0),('01206e6f-e2e7-47bd-a2a7-da8b8d1754fa','2016-08-08',NULL,19407,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'35c33b78-2ea8-4702-ae8f-54dd0ae438dd',NULL,'0',0),('013d7ab7-5bbd-439d-ba72-2ffe43a7c62f','2016-08-08',NULL,9315,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'5368a724-8791-4235-a3c3-14be6a7c8366',NULL,'0',0),('01469633-66b7-4015-b7d7-a3068df950bb','2016-08-08',NULL,5822,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'63117b43-e0d4-4cb0-bd97-088027d7be28',NULL,'0',0),('01a921a1-43ff-451f-80fa-c3e7757b90c6','2016-08-08',NULL,14902,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'3390b1de-aafb-4fee-8194-a69121f007db',NULL,'0',0),('01b01b14-a11d-4c7a-aad7-f0cb6b27df64','2016-08-08',NULL,45856,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'78e8bf51-ff4b-40af-b5af-8649051bc388',NULL,'0',0),('01c0bea1-3c16-4418-8d70-d69e4e9a8ac7','2016-08-08',NULL,891,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'04761771-d7fe-4fd2-bbea-d0054d8843c5',NULL,'0',0),('02312238-b2e6-40c9-acc0-6073def0b328','2016-08-08',NULL,453,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'616d646d-4e53-45c4-a584-f657a6cccb09',NULL,'0',0),('02639b3c-6001-4eb0-9a62-c52fc635b15a','2016-08-08',NULL,2717,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'0d3e03de-e3a6-41f9-99f0-f53f1764c3fd',NULL,'0',0),('026fc92d-6963-448e-afee-f17c249726a8','2016-08-08',NULL,66825,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'cb3ed9d0-cf8d-462a-9583-2f04218d69dc',NULL,'0',0),('02d138d4-0f7e-4e50-9958-67259c3f97e0','2016-08-08',NULL,19872,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e49bac38-aa20-42a8-b709-d07fdbde475c',NULL,'0',0),('030c7fe1-f538-44b4-bdc8-861be6acbd92','2016-08-08',NULL,1552,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'7b1dcac2-0048-49b3-9f6d-88b48268c161',NULL,'0',0),('03b1b1f9-ee96-4df0-87f9-0f68ceeec3ef','2016-08-08',NULL,32401,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'8fb05868-bcb3-4cbb-ace3-a7927e243a7b',NULL,'0',0),('03ea094c-8864-444c-adc2-9d83cbd07e98','2016-08-08',NULL,8100,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'3252a452-2840-427c-9a77-2107111ff6af',NULL,'0',0),('0401ed19-b045-403f-99a3-af700f84caf2','2016-08-08',NULL,518,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'b799a494-fbd0-41ad-87bd-6929ceec4043',NULL,'0',0),('0455b9eb-27ab-4201-b6ae-5bd458574da0','2016-08-08',NULL,713,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'17d09027-7f78-4b74-aa2d-4f19102f3abc',NULL,'0',0),('0456aac4-a353-45c3-9124-d37cb68fc01f','2016-08-08',NULL,40103,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'fd445b92-5917-47f7-8fb4-5f4702496e06',NULL,'0',0),('045c56a4-9bbd-4eb0-99ad-56b7f4809fc2','2016-08-08',NULL,3727,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'29c26422-a1af-4fad-a14f-c5cf4550671e',NULL,'0',0),('045f249f-501d-46c0-8563-51c52897d484','2016-08-08',NULL,3882,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'886a413c-7025-42fa-b945-90f0ddc80fa1',NULL,'0',0),('046da71b-e3b1-4192-bc6b-6f51f9c3c938','2016-08-08',NULL,15525,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'6c07f9de-da43-4f10-b6df-1fc86d407e83',NULL,'0',0),('047632b4-b275-498b-a689-f4d6a5cc786c','2016-08-08',NULL,7425,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'ff34b5dd-f600-4492-9c76-8d34d8589e0f',NULL,'0',0),('048ca569-8013-44ed-97ac-54f2f19f352d','2016-08-08',NULL,15523,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'bccb7f35-5065-4ef0-997a-839c35d8f804',NULL,'0',0),('04bba7a9-bbbb-41bc-9e19-7d469821bf27','2016-08-08',NULL,356,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'53d674c2-6f13-48bb-b4e2-3d2a39541852',NULL,'0',0),('05156d35-4a9e-4ce1-a6d6-2c99f3b0e1cf','2016-08-08',NULL,1620,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'25d4db4a-715f-4561-9441-06da16bf5f7a',NULL,'0',0),('053e3c48-7bbd-4fca-a7e6-b84f96dfd5f8','2016-08-08',NULL,2439,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'3682c42c-eff3-4424-a820-ddcff5326572',NULL,'0',0),('0566ebcb-dca8-418e-95a6-dfc068569388','2016-08-08',NULL,579,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'f8c1840f-43db-4e51-9269-26f9756f71f8',NULL,'0',0),('058e05d4-e6f6-4a5a-8ba1-aa60fcd7503e','2016-08-08',NULL,78919,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'81887fc2-e1b0-452d-9870-cf402bf80c24',NULL,'0',0),('05ac13ae-0731-4cb5-9839-18cbb4e351d7','2016-08-08',NULL,11126,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'5d1875c6-e3d3-4061-bd24-bdde0498a502',NULL,'0',0),('05fec9a9-bb82-4e59-83ef-2a452d13cd0b','2016-08-08',NULL,1343,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'007e27fa-9f94-47a2-a70a-115654f1ae31',NULL,'0',0),('0619bb93-1387-4451-8348-1cc03a0f2710','2016-08-08',NULL,7762,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'29aaecee-60e6-40ca-813f-91cd2156c033',NULL,'0',0),('062f5a10-11cf-4e24-b213-0d964ce41617','2016-08-08',NULL,8100,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'cb1b81ea-20e3-4e77-8dc7-183cb222b81d',NULL,'0',0),('065ae5ba-3ac6-4b43-95f9-8462eecb860e','2016-08-08',NULL,2033,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'3682c42c-eff3-4424-a820-ddcff5326572',NULL,'0',0),('06a11780-2ed6-4df2-808c-28854632e7d8','2016-08-08',NULL,13166,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'8ecd4d6f-3bf9-48bd-8cd9-a7b392a8973a',NULL,'0',0),('06bbb2c1-489e-4925-910f-bba515b5bd25','2016-08-08',NULL,7452,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'45244017-1aa1-4e0a-9540-5006fef47712',NULL,'0',0),('06d09f68-0758-4c5d-931e-cc21cf5c2f64','2016-08-08',NULL,130,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'bb27bc70-e246-4a79-962a-52775600eb4a',NULL,'0',0),('0703db3e-37f5-4be4-8a22-2cb010e020f2','2016-08-08',NULL,4140,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'3161ee08-13f9-43d6-a312-043f441baf9b',NULL,'0',0),('07123a66-1028-4bff-a59f-f340b68c0d41','2016-08-08',NULL,75398,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'4542439b-97fb-4d26-8536-8feeb4dfc137',NULL,'0',0),('07453011-991a-409c-919e-cbe9e32b3be5','2016-08-08',NULL,13045,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'90cea514-a24c-4f8c-b37a-9b868acac2ae',NULL,'0',0),('0774ba75-712f-4f83-a723-f4018d03c6db','2016-08-08',NULL,207360,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'a8e411d5-e8c0-4648-9ca7-bbe90db1f4a7',NULL,'0',0),('077dc8de-93a1-43c0-a4ee-f1c5989a091b','2016-08-08',NULL,28566,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'8b8953f3-3901-4053-86bd-4fe8191e3bad',NULL,'0',0),('079292c5-81c2-4062-94d8-7ccc4cf5e23e','2016-08-08',NULL,17140,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'8e9a55ff-80e9-4d17-a3d5-4f93ec7ac323',NULL,'0',0),('07b0e157-e2ff-4d67-9856-96708224ac76','2016-08-08',NULL,26652,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'44218b4c-d4ba-4c94-950e-f905c18d68f2',NULL,'0',0),('07f71d4c-9545-46ed-9aee-f664b321c913','2016-08-08',NULL,33751,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'7e21826c-82b4-4d84-82a7-b2b77078a96c',NULL,'0',0),('08085277-3149-417a-8ece-605c0093c1ff','2016-08-08',NULL,6002,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'1f43ba02-de8f-4b1a-8d5c-d5fabf862158',NULL,'0',0),('08252708-b05b-4837-8391-71494e46bc8b','2016-08-08',NULL,27001,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e6ca24a3-cd1f-42cb-b39b-f9569ffda976',NULL,'0',0),('0847b32e-9dc9-4049-a687-8931607257aa','2016-08-08',NULL,14283,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e88437e1-6136-4b3f-a144-3af04b68d0cc',NULL,'0',0),('084c8d86-048f-4e45-a333-50adcfc1f74e','2016-08-08',NULL,1940,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'eb3f3543-7d78-4cf7-b935-009353107611',NULL,'0',0),('084f59eb-4729-4ead-b66b-527e044d6987','2016-08-08',NULL,16145,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'3dea9f95-b976-4f2f-b22e-aaaf3a890eec',NULL,'0',0),('08792577-696f-4263-a000-f0e24a3d0b1a','2016-08-08',NULL,495,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'43659546-bd7c-4146-b6eb-27f8be761a4d',NULL,'0',0),('0879c04d-dd7c-4b2a-a67f-66a76ff8276c','2016-08-08',NULL,3208,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'10b7b0fa-494c-49b3-bd65-bdef8ad7d293',NULL,'0',0),('08b32bbd-d4ff-4262-aa93-eefcce5c7542','2016-08-08',NULL,713,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'6adbd5fc-961e-4ccc-a08c-0a4dd9094b68',NULL,'0',0),('08cb938a-4120-4b97-b012-e7f9b05ade2d','2016-08-08',NULL,2976,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'3dc08832-a380-4356-b01b-cf00527a0630',NULL,'0',0),('08ef9d9f-e98d-4e97-b6a6-c982b870ea83','2016-08-08',NULL,2587,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c7874cc2-e364-48cc-b9b0-e1936d6dd360',NULL,'0',0),('08f0e479-05a0-43c7-b0dc-8fe74b8bffc3','2016-08-08',NULL,310,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'58251241-af23-4db9-8898-c5c598d15c9e',NULL,'0',0),('091ff5e9-b1f6-41dd-a3c5-c6c7381e1b5c','2016-08-08',NULL,2228,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'abb5cb67-760d-4be3-b7a1-4ced780cf00c',NULL,'0',0),('09421f3f-a573-418c-acad-a6e512f24fff','2016-08-08',NULL,23443,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'9aa311e3-468a-4e00-b8e1-304a6c7539bf',NULL,'0',0),('094ebba9-9df6-4252-9e41-0a6ca9ddcc60','2016-08-08',NULL,6086,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'5657e79e-8248-418d-8286-45852459a396',NULL,'0',0),('099d47ff-5c53-4717-936f-7e47bf075d6b','2016-08-08',NULL,12678,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e9ded445-9be5-4b49-9785-fccd7a6b52fd',NULL,'0',0),('09ae3072-9aa5-4b51-840c-36976c689be8','2016-08-08',NULL,6727,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e8c6ebc2-4883-4850-b365-b2875c00f158',NULL,'0',0),('09c92626-471d-4671-ab03-e55c4a34d0c9','2016-08-08',NULL,2092,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c4f1a4e0-097c-4c74-87d2-5c1ce0c781f9',NULL,'0',0),('0a108fb4-7730-4c3a-ba37-271ba0dfda35','2016-08-08',NULL,2591,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'5790faa7-4875-41cd-be5f-b17b890b1393',NULL,'0',0),('0a43263d-4e11-445e-b9d4-2ac0fa610bea','2016-08-08',NULL,2527,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'ca2e5c36-4bbe-4c04-a356-e9ca17e4cc71',NULL,'0',0),('0a76a6d5-072e-464b-9df7-9f2b4c326e7d','2016-08-08',NULL,7245,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'a2cf4c47-125c-4e86-b578-9eb32c918cdc',NULL,'0',0),('0a83fd72-dba5-48c8-be4d-d0ee2353cab0','2016-08-08',NULL,1505,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'2d3ab83d-cda0-4f36-8974-c4f72b10cd20',NULL,'0',0),('0a8426ff-5b1a-4727-812d-ee1ea3d04b40','2016-08-08',NULL,42079,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'5138aa27-233b-4d0f-bbfc-47152952a31f',NULL,'0',0),('0ab9702f-7f2f-4b9d-a4b3-33b462beef2b','2016-08-08',NULL,7452,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'6b42eaba-807c-4697-918d-e5d432bb83f2',NULL,'0',0),('0adc7a5d-5894-4c9d-8260-f45cc8051da2','2016-08-08',NULL,8487,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'940bd155-9e53-419b-b24a-bab1df49a63c',NULL,'0',0),('0b03b96b-7eec-491a-929e-7880554835a7','2016-08-08',NULL,3363,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'3955cea0-71f2-40e7-a1c0-f30bcab88250',NULL,'0',0),('0b12e4e5-f30d-4b80-9940-59843976fadb','2016-08-08',NULL,37950,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'9fd7b7e8-0265-463f-b973-bac85c31abf4',NULL,'0',0),('0b7a19f6-001e-4013-8146-266931d81168','2016-08-08',NULL,10971,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'8ecd4d6f-3bf9-48bd-8cd9-a7b392a8973a',NULL,'0',0),('0b7cf315-a086-407c-bd2b-04696e7ba44c','2016-08-08',NULL,1188,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'979b84a9-1298-4b81-a180-eca8f1d01982',NULL,'0',0),('0bb4fe09-0cc9-4b8b-b20b-f2721297dc33','2016-08-08',NULL,5940,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'ff34b5dd-f600-4492-9c76-8d34d8589e0f',NULL,'0',0),('0bc87d4e-ddfc-4e3a-aede-3b7e67dc1f24','2016-08-08',NULL,412,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'35ab31ab-55d9-4b61-97e8-fc6b718fd265',NULL,'0',0),('0c06dc4a-3863-432d-a937-58f6e82c2393','2016-08-08',NULL,1113,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'7fc2f37e-fcaa-485b-a008-180b15bc9d79',NULL,'0',0),('0c1e271e-3297-4eed-b64b-e70c032a5e3e','2016-08-08',NULL,1584,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'6d159603-dad6-4913-b824-7adf31304971',NULL,'0',0),('0c61d649-c3aa-42a7-9315-c9d07682595c','2016-08-08',NULL,2808,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'9b1fd8eb-8c89-457d-ac6a-93c39ab1b8fd',NULL,'0',0),('0c71e51f-82b7-437d-ab59-cbd440b032e1','2016-08-08',NULL,17495,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'254b8e87-0d5b-4fef-aaef-dcbd01f580a7',NULL,'0',0),('0c82def4-6f33-4b02-aa97-877a7c775d36','2016-08-08',NULL,18630,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'35c33b78-2ea8-4702-ae8f-54dd0ae438dd',NULL,'0',0),('0ca03b0d-8223-452c-9a6b-2da74bb1ca46','2016-08-08',NULL,41711,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c97186d7-0912-4977-8672-d968774c62a7',NULL,'0',0),('0cf59720-d8e2-4dbf-8c07-f2ad56a45a3b','2016-08-08',NULL,298,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'58251241-af23-4db9-8898-c5c598d15c9e',NULL,'0',0),('0d2e8975-cd15-4025-a80a-f14f19624339','2016-08-08',NULL,4140,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'ef1f9e0c-2dee-4fe4-b034-fd395366198c',NULL,'0',0),('0d5ffb0f-0047-457a-953c-cdcd7b39e703','2016-08-08',NULL,531,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'63c478b7-eeb8-4fb7-82c7-2d8fdd37a448',NULL,'0',0),('0da48a6e-08ce-4928-b7f7-53fb35de72bb','2016-08-08',NULL,7128,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'2b63d0e6-50cd-434f-a88c-dc2c40d3f1f0',NULL,'0',0),('0de682b5-7c80-4818-a565-14a8fc013b85','2016-08-08',NULL,34155,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'1e266883-c6d2-41d3-8c11-cea3402a4948',NULL,'0',0),('0e166b12-51f5-4869-8192-9d162e967c4d','2016-08-08',NULL,125550,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'57eeb061-a4c6-4d90-b970-89facb3f46be',NULL,'0',0),('0e373643-6c89-45e3-a9e3-00dd7974157e','2016-08-08',NULL,7762,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'60725462-8375-40e5-8b76-2b92291b91a2',NULL,'0',0),('0e476495-d6ef-4114-b269-6db8a7de6e9e','2016-08-08',NULL,20311,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'9b8d9856-f332-42c0-8400-ab7318cdd351',NULL,'0',0),('0e71516f-a95e-4e9c-b7b3-e94863ee365e','2016-08-08',NULL,8901,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'5d1875c6-e3d3-4061-bd24-bdde0498a502',NULL,'0',0),('0ea82ee3-ce0a-4db2-9cb9-326838a1e9d5','2016-08-08',NULL,27048,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'602bb8b3-b9ac-470b-b519-f767d37ff595',NULL,'0',0),('0edc2f4f-7493-43e4-922b-7a243f9c29d0','2016-08-08',NULL,540,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'3df8f1c8-101e-4352-8593-030d958186d4',NULL,'0',0),('0ee5a276-862a-4e5f-b6a4-a6bc57c0a528','2016-08-08',NULL,3229,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'3955cea0-71f2-40e7-a1c0-f30bcab88250',NULL,'0',0),('0f000113-1dee-42d3-bad1-524b15b3ff78','2016-08-08',NULL,16100,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'16865428-073d-4cc3-8da7-f55793296e21',NULL,'0',0),('0f0f428a-f3be-4aad-9279-234d449cf04d','2016-08-08',NULL,14158,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'3cc43db8-3894-4bc1-9c71-a199f253e1c5',NULL,'0',0),('0fa92a14-2918-4c14-9d86-8f548362f1ef','2016-08-08',NULL,434,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c2ba0874-6005-46c2-ace4-3ab3ab318a79',NULL,'0',0),('0fc4ac5a-6617-44cb-be9c-6b14650508b5','2016-08-08',NULL,232254,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'5af83213-24cf-410e-af75-65c824ee431f',NULL,'0',0),('0ff4a08e-7729-4a68-8c6c-906e76ae68c3','2016-08-08',NULL,3882,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'ec38ce5b-96cd-4bd1-aede-f1f7364f5826',NULL,'0',0),('1001b771-9aa7-49d1-bd54-633baccb142d','2016-08-08',NULL,25099,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'1494e6ac-0838-409b-8171-27a4e9c793c6',NULL,'0',0),('100e71dd-4755-43ff-aab7-be8329d4f969','2016-08-08',NULL,1615,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'a75016e6-61e9-4521-8abb-65a4449cdd0b',NULL,'0',0),('104a0b4e-9a9a-4123-80b6-278e6e14aece','2016-08-08',NULL,81972,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'b8cf6bda-59f3-4a48-b9de-f5d8712fde54',NULL,'0',0),('105b809b-69df-491f-ad2c-9c9a30d43820','2016-08-08',NULL,47249,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'94d89cc9-8269-4c90-b501-bb4f85d23f81',NULL,'0',0),('1062838d-1ce8-43f2-9ae8-d1462e5b67c9','2016-08-08',NULL,2070,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'a8138880-4276-4f9c-91c8-2a67243b75e5',NULL,'0',0),('1067f2fc-097e-49c1-9125-4bb03b7c5885','2016-08-08',NULL,5693,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'9b41758d-7e48-48ec-b404-68266f47a57d',NULL,'0',0),('10cf4833-29ad-437b-b5a5-81f4b56980c6','2016-08-08',NULL,1057,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'554e6acf-fe8b-4b05-ae61-78459743c39d',NULL,'0',0),('10e670b0-7c98-4947-b6de-b107f22fe0e4','2016-08-08',NULL,17595,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'d1a4f5b8-dda2-4e1b-8d88-f8f5e76c3b7e',NULL,'0',0),('10f24f79-dfc7-4f5a-b593-c682fcbd42cd','2016-08-08',NULL,5383,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'d818a34d-5107-4798-9acc-3d6f0a2243ee',NULL,'0',0),('1100260a-f179-4e2d-9a45-b97a202a9e24','2016-08-08',NULL,323,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'02537a79-aa55-4a81-8b22-f16f4cf0071e',NULL,'0',0),('11123955-d72e-43ff-9d09-48eae6fc60f3','2016-08-08',NULL,1242,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c3c83d79-ff0e-4631-9a67-2cd941c54ce7',NULL,'0',0),('115b2da7-5ce9-493d-8754-a6ce11dc1c30','2016-08-08',NULL,16043,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'4ea9c4ef-d4f6-4754-94cf-d612c7ce9e6c',NULL,'0',0),('118f6f72-856e-49d0-9cd4-cf9031c1bfbd','2016-08-08',NULL,8100,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'3d78e24e-457a-4e4e-be79-a8ea7be2f184',NULL,'0',0),('122d1e06-cbf2-4621-90a8-3f0990e8804b','2016-08-08',NULL,18233,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'813771de-1fa7-46c2-b11d-f5352868396b',NULL,'0',0),('122d8860-f371-4122-a1cf-0a379354d4b6','2016-08-08',NULL,17503,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'813771de-1fa7-46c2-b11d-f5352868396b',NULL,'0',0),('1233222b-f3fa-406e-a67d-646a92b4fb27','2016-08-08',NULL,2070,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'2c5d4a47-3f91-4771-aadf-8ee49ac08206',NULL,'0',0),('123e2068-89cf-4fca-9a9c-4c30550a061d','2016-08-08',NULL,60750,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'5c2fa992-184b-405e-b219-1041885afd21',NULL,'0',0),('128e26e3-204d-4cf7-9000-e8c4b3dfa9c0','2016-08-08',NULL,3519,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'8f7a2349-7fc0-45d6-89a0-792d076077ac',NULL,'0',0),('128f2ed2-a039-46f2-8331-6173318cb206','2016-08-08',NULL,8409,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'6cbf8685-c3bc-4bd3-9dfe-9edf3a0eb35d',NULL,'0',0),('12c5f48c-1d58-45b7-b995-f72236dc6fde','2016-08-08',NULL,7080,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'ff0b0889-7927-4b8a-a0a8-39bfc31e2bbd',NULL,'0',0),('131d591d-83fa-4b82-ab16-125c6642d528','2016-08-08',NULL,540,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'05830da2-288e-4908-b338-4871b114a416',NULL,'0',0),('133f4b0e-88bb-45a0-afa1-878901313bbf','2016-08-08',NULL,945,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'407fad1b-31fd-41a8-9e2e-26e407355981',NULL,'0',0),('138fa851-1215-4daa-9238-0a6a41252536','2016-08-08',NULL,59194,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'b22ca306-7fd8-43ad-802d-1e6a2207999e',NULL,'0',0),('13ba36aa-2efd-45c5-a8d9-4cd7405d3769','2016-08-08',NULL,1426,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'841c39b8-6ee9-48a1-9b58-2b480ad0c0d1',NULL,'0',0),('13ba82c6-38fb-429d-985e-a343fb0999a1','2016-08-08',NULL,20161,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'88c9f4f3-663d-48cc-885a-3c3a40389307',NULL,'0',0),('146836e0-bbf4-4492-a19d-d5534625c993','2016-08-08',NULL,12419,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'3390b1de-aafb-4fee-8194-a69121f007db',NULL,'0',0),('14790553-6c63-4b60-9742-19d1b40e8451','2016-08-08',NULL,338,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'dcd20c6e-35f0-49f4-9d9d-d3ec1f966159',NULL,'0',0),('14b66972-9614-42d7-a26e-f123ae35d775','2016-08-08',NULL,6750,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'fa602e6e-5fa2-4940-962b-5a3a1e59ae1a',NULL,'0',0),('14bcf27a-ddd0-44e8-9fc5-799052e46bfd','2016-08-08',NULL,52139,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c97186d7-0912-4977-8672-d968774c62a7',NULL,'0',0),('14ec75cc-6ceb-4f6d-8b3f-694c4c929474','2016-08-08',NULL,2009,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c4f1a4e0-097c-4c74-87d2-5c1ce0c781f9',NULL,'0',0),('14f08efc-37c4-4cc6-8980-3a67af099f50','2016-08-08',NULL,582,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'dcc86b92-d8d3-47bd-90a7-56deb8051b95',NULL,'0',0),('14f92bf0-d714-4475-8143-a65725ada928','2016-08-08',NULL,15654,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'8ad9ae17-93e0-49e6-8915-d346b3285e03',NULL,'0',0),('1523bc9f-24b2-4203-9ec2-be7c90949769','2016-08-08',NULL,8943,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'479eaf77-b6ff-4506-9add-222234d4bf8b',NULL,'0',0),('1547f3d3-a9c7-4695-a843-ed86aab7ee23','2016-08-08',NULL,14283,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'b2b57a64-575c-4f01-8e49-6d75a13b0b6c',NULL,'0',0),('1552dfe2-11ab-4552-b17a-f90e5e4796ee','2016-08-08',NULL,822,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'f1ff98e2-3203-49de-a537-0e22f16d8e3f',NULL,'0',0),('1560c0fe-c820-49fb-841c-16075581e76e','2016-08-08',NULL,10092,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'7f2f11f5-faf2-4327-96ba-6a444834947a',NULL,'0',0),('156582de-b3a0-4d23-a01d-72a4582a60eb','2016-08-08',NULL,8223,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'36a7ee3c-cac2-47da-8a38-3fd1b2fe5e5c',NULL,'0',0),('158e41e3-92b7-4f33-81d1-2dc425289e1f','2016-08-08',NULL,532,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'28cba0ec-d341-4e33-abaa-878a82bcd5c9',NULL,'0',0),('159e9418-e721-430b-8128-ca3844bc3ddc','2016-08-08',NULL,33206,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'a98f5afa-f5c0-4922-a065-0d2f5f68001c',NULL,'0',0),('15ec167d-f09c-47ef-ae17-2c3598040585','2016-08-08',NULL,123268,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c7e1658e-5de0-4f84-9b17-5d4aae07c76e',NULL,'0',0),('15ec9bd6-640f-45ae-b422-635105dc81de','2016-08-08',NULL,31919,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'692315c9-fc59-4954-ac73-05aa49d2d9a1',NULL,'0',0),('15fbd6c9-c279-442a-90b9-52f71bbff952','2016-08-08',NULL,198,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'6e5cc3e8-2eab-4709-b6f6-02ffd02ccc99',NULL,'0',0),('160b2aaa-2fd5-4588-a608-3e8138b2b403','2016-08-08',NULL,13055,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'744997b4-9d98-44f3-8eff-6ed0583b6be1',NULL,'0',0),('160ce740-357c-4c63-a266-74c1735c7ff9','2016-08-08',NULL,15153,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c98a019a-981b-485b-86e4-7b3cc62d4d27',NULL,'0',0),('162e8f43-c300-4e0d-a01f-1906e01cb545','2016-08-08',NULL,11902,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'a73fc586-4831-41db-b1be-992e4b8a1687',NULL,'0',0),('1634ab7f-bafd-4555-87e8-6e1eb2af690a','2016-08-08',NULL,14904,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'d0449520-ae74-4735-a545-e21a949f1031',NULL,'0',0),('163ea024-204c-49ca-8997-606199933659','2016-08-08',NULL,3882,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'90b36043-8450-49a1-be3f-83b984481551',NULL,'0',0),('16400f38-adbd-4b4c-9283-289b94636282','2016-08-08',NULL,14175,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'2f49b0a4-86e3-4295-8f55-2fabd91b30f7',NULL,'0',0),('16569a50-91f0-4b19-87d6-2c4aac6a6c74','2016-08-08',NULL,765,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c6379235-1283-482d-926b-b1ca038e1f2d',NULL,'0',0),('16711382-4da9-4e0b-b809-31a0bd1cd78e','2016-08-08',NULL,1620,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'88279a62-e47f-402f-8a4f-009765ad102c',NULL,'0',0),('16904fb4-9a71-4a1b-bb69-7d88401e8f13','2016-08-08',NULL,41773,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'fd445b92-5917-47f7-8fb4-5f4702496e06',NULL,'0',0),('16f011f7-e97b-4a37-bfec-ef638e81c126','2016-08-08',NULL,298,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c4f5582b-8803-40b9-80b6-ab99209894d5',NULL,'0',0),('171375f3-4b00-40a3-9225-4556c08fc436','2016-08-08',NULL,2976,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'46d3047b-e587-4be6-8282-58ecba0fed31',NULL,'0',0),('175eae83-a045-4fcb-825e-98fe0940ecc0','2016-08-08',NULL,108,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'44b4fbde-329c-4d62-aebf-e51e7317bf76',NULL,'0',0),('178e450e-4484-4bf6-8842-e8a4c5b9f1d1','2016-08-08',NULL,573,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'3484a9b2-c960-4a19-a8fe-5a71bc8d2e74',NULL,'0',0),('17e2bf03-01c0-41fc-8686-eb892b165cfd','2016-08-08',NULL,35673,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'21d79dee-51b7-4840-9a9f-ff7dc3726f21',NULL,'0',0),('17e67ca0-9740-488f-846a-8944151c15a4','2016-08-08',NULL,178537,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'b502f59b-35ef-43ad-b51e-d5c45d02b5d8',NULL,'0',0),('17e9eb8a-9570-4f9d-8385-a6d02963f112','2016-08-08',NULL,435526,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'3c19cf31-4728-4f15-b413-11413f7181fa',NULL,'0',0),('1831791f-d384-4919-b529-e176aed36120','2016-08-08',NULL,45281,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'1af980d8-f07e-4d66-9c57-d998b4a1b47f',NULL,'0',0),('18551dca-348e-4c7f-b97e-da6981d0ef3c','2016-08-08',NULL,6002,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'71f37d5f-4a06-4757-9d36-e1691aea628f',NULL,'0',0),('187a1c85-2d48-4fa3-9b50-15e8b711c470','2016-08-08',NULL,16431,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'294e21e2-5410-4522-b947-588746f1293d',NULL,'0',0),('18886525-c6f8-4655-aea5-0f09d8ea776b','2016-08-08',NULL,43138,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'86177d45-c973-47b6-8f6c-8118612b293c',NULL,'0',0),('18953e5f-59e5-4c97-834e-c66cd2d9bafd','2016-08-08',NULL,2459,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c5b2399d-dd5b-4657-8634-a29f56a6ab61',NULL,'0',0),('18d9b914-aa3b-49c0-94ed-571d6818686e','2016-08-08',NULL,15028,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'65cd8f3c-3823-4bdb-8c3b-1bc6f0430048',NULL,'0',0),('18f49c20-f273-407e-98b5-243a263f4f9c','2016-08-08',NULL,428,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e6c6610d-1978-42a2-8d28-7961a29e41b6',NULL,'0',0),('18f8eed9-ab97-4505-8ec9-04a6c6d39147','2016-08-08',NULL,1485,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'a86a1c82-5128-43d8-a865-376d8d6605a0',NULL,'0',0),('1906e1dd-7251-416c-8b71-9b73ebd177ba','2016-08-08',NULL,14904,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'58bddaf4-9a09-4467-a875-076afa91c497',NULL,'0',0),('192934ab-c7d5-4ca6-96e1-184b7a16e7c8','2016-08-08',NULL,7452,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'8c62ba4e-7a19-4733-a76e-c028a81c7a6e',NULL,'0',0),('192b27d8-eb40-4b4f-ad3d-d6519f6b8adf','2016-08-08',NULL,11385,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e4a44977-647c-44fd-b0d2-e6a3a566288b',NULL,'0',0),('1946d91b-a494-4c41-94f3-96102ee84bd1','2016-08-08',NULL,7286,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'7c02890e-1b8f-4be3-84ad-b79727abe03b',NULL,'0',0),('19800067-5f96-4b2e-8d85-89feba4c3723','2016-08-08',NULL,29497,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'9bdd597f-80b5-4660-8436-1c06fcf1a281',NULL,'0',0),('19b64dc3-1f8a-4b2a-bb0b-cfa7ebbcc2fe','2016-08-08',NULL,5498,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'bf57047a-a2cd-4f22-9c1b-b0a8983fc974',NULL,'0',0),('19c3cde8-d1e0-4990-82bd-b9718b31fdca','2016-08-08',NULL,743,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e93254d9-a933-43d9-b552-a0809afa4da2',NULL,'0',0),('1a17116f-148f-401a-bfbc-b4463ae52704','2016-08-08',NULL,290,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'f5509dde-0cea-4281-9079-1dcf6a033ee2',NULL,'0',0),('1a24c582-ce68-4b9f-b01c-6be31d5ced9f','2016-08-08',NULL,1296,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'f7d7c867-796b-4303-b251-a1f80c74eceb',NULL,'0',0),('1a4b811a-3b17-428b-9c2e-84a0d517e14e','2016-08-08',NULL,7590,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'7c02890e-1b8f-4be3-84ad-b79727abe03b',NULL,'0',0),('1a71e3a9-7b56-4ee8-b6fe-e7be3963224d','2016-08-08',NULL,210243,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'64c9411a-f84d-48e2-9278-9f32f2be4827',NULL,'0',0),('1a75a17e-90f5-4bec-aef5-eee5a80aed18','2016-08-08',NULL,27878,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'fab5103b-073d-4952-8280-017ff9faed93',NULL,'0',0),('1a970bb9-5a64-4e64-bd3f-4139a88aa812','2016-08-08',NULL,2587,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'552a43b5-8cb6-4d1d-94f3-1d85131a3d33',NULL,'0',0),('1a9a263d-103e-4433-ac47-39b9fddba8de','2016-08-08',NULL,22440,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'0f8b2430-75d7-49f2-bea0-ba53641982b3',NULL,'0',0),('1aa86f0b-d8d4-4e73-ae5c-24822d3d9568','2016-08-08',NULL,22138,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'925acc48-43d4-49b0-869e-d7b5b198de62',NULL,'0',0),('1aadd051-a7a1-4547-be26-30d10f0b150b','2016-08-08',NULL,540,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'2c1f9606-af8f-42ac-ac91-9eb2f322f5d4',NULL,'0',0),('1ad6a419-91dc-4525-86cd-b7a89453e9ca','2016-08-08',NULL,16200,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'b3437189-8abe-4895-b6e3-f09f4a0fca5f',NULL,'0',0),('1af8cd8f-6bfa-4038-ab93-38f43d3ddb04','2016-08-08',NULL,1254,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'2d3ab83d-cda0-4f36-8974-c4f72b10cd20',NULL,'0',0),('1b2ae1ce-b5e7-4948-a1a7-7c5d5ce71fad','2016-08-08',NULL,27001,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'8fb05868-bcb3-4cbb-ace3-a7927e243a7b',NULL,'0',0),('1ba17bf7-6331-414f-b085-9fa8682d63b4','2016-08-08',NULL,77760,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'7402a1f5-7001-4009-a5c4-29b9e09f7a56',NULL,'0',0),('1bf3059d-c2fb-4ca2-8976-0d67a68947c5','2016-08-08',NULL,2717,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'d39721eb-fa96-454f-bae9-d703cf4655be',NULL,'0',0),('1c2080d9-dfaa-4cde-a176-c4107f9d5e02','2016-08-08',NULL,2587,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'2c5d4a47-3f91-4771-aadf-8ee49ac08206',NULL,'0',0),('1c24e3bc-7a34-41f8-a78b-4ac34d75e550','2016-08-08',NULL,2049,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c5b2399d-dd5b-4657-8634-a29f56a6ab61',NULL,'0',0),('1c516dac-6bc0-47b6-99ba-cc356e5374a4','2016-08-08',NULL,54338,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'1aad43d9-279b-4527-8581-5c86a5885008',NULL,'0',0),('1c6661c2-a74e-4818-b60c-dbb264d73f43','2016-08-08',NULL,20714,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c792c260-f339-4bc5-8647-ebee072b58d5',NULL,'0',0),('1c8a635d-b81a-47c4-83ce-cc46ecd9dc57','2016-08-08',NULL,11437,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'8b60e990-a11a-45bf-b90c-83ccda6aac8e',NULL,'0',0),('1cc4d8a5-3dcf-4a92-a261-e289f921f338','2016-08-08',NULL,162,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e0850b2e-6108-475c-b8d1-3d94274a563b',NULL,'0',0),('1d4e793e-c0d8-4971-97a4-a7ff82a758ca','2016-08-08',NULL,12524,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'8ad9ae17-93e0-49e6-8915-d346b3285e03',NULL,'0',0),('1d5438d3-51a7-450f-9815-46dfad10da36','2016-08-08',NULL,14025,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'5598b1d3-8885-4b91-a415-8eae6cce5b33',NULL,'0',0),('1d618058-abe9-4a59-a410-05c2d7a3ef37','2016-08-08',NULL,4051,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'3c961304-e675-4a2a-bd21-15dbfb7297fb',NULL,'0',0),('1d635f03-1533-4156-b9b5-5628ec691813','2016-08-08',NULL,594,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'6adbd5fc-961e-4ccc-a08c-0a4dd9094b68',NULL,'0',0),('1d7a498c-a2f5-45f3-9a79-d7ed7086658a','2016-08-08',NULL,6578,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'36a7ee3c-cac2-47da-8a38-3fd1b2fe5e5c',NULL,'0',0),('1d872f9e-aa67-4c20-a1e0-11a577c07a6c','2016-08-08',NULL,323,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'6d78718a-6d47-4434-ae4e-fb33df9a0714',NULL,'0',0),('1db0e799-eca8-4aa5-a3d8-7f4ac1ef0de0','2016-08-08',NULL,12825,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'7490d418-9e65-4162-b095-3706d98cec65',NULL,'0',0),('1df32a81-e8ee-46f6-83c1-f1d24869aa9b','2016-08-08',NULL,6831,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'d3ea4f01-19cd-40ec-8c10-3c640de65756',NULL,'0',0),('1dfc80fe-4468-4e11-84c4-d1754c0b6c84','2016-08-08',NULL,12114,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'61bb5f10-9e56-4152-b8ee-a08b606f4e4a',NULL,'0',0),('1e2ce272-70a0-4a24-80e0-08610f609df5','2016-08-08',NULL,23220,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'68172e37-b09a-4a41-b9b3-a1fa7714310e',NULL,'0',0),('1e6d5c18-f58d-4031-9e47-4c5a6ce12bef','2016-08-08',NULL,35397,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'9bdd597f-80b5-4660-8436-1c06fcf1a281',NULL,'0',0),('1e815f72-4e0f-4ef7-be32-03085ad15a61','2016-08-08',NULL,29756,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'10fc4ac8-48e5-403c-b89e-45b88e772f96',NULL,'0',0),('1e865097-cbc5-42b8-a4f4-c36ec52de6c7','2016-08-08',NULL,11799,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'0b74682d-2c3c-471b-81f7-0d3c1cdfc550',NULL,'0',0),('1ea658cf-2378-4dfb-8d8f-ede985b793ba','2016-08-08',NULL,330,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'7efdbb21-13fd-4f57-b50d-0d16f29cef39',NULL,'0',0),('1ea985ab-085f-4e4a-9af0-a5efbafe2e6f','2016-08-08',NULL,713,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e93254d9-a933-43d9-b552-a0809afa4da2',NULL,'0',0),('1f2d0105-b158-40cc-8330-8e72a1f5fbf3','2016-08-08',NULL,8279,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c1ffa627-94af-4280-b9ba-8860742229dd',NULL,'0',0),('1f40ea6b-11ff-4892-b2e5-97b4b7f46cc3','2016-08-08',NULL,22310,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'59216eee-bf00-4692-950c-2cf34e629738',NULL,'0',0),('1f555dbd-031a-485f-a171-3678bec9d5fc','2016-08-08',NULL,381,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'d81b8cfc-b9de-4275-bc14-d29dccbd0ed5',NULL,'0',0),('1f93dbee-8b6b-4873-862a-8a5330754449','2016-08-08',NULL,9750,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'36f18236-d50a-435e-9869-968e0b2f0025',NULL,'0',0),('1f98df4f-a565-467f-8c3f-32fd966fb40a','2016-08-08',NULL,23782,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'99bd428f-3d27-41e7-8604-53cc2c550c24',NULL,'0',0),('1fa42fe4-388f-4857-bc4f-743ce171141b','2016-08-08',NULL,5093,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'642632bb-2fdb-44e0-be92-e24ae6af802c',NULL,'0',0),('1fa942a0-5e9d-437c-8dff-04281a4fb997','2016-08-08',NULL,14801,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'7cb2bdf0-f0c3-4588-9798-541920f448a3',NULL,'0',0),('1fb07f3d-c46d-4ea5-99f1-95df7a2ddb52','2016-08-08',NULL,14878,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'5b57adca-ba56-4bca-8f04-28e81565e91e',NULL,'0',0),('1fc14b01-05db-4201-b834-6a8cfe9c983d','2016-08-08',NULL,1459,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'f584df16-bf95-4599-ad19-78169da7c723',NULL,'0',0),('20345e06-6a5a-43ad-bece-39d9fcad6360','2016-08-08',NULL,2910,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'58e969cf-bf1c-4aeb-9029-04baeef1b071',NULL,'0',0),('2048a50e-3462-4c08-a847-823bcc3873d9','2016-08-08',NULL,8832,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'b85869e6-1f03-4be5-9f4a-74a0646c0272',NULL,'0',0),('206a4638-8054-46c4-9372-ca32946621b1','2016-08-08',NULL,7948,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'02969de9-2b60-4a29-bbe9-563ebd952079',NULL,'0',0),('209614eb-76ec-4296-b6ff-38c2bd727997','2016-08-08',NULL,23575,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'36574898-6c20-4cc9-addc-8e6a68ca5cb9',NULL,'0',0),('209a55e7-e0bf-440b-b940-9d5a0fa7bdd3','2016-08-08',NULL,434,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'a87e543d-44d6-4ce5-8cab-722c673e4b06',NULL,'0',0),('209ed182-c451-4c08-a201-804ab0931478','2016-08-08',NULL,2070,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'23e015ae-9fe0-4fbd-b73c-782ebe70c2c0',NULL,'0',0),('20ccfc6c-e58e-4841-8aa5-92063dc9df96','2016-08-08',NULL,6577,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c9458386-b9d4-4894-adb4-10fd81c841d3',NULL,'0',0),('20df35eb-1640-480b-85dc-0f104879ff40','2016-08-08',NULL,1823,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'f584df16-bf95-4599-ad19-78169da7c723',NULL,'0',0),('20e64def-cca3-4d06-8cb3-57793b3b1d53','2016-08-08',NULL,3882,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e090d829-4bf3-4c32-9cd8-78d1ef511b84',NULL,'0',0),('20f53a6d-e559-443f-85cc-1844a6a25fb0','2016-08-08',NULL,1035,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'433efd3b-65e9-4918-9b26-586aabdf8b9c',NULL,'0',0),('211861d9-3508-498b-b129-f6583843b163','2016-08-08',NULL,14158,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'b994e8aa-85d4-402e-9b96-6e4b839b9e07',NULL,'0',0),('2120d0eb-b2a5-463e-9cba-9778db63cadb','2016-08-08',NULL,18469,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'ec15592f-6863-4097-93de-a5abad4820e2',NULL,'0',0),('214484d0-ccb1-4f27-84ec-4063ad5d68ad','2016-08-08',NULL,2173,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'4167a503-bf99-413a-aa33-d645212307f5',NULL,'0',0),('21748ae8-a6cc-44c6-9bba-3c9bd8e58787','2016-08-08',NULL,8424,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'b8472f07-a2a4-41c5-b338-e3d5f2b16e39',NULL,'0',0),('21871685-d56a-4077-a730-fed1006d8f9d','2016-08-08',NULL,894,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'30176b2c-1c16-4774-9e4a-724306b412d3',NULL,'0',0),('218c12a3-be53-437c-a29d-ff2307496630','2016-08-08',NULL,18354,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'6437460d-aebc-43e0-9172-ad29b40444ad',NULL,'0',0),('21fca5e9-b304-409a-bf20-8a9c79757ddf','2016-08-08',NULL,9108,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'9eab9be0-7355-4001-86b3-d701aafa247a',NULL,'0',0),('21fd2377-c939-4201-bfc3-d5c7c86723d7','2016-08-08',NULL,3752,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'a49fe108-ce17-4da1-862b-23448b62fa99',NULL,'0',0),('22202220-c52d-4e61-8ca5-484b6ceb10cf','2016-08-08',NULL,5832,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e40889c8-9ad8-4ccf-b2be-b2deb2ca6964',NULL,'0',0),('2231e595-aed3-4798-bc0e-d595a1fd2c6a','2016-08-08',NULL,2459,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'a08ad19a-61f0-46d4-87b8-8da6c8fe0e3f',NULL,'0',0),('223f7de6-926a-4878-8a66-48ac2a92077e','2016-08-08',NULL,46451,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'76c588c8-fd4e-460c-bc82-32d0f60eed1a',NULL,'0',0),('2272eb5e-91d8-4739-b539-519b6a78ee1d','2016-08-08',NULL,1815,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'d395d475-8136-4cf8-a162-5c9420acc2ff',NULL,'0',0),('22a08a38-bf1f-413e-9fec-e2f3d21541b5','2016-08-08',NULL,7451,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'80b8cfbd-0752-460a-9a21-f5e8554aaacb',NULL,'0',0),('230db0d0-c20c-43ed-9a5c-079c4c73b039','2016-08-08',NULL,7503,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'8af03560-3305-471c-8325-9b7acff96352',NULL,'0',0),('2318a0d0-65c7-46b4-a11f-49b6e756b4d0','2016-08-08',NULL,707,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'b32bbb38-8c60-4dd3-80b7-5d2fedea25d6',NULL,'0',0),('2342a95d-a360-4820-be01-aa10db540354','2016-08-08',NULL,20183,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'baa27c38-f9aa-49a3-8bc4-f63796d77a83',NULL,'0',0),('2349290a-fcf9-4337-989b-61b60074769f','2016-08-08',NULL,1080,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'528ead48-3584-468c-aaa1-5484a33230f7',NULL,'0',0),('236b5976-3a90-4f63-94cf-8e1ae638c9c2','2016-08-08',NULL,49680,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'7da6917f-afda-45c7-a879-2eed000bfc5b',NULL,'0',0),('2376e802-cd50-44f2-89af-9a42c93d7770','2016-08-08',NULL,10124,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'3252a452-2840-427c-9a77-2107111ff6af',NULL,'0',0),('2377972b-5282-4623-9263-6f5434393f75','2016-08-08',NULL,5111,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'dc7b57d7-2ba4-451d-a5f1-0d0ae4c0c6f3',NULL,'0',0),('238fa435-c437-4585-a8a0-4db1d4d71d1d','2016-08-08',NULL,356,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e6c6610d-1978-42a2-8d28-7961a29e41b6',NULL,'0',0),('240a0885-dd21-4637-ae46-ca8c8130587a','2016-08-08',NULL,11902,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'1c4909bc-5c44-4efb-aaa7-3d0eb384c349',NULL,'0',0),('247b67b1-43a0-4b3b-b325-83118f36fb90','2016-08-08',NULL,1863,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'ff17b5c0-4ddb-4aaf-aed0-27d0823c2784',NULL,'0',0),('2482b06d-9670-4950-9419-0d00c0066e96','2016-08-08',NULL,27299,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'a42e340c-95ea-4b76-82ea-692dace6f11a',NULL,'0',0),('249df64f-3a8b-4812-ae60-0fdffe1fc4c7','2016-08-08',NULL,7452,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'29aaecee-60e6-40ca-813f-91cd2156c033',NULL,'0',0),('24cf13aa-bc13-425f-9a34-63bdb44b87cb','2016-08-08',NULL,12032,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'bc3117b5-90f1-40fa-bc79-119f1708f934',NULL,'0',0),('2549cdbc-261d-438b-bdfb-11d4fb6b71bb','2016-08-08',NULL,48679,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'1f908ff9-e0bb-49db-91f0-d098e5661987',NULL,'0',0),('25680300-7fc2-4ab7-9ed7-48e7b567b53e','2016-08-08',NULL,30525,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'01b8a9fa-5733-4ee8-8c08-b20e26e5c167',NULL,'0',0),('25751896-04d1-4f0f-9703-1b697a2aea96','2016-08-08',NULL,67994,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'7071cada-b946-433b-bf14-87dd877b3ab1',NULL,'0',0),('2593352a-af45-4506-be69-45682781ab0e','2016-08-08',NULL,7452,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'65226da3-5150-408e-94f0-dd3c4eb90443',NULL,'0',0),('25d928ab-375c-45fb-9e45-e885371d33de','2016-08-08',NULL,259,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c7ebf076-3e1b-4c45-985c-3cd09fd3ecba',NULL,'0',0),('262f4ada-5c1b-43b1-82f6-ba483259e87e','2016-08-08',NULL,27562,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c52ad20c-a94c-4cd5-aa1d-9ca21062c369',NULL,'0',0),('263a7807-ca20-46cc-aaed-ce38804a2727','2016-08-08',NULL,11644,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'5368a724-8791-4235-a3c3-14be6a7c8366',NULL,'0',0),('26414a88-636b-4d75-ad3e-f43221087b68','2016-08-08',NULL,32399,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'65452f02-fea6-4557-b2d1-16b5c7cb699a',NULL,'0',0),('264a2e7a-2f32-4af8-8cd9-0dca27fa8304','2016-08-08',NULL,18755,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'24e58c5e-7f82-47ed-a56d-d384a29515ec',NULL,'0',0),('2651136d-b1cb-4b9e-a1ee-2be2e90c6330','2016-08-08',NULL,17549,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'05f6c643-47dd-4a0e-9e60-607c5a72e2b1',NULL,'0',0),('2658b16f-9427-4ab1-962b-02b8840b0e70','2016-08-08',NULL,2295,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'a2f0a0e0-671f-4653-b4b6-5f2e80c97ad4',NULL,'0',0),('265f9bb8-7cdf-43ef-a28d-38a8f9d91ee9','2016-08-08',NULL,20700,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'b1e8d539-2fa7-4c11-bb0d-b6889fb8bced',NULL,'0',0),('26d7f41f-14f3-4160-a475-eb602955d9e6','2016-08-08',NULL,2591,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c5404306-9de8-4113-9ff4-ff5856f00da7',NULL,'0',0),('26fb4cb4-6d47-4594-a042-a37f2f4d49c1','2016-08-08',NULL,19924,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'6885ead4-766d-4d90-95b6-62b83e0d62f6',NULL,'0',0),('272769ca-316b-45cc-8795-b1b800b83bf5','2016-08-08',NULL,334,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'de368c77-e855-4ee6-bbb4-89194ee66380',NULL,'0',0),('2727d85e-4b32-4636-b6b2-1306dfb1f4b6','2016-08-08',NULL,924,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e308ba64-e78e-4228-93d9-24a081bef865',NULL,'0',0),('273c8978-fba2-4f5d-ad42-0867fc91f793','2016-08-08',NULL,10260,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'7490d418-9e65-4162-b095-3706d98cec65',NULL,'0',0),('274624c0-e7f4-4409-a403-fd75d2805878','2016-08-08',NULL,65805,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'27730e12-6012-4ac1-8c7c-17669fdf9916',NULL,'0',0),('27787de2-29ce-49d5-bab1-29212dc6a95c','2016-08-08',NULL,2717,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'4167a503-bf99-413a-aa33-d645212307f5',NULL,'0',0),('278fa693-a62f-4adc-af0b-3a590b312e09','2016-08-08',NULL,8100,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'fff81e0f-ed13-4065-8c65-36a9ac7c72fe',NULL,'0',0),('2809aef0-816a-4187-953a-e2e4cba6df06','2016-08-08',NULL,13196,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'f499b6ec-2027-4ae3-a9f8-7d750045122f',NULL,'0',0),('280ad2db-ddff-4d96-8f6e-f7f0de39e35c','2016-08-08',NULL,338,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'848536e1-d0f1-499a-8cd1-40bfb1c2efe1',NULL,'0',0),('28383ef0-9488-40bf-b968-19043f21ddcb','2016-08-08',NULL,7203,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'1f43ba02-de8f-4b1a-8d5c-d5fabf862158',NULL,'0',0),('283ed03a-bff1-4d62-aa3e-80b3d3c4d774','2016-08-08',NULL,6599,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'45aa3047-9d7f-47e7-acc4-5b66206c38ab',NULL,'0',0),('28451cb8-fa2c-450a-8a64-6f0d90b9f968','2016-08-08',NULL,29253,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'f5c029dc-c40e-4c0e-9d89-d00473706b36',NULL,'0',0),('286470d2-24b4-4215-90d3-4b300b308f94','2016-08-08',NULL,13662,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c9964447-2625-43e3-85ca-67f5ba4e6cfb',NULL,'0',0),('28a52752-b524-4f5f-af52-87caaae58391','2016-08-08',NULL,808,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'3408fa37-27a1-4ba7-aabd-47da2341f48b',NULL,'0',0),('28ca00bb-7e84-40d8-96b6-177056ae480c','2016-08-08',NULL,137655,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'0dc97e5d-c36b-4bc9-bdbf-62bce2412dd0',NULL,'0',0),('28cad7e4-8dd3-4ad3-be1f-87aea492ca35','2016-08-08',NULL,1822,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'ac9cf706-1129-4ec9-98de-35e2e3406708',NULL,'0',0),('290b7d41-f8fc-4aaf-be3a-7d3749af36d5','2016-08-08',NULL,1164,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'18315342-7f0d-43e6-8710-71ce095f0f5f',NULL,'0',0),('29183ee0-0ef0-40ea-a01e-737af3380e3d','2016-08-08',NULL,835,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'752be6c7-a8e5-4f8b-a309-2f79926c6f47',NULL,'0',0),('2927ff97-fcd8-4a59-bf18-f7c80baf649a','2016-08-08',NULL,1242,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'7819a076-6e2b-40d6-8fb5-82352074c6c5',NULL,'0',0),('294c358c-095e-4dbf-956c-2598bd1df6d8','2016-08-08',NULL,2530,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'152f2e0e-1a2c-417f-82c1-b280460976fd',NULL,'0',0),('29580f2c-f3b6-4633-ad24-ddafd3b71075','2016-08-08',NULL,22045,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'88de4ea2-80d9-4152-91aa-4817f82e8f89',NULL,'0',0),('296573c7-3ce8-4ee3-a522-59c8d7910c10','2016-08-08',NULL,10738,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'4fccf62e-f6c6-46d9-948b-ff2c1f769fff',NULL,'0',0),('29bb8f98-aae2-4f82-906c-58a85b69bc7f','2016-08-08',NULL,5822,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'ec29bc77-685a-40ae-a6fd-2c7f6eecd9f4',NULL,'0',0),('29d8227f-bc4d-415d-95bc-b9c3e47a4414','2016-08-08',NULL,3002,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'a49fe108-ce17-4da1-862b-23448b62fa99',NULL,'0',0),('29ec1b1e-bb26-4bf4-82f5-367a67df4b5c','2016-08-08',NULL,7080,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'b268586d-4579-4679-b24c-8ba634cac4dd',NULL,'0',0),('29feb5d7-d70e-4f70-acf3-d5b4f8b1e398','2016-08-08',NULL,108,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'bb27bc70-e246-4a79-962a-52775600eb4a',NULL,'0',0),('2a1de83e-e6e3-4405-aed8-52b09e910414','2016-08-08',NULL,37950,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'7fd16ed2-3b51-4d09-b5ed-4bad37a4f0f4',NULL,'0',0),('2a23a1f2-5f5c-455e-94e7-e70220e87c73','2016-08-08',NULL,16456,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'09fb4270-b803-4287-ba6b-6c2d1fa0a2b8',NULL,'0',0),('2a3179c7-87bb-4aed-a257-48cec5ace922','2016-08-08',NULL,724,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'f8c1840f-43db-4e51-9269-26f9756f71f8',NULL,'0',0),('2a31a209-5c03-4ff9-800c-d9a50aae76f4','2016-08-08',NULL,10184,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'940bd155-9e53-419b-b24a-bab1df49a63c',NULL,'0',0),('2a80a12f-7c21-46e3-a112-79b3803c8922','2016-08-08',NULL,3889,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'3c961304-e675-4a2a-bd21-15dbfb7297fb',NULL,'0',0),('2a873826-d38e-4401-a023-58db613abf52','2016-08-08',NULL,139150,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'3bb38ddc-5073-46f7-ad04-d6862c1ac3c2',NULL,'0',0),('2afe498e-5b4b-4ef1-8420-44021802bf5c','2016-08-08',NULL,7116,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c8d40fe1-4615-48ca-84ac-2a08faa62232',NULL,'0',0),('2b1e9199-a83a-4033-944f-475a53090b61','2016-08-08',NULL,41508,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'a98f5afa-f5c0-4922-a065-0d2f5f68001c',NULL,'0',0),('2b1f0e62-41b5-4fbe-8744-931c05d2da68','2016-08-08',NULL,432,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'475990d7-a7ee-46c3-9ed3-ec1079542117',NULL,'0',0),('2b381a54-3611-4c18-bcdd-ec48839bf2f5','2016-08-08',NULL,37159,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'de8c5b61-d15b-47dd-8cc2-a4a75be4c43b',NULL,'0',0),('2b51a696-fb0a-46e6-8b60-c8ba2c009fa5','2016-08-08',NULL,933,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'7de23c6c-a740-4950-9dc1-a559453a4ca6',NULL,'0',0),('2b8856ec-0745-4e4e-a9e0-26e979611148','2016-08-08',NULL,14586,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'813771de-1fa7-46c2-b11d-f5352868396b',NULL,'0',0),('2bba197f-6510-420a-a56c-f46167b3f1c3','2016-08-08',NULL,19664,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c770feb5-f73f-4dda-868b-5577dbb125aa',NULL,'0',0),('2bc31f0e-3558-496c-99c2-202522bfbb83','2016-08-08',NULL,8943,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'45244017-1aa1-4e0a-9540-5006fef47712',NULL,'0',0),('2c1ff8f5-e598-4e5a-8bbb-f50ba86ccb75','2016-08-08',NULL,166980,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'3bb38ddc-5073-46f7-ad04-d6862c1ac3c2',NULL,'0',0),('2c27bd4a-e948-4460-aa91-a2596c485279','2016-08-08',NULL,2587,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'23e015ae-9fe0-4fbd-b73c-782ebe70c2c0',NULL,'0',0),('2c30835f-289d-4fbb-825d-e7d47c75464c','2016-08-08',NULL,14904,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'2c7e34a0-931b-412a-9aa6-63af17f37815',NULL,'0',0),('2c31485e-03d4-4045-9baf-dbadd0c3f8ae','2016-08-08',NULL,31568,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'3d9d81c3-3528-40a0-a29a-a34658dc8075',NULL,'0',0),('2c8166d3-5725-4d89-8fdb-faeef3ec0cce','2016-08-08',NULL,4968,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'ef1f9e0c-2dee-4fe4-b034-fd395366198c',NULL,'0',0),('2ce339ef-939d-4d25-9908-5cabd345732c','2016-08-08',NULL,32805,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'3d56278b-58dd-4f82-9169-d8a478a21b43',NULL,'0',0),('2d133329-38d0-4c7c-9298-e8f069655bef','2016-08-08',NULL,34155,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'81bd16af-abfd-4a2a-b92b-15bc2240459c',NULL,'0',0),('2d14a3db-1903-4496-9955-3be569586170','2016-08-08',NULL,2721,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'44315dc2-e2fa-44dd-8de8-8330ed4de153',NULL,'0',0),('2d26b6e7-d9c3-45d6-9843-c2806985a777','2016-08-08',NULL,1823,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'3fc3e6ff-2011-4022-bd3a-6c826cbc2411',NULL,'0',0),('2d320047-7cb4-4aba-94ae-59654756bbe1','2016-08-08',NULL,3577,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c04fb5e7-4366-4ed4-8427-e788be8af7a5',NULL,'0',0),('2d69bef4-fe22-4cfd-b9f3-9b43d5b179f1','2016-08-08',NULL,15008,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'941fa182-a1cb-4490-89a6-4ec3d660dee6',NULL,'0',0),('2dbf2c33-3b04-4309-8d84-8a20f9e5e810','2016-08-08',NULL,492,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'a009032a-47ee-4ca2-99dc-ca8576c39bdc',NULL,'0',0),('2deb934d-dc6f-4d0d-9895-a061dfac2462','2016-08-08',NULL,16664,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'1cbdf52a-e1bc-4242-b846-d9b8f5e323c3',NULL,'0',0),('2e0b09c0-bf1f-4a61-8227-443fd855b1d8','2016-08-08',NULL,52165,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'1aad43d9-279b-4527-8581-5c86a5885008',NULL,'0',0),('2e0f54ce-e5fe-4ed3-9eba-de8db3a8eb0d','2016-08-08',NULL,11799,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'3cc43db8-3894-4bc1-9c71-a199f253e1c5',NULL,'0',0),('2e3c0fc4-7659-4ae1-b7f4-9c8f80f332cd','2016-08-08',NULL,42694,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'1e266883-c6d2-41d3-8c11-cea3402a4948',NULL,'0',0),('2e3d61af-af8f-4a13-91ec-ef514fdb8785','2016-08-08',NULL,362,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c2ba0874-6005-46c2-ace4-3ab3ab318a79',NULL,'0',0),('2e445259-38ef-4b67-9142-b94a0b95a1b5','2016-08-08',NULL,7128,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'f716a70f-946f-4b3f-9f69-cd8016f608d9',NULL,'0',0),('2e4541ff-b7f6-4927-bd4b-1fda288315aa','2016-08-08',NULL,34151,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'5463545e-fff0-4208-aec6-0d308efacdc1',NULL,'0',0),('2e48d99f-52c1-4309-8397-3ed839320de5','2016-08-08',NULL,17495,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e2b230a9-e241-486c-838a-edb2493bdd5c',NULL,'0',0),('2e9b8399-1391-4a26-b0fc-510bc7f9ba5c','2016-08-08',NULL,7375,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'ff0b0889-7927-4b8a-a0a8-39bfc31e2bbd',NULL,'0',0),('2ea1266c-c0fe-430e-8952-3dd4ae6f7ad3','2016-08-08',NULL,18150,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c9438eeb-a4e2-4532-a7b2-e7b0aa4aa16b',NULL,'0',0),('2efd8408-2e25-40dd-b6e6-ae7accf30626','2016-08-08',NULL,79063,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'1cb74234-3d39-4b32-bf58-4b07136eb87b',NULL,'0',0),('2f229c3f-72eb-47d2-9b98-702ae6512c99','2016-08-08',NULL,7116,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'9b41758d-7e48-48ec-b404-68266f47a57d',NULL,'0',0),('2f49d6c5-6bcb-42ce-bdd7-b2829906c9ee','2016-08-08',NULL,4658,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'63117b43-e0d4-4cb0-bd97-088027d7be28',NULL,'0',0),('2f5c8d01-8cbd-4a98-8c3d-388d98543649','2016-08-08',NULL,635,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'2fd63757-2ddc-4466-b04f-a3ca142b8591',NULL,'0',0),('2f670801-493b-497e-9171-4aa989e2d8b9','2016-08-08',NULL,8279,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'6e17ec90-63af-41c3-8cac-5bd946faaf82',NULL,'0',0),('2f8354ce-eb71-4fb6-9375-b903d05ff77a','2016-08-08',NULL,2160,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c5404306-9de8-4113-9ff4-ff5856f00da7',NULL,'0',0),('2f849625-b8c8-4a9c-8a69-ebaccf092504','2016-08-08',NULL,211,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'de64e7fc-bcc1-431f-badd-e1ca9df3aa03',NULL,'0',0),('2f9888b9-361f-4ff7-b00a-5646f87630ea','2016-08-08',NULL,5400,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'fa602e6e-5fa2-4940-962b-5a3a1e59ae1a',NULL,'0',0),('2f9bc259-b49f-4076-be67-40b192f1b2eb','2016-08-08',NULL,7211,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'2cc86f32-a7e0-4d34-82cd-b434a2b41768',NULL,'0',0),('2fcf20f7-1b1d-4273-9f60-a8698d456556','2016-08-08',NULL,2200,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'d62b1240-3a2b-4a40-8db0-5cd165cfa8f3',NULL,'0',0),('2ff8d3bb-fd17-4fb7-8d11-c1d4f050db6c','2016-08-08',NULL,271,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'756a6964-9037-44fc-aa3b-ce6dd9cd062d',NULL,'0',0),('3001b770-4c2e-47b1-9599-2c801d92044f','2016-08-08',NULL,58320,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'5c2fa992-184b-405e-b219-1041885afd21',NULL,'0',0),('30057816-82dc-4c63-af60-04d43b84dcdf','2016-08-08',NULL,7511,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'2cc86f32-a7e0-4d34-82cd-b434a2b41768',NULL,'0',0),('3007479e-2ff2-487f-bc0d-7f1b5da0bb96','2016-08-08',NULL,24300,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e599645c-8615-4d84-ae88-b7f9e464feb0',NULL,'0',0),('3067125f-75ef-4450-af2a-c91fa634b626','2016-08-08',NULL,175203,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'64c9411a-f84d-48e2-9278-9f32f2be4827',NULL,'0',0),('3085a5da-94d1-4646-a0a1-bbd4922638a7','2016-08-08',NULL,726,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'8c857058-ba14-46fd-b220-4cf196a557d1',NULL,'0',0),('308a9ddb-d9b2-488b-b0aa-0c318a149f0e','2016-08-08',NULL,108,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'5f70495e-f309-4199-a38c-8272f1267a13',NULL,'0',0),('30b84152-46b8-474d-aa0d-982fd407be9c','2016-08-08',NULL,2236,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c7848e87-3983-4bf0-80dc-52e066e312ac',NULL,'0',0),('30fec557-7031-4186-a783-75882659d26a','2016-08-08',NULL,5940,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'1055232b-f75f-432f-92fc-d252a55af5f1',NULL,'0',0),('311a11e4-d65c-4c82-80a1-d37451ca6e06','2016-08-08',NULL,118642,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'f660a9fc-459f-4277-ba19-e9dd28598262',NULL,'0',0),('31446e92-8dea-4c81-9166-dc6f8595cb04','2016-08-08',NULL,23909,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'33da234e-081b-4a4e-8e98-17cded390bba',NULL,'0',0),('3176f5f2-f054-40cd-afc1-b30b31be6221','2016-08-08',NULL,65274,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'7071cada-b946-433b-bf14-87dd877b3ab1',NULL,'0',0),('3199983f-171c-4bfc-9032-9a500f6acbab','2016-08-08',NULL,17623,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'82b32d45-0766-4c17-bfa2-855793ee7e8e',NULL,'0',0),('31ccd4b5-0bde-4337-a270-e509474f2f50','2016-08-08',NULL,12808,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'7a93e08d-12b3-4643-ac13-abb218ef0624',NULL,'0',0),('31d9801f-ff7a-4c0d-aad7-a446f641373d','2016-08-08',NULL,1944,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'ee3f7798-3a92-4dae-92c4-804317e4f8bc',NULL,'0',0),('32021214-8725-4200-9b97-33ee68129217','2016-08-08',NULL,14904,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c7383f85-c820-45e2-a939-ce24c50ad173',NULL,'0',0),('325d7242-87a2-45a6-bd4c-f8577eb86cb0','2016-08-08',NULL,2970,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'40858ddf-87fc-47ac-8f18-f1d67e2bdea9',NULL,'0',0),('32661158-14ac-42e2-bebe-8a8bfda8677e','2016-08-08',NULL,5693,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'a5e168c0-d73f-4caf-860a-e5cc4cc47ffb',NULL,'0',0),('328e403b-0be6-4382-8dc3-66f36fb21180','2016-08-08',NULL,1967,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'a08ad19a-61f0-46d4-87b8-8da6c8fe0e3f',NULL,'0',0),('329a8378-aa23-44be-b030-d2c406bb17f9','2016-08-08',NULL,2699,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'3970bb04-951f-4143-9f9a-9c5bedef7140',NULL,'0',0),('32c7eed3-b6f4-4f92-b7ed-940bff4eb14b','2016-08-08',NULL,21606,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'b0e53c7d-fa19-4d03-8276-5fc5b8bb5973',NULL,'0',0),('32ded53a-917f-457d-b347-43e4b54c527e','2016-08-08',NULL,7825,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'a4dc0839-9fda-45ca-ac7b-7c510434d303',NULL,'0',0),('32e58aa3-fdd4-48c5-982e-15eb133eb62b','2016-08-08',NULL,18760,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'941fa182-a1cb-4490-89a6-4ec3d660dee6',NULL,'0',0),('32e60386-94a5-400c-914d-1c9198453710','2016-08-08',NULL,589,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'b32bbb38-8c60-4dd3-80b7-5d2fedea25d6',NULL,'0',0),('331aabb8-8ae6-41b8-934e-7121fc7be972','2016-08-08',NULL,126500,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c1b5c607-f976-40c3-9c8c-7a53d31fbabf',NULL,'0',0),('33354a65-297d-4d95-8dbb-fa08f91ea647','2016-08-08',NULL,7762,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'6b42eaba-807c-4697-918d-e5d432bb83f2',NULL,'0',0),('335d2434-4542-43a6-b94f-745aa5902759','2016-08-08',NULL,1346,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'99574587-106f-4cca-8241-5ee3aa395b1d',NULL,'0',0),('3360c2c3-09ed-4a72-a3d5-a3de8fa9178f','2016-08-08',NULL,6831,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'805eab32-9eb1-4345-8d2a-cca424169ae5',NULL,'0',0),('33644faa-e454-449b-964f-9894c7661578','2016-08-08',NULL,2025,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'25d4db4a-715f-4561-9441-06da16bf5f7a',NULL,'0',0),('336622ba-d0f6-430b-9702-95b89ac1cc82','2016-08-08',NULL,3111,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'6f5dda22-2d2b-41a1-a350-3199c935c163',NULL,'0',0),('33809e7e-ee80-47c0-b946-71490c8ef2da','2016-08-08',NULL,1913,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'a2f0a0e0-671f-4653-b4b6-5f2e80c97ad4',NULL,'0',0),('3390a802-99ae-4aed-ae4b-55d2ba14dfc8','2016-08-08',NULL,1875,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'6e98c5ca-3261-495e-89d1-4a46156ca08c',NULL,'0',0),('33a7947d-d205-4538-b912-b272e6a2ca8f','2016-08-08',NULL,8247,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'89fad77b-ec05-4e93-98b7-2fbe43971f7f',NULL,'0',0),('340d618c-8a0c-4a29-9163-b3f18a700297','2016-08-08',NULL,21735,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'53d8fc10-c72b-46e4-ad97-dee6500c19d6',NULL,'0',0),('34346720-47d0-4a51-9aca-1745762e115c','2016-08-08',NULL,3499,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e166d6d7-7cf8-4e5c-a13a-4499d9762f7f',NULL,'0',0),('3463da4e-830a-4698-862b-10017ec450d5','2016-08-08',NULL,2873,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'5c293368-1897-4eb3-9915-e1cf6351d918',NULL,'0',0),('34845847-7a1d-4ed0-afe8-64708f4a0483','2016-08-08',NULL,7762,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'8c62ba4e-7a19-4733-a76e-c028a81c7a6e',NULL,'0',0),('348c0b4e-e2cf-412e-b0f6-0a8a4347c60e','2016-08-08',NULL,262770,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'bc857948-b661-4946-90dc-cb01ad88aaac',NULL,'0',0),('34930ab8-4292-4f5f-9d99-0c78c3433b7b','2016-08-08',NULL,130,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'a6e3696d-0ee8-4baf-99b4-8e0771fbb187',NULL,'0',0),('34d6194e-7ed6-47ca-aa11-2e78d4066e99','2016-08-08',NULL,22138,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'275f070a-ae3d-4f29-a882-cd6bd9fca7e5',NULL,'0',0),('34e147b4-3b65-411c-bad1-25ca7d74ad9f','2016-08-08',NULL,33249,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'692315c9-fc59-4954-ac73-05aa49d2d9a1',NULL,'0',0),('3518d79d-8b14-4dba-8554-0f5bd9092c89','2016-08-08',NULL,18630,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'6c07f9de-da43-4f10-b6df-1fc86d407e83',NULL,'0',0),('35291115-3a12-442a-9553-ac0a3f5576c6','2016-08-08',NULL,18224,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e2b230a9-e241-486c-838a-edb2493bdd5c',NULL,'0',0),('354e1ae3-3db4-49d7-ad9c-f0380a37133b','2016-08-08',NULL,9688,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'4eb68a82-560b-41b0-bdd7-3c7bb9609939',NULL,'0',0),('354ef83f-a557-4094-8139-9270fe2ac18b','2016-08-08',NULL,1238,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'979b84a9-1298-4b81-a180-eca8f1d01982',NULL,'0',0),('3576876e-296f-416b-9e57-735317762844','2016-08-08',NULL,305,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'d81b8cfc-b9de-4275-bc14-d29dccbd0ed5',NULL,'0',0),('35907f38-a913-44f0-8fb6-26ad7173f0c1','2016-08-08',NULL,8100,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'5abe998d-42be-49d3-a2dd-2a2aff059473',NULL,'0',0),('35e596a1-131c-4d31-83cc-63f003b3ba64','2016-08-08',NULL,8508,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'37cdc631-a446-477e-b477-5f6d3568add5',NULL,'0',0),('36111a5d-c503-438c-aa55-445dbbd1b438','2016-08-08',NULL,1155,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e308ba64-e78e-4228-93d9-24a081bef865',NULL,'0',0),('361d190e-caf5-4307-8e3d-3737f4b3deb1','2016-08-08',NULL,15525,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c7383f85-c820-45e2-a939-ce24c50ad173',NULL,'0',0),('36424fb2-235b-4de0-90d0-95ec82ddc626','2016-08-08',NULL,45224,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'d29a5c7d-225f-4b41-b036-88e2315ee949',NULL,'0',0),('365afe29-539f-4e2c-b1cf-e574e4066aa2','2016-08-08',NULL,4450,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'218005c1-4b36-4d3b-8b5b-5d4c6eb88186',NULL,'0',0),('366c9212-ba91-4b7b-9bbb-2bd300613dcf','2016-08-08',NULL,218975,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'bc857948-b661-4946-90dc-cb01ad88aaac',NULL,'0',0),('369b9c0c-69c4-43e2-8104-407ba7449a0f','2016-08-08',NULL,4147,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'d9a62fb7-6ef1-4dd9-893a-0d1fb92ec830',NULL,'0',0),('36ddaf2c-fabf-4bb3-a336-41c1937d3bb5','2016-08-08',NULL,9108,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e4a44977-647c-44fd-b0d2-e6a3a566288b',NULL,'0',0),('36df172b-e8e2-486e-97a7-a3f7620ef3cb','2016-08-08',NULL,17495,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'63c4e0ef-6ebc-464d-adf9-1d5dce38473b',NULL,'0',0),('37240803-e8c1-4358-917d-594544e5e30f','2016-08-08',NULL,3727,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'327685f6-7192-4d97-9e74-a3d82d88482f',NULL,'0',0),('3796216e-bc47-4c92-bd7c-0cfb7928c955','2016-08-08',NULL,594,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'17d09027-7f78-4b74-aa2d-4f19102f3abc',NULL,'0',0),('37d0f6e7-894f-4153-8ed7-d945a9262503','2016-08-08',NULL,6597,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'89fad77b-ec05-4e93-98b7-2fbe43971f7f',NULL,'0',0),('37f08aa5-ab25-4d05-9ac8-a02aeade51a0','2016-08-08',NULL,5280,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'79f1c6f1-c0c3-4a62-b7af-12c2618a554e',NULL,'0',0),('3812bacc-b60e-4c1b-89a7-1cadbae5cbb8','2016-08-08',NULL,19440,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'b3437189-8abe-4895-b6e3-f09f4a0fca5f',NULL,'0',0),('390af419-f40c-4a59-96ed-e362d123661f','2016-08-08',NULL,273719,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'bc857948-b661-4946-90dc-cb01ad88aaac',NULL,'0',0),('391544be-e91d-40ee-b8ce-498a03a8d78d','2016-08-08',NULL,325,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'b77080a1-4dbd-4923-a5b5-bcdf7795740d',NULL,'0',0),('3926154f-ad94-469b-b2f3-cf793421c6af','2016-08-08',NULL,16818,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'b13ca82b-fbc6-436c-8645-802d56ff7f96',NULL,'0',0),('3933ef8a-6d85-4ff4-857d-ae97694bceb9','2016-08-08',NULL,10309,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'4fccf62e-f6c6-46d9-948b-ff2c1f769fff',NULL,'0',0),('39b4bffe-d137-43cb-a236-ee57acbd8b48','2016-08-08',NULL,9719,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'3d78e24e-457a-4e4e-be79-a8ea7be2f184',NULL,'0',0),('39d4565f-bdb2-455b-a426-6a701fa14f2a','2016-08-08',NULL,3416,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'eeb87659-05a0-48ec-8e63-9a13d4e24302',NULL,'0',0),('39f2112a-f3fa-42b6-ad90-5747989c4692','2016-08-08',NULL,696,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'b97239fd-c18c-4ea7-a8f4-27ca274aac66',NULL,'0',0),('3a032e09-83ad-4f28-9f49-ac508a21424a','2016-08-08',NULL,1940,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'7b1dcac2-0048-49b3-9f6d-88b48268c161',NULL,'0',0),('3a0550f1-1b4c-4059-bedb-9a9be760b7c7','2016-08-08',NULL,5900,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'ff0b0889-7927-4b8a-a0a8-39bfc31e2bbd',NULL,'0',0),('3a10dc03-d0e5-4d58-bb00-acac8e5c38fa','2016-08-08',NULL,38254,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e2cf3f60-28f2-452a-b3f4-19b7dbb4caec',NULL,'0',0),('3a3e321d-a475-4edd-b173-018ed1c3338a','2016-08-08',NULL,82801,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'d4a2c9ff-e6a9-4261-b6a8-9201a96e70ef',NULL,'0',0),('3a4133bc-aeb4-483a-972a-8c9ff9456000','2016-08-08',NULL,22032,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e80cb4ac-b07e-4600-bae7-a64c2a2f23c1',NULL,'0',0),('3a41c511-7ded-4d38-b53b-6c9ab2caa709','2016-08-08',NULL,1035,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'d37f5f6d-53be-40ee-85c6-4edb83ce65c7',NULL,'0',0),('3a5ecd21-c78b-421d-b88a-5e0fb467e69b','2016-08-08',NULL,12312,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'7490d418-9e65-4162-b095-3706d98cec65',NULL,'0',0),('3a9297f9-65e3-4c21-bfee-2284ed4f3b17','2016-08-08',NULL,7452,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'479eaf77-b6ff-4506-9add-222234d4bf8b',NULL,'0',0),('3abe687f-d049-4bba-a773-e58eb3c0d98a','2016-08-08',NULL,10247,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'7fcef193-3548-48fc-aeb2-9ef94dacb13f',NULL,'0',0),('3b108885-704c-4ace-b09c-8aa4b91faef8','2016-08-08',NULL,128547,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'b58a6f2c-6b73-414d-a5b8-f2aca010713c',NULL,'0',0),('3b269548-55fc-4ead-856c-f22644d29371','2016-08-08',NULL,195,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'2d567563-1311-4d61-b599-4262498abbcf',NULL,'0',0),('3b329b2e-58fc-42de-888d-bfce75e0216f','2016-08-08',NULL,518,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'3df8f1c8-101e-4352-8593-030d958186d4',NULL,'0',0),('3b5aaf47-81cc-4a5f-9d65-ade9d9f5ee59','2016-08-08',NULL,2608,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c1a2f65d-8640-4296-a54b-aaa1e3d635d0',NULL,'0',0),('3b765b34-0dbe-4fd5-8da0-1e1d95ec1652','2016-08-08',NULL,3637,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'58e969cf-bf1c-4aeb-9029-04baeef1b071',NULL,'0',0),('3b7c50eb-6386-4269-a87a-4ee43077041f','2016-08-08',NULL,627,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'8f2016f0-d21e-4d6f-a661-360fd72135c1',NULL,'0',0),('3b867be8-948f-4b07-bc38-2bf7aad331d2','2016-08-08',NULL,2739,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'ca67dff0-fdf8-416f-a4eb-ea18fc42d407',NULL,'0',0),('3bbd682d-f64f-424b-b095-74820c19214b','2016-08-08',NULL,71280,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'565834a0-66bc-4d40-84ed-e3c96d4fc77f',NULL,'0',0),('3bee2677-16e1-49aa-b398-94c93d222629','2016-08-08',NULL,26082,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'4c661b0f-2e20-4d75-9dd6-c2b2a075f136',NULL,'0',0),('3bf55c75-a00a-40b3-92d3-3e0a5b589375','2016-08-08',NULL,1035,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'16861364-78e1-4079-8250-3653ad9e75ca',NULL,'0',0),('3c5f5429-8cc9-4ee9-8c5b-1c912630c49f','2016-08-08',NULL,1209,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'591dd6bb-f2f6-4b00-828f-5f7a869f361d',NULL,'0',0),('3c628774-9c34-4644-ada0-35a9d04555c6','2016-08-08',NULL,197850,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'561e3e8a-72c4-4cc0-9a4e-55af1ee4d97a',NULL,'0',0),('3c8a3f72-5aa8-4028-a5d3-25d3a0f456e1','2016-08-08',NULL,4010,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'10b7b0fa-494c-49b3-bd65-bdef8ad7d293',NULL,'0',0),('3cc6f233-d87a-4441-a436-d75b7b2465f7','2016-08-08',NULL,16818,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'3dea9f95-b976-4f2f-b22e-aaaf3a890eec',NULL,'0',0),('3d1fa340-c2cc-4a73-99b8-79fb016888ce','2016-08-08',NULL,13145,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'294e21e2-5410-4522-b947-588746f1293d',NULL,'0',0),('3da2352c-cd21-434e-89c8-c4f3e29de91f','2016-08-08',NULL,78966,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'27730e12-6012-4ac1-8c7c-17669fdf9916',NULL,'0',0),('3daa17cb-1906-4a31-ac16-c4698c63526b','2016-08-08',NULL,2608,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'8d590898-6df7-4a2b-98f6-7335961781ca',NULL,'0',0),('3df2a6e8-2ed4-400d-bfa4-da2aec723c5a','2016-08-08',NULL,82257,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'27730e12-6012-4ac1-8c7c-17669fdf9916',NULL,'0',0),('3df96a9e-91f4-409a-9b41-360b42e6c3b7','2016-08-08',NULL,5714,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'3e5946fb-f320-4e59-b4ac-017980a6a74a',NULL,'0',0),('3e0acb2e-f805-4c6f-8001-0986d0b12cb0','2016-08-08',NULL,2591,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'5062d5a6-46a9-40b3-8b47-d8967781b60a',NULL,'0',0),('3e1fb416-527d-4530-8b7d-13f88a11b89b','2016-08-08',NULL,12579,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'ef269800-460b-4827-9444-2f295a5cdf6d',NULL,'0',0),('3e250d07-3af0-4456-bfa5-7a537ea04cd4','2016-08-08',NULL,2025,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'88279a62-e47f-402f-8a4f-009765ad102c',NULL,'0',0),('3e2935b5-7c1a-464f-9c9f-bd0daa029dc2','2016-08-08',NULL,15525,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'2a55be02-7190-41d1-8726-90bccec8c4b1',NULL,'0',0),('3eb47839-0e2b-4dc2-842d-ad138d0b8809','2016-08-08',NULL,4140,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'68bc940c-4a69-4656-a72b-7eba9efc6987',NULL,'0',0),('3f2d74a6-5d36-49c6-8b6c-cea843fbb851','2016-08-08',NULL,85388,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'b8cf6bda-59f3-4a48-b9de-f5d8712fde54',NULL,'0',0),('3f43898a-e088-48b5-bcf3-8aa6c809cfe0','2016-08-08',NULL,19127,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'24c994b8-0141-4be3-a317-5d7260b90367',NULL,'0',0),('3f63b7e7-4e4a-4ff4-9865-ab29d1d84a0b','2016-08-08',NULL,13724,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'8b60e990-a11a-45bf-b90c-83ccda6aac8e',NULL,'0',0),('3f77738c-32b9-444b-9222-6b8704c95195','2016-08-08',NULL,1162,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'bcadd324-0f18-44f9-9fc3-efae346a55c6',NULL,'0',0),('3fb3826a-47ba-42cb-8d5f-dfe863bde2f3','2016-08-08',NULL,2173,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'33001ff1-5e76-4d77-9454-f720b61534b9',NULL,'0',0),('3ffb1750-4548-4f08-9f79-85deaa9ce1d1','2016-08-08',NULL,7576,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'b27e43c2-9acb-4168-9f5d-4c4c0babcf5a',NULL,'0',0),('400ebfbb-6e34-4576-a702-2d31974f29de','2016-08-08',NULL,49500,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'78400bc3-34aa-4448-a70b-50a85ad93785',NULL,'0',0),('401ccb9d-c572-4393-b7a3-5e7bb5a029ce','2016-08-08',NULL,43470,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'1aad43d9-279b-4527-8581-5c86a5885008',NULL,'0',0),('40388c57-d572-453d-9791-46f260ec8c77','2016-08-08',NULL,18901,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'44be9244-8a08-401b-967d-785cc71d6a3a',NULL,'0',0),('40512f24-1da6-4d2b-b207-e1fc5f6b4735','2016-08-08',NULL,10247,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'be82505d-7012-4894-9797-5de0cbd3c1b8',NULL,'0',0),('4058c3ce-135f-4530-a75e-cf5ebebea196','2016-08-08',NULL,9833,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'a39c3b64-9c5d-4824-b80a-f5cf58c5297b',NULL,'0',0),('4091d0d8-7d8a-41f7-b617-baa76e916a90','2016-08-08',NULL,4244,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'642632bb-2fdb-44e0-be92-e24ae6af802c',NULL,'0',0),('40b6a577-89b0-4de1-b9bc-1e5d548e785e','2016-08-08',NULL,43164,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'53f9ec0d-c5a3-46f0-b51b-3a1f0fad63f8',NULL,'0',0),('40c1a2fe-523e-4f9e-a14f-2833bd89ac02','2016-08-08',NULL,248,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'58251241-af23-4db9-8898-c5c598d15c9e',NULL,'0',0),('40fd1d8b-99c4-4729-9c59-5b08a4ccfa32','2016-08-08',NULL,696,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'752be6c7-a8e5-4f8b-a309-2f79926c6f47',NULL,'0',0),('4113f3fa-c12b-4b50-b986-53386b0e1140','2016-08-08',NULL,18058,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e75543d4-2e88-46ea-9c86-6f81cae97787',NULL,'0',0),('4123e262-49f1-4831-be10-5360ed8552ba','2016-08-08',NULL,271,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'b77080a1-4dbd-4923-a5b5-bcdf7795740d',NULL,'0',0),('41425173-7c64-456c-92ee-6f6b92b66eea','2016-08-08',NULL,9450,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'a0eacb3f-5b0e-4833-b9b5-56ed95c0a9f9',NULL,'0',0),('415b3dd4-4959-434b-933e-b0deff70e480','2016-08-08',NULL,9522,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'1c4909bc-5c44-4efb-aaa7-3d0eb384c349',NULL,'0',0),('417595e4-afd9-425f-9b4c-cce983124ecb','2016-08-08',NULL,756,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'78beadff-493c-4956-a1f1-dc7745b357a7',NULL,'0',0),('417d17d2-db3a-4f1e-8de5-779935a76382','2016-08-08',NULL,297,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'401f52f9-0183-4466-857b-aa5e512fa4b1',NULL,'0',0),('41bbacb1-b3d9-4ae8-8b5c-e7a5bf2225fb','2016-08-08',NULL,135,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'bb27bc70-e246-4a79-962a-52775600eb4a',NULL,'0',0),('41e282a7-cbe6-4560-b972-d7b3b9e0091e','2016-08-08',NULL,14748,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'0b74682d-2c3c-471b-81f7-0d3c1cdfc550',NULL,'0',0),('42027546-1a40-4356-b0ce-dade658e36bc','2016-08-08',NULL,12322,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'b797a848-7080-4827-b406-1924ac7bcecf',NULL,'0',0),('42207fef-3cf2-4c05-8e38-ea7190593941','2016-08-08',NULL,13656,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'17170adc-b545-44df-98f3-987692f559b4',NULL,'0',0),('4230a390-fc58-47f6-91d7-df2c20e01f57','2016-08-08',NULL,20369,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'ab8cc7d9-09f9-4d10-b6b2-fe0d97a82111',NULL,'0',0),('423e6e35-582f-4d48-b36e-8d97ed279262','2016-08-08',NULL,4240,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'9d42b826-2089-429f-9f97-e686e146bf08',NULL,'0',0),('427f4321-0e64-4bb3-86d8-7f5a77c8450e','2016-08-08',NULL,10501,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'6ef114dd-7073-45bb-8b29-c3d8aae1c636',NULL,'0',0),('42b73a80-3e36-49d6-9bc0-a8d28cee84cc','2016-08-08',NULL,19355,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'88c9f4f3-663d-48cc-885a-3c3a40389307',NULL,'0',0),('42c53ae5-c4c0-42e3-9b87-c64693cade91','2016-08-08',NULL,7375,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'b268586d-4579-4679-b24c-8ba634cac4dd',NULL,'0',0),('434b5e5e-c5ae-449d-a97d-367497ed87aa','2016-08-08',NULL,3106,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'08a80cf4-0ef9-48d1-a79c-edd714b170c0',NULL,'0',0),('4357667c-f25e-48e7-9f3c-82a0018e934e','2016-08-08',NULL,4761,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'3e5946fb-f320-4e59-b4ac-017980a6a74a',NULL,'0',0),('4373753d-78e7-48f7-a393-b6e52180526b','2016-08-08',NULL,855,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'ec6fa4a1-8d0c-4b8d-b6cb-12fb11f43d7b',NULL,'0',0),('437982f9-c2e0-420e-8a64-3b77cf2a2a05','2016-08-08',NULL,10092,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'90b93b2a-34f8-43f5-957f-cb47a4551120',NULL,'0',0),('43d35c6d-5af5-41d2-b81f-1cd389661f51','2016-08-08',NULL,472,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'6f029a46-7aff-4d7d-be04-13e5b1f17e8f',NULL,'0',0),('43d5be58-5ae7-46b1-81be-96b4fc589796','2016-08-08',NULL,30360,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'7fd16ed2-3b51-4d09-b5ed-4bad37a4f0f4',NULL,'0',0),('43e8d95f-3c12-4eee-a86c-0cdd4ddedd94','2016-08-08',NULL,6831,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'a5e168c0-d73f-4caf-860a-e5cc4cc47ffb',NULL,'0',0),('4400ea2c-1083-49ef-aa13-3f40e0249231','2016-08-08',NULL,58949,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'f9383cdd-aaf2-472d-ad75-0496e33b5d64',NULL,'0',0),('44040049-0c13-49b6-aca5-1f25c947d87e','2016-08-08',NULL,5563,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'579e5f38-ef72-448c-865f-8e80b04e25df',NULL,'0',0),('44049f0f-3dff-4cdf-84bb-3908c4a76685','2016-08-08',NULL,13196,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'edace783-6b08-4a15-9194-6cb363bc0f79',NULL,'0',0),('44072753-2142-4e37-ab3a-b0a56ef7a66e','2016-08-08',NULL,810,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'986f7ca9-4ac0-4350-9b3f-a8d37aaead04',NULL,'0',0),('4453176f-3d18-4020-8e12-462dbff21d91','2016-08-08',NULL,7762,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'91fb4e05-b678-42fa-bb16-8022e2e24e22',NULL,'0',0),('44538029-b304-4523-9a0b-1ad866085029','2016-08-08',NULL,1035,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'92c66aae-c96a-418e-984c-b4f6f45055b3',NULL,'0',0),('445d0413-b3e2-4725-8e9c-cfa45bab83e5','2016-08-08',NULL,6210,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'74a69361-60e9-4af8-8765-eac724021451',NULL,'0',0),('44a3bdce-8d3c-48ea-8d79-2f68565b3638','2016-08-08',NULL,675,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'05830da2-288e-4908-b338-4871b114a416',NULL,'0',0),('44ac938f-3363-434e-8405-e1beef11239f','2016-08-08',NULL,6075,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e40889c8-9ad8-4ccf-b2be-b2deb2ca6964',NULL,'0',0),('44b7f696-e3a1-4fe5-a41e-7970c989bf67','2016-08-08',NULL,82350,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'56c34599-fb09-49f1-b19a-09dbe50f41fe',NULL,'0',0),('44c42ad5-8a0d-4efa-8a4f-5381b8b0fd74','2016-08-08',NULL,2070,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c7874cc2-e364-48cc-b9b0-e1936d6dd360',NULL,'0',0),('44cca710-baa1-4850-8157-e1eb30a6f84f','2016-08-08',NULL,27887,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'59216eee-bf00-4692-950c-2cf34e629738',NULL,'0',0),('44cdfe4b-9c29-40b0-8b60-8937160075d4','2016-08-08',NULL,12110,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'39ec1054-d8a8-4e7e-84fc-984740b0f8f2',NULL,'0',0),('44d52d37-9e98-432f-9680-403d8dd39336','2016-08-08',NULL,2329,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c7848e87-3983-4bf0-80dc-52e066e312ac',NULL,'0',0),('4509da90-39da-4cf6-8d1d-3d13778a3f95','2016-08-08',NULL,32442,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'cc980e92-7d48-44d2-af07-2c9f66675e5a',NULL,'0',0),('4519a049-a809-43b6-9f95-3655e7ec8a1f','2016-08-08',NULL,396,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'43659546-bd7c-4146-b6eb-27f8be761a4d',NULL,'0',0),('4536b882-d824-400a-8265-07e84aec69f6','2016-08-08',NULL,5175,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'74a69361-60e9-4af8-8765-eac724021451',NULL,'0',0),('45550040-0ca1-464a-b081-f01a8bb8b250','2016-08-08',NULL,10092,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'1a963c74-95d3-4735-ac0c-55358c5a078c',NULL,'0',0),('4566b5ac-d5c0-43a6-a664-3d884aa09b18','2016-08-08',NULL,2112,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'f96599c9-4abc-494d-b9e1-5a95e9d04e73',NULL,'0',0),('4568ab6a-70e0-42d5-b96f-286ef7c0817c','2016-08-08',NULL,1663,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'06e325af-29b7-44d2-a87c-5bbe68355d45',NULL,'0',0),('457eb0ba-9404-4354-a44a-c5102b86e747','2016-08-08',NULL,7560,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'a0eacb3f-5b0e-4833-b9b5-56ed95c0a9f9',NULL,'0',0),('4580f9dd-9eea-401e-ad5f-f44b869ec63a','2016-08-08',NULL,559,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'dcc86b92-d8d3-47bd-90a7-56deb8051b95',NULL,'0',0),('458e0e5e-9e13-4a75-b22c-12b90959672e','2016-08-08',NULL,7970,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'41bd6355-9d61-47b9-bb0b-ceda1aae21fc',NULL,'0',0),('45a03d5b-2d77-45a5-9512-c4990cfe9940','2016-08-08',NULL,14256,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'86e73666-b52c-4b2f-95cd-dca03265be97',NULL,'0',0),('45a8ef5c-8201-4600-a28b-3e52276a3eca','2016-08-08',NULL,12420,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'eb392a11-14b8-4e54-a103-6ca7b5fcfa1c',NULL,'0',0),('45b6cacf-264c-4c1c-8745-f0e5e069970d','2016-08-08',NULL,358,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'412a5592-b458-4ca6-9e93-ebc6459ad9f7',NULL,'0',0),('45d433aa-5f7c-4600-bae8-c4a03d312433','2016-08-08',NULL,1242,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'92c66aae-c96a-418e-984c-b4f6f45055b3',NULL,'0',0),('45d5ec6a-9ef5-4254-96d2-0986de07ef83','2016-08-08',NULL,9832,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'cb080cf5-be76-4956-bca0-d1da336c171b',NULL,'0',0),('462af87d-30cc-42d9-a540-f956415498dd','2016-08-08',NULL,529,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'2fd63757-2ddc-4466-b04f-a3ca142b8591',NULL,'0',0),('463f7563-6be9-40cf-a932-295fa7664695','2016-08-08',NULL,4125,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'05f7ca85-abef-44b7-856b-bd65718f0eae',NULL,'0',0),('46708e44-ff1b-4451-b641-dd333144992f','2016-08-08',NULL,5693,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'d56f271f-0d1f-47d9-a879-5d7dbddbf64c',NULL,'0',0),('469c57a9-6100-4d5e-b460-0ce14423cd6a','2016-08-08',NULL,18480,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'2816962b-cceb-4941-b477-977ba800e72d',NULL,'0',0),('46c373fc-7130-44c0-953d-96df6f406360','2016-08-08',NULL,5175,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'ac5376fc-baaa-42b0-98ff-e1ecd592912d',NULL,'0',0),('46cf4980-9209-440b-a5cb-226a8c5fb497','2016-08-08',NULL,51750,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'7da6917f-afda-45c7-a879-2eed000bfc5b',NULL,'0',0),('46e609eb-b44b-4300-a268-653795ea9ad1','2016-08-08',NULL,490,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'d9fa83ac-a786-4d41-b318-18c3a8acb8ff',NULL,'0',0),('46ebce9b-232d-4e63-bdd5-8e8989c29f4e','2016-08-08',NULL,1139,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'71c2099c-5089-4be3-b714-5f53900cb009',NULL,'0',0),('4704f241-98b2-4a74-9c5f-d3a29693b75c','2016-08-08',NULL,10998,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'aaea9111-5d11-460e-b898-c56762aa4455',NULL,'0',0),('47066a7a-8a31-489a-8568-3f1f52f9e498','2016-08-08',NULL,13109,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'17170adc-b545-44df-98f3-987692f559b4',NULL,'0',0),('474c5fe3-e672-4b30-b3b7-83f83f22de09','2016-08-08',NULL,19127,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'6885ead4-766d-4d90-95b6-62b83e0d62f6',NULL,'0',0),('47596e81-89c4-46e0-b09f-2103b63fcd41','2016-08-08',NULL,9719,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'3252a452-2840-427c-9a77-2107111ff6af',NULL,'0',0),('4760ec49-bf64-47c6-944f-0971a2dd4919','2016-08-08',NULL,1080,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'0c22a71d-831d-4f91-9006-aac28244e489',NULL,'0',0),('479ea5d0-5efa-408e-b39b-83ebc404bfff','2016-08-08',NULL,683,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'9b30e01a-1f13-4cb2-a30b-3545cf7e8fbc',NULL,'0',0),('47b897a3-ef14-4f45-8069-f436efdb2a6d','2016-08-08',NULL,14748,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'3cc43db8-3894-4bc1-9c71-a199f253e1c5',NULL,'0',0),('47c08504-797b-421d-ae95-a5d8f9db0f17','2016-08-08',NULL,2268,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'44315dc2-e2fa-44dd-8de8-8330ed4de153',NULL,'0',0),('47c86ad4-7df4-457c-a3a0-c7d5c7de9cde','2016-08-08',NULL,432,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'715941ea-e398-49a7-b9e2-53d8a5f0baf1',NULL,'0',0),('47ff41db-d3b2-467d-bb01-ab09c8a9849c','2016-08-08',NULL,2773,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'b23d48e6-88f6-4415-a774-824d604613e7',NULL,'0',0),('482a90ce-9cb6-4e55-8ded-c2c4834919d2','2016-08-08',NULL,2391,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'a2f0a0e0-671f-4653-b4b6-5f2e80c97ad4',NULL,'0',0),('484dbeb8-2436-46db-ad5e-8a408a6f8718','2016-08-08',NULL,20369,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'746ec058-c48a-4a7d-a2db-907773279793',NULL,'0',0),('4896766d-2d0e-49fb-8675-d575bfa7342c','2016-08-08',NULL,470,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'ecb0ba82-2039-4da4-ab4f-b1b25d90e745',NULL,'0',0),('48b2a182-9f6f-4012-a355-11d703345c38','2016-08-08',NULL,36872,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'9bdd597f-80b5-4660-8436-1c06fcf1a281',NULL,'0',0),('48c037b2-c71f-4c44-8351-5b8b35d8bbf2','2016-08-08',NULL,1035,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'4462502a-223f-4d8a-9814-1ec1a96574c4',NULL,'0',0),('48dc3334-400d-43e4-8a8d-6a2b9197ee6b','2016-08-08',NULL,271,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'8a484956-eb83-4a2e-8591-c66825edb086',NULL,'0',0),('48de37c0-ae78-4e14-be50-75f8ed0f3e93','2016-08-08',NULL,130,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'44b4fbde-329c-4d62-aebf-e51e7317bf76',NULL,'0',0),('48e4e3fc-2fed-40d3-a86c-0a9b9fd2e702','2016-08-08',NULL,784,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'0a9a2f8d-36a7-45ea-9e2a-67b9fa59da98',NULL,'0',0),('48eec439-6484-4fce-8b19-8e6b060335d9','2016-08-08',NULL,154085,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c7e1658e-5de0-4f84-9b17-5d4aae07c76e',NULL,'0',0),('4947ff90-f00a-45c3-bc08-ecc9aca08965','2016-08-08',NULL,9935,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'1177854c-af94-4c6b-b3ef-8545dc0c2a7c',NULL,'0',0),('4950d8c3-4b4e-4261-8861-eb977ba3807c','2016-08-08',NULL,16891,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'d1a4f5b8-dda2-4e1b-8d88-f8f5e76c3b7e',NULL,'0',0),('495df579-204a-41b9-aefa-b1d5193e3305','2016-08-08',NULL,7762,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'1706fcfd-6788-4c63-a45b-bddb2c7da5a0',NULL,'0',0),('496cfc24-84f6-45ca-8572-d6dfeb1beaad','2016-08-08',NULL,18975,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'33deee8e-779e-4354-9abc-c821cfd629dd',NULL,'0',0),('49790d46-870d-4011-a67b-e9c2b871f435','2016-08-08',NULL,28083,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'f5c029dc-c40e-4c0e-9d89-d00473706b36',NULL,'0',0),('49815a36-1984-4189-a8e8-d05f332992d0','2016-08-08',NULL,17885,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'d0449520-ae74-4735-a545-e21a949f1031',NULL,'0',0),('49d8a0f4-c9ce-4239-8f07-6bdb462f0fae','2016-08-08',NULL,7892,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'b27e43c2-9acb-4168-9f5d-4c4c0babcf5a',NULL,'0',0),('49e0e9bb-cae7-4e1b-96ee-931728e14487','2016-08-08',NULL,81000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'7402a1f5-7001-4009-a5c4-29b9e09f7a56',NULL,'0',0),('49fd2304-32fc-479f-92e9-f30f7fe68582','2016-08-08',NULL,14579,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e2b230a9-e241-486c-838a-edb2493bdd5c',NULL,'0',0),('4a0d3976-6524-4a40-8a19-54ded7706307','2016-08-08',NULL,29095,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'d60f5ae5-e8bf-42ca-b6e9-d6c8d818b875',NULL,'0',0),('4a16a7ce-bbfa-407a-b246-fe3c2fcdaaeb','2016-08-08',NULL,2699,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c5404306-9de8-4113-9ff4-ff5856f00da7',NULL,'0',0),('4a247819-a0ba-4033-b887-19e4df7a76bd','2016-08-08',NULL,19886,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c792c260-f339-4bc5-8647-ebee072b58d5',NULL,'0',0),('4ac18d54-866b-4331-8c0b-147147382fbc','2016-08-08',NULL,6727,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'f74b8998-8283-4843-a7d2-8e4ed5978497',NULL,'0',0),('4acb220a-4933-4bdb-ab46-55679b1a5e92','2016-08-08',NULL,32401,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'7e21826c-82b4-4d84-82a7-b2b77078a96c',NULL,'0',0),('4adcbca3-5684-413f-857e-46dedab42ad8','2016-08-08',NULL,6210,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'8c62ba4e-7a19-4733-a76e-c028a81c7a6e',NULL,'0',0),('4ae2f961-50b5-4882-aa17-b97eac059938','2016-08-08',NULL,35578,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'81bd16af-abfd-4a2a-b92b-15bc2240459c',NULL,'0',0),('4b0795d7-a474-4199-bc8b-3a05c426723b','2016-08-08',NULL,17854,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'b2b57a64-575c-4f01-8e49-6d75a13b0b6c',NULL,'0',0),('4b204cf1-f17e-4b59-96d8-1e8638d20d3f','2016-08-08',NULL,1901,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'6d159603-dad6-4913-b824-7adf31304971',NULL,'0',0),('4b39d88a-5cef-49ae-b753-edffc2a02721','2016-08-08',NULL,13599,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'744997b4-9d98-44f3-8eff-6ed0583b6be1',NULL,'0',0),('4b80d76e-61bb-4f3b-ad5f-aac4088e710e','2016-08-08',NULL,13455,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'3dea9f95-b976-4f2f-b22e-aaaf3a890eec',NULL,'0',0),('4b985083-b4fa-47f4-a2bd-dbbf90f9b00c','2016-08-08',NULL,16818,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'681f1db6-6a6c-41d4-8e48-df52a4d07135',NULL,'0',0),('4ba9a630-a87a-4290-9011-c31c29fdfe3b','2016-08-08',NULL,3369,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'9b1fd8eb-8c89-457d-ac6a-93c39ab1b8fd',NULL,'0',0),('4baad3cc-227a-490d-8e3e-45ea027d302c','2016-08-08',NULL,33751,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'8fb05868-bcb3-4cbb-ace3-a7927e243a7b',NULL,'0',0),('4bab6db3-43de-40ec-a901-8a2b5595947a','2016-08-08',NULL,19407,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'2a55be02-7190-41d1-8726-90bccec8c4b1',NULL,'0',0),('4bb158cf-eaf6-4b8b-9325-f81d62d1de73','2016-08-08',NULL,29728,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'d0e980e2-8899-4acd-9c83-5e0e6db0a7ca',NULL,'0',0),('4bc25803-3ad0-4d90-acd7-5ec4e8fbfc61','2016-08-08',NULL,5406,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'280f4a60-3587-4a87-b219-c75d42cc6534',NULL,'0',0),('4bc4c48a-c2eb-4fb9-b995-e09bfd90adbb','2016-08-08',NULL,23059,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'ee715dd7-b854-4c08-ba5a-17e0b4ac8add',NULL,'0',0),('4bda32a8-c3fb-46e8-a0d4-7a5d2e168fb2','2016-08-08',NULL,33997,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'751d2111-d008-4523-b8a2-153b5d85c7a1',NULL,'0',0),('4c009094-9ec4-4858-9603-0d6369d66b8a','2016-08-08',NULL,325,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'87c22b7c-7853-4de3-9c4a-8fa1d955ce8d',NULL,'0',0),('4c182e85-a70d-4d40-bac1-0802821481da','2016-08-08',NULL,1944,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'88279a62-e47f-402f-8a4f-009765ad102c',NULL,'0',0),('4c1c91a6-4390-4409-852a-971958fffe84','2016-08-08',NULL,22770,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'3e9aef4d-7b15-4cab-9e07-84245b9a7090',NULL,'0',0),('4c26e475-7ef4-4de8-ab00-61bd6754337b','2016-08-08',NULL,8539,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'be82505d-7012-4894-9797-5de0cbd3c1b8',NULL,'0',0),('4c28507a-5636-4b7f-a46b-0e50e05d9768','2016-08-08',NULL,20570,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'7d2e8892-f80e-45f9-9a73-56d590bc0e87',NULL,'0',0),('4c748f86-af94-47ad-b493-bb9203c6c69a','2016-08-08',NULL,1423,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'71c2099c-5089-4be3-b714-5f53900cb009',NULL,'0',0),('4c93b079-41f0-47f2-b0f4-d6c9dda250c7','2016-08-08',NULL,14850,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'86e73666-b52c-4b2f-95cd-dca03265be97',NULL,'0',0),('4c97ca8a-829c-470c-930c-d8647eff0ade','2016-08-08',NULL,19997,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'1cbdf52a-e1bc-4242-b846-d9b8f5e323c3',NULL,'0',0),('4ccb0b9b-b1a8-4ba8-b036-e98189a6aefe','2016-08-08',NULL,12835,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'b797a848-7080-4827-b406-1924ac7bcecf',NULL,'0',0),('4cf1e5a8-3475-4c22-98df-405725083c1f','2016-08-08',NULL,9315,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'45244017-1aa1-4e0a-9540-5006fef47712',NULL,'0',0),('4cfccff3-f144-47a3-8e21-6b18789b2114','2016-08-08',NULL,7073,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'7e96a11f-735a-4afe-84d3-a229d863b834',NULL,'0',0),('4dbdfccc-8110-4f2f-87ac-386d5b67d6ad','2016-08-08',NULL,5952,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'3e5946fb-f320-4e59-b4ac-017980a6a74a',NULL,'0',0),('4e072661-2fc7-4fa2-b7d0-d06c8e6a104b','2016-08-08',NULL,73686,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'f9383cdd-aaf2-472d-ad75-0496e33b5d64',NULL,'0',0),('4e126157-edaa-4277-90b3-9b5aacc354e5','2016-08-08',NULL,810,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c267f236-325c-41f6-8a46-56763ecd4b12',NULL,'0',0),('4e159abb-efc0-4749-ab4d-763a1af95f9d','2016-08-08',NULL,396,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'93bcac5f-f791-47d7-8bd7-c4973506029d',NULL,'0',0),('4e30bc8f-8888-4837-97aa-2ee3828c9e16','2016-08-08',NULL,14579,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'254b8e87-0d5b-4fef-aaef-dcbd01f580a7',NULL,'0',0),('4e338cdf-0edf-42b0-9af7-b54f99803778','2016-08-08',NULL,501,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'6c3b04c3-0627-4e1e-8bc5-4d19a2adabe8',NULL,'0',0),('4e4bf785-6556-4690-b224-6a31733c195b','2016-08-08',NULL,49680,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'2223495a-8eef-4757-b33c-27fb7646d4f5',NULL,'0',0),('4e82fcaa-a643-400c-85ff-efd6e39a345a','2016-08-08',NULL,22308,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'5e0061bd-4ce4-4bfd-9568-d82450b30e36',NULL,'0',0),('4e9abbfc-49e3-42d5-9d4c-58bd4d9f77f3','2016-08-08',NULL,28459,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'5463545e-fff0-4208-aec6-0d308efacdc1',NULL,'0',0),('4ec168b0-d173-4870-b419-c8e860cea558','2016-08-08',NULL,108,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c5ac1eb3-cb9b-4134-91db-a271a8e1b43e',NULL,'0',0),('4ef5764a-0e24-4828-8a7b-b21e7451d67d','2016-08-08',NULL,3416,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'6ede563d-0aa2-4bdd-ab9d-199fb73117dd',NULL,'0',0),('4f427548-430e-4318-9754-01f002074499','2016-08-08',NULL,11426,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'1c4909bc-5c44-4efb-aaa7-3d0eb384c349',NULL,'0',0),('4f47ce84-0a0f-4e05-bece-198f88cb9f12','2016-08-08',NULL,9288,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'b7356652-f9bf-4916-8040-ed670178da93',NULL,'0',0),('4f4a19df-212b-450b-9074-eae4c4f245eb','2016-08-08',NULL,19440,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'d997ed5d-8d3f-4951-8241-9627da3a6683',NULL,'0',0),('4f4b2e5d-1b32-4ee2-811e-34c5ceeeb723','2016-08-08',NULL,2075,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'f886c2b4-d114-4212-9569-b3f9ea49e1a1',NULL,'0',0),('4f563ace-b8c8-4f25-85e1-3f69a228fdf8','2016-08-08',NULL,7972,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'de4c925c-658e-4d9b-aa04-761b50a2b364',NULL,'0',0),('4f5fa2e7-96d0-4265-88f8-3e1f28fa514b','2016-08-08',NULL,18224,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'90c07d25-db37-4060-ba5a-6e5af7dfdf4f',NULL,'0',0),('4fd413cb-fd7c-4efa-aea3-094654ecb4e4','2016-08-08',NULL,3491,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'58e969cf-bf1c-4aeb-9029-04baeef1b071',NULL,'0',0),('503494d0-f04c-4d98-beba-87c10ddc1947','2016-08-08',NULL,4158,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e30c8882-bef9-4f25-8321-ac843a963e44',NULL,'0',0),('5047a2e7-f2db-405b-8ffb-17b2c19c8c2c','2016-08-08',NULL,222750,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'bbcc0daf-3f4a-487a-b797-d6b2552c97b1',NULL,'0',0),('507ac32b-e48b-404e-96e9-f9a84ff7c031','2016-08-08',NULL,8409,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e8c6ebc2-4883-4850-b365-b2875c00f158',NULL,'0',0),('508cf785-fdf8-4819-95ca-d286f9833c08','2016-08-08',NULL,28566,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'10fc4ac8-48e5-403c-b89e-45b88e772f96',NULL,'0',0),('510f7a4c-e0f9-4d36-bad0-3f590c08a498','2016-08-08',NULL,21252,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'275f070a-ae3d-4f29-a882-cd6bd9fca7e5',NULL,'0',0),('514fdcc9-bf83-433c-a46e-0ae0993efc3d','2016-08-08',NULL,554,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'d8125419-2e6a-4f03-91a0-ea1675890f32',NULL,'0',0),('5153b9e7-7f85-4cc1-ac52-94622e718d45','2016-08-08',NULL,25921,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e6ca24a3-cd1f-42cb-b39b-f9569ffda976',NULL,'0',0),('51862d32-86c3-4c84-a893-35b5d6dad0b6','2016-08-08',NULL,3727,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'90b36043-8450-49a1-be3f-83b984481551',NULL,'0',0),('51992cbe-86e1-4056-8020-4d301ee3152d','2016-08-08',NULL,130,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'bccdfffa-31da-4bc7-b7ba-6314936cac66',NULL,'0',0),('519e6f94-d40c-4791-9451-399a38933fec','2016-08-08',NULL,26207,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'a42e340c-95ea-4b76-82ea-692dace6f11a',NULL,'0',0),('51ae2a23-c3f7-42f0-982d-ea0aa356b725','2016-08-08',NULL,8304,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'de4c925c-658e-4d9b-aa04-761b50a2b364',NULL,'0',0),('51b44a2f-1cae-480a-a6e3-9e5b1058ec57','2016-08-08',NULL,2160,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'08b45e7e-9a17-4a42-a545-f23327c35785',NULL,'0',0),('5208e40a-799d-4fd3-893c-7c08406aa7b3','2016-08-08',NULL,554,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'28cba0ec-d341-4e33-abaa-878a82bcd5c9',NULL,'0',0),('521292dd-df8e-49b2-9ee1-922bdb820b42','2016-08-08',NULL,2483,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'fcc00617-3270-499f-abf0-3a18d5305c2e',NULL,'0',0),('524bf42f-9260-49cb-ab14-100f78776110','2016-08-08',NULL,28380,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'f75d973c-f0b9-4d48-aa08-134e55c5c37b',NULL,'0',0),('52628529-147b-41f4-8127-ecf7e7d889ad','2016-08-08',NULL,323,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'590bc58c-aa06-4cb8-997d-b7abf367c28b',NULL,'0',0),('526af180-7cbf-4506-a9c5-791e29d5bc97','2016-08-08',NULL,6750,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'6663aebb-4ed2-48bf-8625-7f875052bc7b',NULL,'0',0),('52eaf987-b26d-4f70-9bb9-696a2bc6c576','2016-08-08',NULL,292,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'1aa9ec96-e467-4ddb-8397-5f59685a32ed',NULL,'0',0),('53094a41-c71e-4b9d-ab43-795a165ec16c','2016-08-08',NULL,19766,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'33deee8e-779e-4354-9abc-c821cfd629dd',NULL,'0',0),('530bb060-5501-4986-abb8-f6dfb9247801','2016-08-08',NULL,4719,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'75b4abba-6596-457a-af5e-c2e9d257c28c',NULL,'0',0),('530dee85-57bd-4160-8742-c9479a95aa19','2016-08-08',NULL,15034,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'b8eed9d5-a538-4c6e-ba3a-b4c05666d0af',NULL,'0',0),('5362f6ea-4472-47d5-bd0f-d6657f0b5a03','2016-08-08',NULL,9688,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'7f2f11f5-faf2-4327-96ba-6a444834947a',NULL,'0',0),('53c38cd5-7408-427f-b984-29288a76730b','2016-08-08',NULL,97808,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'05b1a7cd-af33-4b66-97fc-8e799dbb9233',NULL,'0',0),('53daf5aa-3dc0-4ad5-a258-62b218182df9','2016-08-08',NULL,3882,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'327685f6-7192-4d97-9e74-a3d82d88482f',NULL,'0',0),('53f1841a-1452-4cc6-9ad7-550e34613fee','2016-08-08',NULL,37159,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'21d79dee-51b7-4840-9a9f-ff7dc3726f21',NULL,'0',0),('53f3f2ff-a512-4dad-ae26-96c3fd2d71e8','2016-08-08',NULL,3960,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'626b88e8-5e08-437b-b5e9-649a410fac46',NULL,'0',0),('53f4ecb5-24b0-4b91-8993-f6589a73a708','2016-08-08',NULL,3241,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'3c961304-e675-4a2a-bd21-15dbfb7297fb',NULL,'0',0),('542b429d-1a45-4260-9cf5-9412bfa41cd3','2016-08-08',NULL,56451,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'0aeeef06-348c-4b67-8750-5101f00a3f2c',NULL,'0',0),('55019ddf-f98f-456b-94ae-2409b9911bf8','2016-08-08',NULL,1555,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'936f4c03-b603-41a6-b078-dbfe54b06563',NULL,'0',0),('5501ae5b-a271-414e-9134-4b28fe52354c','2016-08-08',NULL,452,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c2ba0874-6005-46c2-ace4-3ab3ab318a79',NULL,'0',0),('5514e75c-558f-4c90-b5c7-6de7732e72f0','2016-08-08',NULL,19748,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'7d2e8892-f80e-45f9-9a73-56d590bc0e87',NULL,'0',0),('553e4d30-fbe0-466f-b585-013d0dc9888c','2016-08-08',NULL,7203,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'981207d1-bb18-42a6-b9cc-665574d22b62',NULL,'0',0),('5558a79a-d0cc-486d-8c00-24d3332207b4','2016-08-08',NULL,810,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'2d35744d-b386-411d-88be-1900f1c93469',NULL,'0',0),('556924b2-64ce-4671-94fc-6349d55ce08e','2016-08-08',NULL,33839,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'78f0d0d4-0f97-41ad-b2ef-59bca9b38470',NULL,'0',0),('556e15dc-5ccc-4e26-ad53-8307b0ba6a63','2016-08-08',NULL,41056,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'0d95cd28-0fdb-453d-9a8f-3c02d52557ee',NULL,'0',0),('5599a999-9267-44bd-a1a1-f4b8505fc5f2','2016-08-08',NULL,14158,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'0b74682d-2c3c-471b-81f7-0d3c1cdfc550',NULL,'0',0),('55b87a7f-24ac-449e-bcea-417eb086b029','2016-08-08',NULL,1056,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'de9a4e71-d7f6-4596-ab92-cc4ca0856feb',NULL,'0',0),('55bece67-b2c7-4b9c-b164-7558c5bfffc0','2016-08-08',NULL,2160,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'5790faa7-4875-41cd-be5f-b17b890b1393',NULL,'0',0),('55df4028-ab5f-46be-9441-3ee345f56b91','2016-08-08',NULL,24420,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'5d50e9c0-84d0-4d31-8d02-f3825a3112fe',NULL,'0',0),('55f7c482-efc6-45cb-9bfc-7edc08a82a29','2016-08-08',NULL,4529,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'eed89e3a-292f-40c0-9d8d-f14085205184',NULL,'0',0),('5609d0a8-e21a-45ee-a3e8-bd7f43e0cf35','2016-08-08',NULL,10599,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'b85869e6-1f03-4be5-9f4a-74a0646c0272',NULL,'0',0),('56254c6f-f0a0-4a51-acf2-61459b504668','2016-08-08',NULL,53043,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'32f72db1-360a-4cc7-b444-c7c1a09b66cd',NULL,'0',0),('562d43c7-ef88-4e3e-918b-e731d6cf9f86','2016-08-08',NULL,2360,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'a08ad19a-61f0-46d4-87b8-8da6c8fe0e3f',NULL,'0',0),('56994984-29bf-4073-9c03-53abaf4513f9','2016-08-08',NULL,8775,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'b8472f07-a2a4-41c5-b338-e3d5f2b16e39',NULL,'0',0),('56a39dc0-7c73-4f09-951f-7da919e10150','2016-08-08',NULL,835,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'b97239fd-c18c-4ea7-a8f4-27ca274aac66',NULL,'0',0),('56ac957e-1c7b-43e0-8e65-81c657cf80db','2016-08-08',NULL,906,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'770068c9-eb27-4bfb-b29d-f0ec9fc23d8e',NULL,'0',0),('56c8e9cd-0376-490b-9ec2-dd9288275786','2016-08-08',NULL,7503,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'1f43ba02-de8f-4b1a-8d5c-d5fabf862158',NULL,'0',0),('56d2ac33-d355-4596-ba20-d74abbad89cf','2016-08-08',NULL,14283,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'17b97205-0022-4a3d-aa41-9c715ac072dc',NULL,'0',0),('5746443e-193e-4b56-a653-acfdc869ee7f','2016-08-08',NULL,404,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'4effe726-17dd-4133-a179-cd6415fba98e',NULL,'0',0),('574cde76-c657-4519-bb94-c8266d035655','2016-08-08',NULL,11644,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'785f325c-93cd-4e3f-833a-7b448482f285',NULL,'0',0),('575a73d7-2673-4301-ba00-1e9933804594','2016-08-08',NULL,18755,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'22e4608e-f78b-4604-9dd8-2666b21690c7',NULL,'0',0),('5798ae16-c132-4ba5-a937-80ad5e50d43a','2016-08-08',NULL,148302,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'f660a9fc-459f-4277-ba19-e9dd28598262',NULL,'0',0),('57f73a6a-f360-49ad-b2de-b6efb5b55e6c','2016-08-08',NULL,14904,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e05eb9c7-ae9f-4ab0-a451-63b849918495',NULL,'0',0),('580032ca-cdf9-450c-ab8c-02ba6c9167ec','2016-08-08',NULL,2483,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'552a43b5-8cb6-4d1d-94f3-1d85131a3d33',NULL,'0',0),('580b130d-4637-466e-91dc-08b557ca33a8','2016-08-08',NULL,378,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'dd4d9de7-b0b4-4bf2-a095-cb2e876a2899',NULL,'0',0),('583096d4-974b-4cc8-9b6d-ee29b0497a2d','2016-08-08',NULL,15496,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'6076d39a-51dc-4d7f-b59b-8a81bd1e601d',NULL,'0',0),('5897840d-2508-41a8-a758-cf75fe7b9d92','2016-08-08',NULL,1863,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c7848e87-3983-4bf0-80dc-52e066e312ac',NULL,'0',0),('590f9a6b-b648-405d-ab04-6c8463b5ef90','2016-08-08',NULL,870,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'b97239fd-c18c-4ea7-a8f4-27ca274aac66',NULL,'0',0),('593c90b7-6042-41e7-a25b-88cd3b3abd13','2016-08-08',NULL,2562,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c5b2399d-dd5b-4657-8634-a29f56a6ab61',NULL,'0',0),('594be80d-515a-4447-9d3b-d3ba8f84798f','2016-08-08',NULL,388,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'590bc58c-aa06-4cb8-997d-b7abf367c28b',NULL,'0',0),('596f24b5-d2e5-4b05-9a22-cd3f7cdcbf8c','2016-08-08',NULL,518,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'475990d7-a7ee-46c3-9ed3-ec1079542117',NULL,'0',0),('5972edcd-0aa8-4976-9d70-bc18633cbce0','2016-08-08',NULL,306619,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'9a6d59ef-1828-42ff-a4b8-54cf1a02ccbf',NULL,'0',0),('5974be14-321d-442d-96cd-a8c1266d0ee7','2016-08-08',NULL,2160,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'5fae8412-5d0f-46ca-a473-09bd9c0b1ca8',NULL,'0',0),('59865fcb-d081-481c-9e77-5bde0ef8897a','2016-08-08',NULL,4860,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e40889c8-9ad8-4ccf-b2be-b2deb2ca6964',NULL,'0',0),('598c5eeb-77d9-47bc-ae26-84b69891f8db','2016-08-08',NULL,9919,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c247ed0b-33d9-47b9-979c-4577f8b55f05',NULL,'0',0),('59bbb61d-c8da-4209-8e53-391724713a38','2016-08-08',NULL,2591,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'5fae8412-5d0f-46ca-a473-09bd9c0b1ca8',NULL,'0',0),('59c26abb-d420-444f-bdca-609cc888f826','2016-08-08',NULL,4147,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'1036ff8c-ba61-4479-8b3f-1089e236dd18',NULL,'0',0),('59c632f6-37ae-45c1-ab53-e2aa9e79abbf','2016-08-08',NULL,13055,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'9802b6fb-0db0-4e66-8938-26afdccbcb53',NULL,'0',0),('59c9a791-b349-4dc5-a033-11c1f6261b31','2016-08-08',NULL,19320,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'9e8cc1ec-e2fe-41c1-af4c-ed7aab6c0df7',NULL,'0',0),('59c9f3d9-fa11-4a35-ad02-9bf4c095a7e9','2016-08-08',NULL,7090,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'37cdc631-a446-477e-b477-5f6d3568add5',NULL,'0',0),('59df8830-c642-4a25-812a-516cbf5ebf04','2016-08-08',NULL,7245,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'a95f63f1-1949-4f90-8e3d-ff5b4e7e961a',NULL,'0',0),('59e582c1-89ea-4506-9fc7-96594be2251c','2016-08-08',NULL,2025,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'56df21f7-d44f-473c-9302-a84b3c40b8c4',NULL,'0',0),('5a22c354-0560-4759-ac3a-e636a5530f10','2016-08-08',NULL,2236,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'ce29f97c-702e-4ef5-a941-fee79081fe66',NULL,'0',0),('5a2e3ffa-efb8-417c-af9f-87d34ee6c6f6','2016-08-08',NULL,6624,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'02969de9-2b60-4a29-bbe9-563ebd952079',NULL,'0',0),('5a6d87d7-597e-40dd-a82e-faa8e21b5ddf','2016-08-08',NULL,648,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'986f7ca9-4ac0-4350-9b3f-a8d37aaead04',NULL,'0',0),('5aa653a8-e380-4e0b-9562-70927d54baab','2016-08-08',NULL,725,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'78beadff-493c-4956-a1f1-dc7745b357a7',NULL,'0',0),('5ae3366d-003e-4b9d-8146-7f9ca6f54bf6','2016-08-08',NULL,162,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'2d567563-1311-4d61-b599-4262498abbcf',NULL,'0',0),('5ae46d5c-6d25-45b7-ad08-f9c47700499f','2016-08-08',NULL,6728,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'3e700502-6382-4f52-a5df-175e7407dc4c',NULL,'0',0),('5af5fad0-bb15-4246-a87a-fd2118146c52','2016-08-08',NULL,56826,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'b22ca306-7fd8-43ad-802d-1e6a2207999e',NULL,'0',0),('5b31e5c7-bcca-45b0-83fc-0e814bcec7a1','2016-08-08',NULL,38879,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'65452f02-fea6-4557-b2d1-16b5c7cb699a',NULL,'0',0),('5b5432e2-57af-4740-84fe-4f89fe0b2df9','2016-08-08',NULL,635,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'cd61cb27-850a-48c4-8a5c-f51db64176e3',NULL,'0',0),('5b5ba982-7fb0-4226-8231-227edb1f6247','2016-08-08',NULL,26599,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'692315c9-fc59-4954-ac73-05aa49d2d9a1',NULL,'0',0),('5c14b889-f247-42d7-b08b-bf2880af92de','2016-08-08',NULL,2608,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'52bb3edc-e029-4ced-8e97-2e2afc53a71d',NULL,'0',0),('5c1ab915-88e8-4b2f-9f28-7e4ef724a387','2016-08-08',NULL,8487,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'7e96a11f-735a-4afe-84d3-a229d863b834',NULL,'0',0),('5c1e5355-0075-4b8a-8a99-243f5b1e5587','2016-08-08',NULL,260,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'8a484956-eb83-4a2e-8591-c66825edb086',NULL,'0',0),('5c2f541c-3709-4fb4-a6d0-365ded8b98ca','2016-08-08',NULL,74250,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'565834a0-66bc-4d40-84ed-e3c96d4fc77f',NULL,'0',0),('5c4429ef-220c-4e14-b06e-2d60abe3d8ef','2016-08-08',NULL,1366,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'71c2099c-5089-4be3-b714-5f53900cb009',NULL,'0',0),('5c828fcd-6225-46fc-a496-4e7e1df2fe7f','2016-08-08',NULL,11069,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e00d89f5-d632-47da-bf5f-8cf9d7f4be9b',NULL,'0',0),('5c9a13d3-1329-40bd-b834-6cdba76e75aa','2016-08-08',NULL,2794,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'672947e3-41dd-4c7f-bf34-824b0dd04ee7',NULL,'0',0),('5ca8be02-4806-4add-bae0-0c6bc7ce5d36','2016-08-08',NULL,10092,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'23e3d105-5d65-4bbf-a54f-fa527ee68aff',NULL,'0',0),('5cbbfe8a-0dd3-4fda-8cfe-159b885bf047','2016-08-08',NULL,1552,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'0c87f638-2e75-413d-bd70-c5b89c144b3b',NULL,'0',0),('5d684c7d-e8ce-4881-97a4-da5e1059cfd8','2016-08-08',NULL,6644,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'de4c925c-658e-4d9b-aa04-761b50a2b364',NULL,'0',0),('5d6e5e6a-0093-43e4-920c-ebc35b4c266d','2016-08-08',NULL,3300,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'626b88e8-5e08-437b-b5e9-649a410fac46',NULL,'0',0),('5d72b65f-3f30-4e7d-99de-f0012b752f52','2016-08-08',NULL,2857,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'3dc08832-a380-4356-b01b-cf00527a0630',NULL,'0',0),('5d7e92ce-0258-4b79-9d75-4acdb5b3194a','2016-08-08',NULL,8100,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'62e4d93e-949e-4136-9628-cca17c0eadd9',NULL,'0',0),('5d834ff6-06ee-4230-903f-02dc61282795','2016-08-08',NULL,1577,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'a6f0a666-72ea-4f60-99c4-42d18487b833',NULL,'0',0),('5d8f5423-329a-4927-8a57-07e70958f58e','2016-08-08',NULL,3727,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'70792786-2f74-4516-a571-39c9b8a3af9f',NULL,'0',0),('5da0bd6d-ef7e-4485-92cd-9d137a66085f','2016-08-08',NULL,931,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'18315342-7f0d-43e6-8710-71ce095f0f5f',NULL,'0',0),('5dd15223-d89b-4c33-8e3b-15a32ad8ccde','2016-08-08',NULL,41400,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'7da6917f-afda-45c7-a879-2eed000bfc5b',NULL,'0',0),('5de4920b-c9e8-4a09-b70c-4fba0b94f1f5','2016-08-08',NULL,10681,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'5d1875c6-e3d3-4061-bd24-bdde0498a502',NULL,'0',0),('5de4d4b6-6b31-4585-816d-ad48690e3a23','2016-08-08',NULL,6469,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'ac5376fc-baaa-42b0-98ff-e1ecd592912d',NULL,'0',0),('5e09573f-2bfd-4c11-8b5f-ba0cb5188711','2016-08-08',NULL,3727,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'08a80cf4-0ef9-48d1-a79c-edd714b170c0',NULL,'0',0),('5e5641fd-e66a-4ff9-8dff-9401fdaf1b2b','2016-08-08',NULL,725,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'6f464606-9908-4437-ae5f-2949a0547126',NULL,'0',0),('5e627d45-ec91-4091-ba3d-0f46ff9156a2','2016-08-08',NULL,7116,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'a5e168c0-d73f-4caf-860a-e5cc4cc47ffb',NULL,'0',0),('5ead44a6-9291-453f-875f-d8390296b03a','2016-08-08',NULL,7158,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'8769c18d-f776-4753-86a9-2a97811c8a7d',NULL,'0',0),('5f026d43-8e4e-404e-9104-bd79499168e7','2016-08-08',NULL,638,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c6379235-1283-482d-926b-b1ca038e1f2d',NULL,'0',0),('5f127e48-85d2-4448-b764-40963deb368f','2016-08-08',NULL,2608,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'4167a503-bf99-413a-aa33-d645212307f5',NULL,'0',0),('5f2decd4-2c9b-45a8-a8c8-622ce7f82103','2016-08-08',NULL,1863,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'b77fcabc-a2e9-4157-94b1-176e5bb493d8',NULL,'0',0),('5f4ba2bf-318e-457f-8dd4-a791eaa56b20','2016-08-08',NULL,6728,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'d818a34d-5107-4798-9acc-3d6f0a2243ee',NULL,'0',0),('5f8463e1-1744-43ef-8800-ea05f8a47485','2016-08-08',NULL,26082,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'53d8fc10-c72b-46e4-ad97-dee6500c19d6',NULL,'0',0),('5f8f2a22-de1f-4af4-a90d-a90864e85969','2016-08-08',NULL,13455,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'681f1db6-6a6c-41d4-8e48-df52a4d07135',NULL,'0',0),('5f9c5994-a713-486f-9497-3940af2e5318','2016-08-08',NULL,362938,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'3c19cf31-4728-4f15-b413-11413f7181fa',NULL,'0',0),('5faa1b1c-7e17-4f49-9743-d50515d8242d','2016-08-08',NULL,696,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'7445ba41-b22b-43b4-9430-6e085dc47bb0',NULL,'0',0),('5fbb09aa-c9a4-4458-b1c0-46c833052575','2016-08-08',NULL,7348,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'d2662251-68b7-40b4-bdc2-0676f5426730',NULL,'0',0),('5fc009fa-749f-4a66-9ba0-849819f0af4d','2016-08-08',NULL,11799,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'39832a2f-9e73-472a-910b-4a5e4081ce99',NULL,'0',0),('5fd75e17-4c8b-451e-9cbd-27563f8f7f6e','2016-08-08',NULL,21384,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'a26b1643-5f37-4b51-b449-2c77bb73b2e2',NULL,'0',0),('60515ade-4ca3-4108-811f-e6d32969438a','2016-08-08',NULL,1620,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'56df21f7-d44f-473c-9302-a84b3c40b8c4',NULL,'0',0),('606f89a6-6779-48a5-9dd8-8293dbabbab0','2016-08-08',NULL,17140,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'b2b57a64-575c-4f01-8e49-6d75a13b0b6c',NULL,'0',0),('607fbb2c-27d4-4848-8155-3a1d0ccde9d1','2016-08-08',NULL,66240,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'d4a2c9ff-e6a9-4261-b6a8-9201a96e70ef',NULL,'0',0),('6081dc5e-1b24-43bb-a52a-ea20af4f871f','2016-08-08',NULL,2160,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'5062d5a6-46a9-40b3-8b47-d8967781b60a',NULL,'0',0),('60865c39-2065-4b29-a155-41547eab39af','2016-08-08',NULL,2160,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'99d42967-f9d7-43d6-8667-d98b9f3d5944',NULL,'0',0),('6165e866-8d87-49f0-b9de-080137019b77','2016-08-08',NULL,213840,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'bbcc0daf-3f4a-487a-b797-d6b2552c97b1',NULL,'0',0),('618524f2-788f-4d10-9a4a-c7698cd9275e','2016-08-08',NULL,6210,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'91fb4e05-b678-42fa-bb16-8022e2e24e22',NULL,'0',0),('61c2567e-94e4-4174-9cd1-cdf8e97c3f94','2016-08-08',NULL,7116,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'805eab32-9eb1-4345-8d2a-cca424169ae5',NULL,'0',0),('61c314f1-e312-46ac-83c1-55822796662e','2016-08-08',NULL,309,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'d9542fb1-bfa9-4556-be69-60e36511ae01',NULL,'0',0),('61f42d0e-94ce-439f-aa54-d85eab9fa87a','2016-08-08',NULL,778,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'986f7ca9-4ac0-4350-9b3f-a8d37aaead04',NULL,'0',0),('6232cf41-fe54-4e0c-9466-4bf0b4ac4b63','2016-08-08',NULL,20700,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'66c61c70-fe7e-4b9c-b58b-72766e0d8413',NULL,'0',0),('62458160-ba74-40f0-98c3-7d34e10627f9','2016-08-08',NULL,9315,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'6dee2dfe-043b-4bb7-a500-9a918d85d86b',NULL,'0',0),('624f29a1-beb6-4846-ac9e-27d407dac5cf','2016-08-08',NULL,1115,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'bcadd324-0f18-44f9-9fc3-efae346a55c6',NULL,'0',0),('62855aa6-a1f1-4373-99ee-3332627e8c6c','2016-08-08',NULL,2381,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'3dc08832-a380-4356-b01b-cf00527a0630',NULL,'0',0),('62931b45-2306-4de1-9536-cb056dd2ec2e','2016-08-08',NULL,104,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'a6e3696d-0ee8-4baf-99b4-8e0771fbb187',NULL,'0',0),('62c92feb-c696-454a-a567-1e56171a0a7e','2016-08-08',NULL,58477,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'706f8cc4-f647-4992-87c8-a17a2ec549f2',NULL,'0',0),('6314c55a-a925-4d69-91ba-9a22e084c98d','2016-08-08',NULL,1552,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'eb3f3543-7d78-4cf7-b935-009353107611',NULL,'0',0),('63269185-18b1-46f7-b824-07d71483ed87','2016-08-08',NULL,1350,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'f7d7c867-796b-4303-b251-a1f80c74eceb',NULL,'0',0),('63989870-ffdf-4980-be50-4a259df8d281','2016-08-08',NULL,8073,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'90b93b2a-34f8-43f5-957f-cb47a4551120',NULL,'0',0),('63b57e21-dc91-4b16-bef1-9cd16a6c2d9e','2016-08-08',NULL,30375,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e599645c-8615-4d84-ae88-b7f9e464feb0',NULL,'0',0),('63db9759-786c-412b-9f97-f91ba842af76','2016-08-08',NULL,23782,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'d0e980e2-8899-4acd-9c83-5e0e6db0a7ca',NULL,'0',0),('63f8832e-8fa3-4611-96a6-8cba98e9c612','2016-08-08',NULL,8694,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'a95f63f1-1949-4f90-8e3d-ff5b4e7e961a',NULL,'0',0),('64126712-9a91-4c7a-8f6a-4432f98c1c3c','2016-08-08',NULL,10124,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c5ce14c5-1410-4628-8421-e378e664a208',NULL,'0',0),('6413cc27-3d34-4e98-a7df-23bc3f27fbcb','2016-08-08',NULL,10349,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'822121a6-1bd2-4bea-8e30-109fc6d72492',NULL,'0',0),('64184fa9-5758-45df-9286-34d11c27df59','2016-08-08',NULL,7503,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'981207d1-bb18-42a6-b9cc-665574d22b62',NULL,'0',0),('6430fdf4-7109-4786-af90-c8c03778b148','2016-08-08',NULL,238,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'d8f244aa-5e52-470d-813e-9d856a95c577',NULL,'0',0),('6441ecf9-14f4-41d5-8386-c4570c95d3c8','2016-08-08',NULL,2251,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'5e3725dd-9e90-41d5-834a-80bfb0b40a79',NULL,'0',0),('644cd3b3-2de1-4e40-9a5c-fd47f02d261d','2016-08-08',NULL,15523,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'3390b1de-aafb-4fee-8194-a69121f007db',NULL,'0',0),('644d76c5-2624-49ae-b370-ae727e9a3e1b','2016-08-08',NULL,2329,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'ce29f97c-702e-4ef5-a941-fee79081fe66',NULL,'0',0),('645ffb87-5852-49c2-9887-c58e944bd7c0','2016-08-08',NULL,14784,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'2816962b-cceb-4941-b477-977ba800e72d',NULL,'0',0),('6483a5eb-dd8e-4014-9a98-0abe0eedc3f0','2016-08-08',NULL,1511,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'591dd6bb-f2f6-4b00-828f-5f7a869f361d',NULL,'0',0),('64ae3a44-cbb3-4abf-aa20-c8924ecc19c4','2016-08-08',NULL,62832,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'4542439b-97fb-4d26-8536-8feeb4dfc137',NULL,'0',0),('651c78ba-66e6-4d74-8c95-7b57ac8467f2','2016-08-08',NULL,648,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'05830da2-288e-4908-b338-4871b114a416',NULL,'0',0),('6569ab49-b8c8-40ba-bbad-341af3fb6f56','2016-08-08',NULL,12917,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'a63f33cd-561e-4f75-8fd8-6784c3716e31',NULL,'0',0),('65bb8f81-7179-4f47-8198-28177ffa5677','2016-08-08',NULL,756,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'407fad1b-31fd-41a8-9e2e-26e407355981',NULL,'0',0),('65f0ae2e-5bd6-4d12-8c78-f9bb743d5e91','2016-08-08',NULL,605,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'6f464606-9908-4437-ae5f-2949a0547126',NULL,'0',0),('66129181-7782-4881-b9d3-4bb84b210e42','2016-08-08',NULL,10268,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'b797a848-7080-4827-b406-1924ac7bcecf',NULL,'0',0),('6644b93d-765b-48a4-8220-3ffe958d56dd','2016-08-08',NULL,245295,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'9a6d59ef-1828-42ff-a4b8-54cf1a02ccbf',NULL,'0',0),('6685bd6e-7b50-40dd-b5b8-78b50e2539dd','2016-08-08',NULL,12187,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'36f18236-d50a-435e-9869-968e0b2f0025',NULL,'0',0),('66a7ed19-fedc-4d77-9e9e-1b1b4eb78484','2016-08-08',NULL,56166,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'3dac8d81-16af-4e9b-9f3f-b3cca940035e',NULL,'0',0),('66c46f99-aeb9-487d-b062-3c20cafe5aae','2016-08-08',NULL,6480,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'6663aebb-4ed2-48bf-8625-7f875052bc7b',NULL,'0',0),('66d97143-5108-4626-a7c9-3a7e9b53d773','2016-08-08',NULL,11644,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'6dee2dfe-043b-4bb7-a500-9a918d85d86b',NULL,'0',0),('6726dfc8-2068-430d-a4d3-27c8e95c1423','2016-08-08',NULL,18224,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'63c4e0ef-6ebc-464d-adf9-1d5dce38473b',NULL,'0',0),('6746cc49-a1b7-4e76-953d-65e050c130d8','2016-08-08',NULL,271,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'848536e1-d0f1-499a-8cd1-40bfb1c2efe1',NULL,'0',0),('6771a119-7ea2-4e91-85d5-bad6f4fbcb44','2016-08-08',NULL,3960,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'05f7ca85-abef-44b7-856b-bd65718f0eae',NULL,'0',0),('67c1e776-9615-42c3-ba56-d91088e124f9','2016-08-08',NULL,10609,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'940bd155-9e53-419b-b24a-bab1df49a63c',NULL,'0',0),('67c74899-8752-4c40-a691-4f5080e93aa1','2016-08-08',NULL,4784,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c0b87cc9-7dd5-4e92-b78c-5b065da4e621',NULL,'0',0),('67cc30bf-ac02-40a1-af45-56462473ff15','2016-08-08',NULL,1728,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'08b45e7e-9a17-4a42-a545-f23327c35785',NULL,'0',0),('67cdaf09-7dd6-4330-a338-149d758bd50c','2016-08-08',NULL,1080,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'69a092a5-158d-44df-90c8-025ce8f26d68',NULL,'0',0),('67fe1fb8-82d9-4eb6-8546-86a43a2fd422','2016-08-08',NULL,4968,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'3161ee08-13f9-43d6-a312-043f441baf9b',NULL,'0',0),('6821896c-71c1-4b8a-bf9f-1457714520aa','2016-08-08',NULL,125,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'a6e3696d-0ee8-4baf-99b4-8e0771fbb187',NULL,'0',0),('6823afcb-746c-45a4-aaed-85ac91031400','2016-08-08',NULL,15813,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'33deee8e-779e-4354-9abc-c821cfd629dd',NULL,'0',0),('686a96bc-27af-476a-81f7-84e4ec6f9ffe','2016-08-08',NULL,28080,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'db75c674-4ed2-44ce-bcd8-e1d3a51625fa',NULL,'0',0),('6875cd08-08e0-423e-8de1-64f42392712a','2016-08-08',NULL,387,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'35f2b105-7802-446d-881f-97f5f407a6ef',NULL,'0',0),('687fd130-efad-409e-8aef-03f6398f72da','2016-08-08',NULL,4658,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'dd0751e7-c88c-473e-94eb-955bd6e0ea8b',NULL,'0',0),('68e7af77-3f1e-449b-bf3b-8b90094fe7ae','2016-08-08',NULL,46805,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'3dac8d81-16af-4e9b-9f3f-b3cca940035e',NULL,'0',0),('69004161-6e5b-4188-a228-8e7678f51150','2016-08-08',NULL,61375,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'a969df9a-af25-4798-9fa7-a2e72520e1f7',NULL,'0',0),('690686c6-7cca-4a50-ab1b-819edecef14d','2016-08-08',NULL,8073,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'1a963c74-95d3-4735-ac0c-55358c5a078c',NULL,'0',0),('693b133a-47c0-45b1-a3a6-6333a02e6068','2016-08-08',NULL,3564,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'40858ddf-87fc-47ac-8f18-f1d67e2bdea9',NULL,'0',0),('694b7b28-0ede-4487-9ef0-d506e543970f','2016-08-08',NULL,5377,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'5aef0cff-d054-45c2-a26e-98e57f13544b',NULL,'0',0),('694fd51d-ed50-407d-866e-0902bea24ec2','2016-08-08',NULL,7327,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'4f6f1a5c-8c63-4398-a1a7-d3fca7a0c400',NULL,'0',0),('695be700-6ff8-48eb-bdad-664b850f9766','2016-08-08',NULL,38709,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'76c588c8-fd4e-460c-bc82-32d0f60eed1a',NULL,'0',0),('6967426c-71d2-4bf6-8f90-78e7bbbe22cf','2016-08-08',NULL,1035,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c3c83d79-ff0e-4631-9a67-2cd941c54ce7',NULL,'0',0),('69a907a8-76dd-4aa6-a4a5-e2ccafbf4193','2016-08-08',NULL,10349,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'1177854c-af94-4c6b-b3ef-8545dc0c2a7c',NULL,'0',0),('69b23e39-f874-4464-9420-1e00d7639847','2016-08-08',NULL,14902,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'bccb7f35-5065-4ef0-997a-839c35d8f804',NULL,'0',0),('69ff02fc-e267-412a-bb42-4be3f7121385','2016-08-08',NULL,18630,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e07d2c5c-d211-4ba1-ad34-706ef9c5c2f4',NULL,'0',0),('6a2eda46-9ad8-4152-a038-484254e1e286','2016-08-08',NULL,278,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'de368c77-e855-4ee6-bbb4-89194ee66380',NULL,'0',0),('6a5bdcd0-f8eb-4742-8ed1-77e17c5df9aa','2016-08-08',NULL,16560,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'66c61c70-fe7e-4b9c-b58b-72766e0d8413',NULL,'0',0),('6a70e5d3-f7c6-48f5-a012-5200143b1267','2016-08-08',NULL,98828,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'1cb74234-3d39-4b32-bf58-4b07136eb87b',NULL,'0',0),('6a8bd83a-1584-4d6c-b43f-963ac965d438','2016-08-08',NULL,28176,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'32dbb41e-2878-40ad-a4f2-31b8b34400ed',NULL,'0',0),('6ac910d3-cddd-460a-a558-1940ca8791a0','2016-08-08',NULL,6339,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'5657e79e-8248-418d-8286-45852459a396',NULL,'0',0),('6ad28311-5253-4d01-9897-6c3d1692f037','2016-08-08',NULL,908,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'43eecce1-b6f8-4ed1-a8f6-3f029d3bc1d6',NULL,'0',0),('6af078a7-c6ac-4941-b0a7-66d19b6b8eee','2016-08-08',NULL,51750,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'fd971fe4-4fdc-4eeb-97cb-b7d8f2853c50',NULL,'0',0),('6b0e8fe8-0e45-4897-ad16-7eda3cc5c77b','2016-08-08',NULL,21839,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'a42e340c-95ea-4b76-82ea-692dace6f11a',NULL,'0',0),('6b26658e-9854-4198-b4ed-d915c0a4d3ce','2016-08-08',NULL,71156,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'bb427bf0-ee51-4e14-b585-f8d92e08e0ad',NULL,'0',0),('6b67999f-c888-4102-ac5c-b0a46ab24270','2016-08-08',NULL,1940,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'ff17b5c0-4ddb-4aaf-aed0-27d0823c2784',NULL,'0',0),('6b707722-4e00-4129-a762-ec54572f80ba','2016-08-08',NULL,453672,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'3c19cf31-4728-4f15-b413-11413f7181fa',NULL,'0',0),('6ba152c0-5f94-47f1-b33d-966b78f514d8','2016-08-08',NULL,29728,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c6cb3613-3b59-4d93-bad5-cbc307a5b147',NULL,'0',0),('6bdc5bc0-4677-451d-bc3b-e8a23704a354','2016-08-08',NULL,27071,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'78f0d0d4-0f97-41ad-b2ef-59bca9b38470',NULL,'0',0),('6bebb733-28b9-4d82-b95e-e0c3ce4c022c','2016-08-08',NULL,6480,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'5abe998d-42be-49d3-a2dd-2a2aff059473',NULL,'0',0),('6bf2263c-b62c-4672-9c05-ecfa580b9136','2016-08-08',NULL,108,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'bccdfffa-31da-4bc7-b7ba-6314936cac66',NULL,'0',0),('6bf2cdbf-f286-4b66-9e64-aa3f3b950f5c','2016-08-08',NULL,1296,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'a4be3d32-ddb9-4ec1-85d3-74107f1cb9f7',NULL,'0',0),('6bf3015c-5cb7-481b-ab1c-c9b9d714193a','2016-08-08',NULL,24478,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c2ebfa2f-486d-4784-bb85-8e5524da2ba4',NULL,'0',0),('6c041173-ff0b-4408-b143-b688db718e78','2016-08-08',NULL,2723,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'084ecea3-20b9-47fd-a75b-b5bc0f6cbd69',NULL,'0',0),('6c2a64ab-142e-403c-b8b4-ed8955d5956f','2016-08-08',NULL,716,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'3484a9b2-c960-4a19-a8fe-5a71bc8d2e74',NULL,'0',0),('6c30c969-25db-4b3b-83ab-4777fb16726e','2016-08-08',NULL,2483,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'1efa96d9-713d-4a0f-be9b-1d681ab2f0e2',NULL,'0',0),('6c47a9fc-5ca3-4dcb-9d53-16814767a867','2016-08-08',NULL,24841,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'b1e8d539-2fa7-4c11-bb0d-b6889fb8bced',NULL,'0',0),('6c7f2e36-6bd3-4681-80ef-b4bb9db397df','2016-08-08',NULL,1293,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'8da8e399-bf10-4dfc-8363-82722c174366',NULL,'0',0),('6c8659fc-dd42-4d92-b23b-adf9338db2e3','2016-08-08',NULL,10124,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'cb1b81ea-20e3-4e77-8dc7-183cb222b81d',NULL,'0',0),('6cde75bb-f013-4bbb-88e8-58582aa74297','2016-08-08',NULL,36267,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'30a807fc-2faa-4c65-ab73-4f2f78ae9ced',NULL,'0',0),('6d873d69-4f45-48fa-80ba-f734bfb4092b','2016-08-08',NULL,2591,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'99d42967-f9d7-43d6-8667-d98b9f3d5944',NULL,'0',0),('6dac1379-d8aa-4703-b83c-94a237e768f9','2016-08-08',NULL,27324,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'25310c3d-2ca0-4dbb-9b8a-7d0c3754b11a',NULL,'0',0),('6db62618-c4d5-4e2c-9e66-27598ac3fa55','2016-08-08',NULL,432,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'2c1f9606-af8f-42ac-ac91-9eb2f322f5d4',NULL,'0',0),('6e21621c-c0f7-46a0-b2a1-4d2d685e22ea','2016-08-08',NULL,56925,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'bb427bf0-ee51-4e14-b585-f8d92e08e0ad',NULL,'0',0),('6e3ca539-1dae-4db2-a55b-dd11b0052cf4','2016-08-08',NULL,27864,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'68172e37-b09a-4a41-b9b3-a1fa7714310e',NULL,'0',0),('6e6048f5-c1b5-49b3-a86d-edd44d0e219f','2016-08-08',NULL,5088,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'9d42b826-2089-429f-9f97-e686e146bf08',NULL,'0',0),('6ea5358c-98d6-4a4c-b0ab-3cf0e09be94b','2016-08-08',NULL,12627,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c98a019a-981b-485b-86e4-7b3cc62d4d27',NULL,'0',0),('6ebed068-f150-4ac0-b20f-0ea1a015df75','2016-08-08',NULL,18755,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'0f3778f1-cf32-45cb-b73a-701184d39bb8',NULL,'0',0),('6eccc345-1ddd-42ac-91ff-c977d47a4fde','2016-08-08',NULL,1782,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'abb5cb67-760d-4be3-b7a1-4ced780cf00c',NULL,'0',0),('6ed19d55-04db-4a2d-bb76-2fdc4abbe023','2016-08-08',NULL,564,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'ecb0ba82-2039-4da4-ab4f-b1b25d90e745',NULL,'0',0),('6ed5441d-5598-4a7a-804f-df50cffcf49c','2016-08-08',NULL,3727,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'886a413c-7025-42fa-b945-90f0ddc80fa1',NULL,'0',0),('6f21bd0b-d217-426b-8c9a-a530ad42ad5f','2016-08-08',NULL,55632,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'f32709b7-59c6-4d10-91ed-75936038e844',NULL,'0',0),('6f31de18-3e9a-4a62-b7b7-ce0975283cbf','2016-08-08',NULL,51319,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'0d95cd28-0fdb-453d-9a8f-3c02d52557ee',NULL,'0',0),('6f6b7b78-d8c5-4930-875e-00df7fb07fc2','2016-08-08',NULL,19407,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'d5867fc3-708d-4fd8-8b83-49598971cfda',NULL,'0',0),('6f6e0c94-8edb-442f-bdc1-f2d161aa998f','2016-08-08',NULL,3106,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'bead6344-7eff-4998-9733-67ba6c78599d',NULL,'0',0),('6f838330-088a-4d3a-b765-24a5aa54e0f0','2016-08-08',NULL,49267,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'0d95cd28-0fdb-453d-9a8f-3c02d52557ee',NULL,'0',0),('6fcc208f-0a69-4487-95c8-0a8d05b2a616','2016-08-08',NULL,15008,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'0d0a7ff1-8497-40bb-a4b2-848d7ac2749c',NULL,'0',0),('6ff23f2a-14a8-44dd-9c8c-41b25df10d21','2016-08-08',NULL,1296,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'69a092a5-158d-44df-90c8-025ce8f26d68',NULL,'0',0),('70304798-c6f5-434b-8d99-f147eeffc591','2016-08-08',NULL,1940,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'8573a3b3-2381-4989-8194-1d966e8652ef',NULL,'0',0),('7039303d-2d5c-403d-bd54-c08444c879ca','2016-08-08',NULL,15048,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e75543d4-2e88-46ea-9c86-6f81cae97787',NULL,'0',0),('70a1b25d-fcd4-4bb0-9ee9-c10d435990b3','2016-08-08',NULL,14532,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'39ec1054-d8a8-4e7e-84fc-984740b0f8f2',NULL,'0',0),('70b4ba2a-102f-4327-8e88-c5f131ee6328','2016-08-08',NULL,8073,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'9765d942-edbc-4d37-993f-6b4cc4fd8c92',NULL,'0',0),('70d46736-b205-47d2-a1f8-46391bbb33d5','2016-08-08',NULL,23805,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'8b8953f3-3901-4053-86bd-4fe8191e3bad',NULL,'0',0),('70fa8549-6729-4093-a90f-6f4ddcb419a1','2016-08-08',NULL,10349,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'4f829a87-bbba-452c-968a-7d3c063ec45b',NULL,'0',0),('70ffa9a3-772e-47a5-bacc-849674d6549b','2016-08-08',NULL,3106,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'886a413c-7025-42fa-b945-90f0ddc80fa1',NULL,'0',0),('7106e087-ecc4-417c-83da-30a091dd0786','2016-08-08',NULL,3725,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'bbdff218-6ed0-4984-bf91-194096003796',NULL,'0',0),('71553b47-42af-4f5f-84aa-10ae8656599b','2016-08-08',NULL,3602,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'a49fe108-ce17-4da1-862b-23448b62fa99',NULL,'0',0),('7174ba56-1cd6-48c4-8fd1-594a31786ced','2016-08-08',NULL,4099,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'eeb87659-05a0-48ec-8e63-9a13d4e24302',NULL,'0',0),('7200695f-4b7a-4ead-86cf-44837f8047a8','2016-08-08',NULL,31625,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'9fd7b7e8-0265-463f-b973-bac85c31abf4',NULL,'0',0),('721ec7be-3955-4abf-9ae4-d1f9b01f4183','2016-08-08',NULL,2138,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'abb5cb67-760d-4be3-b7a1-4ced780cf00c',NULL,'0',0),('724180df-d56e-44c0-88b1-c2e0d1e42238','2016-08-08',NULL,3519,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'94e09848-c3cc-4302-89eb-25b1e4a7880d',NULL,'0',0),('72565a7f-a875-456b-b27c-17ce998da9ac','2016-08-08',NULL,14878,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'17b97205-0022-4a3d-aa41-9c715ac072dc',NULL,'0',0),('7296d6e8-2c52-4e4b-9d90-89a7525a45e5','2016-08-08',NULL,6072,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'7c02890e-1b8f-4be3-84ad-b79727abe03b',NULL,'0',0),('72a5eae9-68ea-4811-b4ae-9e6edfff611a','2016-08-08',NULL,31117,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'4e196243-c077-49e7-9ff6-b6d188a9f10a',NULL,'0',0),('72d7cd30-6667-49ce-a2c5-34e340ad888f','2016-08-08',NULL,388,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'6d78718a-6d47-4434-ae4e-fb33df9a0714',NULL,'0',0),('72dc4f61-f691-4e18-b7a2-86f78500e54a','2016-08-08',NULL,10081,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'6ef114dd-7073-45bb-8b29-c3d8aae1c636',NULL,'0',0),('72fe6dee-c249-4da9-b7b2-a3d0fcc9ac15','2016-08-08',NULL,388,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'4effe726-17dd-4133-a179-cd6415fba98e',NULL,'0',0),('733b39af-348a-4154-87fd-7c22be9b3583','2016-08-08',NULL,5589,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'689937cd-f309-47a2-a1b7-812c792e5062',NULL,'0',0),('737163bd-b070-4efa-ae3c-565681a9c17d','2016-08-08',NULL,1293,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'d37f5f6d-53be-40ee-85c6-4edb83ce65c7',NULL,'0',0),('739bf5d7-00e1-458a-a430-82f97954a07e','2016-08-08',NULL,2298,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'5c293368-1897-4eb3-9915-e1cf6351d918',NULL,'0',0),('73ae414f-c1a1-4657-ba41-7285b6e7c475','2016-08-08',NULL,1125,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'0c22a71d-831d-4f91-9006-aac28244e489',NULL,'0',0),('73b2fd62-2d12-4f53-a289-f09a1d451d56','2016-08-08',NULL,35775,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'635fb567-5a30-46a0-92e9-d24c2bf9340f',NULL,'0',0),('73b71007-b24f-4a89-a580-b6689369f3e0','2016-08-08',NULL,25931,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'4e196243-c077-49e7-9ff6-b6d188a9f10a',NULL,'0',0),('73cac0ac-54fc-469c-a266-16787385512d','2016-08-08',NULL,14158,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'39832a2f-9e73-472a-910b-4a5e4081ce99',NULL,'0',0),('73d5c156-9c5d-4090-a9e8-467e78caa9e8','2016-08-08',NULL,39330,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'940e364c-f540-402b-9228-3b00ab32c624',NULL,'0',0),('73ee8a0e-8ad3-416e-b249-aadfcfeb09ef','2016-08-08',NULL,9935,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'bbcb16ce-b29a-4b33-b633-ebecb8211ea3',NULL,'0',0),('741bc90b-5e3f-4cda-bb9c-53055e31a7ec','2016-08-08',NULL,7128,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'9b45d4b2-297f-4b31-8029-343daa7a39a2',NULL,'0',0),('741c255e-0aa8-4ca0-b4e4-e83cdf528c37','2016-08-08',NULL,172068,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'0dc97e5d-c36b-4bc9-bdbf-62bce2412dd0',NULL,'0',0),('742f8d8a-8706-4105-bfc2-9463eda5ef02','2016-08-08',NULL,1109,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e308ba64-e78e-4228-93d9-24a081bef865',NULL,'0',0),('745bc4f2-9cbf-4eb2-806c-859f34fa1613','2016-08-08',NULL,330,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'93bcac5f-f791-47d7-8bd7-c4973506029d',NULL,'0',0),('7480fc7b-2a42-4373-ace0-439b3171f940','2016-08-08',NULL,27324,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'3e9aef4d-7b15-4cab-9e07-84245b9a7090',NULL,'0',0),('748138fa-ca4e-4c0a-a3ad-960915664eb2','2016-08-08',NULL,107123,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'b58a6f2c-6b73-414d-a5b8-f2aca010713c',NULL,'0',0),('7492d27d-3a5c-4f3f-8288-beee015404b3','2016-08-08',NULL,10060,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'8c2d9e22-6bc0-4525-8c22-3fb3d74077ab',NULL,'0',0),('749810d7-f208-4dbd-9831-a65505581afc','2016-08-08',NULL,22968,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'32c00f0f-3f41-4b6f-b511-cc713e4a0376',NULL,'0',0),('749b8a0d-5e36-47d6-b885-b6c4863aafab','2016-08-08',NULL,2587,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'1efa96d9-713d-4a0f-be9b-1d681ab2f0e2',NULL,'0',0),('749efbc4-d028-4132-aed1-f3a173f66006','2016-08-08',NULL,1350,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'69848a12-92b1-43a8-a17a-7508e5065415',NULL,'0',0),('74b16e35-ea1b-410f-9135-456b822103c7','2016-08-08',NULL,5093,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'0db1619a-3d5d-4dd2-a294-af7ab18f09a5',NULL,'0',0),('74b1f667-89cc-4f2f-a173-9b5d674c6ec0','2016-08-08',NULL,17854,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e88437e1-6136-4b3f-a144-3af04b68d0cc',NULL,'0',0),('750cb761-12f9-4fa9-af48-31f1014bdb0d','2016-08-08',NULL,56530,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'d29a5c7d-225f-4b41-b036-88e2315ee949',NULL,'0',0),('750e6051-bb57-4a29-92a2-d510ce70edb0','2016-08-08',NULL,4968,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'a576e481-1a6c-4809-b47e-2881bf29e1da',NULL,'0',0),('751902e8-b4bf-4ecb-b4a5-43705226a584','2016-08-08',NULL,19536,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'22e4608e-f78b-4604-9dd8-2666b21690c7',NULL,'0',0),('752e66f9-70c8-4372-b3c4-40baf96c2e54','2016-08-08',NULL,11179,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'5368a724-8791-4235-a3c3-14be6a7c8366',NULL,'0',0),('758b83bc-508f-4192-a10a-b7743ffbc7a2','2016-08-08',NULL,12524,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'90cea514-a24c-4f8c-b37a-9b868acac2ae',NULL,'0',0),('75991bf4-774f-48ab-91e4-ea863e8de749','2016-08-08',NULL,755,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'770068c9-eb27-4bfb-b29d-f0ec9fc23d8e',NULL,'0',0),('75a1d744-0f9a-48f8-a3b0-ed2aa098f383','2016-08-08',NULL,23183,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'6b2cb11a-7607-48e6-ab8d-850cb701e1c0',NULL,'0',0),('75a51a1b-009d-4bfb-80df-573bc8d0e268','2016-08-08',NULL,5305,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'0db1619a-3d5d-4dd2-a294-af7ab18f09a5',NULL,'0',0),('75a97a14-dbe2-447a-bf4a-970a6477eefc','2016-08-08',NULL,9315,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'479eaf77-b6ff-4506-9add-222234d4bf8b',NULL,'0',0),('75ae2fe4-f749-46e8-83d8-6ace98283469','2016-08-08',NULL,1750,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'3fc3e6ff-2011-4022-bd3a-6c826cbc2411',NULL,'0',0),('7620f8bb-c095-46e4-aa35-9e98a3a1a454','2016-08-08',NULL,10879,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'744997b4-9d98-44f3-8eff-6ed0583b6be1',NULL,'0',0),('7628d5ad-47ab-4cd1-92f7-fc8b062638e7','2016-08-08',NULL,325,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'848536e1-d0f1-499a-8cd1-40bfb1c2efe1',NULL,'0',0),('76302dd7-13ff-4ca7-bbeb-ed7211ecdd43','2016-08-08',NULL,6459,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'d818a34d-5107-4798-9acc-3d6f0a2243ee',NULL,'0',0),('76419a0c-0ba6-458d-bf7c-ddda6bc50729','2016-08-08',NULL,36432,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'7fd16ed2-3b51-4d09-b5ed-4bad37a4f0f4',NULL,'0',0),('76819ef9-4d0a-44ee-90bc-f38afa6b362b','2016-08-08',NULL,1035,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'742a55d2-b11b-481c-8cc2-20d85daac577',NULL,'0',0),('76826b99-4f33-48ac-8f01-8e836cb05faa','2016-08-08',NULL,8266,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c247ed0b-33d9-47b9-979c-4577f8b55f05',NULL,'0',0),('76982e7e-79ee-48f2-b340-d73e87adc8e8','2016-08-08',NULL,133903,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'b58a6f2c-6b73-414d-a5b8-f2aca010713c',NULL,'0',0),('7698cbfb-c794-4a37-a818-140ae71f5b3d','2016-08-08',NULL,8798,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'01b583c9-c515-4b30-9793-482d0a76f1d2',NULL,'0',0),('76a3b154-7881-48dc-b342-bdee4124afc8','2016-08-08',NULL,44963,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'53f9ec0d-c5a3-46f0-b51b-3a1f0fad63f8',NULL,'0',0),('76afb2be-fbc3-46d0-b6e4-dc4434c442a3','2016-08-08',NULL,2483,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'2c5d4a47-3f91-4771-aadf-8ee49ac08206',NULL,'0',0),('76ddfe15-3621-4a7a-9f03-eb642efaa09f','2016-08-08',NULL,23782,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'6b0abda0-9adc-409b-94a3-e7b6723c4be3',NULL,'0',0),('76ecba00-9926-4670-884a-65ae2fb50849','2016-08-08',NULL,9719,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c5ce14c5-1410-4628-8421-e378e664a208',NULL,'0',0),('76f1eead-ed2e-478a-9881-ea0bd4f01701','2016-08-08',NULL,11665,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'7353aa67-3256-4ce2-9d6e-f20ddeb3be76',NULL,'0',0),('777b6de9-dc53-4f3a-adb4-78037f5df10f','2016-08-08',NULL,19119,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'6437460d-aebc-43e0-9172-ad29b40444ad',NULL,'0',0),('777ebcdb-116b-413d-b282-0f63b2d66e9c','2016-08-08',NULL,11799,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'a39c3b64-9c5d-4824-b80a-f5cf58c5297b',NULL,'0',0),('77cc497e-a06b-4c21-811f-067df7366c9c','2016-08-08',NULL,2173,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'52bb3edc-e029-4ced-8e97-2e2afc53a71d',NULL,'0',0),('780c8370-662b-49dd-91c9-68def3b832dd','2016-08-08',NULL,16145,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'b13ca82b-fbc6-436c-8645-802d56ff7f96',NULL,'0',0),('7817d4e0-38fc-4369-ae0e-76ff70506553','2016-08-08',NULL,3106,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'ec38ce5b-96cd-4bd1-aede-f1f7364f5826',NULL,'0',0),('7846af44-900f-493a-b320-f96dfa490e23','2016-08-08',NULL,44591,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'de8c5b61-d15b-47dd-8cc2-a4a75be4c43b',NULL,'0',0),('787fe400-d750-4645-b7e4-a90176d44c3b','2016-08-08',NULL,20830,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'1cbdf52a-e1bc-4242-b846-d9b8f5e323c3',NULL,'0',0),('787ff051-e903-48ba-b09b-0948b9fc654c','2016-08-08',NULL,3727,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'ec38ce5b-96cd-4bd1-aede-f1f7364f5826',NULL,'0',0),('78a855de-299e-4b5e-9769-931a44c8ed03','2016-08-08',NULL,9729,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'6d745229-9f24-4476-9dde-9fba11c73668',NULL,'0',0),('78ce7659-93f8-49ab-af86-d4a24c112101','2016-08-08',NULL,203,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e0850b2e-6108-475c-b8d1-3d94274a563b',NULL,'0',0),('78cef0ec-2891-4dfa-b73d-47023ac8ac92','2016-08-08',NULL,4906,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'dc7b57d7-2ba4-451d-a5f1-0d0ae4c0c6f3',NULL,'0',0),('79322861-7b88-437d-9f80-67f4c1413b6c','2016-08-08',NULL,11426,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'a73fc586-4831-41db-b1be-992e4b8a1687',NULL,'0',0),('794770d5-7bd0-4f8d-937a-a2a7bec4e7fc','2016-08-08',NULL,154085,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'bcbc9ffe-fb49-4c43-bb91-85ddc9dddb71',NULL,'0',0),('794ed885-fbe6-4f1c-b348-6038eb81acd0','2016-08-08',NULL,17854,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'8e9a55ff-80e9-4d17-a3d5-4f93ec7ac323',NULL,'0',0),('79c0bbdd-f4b5-4b7b-ab32-1e8136545d05','2016-08-08',NULL,1980,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'6d159603-dad6-4913-b824-7adf31304971',NULL,'0',0),('79d6d3bc-35e7-44de-8aa7-6c30fcdde918','2016-08-08',NULL,662,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'2fd63757-2ddc-4466-b04f-a3ca142b8591',NULL,'0',0),('79e68c36-0ac7-4a4b-b41b-5f1dc2db44d8','2016-08-08',NULL,34056,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'f75d973c-f0b9-4d48-aa08-134e55c5c37b',NULL,'0',0),('79f7b67f-4d82-4015-99b5-b0e000f161e6','2016-08-08',NULL,901,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'f212b583-b619-4352-b7ae-bfd3677d4ad4',NULL,'0',0),('79fe9103-84d6-427c-8db0-df20f764a167','2016-08-08',NULL,3106,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'29c26422-a1af-4fad-a14f-c5cf4550671e',NULL,'0',0),('7a1de141-3af6-4bfa-9d1a-08504c046258','2016-08-08',NULL,21384,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'4b4313d1-4ec1-49cc-b023-a175c2696263',NULL,'0',0),('7a24a511-9d81-40b4-b670-7a97719c8f37','2016-08-08',NULL,28538,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'99bd428f-3d27-41e7-8604-53cc2c550c24',NULL,'0',0),('7a2a6784-d79b-4258-b019-512ee062f2c9','2016-08-08',NULL,13608,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'2f49b0a4-86e3-4295-8f55-2fabd91b30f7',NULL,'0',0),('7ac69c5f-06d8-4583-ad17-312fcba7cc6f','2016-08-08',NULL,9688,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'23e3d105-5d65-4bbf-a54f-fa527ee68aff',NULL,'0',0),('7ada043e-e4c0-4f20-ab1b-da197a2295f9','2016-08-08',NULL,12291,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'a39c3b64-9c5d-4824-b80a-f5cf58c5297b',NULL,'0',0),('7af971fe-3d68-4377-9d41-62df70c67096','2016-08-08',NULL,23681,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'4e6b8e5d-2296-42a4-9cfc-35b0907fcdd1',NULL,'0',0),('7b3e7d0a-97b7-489b-95d3-bec96c3e8e2e','2016-08-08',NULL,25186,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'afdf278b-e323-4208-8a00-0e639c63496f',NULL,'0',0),('7b5c53c5-d183-4dca-ab53-313725bf2a10','2016-08-08',NULL,3416,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'43afb9fc-1f57-4e00-a93b-bf51de20e7e1',NULL,'0',0),('7b77e6d6-7258-4c8a-8205-d8a650eef573','2016-08-08',NULL,10558,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'aaea9111-5d11-460e-b898-c56762aa4455',NULL,'0',0),('7b85290d-bd24-41c3-8834-54c9c094c2e2','2016-08-08',NULL,17140,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e88437e1-6136-4b3f-a144-3af04b68d0cc',NULL,'0',0),('7b98b68f-3e27-4400-bc33-e92f80034a3a','2016-08-08',NULL,3727,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'bead6344-7eff-4998-9733-67ba6c78599d',NULL,'0',0),('7ba51fb3-e93e-44fd-86ee-1c111f124684','2016-08-08',NULL,4140,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'a576e481-1a6c-4809-b47e-2881bf29e1da',NULL,'0',0),('7ba5f68b-ec30-4c27-a293-2d073f69d973','2016-08-08',NULL,8694,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'a2cf4c47-125c-4e86-b578-9eb32c918cdc',NULL,'0',0),('7bc89f4c-6f6b-4360-9dd7-adea18ebfe37','2016-08-08',NULL,7080,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'a51eaf49-7f7f-4e87-a3a2-d0099ca70880',NULL,'0',0),('7bdb2ba6-7906-4973-b094-caed56f261f7','2016-08-08',NULL,172800,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'a8e411d5-e8c0-4648-9ca7-bbe90db1f4a7',NULL,'0',0),('7c08aaf9-ef4c-4bcb-a5a5-7ecb6ffcbb73','2016-08-08',NULL,68310,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'bb427bf0-ee51-4e14-b585-f8d92e08e0ad',NULL,'0',0),('7c1e0afd-5d5f-428e-855d-18c407e741b6','2016-08-08',NULL,1674,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c4f1a4e0-097c-4c74-87d2-5c1ce0c781f9',NULL,'0',0),('7c21c7af-dffd-4cc9-a2ba-4db956173300','2016-08-08',NULL,7198,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'f91c5830-2808-4e6e-9c23-320a015d0308',NULL,'0',0),('7c28fe87-c61f-4e8c-962e-0ecc98e34107','2016-08-08',NULL,348,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'f5509dde-0cea-4281-9079-1dcf6a033ee2',NULL,'0',0),('7c84d080-76b9-48c9-8760-ff63ae78d054','2016-08-08',NULL,35574,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'5463545e-fff0-4208-aec6-0d308efacdc1',NULL,'0',0),('7c871642-debc-446f-a2cf-09503f8c2f9c','2016-08-08',NULL,10558,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'acd3b56c-0811-498b-9324-640d56607ef2',NULL,'0',0),('7ca79504-0475-4bef-a692-fd8073b79bcb','2016-08-08',NULL,79489,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'d4a2c9ff-e6a9-4261-b6a8-9201a96e70ef',NULL,'0',0),('7cdd0d2a-241b-4d9b-b980-56e6f2effc08','2016-08-08',NULL,9563,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'41bd6355-9d61-47b9-bb0b-ceda1aae21fc',NULL,'0',0),('7ce29168-d588-49ac-8862-55be4ab95649','2016-08-08',NULL,6872,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'8769c18d-f776-4753-86a9-2a97811c8a7d',NULL,'0',0),('7d1e4c74-d15c-4965-8bc5-d26cef7145e0','2016-08-08',NULL,891,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'ec6fa4a1-8d0c-4b8d-b6cb-12fb11f43d7b',NULL,'0',0),('7d461e75-e958-4001-a435-b820d1fc1143','2016-08-08',NULL,3300,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'05f7ca85-abef-44b7-856b-bd65718f0eae',NULL,'0',0),('7d51131c-6e2b-4c47-a866-b6a784398b74','2016-08-08',NULL,73650,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'a969df9a-af25-4798-9fa7-a2e72520e1f7',NULL,'0',0),('7d68d214-98f9-405d-a20e-565c55fda205','2016-08-08',NULL,42434,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'32f72db1-360a-4cc7-b444-c7c1a09b66cd',NULL,'0',0),('7dc76cab-fb33-4ce1-b768-2b90157227e7','2016-08-08',NULL,1314,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'a6f0a666-72ea-4f60-99c4-42d18487b833',NULL,'0',0),('7dcbdd49-d73e-4095-90de-18f0b2fb9e14','2016-08-08',NULL,475,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'43659546-bd7c-4146-b6eb-27f8be761a4d',NULL,'0',0),('7dd74252-0820-4436-849f-2d5c2fada974','2016-08-08',NULL,6600,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'0bd09974-0132-4a30-98ae-ac6d2f95cb0b',NULL,'0',0),('7de2099d-8f32-4a0e-8bf0-82eb8867fde2','2016-08-08',NULL,21217,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'746ec058-c48a-4a7d-a2db-907773279793',NULL,'0',0),('7e24e53d-2775-4321-9aef-c813e15da2eb','2016-08-08',NULL,17389,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'4631afb4-5070-441c-8577-a4a546362f3c',NULL,'0',0),('7e3ee10c-6a7a-4ef9-81db-b447421629d0','2016-08-08',NULL,135,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'bccdfffa-31da-4bc7-b7ba-6314936cac66',NULL,'0',0),('7e469942-253e-4f0f-980c-76ea35d71944','2016-08-08',NULL,5940,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'2b63d0e6-50cd-434f-a88c-dc2c40d3f1f0',NULL,'0',0),('7e492d0a-62df-4c8d-81f4-87fed56c4b7a','2016-08-08',NULL,2070,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'fcc00617-3270-499f-abf0-3a18d5305c2e',NULL,'0',0),('7edc67dd-e254-4985-b7f2-0d0ef3ab5db5','2016-08-08',NULL,9056,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'a2cf4c47-125c-4e86-b578-9eb32c918cdc',NULL,'0',0),('7edd159a-bab2-43ca-a4c1-d29cf93bbbfd','2016-08-08',NULL,1293,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'433efd3b-65e9-4918-9b26-586aabdf8b9c',NULL,'0',0),('7ee9a945-a85c-435b-8eda-192eef0bb8a3','2016-08-08',NULL,7633,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'4f6f1a5c-8c63-4398-a1a7-d3fca7a0c400',NULL,'0',0),('7f01e80b-f5d5-494e-af23-e0bfc357bfd9','2016-08-08',NULL,11179,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'785f325c-93cd-4e3f-833a-7b448482f285',NULL,'0',0),('7f0dfeb1-d935-4af5-9308-a4abf2270941','2016-08-08',NULL,12668,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'f499b6ec-2027-4ae3-a9f8-7d750045122f',NULL,'0',0),('7f3ccaee-92cb-46d2-8f25-663d4288350b','2016-08-08',NULL,9314,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'1706fcfd-6788-4c63-a45b-bddb2c7da5a0',NULL,'0',0),('7f473ef2-89b2-41a2-999c-ad76bdbb1847','2016-08-08',NULL,9625,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'bc3117b5-90f1-40fa-bc79-119f1708f934',NULL,'0',0),('7f4ca26e-4c10-40c4-a89f-04c3da317aa6','2016-08-08',NULL,6469,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'74a69361-60e9-4af8-8765-eac724021451',NULL,'0',0),('7f8ca1ca-cf07-480e-93d2-09e5b3b0290d','2016-08-08',NULL,444,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'28cba0ec-d341-4e33-abaa-878a82bcd5c9',NULL,'0',0),('7fb5d182-88b8-4a6e-831c-c6dfd9eeb8ae','2016-08-08',NULL,49163,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'ffd1c689-325e-4455-8816-ce31814996c8',NULL,'0',0),('7fbd3faa-3316-496f-9b8b-21e8c41b5051','2016-08-08',NULL,432,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'4b062d45-5166-4864-88fa-3b8fe398a933',NULL,'0',0),('7fef77d0-6b3b-41ac-b994-244023d4c865','2016-08-08',NULL,2203,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'48196acf-26db-4a60-b7f0-7377d408d8c4',NULL,'0',0),('7ffa37af-3743-4091-9e10-5e22a9c193f5','2016-08-08',NULL,22275,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'4b4313d1-4ec1-49cc-b023-a175c2696263',NULL,'0',0),('80148011-9508-4cee-82ce-b4bc17d6f09f','2016-08-08',NULL,3510,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'9b1fd8eb-8c89-457d-ac6a-93c39ab1b8fd',NULL,'0',0),('802220f4-ee0f-459f-9d76-8f8794cdca4f','2016-08-08',NULL,7894,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'36a7ee3c-cac2-47da-8a38-3fd1b2fe5e5c',NULL,'0',0),('805b4082-fb37-4016-a30f-a98c4b56ac5f','2016-08-08',NULL,7776,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'fff81e0f-ed13-4065-8c65-36a9ac7c72fe',NULL,'0',0),('80614543-7e17-4376-a614-e481f16c4c74','2016-08-08',NULL,3933,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'75b4abba-6596-457a-af5e-c2e9d257c28c',NULL,'0',0),('806ddc24-f740-4e89-adae-0d367678bec1','2016-08-08',NULL,29756,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'35732a5c-88cb-4012-8712-4a60bf5628eb',NULL,'0',0),('80777c23-5c7c-49e1-b15a-ada55d446f20','2016-08-08',NULL,18596,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'6076d39a-51dc-4d7f-b59b-8a81bd1e601d',NULL,'0',0),('80f385a2-75d7-4567-957b-8b5b8cf359d6','2016-08-08',NULL,8250,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'0bd09974-0132-4a30-98ae-ac6d2f95cb0b',NULL,'0',0),('810c0bfd-fec6-4d68-9148-817b1bf6ccc1','2016-08-08',NULL,32637,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'751d2111-d008-4523-b8a2-153b5d85c7a1',NULL,'0',0),('8145d7b5-0ba1-48a6-b1c4-af230bc7b91c','2016-08-08',NULL,29350,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'32dbb41e-2878-40ad-a4f2-31b8b34400ed',NULL,'0',0),('815bd125-6af7-4795-a4bc-f66d4c2e1d82','2016-08-08',NULL,987,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'f1ff98e2-3203-49de-a537-0e22f16d8e3f',NULL,'0',0),('815e06a0-c413-4629-b285-7ba1f19aa383','2016-08-08',NULL,29304,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'01b8a9fa-5733-4ee8-8c08-b20e26e5c167',NULL,'0',0),('81786c0d-9c97-4501-b94e-f2897bdca797','2016-08-08',NULL,949,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'b48edec6-7d45-4685-ac79-67d694fe6981',NULL,'0',0),('8187543d-2e09-4fd4-98f9-5c58783f163d','2016-08-08',NULL,4399,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'94e09848-c3cc-4302-89eb-25b1e4a7880d',NULL,'0',0),('819763d5-78f4-4990-9614-c8c19315ae58','2016-08-08',NULL,26311,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'8a47259e-e3d5-461c-bc20-184270f4f11b',NULL,'0',0),('81cb4629-5813-48d4-aaf6-ab442aba55bb','2016-08-08',NULL,2459,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'f50477dc-a0f6-4829-98bb-f376a115b3b7',NULL,'0',0),('81d10f37-7862-4577-aadd-0125200a254d','2016-08-08',NULL,900,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'0c22a71d-831d-4f91-9006-aac28244e489',NULL,'0',0),('81f1c2cd-17f1-4741-ad98-eb740e15e5b2','2016-08-08',NULL,297,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'f2d7c2ca-54a3-423f-9499-0f06333a9910',NULL,'0',0),('81f80ee3-c705-433e-9723-bcda0229d990','2016-08-08',NULL,14579,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'63c4e0ef-6ebc-464d-adf9-1d5dce38473b',NULL,'0',0),('82777f88-5f75-4348-aec0-c26d738d7698','2016-08-08',NULL,19536,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'0f3778f1-cf32-45cb-b73a-701184d39bb8',NULL,'0',0),('82845065-549b-483b-aaf6-cd3089185591','2016-08-08',NULL,8073,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'4eb68a82-560b-41b0-bdd7-3c7bb9609939',NULL,'0',0),('828e74b2-82cf-448e-af81-b04b815b0238','2016-08-08',NULL,44550,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'26cc436a-c594-409c-8f35-c0cfbfd82a4c',NULL,'0',0),('8292680e-6f82-4f8d-94a9-5f31a8f76951','2016-08-08',NULL,36685,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'78e8bf51-ff4b-40af-b5af-8649051bc388',NULL,'0',0),('82a6b2f4-7189-489c-9441-810656e46f4c','2016-08-08',NULL,880,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'554e6acf-fe8b-4b05-ae61-78459743c39d',NULL,'0',0),('82c0b7fd-8cac-43d9-aa59-44939d0f8904','2016-08-08',NULL,6210,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'29aaecee-60e6-40ca-813f-91cd2156c033',NULL,'0',0),('830ff6e3-69ed-4c3b-a896-64b90c958cec','2016-08-08',NULL,2857,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'46d3047b-e587-4be6-8282-58ecba0fed31',NULL,'0',0),('83112ba5-f370-455d-82d3-c4fd608e036f','2016-08-08',NULL,0,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e9d0f8af-54e1-49f9-b5e2-a19e42f0e05c',NULL,'0',0),('831284b0-7806-4816-b748-17925907008f','2016-08-08',NULL,130,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c5ac1eb3-cb9b-4134-91db-a271a8e1b43e',NULL,'0',0),('831950a4-9f58-4764-8c4f-826edfb65c12','2016-08-08',NULL,1296,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e6ca4f92-bec8-459a-85ca-9d71e75bf137',NULL,'0',0),('8351a081-2376-4fd2-831a-60958e51e6b7','2016-08-08',NULL,19536,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'24e58c5e-7f82-47ed-a56d-d384a29515ec',NULL,'0',0),('83567b4d-9288-422e-a3a6-a42137d91c85','2016-08-08',NULL,17761,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'7cb2bdf0-f0c3-4588-9798-541920f448a3',NULL,'0',0),('83992702-46f5-48ae-ad54-bc250e9af84d','2016-08-08',NULL,39848,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e2cf3f60-28f2-452a-b3f4-19b7dbb4caec',NULL,'0',0),('83adbd76-8495-47d9-9793-6bb5aade6967','2016-08-08',NULL,53460,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'cb3ed9d0-cf8d-462a-9583-2f04218d69dc',NULL,'0',0),('83c9ef31-a3e3-426b-8c36-62ddf2e6ee67','2016-08-08',NULL,219003,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'64c9411a-f84d-48e2-9278-9f32f2be4827',NULL,'0',0),('83d0749b-00f8-417a-8d83-affffc658834','2016-08-08',NULL,4269,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'43afb9fc-1f57-4e00-a93b-bf51de20e7e1',NULL,'0',0),('840fbe7c-6de4-43b7-af38-6339293e396a','2016-08-08',NULL,3424,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'ca67dff0-fdf8-416f-a4eb-ea18fc42d407',NULL,'0',0),('841b9671-20f0-4dce-8441-a35fc72842fe','2016-08-08',NULL,1643,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'a6f0a666-72ea-4f60-99c4-42d18487b833',NULL,'0',0),('8428230e-8d1f-404c-beac-670a565e84bd','2016-08-08',NULL,2025,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'ee3f7798-3a92-4dae-92c4-804317e4f8bc',NULL,'0',0),('8434b130-567e-4646-b108-55fa59364ec9','2016-08-08',NULL,15121,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'44be9244-8a08-401b-967d-785cc71d6a3a',NULL,'0',0),('844ac926-338c-40d2-9e1a-f19af75e54f5','2016-08-08',NULL,17495,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'90c07d25-db37-4060-ba5a-6e5af7dfdf4f',NULL,'0',0),('844d9e08-f05a-4651-9b3f-e98e2e571dc5','2016-08-08',NULL,1080,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e6ca4f92-bec8-459a-85ca-9d71e75bf137',NULL,'0',0),('84e019ce-9763-49d4-87d1-7d228e7210a9','2016-08-08',NULL,28463,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'162da676-a464-47e3-b74f-98c12165e8c3',NULL,'0',0),('84ed0401-16cc-4565-9926-266abb1eaa18','2016-08-08',NULL,807,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'964743e6-56d8-49bd-8441-67ac6fa3b795',NULL,'0',0),('85292311-5eef-4575-8832-4b7e8b5c5761','2016-08-08',NULL,8279,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'b39aaef8-7805-4f05-9381-afec13f53977',NULL,'0',0),('853a14c7-d60b-414a-a2f3-f52ff498d562','2016-08-08',NULL,648,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'5794b252-93ea-4cee-aa14-dbc63204ecfa',NULL,'0',0),('854e969c-4147-4cff-8f58-095dbcdc073d','2016-08-08',NULL,16818,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'6977de00-516c-4a83-bb4a-c62cdf78c088',NULL,'0',0),('856973be-d9a5-4f58-92f6-7e49281fdd04','2016-08-08',NULL,8997,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'f91c5830-2808-4e6e-9c23-320a015d0308',NULL,'0',0),('85a5257e-7f78-49a3-bbeb-e5f1cb62a908','2016-08-08',NULL,45161,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'0aeeef06-348c-4b67-8750-5101f00a3f2c',NULL,'0',0),('86085912-ec52-4ffd-9e9d-bcc1f06f1bf8','2016-08-08',NULL,17078,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e4226aff-9dc3-4214-bdd7-3db1100093b4',NULL,'0',0),('8608e555-64e2-46ba-9acd-3df005d97703','2016-08-08',NULL,4125,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'626b88e8-5e08-437b-b5e9-649a410fac46',NULL,'0',0),('86162a85-8c5a-4b3a-978d-5c125cc64825','2016-08-08',NULL,64152,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'cb3ed9d0-cf8d-462a-9583-2f04218d69dc',NULL,'0',0),('861bff62-9fca-410c-8711-3b3d03ed5574','2016-08-08',NULL,467,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'46033846-68ce-4db7-904d-f882dfda42ff',NULL,'0',0),('869e6f12-0358-4c10-b994-b5356ef6490d','2016-08-08',NULL,1944,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'25d4db4a-715f-4561-9441-06da16bf5f7a',NULL,'0',0),('86a58d06-fa57-4c9c-9d7e-3750c3332b44','2016-08-08',NULL,8863,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'37cdc631-a446-477e-b477-5f6d3568add5',NULL,'0',0),('86ed9b94-92a4-4534-8b97-58ecd170f944','2016-08-08',NULL,20394,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'9bb8e3e3-3b08-411a-a7e6-43148c5cc4f6',NULL,'0',0),('8707fece-4242-4bab-88bc-f3d5ad4197a9','2016-08-08',NULL,1012,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'723ccfad-6157-4421-9647-3aa8fc6d4ada',NULL,'0',0),('872bed1c-fbf2-440f-af44-c66e96b1ac95','2016-08-08',NULL,2106,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'ca2e5c36-4bbe-4c04-a356-e9ca17e4cc71',NULL,'0',0),('87366531-ccaf-4271-ad6a-78851c37215c','2016-08-08',NULL,1620,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'69848a12-92b1-43a8-a17a-7508e5065415',NULL,'0',0),('874caa2b-2fc9-485c-af88-213189e346b5','2016-08-08',NULL,45359,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'94d89cc9-8269-4c90-b501-bb4f85d23f81',NULL,'0',0),('8771d285-8467-4221-a05b-fe57f434ac0c','2016-08-08',NULL,8073,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'6cbf8685-c3bc-4bd3-9dfe-9edf3a0eb35d',NULL,'0',0),('87891456-a164-4a0a-b968-bc5403dc29a7','2016-08-08',NULL,1863,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'eb3f3543-7d78-4cf7-b935-009353107611',NULL,'0',0),('8793db4b-9463-4b16-9cfe-8239342f34b9','2016-08-08',NULL,35640,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'26cc436a-c594-409c-8f35-c0cfbfd82a4c',NULL,'0',0),('87a6e62c-fc6d-4943-93a3-44daf568903a','2016-08-08',NULL,178200,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'bbcc0daf-3f4a-487a-b797-d6b2552c97b1',NULL,'0',0),('87e70057-2440-4009-8ece-19dd737b3591','2016-08-08',NULL,323,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'4effe726-17dd-4133-a179-cd6415fba98e',NULL,'0',0),('87ea80f4-b1e7-42a2-965e-5b96ac60b118','2016-08-08',NULL,870,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'7445ba41-b22b-43b4-9430-6e085dc47bb0',NULL,'0',0),('87ee85e4-9e0b-4c96-b336-197744126e67','2016-08-08',NULL,17741,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'2816962b-cceb-4941-b477-977ba800e72d',NULL,'0',0),('87f5ca31-0416-479c-8c7d-90cef4c236bb','2016-08-08',NULL,1386,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'06e325af-29b7-44d2-a87c-5bbe68355d45',NULL,'0',0),('87f6cc58-650c-42b4-a3d9-9e1f78f193cb','2016-08-08',NULL,338,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'87c22b7c-7853-4de3-9c4a-8fa1d955ce8d',NULL,'0',0),('881b1f28-1eae-41e3-bc88-4031bc9c3cf1','2016-08-08',NULL,3780,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'01a8e63d-6b82-431c-b434-26bce2e551d1',NULL,'0',0),('88354e0b-2340-4728-bd91-ded6b7df2267','2016-08-08',NULL,7128,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'1055232b-f75f-432f-92fc-d252a55af5f1',NULL,'0',0),('885824a2-a74a-4356-98a4-821d738ddc25','2016-08-08',NULL,33751,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'34cb8dc5-05db-4754-a6f0-753c331fcbe7',NULL,'0',0),('8861da19-af16-498c-b152-efa6d92364b5','2016-08-08',NULL,685,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'f22d2038-bf3b-4868-bdfc-c963a6e5c5ec',NULL,'0',0),('8867ad98-fd18-45ef-b697-405c1e7ccd4a','2016-08-08',NULL,2699,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'99d42967-f9d7-43d6-8667-d98b9f3d5944',NULL,'0',0),('887b3eb0-63fb-4f26-99b9-b0868fe5dc51','2016-08-08',NULL,6831,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c8d40fe1-4615-48ca-84ac-2a08faa62232',NULL,'0',0),('889611d3-ba4b-4946-8f9d-8cfda506ac27','2016-08-08',NULL,1242,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'433efd3b-65e9-4918-9b26-586aabdf8b9c',NULL,'0',0),('88ad5a68-9136-4c37-86df-5da78e326521','2016-08-08',NULL,39365,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'2a3c9db2-6252-46a3-a3fe-57523bd96c01',NULL,'0',0),('88adfdfc-160a-4e23-b079-ab410d743361','2016-08-08',NULL,44022,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'78e8bf51-ff4b-40af-b5af-8649051bc388',NULL,'0',0),('88b065a3-612a-4634-85d1-89e1dfae332d','2016-08-08',NULL,53922,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'86177d45-c973-47b6-8f6c-8118612b293c',NULL,'0',0),('88b503de-b861-4a69-80fb-de8754567671','2016-08-08',NULL,1147,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'8c0032ee-f608-456f-8986-850db19c98c2',NULL,'0',0),('88bfe90b-a2d8-4122-97f1-3714c7853b3b','2016-08-08',NULL,26928,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'0f8b2430-75d7-49f2-bea0-ba53641982b3',NULL,'0',0),('89097ba8-a024-4f91-a749-6c17f37b0053','2016-08-08',NULL,1296,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'528ead48-3584-468c-aaa1-5484a33230f7',NULL,'0',0),('891424d7-b711-4670-93ca-46585bbfee40','2016-08-08',NULL,216000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'a8e411d5-e8c0-4648-9ca7-bbe90db1f4a7',NULL,'0',0),('8916325a-4de8-4b4c-9ae6-fc4f96a0e11d','2016-08-08',NULL,343,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'35ab31ab-55d9-4b61-97e8-fc6b718fd265',NULL,'0',0),('89361e6e-2dca-4d64-8cb4-46f91d6c61b6','2016-08-08',NULL,29040,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'fab5103b-073d-4952-8280-017ff9faed93',NULL,'0',0),('89c92bbb-31ae-417b-9a41-70a93d77dc5c','2016-08-08',NULL,4348,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'eed89e3a-292f-40c0-9d8d-f14085205184',NULL,'0',0),('89e41743-b129-40a3-b069-05487b016490','2016-08-08',NULL,37950,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'1f82dfc0-8285-4c28-88b4-175234347c5d',NULL,'0',0),('8a274310-550c-4f01-860a-5f2b52b2734f','2016-08-08',NULL,29728,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'6b0abda0-9adc-409b-94a3-e7b6723c4be3',NULL,'0',0),('8a8c84bc-b857-4cf2-be90-ae00c4bf6dbe','2016-08-08',NULL,32414,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'4e196243-c077-49e7-9ff6-b6d188a9f10a',NULL,'0',0),('8a94bdad-b9cb-4429-a00d-3f120c8897ab','2016-08-08',NULL,2587,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'a8138880-4276-4f9c-91c8-2a67243b75e5',NULL,'0',0),('8a9b5215-23ae-4fa1-b06b-ed0eddb0b11c','2016-08-08',NULL,1350,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e6ca4f92-bec8-459a-85ca-9d71e75bf137',NULL,'0',0),('8aa19f07-9937-4b95-8dd5-2675f1ffde22','2016-08-08',NULL,1452,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'d395d475-8136-4cf8-a162-5c9420acc2ff',NULL,'0',0),('8aadaf79-59ac-41eb-b0e9-e08b5735a702','2016-08-08',NULL,57716,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'7867372a-5231-4c40-be88-92a77ce74340',NULL,'0',0),('8acf063b-101c-40ad-a53d-3c7f5e4372a6','2016-08-08',NULL,285,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'d8f244aa-5e52-470d-813e-9d856a95c577',NULL,'0',0),('8ad1394c-3bb4-4f7d-acd4-1ccc84e0b258','2016-08-08',NULL,569,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'9b30e01a-1f13-4cb2-a30b-3545cf7e8fbc',NULL,'0',0),('8ade2464-3ca1-4d6a-955c-4c3db361a951','2016-08-08',NULL,2200,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'f96599c9-4abc-494d-b9e1-5a95e9d04e73',NULL,'0',0),('8af1a390-a546-4c2b-b1ca-095406317083','2016-08-08',NULL,2483,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'a8138880-4276-4f9c-91c8-2a67243b75e5',NULL,'0',0),('8b058ba6-782d-4546-ab12-93207a56ec8b','2016-08-08',NULL,23597,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c770feb5-f73f-4dda-868b-5577dbb125aa',NULL,'0',0),('8b2d4ae0-1802-4ad4-9308-4a4f1fd05aa5','2016-08-08',NULL,3882,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'08a80cf4-0ef9-48d1-a79c-edd714b170c0',NULL,'0',0),('8b321602-94cd-4dbb-80e5-90d97363e848','2016-08-08',NULL,15137,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'3c36cb75-c784-483d-a044-42bdd241254a',NULL,'0',0),('8b5959e3-d20b-4ddb-99da-c145c89f6ba8','2016-08-08',NULL,1293,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'742a55d2-b11b-481c-8cc2-20d85daac577',NULL,'0',0),('8b980a3c-9d38-41f7-9321-404b2da9b6c1','2016-08-08',NULL,11880,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'86e73666-b52c-4b2f-95cd-dca03265be97',NULL,'0',0),('8bd5aebf-e518-41c5-889e-d766d1f8552c','2016-08-08',NULL,2717,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'33001ff1-5e76-4d77-9454-f720b61534b9',NULL,'0',0),('8be219c7-c40d-4846-b55d-f48912f61fbe','2016-08-08',NULL,12110,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'3c36cb75-c784-483d-a044-42bdd241254a',NULL,'0',0),('8c3905b2-10eb-45d7-8d57-3e00aa003974','2016-08-08',NULL,15774,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'294e21e2-5410-4522-b947-588746f1293d',NULL,'0',0),('8c3b5ac6-eac1-4d46-996b-febecfcefd61','2016-08-08',NULL,23925,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'32c00f0f-3f41-4b6f-b511-cc713e4a0376',NULL,'0',0),('8c71b32e-fc4b-480f-b288-0025514125d8','2016-08-08',NULL,25212,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'28135593-39cf-4a2a-aee4-706f7ab6fddf',NULL,'0',0),('8c7266fb-1bdc-4711-a0cc-51b82d9a9c19','2016-08-08',NULL,5338,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'62d86106-b325-4359-b9ec-268e745553ed',NULL,'0',0),('8c9470e2-2f55-4787-96e2-5d3908325ca4','2016-08-08',NULL,19562,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'7fddbe26-7a42-4719-9fda-115517d449f0',NULL,'0',0),('8cad7597-c644-435a-8722-e7134d1318f3','2016-08-08',NULL,5278,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'bf57047a-a2cd-4f22-9c1b-b0a8983fc974',NULL,'0',0),('8d072deb-404b-4d95-810e-fd9a0a231e30','2016-08-08',NULL,3824,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e7e27f01-f901-4fa0-88df-2ff7d8eb9d26',NULL,'0',0),('8db06501-d65e-4054-b758-9780a500de08','2016-08-08',NULL,388,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'02537a79-aa55-4a81-8b22-f16f4cf0071e',NULL,'0',0),('8dbb2e1b-63d7-4390-884b-0d6b1bc0c9c7','2016-08-08',NULL,16145,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e5f22872-81b5-4b95-9918-8b1d9a53c654',NULL,'0',0),('8dc578e2-4a53-414c-bcc9-a391c97d1a99','2016-08-08',NULL,6727,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'6cbf8685-c3bc-4bd3-9dfe-9edf3a0eb35d',NULL,'0',0),('8dd54c2b-b75b-4e9a-9593-6f19c800054a','2016-08-08',NULL,15525,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'eb392a11-14b8-4e54-a103-6ca7b5fcfa1c',NULL,'0',0),('8dd65ade-7f40-4df6-a561-8edccdbba567','2016-08-08',NULL,22540,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'602bb8b3-b9ac-470b-b519-f767d37ff595',NULL,'0',0),('8dff4072-baa2-4af5-9345-fc0f0bf22f5a','2016-08-08',NULL,27001,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'34cb8dc5-05db-4754-a6f0-753c331fcbe7',NULL,'0',0),('8e062111-a95e-4acf-b0b4-c45dfa27cb08','2016-08-08',NULL,30360,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'1f82dfc0-8285-4c28-88b4-175234347c5d',NULL,'0',0),('8e56c5f9-d48e-4c03-ae0f-9689f5b85231','2016-08-08',NULL,452,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'a87e543d-44d6-4ce5-8cab-722c673e4b06',NULL,'0',0),('8e7237c4-dd44-42b2-95a3-420fa6af7f17','2016-08-08',NULL,917,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'8c0032ee-f608-456f-8986-850db19c98c2',NULL,'0',0),('8ecd83a2-2e04-4dd5-a52e-47df6a33b547','2016-08-08',NULL,14532,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'3c36cb75-c784-483d-a044-42bdd241254a',NULL,'0',0),('8ee24ce9-d086-40ee-a998-fe6d2c5b30b7','2016-08-08',NULL,2281,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'1c477c16-a1b0-4982-8857-b9b7ee9fb986',NULL,'0',0),('8f51994d-79e0-4cc4-91a5-4862d903ed70','2016-08-08',NULL,19140,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'32c00f0f-3f41-4b6f-b511-cc713e4a0376',NULL,'0',0),('8fbc0068-cb90-4b48-912f-c9fbd9a6db4c','2016-08-08',NULL,980,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'0a9a2f8d-36a7-45ea-9e2a-67b9fa59da98',NULL,'0',0),('8ffbf06b-87c5-45c9-99aa-5bf2cd03edc7','2016-08-08',NULL,24668,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'4e6b8e5d-2296-42a4-9cfc-35b0907fcdd1',NULL,'0',0),('9037853f-e6de-48ff-93f6-bcb68e0e7cbe','2016-08-08',NULL,363,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'f5509dde-0cea-4281-9079-1dcf6a033ee2',NULL,'0',0),('907a679a-5aba-4198-a4d9-495221096cce','2016-08-08',NULL,3287,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'ca67dff0-fdf8-416f-a4eb-ea18fc42d407',NULL,'0',0),('907f5139-e7d3-418d-b77f-9da4b2a9c13b','2016-08-08',NULL,2758,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'5c293368-1897-4eb3-9915-e1cf6351d918',NULL,'0',0),('90c420d6-146c-4a69-8157-a4de229a7515','2016-08-08',NULL,33696,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'db75c674-4ed2-44ce-bcd8-e1d3a51625fa',NULL,'0',0),('90ebc144-83d3-4f72-847c-4af4422bff88','2016-08-08',NULL,6210,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'ed875474-f3f2-4d79-b94f-9db4b3fe5ad0',NULL,'0',0),('90ee3527-10e5-4b93-b304-7d2e036bc5ff','2016-08-08',NULL,13464,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'5598b1d3-8885-4b91-a415-8eae6cce5b33',NULL,'0',0),('9147184b-84d3-42ac-83b7-00eccb2280f7','2016-08-08',NULL,1459,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'3fc3e6ff-2011-4022-bd3a-6c826cbc2411',NULL,'0',0),('9172e30b-8149-4d78-938e-a1572dbe59b7','2016-08-08',NULL,3882,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'29c26422-a1af-4fad-a14f-c5cf4550671e',NULL,'0',0),('917ef5cc-869c-4fc7-8e00-4553e9129b48','2016-08-08',NULL,1242,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'d37f5f6d-53be-40ee-85c6-4edb83ce65c7',NULL,'0',0),('918e7a3c-7075-4167-8cf7-d30a02e5449f','2016-08-08',NULL,10095,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'61bb5f10-9e56-4152-b8ee-a08b606f4e4a',NULL,'0',0),('92294db4-7b94-4b24-9964-966cc5e67cf9','2016-08-08',NULL,26771,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'59216eee-bf00-4692-950c-2cf34e629738',NULL,'0',0),('92315095-6132-4124-8016-9f220b7175e6','2016-08-08',NULL,271,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'dcd20c6e-35f0-49f4-9d9d-d3ec1f966159',NULL,'0',0),('9251978b-810f-43cd-ae77-14ed7015ccbd','2016-08-08',NULL,9056,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'a95f63f1-1949-4f90-8e3d-ff5b4e7e961a',NULL,'0',0),('928611f0-0e78-4db4-9140-8f38ef8a113c','2016-08-08',NULL,2173,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'0d3e03de-e3a6-41f9-99f0-f53f1764c3fd',NULL,'0',0),('92872932-1669-40bb-8314-d93528bfe394','2016-08-08',NULL,34914,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'d60f5ae5-e8bf-42ca-b6e9-d6c8d818b875',NULL,'0',0),('928bb3a2-d706-4b2f-bdcf-480033a94fa1','2016-08-08',NULL,62172,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'0b7c70bb-e354-4250-8931-5fe10e2a78f0',NULL,'0',0),('92f8dd8e-97a3-4582-bf84-c65b4bdcb972','2016-08-08',NULL,4537,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'01a8e63d-6b82-431c-b434-26bce2e551d1',NULL,'0',0),('937fc468-9e1e-4151-b61e-b238ac74a6b6','2016-08-08',NULL,11902,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'5b57adca-ba56-4bca-8f04-28e81565e91e',NULL,'0',0),('93c8707b-611b-4fc2-8a2f-63d4a8e9ef93','2016-08-08',NULL,2541,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'3682c42c-eff3-4424-a820-ddcff5326572',NULL,'0',0),('93cd838b-3105-4295-bf0b-f050a0f3e339','2016-08-08',NULL,366,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'d81b8cfc-b9de-4275-bc14-d29dccbd0ed5',NULL,'0',0),('93deb4da-ab40-431d-a238-33b82374da10','2016-08-08',NULL,271,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'87c22b7c-7853-4de3-9c4a-8fa1d955ce8d',NULL,'0',0),('93fcbe99-de79-4a54-8d7b-cb6a11cc69b0','2016-08-08',NULL,990,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'979b84a9-1298-4b81-a180-eca8f1d01982',NULL,'0',0),('94208a70-4f25-4ce8-a816-312e166fb208','2016-08-08',NULL,12755,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'9a2c13fd-a142-46ec-8551-4bc86e1a7626',NULL,'0',0),('94443f2e-51f7-4857-b664-de69b4a95b08','2016-08-08',NULL,1162,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e3b20e37-4d91-47d4-8558-99491bb737fd',NULL,'0',0),('945a7463-4d9a-46ba-adb3-c0fc80bc629c','2016-08-08',NULL,1293,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'7c3e6810-d2a3-491f-aaaa-df23bc921154',NULL,'0',0),('9460c704-769b-4898-9621-1e5712c34a09','2016-08-08',NULL,216,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'8a484956-eb83-4a2e-8591-c66825edb086',NULL,'0',0),('9465128d-6546-4a4d-89c8-4fedeca99230','2016-08-08',NULL,2295,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'48196acf-26db-4a60-b7f0-7377d408d8c4',NULL,'0',0),('9483ecca-8d9b-4866-a00b-dd1ea163fe26','2016-08-08',NULL,540,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'475990d7-a7ee-46c3-9ed3-ec1079542117',NULL,'0',0),('94a36037-4ecb-463e-9df7-3f57088b2508','2016-08-08',NULL,12528,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'b8eed9d5-a538-4c6e-ba3a-b4c05666d0af',NULL,'0',0),('94a975ca-6908-4732-b34b-e1dbcffcaac8','2016-08-08',NULL,7776,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'5abe998d-42be-49d3-a2dd-2a2aff059473',NULL,'0',0),('94c2fce5-b9a6-4900-9d94-cc555ef7b62d','2016-08-08',NULL,8073,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e8c6ebc2-4883-4850-b365-b2875c00f158',NULL,'0',0),('94cf5b3b-14d8-4a9f-a1e3-e42d4522b029','2016-08-08',NULL,6459,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'3e700502-6382-4f52-a5df-175e7407dc4c',NULL,'0',0),('94cffd79-9bc2-4046-aa63-d72554878b2e','2016-08-08',NULL,1242,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'7c3e6810-d2a3-491f-aaaa-df23bc921154',NULL,'0',0),('95501296-da9d-4ce0-bf28-2ac927b746ac','2016-08-08',NULL,6521,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'a4dc0839-9fda-45ca-ac7b-7c510434d303',NULL,'0',0),('955a5924-58cc-4f9d-ba0a-c03f2c0d5ee2','2016-08-08',NULL,1350,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'69a092a5-158d-44df-90c8-025ce8f26d68',NULL,'0',0),('955d25f7-9e7c-4459-87f7-218d554f464b','2016-08-08',NULL,6600,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'79f1c6f1-c0c3-4a62-b7af-12c2618a554e',NULL,'0',0),('95892c38-b9f6-466c-b726-15bca142f8e6','2016-08-08',NULL,756,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'6f464606-9908-4437-ae5f-2949a0547126',NULL,'0',0),('95fe0c0f-ce52-479c-88e5-74c8ba60b7ac','2016-08-08',NULL,26263,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'28135593-39cf-4a2a-aee4-706f7ab6fddf',NULL,'0',0),('9612cb2e-d5dd-4e59-bfbf-62d3f25f1073','2016-08-08',NULL,737,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'b32bbb38-8c60-4dd3-80b7-5d2fedea25d6',NULL,'0',0),('963bc663-f56b-4cd5-b9ed-c0cf814c0cc6','2016-08-08',NULL,29160,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e599645c-8615-4d84-ae88-b7f9e464feb0',NULL,'0',0),('964613a9-a0c1-4336-ab17-03c458ea9cd0','2016-08-08',NULL,3106,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'70792786-2f74-4516-a571-39c9b8a3af9f',NULL,'0',0),('965c2074-331e-4b1c-a66e-7d2b90100790','2016-08-08',NULL,27198,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'751d2111-d008-4523-b8a2-153b5d85c7a1',NULL,'0',0),('968754a9-a303-4512-851e-856609ad3ea3','2016-08-08',NULL,264,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'de64e7fc-bcc1-431f-badd-e1ca9df3aa03',NULL,'0',0),('968eff46-a81c-452c-9c37-adfe337a6186','2016-08-08',NULL,39460,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'3d9d81c3-3528-40a0-a29a-a34658dc8075',NULL,'0',0),('9706e2aa-8468-4dc5-8443-d183d7a3b8fe','2016-08-08',NULL,11902,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'17b97205-0022-4a3d-aa41-9c715ac072dc',NULL,'0',0),('97466a25-f2c0-4d9e-9c4d-b8b635bb9661','2016-08-08',NULL,1320,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'de9a4e71-d7f6-4596-ab92-cc4ca0856feb',NULL,'0',0),('9764e049-9561-46d2-aa98-ae8a51fc15ac','2016-08-08',NULL,27482,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'adc12893-097d-4c38-bbbd-6264ed8bbf3e',NULL,'0',0),('97d71aa7-4eb1-49a4-8207-80243999e1bf','2016-08-08',NULL,5727,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'8769c18d-f776-4753-86a9-2a97811c8a7d',NULL,'0',0),('97e3d462-b916-4700-bc0b-4272eb02ce3a','2016-08-08',NULL,35673,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c6cb3613-3b59-4d93-bad5-cbc307a5b147',NULL,'0',0),('97e6ef91-292a-4770-83c7-2c4e86af105a','2016-08-08',NULL,2500,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'223d66d3-f822-489e-a049-39bbc69145c7',NULL,'0',0),('97fc6bfd-8303-4e34-9a17-c21c92b4f657','2016-08-08',NULL,50921,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'32f72db1-360a-4cc7-b444-c7c1a09b66cd',NULL,'0',0),('980e7642-79ba-42e9-b440-aeef73d290fb','2016-08-08',NULL,8279,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'1177854c-af94-4c6b-b3ef-8545dc0c2a7c',NULL,'0',0),('9811995f-d232-41c5-977a-95a0ccbd44eb','2016-08-08',NULL,3727,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'da9406ae-a2d9-43da-a0f6-a3a6d2bfdc1f',NULL,'0',0),('9820ff85-51c3-475a-8a9b-52e15422eb28','2016-08-08',NULL,19924,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'24c994b8-0141-4be3-a317-5d7260b90367',NULL,'0',0),('982116c3-9ac9-4ced-85cd-1e5c1edda95a','2016-08-08',NULL,18447,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'ee715dd7-b854-4c08-ba5a-17e0b4ac8add',NULL,'0',0),('9846ed5e-b97a-4c2c-b7c9-da7900beda24','2016-08-08',NULL,40986,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'1e266883-c6d2-41d3-8c11-cea3402a4948',NULL,'0',0),('9854bd61-4672-4ce5-b3bd-2c9629d83405','2016-08-08',NULL,810,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'ba451c8c-1999-4ee2-b4da-3e52f18e109a',NULL,'0',0),('987dfd0f-0199-41e3-88ee-66203b464ab4','2016-08-08',NULL,78540,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'4542439b-97fb-4d26-8536-8feeb4dfc137',NULL,'0',0),('98f9d207-7488-45d9-81b3-4697af1dac14','2016-08-08',NULL,248,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c4f5582b-8803-40b9-80b6-ab99209894d5',NULL,'0',0),('98fcd069-b985-43b0-800f-4a34d17bebf8','2016-08-08',NULL,20311,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'9f9deb9f-6bff-441a-8f97-d5caca47ffff',NULL,'0',0),('992b5b95-ff24-4db3-acf8-cb44b34702bf','2016-08-08',NULL,5071,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'5657e79e-8248-418d-8286-45852459a396',NULL,'0',0),('99455c8a-f7bd-4033-b276-6ca57fb7bd96','2016-08-08',NULL,7425,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'5ba92538-5b76-46c0-85cd-870ffb1b9db6',NULL,'0',0),('994672a0-3c4b-4ed2-98d3-91d0a9724731','2016-08-08',NULL,90563,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'eb415c97-7236-4ac9-9a09-944282ea9575',NULL,'0',0),('99b3378e-5423-44a0-a815-31a6b1b89f14','2016-08-08',NULL,9314,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'80b8cfbd-0752-460a-9a21-f5e8554aaacb',NULL,'0',0),('9a3ebac0-0624-4a2d-b1ce-7cd1306a7581','2016-08-08',NULL,11699,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'36f18236-d50a-435e-9869-968e0b2f0025',NULL,'0',0),('9a6b8801-50a8-4994-8fa7-83105e9bbeea','2016-08-08',NULL,19407,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'6c07f9de-da43-4f10-b6df-1fc86d407e83',NULL,'0',0),('9a986359-b3e5-4a9a-9739-3df4642903c8','2016-08-08',NULL,29373,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c2ebfa2f-486d-4784-bb85-8e5524da2ba4',NULL,'0',0),('9a98dd8b-cd90-4337-a852-2cd1405dfffa','2016-08-08',NULL,9935,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'b39aaef8-7805-4f05-9381-afec13f53977',NULL,'0',0),('9ab1e63f-5d6a-4940-afa9-d4e0ff7de27b','2016-08-08',NULL,1552,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'59edbac4-7aae-4008-817d-eeeb02bd28c7',NULL,'0',0),('9ad4ec30-b629-4807-bc9c-8857a5bd3085','2016-08-08',NULL,33419,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'fd445b92-5917-47f7-8fb4-5f4702496e06',NULL,'0',0),('9b66fde0-82e4-4b26-8c64-7d8fe29c5166','2016-08-08',NULL,5940,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'f716a70f-946f-4b3f-9f69-cd8016f608d9',NULL,'0',0),('9b9a5757-b053-4abc-82df-38bea2418e7a','2016-08-08',NULL,24974,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'60b2c200-fffa-4abb-bd81-b0f0a7cfbb2f',NULL,'0',0),('9b9fcff3-d486-42f2-981c-67ba3481c39c','2016-08-08',NULL,48646,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'2cf89940-2aa8-47d1-b496-00aac722bcee',NULL,'0',0),('9ba04b1a-3064-4d48-9bde-434b21efe8fe','2016-08-08',NULL,54395,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'7071cada-b946-433b-bf14-87dd877b3ab1',NULL,'0',0),('9bc3b156-548b-427a-b5d3-84f2bfbacfd1','2016-08-08',NULL,687,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'3484a9b2-c960-4a19-a8fe-5a71bc8d2e74',NULL,'0',0),('9bc965db-2381-4305-ad2c-e838d8e4c663','2016-08-08',NULL,5693,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'9e3c398b-3c45-49a6-bb2a-0367a986a1e6',NULL,'0',0),('9bf6b2e4-8e6d-4442-a9c8-425d10d6392b','2016-08-08',NULL,743,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'17d09027-7f78-4b74-aa2d-4f19102f3abc',NULL,'0',0),('9bf99a45-91b3-4dcd-83a5-86f4a0fc013e','2016-08-08',NULL,23676,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'87cfce04-958b-446e-b8d3-7c6d8f7cc662',NULL,'0',0),('9bfd5ef2-e328-42e2-94a8-1ae83bd3b7bb','2016-08-08',NULL,7425,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'2b63d0e6-50cd-434f-a88c-dc2c40d3f1f0',NULL,'0',0),('9c14e2df-273b-45fc-8d09-65ea7127ad98','2016-08-08',NULL,54193,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'0aeeef06-348c-4b67-8750-5101f00a3f2c',NULL,'0',0),('9c1fbc7a-8315-4925-88a4-eba62976954c','2016-08-08',NULL,73096,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'706f8cc4-f647-4992-87c8-a17a2ec549f2',NULL,'0',0),('9c233bc5-e2e3-4eac-9283-633d179a8992','2016-08-08',NULL,1242,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'742a55d2-b11b-481c-8cc2-20d85daac577',NULL,'0',0),('9c594d59-90b0-4bdf-9b1e-556d3b294bcc','2016-08-08',NULL,944,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'770068c9-eb27-4bfb-b29d-f0ec9fc23d8e',NULL,'0',0),('9c7211ac-ec7e-442f-9ac2-6ef05cfd9ec8','2016-08-08',NULL,1293,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c3c83d79-ff0e-4631-9a67-2cd941c54ce7',NULL,'0',0),('9c77e80b-298f-45c2-bd79-478c5fcbddae','2016-08-08',NULL,9072,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'a0eacb3f-5b0e-4833-b9b5-56ed95c0a9f9',NULL,'0',0),('9c99e85e-ab9e-4187-8243-3d82267e199a','2016-08-08',NULL,11550,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'bc3117b5-90f1-40fa-bc79-119f1708f934',NULL,'0',0),('9ca8f2ed-7d1d-48b5-8319-83c8ea776a8c','2016-08-08',NULL,7245,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'bbecc8a4-1770-4f1a-89e7-5239fea66cb2',NULL,'0',0),('9ce2b041-bdc3-44cc-8504-8e129aa80899','2016-08-08',NULL,58506,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'3dac8d81-16af-4e9b-9f3f-b3cca940035e',NULL,'0',0),('9d13982b-8f7a-433b-8a21-cf60d8a873c1','2016-08-08',NULL,1555,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'a4be3d32-ddb9-4ec1-85d3-74107f1cb9f7',NULL,'0',0),('9d2af090-ff8a-4d26-8f96-957cc9e261ea','2016-08-08',NULL,10764,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'a63f33cd-561e-4f75-8fd8-6784c3716e31',NULL,'0',0),('9d3887af-a52c-44bb-91fa-0ddff587bb59','2016-08-08',NULL,1940,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'59edbac4-7aae-4008-817d-eeeb02bd28c7',NULL,'0',0),('9d5aa701-a5c7-4ccf-86d9-a5a63a3a0b8f','2016-08-08',NULL,17285,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'b0e53c7d-fa19-4d03-8276-5fc5b8bb5973',NULL,'0',0),('9d70b8fc-6420-4098-90e0-13c16509c2b8','2016-08-08',NULL,10350,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'3c4fcbe7-a749-4756-8385-27ec1f53c6ee',NULL,'0',0),('9dfdff6b-f123-4322-9b19-ef450620a0a6','2016-08-08',NULL,20988,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'afdf278b-e323-4208-8a00-0e639c63496f',NULL,'0',0),('9e08832f-8a34-4100-add3-daea905452e1','2016-08-08',NULL,3850,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'10b7b0fa-494c-49b3-bd65-bdef8ad7d293',NULL,'0',0),('9e48d55a-c676-4acc-89a1-40066edac633','2016-08-08',NULL,37224,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'dfe53a5f-f3cd-4930-bf99-2ef553ea9cba',NULL,'0',0),('9e4b920a-1dc3-4cea-a3a6-4e8eae90a34f','2016-08-08',NULL,46700,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'2cf89940-2aa8-47d1-b496-00aac722bcee',NULL,'0',0),('9e590f34-4fa4-4405-89e8-209a205ed54f','2016-08-08',NULL,130,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'5f70495e-f309-4199-a38c-8272f1267a13',NULL,'0',0),('9e6fd149-ea0b-4e4e-bb16-e83adbcd734c','2016-08-08',NULL,442,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'63c478b7-eeb8-4fb7-82c7-2d8fdd37a448',NULL,'0',0),('9e876855-5e8a-476e-8a74-628d61a9eac8','2016-08-08',NULL,3983,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e7e27f01-f901-4fa0-88df-2ff7d8eb9d26',NULL,'0',0),('9eb7acc8-dd73-4eda-956b-22d3aa087719','2016-08-08',NULL,78247,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'05b1a7cd-af33-4b66-97fc-8e799dbb9233',NULL,'0',0),('9f063049-fd12-40fd-b1c7-b7c9800addb4','2016-08-08',NULL,16200,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'d997ed5d-8d3f-4951-8241-9627da3a6683',NULL,'0',0),('9f2c448b-25c6-4f26-9577-504a03ca15f7','2016-08-08',NULL,86940,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'eb415c97-7236-4ac9-9a09-944282ea9575',NULL,'0',0),('9f2efb00-0cf4-42d9-8e9f-abc005bf0849','2016-08-08',NULL,378,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'6f029a46-7aff-4d7d-be04-13e5b1f17e8f',NULL,'0',0),('9f3141d3-bf26-42f5-961e-aee52e9e748b','2016-08-08',NULL,4481,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'5aef0cff-d054-45c2-a26e-98e57f13544b',NULL,'0',0),('9f5baf26-8bd5-4c7f-919a-a212dd5f905b','2016-08-08',NULL,472,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'616d646d-4e53-45c4-a584-f657a6cccb09',NULL,'0',0),('9f957486-21ac-411b-b36a-f2fee9c56f57','2016-08-08',NULL,10925,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'17170adc-b545-44df-98f3-987692f559b4',NULL,'0',0),('9f9714af-3a69-4718-895d-33d2bab0a8ba','2016-08-08',NULL,2717,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c1a2f65d-8640-4296-a54b-aaa1e3d635d0',NULL,'0',0),('9f9871b0-0bf5-48b4-864a-9b3ea446a1c4','2016-08-08',NULL,19440,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'0c4e33f7-256a-4275-a268-cdbf64495451',NULL,'0',0),('9fc69441-4bb6-441c-81fa-cccafa5258c1','2016-08-08',NULL,841,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'3408fa37-27a1-4ba7-aabd-47da2341f48b',NULL,'0',0),('a00ca50e-b44d-4b38-9d13-021d56fe6d9a','2016-08-08',NULL,15654,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'65cd8f3c-3823-4bdb-8c3b-1bc6f0430048',NULL,'0',0),('a02ae99a-9dd8-4a54-89c2-17717a536590','2016-08-08',NULL,64687,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'fd971fe4-4fdc-4eeb-97cb-b7d8f2853c50',NULL,'0',0),('a03afb2d-a4cc-4117-8ee9-74d0579ef6ec','2016-08-08',NULL,40566,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'1f908ff9-e0bb-49db-91f0-d098e5661987',NULL,'0',0),('a051affa-9aaa-45b6-9e61-7545c5b1bcef','2016-08-08',NULL,968,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'964743e6-56d8-49bd-8441-67ac6fa3b795',NULL,'0',0),('a0655278-51af-45f2-8416-c0934eda0d30','2016-08-08',NULL,29205,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'6a109be9-3ad5-4287-ab6f-2300dfbea49c',NULL,'0',0),('a0745bb3-7808-4cc9-b783-d5aa2e7a1aa6','2016-08-08',NULL,17710,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'925acc48-43d4-49b0-869e-d7b5b198de62',NULL,'0',0),('a07732d0-f19e-4f5a-a073-56f74790a4fb','2016-08-08',NULL,32913,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'05ea21d4-1ec4-4d21-a583-dbae13f5afee',NULL,'0',0),('a08e332f-57a8-43a6-bb09-870179c29619','2016-08-08',NULL,206094,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'561e3e8a-72c4-4cc0-9a4e-55af1ee4d97a',NULL,'0',0),('a0a103cd-7ce6-4686-8067-2d63158460f1','2016-08-08',NULL,77715,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'0b7c70bb-e354-4250-8931-5fe10e2a78f0',NULL,'0',0),('a0cbae76-8c57-48c7-9853-1a25e90fcb57','2016-08-08',NULL,51765,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'86177d45-c973-47b6-8f6c-8118612b293c',NULL,'0',0),('a0fe60cd-cab5-4471-b94f-7ffb0b0a9992','2016-08-08',NULL,21780,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c9438eeb-a4e2-4532-a7b2-e7b0aa4aa16b',NULL,'0',0),('a10a8fd4-93ee-44ec-b18c-4c4b98af91eb','2016-08-08',NULL,1953,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'6e98c5ca-3261-495e-89d1-4a46156ca08c',NULL,'0',0),('a112ddc3-86a3-49ac-b0b9-f56611f0f9ca','2016-08-08',NULL,6831,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'d56f271f-0d1f-47d9-a879-5d7dbddbf64c',NULL,'0',0),('a15251a5-5d36-48c3-90d1-f82d8c56fe4a','2016-08-08',NULL,15939,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'24c994b8-0141-4be3-a317-5d7260b90367',NULL,'0',0),('a155f709-863a-43da-8da9-94e7a025bfe9','2016-08-08',NULL,238,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'f7b6a5d2-8409-4f79-90da-be61ea52375f',NULL,'0',0),('a15b9afd-9b84-470e-93e5-2e5b48b63816','2016-08-08',NULL,1562,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'6e98c5ca-3261-495e-89d1-4a46156ca08c',NULL,'0',0),('a1a9845b-9bb5-475e-af4e-d51dba85cd47','2016-08-08',NULL,3466,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'b23d48e6-88f6-4415-a774-824d604613e7',NULL,'0',0),('a1b8b6b2-cc79-4a68-b914-5afbd2803dab','2016-08-08',NULL,14076,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'d1a4f5b8-dda2-4e1b-8d88-f8f5e76c3b7e',NULL,'0',0),('a1e49209-06a6-4df2-8edd-4cef0e14809b','2016-08-08',NULL,33794,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'cc980e92-7d48-44d2-af07-2c9f66675e5a',NULL,'0',0),('a200665b-cffa-4a85-b7df-3de673826ef7','2016-08-08',NULL,8855,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e00d89f5-d632-47da-bf5f-8cf9d7f4be9b',NULL,'0',0),('a21c204f-c279-4ae4-9076-ca187ad4353b','2016-08-08',NULL,972,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'7de23c6c-a740-4950-9dc1-a559453a4ca6',NULL,'0',0),('a2464e39-1dea-4403-8fed-3e95fda7ccb7','2016-08-08',NULL,1940,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'0c87f638-2e75-413d-bd70-c5b89c144b3b',NULL,'0',0),('a2543f36-e119-4118-8037-8d119655f5bd','2016-08-08',NULL,7020,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'b8472f07-a2a4-41c5-b338-e3d5f2b16e39',NULL,'0',0),('a28c4ef1-bf04-4167-a4e6-059f454c5cee','2016-08-08',NULL,7375,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'a51eaf49-7f7f-4e87-a3a2-d0099ca70880',NULL,'0',0),('a29341fe-cf8e-41f8-aa05-afae6b18530b','2016-08-08',NULL,3353,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'672947e3-41dd-4c7f-bf34-824b0dd04ee7',NULL,'0',0),('a2ee3627-2af5-428b-8c27-df263b6d6487','2016-08-08',NULL,675,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'5794b252-93ea-4cee-aa14-dbc63204ecfa',NULL,'0',0),('a2f93577-c4f0-49b7-8b4b-df77f0501ba9','2016-08-08',NULL,350,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'1aa9ec96-e467-4ddb-8397-5f59685a32ed',NULL,'0',0),('a31ff089-f2ac-4041-8572-13ef9ad77e06','2016-08-08',NULL,19499,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'9b8d9856-f332-42c0-8400-ab7318cdd351',NULL,'0',0),('a33bb7d9-5bf3-4dee-b6b9-457509db837c','2016-08-08',NULL,6210,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'60725462-8375-40e5-8b76-2b92291b91a2',NULL,'0',0),('a34f157a-6f16-4733-bba8-b8b6877d0a8a','2016-08-08',NULL,20700,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e49bac38-aa20-42a8-b709-d07fdbde475c',NULL,'0',0),('a36d976b-6efa-48a3-8aaf-b3da7b20979c','2016-08-08',NULL,48386,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'76c588c8-fd4e-460c-bc82-32d0f60eed1a',NULL,'0',0),('a3862430-e3fd-48b7-9d00-78a11248e8f7','2016-08-08',NULL,3493,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'672947e3-41dd-4c7f-bf34-824b0dd04ee7',NULL,'0',0),('a39f149a-f59d-46f1-87d4-7f0f63c39d63','2016-08-08',NULL,29756,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'8b8953f3-3901-4053-86bd-4fe8191e3bad',NULL,'0',0),('a3da8bbd-446e-4baf-8ce0-89983cfdb55d','2016-08-08',NULL,30222,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'30a807fc-2faa-4c65-ab73-4f2f78ae9ced',NULL,'0',0),('a3eb4213-3f37-416f-9257-9a71be5b9131','2016-08-08',NULL,15784,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c98a019a-981b-485b-86e4-7b3cc62d4d27',NULL,'0',0),('a3fa84d6-f21b-49a3-a730-9dd18507d30b','2016-08-08',NULL,100440,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'57eeb061-a4c6-4d90-b970-89facb3f46be',NULL,'0',0),('a404a462-524a-4319-a7bf-b69855d90572','2016-08-08',NULL,18630,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'d5867fc3-708d-4fd8-8b83-49598971cfda',NULL,'0',0),('a4249846-6494-45fb-b9f6-f5bf253c7a21','2016-08-08',NULL,2070,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'1efa96d9-713d-4a0f-be9b-1d681ab2f0e2',NULL,'0',0),('a425ad77-1a07-42ca-b3b8-06622ffb89fd','2016-08-08',NULL,446,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e6c6610d-1978-42a2-8d28-7961a29e41b6',NULL,'0',0),('a4388c22-2907-4787-bda6-363f7d5388bb','2016-08-08',NULL,120528,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'57eeb061-a4c6-4d90-b970-89facb3f46be',NULL,'0',0),('a44eca09-5741-4caf-8c5b-aba94b3caaf4','2016-08-08',NULL,297,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'f7b6a5d2-8409-4f79-90da-be61ea52375f',NULL,'0',0),('a478b301-297b-4ef1-821c-8f5f6f7d86e3','2016-08-08',NULL,4658,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'ec29bc77-685a-40ae-a6fd-2c7f6eecd9f4',NULL,'0',0),('a4acd6d1-c7a3-4a7a-9b73-3219372b65f3','2016-08-08',NULL,9056,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'bbecc8a4-1770-4f1a-89e7-5239fea66cb2',NULL,'0',0),('a512ce52-85da-445a-a9a4-fced971a7cb9','2016-08-08',NULL,9522,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'03ed3ffd-4174-4201-813b-31dd9c4e5793',NULL,'0',0),('a5139c48-4a47-4f3d-9a7c-07aee3c64dee','2016-08-08',NULL,30525,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'5d50e9c0-84d0-4d31-8d02-f3825a3112fe',NULL,'0',0),('a51d1a20-e648-4a23-9c09-1dd7ad9dfc48','2016-08-08',NULL,1836,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'48196acf-26db-4a60-b7f0-7377d408d8c4',NULL,'0',0),('a5242bfb-9781-4caf-80ab-c7fc3eb24ef9','2016-08-08',NULL,5175,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'a576e481-1a6c-4809-b47e-2881bf29e1da',NULL,'0',0),('a5372363-046f-4c3a-9c55-987b33256523','2016-08-08',NULL,1346,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'a75016e6-61e9-4521-8abb-65a4449cdd0b',NULL,'0',0),('a5977b0e-6e66-4e97-8864-f618588e02aa','2016-08-08',NULL,15939,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'6885ead4-766d-4d90-95b6-62b83e0d62f6',NULL,'0',0),('a59e7eca-b248-4f35-ba4a-16cb25482ffe','2016-08-08',NULL,15028,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'8ad9ae17-93e0-49e6-8915-d346b3285e03',NULL,'0',0),('a5fd0a0a-928b-4865-9ccf-ca89d58f758d','2016-08-08',NULL,8073,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'f74b8998-8283-4843-a7d2-8e4ed5978497',NULL,'0',0),('a5fde764-ee8e-450f-8564-0df703920553','2016-08-08',NULL,3271,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e6e9b82a-d5db-47d2-b2c8-d92f49d03713',NULL,'0',0),('a601a3d6-7fa9-4d26-84db-0b9ef5d7cfb6','2016-08-08',NULL,14231,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c9964447-2625-43e3-85ca-67f5ba4e6cfb',NULL,'0',0),('a617f620-f0a0-48d1-a30a-339c654bc7aa','2016-08-08',NULL,25876,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'6c9f3ce2-358a-4b37-8794-43ab3788b58c',NULL,'0',0),('a66d7951-0473-4f92-aa0b-9f6104058578','2016-08-08',NULL,10332,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c247ed0b-33d9-47b9-979c-4577f8b55f05',NULL,'0',0),('a6dc7936-c3a1-4036-85d5-1e989cc0d971','2016-08-08',NULL,1750,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'f584df16-bf95-4599-ad19-78169da7c723',NULL,'0',0),('a6ff82c1-a2f4-4500-8271-883d3a8596f3','2016-08-08',NULL,388,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'dee9470c-6103-48e6-81e5-12b09412553b',NULL,'0',0),('a72edc11-fa9c-4cb8-8dc3-ed5c00a710e5','2016-08-08',NULL,10998,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'01b583c9-c515-4b30-9793-482d0a76f1d2',NULL,'0',0),('a73a529f-0cab-49de-9d2d-7ad1ecd8ef54','2016-08-08',NULL,47355,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'b22ca306-7fd8-43ad-802d-1e6a2207999e',NULL,'0',0),('a79964a0-4b54-4ee7-b417-c5c570496f3e','2016-08-08',NULL,195,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e0850b2e-6108-475c-b8d1-3d94274a563b',NULL,'0',0),('a7acef36-f75f-4ace-8fec-618d297dcb32','2016-08-08',NULL,2587,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'fcc00617-3270-499f-abf0-3a18d5305c2e',NULL,'0',0),('a7cc82ba-0793-4897-838d-f64111d1e34a','2016-08-08',NULL,62100,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'fd971fe4-4fdc-4eeb-97cb-b7d8f2853c50',NULL,'0',0),('a84fb681-5dba-461e-8368-4fd6c2a9f56c','2016-08-08',NULL,1035,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'353c2ac7-a726-4211-a776-43a1d29ba313',NULL,'0',0),('a8527e8a-c529-45b1-8a0f-a4dd8ce8375a','2016-08-08',NULL,540,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'4b062d45-5166-4864-88fa-3b8fe398a933',NULL,'0',0),('a86d4824-6f3c-4bfc-9ee6-5d5a71304d22','2016-08-08',NULL,23975,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'60b2c200-fffa-4abb-bd81-b0f0a7cfbb2f',NULL,'0',0),('a8c1c959-5476-40a0-b06a-b12760325969','2016-08-08',NULL,466,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'dcc86b92-d8d3-47bd-90a7-56deb8051b95',NULL,'0',0),('a8e332b8-3e0e-4352-8bce-440f23312df5','2016-08-08',NULL,12938,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'3c4fcbe7-a749-4756-8385-27ec1f53c6ee',NULL,'0',0),('a9120057-6bec-46eb-99b2-d3e3905fa3ed','2016-08-08',NULL,7503,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'71f37d5f-4a06-4757-9d36-e1691aea628f',NULL,'0',0),('a9223875-1048-4c88-9d75-152d1c5f2e48','2016-08-08',NULL,21217,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'ab8cc7d9-09f9-4d10-b6b2-fe0d97a82111',NULL,'0',0),('a9355d6c-d774-4997-a158-60f1993441af','2016-08-08',NULL,27169,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'4c661b0f-2e20-4d75-9dd6-c2b2a075f136',NULL,'0',0),('a9450913-2807-49b9-a0ab-291de1787514','2016-08-08',NULL,8798,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'acd3b56c-0811-498b-9324-640d56607ef2',NULL,'0',0),('a94b7784-16e2-4c88-ac08-0c0e7f6c3b45','2016-08-08',NULL,3882,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'70792786-2f74-4516-a571-39c9b8a3af9f',NULL,'0',0),('a96a4455-635a-4051-a3cc-d19275d85194','2016-08-08',NULL,15629,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'0f3778f1-cf32-45cb-b73a-701184d39bb8',NULL,'0',0),('a9727842-5e9d-4d6a-948f-5dcb6c68591d','2016-08-08',NULL,297,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'d8f244aa-5e52-470d-813e-9d856a95c577',NULL,'0',0),('a9784e1f-6310-47dc-9386-20d123c76d7a','2016-08-08',NULL,9720,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'7353aa67-3256-4ce2-9d6e-f20ddeb3be76',NULL,'0',0),('a9bce98e-2a0e-4bcb-8e12-174805c31655','2016-08-08',NULL,5175,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'68bc940c-4a69-4656-a72b-7eba9efc6987',NULL,'0',0),('a9da22c3-df35-4345-a324-f1a332ef4aac','2016-08-08',NULL,50708,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'1f908ff9-e0bb-49db-91f0-d098e5661987',NULL,'0',0),('a9e6d4dc-7e50-43ef-a7c2-d0b27bd98759','2016-08-08',NULL,1742,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'d395d475-8136-4cf8-a162-5c9420acc2ff',NULL,'0',0),('aa06926b-1998-4c6f-b8c4-dfbd103039e6','2016-08-08',NULL,16818,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'aaf6a740-abb1-4a7d-b36b-2ecc0738e723',NULL,'0',0),('aa32753b-1927-4b23-a672-43534d12019e','2016-08-08',NULL,4089,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e6e9b82a-d5db-47d2-b2c8-d92f49d03713',NULL,'0',0),('aacdbc30-c84b-4851-9f5b-36d6088b58a5','2016-08-08',NULL,70739,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'f9383cdd-aaf2-472d-ad75-0496e33b5d64',NULL,'0',0),('aafbe7f8-abf3-4b01-85bf-19baf3dbf4e8','2016-08-08',NULL,5300,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'9d42b826-2089-429f-9f97-e686e146bf08',NULL,'0',0),('ab0754ea-37d1-4a28-b542-364869eb5576','2016-08-08',NULL,6210,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'6b42eaba-807c-4697-918d-e5d432bb83f2',NULL,'0',0),('ab222270-70d7-4528-aea9-81cc92abbbc4','2016-08-08',NULL,11220,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'5598b1d3-8885-4b91-a415-8eae6cce5b33',NULL,'0',0),('ab35bbb0-9880-4b97-9ac2-170cfa97902c','2016-08-08',NULL,7425,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'9b45d4b2-297f-4b31-8029-343daa7a39a2',NULL,'0',0),('ab43f2bd-0890-4855-a9da-b903b7ec98d2','2016-08-08',NULL,502,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'8f2016f0-d21e-4d6f-a661-360fd72135c1',NULL,'0',0),('ab484c3c-58dd-4b20-bf1b-13c9d08055e9','2016-08-08',NULL,29728,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'21d79dee-51b7-4840-9a9f-ff7dc3726f21',NULL,'0',0),('aba01c60-62d5-401f-aa4c-a97fbb4530b4','2016-08-08',NULL,16100,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'9e8cc1ec-e2fe-41c1-af4c-ed7aab6c0df7',NULL,'0',0),('abaacc2b-199e-4eba-9f81-c7f6ac58484b','2016-08-08',NULL,16456,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'7d2e8892-f80e-45f9-9a73-56d590bc0e87',NULL,'0',0),('abbf73aa-2604-40d4-9048-d6acd606a3f2','2016-08-08',NULL,9439,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'cb080cf5-be76-4956-bca0-d1da336c171b',NULL,'0',0),('abceffcd-7dbe-403f-9346-cd82f69a7ab3','2016-08-08',NULL,648,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'ba451c8c-1999-4ee2-b4da-3e52f18e109a',NULL,'0',0),('ac050398-b7cc-4338-98c9-a38b6fdd4536','2016-08-08',NULL,432,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'3df8f1c8-101e-4352-8593-030d958186d4',NULL,'0',0),('ac2f6dcd-e8f7-4ed1-be44-74224d0ee5e9','2016-08-08',NULL,835,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'7445ba41-b22b-43b4-9430-6e085dc47bb0',NULL,'0',0),('ac50038e-1ffd-454a-b60e-309efe35cece','2016-08-08',NULL,518,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'2c1f9606-af8f-42ac-ac91-9eb2f322f5d4',NULL,'0',0),('ac82de3a-08ec-4c75-b961-7228a25b7507','2016-08-08',NULL,2483,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'23e015ae-9fe0-4fbd-b73c-782ebe70c2c0',NULL,'0',0),('ac8a2c77-b63f-45bb-bc43-91bc38d23133','2016-08-08',NULL,20493,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e4226aff-9dc3-4214-bdd7-3db1100093b4',NULL,'0',0),('acb3fac1-d528-4924-8ae9-9d7423777781','2016-08-08',NULL,19376,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'baa27c38-f9aa-49a3-8bc4-f63796d77a83',NULL,'0',0),('acbf082e-4381-4a07-bd51-edc217a62455','2016-08-08',NULL,32789,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'25310c3d-2ca0-4dbb-9b8a-7d0c3754b11a',NULL,'0',0),('ad37293c-02ac-4521-91fc-04711e7372e0','2016-08-08',NULL,432,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'b799a494-fbd0-41ad-87bd-6929ceec4043',NULL,'0',0),('adb0e082-a4bc-44d1-99b7-4db7455e4548','2016-08-08',NULL,648,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'2d35744d-b386-411d-88be-1900f1c93469',NULL,'0',0),('add37e3e-14f8-4e42-b81f-4aa80de43b35','2016-08-08',NULL,26235,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'afdf278b-e323-4208-8a00-0e639c63496f',NULL,'0',0),('ade3fc5a-e54c-49bb-8e37-4260cca8f51c','2016-08-08',NULL,1760,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'d62b1240-3a2b-4a40-8db0-5cd165cfa8f3',NULL,'0',0),('ae4bba6e-6b1a-442f-ae52-bc46bb3ff522','2016-08-08',NULL,20570,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'09fb4270-b803-4287-ba6b-6c2d1fa0a2b8',NULL,'0',0),('ae56b075-189b-4c32-8bee-a64b8e1d87c7','2016-08-08',NULL,24841,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'6c9f3ce2-358a-4b37-8794-43ab3788b58c',NULL,'0',0),('ae78fe9e-d94b-41e6-8a61-b49f7941d4cb','2016-08-08',NULL,48600,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'5c2fa992-184b-405e-b219-1041885afd21',NULL,'0',0),('aefa910a-3424-4dd9-80a8-71298f493196','2016-08-08',NULL,15660,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'b8eed9d5-a538-4c6e-ba3a-b4c05666d0af',NULL,'0',0),('af28ba35-5540-4549-923a-8c55dd369cd0','2016-08-08',NULL,2699,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'5790faa7-4875-41cd-be5f-b17b890b1393',NULL,'0',0),('af47d2ec-4b97-46a1-a6a8-7c3e6627b8a7','2016-08-08',NULL,648,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'f9a025ce-bd2b-4ae6-b627-acae3d66bdf1',NULL,'0',0),('af4fb823-7f7d-4288-9f78-60e9b7340deb','2016-08-08',NULL,11902,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'03ed3ffd-4174-4201-813b-31dd9c4e5793',NULL,'0',0),('af565b25-f477-4d78-ba36-8da932a8110f','2016-08-08',NULL,2000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'223d66d3-f822-489e-a049-39bbc69145c7',NULL,'0',0),('af9b8902-93d4-43f3-ac1e-ed2c65837523','2016-08-08',NULL,7425,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'f716a70f-946f-4b3f-9f69-cd8016f608d9',NULL,'0',0),('af9e710d-99fe-45bb-afbc-645993e6888e','2016-08-08',NULL,540,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'5794b252-93ea-4cee-aa14-dbc63204ecfa',NULL,'0',0),('afa0ee71-f6b6-4ef3-a784-0286cdac17fb','2016-08-08',NULL,15629,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'22e4608e-f78b-4604-9dd8-2666b21690c7',NULL,'0',0),('aff0ef83-f93a-4591-aa99-e793edb6d17c','2016-08-08',NULL,1967,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'f50477dc-a0f6-4829-98bb-f376a115b3b7',NULL,'0',0),('aff1b516-4d9d-4445-b01a-a25e3308fb3c','2016-08-08',NULL,35970,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'53f9ec0d-c5a3-46f0-b51b-3a1f0fad63f8',NULL,'0',0),('b069a55f-d5d4-4010-8df1-9ee64849af02','2016-08-08',NULL,147922,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'bcbc9ffe-fb49-4c43-bb91-85ddc9dddb71',NULL,'0',0),('b0a26687-066e-483d-864e-d49f4a128084','2016-08-08',NULL,553,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'63c478b7-eeb8-4fb7-82c7-2d8fdd37a448',NULL,'0',0),('b0aa35c3-565c-47d4-a5f5-d78ca43a4e4f','2016-08-08',NULL,6009,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'2cc86f32-a7e0-4d34-82cd-b434a2b41768',NULL,'0',0),('b0d7a9ed-baa1-4d8f-a19f-2ae82116d867','2016-08-08',NULL,169425,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'f9264f22-8676-4d49-bfc7-cc4f30adbafe',NULL,'0',0),('b0db96bf-7177-4983-acf9-431756da4e5f','2016-08-08',NULL,1688,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'69848a12-92b1-43a8-a17a-7508e5065415',NULL,'0',0),('b0e16df5-17d0-4b7e-8a07-585b21b33f61','2016-08-08',NULL,11340,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'2f49b0a4-86e3-4295-8f55-2fabd91b30f7',NULL,'0',0),('b0e508ab-8261-4eb9-955e-f7a30abcdeac','2016-08-08',NULL,23403,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'f5c029dc-c40e-4c0e-9d89-d00473706b36',NULL,'0',0),('b0f9bf32-22d1-4021-b6ca-8ed700f610cf','2016-08-08',NULL,19748,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'09fb4270-b803-4287-ba6b-6c2d1fa0a2b8',NULL,'0',0),('b107be27-cb6d-46a0-b2ad-e7ea7e65026b','2016-08-08',NULL,25586,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'44218b4c-d4ba-4c94-950e-f905c18d68f2',NULL,'0',0),('b118a27f-0196-46ea-918d-f2b2143e33ee','2016-08-08',NULL,5589,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'dd0751e7-c88c-473e-94eb-955bd6e0ea8b',NULL,'0',0),('b1450eb9-b8f5-40e2-937b-9d47eae8d67a','2016-08-08',NULL,588,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'d9fa83ac-a786-4d41-b318-18c3a8acb8ff',NULL,'0',0),('b15e44f2-e75b-459d-a505-a43dc2c12919','2016-08-08',NULL,14491,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'4631afb4-5070-441c-8577-a4a546362f3c',NULL,'0',0),('b169063c-bd4c-4fae-9553-8be9e45810c7','2016-08-08',NULL,22902,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'adc12893-097d-4c38-bbbd-6264ed8bbf3e',NULL,'0',0),('b19c6146-f8db-4626-8b35-27d219c1ce87','2016-08-08',NULL,712,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'9b30e01a-1f13-4cb2-a30b-3545cf7e8fbc',NULL,'0',0),('b1a0500d-781c-44bd-97c7-be53a68dd84b','2016-08-08',NULL,0,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e9d0f8af-54e1-49f9-b5e2-a19e42f0e05c',NULL,'0',0),('b1aef1a8-2e5d-41bc-9331-c2bd4aa769d2','2016-08-08',NULL,11385,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c9964447-2625-43e3-85ca-67f5ba4e6cfb',NULL,'0',0),('b1d5de41-d217-4cfc-a310-afe9bd993a45','2016-08-08',NULL,1944,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'56df21f7-d44f-473c-9302-a84b3c40b8c4',NULL,'0',0),('b21173c4-3733-4b32-8dc4-7e263eff465b','2016-08-08',NULL,3456,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'d9a62fb7-6ef1-4dd9-893a-0d1fb92ec830',NULL,'0',0),('b218256e-2498-4d58-9e99-be142bfbfec5','2016-08-08',NULL,27556,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'88de4ea2-80d9-4152-91aa-4817f82e8f89',NULL,'0',0),('b21e3047-0399-4256-a46b-c517e926b036','2016-08-08',NULL,10556,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'f499b6ec-2027-4ae3-a9f8-7d750045122f',NULL,'0',0),('b2445478-a477-485b-ae8c-41070e5a551f','2016-08-08',NULL,540,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'715941ea-e398-49a7-b9e2-53d8a5f0baf1',NULL,'0',0),('b2b0848b-7e1d-4a62-8525-ae7c0ea0d663','2016-08-08',NULL,2024,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'152f2e0e-1a2c-417f-82c1-b280460976fd',NULL,'0',0),('b2bf2091-fe8c-4015-8dbe-c66b5737b23d','2016-08-08',NULL,3643,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'665c04ae-578b-4cd8-b1e9-933f12d34994',NULL,'0',0),('b342c26c-77cf-455f-a3f5-968b668a6c7b','2016-08-08',NULL,27428,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'05ea21d4-1ec4-4d21-a583-dbae13f5afee',NULL,'0',0),('b34f370e-1c66-40cf-b45d-b9f2ffa1034a','2016-08-08',NULL,18360,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e80cb4ac-b07e-4600-bae7-a64c2a2f23c1',NULL,'0',0),('b356f88f-45e2-4d8a-8848-b704905832fe','2016-08-08',NULL,1293,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'7819a076-6e2b-40d6-8fb5-82352074c6c5',NULL,'0',0),('b35b768d-6ac7-4729-ac7f-a8dc3d4d271e','2016-08-08',NULL,10998,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'acd3b56c-0811-498b-9324-640d56607ef2',NULL,'0',0),('b35e1b9f-e426-4ab3-bc32-fb1010c9de43','2016-08-08',NULL,8279,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'4f829a87-bbba-452c-968a-7d3c063ec45b',NULL,'0',0),('b39965c1-a247-455f-886b-f7993e4bbc6d','2016-08-08',NULL,29304,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'5d50e9c0-84d0-4d31-8d02-f3825a3112fe',NULL,'0',0),('b3c12e9b-c121-434e-8b56-3060a41ec409','2016-08-08',NULL,32804,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'2a3c9db2-6252-46a3-a3fe-57523bd96c01',NULL,'0',0),('b3ca3cbe-fee9-4b5f-9361-24fe7c74536f','2016-08-08',NULL,453,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'6f029a46-7aff-4d7d-be04-13e5b1f17e8f',NULL,'0',0),('b41ed65a-9c31-4cba-b3d8-14c7c48eecd8','2016-08-08',NULL,19407,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'b83db7ea-3f9a-40c7-9366-8cf56fe62584',NULL,'0',0),('b42f907a-244c-4dca-8593-53cde02ab2eb','2016-08-08',NULL,135540,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'f9264f22-8676-4d49-bfc7-cc4f30adbafe',NULL,'0',0),('b44bcd87-8ba1-4ec3-b69b-48878d21849e','2016-08-08',NULL,16974,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'ab8cc7d9-09f9-4d10-b6b2-fe0d97a82111',NULL,'0',0),('b490c245-66bb-44ab-a100-e65c477d6806','2016-08-08',NULL,3106,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e090d829-4bf3-4c32-9cd8-78d1ef511b84',NULL,'0',0),('b497b7a1-1e5e-4fa8-95d9-fde5fd256ceb','2016-08-08',NULL,310,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'35f2b105-7802-446d-881f-97f5f407a6ef',NULL,'0',0),('b49b5230-2872-4b49-98ae-7fc57fd0b5d2','2016-08-08',NULL,713,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'ec6fa4a1-8d0c-4b8d-b6cb-12fb11f43d7b',NULL,'0',0),('b4db47fb-9f90-43ee-997e-0e99ef5d0de2','2016-08-08',NULL,5693,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c8d40fe1-4615-48ca-84ac-2a08faa62232',NULL,'0',0),('b4ed549b-d88b-413a-b130-847e56610e2b','2016-08-08',NULL,10673,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'be82505d-7012-4894-9797-5de0cbd3c1b8',NULL,'0',0),('b5000481-6e26-40b0-86e9-68ec3ecebe79','2016-08-08',NULL,10930,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e4a44977-647c-44fd-b0d2-e6a3a566288b',NULL,'0',0),('b52661a5-dc86-4a51-8e90-d526604562bc','2016-08-08',NULL,1518,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'ac9cf706-1129-4ec9-98de-35e2e3406708',NULL,'0',0),('b542e4b1-b1a5-422f-a549-7e7a64801a96','2016-08-08',NULL,13455,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e5f22872-81b5-4b95-9918-8b1d9a53c654',NULL,'0',0),('b5478813-5cd0-4850-8266-dcdac47d7149','2016-08-08',NULL,2717,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'52bb3edc-e029-4ced-8e97-2e2afc53a71d',NULL,'0',0),('b5611cf6-7521-49af-8c1b-b668ce5d2e0b','2016-08-08',NULL,39848,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'a98f5afa-f5c0-4922-a065-0d2f5f68001c',NULL,'0',0),('b5fd695a-5efe-453a-8b80-008549fa5c92','2016-08-08',NULL,10479,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'8c2d9e22-6bc0-4525-8c22-3fb3d74077ab',NULL,'0',0),('b6054aed-f1c1-43ec-8dfb-549268b5fe9f','2016-08-08',NULL,29304,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'3bcf2b03-f78d-4b94-9083-b6ef6ab40739',NULL,'0',0),('b621f045-7a8b-4e6e-bc15-ec2ade43a85f','2016-08-08',NULL,37159,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c6cb3613-3b59-4d93-bad5-cbc307a5b147',NULL,'0',0),('b654c1b6-b446-4b99-8561-c1158a942f93','2016-08-08',NULL,16974,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'746ec058-c48a-4a7d-a2db-907773279793',NULL,'0',0),('b66fd5cf-3e08-4977-b90a-59c7d9a10716','2016-08-08',NULL,615,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'a009032a-47ee-4ca2-99dc-ca8576c39bdc',NULL,'0',0),('b6888a2a-0ff1-4b2c-a804-1b4a2c052c67','2016-08-08',NULL,338,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'b77080a1-4dbd-4923-a5b5-bcdf7795740d',NULL,'0',0),('b692f49b-55a1-4c33-b7fc-c2eb57671c1a','2016-08-08',NULL,2376,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'1c477c16-a1b0-4982-8857-b9b7ee9fb986',NULL,'0',0),('b6e58b7e-94ed-4a8b-8914-71f866deed19','2016-08-08',NULL,10092,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'9765d942-edbc-4d37-993f-6b4cc4fd8c92',NULL,'0',0),('b6f5e24b-eca7-444d-b990-a04d4b3181f0','2016-08-08',NULL,23805,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'10fc4ac8-48e5-403c-b89e-45b88e772f96',NULL,'0',0),('b6f8c650-138b-4694-8d6f-1322ac761e00','2016-08-08',NULL,612,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'d9fa83ac-a786-4d41-b318-18c3a8acb8ff',NULL,'0',0),('b71e0545-22fe-4a47-9dda-798a478b601b','2016-08-08',NULL,6480,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'62e4d93e-949e-4136-9628-cca17c0eadd9',NULL,'0',0),('b74349da-0bd4-4619-a58f-4d2b4411956a','2016-08-08',NULL,28463,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'81bd16af-abfd-4a2a-b92b-15bc2240459c',NULL,'0',0),('b74f4702-689f-4d67-bc07-6e4a6f64a9fe','2016-08-08',NULL,870,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'752be6c7-a8e5-4f8b-a309-2f79926c6f47',NULL,'0',0),('b797d8b0-e8f2-46d1-aaaa-99ff1b15d3b6','2016-08-08',NULL,203,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'2d567563-1311-4d61-b599-4262498abbcf',NULL,'0',0),('b7a18d36-32bc-4e81-b054-b24c391561e4','2016-08-08',NULL,23364,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'6a109be9-3ad5-4287-ab6f-2300dfbea49c',NULL,'0',0),('b7bbcfad-8168-455a-8c73-8deb18940644','2016-08-08',NULL,4505,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'280f4a60-3587-4a87-b219-c75d42cc6534',NULL,'0',0),('b7e041a5-0e3d-4d9e-8c55-36a6db2ed214','2016-08-08',NULL,18010,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'941fa182-a1cb-4490-89a6-4ec3d660dee6',NULL,'0',0),('b80eece4-f236-4735-8b4e-2d9004191bb0','2016-08-08',NULL,8151,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'a4dc0839-9fda-45ca-ac7b-7c510434d303',NULL,'0',0),('b819f488-3252-467b-a11a-085554112148','2016-08-08',NULL,5693,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'b475997b-5fd6-4f4c-9333-7c96ca4367a9',NULL,'0',0),('b821a604-a7dd-4f7d-b592-5fdd8e7f372e','2016-08-08',NULL,20742,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'b0e53c7d-fa19-4d03-8276-5fc5b8bb5973',NULL,'0',0),('b83a208e-3a8c-4705-a8a5-40d079d7a363','2016-08-08',NULL,4471,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'bbdff218-6ed0-4984-bf91-194096003796',NULL,'0',0),('b840a452-3891-4244-b56d-813d9bc39d09','2016-08-08',NULL,1242,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'8da8e399-bf10-4dfc-8363-82722c174366',NULL,'0',0),('b85cc389-ba44-431b-bf4b-b46e288c138f','2016-08-08',NULL,3882,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'da9406ae-a2d9-43da-a0f6-a3a6d2bfdc1f',NULL,'0',0),('b86bcb42-0178-4b3a-8ad3-9b395cf002d1','2016-08-08',NULL,22770,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'162da676-a464-47e3-b74f-98c12165e8c3',NULL,'0',0),('b8729f42-37fd-4c94-9d56-4bcbebd45c78','2016-08-08',NULL,417,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'6c3b04c3-0627-4e1e-8bc5-4d19a2adabe8',NULL,'0',0),('b8a56e14-ff0e-4844-ab29-bd4940582132','2016-08-08',NULL,24420,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'3bcf2b03-f78d-4b94-9083-b6ef6ab40739',NULL,'0',0),('b8b7275f-b8a5-4138-ba5b-e3ec23dea33b','2016-08-08',NULL,5631,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'280f4a60-3587-4a87-b219-c75d42cc6534',NULL,'0',0),('b8d1c0e5-8b10-4a1b-b32e-00d99bcff3b6','2016-08-08',NULL,1072,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'30176b2c-1c16-4774-9e4a-724306b412d3',NULL,'0',0),('b915026a-49b7-4de2-8814-78f6df4ec342','2016-08-08',NULL,21347,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e4226aff-9dc3-4214-bdd7-3db1100093b4',NULL,'0',0),('b9873f8c-77d5-41d6-9199-4a1c5c1e2584','2016-08-08',NULL,15295,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'6437460d-aebc-43e0-9172-ad29b40444ad',NULL,'0',0),('b98ef25e-64ca-4a1c-b4b5-5d86a64705ff','2016-08-08',NULL,142830,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'b502f59b-35ef-43ad-b51e-d5c45d02b5d8',NULL,'0',0),('b9a879c5-a5c6-42f8-bc9b-5cc9185b4648','2016-08-08',NULL,14748,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'b994e8aa-85d4-402e-9b96-6e4b839b9e07',NULL,'0',0),('b9c7b075-667d-4197-a385-caebe958b71c','2016-08-08',NULL,3241,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'6f5dda22-2d2b-41a1-a350-3199c935c163',NULL,'0',0),('b9f6a9c0-abda-47a6-bf3d-15cf78535b1f','2016-08-08',NULL,12880,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'16865428-073d-4cc3-8da7-f55793296e21',NULL,'0',0),('b9faa6c7-f9e7-4a2a-9c60-b65b19e24600','2016-08-08',NULL,3645,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e166d6d7-7cf8-4e5c-a13a-4499d9762f7f',NULL,'0',0),('ba0720b4-bca2-43a1-9dfe-ab325d567329','2016-08-08',NULL,50053,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c97186d7-0912-4977-8672-d968774c62a7',NULL,'0',0),('ba302959-445e-421a-903b-611a05efdc57','2016-08-08',NULL,6831,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'9e3c398b-3c45-49a6-bb2a-0367a986a1e6',NULL,'0',0),('ba42b6bf-7bcf-4c0b-8304-ca889e20f4e4','2016-08-08',NULL,16129,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'88c9f4f3-663d-48cc-885a-3c3a40389307',NULL,'0',0),('ba5d3b5d-4dac-4b28-b682-42030da05b9c','2016-08-08',NULL,5175,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'ef1f9e0c-2dee-4fe4-b034-fd395366198c',NULL,'0',0),('ba7e78a1-30ce-4973-9fcf-6a61cf2ae1ca','2016-08-08',NULL,508,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'cd61cb27-850a-48c4-8a5c-f51db64176e3',NULL,'0',0),('ba882d4e-ec68-4ec7-bf81-2b5fbdded62b','2016-08-08',NULL,60390,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'140830b4-4847-445d-b32e-6ff9a315acf6',NULL,'0',0),('bab6ff5d-f61f-44ea-a8ac-a0803d93f6b6','2016-08-08',NULL,8383,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'8c2d9e22-6bc0-4525-8c22-3fb3d74077ab',NULL,'0',0),('bac62ab5-8196-43cb-a655-54c005420754','2016-08-08',NULL,1863,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'0c87f638-2e75-413d-bd70-c5b89c144b3b',NULL,'0',0),('bad853d1-1f6c-457a-8d29-1cc838d7bae3','2016-08-08',NULL,94875,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'1cb74234-3d39-4b32-bf58-4b07136eb87b',NULL,'0',0),('bae640b2-e725-4bd1-b466-5383b6b765f5','2016-08-08',NULL,11880,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'04715b9f-36c0-4c0f-9377-a8f4b42dadff',NULL,'0',0),('bafbf17b-45f8-46b7-94ab-7bc671e1c265','2016-08-08',NULL,0,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e9d0f8af-54e1-49f9-b5e2-a19e42f0e05c',NULL,'0',0),('bb155eea-caf3-4bbe-a5ff-e45b3bbe7dfb','2016-08-08',NULL,12006,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'0d0a7ff1-8497-40bb-a4b2-848d7ac2749c',NULL,'0',0),('bb4d6619-44e4-42ac-8097-086b423f1489','2016-08-08',NULL,93896,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'05b1a7cd-af33-4b66-97fc-8e799dbb9233',NULL,'0',0),('bb80ea97-a3f7-47fc-becb-ceb4a261b217','2016-08-08',NULL,1035,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'8da8e399-bf10-4dfc-8363-82722c174366',NULL,'0',0),('bb9b0e4e-3fda-45b2-9e8f-0a35561d2c58','2016-08-08',NULL,23474,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'7fddbe26-7a42-4719-9fda-115517d449f0',NULL,'0',0),('bba2be1c-81c6-4a0a-8a2e-4de04809475f','2016-08-08',NULL,18630,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'d0449520-ae74-4735-a545-e21a949f1031',NULL,'0',0),('bba3710c-bab3-4e13-8135-15045880ffaf','2016-08-08',NULL,5822,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'830d777f-32bf-475f-b03b-aba72906c82c',NULL,'0',0),('bbdb56f3-a8b6-438c-ab90-e3a1683dfa58','2016-08-08',NULL,3434,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c04fb5e7-4366-4ed4-8427-e788be8af7a5',NULL,'0',0),('bbf31865-90b5-4772-bcce-3215f1c0d850','2016-08-08',NULL,1293,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'16861364-78e1-4079-8250-3653ad9e75ca',NULL,'0',0),('bbfbea6f-9697-4641-95a4-648fd88a7420','2016-08-08',NULL,257,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'d9542fb1-bfa9-4556-be69-60e36511ae01',NULL,'0',0),('bc017b86-5871-4376-867c-fe5f556aa519','2016-08-08',NULL,36225,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'1af980d8-f07e-4d66-9c57-d998b4a1b47f',NULL,'0',0),('bc1538c4-6815-4b7f-a1f7-674fb0c064f6','2016-08-08',NULL,3713,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'40858ddf-87fc-47ac-8f18-f1d67e2bdea9',NULL,'0',0),('bc3509fc-abef-4e66-92ad-3251a0cfb5df','2016-08-08',NULL,540,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'b799a494-fbd0-41ad-87bd-6929ceec4043',NULL,'0',0),('bc4bab83-082a-4f23-8c9b-ede6e893fab7','2016-08-08',NULL,15525,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'35c33b78-2ea8-4702-ae8f-54dd0ae438dd',NULL,'0',0),('bca32bc8-5398-4a6d-8dd3-55a40ec3d55d','2016-08-08',NULL,19251,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'4ea9c4ef-d4f6-4754-94cf-d612c7ce9e6c',NULL,'0',0),('bcaeff80-051f-4256-8b2b-25c84b53800a','2016-08-08',NULL,25661,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'a26b1643-5f37-4b51-b449-2c77bb73b2e2',NULL,'0',0),('bcc7eeb0-5dcf-4569-bf10-6949c1b504f7','2016-08-08',NULL,908,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'407fad1b-31fd-41a8-9e2e-26e407355981',NULL,'0',0),('bcf0fe25-b6bf-49b1-b8a8-9f617fe1010d','2016-08-08',NULL,6707,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'689937cd-f309-47a2-a1b7-812c792e5062',NULL,'0',0),('bd106135-b1c2-4061-98e0-a9bd544fc401','2016-08-08',NULL,2381,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'46d3047b-e587-4be6-8282-58ecba0fed31',NULL,'0',0),('bd2a4499-f0c3-4954-8825-0d53b9ab76b8','2016-08-08',NULL,778,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'2d35744d-b386-411d-88be-1900f1c93469',NULL,'0',0),('bd2e69ee-da77-4551-9620-d79ba54c2a27','2016-08-08',NULL,591,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'a009032a-47ee-4ca2-99dc-ca8576c39bdc',NULL,'0',0),('bd6b22af-1687-42b1-a49c-14eb33cbe8bc','2016-08-08',NULL,3986,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c0b87cc9-7dd5-4e92-b78c-5b065da4e621',NULL,'0',0),('bd86cf1a-6d72-4102-a631-63d0d7765d9c','2016-08-08',NULL,23232,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'fab5103b-073d-4952-8280-017ff9faed93',NULL,'0',0),('bda67b9a-e526-4267-badf-24122050e157','2016-08-08',NULL,147922,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c7e1658e-5de0-4f84-9b17-5d4aae07c76e',NULL,'0',0),('bdc2452f-080d-4f5d-9bf4-263c9d5731d7','2016-08-08',NULL,53406,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'f32709b7-59c6-4d10-91ed-75936038e844',NULL,'0',0),('bdf0a049-4eb0-4798-b4bc-56ea37b0cac8','2016-08-08',NULL,7116,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'d3ea4f01-19cd-40ec-8c10-3c640de65756',NULL,'0',0),('be1a4248-98f7-45c4-b788-92c8fb29b909','2016-08-08',NULL,39600,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'78400bc3-34aa-4448-a70b-50a85ad93785',NULL,'0',0),('be3c0383-66cf-43b3-b4de-e76cb6851e9b','2016-08-08',NULL,163,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'8ff8e6a8-d2f8-4f90-9010-f2c74a9b803b',NULL,'0',0),('be675bbe-9719-45e7-8efe-28dadc4c7846','2016-08-08',NULL,26454,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'88de4ea2-80d9-4152-91aa-4817f82e8f89',NULL,'0',0),('bec02b8a-ae56-441b-ac5d-3a1892eba411','2016-08-08',NULL,15391,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'ec15592f-6863-4097-93de-a5abad4820e2',NULL,'0',0),('becb45c4-9f4d-46b5-a634-dc2221bee5e8','2016-08-08',NULL,372,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'35f2b105-7802-446d-881f-97f5f407a6ef',NULL,'0',0),('bf32704d-8b1a-4829-aeda-977719866db6','2016-08-08',NULL,5400,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'6663aebb-4ed2-48bf-8625-7f875052bc7b',NULL,'0',0),('bf32d4de-dbec-4ae8-b635-2148ddf2a7d6','2016-08-08',NULL,7920,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'0bd09974-0132-4a30-98ae-ac6d2f95cb0b',NULL,'0',0),('bf32e66f-983d-4433-9c5f-1438209995ff','2016-08-08',NULL,1080,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'f7d7c867-796b-4303-b251-a1f80c74eceb',NULL,'0',0),('bf3eff72-56aa-4dbd-827a-96abd3b0dd1b','2016-08-08',NULL,4968,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'68bc940c-4a69-4656-a72b-7eba9efc6987',NULL,'0',0),('bf515054-89dd-4683-853b-2d6bbd3825f1','2016-08-08',NULL,43469,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'1af980d8-f07e-4d66-9c57-d998b4a1b47f',NULL,'0',0),('bf9c298e-b620-42ee-aa76-0795a47e2e4a','2016-08-08',NULL,47520,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'78400bc3-34aa-4448-a70b-50a85ad93785',NULL,'0',0),('bfabdc25-80f9-4fbf-854f-cb347c1c7ae3','2016-08-08',NULL,28538,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'6b0abda0-9adc-409b-94a3-e7b6723c4be3',NULL,'0',0),('bfba2257-4baf-474f-83f1-061fde80fd07','2016-08-08',NULL,39330,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'ffd1c689-325e-4455-8816-ce31814996c8',NULL,'0',0),('bfbb4b3f-7b47-42b7-922d-ca943cce82c6','2016-08-08',NULL,5900,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'b268586d-4579-4679-b24c-8ba634cac4dd',NULL,'0',0),('bfc23179-a4f9-4875-8376-e47af0a903f3','2016-08-08',NULL,28566,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'35732a5c-88cb-4012-8712-4a60bf5628eb',NULL,'0',0),('bfec0044-88a7-40d1-9b41-119396b47414','2016-08-08',NULL,11880,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'70bc2b1a-2985-4f27-a201-38796f2b5fa5',NULL,'0',0),('bff58ebf-e7a5-4a8c-a3c9-f0cafb224d56','2016-08-08',NULL,4657,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'bbdff218-6ed0-4984-bf91-194096003796',NULL,'0',0),('c007fd29-24d9-4fc1-a260-c48197edc0b7','2016-08-08',NULL,713,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'04761771-d7fe-4fd2-bbea-d0054d8843c5',NULL,'0',0),('c01a7de1-cd5e-4658-97a9-feefec57e410','2016-08-08',NULL,3186,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e7e27f01-f901-4fa0-88df-2ff7d8eb9d26',NULL,'0',0),('c0406419-4f58-4aef-bac3-cbe529d993d3','2016-08-08',NULL,34172,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'3d56278b-58dd-4f82-9169-d8a478a21b43',NULL,'0',0),('c04c7744-c56e-4593-aa15-289863c56827','2016-08-08',NULL,12524,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'65cd8f3c-3823-4bdb-8c3b-1bc6f0430048',NULL,'0',0),('c0594867-a1f9-43ef-be9d-5b60ff194812','2016-08-08',NULL,44505,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'f32709b7-59c6-4d10-91ed-75936038e844',NULL,'0',0),('c0875897-9b1f-48b5-a3f4-191e28c87d1f','2016-08-08',NULL,2459,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'fb09b5bb-4361-4bd1-a72e-2618b1347f50',NULL,'0',0),('c0af2e98-b7c0-49d1-ba05-0a212dbf6728','2016-08-08',NULL,17820,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'4b4313d1-4ec1-49cc-b023-a175c2696263',NULL,'0',0),('c1194a22-07a5-42f7-942f-c1b99ef45671','2016-08-08',NULL,908,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'d30ecb66-2dbc-479c-b189-ab867dca4473',NULL,'0',0),('c1a57df5-ef36-4ba0-9bd4-06ef979d9518','2016-08-08',NULL,908,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'8c857058-ba14-46fd-b220-4cf196a557d1',NULL,'0',0),('c1c176b7-cf6a-43ab-9169-568788569674','2016-08-08',NULL,1293,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'92c66aae-c96a-418e-984c-b4f6f45055b3',NULL,'0',0),('c1c80e3f-2180-479a-859e-660792db07aa','2016-08-08',NULL,13455,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'b13ca82b-fbc6-436c-8645-802d56ff7f96',NULL,'0',0),('c1dc5f6b-9411-4419-b2b1-5e817de18825','2016-08-08',NULL,173938,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'3bb38ddc-5073-46f7-ad04-d6862c1ac3c2',NULL,'0',0),('c27f3154-4956-4caf-8feb-df750b8badc3','2016-08-08',NULL,2178,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'084ecea3-20b9-47fd-a75b-b5bc0f6cbd69',NULL,'0',0),('c2f3fbf9-d085-4ce2-b4ff-d6172b0331fa','2016-08-08',NULL,18630,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'b83db7ea-3f9a-40c7-9366-8cf56fe62584',NULL,'0',0),('c315560b-45f8-4706-9e90-ca114aa62051','2016-08-08',NULL,16560,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e49bac38-aa20-42a8-b709-d07fdbde475c',NULL,'0',0),('c364669d-4c7e-46b4-a34d-66bdd657736e','2016-08-08',NULL,945,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'43eecce1-b6f8-4ed1-a8f6-3f029d3bc1d6',NULL,'0',0),('c3856c9e-07db-405c-ac72-fb9b04f5e0a8','2016-08-08',NULL,6336,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'79f1c6f1-c0c3-4a62-b7af-12c2618a554e',NULL,'0',0),('c3b1e524-5d44-407d-8655-83699da4c2b9','2016-08-08',NULL,1760,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'f96599c9-4abc-494d-b9e1-5a95e9d04e73',NULL,'0',0),('c3d8a189-7bc2-4170-9b6d-8304e63aca4d','2016-08-08',NULL,1081,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'f212b583-b619-4352-b7ae-bfd3677d4ad4',NULL,'0',0),('c3f3a34c-df88-4684-9aed-86139d9c737d','2016-08-08',NULL,6852,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c9458386-b9d4-4894-adb4-10fd81c841d3',NULL,'0',0),('c3f7d593-5013-44da-8339-e14681fa08eb','2016-08-08',NULL,238,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'401f52f9-0183-4466-857b-aa5e512fa4b1',NULL,'0',0),('c4473635-dd3b-4363-ba33-4bb8686e65ee','2016-08-08',NULL,2429,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'152f2e0e-1a2c-417f-82c1-b280460976fd',NULL,'0',0),('c451df58-9f69-4708-b92d-f1b20574b192','2016-08-08',NULL,2360,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'f50477dc-a0f6-4829-98bb-f376a115b3b7',NULL,'0',0),('c4559b67-9ffe-455f-b5fb-43009de575e6','2016-08-08',NULL,695,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'f8c1840f-43db-4e51-9269-26f9756f71f8',NULL,'0',0),('c45ad0eb-c6e2-425e-bca9-d4085b5d90f2','2016-08-08',NULL,4099,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'ecf5648f-6127-407a-a854-0d33b13f7cc9',NULL,'0',0),('c45c7b00-1f27-4f25-8112-5b9e0f634827','2016-08-08',NULL,7866,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'cb080cf5-be76-4956-bca0-d1da336c171b',NULL,'0',0),('c497984d-9c79-41ea-93fe-6bc8e605e817','2016-08-08',NULL,4658,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'830d777f-32bf-475f-b03b-aba72906c82c',NULL,'0',0),('c4ad2f42-179a-4a30-be7d-083d26ec25be','2016-08-08',NULL,1069,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'7fc2f37e-fcaa-485b-a008-180b15bc9d79',NULL,'0',0),('c4b20163-d2da-4745-9620-7cfdafbad7f1','2016-08-08',NULL,29886,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'33da234e-081b-4a4e-8e98-17cded390bba',NULL,'0',0),('c4c2ae1d-a4fd-4f68-b689-9bd754493f4f','2016-08-08',NULL,941,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'0a9a2f8d-36a7-45ea-9e2a-67b9fa59da98',NULL,'0',0),('c4cd0b2f-e12f-4bd5-9470-a0c1603ccdab','2016-08-08',NULL,16572,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c792c260-f339-4bc5-8647-ebee072b58d5',NULL,'0',0),('c4df239d-f542-4d9f-bf60-57ae867685fe','2016-08-08',NULL,5481,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c9458386-b9d4-4894-adb4-10fd81c841d3',NULL,'0',0),('c535eb45-6cf1-4b66-b90a-372a60e0f507','2016-08-08',NULL,2112,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'d62b1240-3a2b-4a40-8db0-5cd165cfa8f3',NULL,'0',0),('c566768c-19b0-4ba5-9671-b103b9da9f9d','2016-08-08',NULL,404,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'590bc58c-aa06-4cb8-997d-b7abf367c28b',NULL,'0',0),('c634a1fa-81c8-4a4f-8966-99fbd890dbf9','2016-08-08',NULL,4099,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'6ede563d-0aa2-4bdd-ab9d-199fb73117dd',NULL,'0',0),('c65147b7-ee8a-4371-9db7-74e16a1551ef','2016-08-08',NULL,206,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'6e5cc3e8-2eab-4709-b6f6-02ffd02ccc99',NULL,'0',0),('c656f02a-7caa-4373-98cd-c79c22e8c27f','2016-08-08',NULL,5563,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'218005c1-4b36-4d3b-8b5b-5d4c6eb88186',NULL,'0',0),('c67e2303-e65b-4478-811d-e74d24e905f2','2016-08-08',NULL,1117,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'18315342-7f0d-43e6-8710-71ce095f0f5f',NULL,'0',0),('c6cdb45d-581b-47c0-92ee-cceb13f6665c','2016-08-08',NULL,7452,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'91fb4e05-b678-42fa-bb16-8022e2e24e22',NULL,'0',0),('c6db962c-8aa5-4ec3-b6d2-e9b65e7d93d9','2016-08-08',NULL,19536,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'9aa311e3-468a-4e00-b8e1-304a6c7539bf',NULL,'0',0),('c721540a-c556-45c8-8f55-52dc79b2f7eb','2016-08-08',NULL,46173,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'7867372a-5231-4c40-be88-92a77ce74340',NULL,'0',0),('c729adc1-f67c-4e71-85d2-89335918d0d7','2016-08-08',NULL,3416,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'ecf5648f-6127-407a-a854-0d33b13f7cc9',NULL,'0',0),('c7342d9c-a304-41f6-8602-b7b03f1ba7b0','2016-08-08',NULL,14579,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'90c07d25-db37-4060-ba5a-6e5af7dfdf4f',NULL,'0',0),('c77b5803-e27c-44b0-aaaa-bc991ecf9fd3','2016-08-08',NULL,11609,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'b7356652-f9bf-4916-8040-ed670178da93',NULL,'0',0),('c7825678-19e1-4501-bef1-0a0cb84ee478','2016-08-08',NULL,4099,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'984707b1-d587-4507-9309-a91b132bfb98',NULL,'0',0),('c78a5d5e-6077-48d0-b75f-e41c00db07bd','2016-08-08',NULL,8591,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'4fccf62e-f6c6-46d9-948b-ff2c1f769fff',NULL,'0',0),('c7937133-1d30-4bd4-9465-ec08ae3cb643','2016-08-08',NULL,16145,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'681f1db6-6a6c-41d4-8e48-df52a4d07135',NULL,'0',0),('c79f918e-1c36-4f2c-8c69-050c9e9981ef','2016-08-08',NULL,70173,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'706f8cc4-f647-4992-87c8-a17a2ec549f2',NULL,'0',0),('c7c23580-414b-452a-9886-a9c28c65f0e1','2016-08-08',NULL,131,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'8ff8e6a8-d2f8-4f90-9010-f2c74a9b803b',NULL,'0',0),('c7f3f2d6-c291-4efd-ae75-2cafaf539863','2016-08-08',NULL,22950,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e80cb4ac-b07e-4600-bae7-a64c2a2f23c1',NULL,'0',0),('c83d27a1-6f19-489d-942c-85c60a94db18','2016-08-08',NULL,973,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c267f236-325c-41f6-8a46-56763ecd4b12',NULL,'0',0),('c84ea40d-4be7-46c9-91db-ba934c95d0a9','2016-08-08',NULL,20053,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'4ea9c4ef-d4f6-4754-94cf-d612c7ce9e6c',NULL,'0',0),('c852309f-df9f-490a-a08d-b9ebf3c3b828','2016-08-08',NULL,2592,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'6f5dda22-2d2b-41a1-a350-3199c935c163',NULL,'0',0),('c8a22429-d6fe-4277-b155-8702e8a6e75e','2016-08-08',NULL,10556,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'edace783-6b08-4a15-9194-6cb363bc0f79',NULL,'0',0),('c8c8c0a8-8201-4b77-98a4-a18c07e4366d','2016-08-08',NULL,12420,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'2c7e34a0-931b-412a-9aa6-63af17f37815',NULL,'0',0),('c8eb4f22-4ef7-4bc6-bf38-0455f8260dd9','2016-08-08',NULL,7116,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'b475997b-5fd6-4f4c-9333-7c96ca4367a9',NULL,'0',0),('c8fd9669-989b-43c1-9871-6bc881e6735a','2016-08-08',NULL,158125,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c1b5c607-f976-40c3-9c8c-7a53d31fbabf',NULL,'0',0),('c93d98ab-5893-41c5-81af-7823df4b5fa9','2016-08-08',NULL,4320,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'1036ff8c-ba61-4479-8b3f-1089e236dd18',NULL,'0',0),('c949a60e-a1b8-4355-886d-789b9b8d12f6','2016-08-08',NULL,13714,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'8ecd4d6f-3bf9-48bd-8cd9-a7b392a8973a',NULL,'0',0),('c969fc5e-ace2-40ac-af06-d70bc0b20720','2016-08-08',NULL,21010,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'28135593-39cf-4a2a-aee4-706f7ab6fddf',NULL,'0',0),('c98b807a-0f67-40ea-9c7f-d459fc78ab79','2016-08-08',NULL,522,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'6c3b04c3-0627-4e1e-8bc5-4d19a2adabe8',NULL,'0',0),('c9966101-5e93-485f-a575-cb49e63052ae','2016-08-08',NULL,1242,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'16861364-78e1-4079-8250-3653ad9e75ca',NULL,'0',0),('c9d292d0-1092-4dd8-969f-b4a6217b568a','2016-08-08',NULL,12668,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'edace783-6b08-4a15-9194-6cb363bc0f79',NULL,'0',0),('c9ddf087-9ba6-4f78-90b6-eef78cc9d9aa','2016-08-08',NULL,5175,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'ed875474-f3f2-4d79-b94f-9db4b3fe5ad0',NULL,'0',0),('ca1f9fb3-a775-405a-9bab-35819785eec7','2016-08-08',NULL,29468,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'36574898-6c20-4cc9-addc-8e6a68ca5cb9',NULL,'0',0),('ca675346-0a81-4b6a-b3c2-d24c03bc5994','2016-08-08',NULL,17710,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'275f070a-ae3d-4f29-a882-cd6bd9fca7e5',NULL,'0',0),('caa32f85-7871-4ec3-9c69-a6ed1142858f','2016-08-08',NULL,14256,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'04715b9f-36c0-4c0f-9377-a8f4b42dadff',NULL,'0',0),('cab788c1-95f5-40a2-845e-d7e143baf4b6','2016-08-08',NULL,16200,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'0c4e33f7-256a-4275-a268-cdbf64495451',NULL,'0',0),('cad6d8bf-66a0-4d1c-8266-1176455863c9','2016-08-08',NULL,725,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'0dde6cd4-61ee-4ae4-b272-7ec50af92bc8',NULL,'0',0),('cad72656-1449-403f-82c2-5092eb72213d','2016-08-08',NULL,1188,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'a86a1c82-5128-43d8-a865-376d8d6605a0',NULL,'0',0),('cadab0fb-5863-46e9-9871-892df1cb1f21','2016-08-08',NULL,7116,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'d56f271f-0d1f-47d9-a879-5d7dbddbf64c',NULL,'0',0),('cb0fca40-2051-4f32-b041-fb3e7e0c813e','2016-08-08',NULL,9688,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'9765d942-edbc-4d37-993f-6b4cc4fd8c92',NULL,'0',0),('cb164d67-362c-49d1-bb81-c5cb6a04b319','2016-08-08',NULL,8637,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'f91c5830-2808-4e6e-9c23-320a015d0308',NULL,'0',0),('cb166521-7a76-4aad-89ed-e25eee5b4ab5','2016-08-08',NULL,10349,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'b39aaef8-7805-4f05-9381-afec13f53977',NULL,'0',0),('cb74c98e-2c84-438e-9322-df401957e424','2016-08-08',NULL,2490,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'f886c2b4-d114-4212-9569-b3f9ea49e1a1',NULL,'0',0),('cb8b6e49-dc5c-4ddf-84e5-2dcb4fb6c86e','2016-08-08',NULL,13599,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'9802b6fb-0db0-4e66-8938-26afdccbcb53',NULL,'0',0),('cb91ca3b-28eb-4fdd-b9a1-d719c1b3c31c','2016-08-08',NULL,19319,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'6b2cb11a-7607-48e6-ab8d-850cb701e1c0',NULL,'0',0),('cba9e651-a8b1-4957-b057-8147439c8c50','2016-08-08',NULL,1451,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'591dd6bb-f2f6-4b00-828f-5f7a869f361d',NULL,'0',0),('cbb0f23b-6e58-4390-bb6c-a1798af01647','2016-08-08',NULL,14407,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'0d0a7ff1-8497-40bb-a4b2-848d7ac2749c',NULL,'0',0),('cbbc31b8-daba-48a5-b380-9770f0b09133','2016-08-08',NULL,2483,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c7874cc2-e364-48cc-b9b0-e1936d6dd360',NULL,'0',0),('cc34abe0-6258-4b4e-b184-8a7b7b3410ab','2016-08-08',NULL,7948,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'6e17ec90-63af-41c3-8cac-5bd946faaf82',NULL,'0',0),('cc5de816-ff32-4378-9911-69ac2ddbab6c','2016-08-08',NULL,48312,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'140830b4-4847-445d-b32e-6ff9a315acf6',NULL,'0',0),('cc7c1372-a29c-4b32-acc0-6664999f920f','2016-08-08',NULL,135,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c5ac1eb3-cb9b-4134-91db-a271a8e1b43e',NULL,'0',0),('cc9a00c6-f087-418d-a27c-8b05cabce0e1','2016-08-08',NULL,15525,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e07d2c5c-d211-4ba1-ad34-706ef9c5c2f4',NULL,'0',0),('cd00a5f5-76ce-41de-8b0c-5a340be9e59a','2016-08-08',NULL,171396,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'b502f59b-35ef-43ad-b51e-d5c45d02b5d8',NULL,'0',0),('cd0e2934-11c8-475a-93c9-9a8599f7b8a7','2016-08-08',NULL,19239,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'ec15592f-6863-4097-93de-a5abad4820e2',NULL,'0',0),('cd3d12f9-3706-47cf-9999-0ba0c7887b85','2016-08-08',NULL,19407,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e07d2c5c-d211-4ba1-ad34-706ef9c5c2f4',NULL,'0',0),('cd6c275a-cbfc-41eb-8238-f2d6a6e75f84','2016-08-08',NULL,11426,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'03ed3ffd-4174-4201-813b-31dd9c4e5793',NULL,'0',0),('cd786b75-3f60-42a3-b30a-4742bca89ef8','2016-08-08',NULL,594,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e815dcda-c91e-45e3-9fc1-dd2a575e6e73',NULL,'0',0),('cd83044f-0e46-41b7-8ebc-6f1eb24fbc63','2016-08-08',NULL,1620,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'936f4c03-b603-41a6-b078-dbfe54b06563',NULL,'0',0),('cda93562-d937-4d3a-9113-0fcf0b927dff','2016-08-08',NULL,10247,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'7a93e08d-12b3-4643-ac13-abb218ef0624',NULL,'0',0),('cdb313da-2e45-46e8-800a-f22ffa4bb45e','2016-08-08',NULL,20700,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'6c9f3ce2-358a-4b37-8794-43ab3788b58c',NULL,'0',0),('cdc1776d-525a-46ef-aaaf-955f2372eb0c','2016-08-08',NULL,11385,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'9eab9be0-7355-4001-86b3-d701aafa247a',NULL,'0',0),('cdcdda3d-31ac-46c7-af80-89d89d16ef51','2016-08-08',NULL,396,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'7efdbb21-13fd-4f57-b50d-0d16f29cef39',NULL,'0',0),('cdce7d08-91c2-4015-a683-ec627070e538','2016-08-08',NULL,36369,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'d60f5ae5-e8bf-42ca-b6e9-d6c8d818b875',NULL,'0',0),('cdfa76aa-04f3-4e6f-921c-6616642dbb16','2016-08-08',NULL,5589,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'ec29bc77-685a-40ae-a6fd-2c7f6eecd9f4',NULL,'0',0),('ce0d6e91-c0c0-4a97-a206-39479b9b25ec','2016-08-08',NULL,12151,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'7353aa67-3256-4ce2-9d6e-f20ddeb3be76',NULL,'0',0),('ce2ac2cb-362e-48f4-b1e2-e010e62376a8','2016-08-08',NULL,24420,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'01b8a9fa-5733-4ee8-8c08-b20e26e5c167',NULL,'0',0),('ce535cec-2807-485c-bd4a-7570c152425b','2016-08-08',NULL,11799,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'b994e8aa-85d4-402e-9b96-6e4b839b9e07',NULL,'0',0),('ce5d48ff-cb40-4655-ab89-e285a6dcc5b4','2016-08-08',NULL,1940,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'b77fcabc-a2e9-4157-94b1-176e5bb493d8',NULL,'0',0),('ce83ca8e-9314-4682-948d-3e4676c357c9','2016-08-08',NULL,9522,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'a73fc586-4831-41db-b1be-992e4b8a1687',NULL,'0',0),('ce97115b-2a42-4446-ad35-898638605456','2016-08-08',NULL,18810,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e75543d4-2e88-46ea-9c86-6f81cae97787',NULL,'0',0),('cf20c0f7-12f8-4376-8cfa-7e130488d16f','2016-08-08',NULL,12618,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'61bb5f10-9e56-4152-b8ee-a08b606f4e4a',NULL,'0',0),('cf2f3969-22e5-4821-9033-2dc978d049d1','2016-08-08',NULL,1620,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'a4be3d32-ddb9-4ec1-85d3-74107f1cb9f7',NULL,'0',0),('cf537cdd-7088-454a-b45d-8a7fa71ff6c7','2016-08-08',NULL,15629,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'24e58c5e-7f82-47ed-a56d-d384a29515ec',NULL,'0',0),('cf7bef0a-9c9a-459f-8e5e-f190a64d303f','2016-08-08',NULL,8279,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'822121a6-1bd2-4bea-8e30-109fc6d72492',NULL,'0',0),('cf7f44a8-5715-4c9d-b6dc-3ef493e84e11','2016-08-08',NULL,21252,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'925acc48-43d4-49b0-869e-d7b5b198de62',NULL,'0',0),('cfb912b2-4927-4b03-9e6f-078d71253451','2016-08-08',NULL,28175,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'602bb8b3-b9ac-470b-b519-f767d37ff595',NULL,'0',0),('cfdbbed3-04ba-442b-9563-67c1378308ac','2016-08-08',NULL,3239,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'3970bb04-951f-4143-9f9a-9c5bedef7140',NULL,'0',0),('d00057fc-756c-4c65-b758-927c25693516','2016-08-08',NULL,123268,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'bcbc9ffe-fb49-4c43-bb91-85ddc9dddb71',NULL,'0',0),('d01c3529-6c46-4003-8b18-ce13b3f790b8','2016-08-08',NULL,6106,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'4f6f1a5c-8c63-4398-a1a7-d3fca7a0c400',NULL,'0',0),('d03e056f-9ce7-446c-98ad-63b99b248ad6','2016-08-08',NULL,38916,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'2cf89940-2aa8-47d1-b496-00aac722bcee',NULL,'0',0),('d043abed-07ce-4291-a163-37e90b732936','2016-08-08',NULL,4726,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'01a8e63d-6b82-431c-b434-26bce2e551d1',NULL,'0',0),('d0f7013f-1c9a-44d4-855a-1241a813869c','2016-08-08',NULL,4269,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'6ede563d-0aa2-4bdd-ab9d-199fb73117dd',NULL,'0',0),('d1120e65-61d1-4103-aae4-38bf2a8b3390','2016-08-08',NULL,1035,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'7c3e6810-d2a3-491f-aaaa-df23bc921154',NULL,'0',0),('d118418f-212b-49d5-855c-afecf395be49','2016-08-08',NULL,14098,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'82b32d45-0766-4c17-bfa2-855793ee7e8e',NULL,'0',0),('d140d018-9e42-4bcb-af60-69a1d03a63ec','2016-08-08',NULL,298,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'412a5592-b458-4ca6-9e93-ebc6459ad9f7',NULL,'0',0),('d1417507-757f-49ba-8cc7-d41d3b42cec5','2016-08-08',NULL,34155,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'25310c3d-2ca0-4dbb-9b8a-7d0c3754b11a',NULL,'0',0),('d1ac3982-da36-4e4d-bce9-d11cd417adb8','2016-08-08',NULL,27324,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'162da676-a464-47e3-b74f-98c12165e8c3',NULL,'0',0),('d1c208c1-9ad4-482c-b194-b409e3d201ef','2016-08-08',NULL,856,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'f22d2038-bf3b-4868-bdfc-c963a6e5c5ec',NULL,'0',0),('d1c48df9-663d-44e6-9596-03bfce6b3ce0','2016-08-08',NULL,5340,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'218005c1-4b36-4d3b-8b5b-5d4c6eb88186',NULL,'0',0),('d1e68e1b-9b32-4add-95a6-867e88fc8d47','2016-08-08',NULL,1013,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c267f236-325c-41f6-8a46-56763ecd4b12',NULL,'0',0),('d20d2a09-bea0-4d03-a8bb-128799257693','2016-08-08',NULL,29025,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'68172e37-b09a-4a41-b9b3-a1fa7714310e',NULL,'0',0),('d2824d0e-ff97-4212-a13c-828e202786f9','2016-08-08',NULL,10143,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e9ded445-9be5-4b49-9785-fccd7a6b52fd',NULL,'0',0),('d299a554-654e-40b6-a982-727bacfd0771','2016-08-08',NULL,587,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'ecb0ba82-2039-4da4-ab4f-b1b25d90e745',NULL,'0',0),('d2c20126-b319-45bc-a7c8-2983cfaf1d6d','2016-08-08',NULL,5279,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'45aa3047-9d7f-47e7-acc4-5b66206c38ab',NULL,'0',0),('d2c330fb-e466-41d5-8b2b-fcc7f5eb4016','2016-08-08',NULL,605,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'78beadff-493c-4956-a1f1-dc7745b357a7',NULL,'0',0),('d2f641a7-2278-4053-b31a-6a3604b2a4cd','2016-08-08',NULL,10092,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'4eb68a82-560b-41b0-bdd7-3c7bb9609939',NULL,'0',0),('d3029eb4-dce1-41a4-a3ad-f52676c27629','2016-08-08',NULL,13455,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'aaf6a740-abb1-4a7d-b36b-2ecc0738e723',NULL,'0',0),('d310941f-a325-46ef-aaf2-31cbeb91cdc8','2016-08-08',NULL,8409,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'f74b8998-8283-4843-a7d2-8e4ed5978497',NULL,'0',0),('d32146b6-1c96-41fb-8645-537ec3b0f018','2016-08-08',NULL,76719,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'a969df9a-af25-4798-9fa7-a2e72520e1f7',NULL,'0',0),('d324c437-a902-4443-9954-3d1edc8f7f0e','2016-08-08',NULL,1620,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'ee3f7798-3a92-4dae-92c4-804317e4f8bc',NULL,'0',0),('d34578f5-a795-4f09-89fa-a36137c50d61','2016-08-08',NULL,28037,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'6a109be9-3ad5-4287-ab6f-2300dfbea49c',NULL,'0',0),('d354b1f1-cd06-49d1-b46f-287d9c74aa5e','2016-08-08',NULL,16145,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'6977de00-516c-4a83-bb4a-c62cdf78c088',NULL,'0',0),('d365c3ed-ed75-461f-8bee-4b82b3a76db7','2016-08-08',NULL,7762,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'65226da3-5150-408e-94f0-dd3c4eb90443',NULL,'0',0),('d3a97bc7-99b5-4799-8929-4a078f0a38e2','2016-08-08',NULL,2608,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'33001ff1-5e76-4d77-9454-f720b61534b9',NULL,'0',0),('d3d9a1bb-ea87-4d0d-b46b-ad561881ee12','2016-08-08',NULL,34285,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'05ea21d4-1ec4-4d21-a583-dbae13f5afee',NULL,'0',0),('d4099a60-67c5-4c23-b8e3-b05b82947257','2016-08-08',NULL,3416,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'984707b1-d587-4507-9309-a91b132bfb98',NULL,'0',0),('d428ade6-872f-437d-a934-0f6422f81e8f','2016-08-08',NULL,2691,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'3955cea0-71f2-40e7-a1c0-f30bcab88250',NULL,'0',0),('d431e2fb-a60d-4e19-9dc7-c2c26b0e22db','2016-08-08',NULL,14850,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'70bc2b1a-2985-4f27-a201-38796f2b5fa5',NULL,'0',0),('d438547f-92a8-40b4-8905-92f2fe316874','2016-08-08',NULL,28050,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'0f8b2430-75d7-49f2-bea0-ba53641982b3',NULL,'0',0),('d46ce4f6-c680-4e0e-a139-9b13d434ef95','2016-08-08',NULL,7425,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'1055232b-f75f-432f-92fc-d252a55af5f1',NULL,'0',0),('d4ad19e7-74f7-4401-a894-1d47994e88a4','2016-08-08',NULL,428,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'53d674c2-6f13-48bb-b4e2-3d2a39541852',NULL,'0',0),('d4c6170a-be3c-44ec-9bdd-de160afca1d6','2016-08-08',NULL,2173,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'8d590898-6df7-4a2b-98f6-7335961781ca',NULL,'0',0),('d4d983e4-66f3-4c8a-ab2f-ee039723ac3c','2016-08-08',NULL,26770,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'5e0061bd-4ce4-4bfd-9568-d82450b30e36',NULL,'0',0),('d4e262e7-8b92-440f-a26e-e15b6fd803a3','2016-08-08',NULL,79056,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'56c34599-fb09-49f1-b19a-09dbe50f41fe',NULL,'0',0),('d50a9e57-34b3-47b2-8846-1a05b6ede5ed','2016-08-08',NULL,1733,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'06e325af-29b7-44d2-a87c-5bbe68355d45',NULL,'0',0),('d5274cb8-2706-480d-bc1b-6ed31d62cccb','2016-08-08',NULL,151800,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c1b5c607-f976-40c3-9c8c-7a53d31fbabf',NULL,'0',0),('d557e30f-b5cc-48ae-b762-a0968a078faf','2016-08-08',NULL,929,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'bcadd324-0f18-44f9-9fc3-efae346a55c6',NULL,'0',0),('d55cd559-23dd-451b-9995-f9f9f254e3c7','2016-08-08',NULL,9315,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'785f325c-93cd-4e3f-833a-7b448482f285',NULL,'0',0),('d5b7444e-3bc2-48b2-bca7-f43607ec064f','2016-08-08',NULL,22729,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'87cfce04-958b-446e-b8d3-7c6d8f7cc662',NULL,'0',0),('d5db00e3-706f-4511-ad4a-26e9e76c6176','2016-08-08',NULL,6831,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'b475997b-5fd6-4f4c-9333-7c96ca4367a9',NULL,'0',0),('d5df2dbd-ecfb-4547-a36f-e77dc0e2f388','2016-08-08',NULL,1139,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'b48edec6-7d45-4685-ac79-67d694fe6981',NULL,'0',0),('d5e06969-d045-4372-a1a4-20af0e156bfc','2016-08-08',NULL,2173,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'d39721eb-fa96-454f-bae9-d703cf4655be',NULL,'0',0),('d5e7e7e9-23bc-45a3-9874-8c615acc12f8','2016-08-08',NULL,23480,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'32dbb41e-2878-40ad-a4f2-31b8b34400ed',NULL,'0',0),('d60701fe-5da3-4e44-beea-b9f2fc73be6d','2016-08-08',NULL,5175,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'3161ee08-13f9-43d6-a312-043f441baf9b',NULL,'0',0),('d60c3c36-708e-44cf-a529-5c416ec6c341','2016-08-08',NULL,3727,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e090d829-4bf3-4c32-9cd8-78d1ef511b84',NULL,'0',0),('d62ac294-64ef-470e-bf77-9c3acc7229c0','2016-08-08',NULL,37778,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'30a807fc-2faa-4c65-ab73-4f2f78ae9ced',NULL,'0',0),('d685085e-3c78-4731-bc13-18466db5f0c7','2016-08-08',NULL,4088,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'dc7b57d7-2ba4-451d-a5f1-0d0ae4c0c6f3',NULL,'0',0),('d685ddcb-8061-4975-95a6-7c060aa88446','2016-08-08',NULL,18224,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'254b8e87-0d5b-4fef-aaef-dcbd01f580a7',NULL,'0',0),('d6966ade-1395-4b83-ae72-56c335f946e9','2016-08-08',NULL,4269,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'eeb87659-05a0-48ec-8e63-9a13d4e24302',NULL,'0',0),('d69a74f1-a519-4f66-9da5-e10363b76b2c','2016-08-08',NULL,487,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'46033846-68ce-4db7-904d-f882dfda42ff',NULL,'0',0),('d6b8440c-2c11-4583-9736-97abbe464e18','2016-08-08',NULL,18145,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'44be9244-8a08-401b-967d-785cc71d6a3a',NULL,'0',0),('d70d0036-6517-4114-b493-77b208719194','2016-08-08',NULL,3106,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'da9406ae-a2d9-43da-a0f6-a3a6d2bfdc1f',NULL,'0',0),('d79029ec-3dad-4b44-b718-4a40bd3d3d62','2016-08-08',NULL,15525,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e05eb9c7-ae9f-4ab0-a451-63b849918495',NULL,'0',0),('d798bb2e-9ffc-4956-ad38-9fd522d84018','2016-08-08',NULL,1485,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'841c39b8-6ee9-48a1-9b58-2b480ad0c0d1',NULL,'0',0),('d7b99a33-8233-4102-9cb9-9c3e43134231','2016-08-08',NULL,20250,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'0c4e33f7-256a-4275-a268-cdbf64495451',NULL,'0',0),('d7c90b57-d796-4cb9-9d65-05d9466db510','2016-08-08',NULL,14283,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'5b57adca-ba56-4bca-8f04-28e81565e91e',NULL,'0',0),('d7d83815-001c-4d73-aa28-acd6dde03461','2016-08-08',NULL,15944,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'9a2c13fd-a142-46ec-8551-4bc86e1a7626',NULL,'0',0),('d8259380-d554-4180-82c6-33316ab0f5b6','2016-08-08',NULL,472,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'dd4d9de7-b0b4-4bf2-a095-cb2e876a2899',NULL,'0',0),('d842e951-5da8-465d-a65a-81f0ca268321','2016-08-08',NULL,19980,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'60b2c200-fffa-4abb-bd81-b0f0a7cfbb2f',NULL,'0',0),('d846d7ae-04bf-4e85-8842-144b7651390d','2016-08-08',NULL,15525,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'2c7e34a0-931b-412a-9aa6-63af17f37815',NULL,'0',0),('d85ae678-1433-46ee-ad6d-b0b7196df5ea','2016-08-08',NULL,75762,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'81887fc2-e1b0-452d-9870-cf402bf80c24',NULL,'0',0),('d8617648-808d-462c-83f0-d66fb236defd','2016-08-08',NULL,1115,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e3b20e37-4d91-47d4-8558-99491bb737fd',NULL,'0',0),('d8af29d7-8157-4f24-9983-0aed36dfae72','2016-08-08',NULL,18501,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'7cb2bdf0-f0c3-4588-9798-541920f448a3',NULL,'0',0),('d8d8d8d8-e104-4fc3-8128-b017bc87a53d','2016-08-08',NULL,35475,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'f75d973c-f0b9-4d48-aa08-134e55c5c37b',NULL,'0',0),('d9029bf7-6a54-4d10-9d8b-5b8bc878672c','2016-08-08',NULL,4269,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'ecf5648f-6127-407a-a854-0d33b13f7cc9',NULL,'0',0),('d938ca40-99fd-4a6c-9cd1-25b86d04bd0e','2016-08-08',NULL,323,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'dee9470c-6103-48e6-81e5-12b09412553b',NULL,'0',0),('d95ba49b-5f05-44c8-8b27-09a57dba632c','2016-08-08',NULL,24581,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c770feb5-f73f-4dda-868b-5577dbb125aa',NULL,'0',0),('d9718091-83a5-4da5-bc15-74bd447ce7ca','2016-08-08',NULL,10063,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'ef269800-460b-4827-9444-2f295a5cdf6d',NULL,'0',0),('d991b110-750c-4b39-bece-49bf2f93fa8f','2016-08-08',NULL,28710,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c52ad20c-a94c-4cd5-aa1d-9ca21062c369',NULL,'0',0),('d9a701d3-81d6-48de-aa25-bf5520c0d6c1','2016-08-08',NULL,35066,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'5138aa27-233b-4d0f-bbfc-47152952a31f',NULL,'0',0),('d9b81913-fc52-4f9f-aaeb-e4a850ca2ff5','2016-08-08',NULL,12420,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c7383f85-c820-45e2-a939-ce24c50ad173',NULL,'0',0),('d9b9b562-6857-4887-9717-6a5e2a390c59','2016-08-08',NULL,594,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e93254d9-a933-43d9-b552-a0809afa4da2',NULL,'0',0),('d9ee84e6-b8b5-4040-ba07-54f24e1d77fb','2016-08-08',NULL,12420,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e05eb9c7-ae9f-4ab0-a451-63b849918495',NULL,'0',0),('da1d65d2-3387-4b34-b162-3884ef4d20dc','2016-08-08',NULL,1293,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'353c2ac7-a726-4211-a776-43a1d29ba313',NULL,'0',0),('da3c59d9-5fa5-4fa5-9d02-2bb0dfb58949','2016-08-08',NULL,1126,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'f212b583-b619-4352-b7ae-bfd3677d4ad4',NULL,'0',0),('da6e1f98-f25e-46bd-a0eb-acd7c2d735be','2016-08-08',NULL,63135,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'81887fc2-e1b0-452d-9870-cf402bf80c24',NULL,'0',0),('da79781e-8181-4c65-8fd1-fb74b9482a84','2016-08-08',NULL,253,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'de64e7fc-bcc1-431f-badd-e1ca9df3aa03',NULL,'0',0),('daa2f20b-ad71-4e8f-ad53-c92b2959fd21','2016-08-08',NULL,3456,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'1036ff8c-ba61-4479-8b3f-1089e236dd18',NULL,'0',0),('dac0acc3-cd25-44a1-b269-5d3494c2afcf','2016-08-08',NULL,870,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'0dde6cd4-61ee-4ae4-b272-7ec50af92bc8',NULL,'0',0),('daca98b9-f10b-419e-9a3e-d4318e93c1ef','2016-08-08',NULL,906,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'0dde6cd4-61ee-4ae4-b272-7ec50af92bc8',NULL,'0',0),('dacc874f-991a-40af-9338-fbae4dc5eb89','2016-08-08',NULL,4099,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'43afb9fc-1f57-4e00-a93b-bf51de20e7e1',NULL,'0',0),('dad5e5da-1c5e-4bda-93fc-3d5bfbc22126','2016-08-08',NULL,21735,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'4c661b0f-2e20-4d75-9dd6-c2b2a075f136',NULL,'0',0),('dad81c58-b117-4588-b474-2f7fd0f72e33','2016-08-08',NULL,3106,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'90b36043-8450-49a1-be3f-83b984481551',NULL,'0',0),('db2558fd-9b14-48ae-bc12-553959a5e90c','2016-08-08',NULL,11040,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'b85869e6-1f03-4be5-9f4a-74a0646c0272',NULL,'0',0),('db59dbea-09c3-4357-ba9c-4856ba7d1398','2016-08-08',NULL,7203,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'71f37d5f-4a06-4757-9d36-e1691aea628f',NULL,'0',0),('db902939-044c-406d-9eb5-028be66aa569','2016-08-08',NULL,13455,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'6977de00-516c-4a83-bb4a-c62cdf78c088',NULL,'0',0),('db970dbd-adcf-4fca-9888-172db12c63f7','2016-08-08',NULL,65880,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'56c34599-fb09-49f1-b19a-09dbe50f41fe',NULL,'0',0),('dbc99bb4-a41e-4710-a2bc-ca4cf544de27','2016-08-08',NULL,14748,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'39832a2f-9e73-472a-910b-4a5e4081ce99',NULL,'0',0),('dbdb22a6-41a4-4882-916e-253e061b7314','2016-08-08',NULL,713,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e815dcda-c91e-45e3-9fc1-dd2a575e6e73',NULL,'0',0),('dc260049-7647-4271-95cc-03b95772ae1f','2016-08-08',NULL,4223,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'94e09848-c3cc-4302-89eb-25b1e4a7880d',NULL,'0',0),('dc4aab29-bd44-4beb-944f-5c8e1bcf0122','2016-08-08',NULL,7128,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'ff34b5dd-f600-4492-9c76-8d34d8589e0f',NULL,'0',0),('dc662b16-a233-4d8a-ae42-570c64c5f879','2016-08-08',NULL,15456,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'16865428-073d-4cc3-8da7-f55793296e21',NULL,'0',0),('dcb285ac-4db6-477f-95e0-78c5382400f1','2016-08-08',NULL,4320,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'d9a62fb7-6ef1-4dd9-893a-0d1fb92ec830',NULL,'0',0),('dd08f74e-602f-4186-b3e0-3fcb1f2e0aa2','2016-08-08',NULL,260,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'756a6964-9037-44fc-aa3b-ce6dd9cd062d',NULL,'0',0),('dd17e0aa-e8d0-468d-84f4-1dd1ef2eef7e','2016-08-08',NULL,14256,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'70bc2b1a-2985-4f27-a201-38796f2b5fa5',NULL,'0',0),('dd63a226-0237-49a9-972f-65fa53938ad6','2016-08-08',NULL,37882,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'3d9d81c3-3528-40a0-a29a-a34658dc8075',NULL,'0',0),('dd8d4ba7-8a6e-4f86-a2ea-31e52d4241b3','2016-08-08',NULL,39531,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'9fd7b7e8-0265-463f-b973-bac85c31abf4',NULL,'0',0),('dd90d677-c5d7-4e55-9aad-1d7ffdac9f84','2016-08-08',NULL,2614,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'084ecea3-20b9-47fd-a75b-b5bc0f6cbd69',NULL,'0',0),('ddad6fc8-c8f0-4090-9e74-b3beac677a3d','2016-08-08',NULL,5589,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'830d777f-32bf-475f-b03b-aba72906c82c',NULL,'0',0),('ddb654a0-5b16-4948-8f69-aef5a8f906e5','2016-08-08',NULL,3665,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'8f7a2349-7fc0-45d6-89a0-792d076077ac',NULL,'0',0),('ddc1de70-3377-4c84-a25a-0272399fe8f9','2016-08-08',NULL,778,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'ba451c8c-1999-4ee2-b4da-3e52f18e109a',NULL,'0',0),('ddc7453f-0382-43b1-beb5-951f25a43c50','2016-08-08',NULL,6624,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'6e17ec90-63af-41c3-8cac-5bd946faaf82',NULL,'0',0),('ddd5e16b-7352-446e-922b-097d597312b1','2016-08-08',NULL,164875,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'561e3e8a-72c4-4cc0-9a4e-55af1ee4d97a',NULL,'0',0),('de09f881-0ed8-417b-87d4-4321826ada14','2016-08-08',NULL,8100,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c5ce14c5-1410-4628-8421-e378e664a208',NULL,'0',0),('de1740b8-fa55-475f-95fa-aa6d307479b4','2016-08-08',NULL,743,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e815dcda-c91e-45e3-9fc1-dd2a575e6e73',NULL,'0',0),('de334ae7-4294-462f-b859-f653155e5df4','2016-08-08',NULL,5693,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'805eab32-9eb1-4345-8d2a-cca424169ae5',NULL,'0',0),('de51d96a-de73-4276-a7ae-d0e700a47bca','2016-08-08',NULL,446,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'53d674c2-6f13-48bb-b4e2-3d2a39541852',NULL,'0',0),('de5e4c8f-f496-4c06-9910-efe413c97f32','2016-08-08',NULL,8279,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'bbcb16ce-b29a-4b33-b633-ebecb8211ea3',NULL,'0',0),('de783abb-6ddf-4370-a272-5038722db3fb','2016-08-08',NULL,1242,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'353c2ac7-a726-4211-a776-43a1d29ba313',NULL,'0',0),('de83aca6-de8b-4cb5-bbee-1cb12520e72a','2016-08-08',NULL,602,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'8f2016f0-d21e-4d6f-a661-360fd72135c1',NULL,'0',0),('de9345c7-6b34-4957-82ee-66f8496e8132','2016-08-08',NULL,2073,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'08b45e7e-9a17-4a42-a545-f23327c35785',NULL,'0',0),('decce4d4-f4b1-43b6-a1b7-119bd6de94dd','2016-08-08',NULL,216,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'756a6964-9037-44fc-aa3b-ce6dd9cd062d',NULL,'0',0),('defa2684-292f-4c52-8a5e-960934662dc7','2016-08-08',NULL,14283,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'8e9a55ff-80e9-4d17-a3d5-4f93ec7ac323',NULL,'0',0),('df1e4494-354b-44bc-9e5d-060fa529bb5e','2016-08-08',NULL,2608,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'d39721eb-fa96-454f-bae9-d703cf4655be',NULL,'0',0),('df7984a6-1a93-427a-b956-d1d27639e36c','2016-08-08',NULL,7128,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'3e28f39e-bbcf-43c6-88aa-f5c29c3b2307',NULL,'0',0),('dfa5b82f-f8a6-4343-9b53-0714c8fb06d1','2016-08-08',NULL,2699,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'5062d5a6-46a9-40b3-8b47-d8967781b60a',NULL,'0',0),('dfbfdd05-a9dc-4d7c-a16b-483996b62229','2016-08-08',NULL,25876,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'b1e8d539-2fa7-4c11-bb0d-b6889fb8bced',NULL,'0',0),('dfd0c792-0a3a-469e-8a0e-1f7e7fce107b','2016-08-08',NULL,1901,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'1c477c16-a1b0-4982-8857-b9b7ee9fb986',NULL,'0',0),('e02cc8f0-1c37-4a04-9f53-131a2b9045e7','2016-08-08',NULL,404,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'dee9470c-6103-48e6-81e5-12b09412553b',NULL,'0',0),('e06ce4b3-48dc-41cf-ae6e-fe614bb61f08','2016-08-08',NULL,47196,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'940e364c-f540-402b-9228-3b00ab32c624',NULL,'0',0),('e07c0666-5faa-4af9-a5cb-d7dd257f5920','2016-08-08',NULL,5940,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'5ba92538-5b76-46c0-85cd-870ffb1b9db6',NULL,'0',0),('e0abc0c1-8cd1-42fc-a9f7-cd7b6357d849','2016-08-08',NULL,2717,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'8d590898-6df7-4a2b-98f6-7335961781ca',NULL,'0',0),('e0b27dc4-62db-4a98-bee8-2035a9a80149','2016-08-08',NULL,47196,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'ffd1c689-325e-4455-8816-ce31814996c8',NULL,'0',0),('e0b70880-f63a-4ecf-a3b6-8b0bad3507cb','2016-08-08',NULL,6002,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'981207d1-bb18-42a6-b9cc-665574d22b62',NULL,'0',0),('e1037fcd-9d19-473c-a906-1abb18831e2a','2016-08-08',NULL,325,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'dcd20c6e-35f0-49f4-9d9d-d3ec1f966159',NULL,'0',0),('e11023cb-e7e8-4284-afe1-fac720e494a0','2016-08-08',NULL,10930,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'9eab9be0-7355-4001-86b3-d701aafa247a',NULL,'0',0),('e116e1d2-e7c7-43b8-8bb6-c754a75c2c2f','2016-08-08',NULL,6406,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'62d86106-b325-4359-b9ec-268e745553ed',NULL,'0',0),('e12afccd-9d7d-4274-83e4-24b180af8702','2016-08-08',NULL,378,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'616d646d-4e53-45c4-a584-f657a6cccb09',NULL,'0',0),('e12bea0c-d1fe-411a-bb34-d71cf1f45f45','2016-08-08',NULL,453,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'dd4d9de7-b0b4-4bf2-a095-cb2e876a2899',NULL,'0',0),('e1481dae-5d89-4a67-bdac-19911fd065fc','2016-08-08',NULL,1119,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'007e27fa-9f94-47a2-a70a-115654f1ae31',NULL,'0',0),('e14cf544-68c9-48fa-b68b-4a332188d98e','2016-08-08',NULL,23805,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'35732a5c-88cb-4012-8712-4a60bf5628eb',NULL,'0',0),('e15d3b91-f5cf-4b3f-ac93-4596ce76f040','2016-08-08',NULL,8279,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'02969de9-2b60-4a29-bbe9-563ebd952079',NULL,'0',0),('e160c0c5-4606-4cea-842b-bab30ca3b548','2016-08-08',NULL,12419,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'bccb7f35-5065-4ef0-997a-839c35d8f804',NULL,'0',0),('e17875a4-f920-4d7e-89c4-3a76f51df474','2016-08-08',NULL,43832,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'5138aa27-233b-4d0f-bbfc-47152952a31f',NULL,'0',0),('e1a39680-653d-4cdc-b278-6b15c11ed2ee','2016-08-08',NULL,518,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'4b062d45-5166-4864-88fa-3b8fe398a933',NULL,'0',0),('e1a4de1c-564c-4a3a-ae64-411dfd63eb65','2016-08-08',NULL,20250,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'b3437189-8abe-4895-b6e3-f09f4a0fca5f',NULL,'0',0),('e1bb7c4f-aecc-4392-93d8-7858bdfff4f5','2016-08-08',NULL,41005,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'2a3c9db2-6252-46a3-a3fe-57523bd96c01',NULL,'0',0),('e1e060b1-ef02-4c56-b41a-23ae6a61a846','2016-08-08',NULL,777,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'7de23c6c-a740-4950-9dc1-a559453a4ca6',NULL,'0',0),('e1e84074-11b2-4a3b-adfb-ce46044fda91','2016-08-08',NULL,18113,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'4631afb4-5070-441c-8577-a4a546362f3c',NULL,'0',0),('e2086378-7cc8-4e28-a788-4a959606f6ed','2016-08-08',NULL,12296,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'7a93e08d-12b3-4643-ac13-abb218ef0624',NULL,'0',0),('e22974e0-e222-4580-ab2d-1f70f44efc8c','2016-08-08',NULL,28463,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'3e9aef4d-7b15-4cab-9e07-84245b9a7090',NULL,'0',0),('e22f5040-515d-40a3-961f-8e3497f27af9','2016-08-08',NULL,2835,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'44315dc2-e2fa-44dd-8de8-8330ed4de153',NULL,'0',0),('e2453716-0ff8-4e95-8db7-9a24352b13c7','2016-08-08',NULL,8841,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'7e96a11f-735a-4afe-84d3-a229d863b834',NULL,'0',0),('e254ac2c-0b5b-4d38-ba10-ec77947a1843','2016-08-08',NULL,1215,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'723ccfad-6157-4421-9647-3aa8fc6d4ada',NULL,'0',0),('e29914cf-f5cb-4dfd-a629-b19b8805218f','2016-08-08',NULL,2608,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'0d3e03de-e3a6-41f9-99f0-f53f1764c3fd',NULL,'0',0),('e2a802dc-643e-49d6-9989-ac40b50135b2','2016-08-08',NULL,238,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'f2d7c2ca-54a3-423f-9499-0f06333a9910',NULL,'0',0),('e2c3bba9-d4b5-40c3-8ac4-d39296b8e586','2016-08-08',NULL,8818,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'d2662251-68b7-40b4-bdc2-0676f5426730',NULL,'0',0),('e2ffe646-3337-465f-b5b9-7c7d656d7123','2016-08-08',NULL,10349,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c1ffa627-94af-4280-b9ba-8860742229dd',NULL,'0',0),('e343fbf5-3955-44f0-8ed1-e0f71aa20ed4','2016-08-08',NULL,1101,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'554e6acf-fe8b-4b05-ae61-78459743c39d',NULL,'0',0),('e3519e9c-b89c-46e5-b670-69383dc99d58','2016-08-08',NULL,5900,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'a51eaf49-7f7f-4e87-a3a2-d0099ca70880',NULL,'0',0),('e3ccc13b-7cad-452d-a749-425098f07a78','2016-08-08',NULL,797,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c6379235-1283-482d-926b-b1ca038e1f2d',NULL,'0',0),('e3f861f1-bcf8-4341-9878-5ba1cd9042cb','2016-08-08',NULL,1552,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'ff17b5c0-4ddb-4aaf-aed0-27d0823c2784',NULL,'0',0),('e40a1250-3d0c-4766-96c5-9e9a60075ebe','2016-08-08',NULL,54269,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'d29a5c7d-225f-4b41-b036-88e2315ee949',NULL,'0',0),('e41d842f-2d44-4518-a692-f9dd5b997f57','2016-08-08',NULL,373,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'412a5592-b458-4ca6-9e93-ebc6459ad9f7',NULL,'0',0),('e436155c-50eb-458d-afb9-525ea13816f5','2016-08-08',NULL,19734,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'4e6b8e5d-2296-42a4-9cfc-35b0907fcdd1',NULL,'0',0),('e45eb9a9-6151-4201-bb09-64fbb46f9726','2016-08-08',NULL,16918,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'82b32d45-0766-4c17-bfa2-855793ee7e8e',NULL,'0',0),('e47c2972-4de1-41e5-a9fa-2400c344adda','2016-08-08',NULL,165,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'6e5cc3e8-2eab-4709-b6f6-02ffd02ccc99',NULL,'0',0),('e4bdcc6f-ba43-4b37-9b00-68e6b99ef50a','2016-08-08',NULL,3327,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'b23d48e6-88f6-4415-a774-824d604613e7',NULL,'0',0),('e5009a91-0044-4e62-b7a4-0b6bdf538847','2016-08-08',NULL,10349,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'bbcb16ce-b29a-4b33-b633-ebecb8211ea3',NULL,'0',0),('e510f9fb-a403-44d0-b0af-8c28385d23ae','2016-08-08',NULL,10879,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'9802b6fb-0db0-4e66-8938-26afdccbcb53',NULL,'0',0),('e52b908c-53e0-4d48-ac36-92fabaf9e6ef','2016-08-08',NULL,6831,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'9b41758d-7e48-48ec-b404-68266f47a57d',NULL,'0',0),('e53d954a-1ef3-4c51-964c-0a794d93462f','2016-08-08',NULL,756,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'43eecce1-b6f8-4ed1-a8f6-3f029d3bc1d6',NULL,'0',0),('e553a444-cd85-42f9-85b0-0509f3061074','2016-08-08',NULL,778,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'f9a025ce-bd2b-4ae6-b627-acae3d66bdf1',NULL,'0',0),('e5771fce-62ce-40b2-8ecc-799299fd7485','2016-08-08',NULL,429,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'35ab31ab-55d9-4b61-97e8-fc6b718fd265',NULL,'0',0),('e57cf2b2-6ee7-42ce-958e-d2fc07a0df66','2016-08-08',NULL,1568,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'2d3ab83d-cda0-4f36-8974-c4f72b10cd20',NULL,'0',0),('e583f8b3-e9f6-41df-903a-9367c1932f2d','2016-08-08',NULL,322,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'d9542fb1-bfa9-4556-be69-60e36511ae01',NULL,'0',0),('e595ecb4-19c3-4c88-a450-b580e2c08765','2016-08-08',NULL,6335,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'45aa3047-9d7f-47e7-acc4-5b66206c38ab',NULL,'0',0),('e59c687d-41be-42fd-8c35-6210231d8c48','2016-08-08',NULL,518,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'715941ea-e398-49a7-b9e2-53d8a5f0baf1',NULL,'0',0),('e5ab3d8b-6a26-43d2-9f56-2eb5ace439c6','2016-08-08',NULL,35100,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'db75c674-4ed2-44ce-bcd8-e1d3a51625fa',NULL,'0',0),('e5fda1e4-988e-49bd-99a9-365f86800077','2016-08-08',NULL,7116,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'9e3c398b-3c45-49a6-bb2a-0367a986a1e6',NULL,'0',0),('e60d6996-6b81-4fa0-9641-13ba0ad7ead3','2016-08-08',NULL,1967,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'fb09b5bb-4361-4bd1-a72e-2618b1347f50',NULL,'0',0),('e60eceee-d5b8-47ab-a2af-c7158a32de9b','2016-08-08',NULL,15525,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'b83db7ea-3f9a-40c7-9366-8cf56fe62584',NULL,'0',0),('e638c7e0-a828-4008-b51c-78716fb5a438','2016-08-08',NULL,3106,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'327685f6-7192-4d97-9e74-a3d82d88482f',NULL,'0',0),('e6ad9082-2830-4846-8ca3-5a0638dbcd16','2016-08-08',NULL,18941,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'87cfce04-958b-446e-b8d3-7c6d8f7cc662',NULL,'0',0),('e6c4047f-2c53-4955-bb3a-3129713c5a64','2016-08-08',NULL,49163,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'940e364c-f540-402b-9228-3b00ab32c624',NULL,'0',0),('e6eab313-4b3e-4bf6-9eaa-6aae75c3745b','2016-08-08',NULL,404,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'02537a79-aa55-4a81-8b22-f16f4cf0071e',NULL,'0',0),('e7086069-73ef-46cc-80ea-9295fcb862a3','2016-08-08',NULL,1266,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'723ccfad-6157-4421-9647-3aa8fc6d4ada',NULL,'0',0),('e75d6743-72c7-4a62-a5a9-e354d5df0021','2016-08-08',NULL,8539,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'7fcef193-3548-48fc-aeb2-9ef94dacb13f',NULL,'0',0),('e768f4e6-908e-4efc-91d2-017718412aa2','2016-08-08',NULL,28628,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'adc12893-097d-4c38-bbbd-6264ed8bbf3e',NULL,'0',0),('e79f6e6e-a9b1-4c64-99c1-d4087dbd5e06','2016-08-08',NULL,945,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'d30ecb66-2dbc-479c-b189-ab867dca4473',NULL,'0',0),('e7a6f1db-b9ad-4bf7-9749-d1ec86832d92','2016-08-08',NULL,28289,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'36574898-6c20-4cc9-addc-8e6a68ca5cb9',NULL,'0',0),('e7cff177-f264-40d5-8e6a-d8ee45ce8976','2016-08-08',NULL,294354,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'9a6d59ef-1828-42ff-a4b8-54cf1a02ccbf',NULL,'0',0),('e7d32da9-c08a-406c-a280-29aac2e6400d','2016-08-08',NULL,810,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'f9a025ce-bd2b-4ae6-b627-acae3d66bdf1',NULL,'0',0),('e800479c-fab4-4e73-aeed-74488d9c0155','2016-08-08',NULL,5601,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'5aef0cff-d054-45c2-a26e-98e57f13544b',NULL,'0',0),('e8043aad-c3ad-4aa5-a313-57e901e72e04','2016-08-08',NULL,7917,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'89fad77b-ec05-4e93-98b7-2fbe43971f7f',NULL,'0',0),('e824469a-aac5-4962-937a-40fc975abb90','2016-08-08',NULL,24420,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'9aa311e3-468a-4e00-b8e1-304a6c7539bf',NULL,'0',0),('e89996d6-c9fd-4607-bd1a-b934dd579add','2016-08-08',NULL,6469,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'ed875474-f3f2-4d79-b94f-9db4b3fe5ad0',NULL,'0',0),('e91c913f-3928-4c44-aacc-cc799945e035','2016-08-08',NULL,16249,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'9b8d9856-f332-42c0-8400-ab7318cdd351',NULL,'0',0),('e9a1c59e-3c11-428e-baa7-6724179882e4','2016-08-08',NULL,1863,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'8573a3b3-2381-4989-8194-1d966e8652ef',NULL,'0',0),('e9a92ad5-6cbf-482f-8553-4cdb7eb1daf2','2016-08-08',NULL,1035,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'7819a076-6e2b-40d6-8fb5-82352074c6c5',NULL,'0',0),('e9b0adb4-3464-4c9a-80ff-6cb48e2b048d','2016-08-08',NULL,27885,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'5e0061bd-4ce4-4bfd-9568-d82450b30e36',NULL,'0',0),('ea02c5b2-152d-4525-b2ec-609e05ac18c0','2016-08-08',NULL,15137,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'39ec1054-d8a8-4e7e-84fc-984740b0f8f2',NULL,'0',0),('ea085d4f-1643-4511-b316-82b53a6d517e','2016-08-08',NULL,4269,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'984707b1-d587-4507-9309-a91b132bfb98',NULL,'0',0),('ea17846c-9def-44a6-9980-8e00c7fbec1e','2016-08-08',NULL,6210,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'65226da3-5150-408e-94f0-dd3c4eb90443',NULL,'0',0),('ea17e776-5c8c-44e0-a3ad-95b92992c6d3','2016-08-08',NULL,19499,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'9f9deb9f-6bff-441a-8f97-d5caca47ffff',NULL,'0',0),('ea61d0ae-5cf7-4def-a814-28be30759b0a','2016-08-08',NULL,8400,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'6ef114dd-7073-45bb-8b29-c3d8aae1c636',NULL,'0',0),('eaa09329-f8d9-416a-b254-e60ba874d74a','2016-08-08',NULL,2345,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'5e3725dd-9e90-41d5-834a-80bfb0b40a79',NULL,'0',0),('eb02e48d-912e-4391-9a61-70bee808e676','2016-08-08',NULL,64800,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'7402a1f5-7001-4009-a5c4-29b9e09f7a56',NULL,'0',0),('eb2d0c02-32ba-43cf-8a59-51a9c3ffbe60','2016-08-08',NULL,929,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e3b20e37-4d91-47d4-8558-99491bb737fd',NULL,'0',0),('eb620e28-d3a6-4fe1-bc72-7bbbe7797b9f','2016-08-08',NULL,27169,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'53d8fc10-c72b-46e4-ad97-dee6500c19d6',NULL,'0',0),('eb7e2585-7ef0-47dd-8d6b-f9a8af93d005','2016-08-08',NULL,1188,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'841c39b8-6ee9-48a1-9b58-2b480ad0c0d1',NULL,'0',0),('eb8ec4a7-f930-43ba-9925-2d86b4533118','2016-08-08',NULL,25493,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'9bb8e3e3-3b08-411a-a7e6-43148c5cc4f6',NULL,'0',0),('eba3d930-b004-4616-b44f-dd124b89cf1a','2016-08-08',NULL,1009,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'964743e6-56d8-49bd-8441-67ac6fa3b795',NULL,'0',0),('ebb5e2be-5b6d-4241-b99e-ac50b7cf1b3a','2016-08-08',NULL,5589,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'63117b43-e0d4-4cb0-bd97-088027d7be28',NULL,'0',0),('ebd0fd55-5123-49d8-b402-1ce617cc3534','2016-08-08',NULL,1876,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'5e3725dd-9e90-41d5-834a-80bfb0b40a79',NULL,'0',0),('ebe0d8d7-3622-42eb-9720-137e0e0ae6e8','2016-08-08',NULL,5822,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'dd0751e7-c88c-473e-94eb-955bd6e0ea8b',NULL,'0',0),('ec4db4bf-0ef3-474c-938e-abb3a1b70598','2016-08-08',NULL,12420,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'58bddaf4-9a09-4467-a875-076afa91c497',NULL,'0',0),('ec5223f4-5d23-43bd-8220-ea96f0c0f57e','2016-08-08',NULL,19370,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'6076d39a-51dc-4d7f-b59b-8a81bd1e601d',NULL,'0',0),('ec666c7d-8e43-47f6-921c-4e558b0fd956','2016-08-08',NULL,26730,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'a26b1643-5f37-4b51-b449-2c77bb73b2e2',NULL,'0',0),('ec92f99c-71a9-4da5-9973-50f1d65f528a','2016-08-08',NULL,41400,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'2223495a-8eef-4757-b33c-27fb7646d4f5',NULL,'0',0),('eceb8cb8-9b06-4897-9446-c348151446d5','2016-08-08',NULL,3036,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'665c04ae-578b-4cd8-b1e9-933f12d34994',NULL,'0',0),('ed02229f-d7dc-45fd-870c-f7df1e9b599d','2016-08-08',NULL,348,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'de368c77-e855-4ee6-bbb4-89194ee66380',NULL,'0',0),('ed1a7bd8-b4bb-442f-a450-43cd18b6a808','2016-08-08',NULL,55407,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'7867372a-5231-4c40-be88-92a77ce74340',NULL,'0',0),('ed3b2404-e370-44ec-a111-e3fbd5f7bfdd','2016-08-08',NULL,135,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'44b4fbde-329c-4d62-aebf-e51e7317bf76',NULL,'0',0),('ed6e73c2-c506-4652-bd75-412de668f875','2016-08-08',NULL,822,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'f22d2038-bf3b-4868-bdfc-c963a6e5c5ec',NULL,'0',0),('ed70e2cb-f7c6-4162-a5cb-6205c8ab9507','2016-08-08',NULL,31878,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e2cf3f60-28f2-452a-b3f4-19b7dbb4caec',NULL,'0',0),('ed7de320-6b19-4218-aa34-6d1357297382','2016-08-08',NULL,1350,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'528ead48-3584-468c-aaa1-5484a33230f7',NULL,'0',0),('ed92ff18-900f-4ad6-bb41-8cfd0aa3b52c','2016-08-08',NULL,32401,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'34cb8dc5-05db-4754-a6f0-753c331fcbe7',NULL,'0',0),('edaf702e-f6ff-418f-aec7-eeaee55e2be7','2016-08-08',NULL,46449,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'de8c5b61-d15b-47dd-8cc2-a4a75be4c43b',NULL,'0',0),('edfe1b01-4c80-490f-bfe2-133d4580c668','2016-08-08',NULL,7425,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'3e28f39e-bbcf-43c6-88aa-f5c29c3b2307',NULL,'0',0),('ee233947-946b-4385-901c-9aff6705cbf6','2016-08-08',NULL,9688,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'90b93b2a-34f8-43f5-957f-cb47a4551120',NULL,'0',0),('ee250c38-a2f8-42d3-937c-ad8d9e10c8f2','2016-08-08',NULL,3465,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e30c8882-bef9-4f25-8321-ac843a963e44',NULL,'0',0),('ee3dc95c-6a46-4457-bb50-9d6ae3b234c9','2016-08-08',NULL,14850,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'04715b9f-36c0-4c0f-9377-a8f4b42dadff',NULL,'0',0),('ee411867-9ea8-40d4-aa0a-0efe5e2054e0','2016-08-08',NULL,10673,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'7fcef193-3548-48fc-aeb2-9ef94dacb13f',NULL,'0',0),('ee65d1dd-796a-4bc2-a7ba-a22777751a1e','2016-08-08',NULL,1122,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'99574587-106f-4cca-8241-5ee3aa395b1d',NULL,'0',0),('ee82d857-f2c1-46de-837d-c15ec0cbf005','2016-08-08',NULL,9962,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'41bd6355-9d61-47b9-bb0b-ceda1aae21fc',NULL,'0',0),('ee91e77a-0609-40d0-b354-781eff3fdf91','2016-08-08',NULL,2173,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c1a2f65d-8640-4296-a54b-aaa1e3d635d0',NULL,'0',0),('ee961983-16dc-421a-9c24-0d5fbe14defd','2016-08-08',NULL,9185,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'d2662251-68b7-40b4-bdc2-0676f5426730',NULL,'0',0),('eef3bb48-46dd-474f-b278-c85b49fd9ef0','2016-08-08',NULL,3374,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'3970bb04-951f-4143-9f9a-9c5bedef7140',NULL,'0',0),('ef0b84a0-b1f6-4658-be30-3345567d676b','2016-08-08',NULL,16146,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'baa27c38-f9aa-49a3-8bc4-f63796d77a83',NULL,'0',0),('ef1fcfdd-8a6c-49e7-8bf4-5580bb06fde4','2016-08-08',NULL,891,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'7fc2f37e-fcaa-485b-a008-180b15bc9d79',NULL,'0',0),('ef373b66-dfaf-4745-b5ff-2cccd3ee09e9','2016-08-08',NULL,3882,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'bead6344-7eff-4998-9733-67ba6c78599d',NULL,'0',0),('ef3d2caa-d568-4b6e-9660-f6ad66660e4a','2016-08-08',NULL,27337,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'3d56278b-58dd-4f82-9169-d8a478a21b43',NULL,'0',0),('ef6a98b0-72b0-4cea-8500-1658b974f58a','2016-08-08',NULL,2593,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'f886c2b4-d114-4212-9569-b3f9ea49e1a1',NULL,'0',0),('ef74eb45-b61f-4f4a-a3a4-a461e3b49ebf','2016-08-08',NULL,24149,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'6b2cb11a-7607-48e6-ab8d-850cb701e1c0',NULL,'0',0),('ef7c6e58-76be-4ad4-b675-4dbdf183e1d8','2016-08-08',NULL,3795,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'665c04ae-578b-4cd8-b1e9-933f12d34994',NULL,'0',0),('effc5368-8213-47f9-b776-87ff07ada795','2016-08-08',NULL,37800,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'94d89cc9-8269-4c90-b501-bb4f85d23f81',NULL,'0',0),('f019a7ed-86ad-484e-9fa9-34fdb2b2595e','2016-08-08',NULL,5305,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'642632bb-2fdb-44e0-be92-e24ae6af802c',NULL,'0',0),('f037be09-80cf-45ce-a00e-5cf9b62cde4a','2016-08-08',NULL,6210,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'ac5376fc-baaa-42b0-98ff-e1ecd592912d',NULL,'0',0),('f0470fa9-1b5d-4c8f-98a7-dde12bf7eca3','2016-08-08',NULL,21926,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'8a47259e-e3d5-461c-bc20-184270f4f11b',NULL,'0',0),('f0623e72-47a5-4dfd-8d4c-09b7d26f10ff','2016-08-08',NULL,310,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c4f5582b-8803-40b9-80b6-ab99209894d5',NULL,'0',0),('f0691cb2-e29b-4f34-8e50-2e1aaae3f08a','2016-08-08',NULL,1863,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'7b1dcac2-0048-49b3-9f6d-88b48268c161',NULL,'0',0),('f06cc3c7-d574-4ca1-a175-0fc57f7afd46','2016-08-08',NULL,1028,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'f1ff98e2-3203-49de-a537-0e22f16d8e3f',NULL,'0',0),('f0aeafe9-06ab-42b0-b7ae-ee6eb16354d5','2016-08-08',NULL,324,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c7ebf076-3e1b-4c45-985c-3cd09fd3ecba',NULL,'0',0),('f0bc81ac-feb7-4605-903d-913fdb446e09','2016-08-08',NULL,2916,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e166d6d7-7cf8-4e5c-a13a-4499d9762f7f',NULL,'0',0),('f0c46620-0d20-4f0c-89dd-9fb0afe97212','2016-08-08',NULL,285,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'401f52f9-0183-4466-857b-aa5e512fa4b1',NULL,'0',0),('f0e7ef87-e7f1-4339-860c-a55171da52f8','2016-08-08',NULL,68310,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'b8cf6bda-59f3-4a48-b9de-f5d8712fde54',NULL,'0',0),('f0f1dee3-01ea-4bec-bb5c-af0b3b625dab','2016-08-08',NULL,20125,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'9e8cc1ec-e2fe-41c1-af4c-ed7aab6c0df7',NULL,'0',0),('f0f498fd-45da-41d4-b0aa-3f30d96a14f4','2016-08-08',NULL,21600,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'e6ca24a3-cd1f-42cb-b39b-f9569ffda976',NULL,'0',0),('f10ecb4f-f6de-46a1-8e43-7c7dd299aa1b','2016-08-08',NULL,10436,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'90cea514-a24c-4f8c-b37a-9b868acac2ae',NULL,'0',0),('f11d54b2-905f-48e0-8498-37a7c69ddddb','2016-08-08',NULL,871,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'8c857058-ba14-46fd-b220-4cf196a557d1',NULL,'0',0),('f12db54b-67fd-4717-aca6-431fd8cd9bd0','2016-08-08',NULL,404,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'6d78718a-6d47-4434-ae4e-fb33df9a0714',NULL,'0',0),('f14a570b-c15c-4b0d-9a20-d105bcfa120a','2016-08-08',NULL,30597,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c2ebfa2f-486d-4784-bb85-8e5524da2ba4',NULL,'0',0),('f1743ad0-19fa-4b54-8de7-bc7459fafda1','2016-08-08',NULL,15525,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'58bddaf4-9a09-4467-a875-076afa91c497',NULL,'0',0),('f17dba63-0618-49f9-bce5-34bca6edbc48','2016-08-08',NULL,5940,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'9b45d4b2-297f-4b31-8029-343daa7a39a2',NULL,'0',0),('f1a7d6a9-893d-4f53-ada9-019b9de072ee','2016-08-08',NULL,7452,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'60725462-8375-40e5-8b76-2b92291b91a2',NULL,'0',0),('f1f704e0-88d4-4c7a-ba42-b757a840022c','2016-08-08',NULL,9935,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'4f829a87-bbba-452c-968a-7d3c063ec45b',NULL,'0',0),('f1fd07e7-3ff6-4c47-9112-5671a96fc3bc','2016-08-08',NULL,1186,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'b48edec6-7d45-4685-ac79-67d694fe6981',NULL,'0',0),('f28b9df8-40ed-4e6f-bed3-1841fad694bc','2016-08-08',NULL,1293,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'4462502a-223f-4d8a-9814-1ec1a96574c4',NULL,'0',0),('f29db7f6-05c1-4cf5-bcfe-677ea0ea568d','2016-08-08',NULL,162648,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'f9264f22-8676-4d49-bfc7-cc4f30adbafe',NULL,'0',0),('f2a21a53-72e4-4e35-9350-957395ba9634','2016-08-08',NULL,4244,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'0db1619a-3d5d-4dd2-a294-af7ab18f09a5',NULL,'0',0),('f2aecf63-f3a1-4fc3-af49-48c66697b195','2016-08-08',NULL,610,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'cd61cb27-850a-48c4-8a5c-f51db64176e3',NULL,'0',0),('f2cf29cb-cc53-4d48-b197-d145ab26a3c4','2016-08-08',NULL,2070,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'552a43b5-8cb6-4d1d-94f3-1d85131a3d33',NULL,'0',0),('f2e34da2-f9a6-4fe0-b7e5-071f9d45fe7c','2016-08-08',NULL,14296,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'8b60e990-a11a-45bf-b90c-83ccda6aac8e',NULL,'0',0),('f2f75a28-8d82-4f8e-ba97-f5c0cdc6441a','2016-08-08',NULL,24452,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'7fddbe26-7a42-4719-9fda-115517d449f0',NULL,'0',0),('f3013e34-140b-4216-acb7-8005460a02a5','2016-08-08',NULL,9935,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'822121a6-1bd2-4bea-8e30-109fc6d72492',NULL,'0',0),('f32f96c1-4dbb-42db-84bf-330a37dffe5b','2016-08-08',NULL,30525,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'3bcf2b03-f78d-4b94-9083-b6ef6ab40739',NULL,'0',0),('f354a0ea-b87c-4df1-93a3-fde159db2cb0','2016-08-08',NULL,5383,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'3e700502-6382-4f52-a5df-175e7407dc4c',NULL,'0',0),('f361b902-343a-4ba8-bd1c-76db67471b84','2016-08-08',NULL,28620,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'635fb567-5a30-46a0-92e9-d24c2bf9340f',NULL,'0',0),('f37b660b-df5e-4f16-b24c-dc4beca4f562','2016-08-08',NULL,22137,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'ee715dd7-b854-4c08-ba5a-17e0b4ac8add',NULL,'0',0),('f3b66fc4-d21b-40a3-bfdf-82708a7ce37b','2016-08-08',NULL,2633,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'ca2e5c36-4bbe-4c04-a356-e9ca17e4cc71',NULL,'0',0),('f3d825f2-f2fe-49b5-83f2-38f6e8b1ae81','2016-08-08',NULL,1863,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'ce29f97c-702e-4ef5-a941-fee79081fe66',NULL,'0',0),('f4177b57-2953-486d-887e-75a963633f60','2016-08-08',NULL,1101,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'8c0032ee-f608-456f-8986-850db19c98c2',NULL,'0',0),('f4b4e9d8-19b2-473a-98f1-eb3cada7740e','2016-08-08',NULL,6480,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'fff81e0f-ed13-4065-8c65-36a9ac7c72fe',NULL,'0',0),('f4b5c57f-8959-4395-b300-36dfdd7793f9','2016-08-08',NULL,8073,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'23e3d105-5d65-4bbf-a54f-fa527ee68aff',NULL,'0',0),('f4bae969-6607-413a-8c1f-05b9c6cc49fa','2016-08-08',NULL,74606,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'0b7c70bb-e354-4250-8931-5fe10e2a78f0',NULL,'0',0),('f4d47f52-f129-4dbd-a99e-7058f7f86996','2016-08-08',NULL,1403,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'99574587-106f-4cca-8241-5ee3aa395b1d',NULL,'0',0),('f4f40fce-491e-4140-89cb-9161a34d2916','2016-08-08',NULL,16818,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e5f22872-81b5-4b95-9918-8b1d9a53c654',NULL,'0',0),('f51c77a7-1b39-45c3-846a-04d1e56221f3','2016-08-08',NULL,27408,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'8a47259e-e3d5-461c-bc20-184270f4f11b',NULL,'0',0),('f5211280-60b3-4657-967a-1305ab8bea52','2016-08-08',NULL,413,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'93bcac5f-f791-47d7-8bd7-c4973506029d',NULL,'0',0),('f521b117-24c6-4b7d-ac07-294ec146cbec','2016-08-08',NULL,9935,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c1ffa627-94af-4280-b9ba-8860742229dd',NULL,'0',0),('f530d2fc-b748-4c60-9ee1-fbd6b127a0fa','2016-08-08',NULL,444,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'d8125419-2e6a-4f03-91a0-ea1675890f32',NULL,'0',0),('f53c3507-9583-4f40-9380-f960b5f83113','2016-08-08',NULL,1296,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'936f4c03-b603-41a6-b078-dbfe54b06563',NULL,'0',0),('f554aa92-42a8-4c5c-a4e2-dd5371718723','2016-08-08',NULL,15306,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'9a2c13fd-a142-46ec-8551-4bc86e1a7626',NULL,'0',0),('f5c57109-4170-4885-87e7-f33aff10528d','2016-08-08',NULL,153896,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'0f2fd2e2-3ab1-4a57-a327-2d11215facb4',NULL,'0',0),('f5ffd5ac-fc1d-4ceb-ba11-27a9beb2cd1e','2016-08-08',NULL,34344,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'635fb567-5a30-46a0-92e9-d24c2bf9340f',NULL,'0',0),('f62362de-7923-4e2a-aae3-fae431b48c0b','2016-08-08',NULL,3623,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'eed89e3a-292f-40c0-9d8d-f14085205184',NULL,'0',0),('f62910b5-e00f-4acf-a2a8-d24553fecc98','2016-08-08',NULL,6002,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'8af03560-3305-471c-8325-9b7acff96352',NULL,'0',0),('f64d4329-bfb1-4666-8b3f-4c7952053d2a','2016-08-08',NULL,4331,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'e30c8882-bef9-4f25-8321-ac843a963e44',NULL,'0',0),('f67b0022-e903-49bc-ab61-441b7fc5f52e','2016-08-08',NULL,7203,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'8af03560-3305-471c-8325-9b7acff96352',NULL,'0',0),('f68db3ea-cd73-4c66-abee-d571df24513c','2016-08-08',NULL,31020,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'dfe53a5f-f3cd-4930-bf99-2ef553ea9cba',NULL,'0',0),('f6a4eaaf-bc43-4603-84f3-78d2f320cd82','2016-08-08',NULL,2932,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'8f7a2349-7fc0-45d6-89a0-792d076077ac',NULL,'0',0),('f6adf339-ee4c-434c-a653-05a678618da3','2016-08-08',NULL,24095,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'1494e6ac-0838-409b-8171-27a4e9c793c6',NULL,'0',0),('f6dbd6db-f16f-4e29-b289-d130c02dd3a7','2016-08-08',NULL,855,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'04761771-d7fe-4fd2-bbea-d0054d8843c5',NULL,'0',0),('f70b4e35-beef-4599-b017-e09eda24d8f5','2016-08-08',NULL,72450,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'eb415c97-7236-4ac9-9a09-944282ea9575',NULL,'0',0),('f71e4b22-ff9e-4f32-9acd-d78c053a03f7','2016-08-08',NULL,27035,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'cc980e92-7d48-44d2-af07-2c9f66675e5a',NULL,'0',0),('f7270c5d-689f-4a8e-ad44-8c77d7aa7e83','2016-08-08',NULL,27001,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'7e21826c-82b4-4d84-82a7-b2b77078a96c',NULL,'0',0),('f7386058-ba25-4e99-bbb3-24818486b828','2016-08-08',NULL,40499,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'65452f02-fea6-4557-b2d1-16b5c7cb699a',NULL,'0',0),('f75cf731-065f-4f74-b708-89d52334f1d7','2016-08-08',NULL,8942,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'80b8cfbd-0752-460a-9a21-f5e8554aaacb',NULL,'0',0),('f7670f75-0246-4fdb-99f2-d19c14edeff9','2016-08-08',NULL,5340,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'579e5f38-ef72-448c-865f-8e80b04e25df',NULL,'0',0),('f76a664a-a346-438f-96dc-c4b2f83896fb','2016-08-08',NULL,123116,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'0f2fd2e2-3ab1-4a57-a327-2d11215facb4',NULL,'0',0),('f78ce5d9-01d7-4921-886c-d030fa8cd638','2016-08-08',NULL,51750,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'2223495a-8eef-4757-b33c-27fb7646d4f5',NULL,'0',0),('f7a693c8-1419-4230-ad45-a8eb69009e1d','2016-08-08',NULL,135,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'5f70495e-f309-4199-a38c-8272f1267a13',NULL,'0',0),('f7aa6f35-db28-47e1-bfcb-d577a5bb7be2','2016-08-08',NULL,8798,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'aaea9111-5d11-460e-b898-c56762aa4455',NULL,'0',0),('f7c47758-259a-4376-bb59-11a04e464107','2016-08-08',NULL,4398,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'bf57047a-a2cd-4f22-9c1b-b0a8983fc974',NULL,'0',0),('f7e36007-7b2b-442f-b442-28e60a262d1e','2016-08-08',NULL,193545,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'5af83213-24cf-410e-af75-65c824ee431f',NULL,'0',0),('f7ec3060-cf92-4c1c-a816-7fdabbcb638d','2016-08-08',NULL,19872,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'66c61c70-fe7e-4b9c-b58b-72766e0d8413',NULL,'0',0),('f7ed074a-3e79-45cc-a64e-afdc03887fef','2016-08-08',NULL,11675,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'6d745229-9f24-4476-9dde-9fba11c73668',NULL,'0',0),('f8259243-c63c-4ea5-a8e7-22fe96c37c98','2016-08-08',NULL,756,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'d30ecb66-2dbc-479c-b189-ab867dca4473',NULL,'0',0),('f8277b94-cb7a-4a21-bdec-23ebca8ac4bd','2016-08-08',NULL,12161,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'6d745229-9f24-4476-9dde-9fba11c73668',NULL,'0',0),('f866d762-12cb-4bec-b781-1b3c86a7e534','2016-08-08',NULL,38775,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'dfe53a5f-f3cd-4930-bf99-2ef553ea9cba',NULL,'0',0),('f87ed4a0-087c-46f5-adc3-220d62762316','2016-08-08',NULL,13455,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'a63f33cd-561e-4f75-8fd8-6784c3716e31',NULL,'0',0),('f88510f2-310f-4b1e-8e15-bd92fc184b26','2016-08-08',NULL,2400,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'223d66d3-f822-489e-a049-39bbc69145c7',NULL,'0',0),('f8bbfab1-0196-441c-8237-4b2d34d52ae1','2016-08-08',NULL,1242,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'4462502a-223f-4d8a-9814-1ec1a96574c4',NULL,'0',0),('f8c591ee-0005-42fb-9f98-1c7ee807da34','2016-08-08',NULL,22968,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c52ad20c-a94c-4cd5-aa1d-9ca21062c369',NULL,'0',0),('f8cad1cc-9770-441f-8492-9ebe7430b7a7','2016-08-08',NULL,14040,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'05f6c643-47dd-4a0e-9e60-607c5a72e2b1',NULL,'0',0),('f8cf43c5-5e91-4e6d-9522-00e268f04e50','2016-08-08',NULL,15525,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'d5867fc3-708d-4fd8-8b83-49598971cfda',NULL,'0',0),('f8eb8d03-6c45-43a4-b3ed-4d4c539552ab','2016-08-08',NULL,2862,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'c04fb5e7-4366-4ed4-8427-e788be8af7a5',NULL,'0',0),('f8f152ce-e0f7-4f14-ae95-c217bf299dbf','2016-08-08',NULL,7776,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'62e4d93e-949e-4136-9628-cca17c0eadd9',NULL,'0',0),('f9094798-d30c-4384-a0a7-4b9d0b7b3e2a','2016-08-08',NULL,4916,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'75b4abba-6596-457a-af5e-c2e9d257c28c',NULL,'0',0),('f920f2f3-13ed-48ec-a9b2-89a1fc14046c','2016-08-08',NULL,6314,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'b27e43c2-9acb-4168-9f5d-4c4c0babcf5a',NULL,'0',0),('f9596a54-8ff2-4f32-a9cd-cdb05f00586f','2016-08-08',NULL,12171,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e9ded445-9be5-4b49-9785-fccd7a6b52fd',NULL,'0',0),('f9c3aee3-9a44-4b24-a9c2-f1cd30a61d08','2016-08-08',NULL,8073,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'7f2f11f5-faf2-4327-96ba-6a444834947a',NULL,'0',0),('f9ed5f8d-0eaf-425c-bc74-9722586f2fbe','2016-08-08',NULL,28690,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'33da234e-081b-4a4e-8e98-17cded390bba',NULL,'0',0),('f9ee1d72-1711-4af9-9bde-9363f0817d3e','2016-08-08',NULL,413,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'7efdbb21-13fd-4f57-b50d-0d16f29cef39',NULL,'0',0),('fa51826d-502f-48f6-9e68-7b5d903122cc','2016-08-08',NULL,10124,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'3d78e24e-457a-4e4e-be79-a8ea7be2f184',NULL,'0',0),('fa574a61-d122-486a-8abf-8ddfda8cccc7','2016-08-08',NULL,36432,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'1f82dfc0-8285-4c28-88b4-175234347c5d',NULL,'0',0),('fa6cb152-5f40-4be0-9f2d-3495d1793da1','2016-08-08',NULL,9703,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'1706fcfd-6788-4c63-a45b-bddb2c7da5a0',NULL,'0',0),('fa8102c3-b87a-44ad-9690-c9aab118c9b7','2016-08-08',NULL,14904,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'eb392a11-14b8-4e54-a103-6ca7b5fcfa1c',NULL,'0',0),('fa93d413-56aa-4279-a259-141a4727731c','2016-08-08',NULL,16145,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'aaf6a740-abb1-4a7d-b36b-2ecc0738e723',NULL,'0',0),('fa9f35b7-fb24-487d-a3fe-6cd28fbfe30d','2016-08-08',NULL,1117,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'30176b2c-1c16-4774-9e4a-724306b412d3',NULL,'0',0),('fad51f99-1f8b-47ff-94fb-aafb28cd8dc4','2016-08-08',NULL,2360,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'fb09b5bb-4361-4bd1-a72e-2618b1347f50',NULL,'0',0),('faeb0c30-f937-4e0e-ba5f-d8ae6f01d460','2016-08-08',NULL,389,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'46033846-68ce-4db7-904d-f882dfda42ff',NULL,'0',0),('fb186d8f-8fd1-4a1f-862a-d9845fe4a7df','2016-08-08',NULL,9719,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'cb1b81ea-20e3-4e77-8dc7-183cb222b81d',NULL,'0',0),('fb2ac6ca-0ac9-496b-b445-bce56b6aee6d','2016-08-08',NULL,1552,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'8573a3b3-2381-4989-8194-1d966e8652ef',NULL,'0',0),('fb2e319e-47e5-4a3c-bc1e-b44a74a7e688','2016-08-08',NULL,20079,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'1494e6ac-0838-409b-8171-27a4e9c793c6',NULL,'0',0),('fb6727d5-63ac-496d-9c81-0ff4aa2cb6c5','2016-08-08',NULL,165186,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'0dc97e5d-c36b-4bc9-bdbf-62bce2412dd0',NULL,'0',0),('fb80fc12-e95d-4504-8b6d-a5411cedf294','2016-08-08',NULL,5940,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'3e28f39e-bbcf-43c6-88aa-f5c29c3b2307',NULL,'0',0),('fb87f972-79c4-435a-8c2f-4c62abe7b177','2016-08-08',NULL,1682,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'a75016e6-61e9-4521-8abb-65a4449cdd0b',NULL,'0',0),('fb8ae1ab-1afe-439d-9010-6b9e7cddaaa3','2016-08-08',NULL,3925,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'e6e9b82a-d5db-47d2-b2c8-d92f49d03713',NULL,'0',0),('fb97f472-a3ae-4d34-870c-504c3ee5d638','2016-08-08',NULL,57974,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'140830b4-4847-445d-b32e-6ff9a315acf6',NULL,'0',0),('fbaaaa0d-e6b6-4fe0-881b-c0f4fa936cf3','2016-08-08',NULL,365,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'1aa9ec96-e467-4ddb-8397-5f59685a32ed',NULL,'0',0),('fbf334ca-84ef-42ee-98f3-f4ba7c03731d','2016-08-08',NULL,18630,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'2a55be02-7190-41d1-8726-90bccec8c4b1',NULL,'0',0),('fc27097e-68ec-49ca-a98e-166c2cf13c8b','2016-08-08',NULL,16847,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'05f6c643-47dd-4a0e-9e60-607c5a72e2b1',NULL,'0',0),('fc2da956-7d39-4f28-a610-529ba677991a','2016-08-08',NULL,285,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'f2d7c2ca-54a3-423f-9499-0f06333a9910',NULL,'0',0),('fc71e52c-150d-463f-811e-ed45eb042dcb','2016-08-08',NULL,9688,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'1a963c74-95d3-4735-ac0c-55358c5a078c',NULL,'0',0),('fcd9bc4f-301d-45b0-b431-7b4a45fa0231','2016-08-08',NULL,20250,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'d997ed5d-8d3f-4951-8241-9627da3a6683',NULL,'0',0),('fceaa2e3-d608-46e8-a2c1-0ed021c24953','2016-08-08',NULL,6673,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'62d86106-b325-4359-b9ec-268e745553ed',NULL,'0',0),('fd1513a8-06ec-470d-b4ce-fc40b99c69b1','2016-08-08',NULL,157,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'8ff8e6a8-d2f8-4f90-9010-f2c74a9b803b',NULL,'0',0),('fd40b5df-0eb2-4709-9ce8-2b2080748ad3','2016-08-08',NULL,12420,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'3c4fcbe7-a749-4756-8385-27ec1f53c6ee',NULL,'0',0),('fd453a82-d001-4f3f-aef8-89e05843e6c3','2016-08-08',NULL,11145,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'b7356652-f9bf-4916-8040-ed670178da93',NULL,'0',0),('fd4b4d45-5f70-4882-b919-d8bd95d57131','2016-08-08',NULL,147740,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'0f2fd2e2-3ab1-4a57-a327-2d11215facb4',NULL,'0',0),('fd53da56-f1a8-421d-a63e-d4fb40d19107','2016-08-08',NULL,24473,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'9bb8e3e3-3b08-411a-a7e6-43148c5cc4f6',NULL,'0',0),('fd5a8248-1943-412e-b090-1db2e0b6eefa','2016-08-08',NULL,21322,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'44218b4c-d4ba-4c94-950e-f905c18d68f2',NULL,'0',0),('fd63ef51-5828-45dc-80af-8c8493d0808b','2016-08-08',NULL,1399,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'007e27fa-9f94-47a2-a70a-115654f1ae31',NULL,'0',0),('fd6aa27f-69a9-45eb-8873-405084a45201','2016-08-08',NULL,10558,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'01b583c9-c515-4b30-9793-482d0a76f1d2',NULL,'0',0),('fd93b4d6-695e-4b87-b1dd-f2065035cf9f','2016-08-08',NULL,29728,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'99bd428f-3d27-41e7-8604-53cc2c550c24',NULL,'0',0),('fd9d6359-3532-4e3c-a6c2-c2690781c968','2016-08-08',NULL,1426,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'a86a1c82-5128-43d8-a865-376d8d6605a0',NULL,'0',0),('fdac0af3-eee9-4f9c-a4f6-2c4c9a6cb744','2016-08-08',NULL,4983,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c0b87cc9-7dd5-4e92-b78c-5b065da4e621',NULL,'0',0),('fdb245ae-b11e-4961-a09a-154d70f12e29','2016-08-08',NULL,1863,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'59edbac4-7aae-4008-817d-eeeb02bd28c7',NULL,'0',0),('fdb6614d-1703-4196-8728-34e6faa60da7','2016-08-08',NULL,285,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'f7b6a5d2-8409-4f79-90da-be61ea52375f',NULL,'0',0),('fdd01249-5d85-4f2b-bcde-3ee30be8905e','2016-08-08',NULL,1267,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'de9a4e71-d7f6-4596-ab92-cc4ca0856feb',NULL,'0',0),('fe1d3a06-4b98-4c0d-bf3a-4a6b07326b14','2016-08-08',NULL,311,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'c7ebf076-3e1b-4c45-985c-3cd09fd3ecba',NULL,'0',0),('fe25c7f9-04d7-44c8-b7d6-13dccdfa460a','2016-08-08',NULL,7128,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'5ba92538-5b76-46c0-85cd-870ffb1b9db6',NULL,'0',0),('fe297714-c1fc-42d6-b148-396a5d477552','2016-08-08',NULL,59400,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'565834a0-66bc-4d40-84ed-e3c96d4fc77f',NULL,'0',0),('fe34d927-ce10-4fbc-b2cc-a6d45c1037b8','2016-08-08',NULL,28538,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'d0e980e2-8899-4acd-9c83-5e0e6db0a7ca',NULL,'0',0),('fe4b76db-87d6-445d-ad98-ec0a0ec79370','2016-08-08',NULL,12076,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'ef269800-460b-4827-9444-2f295a5cdf6d',NULL,'0',0),('fea77e01-3cdd-464e-bf19-178077b63d66','2016-08-08',NULL,42768,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'26cc436a-c594-409c-8f35-c0cfbfd82a4c',NULL,'0',0),('febb9a6b-56d9-459b-a5ec-bed60d165638','2016-08-08',NULL,11179,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'6dee2dfe-043b-4bb7-a500-9a918d85d86b',NULL,'0',0),('febeaced-2e5a-4283-a03e-203a7e894c7f','2016-08-08',NULL,241931,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'5af83213-24cf-410e-af75-65c824ee431f',NULL,'0',0),('fec5321d-e34a-49c0-be70-f0ccf3c0ce9d','2016-08-08',NULL,22688,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'c9438eeb-a4e2-4532-a7b2-e7b0aa4aa16b',NULL,'0',0),('fed2987e-8052-41e8-b6f7-d78a68f4fa72','2016-08-08',NULL,142370,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'f660a9fc-459f-4277-ba19-e9dd28598262',NULL,'0',0),('fed32f26-2f36-4ed2-ad4a-83581e150a9a','2016-08-08',NULL,6986,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'689937cd-f309-47a2-a1b7-812c792e5062',NULL,'0',0),('fef863c3-4bb5-4eb9-942c-5c2835e72e67','2016-08-08',NULL,673,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'3408fa37-27a1-4ba7-aabd-47da2341f48b',NULL,'0',0),('ff3dcad9-b58c-4705-a280-ef1e4a9407f2','2016-08-08',NULL,743,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','REFERENCE',NULL,NULL,'6adbd5fc-961e-4ccc-a08c-0a4dd9094b68',NULL,'0',0),('ff6afd01-6b0a-4a3f-866a-d4edf492c105','2016-08-08',NULL,532,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','CLINIC',NULL,NULL,'d8125419-2e6a-4f03-91a0-ea1675890f32',NULL,'0',0),('ffaaa1b0-3822-4603-bfb6-23a681bd727f','2016-08-08',NULL,1552,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'b77fcabc-a2e9-4157-94b1-176e5bb493d8',NULL,'0',0),('fff67fef-89a4-4a85-9a1f-ec21d3bc3456','2016-08-08',NULL,362,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'a87e543d-44d6-4ce5-8cab-722c673e4b06',NULL,'0',0);
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
-- Table structure for table `quote`
--

DROP TABLE IF EXISTS `quote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quote` (
  `id` char(50) NOT NULL,
  `issue_date` date DEFAULT NULL,
  `valid_from` date DEFAULT NULL,
  `valid_to` date DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `fk_issuer` char(50) DEFAULT NULL,
  `fk_receiver` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quote`
--

LOCK TABLES `quote` WRITE;
/*!40000 ALTER TABLE `quote` DISABLE KEYS */;
/*!40000 ALTER TABLE `quote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quote_item`
--

DROP TABLE IF EXISTS `quote_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quote_item` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `unit_price` decimal(10,0) DEFAULT NULL,
  `delivery_date` date DEFAULT NULL,
  `fk_uom` char(50) DEFAULT NULL,
  `comment` char(50) DEFAULT NULL,
  `fk_request_item` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quote_item`
--

LOCK TABLES `quote_item` WRITE;
/*!40000 ALTER TABLE `quote_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `quote_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quote_role`
--

DROP TABLE IF EXISTS `quote_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quote_role` (
  `id` char(50) NOT NULL,
  `fk_person` char(50) DEFAULT NULL,
  `fk_quote` char(50) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quote_role`
--

LOCK TABLES `quote_role` WRITE;
/*!40000 ALTER TABLE `quote_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `quote_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quote_term`
--

DROP TABLE IF EXISTS `quote_term`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quote_term` (
  `id` char(50) NOT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `fk_quote` char(50) DEFAULT NULL,
  `fk_quote_item` char(50) DEFAULT NULL,
  `fk_term_type` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quote_term`
--

LOCK TABLES `quote_term` WRITE;
/*!40000 ALTER TABLE `quote_term` DISABLE KEYS */;
/*!40000 ALTER TABLE `quote_term` ENABLE KEYS */;
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
/*!40000 ALTER TABLE `recurring_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request` (
  `id` char(50) NOT NULL,
  `entry_date` date DEFAULT NULL,
  `required_date` date DEFAULT NULL,
  `send_date` date DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `fk_originator` char(50) DEFAULT NULL,
  `fk_responding` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request_item`
--

DROP TABLE IF EXISTS `request_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request_item` (
  `id` char(50) NOT NULL,
  `required_date` date DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `max_allowable_price` decimal(10,0) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `fk_request` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request_item`
--

LOCK TABLES `request_item` WRITE;
/*!40000 ALTER TABLE `request_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `request_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request_role`
--

DROP TABLE IF EXISTS `request_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request_role` (
  `id` char(50) NOT NULL,
  `fk_person` char(50) DEFAULT NULL,
  `fk_request` char(50) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request_role`
--

LOCK TABLES `request_role` WRITE;
/*!40000 ALTER TABLE `request_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `request_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requirement`
--

DROP TABLE IF EXISTS `requirement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requirement` (
  `id` char(50) NOT NULL,
  `creation_date` date DEFAULT NULL,
  `required_date` date DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `estimated_budget` decimal(10,0) DEFAULT NULL,
  `source_type` char(25) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `fk_parent` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requirement`
--

LOCK TABLES `requirement` WRITE;
/*!40000 ALTER TABLE `requirement` DISABLE KEYS */;
/*!40000 ALTER TABLE `requirement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requirement_request`
--

DROP TABLE IF EXISTS `requirement_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requirement_request` (
  `id` char(50) NOT NULL,
  `fk_request_item` char(50) DEFAULT NULL,
  `fk_requirement` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requirement_request`
--

LOCK TABLES `requirement_request` WRITE;
/*!40000 ALTER TABLE `requirement_request` DISABLE KEYS */;
/*!40000 ALTER TABLE `requirement_request` ENABLE KEYS */;
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
  `fk_order` char(50) DEFAULT NULL,
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
-- Table structure for table `requirement_status`
--

DROP TABLE IF EXISTS `requirement_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requirement_status` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `fk_order` char(50) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `fk_requirement` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requirement_status`
--

LOCK TABLES `requirement_status` WRITE;
/*!40000 ALTER TABLE `requirement_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `requirement_status` ENABLE KEYS */;
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
-- Table structure for table `sales_order`
--

DROP TABLE IF EXISTS `sales_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sales_order` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_order`
--

LOCK TABLES `sales_order` WRITE;
/*!40000 ALTER TABLE `sales_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `sales_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_order_item`
--

DROP TABLE IF EXISTS `sales_order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sales_order_item` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_order_item`
--

LOCK TABLES `sales_order_item` WRITE;
/*!40000 ALTER TABLE `sales_order_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `sales_order_item` ENABLE KEYS */;
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
INSERT INTO `sequence_number` VALUES ('1d2c4bcd-97ca-4ce4-8c1c-d5ecc06e988b','2016-08-10',NULL,'4b6b0923-ee66-4459-817c-8a3615e77276','PHS',2,0,0,0),('2588f495-4aad-4e2c-a915-d25eac877df1','2016-08-10',NULL,'4b6b0923-ee66-4459-817c-8a3615e77276','SPIN',2,0,0,0),('6ec0210d-3f88-49dd-af46-4dede46fe42d','2016-08-12',NULL,'4a129f6b-7b21-4640-bf78-4da17201894a','CsPO',2,0,0,0),('9768b7dc-dfbc-44b6-9fc2-d0b23b9d41f7','2016-08-11',NULL,'b620d220-4d73-473f-b0ba-cad098570b6a','BLMED',2,0,0,0),('bf63612e-ffc0-4251-9d76-e4ac975b0da0','2016-08-11',NULL,'4b6b0923-ee66-4459-817c-8a3615e77276','SPIN',3,0,0,1),('ddadc976-301b-466a-81b2-29a7928a393f','2016-08-11',NULL,'b620d220-4d73-473f-b0ba-cad098570b6a','PHS',2,0,0,0);
/*!40000 ALTER TABLE `sequence_number` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment`
--

DROP TABLE IF EXISTS `shipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipment` (
  `id` char(50) NOT NULL,
  `entry_date` date DEFAULT NULL,
  `estimated_ship_date` date DEFAULT NULL,
  `estimated_ready_date` date DEFAULT NULL,
  `estimated_arrival_date` date DEFAULT NULL,
  `allowable_cancel_date` date DEFAULT NULL,
  `estimated_ship_cost` decimal(10,0) DEFAULT NULL,
  `act_ship_cost` decimal(10,0) DEFAULT NULL,
  `last_updated` date DEFAULT NULL,
  `instruction` varchar(250) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `ship_from_party` char(50) DEFAULT NULL,
  `ship_to_party` char(50) DEFAULT NULL,
  `ship_from_address` char(50) DEFAULT NULL,
  `ship_to_address` char(50) DEFAULT NULL,
  `ship_from_contact` char(50) DEFAULT NULL,
  `ship_to_contact` char(50) DEFAULT NULL,
  `fk_shipping_document` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment`
--

LOCK TABLES `shipment` WRITE;
/*!40000 ALTER TABLE `shipment` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment_item`
--

DROP TABLE IF EXISTS `shipment_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipment_item` (
  `id` char(50) NOT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `fk_uom` char(50) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `fk_shipment` char(50) DEFAULT NULL,
  `fk_shipping_document` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment_item`
--

LOCK TABLES `shipment_item` WRITE;
/*!40000 ALTER TABLE `shipment_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipment_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment_item_billing`
--

DROP TABLE IF EXISTS `shipment_item_billing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipment_item_billing` (
  `id` char(50) NOT NULL,
  `fk_shipment_item` char(50) DEFAULT NULL,
  `fk_invoice_item` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment_item_billing`
--

LOCK TABLES `shipment_item_billing` WRITE;
/*!40000 ALTER TABLE `shipment_item_billing` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipment_item_billing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment_order`
--

DROP TABLE IF EXISTS `shipment_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipment_order` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `fk_shipment_item` char(50) DEFAULT NULL,
  `fk_order_item` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment_order`
--

LOCK TABLES `shipment_order` WRITE;
/*!40000 ALTER TABLE `shipment_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipment_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment_package`
--

DROP TABLE IF EXISTS `shipment_package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipment_package` (
  `id` char(50) NOT NULL,
  `create_date` date DEFAULT NULL,
  `fk_shipping_document` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment_package`
--

LOCK TABLES `shipment_package` WRITE;
/*!40000 ALTER TABLE `shipment_package` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipment_package` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment_receipt`
--

DROP TABLE IF EXISTS `shipment_receipt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipment_receipt` (
  `id` char(50) NOT NULL,
  `date_received` date DEFAULT NULL,
  `item_description` varchar(250) DEFAULT NULL,
  `quantity_accepted` decimal(10,0) DEFAULT NULL,
  `quantity_rejected` decimal(10,0) DEFAULT NULL,
  `fk_shipment_package` char(50) DEFAULT NULL,
  `fk_inventory_item` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment_receipt`
--

LOCK TABLES `shipment_receipt` WRITE;
/*!40000 ALTER TABLE `shipment_receipt` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipment_receipt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment_receipt_role`
--

DROP TABLE IF EXISTS `shipment_receipt_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipment_receipt_role` (
  `id` char(50) NOT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `type` char(50) DEFAULT NULL,
  `fk_shipment_receipt` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment_receipt_role`
--

LOCK TABLES `shipment_receipt_role` WRITE;
/*!40000 ALTER TABLE `shipment_receipt_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipment_receipt_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment_rejection_reason`
--

DROP TABLE IF EXISTS `shipment_rejection_reason`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipment_rejection_reason` (
  `id` char(50) NOT NULL,
  `note` varchar(250) DEFAULT NULL,
  ` fk_shipment_receipt` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment_rejection_reason`
--

LOCK TABLES `shipment_rejection_reason` WRITE;
/*!40000 ALTER TABLE `shipment_rejection_reason` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipment_rejection_reason` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment_route_segment`
--

DROP TABLE IF EXISTS `shipment_route_segment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipment_route_segment` (
  `id` char(50) NOT NULL,
  `est_start_date` date DEFAULT NULL,
  `est_arrival_date` date DEFAULT NULL,
  `act_start_date` date DEFAULT NULL,
  `act_arrival_date` date DEFAULT NULL,
  `start_mileage` decimal(10,0) DEFAULT NULL,
  `end_mileage` decimal(10,0) DEFAULT NULL,
  `fuel_used` decimal(10,0) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `fk_vehicle` char(50) DEFAULT NULL,
  `fk_carrier` char(50) DEFAULT NULL,
  `fk_shipment` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment_route_segment`
--

LOCK TABLES `shipment_route_segment` WRITE;
/*!40000 ALTER TABLE `shipment_route_segment` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipment_route_segment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment_status`
--

DROP TABLE IF EXISTS `shipment_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipment_status` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `fk_shipment` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment_status`
--

LOCK TABLES `shipment_status` WRITE;
/*!40000 ALTER TABLE `shipment_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipment_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipping_document`
--

DROP TABLE IF EXISTS `shipping_document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipping_document` (
  `id` char(50) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipping_document`
--

LOCK TABLES `shipping_document` WRITE;
/*!40000 ALTER TABLE `shipping_document` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipping_document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `simple_invoice_clinic`
--

DROP TABLE IF EXISTS `simple_invoice_clinic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `simple_invoice_clinic` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `fk_customer` char(50) DEFAULT NULL,
  `fk_employe` char(50) DEFAULT NULL,
  `fk_currency` char(50) DEFAULT NULL,
  `note` varchar(150) DEFAULT NULL,
  `number` char(50) DEFAULT NULL,
  `is_paid` char(1) DEFAULT '0',
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `simple_invoice_clinic`
--

LOCK TABLES `simple_invoice_clinic` WRITE;
/*!40000 ALTER TABLE `simple_invoice_clinic` DISABLE KEYS */;
INSERT INTO `simple_invoice_clinic` VALUES ('5d2f3d5e-95f1-4926-9fa3-7b003259f83c','2016-08-11','4b6b0923-ee66-4459-817c-8a3615e77276','bce962f9-7d57-49fa-bcee-cfc093b10b96','78171b13-766f-495b-939d-e01b79e21931','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','','SPIN2','0',0);
/*!40000 ALTER TABLE `simple_invoice_clinic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `simple_invoice_clinic_item`
--

DROP TABLE IF EXISTS `simple_invoice_clinic_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `simple_invoice_clinic_item` (
  `id` char(50) NOT NULL,
  `note` varchar(150) DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `fk_root` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `simple_invoice_clinic_item`
--

LOCK TABLES `simple_invoice_clinic_item` WRITE;
/*!40000 ALTER TABLE `simple_invoice_clinic_item` DISABLE KEYS */;
INSERT INTO `simple_invoice_clinic_item` VALUES ('74d68d0a-039d-481f-b0a6-044f25b643c5','Tagihan Obat',5000000,'5d2f3d5e-95f1-4926-9fa3-7b003259f83c',0),('c918fb6f-7963-4d8a-990a-ceb7c010d14e','Tagihan Tuslah',250000,'5d2f3d5e-95f1-4926-9fa3-7b003259f83c',0);
/*!40000 ALTER TABLE `simple_invoice_clinic_item` ENABLE KEYS */;
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
  `note` varchar(250) DEFAULT NULL,
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
INSERT INTO `stock_adjustment` VALUES ('5e7864c5-44d5-45db-86e0-7bf76c3c7407','2016-08-11','\"f68e2747-3c78-40e5-9cd3-57f72d0febc8\"','b17aadd1-fb3a-48fd-b780-a34f89596102','',0);
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
  `expired_date` date DEFAULT NULL,
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
INSERT INTO `stock_adjustment_item` VALUES ('df62abd7-2864-483a-b3c3-9619d7c629f7',100,'5e7864c5-44d5-45db-86e0-7bf76c3c7407','8ecd4d6f-3bf9-48bd-8cd9-a7b392a8973a','','2016-08-31',0);
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
-- Table structure for table `term_type`
--

DROP TABLE IF EXISTS `term_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `term_type` (
  `id` char(50) NOT NULL,
  `description` varchar(150) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `term_type`
--

LOCK TABLES `term_type` WRITE;
/*!40000 ALTER TABLE `term_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `term_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time_entry`
--

DROP TABLE IF EXISTS `time_entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `time_entry` (
  `id` char(50) NOT NULL,
  `start` timestamp NULL DEFAULT NULL,
  `end` timestamp NULL DEFAULT NULL,
  `hour` decimal(10,0) DEFAULT NULL,
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
/*!40000 ALTER TABLE `time_entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time_entry_billing`
--

DROP TABLE IF EXISTS `time_entry_billing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `time_entry_billing` (
  `id` char(50) NOT NULL,
  `fk_time_entry` char(50) DEFAULT NULL,
  `fk_invoice_item` char(50) DEFAULT NULL,
  `hour` decimal(10,0) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time_entry_billing`
--

LOCK TABLES `time_entry_billing` WRITE;
/*!40000 ALTER TABLE `time_entry_billing` DISABLE KEYS */;
/*!40000 ALTER TABLE `time_entry_billing` ENABLE KEYS */;
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
  `fk_worker` char(50) DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
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
/*!40000 ALTER TABLE `timesheet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timesheet_role`
--

DROP TABLE IF EXISTS `timesheet_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timesheet_role` (
  `id` char(50) NOT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `fk_timesheet` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timesheet_role`
--

LOCK TABLES `timesheet_role` WRITE;
/*!40000 ALTER TABLE `timesheet_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `timesheet_role` ENABLE KEYS */;
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
  `type` char(10) DEFAULT NULL,
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
INSERT INTO `unit_of_measure` VALUES ('002e1b00-f0a8-4313-abf8-dbd3d863b1d8','Month (Work)','Month (Work)','','Time',2),('038515dd-4524-496a-a4ae-ff7370ef60d9','VIAL','VIAL',NULL,'Weight',0),('07d363af-0f3d-4d29-a09c-432ec3dc6707','LEMBAR','LEMBAR',NULL,'Weight',0),('0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','TUBE','TUBE',NULL,'Weight',0),('0ff680e9-1408-4ee6-90f1-4666659b8efb','SIRUP','SIRUP',NULL,'Weight',0),('12d4dba0-5b13-493f-a364-890fbb8f0691','BLS','BLS',NULL,'Weight',0),('21ee2def-bf0c-48ac-9f4f-1390dd5932fa','SUPP','SUPP',NULL,'Weight',0),('22f1f150-0533-4cdc-a229-9260b752421c','KOTAK','KOTAK',NULL,'Weight',0),('2edc961e-8693-429d-973a-299182d28690','AMPUL','AMPUL',NULL,'Weight',0),('3744de49-a23d-4280-8f8f-b8a2218ffa2b','Week','Week','','Time',0),('453077e2-a7fb-4f81-b6d8-936cbef4fab3','PCS','PCS',NULL,'Weight',0),('489c80c3-8f63-46e8-ba22-91fe377e0443','SACHET','SACHET',NULL,'Weight',0),('4906be4c-a7c6-4aef-a215-c68cc2a7de77','Mandays','Mandays','','Time',0),('527476cb-2087-4a59-a239-e3e33c731cbc','BLISTER','BLISTER',NULL,'Weight',0),('5e5eb7d7-403d-4da7-826c-df47d8dac604','MD','MD',NULL,'Weight',0),('8d41c267-ff40-466b-89b3-fff445a46b55','TABLET','TABLET',NULL,'Weight',0),('8f832dfa-55ee-405d-9dcd-795264b3c656','ROLL','ROLL',NULL,'Weight',0),('920990f3-1cdd-4062-8d5d-835e47dc957e','Day','Day','','Time',0),('92d61b55-d41e-4b28-aab8-6122eac8c6c1','JSE','Jasa Tuslah','','Weight',0),('a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','KAPSUL','KAPSUL',NULL,'Weight',0),('aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','BOTOL','BOTOL',NULL,'Weight',0),('afe54bba-c2b1-4915-973f-24069d45d790','KAPLET','KAPLET',NULL,'Weight',0),('be5ad391-0c12-4c0a-bad5-7ee5254abb56','Hour','Hour','','Time',0),('c99fc794-b3ff-4afa-af41-18505f9cded7','AMPLOP','AMPLOP',NULL,'Weight',0),('d39e1e7d-a7ac-4027-9762-43d58893f68f','DUS','DUS',NULL,'Weight',0),('e1db32dc-f5f5-4b85-8d57-1f278355ba6b','Year','Year','','Time',0),('e7213b99-369f-4b28-92be-80fc0ec57886','FLS','FLS',NULL,'Weight',0),('ea7c09e7-a2e5-4fc4-a060-1addffb654e7','RECTAL TUBE','RECTAL TUBE',NULL,'Weight',0),('eddf7518-491f-4713-bf70-85bab5a09938','STRIP','STRIP',NULL,'Weight',0),('f5d20b38-1fa8-4ae8-95af-94f638af73f7','KOLF','KOLF',NULL,'Weight',0),('f66bccf3-c3ab-46b6-b8b7-5b19a1fdda3a','BOX','BOX',NULL,'Weight',0);
/*!40000 ALTER TABLE `unit_of_measure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uom_factor`
--

DROP TABLE IF EXISTS `uom_factor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uom_factor` (
  `id` char(50) NOT NULL,
  `factor` decimal(10,0) DEFAULT NULL,
  `fk_uom_from` char(50) DEFAULT NULL,
  `fk_uom_to` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uom_factor`
--

LOCK TABLES `uom_factor` WRITE;
/*!40000 ALTER TABLE `uom_factor` DISABLE KEYS */;
INSERT INTO `uom_factor` VALUES ('2679d072-48ba-4816-afb3-d3c4b27359e0',176,'002e1b00-f0a8-4313-abf8-dbd3d863b1d8','be5ad391-0c12-4c0a-bad5-7ee5254abb56',0),('6de49d0e-a662-433a-ae33-a3356422d1da',22,'002e1b00-f0a8-4313-abf8-dbd3d863b1d8','4906be4c-a7c6-4aef-a215-c68cc2a7de77',0),('a49172cd-35f1-4201-a29b-d23a8c4ab87a',5,'3744de49-a23d-4280-8f8f-b8a2218ffa2b','4906be4c-a7c6-4aef-a215-c68cc2a7de77',0),('e040fefe-b37a-403d-a005-afc2203547e6',4,'002e1b00-f0a8-4313-abf8-dbd3d863b1d8','3744de49-a23d-4280-8f8f-b8a2218ffa2b',0),('eb089afc-b624-4ce5-95b3-46360e9cb8ff',8,'4906be4c-a7c6-4aef-a215-c68cc2a7de77','be5ad391-0c12-4c0a-bad5-7ee5254abb56',0);
/*!40000 ALTER TABLE `uom_factor` ENABLE KEYS */;
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
INSERT INTO `user` VALUES ('97dc9715-47eb-45d5-96ba-0a582fabdf3b','admin@belian.com','jIfSsj+ceSsamqTfmru/ZlLSRsjwUijQK4CJqi86fLNWb/nqSv2eY2rRrJxgpdDM','1',NULL,'0',0),('b9e55e5b-2f34-45e6-937d-69a930dd1a52','sukhaa13','onato69Ss6C2CSe+oiQcHOPLR+0dOXUoFj4IEwmXR72bseFTbmErP51+B5lQawiy','1','1900005f-9c8d-4330-bbbb-3288c18e18fd','0',0),('ef8b3235-7cb8-480c-b94b-62563a058fa9','Dr Johan Molana','qd2+OYhtKI+y8ljpWes7wOVKTduPQvRS8P/sJymFJTWGhAxo7O3y2hEvbBt+wFwQ','1','436c802d-d290-4e34-ae91-11b51edca462','0',0);
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
INSERT INTO `user_role` VALUES ('0348b97e-8758-49f8-b9e9-e8c6763d7777','096b0105-de76-492c-9bb0-5e518b46d69c','ef8b3235-7cb8-480c-b94b-62563a058fa9','1',1),('849138a5-4b4e-41ea-8f24-e4586e7f8ab9','096b0105-de76-492c-9bb0-5e518b46d69c','97dc9715-47eb-45d5-96ba-0a582fabdf3b','1',0),('d748f5bd-1775-4609-bcd7-78a50c44fa77','096b0105-de76-492c-9bb0-5e518b46d69c','b9e55e5b-2f34-45e6-937d-69a930dd1a52','1',1);
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
INSERT INTO `user_setting` VALUES ('1900005f-9c8d-4330-bbbb-3288c18e18fd','4a129f6b-7b21-4640-bf78-4da17201894a','Aim Medical Center','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','Pontianak','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','R-PPN','in_id',25,'POS',19),('436c802d-d290-4e34-ae91-11b51edca462','4b6b0923-ee66-4459-817c-8a3615e77276','Aim Laboratory',NULL,NULL,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','R-PPN','in_ID',25,'POS',0);
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
  `name` varchar(150) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `scheduled_start_date` date DEFAULT NULL,
  `scheduled_complete_date` date DEFAULT NULL,
  `actual_start_date` date DEFAULT NULL,
  `actual_complete_date` date DEFAULT NULL,
  `money_allowed` decimal(10,0) DEFAULT NULL,
  `hour_allowed` decimal(10,0) DEFAULT '0',
  `estimated_hour` decimal(10,0) DEFAULT NULL,
  `actual_hour` decimal(10,0) DEFAULT NULL,
  `spesial_term` varchar(250) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `purpose_type` char(25) DEFAULT NULL,
  `fk_production_run` char(50) DEFAULT NULL,
  `fk_parent` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_effort`
--

LOCK TABLES `work_effort` WRITE;
/*!40000 ALTER TABLE `work_effort` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_effort` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_effort_asset_assignment`
--

DROP TABLE IF EXISTS `work_effort_asset_assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_effort_asset_assignment` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `cost` decimal(10,0) DEFAULT NULL,
  `comment` varchar(250) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `fk_asset` char(50) DEFAULT NULL,
  `fk_work_effort` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_effort_asset_assignment`
--

LOCK TABLES `work_effort_asset_assignment` WRITE;
/*!40000 ALTER TABLE `work_effort_asset_assignment` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_effort_asset_assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_effort_assignment_rate`
--

DROP TABLE IF EXISTS `work_effort_assignment_rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_effort_assignment_rate` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `rate` decimal(10,0) DEFAULT NULL,
  `type` char(50) DEFAULT NULL,
  `fk_assignment` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_effort_assignment_rate`
--

LOCK TABLES `work_effort_assignment_rate` WRITE;
/*!40000 ALTER TABLE `work_effort_assignment_rate` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_effort_assignment_rate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_effort_billing`
--

DROP TABLE IF EXISTS `work_effort_billing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_effort_billing` (
  `id` char(50) NOT NULL,
  `fk_work_effort` char(50) DEFAULT NULL,
  `fk_invoice_item` char(50) DEFAULT NULL,
  `percent` decimal(10,0) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_effort_billing`
--

LOCK TABLES `work_effort_billing` WRITE;
/*!40000 ALTER TABLE `work_effort_billing` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_effort_billing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_effort_deliverable_produced`
--

DROP TABLE IF EXISTS `work_effort_deliverable_produced`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_effort_deliverable_produced` (
  `id` char(50) NOT NULL,
  `fk_work_effort` char(50) DEFAULT NULL,
  `fk_deliverable` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_effort_deliverable_produced`
--

LOCK TABLES `work_effort_deliverable_produced` WRITE;
/*!40000 ALTER TABLE `work_effort_deliverable_produced` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_effort_deliverable_produced` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_effort_inventory_assignment`
--

DROP TABLE IF EXISTS `work_effort_inventory_assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_effort_inventory_assignment` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `fk_inventory_item` char(50) DEFAULT NULL,
  `fk_work_effort` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_effort_inventory_assignment`
--

LOCK TABLES `work_effort_inventory_assignment` WRITE;
/*!40000 ALTER TABLE `work_effort_inventory_assignment` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_effort_inventory_assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_effort_inventorys_produced`
--

DROP TABLE IF EXISTS `work_effort_inventorys_produced`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_effort_inventorys_produced` (
  `id` char(50) NOT NULL,
  `fk_work_effort` char(50) DEFAULT NULL,
  `fk_inventory_item` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_effort_inventorys_produced`
--

LOCK TABLES `work_effort_inventorys_produced` WRITE;
/*!40000 ALTER TABLE `work_effort_inventorys_produced` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_effort_inventorys_produced` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_effort_party_assignment`
--

DROP TABLE IF EXISTS `work_effort_party_assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_effort_party_assignment` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `fk_work_effort` char(50) DEFAULT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_effort_party_assignment`
--

LOCK TABLES `work_effort_party_assignment` WRITE;
/*!40000 ALTER TABLE `work_effort_party_assignment` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_effort_party_assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_effort_role`
--

DROP TABLE IF EXISTS `work_effort_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_effort_role` (
  `id` char(50) NOT NULL,
  `type` char(25) DEFAULT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `fk_work_effort` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_effort_role`
--

LOCK TABLES `work_effort_role` WRITE;
/*!40000 ALTER TABLE `work_effort_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_effort_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worker`
--

DROP TABLE IF EXISTS `worker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `worker` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worker`
--

LOCK TABLES `worker` WRITE;
/*!40000 ALTER TABLE `worker` DISABLE KEYS */;
/*!40000 ALTER TABLE `worker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worker_relationship`
--

DROP TABLE IF EXISTS `worker_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `worker_relationship` (
  `id` char(50) NOT NULL,
  `fk_worker` char(50) DEFAULT NULL,
  `fk_internal_organization` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worker_relationship`
--

LOCK TABLES `worker_relationship` WRITE;
/*!40000 ALTER TABLE `worker_relationship` DISABLE KEYS */;
/*!40000 ALTER TABLE `worker_relationship` ENABLE KEYS */;
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

-- Dump completed on 2016-08-22 11:32:14
