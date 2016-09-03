CREATE DATABASE  IF NOT EXISTS `belianeducation` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `belianeducation`;
-- MySQL dump 10.13  Distrib 5.7.12, for osx10.9 (x86_64)
--
-- Host: localhost    Database: belianeducation
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
INSERT INTO `access_role` VALUES ('01f5388b-c63e-4d09-b3b5-dd6456dd0815','c79e78d0-3427-440c-b8fe-df126e667a8b','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('0442dff1-c1dd-45e7-8634-2b9d90904469','7bef1d92-0f15-43ef-b59b-5bc3e769d896','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('060d3480-7c9a-44c7-b572-d7b2c4067359','916b22eb-48fa-4000-b7a2-7fc1d47ced4e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('0a1a6c1d-e681-48c4-b400-be611a9f70b7','8a05b279-2f80-47b8-a2a7-63fbe96d327e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('0e9073d1-2be3-4a8a-9a82-5bd1166757e2','847a8df6-bc04-4de6-8d7d-28e41c00f422','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('195dd074-a5e5-4abe-bc9f-5e913229bbb6','2d7e5641-511d-43fd-a6d6-a482120f8aa5','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('1aa3a48c-ab0c-4949-945e-e9852a9b9a93','95dd39dd-512e-414e-b95c-0fc251887f98','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('22fbdfec-6afe-4f2f-bd69-ac6a9974ae82','5c37296e-ab30-4d07-bba3-342d4c403f48','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('2c661c0d-53b6-44c7-85bd-ba04da473be3','c0f3237c-23c2-49ab-bc9c-e00aa706d7e2','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('2d52482a-0a7a-4e49-83c6-9db73e4e051b','80aebe74-399c-4273-9145-956a077d3f5d','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('3202f4e4-fd87-41a8-ae71-fbefce6a2ef4','b54c8e49-c820-4292-9f74-9e47bd55711f','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('32915e9c-96bf-44b3-881a-2f7c917a4c92','d33784ca-abd5-422b-b45a-8c8ee13ddc0a','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('32cc538f-0445-4ec4-9d2e-3084e89062d1','7f17176c-f27a-432c-a106-0d7d87b0afb7','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('331300a2-cc8e-4417-abb3-45dadf814422','fca1cfcf-d199-4729-a321-e1ed01deb0f1','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('37484efd-9cb6-4f79-903f-e7d6687658cc','6861d3b3-8110-46ed-8a3a-830963597fa7','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('3a225b38-8dbd-482a-9c14-2f7f1c535068','88bf4008-c84a-4089-88c6-e9d8f077a196','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('48c06de3-442f-4125-a438-e370fabade36','f50dd16d-0e25-44b6-bd69-c28dfcc55300','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('48c4056e-33f6-4082-af20-0139f3e66371','8217c196-16b9-44fb-9662-8323220ee705','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('490e4434-7ea2-475e-a66c-ea7296b82c54','29ec80f0-0d4c-451c-ae5e-f195c4be1a27','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('4b15a790-2920-47f2-b805-33ecd48b9bac','2c0d9a06-cebd-4da2-b520-2e948aae3e53','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('4fffeab2-b09c-47fb-92b4-3981da252637','9e644628-121d-4954-8a66-8002cc866bda','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('541dd297-fd64-44ae-bcf4-fed612227962','4b3bb551-173e-46f5-b1e9-bdd719e3045e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('59d88282-5a3f-481b-9bb8-91679fbf4d91','f53b80db-1b89-4779-86e7-b065b5287bbb','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('5a2ce59a-60c2-4203-9d3b-7c5d038fe635','e916392a-0b3c-4543-ada7-93054383bb3b','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('5c2ddb84-b28c-40f6-81d5-351e0ea1037d','627fb961-6cf0-4148-9451-0d1422095eb7','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('5c9ab463-dc50-47a5-a601-f074734adf3c','abfd9a02-3b4b-47a0-9048-a65b6be0b3aa','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('6179118a-ff80-452a-a89d-8e0154725095','b662de02-f4a3-4f1a-819b-5d2aaf6a342b','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('6416ea67-8c7b-477e-811f-c5e4e45ca9c0','99623cbd-066f-4cc2-b9b3-1961bed131cc','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('6655f91e-4928-4c6f-b83a-f43b28f04454','770c420c-f809-43f7-969c-b493f0b4ef48','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('6adcd07b-62da-4e75-a076-80520a58eb32','5cdd1545-8fdb-4a79-b2a3-0662ed6fec30','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('6ed261e4-7608-49cd-9953-a04e3ff8dfed','affcf2e7-fd2c-4b39-beee-97b5dc5a1405','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('711417b0-a5ea-4c2e-8ab3-e5a96576b45b','8f6ec9c8-e9ed-49e1-ab7a-c4a868b8391e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('71479847-69f5-43fa-b7ce-00af42c28d4a','339d7200-9aa1-43d5-8683-e7118cb52839','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('724b174d-96ec-4152-a42c-2d03097b9aa9','342b0b64-291f-4d12-bdb8-77186895d21d','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('79450f94-0cbf-4c0d-ad76-3362a4abe180','4eca5501-a650-41d5-87c1-c091391d3608','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('89c3b455-3c46-4bc4-9a13-77c171e129b6','a4c43802-436f-407c-8793-323600c181d7','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('8c6f9ab1-f804-45c2-8504-9d9cc9d3199c','532efe0a-05ff-4f94-877d-a7f3f7509569','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('923b7b67-a1e4-478a-9769-e2ee32b685b1','ee3c3540-9c62-46df-a79e-f7b636a9ba1d','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('94863d4d-7d07-41d2-bc78-4f65260776d6','13989b38-ac2c-47b8-8708-5e27477af18d','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('96318b3e-baf7-479b-ab07-d0798114d3bd','e54e6ba5-7ffd-457b-a23e-8b6285867ba4','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('9659ee34-7845-4078-89bd-9ee9b9e37b78','855aab16-cb45-41c3-b62c-55185ff77dfc','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('9728b76b-eac0-44c4-9ba9-afca669e0a76','e8f89299-2138-4167-b5b7-52f6ae1667ca','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('9f52d7a0-217e-4084-9bb3-78c5c81dd536','07452775-a048-4071-8798-21dc943fe926','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('9fa511a1-e704-4018-a90a-57acea0ac5da','1adc4b8b-ad93-4658-8476-6bb13e2e810d','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('a055f787-df6a-4c93-af22-12797bf5ec39','69443009-4a15-4061-b9f0-08c08c8f50aa','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('a3e8ba06-d955-4929-bd36-f658f3796b6c','a4aa9ae0-5166-4d06-afd1-d2eea6f2417c','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('a3ef8fbd-46f9-43db-ab47-31d062c3fb20','74ad4867-9495-472f-97fc-36bf87895585','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('a7951344-6b9e-438f-af5c-7b94dee26b2d','83b19678-9f2f-49f4-ba25-0f31a8dee078','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('a8a90cc0-470f-456c-879b-77c0ed469dd7','9df71b1a-0e52-4445-98ea-b9a59ad81ac9','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('a91848d3-83d1-485a-9846-c83ff3699ac2','322d37f6-a667-481e-bc22-db212d0154ea','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('abecab92-51cb-4ca9-88a0-9446c1bc5ae3','4eb93eb7-2100-49ae-bd96-a39995ed5670','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('ac144c04-22c4-47fb-8fd4-3783a4f29a90','1cf392fc-4f93-4e38-9709-2beb84434951','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('ad389302-f250-4270-a937-75cf984c2f80','2bdc3f95-c5bd-47d9-adce-9e9df1042e2f','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('b31dbbf6-6b74-4aa9-9db4-6ebd3888ef91','355ca995-6bae-4638-bfd4-a9bfeff5eefb','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('b4f04a2c-d9a4-4b30-b75b-4572685e35a8','9178e8cd-4063-4fe9-a060-d2e3ac818ed1','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('bf839209-25d9-4ea7-8e4a-d771f7599e2e','6cbaf072-6925-46e9-b417-17326f3d8584','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('c2d02e3b-7b8a-47b4-bb08-30f37f9505fc','9b9deb26-0960-478c-8cac-4ac475c3ffc3','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('c655e02a-f2a3-4132-8bd7-9428cc1ce3af','0b503053-31eb-410d-90a6-ec6a9977bc1e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('c836928e-da88-414e-b572-db436cc948a4','4939e42f-06b5-4e44-b3ba-4106964f1f68','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('c9681985-0b2a-4537-822b-8f477bc15104','65414caf-3a73-4e3f-9a58-2d70c723b5bc','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('ce77f072-7ad1-4cb5-9e9e-0d9b89a853bd','314a3f13-a982-4915-a5cb-455eacbc27ae','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('cf2437ad-5e59-4f7a-8190-f537beabc623','58621810-2c8f-44ae-b9aa-b1e05ad32743','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('cff3c8ef-bd79-4d32-be37-b4a2e7dab027','90195ecb-4674-4614-a429-eebc24ffe773','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('d11fbe57-0eac-4f6f-bc22-14a0ed221733','fab64cd8-7762-412b-90fb-3d31d5576b45','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('d8a71d8e-344a-4c18-88ff-9ca2cffed715','b9935030-f5c1-479e-9ec1-795afc1c1e7e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('de2ab421-31cd-45b7-b6d7-5baf50797f2c','6e299ade-e10e-4940-ae83-bdf61505ed63','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('e1ae7cc5-aab3-4271-a744-9d17fca44e9c','9b9e014c-7a23-40c1-8841-30044564bf7f','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('e1ae7cc5-aab3-4271-a744-9d17fca44e9x','9b9e014c-7a23-40c1-8841-30044564bf7x','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('e51c5ad1-38c7-4699-9c92-50f070f7a7f3','4bf39427-b32a-434c-bd71-4d9493ea6eef','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('e6f44dd7-9616-4c85-aaa9-e5322ea39319','b44420c6-261b-44c5-a23a-7802a0506dab','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('e9b3d5e4-1259-48bc-b521-7abb7d72bc30','e4307d82-f3fa-4916-9e6b-7a4f894d847e','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('ed0df929-8852-42ca-9006-e0ad6fd37a90','55b7e0fb-a178-478b-a09e-4b753f161aeb','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('ee5e29eb-cf8a-4c54-a709-da55952b8f80','5eda5016-f448-42dd-926b-52b10870e29c','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('f0c0441f-80df-4405-8927-c114d9c61edb','e4d249e1-4bd5-4291-9050-62a99f70f64c','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('f0f949d7-f756-4fdc-bacd-b6e145b9829d','5e8c4a66-e46a-4000-ae1c-bf536686b30f','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('f21a4567-0723-4569-abd7-8e59e3645767','0c586cf4-9bd2-4b93-b24b-d41ceca2aef4','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('f6e69991-8825-41e8-a6e7-24a4c6257c4d','dbc9175e-eb27-45e9-9e43-a1c12d6354e4','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',0),('f7284b39-b584-4334-94f0-0631d3a9b429','4500a912-bbad-4590-9abb-d9ec92a311a5','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1),('fe2ef334-8861-41af-887a-a95992d46b74','8c7e1020-0824-4239-9a4e-46301c80b9cd','096b0105-de76-492c-9bb0-5e518b46d69c','1','1','1','1','1',1);
/*!40000 ALTER TABLE `access_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `accounting_period`
--

LOCK TABLES `accounting_period` WRITE;
/*!40000 ALTER TABLE `accounting_period` DISABLE KEYS */;
/*!40000 ALTER TABLE `accounting_period` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES ('010d2467-3a43-4a99-a33b-76ce10b2fd88','Jl. Apel Gg. Apel No. 23','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','731838a3-08f5-4f01-9cc3-7b0985239d44',0),('0cb7f1ef-72dd-4edf-9d0c-3784d14e166e','Jl. Gusti Hamzah Gg. Nur2 Dalam No. 4','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','022b153f-c31b-4bbe-bcf3-90dfc5243579',0),('0f6402e1-4058-4040-b734-efd514842463','Jl. Gusti Hamzah Gg. Nur2','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','a77bcca4-aee3-4cd3-96c0-b0e78ff13f73',0),('109286a5-5e1a-496b-bc94-52ef9ff59802','Komp. Didis Permai 7 No. 21D','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','4dc0134d-711c-468e-af68-6faa3aa9ea1e',0),('123e48ff-66c4-4a8e-bd57-4c21ef39a8d7','Jl. RE Martadinata No. C10 (Ruko)','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','c407032a-4d0d-4b6d-94a3-ae891170e65c',0),('15d5a8c9-f281-4c25-a830-e090f75e9151','Jl. Kom Yos Sudarso Gg. Lamtoro Surya Kencana A2','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','12529b23-3ec7-4912-a7ba-4a7dd0b14b64',0),('17e1801e-8bfc-4ea8-ade7-942e3cee8f21','Jl. Karya Komp. Villa Permata Asri F.8','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','8a820547-5d64-4589-bf73-837687170286',0),('1ef7144c-41a0-4d6a-9bea-350c855e7cf5','Jl. Husein Hamzah Komp. Cempaka 5 No. A-16','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','49a021f9-ef29-4e7b-88a6-bdd1ee2f4d70',0),('23bd3fa3-1131-4b18-a53f-02a896fd0cbc','Jl. HM Suwignyo Gg. Al Karim No. 21','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','ce59473f-8bd8-4c7c-a118-6228a2b301a1',0),('2458bbd7-3fe3-4f57-bd0b-dcc12073c25e','Jl. Marta Gg. Pala 4 No. 23','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','819d4ae9-36e9-47d5-b572-c7fb8c76f392',0),('2550de8e-b4ad-4e0e-8a15-1f4c20679c00','Jl. Karet Komp. Surya Kencana I No. D24','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','280c1c5f-5bfc-41c7-9162-805edadc6a7c',0),('25b80ce4-d25f-4ad1-8344-d81d64d1daf0','Jl. Sejarah Gg. Gn. Malabar No. 33','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','e26ce188-8644-46e6-b25f-e131cf46d678',0),('281eb906-ff88-4ebf-844d-6dc303a5bd71','Jl. Dr. Wahidin Gg. Sepakat 3 No. 14','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','a3ad09a6-dac6-45b9-b678-750014a6cf73',0),('2dd719e3-2945-42d1-b20d-7be25a0fdae0','Jl. Husein Hamzah Komp. Harvin Indah No. B19','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','f89abcfd-9762-4a07-8b49-ad4f844b3ca1',0),('30781006-bd43-438c-b4bc-25b6d98c5349','Sepakat 6 Jalur 2','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','1ceb724e-4833-417f-b34c-8086eb670f7e',0),('3099765c-c9fc-4951-91bb-5d7ed0ebe0ca','Jl. Karet Komp. Didis Permai No. A13','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','4a842e24-386c-4380-a333-3337b7f9029b',0),('33a4431e-6e90-4790-95ef-713af9a79dc2','Jl. Pangeran Natakusuma Gg. Bambu No. 19A','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','cb1e074f-7ba2-415e-8523-4c36b75e2101',0),('33acee69-09bc-4bc5-96e6-5b8a64bcf922','Jl. Tebu Komp. Tebu Mandala No. 26A','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','c0f065ac-a095-4a85-a28f-f116a9ba3e57',0),('395c2771-4c04-4f2b-ab3a-a71052c04ca3','Jl. Kemakmuran Gg. Kemakmuran III','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','65b78b03-601e-4570-bf18-14c7d44e1a18',0),('3b56fd1e-4d50-4a4b-bb60-ea38f97b32e9','Gg. Margosari No. 12A','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','42901be4-86e0-4e24-be0f-0698dd7ae9bf',0),('3d08c7b9-1926-4271-bd8e-35f3325fb7c6','Jl. Karya Baru Komp. Bali Agung I No. 10B','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','2625e364-072a-416b-846e-90b6add43bef',0),('41b8e093-c0f7-40a5-bf38-219f67f52f81','Jl. KHW Hasyim Gg. Usaha 2 / 26A','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','f4eded39-41dc-40b7-b249-84c7daf9713d',0),('4d9e7ea4-c53b-41bd-a4e8-9e5d3f735264','Tj. Raya 2 Gg. Amanah SBR,6 (plus) Blok E1 No.5 Saigon','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','63a56e3f-f59b-432f-9c9d-463f1f744334',0),('50724f80-3f6f-4c36-bdc2-57283b28444c','Jl. Pangeran Natakusuma Gg. Rencana No. 23 78116','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','923274db-d2a5-4a78-9962-86348c84e283',0),('51bfdfd5-7612-4f61-bd75-727fe81db8b5','Jl. Gusti Hamzah Gg. Pancasila 4B','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','756755c3-1ddd-4086-b862-e7e9298b30cc',0),('57aec5a2-6815-4fec-a70e-b4c7c3f45aa2','Jl. KHA Dahlan Gg. Ruper I No. 21','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','20677939-457c-4ac0-bf48-d93a5a02938a',0),('59fc4cb2-6ffe-4426-8ef3-3b1d767f358f','Jl. Sejarah Gg. Gn. Malabar No. 33','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','924efe8c-512b-4f7b-9b59-23f0a0e87369',0),('5c9577aa-6df3-4573-b8d5-7e34130d9684','Jl. Alianyang Gg. Rahayu No. 10','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','8e004f0b-e655-46c5-a38d-cc0217cca15a',0),('602edd64-ed21-4c7c-8c89-ac4675db40ff','Jl. Ampera No. 5 Kota Baru','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','964a55cc-2dbb-48ea-b45a-62e4f244a796',0),('60dd32ff-ff3d-4bb0-a483-05394080871c','Purnama Agung 7 Blok H 12A','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','c76091c1-4d94-447e-96f8-476bfee31604',0),('665ec1f3-2ed4-429a-b035-dc456080f714','Jl. Sungai Raya Dalam Komp. Palem Raya No. A11','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','11bb1ed3-dcdd-4430-908e-3d7e84870a88',0),('6be073cd-dc61-4ef0-b132-12b3937ff2c4','Jl. Kenari Gg. Merak II Dalam No. 19','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','0191c9f9-ed27-4967-93ed-add08b6f6f26',0),('746b8398-1be5-4fe8-b9b9-158482d051a3','Dr. Wahidin Komp. Mitra Raya Lestari III D15','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','088f14ea-d0e6-4177-8998-cca133fae524',0),('7c15a7a0-f61c-42b1-994a-5b15d98b0914','Jl. HM Suwignyo Gg. Sri Mulya B24','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','6c0fadd3-9867-4d3c-b9f5-502676b503a8',0),('7fd108b5-6d82-4a70-bde3-03b3e1361880','Jl. Tebu Gg. Rachmad  No. 53','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','61105d59-ec88-4467-ac05-8334d9f66e50',0),('89775c62-05b9-4166-a4ac-1356e8d33257','Jl. Danau Sentarum Komp. Mitra Utama V No. B15','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','a8280d8e-553c-4074-90b4-1f71b5c34e27',0),('8a120523-c7f6-451a-807c-a2df5364d1c9','Jl. Dr. Sutomo Gg. Karya I Gg. Pak Abu No. 31','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','6ad80274-db6b-42e3-8013-6ad1e441fb81',0),('8eeb39ca-5ddd-47aa-9dd5-402667e9866d','Jl. Alianyang Gg. Rahayu','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','348d0045-3db2-4e43-a632-ad70f82f86dd',0),('9a320d56-b39d-4984-b100-c33bcb86caf5','Jl. Dr. Wahidin Gg. Sepakat 6 Jalur 4 Blok L No. 1','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','9d91dc31-8244-41e6-9c4e-9a07bdef3122',0),('9f9b6ba6-a760-4618-8dfc-08d303b378c7','Jl. Gusti Hamzah Komp. Navigasi No. 14','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','03039740-cb9e-49dc-a670-a600b41d21d1',0),('a65a0faf-3e54-43dd-93e5-2b12aeba215d','Jl. Pangeran Natakusuma Gg. Melati No. 20','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','763a852d-5742-4be1-8905-714bcecebefd',0),('a9a69113-3f1a-4216-ae5f-6268b8b2945a','Jl. HM. Suwignyo Komp. Citra Indah I No. D9','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','2f43245c-8573-42cc-9692-8e3236de2f97',0),('ab4b8701-233e-41fb-899a-2ffb55b057dc','Jl. Ujung Pandang Komp. Taman Firdaus B15','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','b7afc825-ce01-493b-b59a-071b5645b682',0),('af4c8631-1fde-4a30-8f0f-14020b20513c','Jl. HRA Rahman Gg. Bendahara No. 11','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','3878879a-2e22-4a97-9929-ff37e1c31431',0),('af81a6ff-3766-4a79-8431-56d352782da4','Jl. Husin Hamzah Gg. Bersaudara No. 3','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','d67ddc3e-1c60-4aff-8120-66dccf9263cb',0),('b5d8dc5e-1a2e-4986-b156-e3c759aa055a','Jl. Karya Sosial Komp. Bumi Persada No. 9 Ampera','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','0ee45092-38fe-4270-a4c2-6657fa59298e',0),('b6747af4-fcd7-4e9d-95ba-de57f7837eb9','Jl. RE Martadinata Gg. Pala 4 No. 8','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','017973d0-bdbc-4b6a-9b1e-bff197ab71f0',0),('b91b8d40-1c25-48be-a4c2-789e6759cfbd','Jl. Dr. Wahidin S Gg. Sepakat 2 Komp. Sriwijaya 2 No. 3','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','146508c4-cdd5-44e0-9d99-4f5041bf740f',0),('bd561d5e-5154-4288-bec0-8423f868f176','Jl. Suwignyo, Gg. Kurnia Indah No.7','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','fe8c2142-a8a5-428b-b242-84d7f384c079',0),('be55fda1-e249-4407-8654-051daa5abb73','Jl. Sejarah Gg. Puting 2 No. 40','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','aa10f218-64f3-4c41-8a90-c5a578896e17',0),('bf4eccbf-d032-4820-81c5-f91692e85ce4','Jl. Khatulistiwa Asmil Khatulistiwa','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','36f481b9-37e7-4c28-99e5-369f45200634',0),('c064e7c1-d79f-41ae-abc8-5dd2b7df552f','Dusun Sengkuang Daek','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','d0ae6c1a-d6e2-4ca8-879d-52d74e6feb71','f5a12273-368d-4d39-851a-05da7bb04ab9','d73b0190-ec65-4e75-8b15-aaebbfb4dc97',0),('c0788886-d865-4470-85bb-382c68928c05','Jl. H. Rais A Rahman Gg. Keluarga No. 9 76118','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','bc260302-c07d-47a6-ad55-bdda6b4b16e5',0),('c2ce42e0-ae5b-4ffd-96ea-c68ce04d7795','Asrama Hidayat Blok V No. 2','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','8459900c-a178-43dd-b215-5e5c089475a2',0),('cad02d1a-01f7-431a-b773-54b59b7c6fc4','Jl. RE Martadinata Gg. Puring No. 7','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','b5cbc987-4f00-4fd8-b6d3-5c8de2e4ed45',0),('dab3018f-2019-4911-a91d-a23e55dee84a','Jl. HM Suwignyo Gg. Sri Mulya No. 9','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','3459dd9e-7ec3-436f-9c39-db93a9c8f7c6',0),('dd1048c7-d2b2-40e0-b014-2e9d575af49b','Jl. Suwignyo Komp. Citra Indah I No. D-9','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','29454f3b-e557-4cd5-b95d-8cd189c3c331',0),('de7d7b8e-8ae5-4fac-86a0-2b5487856fdd','Jl. Martadinata Gg. Timun I Jalur 6 No. 42B','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','e9ecb5e5-ec98-40d3-9282-6b7949c99924',0),('e1ceea38-7e9d-4b41-9445-5a99a3161c82','Jl. Ujung Pandang Komp. Taman Firdaus B15','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','f8c59058-2728-4039-87d2-409b42b9dbc8',0),('e1db0f3c-4d16-405f-b563-63bd0761c0f5','Jl. HM Suwignyo Gg. Nur3 No. 17A','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','633e7708-63c7-4f1f-8312-1d210e0dd065',0),('e3283197-f76d-4798-9680-76305d25f66c','Jl. Purnama Komp. Dinasty','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','f6917d75-083e-4325-bc07-77af774f043b',0),('e7fed549-1c14-4781-811f-7914e580c15d','Jl. HM Suwignyo Gg. Margodadirejo I No. 27','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','41095616-583a-4e15-8563-e405bc26d0d3',0),('ea510593-7049-441e-a83a-5f318692b710','Jl. Karna Sosial Gg. Wonoyoso 3 No. A1','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','539fc7b2-a4a1-4b0e-a520-4bb2148b5405',0),('eabee31a-2011-47c7-8a48-3f2a254d4739','Jl. Tabrani Ahmad Gg. Zurriyat No. 3','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','e68fa2ab-75bf-48b8-ab52-55f89e7a4787',0),('ef52b384-4241-4cd6-9604-c901b0127776','Jl. Dr. Sutomo Komp. Batara Indah IV No. 11A','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','1eac9139-6b4f-40ff-aafb-a1be57705592',0),('f19c2096-23fd-42a3-9ad5-8609e89152c8','Jl. Dr. Wahidin Gg. Margo dadirejo II D No. 8','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','7aff71e4-ddaf-4f7b-aff6-6a95cff39ed2',0),('f24e9819-ae77-4e27-8557-24519d2d5a7f','Jl. Tebu Gg. Rachmad  No. 53','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','1701ebcc-9dde-4e2f-9ac5-4cec4dd8d386',0),('f79eb7aa-a9b4-4198-9f44-1e8a638ee14b','Jl. Dr. Wahidin Gg. Sepakat 9 No. 28','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','4221f198-19b2-416c-bf46-71163727a0ff',0),('f94533a9-f8a4-4d98-8e39-e3665cfc13ca','Jl. Ampera Komp. Ari Karya Indah 8 No. C4','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','20266334-c727-405c-b710-f215473e4396',0),('fb21f4d6-d0f7-4475-ae0d-60d97ad2ed54','Jl. Tanjung Raya 2 Komp. Bumi Citra Saigon No. B17','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','77a9c861-faaa-4b4a-a7b2-2d7124be9ba3',0),('fbd08f2e-2c82-46e5-9eb0-fd30cae51a83','Jl. Dr. Wahidin Komp. Batara Indah I Blok M No. 13A','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','44a75f39-d018-4644-b028-cd2328ac7ef8',0),('fc882beb-6bc9-4db3-992f-318e755f623a','Jl. Bina Jaya Gg. Damai 2 Komp. Nusa Indah 2 Blok G No. 17','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','e196257a-b925-4413-8ede-d4a7bd9f2466',0),('fdd12824-53ff-46b1-982a-2b93be93d071','Jl. Sungai Raya Dalam Komp. Mitra Indah Utama 3 No. A10','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','f5a12273-368d-4d39-851a-05da7bb04ab9','ffa7d45c-37c8-46cf-9a02-6973fa73ca3d',0);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `approve_and_reviewable`
--

LOCK TABLES `approve_and_reviewable` WRITE;
/*!40000 ALTER TABLE `approve_and_reviewable` DISABLE KEYS */;
/*!40000 ALTER TABLE `approve_and_reviewable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `approveable`
--

LOCK TABLES `approveable` WRITE;
/*!40000 ALTER TABLE `approveable` DISABLE KEYS */;
/*!40000 ALTER TABLE `approveable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `asset`
--

LOCK TABLES `asset` WRITE;
/*!40000 ALTER TABLE `asset` DISABLE KEYS */;
INSERT INTO `asset` VALUES ('cd0c3f10-40b0-4c47-b2f7-a2043e5311b6','ADMIN 1','ADMIN 1','2016-08-07',NULL,NULL,0,'1','0','ca1d20d1-5a09-4a2a-ba28-f3f0b79a0099','','e29c7687-30f8-4201-af68-0a4a67541b86',NULL,11);
/*!40000 ALTER TABLE `asset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `asset_type`
--

LOCK TABLES `asset_type` WRITE;
/*!40000 ALTER TABLE `asset_type` DISABLE KEYS */;
INSERT INTO `asset_type` VALUES ('ca1d20d1-5a09-4a2a-ba28-f3f0b79a0099','KOMPUTER','KOMPUTER',NULL,0);
/*!40000 ALTER TABLE `asset_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `audit_trail`
--

LOCK TABLES `audit_trail` WRITE;
/*!40000 ALTER TABLE `audit_trail` DISABLE KEYS */;
INSERT INTO `audit_trail` VALUES ('08fe61d0-ea27-40fe-980d-de636002ca56','2016-08-28 09:41:47.846','0','DODI','SSC PANCASILA','Cashier Shift','Open new shift for cashier on ADMIN 1',0),('48fef393-0579-4b34-adc2-207940590db0','2016-09-02 20:58:11.233','0','DODI','SSC PANCASILA','Cashier Shift','Open new shift for cashier on ADMIN 1',0),('4d3220ed-ed29-4cb3-8589-e38b71983bf8','2016-08-28 09:46:52.75','0','DODI','SSC PANCASILA','Cashier Shift','Closed shift session for cashier on ADMIN 1',0),('70bb3319-b263-4a14-9da3-e76c562f4ec2','2016-08-28 09:41:54.48','0','DODI','SSC PANCASILA','Cashier Shift','Closed shift session for cashier on ADMIN 1',0),('7a019e1a-a4fa-4ac2-84ab-ccff8dea2a2d','2016-08-07 09:55:28.206','0','DODI','SSC PANCASILA','Cashier Shift','Open new shift for cashier on ADMIN 1',0),('8cdef6ee-3456-430a-9eff-bdb89787afd3','2016-09-02 20:58:04.682','0','DODI','SSC PANCASILA','Cashier Shift','Closed shift session for cashier on ADMIN 1',0),('9b7c481b-7d25-4c53-b4ce-7532b9e61441','2016-08-28 09:43:30.05','0','DODI','SSC PANCASILA','Cashier Shift','Open new shift for cashier on ADMIN 1',0),('ca3b3ed3-ffe2-4198-ac3a-d61d4245e2bb','2016-09-02 21:16:12.019','0','DODI','SSC PANCASILA','Cashier Shift','Closed shift session for cashier on ADMIN 1',0),('cb4d7405-ce3b-413c-9fae-1833371c39c3','2016-08-28 09:42:50.636','0','DODI','SSC PANCASILA','Cashier Shift','Closed shift session for cashier on ADMIN 1',0),('d779e334-f8a7-4087-8555-15eb213863d7','2016-08-28 09:42:44.569','0','DODI','SSC PANCASILA','Cashier Shift','Open new shift for cashier on ADMIN 1',0),('d95d2deb-e6ab-426c-9319-530cb4f5b2a3','2016-08-07 09:54:41.259','0','DODI','SSC PANCASILA','Cashier Shift','Open new shift for cashier on ADMIN 1',0),('f0fdc3bd-dbe4-484e-9758-395bf4129e1e','2016-08-07 09:54:46.824','0','DODI','SSC PANCASILA','Cashier Shift','Closed shift session for cashier on ADMIN 1',0);
/*!40000 ALTER TABLE `audit_trail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `auto_journal_sales`
--

LOCK TABLES `auto_journal_sales` WRITE;
/*!40000 ALTER TABLE `auto_journal_sales` DISABLE KEYS */;
/*!40000 ALTER TABLE `auto_journal_sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `benefit`
--

LOCK TABLES `benefit` WRITE;
/*!40000 ALTER TABLE `benefit` DISABLE KEYS */;
/*!40000 ALTER TABLE `benefit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `benefit_type`
--

LOCK TABLES `benefit_type` WRITE;
/*!40000 ALTER TABLE `benefit_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `benefit_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `billable`
--

LOCK TABLES `billable` WRITE;
/*!40000 ALTER TABLE `billable` DISABLE KEYS */;
/*!40000 ALTER TABLE `billable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `bpjs`
--

LOCK TABLES `bpjs` WRITE;
/*!40000 ALTER TABLE `bpjs` DISABLE KEYS */;
/*!40000 ALTER TABLE `bpjs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `budget`
--

LOCK TABLES `budget` WRITE;
/*!40000 ALTER TABLE `budget` DISABLE KEYS */;
/*!40000 ALTER TABLE `budget` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `budget_item`
--

LOCK TABLES `budget_item` WRITE;
/*!40000 ALTER TABLE `budget_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `budget_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `budget_review`
--

LOCK TABLES `budget_review` WRITE;
/*!40000 ALTER TABLE `budget_review` DISABLE KEYS */;
/*!40000 ALTER TABLE `budget_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `budget_revision`
--

LOCK TABLES `budget_revision` WRITE;
/*!40000 ALTER TABLE `budget_revision` DISABLE KEYS */;
/*!40000 ALTER TABLE `budget_revision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `budget_revision_item`
--

LOCK TABLES `budget_revision_item` WRITE;
/*!40000 ALTER TABLE `budget_revision_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `budget_revision_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `budget_role`
--

LOCK TABLES `budget_role` WRITE;
/*!40000 ALTER TABLE `budget_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `budget_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `budget_status`
--

LOCK TABLES `budget_status` WRITE;
/*!40000 ALTER TABLE `budget_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `budget_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cash_purchase_order`
--

LOCK TABLES `cash_purchase_order` WRITE;
/*!40000 ALTER TABLE `cash_purchase_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `cash_purchase_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cash_purchase_order_item`
--

LOCK TABLES `cash_purchase_order_item` WRITE;
/*!40000 ALTER TABLE `cash_purchase_order_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `cash_purchase_order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cash_sales`
--

LOCK TABLES `cash_sales` WRITE;
/*!40000 ALTER TABLE `cash_sales` DISABLE KEYS */;
/*!40000 ALTER TABLE `cash_sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cash_sales_line`
--

LOCK TABLES `cash_sales_line` WRITE;
/*!40000 ALTER TABLE `cash_sales_line` DISABLE KEYS */;
/*!40000 ALTER TABLE `cash_sales_line` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cashier_shift`
--

LOCK TABLES `cashier_shift` WRITE;
/*!40000 ALTER TABLE `cashier_shift` DISABLE KEYS */;
INSERT INTO `cashier_shift` VALUES ('163f2763-c270-41d2-b31a-cd98b6fcc3f4','2016-08-07','895f107c-991a-4173-8dba-f6a906e13cef','1','cd0c3f10-40b0-4c47-b2f7-a2043e5311b6',0,'09:54:41','09:54:46',NULL,1),('616831d5-8437-4b38-b723-6c04eaa3aa7e','2016-08-07','895f107c-991a-4173-8dba-f6a906e13cef','1','cd0c3f10-40b0-4c47-b2f7-a2043e5311b6',0,'09:55:28','20:58:04',NULL,1),('9a2a3d79-05e2-490a-b6eb-8088319de6e6','2016-08-28','895f107c-991a-4173-8dba-f6a906e13cef','1','cd0c3f10-40b0-4c47-b2f7-a2043e5311b6',0,'09:42:44','09:42:50',NULL,1),('a5bd286b-a1f9-4d72-8d6b-b2023384b185','2016-09-02','895f107c-991a-4173-8dba-f6a906e13cef','1','cd0c3f10-40b0-4c47-b2f7-a2043e5311b6',0,'20:58:11','21:16:12','85c90912-97ff-47ce-9d6a-7d1650ab3ea9',1),('c06dcbfd-6e19-4c3b-83ca-811c8c2fcd35','2016-08-28','895f107c-991a-4173-8dba-f6a906e13cef','1','cd0c3f10-40b0-4c47-b2f7-a2043e5311b6',0,'09:41:47','09:41:54',NULL,1),('f42390b0-0780-46cc-addd-2e735de6e17a','2016-08-28','895f107c-991a-4173-8dba-f6a906e13cef','1','cd0c3f10-40b0-4c47-b2f7-a2043e5311b6',50000,'09:43:30','09:46:52',NULL,1);
/*!40000 ALTER TABLE `cashier_shift` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `clinic_sales`
--

LOCK TABLES `clinic_sales` WRITE;
/*!40000 ALTER TABLE `clinic_sales` DISABLE KEYS */;
/*!40000 ALTER TABLE `clinic_sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `company_structure`
--

LOCK TABLES `company_structure` WRITE;
/*!40000 ALTER TABLE `company_structure` DISABLE KEYS */;
INSERT INTO `company_structure` VALUES ('576b2966-dd2a-408e-ae68-d62997586b1a','2009-08-07',NULL,'980d82f2-aa01-4511-b461-985f5fcbe6a1','HOLDING',NULL,0),('8eb71405-a5cb-4ef7-b88d-b36bec31ba3b','2009-08-07',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','BRANCH','a67f9da5-bbc2-4591-bfd9-934d77532b29',0),('a67f9da5-bbc2-4591-bfd9-934d77532b29','2009-08-07',NULL,'329f661e-3386-46f8-8d3a-5fa704b6f533','COMPANY','576b2966-dd2a-408e-ae68-d62997586b1a',0);
/*!40000 ALTER TABLE `company_structure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES ('0160e67e-cf07-41ad-9d33-460549d37209','081345048506','CELLPHONE','1','f6917d75-083e-4325-bc07-77af774f043b',0),('02f52854-f607-45f5-bbf4-0f96da014876','082255353626','CELLPHONE','1','a77bcca4-aee3-4cd3-96c0-b0e78ff13f73',0),('0a62e192-d2ff-4eba-b219-2a618767f948','02253517556','CELLPHONE','1','bc260302-c07d-47a6-ad55-bdda6b4b16e5',0),('0cebc4bd-ba08-4d56-9bca-fd5c8e84680e','08125754832','CELLPHONE','1','12529b23-3ec7-4912-a7ba-4a7dd0b14b64',0),('0e4a0ed9-fce7-4ed1-ba51-10fa38b4014e','085250196329','CELLPHONE','1','6c0fadd3-9867-4d3c-b9f5-502676b503a8',0),('0f17f981-25c9-43fa-80d4-b5fd81bad20f','085349933445','CELLPHONE','1','017973d0-bdbc-4b6a-9b1e-bff197ab71f0',0),('11cb9b39-5bda-43b1-8031-cec51f70e89f','089677412191','CELLPHONE','1','3878879a-2e22-4a97-9929-ff37e1c31431',0),('17692134-ea5a-4006-8914-4182bb04718f','085252344288','CELLPHONE','1','022b153f-c31b-4bbe-bcf3-90dfc5243579',0),('18924bed-cd1e-4a5e-bdd4-84e2979d4046','082157055101','CELLPHONE','1','e68fa2ab-75bf-48b8-ab52-55f89e7a4787',0),('199cffd9-dc37-4ea7-8e38-6f0619b93ec2','08215671000','CELLPHONE','1','41095616-583a-4e15-8563-e405bc26d0d3',0),('1a6ae0dd-ebdf-47fb-9ee7-f699935ed7ce','089637663784','CELLPHONE','1','633e7708-63c7-4f1f-8312-1d210e0dd065',0),('1aa2a5af-61ec-4e01-ab7b-b05a033bed18','081257053292','CELLPHONE','1','f8c59058-2728-4039-87d2-409b42b9dbc8',0),('1d3040f0-57f6-497d-9b74-105df1207f3e','081253567902','CELLPHONE','1','e196257a-b925-4413-8ede-d4a7bd9f2466',0),('1f47bb52-16d0-4fe9-a239-cbda6d8e24f7','081345005698','CELLPHONE','1','61105d59-ec88-4467-ac05-8334d9f66e50',0),('226a73e0-2ff8-4764-9b86-1b7df272b304','089627010303','CELLPHONE','1','f89abcfd-9762-4a07-8b49-ad4f844b3ca1',0),('2ca9ef30-f7b0-412f-8f0d-91e5b287e187','082251687195','CELLPHONE','1','9d91dc31-8244-41e6-9c4e-9a07bdef3122',0),('30b68afa-0a19-4e3b-beed-98f1c8d978fd','089683734643','CELLPHONE','1','2625e364-072a-416b-846e-90b6add43bef',0),('3206621e-6510-44a5-997f-f951277b71eb','082157841087','CELLPHONE','1','731838a3-08f5-4f01-9cc3-7b0985239d44',0),('36c7bc10-481d-48a2-b947-5c6d8587f909','085348273272','CELLPHONE','1','20266334-c727-405c-b710-f215473e4396',0),('3cc0f74b-e817-43f0-895c-f4e0ffd81323','089619499691','CELLPHONE','1','49a021f9-ef29-4e7b-88a6-bdd1ee2f4d70',0),('3d7c6adb-2320-4e67-bf43-d36681be9f65','08125718596','CELLPHONE','1','ffa7d45c-37c8-46cf-9a02-6973fa73ca3d',0),('3fb6202b-2a65-4bb7-98ee-60bfe4384ecd','085249950369','CELLPHONE','1','a3ad09a6-dac6-45b9-b678-750014a6cf73',0),('41770478-a587-4510-8514-3f108719fdcc','081242637701','CELLPHONE','1','63a56e3f-f59b-432f-9c9d-463f1f744334',0),('44b1060e-a830-4613-be58-b63b29d28b25','082158733187','CELLPHONE','1','923274db-d2a5-4a78-9962-86348c84e283',0),('45251970-18e2-49c9-851d-431a4b2285ac','082159534599','CELLPHONE','1','aa10f218-64f3-4c41-8a90-c5a578896e17',0),('4702e1fe-c654-4d22-98bd-5994dc4969de','089696062829','CELLPHONE','1','b5cbc987-4f00-4fd8-b6d3-5c8de2e4ed45',0),('4a9b9077-5c32-45af-8599-5c6537283dd5','085386060383','CELLPHONE','1','819d4ae9-36e9-47d5-b572-c7fb8c76f392',1),('4b17eeb8-80e8-4c07-aa01-a4484d5c6bae','082150478811','CELLPHONE','1','d67ddc3e-1c60-4aff-8120-66dccf9263cb',0),('4cb9c663-afbf-44f6-b11e-0adfa2196781','085342818721','CELLPHONE','1','4a842e24-386c-4380-a333-3337b7f9029b',0),('4dfef738-cf77-438d-a4c5-ea0506ea5fdf','089637663784','CELLPHONE','1','c407032a-4d0d-4b6d-94a3-ae891170e65c',0),('5afb294f-9d7b-4cb7-b2f7-3d8535567f5e','0561745426','CELLPHONE','1','348d0045-3db2-4e43-a632-ad70f82f86dd',0),('5b0a6503-ef53-42af-bfa6-b5b6506b0b38','08999687278','CELLPHONE','1','d67ddc3e-1c60-4aff-8120-66dccf9263cb',0),('61386936-1641-49b1-868d-5d8b16ca04e5','0895351187883','CELLPHONE','1','ffa7d45c-37c8-46cf-9a02-6973fa73ca3d',0),('63fa272d-45ff-4a1a-ad3d-d1095f2f1469','085387162669','CELLPHONE','1','8a820547-5d64-4589-bf73-837687170286',0),('643b9999-c264-47f3-ac05-ae9106817eed','082250510931','CELLPHONE','1','6ad80274-db6b-42e3-8013-6ad1e441fb81',0),('68325e1d-e16f-42cf-bfa6-81dc0ab203e4','085245812181','CELLPHONE','1','3459dd9e-7ec3-436f-9c39-db93a9c8f7c6',0),('6c1b862d-d09e-4ab3-8a2d-bcc490a2bd3d','085252101526','CELLPHONE','1','280c1c5f-5bfc-41c7-9162-805edadc6a7c',0),('6f2511cd-dca5-485b-89b8-49510276eae2','08125777144','CELLPHONE','1','924efe8c-512b-4f7b-9b59-23f0a0e87369',0),('709f3fc8-ce4c-46cb-885d-fad1cec144cc','081348475241','CELLPHONE','1','4a842e24-386c-4380-a333-3337b7f9029b',0),('70b7beb9-ae12-4969-9ba8-597bc1ba0450','085245258999','CELLPHONE','1','756755c3-1ddd-4086-b862-e7e9298b30cc',0),('70f1a4ed-e2f7-4104-8047-028cae3e81c8','081345070052','CELLPHONE','1','2f43245c-8573-42cc-9692-8e3236de2f97',0),('723fc9d0-e2d1-45f6-afea-e917db2cce07','085252096364','CELLPHONE','1','0ee45092-38fe-4270-a4c2-6657fa59298e',0),('752c8b08-f284-473d-b614-f2a39834c6df','05616589593','CELLPHONE','1','539fc7b2-a4a1-4b0e-a520-4bb2148b5405',0),('775ef94f-aca4-40c9-b899-e368747c0a9e','081345005698','CELLPHONE','1','1701ebcc-9dde-4e2f-9ac5-4cec4dd8d386',0),('77e3b3b4-4d23-4bfe-a157-d38c7c531fbf','08164991419','CELLPHONE','1','8e004f0b-e655-46c5-a38d-cc0217cca15a',0),('793dda09-220c-45ae-b94c-49a34e5ca884','085387654828','CELLPHONE','1','964a55cc-2dbb-48ea-b45a-62e4f244a796',0),('794c40f3-7b0e-4db8-a180-b18670286aab','085151489919','CELLPHONE','1','1ceb724e-4833-417f-b34c-8086eb670f7e',0),('79e71028-129d-4c05-833e-04a8e790aa78','08125604198','CELLPHONE','1','bc260302-c07d-47a6-ad55-bdda6b4b16e5',0),('7bae6703-59fb-44b8-95ce-e1ff788ef082','081352602821','CELLPHONE','1','633e7708-63c7-4f1f-8312-1d210e0dd065',0),('7c804a10-bfbb-4a8e-b3f5-04f2c282e77c','082151222686','CELLPHONE','1','77a9c861-faaa-4b4a-a7b2-2d7124be9ba3',0),('813dfcfa-2700-48d2-bf4b-dab0e2c1402e','085345353411','CELLPHONE','1','c0f065ac-a095-4a85-a28f-f116a9ba3e57',0),('82681dd9-c20b-482c-83b6-353fe11de6e5','08960711948','CELLPHONE','1','4221f198-19b2-416c-bf46-71163727a0ff',0),('835d0f1a-07b9-45f1-b37d-66627910ed72','082148484781','CELLPHONE','1','fe8c2142-a8a5-428b-b242-84d7f384c079',0),('838aded6-50ac-417d-bbd9-54ef12c7d8fd','081256337879','CELLPHONE','1','03039740-cb9e-49dc-a670-a600b41d21d1',0),('83a71f4f-d7de-4120-ba39-ee37c2d077db','089610400482','CELLPHONE','1','11bb1ed3-dcdd-4430-908e-3d7e84870a88',0),('857f4480-35d7-40fa-9730-49ec5e10a20b','0811560430','CELLPHONE','1','12529b23-3ec7-4912-a7ba-4a7dd0b14b64',0),('8737ba04-39be-46f7-8ff9-759e437a0d2e','081345249697','CELLPHONE','1','7aff71e4-ddaf-4f7b-aff6-6a95cff39ed2',0),('8bbaa325-e89b-48ab-a00c-c1974c41066a','081352121975','CELLPHONE','1','77a9c861-faaa-4b4a-a7b2-2d7124be9ba3',0),('8d29421b-dbda-409f-bf9b-c8326c32e686','0561745426','CELLPHONE','1','8e004f0b-e655-46c5-a38d-cc0217cca15a',0),('8d9ac8c9-7c55-4496-aae0-8f9eba85b6a0','081345070052','CELLPHONE','1','29454f3b-e557-4cd5-b95d-8cd189c3c331',0),('8e3c7749-c0a6-4bc9-84b6-ddcf442ca62b','085387875751','CELLPHONE','1','c407032a-4d0d-4b6d-94a3-ae891170e65c',0),('907475e4-8ec9-47d6-9b36-53dd8ad5eec0','082351039719','CELLPHONE','1','088f14ea-d0e6-4177-8998-cca133fae524',0),('92560488-c063-45f6-92a0-8d0a50557b05','081257560340','CELLPHONE','1','f4eded39-41dc-40b7-b249-84c7daf9713d',0),('94366d11-0060-42d2-aaba-a5fcab61b69f','08215777144','CELLPHONE','1','e26ce188-8644-46e6-b25f-e131cf46d678',0),('957f2a65-53d6-445e-879b-e16fa140d18d','085647447139','CELLPHONE','1','42901be4-86e0-4e24-be0f-0698dd7ae9bf',0),('973f62f5-de1d-40d5-bb3d-252dc341fe26','081345109042','CELLPHONE','1','8459900c-a178-43dd-b215-5e5c089475a2',0),('98172805-fbd9-404b-bca2-13fa4e79fd39','0561775197','CELLPHONE','1','731838a3-08f5-4f01-9cc3-7b0985239d44',0),('9938211f-8c71-49fd-974e-22b08df08b41','082152008535','CELLPHONE','1','539fc7b2-a4a1-4b0e-a520-4bb2148b5405',0),('9d566e1d-e673-458c-a9fb-13db1cfff16d','089691750775','CELLPHONE','1','0191c9f9-ed27-4967-93ed-add08b6f6f26',0),('9f1b1f17-39e3-49a0-b21a-94b65e2c9570','082255754114','CELLPHONE','1','2625e364-072a-416b-846e-90b6add43bef',0),('a0e8afb7-77a0-482a-a979-20af79db55f8','0812578215','CELLPHONE','1','a8280d8e-553c-4074-90b4-1f71b5c34e27',0),('a5495b73-886a-4d40-9ea5-3357671f9fd0','08125727332','CELLPHONE','1','4221f198-19b2-416c-bf46-71163727a0ff',0),('a7a03733-0a04-490e-b330-cbdbc127c7b1','081345558880','CELLPHONE','1','f89abcfd-9762-4a07-8b49-ad4f844b3ca1',0),('aae0b4a0-5cba-48f7-a6fa-6b81b46188da','08968805416','CELLPHONE','1','e9ecb5e5-ec98-40d3-9282-6b7949c99924',0),('ae0a86bb-065c-452f-972f-f8054ae782cd','089520537045','CELLPHONE','1','41095616-583a-4e15-8563-e405bc26d0d3',0),('b44c7c8d-fb91-458c-9326-9edb7ca12cfc','082158409095','CELLPHONE','1','65b78b03-601e-4570-bf18-14c7d44e1a18',0),('b4dd2942-2f97-4caa-9ca8-943134a5b9c2','085346604354','CELLPHONE','1','cb1e074f-7ba2-415e-8523-4c36b75e2101',0),('b5396256-abbb-4c06-a82d-b2bfeb52842b','089622599526','CELLPHONE','1','12529b23-3ec7-4912-a7ba-4a7dd0b14b64',0),('b76fa463-a784-4876-9c84-a19cd340a7eb','081250150649','CELLPHONE','1','63a56e3f-f59b-432f-9c9d-463f1f744334',0),('b8c6134f-0800-4979-9e20-20f51c35b94b','08125722896','CELLPHONE','1','924efe8c-512b-4f7b-9b59-23f0a0e87369',0),('baef50da-5399-4bb6-a8dd-b70c5a03ae81','08135227733','CELLPHONE','1','146508c4-cdd5-44e0-9d99-4f5041bf740f',0),('bb81716d-d6d0-443c-b277-15117d939258','082154584006','CELLPHONE','1','3878879a-2e22-4a97-9929-ff37e1c31431',0),('bd1ddb77-bc53-4391-ba0d-0a97bebd912c','081257536242','CELLPHONE','1','756755c3-1ddd-4086-b862-e7e9298b30cc',0),('be07abad-b641-4ab4-848c-fb95ad101896','085246661771','CELLPHONE','1','8a820547-5d64-4589-bf73-837687170286',0),('bf275ee9-9ab9-4239-a3db-f9ff088c6382','081257053292','CELLPHONE','1','b7afc825-ce01-493b-b59a-071b5645b682',0),('bf3851d4-99a5-4fad-98a4-5c5351bdc7fa','(0561)585830','CELLPHONE','1','022b153f-c31b-4bbe-bcf3-90dfc5243579',0),('bf8ba7de-f1f9-41ad-a3ee-2ec21c6b8db8','081345294050','CELLPHONE','1','6ad80274-db6b-42e3-8013-6ad1e441fb81',0),('c21a36a7-51ff-4f23-b20e-53ed68d667e0','088245225062','CELLPHONE','1','ce59473f-8bd8-4c7c-a118-6228a2b301a1',0),('c2b1ef74-3eee-4adc-b43f-23e91dfe4a8b','08125460807','CELLPHONE','1','36f481b9-37e7-4c28-99e5-369f45200634',0),('c3fecf26-0d9d-4282-bed2-59514f937383','08125722896','CELLPHONE','1','e26ce188-8644-46e6-b25f-e131cf46d678',0),('c466ead7-73c6-4292-a1f1-b64565eec826','085251790775','CELLPHONE','1','4dc0134d-711c-468e-af68-6faa3aa9ea1e',0),('c567725b-3c0c-48bd-b16c-5b19511bde8a','08164991419','CELLPHONE','1','348d0045-3db2-4e43-a632-ad70f82f86dd',0),('c57c1470-2f8b-4af1-a84c-45064b7da9e0','089614814098','CELLPHONE','1','03039740-cb9e-49dc-a670-a600b41d21d1',0),('caecd0de-1ae8-459d-9c44-7165ac4ed43b','08981123271','CELLPHONE','1','cb1e074f-7ba2-415e-8523-4c36b75e2101',0),('cf12dc2e-d31b-421a-8e39-1d0a99c74d79','089688869516','CELLPHONE','1','20266334-c727-405c-b710-f215473e4396',0),('d229a631-ac15-40cc-af80-e55764b466ca','089670106075','CELLPHONE','1','7aff71e4-ddaf-4f7b-aff6-6a95cff39ed2',0),('d535a0aa-af97-4bef-8b86-5e5e4e80d269','089666300946','CELLPHONE','1','280c1c5f-5bfc-41c7-9162-805edadc6a7c',0),('d67575ac-7da6-46be-b40c-bb67dfe0530a','081345573220','CELLPHONE','1','1eac9139-6b4f-40ff-aafb-a1be57705592',0),('d94bf8f9-804d-48f7-956e-5c821a9971b6','089505169446','CELLPHONE','1','763a852d-5742-4be1-8905-714bcecebefd',0),('dc886bea-c653-44ae-bd2d-6e511578afb1','081345471234','CELLPHONE','1','44a75f39-d018-4644-b028-cd2328ac7ef8',0),('e2af15aa-96a9-4886-b55e-8ec4e68631ca','08115702351','CELLPHONE','1','9d91dc31-8244-41e6-9c4e-9a07bdef3122',0),('e3677fe8-21ce-4cb5-b1ad-2be733adce3f','085387924066','CELLPHONE','1','20677939-457c-4ac0-bf48-d93a5a02938a',0),('e7566caf-fde5-4804-98f9-23b29bd47193','08986837143','CELLPHONE','1','44a75f39-d018-4644-b028-cd2328ac7ef8',0),('e84c3778-d986-4a35-be79-03515aa3302e','081352529578','CELLPHONE','1','11bb1ed3-dcdd-4430-908e-3d7e84870a88',0),('eab5b8d1-754e-4712-a7a5-0d076ba0f4c9','(0561)774169','HOMEPHONE','1','e68fa2ab-75bf-48b8-ab52-55f89e7a4787',0),('eb2a781b-bf17-4a8c-86cf-e7f85bb2995a','085245389855','CELLPHONE','1','964a55cc-2dbb-48ea-b45a-62e4f244a796',0),('f11d5c98-9ceb-45c5-a47c-0e9b5a8a034f','08978120339','CELLPHONE','1','923274db-d2a5-4a78-9962-86348c84e283',0),('f40eaf42-e796-441c-92d5-0597c0ba99b8','08970054066','CELLPHONE','1','c76091c1-4d94-447e-96f8-476bfee31604',0),('f4768962-2cb9-4b94-9ffa-ea507c6a3b66','082354076152','CELLPHONE','1','d73b0190-ec65-4e75-8b15-aaebbfb4dc97',0),('f47a95a8-96d5-4180-bb21-d8ae3b7b3afc','081231347807','CELLPHONE','1','36f481b9-37e7-4c28-99e5-369f45200634',0),('f7c97dec-336b-421d-a5ae-aa4af272077f','089616350931','CELLPHONE','1','c76091c1-4d94-447e-96f8-476bfee31604',0),('f8054c99-c5c2-4f4a-8ee0-8fc51000fd4c','085245841138','CELLPHONE','1','e9ecb5e5-ec98-40d3-9282-6b7949c99924',0),('f8fb3723-70e8-4a09-a804-0e1d77193504','08989809855','CELLPHONE','1','731838a3-08f5-4f01-9cc3-7b0985239d44',0),('fb1e672f-5999-4f61-99f9-a0aec8db7ebf','(0561)775612','HOMEPHONE','1','017973d0-bdbc-4b6a-9b1e-bff197ab71f0',0),('fb58e5b4-ab61-429a-965c-9e22d38a5f04','0561760108','HOMEPHONE','1','bc260302-c07d-47a6-ad55-bdda6b4b16e5',0),('fba51cf3-9376-4a16-a2c4-e675dc521e16','089683417325','CELLPHONE','1','6c0fadd3-9867-4d3c-b9f5-502676b503a8',0),('ff204485-ad0b-4648-8114-16f30ee55117','081254150707','CELLPHONE','1','763a852d-5742-4be1-8905-714bcecebefd',0);
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `course_attendance`
--

LOCK TABLES `course_attendance` WRITE;
/*!40000 ALTER TABLE `course_attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `course_attendance_item`
--

LOCK TABLES `course_attendance_item` WRITE;
/*!40000 ALTER TABLE `course_attendance_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_attendance_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `course_discount`
--

LOCK TABLES `course_discount` WRITE;
/*!40000 ALTER TABLE `course_discount` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `course_installment`
--

LOCK TABLES `course_installment` WRITE;
/*!40000 ALTER TABLE `course_installment` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_installment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `course_installment_item`
--

LOCK TABLES `course_installment_item` WRITE;
/*!40000 ALTER TABLE `course_installment_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_installment_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `course_item`
--

LOCK TABLES `course_item` WRITE;
/*!40000 ALTER TABLE `course_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `course_registration`
--

LOCK TABLES `course_registration` WRITE;
/*!40000 ALTER TABLE `course_registration` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `course_schedule`
--

LOCK TABLES `course_schedule` WRITE;
/*!40000 ALTER TABLE `course_schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_schedule` ENABLE KEYS */;
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
-- Dumping data for table `deduction`
--

LOCK TABLES `deduction` WRITE;
/*!40000 ALTER TABLE `deduction` DISABLE KEYS */;
/*!40000 ALTER TABLE `deduction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `deduction_type`
--

LOCK TABLES `deduction_type` WRITE;
/*!40000 ALTER TABLE `deduction_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `deduction_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `disbursement`
--

LOCK TABLES `disbursement` WRITE;
/*!40000 ALTER TABLE `disbursement` DISABLE KEYS */;
/*!40000 ALTER TABLE `disbursement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
INSERT INTO `discount` VALUES ('1beca9e8-7df2-44ac-b266-c1a0b58654ea','2016-01-01',NULL,'RANGKING 1-5',150000,'0',1),('39fc9fc5-d65e-4d0c-a243-4f90a7f68387','2016-01-01',NULL,'RANGKING 6-10',100000,'0',1),('568ba4cb-6367-4dd1-8b3d-2008f57f4008','2016-01-01',NULL,'KAKAK-ADIK',50000,'0',1),('962550e6-a193-4ebd-8944-27a2e4913d88','2016-01-01',NULL,'CASH',300000,'0',1),('997e05f9-0a1d-413c-bc9a-8d2589f6a102','2016-01-01',NULL,'ANAK GURU',100000,'0',1),('d3bf7373-9700-4a36-beb4-87cae75e4f52','2016-01-01',NULL,'MANTAN SISWA',25,'1',1);
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `doctor_appointment`
--

LOCK TABLES `doctor_appointment` WRITE;
/*!40000 ALTER TABLE `doctor_appointment` DISABLE KEYS */;
/*!40000 ALTER TABLE `doctor_appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `doctor_relationship`
--

LOCK TABLES `doctor_relationship` WRITE;
/*!40000 ALTER TABLE `doctor_relationship` DISABLE KEYS */;
/*!40000 ALTER TABLE `doctor_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `doctor_type`
--

LOCK TABLES `doctor_type` WRITE;
/*!40000 ALTER TABLE `doctor_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `doctor_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('b8ae098a-a7bd-4977-b595-53ed28fae483','9173455f-4082-4e84-9188-e1d4c9038a28');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employment`
--

LOCK TABLES `employment` WRITE;
/*!40000 ALTER TABLE `employment` DISABLE KEYS */;
INSERT INTO `employment` VALUES ('74cbd93a-dfb2-45ca-a3fd-8ed5ee6f8cf1','b8ae098a-a7bd-4977-b595-53ed28fae483','742fc487-8b9d-41d8-9a0c-b55772bc2c49');
/*!40000 ALTER TABLE `employment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employment_application`
--

LOCK TABLES `employment_application` WRITE;
/*!40000 ALTER TABLE `employment_application` DISABLE KEYS */;
/*!40000 ALTER TABLE `employment_application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `erp_mode`
--

LOCK TABLES `erp_mode` WRITE;
/*!40000 ALTER TABLE `erp_mode` DISABLE KEYS */;
INSERT INTO `erp_mode` VALUES ('00000','EDUCATION',1);
/*!40000 ALTER TABLE `erp_mode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `facility`
--

LOCK TABLES `facility` WRITE;
/*!40000 ALTER TABLE `facility` DISABLE KEYS */;
/*!40000 ALTER TABLE `facility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `facility_organization`
--

LOCK TABLES `facility_organization` WRITE;
/*!40000 ALTER TABLE `facility_organization` DISABLE KEYS */;
/*!40000 ALTER TABLE `facility_organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `family_folder`
--

LOCK TABLES `family_folder` WRITE;
/*!40000 ALTER TABLE `family_folder` DISABLE KEYS */;
/*!40000 ALTER TABLE `family_folder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `family_member`
--

LOCK TABLES `family_member` WRITE;
/*!40000 ALTER TABLE `family_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `family_member` ENABLE KEYS */;
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
-- Dumping data for table `gl_account`
--

LOCK TABLES `gl_account` WRITE;
/*!40000 ALTER TABLE `gl_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `gl_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `gl_account_balance`
--

LOCK TABLES `gl_account_balance` WRITE;
/*!40000 ALTER TABLE `gl_account_balance` DISABLE KEYS */;
/*!40000 ALTER TABLE `gl_account_balance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `goods_issue`
--

LOCK TABLES `goods_issue` WRITE;
/*!40000 ALTER TABLE `goods_issue` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods_issue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `goods_issue_item`
--

LOCK TABLES `goods_issue_item` WRITE;
/*!40000 ALTER TABLE `goods_issue_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods_issue_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `goods_receive`
--

LOCK TABLES `goods_receive` WRITE;
/*!40000 ALTER TABLE `goods_receive` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods_receive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `goods_receive_item`
--

LOCK TABLES `goods_receive_item` WRITE;
/*!40000 ALTER TABLE `goods_receive_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods_receive_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `goods_transfer`
--

LOCK TABLES `goods_transfer` WRITE;
/*!40000 ALTER TABLE `goods_transfer` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods_transfer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `goods_transfer_item`
--

LOCK TABLES `goods_transfer_item` WRITE;
/*!40000 ALTER TABLE `goods_transfer_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods_transfer_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `inbox`
--

LOCK TABLES `inbox` WRITE;
/*!40000 ALTER TABLE `inbox` DISABLE KEYS */;
/*!40000 ALTER TABLE `inbox` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `internal_organization`
--

LOCK TABLES `internal_organization` WRITE;
/*!40000 ALTER TABLE `internal_organization` DISABLE KEYS */;
INSERT INTO `internal_organization` VALUES ('742fc487-8b9d-41d8-9a0c-b55772bc2c49');
/*!40000 ALTER TABLE `internal_organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `inventory_item`
--

LOCK TABLES `inventory_item` WRITE;
/*!40000 ALTER TABLE `inventory_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventory_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `journal_entry`
--

LOCK TABLES `journal_entry` WRITE;
/*!40000 ALTER TABLE `journal_entry` DISABLE KEYS */;
/*!40000 ALTER TABLE `journal_entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `journal_entry_detail`
--

LOCK TABLES `journal_entry_detail` WRITE;
/*!40000 ALTER TABLE `journal_entry_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `journal_entry_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `journal_posting`
--

LOCK TABLES `journal_posting` WRITE;
/*!40000 ALTER TABLE `journal_posting` DISABLE KEYS */;
/*!40000 ALTER TABLE `journal_posting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `journal_setting`
--

LOCK TABLES `journal_setting` WRITE;
/*!40000 ALTER TABLE `journal_setting` DISABLE KEYS */;
/*!40000 ALTER TABLE `journal_setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `laboratory`
--

LOCK TABLES `laboratory` WRITE;
/*!40000 ALTER TABLE `laboratory` DISABLE KEYS */;
/*!40000 ALTER TABLE `laboratory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `laboratory_item`
--

LOCK TABLES `laboratory_item` WRITE;
/*!40000 ALTER TABLE `laboratory_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `laboratory_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `laboratory_sales`
--

LOCK TABLES `laboratory_sales` WRITE;
/*!40000 ALTER TABLE `laboratory_sales` DISABLE KEYS */;
/*!40000 ALTER TABLE `laboratory_sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `medical_record`
--

LOCK TABLES `medical_record` WRITE;
/*!40000 ALTER TABLE `medical_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `medical_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `medical_sales`
--

LOCK TABLES `medical_sales` WRITE;
/*!40000 ALTER TABLE `medical_sales` DISABLE KEYS */;
/*!40000 ALTER TABLE `medical_sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `medical_treatment_sales`
--

LOCK TABLES `medical_treatment_sales` WRITE;
/*!40000 ALTER TABLE `medical_treatment_sales` DISABLE KEYS */;
/*!40000 ALTER TABLE `medical_treatment_sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `medication`
--

LOCK TABLES `medication` WRITE;
/*!40000 ALTER TABLE `medication` DISABLE KEYS */;
/*!40000 ALTER TABLE `medication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `medication_item`
--

LOCK TABLES `medication_item` WRITE;
/*!40000 ALTER TABLE `medication_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `medication_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `message_receiver`
--

LOCK TABLES `message_receiver` WRITE;
/*!40000 ALTER TABLE `message_receiver` DISABLE KEYS */;
/*!40000 ALTER TABLE `message_receiver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `module`
--

LOCK TABLES `module` WRITE;
/*!40000 ALTER TABLE `module` DISABLE KEYS */;
INSERT INTO `module` VALUES ('07452775-a048-4071-8798-21dc943fe926','PRODUCT','Product','','INVENTORY','0',0),('0b503053-31eb-410d-90a6-ec6a9977bc1e','FAMILY_FOLDER','Family Folder','','CLINIC','0',0),('0c586cf4-9bd2-4b93-b24b-d41ceca2aef4','CLINIC_SALES','Clinic Sales','','CLINIC','0',0),('13989b38-ac2c-47b8-8708-5e27477af18d','BENEFIT_TYPE','Benefit Type','','HR','0',0),('1adc4b8b-ad93-4658-8476-6bb13e2e810d','PURCHASE_ORDER_REQUEST','Purchase Order Request','','PROCUREMENT','0',0),('1cf392fc-4f93-4e38-9709-2beb84434951','DOCTORTYPE','Doctor Type','','CLINIC','0',0),('29ec80f0-0d4c-451c-ae5e-f195c4be1a27','COMPANY_STRUCTURE','Company Structure','','GENERAL','0',0),('2bdc3f95-c5bd-47d9-adce-9e9df1042e2f','BUDGET_APPROVER','Budget Approver','','ACCOUNTING','0',0),('2c0d9a06-cebd-4da2-b520-2e948aae3e53','INVOICE_REPORT','Invoice Report','','FINANCIAL','0',0),('2d7e5641-511d-43fd-a6d6-a482120f8aa5','BUDGET','Budget','','ACCOUNTING','0',0),('314a3f13-a982-4915-a5cb-455eacbc27ae','INBOX','Inbox Message','','SYSTEM','0',0),('322d37f6-a667-481e-bc22-db212d0154ea','EMPYAPP','Employment Application','','HR','0',0),('339d7200-9aa1-43d5-8683-e7118cb52839','STUDENT','Student','','EDUCATION','0',0),('342b0b64-291f-4d12-bdb8-77186895d21d','SALES_REPORT','Sales Report','','SALES','0',0),('355ca995-6bae-4638-bfd4-a9bfeff5eefb','INVOICE_OVERDUE_REPORT','Invoice Over Due Report','','FINANCIAL','0',0),('4500a912-bbad-4590-9abb-d9ec92a311a5','DISCOUNT','Discount Programm','Discount','PAYMENT','0',1),('4939e42f-06b5-4e44-b3ba-4106964f1f68','ACCOUNTINGPERIOD','Accounting Period','','ACCOUNTING','0',0),('4b3bb551-173e-46f5-b1e9-bdd719e3045e','COA','General Chart of Account','','ACCOUNTING','0',0),('4bf39427-b32a-434c-bd71-4d9493ea6eef','STOCK_OPNAME','Stock Opname','','INVENTORY','0',0),('4eb93eb7-2100-49ae-bd96-a39995ed5670','USER','User','Application User Module','SECURITY','1',0),('4eca5501-a650-41d5-87c1-c091391d3608','CASHSALES','Cash Sales','','SALES','0',0),('532efe0a-05ff-4f94-877d-a7f3f7509569','WORKING_TIMESHEET','Working Timesheet','','PRODUCTION','0',0),('55b7e0fb-a178-478b-a09e-4b753f161aeb','MEDICATION','Medication','','CLINIC','0',0),('58621810-2c8f-44ae-b9aa-b1e05ad32743','SUPPLIER','Supplier','','PROCUREMENT','0',0),('5c37296e-ab30-4d07-bba3-342d4c403f48','INVITEM','Inventory Item','','INVENTORY','0',0),('5cdd1545-8fdb-4a79-b2a3-0662ed6fec30','POSITIONTYPERATE','Position Type Rate','','HR','0',0),('5e8c4a66-e46a-4000-ae1c-bf536686b30f','TRN_ORDER_REQ','Transfer Order Request','','INVENTORY','0',0),('5eda5016-f448-42dd-926b-52b10870e29c','STUDY_TIME','Study Time','','EDUCATION','0',0),('627fb961-6cf0-4148-9451-0d1422095eb7','PURCHASE_ORDER_APPROVER','Purchase Order Request Approver','','PROCUREMENT','0',0),('65414caf-3a73-4e3f-9a58-2d70c723b5bc','CURRENCY','Currency','GENERAL','ACCOUNTING','0',1),('6861d3b3-8110-46ed-8a3a-830963597fa7','TAX','Tax','','ACCOUNTING','0',0),('69443009-4a15-4061-b9f0-08c08c8f50aa','JOURNALENTRY','Journal Entry','','ACCOUNTING','0',0),('6cbaf072-6925-46e9-b417-17326f3d8584','EMPLOYMENT','Employment','','HR','0',0),('6e299ade-e10e-4940-ae83-bdf61505ed63','STUDENT_REGISTRATION','Student Registration','','EDUCATION','0',0),('74ad4867-9495-472f-97fc-36bf87895585','COURSE_ATTENDANCE','Course Attendance','EDUCATION','EDUCATION','0',1),('770c420c-f809-43f7-969c-b493f0b4ef48','CASHIER','Cashier','','SALES','0',0),('7bef1d92-0f15-43ef-b59b-5bc3e769d896','UOM','Unit of Measure','','INVENTORY','0',0),('7f17176c-f27a-432c-a106-0d7d87b0afb7','RECEIPT','Receipt','','PAYMENT','0',0),('80aebe74-399c-4273-9145-956a077d3f5d','ACCESS_ROLE','Role','Application Access Role','SECURITY','1',0),('8217c196-16b9-44fb-9662-8323220ee705','ASSET','Asset Management','','ASSET','0',0),('83b19678-9f2f-49f4-ba25-0f31a8dee078','PHARMACY_ORDER','Pharmacy Order','','PHARMACY','0',0),('847a8df6-bc04-4de6-8d7d-28e41c00f422','DOCTOR_APPOINTMENT','Doctor Appointment','','CLINIC','0',0),('855aab16-cb45-41c3-b62c-55185ff77dfc','PHARMACY_SALES','Pharmacy Sales','','PHARMACY','0',0),('88bf4008-c84a-4089-88c6-e9d8f077a196','JOURNALSETTING','Journal Setting','','ACCOUNTING','0',0),('8a05b279-2f80-47b8-a2a7-63fbe96d327e','AUDIT_TRAIL','Audit Trail','','SYSTEM','0',0),('8c7e1020-0824-4239-9a4e-46301c80b9cd','PAYMENT_METHOD_TYPE','Payment Method Type','','PAYMENT','0',0),('8f6ec9c8-e9ed-49e1-ab7a-c4a868b8391e','ORGANIZATIONACCOUNT','Organization Account','','ACCOUNTING','0',0),('90195ecb-4674-4614-a429-eebc24ffe773','POSITIONTYPE','Position Type','','HR','0',0),('916b22eb-48fa-4000-b7a2-7fc1d47ced4e','STOCK_ADJUSTMENT','Stock Adjustment','','INVENTORY','0',0),('9178e8cd-4063-4fe9-a060-d2e3ac818ed1','PAYCHECK','Paycheck','','PAYMENT','0',0),('95dd39dd-512e-414e-b95c-0fc251887f98','PRDCATEGORY','Product Category','','INVENTORY','0',0),('99623cbd-066f-4cc2-b9b3-1961bed131cc','GOODS_TRANSFER','Goods Transfer','','INVENTORY','0',0),('9b9deb26-0960-478c-8cac-4ac475c3ffc3','COURSE_REGISTRATION','Course Registration','','EDUCATION','0',0),('9b9e014c-7a23-40c1-8841-30044564bf7f','MODULE','Module','Application Module','SECURITY','1',0),('9b9e014c-7a23-40c1-8841-30044564bf7x','SYSTEM','System Access','System Access','SYSTEM','1',0),('9df71b1a-0e52-4445-98ea-b9a59ad81ac9','PATIENT','Patient','','CLINIC','0',0),('9e644628-121d-4954-8a66-8002cc866bda','STOCK_ADMIN','Stock Admin','','INVENTORY','0',0),('a4aa9ae0-5166-4d06-afd1-d2eea6f2417c','PERSON','Person Management','','GENERAL','0',0),('a4c43802-436f-407c-8793-323600c181d7','GOODS_RECEIVE','Goods Receive','','INVENTORY','0',0),('abfd9a02-3b4b-47a0-9048-a65b6be0b3aa','PRODUCT_RETUR','Product Retur','','INVENTORY','0',0),('affcf2e7-fd2c-4b39-beee-97b5dc5a1405','STUDY_PERIOD','Study Period','','EDUCATION','0',0),('b44420c6-261b-44c5-a23a-7802a0506dab','RECURRING_PAYMENT','Recurring Payment','','PAYMENT','0',0),('b54c8e49-c820-4292-9f74-9e47bd55711f','CASH_PURCHASE_ORDER','Cash Purchase Order','','PROCUREMENT','0',0),('b662de02-f4a3-4f1a-819b-5d2aaf6a342b','GOODS_ISSUE','Goods Issue','','INVENTORY','0',0),('b9935030-f5c1-479e-9ec1-795afc1c1e7e','FACILITY','Facility','','INVENTORY','0',0),('c0f3237c-23c2-49ab-bc9c-e00aa706d7e2','PROFIT_LOSS','Profit Loss Report','','FINANCIAL','0',0),('c79e78d0-3427-440c-b8fe-df126e667a8b','INVOICE_DUEDATE_REPORT','Invoice Due Date Report','','FINANCIAL','0',0),('d33784ca-abd5-422b-b45a-8c8ee13ddc0a','DEDUCTION_TYPE','Deduction Type','','PAYMENT','0',0),('dbc9175e-eb27-45e9-9e43-a1c12d6354e4','DOCTOR','Doctor','','CLINIC','0',0),('e4307d82-f3fa-4916-9e6b-7a4f894d847e','ORGANIZATION','Organization','','GENERAL','0',0),('e4d249e1-4bd5-4291-9050-62a99f70f64c','CLINIC_REPORT','Clinic Reports','','CLINIC','0',0),('e54e6ba5-7ffd-457b-a23e-8b6285867ba4','STUDY_ROOM','Study Room','','EDUCATION','0',0),('e8f89299-2138-4167-b5b7-52f6ae1667ca','POSITION','Position','','HR','0',0),('e916392a-0b3c-4543-ada7-93054383bb3b','MESSAGE','Message','','SYSTEM','0',0),('ee3c3540-9c62-46df-a79e-f7b636a9ba1d','STUDY_DAY','Study Day','EDUCATION','EDUCATION','0',1),('f50dd16d-0e25-44b6-bd69-c28dfcc55300','GEOGRAPHIC','Geographic','','GENERAL','0',0),('f53b80db-1b89-4779-86e7-b065b5287bbb','ASSET_TYPE','Asset Type','','ASSET','0',0),('fab64cd8-7762-412b-90fb-3d31d5576b45','COURSE_SCHEDULE','Course Schedule','','EDUCATION','0',0),('fca1cfcf-d199-4729-a321-e1ed01deb0f1','LABS_REGISTRATION','Laboratory Registration','','MEDICALLAB','0',0);
/*!40000 ALTER TABLE `module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `order_payment`
--

LOCK TABLES `order_payment` WRITE;
/*!40000 ALTER TABLE `order_payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `organization`
--

LOCK TABLES `organization` WRITE;
/*!40000 ALTER TABLE `organization` DISABLE KEYS */;
INSERT INTO `organization` VALUES ('329f661e-3386-46f8-8d3a-5fa704b6f533','EDUCATION'),('980d82f2-aa01-4511-b461-985f5fcbe6a1','EDUCATION'),('e29c7687-30f8-4201-af68-0a4a67541b86','EDUCATION');
/*!40000 ALTER TABLE `organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `organization_account`
--

LOCK TABLES `organization_account` WRITE;
/*!40000 ALTER TABLE `organization_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `organization_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `organization_gl_account`
--

LOCK TABLES `organization_gl_account` WRITE;
/*!40000 ALTER TABLE `organization_gl_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `organization_gl_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `organization_period`
--

LOCK TABLES `organization_period` WRITE;
/*!40000 ALTER TABLE `organization_period` DISABLE KEYS */;
/*!40000 ALTER TABLE `organization_period` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `party`
--

LOCK TABLES `party` WRITE;
/*!40000 ALTER TABLE `party` DISABLE KEYS */;
INSERT INTO `party` VALUES ('017973d0-bdbc-4b6a-9b1e-bff197ab71f0','SDN2016080023','Muhammad Iqbal Putra',NULL,'2016-11-19','','1',1),('0191c9f9-ed27-4967-93ed-add08b6f6f26','SDN2016080080','Hadi Prayoga',NULL,'1999-10-12','','1',1),('022b153f-c31b-4bbe-bcf3-90dfc5243579','SDN2016080019','M. Fadil Hawari',NULL,'2004-11-16','','1',1),('03039740-cb9e-49dc-a670-a600b41d21d1','SDN2016080015','Fitriyani Fauziah',NULL,'2000-01-09','','1',1),('088f14ea-d0e6-4177-8998-cca133fae524','SDN2016080022','Uray Achmad Januardi',NULL,'2016-02-22','','1',1),('0ee45092-38fe-4270-a4c2-6657fa59298e','SDN2016080070','Raihan Osri',NULL,'2002-10-19','','1',1),('11bb1ed3-dcdd-4430-908e-3d7e84870a88','SDN2016080045','Meisya Nurfajri',NULL,'2016-05-06','','1',1),('12529b23-3ec7-4912-a7ba-4a7dd0b14b64','SDN2016080060','M. Iqbal Fahlefy',NULL,'1999-07-31','','1',1),('146508c4-cdd5-44e0-9d99-4f5041bf740f','SDN2016080058','Aqilla Putri Rahmadania',NULL,'2006-09-29','','1',1),('1701ebcc-9dde-4e2f-9ac5-4cec4dd8d386','SDN2016080066','Raihan Al Farizy',NULL,'2002-01-05','','1',1),('1ceb724e-4833-417f-b34c-8086eb670f7e','SDN2016080056','Yasa Khalqiah',NULL,'2000-03-17','','1',1),('1eac9139-6b4f-40ff-aafb-a1be57705592','SDN2016080059','Tifani Barita Pratiwi',NULL,'2000-07-28','','1',1),('20266334-c727-405c-b710-f215473e4396','SDN2016080049','Ferianty Riska Endayanti',NULL,'1999-02-16','','1',1),('20677939-457c-4ac0-bf48-d93a5a02938a','SDN2016080027','Nadhia Rizky Aulia',NULL,'2005-07-10','','1',1),('2625e364-072a-416b-846e-90b6add43bef','SDN2016080035','Naufal Tricahya Putra',NULL,'2000-09-21','','1',1),('280c1c5f-5bfc-41c7-9162-805edadc6a7c','SDN2016080076','Ayu Baitin Ningrum',NULL,'2000-10-26','','1',1),('29454f3b-e557-4cd5-b95d-8cd189c3c331','SDN2016080052','Edwin Satrio Pratama',NULL,'1999-03-17','','1',1),('2f43245c-8573-42cc-9692-8e3236de2f97','SDN2016080053','Ropi Darmawan',NULL,'2002-09-16','','1',1),('329f661e-3386-46f8-8d3a-5fa704b6f533','00001','SONY SUGEMA COLLEGE',NULL,'2009-08-07','','1',0),('3459dd9e-7ec3-436f-9c39-db93a9c8f7c6','SDN2016080068','Maulidia Adinda Putri',NULL,'2004-05-12','','1',1),('348d0045-3db2-4e43-a632-ad70f82f86dd','SDN2016080032','Mufrih Nur Huda Tri Putra',NULL,'2002-10-31','','1',1),('36f481b9-37e7-4c28-99e5-369f45200634','SDN2016080061','Dicha Niswansuah Auliyah',NULL,'1999-04-15','','1',1),('3878879a-2e22-4a97-9929-ff37e1c31431','SDN2016080029','M. Yudhitya Eka Pratama',NULL,'1999-06-26','','1',1),('41095616-583a-4e15-8563-e405bc26d0d3','SDN2016080075','Nur Afifah Aulia Pangestu',NULL,'2001-02-07','','1',1),('4221f198-19b2-416c-bf46-71163727a0ff','SDN2016080077','Nuraini Rizka Septiyana',NULL,'2002-09-03','','1',1),('42901be4-86e0-4e24-be0f-0698dd7ae9bf','SDN2016080079','Harry Kalimulya',NULL,'2016-07-24','','1',1),('44a75f39-d018-4644-b028-cd2328ac7ef8','SDN2016080055','Alya Asyura',NULL,'2002-04-04','','1',1),('49a021f9-ef29-4e7b-88a6-bdd1ee2f4d70','SDN2016080030','Annisa Shafa Azzuhra P',NULL,'2002-03-28','','1',1),('4a842e24-386c-4380-a333-3337b7f9029b','SDN2016080073','Sondang Tiur Hertiana',NULL,'2002-01-10','','1',1),('4dc0134d-711c-468e-af68-6faa3aa9ea1e','SDN2016080018','Adhesty',NULL,'2003-09-09','','1',1),('539fc7b2-a4a1-4b0e-a520-4bb2148b5405','SDN2016080074','Dhavina Dheviarni Aulia',NULL,'2002-09-14','','1',1),('61105d59-ec88-4467-ac05-8334d9f66e50','SDN2016080065','Fakhri Al Fathir',NULL,'2004-08-19','','1',1),('633e7708-63c7-4f1f-8312-1d210e0dd065','SDN2016080063','Cyril Ahmad Khatir Syarqi',NULL,'2003-12-17','','1',1),('63a56e3f-f59b-432f-9c9d-463f1f744334','SDN2016080078','Rifky Nugraha Utama',NULL,'2000-07-03','','1',1),('65b78b03-601e-4570-bf18-14c7d44e1a18','SDN2016080013','Argha Nugroho',NULL,'1999-09-22','','1',1),('6ad80274-db6b-42e3-8013-6ad1e441fb81','SDN2016080040','Jihan Fazila',NULL,'1999-05-17','','1',1),('6c0fadd3-9867-4d3c-b9f5-502676b503a8','SDN2016080024','Aditya Karunia Hardy',NULL,'2001-08-18','','1',1),('731838a3-08f5-4f01-9cc3-7b0985239d44','SDN2016080043','Nur Rakhmi',NULL,'2000-01-16','','1',1),('756755c3-1ddd-4086-b862-e7e9298b30cc','SDN2016080020','Risma Aryani',NULL,'2005-05-12','','1',2),('763a852d-5742-4be1-8905-714bcecebefd','SDN2016080069','Aura Faradillah',NULL,'2002-08-02','','1',1),('77a9c861-faaa-4b4a-a7b2-2d7124be9ba3','SDN2016080009','Rizka Dhafina Putri',NULL,'2005-04-22','','1',3),('78171b13-766f-495b-939d-e01b79e21931','00001','SYSADMIN',NULL,'1981-07-25','','0',0),('7aff71e4-ddaf-4f7b-aff6-6a95cff39ed2','SDN2016080054','Nurhana Alawiyah',NULL,'2002-04-12','','1',1),('819d4ae9-36e9-47d5-b572-c7fb8c76f392','SDN2016080033','Dyah Anggraeni',NULL,'2000-09-28','','1',1),('8459900c-a178-43dd-b215-5e5c089475a2','SDN2016080014','M. Rifki. S',NULL,'2016-01-01','','1',1),('895f107c-991a-4173-8dba-f6a906e13cef','6171022008900008','DODI',NULL,'1990-08-20','','1',0),('8a820547-5d64-4589-bf73-837687170286','SDN2016080044','Yudha Prabaskara',NULL,'2004-09-10','','1',1),('8e004f0b-e655-46c5-a38d-cc0217cca15a','SDN2016080031','Mufid Hayyu Nurfahmi Arif',NULL,'2004-08-31','','1',1),('923274db-d2a5-4a78-9962-86348c84e283','SDN2016080072','Muhammad Farhan Pratama',NULL,'2004-03-06','','1',1),('924efe8c-512b-4f7b-9b59-23f0a0e87369','SDN2016080051','Ihsaan Rizgullah Lubis',NULL,'2006-08-30','','1',1),('964a55cc-2dbb-48ea-b45a-62e4f244a796','SDN2016080047','Achlaq Al Arif',NULL,'2000-12-29','','1',1),('980d82f2-aa01-4511-b461-985f5fcbe6a1','00000','Harry Corporation',NULL,'2009-08-07','','1',0),('9d91dc31-8244-41e6-9c4e-9a07bdef3122','SDN2016080046','Danar Gymnastiar',NULL,'2003-10-07','','1',1),('a3ad09a6-dac6-45b9-b678-750014a6cf73','SDN2016080028','Aulia Fitra Raihannaim',NULL,'2002-12-05','','1',1),('a77bcca4-aee3-4cd3-96c0-b0e78ff13f73','SDN2016080025','Bayu Setiadi',NULL,'2016-05-03','','1',1),('a8280d8e-553c-4074-90b4-1f71b5c34e27','SDN2016080057','M. Fakhir',NULL,'2006-09-12','','1',1),('aa10f218-64f3-4c41-8a90-c5a578896e17','SDN2016080042','Sigit Bramantio Haryono',NULL,'2004-06-14','','1',1),('b01d8d84-9815-403c-9c44-12a385e997c4','00000','ANONYMOUS',NULL,'1980-07-25','','0',0),('b5cbc987-4f00-4fd8-b6d3-5c8de2e4ed45','SDN2016080062','M. Wahyu Aditya',NULL,'2000-12-16','','1',1),('b7afc825-ce01-493b-b59a-071b5645b682','SDN2016080017','Rama Novarianto',NULL,'2016-01-01','','1',1),('bc260302-c07d-47a6-ad55-bdda6b4b16e5','SDN2016080036','Reiska Ayu Tribowo',NULL,'1999-06-14','','1',1),('c0f065ac-a095-4a85-a28f-f116a9ba3e57','SDN2016080011','Afifah Indah S.',NULL,'2016-08-19','','1',1),('c407032a-4d0d-4b6d-94a3-ae891170e65c','SDN2016080064','Ulfi Fahri',NULL,'2001-12-29','','1',2),('c76091c1-4d94-447e-96f8-476bfee31604','SDN2016080026','Gisella Ayu Putri',NULL,'2016-03-20','','1',1),('cb1e074f-7ba2-415e-8523-4c36b75e2101','SDN2016080041','Fani Puja Apriastuti',NULL,'1999-04-10','','1',1),('ce59473f-8bd8-4c7c-a118-6228a2b301a1','SDN2016080067','Gery Elbari',NULL,'2002-06-26','','1',1),('d67ddc3e-1c60-4aff-8120-66dccf9263cb','SDN2016080039','Syarif Bayu Zulmarliansyah',NULL,'2000-12-15','','1',1),('d73b0190-ec65-4e75-8b15-aaebbfb4dc97','SDN2016080021','Yoga Febriyanda',NULL,'2001-10-09','','1',1),('e196257a-b925-4413-8ede-d4a7bd9f2466','SDN2016080048','Raka Ryan Arjuna A.',NULL,'1999-11-16','','1',1),('e26ce188-8644-46e6-b25f-e131cf46d678','SDN2016080050','Daffa Hibatullah Lubis',NULL,'2002-04-13','','1',1),('e29c7687-30f8-4201-af68-0a4a67541b86','00002','SSC PANCASILA',NULL,'2009-08-07','','1',0),('e68fa2ab-75bf-48b8-ab52-55f89e7a4787','SDN2016080007','Hanna Amalia',NULL,'2002-02-26','','1',1),('e9ecb5e5-ec98-40d3-9282-6b7949c99924','SDN2016080034','Tony Guswanto',NULL,'1999-08-17','','1',1),('f4eded39-41dc-40b7-b249-84c7daf9713d','SDN2016080038','Fauziah Putri',NULL,'2016-03-04','','1',1),('f6917d75-083e-4325-bc07-77af774f043b','SDN2016080037','Firlani Danti Nanda Novea',NULL,'1999-11-18','','1',1),('f89abcfd-9762-4a07-8b49-ad4f844b3ca1','SDN2016080012','Akbar Nurrohim Rusliana Ade',NULL,'1999-08-20','','1',1),('f8c59058-2728-4039-87d2-409b42b9dbc8','SDN2016080016','Bima Novarianto',NULL,'2016-11-28','','1',1),('fe8c2142-a8a5-428b-b242-84d7f384c079','SDN2016080010','Tiara Cahyani',NULL,'2002-12-26','','1',2),('ffa7d45c-37c8-46cf-9a02-6973fa73ca3d','SDN2016080071','Abimanyu Tri Aditama',NULL,'2000-02-24','','1',1);
/*!40000 ALTER TABLE `party` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `party_relationship`
--

LOCK TABLES `party_relationship` WRITE;
/*!40000 ALTER TABLE `party_relationship` DISABLE KEYS */;
INSERT INTO `party_relationship` VALUES ('032be2c3-cc2e-40e3-8b02-e9fdea941293','2016-07-23',NULL,NULL,NULL,0),('076ce509-80f9-43a5-817f-dec95cc60c91','2016-07-14',NULL,NULL,NULL,0),('08c4b3fc-4b19-4f1a-8c30-bd56fa568597','2016-07-25',NULL,NULL,NULL,0),('0dbac322-1500-4363-b343-a62d13017a3b','2016-07-23',NULL,NULL,NULL,0),('0dff5e0d-4271-46a5-bc99-c553e54bdbff','2016-06-18',NULL,NULL,NULL,0),('0f2e07d7-b23a-4716-8b30-636b72823f3f','1016-07-25',NULL,NULL,NULL,0),('135e4c98-33e0-4bf2-944b-de7b70fdcea0','2016-08-19',NULL,NULL,NULL,0),('139c104e-21c3-42d0-a166-219f0849c3fb','2016-07-25',NULL,NULL,NULL,0),('1c54f327-4edb-453f-bb66-d88b32c1a32b','2016-07-15',NULL,NULL,NULL,0),('1f39020a-3329-4285-b1ad-0c1f193b6070','2016-07-20',NULL,NULL,NULL,0),('1ff2319f-5daf-412c-81d5-86cd4ee4c7e1','2016-08-20',NULL,NULL,NULL,0),('23c55f7d-514e-48fe-a253-4ad962e4e8cf','2016-07-20',NULL,NULL,NULL,0),('28557ce2-861b-4928-b19a-3f2be3be3a8d','2016-07-12',NULL,NULL,NULL,0),('2925e2a8-8fb2-41ef-a097-99230aa39ae3','2016-07-25',NULL,NULL,NULL,0),('2926861b-df52-4312-bfbe-74cb6e48a6f4','2016-07-26',NULL,NULL,NULL,0),('2b729014-d894-4d64-82ed-9ce3ea6908e5','2016-07-19',NULL,NULL,NULL,0),('2bfc959f-896e-4fe9-8c54-dec324f57108','2016-07-26',NULL,NULL,NULL,0),('30255c60-7b8d-4ac3-843c-ead85edd88e1','2016-07-26',NULL,NULL,NULL,0),('30bd079b-e877-4e72-8c6c-a2b73804596a','2016-06-30',NULL,NULL,NULL,0),('310c82dd-78ed-4942-b10e-5509034c7e8c','2016-07-22',NULL,NULL,NULL,0),('329e54ac-e836-4686-96aa-c942597606e7','2016-07-18',NULL,NULL,NULL,0),('34cf8129-bead-4a09-b104-df235436e2fa','2016-07-26',NULL,NULL,NULL,0),('34e0bd3e-d7f4-4485-a7a6-36328b1619d9','2016-07-25',NULL,NULL,NULL,0),('37ea2be0-018e-4099-b8ef-e40856893fa4','2016-07-19',NULL,NULL,NULL,0),('384b5038-10f2-4a19-a6d4-584c3c3f7d29','2016-07-23',NULL,NULL,NULL,0),('3a4619fd-3c77-450a-9797-7d08871076a8','2016-07-25',NULL,NULL,NULL,0),('3ef18a42-d035-484a-9aa6-f9fa1258598f','2016-07-25',NULL,NULL,NULL,0),('42c711be-69e3-49f4-91b7-690a47b284b8','2016-07-25',NULL,NULL,NULL,0),('453d166a-07cf-4414-ba22-3f900a43ff4d','2016-07-18',NULL,NULL,NULL,0),('48a551a0-476d-4512-b664-425de879cbf5','2016-07-25',NULL,NULL,NULL,0),('4d51d260-8fcc-4bcd-babf-eac8fdf495ae','2016-07-18',NULL,NULL,NULL,0),('52629dee-9f9b-4a8c-b01a-cdb3b76d122b','2016-07-20',NULL,NULL,NULL,0),('531b848c-499c-4e6f-ab4a-46cc96e58a04','2016-06-04',NULL,NULL,NULL,0),('601daaa4-e8f7-4e32-8adf-7fbd9f1a8dfd','2016-07-20',NULL,NULL,NULL,0),('602ad1b2-57bf-4c0b-adb9-3d4c7c051a71','2016-07-15',NULL,NULL,NULL,0),('6472b733-96d7-4de4-ba0d-9bf8e4ffc29e','2016-07-22',NULL,NULL,NULL,0),('65b6ae84-53c2-4903-839c-c5b5589e3cd5','2016-07-26',NULL,NULL,NULL,0),('65de20c0-f5df-46bd-b91e-a8de5b03a53c','2016-07-26',NULL,NULL,NULL,0),('6788c207-ca1e-464d-b9eb-26d33c7a4068','2016-07-25',NULL,NULL,NULL,0),('68410bee-958e-4184-95b3-9e4ff71924a6','2016-07-25',NULL,NULL,NULL,0),('6a19d48c-741b-4740-832f-a5dc80c13e91','2016-07-20',NULL,NULL,NULL,0),('6f484743-b027-43b6-ba12-09e9dded155a','2016-08-22',NULL,NULL,NULL,0),('709f87d5-ade6-41b9-ac4a-cebd75e56b5c','2016-08-23',NULL,NULL,NULL,0),('710d06f5-4191-4aea-88eb-14a3f53a6a64','2016-08-23',NULL,NULL,NULL,0),('74cbd93a-dfb2-45ca-a3fd-8ed5ee6f8cf1','2014-08-07',NULL,NULL,NULL,0),('7fc21295-ab33-4c14-bc49-ddab440c46c3','2016-07-22',NULL,NULL,NULL,0),('8b67df0e-b5de-46ca-ba28-4693af99881e','2016-07-02',NULL,NULL,NULL,0),('8e716d34-c6aa-406f-9119-227dbb3c4d90','2016-07-22',NULL,NULL,NULL,0),('8f36a40e-83c1-4960-95bb-348fa34658b0','2016-07-19',NULL,NULL,NULL,0),('958a5554-bff8-484a-a30d-1e61c65efbf1','2016-07-20',NULL,NULL,NULL,0),('a7dd038f-31e2-40a2-b65d-07d43e44c587','2016-07-20',NULL,NULL,NULL,0),('ac406878-2721-4b1b-bda9-13a1d099960d','2016-07-19',NULL,NULL,NULL,0),('ad3b5b6b-1237-49bb-9a0f-7e08a5b4eb77','2016-07-26',NULL,NULL,NULL,0),('c18bbd27-c31f-4498-b873-20628f13ce56','2016-07-26',NULL,NULL,NULL,0),('c2960a06-c18c-44ef-94d6-a6720ab9dc1c','2016-07-26',NULL,NULL,NULL,0),('c2bc1638-71bd-4381-bee4-f18baa7eb5c5','2016-07-18',NULL,NULL,NULL,0),('c3785077-cbec-4ff1-9000-52bd087abdc2','2016-07-25',NULL,NULL,NULL,0),('c39e32af-9b46-4dce-957a-c04ed5f70696','2016-07-26',NULL,NULL,NULL,0),('c74385e6-156f-4065-97ef-7c45a5de504d','2016-07-22',NULL,NULL,NULL,0),('c929d858-e4e5-4c5e-92ba-1091e65c836c','2016-06-04',NULL,NULL,NULL,0),('ca7ee52a-5bc5-4563-8303-16d590c6f7c0','2016-07-19',NULL,NULL,NULL,0),('d30b1768-45bb-41ce-8561-0344d5388aa2','2016-07-26',NULL,NULL,NULL,0),('d470bf2b-bb5c-41bb-81a1-b93dbe00ba3a','2016-08-23',NULL,NULL,NULL,0),('d74a2e88-800b-4cb6-ab5e-1d9ca31e4d7f','2016-07-23',NULL,NULL,NULL,0),('d98aa4c5-2875-4899-bd1f-407e48c345a2','2016-07-16',NULL,NULL,NULL,0),('dc0d6440-e5ac-40dc-8198-935b0acf5a37','2016-07-25',NULL,NULL,NULL,0),('dc760901-56e6-4edc-86e6-3157c00fcdf5','2016-07-25',NULL,NULL,NULL,0),('e21ce90b-da25-4be6-81d3-26e6b7a7efd8','2016-07-25',NULL,NULL,NULL,0),('e65816bf-e384-49a6-a874-01cfc0db40f9','2016-05-11',NULL,NULL,NULL,0),('e757012c-967f-4b9f-851a-75792a157a3c','2016-07-19',NULL,NULL,NULL,0),('f04a6b9a-c638-4cdf-a1f5-09e6f48413bc','2016-07-18',NULL,NULL,NULL,0),('f1501be0-3f40-4620-a8c7-20f2e03a1724','2016-07-26',NULL,NULL,NULL,0),('f6fe4b06-975f-4582-bd8e-fe76cf3fdd0a','2016-07-25',NULL,NULL,NULL,0),('fafb7450-1dda-466a-b92d-5f5da89230d1','2016-07-22',NULL,NULL,NULL,0),('fb0e872e-b148-4c31-ae38-f2a3dbe1322a','2016-07-23',NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `party_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `party_role`
--

LOCK TABLES `party_role` WRITE;
/*!40000 ALTER TABLE `party_role` DISABLE KEYS */;
INSERT INTO `party_role` VALUES ('013f6fbf-2c6b-4d7a-8b04-2ad181d02bd7','2016-07-22',NULL,'6ad80274-db6b-42e3-8013-6ad1e441fb81',0),('09890166-4ccc-41d4-a54c-5a0e5864f6e3','2016-07-25',NULL,'c407032a-4d0d-4b6d-94a3-ae891170e65c',0),('14bd9c3f-7770-4b64-b195-1cf29b60e38a','2016-07-25',NULL,'1701ebcc-9dde-4e2f-9ac5-4cec4dd8d386',0),('19056ce0-9e11-4d7f-a136-54002d343c99','2016-06-30',NULL,'f89abcfd-9762-4a07-8b49-ad4f844b3ca1',0),('1f85a637-34bd-46cc-b824-0c67154988a9','2016-07-25',NULL,'a8280d8e-553c-4074-90b4-1f71b5c34e27',0),('206fbce2-5238-443b-9840-c8d98cd1b111','2016-07-25',NULL,'1eac9139-6b4f-40ff-aafb-a1be57705592',0),('20f5051d-a3c7-447f-97a7-178e033547a9','2016-07-23',NULL,'964a55cc-2dbb-48ea-b45a-62e4f244a796',0),('25e3817d-03ac-4c25-873c-589c911191b9','2016-07-25',NULL,'924efe8c-512b-4f7b-9b59-23f0a0e87369',0),('27ba0cef-80c1-4dd8-828b-c8a331bd8fe7','2016-07-26',NULL,'ce59473f-8bd8-4c7c-a118-6228a2b301a1',0),('2919f335-3ec9-40c0-bfd2-0dea0a3f465e','2016-07-26',NULL,'4221f198-19b2-416c-bf46-71163727a0ff',0),('2b21be03-bbbd-454f-a7aa-2cd75a76f2c8','2016-07-18',NULL,'017973d0-bdbc-4b6a-9b1e-bff197ab71f0',0),('36395e06-fc13-4720-9466-ac6ee36099b0','2016-08-23',NULL,'63a56e3f-f59b-432f-9c9d-463f1f744334',0),('3642b32d-8f15-45d9-adb6-3f325f9bb6c2','2016-07-18',NULL,'088f14ea-d0e6-4177-8998-cca133fae524',0),('3679901a-5145-4240-be19-f6693c9c3217','2016-07-26',NULL,'539fc7b2-a4a1-4b0e-a520-4bb2148b5405',0),('38a2b91d-a6b3-489a-a6cb-05acac001f99','2016-07-20',NULL,'49a021f9-ef29-4e7b-88a6-bdd1ee2f4d70',0),('3a579716-6a51-4bd5-a667-bdf6a174250f','2016-07-02',NULL,'65b78b03-601e-4570-bf18-14c7d44e1a18',0),('3b535b54-dba9-4067-a2a9-1af2e1696f85','2016-07-25',NULL,'7aff71e4-ddaf-4f7b-aff6-6a95cff39ed2',0),('40e222c3-db79-436c-b58a-de537f99a0df','2016-07-23',NULL,'11bb1ed3-dcdd-4430-908e-3d7e84870a88',0),('41826c9d-5160-4912-995c-19a5b3700b45','2016-07-19',NULL,'a77bcca4-aee3-4cd3-96c0-b0e78ff13f73',0),('4435f12f-3a1a-45c6-bce7-0db20cd97911','2016-08-23',NULL,'42901be4-86e0-4e24-be0f-0698dd7ae9bf',0),('4a79e394-7635-44c8-9aa0-d373e3f71990','2016-07-19',NULL,'6c0fadd3-9867-4d3c-b9f5-502676b503a8',0),('51125d9e-8a12-40c1-8519-faad4b8065f2','2016-07-22',NULL,'d67ddc3e-1c60-4aff-8120-66dccf9263cb',0),('518c3838-0f36-402f-9bad-652e93f1533c','2016-07-25',NULL,'44a75f39-d018-4644-b028-cd2328ac7ef8',0),('51c3c592-434d-4aea-9c66-e33cefcce8a8','2016-07-23',NULL,'8a820547-5d64-4589-bf73-837687170286',0),('58d04d5d-d3f8-43f8-b98e-09bb8afc4f54','2016-07-26',NULL,'0191c9f9-ed27-4967-93ed-add08b6f6f26',0),('59851383-6691-45c0-8330-10e86ac2342d','2016-07-26',NULL,'4a842e24-386c-4380-a333-3337b7f9029b',0),('5a6f3da9-5900-46aa-bac3-08ff13e6b0af','2016-07-26',NULL,'763a852d-5742-4be1-8905-714bcecebefd',0),('5cd4779d-3fb6-40cb-a532-e543734341d3','2016-08-22',NULL,'e196257a-b925-4413-8ede-d4a7bd9f2466',0),('607abfa1-d844-466b-8e1b-99e200e06cba','2016-06-18',NULL,'77a9c861-faaa-4b4a-a7b2-2d7124be9ba3',0),('67a29453-75e5-427b-88d3-2dccb104f9b2','2016-07-19',NULL,'3878879a-2e22-4a97-9929-ff37e1c31431',0),('6cec3c65-b6ff-4094-b90b-4748c634d508','2016-07-25',NULL,'36f481b9-37e7-4c28-99e5-369f45200634',0),('71ef3dc2-f4f1-48ed-b166-e2fa24fb7601','2016-07-20',NULL,'348d0045-3db2-4e43-a632-ad70f82f86dd',0),('72301c4d-1c56-4fcd-84e7-c6cf1ff04308','2016-07-20',NULL,'bc260302-c07d-47a6-ad55-bdda6b4b16e5',0),('72833aed-7a0c-4a09-9049-35f0aab38458','2016-07-19',NULL,'20677939-457c-4ac0-bf48-d93a5a02938a',0),('742fc487-8b9d-41d8-9a0c-b55772bc2c49','2014-08-07',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86',0),('743b9b7f-9292-407f-aa0d-9305b98becff','2016-07-18',NULL,'d73b0190-ec65-4e75-8b15-aaebbfb4dc97',0),('7dd6af66-de94-49ff-ac9b-7dd42a15cb0b','2016-07-22',NULL,'cb1e074f-7ba2-415e-8523-4c36b75e2101',0),('7dd9fbae-3b38-446e-b2cc-64f1692eb4c0','2016-07-20',NULL,'819d4ae9-36e9-47d5-b572-c7fb8c76f392',0),('7f4d7f25-a9e0-47f5-b8e3-47d8b492aa39','2016-07-15',NULL,'f8c59058-2728-4039-87d2-409b42b9dbc8',0),('81411eb4-901e-47d6-a97d-eb6b2d09c917','2016-07-22',NULL,'f4eded39-41dc-40b7-b249-84c7daf9713d',0),('81cebf95-2bc8-47ba-b782-84722ae48ab5','2016-08-19',NULL,'c0f065ac-a095-4a85-a28f-f116a9ba3e57',1),('86cdb736-158a-43a1-97f6-92eb5a507a9b','2016-08-20',NULL,'f6917d75-083e-4325-bc07-77af774f043b',0),('895c6562-c9c5-4b9e-8cd6-f34afa95238c','2016-07-23',NULL,'20266334-c727-405c-b710-f215473e4396',0),('93d109dd-5451-4823-8cff-b9b1806a1ff8','2016-08-23',NULL,'12529b23-3ec7-4912-a7ba-4a7dd0b14b64',0),('9575be3b-df71-4a73-ad13-91bd9f226ebb','2016-07-25',NULL,'29454f3b-e557-4cd5-b95d-8cd189c3c331',0),('961de37e-d784-4190-9f3d-8b12781c3b4e','2016-07-25',NULL,'146508c4-cdd5-44e0-9d99-4f5041bf740f',0),('99aab9a3-69ed-4f66-9508-6e6dea71f5e7','2016-07-20',NULL,'e9ecb5e5-ec98-40d3-9282-6b7949c99924',0),('9c003100-b652-498f-b4aa-4c3077667683','2016-07-22',NULL,'731838a3-08f5-4f01-9cc3-7b0985239d44',0),('a2486b77-c0c8-441e-8ad3-16d213fada1f','2016-07-26',NULL,'3459dd9e-7ec3-436f-9c39-db93a9c8f7c6',0),('a6d1bcd6-f39b-498b-a888-f3a14d76757c','2016-07-26',NULL,'280c1c5f-5bfc-41c7-9162-805edadc6a7c',0),('aa0d0f9e-fa99-4964-a7c8-50837cfc95c4','2016-07-25',NULL,'e26ce188-8644-46e6-b25f-e131cf46d678',0),('acd9ad82-15a8-4460-a437-9cf049aa6fdd','2016-07-20',NULL,'2625e364-072a-416b-846e-90b6add43bef',0),('b6e6b30b-1d19-4310-a4fa-27a7cc233f30','2016-07-26',NULL,'0ee45092-38fe-4270-a4c2-6657fa59298e',0),('b6e87fe4-9f31-4741-89a0-77530ba60d51','2016-07-18',NULL,'756755c3-1ddd-4086-b862-e7e9298b30cc',0),('b899ae55-9627-4da2-a702-8adb2d908b0c','1016-07-25',NULL,'b5cbc987-4f00-4fd8-b6d3-5c8de2e4ed45',0),('b8ae098a-a7bd-4977-b595-53ed28fae483','2014-08-07',NULL,'895f107c-991a-4173-8dba-f6a906e13cef',0),('bed05b14-62dc-4c93-bc6b-825930e013fc','2016-07-19',NULL,'a3ad09a6-dac6-45b9-b678-750014a6cf73',0),('bf088633-0bdb-4285-976a-6c72652bbf15','2016-07-26',NULL,'ffa7d45c-37c8-46cf-9a02-6973fa73ca3d',0),('bf336e36-5de1-43dc-90df-d6691ee37cb6','2016-07-14',NULL,'03039740-cb9e-49dc-a670-a600b41d21d1',0),('c6429b9c-b534-462d-9de2-daf3a26d7782','2016-07-16',NULL,'4dc0134d-711c-468e-af68-6faa3aa9ea1e',0),('ca5f620c-7715-452c-a9ff-76dd4ec4268f','2016-07-12',NULL,'8459900c-a178-43dd-b215-5e5c089475a2',0),('cc0772a2-3380-4f0a-ab00-3b1dd3f13606','2016-07-25',NULL,'633e7708-63c7-4f1f-8312-1d210e0dd065',0),('ced63b0d-655c-4094-ba4c-3a36d11efe1a','2016-07-25',NULL,'61105d59-ec88-4467-ac05-8334d9f66e50',0),('cee4b98e-b0ff-4ccd-b5f3-ab8f2ccc0d44','2016-07-26',NULL,'41095616-583a-4e15-8563-e405bc26d0d3',0),('d107d701-77ab-46fa-b28b-7ca533b01835','2016-07-22',NULL,'aa10f218-64f3-4c41-8a90-c5a578896e17',0),('d527a974-7114-4887-b2d0-ddb3995da945','2016-07-15',NULL,'b7afc825-ce01-493b-b59a-071b5645b682',1),('d5feeaa3-b34d-4495-b529-1e932e953ae0','2016-07-25',NULL,'1ceb724e-4833-417f-b34c-8086eb670f7e',0),('d67d6382-c999-49d9-adc8-1d22214aa367','2016-07-19',NULL,'c76091c1-4d94-447e-96f8-476bfee31604',0),('db471402-1f99-403c-bbcc-fc0bc20f58b0','2016-07-23',NULL,'9d91dc31-8244-41e6-9c4e-9a07bdef3122',0),('dfc15c98-8c01-412e-beb0-904170908b5f','2016-06-04',NULL,'fe8c2142-a8a5-428b-b242-84d7f384c079',1),('e721b7c8-ab3f-4932-9688-6d2755cbf647','2016-07-25',NULL,'2f43245c-8573-42cc-9692-8e3236de2f97',0),('ed53f41a-18b9-41e5-a5f5-09de16da9609','2016-07-26',NULL,'923274db-d2a5-4a78-9962-86348c84e283',0),('f2b8de62-48db-4af6-a587-ce0257528679','2016-07-20',NULL,'8e004f0b-e655-46c5-a38d-cc0217cca15a',0),('f4b3800b-b0d5-4519-b86e-b5775184f4ab','2016-05-11',NULL,'e68fa2ab-75bf-48b8-ab52-55f89e7a4787',2),('f971e4ae-b2eb-4572-ad76-ba60843880fc','2016-07-18',NULL,'022b153f-c31b-4bbe-bcf3-90dfc5243579',0);
/*!40000 ALTER TABLE `party_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `patient_relationship`
--

LOCK TABLES `patient_relationship` WRITE;
/*!40000 ALTER TABLE `patient_relationship` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `pay_history`
--

LOCK TABLES `pay_history` WRITE;
/*!40000 ALTER TABLE `pay_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `pay_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `payable`
--

LOCK TABLES `payable` WRITE;
/*!40000 ALTER TABLE `payable` DISABLE KEYS */;
/*!40000 ALTER TABLE `payable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `paycheck`
--

LOCK TABLES `paycheck` WRITE;
/*!40000 ALTER TABLE `paycheck` DISABLE KEYS */;
/*!40000 ALTER TABLE `paycheck` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `paycheck_item`
--

LOCK TABLES `paycheck_item` WRITE;
/*!40000 ALTER TABLE `paycheck_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `paycheck_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES ('0f7404b2-a2bf-476a-a600-4419f1f522e6','INV1','2016-09-02',1650000,'895f107c-991a-4173-8dba-f6a906e13cef','Cashier Event','e29c7687-30f8-4201-af68-0a4a67541b86','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','b4ab72cc-5153-43bb-ad33-14ae6ed7f6d6',0),('b94f43aa-464d-4ea3-9866-fcfa2bc2b04e','INV1','2016-08-28',2800000,'895f107c-991a-4173-8dba-f6a906e13cef','Cashier Event','e29c7687-30f8-4201-af68-0a4a67541b86','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `payment_application`
--

LOCK TABLES `payment_application` WRITE;
/*!40000 ALTER TABLE `payment_application` DISABLE KEYS */;
INSERT INTO `payment_application` VALUES ('3ef4bf2b-ddbf-4660-93c0-b2fff54ba104',1650000,'575a5deb-e574-4471-ba21-f0c9f3aa1727','0f7404b2-a2bf-476a-a600-4419f1f522e6',NULL),('eba59826-35ad-425e-8085-4d3a7eda3cc2',2800000,'22502402-da64-4ae1-9bb9-131b49745eab','b94f43aa-464d-4ea3-9866-fcfa2bc2b04e',NULL);
/*!40000 ALTER TABLE `payment_application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `payment_item`
--

LOCK TABLES `payment_item` WRITE;
/*!40000 ALTER TABLE `payment_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `payment_method_type`
--

LOCK TABLES `payment_method_type` WRITE;
/*!40000 ALTER TABLE `payment_method_type` DISABLE KEYS */;
INSERT INTO `payment_method_type` VALUES ('b4ab72cc-5153-43bb-ad33-14ae6ed7f6d6','CASH','',0);
/*!40000 ALTER TABLE `payment_method_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `payroll_preference`
--

LOCK TABLES `payroll_preference` WRITE;
/*!40000 ALTER TABLE `payroll_preference` DISABLE KEYS */;
/*!40000 ALTER TABLE `payroll_preference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES ('017973d0-bdbc-4b6a-9b1e-bff197ab71f0','MALE','SINGLE'),('0191c9f9-ed27-4967-93ed-add08b6f6f26','MALE','SINGLE'),('022b153f-c31b-4bbe-bcf3-90dfc5243579','MALE','SINGLE'),('03039740-cb9e-49dc-a670-a600b41d21d1','FEMALE','SINGLE'),('088f14ea-d0e6-4177-8998-cca133fae524','MALE','SINGLE'),('0ee45092-38fe-4270-a4c2-6657fa59298e','MALE','SINGLE'),('11bb1ed3-dcdd-4430-908e-3d7e84870a88','FEMALE','SINGLE'),('12529b23-3ec7-4912-a7ba-4a7dd0b14b64','MALE','SINGLE'),('146508c4-cdd5-44e0-9d99-4f5041bf740f','FEMALE','SINGLE'),('1701ebcc-9dde-4e2f-9ac5-4cec4dd8d386','MALE','SINGLE'),('1ceb724e-4833-417f-b34c-8086eb670f7e','FEMALE','SINGLE'),('1eac9139-6b4f-40ff-aafb-a1be57705592','FEMALE','SINGLE'),('20266334-c727-405c-b710-f215473e4396','FEMALE','SINGLE'),('20677939-457c-4ac0-bf48-d93a5a02938a','FEMALE','SINGLE'),('2625e364-072a-416b-846e-90b6add43bef','MALE','SINGLE'),('280c1c5f-5bfc-41c7-9162-805edadc6a7c','FEMALE','SINGLE'),('29454f3b-e557-4cd5-b95d-8cd189c3c331','MALE','SINGLE'),('2f43245c-8573-42cc-9692-8e3236de2f97','MALE','SINGLE'),('3459dd9e-7ec3-436f-9c39-db93a9c8f7c6','FEMALE','SINGLE'),('348d0045-3db2-4e43-a632-ad70f82f86dd','MALE','SINGLE'),('36f481b9-37e7-4c28-99e5-369f45200634','FEMALE','SINGLE'),('3878879a-2e22-4a97-9929-ff37e1c31431','FEMALE','SINGLE'),('41095616-583a-4e15-8563-e405bc26d0d3','FEMALE','SINGLE'),('4221f198-19b2-416c-bf46-71163727a0ff','FEMALE','SINGLE'),('42901be4-86e0-4e24-be0f-0698dd7ae9bf','MALE','SINGLE'),('44a75f39-d018-4644-b028-cd2328ac7ef8','FEMALE','SINGLE'),('49a021f9-ef29-4e7b-88a6-bdd1ee2f4d70','FEMALE','SINGLE'),('4a842e24-386c-4380-a333-3337b7f9029b','FEMALE','SINGLE'),('4dc0134d-711c-468e-af68-6faa3aa9ea1e','FEMALE','SINGLE'),('539fc7b2-a4a1-4b0e-a520-4bb2148b5405','FEMALE','SINGLE'),('61105d59-ec88-4467-ac05-8334d9f66e50','MALE','SINGLE'),('633e7708-63c7-4f1f-8312-1d210e0dd065','MALE','SINGLE'),('63a56e3f-f59b-432f-9c9d-463f1f744334','MALE','SINGLE'),('65b78b03-601e-4570-bf18-14c7d44e1a18','MALE','SINGLE'),('6ad80274-db6b-42e3-8013-6ad1e441fb81','FEMALE','SINGLE'),('6c0fadd3-9867-4d3c-b9f5-502676b503a8','MALE','SINGLE'),('731838a3-08f5-4f01-9cc3-7b0985239d44','FEMALE','SINGLE'),('756755c3-1ddd-4086-b862-e7e9298b30cc','FEMALE','SINGLE'),('763a852d-5742-4be1-8905-714bcecebefd','FEMALE','SINGLE'),('77a9c861-faaa-4b4a-a7b2-2d7124be9ba3','MALE','SINGLE'),('78171b13-766f-495b-939d-e01b79e21931','MALE','SINGLE'),('7aff71e4-ddaf-4f7b-aff6-6a95cff39ed2','FEMALE','SINGLE'),('819d4ae9-36e9-47d5-b572-c7fb8c76f392','FEMALE','SINGLE'),('8459900c-a178-43dd-b215-5e5c089475a2','MALE','SINGLE'),('895f107c-991a-4173-8dba-f6a906e13cef','MALE','SINGLE'),('8a820547-5d64-4589-bf73-837687170286','MALE','SINGLE'),('8e004f0b-e655-46c5-a38d-cc0217cca15a','MALE','SINGLE'),('923274db-d2a5-4a78-9962-86348c84e283','MALE','SINGLE'),('924efe8c-512b-4f7b-9b59-23f0a0e87369','MALE','SINGLE'),('964a55cc-2dbb-48ea-b45a-62e4f244a796','MALE','SINGLE'),('9d91dc31-8244-41e6-9c4e-9a07bdef3122','MALE','SINGLE'),('a3ad09a6-dac6-45b9-b678-750014a6cf73','FEMALE','SINGLE'),('a77bcca4-aee3-4cd3-96c0-b0e78ff13f73','MALE','SINGLE'),('a8280d8e-553c-4074-90b4-1f71b5c34e27','MALE','SINGLE'),('aa10f218-64f3-4c41-8a90-c5a578896e17','MALE','SINGLE'),('b01d8d84-9815-403c-9c44-12a385e997c4','MALE','SINGLE'),('b5cbc987-4f00-4fd8-b6d3-5c8de2e4ed45','MALE','SINGLE'),('b7afc825-ce01-493b-b59a-071b5645b682','MALE','SINGLE'),('bc260302-c07d-47a6-ad55-bdda6b4b16e5','FEMALE','SINGLE'),('c0f065ac-a095-4a85-a28f-f116a9ba3e57','MALE','SINGLE'),('c407032a-4d0d-4b6d-94a3-ae891170e65c','FEMALE','SINGLE'),('c76091c1-4d94-447e-96f8-476bfee31604','FEMALE','SINGLE'),('cb1e074f-7ba2-415e-8523-4c36b75e2101','FEMALE','SINGLE'),('ce59473f-8bd8-4c7c-a118-6228a2b301a1','MALE','SINGLE'),('d67ddc3e-1c60-4aff-8120-66dccf9263cb','MALE','SINGLE'),('d73b0190-ec65-4e75-8b15-aaebbfb4dc97','MALE','SINGLE'),('e196257a-b925-4413-8ede-d4a7bd9f2466','MALE','SINGLE'),('e26ce188-8644-46e6-b25f-e131cf46d678','MALE','SINGLE'),('e68fa2ab-75bf-48b8-ab52-55f89e7a4787','FEMALE','SINGLE'),('e9ecb5e5-ec98-40d3-9282-6b7949c99924','MALE','SINGLE'),('f4eded39-41dc-40b7-b249-84c7daf9713d','FEMALE','SINGLE'),('f6917d75-083e-4325-bc07-77af774f043b','FEMALE','SINGLE'),('f89abcfd-9762-4a07-8b49-ad4f844b3ca1','MALE','SINGLE'),('f8c59058-2728-4039-87d2-409b42b9dbc8','MALE','SINGLE'),('fe8c2142-a8a5-428b-b242-84d7f384c079','FEMALE','SINGLE'),('ffa7d45c-37c8-46cf-9a02-6973fa73ca3d','MALE','SINGLE');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `pharmacy_sales`
--

LOCK TABLES `pharmacy_sales` WRITE;
/*!40000 ALTER TABLE `pharmacy_sales` DISABLE KEYS */;
/*!40000 ALTER TABLE `pharmacy_sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `pharmacy_sales_item`
--

LOCK TABLES `pharmacy_sales_item` WRITE;
/*!40000 ALTER TABLE `pharmacy_sales_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `pharmacy_sales_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES ('989ee61c-cd85-4f52-8925-8226403ed4c5','2016-07-25',NULL,'2016-07-25',NULL,'Fulltime','Permanent','Monthly','Planned',NULL,'05405e62-c71b-4e76-b28f-d5f5f148f19e','b620d220-4d73-473f-b0ba-cad098570b6a',3);
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `position_fulfillment`
--

LOCK TABLES `position_fulfillment` WRITE;
/*!40000 ALTER TABLE `position_fulfillment` DISABLE KEYS */;
/*!40000 ALTER TABLE `position_fulfillment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `position_reporting_structure`
--

LOCK TABLES `position_reporting_structure` WRITE;
/*!40000 ALTER TABLE `position_reporting_structure` DISABLE KEYS */;
/*!40000 ALTER TABLE `position_reporting_structure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `position_responsibility`
--

LOCK TABLES `position_responsibility` WRITE;
/*!40000 ALTER TABLE `position_responsibility` DISABLE KEYS */;
/*!40000 ALTER TABLE `position_responsibility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `position_type`
--

LOCK TABLES `position_type` WRITE;
/*!40000 ALTER TABLE `position_type` DISABLE KEYS */;
INSERT INTO `position_type` VALUES ('05405e62-c71b-4e76-b28f-d5f5f148f19e','CEO','CEO',0);
/*!40000 ALTER TABLE `position_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `position_type_rate`
--

LOCK TABLES `position_type_rate` WRITE;
/*!40000 ALTER TABLE `position_type_rate` DISABLE KEYS */;
/*!40000 ALTER TABLE `position_type_rate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('0bc8361e-ed10-4cfb-b236-30183daa771c','KLS 7 SMP KTSP','KELAS 7 SMP KTSP','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,0),('0f00e455-b398-402f-8fc7-8281844d8aac','SOS','SOSIOLOGI','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,0),('17fb878a-6cbd-4605-8a1b-7d8ca8ffde21','KLS 5 SD K2013','KELAS 5 SD K2013','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,1),('1967553d-bda0-4a57-b9f5-356adf49c451','BIAYA PENDAFTARAN','BIAYA PENDAFTARAN','2009-08-07',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,0),('283f284e-9efb-45c9-84fd-5fcbd2293505','KLS 6 SD K2013','KELAS 6 SD K2013','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,1),('2d1f7f21-4288-405b-9b35-188e668b1ba7','KLS 4 SD KTSP','KELAS 4 SD KTSP','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,1),('2d20ed16-7959-430b-9582-d9161033cadf','KLS 12 SMA IPA + SBMPTN','KELAS 12 SMA IPA + SBMPTN','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,0),('302a98d2-e1a6-488e-b5bc-4589d058e056','KLS 12 SMA IPA K2013','KELAS 12 SMA IPA K2013','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,0),('30ba8cf4-f749-49e3-9a64-cab4c7adaa0a','KIM','KIMIA','2016-08-07',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,0),('3394c361-d913-4846-b886-46345d1ffb1a','KLS 12 SMA IPS K2013','KELAS 12 SMA IPS K2013','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,0),('3a5ff044-420c-410c-a9e1-e5ddfe922c53','IPA','ILMU PENGETAHUAN ALAM','2016-08-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,0),('3d7f280c-a0cc-4959-91a4-7a42e2d7e86a','KLS 6 SD KTSP','KELAS 6 SD KTSP','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,0),('44965c88-3dfa-4645-b885-1003c53da8af','KLS 10 IPS K2013','KELAS 10 IPS K2013','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,1),('4e2b417e-0a3a-427d-aa82-9b44cf14fd22','KLS 5 SD KTSP','KELAS 5 SD KTSP','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,1),('64e5471b-d868-4f75-8e56-a7f1c76c31f9','KLS 11 SMA IPS KTSP','KELAS 11 SMA IPS KTSP','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,0),('6f38df8c-f40f-4b92-aba3-ac33873af6c2','KLS 10 IPS KTSP','KELAS 10 IPS KTSP','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,0),('7772edb9-c20a-4cae-af8c-af8eda5226af','KLS 9 SMP KTSP','KELAS 9 SMP KTSP','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,0),('797da746-ebd7-4b49-9f6d-aa363adf6333','BIO','BIOLOGI','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,0),('7a9d5b56-1430-4404-a4f0-732da0deeba6','IPS','ILMU PENGETAHUAN SOSIAL','2016-08-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,0),('817ac9c4-31d5-460e-9500-914719aee3b3','KLS 12 SMA IPS KTSP','KELAS 12 SMA IPS KTSP','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,0),('85dc7116-6c49-4821-a5e4-76cf774dbb92','KLS 8 SMP KTSP','KELAS 8 SMP KTSP','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,0),('87ba3d97-3c5e-4ad4-8a49-a4a61606747f','KLS 11 SMA IPA KTSP','KELAS 11 SMA IPA KTSP','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,0),('8d0f9eaf-4a97-4569-a6e9-45dd8ec1ef80','AK','EKONOMI / AKUTANSI','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,2),('92733f9c-0645-43d4-a244-1c6f50047dc1','KLS 7 SMP K2013','KELAS 7 SMP K2013','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,1),('a60736b7-5b34-4aa9-ae77-e31207d69f80','KLS 10 SMA IPA K2013','KELAS 10 SMA IPA K2013','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,2),('a770715e-fdc0-430e-93db-bc513306b815','KLS 12 SMA IPA KTSP','KELAS 12 SMA IPA KTSP','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,0),('aa5d68c4-ea05-41c0-b426-39cf527fa337','KLS 4 SD K2013','KELAS 4 SD K2013','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,0),('b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','B.ING','BAHASA INGGRIS','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,1),('c09495a7-c517-4a74-9eda-6433c9b681d1','FIS','FISIKA','2009-08-07',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,0),('c47da54f-b8ef-4d61-a5b0-79563bae587c','KLS 9 SMP K2013','KELAS 9 SMP K2013','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,1),('c4f99a41-737b-410e-a0ca-d0a8970ba7ae','KLS 12 SMA IPS + SBMPTN','KELAS 12 SMA IPS + SBMPTN','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,0),('c51063e0-bfeb-4cf1-abd5-4ec0df252483','GEO','GEOGRAFI','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,0),('c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','B.IND','BAHASA INDONESIA','0106-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,3),('d75a699b-9cbd-4375-90e9-a249e1d99fb7','MTK','MATEMATIKA','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,2),('e02177e4-4b57-47e8-8fce-d684addf9ff5','KLS 10 SMA IPA KTAP','KELAS 10 SMA IPA KTSP','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,0),('e0c6c287-aca3-49ac-830d-28d5de8f4339','KLS 8 SMP K2013','KELAS 8 SMP K2013','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,1),('ec04f800-1eb6-4c2c-ab2c-e2d835cb8982','KLS 11 SMA IPS K2013','KELAS 11 SMA IPS K2013','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,0),('fc4de6a2-5951-423b-82d2-bf2b84a6f3d0','KLS 11 SMA IPA K2013','KELAS 11 SMA IPA K2013','2016-01-01',NULL,'be5ad391-0c12-4c0a-bad5-7ee5254abb56','127bbc98-7a14-48a5-8df5-751ecc2f9f8f','SERVICE',0,1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product_category`
--

LOCK TABLES `product_category` WRITE;
/*!40000 ALTER TABLE `product_category` DISABLE KEYS */;
INSERT INTO `product_category` VALUES ('127bbc98-7a14-48a5-8df5-751ecc2f9f8f','BIMBEL','BIMBINGAN BELAJAR','SSC','FOOD',1);
/*!40000 ALTER TABLE `product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product_code`
--

LOCK TABLES `product_code` WRITE;
/*!40000 ALTER TABLE `product_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product_component`
--

LOCK TABLES `product_component` WRITE;
/*!40000 ALTER TABLE `product_component` DISABLE KEYS */;
INSERT INTO `product_component` VALUES ('0103388f-bc0e-473b-810d-9a0a6365174a',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','2d1f7f21-4288-405b-9b35-188e668b1ba7','',0),('01b5e47c-2eea-41d1-a405-8ff2da48d540',1,'c09495a7-c517-4a74-9eda-6433c9b681d1','87ba3d97-3c5e-4ad4-8a49-a4a61606747f','',0),('033a0b72-c433-42cf-a2ba-d04491884ebd',1,'3a5ff044-420c-410c-a9e1-e5ddfe922c53','2d1f7f21-4288-405b-9b35-188e668b1ba7','',0),('053d1644-da9c-4088-ae7a-792ab2579b31',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','e0c6c287-aca3-49ac-830d-28d5de8f4339','',0),('07528956-53e5-4b7f-a080-1ab88c3edee8',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','aa5d68c4-ea05-41c0-b426-39cf527fa337','',0),('0a1bc553-f96c-464a-b436-aa721865c15b',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','92733f9c-0645-43d4-a244-1c6f50047dc1','',0),('0ec84a29-b58b-41c6-92cf-0891f927afab',1,'7a9d5b56-1430-4404-a4f0-732da0deeba6','17fb878a-6cbd-4605-8a1b-7d8ca8ffde21','',0),('138dd687-9de7-449d-8183-0b1cff81afba',1,'8d0f9eaf-4a97-4569-a6e9-45dd8ec1ef80','3394c361-d913-4846-b886-46345d1ffb1a','',0),('175be025-1cf2-4f72-ab64-b3ce2f479c10',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','fc4de6a2-5951-423b-82d2-bf2b84a6f3d0','',0),('19930832-2364-4485-a70e-12c8d58bade4',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','92733f9c-0645-43d4-a244-1c6f50047dc1','',0),('19fe9eb6-d8e0-4980-9da6-57765af4be06',1,'0f00e455-b398-402f-8fc7-8281844d8aac','6f38df8c-f40f-4b92-aba3-ac33873af6c2','',0),('1a5742a5-1d65-447f-8f22-08762bdcbf43',1,'0f00e455-b398-402f-8fc7-8281844d8aac','3394c361-d913-4846-b886-46345d1ffb1a','',0),('1ba4f291-d28c-4bc3-8b9e-ae3e398a1c9f',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','283f284e-9efb-45c9-84fd-5fcbd2293505','',0),('1d024699-a51f-460f-88b1-8510578b7c7f',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','44965c88-3dfa-4645-b885-1003c53da8af','',0),('1dfbf9e5-28ec-4d95-9cad-32abb39cb9e3',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','6f38df8c-f40f-4b92-aba3-ac33873af6c2','',0),('1e22729b-2c0d-4965-82c9-baa5e79c168a',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','4e2b417e-0a3a-427d-aa82-9b44cf14fd22','',0),('1ef56a02-13ca-44da-a83b-c9774de4500c',1,'797da746-ebd7-4b49-9f6d-aa363adf6333','2d20ed16-7959-430b-9582-d9161033cadf','',0),('1f80ffff-66fa-45de-a834-0189e1c0e4ac',1,'c51063e0-bfeb-4cf1-abd5-4ec0df252483','64e5471b-d868-4f75-8e56-a7f1c76c31f9','',0),('1fb6dea6-ea34-4782-8039-dd70fbade5d9',1,'797da746-ebd7-4b49-9f6d-aa363adf6333','302a98d2-e1a6-488e-b5bc-4589d058e056','',0),('20b6c4ec-7773-46ce-9e54-abbadc606d83',1,'0f00e455-b398-402f-8fc7-8281844d8aac','44965c88-3dfa-4645-b885-1003c53da8af','',0),('22978e94-f741-4c62-a310-585e571debdc',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','302a98d2-e1a6-488e-b5bc-4589d058e056','',0),('2335b870-ba32-4a6e-b047-7d48ac0b26cf',1,'7a9d5b56-1430-4404-a4f0-732da0deeba6','0bc8361e-ed10-4cfb-b236-30183daa771c','',0),('245a86ce-de88-475a-a86c-e191638fb120',1,'c51063e0-bfeb-4cf1-abd5-4ec0df252483','c4f99a41-737b-410e-a0ca-d0a8970ba7ae','',0),('257017d8-4d27-4a00-9e32-29c4515b572a',1,'797da746-ebd7-4b49-9f6d-aa363adf6333','a60736b7-5b34-4aa9-ae77-e31207d69f80','',0),('2625255b-43e2-4421-8498-c8648acf7c09',1,'7a9d5b56-1430-4404-a4f0-732da0deeba6','85dc7116-6c49-4821-a5e4-76cf774dbb92','',0),('274fec34-27f4-4108-ad99-c8ed2bb6eb40',1,'7a9d5b56-1430-4404-a4f0-732da0deeba6','3d7f280c-a0cc-4959-91a4-7a42e2d7e86a','',0),('2b26e040-ab1c-4719-b8e0-332a3f506c36',1,'8d0f9eaf-4a97-4569-a6e9-45dd8ec1ef80','6f38df8c-f40f-4b92-aba3-ac33873af6c2','',0),('2fb76ee6-e232-4684-9ef6-171dc616de48',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','6f38df8c-f40f-4b92-aba3-ac33873af6c2','',0),('3115234b-0e4b-4cd2-8396-dbe6827a71f2',1,'30ba8cf4-f749-49e3-9a64-cab4c7adaa0a','e02177e4-4b57-47e8-8fce-d684addf9ff5','',0),('33cad4ad-44ce-4a64-8549-7986417f1a79',1,'c51063e0-bfeb-4cf1-abd5-4ec0df252483','44965c88-3dfa-4645-b885-1003c53da8af','',0),('3480b0a2-8171-4189-a93c-9d05063ff11a',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','2d20ed16-7959-430b-9582-d9161033cadf','',0),('35d1e6d7-0ed7-44b4-8cfe-97bfd4027c84',1,'3a5ff044-420c-410c-a9e1-e5ddfe922c53','85dc7116-6c49-4821-a5e4-76cf774dbb92','',0),('3773c029-4852-4ea9-81c5-d9e3f6dc72b4',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','e0c6c287-aca3-49ac-830d-28d5de8f4339','',0),('38bcf975-a04b-4cd9-b78c-d95b807f27ea',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','85dc7116-6c49-4821-a5e4-76cf774dbb92','',0),('3977cf32-147e-485c-ac22-30f5f8867301',1,'3a5ff044-420c-410c-a9e1-e5ddfe922c53','92733f9c-0645-43d4-a244-1c6f50047dc1','',0),('3d6d1d9e-1970-497c-aefb-35fd2def46ca',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','85dc7116-6c49-4821-a5e4-76cf774dbb92','',0),('3ddb40a5-65bd-442c-b4c4-cfb2c7a776cc',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','817ac9c4-31d5-460e-9500-914719aee3b3','',0),('3eeb6960-b00d-4a61-a64e-22bec81d5be3',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','3394c361-d913-4846-b886-46345d1ffb1a','',0),('41d25bcc-47ca-4364-80b6-f05764f00b71',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','4e2b417e-0a3a-427d-aa82-9b44cf14fd22','',0),('42644caf-75ca-40fa-9dd1-f5e3dd0a56b8',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','2d1f7f21-4288-405b-9b35-188e668b1ba7','',0),('42bdfccf-c2eb-44b1-a8e4-58716e4f032a',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','ec04f800-1eb6-4c2c-ab2c-e2d835cb8982','',0),('430568f3-3d85-4f78-9d71-09ab23df3c16',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','2d20ed16-7959-430b-9582-d9161033cadf','',0),('442231de-119d-4439-9597-345b3742a798',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','3d7f280c-a0cc-4959-91a4-7a42e2d7e86a','',0),('44e1c4fd-b1cc-4fd4-9dfc-3e94055fad61',1,'3a5ff044-420c-410c-a9e1-e5ddfe922c53','e0c6c287-aca3-49ac-830d-28d5de8f4339','',0),('482be831-f944-4a16-916a-fbbd5ea9372c',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','0bc8361e-ed10-4cfb-b236-30183daa771c','',0),('4c327976-0ebc-4a6c-9066-614fa17de227',1,'30ba8cf4-f749-49e3-9a64-cab4c7adaa0a','302a98d2-e1a6-488e-b5bc-4589d058e056','',0),('4cee9487-e4a5-4f38-8c2b-5120860e831c',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','3394c361-d913-4846-b886-46345d1ffb1a','',0),('4e1ba4cf-8ac6-4d9f-848e-baa0e114e6ec',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','0bc8361e-ed10-4cfb-b236-30183daa771c','',0),('50b150e0-6a09-4e61-ac79-2d6f6e9f8395',1,'30ba8cf4-f749-49e3-9a64-cab4c7adaa0a','fc4de6a2-5951-423b-82d2-bf2b84a6f3d0','',0),('558169f9-5ec8-492b-bbfe-20db5348c47c',1,'797da746-ebd7-4b49-9f6d-aa363adf6333','fc4de6a2-5951-423b-82d2-bf2b84a6f3d0','',0),('57d352fe-b4a2-4216-a8c6-8e66128bd1b5',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','3d7f280c-a0cc-4959-91a4-7a42e2d7e86a','',0),('5a8c1257-5265-421f-bff6-e3f11146539a',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','817ac9c4-31d5-460e-9500-914719aee3b3','',0),('5a99475e-3933-4b15-a3e0-c532b4b01abf',1,'c09495a7-c517-4a74-9eda-6433c9b681d1','e02177e4-4b57-47e8-8fce-d684addf9ff5','',0),('5dbfd153-dadc-41cf-aee8-f835a07ca4fe',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','44965c88-3dfa-4645-b885-1003c53da8af','',0),('604ec4ee-4819-458e-be63-5b78b63106ce',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','a770715e-fdc0-430e-93db-bc513306b815','',0),('611de6b0-8732-4b9d-b4ad-53a81cbeadea',1,'c51063e0-bfeb-4cf1-abd5-4ec0df252483','ec04f800-1eb6-4c2c-ab2c-e2d835cb8982','',0),('613db0ef-1cb0-4871-bf67-6f6c0edae4fc',1,'3a5ff044-420c-410c-a9e1-e5ddfe922c53','7772edb9-c20a-4cae-af8c-af8eda5226af','',0),('61fc20a9-35f2-4b85-a0ff-0d63f0740f96',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','87ba3d97-3c5e-4ad4-8a49-a4a61606747f','',0),('625185cb-51c2-4691-ae90-2b5c67135c1c',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','87ba3d97-3c5e-4ad4-8a49-a4a61606747f','',0),('625b6acc-eb94-4a5f-9d89-a9f4411ce16b',1,'0f00e455-b398-402f-8fc7-8281844d8aac','817ac9c4-31d5-460e-9500-914719aee3b3','',0),('63c04f29-3a6e-4671-af8c-70c084a1ba0e',1,'7a9d5b56-1430-4404-a4f0-732da0deeba6','92733f9c-0645-43d4-a244-1c6f50047dc1','',0),('67e35ac2-e0fa-49e3-bf7a-d2bef94f0d70',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','c4f99a41-737b-410e-a0ca-d0a8970ba7ae','',0),('67f1298c-71aa-4f29-a9a8-04ec770d2beb',1,'3a5ff044-420c-410c-a9e1-e5ddfe922c53','c47da54f-b8ef-4d61-a5b0-79563bae587c','',0),('6bf7c427-0d06-4b92-83a0-4139fafbc664',1,'c09495a7-c517-4a74-9eda-6433c9b681d1','302a98d2-e1a6-488e-b5bc-4589d058e056','',0),('6c67ecad-4ad7-4c12-98d9-01a419dd33c8',1,'3a5ff044-420c-410c-a9e1-e5ddfe922c53','4e2b417e-0a3a-427d-aa82-9b44cf14fd22','',0),('72f4a7d7-8987-4a16-9147-f2d5c2edd0c7',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','c4f99a41-737b-410e-a0ca-d0a8970ba7ae','',0),('73d971d2-6c53-4cf0-a82b-2b4b0c25591b',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','a770715e-fdc0-430e-93db-bc513306b815','',0),('757ee141-4022-466e-9df1-c4617cc257cb',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','7772edb9-c20a-4cae-af8c-af8eda5226af','',0),('77ea9f77-ea25-4bb5-b658-a09523bc50ba',1,'c09495a7-c517-4a74-9eda-6433c9b681d1','2d20ed16-7959-430b-9582-d9161033cadf','',0),('78966463-eda6-4378-850c-f9d08af4effc',1,'3a5ff044-420c-410c-a9e1-e5ddfe922c53','283f284e-9efb-45c9-84fd-5fcbd2293505','',0),('7979f26e-c429-469c-8d7e-8adda1a95967',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','64e5471b-d868-4f75-8e56-a7f1c76c31f9','',0),('8225ce70-fb88-490d-ad61-df29d0d2ccc2',1,'7a9d5b56-1430-4404-a4f0-732da0deeba6','2d1f7f21-4288-405b-9b35-188e668b1ba7','',0),('843982b4-7243-41e6-96e0-914491a0eba7',1,'8d0f9eaf-4a97-4569-a6e9-45dd8ec1ef80','c4f99a41-737b-410e-a0ca-d0a8970ba7ae','',0),('84ac5afc-8634-4d14-a69a-a90baad2bda5',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','64e5471b-d868-4f75-8e56-a7f1c76c31f9','',0),('8684914a-7cf3-4e4a-ba55-b6b35f0b110c',1,'c09495a7-c517-4a74-9eda-6433c9b681d1','a60736b7-5b34-4aa9-ae77-e31207d69f80','',0),('8740c503-dad3-4eff-966f-d7467feb2d07',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','44965c88-3dfa-4645-b885-1003c53da8af','',0),('886478ab-2830-4af7-9964-9520d1aeaea2',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','4e2b417e-0a3a-427d-aa82-9b44cf14fd22','',0),('8b524d72-153c-442e-a8ae-2a2b1b19b497',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','7772edb9-c20a-4cae-af8c-af8eda5226af','',0),('8b93b9c0-d73e-4cd3-9834-ed4cab457a8b',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','e02177e4-4b57-47e8-8fce-d684addf9ff5','',0),('8bee901c-d7b9-4b59-ab96-f494e466657b',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','3d7f280c-a0cc-4959-91a4-7a42e2d7e86a','',0),('8c90c7cf-cdb2-4820-bf5d-c41bdfe12a57',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','ec04f800-1eb6-4c2c-ab2c-e2d835cb8982','',0),('8ce37132-0e04-45d4-a620-afb1bb576133',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','aa5d68c4-ea05-41c0-b426-39cf527fa337','',0),('8ce69408-d448-4733-84ed-adf652ffb8ee',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','e02177e4-4b57-47e8-8fce-d684addf9ff5','',0),('8f2632a7-335a-4a29-8eb0-bdb00fda40ef',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','fc4de6a2-5951-423b-82d2-bf2b84a6f3d0','',0),('8fad788f-b857-4dc1-81f3-17d1676401c2',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','6f38df8c-f40f-4b92-aba3-ac33873af6c2','',0),('90058f03-eaa5-47a3-8e0f-4ab5ff3e2f99',1,'30ba8cf4-f749-49e3-9a64-cab4c7adaa0a','a60736b7-5b34-4aa9-ae77-e31207d69f80','',0),('92337e29-1bf9-498e-b6fb-f391310ca083',1,'7a9d5b56-1430-4404-a4f0-732da0deeba6','7772edb9-c20a-4cae-af8c-af8eda5226af','',0),('93238d7f-ed73-480c-b1bd-8edfb0d379d0',1,'8d0f9eaf-4a97-4569-a6e9-45dd8ec1ef80','44965c88-3dfa-4645-b885-1003c53da8af','',0),('9381032f-339a-407b-b9c0-bd3f7fc28e48',1,'30ba8cf4-f749-49e3-9a64-cab4c7adaa0a','a770715e-fdc0-430e-93db-bc513306b815','',0),('97cd9e18-9a88-4391-bf37-49c119c86588',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','3394c361-d913-4846-b886-46345d1ffb1a','',0),('997c22fd-9fd2-4813-9411-68d620dcf4b8',1,'3a5ff044-420c-410c-a9e1-e5ddfe922c53','0bc8361e-ed10-4cfb-b236-30183daa771c','',0),('9ae687e3-e2e7-45f7-ae1e-14abb77d574f',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','e02177e4-4b57-47e8-8fce-d684addf9ff5','',0),('9afd579e-2356-4d75-9352-f2c01dfe4ed7',1,'c51063e0-bfeb-4cf1-abd5-4ec0df252483','3394c361-d913-4846-b886-46345d1ffb1a','',0),('9d687d0f-76d1-4ceb-abf2-cf511ef891c6',1,'c51063e0-bfeb-4cf1-abd5-4ec0df252483','6f38df8c-f40f-4b92-aba3-ac33873af6c2','',0),('9e5c0fb7-f1f2-4591-a765-540f7267f7e3',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','817ac9c4-31d5-460e-9500-914719aee3b3','',0),('a00bdfd2-cc5e-40b3-928f-509e6bce4d2e',1,'30ba8cf4-f749-49e3-9a64-cab4c7adaa0a','87ba3d97-3c5e-4ad4-8a49-a4a61606747f','',0),('a0a32e05-dc6f-4e8a-ac35-395f5d4c4175',1,'c09495a7-c517-4a74-9eda-6433c9b681d1','a770715e-fdc0-430e-93db-bc513306b815','',0),('a5297380-f490-48a3-b759-535907aec1f9',1,'c51063e0-bfeb-4cf1-abd5-4ec0df252483','817ac9c4-31d5-460e-9500-914719aee3b3','',0),('a58cc54f-d0be-4c8f-bc41-3e160854e8b0',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','64e5471b-d868-4f75-8e56-a7f1c76c31f9','',0),('a670d917-e99f-45d7-be1d-6723ecaf2ed6',1,'7a9d5b56-1430-4404-a4f0-732da0deeba6','283f284e-9efb-45c9-84fd-5fcbd2293505','',0),('a6c7a807-3f82-4b76-b92e-2b4874a44713',1,'0f00e455-b398-402f-8fc7-8281844d8aac','64e5471b-d868-4f75-8e56-a7f1c76c31f9','',0),('ab4bcad3-87d6-4b09-947e-7a350c2d5932',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','302a98d2-e1a6-488e-b5bc-4589d058e056','',0),('ac69a4f6-8558-4b45-bb73-973cbaa3fcc3',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','92733f9c-0645-43d4-a244-1c6f50047dc1','',0),('ad98bc51-6c69-43b8-ac71-4fe303a1549f',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','aa5d68c4-ea05-41c0-b426-39cf527fa337','',0),('b05de736-02f2-4ef2-8ca1-fa2b17737d47',1,'7a9d5b56-1430-4404-a4f0-732da0deeba6','aa5d68c4-ea05-41c0-b426-39cf527fa337','',0),('b2cecac7-ede2-4a71-a01c-aaf8b84a2b31',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','c47da54f-b8ef-4d61-a5b0-79563bae587c','',0),('b340bfa5-8d5e-4d5f-aa29-a7202026e499',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','283f284e-9efb-45c9-84fd-5fcbd2293505','',0),('b3907d0a-9bf6-4184-8460-8a2644d60d02',1,'797da746-ebd7-4b49-9f6d-aa363adf6333','87ba3d97-3c5e-4ad4-8a49-a4a61606747f','',0),('b3a24b48-b040-4f3e-b7f7-323a80740281',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','ec04f800-1eb6-4c2c-ab2c-e2d835cb8982','',0),('b3eec394-9185-4527-b6ea-f5cc777ca858',1,'30ba8cf4-f749-49e3-9a64-cab4c7adaa0a','2d20ed16-7959-430b-9582-d9161033cadf','',0),('b6083fa3-08dd-4099-9f50-2069a2af6537',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','7772edb9-c20a-4cae-af8c-af8eda5226af','',0),('bd38f81a-2313-486a-8c9f-b3d9fefa11ae',1,'3a5ff044-420c-410c-a9e1-e5ddfe922c53','17fb878a-6cbd-4605-8a1b-7d8ca8ffde21','',0),('c030d9e6-b975-499d-b97f-f592ec6e008d',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','c47da54f-b8ef-4d61-a5b0-79563bae587c','',0),('c4a9a0df-69fd-454b-b4b3-3418035025af',1,'7a9d5b56-1430-4404-a4f0-732da0deeba6','c47da54f-b8ef-4d61-a5b0-79563bae587c','',0),('cee6bbd6-a71b-486b-80c8-e99f433d8803',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','17fb878a-6cbd-4605-8a1b-7d8ca8ffde21','',0),('cf5c254b-d28a-4cce-b6df-c761b465fcc6',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','a60736b7-5b34-4aa9-ae77-e31207d69f80','',0),('d1e1d96f-ded2-4591-b235-1422ea55ad85',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','85dc7116-6c49-4821-a5e4-76cf774dbb92','',0),('d22b92ce-ce61-4a4b-9902-6c6740b53b7b',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','17fb878a-6cbd-4605-8a1b-7d8ca8ffde21','',0),('d2d2a90c-e1f8-4744-b95d-c7d3b702ca3b',1,'797da746-ebd7-4b49-9f6d-aa363adf6333','e02177e4-4b57-47e8-8fce-d684addf9ff5','',0),('d3375103-fb9c-4fea-9946-88108d8b4515',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','ec04f800-1eb6-4c2c-ab2c-e2d835cb8982','',0),('d405000d-d9d3-4805-9883-40182128c0cc',1,'797da746-ebd7-4b49-9f6d-aa363adf6333','a770715e-fdc0-430e-93db-bc513306b815','',0),('d508fa7c-59d8-4e9a-943d-46a5df4c050c',1,'7a9d5b56-1430-4404-a4f0-732da0deeba6','e0c6c287-aca3-49ac-830d-28d5de8f4339','',0),('d67397f4-1ef0-42ec-92c9-605639c44a46',1,'7a9d5b56-1430-4404-a4f0-732da0deeba6','4e2b417e-0a3a-427d-aa82-9b44cf14fd22','',0),('d79b24b0-5921-4315-84db-453b31175355',1,'8d0f9eaf-4a97-4569-a6e9-45dd8ec1ef80','ec04f800-1eb6-4c2c-ab2c-e2d835cb8982','',0),('d7a02e09-7359-4bc1-a0d4-e6b6f97b54fd',1,'8d0f9eaf-4a97-4569-a6e9-45dd8ec1ef80','817ac9c4-31d5-460e-9500-914719aee3b3','',0),('d7f183b0-7d49-4c38-8556-e9de1decf2cd',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','a60736b7-5b34-4aa9-ae77-e31207d69f80','',0),('d7f2a39a-76d6-472e-b0e9-482dc57e88b3',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','17fb878a-6cbd-4605-8a1b-7d8ca8ffde21','',0),('d7f48464-7d9b-4144-9493-c0896cb9673a',1,'3a5ff044-420c-410c-a9e1-e5ddfe922c53','aa5d68c4-ea05-41c0-b426-39cf527fa337','',0),('d93587f0-5c4e-4614-9cae-d56b537598f1',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','2d20ed16-7959-430b-9582-d9161033cadf','',0),('da0ae132-31ed-479f-8f28-c46ea6063a39',1,'3a5ff044-420c-410c-a9e1-e5ddfe922c53','3d7f280c-a0cc-4959-91a4-7a42e2d7e86a','',0),('dbceb2b1-5d4b-4769-a642-e497d13a7358',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','c4f99a41-737b-410e-a0ca-d0a8970ba7ae','',0),('de186570-006e-460b-bbcb-8569902f78ba',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','fc4de6a2-5951-423b-82d2-bf2b84a6f3d0','',0),('e3acb4a1-79da-4581-941d-3fe05613e950',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','a60736b7-5b34-4aa9-ae77-e31207d69f80','',0),('e6bfc9e8-662d-4c37-a6ab-85dedaac4cd3',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','302a98d2-e1a6-488e-b5bc-4589d058e056','',0),('ead0f449-a9f8-4f1b-8a6e-aeec4fdb411f',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','2d1f7f21-4288-405b-9b35-188e668b1ba7','',0),('ecc29fa3-fb74-483d-9fa6-ba6a464f63a0',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','a770715e-fdc0-430e-93db-bc513306b815','',0),('ed255728-4477-4ecd-8a64-7361615ae02f',1,'c09495a7-c517-4a74-9eda-6433c9b681d1','fc4de6a2-5951-423b-82d2-bf2b84a6f3d0','',0),('ee8419a3-1f9a-4672-95b5-8bbca187a837',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','283f284e-9efb-45c9-84fd-5fcbd2293505','',0),('eee04578-59bc-4ab8-ab7a-1fbe1a8e7fb5',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','0bc8361e-ed10-4cfb-b236-30183daa771c','',0),('f0c51cc7-2820-4438-b965-03e824daacc8',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','c47da54f-b8ef-4d61-a5b0-79563bae587c','',0),('f76e25d6-0646-4fd0-9634-f4ed062016f7',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','87ba3d97-3c5e-4ad4-8a49-a4a61606747f','',0),('f7d74cea-bbe8-4295-a673-a23ad84ba7a7',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','e0c6c287-aca3-49ac-830d-28d5de8f4339','',0),('fc728e07-486a-4371-92ac-be62aba4ad9e',1,'8d0f9eaf-4a97-4569-a6e9-45dd8ec1ef80','64e5471b-d868-4f75-8e56-a7f1c76c31f9','',0),('fe16c86c-8fa8-41ef-a838-71598cf1e535',1,'0f00e455-b398-402f-8fc7-8281844d8aac','c4f99a41-737b-410e-a0ca-d0a8970ba7ae','',0);
/*!40000 ALTER TABLE `product_component` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product_cost`
--

LOCK TABLES `product_cost` WRITE;
/*!40000 ALTER TABLE `product_cost` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_cost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product_feature`
--

LOCK TABLES `product_feature` WRITE;
/*!40000 ALTER TABLE `product_feature` DISABLE KEYS */;
INSERT INTO `product_feature` VALUES ('043c499b-0f22-41e6-a258-3b09e2e982fe','EKSKLUSIF','Program','','a770715e-fdc0-430e-93db-bc513306b815',0),('051fb26f-9ef8-4b9b-a92e-d1f027f502b3','REGULER','Program','','4e2b417e-0a3a-427d-aa82-9b44cf14fd22',0),('0b185b17-1b31-4f71-8342-a792a1cbae38','EKSKLUSIF','Program','','c47da54f-b8ef-4d61-a5b0-79563bae587c',0),('1e21b9c7-fbf5-4056-9255-d1f93dd71dff','REGULER','Program','','aa5d68c4-ea05-41c0-b426-39cf527fa337',0),('263b82f0-1fb5-493f-b3cd-fab5cd5586f7','REGULER','Program','','17fb878a-6cbd-4605-8a1b-7d8ca8ffde21',0),('2c4d9431-9b7f-4045-aad0-6e57b0302dda','EKSKLUSIF','Program','','3394c361-d913-4846-b886-46345d1ffb1a',0),('3447add0-ee66-4cd5-b40d-268dca7d7d6a','REGULER','Program','','0bc8361e-ed10-4cfb-b236-30183daa771c',0),('367315b3-145d-4276-aa20-2f555990ccd9','EKSKLUSIF','Program','','2d1f7f21-4288-405b-9b35-188e668b1ba7',0),('393ed2d7-40fd-4ef2-b301-7b3058f6a5e9','REGULER','Program','','fc4de6a2-5951-423b-82d2-bf2b84a6f3d0',0),('3b2d4b34-8b3d-4eda-9bc5-6482b0280894','EKSKLUSIF','Program','','2d20ed16-7959-430b-9582-d9161033cadf',0),('3bc53d56-4fad-4e8c-b014-327042ef4703','REGULER','Program','','64e5471b-d868-4f75-8e56-a7f1c76c31f9',0),('3ce9a5da-2717-47d2-bfc6-45a54fdd8335','EKSKLUSIF','Program','','44965c88-3dfa-4645-b885-1003c53da8af',0),('44b02256-52c4-4842-ae5e-34b0d54f79ce','REGULER','Program','','ec04f800-1eb6-4c2c-ab2c-e2d835cb8982',0),('45ac25bb-37a9-40b8-b5e5-d1813ea28c84','REGULER','Program','','3d7f280c-a0cc-4959-91a4-7a42e2d7e86a',0),('4884c194-5bec-4575-b310-5f6f00e4488a','EKSKLUSIF','Program','','4e2b417e-0a3a-427d-aa82-9b44cf14fd22',0),('4a927e72-2fb4-4db2-9462-157a427ce4f5','EKSKLUSIF','Program','','6f38df8c-f40f-4b92-aba3-ac33873af6c2',0),('51db4c1b-8a21-4d74-9821-a520cb5d86d3','REGULER','Program','','44965c88-3dfa-4645-b885-1003c53da8af',0),('557f0c90-cb32-437c-bcf7-632242622413','REGULER','Program','','c47da54f-b8ef-4d61-a5b0-79563bae587c',0),('6255d582-58ad-4951-b6a7-d4b9979058d7','REGULER','Program','','817ac9c4-31d5-460e-9500-914719aee3b3',0),('63c03f8f-d5ab-44a5-87c5-2ee874aa7743','EKSKLUSIF','Program','','a60736b7-5b34-4aa9-ae77-e31207d69f80',0),('673c119f-9051-4281-abe0-b3c6bd0f25a1','EKSKLUSIF','Program','','c4f99a41-737b-410e-a0ca-d0a8970ba7ae',0),('6888cb76-757a-43bb-b6b4-435727085db9','REGULER','Program','','a770715e-fdc0-430e-93db-bc513306b815',0),('69b94980-2f4b-478a-9d52-72d21cf6c311','EKSKLUSIF','Program','','17fb878a-6cbd-4605-8a1b-7d8ca8ffde21',0),('69d3fe52-ec11-450e-8e63-8a9747a484b7','REGULER','Program','','302a98d2-e1a6-488e-b5bc-4589d058e056',0),('6bc05d2d-25b3-445b-988c-2d5c2c20c427','EKSKLUSIF','Program','','e02177e4-4b57-47e8-8fce-d684addf9ff5',0),('6e97c45e-2e7c-4816-94dd-342469da68f3','REGULER','Program','','2d20ed16-7959-430b-9582-d9161033cadf',0),('80a3e730-15e4-4329-be2e-74dce739e2d4','REGULER','Program','','1967553d-bda0-4a57-b9f5-356adf49c451',0),('86574b07-1dc7-4b53-9088-3d56ee288e0b','EKSKLUSIF','Program','','283f284e-9efb-45c9-84fd-5fcbd2293505',0),('8e0fc923-79c3-4115-8a23-e49c75fcb0d0','REGULER','Program','','e02177e4-4b57-47e8-8fce-d684addf9ff5',0),('8e715111-8c7e-4d53-89c2-fc4060083bfd','EKSKLUSIF','Program','','fc4de6a2-5951-423b-82d2-bf2b84a6f3d0',0),('8f3f42ae-afd2-4185-b3d4-15c372e1bfe8','EKSKLUSIF','Program','','0bc8361e-ed10-4cfb-b236-30183daa771c',0),('938732e0-d8f3-47ee-af2d-d9b4abc962e7','REGULER','Program','','a60736b7-5b34-4aa9-ae77-e31207d69f80',0),('93bbbc61-295c-4a62-a6ee-320bfb1c92a7','EKSKLUSIF','Program','','3d7f280c-a0cc-4959-91a4-7a42e2d7e86a',0),('96385fa3-e2cd-44cc-b89f-a88c54864f5c','EKSKLUSIF','Program','','85dc7116-6c49-4821-a5e4-76cf774dbb92',0),('a06190e3-0ac1-4116-922a-2fd2577307ca','REGULER','Program','','7772edb9-c20a-4cae-af8c-af8eda5226af',0),('a19646c1-1a79-4b78-8d80-7127bb1b8003','EKSKLUSIF','Program','','7772edb9-c20a-4cae-af8c-af8eda5226af',0),('a28d8d7f-76d1-484d-8305-bc4191fd15f0','REGULER','Program','','3394c361-d913-4846-b886-46345d1ffb1a',0),('a6024bf6-cad4-434c-8a65-057389a97731','REGULER','Program','','85dc7116-6c49-4821-a5e4-76cf774dbb92',0),('abe80c5f-70d1-4249-8a65-0bab9f168f18','REGULER','Program','','c4f99a41-737b-410e-a0ca-d0a8970ba7ae',0),('b0f891c2-b6cf-43c1-b51a-9d7a2cdc19d0','EKSKLUSIF','Program','','1967553d-bda0-4a57-b9f5-356adf49c451',0),('bc634a40-eea0-4491-967f-d6b90b271df4','EKSKLUSIF','Program','','64e5471b-d868-4f75-8e56-a7f1c76c31f9',0),('c0bda8a9-2013-477d-84d6-4077cba5e4b7','EKSKLUSIF','Program','','92733f9c-0645-43d4-a244-1c6f50047dc1',0),('c211e6cd-ca5b-4ce3-84f6-c8def13fea3c','REGULER','Program','','283f284e-9efb-45c9-84fd-5fcbd2293505',0),('cc83844d-bd8d-4db8-8ca0-40cdbb82f6cf','EKSKLUSIF','Program','','aa5d68c4-ea05-41c0-b426-39cf527fa337',0),('ccda8048-d4dd-456d-900d-6bedcc916d4c','REGULER','SIZE','','2d1f7f21-4288-405b-9b35-188e668b1ba7',0),('ced46d3e-ad88-47ba-9c4f-a0767ac05c3d','EKSKLUSIF','Program','','87ba3d97-3c5e-4ad4-8a49-a4a61606747f',0),('d0b7283c-2346-4912-8dfa-bbe6d064ea36','EKSKLUSIF','Program','','302a98d2-e1a6-488e-b5bc-4589d058e056',0),('d50d8a83-075c-44b3-82b2-649636c6680f','EKSKLUSIF','Program','','e0c6c287-aca3-49ac-830d-28d5de8f4339',0),('dfc383dc-ac63-48ad-b82b-9f0ad5ee0956','EKSKLUSIF','Program','','ec04f800-1eb6-4c2c-ab2c-e2d835cb8982',0),('dfd0056d-d012-42c3-8903-fc927f87f55e','REGULER','SIZE','','92733f9c-0645-43d4-a244-1c6f50047dc1',0),('e7c5f355-9654-44b6-bb1a-dc6e3cf53893','REGULER','Program','','87ba3d97-3c5e-4ad4-8a49-a4a61606747f',0),('ea372ab8-2f32-49b8-b225-3c2e18b3179b','REGULER','Program','','e0c6c287-aca3-49ac-830d-28d5de8f4339',0),('ebc8f537-d2aa-4186-8e0a-eb8ce94ca391','EKSKLUSIF','Program','','817ac9c4-31d5-460e-9500-914719aee3b3',0),('f3038527-6048-4ae6-8ffb-8b43868a9871','REGULER','Program','','6f38df8c-f40f-4b92-aba3-ac33873af6c2',0);
/*!40000 ALTER TABLE `product_feature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product_price`
--

LOCK TABLES `product_price` WRITE;
/*!40000 ALTER TABLE `product_price` DISABLE KEYS */;
INSERT INTO `product_price` VALUES ('026dd356-17a9-4bac-8eb0-2ca710b0d351','2016-01-01',NULL,4700000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','7772edb9-c20a-4cae-af8c-af8eda5226af','a19646c1-1a79-4b78-8d80-7127bb1b8003','0',0),('0351ff94-99fe-491a-8240-4a81fe05c59c','2016-01-01',NULL,4200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','2d1f7f21-4288-405b-9b35-188e668b1ba7','367315b3-145d-4276-aa20-2f555990ccd9','0',0),('0bd2621c-e138-4324-9f46-266169f820b9','2016-01-01',NULL,4700000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','85dc7116-6c49-4821-a5e4-76cf774dbb92','96385fa3-e2cd-44cc-b89f-a88c54864f5c','0',0),('0bdda2a8-f92b-4fc9-b9c5-9b6f81aacb47','2016-01-01',NULL,5200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','3394c361-d913-4846-b886-46345d1ffb1a','2c4d9431-9b7f-4045-aad0-6e57b0302dda','0',0),('0ccf5364-b62d-4ff1-9685-2d66c38f04b6','2016-01-01',NULL,2800000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','3394c361-d913-4846-b886-46345d1ffb1a','a28d8d7f-76d1-484d-8305-bc4191fd15f0','0',0),('18072182-686e-475e-ae76-c7377c0af664','2009-08-07',NULL,200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'1967553d-bda0-4a57-b9f5-356adf49c451','b0f891c2-b6cf-43c1-b51a-9d7a2cdc19d0','0',0),('183b54e4-8ea8-43d3-abed-b67db8f0282e','2016-01-01',NULL,4200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','aa5d68c4-ea05-41c0-b426-39cf527fa337','cc83844d-bd8d-4db8-8ca0-40cdbb82f6cf','0',0),('18d2dd57-6e5c-4fd8-bde9-64584da7d92d','2016-01-01',NULL,5200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','e02177e4-4b57-47e8-8fce-d684addf9ff5','6bc05d2d-25b3-445b-988c-2d5c2c20c427','0',0),('25448de8-b43c-4f2f-babc-6e53291185d9','2016-01-01',NULL,2800000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','ec04f800-1eb6-4c2c-ab2c-e2d835cb8982','44b02256-52c4-4842-ae5e-34b0d54f79ce','0',0),('29bbb9f1-cf10-4a43-acb5-751a0451b1f4','2016-01-01',NULL,2800000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','6f38df8c-f40f-4b92-aba3-ac33873af6c2','f3038527-6048-4ae6-8ffb-8b43868a9871','0',0),('2ed91c81-71eb-492c-9d8d-5c8090fc5c86','2016-01-01',NULL,3700000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','2d20ed16-7959-430b-9582-d9161033cadf','6e97c45e-2e7c-4816-94dd-342469da68f3','0',0),('329c3d9f-17b3-4ce5-b3dd-59827e4a325a','2016-01-01',NULL,7200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','c4f99a41-737b-410e-a0ca-d0a8970ba7ae','673c119f-9051-4281-abe0-b3c6bd0f25a1','0',0),('344a8048-ee0e-4efe-8343-cdf28cf52b45','2016-01-01',NULL,4200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','4e2b417e-0a3a-427d-aa82-9b44cf14fd22','4884c194-5bec-4575-b310-5f6f00e4488a','0',0),('35a402e7-b2cc-4a91-9bf4-009573b1ac40','2016-01-01',NULL,5200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','44965c88-3dfa-4645-b885-1003c53da8af','3ce9a5da-2717-47d2-bfc6-45a54fdd8335','0',0),('3ac928d8-e2d0-40ca-9167-cccd97e3b3e0','2016-01-01',NULL,2500000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','85dc7116-6c49-4821-a5e4-76cf774dbb92','a6024bf6-cad4-434c-8a65-057389a97731','0',0),('46340d92-2fbb-44b4-aa2a-b931ac09ca15','2016-01-01',NULL,2500000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','c47da54f-b8ef-4d61-a5b0-79563bae587c','557f0c90-cb32-437c-bcf7-632242622413','0',0),('46756792-7dff-46d1-901d-c13ae36f7b03','2016-01-01',NULL,5200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','a770715e-fdc0-430e-93db-bc513306b815','043c499b-0f22-41e6-a258-3b09e2e982fe','0',0),('4869f5fb-dbdb-442a-8e25-6c74ebbe45df','2016-01-01',NULL,2200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','aa5d68c4-ea05-41c0-b426-39cf527fa337','1e21b9c7-fbf5-4056-9255-d1f93dd71dff','0',0),('5502ccae-ce69-47e7-b86c-91ed5987a30b','2016-01-01',NULL,2500000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','0bc8361e-ed10-4cfb-b236-30183daa771c','3447add0-ee66-4cd5-b40d-268dca7d7d6a','0',0),('5a8fac0d-fb6d-46fd-8eec-e2dfe4fe705d','2016-01-01',NULL,2800000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','a60736b7-5b34-4aa9-ae77-e31207d69f80','938732e0-d8f3-47ee-af2d-d9b4abc962e7','0',0),('5eb9d254-1ee9-4195-8a61-1fbcd418c992','2016-01-01',NULL,2800000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','302a98d2-e1a6-488e-b5bc-4589d058e056','69d3fe52-ec11-450e-8e63-8a9747a484b7','0',0),('5f551538-fe3e-4eb2-8249-2c86b267650c','2016-01-01',NULL,2200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','17fb878a-6cbd-4605-8a1b-7d8ca8ffde21','263b82f0-1fb5-493f-b3cd-fab5cd5586f7','0',0),('61820217-91f7-4764-88c0-75bd4d16f06b','2016-01-01',NULL,2800000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','e02177e4-4b57-47e8-8fce-d684addf9ff5','8e0fc923-79c3-4115-8a23-e49c75fcb0d0','0',0),('6729fa04-f187-4501-a456-24380f018165','2016-01-01',NULL,2200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','3d7f280c-a0cc-4959-91a4-7a42e2d7e86a','45ac25bb-37a9-40b8-b5e5-d1813ea28c84','0',0),('67ea6c53-ca26-41e3-99fc-98b026c027d3','2016-01-01',NULL,4200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','283f284e-9efb-45c9-84fd-5fcbd2293505','86574b07-1dc7-4b53-9088-3d56ee288e0b','0',0),('68285ef1-88ce-48fd-88eb-e5b90047829e','2016-01-01',NULL,2800000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','64e5471b-d868-4f75-8e56-a7f1c76c31f9','3bc53d56-4fad-4e8c-b014-327042ef4703','0',0),('707975ec-2ff9-4a22-8180-1d2a28fbf34b','2016-01-01',NULL,5200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','64e5471b-d868-4f75-8e56-a7f1c76c31f9','bc634a40-eea0-4491-967f-d6b90b271df4','0',0),('799b81cb-bb97-4466-9876-cd628a9ebb14','2016-01-01',NULL,5200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','6f38df8c-f40f-4b92-aba3-ac33873af6c2','4a927e72-2fb4-4db2-9462-157a427ce4f5','0',0),('829bd894-59cd-4a92-b7cb-308a8f9a37b2','2016-01-01',NULL,2500000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','92733f9c-0645-43d4-a244-1c6f50047dc1','dfd0056d-d012-42c3-8903-fc927f87f55e','0',0),('83d34189-009d-4d25-a1c6-543786834412','2016-01-01',NULL,2500000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','7772edb9-c20a-4cae-af8c-af8eda5226af','a06190e3-0ac1-4116-922a-2fd2577307ca','0',0),('8a5009c5-f343-480e-b541-510d48aae17a','2016-01-01',NULL,2500000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','e0c6c287-aca3-49ac-830d-28d5de8f4339','ea372ab8-2f32-49b8-b225-3c2e18b3179b','0',0),('904ff6df-b176-4f92-ac9c-83e8403c2ed5','2016-01-01',NULL,4700000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','92733f9c-0645-43d4-a244-1c6f50047dc1','c0bda8a9-2013-477d-84d6-4077cba5e4b7','0',0),('98625a70-cff8-4aba-91d9-eb791e16a4a9','2016-01-01',NULL,4700000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','0bc8361e-ed10-4cfb-b236-30183daa771c','8f3f42ae-afd2-4185-b3d4-15c372e1bfe8','0',0),('a42142d3-2f43-49d4-b872-fd77f1d1922e','2016-01-01',NULL,4200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','3d7f280c-a0cc-4959-91a4-7a42e2d7e86a','93bbbc61-295c-4a62-a6ee-320bfb1c92a7','0',0),('a44a9ae3-f128-43d7-a3e1-2ee2a97e10cb','2016-01-01',NULL,5200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','87ba3d97-3c5e-4ad4-8a49-a4a61606747f','ced46d3e-ad88-47ba-9c4f-a0767ac05c3d','0',0),('a84df69e-8ce7-4ce9-9e68-84e6d2b7b3ca','2016-01-01',NULL,2800000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','87ba3d97-3c5e-4ad4-8a49-a4a61606747f','e7c5f355-9654-44b6-bb1a-dc6e3cf53893','0',0),('a8b0e05b-e599-4b47-a36f-9b9eec1abea4','2016-01-01',NULL,2200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','283f284e-9efb-45c9-84fd-5fcbd2293505','c211e6cd-ca5b-4ce3-84f6-c8def13fea3c','0',0),('b3403263-19d8-4f82-a733-f8e3ea06321d','2016-01-01',NULL,5200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','ec04f800-1eb6-4c2c-ab2c-e2d835cb8982','dfc383dc-ac63-48ad-b82b-9f0ad5ee0956','0',0),('b4e613c2-3e09-4de6-83f4-0fd4eac02bb0','2016-01-01',NULL,4700000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','e0c6c287-aca3-49ac-830d-28d5de8f4339','d50d8a83-075c-44b3-82b2-649636c6680f','0',0),('bc74f6a9-5f10-4716-98b7-6318894d7870','2016-01-01',NULL,4700000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','c47da54f-b8ef-4d61-a5b0-79563bae587c','0b185b17-1b31-4f71-8342-a792a1cbae38','0',0),('c14f201f-05b9-43a9-be4f-0ed5d6a9f64a','2016-01-01',NULL,2800000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','fc4de6a2-5951-423b-82d2-bf2b84a6f3d0','393ed2d7-40fd-4ef2-b301-7b3058f6a5e9','0',0),('c6084421-3cd5-4f96-8c8f-982fd4050ba9','2016-01-01',NULL,2800000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','44965c88-3dfa-4645-b885-1003c53da8af','51db4c1b-8a21-4d74-9821-a520cb5d86d3','0',0),('c8f0cdba-4efb-427f-9758-75ef9b55d795','2016-01-01',NULL,2200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','4e2b417e-0a3a-427d-aa82-9b44cf14fd22','051fb26f-9ef8-4b9b-a92e-d1f027f502b3','0',0),('c99c3f6e-3d23-4492-9a3a-56745f220f30','2016-01-01',NULL,4200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','17fb878a-6cbd-4605-8a1b-7d8ca8ffde21','69b94980-2f4b-478a-9d52-72d21cf6c311','0',0),('ca5e9302-8c1a-49a8-ba62-10316e551cec','2016-01-01',NULL,2200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','2d1f7f21-4288-405b-9b35-188e668b1ba7','ccda8048-d4dd-456d-900d-6bedcc916d4c','0',0),('daf6f611-4578-41c1-ad73-38b8faa3eaa6','2016-01-01',NULL,2800000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','817ac9c4-31d5-460e-9500-914719aee3b3','6255d582-58ad-4951-b6a7-d4b9979058d7','0',0),('df5d8304-b52a-4a57-a6d0-c71c79088ee0','2016-01-01',NULL,7200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','2d20ed16-7959-430b-9582-d9161033cadf','3b2d4b34-8b3d-4eda-9bc5-6482b0280894','0',0),('e1e9e364-50bf-4270-9406-8b7aa6a11ea3','2016-01-01',NULL,3700000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','c4f99a41-737b-410e-a0ca-d0a8970ba7ae','abe80c5f-70d1-4249-8a65-0bab9f168f18','0',0),('e2d8da7e-a1e0-4f5f-890d-ff0c99b55641','2016-01-01',NULL,5200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','fc4de6a2-5951-423b-82d2-bf2b84a6f3d0','8e715111-8c7e-4d53-89c2-fc4060083bfd','0',0),('f6601be8-444f-4a38-ae34-bc4db7f45d31','2016-01-01',NULL,2800000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','a770715e-fdc0-430e-93db-bc513306b815','6888cb76-757a-43bb-b6b4-435727085db9','0',0),('f7428e5e-93fb-4b13-9282-d36612f35e3a','2016-01-01',NULL,5200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','817ac9c4-31d5-460e-9500-914719aee3b3','ebc8f537-d2aa-4186-8e0a-eb8ce94ca391','0',0),('fa534dcb-561e-4f48-ab57-21a8e5d0148f','2009-08-07',NULL,100000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'1967553d-bda0-4a57-b9f5-356adf49c451','80a3e730-15e4-4329-be2e-74dce739e2d4','0',0),('faf1243d-4ec9-48b6-97e8-15731dd5ac77','2016-01-01',NULL,5200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','302a98d2-e1a6-488e-b5bc-4589d058e056','d0b7283c-2346-4912-8dfa-bbe6d064ea36','0',0),('fcef45d2-eb0a-4389-b0a3-e374b911bdcc','2016-01-01',NULL,5200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','a60736b7-5b34-4aa9-ae77-e31207d69f80','63c03f8f-d5ab-44a5-87c5-2ee874aa7743','0',0);
/*!40000 ALTER TABLE `product_price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product_receivable`
--

LOCK TABLES `product_receivable` WRITE;
/*!40000 ALTER TABLE `product_receivable` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_receivable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product_retur`
--

LOCK TABLES `product_retur` WRITE;
/*!40000 ALTER TABLE `product_retur` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_retur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product_retur_item`
--

LOCK TABLES `product_retur_item` WRITE;
/*!40000 ALTER TABLE `product_retur_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_retur_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product_supplier`
--

LOCK TABLES `product_supplier` WRITE;
/*!40000 ALTER TABLE `product_supplier` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `purchase_order`
--

LOCK TABLES `purchase_order` WRITE;
/*!40000 ALTER TABLE `purchase_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `purchase_order_item`
--

LOCK TABLES `purchase_order_item` WRITE;
/*!40000 ALTER TABLE `purchase_order_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `purchase_order_request`
--

LOCK TABLES `purchase_order_request` WRITE;
/*!40000 ALTER TABLE `purchase_order_request` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_order_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `purchase_order_request_item`
--

LOCK TABLES `purchase_order_request_item` WRITE;
/*!40000 ALTER TABLE `purchase_order_request_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_order_request_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `purchase_order_request_review`
--

LOCK TABLES `purchase_order_request_review` WRITE;
/*!40000 ALTER TABLE `purchase_order_request_review` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_order_request_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `purchase_order_request_role`
--

LOCK TABLES `purchase_order_request_role` WRITE;
/*!40000 ALTER TABLE `purchase_order_request_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_order_request_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `purchase_order_request_status`
--

LOCK TABLES `purchase_order_request_status` WRITE;
/*!40000 ALTER TABLE `purchase_order_request_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_order_request_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `receipt`
--

LOCK TABLES `receipt` WRITE;
/*!40000 ALTER TABLE `receipt` DISABLE KEYS */;
/*!40000 ALTER TABLE `receipt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `recurring_payment`
--

LOCK TABLES `recurring_payment` WRITE;
/*!40000 ALTER TABLE `recurring_payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `recurring_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `requirement`
--

LOCK TABLES `requirement` WRITE;
/*!40000 ALTER TABLE `requirement` DISABLE KEYS */;
/*!40000 ALTER TABLE `requirement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `requirement_role`
--

LOCK TABLES `requirement_role` WRITE;
/*!40000 ALTER TABLE `requirement_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `requirement_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
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
-- Dumping data for table `roled`
--

LOCK TABLES `roled` WRITE;
/*!40000 ALTER TABLE `roled` DISABLE KEYS */;
/*!40000 ALTER TABLE `roled` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sequence_number`
--

LOCK TABLES `sequence_number` WRITE;
/*!40000 ALTER TABLE `sequence_number` DISABLE KEYS */;
INSERT INTO `sequence_number` VALUES ('08f642d9-1072-4364-a921-c91df87db1a4','2016-07-08',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','CRS',3,0,0,1),('0f6c1237-c166-4224-9283-50118fe33c56','2016-06-04',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','CRS',5,0,0,3),('15a8b327-002f-409f-a223-b7547c65b06e','2016-05-11',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','CRS',10,0,0,8),('19d23b21-af85-430e-a580-92073635ffc4','2016-09-02',NULL,'980d82f2-aa01-4511-b461-985f5fcbe6a1','CRS',6,0,0,4),('25962de1-229e-452c-8537-b287070d756f','2016-08-07',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',3,0,0,1),('33834a66-f5ba-4388-b9e2-bffd420d95c4','2016-08-18',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','CRS',2,0,0,0),('3bc3deab-1a37-483c-a602-638221adb499','2016-11-02',NULL,'980d82f2-aa01-4511-b461-985f5fcbe6a1','INV',5,0,0,3),('4adf8a6d-7c7a-4894-be12-f0eab6bbdb5e','2016-10-02',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',4,0,0,2),('5448f8b5-472e-4329-bd3d-660594aa1173','2016-08-07',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','SDN',81,2016,7,79),('5f670a4d-2dd4-45d1-9eef-34bf39c57418','2016-11-02',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',4,0,0,2),('637f6cb1-4140-496a-b61b-ca72ae2eca1d','2016-09-02',NULL,'980d82f2-aa01-4511-b461-985f5fcbe6a1','INV',6,0,0,4),('6def02ff-cc03-4d0e-b5b3-fcc2fa4fd78e','2016-06-04',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',6,0,0,4),('74989341-a57f-4a3f-aea3-4f6c50202835','2016-08-28',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','CRS',3,0,0,1),('76ed745f-c4c6-4d81-94e0-529e9c1b57cd','2016-06-18',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',2,0,0,0),('7d1b24aa-0925-4063-ab23-8f41506e088a','2016-07-04',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',2,0,0,0),('7e91abdc-b805-485d-af81-d2fd21f3c321','2016-08-18',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',13,0,0,11),('9650746d-f47d-42c5-99ac-209c836b5150','2016-09-04',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',2,0,0,0),('9792a185-3c61-4cd6-bb50-9398e81ec476','2016-08-07',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','CRS',5,0,0,3),('9988f717-e5fc-4a13-910e-c7f7a7bbdb98','2016-09-02',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',4,0,0,2),('9a88a1a2-b757-4d9a-b68c-0d387372d6fc','2016-08-04',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',2,0,0,0),('9e226682-2be1-4fce-a15d-6cd726be04fc','2016-08-16',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',11,0,0,9),('b03f6c7c-dffa-401b-8065-528aeb5f87d7','2016-08-10',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',5,0,0,3),('ca03ee00-7592-484e-9b68-371c2385e4ba','2016-07-08',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',2,0,0,0),('cb8bf571-fa7e-47f1-8120-a9ccf2bd2b0e','2016-07-22',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',2,0,0,0),('d54385aa-6c37-4a84-ac74-d41adeb6d0f9','2016-08-28',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',2,0,0,0),('e62bc6da-81df-4902-baae-68120561b3c0','2016-09-02',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','CRS',4,0,0,2),('e99c7b70-615b-454c-92c5-e9c45550203c','2016-08-16',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','CRS',6,0,0,4),('ef98cd95-c792-46ff-9840-a82530f67ad6','2016-10-02',NULL,'980d82f2-aa01-4511-b461-985f5fcbe6a1','INV',5,0,0,3),('fddb349d-3c22-4952-ac14-0f5105584058','2016-05-11',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',8,0,0,6);
/*!40000 ALTER TABLE `sequence_number` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `statuses`
--

LOCK TABLES `statuses` WRITE;
/*!40000 ALTER TABLE `statuses` DISABLE KEYS */;
/*!40000 ALTER TABLE `statuses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `stock_adjustment`
--

LOCK TABLES `stock_adjustment` WRITE;
/*!40000 ALTER TABLE `stock_adjustment` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_adjustment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `stock_adjustment_item`
--

LOCK TABLES `stock_adjustment_item` WRITE;
/*!40000 ALTER TABLE `stock_adjustment_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_adjustment_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `stock_admin`
--

LOCK TABLES `stock_admin` WRITE;
/*!40000 ALTER TABLE `stock_admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `stock_opname`
--

LOCK TABLES `stock_opname` WRITE;
/*!40000 ALTER TABLE `stock_opname` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_opname` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `stock_opname_item`
--

LOCK TABLES `stock_opname_item` WRITE;
/*!40000 ALTER TABLE `stock_opname_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_opname_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('013f6fbf-2c6b-4d7a-8b04-2ad181d02bd7','Lisnawati','SMA N 7 Pontianak','Friend'),('09890166-4ccc-41d4-a54c-5a0e5864f6e3','Sri Handayani','MTs N 2 Pontianak','Friend'),('14bd9c3f-7770-4b64-b195-1cf29b60e38a','Juliandry','SMP N 1 Pontianak','Friend'),('19056ce0-9e11-4d7f-a136-54002d343c99','Ari Susnindar, S.T.','SMA Negeri 7','Friend'),('1f85a637-34bd-46cc-b824-0c67154988a9','Suwarno','SD Muhammadiyah 1 Pontianak','Friend'),('206fbce2-5238-443b-9840-c8d98cd1b111','Sri Umi Nasfiyati','SMA N 7 Pontianak','Friend'),('20f5051d-a3c7-447f-97a7-178e033547a9','H. Sulaiman, S.E.','MAN 2 Pontianak','Friend'),('25e3817d-03ac-4c25-873c-589c911191b9','Indra Nauli Lubis','SDS Bawamai Pontianak','Friend'),('27ba0cef-80c1-4dd8-828b-c8a331bd8fe7','Heryadi','SMP N 17 Pontianak','Friend'),('2919f335-3ec9-40c0-bfd2-0dea0a3f465e','Suyatna','SMP N 3 Pontianak','Friend'),('2b21be03-bbbd-454f-a7aa-2cd75a76f2c8','Solha','SMA N 3 Pontianak','Friend'),('36395e06-fc13-4720-9466-ac6ee36099b0','Agus Raya','SMA N 9 Pontianak','Friend'),('3642b32d-8f15-45d9-adb6-3f325f9bb6c2','Uray Harun','SMP N 24 Negeri','Friend'),('3679901a-5145-4240-be19-f6693c9c3217','Hadi Prayitno & Eka Vitriani','SMP N 1 Pontianak','Friend'),('38a2b91d-a6b3-489a-a6cb-05acac001f99','Herry Aca','SMP N 1 Pontianak','Friend'),('3a579716-6a51-4bd5-a667-bdf6a174250f','Sumarseno','SMA Panca Bhakti','Friend'),('3b535b54-dba9-4067-a2a9-1af2e1696f85','Syf. Zaleha Eliza','MTs N 1 Pontianak','Friend'),('40e222c3-db79-436c-b58a-de537f99a0df','Nuryanti Malani','SMP N 10 Pontianak','Friend'),('41826c9d-5160-4912-995c-19a5b3700b45','Supriyadi','SMP N 1 Pontianak','Friend'),('4435f12f-3a1a-45c6-bce7-0db20cd97911','Ramli Salim','SMA N 3 Pontianak','Friend'),('4a79e394-7635-44c8-9aa0-d373e3f71990','Elmania','SMA N 10 Pontianak','Friend'),('51125d9e-8a12-40c1-8519-faad4b8065f2','Zulkarnain, S.Sos.','SMA N 8 Pontianak','Friend'),('518c3838-0f36-402f-9bad-652e93f1533c','Ridwan','MTs Negeri 1 Pontianak','Friend'),('51c3c592-434d-4aea-9c66-e33cefcce8a8','Roni Basuki','MTs Al-Ikhwah Pontianak / SMP N 3','Friend'),('58d04d5d-d3f8-43f8-b98e-09bb8afc4f54','Suherman','SMA N 3 Pontianak','Friend'),('59851383-6691-45c0-8330-10e86ac2342d','Limaisim','SMA N 2 Pontianak','Friend'),('5a6f3da9-5900-46aa-bac3-08ff13e6b0af','Udi Suyudi','SMP N 9 Pontianak','Friend'),('5cd4779d-3fb6-40cb-a532-e543734341d3','Sukandar','SMAN 3 Pontianak','Friend'),('607abfa1-d844-466b-8e1b-99e200e06cba','M. Darmawan','SD Plus Bina 45 Pontianak Timur','Friend'),('67a29453-75e5-427b-88d3-2dccb104f9b2','Edy Soegiono, S.E.','SMA N 2 Pontianak','Friend'),('6cec3c65-b6ff-4094-b90b-4748c634d508','Suwandi','SMA N 6 Pontianak','Friend'),('71ef3dc2-f4f1-48ed-b166-e2fa24fb7601','Suparji','SMP N 3 Pontianak','Friend'),('72301c4d-1c56-4fcd-84e7-c6cf1ff04308','Tri Wigianti','SMA Muhammadiyah 1 Pontianak','Friend'),('72833aed-7a0c-4a09-9049-35f0aab38458','Haris','SDN 6 Pontianak','Friend'),('743b9b7f-9292-407f-aa0d-9305b98becff','Hariyanto','MAN 2 Pontianak','Friend'),('7dd6af66-de94-49ff-ac9b-7dd42a15cb0b','Achmad Faisal','SMA N 7 Pontianak','Friend'),('7dd9fbae-3b38-446e-b2cc-64f1692eb4c0','Sri Margaretha Dayang','SMA N 2 Pontianak','Friend'),('7f4d7f25-a9e0-47f5-b8e3-47d8b492aa39','Tommy Hidayat','MAN 1 Pontianak','Friend'),('81411eb4-901e-47d6-a97d-eb6b2d09c917','Suharti','SMP N 10 Pontianak','Friend'),('81cebf95-2bc8-47ba-b782-84722ae48ab5','Belum Tau','SMP N 17 Pontianak','Friend'),('86cdb736-158a-43a1-97f6-92eb5a507a9b','Devi Herlinda','SMA Muhammadiyah 1 Pontianak','Friend'),('895c6562-c9c5-4b9e-8cd6-f34afa95238c','Selerina','SMA N 7 Pontianak','Friend'),('93d109dd-5451-4823-8cff-b9b1806a1ff8','Andy Hasiyadi','SMU Tunas Bakti','Friend'),('9575be3b-df71-4a73-ad13-91bd9f226ebb','Wiradhad / Erna Medina','SMA N 7 Pontianak','Friend'),('961de37e-d784-4190-9f3d-8b12781c3b4e','Roby Nazarudin, S.H.','SD Muhammadiyah 2 Pontianak','Friend'),('99aab9a3-69ed-4f66-9508-6e6dea71f5e7','Umy Hani','SMA N 2 Pontianak','Friend'),('9c003100-b652-498f-b4aa-4c3077667683','Agus Haryono, S.H.','SMP N 9 Pontianak','Friend'),('a2486b77-c0c8-441e-8ad3-16d213fada1f','Agus Hidayat','SMP N 10 Pontianak','Friend'),('a6d1bcd6-f39b-498b-a888-f3a14d76757c','Lina Rosanti AR','SMA N 2 Pontianak','Friend'),('aa0d0f9e-fa99-4964-a7c8-50837cfc95c4','Indra Nauli Lubis','SMP N 3 Pontianak','Friend'),('acd9ad82-15a8-4460-a437-9cf049aa6fdd','Ulung Alana','SMA N 2 Pontianak','Friend'),('b6e6b30b-1d19-4310-a4fa-27a7cc233f30','Oskandar','SMP N 9 Pontianak','Friend'),('b6e87fe4-9f31-4741-89a0-77530ba60d51','Sri Yanti','SDN 39 Pontianak','Friend'),('b899ae55-9627-4da2-a702-8adb2d908b0c','Heri Sutasno','SMA N 8 Pontianak','Friend'),('bed05b14-62dc-4c93-bc6b-825930e013fc','Debbie Savira Indrayabi','MTs Negeri 2','Friend'),('bf088633-0bdb-4285-976a-6c72652bbf15','Sunaryo','SMA N 6 Pontianak','Friend'),('bf336e36-5de1-43dc-90df-d6691ee37cb6','Nurhainah','MAN 1 Pontianak','Friend'),('c6429b9c-b534-462d-9de2-daf3a26d7782','Ferry Wigisono','SMP N 5 Pontianak','Friend'),('ca5f620c-7715-452c-a9ff-76dd4ec4268f','Belum Tau','SMP N 1 Pontianak','Friend'),('cc0772a2-3380-4f0a-ab00-3b1dd3f13606','Khalifudiansyah','MTs Negeri 1 Pontianak','Friend'),('ced63b0d-655c-4094-ba4c-3a36d11efe1a','Juliandri','SMP N 9 Pontianak','Friend'),('cee4b98e-b0ff-4ccd-b5f3-ab8f2ccc0d44','Supriadi Sino','SMA N 10 Pontianak','Friend'),('d107d701-77ab-46fa-b28b-7ca533b01835','Agus Haryono, S.H.','SMP N 9 Pontianak','Friend'),('d527a974-7114-4887-b2d0-ddb3995da945','Tommy Hidayat','SMP N 23 Pontianak','Friend'),('d5feeaa3-b34d-4495-b529-1e932e953ae0','M. Yusuf','MAN 2 Pontianak','Friend'),('d67d6382-c999-49d9-adc8-1d22214aa367','Bayu Waraswati','SMA N 1 Pontianak','Friend'),('db471402-1f99-403c-bbcc-fc0bc20f58b0','Supriaji','SMP N 1 Pontianak','Friend'),('dfc15c98-8c01-412e-beb0-904170908b5f','Istikharah Noor','MTs Negeri 1 Pontianak','Friend'),('e721b7c8-ab3f-4932-9688-6d2755cbf647','Wiradad / Erna Medina','SMP N 9 Pontianak','Friend'),('ed53f41a-18b9-41e5-a5f5-09de16da9609','Saiful Muslimin & Fitriawati','SMP N 9 Pontianak','Friend'),('f2b8de62-48db-4af6-a587-ce0257528679','Suparji','SMP N 3 Pontianak','Friend'),('f4b3800b-b0d5-4519-b86e-b5775184f4ab','Supriyadi','MTs Negeri 1','Senior'),('f971e4ae-b2eb-4572-ad76-ba60843880fc','Iskandar, S.E.','SMP Negeri 3 Pontianak','Friend');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `student_relationship`
--

LOCK TABLES `student_relationship` WRITE;
/*!40000 ALTER TABLE `student_relationship` DISABLE KEYS */;
INSERT INTO `student_relationship` VALUES ('032be2c3-cc2e-40e3-8b02-e9fdea941293','db471402-1f99-403c-bbcc-fc0bc20f58b0','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('076ce509-80f9-43a5-817f-dec95cc60c91','bf336e36-5de1-43dc-90df-d6691ee37cb6','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('08c4b3fc-4b19-4f1a-8c30-bd56fa568597','cc0772a2-3380-4f0a-ab00-3b1dd3f13606','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('0dbac322-1500-4363-b343-a62d13017a3b','895c6562-c9c5-4b9e-8cd6-f34afa95238c','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('0dff5e0d-4271-46a5-bc99-c553e54bdbff','607abfa1-d844-466b-8e1b-99e200e06cba','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('0f2e07d7-b23a-4716-8b30-636b72823f3f','b899ae55-9627-4da2-a702-8adb2d908b0c','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('135e4c98-33e0-4bf2-944b-de7b70fdcea0','81cebf95-2bc8-47ba-b782-84722ae48ab5','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('139c104e-21c3-42d0-a166-219f0849c3fb','206fbce2-5238-443b-9840-c8d98cd1b111','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('1c54f327-4edb-453f-bb66-d88b32c1a32b','d527a974-7114-4887-b2d0-ddb3995da945','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('1f39020a-3329-4285-b1ad-0c1f193b6070','38a2b91d-a6b3-489a-a6cb-05acac001f99','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('1ff2319f-5daf-412c-81d5-86cd4ee4c7e1','86cdb736-158a-43a1-97f6-92eb5a507a9b','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('23c55f7d-514e-48fe-a253-4ad962e4e8cf','f2b8de62-48db-4af6-a587-ce0257528679','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('28557ce2-861b-4928-b19a-3f2be3be3a8d','ca5f620c-7715-452c-a9ff-76dd4ec4268f','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('2925e2a8-8fb2-41ef-a097-99230aa39ae3','aa0d0f9e-fa99-4964-a7c8-50837cfc95c4','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('2926861b-df52-4312-bfbe-74cb6e48a6f4','bf088633-0bdb-4285-976a-6c72652bbf15','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('2b729014-d894-4d64-82ed-9ce3ea6908e5','d67d6382-c999-49d9-adc8-1d22214aa367','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('2bfc959f-896e-4fe9-8c54-dec324f57108','59851383-6691-45c0-8330-10e86ac2342d','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('30255c60-7b8d-4ac3-843c-ead85edd88e1','5a6f3da9-5900-46aa-bac3-08ff13e6b0af','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('30bd079b-e877-4e72-8c6c-a2b73804596a','19056ce0-9e11-4d7f-a136-54002d343c99','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('310c82dd-78ed-4942-b10e-5509034c7e8c','d107d701-77ab-46fa-b28b-7ca533b01835','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('329e54ac-e836-4686-96aa-c942597606e7','b6e87fe4-9f31-4741-89a0-77530ba60d51','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('34cf8129-bead-4a09-b104-df235436e2fa','cee4b98e-b0ff-4ccd-b5f3-ab8f2ccc0d44','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('34e0bd3e-d7f4-4485-a7a6-36328b1619d9','9575be3b-df71-4a73-ad13-91bd9f226ebb','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('37ea2be0-018e-4099-b8ef-e40856893fa4','67a29453-75e5-427b-88d3-2dccb104f9b2','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('384b5038-10f2-4a19-a6d4-584c3c3f7d29','20f5051d-a3c7-447f-97a7-178e033547a9','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('3a4619fd-3c77-450a-9797-7d08871076a8','961de37e-d784-4190-9f3d-8b12781c3b4e','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('3ef18a42-d035-484a-9aa6-f9fa1258598f','518c3838-0f36-402f-9bad-652e93f1533c','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('42c711be-69e3-49f4-91b7-690a47b284b8','1f85a637-34bd-46cc-b824-0c67154988a9','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('453d166a-07cf-4414-ba22-3f900a43ff4d','f971e4ae-b2eb-4572-ad76-ba60843880fc','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('48a551a0-476d-4512-b664-425de879cbf5','3b535b54-dba9-4067-a2a9-1af2e1696f85','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('4d51d260-8fcc-4bcd-babf-eac8fdf495ae','3642b32d-8f15-45d9-adb6-3f325f9bb6c2','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('52629dee-9f9b-4a8c-b01a-cdb3b76d122b','acd9ad82-15a8-4460-a437-9cf049aa6fdd','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('531b848c-499c-4e6f-ab4a-46cc96e58a04','f68bcc40-325f-4991-ad69-f6c87dd6d09c','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('601daaa4-e8f7-4e32-8adf-7fbd9f1a8dfd','99aab9a3-69ed-4f66-9508-6e6dea71f5e7','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('602ad1b2-57bf-4c0b-adb9-3d4c7c051a71','7f4d7f25-a9e0-47f5-b8e3-47d8b492aa39','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('6472b733-96d7-4de4-ba0d-9bf8e4ffc29e','7dd6af66-de94-49ff-ac9b-7dd42a15cb0b','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('65b6ae84-53c2-4903-839c-c5b5589e3cd5','a6d1bcd6-f39b-498b-a888-f3a14d76757c','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('65de20c0-f5df-46bd-b91e-a8de5b03a53c','b6e6b30b-1d19-4310-a4fa-27a7cc233f30','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('6788c207-ca1e-464d-b9eb-26d33c7a4068','14bd9c3f-7770-4b64-b195-1cf29b60e38a','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('68410bee-958e-4184-95b3-9e4ff71924a6','d5feeaa3-b34d-4495-b529-1e932e953ae0','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('6a19d48c-741b-4740-832f-a5dc80c13e91','72301c4d-1c56-4fcd-84e7-c6cf1ff04308','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('6f484743-b027-43b6-ba12-09e9dded155a','5cd4779d-3fb6-40cb-a532-e543734341d3','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('709f87d5-ade6-41b9-ac4a-cebd75e56b5c','4435f12f-3a1a-45c6-bce7-0db20cd97911','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('710d06f5-4191-4aea-88eb-14a3f53a6a64','93d109dd-5451-4823-8cff-b9b1806a1ff8','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('7fc21295-ab33-4c14-bc49-ddab440c46c3','81411eb4-901e-47d6-a97d-eb6b2d09c917','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('8b67df0e-b5de-46ca-ba28-4693af99881e','3a579716-6a51-4bd5-a667-bdf6a174250f','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('8e716d34-c6aa-406f-9119-227dbb3c4d90','9c003100-b652-498f-b4aa-4c3077667683','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('8f36a40e-83c1-4960-95bb-348fa34658b0','4a79e394-7635-44c8-9aa0-d373e3f71990','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('958a5554-bff8-484a-a30d-1e61c65efbf1','71ef3dc2-f4f1-48ed-b166-e2fa24fb7601','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('a7dd038f-31e2-40a2-b65d-07d43e44c587','7dd9fbae-3b38-446e-b2cc-64f1692eb4c0','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('ac406878-2721-4b1b-bda9-13a1d099960d','bed05b14-62dc-4c93-bc6b-825930e013fc','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('ad3b5b6b-1237-49bb-9a0f-7e08a5b4eb77','ed53f41a-18b9-41e5-a5f5-09de16da9609','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('c18bbd27-c31f-4498-b873-20628f13ce56','27ba0cef-80c1-4dd8-828b-c8a331bd8fe7','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('c2960a06-c18c-44ef-94d6-a6720ab9dc1c','2919f335-3ec9-40c0-bfd2-0dea0a3f465e','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('c2bc1638-71bd-4381-bee4-f18baa7eb5c5','2b21be03-bbbd-454f-a7aa-2cd75a76f2c8','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('c3785077-cbec-4ff1-9000-52bd087abdc2','ced63b0d-655c-4094-ba4c-3a36d11efe1a','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('c39e32af-9b46-4dce-957a-c04ed5f70696','3679901a-5145-4240-be19-f6693c9c3217','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('c74385e6-156f-4065-97ef-7c45a5de504d','013f6fbf-2c6b-4d7a-8b04-2ad181d02bd7','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('c929d858-e4e5-4c5e-92ba-1091e65c836c','dfc15c98-8c01-412e-beb0-904170908b5f','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('ca7ee52a-5bc5-4563-8303-16d590c6f7c0','72833aed-7a0c-4a09-9049-35f0aab38458','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('d30b1768-45bb-41ce-8561-0344d5388aa2','58d04d5d-d3f8-43f8-b98e-09bb8afc4f54','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('d470bf2b-bb5c-41bb-81a1-b93dbe00ba3a','36395e06-fc13-4720-9466-ac6ee36099b0','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('d74a2e88-800b-4cb6-ab5e-1d9ca31e4d7f','40e222c3-db79-436c-b58a-de537f99a0df','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('d98aa4c5-2875-4899-bd1f-407e48c345a2','c6429b9c-b534-462d-9de2-daf3a26d7782','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('dc0d6440-e5ac-40dc-8198-935b0acf5a37','25e3817d-03ac-4c25-873c-589c911191b9','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('dc760901-56e6-4edc-86e6-3157c00fcdf5','6cec3c65-b6ff-4094-b90b-4748c634d508','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('e21ce90b-da25-4be6-81d3-26e6b7a7efd8','e721b7c8-ab3f-4932-9688-6d2755cbf647','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('e65816bf-e384-49a6-a874-01cfc0db40f9','f4b3800b-b0d5-4519-b86e-b5775184f4ab','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('e757012c-967f-4b9f-851a-75792a157a3c','41826c9d-5160-4912-995c-19a5b3700b45','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('f04a6b9a-c638-4cdf-a1f5-09e6f48413bc','743b9b7f-9292-407f-aa0d-9305b98becff','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('f1501be0-3f40-4620-a8c7-20f2e03a1724','a2486b77-c0c8-441e-8ad3-16d213fada1f','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('f6fe4b06-975f-4582-bd8e-fe76cf3fdd0a','09890166-4ccc-41d4-a54c-5a0e5864f6e3','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('fafb7450-1dda-466a-b92d-5f5da89230d1','51125d9e-8a12-40c1-8519-faad4b8065f2','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('fb0e872e-b148-4c31-ae38-f2a3dbe1322a','51c3c592-434d-4aea-9c66-e33cefcce8a8','742fc487-8b9d-41d8-9a0c-b55772bc2c49');
/*!40000 ALTER TABLE `student_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `study_day`
--

LOCK TABLES `study_day` WRITE;
/*!40000 ALTER TABLE `study_day` DISABLE KEYS */;
INSERT INTO `study_day` VALUES ('65732831-20a9-4870-8f5f-32d7e3b71edb','0','1','0','1','0','1','0',0),('c3681331-54b4-46cd-b119-ac0730c28b1c','0','0','1','0','1','0','1',0);
/*!40000 ALTER TABLE `study_day` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `study_period`
--

LOCK TABLES `study_period` WRITE;
/*!40000 ALTER TABLE `study_period` DISABLE KEYS */;
INSERT INTO `study_period` VALUES ('e4c80e40-aaee-4127-9888-5e798aec080e','Tahun Ajaran 2016/2017','',0);
/*!40000 ALTER TABLE `study_period` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `study_room`
--

LOCK TABLES `study_room` WRITE;
/*!40000 ALTER TABLE `study_room` DISABLE KEYS */;
/*!40000 ALTER TABLE `study_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `study_time`
--

LOCK TABLES `study_time` WRITE;
/*!40000 ALTER TABLE `study_time` DISABLE KEYS */;
INSERT INTO `study_time` VALUES ('2dda14a2-c020-42b2-ba43-b663a86f30c5','15:00:00','17:00:00',1),('963b3b08-0dd2-4cba-8ea7-fc4f306748c1','19:10:00','21:10:00',0),('d127c85a-f4fb-4d3b-8f59-81d332ea481b','17:00:00','19:10:00',0);
/*!40000 ALTER TABLE `study_time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `supplier_relationship`
--

LOCK TABLES `supplier_relationship` WRITE;
/*!40000 ALTER TABLE `supplier_relationship` DISABLE KEYS */;
/*!40000 ALTER TABLE `supplier_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tax`
--

LOCK TABLES `tax` WRITE;
/*!40000 ALTER TABLE `tax` DISABLE KEYS */;
INSERT INTO `tax` VALUES ('b685e80a-5257-49c7-9c7d-11b986a49b29','PPN','PPN',NULL,10,'0',0),('d4921463-e9ff-4c8e-b6ff-9a1730688fbb','R-PPN','R-PPN',NULL,0,'1',1);
/*!40000 ALTER TABLE `tax` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `time_entry`
--

LOCK TABLES `time_entry` WRITE;
/*!40000 ALTER TABLE `time_entry` DISABLE KEYS */;
/*!40000 ALTER TABLE `time_entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `timesheet`
--

LOCK TABLES `timesheet` WRITE;
/*!40000 ALTER TABLE `timesheet` DISABLE KEYS */;
/*!40000 ALTER TABLE `timesheet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `transfer_order_request`
--

LOCK TABLES `transfer_order_request` WRITE;
/*!40000 ALTER TABLE `transfer_order_request` DISABLE KEYS */;
/*!40000 ALTER TABLE `transfer_order_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `transfer_order_request_item`
--

LOCK TABLES `transfer_order_request_item` WRITE;
/*!40000 ALTER TABLE `transfer_order_request_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `transfer_order_request_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `treatment`
--

LOCK TABLES `treatment` WRITE;
/*!40000 ALTER TABLE `treatment` DISABLE KEYS */;
/*!40000 ALTER TABLE `treatment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `treatment_item`
--

LOCK TABLES `treatment_item` WRITE;
/*!40000 ALTER TABLE `treatment_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `treatment_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `unit_of_measure`
--

LOCK TABLES `unit_of_measure` WRITE;
/*!40000 ALTER TABLE `unit_of_measure` DISABLE KEYS */;
INSERT INTO `unit_of_measure` VALUES ('002e1b00-f0a8-4313-abf8-dbd3d863b1d8','Month (Work)','Month (Work)','','Time',2),('3744de49-a23d-4280-8f8f-b8a2218ffa2b','Week','Week','','Time',0),('4906be4c-a7c6-4aef-a215-c68cc2a7de77','Mandays','Mandays','','Time',0),('920990f3-1cdd-4062-8d5d-835e47dc957e','Day','Day','','Time',0),('be5ad391-0c12-4c0a-bad5-7ee5254abb56','Hour','Hour','','Time',0),('e1db32dc-f5f5-4b85-8d57-1f278355ba6b','Year','Year','','Time',0);
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
INSERT INTO `user` VALUES ('9173455f-4082-4e84-9188-e1d4c9038a28','DODI','k3A5tVWTVSt+i5GqErq64bVVl9nv3wem89hf1UMZofZQnF8zbqWxYqvP2undku6N','1','8c2cea76-1f03-4dbe-a2d0-31c86fce1c15','0',2),('97dc9715-47eb-45d5-96ba-0a582fabdf3b','admin@belian.com','jIfSsj+ceSsamqTfmru/ZlLSRsjwUijQK4CJqi86fLNWb/nqSv2eY2rRrJxgpdDM','1',NULL,'0',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES ('849138a5-4b4e-41ea-8f24-e4586e7f8ab9','096b0105-de76-492c-9bb0-5e518b46d69c','97dc9715-47eb-45d5-96ba-0a582fabdf3b','1',0),('baf1db9b-44ac-4903-8e53-0d4404e4ee33','096b0105-de76-492c-9bb0-5e518b46d69c','9173455f-4082-4e84-9188-e1d4c9038a28','1',1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_setting`
--

LOCK TABLES `user_setting` WRITE;
/*!40000 ALTER TABLE `user_setting` DISABLE KEYS */;
INSERT INTO `user_setting` VALUES ('8c2cea76-1f03-4dbe-a2d0-31c86fce1c15','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','Pontianak','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','R-PPN','in_ID',25,'POS',1);
/*!40000 ALTER TABLE `user_setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `work_effort`
--

LOCK TABLES `work_effort` WRITE;
/*!40000 ALTER TABLE `work_effort` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_effort` ENABLE KEYS */;
UNLOCK TABLES;

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

-- Dump completed on 2016-09-02 21:23:01
