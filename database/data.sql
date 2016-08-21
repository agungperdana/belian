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
-- Dumping data for table `access_role`
--

LOCK TABLES `access_role` WRITE;
/*!40000 ALTER TABLE `access_role` DISABLE KEYS */;
INSERT INTO `access_role` VALUES ('01f5388b-c63e-4d09-b3b5-dd6456dd0815','c79e78d0-3427-440c-b8fe-df126e667a8b','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('0442dff1-c1dd-45e7-8634-2b9d90904469','7bef1d92-0f15-43ef-b59b-5bc3e769d896','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('060d3480-7c9a-44c7-b572-d7b2c4067359','916b22eb-48fa-4000-b7a2-7fc1d47ced4e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('0a1a6c1d-e681-48c4-b400-be611a9f70b7','8a05b279-2f80-47b8-a2a7-63fbe96d327e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('0e9073d1-2be3-4a8a-9a82-5bd1166757e2','847a8df6-bc04-4de6-8d7d-28e41c00f422','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('195dd074-a5e5-4abe-bc9f-5e913229bbb6','2d7e5641-511d-43fd-a6d6-a482120f8aa5','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('1aa3a48c-ab0c-4949-945e-e9852a9b9a93','95dd39dd-512e-414e-b95c-0fc251887f98','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('22fbdfec-6afe-4f2f-bd69-ac6a9974ae82','5c37296e-ab30-4d07-bba3-342d4c403f48','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('2c661c0d-53b6-44c7-85bd-ba04da473be3','c0f3237c-23c2-49ab-bc9c-e00aa706d7e2','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('2d52482a-0a7a-4e49-83c6-9db73e4e051b','80aebe74-399c-4273-9145-956a077d3f5d','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('3202f4e4-fd87-41a8-ae71-fbefce6a2ef4','b54c8e49-c820-4292-9f74-9e47bd55711f','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('32915e9c-96bf-44b3-881a-2f7c917a4c92','d33784ca-abd5-422b-b45a-8c8ee13ddc0a','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('32cc538f-0445-4ec4-9d2e-3084e89062d1','7f17176c-f27a-432c-a106-0d7d87b0afb7','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('331300a2-cc8e-4417-abb3-45dadf814422','fca1cfcf-d199-4729-a321-e1ed01deb0f1','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('37484efd-9cb6-4f79-903f-e7d6687658cc','6861d3b3-8110-46ed-8a3a-830963597fa7','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('3a225b38-8dbd-482a-9c14-2f7f1c535068','88bf4008-c84a-4089-88c6-e9d8f077a196','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('40e72f84-d3dc-4ce4-94de-c6c9716a5549','475038c2-e2fc-406a-ac8f-c6711c6480af','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('48c06de3-442f-4125-a438-e370fabade36','f50dd16d-0e25-44b6-bd69-c28dfcc55300','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('48c4056e-33f6-4082-af20-0139f3e66371','8217c196-16b9-44fb-9662-8323220ee705','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('490e4434-7ea2-475e-a66c-ea7296b82c54','29ec80f0-0d4c-451c-ae5e-f195c4be1a27','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('4b15a790-2920-47f2-b805-33ecd48b9bac','2c0d9a06-cebd-4da2-b520-2e948aae3e53','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('4fffeab2-b09c-47fb-92b4-3981da252637','9e644628-121d-4954-8a66-8002cc866bda','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('541dd297-fd64-44ae-bcf4-fed612227962','4b3bb551-173e-46f5-b1e9-bdd719e3045e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('59d88282-5a3f-481b-9bb8-91679fbf4d91','f53b80db-1b89-4779-86e7-b065b5287bbb','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('5a2ce59a-60c2-4203-9d3b-7c5d038fe635','e916392a-0b3c-4543-ada7-93054383bb3b','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('5c2ddb84-b28c-40f6-81d5-351e0ea1037d','627fb961-6cf0-4148-9451-0d1422095eb7','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('5c9ab463-dc50-47a5-a601-f074734adf3c','abfd9a02-3b4b-47a0-9048-a65b6be0b3aa','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('5f5930ba-8251-470e-a650-e240cfa1bde0','8971337a-2aea-41d3-930a-4e6f2fa3acc0','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('6179118a-ff80-452a-a89d-8e0154725095','b662de02-f4a3-4f1a-819b-5d2aaf6a342b','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('6416ea67-8c7b-477e-811f-c5e4e45ca9c0','99623cbd-066f-4cc2-b9b3-1961bed131cc','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('6655f91e-4928-4c6f-b83a-f43b28f04454','770c420c-f809-43f7-969c-b493f0b4ef48','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('6adcd07b-62da-4e75-a076-80520a58eb32','5cdd1545-8fdb-4a79-b2a3-0662ed6fec30','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('6ed261e4-7608-49cd-9953-a04e3ff8dfed','affcf2e7-fd2c-4b39-beee-97b5dc5a1405','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('711417b0-a5ea-4c2e-8ab3-e5a96576b45b','8f6ec9c8-e9ed-49e1-ab7a-c4a868b8391e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('71479847-69f5-43fa-b7ce-00af42c28d4a','339d7200-9aa1-43d5-8683-e7118cb52839','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('724b174d-96ec-4152-a42c-2d03097b9aa9','342b0b64-291f-4d12-bdb8-77186895d21d','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('79450f94-0cbf-4c0d-ad76-3362a4abe180','4eca5501-a650-41d5-87c1-c091391d3608','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('8675d849-03b8-4553-ac34-5b58df769501','88bdca27-a7cf-4a1e-9fdc-4d0f48a0ca19','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('89c3b455-3c46-4bc4-9a13-77c171e129b6','a4c43802-436f-407c-8793-323600c181d7','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('8c6f9ab1-f804-45c2-8504-9d9cc9d3199c','532efe0a-05ff-4f94-877d-a7f3f7509569','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('923b7b67-a1e4-478a-9769-e2ee32b685b1','ee3c3540-9c62-46df-a79e-f7b636a9ba1d','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('94863d4d-7d07-41d2-bc78-4f65260776d6','13989b38-ac2c-47b8-8708-5e27477af18d','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('96318b3e-baf7-479b-ab07-d0798114d3bd','e54e6ba5-7ffd-457b-a23e-8b6285867ba4','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('9659ee34-7845-4078-89bd-9ee9b9e37b78','855aab16-cb45-41c3-b62c-55185ff77dfc','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('9728b76b-eac0-44c4-9ba9-afca669e0a76','e8f89299-2138-4167-b5b7-52f6ae1667ca','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('9f52d7a0-217e-4084-9bb3-78c5c81dd536','07452775-a048-4071-8798-21dc943fe926','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('9fa511a1-e704-4018-a90a-57acea0ac5da','1adc4b8b-ad93-4658-8476-6bb13e2e810d','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('a055f787-df6a-4c93-af22-12797bf5ec39','69443009-4a15-4061-b9f0-08c08c8f50aa','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('a3e8ba06-d955-4929-bd36-f658f3796b6c','a4aa9ae0-5166-4d06-afd1-d2eea6f2417c','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('a3ef8fbd-46f9-43db-ab47-31d062c3fb20','74ad4867-9495-472f-97fc-36bf87895585','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('a62bb18e-1809-4476-9997-84521044e27d','4b0f494a-5d29-4412-b2c1-eaaab78f53f2','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('a7951344-6b9e-438f-af5c-7b94dee26b2d','83b19678-9f2f-49f4-ba25-0f31a8dee078','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('a8a90cc0-470f-456c-879b-77c0ed469dd7','9df71b1a-0e52-4445-98ea-b9a59ad81ac9','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('a91848d3-83d1-485a-9846-c83ff3699ac2','322d37f6-a667-481e-bc22-db212d0154ea','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('abecab92-51cb-4ca9-88a0-9446c1bc5ae3','4eb93eb7-2100-49ae-bd96-a39995ed5670','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('ac144c04-22c4-47fb-8fd4-3783a4f29a90','1cf392fc-4f93-4e38-9709-2beb84434951','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('ad389302-f250-4270-a937-75cf984c2f80','2bdc3f95-c5bd-47d9-adce-9e9df1042e2f','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('b31dbbf6-6b74-4aa9-9db4-6ebd3888ef91','355ca995-6bae-4638-bfd4-a9bfeff5eefb','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('b4f04a2c-d9a4-4b30-b75b-4572685e35a8','9178e8cd-4063-4fe9-a060-d2e3ac818ed1','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('ba3f64f6-9e81-43c6-a20e-7de6a6cf4d79','5eb48ec2-5634-4ee9-b5f7-43b2df6c8c83','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('bf839209-25d9-4ea7-8e4a-d771f7599e2e','6cbaf072-6925-46e9-b417-17326f3d8584','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('c2d02e3b-7b8a-47b4-bb08-30f37f9505fc','9b9deb26-0960-478c-8cac-4ac475c3ffc3','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('c655e02a-f2a3-4132-8bd7-9428cc1ce3af','0b503053-31eb-410d-90a6-ec6a9977bc1e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('c836928e-da88-414e-b572-db436cc948a4','4939e42f-06b5-4e44-b3ba-4106964f1f68','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('c9681985-0b2a-4537-822b-8f477bc15104','65414caf-3a73-4e3f-9a58-2d70c723b5bc','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('ce77f072-7ad1-4cb5-9e9e-0d9b89a853bd','314a3f13-a982-4915-a5cb-455eacbc27ae','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('cf2437ad-5e59-4f7a-8190-f537beabc623','58621810-2c8f-44ae-b9aa-b1e05ad32743','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('cff3c8ef-bd79-4d32-be37-b4a2e7dab027','90195ecb-4674-4614-a429-eebc24ffe773','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('d11fbe57-0eac-4f6f-bc22-14a0ed221733','fab64cd8-7762-412b-90fb-3d31d5576b45','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('d8a71d8e-344a-4c18-88ff-9ca2cffed715','b9935030-f5c1-479e-9ec1-795afc1c1e7e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('de2ab421-31cd-45b7-b6d7-5baf50797f2c','6e299ade-e10e-4940-ae83-bdf61505ed63','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('e1ae7cc5-aab3-4271-a744-9d17fca44e9c','9b9e014c-7a23-40c1-8841-30044564bf7f','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('e1ae7cc5-aab3-4271-a744-9d17fca44e9x','9b9e014c-7a23-40c1-8841-30044564bf7x','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('e51c5ad1-38c7-4699-9c92-50f070f7a7f3','4bf39427-b32a-434c-bd71-4d9493ea6eef','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('e6f44dd7-9616-4c85-aaa9-e5322ea39319','b44420c6-261b-44c5-a23a-7802a0506dab','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('e9b3d5e4-1259-48bc-b521-7abb7d72bc30','e4307d82-f3fa-4916-9e6b-7a4f894d847e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('ed0df929-8852-42ca-9006-e0ad6fd37a90','55b7e0fb-a178-478b-a09e-4b753f161aeb','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('ee5e29eb-cf8a-4c54-a709-da55952b8f80','5eda5016-f448-42dd-926b-52b10870e29c','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('f0c0441f-80df-4405-8927-c114d9c61edb','e4d249e1-4bd5-4291-9050-62a99f70f64c','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('f0f949d7-f756-4fdc-bacd-b6e145b9829d','5e8c4a66-e46a-4000-ae1c-bf536686b30f','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('f21a4567-0723-4569-abd7-8e59e3645767','0c586cf4-9bd2-4b93-b24b-d41ceca2aef4','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('f6e69991-8825-41e8-a6e7-24a4c6257c4d','dbc9175e-eb27-45e9-9e43-a1c12d6354e4','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('f7284b39-b584-4334-94f0-0631d3a9b429','4500a912-bbad-4590-9abb-d9ec92a311a5','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('fe2ef334-8861-41af-887a-a95992d46b74','8c7e1020-0824-4239-9a4e-46301c80b9cd','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1);
/*!40000 ALTER TABLE `access_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `currency`
--

LOCK TABLES `currency` WRITE;
/*!40000 ALTER TABLE `currency` DISABLE KEYS */;
INSERT INTO `currency` VALUES ('82159e7e-7d44-44e9-acc6-09f85e99bac0','RMY','Ringgit Malaysia','0',0),('85c90912-97ff-47ce-9d6a-7d1650ab3ea9','IDR','Rupiah','1',1),('f4e2e57c-be85-49a8-b19b-66ed812b2785','USD','US Dollar','0',0);
/*!40000 ALTER TABLE `currency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `erp_mode`
--

LOCK TABLES `erp_mode` WRITE;
/*!40000 ALTER TABLE `erp_mode` DISABLE KEYS */;
INSERT INTO `erp_mode` VALUES ('00000','MEDICAL',1);
/*!40000 ALTER TABLE `erp_mode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `geographic`
--

LOCK TABLES `geographic` WRITE;
/*!40000 ALTER TABLE `geographic` DISABLE KEYS */;
INSERT INTO `geographic` VALUES ('68309a5f-4606-46d3-ad20-996ed6c782d0','KAL-BAR','Kalimantan Barat','PROVINCE','',0),('68309a5f-4606-46d3-ad20-996ed6c782dx','RSJ','Rasau Jaya','CITY','',0),('c4c10aee-a3a1-4e6c-a08b-62d4e26414df','PNK','Pontianak','CITY','',0),('d0ae6c1a-d6e2-4ca8-879d-52d74e6feb71','JABAR','Jawa Barat','PROVINCE','',0),('f5a12273-368d-4d39-851a-05da7bb04ab9','IN-ID','Indonesia','COUNTRY','',0);
/*!40000 ALTER TABLE `geographic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `module`
--

LOCK TABLES `module` WRITE;
/*!40000 ALTER TABLE `module` DISABLE KEYS */;
INSERT INTO `module` VALUES ('07452775-a048-4071-8798-21dc943fe926','PRODUCT','Product','','INVENTORY','0',0),('0b503053-31eb-410d-90a6-ec6a9977bc1e','FAMILY_FOLDER','Family Folder','','CLINIC','0',0),('0c586cf4-9bd2-4b93-b24b-d41ceca2aef4','CLINIC_SALES','Clinic Sales','','CLINIC','0',0),('13989b38-ac2c-47b8-8708-5e27477af18d','BENEFIT_TYPE','Benefit Type','','HR','0',0),('1adc4b8b-ad93-4658-8476-6bb13e2e810d','PURCHASE_ORDER_REQUEST','Purchase Order Request','','PROCUREMENT','0',0),('1cf392fc-4f93-4e38-9709-2beb84434951','DOCTORTYPE','Doctor Type','','CLINIC','0',0),('29ec80f0-0d4c-451c-ae5e-f195c4be1a27','COMPANY_STRUCTURE','Company Structure','','GENERAL','0',0),('2bdc3f95-c5bd-47d9-adce-9e9df1042e2f','BUDGET_APPROVER','Budget Approver','','ACCOUNTING','0',0),('2c0d9a06-cebd-4da2-b520-2e948aae3e53','INVOICE_REPORT','Invoice Report','','FINANCIAL','0',0),('2d7e5641-511d-43fd-a6d6-a482120f8aa5','BUDGET','Budget','','ACCOUNTING','0',0),('314a3f13-a982-4915-a5cb-455eacbc27ae','INBOX','Inbox Message','','SYSTEM','0',0),('322d37f6-a667-481e-bc22-db212d0154ea','EMPYAPP','Employment Application','','HR','0',0),('339d7200-9aa1-43d5-8683-e7118cb52839','STUDENT','Student','','EDUCATION','0',0),('342b0b64-291f-4d12-bdb8-77186895d21d','SALES_REPORT','Sales Report','','SALES','0',0),('355ca995-6bae-4638-bfd4-a9bfeff5eefb','INVOICE_OVERDUE_REPORT','Invoice Over Due Report','','FINANCIAL','0',0),('4500a912-bbad-4590-9abb-d9ec92a311a5','DISCOUNT','Discount Programm','Discount','PAYMENT','0',1),('475038c2-e2fc-406a-ac8f-c6711c6480af','SIMPLE_PHARMACY_INVOICE','Simple Pharmacy Invoice','','PHARMACY','0',0),('4939e42f-06b5-4e44-b3ba-4106964f1f68','ACCOUNTINGPERIOD','Accounting Period','','ACCOUNTING','0',0),('4b0f494a-5d29-4412-b2c1-eaaab78f53f2','GENERAL_LEDGER_REPORT','General Ledger Report','','FINANCIAL','0',0),('4b3bb551-173e-46f5-b1e9-bdd719e3045e','COA','General Chart of Account','','ACCOUNTING','0',0),('4bf39427-b32a-434c-bd71-4d9493ea6eef','STOCK_OPNAME','Stock Opname','','INVENTORY','0',0),('4eb93eb7-2100-49ae-bd96-a39995ed5670','USER','User','Application User Module','SECURITY','1',0),('4eca5501-a650-41d5-87c1-c091391d3608','CASHSALES','Cash Sales','','SALES','0',0),('532efe0a-05ff-4f94-877d-a7f3f7509569','WORKING_TIMESHEET','Working Timesheet','','PRODUCTION','0',0),('55b7e0fb-a178-478b-a09e-4b753f161aeb','MEDICATION','Medication','','CLINIC','0',0),('58621810-2c8f-44ae-b9aa-b1e05ad32743','SUPPLIER','Supplier','','PROCUREMENT','0',0),('5c37296e-ab30-4d07-bba3-342d4c403f48','INVITEM','Inventory Item','','INVENTORY','0',0),('5cdd1545-8fdb-4a79-b2a3-0662ed6fec30','POSITIONTYPERATE','Position Type Rate','','HR','0',0),('5e8c4a66-e46a-4000-ae1c-bf536686b30f','TRN_ORDER_REQ','Transfer Order Request','','INVENTORY','0',0),('5eb48ec2-5634-4ee9-b5f7-43b2df6c8c83','TRIAL_BALANCE_REPORT','Trial Balance Report','','FINANCIAL','0',0),('5eda5016-f448-42dd-926b-52b10870e29c','STUDY_TIME','Study Time','','EDUCATION','0',0),('627fb961-6cf0-4148-9451-0d1422095eb7','PURCHASE_ORDER_APPROVER','Purchase Order Request Approver','','PROCUREMENT','0',0),('65414caf-3a73-4e3f-9a58-2d70c723b5bc','CURRENCY','Currency','GENERAL','ACCOUNTING','0',1),('6861d3b3-8110-46ed-8a3a-830963597fa7','TAX','Tax','','ACCOUNTING','0',0),('69443009-4a15-4061-b9f0-08c08c8f50aa','JOURNALENTRY','Journal Entry','','ACCOUNTING','0',0),('6cbaf072-6925-46e9-b417-17326f3d8584','EMPLOYMENT','Employment','','HR','0',0),('6e299ade-e10e-4940-ae83-bdf61505ed63','STUDENT_REGISTRATION','Student Registration','','EDUCATION','0',0),('74ad4867-9495-472f-97fc-36bf87895585','COURSE_ATTENDANCE','Course Attendance','EDUCATION','EDUCATION','0',1),('770c420c-f809-43f7-969c-b493f0b4ef48','CASHIER','Cashier','','SALES','0',0),('7bef1d92-0f15-43ef-b59b-5bc3e769d896','UOM','Unit of Measure','','INVENTORY','0',0),('7f17176c-f27a-432c-a106-0d7d87b0afb7','RECEIPT','Receipt','','PAYMENT','0',0),('80aebe74-399c-4273-9145-956a077d3f5d','ACCESS_ROLE','Role','Application Access Role','SECURITY','1',0),('8217c196-16b9-44fb-9662-8323220ee705','ASSET','Asset Management','','ASSET','0',0),('83b19678-9f2f-49f4-ba25-0f31a8dee078','PHARMACY_ORDER','Pharmacy Order','','PHARMACY','0',0),('847a8df6-bc04-4de6-8d7d-28e41c00f422','DOCTOR_APPOINTMENT','Doctor Appointment','','CLINIC','0',0),('855aab16-cb45-41c3-b62c-55185ff77dfc','PHARMACY_SALES','Pharmacy Sales','','PHARMACY','0',0),('88bdca27-a7cf-4a1e-9fdc-4d0f48a0ca19','GENERAL_JOURNAL_REPORT','General Journal','','FINANCIAL','0',0),('88bf4008-c84a-4089-88c6-e9d8f077a196','JOURNALSETTING','Journal Setting','','ACCOUNTING','0',0),('8971337a-2aea-41d3-930a-4e6f2fa3acc0','CLINIC_SALES_INVOICE_REPORT','Clinic Invoice From Pharmacy','','PHARMACY','0',0),('8a05b279-2f80-47b8-a2a7-63fbe96d327e','AUDIT_TRAIL','Audit Trail','','SYSTEM','0',0),('8c7e1020-0824-4239-9a4e-46301c80b9cd','PAYMENT_METHOD_TYPE','Payment Method Type','','PAYMENT','0',0),('8f6ec9c8-e9ed-49e1-ab7a-c4a868b8391e','ORGANIZATIONACCOUNT','Organization Account','','ACCOUNTING','0',0),('90195ecb-4674-4614-a429-eebc24ffe773','POSITIONTYPE','Position Type','','HR','0',0),('916b22eb-48fa-4000-b7a2-7fc1d47ced4e','STOCK_ADJUSTMENT','Stock Adjustment','','INVENTORY','0',0),('9178e8cd-4063-4fe9-a060-d2e3ac818ed1','PAYCHECK','Paycheck','','PAYMENT','0',0),('95dd39dd-512e-414e-b95c-0fc251887f98','PRDCATEGORY','Product Category','','INVENTORY','0',0),('99623cbd-066f-4cc2-b9b3-1961bed131cc','GOODS_TRANSFER','Goods Transfer','','INVENTORY','0',0),('9b9deb26-0960-478c-8cac-4ac475c3ffc3','COURSE_REGISTRATION','Course Registration','','EDUCATION','0',0),('9b9e014c-7a23-40c1-8841-30044564bf7f','MODULE','Module','Application Module','SECURITY','1',0),('9b9e014c-7a23-40c1-8841-30044564bf7x','SYSTEM','System Access','System Access','SYSTEM','1',0),('9df71b1a-0e52-4445-98ea-b9a59ad81ac9','PATIENT','Patient','','CLINIC','0',0),('9e644628-121d-4954-8a66-8002cc866bda','STOCK_ADMIN','Stock Admin','','INVENTORY','0',0),('a4aa9ae0-5166-4d06-afd1-d2eea6f2417c','PERSON','Person Management','','GENERAL','0',0),('a4c43802-436f-407c-8793-323600c181d7','GOODS_RECEIVE','Goods Receive','','INVENTORY','0',0),('abfd9a02-3b4b-47a0-9048-a65b6be0b3aa','PRODUCT_RETUR','Product Retur','','INVENTORY','0',0),('affcf2e7-fd2c-4b39-beee-97b5dc5a1405','STUDY_PERIOD','Study Period','','EDUCATION','0',0),('b44420c6-261b-44c5-a23a-7802a0506dab','RECURRING_PAYMENT','Recurring Payment','','PAYMENT','0',0),('b54c8e49-c820-4292-9f74-9e47bd55711f','CASH_PURCHASE_ORDER','Cash Purchase Order','','PROCUREMENT','0',0),('b662de02-f4a3-4f1a-819b-5d2aaf6a342b','GOODS_ISSUE','Goods Issue','','INVENTORY','0',0),('b9935030-f5c1-479e-9ec1-795afc1c1e7e','FACILITY','Facility','','INVENTORY','0',0),('c0f3237c-23c2-49ab-bc9c-e00aa706d7e2','PROFIT_LOSS','Profit Loss Report','','FINANCIAL','0',0),('c79e78d0-3427-440c-b8fe-df126e667a8b','INVOICE_DUEDATE_REPORT','Invoice Due Date Report','','FINANCIAL','0',0),('d33784ca-abd5-422b-b45a-8c8ee13ddc0a','DEDUCTION_TYPE','Deduction Type','','PAYMENT','0',0),('dbc9175e-eb27-45e9-9e43-a1c12d6354e4','DOCTOR','Doctor','','CLINIC','0',0),('e4307d82-f3fa-4916-9e6b-7a4f894d847e','ORGANIZATION','Organization','','GENERAL','0',0),('e4d249e1-4bd5-4291-9050-62a99f70f64c','CLINIC_REPORT','Clinic Reports','','CLINIC','0',0),('e54e6ba5-7ffd-457b-a23e-8b6285867ba4','STUDY_ROOM','Study Room','','EDUCATION','0',0),('e8f89299-2138-4167-b5b7-52f6ae1667ca','POSITION','Position','','HR','0',0),('e916392a-0b3c-4543-ada7-93054383bb3b','MESSAGE','Message','','SYSTEM','0',0),('ee3c3540-9c62-46df-a79e-f7b636a9ba1d','STUDY_DAY','Study Day','EDUCATION','EDUCATION','0',1),('f50dd16d-0e25-44b6-bd69-c28dfcc55300','GEOGRAPHIC','Geographic','','GENERAL','0',0),('f53b80db-1b89-4779-86e7-b065b5287bbb','ASSET_TYPE','Asset Type','','ASSET','0',0),('fab64cd8-7762-412b-90fb-3d31d5576b45','COURSE_SCHEDULE','Course Schedule','','EDUCATION','0',0),('fca1cfcf-d199-4729-a321-e1ed01deb0f1','LABS_REGISTRATION','Laboratory Registration','','MEDICALLAB','0',0);
/*!40000 ALTER TABLE `module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `party`
--

LOCK TABLES `party` WRITE;
/*!40000 ALTER TABLE `party` DISABLE KEYS */;
INSERT INTO `party` VALUES ('27fa30c5-4c84-4f2a-88ed-f93fa1ca558d','00130','Aim Poli Gigi',NULL,'2014-07-25','','1',1),('4a129f6b-7b21-4640-bf78-4da17201894a','000100','Aim Medical Center',NULL,'2014-07-25','','1',0),('4b089faf-a54c-4870-bd4d-17128ae8aa42','00200','Rasau Medical Center',NULL,'2014-07-25','','1',0),('4b6b0923-ee66-4459-817c-8a3615e77276','00140','Aim Laboratory',NULL,'2014-07-25','','1',0),('78171b13-766f-495b-939d-e01b79e21931','00001','SYSADMIN',NULL,'1981-07-25','','0',0),('977dce5c-bbe4-4abc-8df7-f8f3a4c167c7','00210','Rasau Poli Umum',NULL,'2014-07-25','','1',0),('b01d8d84-9815-403c-9c44-12a385e997c4','00000','ANONYMOUS',NULL,'1980-07-25','','0',0),('b17aadd1-fb3a-48fd-b780-a34f89596102','00120','Aim Apotik',NULL,'2014-07-25','','1',1),('b42b1e90-1bb2-4a6f-9962-230fd47c003e','0001','Johan Healcare',NULL,'2016-07-28','','1',0),('b620d220-4d73-473f-b0ba-cad098570b6a','0000','Johan Corporation',NULL,'2014-07-25','','1',0),('b7337ad2-a0a9-47e3-a165-e02d0998a271','7357327325','sukhaa13',NULL,'2016-08-11','','1',0),('bce962f9-7d57-49fa-bcee-cfc093b10b96','000110','Aim Poli Umum',NULL,'2014-07-25','','1',2),('e7e49682-49d1-40cb-90b2-3ef428fed139','0000000','Dr Johan Molana',NULL,'2016-08-18','','1',0);
/*!40000 ALTER TABLE `party` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES ('78171b13-766f-495b-939d-e01b79e21931','MALE','SINGLE'),('b01d8d84-9815-403c-9c44-12a385e997c4','MALE','SINGLE'),('b7337ad2-a0a9-47e3-a165-e02d0998a271','MALE','SINGLE'),('e7e49682-49d1-40cb-90b2-3ef428fed139','MALE','MARIED');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('096b0105-de76-492c-9bb0-5e518b46d69c','Sys Admin','System Administrator','System Administrator',NULL);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `unit_of_measure`
--

LOCK TABLES `unit_of_measure` WRITE;
/*!40000 ALTER TABLE `unit_of_measure` DISABLE KEYS */;
INSERT INTO `unit_of_measure` VALUES ('002e1b00-f0a8-4313-abf8-dbd3d863b1d8','Month (Work)','Month (Work)','','Time',2),('038515dd-4524-496a-a4ae-ff7370ef60d9','VIAL','VIAL',NULL,'Weight',0),('07d363af-0f3d-4d29-a09c-432ec3dc6707','LEMBAR','LEMBAR',NULL,'Weight',0),('0d5dc768-ce7e-4a8f-ad5f-eddbe7bf8b79','TUBE','TUBE',NULL,'Weight',0),('0ff680e9-1408-4ee6-90f1-4666659b8efb','SIRUP','SIRUP',NULL,'Weight',0),('12d4dba0-5b13-493f-a364-890fbb8f0691','BLS','BLS',NULL,'Weight',0),('21ee2def-bf0c-48ac-9f4f-1390dd5932fa','SUPP','SUPP',NULL,'Weight',0),('22f1f150-0533-4cdc-a229-9260b752421c','KOTAK','KOTAK',NULL,'Weight',0),('2edc961e-8693-429d-973a-299182d28690','AMPUL','AMPUL',NULL,'Weight',0),('3744de49-a23d-4280-8f8f-b8a2218ffa2b','Week','Week','','Time',0),('453077e2-a7fb-4f81-b6d8-936cbef4fab3','PCS','PCS',NULL,'Weight',0),('489c80c3-8f63-46e8-ba22-91fe377e0443','SACHET','SACHET',NULL,'Weight',0),('4906be4c-a7c6-4aef-a215-c68cc2a7de77','Mandays','Mandays','','Time',0),('527476cb-2087-4a59-a239-e3e33c731cbc','BLISTER','BLISTER',NULL,'Weight',0),('5e5eb7d7-403d-4da7-826c-df47d8dac604','MD','MD',NULL,'Weight',0),('8d41c267-ff40-466b-89b3-fff445a46b55','TABLET','TABLET',NULL,'Weight',0),('8f832dfa-55ee-405d-9dcd-795264b3c656','ROLL','ROLL',NULL,'Weight',0),('920990f3-1cdd-4062-8d5d-835e47dc957e','Day','Day','','Time',0),('92d61b55-d41e-4b28-aab8-6122eac8c6c1','JSE','Jasa Tuslah','','Weight',0),('a78ad9e1-1fb8-4a91-beeb-a1022f632bb2','KAPSUL','KAPSUL',NULL,'Weight',0),('aa7796e0-9a11-4ad2-b927-7ae9bb25cc92','BOTOL','BOTOL',NULL,'Weight',0),('afe54bba-c2b1-4915-973f-24069d45d790','KAPLET','KAPLET',NULL,'Weight',0),('be5ad391-0c12-4c0a-bad5-7ee5254abb56','Hour','Hour','','Time',0),('c99fc794-b3ff-4afa-af41-18505f9cded7','AMPLOP','AMPLOP',NULL,'Weight',0),('d39e1e7d-a7ac-4027-9762-43d58893f68f','DUS','DUS',NULL,'Weight',0),('e1db32dc-f5f5-4b85-8d57-1f278355ba6b','Year','Year','','Time',0),('e7213b99-369f-4b28-92be-80fc0ec57886','FLS','FLS',NULL,'Weight',0),('ea7c09e7-a2e5-4fc4-a060-1addffb654e7','RECTAL TUBE','RECTAL TUBE',NULL,'Weight',0),('eddf7518-491f-4713-bf70-85bab5a09938','STRIP','STRIP',NULL,'Weight',0),('f5d20b38-1fa8-4ae8-95af-94f638af73f7','KOLF','KOLF',NULL,'Weight',0),('f66bccf3-c3ab-46b6-b8b7-5b19a1fdda3a','BOX','BOX',NULL,'Weight',0);
/*!40000 ALTER TABLE `unit_of_measure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `uom_factor`
--

LOCK TABLES `uom_factor` WRITE;
/*!40000 ALTER TABLE `uom_factor` DISABLE KEYS */;
INSERT INTO `uom_factor` VALUES ('2679d072-48ba-4816-afb3-d3c4b27359e0',176,'002e1b00-f0a8-4313-abf8-dbd3d863b1d8','be5ad391-0c12-4c0a-bad5-7ee5254abb56',0),('6de49d0e-a662-433a-ae33-a3356422d1da',22,'002e1b00-f0a8-4313-abf8-dbd3d863b1d8','4906be4c-a7c6-4aef-a215-c68cc2a7de77',0),('a49172cd-35f1-4201-a29b-d23a8c4ab87a',5,'3744de49-a23d-4280-8f8f-b8a2218ffa2b','4906be4c-a7c6-4aef-a215-c68cc2a7de77',0),('e040fefe-b37a-403d-a005-afc2203547e6',4,'002e1b00-f0a8-4313-abf8-dbd3d863b1d8','3744de49-a23d-4280-8f8f-b8a2218ffa2b',0),('eb089afc-b624-4ce5-95b3-46360e9cb8ff',8,'4906be4c-a7c6-4aef-a215-c68cc2a7de77','be5ad391-0c12-4c0a-bad5-7ee5254abb56',0);
/*!40000 ALTER TABLE `uom_factor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('97dc9715-47eb-45d5-96ba-0a582fabdf3b','admin@belian.com','jIfSsj+ceSsamqTfmru/ZlLSRsjwUijQK4CJqi86fLNWb/nqSv2eY2rRrJxgpdDM','1',NULL,'0',0),('b9e55e5b-2f34-45e6-937d-69a930dd1a52','sukhaa13','onato69Ss6C2CSe+oiQcHOPLR+0dOXUoFj4IEwmXR72bseFTbmErP51+B5lQawiy','1','1900005f-9c8d-4330-bbbb-3288c18e18fd','0',0),('ef8b3235-7cb8-480c-b94b-62563a058fa9','Dr Johan Molana','qd2+OYhtKI+y8ljpWes7wOVKTduPQvRS8P/sJymFJTWGhAxo7O3y2hEvbBt+wFwQ','1','436c802d-d290-4e34-ae91-11b51edca462','0',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES ('0348b97e-8758-49f8-b9e9-e8c6763d7777','096b0105-de76-492c-9bb0-5e518b46d69c','ef8b3235-7cb8-480c-b94b-62563a058fa9','1',1),('849138a5-4b4e-41ea-8f24-e4586e7f8ab9','096b0105-de76-492c-9bb0-5e518b46d69c','97dc9715-47eb-45d5-96ba-0a582fabdf3b','1',0),('d748f5bd-1775-4609-bcd7-78a50c44fa77','096b0105-de76-492c-9bb0-5e518b46d69c','b9e55e5b-2f34-45e6-937d-69a930dd1a52','1',1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_setting`
--

LOCK TABLES `user_setting` WRITE;
/*!40000 ALTER TABLE `user_setting` DISABLE KEYS */;
INSERT INTO `user_setting` VALUES ('1900005f-9c8d-4330-bbbb-3288c18e18fd','4a129f6b-7b21-4640-bf78-4da17201894a','Aim Medical Center','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','Pontianak','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','R-PPN','in_id',25,'POS',19),('436c802d-d290-4e34-ae91-11b51edca462','4b6b0923-ee66-4459-817c-8a3615e77276','Aim Laboratory',NULL,NULL,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','R-PPN','in_ID',25,'POS',0);
/*!40000 ALTER TABLE `user_setting` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-21 10:36:58
