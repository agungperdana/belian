-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: belian
-- ------------------------------------------------------
-- Server version	5.5.5-10.11.2-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `access_module`
--

DROP TABLE IF EXISTS `access_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `access_module` (
  `id` char(50) NOT NULL,
  `code` varchar(150) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `module_group` char(25) DEFAULT 'GENERAL',
  `is_enabled` char(1) DEFAULT '1',
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `access_module`
--

LOCK TABLES `access_module` WRITE;
/*!40000 ALTER TABLE `access_module` DISABLE KEYS */;
INSERT INTO `access_module` VALUES ('07452775-a048-4071-8798-21dc943fe926','PRODUCT','Product','','INVENTORY','0',0),('0918f728-35b9-4028-940b-a343b16fd464','SALES_INVOICE','Sales Invoice','','FINANCIAL','0',0),('0b503053-31eb-410d-90a6-ec6a9977bc1e','FAMILY_FOLDER','Family Folder','','CLINIC','0',0),('0c586cf4-9bd2-4b93-b24b-d41ceca2aef4','CLINIC_SALES','Clinic Sales','','CLINIC','0',0),('0cd0b486-647b-49b9-85a9-7d2eb44c7a42','TERM_TYPE','Order Term','','SALES','0',1),('1213903a-126f-4a60-8c7e-35c6dbe67927','PRODUCT_REQUIREMENT','Product Requirement','','SALES','0',0),('13989b38-ac2c-47b8-8708-5e27477af18d','BENEFIT_TYPE','Benefit Type','','HR','0',0),('1adc4b8b-ad93-4658-8476-6bb13e2e810d','ORDERS_REQUEST','Purchase Order Request','','PROCUREMENT','0',2),('1cf392fc-4f93-4e38-9709-2beb84434951','DOCTORTYPE','Doctor Type','','CLINIC','0',0),('29ec80f0-0d4c-451c-ae5e-f195c4be1a27','COMPANY_STRUCTURE','Company Structure','','GENERAL','0',0),('2bdc3f95-c5bd-47d9-adce-9e9df1042e2f','BUDGET_APPROVER','Budget Approver','','ACCOUNTING','0',0),('2c0d9a06-cebd-4da2-b520-2e948aae3e53','INVOICE_REPORT','Invoice Report','','FINANCIAL','0',0),('2d7e5641-511d-43fd-a6d6-a482120f8aa5','BUDGET','Budget','','ACCOUNTING','0',0),('314a3f13-a982-4915-a5cb-455eacbc27ae','INBOX','Inbox Message','','SYSTEM','0',0),('322d37f6-a667-481e-bc22-db212d0154ea','EMPYAPP','Employment Application','','HR','0',0),('339d7200-9aa1-43d5-8683-e7118cb52839','STUDENT','Student','','EDUCATION','0',0),('342b0b64-291f-4d12-bdb8-77186895d21d','SALES_REPORT','Sales Report','','SALES','0',0),('355ca995-6bae-4638-bfd4-a9bfeff5eefb','INVOICE_OVERDUE_REPORT','Invoice Over Due Report','','FINANCIAL','0',0),('4500a912-bbad-4590-9abb-d9ec92a311a5','DISCOUNT','Discount Programm','Discount','PAYMENT','0',1),('4939e42f-06b5-4e44-b3ba-4106964f1f68','ACCOUNTINGPERIOD','Accounting Period','','ACCOUNTING','0',0),('4b3bb551-173e-46f5-b1e9-bdd719e3045e','COA','General Chart of Account','','ACCOUNTING','0',0),('4bf39427-b32a-434c-bd71-4d9493ea6eef','STOCK_OPNAME','Stock Opname','','INVENTORY','0',0),('4eb93eb7-2100-49ae-bd96-a39995ed5670','USER','User','Application User Module','SECURITY','1',0),('4eca5501-a650-41d5-87c1-c091391d3608','SALES_ORDER','SALES_ORDER','','SALES','0',0),('532efe0a-05ff-4f94-877d-a7f3f7509569','WORKING_TIMESHEET','Working Timesheet','','PRODUCTION','0',0),('55b7e0fb-a178-478b-a09e-4b753f161aeb','MEDICATION','Medication','','CLINIC','0',0),('56f26094-5f17-4985-bc55-6ce8f66dbc96','WORK_EFFORT','Work Effort','Work Effort','HR','0',0),('5844dc9e-2db6-4074-8103-3861566b042e','PRODUCT_FEATURE','Product Feature','','INVENTORY','0',0),('58621810-2c8f-44ae-b9aa-b1e05ad32743','SUPPLIER','Supplier','','PROCUREMENT','0',0),('5c37296e-ab30-4d07-bba3-342d4c403f48','INVITEM','Inventory Item','','INVENTORY','0',0),('5cdd1545-8fdb-4a79-b2a3-0662ed6fec30','POSITIONTYPERATE','Position Type Rate','','HR','0',0),('5e8c4a66-e46a-4000-ae1c-bf536686b30f','TRN_ORDER_REQ','Transfer Order Request','','INVENTORY','0',0),('5eda5016-f448-42dd-926b-52b10870e29c','STUDY_TIME','Study Time','','EDUCATION','0',0),('627fb961-6cf0-4148-9451-0d1422095eb7','ACKNOWLEDGEMENT','Acknowledgement','','SYSTEM','0',0),('65414caf-3a73-4e3f-9a58-2d70c723b5bc','CURRENCY','Currency','GENERAL','ACCOUNTING','0',1),('6861d3b3-8110-46ed-8a3a-830963597fa7','TAX','Tax','','ACCOUNTING','0',0),('69443009-4a15-4061-b9f0-08c08c8f50aa','JOURNALENTRY','Journal Entry','','ACCOUNTING','0',0),('6cbaf072-6925-46e9-b417-17326f3d8584','EMPLOYMENT','Employment','','HR','0',0),('6e299ade-e10e-4940-ae83-bdf61505ed63','STUDENT_REGISTRATION','Student Registration','','EDUCATION','0',0),('74ad4867-9495-472f-97fc-36bf87895585','COURSE_ATTENDANCE','Course Attendance','EDUCATION','EDUCATION','0',1),('770c420c-f809-43f7-969c-b493f0b4ef48','CASHIER','Cashier','','SALES','0',0),('7bef1d92-0f15-43ef-b59b-5bc3e769d896','UOM','Unit of Measure','','INVENTORY','0',0),('7f17176c-f27a-432c-a106-0d7d87b0afb7','RECEIPT','Receipt','','PAYMENT','0',0),('80aebe74-399c-4273-9145-956a077d3f5d','ACCESS_ROLE','Role','Application Access Role','SECURITY','1',0),('8217c196-16b9-44fb-9662-8323220ee705','ASSET','Asset Management','','ASSET','0',0),('83b19678-9f2f-49f4-ba25-0f31a8dee078','PHARMACY_ORDER','Pharmacy Order','','PHARMACY','0',0),('847a8df6-bc04-4de6-8d7d-28e41c00f422','DOCTOR_APPOINTMENT','Doctor Appointment','','CLINIC','0',0),('855aab16-cb45-41c3-b62c-55185ff77dfc','PHARMACY_SALES','Pharmacy Sales','','PHARMACY','0',0),('88bf4008-c84a-4089-88c6-e9d8f077a196','JOURNALSETTING','Journal Setting','','ACCOUNTING','0',0),('8a05b279-2f80-47b8-a2a7-63fbe96d327e','AUDIT_TRAIL','Audit Trail','','SYSTEM','0',0),('8a8db7c0-a8f6-4314-b45c-c40161275c20','WORK_REQUIREMENT','Work Requirement','Work Requirement','HR','0',0),('8c7e1020-0824-4239-9a4e-46301c80b9cd','PAYMENT_METHOD_TYPE','Payment Method Type','','PAYMENT','0',0),('8f6ec9c8-e9ed-49e1-ab7a-c4a868b8391e','ORGANIZATIONACCOUNT','Organization Account','','ACCOUNTING','0',0),('90195ecb-4674-4614-a429-eebc24ffe773','POSITIONTYPE','Position Type','','HR','0',0),('916b22eb-48fa-4000-b7a2-7fc1d47ced4e','STOCK_ADJUSTMENT','Stock Adjustment','','INVENTORY','0',0),('9178e8cd-4063-4fe9-a060-d2e3ac818ed1','PAYCHECK','Paycheck','','PAYMENT','0',0),('95dd39dd-512e-414e-b95c-0fc251887f98','PRODUCT_CATEGORY','Product Category','','INVENTORY','0',1),('99623cbd-066f-4cc2-b9b3-1961bed131cc','GOODS_TRANSFER','Goods Transfer','','INVENTORY','0',0),('9b9deb26-0960-478c-8cac-4ac475c3ffc3','COURSE_REGISTRATION','Course Registration','','EDUCATION','0',0),('9b9e014c-7a23-40c1-8841-30044564bf7f','MODULE','Module','Application Module','SECURITY','1',0),('9b9e014c-7a23-40c1-8841-30044564bf7x','SYSTEM','System Access','System Access','SYSTEM','1',0),('9df71b1a-0e52-4445-98ea-b9a59ad81ac9','PATIENT','Patient','','CLINIC','0',0),('9e644628-121d-4954-8a66-8002cc866bda','STOCK_ADMIN','Stock Admin','','INVENTORY','0',0),('a4aa9ae0-5166-4d06-afd1-d2eea6f2417c','PERSON','Person Management','','GENERAL','0',0),('a4c43802-436f-407c-8793-323600c181d7','SHIPMENT_RECEIPT','Shipment Receipt','','INVENTORY','0',1),('abfd9a02-3b4b-47a0-9048-a65b6be0b3aa','PRODUCT_RETUR','Product Retur','','INVENTORY','0',0),('affcf2e7-fd2c-4b39-beee-97b5dc5a1405','STUDY_PERIOD','Study Period','','EDUCATION','0',0),('b44420c6-261b-44c5-a23a-7802a0506dab','RECURRING_PAYMENT','Recurring Payment','','PAYMENT','0',0),('b54c8e49-c820-4292-9f74-9e47bd55711f','PURCHASE_ORDER','Purchase Order','','PROCUREMENT','0',1),('b662de02-f4a3-4f1a-819b-5d2aaf6a342b','SHIPMENT_ISSUANCE','Shipment Issuance','','INVENTORY','0',1),('b9935030-f5c1-479e-9ec1-795afc1c1e7e','FACILITY','Facility','','INVENTORY','0',0),('c0f3237c-23c2-49ab-bc9c-e00aa706d7e2','PROFIT_LOSS','Profit Loss Report','','FINANCIAL','0',0),('c79e78d0-3427-440c-b8fe-df126e667a8b','INVOICE_DUEDATE_REPORT','Invoice Due Date Report','','FINANCIAL','0',0),('c8b588b7-d205-4f55-a2ca-e7c759d68efc','SHIPMENT','Shipment','Shipment','INVENTORY','0',0),('d33784ca-abd5-422b-b45a-8c8ee13ddc0a','DEDUCTION_TYPE','Deduction Type','','PAYMENT','0',0),('dbc9175e-eb27-45e9-9e43-a1c12d6354e4','DOCTOR','Doctor','','CLINIC','0',0),('e4307d82-f3fa-4916-9e6b-7a4f894d847e','ORGANIZATION','Organization','','GENERAL','0',0),('e4d249e1-4bd5-4291-9050-62a99f70f64c','CLINIC_REPORT','Clinic Reports','','CLINIC','0',0),('e54e6ba5-7ffd-457b-a23e-8b6285867ba4','STUDY_ROOM','Study Room','','EDUCATION','0',0),('e8f89299-2138-4167-b5b7-52f6ae1667ca','POSITION','Position','','HR','0',0),('e916392a-0b3c-4543-ada7-93054383bb3b','MESSAGE','Message','','SYSTEM','0',0),('ee3c3540-9c62-46df-a79e-f7b636a9ba1d','STUDY_DAY','Study Day','EDUCATION','EDUCATION','0',1),('f50dd16d-0e25-44b6-bd69-c28dfcc55300','GEOGRAPHIC','Geographic','','GENERAL','0',0),('f53b80db-1b89-4779-86e7-b065b5287bbb','ASSET_TYPE','Asset Type','','ASSET','0',0),('fab64cd8-7762-412b-90fb-3d31d5576b45','COURSE_SCHEDULE','Course Schedule','','EDUCATION','0',0),('faeb1349-b68e-4695-9086-aaca794597f6','COUNTRY','Country','','GENERAL','0',0),('fca1cfcf-d199-4729-a321-e1ed01deb0f1','LABS_REGISTRATION','Laboratory Registration','','MEDICALLAB','0',0);
/*!40000 ALTER TABLE `access_module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `access_role`
--

DROP TABLE IF EXISTS `access_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `access_role` (
  `id` char(50) NOT NULL,
  `fk_role` char(50) DEFAULT NULL,
  `fk_module` char(50) DEFAULT NULL,
  `module_code` varchar(100) DEFAULT NULL,
  `module_name` varchar(200) DEFAULT NULL,
  `is_can_read` char(1) DEFAULT '0',
  `is_can_update` char(1) DEFAULT '0',
  `is_can_delete` char(1) DEFAULT '0',
  `is_can_create` char(1) DEFAULT '0',
  `is_can_print` char(1) DEFAULT '0',
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `access_role`
--

LOCK TABLES `access_role` WRITE;
/*!40000 ALTER TABLE `access_role` DISABLE KEYS */;
INSERT INTO `access_role` VALUES ('0043ec31-46d4-4dee-8d88-5212f55cd26c','cecab92d-1762-4eb0-b45b-484e32e99fa3','4500a912-bbad-4590-9abb-d9ec92a311a5',NULL,NULL,'0','0','0','0','0',0),('01f41120-c1d9-4372-8b7e-16e7acb817a3','096b0105-de76-492c-9bb0-5e518b46d69c','56f26094-5f17-4985-bc55-6ce8f66dbc96','WORK_EFFORT','Work Effort','1','1','1','1','1',1),('01f5388b-c63e-4d09-b3b5-dd6456dd0815','096b0105-de76-492c-9bb0-5e518b46d69c','c79e78d0-3427-440c-b8fe-df126e667a8b','INVOICE_DUEDATE_REPORT','Invoice Due Date Report','1','1','1','1','1',1),('025b44ad-7c39-428d-8c96-3815e3d24182','cecab92d-1762-4eb0-b45b-484e32e99fa3','a4aa9ae0-5166-4d06-afd1-d2eea6f2417c',NULL,NULL,'0','0','0','0','0',0),('032967cb-5aa5-44bb-96ae-877098c59420','cecab92d-1762-4eb0-b45b-484e32e99fa3','b44420c6-261b-44c5-a23a-7802a0506dab',NULL,NULL,'0','0','0','0','0',0),('03cd6476-2d67-4f90-b95b-4b81d8a6ea46','cecab92d-1762-4eb0-b45b-484e32e99fa3','e8f89299-2138-4167-b5b7-52f6ae1667ca',NULL,NULL,'0','0','0','0','0',0),('0442dff1-c1dd-45e7-8634-2b9d90904469','096b0105-de76-492c-9bb0-5e518b46d69c','7bef1d92-0f15-43ef-b59b-5bc3e769d896','UOM','Unit of Measure','1','1','1','1','1',0),('060d3480-7c9a-44c7-b572-d7b2c4067359','096b0105-de76-492c-9bb0-5e518b46d69c','916b22eb-48fa-4000-b7a2-7fc1d47ced4e','STOCK_ADJUSTMENT','Stock Adjustment','1','1','1','1','1',0),('0a1a6c1d-e681-48c4-b400-be611a9f70b7','096b0105-de76-492c-9bb0-5e518b46d69c','8a05b279-2f80-47b8-a2a7-63fbe96d327e','AUDIT_TRAIL','Audit Trail','1','1','1','1','1',1),('0e9073d1-2be3-4a8a-9a82-5bd1166757e2','096b0105-de76-492c-9bb0-5e518b46d69c','847a8df6-bc04-4de6-8d7d-28e41c00f422','DOCTOR_APPOINTMENT','Doctor Appointment','1','1','1','1','1',0),('11071b96-65a9-4a7c-b33f-8ddde228d695','cecab92d-1762-4eb0-b45b-484e32e99fa3','1cf392fc-4f93-4e38-9709-2beb84434951',NULL,NULL,'0','0','0','0','0',0),('115145a2-9c2b-47be-a78d-73bf316a00c5','cecab92d-1762-4eb0-b45b-484e32e99fa3','8c7e1020-0824-4239-9a4e-46301c80b9cd',NULL,NULL,'0','0','0','0','0',0),('13bd68bf-9e5f-4270-8680-621e92a3d19a','cecab92d-1762-4eb0-b45b-484e32e99fa3','e4307d82-f3fa-4916-9e6b-7a4f894d847e',NULL,NULL,'0','0','0','0','0',0),('15813a75-16cd-4e8f-a7ef-92ff0cc60781','cecab92d-1762-4eb0-b45b-484e32e99fa3','8a8db7c0-a8f6-4314-b45c-c40161275c20',NULL,NULL,'0','0','0','0','0',0),('178186d0-5376-402d-9b91-01c92c03e7d8','cecab92d-1762-4eb0-b45b-484e32e99fa3','342b0b64-291f-4d12-bdb8-77186895d21d',NULL,NULL,'0','0','0','0','0',0),('1785ddf0-ff6b-4451-91de-619c6ff90b1d','cecab92d-1762-4eb0-b45b-484e32e99fa3','5cdd1545-8fdb-4a79-b2a3-0662ed6fec30',NULL,NULL,'0','0','0','0','0',0),('195dd074-a5e5-4abe-bc9f-5e913229bbb6','096b0105-de76-492c-9bb0-5e518b46d69c','2d7e5641-511d-43fd-a6d6-a482120f8aa5','BUDGET','Budget','1','1','1','1','1',0),('1aa3a48c-ab0c-4949-945e-e9852a9b9a93','096b0105-de76-492c-9bb0-5e518b46d69c','95dd39dd-512e-414e-b95c-0fc251887f98','PRODUCT_CATEGORY','Product Category','1','1','1','1','1',0),('1c60aaee-8072-4b5b-9a85-b71858287b80','cecab92d-1762-4eb0-b45b-484e32e99fa3','99623cbd-066f-4cc2-b9b3-1961bed131cc',NULL,NULL,'0','0','0','0','0',0),('2276523a-e567-4880-935d-d9db9009c0d1','cecab92d-1762-4eb0-b45b-484e32e99fa3','fab64cd8-7762-412b-90fb-3d31d5576b45',NULL,NULL,'0','0','0','0','0',0),('22dbda74-3437-4a1f-a3d1-0dac5edef600','cecab92d-1762-4eb0-b45b-484e32e99fa3','88bf4008-c84a-4089-88c6-e9d8f077a196',NULL,NULL,'0','0','0','0','0',0),('22fbdfec-6afe-4f2f-bd69-ac6a9974ae82','096b0105-de76-492c-9bb0-5e518b46d69c','5c37296e-ab30-4d07-bba3-342d4c403f48','INVITEM','Inventory Item','1','1','1','1','1',0),('23b2e925-f5b7-43b5-aa83-982cab9aa8fd','cecab92d-1762-4eb0-b45b-484e32e99fa3','9b9deb26-0960-478c-8cac-4ac475c3ffc3',NULL,NULL,'0','0','0','0','0',0),('2b8087da-3212-41c5-bc3b-17299456ff52','cecab92d-1762-4eb0-b45b-484e32e99fa3','faeb1349-b68e-4695-9086-aaca794597f6',NULL,NULL,'0','0','0','0','0',0),('2c661c0d-53b6-44c7-85bd-ba04da473be3','096b0105-de76-492c-9bb0-5e518b46d69c','c0f3237c-23c2-49ab-bc9c-e00aa706d7e2','PROFIT_LOSS','Profit Loss Report','1','1','1','1','1',1),('2c8857bc-15c8-4ab7-aecf-08c71225b2c2','cecab92d-1762-4eb0-b45b-484e32e99fa3','fca1cfcf-d199-4729-a321-e1ed01deb0f1',NULL,NULL,'0','0','0','0','0',0),('2d52482a-0a7a-4e49-83c6-9db73e4e051b','096b0105-de76-492c-9bb0-5e518b46d69c','80aebe74-399c-4273-9145-956a077d3f5d','ACCESS_ROLE','Role','1','1','1','1','1',0),('2e2c3346-a54d-4412-95b6-bb20aa338cc7','cecab92d-1762-4eb0-b45b-484e32e99fa3','0918f728-35b9-4028-940b-a343b16fd464',NULL,NULL,'0','0','0','0','0',0),('3202f4e4-fd87-41a8-ae71-fbefce6a2ef4','096b0105-de76-492c-9bb0-5e518b46d69c','b54c8e49-c820-4292-9f74-9e47bd55711f','PURCHASE_ORDER','Purchase Order','1','1','1','1','1',0),('32915e9c-96bf-44b3-881a-2f7c917a4c92','096b0105-de76-492c-9bb0-5e518b46d69c','d33784ca-abd5-422b-b45a-8c8ee13ddc0a','DEDUCTION_TYPE','Deduction Type','1','1','1','1','1',0),('32cc538f-0445-4ec4-9d2e-3084e89062d1','096b0105-de76-492c-9bb0-5e518b46d69c','7f17176c-f27a-432c-a106-0d7d87b0afb7','RECEIPT','Receipt','1','1','1','1','1',1),('331300a2-cc8e-4417-abb3-45dadf814422','096b0105-de76-492c-9bb0-5e518b46d69c','fca1cfcf-d199-4729-a321-e1ed01deb0f1','LABS_REGISTRATION','Laboratory Registration','1','1','1','1','1',0),('37484efd-9cb6-4f79-903f-e7d6687658cc','096b0105-de76-492c-9bb0-5e518b46d69c','6861d3b3-8110-46ed-8a3a-830963597fa7','TAX','Tax','1','1','1','1','1',0),('3a225b38-8dbd-482a-9c14-2f7f1c535068','096b0105-de76-492c-9bb0-5e518b46d69c','88bf4008-c84a-4089-88c6-e9d8f077a196','JOURNALSETTING','Journal Setting','1','1','1','1','1',0),('3c1835ed-0038-432c-83df-7ec783b61860','cecab92d-1762-4eb0-b45b-484e32e99fa3','0c586cf4-9bd2-4b93-b24b-d41ceca2aef4',NULL,NULL,'0','0','0','0','0',0),('403b2cbb-20ea-4bbc-b16d-76e3f1716504','cecab92d-1762-4eb0-b45b-484e32e99fa3','314a3f13-a982-4915-a5cb-455eacbc27ae',NULL,NULL,'1','0','0','0','1',2),('4106810f-37bd-48a1-9bf4-6eedcef7af49','096b0105-de76-492c-9bb0-5e518b46d69c','c8b588b7-d205-4f55-a2ca-e7c759d68efc','SHIPMENT','Shipment','1','1','1','1','1',1),('4571a505-de22-4c81-90ca-775dc1cfdd7f','cecab92d-1762-4eb0-b45b-484e32e99fa3','9b9e014c-7a23-40c1-8841-30044564bf7f',NULL,NULL,'0','0','0','0','0',0),('48817f18-03eb-474d-9157-dd97c9ce4909','cecab92d-1762-4eb0-b45b-484e32e99fa3','c8b588b7-d205-4f55-a2ca-e7c759d68efc',NULL,NULL,'0','0','0','0','0',0),('48c06de3-442f-4125-a438-e370fabade36','096b0105-de76-492c-9bb0-5e518b46d69c','f50dd16d-0e25-44b6-bd69-c28dfcc55300','GEOGRAPHIC','Geographic','1','1','1','1','1',0),('48c4056e-33f6-4082-af20-0139f3e66371','096b0105-de76-492c-9bb0-5e518b46d69c','8217c196-16b9-44fb-9662-8323220ee705','ASSET','Asset Management','1','1','1','1','1',0),('490e4434-7ea2-475e-a66c-ea7296b82c54','096b0105-de76-492c-9bb0-5e518b46d69c','29ec80f0-0d4c-451c-ae5e-f195c4be1a27','COMPANY_STRUCTURE','Company Structure','1','1','1','1','1',0),('4b0ecde0-df93-41b9-862a-bf6e5f839541','cecab92d-1762-4eb0-b45b-484e32e99fa3','90195ecb-4674-4614-a429-eebc24ffe773',NULL,NULL,'0','0','0','0','0',0),('4b15a790-2920-47f2-b805-33ecd48b9bac','096b0105-de76-492c-9bb0-5e518b46d69c','2c0d9a06-cebd-4da2-b520-2e948aae3e53','INVOICE_REPORT','Invoice Report','1','1','1','1','1',1),('4bc3906f-84ef-4f3f-bb2c-99200e0b6a94','cecab92d-1762-4eb0-b45b-484e32e99fa3','c0f3237c-23c2-49ab-bc9c-e00aa706d7e2',NULL,NULL,'0','0','0','0','0',0),('4ffc7d67-b139-49bf-abfa-8b14fde333e8','cecab92d-1762-4eb0-b45b-484e32e99fa3','4eca5501-a650-41d5-87c1-c091391d3608',NULL,NULL,'0','0','0','0','0',0),('4fffeab2-b09c-47fb-92b4-3981da252637','096b0105-de76-492c-9bb0-5e518b46d69c','9e644628-121d-4954-8a66-8002cc866bda','STOCK_ADMIN','Stock Admin','1','1','1','1','1',1),('534836de-b92b-4796-9acf-e93c272f185c','cecab92d-1762-4eb0-b45b-484e32e99fa3','80aebe74-399c-4273-9145-956a077d3f5d',NULL,NULL,'0','0','0','0','0',0),('53c89b57-829c-4cb1-bc3c-6e9f783f5e8f','cecab92d-1762-4eb0-b45b-484e32e99fa3','8a05b279-2f80-47b8-a2a7-63fbe96d327e',NULL,NULL,'1','0','0','0','1',2),('541dd297-fd64-44ae-bcf4-fed612227962','096b0105-de76-492c-9bb0-5e518b46d69c','4b3bb551-173e-46f5-b1e9-bdd719e3045e','COA','General Chart of Account','1','1','1','1','1',0),('56b1e1d1-5a23-4932-9cf4-a5adbb7f08bf','cecab92d-1762-4eb0-b45b-484e32e99fa3','2bdc3f95-c5bd-47d9-adce-9e9df1042e2f',NULL,NULL,'0','0','0','0','0',0),('5899665a-2bf5-4bc0-a249-46643db8f641','cecab92d-1762-4eb0-b45b-484e32e99fa3','55b7e0fb-a178-478b-a09e-4b753f161aeb',NULL,NULL,'0','0','0','0','0',0),('59896828-7d8e-43a9-b8f8-c315fa774a15','096b0105-de76-492c-9bb0-5e518b46d69c','0cd0b486-647b-49b9-85a9-7d2eb44c7a42','TERM_TYPE','Order Term','1','1','1','1','1',1),('59d88282-5a3f-481b-9bb8-91679fbf4d91','096b0105-de76-492c-9bb0-5e518b46d69c','f53b80db-1b89-4779-86e7-b065b5287bbb','ASSET_TYPE','Asset Type','1','1','1','1','1',0),('5a2ce59a-60c2-4203-9d3b-7c5d038fe635','096b0105-de76-492c-9bb0-5e518b46d69c','e916392a-0b3c-4543-ada7-93054383bb3b','MESSAGE','Message','1','1','1','1','1',1),('5c2ddb84-b28c-40f6-81d5-351e0ea1037d','096b0105-de76-492c-9bb0-5e518b46d69c','627fb961-6cf0-4148-9451-0d1422095eb7','ACKNOWLEDGEMENT','Acknowledgement','1','1','1','1','1',1),('5c9ab463-dc50-47a5-a601-f074734adf3c','096b0105-de76-492c-9bb0-5e518b46d69c','abfd9a02-3b4b-47a0-9048-a65b6be0b3aa','PRODUCT_RETUR','Product Retur','1','1','1','1','1',1),('5f92972d-0be6-47df-9fef-571ead1a4b33','cecab92d-1762-4eb0-b45b-484e32e99fa3','e54e6ba5-7ffd-457b-a23e-8b6285867ba4',NULL,NULL,'0','0','0','0','0',0),('6179118a-ff80-452a-a89d-8e0154725095','096b0105-de76-492c-9bb0-5e518b46d69c','b662de02-f4a3-4f1a-819b-5d2aaf6a342b','SHIPMENT_ISSUANCE','Shipment Issuance','1','1','1','1','1',0),('62d1ce88-a8f0-4b77-9a0e-cfa5314a8599','cecab92d-1762-4eb0-b45b-484e32e99fa3','07452775-a048-4071-8798-21dc943fe926',NULL,NULL,'0','0','0','0','0',0),('63101df7-be22-4b53-bba5-f6ad0b3d58cb','cecab92d-1762-4eb0-b45b-484e32e99fa3','c79e78d0-3427-440c-b8fe-df126e667a8b',NULL,NULL,'0','0','0','0','0',0),('6416ea67-8c7b-477e-811f-c5e4e45ca9c0','096b0105-de76-492c-9bb0-5e518b46d69c','99623cbd-066f-4cc2-b9b3-1961bed131cc','GOODS_TRANSFER','Goods Transfer','1','1','1','1','1',0),('641e5498-7f09-4cd7-ae01-1bb2ee6f90a6','cecab92d-1762-4eb0-b45b-484e32e99fa3','2c0d9a06-cebd-4da2-b520-2e948aae3e53',NULL,NULL,'0','0','0','0','0',0),('64a1ea08-9b16-4ad7-8597-1132af964f3c','096b0105-de76-492c-9bb0-5e518b46d69c','0918f728-35b9-4028-940b-a343b16fd464','SALES_INVOICE','Sales Invoice','1','1','1','1','1',1),('6655f91e-4928-4c6f-b83a-f43b28f04454','096b0105-de76-492c-9bb0-5e518b46d69c','770c420c-f809-43f7-969c-b493f0b4ef48','CASHIER','Cashier','1','1','1','1','1',0),('66ecfe3f-9d94-4891-a7ae-fdda3e9b0359','cecab92d-1762-4eb0-b45b-484e32e99fa3','4939e42f-06b5-4e44-b3ba-4106964f1f68',NULL,NULL,'0','0','0','0','0',0),('6a302991-e66a-4ebe-9e6b-90b80d10825a','cecab92d-1762-4eb0-b45b-484e32e99fa3','770c420c-f809-43f7-969c-b493f0b4ef48',NULL,NULL,'0','0','0','0','0',0),('6adcd07b-62da-4e75-a076-80520a58eb32','096b0105-de76-492c-9bb0-5e518b46d69c','5cdd1545-8fdb-4a79-b2a3-0662ed6fec30','POSITIONTYPERATE','Position Type Rate','1','1','1','1','1',0),('6b8c5725-0430-4ad3-a02b-6b88db94c588','cecab92d-1762-4eb0-b45b-484e32e99fa3','339d7200-9aa1-43d5-8683-e7118cb52839',NULL,NULL,'0','0','0','0','0',0),('6ce486a9-e346-432b-ac3f-1a1860e25594','cecab92d-1762-4eb0-b45b-484e32e99fa3','d33784ca-abd5-422b-b45a-8c8ee13ddc0a',NULL,NULL,'0','0','0','0','0',0),('6e516bc7-d8c9-4657-ad29-cdb7baf02e35','cecab92d-1762-4eb0-b45b-484e32e99fa3','e916392a-0b3c-4543-ada7-93054383bb3b',NULL,NULL,'1','0','0','0','1',2),('6ed261e4-7608-49cd-9953-a04e3ff8dfed','096b0105-de76-492c-9bb0-5e518b46d69c','affcf2e7-fd2c-4b39-beee-97b5dc5a1405','STUDY_PERIOD','Study Period','1','1','1','1','1',1),('70b7f0f5-7045-4ca5-86d9-5e05388fc194','cecab92d-1762-4eb0-b45b-484e32e99fa3','5844dc9e-2db6-4074-8103-3861566b042e',NULL,NULL,'0','0','0','0','0',0),('711417b0-a5ea-4c2e-8ab3-e5a96576b45b','096b0105-de76-492c-9bb0-5e518b46d69c','8f6ec9c8-e9ed-49e1-ab7a-c4a868b8391e','ORGANIZATIONACCOUNT','Organization Account','1','1','1','1','1',0),('71479847-69f5-43fa-b7ce-00af42c28d4a','096b0105-de76-492c-9bb0-5e518b46d69c','339d7200-9aa1-43d5-8683-e7118cb52839','STUDENT','Student','1','1','1','1','1',1),('71b9f928-ac18-4a43-9341-73e52e432b60','cecab92d-1762-4eb0-b45b-484e32e99fa3','0cd0b486-647b-49b9-85a9-7d2eb44c7a42',NULL,NULL,'0','0','0','0','0',0),('724b174d-96ec-4152-a42c-2d03097b9aa9','096b0105-de76-492c-9bb0-5e518b46d69c','342b0b64-291f-4d12-bdb8-77186895d21d','SALES_REPORT','Sales Report','1','1','1','1','1',0),('73ea355d-9bef-4358-b370-4576fa398aec','cecab92d-1762-4eb0-b45b-484e32e99fa3','8f6ec9c8-e9ed-49e1-ab7a-c4a868b8391e',NULL,NULL,'0','0','0','0','0',0),('745a6c00-725c-4ec4-8930-e02e4553696e','cecab92d-1762-4eb0-b45b-484e32e99fa3','f53b80db-1b89-4779-86e7-b065b5287bbb',NULL,NULL,'0','0','0','0','0',0),('776edbb0-8c17-4121-b9cb-3dc35997ce92','cecab92d-1762-4eb0-b45b-484e32e99fa3','56f26094-5f17-4985-bc55-6ce8f66dbc96',NULL,NULL,'0','0','0','0','0',0),('78b1a078-373f-417f-9e60-1938c899995c','cecab92d-1762-4eb0-b45b-484e32e99fa3','5eda5016-f448-42dd-926b-52b10870e29c',NULL,NULL,'0','0','0','0','0',0),('79450f94-0cbf-4c0d-ad76-3362a4abe180','096b0105-de76-492c-9bb0-5e518b46d69c','4eca5501-a650-41d5-87c1-c091391d3608','SALES_ORDER','SALES_ORDER','1','1','1','1','1',0),('7c7f84ba-7080-40b6-9f32-df7b6f39452c','cecab92d-1762-4eb0-b45b-484e32e99fa3','9df71b1a-0e52-4445-98ea-b9a59ad81ac9',NULL,NULL,'0','0','0','0','0',0),('7d026611-2dbd-4f37-8df7-7f4cecac13ec','cecab92d-1762-4eb0-b45b-484e32e99fa3','916b22eb-48fa-4000-b7a2-7fc1d47ced4e',NULL,NULL,'0','0','0','0','0',0),('7eeba1cc-d68e-4e23-a931-bd512f98ce81','cecab92d-1762-4eb0-b45b-484e32e99fa3','ee3c3540-9c62-46df-a79e-f7b636a9ba1d',NULL,NULL,'0','0','0','0','0',0),('7f861ab6-1a52-4b30-bd29-a8609e8c5e5b','cecab92d-1762-4eb0-b45b-484e32e99fa3','9b9e014c-7a23-40c1-8841-30044564bf7x',NULL,NULL,'1','0','0','0','1',2),('8295829f-8ca5-45aa-8e97-de0af2550048','cecab92d-1762-4eb0-b45b-484e32e99fa3','5e8c4a66-e46a-4000-ae1c-bf536686b30f',NULL,NULL,'0','0','0','0','0',0),('8617eee1-de5c-4122-b5a9-7d936bd34554','cecab92d-1762-4eb0-b45b-484e32e99fa3','9e644628-121d-4954-8a66-8002cc866bda',NULL,NULL,'0','0','0','0','0',0),('86971eb8-fc85-4c3f-8066-f5a0ff397806','cecab92d-1762-4eb0-b45b-484e32e99fa3','affcf2e7-fd2c-4b39-beee-97b5dc5a1405',NULL,NULL,'0','0','0','0','0',0),('87f3c6fe-0ba0-4761-8198-2266bb7c03aa','cecab92d-1762-4eb0-b45b-484e32e99fa3','1adc4b8b-ad93-4658-8476-6bb13e2e810d',NULL,NULL,'0','0','0','0','0',0),('89c3b455-3c46-4bc4-9a13-77c171e129b6','096b0105-de76-492c-9bb0-5e518b46d69c','a4c43802-436f-407c-8793-323600c181d7','SHIPMENT_RECEIPT','Shipment Receipt','1','1','1','1','1',0),('8c6f9ab1-f804-45c2-8504-9d9cc9d3199c','096b0105-de76-492c-9bb0-5e518b46d69c','532efe0a-05ff-4f94-877d-a7f3f7509569','WORKING_TIMESHEET','Working Timesheet','1','1','1','1','1',1),('8d131962-9833-4dc5-8235-0c4d920dab41','cecab92d-1762-4eb0-b45b-484e32e99fa3','855aab16-cb45-41c3-b62c-55185ff77dfc',NULL,NULL,'0','0','0','0','0',0),('8e4419be-5f68-4f46-ac6d-99bc45541173','cecab92d-1762-4eb0-b45b-484e32e99fa3','74ad4867-9495-472f-97fc-36bf87895585',NULL,NULL,'0','0','0','0','0',0),('8fc78447-1fee-4e90-88be-a0eea402feea','cecab92d-1762-4eb0-b45b-484e32e99fa3','9178e8cd-4063-4fe9-a060-d2e3ac818ed1',NULL,NULL,'0','0','0','0','0',0),('923b7b67-a1e4-478a-9769-e2ee32b685b1','096b0105-de76-492c-9bb0-5e518b46d69c','ee3c3540-9c62-46df-a79e-f7b636a9ba1d','STUDY_DAY','Study Day','1','1','1','1','1',1),('94863d4d-7d07-41d2-bc78-4f65260776d6','096b0105-de76-492c-9bb0-5e518b46d69c','13989b38-ac2c-47b8-8708-5e27477af18d','BENEFIT_TYPE','Benefit Type','1','1','1','1','1',0),('96318b3e-baf7-479b-ab07-d0798114d3bd','096b0105-de76-492c-9bb0-5e518b46d69c','e54e6ba5-7ffd-457b-a23e-8b6285867ba4','STUDY_ROOM','Study Room','1','1','1','1','1',1),('9659ee34-7845-4078-89bd-9ee9b9e37b78','096b0105-de76-492c-9bb0-5e518b46d69c','855aab16-cb45-41c3-b62c-55185ff77dfc','PHARMACY_SALES','Pharmacy Sales','1','1','1','1','1',1),('9728b76b-eac0-44c4-9ba9-afca669e0a76','096b0105-de76-492c-9bb0-5e518b46d69c','e8f89299-2138-4167-b5b7-52f6ae1667ca','POSITION','Position','1','1','1','1','1',0),('9b476230-013c-4e00-9ca9-bf7b5bd66478','cecab92d-1762-4eb0-b45b-484e32e99fa3','58621810-2c8f-44ae-b9aa-b1e05ad32743',NULL,NULL,'0','0','0','0','0',0),('9f52d7a0-217e-4084-9bb3-78c5c81dd536','096b0105-de76-492c-9bb0-5e518b46d69c','07452775-a048-4071-8798-21dc943fe926','PRODUCT','Product','1','1','1','1','1',0),('9fa511a1-e704-4018-a90a-57acea0ac5da','096b0105-de76-492c-9bb0-5e518b46d69c','1adc4b8b-ad93-4658-8476-6bb13e2e810d','ORDERS_REQUEST','Purchase Order Request','1','1','1','1','1',0),('a055f787-df6a-4c93-af22-12797bf5ec39','096b0105-de76-492c-9bb0-5e518b46d69c','69443009-4a15-4061-b9f0-08c08c8f50aa','JOURNALENTRY','Journal Entry','1','1','1','1','1',0),('a19d3eed-e7cb-4389-9e7b-1b6b0cfad032','cecab92d-1762-4eb0-b45b-484e32e99fa3','dbc9175e-eb27-45e9-9e43-a1c12d6354e4',NULL,NULL,'0','0','0','0','0',0),('a2d02360-afb3-4de3-843e-f2b0821ee293','cecab92d-1762-4eb0-b45b-484e32e99fa3','2d7e5641-511d-43fd-a6d6-a482120f8aa5',NULL,NULL,'0','0','0','0','0',0),('a3e8ba06-d955-4929-bd36-f658f3796b6c','096b0105-de76-492c-9bb0-5e518b46d69c','a4aa9ae0-5166-4d06-afd1-d2eea6f2417c','PERSON','Person Management','1','1','1','1','1',0),('a3ef8fbd-46f9-43db-ab47-31d062c3fb20','096b0105-de76-492c-9bb0-5e518b46d69c','74ad4867-9495-472f-97fc-36bf87895585','COURSE_ATTENDANCE','Course Attendance','1','1','1','1','1',1),('a41031e7-e779-40cd-8e6e-ef496cfdc366','cecab92d-1762-4eb0-b45b-484e32e99fa3','b9935030-f5c1-479e-9ec1-795afc1c1e7e',NULL,NULL,'0','0','0','0','0',0),('a658bb8f-a9f3-4eba-a64a-a23ccb1e03b0','cecab92d-1762-4eb0-b45b-484e32e99fa3','29ec80f0-0d4c-451c-ae5e-f195c4be1a27',NULL,NULL,'0','0','0','0','0',0),('a7951344-6b9e-438f-af5c-7b94dee26b2d','096b0105-de76-492c-9bb0-5e518b46d69c','83b19678-9f2f-49f4-ba25-0f31a8dee078','PHARMACY_ORDER','Pharmacy Order','1','1','1','1','1',1),('a8a90cc0-470f-456c-879b-77c0ed469dd7','096b0105-de76-492c-9bb0-5e518b46d69c','9df71b1a-0e52-4445-98ea-b9a59ad81ac9','PATIENT','Patient','1','1','1','1','1',0),('a91848d3-83d1-485a-9846-c83ff3699ac2','096b0105-de76-492c-9bb0-5e518b46d69c','322d37f6-a667-481e-bc22-db212d0154ea','EMPYAPP','Employment Application','1','1','1','1','1',0),('a99016f0-9078-472b-928d-2ceaf0be627a','cecab92d-1762-4eb0-b45b-484e32e99fa3','95dd39dd-512e-414e-b95c-0fc251887f98',NULL,NULL,'0','0','0','0','0',0),('abea8c4e-8d38-4a46-b4f0-2401343cc8a5','cecab92d-1762-4eb0-b45b-484e32e99fa3','e4d249e1-4bd5-4291-9050-62a99f70f64c',NULL,NULL,'0','0','0','0','0',0),('abecab92-51cb-4ca9-88a0-9446c1bc5ae3','096b0105-de76-492c-9bb0-5e518b46d69c','4eb93eb7-2100-49ae-bd96-a39995ed5670','USER','User','1','1','1','1','1',0),('ac144c04-22c4-47fb-8fd4-3783a4f29a90','096b0105-de76-492c-9bb0-5e518b46d69c','1cf392fc-4f93-4e38-9709-2beb84434951','DOCTORTYPE','Doctor Type','1','1','1','1','1',0),('ad389302-f250-4270-a937-75cf984c2f80','096b0105-de76-492c-9bb0-5e518b46d69c','2bdc3f95-c5bd-47d9-adce-9e9df1042e2f','BUDGET_APPROVER','Budget Approver','1','1','1','1','1',1),('af724352-26da-43a3-ae25-43f322bece19','cecab92d-1762-4eb0-b45b-484e32e99fa3','a4c43802-436f-407c-8793-323600c181d7',NULL,NULL,'0','0','0','0','0',0),('afe0e208-aaf2-45c0-9399-6b6526840ec1','cecab92d-1762-4eb0-b45b-484e32e99fa3','7f17176c-f27a-432c-a106-0d7d87b0afb7',NULL,NULL,'0','0','0','0','0',0),('b31dbbf6-6b74-4aa9-9db4-6ebd3888ef91','096b0105-de76-492c-9bb0-5e518b46d69c','355ca995-6bae-4638-bfd4-a9bfeff5eefb','INVOICE_OVERDUE_REPORT','Invoice Over Due Report','1','1','1','1','1',1),('b3739e51-6293-498a-bfa5-4c032b88fd3d','cecab92d-1762-4eb0-b45b-484e32e99fa3','65414caf-3a73-4e3f-9a58-2d70c723b5bc',NULL,NULL,'0','0','0','0','0',0),('b457fa72-9509-4497-97ae-19865cce0487','cecab92d-1762-4eb0-b45b-484e32e99fa3','4eb93eb7-2100-49ae-bd96-a39995ed5670',NULL,NULL,'0','0','0','0','0',0),('b4f04a2c-d9a4-4b30-b75b-4572685e35a8','096b0105-de76-492c-9bb0-5e518b46d69c','9178e8cd-4063-4fe9-a060-d2e3ac818ed1','PAYCHECK','Paycheck','1','1','1','1','1',0),('b7e387f5-ab32-4894-aba3-15e91e95a477','cecab92d-1762-4eb0-b45b-484e32e99fa3','69443009-4a15-4061-b9f0-08c08c8f50aa',NULL,NULL,'0','0','0','0','0',0),('b8bcfde1-100d-416b-b8e1-baac42d8b3e8','cecab92d-1762-4eb0-b45b-484e32e99fa3','13989b38-ac2c-47b8-8708-5e27477af18d',NULL,NULL,'0','0','0','0','0',0),('b93973c4-88cb-4edd-84f1-2b28c63ec8ad','cecab92d-1762-4eb0-b45b-484e32e99fa3','5c37296e-ab30-4d07-bba3-342d4c403f48',NULL,NULL,'0','0','0','0','0',0),('b9cf782f-29cf-491f-8956-b066dd4f1a40','096b0105-de76-492c-9bb0-5e518b46d69c','1213903a-126f-4a60-8c7e-35c6dbe67927','PRODUCT_REQUIREMENT','Product Requirement','1','1','1','1','1',1),('b9e3cb9e-bc2b-47de-968e-2fd696da5014','cecab92d-1762-4eb0-b45b-484e32e99fa3','b54c8e49-c820-4292-9f74-9e47bd55711f',NULL,NULL,'0','0','0','0','0',0),('bd997bd7-73d9-4a60-88cd-7e2271a7eef1','cecab92d-1762-4eb0-b45b-484e32e99fa3','f50dd16d-0e25-44b6-bd69-c28dfcc55300',NULL,NULL,'0','0','0','0','0',0),('bf839209-25d9-4ea7-8e4a-d771f7599e2e','096b0105-de76-492c-9bb0-5e518b46d69c','6cbaf072-6925-46e9-b417-17326f3d8584','EMPLOYMENT','Employment','1','1','1','1','1',0),('c0ea0111-01b2-49d4-9cf0-f047e0051860','096b0105-de76-492c-9bb0-5e518b46d69c','faeb1349-b68e-4695-9086-aaca794597f6','COUNTRY','Country','1','1','1','1','1',1),('c15f6072-7e86-48ab-9069-3ae077493f5f','cecab92d-1762-4eb0-b45b-484e32e99fa3','322d37f6-a667-481e-bc22-db212d0154ea',NULL,NULL,'0','0','0','0','0',0),('c2679569-2f15-4f50-8a5a-febbac3ec646','cecab92d-1762-4eb0-b45b-484e32e99fa3','847a8df6-bc04-4de6-8d7d-28e41c00f422',NULL,NULL,'0','0','0','0','0',0),('c2d02e3b-7b8a-47b4-bb08-30f37f9505fc','096b0105-de76-492c-9bb0-5e518b46d69c','9b9deb26-0960-478c-8cac-4ac475c3ffc3','COURSE_REGISTRATION','Course Registration','1','1','1','1','1',1),('c3ae49cc-98cb-4e81-a518-b46d08cbcf54','cecab92d-1762-4eb0-b45b-484e32e99fa3','4b3bb551-173e-46f5-b1e9-bdd719e3045e',NULL,NULL,'0','0','0','0','0',0),('c5c35685-920c-4f1e-bec3-6926cb19dbf2','cecab92d-1762-4eb0-b45b-484e32e99fa3','355ca995-6bae-4638-bfd4-a9bfeff5eefb',NULL,NULL,'0','0','0','0','0',0),('c655e02a-f2a3-4132-8bd7-9428cc1ce3af','096b0105-de76-492c-9bb0-5e518b46d69c','0b503053-31eb-410d-90a6-ec6a9977bc1e','FAMILY_FOLDER','Family Folder','1','1','1','1','1',0),('c836928e-da88-414e-b572-db436cc948a4','096b0105-de76-492c-9bb0-5e518b46d69c','4939e42f-06b5-4e44-b3ba-4106964f1f68','ACCOUNTINGPERIOD','Accounting Period','1','1','1','1','1',0),('c9681985-0b2a-4537-822b-8f477bc15104','096b0105-de76-492c-9bb0-5e518b46d69c','65414caf-3a73-4e3f-9a58-2d70c723b5bc','CURRENCY','Currency','1','1','1','1','1',0),('ce7241d6-dd5f-4f8e-b4b7-5ed8658120b1','cecab92d-1762-4eb0-b45b-484e32e99fa3','7bef1d92-0f15-43ef-b59b-5bc3e769d896',NULL,NULL,'0','0','0','0','0',0),('ce77f072-7ad1-4cb5-9e9e-0d9b89a853bd','096b0105-de76-492c-9bb0-5e518b46d69c','314a3f13-a982-4915-a5cb-455eacbc27ae','INBOX','Inbox Message','1','1','1','1','1',1),('cf021b8c-61cc-49ac-b0f1-a2721e66cf5e','cecab92d-1762-4eb0-b45b-484e32e99fa3','0b503053-31eb-410d-90a6-ec6a9977bc1e',NULL,NULL,'0','0','0','0','0',0),('cf2437ad-5e59-4f7a-8190-f537beabc623','096b0105-de76-492c-9bb0-5e518b46d69c','58621810-2c8f-44ae-b9aa-b1e05ad32743','SUPPLIER','Supplier','1','1','1','1','1',1),('cff3c8ef-bd79-4d32-be37-b4a2e7dab027','096b0105-de76-492c-9bb0-5e518b46d69c','90195ecb-4674-4614-a429-eebc24ffe773','POSITIONTYPE','Position Type','1','1','1','1','1',0),('d11fbe57-0eac-4f6f-bc22-14a0ed221733','096b0105-de76-492c-9bb0-5e518b46d69c','fab64cd8-7762-412b-90fb-3d31d5576b45','COURSE_SCHEDULE','Course Schedule','1','1','1','1','1',1),('d6d952f8-33c2-4ed0-a371-a846572f573e','cecab92d-1762-4eb0-b45b-484e32e99fa3','4bf39427-b32a-434c-bd71-4d9493ea6eef',NULL,NULL,'0','0','0','0','0',0),('d8a71d8e-344a-4c18-88ff-9ca2cffed715','096b0105-de76-492c-9bb0-5e518b46d69c','b9935030-f5c1-479e-9ec1-795afc1c1e7e','FACILITY','Facility','1','1','1','1','1',0),('de2ab421-31cd-45b7-b6d7-5baf50797f2c','096b0105-de76-492c-9bb0-5e518b46d69c','6e299ade-e10e-4940-ae83-bdf61505ed63','STUDENT_REGISTRATION','Student Registration','1','1','1','1','1',1),('df2207bf-ec0b-44f2-b020-edb3e35edeba','cecab92d-1762-4eb0-b45b-484e32e99fa3','b662de02-f4a3-4f1a-819b-5d2aaf6a342b',NULL,NULL,'0','0','0','0','0',0),('e1ae7cc5-aab3-4271-a744-9d17fca44e9c','096b0105-de76-492c-9bb0-5e518b46d69c','9b9e014c-7a23-40c1-8841-30044564bf7f','MODULE','Module','1','1','1','1','1',0),('e1ae7cc5-aab3-4271-a744-9d17fca44e9x','096b0105-de76-492c-9bb0-5e518b46d69c','9b9e014c-7a23-40c1-8841-30044564bf7x','SYSTEM','System Access','1','1','1','1','1',0),('e51c5ad1-38c7-4699-9c92-50f070f7a7f3','096b0105-de76-492c-9bb0-5e518b46d69c','4bf39427-b32a-434c-bd71-4d9493ea6eef','STOCK_OPNAME','Stock Opname','1','1','1','1','1',0),('e6f44dd7-9616-4c85-aaa9-e5322ea39319','096b0105-de76-492c-9bb0-5e518b46d69c','b44420c6-261b-44c5-a23a-7802a0506dab','RECURRING_PAYMENT','Recurring Payment','1','1','1','1','1',1),('e75602fb-2d83-462c-8692-bb8ec206c395','096b0105-de76-492c-9bb0-5e518b46d69c','8a8db7c0-a8f6-4314-b45c-c40161275c20','WORK_REQUIREMENT','Work Requirement','1','1','1','1','1',1),('e9b3d5e4-1259-48bc-b521-7abb7d72bc30','096b0105-de76-492c-9bb0-5e518b46d69c','e4307d82-f3fa-4916-9e6b-7a4f894d847e','ORGANIZATION','Organization','1','1','1','1','1',0),('ebf6409b-1cf3-46aa-80b9-3041091c442b','cecab92d-1762-4eb0-b45b-484e32e99fa3','627fb961-6cf0-4148-9451-0d1422095eb7',NULL,NULL,'1','0','0','0','1',2),('ebf9f4a1-27f9-4c16-9186-905c6d292287','cecab92d-1762-4eb0-b45b-484e32e99fa3','abfd9a02-3b4b-47a0-9048-a65b6be0b3aa',NULL,NULL,'0','0','0','0','0',0),('ed0df929-8852-42ca-9006-e0ad6fd37a90','096b0105-de76-492c-9bb0-5e518b46d69c','55b7e0fb-a178-478b-a09e-4b753f161aeb','MEDICATION','Medication','1','1','1','1','1',0),('ee5e29eb-cf8a-4c54-a709-da55952b8f80','096b0105-de76-492c-9bb0-5e518b46d69c','5eda5016-f448-42dd-926b-52b10870e29c','STUDY_TIME','Study Time','1','1','1','1','1',1),('ee77b8ba-08c2-421d-b0a0-652945c04688','cecab92d-1762-4eb0-b45b-484e32e99fa3','532efe0a-05ff-4f94-877d-a7f3f7509569',NULL,NULL,'0','0','0','0','0',0),('f0c0441f-80df-4405-8927-c114d9c61edb','096b0105-de76-492c-9bb0-5e518b46d69c','e4d249e1-4bd5-4291-9050-62a99f70f64c','CLINIC_REPORT','Clinic Reports','1','1','1','1','1',1),('f0f949d7-f756-4fdc-bacd-b6e145b9829d','096b0105-de76-492c-9bb0-5e518b46d69c','5e8c4a66-e46a-4000-ae1c-bf536686b30f','TRN_ORDER_REQ','Transfer Order Request','1','1','1','1','1',0),('f21a4567-0723-4569-abd7-8e59e3645767','096b0105-de76-492c-9bb0-5e518b46d69c','0c586cf4-9bd2-4b93-b24b-d41ceca2aef4','CLINIC_SALES','Clinic Sales','1','1','1','1','1',1),('f4b12ef0-6f04-4e2c-ac0c-bbb5ba7c8aee','096b0105-de76-492c-9bb0-5e518b46d69c','5844dc9e-2db6-4074-8103-3861566b042e','PRODUCT_FEATURE','Product Feature','1','1','1','1','1',1),('f5040411-7d4c-4171-a3e8-1d5249c4b40e','cecab92d-1762-4eb0-b45b-484e32e99fa3','1213903a-126f-4a60-8c7e-35c6dbe67927',NULL,NULL,'0','0','0','0','0',0),('f54456cf-21e6-4fa4-8732-45e15c59c0d5','cecab92d-1762-4eb0-b45b-484e32e99fa3','6e299ade-e10e-4940-ae83-bdf61505ed63',NULL,NULL,'0','0','0','0','0',0),('f6e1681a-d510-4287-a66b-7cff66db5825','cecab92d-1762-4eb0-b45b-484e32e99fa3','6861d3b3-8110-46ed-8a3a-830963597fa7',NULL,NULL,'0','0','0','0','0',0),('f6e69991-8825-41e8-a6e7-24a4c6257c4d','096b0105-de76-492c-9bb0-5e518b46d69c','dbc9175e-eb27-45e9-9e43-a1c12d6354e4','DOCTOR','Doctor','1','1','1','1','1',0),('f7284b39-b584-4334-94f0-0631d3a9b429','096b0105-de76-492c-9bb0-5e518b46d69c','4500a912-bbad-4590-9abb-d9ec92a311a5','DISCOUNT','Discount Programm','1','1','1','1','1',1),('f904e603-9224-4316-b8fd-0f92fef2de85','cecab92d-1762-4eb0-b45b-484e32e99fa3','83b19678-9f2f-49f4-ba25-0f31a8dee078',NULL,NULL,'0','0','0','0','0',0),('fccec2f5-a554-402a-aca6-edf3d4336c91','cecab92d-1762-4eb0-b45b-484e32e99fa3','8217c196-16b9-44fb-9662-8323220ee705',NULL,NULL,'0','0','0','0','0',0),('fe2ef334-8861-41af-887a-a95992d46b74','096b0105-de76-492c-9bb0-5e518b46d69c','8c7e1020-0824-4239-9a4e-46301c80b9cd','PAYMENT_METHOD_TYPE','Payment Method Type','1','1','1','1','1',1),('fe6ff4a0-77d6-4483-81be-520f46e85918','cecab92d-1762-4eb0-b45b-484e32e99fa3','6cbaf072-6925-46e9-b417-17326f3d8584',NULL,NULL,'0','0','0','0','0',0);
/*!40000 ALTER TABLE `access_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `access_user`
--

DROP TABLE IF EXISTS `access_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `access_user` (
  `id` char(50) NOT NULL,
  `email` varchar(250) DEFAULT NULL,
  `password` varchar(250) DEFAULT NULL,
  `is_enabled` char(1) DEFAULT '1',
  `fk_user_setting` char(50) DEFAULT NULL,
  `is_deleteable` char(1) DEFAULT '0',
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `access_user`
--

LOCK TABLES `access_user` WRITE;
/*!40000 ALTER TABLE `access_user` DISABLE KEYS */;
INSERT INTO `access_user` VALUES ('97dc9715-47eb-45d5-96ba-0a582fabdf3b','admin@belian.com','jIfSsj+ceSsamqTfmru/ZlLSRsjwUijQK4CJqi86fLNWb/nqSv2eY2rRrJxgpdDM','1','28fc7f13-1777-47e3-94c8-8b54436b1e96','0',1);
/*!40000 ALTER TABLE `access_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accounting_period`
--

DROP TABLE IF EXISTS `accounting_period`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounting_period`
--

LOCK TABLES `accounting_period` WRITE;
/*!40000 ALTER TABLE `accounting_period` DISABLE KEYS */;
/*!40000 ALTER TABLE `accounting_period` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `acknowledgement`
--

DROP TABLE IF EXISTS `acknowledgement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acknowledgement` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `approver_status` char(10) DEFAULT NULL,
  `person_id` char(50) DEFAULT NULL,
  `person_value` varchar(250) DEFAULT '0',
  `type` char(30) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acknowledgement`
--

LOCK TABLES `acknowledgement` WRITE;
/*!40000 ALTER TABLE `acknowledgement` DISABLE KEYS */;
INSERT INTO `acknowledgement` VALUES ('09fa18d2-929a-48ac-bbe3-b060606fc030',NULL,'ACCEPTED','c21873ef-3e29-43ca-92cd-45b5eb519c6e','Siti Komarudin','APPROVER',1),('0e487a79-5393-476f-9ef8-c1c293a8f827',NULL,'SUBMITTED','c21873ef-3e29-43ca-92cd-45b5eb519c6e','Siti Komarudin','ENTERED_BY',0),('1a3af1b9-af03-4feb-b01b-5201ccd6f952',NULL,'SUBMITTED','895f107c-991a-4173-8dba-f6a906e13cef','DODI','ENTERED_BY',0),('38f2e548-0873-4f49-b458-de6c73cec722',NULL,'REJECTED','c21873ef-3e29-43ca-92cd-45b5eb519c6e','Siti Komarudin','APPROVER',1),('5084d7c7-9557-4b31-93a0-033ef7b13b22',NULL,'SUBMITTED','895f107c-991a-4173-8dba-f6a906e13cef','DODI','REVIEWER',0),('87350317-a5fa-44f2-9b66-aec9650f47de',NULL,'SUBMITTED','895f107c-991a-4173-8dba-f6a906e13cef','DODI','ENTERED_BY',0),('afe3868a-0a6b-418d-86e9-193aa304a964',NULL,'SUBMITTED','895f107c-991a-4173-8dba-f6a906e13cef','DODI','ENTERED_BY',0),('c118f00c-eaf4-47e2-8ad4-9edf741823fd',NULL,'REJECTED','c21873ef-3e29-43ca-92cd-45b5eb519c6e','Siti Komarudin','APPROVER',1),('d27590ad-3690-47c7-985a-ab151b7ae699',NULL,'SUBMITTED','895f107c-991a-4173-8dba-f6a906e13cef','DODI','REVIEWER',0),('e5d1b9cf-7937-4235-9589-8098a186d429',NULL,'ACCEPTED','c21873ef-3e29-43ca-92cd-45b5eb519c6e','Siti Komarudin','APPROVER',1),('f41ddb17-fd5f-4c79-99d7-8dd43ac22ce8',NULL,'REJECTED','c21873ef-3e29-43ca-92cd-45b5eb519c6e','Siti Komarudin','APPROVER',1);
/*!40000 ALTER TABLE `acknowledgement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id` char(50) NOT NULL,
  `address` varchar(500) DEFAULT NULL,
  `postal` char(25) DEFAULT NULL,
  `status` char(1) DEFAULT '1',
  `type` char(10) DEFAULT 'HOME',
  `fk_city` char(50) DEFAULT NULL,
  `fk_province` char(50) DEFAULT NULL,
  `fk_country` char(50) DEFAULT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES ('010d2467-3a43-4a99-a33b-76ce10b2fd88','Jl. Apel Gg. Apel No. 23','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'731838a3-08f5-4f01-9cc3-7b0985239d44',0),('0cb7f1ef-72dd-4edf-9d0c-3784d14e166e','Jl. Gusti Hamzah Gg. Nur2 Dalam No. 4','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'022b153f-c31b-4bbe-bcf3-90dfc5243579',0),('0f6402e1-4058-4040-b734-efd514842463','Jl. Gusti Hamzah Gg. Nur2','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'a77bcca4-aee3-4cd3-96c0-b0e78ff13f73',0),('109286a5-5e1a-496b-bc94-52ef9ff59802','Komp. Didis Permai 7 No. 21D','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'4dc0134d-711c-468e-af68-6faa3aa9ea1e',0),('123e48ff-66c4-4a8e-bd57-4c21ef39a8d7','Jl. RE Martadinata No. C10 (Ruko)','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'c407032a-4d0d-4b6d-94a3-ae891170e65c',0),('15d5a8c9-f281-4c25-a830-e090f75e9151','Jl. Kom Yos Sudarso Gg. Lamtoro Surya Kencana A2','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'12529b23-3ec7-4912-a7ba-4a7dd0b14b64',0),('17e1801e-8bfc-4ea8-ade7-942e3cee8f21','Jl. Karya Komp. Villa Permata Asri F.8','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'8a820547-5d64-4589-bf73-837687170286',0),('1ef7144c-41a0-4d6a-9bea-350c855e7cf5','Jl. Husein Hamzah Komp. Cempaka 5 No. A-16','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'49a021f9-ef29-4e7b-88a6-bdd1ee2f4d70',0),('1f876140-6015-4d4d-9e23-b742a1457d89','Pasar Dahlia','55413','1','OFFICE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','bdbc5740-01fb-4a62-93f6-2e0b49a83c87','a685cde5-df6b-4430-babc-0ae846f8fa29',0),('23bd3fa3-1131-4b18-a53f-02a896fd0cbc','Jl. HM Suwignyo Gg. Al Karim No. 21','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'ce59473f-8bd8-4c7c-a118-6228a2b301a1',0),('2458bbd7-3fe3-4f57-bd0b-dcc12073c25e','Jl. Marta Gg. Pala 4 No. 23','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'819d4ae9-36e9-47d5-b572-c7fb8c76f392',0),('2550de8e-b4ad-4e0e-8a15-1f4c20679c00','Jl. Karet Komp. Surya Kencana I No. D24','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'280c1c5f-5bfc-41c7-9162-805edadc6a7c',0),('25b80ce4-d25f-4ad1-8344-d81d64d1daf0','Jl. Sejarah Gg. Gn. Malabar No. 33','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'e26ce188-8644-46e6-b25f-e131cf46d678',0),('276c8e3b-b325-4376-80a1-4da38cd87a02','Jln Gusti Hamzah (Pancasila) No 105','55662','1','OFFICE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86',0),('281eb906-ff88-4ebf-844d-6dc303a5bd71','Jl. Dr. Wahidin Gg. Sepakat 3 No. 14','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'a3ad09a6-dac6-45b9-b678-750014a6cf73',0),('2dd719e3-2945-42d1-b20d-7be25a0fdae0','Jl. Husein Hamzah Komp. Harvin Indah No. B19','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'f89abcfd-9762-4a07-8b49-ad4f844b3ca1',0),('30781006-bd43-438c-b4bc-25b6d98c5349','Sepakat 6 Jalur 2','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'1ceb724e-4833-417f-b34c-8086eb670f7e',0),('3099765c-c9fc-4951-91bb-5d7ed0ebe0ca','Jl. Karet Komp. Didis Permai No. A13','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'4a842e24-386c-4380-a333-3337b7f9029b',0),('33a4431e-6e90-4790-95ef-713af9a79dc2','Jl. Pangeran Natakusuma Gg. Bambu No. 19A','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'cb1e074f-7ba2-415e-8523-4c36b75e2101',0),('33acee69-09bc-4bc5-96e6-5b8a64bcf922','Jl. Tebu Komp. Tebu Mandala No. 26A','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'c0f065ac-a095-4a85-a28f-f116a9ba3e57',0),('355d77ba-b5be-4193-9e58-85fc78664a88','JL ABC No 15','325235','1','OFFICE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','0e694333-77f0-4b5e-a2bc-832a7b240d95','329f661e-3386-46f8-8d3a-5fa704b6f533',0),('395c2771-4c04-4f2b-ab3a-a71052c04ca3','Jl. Kemakmuran Gg. Kemakmuran III','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'65b78b03-601e-4570-bf18-14c7d44e1a18',0),('3b56fd1e-4d50-4a4b-bb60-ea38f97b32e9','Gg. Margosari No. 12A','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'42901be4-86e0-4e24-be0f-0698dd7ae9bf',0),('3d08c7b9-1926-4271-bd8e-35f3325fb7c6','Jl. Karya Baru Komp. Bali Agung I No. 10B','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'2625e364-072a-416b-846e-90b6add43bef',0),('41b8e093-c0f7-40a5-bf38-219f67f52f81','Jl. KHW Hasyim Gg. Usaha 2 / 26A','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'f4eded39-41dc-40b7-b249-84c7daf9713d',0),('44b5d8cc-bfc7-4049-8597-6d9ef4064588','jln a no 55','7667','1','OFFICE','68309a5f-4606-46d3-ad20-996ed6c782dx','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'65e565a1-6c1c-4f65-91bd-63e412364298',0),('4bc6509d-7e8f-439d-89dc-667a2ed90edf','Jl. RE Martadinata Gg. Pala 4 No. 8','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','0e694333-77f0-4b5e-a2bc-832a7b240d95','017973d0-bdbc-4b6a-9b1e-bff197ab71f0',0),('4d9e7ea4-c53b-41bd-a4e8-9e5d3f735264','Tj. Raya 2 Gg. Amanah SBR,6 (plus) Blok E1 No.5 Saigon','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'63a56e3f-f59b-432f-9c9d-463f1f744334',0),('50724f80-3f6f-4c36-bdc2-57283b28444c','Jl. Pangeran Natakusuma Gg. Rencana No. 23 78116','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'923274db-d2a5-4a78-9962-86348c84e283',0),('51bfdfd5-7612-4f61-bd75-727fe81db8b5','Jl. Gusti Hamzah Gg. Pancasila 4B','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'756755c3-1ddd-4086-b862-e7e9298b30cc',0),('57aec5a2-6815-4fec-a70e-b4c7c3f45aa2','Jl. KHA Dahlan Gg. Ruper I No. 21','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'20677939-457c-4ac0-bf48-d93a5a02938a',0),('59fc4cb2-6ffe-4426-8ef3-3b1d767f358f','Jl. Sejarah Gg. Gn. Malabar No. 33','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'924efe8c-512b-4f7b-9b59-23f0a0e87369',0),('5c9577aa-6df3-4573-b8d5-7e34130d9684','Jl. Alianyang Gg. Rahayu No. 10','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'8e004f0b-e655-46c5-a38d-cc0217cca15a',0),('602edd64-ed21-4c7c-8c89-ac4675db40ff','Jl. Ampera No. 5 Kota Baru','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'964a55cc-2dbb-48ea-b45a-62e4f244a796',0),('60dd32ff-ff3d-4bb0-a483-05394080871c','Purnama Agung 7 Blok H 12A','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'c76091c1-4d94-447e-96f8-476bfee31604',0),('665ec1f3-2ed4-429a-b035-dc456080f714','Jl. Sungai Raya Dalam Komp. Palem Raya No. A11','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'11bb1ed3-dcdd-4430-908e-3d7e84870a88',0),('6be073cd-dc61-4ef0-b132-12b3937ff2c4','Jl. Kenari Gg. Merak II Dalam No. 19','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'0191c9f9-ed27-4967-93ed-add08b6f6f26',0),('746b8398-1be5-4fe8-b9b9-158482d051a3','Dr. Wahidin Komp. Mitra Raya Lestari III D15','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'088f14ea-d0e6-4177-8998-cca133fae524',0),('7c15a7a0-f61c-42b1-994a-5b15d98b0914','Jl. HM Suwignyo Gg. Sri Mulya B24','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'6c0fadd3-9867-4d3c-b9f5-502676b503a8',0),('7fd108b5-6d82-4a70-bde3-03b3e1361880','Jl. Tebu Gg. Rachmad  No. 53','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'61105d59-ec88-4467-ac05-8334d9f66e50',0),('89775c62-05b9-4166-a4ac-1356e8d33257','Jl. Danau Sentarum Komp. Mitra Utama V No. B15','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'a8280d8e-553c-4074-90b4-1f71b5c34e27',0),('8a120523-c7f6-451a-807c-a2df5364d1c9','Jl. Dr. Sutomo Gg. Karya I Gg. Pak Abu No. 31','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'6ad80274-db6b-42e3-8013-6ad1e441fb81',0),('8eeb39ca-5ddd-47aa-9dd5-402667e9866d','Jl. Alianyang Gg. Rahayu','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'348d0045-3db2-4e43-a632-ad70f82f86dd',0),('9242a17f-2b52-4110-a816-ec6777fdbe40','JL ABCD No 129','11111','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0','0e694333-77f0-4b5e-a2bc-832a7b240d95','895f107c-991a-4173-8dba-f6a906e13cef',0),('9a320d56-b39d-4984-b100-c33bcb86caf5','Jl. Dr. Wahidin Gg. Sepakat 6 Jalur 4 Blok L No. 1','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'9d91dc31-8244-41e6-9c4e-9a07bdef3122',0),('9f9b6ba6-a760-4618-8dfc-08d303b378c7','Jl. Gusti Hamzah Komp. Navigasi No. 14','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'03039740-cb9e-49dc-a670-a600b41d21d1',0),('a65a0faf-3e54-43dd-93e5-2b12aeba215d','Jl. Pangeran Natakusuma Gg. Melati No. 20','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'763a852d-5742-4be1-8905-714bcecebefd',0),('a9a69113-3f1a-4216-ae5f-6268b8b2945a','Jl. HM. Suwignyo Komp. Citra Indah I No. D9','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'2f43245c-8573-42cc-9692-8e3236de2f97',0),('ab4b8701-233e-41fb-899a-2ffb55b057dc','Jl. Ujung Pandang Komp. Taman Firdaus B15','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'b7afc825-ce01-493b-b59a-071b5645b682',0),('af4c8631-1fde-4a30-8f0f-14020b20513c','Jl. HRA Rahman Gg. Bendahara No. 11','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'3878879a-2e22-4a97-9929-ff37e1c31431',0),('af81a6ff-3766-4a79-8431-56d352782da4','Jl. Husin Hamzah Gg. Bersaudara No. 3','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'d67ddc3e-1c60-4aff-8120-66dccf9263cb',0),('b5d8dc5e-1a2e-4986-b156-e3c759aa055a','Jl. Karya Sosial Komp. Bumi Persada No. 9 Ampera','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'0ee45092-38fe-4270-a4c2-6657fa59298e',0),('b67d4171-9534-4956-9e11-9c7aec08b01c','Jln cdb bcd','3245214','1','WAREHOUSE','68309a5f-4606-46d3-ad20-996ed6c782dx','68309a5f-4606-46d3-ad20-996ed6c782d0','0e694333-77f0-4b5e-a2bc-832a7b240d95','e29c7687-30f8-4201-af68-0a4a67541b86',0),('b91b8d40-1c25-48be-a4c2-789e6759cfbd','Jl. Dr. Wahidin S Gg. Sepakat 2 Komp. Sriwijaya 2 No. 3','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'146508c4-cdd5-44e0-9d99-4f5041bf740f',0),('bd561d5e-5154-4288-bec0-8423f868f176','Jl. Suwignyo, Gg. Kurnia Indah No.7','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'fe8c2142-a8a5-428b-b242-84d7f384c079',0),('be55fda1-e249-4407-8654-051daa5abb73','Jl. Sejarah Gg. Puting 2 No. 40','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'aa10f218-64f3-4c41-8a90-c5a578896e17',0),('bf4eccbf-d032-4820-81c5-f91692e85ce4','Jl. Khatulistiwa Asmil Khatulistiwa','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'36f481b9-37e7-4c28-99e5-369f45200634',0),('c064e7c1-d79f-41ae-abc8-5dd2b7df552f','Dusun Sengkuang Daek','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','d0ae6c1a-d6e2-4ca8-879d-52d74e6feb71',NULL,'d73b0190-ec65-4e75-8b15-aaebbfb4dc97',0),('c0788886-d865-4470-85bb-382c68928c05','Jl. H. Rais A Rahman Gg. Keluarga No. 9 76118','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'bc260302-c07d-47a6-ad55-bdda6b4b16e5',0),('c2ce42e0-ae5b-4ffd-96ea-c68ce04d7795','Asrama Hidayat Blok V No. 2','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'8459900c-a178-43dd-b215-5e5c089475a2',0),('cad02d1a-01f7-431a-b773-54b59b7c6fc4','Jl. RE Martadinata Gg. Puring No. 7','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'b5cbc987-4f00-4fd8-b6d3-5c8de2e4ed45',0),('dab3018f-2019-4911-a91d-a23e55dee84a','Jl. HM Suwignyo Gg. Sri Mulya No. 9','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'3459dd9e-7ec3-436f-9c39-db93a9c8f7c6',0),('dd1048c7-d2b2-40e0-b014-2e9d575af49b','Jl. Suwignyo Komp. Citra Indah I No. D-9','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'29454f3b-e557-4cd5-b95d-8cd189c3c331',0),('de7d7b8e-8ae5-4fac-86a0-2b5487856fdd','Jl. Martadinata Gg. Timun I Jalur 6 No. 42B','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'e9ecb5e5-ec98-40d3-9282-6b7949c99924',0),('e1ceea38-7e9d-4b41-9445-5a99a3161c82','Jl. Ujung Pandang Komp. Taman Firdaus B15','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'f8c59058-2728-4039-87d2-409b42b9dbc8',0),('e1db0f3c-4d16-405f-b563-63bd0761c0f5','Jl. HM Suwignyo Gg. Nur3 No. 17A','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'633e7708-63c7-4f1f-8312-1d210e0dd065',0),('e3283197-f76d-4798-9680-76305d25f66c','Jl. Purnama Komp. Dinasty','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'f6917d75-083e-4325-bc07-77af774f043b',0),('e4253c1d-a137-4264-a09d-d77c7aa6e583','JL BCA no 100','243243','1','OFFICE','68309a5f-4606-46d3-ad20-996ed6c782dx','68309a5f-4606-46d3-ad20-996ed6c782d0','0e694333-77f0-4b5e-a2bc-832a7b240d95','329f661e-3386-46f8-8d3a-5fa704b6f533',0),('e7fed549-1c14-4781-811f-7914e580c15d','Jl. HM Suwignyo Gg. Margodadirejo I No. 27','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'41095616-583a-4e15-8563-e405bc26d0d3',0),('ea510593-7049-441e-a83a-5f318692b710','Jl. Karna Sosial Gg. Wonoyoso 3 No. A1','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'539fc7b2-a4a1-4b0e-a520-4bb2148b5405',0),('eabee31a-2011-47c7-8a48-3f2a254d4739','Jl. Tabrani Ahmad Gg. Zurriyat No. 3','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'e68fa2ab-75bf-48b8-ab52-55f89e7a4787',0),('ef52b384-4241-4cd6-9604-c901b0127776','Jl. Dr. Sutomo Komp. Batara Indah IV No. 11A','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'1eac9139-6b4f-40ff-aafb-a1be57705592',0),('f19c2096-23fd-42a3-9ad5-8609e89152c8','Jl. Dr. Wahidin Gg. Margo dadirejo II D No. 8','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'7aff71e4-ddaf-4f7b-aff6-6a95cff39ed2',0),('f24e9819-ae77-4e27-8557-24519d2d5a7f','Jl. Tebu Gg. Rachmad  No. 53','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'1701ebcc-9dde-4e2f-9ac5-4cec4dd8d386',0),('f79eb7aa-a9b4-4198-9f44-1e8a638ee14b','Jl. Dr. Wahidin Gg. Sepakat 9 No. 28','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'4221f198-19b2-416c-bf46-71163727a0ff',0),('f94533a9-f8a4-4d98-8e39-e3665cfc13ca','Jl. Ampera Komp. Ari Karya Indah 8 No. C4','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'20266334-c727-405c-b710-f215473e4396',0),('fb21f4d6-d0f7-4475-ae0d-60d97ad2ed54','Jl. Tanjung Raya 2 Komp. Bumi Citra Saigon No. B17','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'77a9c861-faaa-4b4a-a7b2-2d7124be9ba3',0),('fbd08f2e-2c82-46e5-9eb0-fd30cae51a83','Jl. Dr. Wahidin Komp. Batara Indah I Blok M No. 13A','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'44a75f39-d018-4644-b028-cd2328ac7ef8',0),('fc882beb-6bc9-4db3-992f-318e755f623a','Jl. Bina Jaya Gg. Damai 2 Komp. Nusa Indah 2 Blok G No. 17','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'e196257a-b925-4413-8ede-d4a7bd9f2466',0),('fdd12824-53ff-46b1-982a-2b93be93d071','Jl. Sungai Raya Dalam Komp. Mitra Indah Utama 3 No. A10','','1','HOME','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','68309a5f-4606-46d3-ad20-996ed6c782d0',NULL,'ffa7d45c-37c8-46cf-9a02-6973fa73ca3d',0);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `approve_and_reviewable`
--

DROP TABLE IF EXISTS `approve_and_reviewable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `approve_and_reviewable` (
  `id` char(50) NOT NULL,
  `number` varchar(100) DEFAULT NULL,
  `fk_organization_requested` char(50) DEFAULT NULL,
  `fk_last_status` char(50) DEFAULT NULL,
  `comment` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `approve_and_reviewable`
--

LOCK TABLES `approve_and_reviewable` WRITE;
/*!40000 ALTER TABLE `approve_and_reviewable` DISABLE KEYS */;
/*!40000 ALTER TABLE `approve_and_reviewable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asset`
--

DROP TABLE IF EXISTS `asset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset`
--

LOCK TABLES `asset` WRITE;
/*!40000 ALTER TABLE `asset` DISABLE KEYS */;
INSERT INTO `asset` VALUES ('cd0c3f10-40b0-4c47-b2f7-a2043e5311b6','ADMIN 1','ADMIN 1','2016-08-07',NULL,NULL,0,'1','0','ca1d20d1-5a09-4a2a-ba28-f3f0b79a0099','','e29c7687-30f8-4201-af68-0a4a67541b86',NULL,9);
/*!40000 ALTER TABLE `asset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asset_type`
--

DROP TABLE IF EXISTS `asset_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asset_type` (
  `id` char(50) NOT NULL,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `parent` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset_type`
--

LOCK TABLES `asset_type` WRITE;
/*!40000 ALTER TABLE `asset_type` DISABLE KEYS */;
INSERT INTO `asset_type` VALUES ('ca1d20d1-5a09-4a2a-ba28-f3f0b79a0099','KOMPUTER','KOMPUTER',NULL,0);
/*!40000 ALTER TABLE `asset_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `audit_trail`
--

DROP TABLE IF EXISTS `audit_trail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `audit_trail` (
  `id` char(50) NOT NULL,
  `date` varchar(45) DEFAULT NULL,
  `type` char(6) DEFAULT NULL,
  `user` varchar(150) DEFAULT NULL,
  `company` varchar(150) DEFAULT NULL,
  `service` varchar(150) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit_trail`
--

LOCK TABLES `audit_trail` WRITE;
/*!40000 ALTER TABLE `audit_trail` DISABLE KEYS */;
INSERT INTO `audit_trail` VALUES ('08fe61d0-ea27-40fe-980d-de636002ca56','2016-08-28 09:41:47.846','0','DODI','SSC PANCASILA','Cashier Shift','Open new shift for cashier on ADMIN 1',0),('4d3220ed-ed29-4cb3-8589-e38b71983bf8','2016-08-28 09:46:52.75','0','DODI','SSC PANCASILA','Cashier Shift','Closed shift session for cashier on ADMIN 1',0),('70bb3319-b263-4a14-9da3-e76c562f4ec2','2016-08-28 09:41:54.48','0','DODI','SSC PANCASILA','Cashier Shift','Closed shift session for cashier on ADMIN 1',0),('7a019e1a-a4fa-4ac2-84ab-ccff8dea2a2d','2016-08-07 09:55:28.206','0','DODI','SSC PANCASILA','Cashier Shift','Open new shift for cashier on ADMIN 1',0),('9b7c481b-7d25-4c53-b4ce-7532b9e61441','2016-08-28 09:43:30.05','0','DODI','SSC PANCASILA','Cashier Shift','Open new shift for cashier on ADMIN 1',0),('cb4d7405-ce3b-413c-9fae-1833371c39c3','2016-08-28 09:42:50.636','0','DODI','SSC PANCASILA','Cashier Shift','Closed shift session for cashier on ADMIN 1',0),('d779e334-f8a7-4087-8555-15eb213863d7','2016-08-28 09:42:44.569','0','DODI','SSC PANCASILA','Cashier Shift','Open new shift for cashier on ADMIN 1',0),('d95d2deb-e6ab-426c-9319-530cb4f5b2a3','2016-08-07 09:54:41.259','0','DODI','SSC PANCASILA','Cashier Shift','Open new shift for cashier on ADMIN 1',0),('f0fdc3bd-dbe4-484e-9758-395bf4129e1e','2016-08-07 09:54:46.824','0','DODI','SSC PANCASILA','Cashier Shift','Closed shift session for cashier on ADMIN 1',0);
/*!40000 ALTER TABLE `audit_trail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auto_journal_sales`
--

DROP TABLE IF EXISTS `auto_journal_sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auto_journal_sales` (
  `id` char(50) NOT NULL,
  `fk_cash_account` char(50) DEFAULT NULL,
  `fk_service_sales_account` char(50) DEFAULT NULL,
  `fk_goods_sales_account` char(50) DEFAULT NULL,
  `fk_tax_sales_account` char(50) DEFAULT NULL,
  `fk_receivable_account` char(50) DEFAULT NULL,
  `fk_tuslah_payable_account` char(50) DEFAULT NULL,
  `fk_branch_cash_account` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
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
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `benefit_type` (
  `id` char(50) NOT NULL,
  `code` char(50) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
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
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billable`
--

LOCK TABLES `billable` WRITE;
/*!40000 ALTER TABLE `billable` DISABLE KEYS */;
INSERT INTO `billable` VALUES ('07973aa7-c4aa-4913-8d67-f656f2408cc5','2016-08-10','INV2','0','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','bd6d6b60-4dda-4435-a0ca-06aaf48f0227','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('0d96c6f0-a8db-4c54-aa3d-22acc3683d74','2016-08-07','INV2','1','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','d6bfe390-243d-47e2-b2f0-4d9fc8bdd2c1','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','616831d5-8437-4b38-b723-6c04eaa3aa7e',1),('1c91ead2-61f3-431c-b100-9711216e6381','2016-07-22','INV1','1','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','f5c8833e-a0db-4251-a32f-817b1482083e','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,1),('215a4e52-47df-41a1-a03a-7d6ecf26305a','2016-08-10','INV3','0','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','bd6d6b60-4dda-4435-a0ca-06aaf48f0227','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('22502402-da64-4ae1-9bb9-131b49745eab','2016-08-28','INV1','1','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','e68fa2ab-75bf-48b8-ab52-55f89e7a4787','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','f42390b0-0780-46cc-addd-2e735de6e17a',1),('278b093e-f951-4c4d-831e-e3b5d25c9ce0','2016-08-18','INV8','0','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','bd6d6b60-4dda-4435-a0ca-06aaf48f0227','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('438c0b04-f516-47fd-abf8-bdbd9b43af74','2016-08-10','INV4','0','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','bd6d6b60-4dda-4435-a0ca-06aaf48f0227','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('43d64aad-184d-454d-ae69-ac9ad3ccb834','2016-06-04','INV5','0','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','bd6d6b60-4dda-4435-a0ca-06aaf48f0227','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('49b211d8-592d-4567-9ea8-af704e48eb51','2016-06-04','INV1','1','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','fe8c2142-a8a5-428b-b242-84d7f384c079','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,1),('575e13dc-39ab-48d7-b9ae-09fb140e0030','2016-08-18','INV11','0','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','bd6d6b60-4dda-4435-a0ca-06aaf48f0227','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('74202ffb-ac9f-4e0e-9076-8dbded487e13','2016-08-18','INV9','0','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','bd6d6b60-4dda-4435-a0ca-06aaf48f0227','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('7a6d233f-6137-491e-94a9-741283df4e13','2016-09-04','INV1','0','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','fe8c2142-a8a5-428b-b242-84d7f384c079','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('7e5e9de2-58f7-4885-b960-607b047972c8','2016-08-18','INV7','0','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','bd6d6b60-4dda-4435-a0ca-06aaf48f0227','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('8c770d09-125a-4b92-a026-ac93501f573b','2016-06-04','INV4','0','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','bd6d6b60-4dda-4435-a0ca-06aaf48f0227','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('972c1d92-5359-40a0-82ac-26a6dca8ae6d','2016-08-18','INV10','0','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','bd6d6b60-4dda-4435-a0ca-06aaf48f0227','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('b28b4c94-27f3-4592-8012-a3b039194ccb','2016-06-18','INV1','1','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','f5c8833e-a0db-4251-a32f-817b1482083e','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,1),('bd5b45b1-9f15-46a3-a31e-129093660d77','2016-06-04','INV3','0','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','bd6d6b60-4dda-4435-a0ca-06aaf48f0227','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('c1871cfb-e2a9-4bb4-a649-25518869d7f4','2016-08-18','INV12','0','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','bd6d6b60-4dda-4435-a0ca-06aaf48f0227','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('d55d0831-0979-4620-8a01-440adc08d116','2016-08-04','INV1','0','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','fe8c2142-a8a5-428b-b242-84d7f384c079','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('df34a4cd-47b4-4b48-b241-f85449ab4de8','2016-08-07','INV1','1','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','4377cbf9-83aa-470d-b260-7d7ba3176742','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','616831d5-8437-4b38-b723-6c04eaa3aa7e',1),('e78ffba6-eac3-4150-a29f-3576458bf298','2016-05-11','INV7','0','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','e68fa2ab-75bf-48b8-ab52-55f89e7a4787','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('ff80c196-e148-46a2-a456-dfcfcb1aecfd','2016-07-04','INV1','0','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','fe8c2142-a8a5-428b-b242-84d7f384c079','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0);
/*!40000 ALTER TABLE `billable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bpjs`
--

DROP TABLE IF EXISTS `bpjs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bpjs` (
  `id` char(50) NOT NULL,
  `card_number` char(50) DEFAULT NULL,
  `is_active` char(1) DEFAULT '0',
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `budget` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `type` char(10) DEFAULT 'Operating',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `budget_review` (
  `id` char(50) NOT NULL,
  `fk_budget` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `budget_revision` (
  `id` char(50) NOT NULL,
  `sequence` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `fk_budget` char(50) DEFAULT NULL,
  `comment` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `budget_revision_item` (
  `id` char(50) NOT NULL,
  `type` char(12) DEFAULT NULL,
  `fk_budget_item` char(50) DEFAULT NULL,
  `fk_budget_revision` char(50) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `budget_role` (
  `id` char(50) NOT NULL,
  `fk_budget` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `budget_status` (
  `id` char(50) NOT NULL,
  `fk_budget` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carier_relationship` (
  `id` char(50) NOT NULL,
  `fk_carrier` char(50) DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrier` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cash_purchase_order` (
  `id` char(50) NOT NULL,
  `fk_facility` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cash_purchase_order_item` (
  `id` char(50) NOT NULL,
  `fk_cash_purchase_order` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cash_sales` (
  `id` char(50) NOT NULL,
  `table_number` int(11) DEFAULT 1,
  `fk_geographic_location` char(50) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `cash_sales_type` char(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cash_sales`
--

LOCK TABLES `cash_sales` WRITE;
/*!40000 ALTER TABLE `cash_sales` DISABLE KEYS */;
/*!40000 ALTER TABLE `cash_sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cash_sales_line`
--

DROP TABLE IF EXISTS `cash_sales_line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cash_sales_line`
--

LOCK TABLES `cash_sales_line` WRITE;
/*!40000 ALTER TABLE `cash_sales_line` DISABLE KEYS */;
/*!40000 ALTER TABLE `cash_sales_line` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cashier_shift`
--

DROP TABLE IF EXISTS `cashier_shift`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cashier_shift` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `employee` char(50) DEFAULT NULL,
  `is_closed` char(1) DEFAULT '0',
  `asset` char(50) DEFAULT NULL,
  `capital` decimal(10,0) DEFAULT NULL,
  `start` time DEFAULT NULL,
  `end` time DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cashier_shift`
--

LOCK TABLES `cashier_shift` WRITE;
/*!40000 ALTER TABLE `cashier_shift` DISABLE KEYS */;
INSERT INTO `cashier_shift` VALUES ('163f2763-c270-41d2-b31a-cd98b6fcc3f4','2016-08-07','895f107c-991a-4173-8dba-f6a906e13cef','1','cd0c3f10-40b0-4c47-b2f7-a2043e5311b6',0,'09:54:41','09:54:46',1),('616831d5-8437-4b38-b723-6c04eaa3aa7e','2016-08-07','895f107c-991a-4173-8dba-f6a906e13cef','0','cd0c3f10-40b0-4c47-b2f7-a2043e5311b6',0,'09:55:28',NULL,0),('9a2a3d79-05e2-490a-b6eb-8088319de6e6','2016-08-28','895f107c-991a-4173-8dba-f6a906e13cef','1','cd0c3f10-40b0-4c47-b2f7-a2043e5311b6',0,'09:42:44','09:42:50',1),('c06dcbfd-6e19-4c3b-83ca-811c8c2fcd35','2016-08-28','895f107c-991a-4173-8dba-f6a906e13cef','1','cd0c3f10-40b0-4c47-b2f7-a2043e5311b6',0,'09:41:47','09:41:54',1),('f42390b0-0780-46cc-addd-2e735de6e17a','2016-08-28','895f107c-991a-4173-8dba-f6a906e13cef','1','cd0c3f10-40b0-4c47-b2f7-a2043e5311b6',50000,'09:43:30','09:46:52',1);
/*!40000 ALTER TABLE `cashier_shift` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `citizenship`
--

DROP TABLE IF EXISTS `citizenship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `citizenship` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `nopassport` varchar(150) DEFAULT NULL,
  `fk_person` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citizenship`
--

LOCK TABLES `citizenship` WRITE;
/*!40000 ALTER TABLE `citizenship` DISABLE KEYS */;
/*!40000 ALTER TABLE `citizenship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clinic_sales`
--

DROP TABLE IF EXISTS `clinic_sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clinic_sales` (
  `id` char(50) NOT NULL,
  `is_bpjs` char(1) DEFAULT '0',
  `bpjs_payment_status` char(10) DEFAULT NULL,
  `medication_status` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clinic_sales_item` (
  `id` char(50) NOT NULL,
  `fk_product_medicine` char(50) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `discount` decimal(10,0) DEFAULT NULL,
  `charge` decimal(10,0) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_medication` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company_structure` (
  `id` char(50) NOT NULL,
  `date_from` date DEFAULT NULL,
  `date_to` date DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `type` char(10) DEFAULT NULL,
  `fk_company_structure_parent` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact` (
  `id` char(50) NOT NULL,
  `contact` varchar(150) DEFAULT NULL,
  `type` char(12) DEFAULT 'PHONE',
  `status` char(1) DEFAULT '1',
  `fk_party` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES ('0160e67e-cf07-41ad-9d33-460549d37209','081345048506','CELL_PHONE','1','f6917d75-083e-4325-bc07-77af774f043b',0),('02f52854-f607-45f5-bbf4-0f96da014876','082255353626','CELL_PHONE','1','a77bcca4-aee3-4cd3-96c0-b0e78ff13f73',0),('0a62e192-d2ff-4eba-b219-2a618767f948','02253517556','CELL_PHONE','1','bc260302-c07d-47a6-ad55-bdda6b4b16e5',0),('0cebc4bd-ba08-4d56-9bca-fd5c8e84680e','08125754832','CELL_PHONE','1','12529b23-3ec7-4912-a7ba-4a7dd0b14b64',0),('0e4a0ed9-fce7-4ed1-ba51-10fa38b4014e','085250196329','CELL_PHONE','1','6c0fadd3-9867-4d3c-b9f5-502676b503a8',0),('0f17f981-25c9-43fa-80d4-b5fd81bad20f','085349933445','CELL_PHONE','1','017973d0-bdbc-4b6a-9b1e-bff197ab71f0',0),('11cb9b39-5bda-43b1-8031-cec51f70e89f','089677412191','CELL_PHONE','1','3878879a-2e22-4a97-9929-ff37e1c31431',0),('17692134-ea5a-4006-8914-4182bb04718f','085252344288','CELL_PHONE','1','022b153f-c31b-4bbe-bcf3-90dfc5243579',0),('18924bed-cd1e-4a5e-bdd4-84e2979d4046','082157055101','CELL_PHONE','1','e68fa2ab-75bf-48b8-ab52-55f89e7a4787',0),('199cffd9-dc37-4ea7-8e38-6f0619b93ec2','08215671000','CELL_PHONE','1','41095616-583a-4e15-8563-e405bc26d0d3',0),('1a6ae0dd-ebdf-47fb-9ee7-f699935ed7ce','089637663784','CELL_PHONE','1','633e7708-63c7-4f1f-8312-1d210e0dd065',0),('1aa2a5af-61ec-4e01-ab7b-b05a033bed18','081257053292','CELL_PHONE','1','f8c59058-2728-4039-87d2-409b42b9dbc8',0),('1d3040f0-57f6-497d-9b74-105df1207f3e','081253567902','CELL_PHONE','1','e196257a-b925-4413-8ede-d4a7bd9f2466',0),('1dc8d4cc-8471-4d9b-a7f9-4c5a18491f6b','7439213887247','CELL_PHONE','1','895f107c-991a-4173-8dba-f6a906e13cef',0),('1f47bb52-16d0-4fe9-a239-cbda6d8e24f7','081345005698','CELL_PHONE','1','61105d59-ec88-4467-ac05-8334d9f66e50',0),('226a73e0-2ff8-4764-9b86-1b7df272b304','089627010303','CELL_PHONE','1','f89abcfd-9762-4a07-8b49-ad4f844b3ca1',0),('26b5ad5b-4990-4329-b535-25b9a7b7278c','0561 7881 1871','OFFICE_PHONE','1','a685cde5-df6b-4430-babc-0ae846f8fa29',0),('2c1311f3-51e5-4fb9-9b93-535875fd0463','abs@somecom.com','CELL_PHONE','1','65e565a1-6c1c-4f65-91bd-63e412364298',0),('2ca9ef30-f7b0-412f-8f0d-91e5b287e187','082251687195','CELL_PHONE','1','9d91dc31-8244-41e6-9c4e-9a07bdef3122',0),('30b68afa-0a19-4e3b-beed-98f1c8d978fd','089683734643','CELL_PHONE','1','2625e364-072a-416b-846e-90b6add43bef',0),('3206621e-6510-44a5-997f-f951277b71eb','082157841087','CELL_PHONE','1','731838a3-08f5-4f01-9cc3-7b0985239d44',0),('36c7bc10-481d-48a2-b947-5c6d8587f909','085348273272','CELL_PHONE','1','20266334-c727-405c-b710-f215473e4396',0),('3beff20b-187a-420a-9d99-3d843b3a448a','674574575745','HOME_PHONE','1','329f661e-3386-46f8-8d3a-5fa704b6f533',0),('3cc0f74b-e817-43f0-895c-f4e0ffd81323','089619499691','CELL_PHONE','1','49a021f9-ef29-4e7b-88a6-bdd1ee2f4d70',0),('3d7c6adb-2320-4e67-bf43-d36681be9f65','08125718596','CELL_PHONE','1','ffa7d45c-37c8-46cf-9a02-6973fa73ca3d',0),('3fb6202b-2a65-4bb7-98ee-60bfe4384ecd','085249950369','CELL_PHONE','1','a3ad09a6-dac6-45b9-b678-750014a6cf73',0),('41770478-a587-4510-8514-3f108719fdcc','081242637701','CELL_PHONE','1','63a56e3f-f59b-432f-9c9d-463f1f744334',0),('44b1060e-a830-4613-be58-b63b29d28b25','082158733187','CELL_PHONE','1','923274db-d2a5-4a78-9962-86348c84e283',0),('45251970-18e2-49c9-851d-431a4b2285ac','082159534599','CELL_PHONE','1','aa10f218-64f3-4c41-8a90-c5a578896e17',0),('4702e1fe-c654-4d22-98bd-5994dc4969de','089696062829','CELL_PHONE','1','b5cbc987-4f00-4fd8-b6d3-5c8de2e4ed45',0),('4a9b9077-5c32-45af-8599-5c6537283dd5','085386060383','CELL_PHONE','1','819d4ae9-36e9-47d5-b572-c7fb8c76f392',1),('4b17eeb8-80e8-4c07-aa01-a4484d5c6bae','082150478811','CELL_PHONE','1','d67ddc3e-1c60-4aff-8120-66dccf9263cb',0),('4cb9c663-afbf-44f6-b11e-0adfa2196781','085342818721','CELL_PHONE','1','4a842e24-386c-4380-a333-3337b7f9029b',0),('4dfef738-cf77-438d-a4c5-ea0506ea5fdf','089637663784','CELL_PHONE','1','c407032a-4d0d-4b6d-94a3-ae891170e65c',0),('5afb294f-9d7b-4cb7-b2f7-3d8535567f5e','0561745426','CELL_PHONE','1','348d0045-3db2-4e43-a632-ad70f82f86dd',0),('5b0a6503-ef53-42af-bfa6-b5b6506b0b38','08999687278','CELL_PHONE','1','d67ddc3e-1c60-4aff-8120-66dccf9263cb',0),('61386936-1641-49b1-868d-5d8b16ca04e5','0895351187883','CELL_PHONE','1','ffa7d45c-37c8-46cf-9a02-6973fa73ca3d',0),('63fa272d-45ff-4a1a-ad3d-d1095f2f1469','085387162669','CELL_PHONE','1','8a820547-5d64-4589-bf73-837687170286',0),('643b9999-c264-47f3-ac05-ae9106817eed','082250510931','CELL_PHONE','1','6ad80274-db6b-42e3-8013-6ad1e441fb81',0),('68325e1d-e16f-42cf-bfa6-81dc0ab203e4','085245812181','CELL_PHONE','1','3459dd9e-7ec3-436f-9c39-db93a9c8f7c6',0),('6c1b862d-d09e-4ab3-8a2d-bcc490a2bd3d','085252101526','CELL_PHONE','1','280c1c5f-5bfc-41c7-9162-805edadc6a7c',0),('6f2511cd-dca5-485b-89b8-49510276eae2','08125777144','CELL_PHONE','1','924efe8c-512b-4f7b-9b59-23f0a0e87369',0),('709f3fc8-ce4c-46cb-885d-fad1cec144cc','081348475241','CELL_PHONE','1','4a842e24-386c-4380-a333-3337b7f9029b',0),('70b7beb9-ae12-4969-9ba8-597bc1ba0450','085245258999','CELL_PHONE','1','756755c3-1ddd-4086-b862-e7e9298b30cc',0),('70f1a4ed-e2f7-4104-8047-028cae3e81c8','081345070052','CELL_PHONE','1','2f43245c-8573-42cc-9692-8e3236de2f97',0),('723fc9d0-e2d1-45f6-afea-e917db2cce07','085252096364','CELL_PHONE','1','0ee45092-38fe-4270-a4c2-6657fa59298e',0),('752c8b08-f284-473d-b614-f2a39834c6df','05616589593','CELL_PHONE','1','539fc7b2-a4a1-4b0e-a520-4bb2148b5405',0),('775ef94f-aca4-40c9-b899-e368747c0a9e','081345005698','CELL_PHONE','1','1701ebcc-9dde-4e2f-9ac5-4cec4dd8d386',0),('77e3b3b4-4d23-4bfe-a157-d38c7c531fbf','08164991419','CELL_PHONE','1','8e004f0b-e655-46c5-a38d-cc0217cca15a',0),('793dda09-220c-45ae-b94c-49a34e5ca884','085387654828','CELL_PHONE','1','964a55cc-2dbb-48ea-b45a-62e4f244a796',0),('794c40f3-7b0e-4db8-a180-b18670286aab','085151489919','CELL_PHONE','1','1ceb724e-4833-417f-b34c-8086eb670f7e',0),('79e71028-129d-4c05-833e-04a8e790aa78','08125604198','CELL_PHONE','1','bc260302-c07d-47a6-ad55-bdda6b4b16e5',0),('7bae6703-59fb-44b8-95ce-e1ff788ef082','081352602821','CELL_PHONE','1','633e7708-63c7-4f1f-8312-1d210e0dd065',0),('7c804a10-bfbb-4a8e-b3f5-04f2c282e77c','082151222686','CELL_PHONE','1','77a9c861-faaa-4b4a-a7b2-2d7124be9ba3',0),('813dfcfa-2700-48d2-bf4b-dab0e2c1402e','085345353411','CELL_PHONE','1','c0f065ac-a095-4a85-a28f-f116a9ba3e57',0),('82681dd9-c20b-482c-83b6-353fe11de6e5','08960711948','CELL_PHONE','1','4221f198-19b2-416c-bf46-71163727a0ff',0),('835d0f1a-07b9-45f1-b37d-66627910ed72','082148484781','CELL_PHONE','1','fe8c2142-a8a5-428b-b242-84d7f384c079',0),('838aded6-50ac-417d-bbd9-54ef12c7d8fd','081256337879','CELL_PHONE','1','03039740-cb9e-49dc-a670-a600b41d21d1',0),('83a71f4f-d7de-4120-ba39-ee37c2d077db','089610400482','CELL_PHONE','1','11bb1ed3-dcdd-4430-908e-3d7e84870a88',0),('857f4480-35d7-40fa-9730-49ec5e10a20b','0811560430','CELL_PHONE','1','12529b23-3ec7-4912-a7ba-4a7dd0b14b64',0),('8737ba04-39be-46f7-8ff9-759e437a0d2e','081345249697','CELL_PHONE','1','7aff71e4-ddaf-4f7b-aff6-6a95cff39ed2',0),('8bbaa325-e89b-48ab-a00c-c1974c41066a','081352121975','CELL_PHONE','1','77a9c861-faaa-4b4a-a7b2-2d7124be9ba3',0),('8d29421b-dbda-409f-bf9b-c8326c32e686','0561745426','CELL_PHONE','1','8e004f0b-e655-46c5-a38d-cc0217cca15a',0),('8d9ac8c9-7c55-4496-aae0-8f9eba85b6a0','081345070052','CELL_PHONE','1','29454f3b-e557-4cd5-b95d-8cd189c3c331',0),('8e3c7749-c0a6-4bc9-84b6-ddcf442ca62b','085387875751','CELL_PHONE','1','c407032a-4d0d-4b6d-94a3-ae891170e65c',0),('8ff6bf9c-bed2-4742-be2b-977d51148c83','679469856','OFFICE_PHONE','1','329f661e-3386-46f8-8d3a-5fa704b6f533',0),('907475e4-8ec9-47d6-9b36-53dd8ad5eec0','082351039719','CELL_PHONE','1','088f14ea-d0e6-4177-8998-cca133fae524',0),('92560488-c063-45f6-92a0-8d0a50557b05','081257560340','CELL_PHONE','1','f4eded39-41dc-40b7-b249-84c7daf9713d',0),('94366d11-0060-42d2-aaba-a5fcab61b69f','08215777144','CELL_PHONE','1','e26ce188-8644-46e6-b25f-e131cf46d678',0),('957f2a65-53d6-445e-879b-e16fa140d18d','085647447139','CELL_PHONE','1','42901be4-86e0-4e24-be0f-0698dd7ae9bf',0),('973f62f5-de1d-40d5-bb3d-252dc341fe26','081345109042','CELL_PHONE','1','8459900c-a178-43dd-b215-5e5c089475a2',0),('98172805-fbd9-404b-bca2-13fa4e79fd39','0561775197','CELL_PHONE','1','731838a3-08f5-4f01-9cc3-7b0985239d44',0),('9938211f-8c71-49fd-974e-22b08df08b41','082152008535','CELL_PHONE','1','539fc7b2-a4a1-4b0e-a520-4bb2148b5405',0),('9afe0a1d-e338-413b-9f83-48d1a58a01e2','23523532535','CELL_PHONE','1','329f661e-3386-46f8-8d3a-5fa704b6f533',0),('9d566e1d-e673-458c-a9fb-13db1cfff16d','089691750775','CELL_PHONE','1','0191c9f9-ed27-4967-93ed-add08b6f6f26',0),('9f1b1f17-39e3-49a0-b21a-94b65e2c9570','082255754114','CELL_PHONE','1','2625e364-072a-416b-846e-90b6add43bef',0),('a0e8afb7-77a0-482a-a979-20af79db55f8','0812578215','CELL_PHONE','1','a8280d8e-553c-4074-90b4-1f71b5c34e27',0),('a5495b73-886a-4d40-9ea5-3357671f9fd0','08125727332','CELL_PHONE','1','4221f198-19b2-416c-bf46-71163727a0ff',0),('a7a03733-0a04-490e-b330-cbdbc127c7b1','081345558880','CELL_PHONE','1','f89abcfd-9762-4a07-8b49-ad4f844b3ca1',0),('aae0b4a0-5cba-48f7-a6fa-6b81b46188da','08968805416','CELL_PHONE','1','e9ecb5e5-ec98-40d3-9282-6b7949c99924',0),('ae0a86bb-065c-452f-972f-f8054ae782cd','089520537045','CELL_PHONE','1','41095616-583a-4e15-8563-e405bc26d0d3',0),('b44c7c8d-fb91-458c-9326-9edb7ca12cfc','082158409095','CELL_PHONE','1','65b78b03-601e-4570-bf18-14c7d44e1a18',0),('b4dd2942-2f97-4caa-9ca8-943134a5b9c2','085346604354','CELL_PHONE','1','cb1e074f-7ba2-415e-8523-4c36b75e2101',0),('b5396256-abbb-4c06-a82d-b2bfeb52842b','089622599526','CELL_PHONE','1','12529b23-3ec7-4912-a7ba-4a7dd0b14b64',0),('b76fa463-a784-4876-9c84-a19cd340a7eb','081250150649','CELL_PHONE','1','63a56e3f-f59b-432f-9c9d-463f1f744334',0),('b8c6134f-0800-4979-9e20-20f51c35b94b','08125722896','CELL_PHONE','1','924efe8c-512b-4f7b-9b59-23f0a0e87369',0),('baef50da-5399-4bb6-a8dd-b70c5a03ae81','08135227733','CELL_PHONE','1','146508c4-cdd5-44e0-9d99-4f5041bf740f',0),('bb81716d-d6d0-443c-b277-15117d939258','082154584006','CELL_PHONE','1','3878879a-2e22-4a97-9929-ff37e1c31431',0),('bd1ddb77-bc53-4391-ba0d-0a97bebd912c','081257536242','CELL_PHONE','1','756755c3-1ddd-4086-b862-e7e9298b30cc',0),('be07abad-b641-4ab4-848c-fb95ad101896','085246661771','CELL_PHONE','1','8a820547-5d64-4589-bf73-837687170286',0),('bf275ee9-9ab9-4239-a3db-f9ff088c6382','081257053292','CELL_PHONE','1','b7afc825-ce01-493b-b59a-071b5645b682',0),('bf3851d4-99a5-4fad-98a4-5c5351bdc7fa','(0561)585830','CELL_PHONE','1','022b153f-c31b-4bbe-bcf3-90dfc5243579',0),('bf8ba7de-f1f9-41ad-a3ee-2ec21c6b8db8','081345294050','CELL_PHONE','1','6ad80274-db6b-42e3-8013-6ad1e441fb81',0),('c21a36a7-51ff-4f23-b20e-53ed68d667e0','088245225062','CELL_PHONE','1','ce59473f-8bd8-4c7c-a118-6228a2b301a1',0),('c2b1ef74-3eee-4adc-b43f-23e91dfe4a8b','08125460807','CELL_PHONE','1','36f481b9-37e7-4c28-99e5-369f45200634',0),('c3fecf26-0d9d-4282-bed2-59514f937383','08125722896','CELL_PHONE','1','e26ce188-8644-46e6-b25f-e131cf46d678',0),('c466ead7-73c6-4292-a1f1-b64565eec826','085251790775','CELL_PHONE','1','4dc0134d-711c-468e-af68-6faa3aa9ea1e',0),('c567725b-3c0c-48bd-b16c-5b19511bde8a','08164991419','CELL_PHONE','1','348d0045-3db2-4e43-a632-ad70f82f86dd',0),('c57c1470-2f8b-4af1-a84c-45064b7da9e0','089614814098','CELL_PHONE','1','03039740-cb9e-49dc-a670-a600b41d21d1',0),('caecd0de-1ae8-459d-9c44-7165ac4ed43b','08981123271','CELL_PHONE','1','cb1e074f-7ba2-415e-8523-4c36b75e2101',0),('cf12dc2e-d31b-421a-8e39-1d0a99c74d79','089688869516','CELL_PHONE','1','20266334-c727-405c-b710-f215473e4396',0),('d229a631-ac15-40cc-af80-e55764b466ca','089670106075','CELL_PHONE','1','7aff71e4-ddaf-4f7b-aff6-6a95cff39ed2',0),('d535a0aa-af97-4bef-8b86-5e5e4e80d269','089666300946','CELL_PHONE','1','280c1c5f-5bfc-41c7-9162-805edadc6a7c',0),('d67575ac-7da6-46be-b40c-bb67dfe0530a','081345573220','CELL_PHONE','1','1eac9139-6b4f-40ff-aafb-a1be57705592',0),('d795793e-2523-4ee3-be85-da96659669a0','(0561) 749827','CELL_PHONE','1','e29c7687-30f8-4201-af68-0a4a67541b86',0),('d94bf8f9-804d-48f7-956e-5c821a9971b6','089505169446','CELL_PHONE','1','763a852d-5742-4be1-8905-714bcecebefd',0),('dc886bea-c653-44ae-bd2d-6e511578afb1','081345471234','CELL_PHONE','1','44a75f39-d018-4644-b028-cd2328ac7ef8',0),('e2af15aa-96a9-4886-b55e-8ec4e68631ca','08115702351','CELL_PHONE','1','9d91dc31-8244-41e6-9c4e-9a07bdef3122',0),('e3677fe8-21ce-4cb5-b1ad-2be733adce3f','085387924066','CELL_PHONE','1','20677939-457c-4ac0-bf48-d93a5a02938a',0),('e57452b8-3ac7-45a7-88c6-a27e27126ef4','142523532535','CELL_PHONE','1','65e565a1-6c1c-4f65-91bd-63e412364298',0),('e7566caf-fde5-4804-98f9-23b29bd47193','08986837143','CELL_PHONE','1','44a75f39-d018-4644-b028-cd2328ac7ef8',0),('e84c3778-d986-4a35-be79-03515aa3302e','081352529578','CELL_PHONE','1','11bb1ed3-dcdd-4430-908e-3d7e84870a88',0),('eab5b8d1-754e-4712-a7a5-0d076ba0f4c9','(0561)774169','CELL_PHONE','1','e68fa2ab-75bf-48b8-ab52-55f89e7a4787',0),('eb2a781b-bf17-4a8c-86cf-e7f85bb2995a','085245389855','CELL_PHONE','1','964a55cc-2dbb-48ea-b45a-62e4f244a796',0),('f11d5c98-9ceb-45c5-a47c-0e9b5a8a034f','08978120339','CELL_PHONE','1','923274db-d2a5-4a78-9962-86348c84e283',0),('f40eaf42-e796-441c-92d5-0597c0ba99b8','08970054066','CELL_PHONE','1','c76091c1-4d94-447e-96f8-476bfee31604',0),('f4768962-2cb9-4b94-9ffa-ea507c6a3b66','082354076152','CELL_PHONE','1','d73b0190-ec65-4e75-8b15-aaebbfb4dc97',0),('f47a95a8-96d5-4180-bb21-d8ae3b7b3afc','081231347807','CELL_PHONE','1','36f481b9-37e7-4c28-99e5-369f45200634',0),('f7c97dec-336b-421d-a5ae-aa4af272077f','089616350931','CELL_PHONE','1','c76091c1-4d94-447e-96f8-476bfee31604',0),('f8054c99-c5c2-4f4a-8ee0-8fc51000fd4c','085245841138','CELL_PHONE','1','e9ecb5e5-ec98-40d3-9282-6b7949c99924',0),('f8fb3723-70e8-4a09-a804-0e1d77193504','08989809855','CELL_PHONE','1','731838a3-08f5-4f01-9cc3-7b0985239d44',0),('fb1e672f-5999-4f61-99f9-a0aec8db7ebf','(0561)775612','HOME_PHONE','1','017973d0-bdbc-4b6a-9b1e-bff197ab71f0',1),('fb58e5b4-ab61-429a-965c-9e22d38a5f04','0561760108','CELL_PHONE','1','bc260302-c07d-47a6-ad55-bdda6b4b16e5',0),('fba51cf3-9376-4a16-a2c4-e675dc521e16','089683417325','CELL_PHONE','1','6c0fadd3-9867-4d3c-b9f5-502676b503a8',0),('ff204485-ad0b-4648-8114-16f30ee55117','081254150707','CELL_PHONE','1','763a852d-5742-4be1-8905-714bcecebefd',0);
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `container`
--

DROP TABLE IF EXISTS `container`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `container` (
  `id` char(50) NOT NULL,
  `name` varchar(150) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `parent` char(50) DEFAULT NULL,
  `fk_facility` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `container`
--

LOCK TABLES `container` WRITE;
/*!40000 ALTER TABLE `container` DISABLE KEYS */;
INSERT INTO `container` VALUES ('1139e164-2710-49f2-98e8-557e9a468ca4','B','B','FILE_DRAWER','5b54337a-ee51-47f1-8411-1704997e94cd',NULL,0),('166084c1-41ab-4c7f-98f1-d403f42bd6c8','E','E','ROOM','319a4647-7e34-45b1-a018-d0667062822d',NULL,0),('2ae63df9-e4c7-4b9d-bca6-fa25fb06ee08','A','A','BIN',NULL,'9081de22-1c08-4a10-9e18-b99b88d47885',0),('a87af5ed-2982-4f7d-8f90-2d4420f4aa78','Lemari 1','','BIN',NULL,'e63a8167-7ae8-4b53-93b7-bb5b9258f0ad',0);
/*!40000 ALTER TABLE `container` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `id` char(50) NOT NULL,
  `code` char(25) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES ('0e694333-77f0-4b5e-a2bc-832a7b240d95','INA','Indonesia',0),('bdbc5740-01fb-4a62-93f6-2e0b49a83c87','MY','Malaysia',0),('c6b0604a-f792-4ce6-9b1f-c426de84f491','SG','Singapore',0);
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_attendance`
--

DROP TABLE IF EXISTS `course_attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_attendance` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `fk_Schedule` char(50) DEFAULT NULL,
  `fk_staff` char(50) DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_attendance_item` (
  `id` char(50) NOT NULL,
  `fk_person` char(50) DEFAULT NULL,
  `status` char(10) DEFAULT 'LEAVE',
  `fk_attendance` char(50) DEFAULT NULL,
  `fk_time_entry` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_discount` (
  `id` char(50) NOT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `fk_discount` char(50) DEFAULT NULL,
  `fk_registration` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_discount`
--

LOCK TABLES `course_discount` WRITE;
/*!40000 ALTER TABLE `course_discount` DISABLE KEYS */;
INSERT INTO `course_discount` VALUES ('0da7ef20-f9c2-41bf-97f1-dc3758937ef2',625000,'d3bf7373-9700-4a36-beb4-87cae75e4f52','c1149961-09be-4d98-aa64-06d56c6d781e',0),('6375fea2-a87b-4e0a-834c-290de43dc9bf',100000,'997e05f9-0a1d-413c-bc9a-8d2589f6a102','58ec364f-7e3e-4a5b-b359-4388f33e3084',0),('a7315c4a-be6c-4e22-8c24-771ef3e76789',300000,'962550e6-a193-4ebd-8944-27a2e4913d88','0561ea86-7db1-4754-be5d-47ca42271dac',0),('b1b28f12-9944-434c-8b7a-c31980435ff9',625000,'d3bf7373-9700-4a36-beb4-87cae75e4f52','7f9d56df-dcd4-4659-a0d0-6675d6ba942c',0),('c38f7f80-ec9f-4aec-9c17-c80516e46c2b',300000,'962550e6-a193-4ebd-8944-27a2e4913d88','58ec364f-7e3e-4a5b-b359-4388f33e3084',0),('f1e6014d-88a1-465f-a35c-12f8ea9b3d61',100000,'39fc9fc5-d65e-4d0c-a243-4f90a7f68387','58ec364f-7e3e-4a5b-b359-4388f33e3084',0);
/*!40000 ALTER TABLE `course_discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_installment`
--

DROP TABLE IF EXISTS `course_installment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_installment` (
  `id` char(50) NOT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `fk_course_registration` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_installment`
--

LOCK TABLES `course_installment` WRITE;
/*!40000 ALTER TABLE `course_installment` DISABLE KEYS */;
INSERT INTO `course_installment` VALUES ('07973aa7-c4aa-4913-8d67-f656f2408cc5',500000,'ANGSURAN 2','e1739cf4-c8ee-4c6d-9c8b-f34856ff5853'),('0d96c6f0-a8db-4c54-aa3d-22acc3683d74',2100000,'ANGSURAN 1','58ec364f-7e3e-4a5b-b359-4388f33e3084'),('1c91ead2-61f3-431c-b100-9711216e6381',1800000,'BAYAR KELUNASAN','0561ea86-7db1-4754-be5d-47ca42271dac'),('215a4e52-47df-41a1-a03a-7d6ecf26305a',500000,'ANGSURAN 2','117aba83-bcf0-418d-86e4-7252512a7716'),('22502402-da64-4ae1-9bb9-131b49745eab',2800000,'bayar lunas','f9be0949-037d-4116-abc6-12774b646009'),('278b093e-f951-4c4d-831e-e3b5d25c9ce0',0,'ANGSURAN 4','e1739cf4-c8ee-4c6d-9c8b-f34856ff5853'),('438c0b04-f516-47fd-abf8-bdbd9b43af74',500000,'ANGSURAN 2','4b5aa77a-d09f-426a-b81b-727da84fb467'),('43d64aad-184d-454d-ae69-ac9ad3ccb834',500000,'ANGSURAN 1','4b5aa77a-d09f-426a-b81b-727da84fb467'),('49b211d8-592d-4567-9ea8-af704e48eb51',600000,'Angsuran 1','4afafba4-1d0d-493f-b0a6-c19a79b56d8a'),('575e13dc-39ab-48d7-b9ae-09fb140e0030',1000000,'ANGSURAN 3','4b5aa77a-d09f-426a-b81b-727da84fb467'),('74202ffb-ac9f-4e0e-9076-8dbded487e13',1000000,'ANGSURAN 3','117aba83-bcf0-418d-86e4-7252512a7716'),('7a6d233f-6137-491e-94a9-741283df4e13',700000,'Angsuran 4','4afafba4-1d0d-493f-b0a6-c19a79b56d8a'),('7e5e9de2-58f7-4885-b960-607b047972c8',1600000,'ANGSURAN 3','e1739cf4-c8ee-4c6d-9c8b-f34856ff5853'),('8c770d09-125a-4b92-a026-ac93501f573b',500000,'ANGSURAN 1','117aba83-bcf0-418d-86e4-7252512a7716'),('972c1d92-5359-40a0-82ac-26a6dca8ae6d',600000,'ANGSURAN 4','117aba83-bcf0-418d-86e4-7252512a7716'),('b28b4c94-27f3-4592-8012-a3b039194ccb',100000,'PENDAFTARAN','0561ea86-7db1-4754-be5d-47ca42271dac'),('bd5b45b1-9f15-46a3-a31e-129093660d77',500000,'ANGSURAN 1','e1739cf4-c8ee-4c6d-9c8b-f34856ff5853'),('c1871cfb-e2a9-4bb4-a649-25518869d7f4',600000,'ANGSURAN 4','4b5aa77a-d09f-426a-b81b-727da84fb467'),('d55d0831-0979-4620-8a01-440adc08d116',700000,'Angsuran 3','4afafba4-1d0d-493f-b0a6-c19a79b56d8a'),('df34a4cd-47b4-4b48-b241-f85449ab4de8',1875000,'ANGSURAN 12016','c1149961-09be-4d98-aa64-06d56c6d781e'),('e78ffba6-eac3-4150-a29f-3576458bf298',1875000,'ANGSURAN 1','7f9d56df-dcd4-4659-a0d0-6675d6ba942c'),('ff80c196-e148-46a2-a456-dfcfcb1aecfd',600000,'Angsuran 2','4afafba4-1d0d-493f-b0a6-c19a79b56d8a');
/*!40000 ALTER TABLE `course_installment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_installment_item`
--

DROP TABLE IF EXISTS `course_installment_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_installment_item` (
  `id` char(50) NOT NULL,
  `resource` char(50) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT 1,
  `uom` char(50) DEFAULT NULL,
  `unit_price` decimal(10,0) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_course_installment` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_item` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `fk_product_feature` char(50) DEFAULT NULL,
  `fk_course_registration` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_item`
--

LOCK TABLES `course_item` WRITE;
/*!40000 ALTER TABLE `course_item` DISABLE KEYS */;
INSERT INTO `course_item` VALUES ('0776647e-5dc9-4ac0-9627-03160fa37f2d',1,2500000,'c47da54f-b8ef-4d61-a5b0-79563bae587c','557f0c90-cb32-437c-bcf7-632242622413','117aba83-bcf0-418d-86e4-7252512a7716',0),('229c4880-9dc9-454a-b040-e7f4dfe1b68b',1,100000,'1967553d-bda0-4a57-b9f5-356adf49c451','80a3e730-15e4-4329-be2e-74dce739e2d4','4b5aa77a-d09f-426a-b81b-727da84fb467',0),('40875526-f84a-4e79-aeea-bad19d41a3ca',1,2500000,'c47da54f-b8ef-4d61-a5b0-79563bae587c','557f0c90-cb32-437c-bcf7-632242622413','e1739cf4-c8ee-4c6d-9c8b-f34856ff5853',0),('5078e732-4edc-4ed2-869b-e9f94aefd549',1,100000,'1967553d-bda0-4a57-b9f5-356adf49c451','80a3e730-15e4-4329-be2e-74dce739e2d4','117aba83-bcf0-418d-86e4-7252512a7716',0),('5c27bdc1-e969-4f13-8af3-c3c72983cc05',1,2200000,'8df9ac96-4cb6-4a3d-aebd-8dfffb6d803d','fb3e92c6-8eda-4e3e-a28d-5294567fa670','0561ea86-7db1-4754-be5d-47ca42271dac',0),('61bae7c7-3df6-4dae-9706-1bc4a4945e6a',1,2800000,'44965c88-3dfa-4645-b885-1003c53da8af','51db4c1b-8a21-4d74-9821-a520cb5d86d3','f9be0949-037d-4116-abc6-12774b646009',0),('6644e403-a2a5-4c4d-be37-8b8f82f09041',1,2500000,'f8df0127-63eb-44ca-81ac-cefe6b3e1289','31d873b3-807b-4be0-ba17-1bba18b02830','58ec364f-7e3e-4a5b-b359-4388f33e3084',0),('7256ed85-94bf-4ca1-a92e-f770f69d9270',1,2500000,'f8df0127-63eb-44ca-81ac-cefe6b3e1289','31d873b3-807b-4be0-ba17-1bba18b02830','c1149961-09be-4d98-aa64-06d56c6d781e',0),('72fa290f-5515-4dce-a063-7461251bb31e',1,2500000,'f8df0127-63eb-44ca-81ac-cefe6b3e1289','31d873b3-807b-4be0-ba17-1bba18b02830','4afafba4-1d0d-493f-b0a6-c19a79b56d8a',0),('90314994-64af-46ab-ae60-38d4560bd639',1,100000,'1967553d-bda0-4a57-b9f5-356adf49c451','80a3e730-15e4-4329-be2e-74dce739e2d4','e1739cf4-c8ee-4c6d-9c8b-f34856ff5853',0),('99d534e7-1e11-4402-9acd-d04829085695',1,2500000,'c47da54f-b8ef-4d61-a5b0-79563bae587c','557f0c90-cb32-437c-bcf7-632242622413','7f9d56df-dcd4-4659-a0d0-6675d6ba942c',0),('cdf2a78e-946b-4cfa-b8f1-5da1ccf09a35',1,100000,'1967553d-bda0-4a57-b9f5-356adf49c451','80a3e730-15e4-4329-be2e-74dce739e2d4','4afafba4-1d0d-493f-b0a6-c19a79b56d8a',0),('ecd44d54-e877-4621-911e-488735a4464c',1,2500000,'c47da54f-b8ef-4d61-a5b0-79563bae587c','557f0c90-cb32-437c-bcf7-632242622413','4b5aa77a-d09f-426a-b81b-727da84fb467',0),('fef70f78-d1f1-473a-ad05-24135ad42236',1,100000,'1967553d-bda0-4a57-b9f5-356adf49c451','80a3e730-15e4-4329-be2e-74dce739e2d4','58ec364f-7e3e-4a5b-b359-4388f33e3084',0);
/*!40000 ALTER TABLE `course_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_registration`
--

DROP TABLE IF EXISTS `course_registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_registration`
--

LOCK TABLES `course_registration` WRITE;
/*!40000 ALTER TABLE `course_registration` DISABLE KEYS */;
INSERT INTO `course_registration` VALUES ('0561ea86-7db1-4754-be5d-47ca42271dac','65732831-20a9-4870-8f5f-32d7e3b71edb','d127c85a-f4fb-4d3b-8f59-81d332ea481b','e4c80e40-aaee-4127-9888-5e798aec080e','2016-08-07','CRS4','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','e68fa2ab-75bf-48b8-ab52-55f89e7a4787','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('117aba83-bcf0-418d-86e4-7252512a7716','65732831-20a9-4870-8f5f-32d7e3b71edb','d127c85a-f4fb-4d3b-8f59-81d332ea481b','e4c80e40-aaee-4127-9888-5e798aec080e','2016-06-04','CRS3','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','fe8c2142-a8a5-428b-b242-84d7f384c079','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('4afafba4-1d0d-493f-b0a6-c19a79b56d8a','65732831-20a9-4870-8f5f-32d7e3b71edb','d127c85a-f4fb-4d3b-8f59-81d332ea481b','e4c80e40-aaee-4127-9888-5e798aec080e','2016-08-07','CRS3','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','fe8c2142-a8a5-428b-b242-84d7f384c079','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('4b5aa77a-d09f-426a-b81b-727da84fb467','65732831-20a9-4870-8f5f-32d7e3b71edb','d127c85a-f4fb-4d3b-8f59-81d332ea481b','e4c80e40-aaee-4127-9888-5e798aec080e','2016-06-04','CRS4','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','fe8c2142-a8a5-428b-b242-84d7f384c079','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('58ec364f-7e3e-4a5b-b359-4388f33e3084','65732831-20a9-4870-8f5f-32d7e3b71edb','2dda14a2-c020-42b2-ba43-b663a86f30c5','e4c80e40-aaee-4127-9888-5e798aec080e','2016-08-07','CRS2','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','fe8c2142-a8a5-428b-b242-84d7f384c079','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('7f9d56df-dcd4-4659-a0d0-6675d6ba942c','65732831-20a9-4870-8f5f-32d7e3b71edb','d127c85a-f4fb-4d3b-8f59-81d332ea481b','e4c80e40-aaee-4127-9888-5e798aec080e','2016-05-11','CRS9','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','fe8c2142-a8a5-428b-b242-84d7f384c079','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('c1149961-09be-4d98-aa64-06d56c6d781e','65732831-20a9-4870-8f5f-32d7e3b71edb','963b3b08-0dd2-4cba-8ea7-fc4f306748c1','e4c80e40-aaee-4127-9888-5e798aec080e','2016-08-07','CRS1','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','fe8c2142-a8a5-428b-b242-84d7f384c079','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,4),('e1739cf4-c8ee-4c6d-9c8b-f34856ff5853','65732831-20a9-4870-8f5f-32d7e3b71edb','d127c85a-f4fb-4d3b-8f59-81d332ea481b','e4c80e40-aaee-4127-9888-5e798aec080e','2016-06-04','CRS2','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','fe8c2142-a8a5-428b-b242-84d7f384c079','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0),('f9be0949-037d-4116-abc6-12774b646009','65732831-20a9-4870-8f5f-32d7e3b71edb','2dda14a2-c020-42b2-ba43-b663a86f30c5','e4c80e40-aaee-4127-9888-5e798aec080e','2016-08-28','CRS2','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','e68fa2ab-75bf-48b8-ab52-55f89e7a4787','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0);
/*!40000 ALTER TABLE `course_registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_schedule`
--

DROP TABLE IF EXISTS `course_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_schedule` (
  `id` char(50) NOT NULL,
  `day` char(15) DEFAULT NULL,
  `fk_room` char(50) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `currency` (
  `id` char(50) NOT NULL,
  `code` char(15) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `is_default` char(1) DEFAULT '0',
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
-- Table structure for table `currency_exchange_factor`
--

DROP TABLE IF EXISTS `currency_exchange_factor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `currency_exchange_factor` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `fk_currency_from` char(50) DEFAULT NULL,
  `fk_currency_to` char(50) DEFAULT NULL,
  `value` decimal(10,0) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currency_exchange_factor`
--

LOCK TABLES `currency_exchange_factor` WRITE;
/*!40000 ALTER TABLE `currency_exchange_factor` DISABLE KEYS */;
/*!40000 ALTER TABLE `currency_exchange_factor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deduction`
--

DROP TABLE IF EXISTS `deduction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deduction` (
  `id` char(50) NOT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `fk_doduction_type` char(50) DEFAULT NULL,
  `fk_paycheck` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deduction_type` (
  `id` char(50) NOT NULL,
  `name` varchar(150) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deliverable` (
  `id` char(50) NOT NULL,
  `name` varchar(250) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `type` char(15) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `disbursement` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discount` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `value` decimal(10,0) DEFAULT NULL,
  `is_percent` char(1) DEFAULT '0',
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
INSERT INTO `discount` VALUES ('1beca9e8-7df2-44ac-b266-c1a0b58654ea','2016-01-01',NULL,'RANGKING 1-5',150000,'0',1),('39fc9fc5-d65e-4d0c-a243-4f90a7f68387','2016-01-01',NULL,'RANGKING 6-10',100000,'0',1),('568ba4cb-6367-4dd1-8b3d-2008f57f4008','2016-01-01',NULL,'KAKAK-ADIK',50000,'0',1),('962550e6-a193-4ebd-8944-27a2e4913d88','2016-01-01',NULL,'CASH',300000,'0',1),('997e05f9-0a1d-413c-bc9a-8d2589f6a102','2016-01-01',NULL,'ANAK GURU',100000,'0',1),('d3bf7373-9700-4a36-beb4-87cae75e4f52','2016-01-01',NULL,'MANTAN SISWA',25,'1',1);
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor` (
  `id` char(50) NOT NULL,
  `fk_doctor_type` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor_relationship` (
  `id` char(50) NOT NULL,
  `fk_doctor_type` char(50) DEFAULT NULL,
  `fk_doctor` char(50) DEFAULT NULL,
  `fk_internal_organization` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor_type` (
  `id` char(50) NOT NULL,
  `code` char(50) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` char(50) NOT NULL,
  `username` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('158b3342-ff53-4db6-b7d0-0538a76c76b5','user'),('71a2de84-c9c4-4ae2-85b0-439d47d6170d','sitikom'),('b8ae098a-a7bd-4977-b595-53ed28fae483',NULL),('fff0f880-04b8-4712-8989-4740a6b91866',NULL);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employer`
--

DROP TABLE IF EXISTS `employer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employer` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employer`
--

LOCK TABLES `employer` WRITE;
/*!40000 ALTER TABLE `employer` DISABLE KEYS */;
INSERT INTO `employer` VALUES ('bb700516-6872-40ca-b2db-2e49a3a2acb2');
/*!40000 ALTER TABLE `employer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employment`
--

DROP TABLE IF EXISTS `employment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employment` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employment`
--

LOCK TABLES `employment` WRITE;
/*!40000 ALTER TABLE `employment` DISABLE KEYS */;
INSERT INTO `employment` VALUES ('224a5af6-56b1-4e98-bce0-1755d43d3c90'),('afdb45bf-d586-47fa-812e-d57083b3b3ff'),('e1cf13d4-cb11-415d-b0fe-62b448f7a679');
/*!40000 ALTER TABLE `employment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employment_application`
--

DROP TABLE IF EXISTS `employment_application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employment_application` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `status_type` char(10) DEFAULT NULL,
  `source_type` char(15) DEFAULT NULL,
  `fk_position` char(50) DEFAULT NULL,
  `fk_person_referal` char(50) DEFAULT NULL,
  `fk_person_applicant` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `erp_mode` (
  `id` char(50) NOT NULL,
  `segmentation` char(15) DEFAULT 'GENERAL',
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facility` (
  `id` char(50) NOT NULL,
  `code` varchar(150) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `type` char(15) DEFAULT NULL,
  `fk_facility_parent` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facility`
--

LOCK TABLES `facility` WRITE;
/*!40000 ALTER TABLE `facility` DISABLE KEYS */;
INSERT INTO `facility` VALUES ('8de88fdd-1783-4500-a65e-5c8064212144',NULL,'Kebon Punggur','','PLANT',NULL,0),('9081de22-1c08-4a10-9e18-b99b88d47885',NULL,'Markas P. Aim','OK','BUILDING',NULL,1),('e63a8167-7ae8-4b53-93b7-bb5b9258f0ad',NULL,'Markas Nusa Indah','','OFFICE',NULL,0);
/*!40000 ALTER TABLE `facility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facility_organization`
--

DROP TABLE IF EXISTS `facility_organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facility_organization` (
  `id` char(50) NOT NULL,
  `enabled` char(1) DEFAULT NULL,
  `fk_facility` char(50) DEFAULT NULL,
  `organization_id` char(50) DEFAULT NULL,
  `organization_value` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facility_organization`
--

LOCK TABLES `facility_organization` WRITE;
/*!40000 ALTER TABLE `facility_organization` DISABLE KEYS */;
INSERT INTO `facility_organization` VALUES ('01c7a6d7-78da-4f6b-8c88-011de339147f','1','9081de22-1c08-4a10-9e18-b99b88d47885','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA',0),('2805d566-0a30-46df-89c9-14d4c1344319','1','9081de22-1c08-4a10-9e18-b99b88d47885','329f661e-3386-46f8-8d3a-5fa704b6f533','SONY SUGEMA COLLEGE',0),('5daeebb4-afc4-44d6-bb7e-65c3a1e05fde','0','9081de22-1c08-4a10-9e18-b99b88d47885','980d82f2-aa01-4511-b461-985f5fcbe6a1','Harry Corporation',0);
/*!40000 ALTER TABLE `facility_organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `family_folder`
--

DROP TABLE IF EXISTS `family_folder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `family_folder` (
  `id` char(50) NOT NULL,
  `name` varchar(150) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `family_member` (
  `id` char(50) NOT NULL,
  `fk_patient` char(50) DEFAULT NULL,
  `member_type` char(10) DEFAULT 'HEAD',
  `fk_folder` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `financial_account` (
  `id` char(50) NOT NULL,
  `name` varchar(250) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `financial_account_role` (
  `id` char(50) NOT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `fk_account` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `financial_account_transaction` (
  `id` char(50) NOT NULL,
  `transaction_date` date DEFAULT NULL,
  `entry_date` date DEFAULT NULL,
  `fk_payment` char(50) DEFAULT NULL,
  `fk_account` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `geographic` (
  `id` char(50) NOT NULL,
  `code` char(50) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `type` char(10) DEFAULT 'COUNTRY',
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `geographic`
--

LOCK TABLES `geographic` WRITE;
/*!40000 ALTER TABLE `geographic` DISABLE KEYS */;
INSERT INTO `geographic` VALUES ('68309a5f-4606-46d3-ad20-996ed6c782d0','KAL-BAR','Kalimantan Barat','PROVINCE','',0),('68309a5f-4606-46d3-ad20-996ed6c782dx','RSJ','Rasau Jaya','CITY','',0),('c4c10aee-a3a1-4e6c-a08b-62d4e26414df','PNK','Pontianak','CITY','',0),('d0ae6c1a-d6e2-4ca8-879d-52d74e6feb71','JABAR','Jawa Barat','PROVINCE','',0);
/*!40000 ALTER TABLE `geographic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gl_account`
--

DROP TABLE IF EXISTS `gl_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gl_account` (
  `id` char(50) NOT NULL,
  `number` char(50) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `type` char(15) DEFAULT NULL,
  `fk_gl_account_parent` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gl_account_balance` (
  `id` char(50) NOT NULL,
  `fk_accounting_period` char(50) DEFAULT NULL,
  `fk_gl_account` char(50) DEFAULT NULL,
  `fk_currency` char(50) DEFAULT NULL,
  `debet_balance` decimal(10,0) DEFAULT NULL,
  `credit_balance` decimal(10,0) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goods_issue_item` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `fk_request_item` char(50) DEFAULT NULL,
  `fk_transfer_order` char(50) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods_issue_item`
--

LOCK TABLES `goods_issue_item` WRITE;
/*!40000 ALTER TABLE `goods_issue_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods_issue_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods_transfer`
--

DROP TABLE IF EXISTS `goods_transfer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goods_transfer_item` (
  `id` char(50) NOT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `fk_transfer_order_request_item` char(50) DEFAULT NULL,
  `fk_goods_transfer` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods_transfer_item`
--

LOCK TABLES `goods_transfer_item` WRITE;
/*!40000 ALTER TABLE `goods_transfer_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods_transfer_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `healtcare_practitioner`
--

DROP TABLE IF EXISTS `healtcare_practitioner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `healtcare_practitioner` (
  `id` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `healtcare_practitioner`
--

LOCK TABLES `healtcare_practitioner` WRITE;
/*!40000 ALTER TABLE `healtcare_practitioner` DISABLE KEYS */;
/*!40000 ALTER TABLE `healtcare_practitioner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `healthcare_provider`
--

DROP TABLE IF EXISTS `healthcare_provider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `healthcare_provider` (
  `id` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `healthcare_provider`
--

LOCK TABLES `healthcare_provider` WRITE;
/*!40000 ALTER TABLE `healthcare_provider` DISABLE KEYS */;
/*!40000 ALTER TABLE `healthcare_provider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inbox`
--

DROP TABLE IF EXISTS `inbox`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inbox` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `is_open` char(1) DEFAULT '0',
  `title` varchar(150) DEFAULT NULL,
  `fk_sender` char(50) DEFAULT NULL,
  `fk_receiver` char(50) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `type` char(10) DEFAULT 'Standard',
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `internal_organization` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `internal_organization`
--

LOCK TABLES `internal_organization` WRITE;
/*!40000 ALTER TABLE `internal_organization` DISABLE KEYS */;
INSERT INTO `internal_organization` VALUES ('742fc487-8b9d-41d8-9a0c-b55772bc2c49');
/*!40000 ALTER TABLE `internal_organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory_item`
--

DROP TABLE IF EXISTS `inventory_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventory_item` (
  `id` char(50) NOT NULL,
  `serial_number` varchar(50) DEFAULT NULL,
  `product_id` char(50) DEFAULT NULL,
  `product_value` varchar(250) DEFAULT NULL,
  `on_hand` decimal(10,0) DEFAULT NULL,
  `facility_id` char(50) DEFAULT NULL,
  `facility_value` varchar(250) DEFAULT NULL,
  `expired_date` date DEFAULT NULL,
  `container_id` char(50) DEFAULT NULL,
  `container_value` varchar(200) DEFAULT NULL,
  `organization_id` char(50) DEFAULT NULL,
  `organization_value` varchar(250) DEFAULT NULL,
  `creator` varchar(250) DEFAULT NULL,
  `editor` varchar(250) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `last_edited` datetime DEFAULT NULL,
  `on_order` decimal(10,0) DEFAULT 0,
  `control` bigint(20) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory_item`
--

LOCK TABLES `inventory_item` WRITE;
/*!40000 ALTER TABLE `inventory_item` DISABLE KEYS */;
INSERT INTO `inventory_item` VALUES ('23714267-37fa-4db1-abf6-753aa02d501e',NULL,'17249794-ca76-467b-953f-a00a65404a77','Ayam Kota',1,'9081de22-1c08-4a10-9e18-b99b88d47885','Markas P. Aim',NULL,'5c43f5c3-ffd6-441f-bf63-30063f797f3a','A','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA',NULL,NULL,NULL,NULL,0,NULL,0),('6abcca90-1e12-412b-8cb7-84f0e3d46e0b',NULL,'64865838-5b79-40ca-a1e4-663d7139895a','Garang Asem Sapi',0,'9081de22-1c08-4a10-9e18-b99b88d47885','Markas P. Aim','2016-12-26','2ae63df9-e4c7-4b9d-bca6-fa25fb06ee08','A','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA',NULL,NULL,NULL,NULL,0,NULL,1),('8075845e-e02c-488e-9dd7-2f9e02f401a6','','','Ayam Kota Goreng',101,'Markas Nusa Indah',NULL,NULL,'a87af5ed-2982-4f7d-8f90-2d4420f4aa78','Lemari 1','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA','admin@belian.com','admin@belian.com','2016-09-29 09:43:07','2016-09-30 11:26:17',0,NULL,1),('b1f640a8-e179-4927-a7f2-bfc5496ca860',NULL,'64865838-5b79-40ca-a1e4-663d7139895a','Garang Asem Sapi',12,'9081de22-1c08-4a10-9e18-b99b88d47885','Markas P. Aim','2016-12-25','2ae63df9-e4c7-4b9d-bca6-fa25fb06ee08','A','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA',NULL,NULL,NULL,NULL,0,NULL,11);
/*!40000 ALTER TABLE `inventory_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice` (
  `id` char(50) NOT NULL,
  `number` char(50) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `note` varchar(200) DEFAULT NULL,
  `message` varchar(200) DEFAULT NULL,
  `billed_from_party_id` char(50) DEFAULT NULL,
  `billed_from_party_value` varchar(200) DEFAULT NULL,
  `billed_to_party_id` char(50) DEFAULT NULL,
  `billed_to_party_value` varchar(200) DEFAULT NULL,
  `billed_from_address_id` char(50) DEFAULT NULL,
  `billed_from_address_value` varchar(200) DEFAULT NULL,
  `billed_to_address_id` char(50) DEFAULT NULL,
  `billed_to_address_value` varchar(200) DEFAULT '0',
  `billed_from_contact_id` char(50) DEFAULT NULL,
  `billed_from_contact_value` varchar(200) DEFAULT NULL,
  `billed_to_contact_id` char(50) DEFAULT NULL,
  `billed_to_contact_value` varchar(200) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES ('3b695877-11a8-4ef6-8e27-7e0e99b3d2a0','SIV-19012017-2','2017-01-19','Bayar','Bayar ye','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA','a685cde5-df6b-4430-babc-0ae846f8fa29','Rizky Chicken','276c8e3b-b325-4376-80a1-4da38cd87a02','Alamat Kantor','1f876140-6015-4d4d-9e23-b742a1457d89','Alamat Kantor','d795793e-2523-4ee3-be85-da96659669a0','No HP','26b5ad5b-4990-4329-b535-25b9a7b7278c','Telp Kantor',0),('68ec9160-400e-40e7-ab45-b9ced12330a5','SIV-14012017-2','2017-01-14','ok','ok','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA','a685cde5-df6b-4430-babc-0ae846f8fa29','Rizky Chicken','b67d4171-9534-4956-9e11-9c7aec08b01c','Warehouse Address','1f876140-6015-4d4d-9e23-b742a1457d89','Office Address','d795793e-2523-4ee3-be85-da96659669a0','Cellphone','26b5ad5b-4990-4329-b535-25b9a7b7278c','Office Phone',0);
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice_item`
--

DROP TABLE IF EXISTS `invoice_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice_item` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `taxable` char(1) DEFAULT '0',
  `type` char(40) DEFAULT NULL,
  `product_id` char(50) DEFAULT NULL,
  `product_value` varchar(200) DEFAULT NULL,
  `feature_id` char(50) DEFAULT NULL,
  `feature_value` varchar(200) DEFAULT NULL,
  `fk_sold_with` char(50) DEFAULT NULL,
  `fk_invoice` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice_item`
--

LOCK TABLES `invoice_item` WRITE;
/*!40000 ALTER TABLE `invoice_item` DISABLE KEYS */;
INSERT INTO `invoice_item` VALUES ('92354e7b-558b-4911-834d-48dbefd10fcb',70,1740000,'0','INVOICE_PRODUCT','64865838-5b79-40ca-a1e4-663d7139895a','Garang Asem Sapi',NULL,NULL,NULL,'3b695877-11a8-4ef6-8e27-7e0e99b3d2a0',0);
/*!40000 ALTER TABLE `invoice_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice_order_item_billing`
--

DROP TABLE IF EXISTS `invoice_order_item_billing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice_order_item_billing` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `order_item_id` char(50) DEFAULT NULL,
  `order_item_value` varchar(200) DEFAULT NULL,
  `order_id` char(50) DEFAULT NULL,
  `order_value` varchar(200) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice_order_item_billing`
--

LOCK TABLES `invoice_order_item_billing` WRITE;
/*!40000 ALTER TABLE `invoice_order_item_billing` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice_order_item_billing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice_role`
--

DROP TABLE IF EXISTS `invoice_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice_role` (
  `id` char(50) NOT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `type` char(15) DEFAULT NULL,
  `party_id` char(50) DEFAULT NULL,
  `party_value` varchar(200) DEFAULT NULL,
  `fk_invoice` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice_role`
--

LOCK TABLES `invoice_role` WRITE;
/*!40000 ALTER TABLE `invoice_role` DISABLE KEYS */;
INSERT INTO `invoice_role` VALUES ('6a62a92b-0dda-4295-b10a-f9657b43b676','2017-01-14 02:21:00','ENTERED_BY','c21873ef-3e29-43ca-92cd-45b5eb519c6e','Siti Komarudin','68ec9160-400e-40e7-ab45-b9ced12330a5',0),('e82a7f4b-85d0-4ce4-a54e-f397855c6edd','2017-01-19 01:34:58','ENTERED_BY','c21873ef-3e29-43ca-92cd-45b5eb519c6e','Siti Komarudin','3b695877-11a8-4ef6-8e27-7e0e99b3d2a0',0);
/*!40000 ALTER TABLE `invoice_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice_shipment_item_billing`
--

DROP TABLE IF EXISTS `invoice_shipment_item_billing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice_shipment_item_billing` (
  `id` char(50) NOT NULL,
  `shipment_item_id` char(50) DEFAULT NULL,
  `shipment_item_value` varchar(200) DEFAULT NULL,
  `fk_invoice_item` char(50) DEFAULT NULL,
  `shipment_id` char(50) DEFAULT NULL,
  `shipment_value` varchar(200) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice_shipment_item_billing`
--

LOCK TABLES `invoice_shipment_item_billing` WRITE;
/*!40000 ALTER TABLE `invoice_shipment_item_billing` DISABLE KEYS */;
INSERT INTO `invoice_shipment_item_billing` VALUES ('86162d16-7dbb-464a-b5b7-f13dcaf8cd9c','6dcd1cce-2238-4b42-955e-936e626cadfc','Garang Asem Sapi','92354e7b-558b-4911-834d-48dbefd10fcb','3c09618e-e89e-4d3c-bbab-cdf8f91f1366','SHP-19012017-1',0),('b484e752-a902-494b-a00a-de60464eb5df','357f98ea-e4ef-4bde-8c4f-66deb821e490','Garang Asem Sapi','92354e7b-558b-4911-834d-48dbefd10fcb','fe1fe914-74c7-4ffe-af6b-855df8d217de','SHP-15012017-1',0);
/*!40000 ALTER TABLE `invoice_shipment_item_billing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice_status`
--

DROP TABLE IF EXISTS `invoice_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice_status` (
  `id` char(50) NOT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `type` char(10) DEFAULT NULL,
  `fk_invoice` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice_status`
--

LOCK TABLES `invoice_status` WRITE;
/*!40000 ALTER TABLE `invoice_status` DISABLE KEYS */;
INSERT INTO `invoice_status` VALUES ('c5a3b44f-f386-4882-bd98-e3364a67cb6d','2017-01-14 02:23:00','SEND','68ec9160-400e-40e7-ab45-b9ced12330a5',0);
/*!40000 ALTER TABLE `invoice_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice_term`
--

DROP TABLE IF EXISTS `invoice_term`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice_term` (
  `id` char(50) NOT NULL,
  `value` decimal(10,0) DEFAULT NULL,
  `type` char(15) DEFAULT NULL,
  `fk_invoice` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice_term`
--

LOCK TABLES `invoice_term` WRITE;
/*!40000 ALTER TABLE `invoice_term` DISABLE KEYS */;
INSERT INTO `invoice_term` VALUES ('24bb5fd2-1677-43c9-8cbf-15e2eb7d75a5',1,'PAYMENT','68ec9160-400e-40e7-ab45-b9ced12330a5',0);
/*!40000 ALTER TABLE `invoice_term` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice_time_entry_billing`
--

DROP TABLE IF EXISTS `invoice_time_entry_billing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice_time_entry_billing` (
  `id` char(50) NOT NULL,
  `hour` decimal(10,0) DEFAULT NULL,
  `time_entry_id` char(50) DEFAULT NULL,
  `time_entry_value` varchar(200) DEFAULT '0',
  `fk_invoice_item` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice_time_entry_billing`
--

LOCK TABLES `invoice_time_entry_billing` WRITE;
/*!40000 ALTER TABLE `invoice_time_entry_billing` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice_time_entry_billing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice_work_effort_billing`
--

DROP TABLE IF EXISTS `invoice_work_effort_billing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice_work_effort_billing` (
  `id` char(50) NOT NULL,
  `percent` decimal(10,0) DEFAULT NULL,
  `work_effort_id` char(50) DEFAULT NULL,
  `work_effort_value` varchar(200) DEFAULT NULL,
  `fk_invoice_item` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice_work_effort_billing`
--

LOCK TABLES `invoice_work_effort_billing` WRITE;
/*!40000 ALTER TABLE `invoice_work_effort_billing` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice_work_effort_billing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `journal_entry`
--

DROP TABLE IF EXISTS `journal_entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `journal_entry_detail` (
  `id` char(50) NOT NULL,
  `fk_gl_account` char(50) DEFAULT NULL,
  `type` char(6) DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `fk_journal_entry` char(50) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_journal_posting` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `journal_posting` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `type` char(6) DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `fk_gl_account_balance` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `journal_setting` (
  `id` char(50) NOT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `fk_gl_account_cash` char(50) DEFAULT NULL,
  `fk_gl_account_sales` char(50) DEFAULT NULL,
  `fk_gl_account_ppn_payable` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `laboratory` (
  `id` char(50) NOT NULL,
  `is_bpjs` char(1) DEFAULT '0',
  `bpjs_payment_status` char(10) DEFAULT NULL,
  `lab_handling_status` char(10) DEFAULT NULL,
  `is_personal` char(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `laboratory_item` (
  `id` char(50) NOT NULL,
  `fk_product_service` char(50) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `discount` decimal(10,0) DEFAULT NULL,
  `charge` decimal(10,0) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_laboratory` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laboratory_item`
--

LOCK TABLES `laboratory_item` WRITE;
/*!40000 ALTER TABLE `laboratory_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `laboratory_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laboratory_sales`
--

DROP TABLE IF EXISTS `laboratory_sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `laboratory_sales` (
  `id` char(50) NOT NULL,
  `is_bpjs` char(1) DEFAULT '0',
  `bpjs_payment_status` char(10) DEFAULT NULL,
  `lab_handling_status` char(10) DEFAULT NULL,
  `is_personal` char(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `laboratory_sales_item` (
  `id` char(50) NOT NULL,
  `fk_product_service` char(50) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `discount` decimal(10,0) DEFAULT NULL,
  `charge` decimal(10,0) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_laboratory` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laboratory_sales_item`
--

LOCK TABLES `laboratory_sales_item` WRITE;
/*!40000 ALTER TABLE `laboratory_sales_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `laboratory_sales_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marital_status`
--

DROP TABLE IF EXISTS `marital_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marital_status` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `type` char(25) DEFAULT 'SINGLE',
  `fk_person` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marital_status`
--

LOCK TABLES `marital_status` WRITE;
/*!40000 ALTER TABLE `marital_status` DISABLE KEYS */;
INSERT INTO `marital_status` VALUES ('1d57fe23-cf54-4f3a-99de-9db8de9d119f','2016-09-11',NULL,'SINGLE','017973d0-bdbc-4b6a-9b1e-bff197ab71f0',0);
/*!40000 ALTER TABLE `marital_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_record`
--

DROP TABLE IF EXISTS `medical_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical_sales` (
  `id` char(50) NOT NULL,
  `queue` int(11) DEFAULT NULL,
  `time` time DEFAULT NULL,
  `status` char(15) DEFAULT 'Registered',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical_treatment_sales` (
  `id` char(50) NOT NULL,
  `is_bpjs` char(1) DEFAULT '0',
  `bpjs_payment_status` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical_treatment_sales_item` (
  `id` char(50) NOT NULL,
  `fk_product_treatment` char(50) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `discount` decimal(10,0) DEFAULT NULL,
  `charge` decimal(10,0) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_treatment` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_treatment_sales_item`
--

LOCK TABLES `medical_treatment_sales_item` WRITE;
/*!40000 ALTER TABLE `medical_treatment_sales_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `medical_treatment_sales_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medication`
--

DROP TABLE IF EXISTS `medication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medication` (
  `id` char(50) NOT NULL,
  `is_bpjs` char(1) DEFAULT '0',
  `bpjs_payment_status` char(10) DEFAULT NULL,
  `medication_status` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medication_item` (
  `id` char(50) NOT NULL,
  `fk_product_medicine` char(50) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `discount` decimal(10,0) DEFAULT NULL,
  `charge` decimal(10,0) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_medication` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `title` varchar(150) DEFAULT NULL,
  `fk_sender` char(50) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `type` char(10) DEFAULT 'Draft',
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message_receiver` (
  `id` char(50) NOT NULL,
  `fk_receiver` char(50) DEFAULT NULL,
  `fk_message` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_receiver`
--

LOCK TABLES `message_receiver` WRITE;
/*!40000 ALTER TABLE `message_receiver` DISABLE KEYS */;
/*!40000 ALTER TABLE `message_receiver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notification` (
  `id` char(50) NOT NULL,
  `new_message` int(11) DEFAULT 0,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
INSERT INTO `notification` VALUES ('admin@belian.com',0,0),('sitikom',0,8),('user',0,1);
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_adjustment`
--

DROP TABLE IF EXISTS `order_adjustment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_adjustment` (
  `id` char(50) NOT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `percent` decimal(10,0) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `fk_order` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_adjustment`
--

LOCK TABLES `order_adjustment` WRITE;
/*!40000 ALTER TABLE `order_adjustment` DISABLE KEYS */;
INSERT INTO `order_adjustment` VALUES ('1493b06c-a71a-45aa-b0ea-1233b0ff7c1a',0,10,'TAX','ac5ef13a-c2ce-4ecb-9c3e-a911a7ad08f1',0),('1509df75-e52d-4b4a-819e-4ad1bddc63c2',0,10,'TAX','e9a8f83a-c00e-424c-957a-c15a81f5262e',0),('25c1adeb-ca89-4a83-a3a3-a8fc287b9129',5000,0,'FEE','e9a8f83a-c00e-424c-957a-c15a81f5262e',0),('4fde23e0-e928-447c-a7fb-a0a868ed8c72',0,5,'DISCOUNT','e9a8f83a-c00e-424c-957a-c15a81f5262e',0),('5d98964d-81b7-4a85-a059-bb0c15a7fbbc',0,10,'TAX','388f9588-fddd-45ba-a328-bd41e24729e4',0),('77bee1c4-7b1b-4478-8e48-2b014aecfa28',0,10,'TAX','90fdcd0a-d324-4cab-a18c-25f27c06351f',0),('9c8ecff9-0e4d-4e77-a32c-f12420207005',0,10,'TAX','eac4a1d1-454b-4a15-b35b-b631c595ed04',0),('ba3c4713-e43e-4ea7-8e14-f39f5b2d2b00',0,10,'TAX','ea69c005-d007-476d-931c-02e7b6daa147',0);
/*!40000 ALTER TABLE `order_adjustment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item`
--

DROP TABLE IF EXISTS `order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_item` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `unit_price` decimal(10,0) DEFAULT NULL,
  `uom_id` char(50) DEFAULT NULL,
  `uom_value` varchar(250) DEFAULT NULL,
  `product_id` char(50) DEFAULT NULL,
  `product_value` varchar(250) DEFAULT NULL,
  `product_feature_id` char(50) DEFAULT NULL,
  `product_feature_value` varchar(250) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_order` char(50) DEFAULT NULL,
  `type` char(10) DEFAULT 'PRODUCT',
  `is_shipped` char(1) DEFAULT '0',
  `processed` decimal(10,0) DEFAULT 0,
  `invoiced` char(1) DEFAULT '0',
  `requirement` char(1) DEFAULT '0',
  `workeffort` char(1) DEFAULT '0',
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
INSERT INTO `order_item` VALUES ('15403535-f3a1-4aa6-9db1-c1af69c4088d',12,25000,'46ff493b-776b-4b9c-b199-39b9ef3b5f19','Potong','64865838-5b79-40ca-a1e4-663d7139895a','Garang Asem Sapi',NULL,NULL,'','eac4a1d1-454b-4a15-b35b-b631c595ed04','PRODUCT','0',0,'0','0','0',0),('2a45c16a-b549-4b23-9e20-81badf2e7749',1,18000,NULL,NULL,'1e21e36a-4244-4eb3-bdbe-902cde4cf9b7','Ayam Kampung Goreng',NULL,NULL,'','90fdcd0a-d324-4cab-a18c-25f27c06351f','PRODUCT','0',0,'0','0','0',0),('4afa09ca-4628-47e2-b3a0-f0040c6477c8',1,0,'eb23ea67-cdda-4668-8624-872fdf445a0c','Ekor','17249794-ca76-467b-953f-a00a65404a77','Ayam Kota',NULL,NULL,'Ayam Kota','ec50085f-9f93-4a65-9d70-4be09ec927cc','PRODUCT','0',0,'0','0','0',1),('65700f58-c5ca-45c4-9783-d09cca76a8f9',1,15000,NULL,NULL,'f2e41156-6eb1-4dc4-bd9a-05d38a712554','Ayam Kota Potong 4',NULL,NULL,'','90fdcd0a-d324-4cab-a18c-25f27c06351f','PRODUCT','0',0,'0','0','0',0),('8c9e24e2-7454-43fa-b091-823100d8aa2f',10,15000,'46ff493b-776b-4b9c-b199-39b9ef3b5f19','Potong','64865838-5b79-40ca-a1e4-663d7139895a','Garang Asem Sapi',NULL,NULL,'','7411fc95-25a0-458b-afe9-7d1505a3fda6','PRODUCT','1',10,'0','0','0',17),('9dd39daa-4c00-4a07-853a-60e36312a838',10,23000,'46ff493b-776b-4b9c-b199-39b9ef3b5f19','Potong','64865838-5b79-40ca-a1e4-663d7139895a','Garang Asem Sapi',NULL,NULL,'','ea69c005-d007-476d-931c-02e7b6daa147','PRODUCT','0',5,'0','0','0',17),('a2251e43-bfd6-4ca4-8e92-ca1af78a70fd',1,50000,'d43b50b5-3819-45e6-822f-707c7d64cb5f','Visit','bcfc5b16-4533-4a65-a8b1-2dbf0510ff32','Pemeriksaan Dokter Umum',NULL,NULL,'','388f9588-fddd-45ba-a328-bd41e24729e4','WORK','0',0,'0','1','1',2),('b9974139-3c85-49d7-9418-f5a7800a7e00',100,25000,'46ff493b-776b-4b9c-b199-39b9ef3b5f19','Potong','64865838-5b79-40ca-a1e4-663d7139895a','Garang Asem Sapi',NULL,NULL,'','ac5ef13a-c2ce-4ecb-9c3e-a911a7ad08f1','PRODUCT','0',50,'0','0','0',10),('e19b02e9-b430-4f55-bf6a-8e35755d8203',10,25000,'46ff493b-776b-4b9c-b199-39b9ef3b5f19','Potong','64865838-5b79-40ca-a1e4-663d7139895a','Garang Asem Sapi',NULL,NULL,'','e9a8f83a-c00e-424c-957a-c15a81f5262e','PRODUCT','0',0,'0','0','0',0);
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item_assosiation`
--

DROP TABLE IF EXISTS `order_item_assosiation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_item_assosiation` (
  `id` char(50) NOT NULL,
  `sales_item` char(50) DEFAULT NULL,
  `purchase_item` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item_assosiation`
--

LOCK TABLES `order_item_assosiation` WRITE;
/*!40000 ALTER TABLE `order_item_assosiation` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_item_assosiation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_payment`
--

DROP TABLE IF EXISTS `order_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_payment` (
  `id` char(50) NOT NULL,
  `fk_purchase_order` char(50) DEFAULT NULL,
  `fk_payment_item` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_payment`
--

LOCK TABLES `order_payment` WRITE;
/*!40000 ALTER TABLE `order_payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_role`
--

DROP TABLE IF EXISTS `order_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_role` (
  `id` char(50) NOT NULL,
  `person_id` char(50) DEFAULT NULL,
  `person_value` varchar(250) DEFAULT NULL,
  `type` char(50) DEFAULT NULL,
  `fk_order` char(50) DEFAULT NULL,
  `percent_contribution` decimal(10,0) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_role`
--

LOCK TABLES `order_role` WRITE;
/*!40000 ALTER TABLE `order_role` DISABLE KEYS */;
INSERT INTO `order_role` VALUES ('123ec1e6-0314-4315-8c25-05f3a8283002','c21873ef-3e29-43ca-92cd-45b5eb519c6e','Siti Komarudin','SALESPERSON','ea69c005-d007-476d-931c-02e7b6daa147',0,0),('291b6366-2e8e-4c94-9be4-177b0ae65473','c21873ef-3e29-43ca-92cd-45b5eb519c6e','Siti Komarudin','SALESPERSON','eac4a1d1-454b-4a15-b35b-b631c595ed04',0,0),('59539da3-ec61-4fa7-a3a4-025df8155610','c21873ef-3e29-43ca-92cd-45b5eb519c6e','Siti Komarudin','SALESPERSON','e9a8f83a-c00e-424c-957a-c15a81f5262e',0,0),('6a086e83-df96-41ba-a6a5-0cda093aee88','c21873ef-3e29-43ca-92cd-45b5eb519c6e','Siti Komarudin','SALESPERSON','388f9588-fddd-45ba-a328-bd41e24729e4',0,0),('8670cefb-d707-48aa-a075-c7d2010f68d6','895f107c-991a-4173-8dba-f6a906e13cef','DODI','SALESPERSON','90fdcd0a-d324-4cab-a18c-25f27c06351f',0,0),('eac2b4db-a4b9-4059-bdd7-443ef8903dfc','c21873ef-3e29-43ca-92cd-45b5eb519c6e','Siti Komarudin','SALESPERSON','ac5ef13a-c2ce-4ecb-9c3e-a911a7ad08f1',0,0);
/*!40000 ALTER TABLE `order_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_status`
--

DROP TABLE IF EXISTS `order_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_status` (
  `id` char(50) NOT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `fk_order` char(50) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_status`
--

LOCK TABLES `order_status` WRITE;
/*!40000 ALTER TABLE `order_status` DISABLE KEYS */;
INSERT INTO `order_status` VALUES ('238ea040-c434-4dbe-a388-225a0d120480','2017-01-22 07:37:30','388f9588-fddd-45ba-a328-bd41e24729e4','ACTIVE',0),('5e4ab688-2886-4c52-abd8-d56f214d00da','2017-01-16 02:17:06','ac5ef13a-c2ce-4ecb-9c3e-a911a7ad08f1','ACTIVE',0),('7e987489-d3ed-4d12-a586-c38ac4a6ac70','2016-10-20 02:39:38','90fdcd0a-d324-4cab-a18c-25f27c06351f','RECEIVED',0),('8139a676-c36b-4319-8c73-2497735b25dc','2016-12-19 02:49:51','ea69c005-d007-476d-931c-02e7b6daa147','ACTIVE',0),('afc92cf4-3d8b-408d-aecb-3166e037cd1d','2016-12-19 02:46:36','eac4a1d1-454b-4a15-b35b-b631c595ed04','ACTIVE',0),('df8785ca-d2f7-49d4-ae33-099345fa0793','2017-01-15 13:55:03','e9a8f83a-c00e-424c-957a-c15a81f5262e','ACTIVE',0);
/*!40000 ALTER TABLE `order_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_term`
--

DROP TABLE IF EXISTS `order_term`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_term` (
  `id` char(50) NOT NULL,
  `fk_order` char(50) DEFAULT NULL,
  `order_item` varchar(250) DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `term_id` char(50) DEFAULT NULL,
  `term_value` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_term`
--

LOCK TABLES `order_term` WRITE;
/*!40000 ALTER TABLE `order_term` DISABLE KEYS */;
INSERT INTO `order_term` VALUES ('2094b15c-f44e-426f-be90-14c0d7efd8fb','ac5ef13a-c2ce-4ecb-9c3e-a911a7ad08f1','',0,'00000','Tempo Pembayaran (Hari)',0),('26b3edd2-a76a-4c2f-a0fd-6d5a4e0dc1b4','90fdcd0a-d324-4cab-a18c-25f27c06351f','',7,'fd4a9dfa-a4fb-4557-89c8-8328a1f2b412','Jangka Waktu Kridit (Credit Term)',0),('48a54967-c1b6-4a5b-ad53-0e156118cd25','ea69c005-d007-476d-931c-02e7b6daa147','',0,'00000','Tempo Pembayaran (Hari)',0),('7b4962d4-59f5-47ad-a78d-1046f4238a4e','eac4a1d1-454b-4a15-b35b-b631c595ed04','',0,'00000','Tempo Pembayaran (Hari)',0),('81a0c948-e969-4f37-97a7-fa47f98752dd','e9a8f83a-c00e-424c-957a-c15a81f5262e','',0,'00000','Tempo Pembayaran (Hari)',0),('aad0e698-2664-4d7f-ac35-90c4c299674f','388f9588-fddd-45ba-a328-bd41e24729e4','',0,'00000','Tempo Pembayaran (Hari)',0),('afa5d27e-5c75-4a07-8a9e-b573d51bde5e','90fdcd0a-d324-4cab-a18c-25f27c06351f','Ayam kota potong 4',1,'fd4a9dfa-a4fb-4557-89c8-8328a1f2b412','Jangka Waktu Kridit (Credit Term)',0);
/*!40000 ALTER TABLE `order_term` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_value`
--

DROP TABLE IF EXISTS `order_value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_value` (
  `id` char(50) NOT NULL,
  `min` decimal(10,0) DEFAULT NULL,
  `max` decimal(10,0) DEFAULT NULL,
  `value` bigint(20) DEFAULT 0,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_value`
--

LOCK TABLES `order_value` WRITE;
/*!40000 ALTER TABLE `order_value` DISABLE KEYS */;
INSERT INTO `order_value` VALUES ('08249304-a0a4-4532-9c08-79e9e9e32623',0,0,0,0),('0a3398c1-12d9-43fc-b63f-01d3a0efbc75',0,0,0,0),('10ad7c81-fea2-4b78-ac78-32345ef7e1e7',0,0,0,0),('19c105e8-1d66-4d6e-9ff5-9584c447283b',0,0,0,0),('33052b93-a540-41fd-92d5-fb1dd0f47291',0,0,0,0),('47c1bbe4-5fd6-4185-b3ca-cb58d21ec846',0,0,0,0),('488b6999-480e-47b7-9a14-7d3699eafece',0,0,0,0),('48b029e5-73f6-438f-a1d3-cc8c215e607a',0,0,0,0),('51e24f7f-ae8c-4f67-b3c7-7742415d3b2a',0,0,0,0),('5343807f-1b07-473d-be60-c88e70cf6a14',0,0,0,0),('70c6e029-2843-467b-899b-6fdc67a420b1',0,0,0,0),('790df32d-701a-4d92-b1a2-3aa517f9f91b',0,0,0,0),('80ac4b47-186a-486a-a4e0-e497f8e66eeb',0,0,0,0),('95a5bda0-d81e-4077-b1c2-2ffcbb8c7a44',0,0,0,0),('a9927c26-e787-4869-8caf-e7b731fd6152',0,0,0,0),('c0488a1f-3323-4b15-98e9-71ec7e79eced',0,0,0,0),('c0f88fe9-04b1-4818-8ed0-af1706372687',0,0,0,0),('d9eb6823-d62e-4f3b-b3d6-1170fc517f33',0,0,0,0),('db2bff56-a35b-4373-8074-419d7546bdd4',0,0,0,0),('e8480951-1111-4a55-ac0f-5e2cc744566d',0,0,0,0),('f297b701-536f-4783-9591-fedbd4f0a94e',0,0,0,0);
/*!40000 ALTER TABLE `order_value` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` char(50) NOT NULL,
  `document_number` char(50) DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `entry_date` date DEFAULT NULL,
  `billing_address_id` char(50) DEFAULT NULL,
  `billing_address_value` varchar(250) DEFAULT NULL,
  `shipping_address_id` char(50) DEFAULT NULL,
  `shipping_address_value` varchar(250) DEFAULT NULL,
  `placing_order_id` char(50) DEFAULT NULL,
  `placing_order_value` varchar(250) DEFAULT NULL,
  `taking_order_id` char(50) DEFAULT NULL,
  `taking_order_value` varchar(250) DEFAULT NULL,
  `ship_to_party_id` char(50) DEFAULT NULL,
  `ship_to_party_value` varchar(250) DEFAULT NULL,
  `bill_to_id` char(50) DEFAULT NULL,
  `bill_to_value` varchar(250) DEFAULT NULL,
  `ship_to_contact_id` char(50) DEFAULT NULL,
  `ship_to_contact_value` varchar(250) DEFAULT NULL,
  `bill_to_contact_id` char(50) DEFAULT NULL,
  `bill_to_contact_value` varchar(250) DEFAULT NULL,
  `bill_to_party_id` char(50) DEFAULT NULL,
  `bill_to_party_value` varchar(250) DEFAULT NULL,
  `currency_id` char(50) DEFAULT NULL,
  `currency_value` varchar(250) DEFAULT NULL,
  `transaction_type` char(10) DEFAULT 'STANDARD',
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES ('388f9588-fddd-45ba-a328-bd41e24729e4','SO-22012017-1','2017-01-22','2017-01-22','9242a17f-2b52-4110-a816-ec6777fdbe40','Home Address','9242a17f-2b52-4110-a816-ec6777fdbe40','Home Address','895f107c-991a-4173-8dba-f6a906e13cef','DODI','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA','895f107c-991a-4173-8dba-f6a906e13cef','DODI',NULL,NULL,'1dc8d4cc-8471-4d9b-a7f9-4c5a18491f6b','Cellphone','1dc8d4cc-8471-4d9b-a7f9-4c5a18491f6b','Cellphone','895f107c-991a-4173-8dba-f6a906e13cef','DODI','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','STANDARD',0),('7411fc95-25a0-458b-afe9-7d1505a3fda6','PO201120162','2016-12-20','2016-12-20','1f876140-6015-4d4d-9e23-b742a1457d89','Alamat Kantor','276c8e3b-b325-4376-80a1-4da38cd87a02','Alamat Kantor','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA','a685cde5-df6b-4430-babc-0ae846f8fa29','Rizky Chicken','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA',NULL,NULL,'d795793e-2523-4ee3-be85-da96659669a0','No HP','26b5ad5b-4990-4329-b535-25b9a7b7278c','Telp Kantor','a685cde5-df6b-4430-babc-0ae846f8fa29','Rizky Chicken','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','STANDARD',0),('90fdcd0a-d324-4cab-a18c-25f27c06351f','Number','2016-10-20','2016-10-20','276c8e3b-b325-4376-80a1-4da38cd87a02','Office Address','b67d4171-9534-4956-9e11-9c7aec08b01c','Office Address','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA','895f107c-991a-4173-8dba-f6a906e13cef','DODI','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA',NULL,NULL,'d795793e-2523-4ee3-be85-da96659669a0','Office Phone','d795793e-2523-4ee3-be85-da96659669a0','Office Phone','329f661e-3386-46f8-8d3a-5fa704b6f533','SONY SUGEMA COLLEGE','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','STANDARD',1),('ac5ef13a-c2ce-4ecb-9c3e-a911a7ad08f1','SO-16012017-1','2017-01-16','2017-01-16','1f876140-6015-4d4d-9e23-b742a1457d89','Alamat Kantor','1f876140-6015-4d4d-9e23-b742a1457d89','Alamat Kantor','a685cde5-df6b-4430-babc-0ae846f8fa29','Rizky Chicken','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA','a685cde5-df6b-4430-babc-0ae846f8fa29','Rizky Chicken',NULL,NULL,'26b5ad5b-4990-4329-b535-25b9a7b7278c','Telp Kantor','26b5ad5b-4990-4329-b535-25b9a7b7278c','Telp Kantor','a685cde5-df6b-4430-babc-0ae846f8fa29','Rizky Chicken','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','STANDARD',0),('e9a8f83a-c00e-424c-957a-c15a81f5262e','SO-15012017-1','2017-01-15','2017-01-15','1f876140-6015-4d4d-9e23-b742a1457d89','Office Address','1f876140-6015-4d4d-9e23-b742a1457d89','Office Address','a685cde5-df6b-4430-babc-0ae846f8fa29','Rizky Chicken','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA','a685cde5-df6b-4430-babc-0ae846f8fa29','Rizky Chicken',NULL,NULL,'26b5ad5b-4990-4329-b535-25b9a7b7278c','Office Phone','26b5ad5b-4990-4329-b535-25b9a7b7278c','Office Phone','a685cde5-df6b-4430-babc-0ae846f8fa29','Rizky Chicken','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','STANDARD',1),('ea69c005-d007-476d-931c-02e7b6daa147','SO191120162','2016-12-19','2016-12-19','1f876140-6015-4d4d-9e23-b742a1457d89','Alamat Kantor','1f876140-6015-4d4d-9e23-b742a1457d89','Alamat Kantor','a685cde5-df6b-4430-babc-0ae846f8fa29','Rizky Chicken','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA','a685cde5-df6b-4430-babc-0ae846f8fa29','Rizky Chicken',NULL,NULL,'26b5ad5b-4990-4329-b535-25b9a7b7278c','Telp Kantor','26b5ad5b-4990-4329-b535-25b9a7b7278c','Telp Kantor','a685cde5-df6b-4430-babc-0ae846f8fa29','Rizky Chicken','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','POS',0),('eac4a1d1-454b-4a15-b35b-b631c595ed04','SO191120161','2016-12-19','2016-12-19','1f876140-6015-4d4d-9e23-b742a1457d89','Alamat Kantor','1f876140-6015-4d4d-9e23-b742a1457d89','Alamat Kantor','a685cde5-df6b-4430-babc-0ae846f8fa29','Rizky Chicken','a685cde5-df6b-4430-babc-0ae846f8fa29','Rizky Chicken','a685cde5-df6b-4430-babc-0ae846f8fa29','Rizky Chicken',NULL,NULL,'26b5ad5b-4990-4329-b535-25b9a7b7278c','Telp Kantor','26b5ad5b-4990-4329-b535-25b9a7b7278c','Telp Kantor','a685cde5-df6b-4430-babc-0ae846f8fa29','Rizky Chicken','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','POS',0),('ec50085f-9f93-4a65-9d70-4be09ec927cc','PO161120161','2016-12-16','2016-12-16','1f876140-6015-4d4d-9e23-b742a1457d89','Alamat Kantor','276c8e3b-b325-4376-80a1-4da38cd87a02','Alamat Kantor','c21873ef-3e29-43ca-92cd-45b5eb519c6e','Siti Komarudin','a685cde5-df6b-4430-babc-0ae846f8fa29','Rizky Chicken','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA',NULL,NULL,'d795793e-2523-4ee3-be85-da96659669a0','No HP','26b5ad5b-4990-4329-b535-25b9a7b7278c','Telp Kantor','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','STANDARD',0);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organization_account`
--

DROP TABLE IF EXISTS `organization_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organization_account` (
  `id` char(50) NOT NULL,
  `name` varchar(150) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `status` char(1) DEFAULT '0',
  `fk_organization` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organization_gl_account` (
  `id` char(50) NOT NULL,
  `is_selected` char(1) DEFAULT '0',
  `fk_account` char(50) DEFAULT NULL,
  `fk_organization_account` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization_gl_account`
--

LOCK TABLES `organization_gl_account` WRITE;
/*!40000 ALTER TABLE `organization_gl_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `organization_gl_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organization_period`
--

DROP TABLE IF EXISTS `organization_period`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organization_period` (
  `id` char(50) NOT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `fk_accounting_period` char(50) DEFAULT NULL,
  `is_closed` char(1) DEFAULT '0',
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization_period`
--

LOCK TABLES `organization_period` WRITE;
/*!40000 ALTER TABLE `organization_period` DISABLE KEYS */;
/*!40000 ALTER TABLE `organization_period` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `party`
--

DROP TABLE IF EXISTS `party`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `party` (
  `id` char(50) NOT NULL,
  `name` varchar(150) DEFAULT NULL,
  `fk_geographic_birth_place` char(50) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `tax_code` char(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  `is_system` int(11) DEFAULT 0,
  `gender` char(6) DEFAULT NULL,
  `type` char(15) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party`
--

LOCK TABLES `party` WRITE;
/*!40000 ALTER TABLE `party` DISABLE KEYS */;
INSERT INTO `party` VALUES ('329f661e-3386-46f8-8d3a-5fa704b6f533','SONY SUGEMA COLLEGE',NULL,'2009-08-07','','SSC000',1,0,NULL,'Organization'),('65e565a1-6c1c-4f65-91bd-63e412364298','Some Company Inc','68309a5f-4606-46d3-ad20-996ed6c782dx','2016-09-11','6666 5555','B011',0,0,NULL,'Organization'),('980d82f2-aa01-4511-b461-985f5fcbe6a1','Harry Corporation','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','2009-08-07','','I000',1,0,NULL,'Organization'),('a685cde5-df6b-4430-babc-0ae846f8fa29','Rizky Chicken','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','2016-12-01','','00000-0000-0001',0,0,NULL,'Organization'),('e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA',NULL,'2009-08-07','','SSC01',2,0,NULL,'Organization');
/*!40000 ALTER TABLE `party` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `party_classification`
--

DROP TABLE IF EXISTS `party_classification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `party_classification` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `type` char(35) DEFAULT NULL,
  `value` char(50) DEFAULT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party_classification`
--

LOCK TABLES `party_classification` WRITE;
/*!40000 ALTER TABLE `party_classification` DISABLE KEYS */;
INSERT INTO `party_classification` VALUES ('c0420e23-a387-495b-be5d-848c11865ec3','2016-09-11',NULL,'INDUSTRY_CLASSIFICATION',NULL,'65e565a1-6c1c-4f65-91bd-63e412364298',0),('ec089c94-95da-4bbf-8561-bce903590270','2016-09-11',NULL,'INDUSTRY_CLASSIFICATION','Education','e29c7687-30f8-4201-af68-0a4a67541b86',1);
/*!40000 ALTER TABLE `party_classification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `party_rate`
--

DROP TABLE IF EXISTS `party_rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `party_rate` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `rate` decimal(10,0) DEFAULT NULL,
  `type` char(50) DEFAULT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `party_relationship` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `fk_from_role` char(50) DEFAULT NULL,
  `fk_to_role` char(50) DEFAULT NULL,
  `fk_from_party` char(50) DEFAULT NULL,
  `fk_to_party` char(50) DEFAULT NULL,
  `type` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `status` varchar(15) DEFAULT 'ACTIVE',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party_relationship`
--

LOCK TABLES `party_relationship` WRITE;
/*!40000 ALTER TABLE `party_relationship` DISABLE KEYS */;
INSERT INTO `party_relationship` VALUES ('224a5af6-56b1-4e98-bce0-1755d43d3c90','2016-11-25','2016-11-30','bb700516-6872-40ca-b2db-2e49a3a2acb2','fff0f880-04b8-4712-8989-4740a6b91866','e29c7687-30f8-4201-af68-0a4a67541b86','ec85f840-2f5d-4b17-9333-bbd0dae22958','EMPLOYMENT_RELATIONSHIP',1,'ACTIVE'),('afdb45bf-d586-47fa-812e-d57083b3b3ff','2016-11-25',NULL,'bb700516-6872-40ca-b2db-2e49a3a2acb2','158b3342-ff53-4db6-b7d0-0538a76c76b5','e29c7687-30f8-4201-af68-0a4a67541b86','895f107c-991a-4173-8dba-f6a906e13cef','EMPLOYMENT_RELATIONSHIP',0,'ACTIVE'),('e1cf13d4-cb11-415d-b0fe-62b448f7a679','2016-11-25',NULL,'bb700516-6872-40ca-b2db-2e49a3a2acb2','71a2de84-c9c4-4ae2-85b0-439d47d6170d','e29c7687-30f8-4201-af68-0a4a67541b86','c21873ef-3e29-43ca-92cd-45b5eb519c6e','EMPLOYMENT_RELATIONSHIP',0,'ACTIVE');
/*!40000 ALTER TABLE `party_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `party_role`
--

DROP TABLE IF EXISTS `party_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `party_role` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party_role`
--

LOCK TABLES `party_role` WRITE;
/*!40000 ALTER TABLE `party_role` DISABLE KEYS */;
INSERT INTO `party_role` VALUES ('013f6fbf-2c6b-4d7a-8b04-2ad181d02bd7','2016-07-22',NULL,'6ad80274-db6b-42e3-8013-6ad1e441fb81',NULL,0),('09890166-4ccc-41d4-a54c-5a0e5864f6e3','2016-07-25',NULL,'c407032a-4d0d-4b6d-94a3-ae891170e65c',NULL,0),('14bd9c3f-7770-4b64-b195-1cf29b60e38a','2016-07-25',NULL,'1701ebcc-9dde-4e2f-9ac5-4cec4dd8d386',NULL,0),('158b3342-ff53-4db6-b7d0-0538a76c76b5','2017-01-02',NULL,'895f107c-991a-4173-8dba-f6a906e13cef','EMPLOYEE',2),('19056ce0-9e11-4d7f-a136-54002d343c99','2016-06-30',NULL,'f89abcfd-9762-4a07-8b49-ad4f844b3ca1',NULL,0),('1e2b9483-6e86-42a4-9323-8724665d5f24','2016-09-11',NULL,'329f661e-3386-46f8-8d3a-5fa704b6f533','SUBSIDIARY',1),('1f85a637-34bd-46cc-b824-0c67154988a9','2016-07-25',NULL,'a8280d8e-553c-4074-90b4-1f71b5c34e27',NULL,0),('206fbce2-5238-443b-9840-c8d98cd1b111','2016-07-25',NULL,'1eac9139-6b4f-40ff-aafb-a1be57705592',NULL,0),('20f5051d-a3c7-447f-97a7-178e033547a9','2016-07-23',NULL,'964a55cc-2dbb-48ea-b45a-62e4f244a796',NULL,0),('25e3817d-03ac-4c25-873c-589c911191b9','2016-07-25',NULL,'924efe8c-512b-4f7b-9b59-23f0a0e87369',NULL,0),('27ba0cef-80c1-4dd8-828b-c8a331bd8fe7','2016-07-26',NULL,'ce59473f-8bd8-4c7c-a118-6228a2b301a1',NULL,0),('2919f335-3ec9-40c0-bfd2-0dea0a3f465e','2016-07-26',NULL,'4221f198-19b2-416c-bf46-71163727a0ff',NULL,0),('2b21be03-bbbd-454f-a7aa-2cd75a76f2c8','2016-07-18',NULL,'017973d0-bdbc-4b6a-9b1e-bff197ab71f0','CUSTOMER',2),('36395e06-fc13-4720-9466-ac6ee36099b0','2016-08-23',NULL,'63a56e3f-f59b-432f-9c9d-463f1f744334',NULL,0),('3642b32d-8f15-45d9-adb6-3f325f9bb6c2','2016-07-18',NULL,'088f14ea-d0e6-4177-8998-cca133fae524',NULL,0),('3679901a-5145-4240-be19-f6693c9c3217','2016-07-26',NULL,'539fc7b2-a4a1-4b0e-a520-4bb2148b5405',NULL,0),('38a2b91d-a6b3-489a-a6cb-05acac001f99','2016-07-20',NULL,'49a021f9-ef29-4e7b-88a6-bdd1ee2f4d70',NULL,0),('3a579716-6a51-4bd5-a667-bdf6a174250f','2016-07-02',NULL,'65b78b03-601e-4570-bf18-14c7d44e1a18',NULL,0),('3b535b54-dba9-4067-a2a9-1af2e1696f85','2016-07-25',NULL,'7aff71e4-ddaf-4f7b-aff6-6a95cff39ed2',NULL,0),('40e222c3-db79-436c-b58a-de537f99a0df','2016-07-23',NULL,'11bb1ed3-dcdd-4430-908e-3d7e84870a88',NULL,0),('41826c9d-5160-4912-995c-19a5b3700b45','2016-07-19',NULL,'a77bcca4-aee3-4cd3-96c0-b0e78ff13f73',NULL,0),('4435f12f-3a1a-45c6-bce7-0db20cd97911','2016-08-23',NULL,'42901be4-86e0-4e24-be0f-0698dd7ae9bf',NULL,0),('4a79e394-7635-44c8-9aa0-d373e3f71990','2016-07-19',NULL,'6c0fadd3-9867-4d3c-b9f5-502676b503a8',NULL,0),('51125d9e-8a12-40c1-8519-faad4b8065f2','2016-07-22',NULL,'d67ddc3e-1c60-4aff-8120-66dccf9263cb',NULL,0),('5145024a-2e7e-46fd-82fe-281b9036ee3e','2016-09-11',NULL,'980d82f2-aa01-4511-b461-985f5fcbe6a1','PARENT_ORGANIZATION',0),('518c3838-0f36-402f-9bad-652e93f1533c','2016-07-25',NULL,'44a75f39-d018-4644-b028-cd2328ac7ef8',NULL,0),('51c3c592-434d-4aea-9c66-e33cefcce8a8','2016-07-23',NULL,'8a820547-5d64-4589-bf73-837687170286',NULL,0),('58d04d5d-d3f8-43f8-b98e-09bb8afc4f54','2016-07-26',NULL,'0191c9f9-ed27-4967-93ed-add08b6f6f26',NULL,0),('59851383-6691-45c0-8330-10e86ac2342d','2016-07-26',NULL,'4a842e24-386c-4380-a333-3337b7f9029b',NULL,0),('5a6f3da9-5900-46aa-bac3-08ff13e6b0af','2016-07-26',NULL,'763a852d-5742-4be1-8905-714bcecebefd',NULL,0),('5cd4779d-3fb6-40cb-a532-e543734341d3','2016-08-22',NULL,'e196257a-b925-4413-8ede-d4a7bd9f2466',NULL,0),('607abfa1-d844-466b-8e1b-99e200e06cba','2016-06-18',NULL,'77a9c861-faaa-4b4a-a7b2-2d7124be9ba3',NULL,0),('63d19458-3991-423f-a21a-bd88dfb65c99','2016-09-11',NULL,'65e565a1-6c1c-4f65-91bd-63e412364298','PARENT_ORGANIZATION',0),('67a29453-75e5-427b-88d3-2dccb104f9b2','2016-07-19',NULL,'3878879a-2e22-4a97-9929-ff37e1c31431',NULL,0),('6cec3c65-b6ff-4094-b90b-4748c634d508','2016-07-25',NULL,'36f481b9-37e7-4c28-99e5-369f45200634',NULL,0),('71a2de84-c9c4-4ae2-85b0-439d47d6170d',NULL,NULL,'c21873ef-3e29-43ca-92cd-45b5eb519c6e','EMPLOYEE',1),('71ef3dc2-f4f1-48ed-b166-e2fa24fb7601','2016-07-20',NULL,'348d0045-3db2-4e43-a632-ad70f82f86dd',NULL,0),('72301c4d-1c56-4fcd-84e7-c6cf1ff04308','2016-07-20',NULL,'bc260302-c07d-47a6-ad55-bdda6b4b16e5',NULL,0),('72833aed-7a0c-4a09-9049-35f0aab38458','2016-07-19',NULL,'20677939-457c-4ac0-bf48-d93a5a02938a',NULL,0),('742fc487-8b9d-41d8-9a0c-b55772bc2c49','2014-08-07',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','SUBSIDIARY',1),('743b9b7f-9292-407f-aa0d-9305b98becff','2016-07-18',NULL,'d73b0190-ec65-4e75-8b15-aaebbfb4dc97',NULL,0),('7dd6af66-de94-49ff-ac9b-7dd42a15cb0b','2016-07-22',NULL,'cb1e074f-7ba2-415e-8523-4c36b75e2101',NULL,0),('7dd9fbae-3b38-446e-b2cc-64f1692eb4c0','2016-07-20',NULL,'819d4ae9-36e9-47d5-b572-c7fb8c76f392',NULL,0),('7f4d7f25-a9e0-47f5-b8e3-47d8b492aa39','2016-07-15',NULL,'f8c59058-2728-4039-87d2-409b42b9dbc8',NULL,0),('81411eb4-901e-47d6-a97d-eb6b2d09c917','2016-07-22',NULL,'f4eded39-41dc-40b7-b249-84c7daf9713d',NULL,0),('81cebf95-2bc8-47ba-b782-84722ae48ab5','2016-08-19',NULL,'c0f065ac-a095-4a85-a28f-f116a9ba3e57',NULL,1),('86cdb736-158a-43a1-97f6-92eb5a507a9b','2016-08-20',NULL,'f6917d75-083e-4325-bc07-77af774f043b',NULL,0),('895c6562-c9c5-4b9e-8cd6-f34afa95238c','2016-07-23',NULL,'20266334-c727-405c-b710-f215473e4396',NULL,0),('93d109dd-5451-4823-8cff-b9b1806a1ff8','2016-08-23',NULL,'12529b23-3ec7-4912-a7ba-4a7dd0b14b64',NULL,0),('9575be3b-df71-4a73-ad13-91bd9f226ebb','2016-07-25',NULL,'29454f3b-e557-4cd5-b95d-8cd189c3c331',NULL,0),('961de37e-d784-4190-9f3d-8b12781c3b4e','2016-07-25',NULL,'146508c4-cdd5-44e0-9d99-4f5041bf740f',NULL,0),('99aab9a3-69ed-4f66-9508-6e6dea71f5e7','2016-07-20',NULL,'e9ecb5e5-ec98-40d3-9282-6b7949c99924',NULL,0),('9c003100-b652-498f-b4aa-4c3077667683','2016-07-22',NULL,'731838a3-08f5-4f01-9cc3-7b0985239d44',NULL,0),('a2486b77-c0c8-441e-8ad3-16d213fada1f','2016-07-26',NULL,'3459dd9e-7ec3-436f-9c39-db93a9c8f7c6',NULL,0),('a6d1bcd6-f39b-498b-a888-f3a14d76757c','2016-07-26',NULL,'280c1c5f-5bfc-41c7-9162-805edadc6a7c',NULL,0),('aa0d0f9e-fa99-4964-a7c8-50837cfc95c4','2016-07-25',NULL,'e26ce188-8644-46e6-b25f-e131cf46d678',NULL,0),('acd9ad82-15a8-4460-a437-9cf049aa6fdd','2016-07-20',NULL,'2625e364-072a-416b-846e-90b6add43bef',NULL,0),('b6e6b30b-1d19-4310-a4fa-27a7cc233f30','2016-07-26',NULL,'0ee45092-38fe-4270-a4c2-6657fa59298e',NULL,0),('b6e87fe4-9f31-4741-89a0-77530ba60d51','2016-07-18',NULL,'756755c3-1ddd-4086-b862-e7e9298b30cc',NULL,0),('b899ae55-9627-4da2-a702-8adb2d908b0c','1016-07-25',NULL,'b5cbc987-4f00-4fd8-b6d3-5c8de2e4ed45',NULL,0),('b8ae098a-a7bd-4977-b595-53ed28fae483','2014-08-07',NULL,'895f107c-991a-4173-8dba-f6a906e13cef','CONTRACTOR',1),('bb700516-6872-40ca-b2db-2e49a3a2acb2',NULL,NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','EMPLOYER',0),('bed05b14-62dc-4c93-bc6b-825930e013fc','2016-07-19',NULL,'a3ad09a6-dac6-45b9-b678-750014a6cf73',NULL,0),('bf088633-0bdb-4285-976a-6c72652bbf15','2016-07-26',NULL,'ffa7d45c-37c8-46cf-9a02-6973fa73ca3d',NULL,0),('bf336e36-5de1-43dc-90df-d6691ee37cb6','2016-07-14',NULL,'03039740-cb9e-49dc-a670-a600b41d21d1',NULL,0),('c6429b9c-b534-462d-9de2-daf3a26d7782','2016-07-16',NULL,'4dc0134d-711c-468e-af68-6faa3aa9ea1e',NULL,0),('ca5f620c-7715-452c-a9ff-76dd4ec4268f','2016-07-12',NULL,'8459900c-a178-43dd-b215-5e5c089475a2',NULL,0),('cc0772a2-3380-4f0a-ab00-3b1dd3f13606','2016-07-25',NULL,'633e7708-63c7-4f1f-8312-1d210e0dd065',NULL,0),('ced63b0d-655c-4094-ba4c-3a36d11efe1a','2016-07-25',NULL,'61105d59-ec88-4467-ac05-8334d9f66e50',NULL,0),('cee4b98e-b0ff-4ccd-b5f3-ab8f2ccc0d44','2016-07-26',NULL,'41095616-583a-4e15-8563-e405bc26d0d3',NULL,0),('d107d701-77ab-46fa-b28b-7ca533b01835','2016-07-22',NULL,'aa10f218-64f3-4c41-8a90-c5a578896e17',NULL,0),('d527a974-7114-4887-b2d0-ddb3995da945','2016-07-15',NULL,'b7afc825-ce01-493b-b59a-071b5645b682',NULL,1),('d5feeaa3-b34d-4495-b529-1e932e953ae0','2016-07-25',NULL,'1ceb724e-4833-417f-b34c-8086eb670f7e',NULL,0),('d67d6382-c999-49d9-adc8-1d22214aa367','2016-07-19',NULL,'c76091c1-4d94-447e-96f8-476bfee31604',NULL,0),('db471402-1f99-403c-bbcc-fc0bc20f58b0','2016-07-23',NULL,'9d91dc31-8244-41e6-9c4e-9a07bdef3122',NULL,0),('dfc15c98-8c01-412e-beb0-904170908b5f','2016-06-04',NULL,'fe8c2142-a8a5-428b-b242-84d7f384c079',NULL,1),('e721b7c8-ab3f-4932-9688-6d2755cbf647','2016-07-25',NULL,'2f43245c-8573-42cc-9692-8e3236de2f97',NULL,0),('ed53f41a-18b9-41e5-a5f5-09de16da9609','2016-07-26',NULL,'923274db-d2a5-4a78-9962-86348c84e283',NULL,0),('f2b8de62-48db-4af6-a587-ce0257528679','2016-07-20',NULL,'8e004f0b-e655-46c5-a38d-cc0217cca15a',NULL,0),('f4b3800b-b0d5-4519-b86e-b5775184f4ab','2016-05-11',NULL,'e68fa2ab-75bf-48b8-ab52-55f89e7a4787',NULL,1),('f971e4ae-b2eb-4572-ad76-ba60843880fc','2016-07-18',NULL,'022b153f-c31b-4bbe-bcf3-90dfc5243579',NULL,0),('fa0b8097-60e4-404a-a638-36c5dbc3c5b8','2016-09-11',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','BRANCH',0),('fff0f880-04b8-4712-8989-4740a6b91866',NULL,NULL,'ec85f840-2f5d-4b17-9333-bbd0dae22958','EMPLOYEE',0);
/*!40000 ALTER TABLE `party_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `party_skill`
--

DROP TABLE IF EXISTS `party_skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `party_skill` (
  `id` char(50) NOT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `fk_type` char(50) DEFAULT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `party_skill_type` (
  `id` char(50) NOT NULL,
  `name` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passport` (
  `id` char(50) NOT NULL,
  `number` char(50) DEFAULT NULL,
  `issued_date` date DEFAULT NULL,
  `expiration_date` date DEFAULT NULL,
  `fk_country` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passport`
--

LOCK TABLES `passport` WRITE;
/*!40000 ALTER TABLE `passport` DISABLE KEYS */;
/*!40000 ALTER TABLE `passport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `id` char(50) NOT NULL,
  `fk_bpjs` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_practitioner_relationship`
--

DROP TABLE IF EXISTS `patient_practitioner_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_practitioner_relationship` (
  `id` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_practitioner_relationship`
--

LOCK TABLES `patient_practitioner_relationship` WRITE;
/*!40000 ALTER TABLE `patient_practitioner_relationship` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient_practitioner_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_provider_relationship`
--

DROP TABLE IF EXISTS `patient_provider_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_provider_relationship` (
  `id` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_provider_relationship`
--

LOCK TABLES `patient_provider_relationship` WRITE;
/*!40000 ALTER TABLE `patient_provider_relationship` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient_provider_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_relationship`
--

DROP TABLE IF EXISTS `patient_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_relationship` (
  `id` char(50) NOT NULL,
  `fk_patient` char(50) DEFAULT NULL,
  `fk_internal_organization` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pay_history` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `fk_uom` char(50) DEFAULT NULL,
  `fk_employment` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payable` (
  `id` char(50) NOT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paycheck` (
  `id` char(50) NOT NULL,
  `fk_empployment` char(50) DEFAULT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paycheck_item` (
  `id` char(50) NOT NULL,
  `method` char(15) DEFAULT NULL,
  `account` char(50) DEFAULT NULL,
  `bank` varchar(150) DEFAULT NULL,
  `fk_paycheck` char(50) DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
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
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES ('b94f43aa-464d-4ea3-9866-fcfa2bc2b04e','INV1','2016-08-28',2800000,'895f107c-991a-4173-8dba-f6a906e13cef','Cashier Event','e29c7687-30f8-4201-af68-0a4a67541b86','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','d4921463-e9ff-4c8e-b6ff-9a1730688fbb',NULL,0);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_application`
--

DROP TABLE IF EXISTS `payment_application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_application` (
  `id` char(50) NOT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `fk_billing` char(50) DEFAULT NULL,
  `fk_receipt` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_application`
--

LOCK TABLES `payment_application` WRITE;
/*!40000 ALTER TABLE `payment_application` DISABLE KEYS */;
INSERT INTO `payment_application` VALUES ('eba59826-35ad-425e-8085-4d3a7eda3cc2',2800000,'22502402-da64-4ae1-9bb9-131b49745eab','b94f43aa-464d-4ea3-9866-fcfa2bc2b04e',NULL);
/*!40000 ALTER TABLE `payment_application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_item`
--

DROP TABLE IF EXISTS `payment_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_item` (
  `id` char(50) NOT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_method_type` (
  `id` char(50) NOT NULL,
  `name` varchar(150) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_method_type`
--

LOCK TABLES `payment_method_type` WRITE;
/*!40000 ALTER TABLE `payment_method_type` DISABLE KEYS */;
INSERT INTO `payment_method_type` VALUES ('b4ab72cc-5153-43bb-ad33-14ae6ed7f6d6','CASH','',0);
/*!40000 ALTER TABLE `payment_method_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payroll_preference`
--

DROP TABLE IF EXISTS `payroll_preference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payroll_preference`
--

LOCK TABLES `payroll_preference` WRITE;
/*!40000 ALTER TABLE `payroll_preference` DISABLE KEYS */;
/*!40000 ALTER TABLE `payroll_preference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pharmacy_sales`
--

DROP TABLE IF EXISTS `pharmacy_sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pharmacy_sales` (
  `id` char(50) NOT NULL,
  `is_reference` char(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pharmacy_sales_item` (
  `id` char(50) NOT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `discount` decimal(10,0) DEFAULT NULL,
  `charge` decimal(10,0) DEFAULT NULL,
  `fk_pharmacy_sales` char(50) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pharmacy_sales_item`
--

LOCK TABLES `pharmacy_sales_item` WRITE;
/*!40000 ALTER TABLE `pharmacy_sales_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `pharmacy_sales_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `physical_characteristic`
--

DROP TABLE IF EXISTS `physical_characteristic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `physical_characteristic` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `value` char(15) DEFAULT NULL,
  `fk_person` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `physical_characteristic`
--

LOCK TABLES `physical_characteristic` WRITE;
/*!40000 ALTER TABLE `physical_characteristic` DISABLE KEYS */;
INSERT INTO `physical_characteristic` VALUES ('2f5190b5-af40-4912-8626-5f82fb126f49','2016-09-11',NULL,'HEIGHT','165cm','017973d0-bdbc-4b6a-9b1e-bff197ab71f0',0);
/*!40000 ALTER TABLE `physical_characteristic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pick_list`
--

DROP TABLE IF EXISTS `pick_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pick_list` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pick_list_item` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT 1,
  `fk_inventory_item` char(50) DEFAULT NULL,
  `fk_pick_list` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pick_list_item`
--

LOCK TABLES `pick_list_item` WRITE;
/*!40000 ALTER TABLE `pick_list_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `pick_list_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pos_sales_order`
--

DROP TABLE IF EXISTS `pos_sales_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pos_sales_order` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pos_sales_order`
--

LOCK TABLES `pos_sales_order` WRITE;
/*!40000 ALTER TABLE `pos_sales_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `pos_sales_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES ('989ee61c-cd85-4f52-8925-8226403ed4c5','2016-07-25',NULL,'2016-07-25',NULL,'Fulltime','Permanent','Monthly','Planned',NULL,'05405e62-c71b-4e76-b28f-d5f5f148f19e','b620d220-4d73-473f-b0ba-cad098570b6a',3);
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position_fulfillment`
--

DROP TABLE IF EXISTS `position_fulfillment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `position_fulfillment` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_person_employee` char(50) DEFAULT NULL,
  `fk_position` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `position_reporting_structure` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `is_primary` char(1) DEFAULT '0',
  `fk_position_reporting_to` char(50) DEFAULT NULL,
  `fk_position_parent` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `position_responsibility` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_position` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `position_type` (
  `id` char(50) NOT NULL,
  `title` varchar(150) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position_type`
--

LOCK TABLES `position_type` WRITE;
/*!40000 ALTER TABLE `position_type` DISABLE KEYS */;
INSERT INTO `position_type` VALUES ('05405e62-c71b-4e76-b28f-d5f5f148f19e','CEO','CEO',0);
/*!40000 ALTER TABLE `position_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position_type_rate`
--

DROP TABLE IF EXISTS `position_type_rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position_type_rate`
--

LOCK TABLES `position_type_rate` WRITE;
/*!40000 ALTER TABLE `position_type_rate` DISABLE KEYS */;
/*!40000 ALTER TABLE `position_type_rate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `practitioner_provider_relationship`
--

DROP TABLE IF EXISTS `practitioner_provider_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `practitioner_provider_relationship` (
  `id` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `practitioner_provider_relationship`
--

LOCK TABLES `practitioner_provider_relationship` WRITE;
/*!40000 ALTER TABLE `practitioner_provider_relationship` DISABLE KEYS */;
/*!40000 ALTER TABLE `practitioner_provider_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price_component`
--

DROP TABLE IF EXISTS `price_component`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `price_component` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `percent` decimal(10,0) DEFAULT 0,
  `currency_id` char(50) DEFAULT NULL,
  `currency_value` varchar(250) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `area_id` char(50) DEFAULT NULL,
  `area_value` varchar(250) DEFAULT NULL,
  `category_id` char(50) DEFAULT NULL,
  `category_value` varchar(250) DEFAULT NULL,
  `fk_quantity_break` char(50) DEFAULT NULL,
  `fk_order_value` char(50) DEFAULT NULL,
  `sales_type` char(50) DEFAULT NULL,
  `party_id` char(50) DEFAULT NULL,
  `party_value` varchar(250) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `feature_id` char(50) DEFAULT NULL,
  `feature_value` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price_component`
--

LOCK TABLES `price_component` WRITE;
/*!40000 ALTER TABLE `price_component` DISABLE KEYS */;
INSERT INTO `price_component` VALUES ('353920c1-f61b-44e9-ac73-4edc522b7325','2016-12-01','2016-12-11',23000,0,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','BASE_PRICE',NULL,NULL,NULL,NULL,'deaa167e-6d5e-4827-b572-43964cf5c00d','0a3398c1-12d9-43fc-b63f-01d3a0efbc75','STANDARD_RETAIL_SALES','a685cde5-df6b-4430-babc-0ae846f8fa29','Rizky Chicken','64865838-5b79-40ca-a1e4-663d7139895a',NULL,NULL,2),('362ce622-217f-492e-be88-46211a36e77d','2016-12-01',NULL,25000,0,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','BASE_PRICE',NULL,NULL,NULL,NULL,'3b8073e8-6077-4265-aebc-97aa07522e50','488b6999-480e-47b7-9a14-7d3699eafece','STANDARD_RETAIL_SALES',NULL,NULL,'64865838-5b79-40ca-a1e4-663d7139895a',NULL,NULL,0),('678db6cd-76d9-496e-be2f-77a5014244b9','2016-10-15',NULL,22000,0,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','BASE_PRICE','68309a5f-4606-46d3-ad20-996ed6c782dx','Rasau Jaya',NULL,NULL,'5e262173-e0e1-4c6b-8d9f-47c5f062ab73','db2bff56-a35b-4373-8074-419d7546bdd4','STANDARD_RETAIL_SALES',NULL,NULL,'1e21e36a-4244-4eb3-bdbe-902cde4cf9b7',NULL,NULL,2),('79d54835-a3e9-4195-84d4-752412e5bae1','2016-10-15',NULL,18000,0,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','BASE_PRICE',NULL,NULL,NULL,NULL,'31f3ff18-08b4-4911-bdb0-9755e60a8fbd','80ac4b47-186a-486a-a4e0-e497f8e66eeb','STANDARD_RETAIL_SALES',NULL,NULL,'1e21e36a-4244-4eb3-bdbe-902cde4cf9b7',NULL,NULL,0),('8819aeb5-4d49-40be-a03a-3cefaa02a68b','2017-01-01',NULL,50000,0,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','BASE_PRICE',NULL,NULL,NULL,NULL,'0676041f-d86f-4d82-95d5-e8cd227074b7','a9927c26-e787-4869-8caf-e7b731fd6152','STANDARD_RETAIL_SALES',NULL,NULL,'bcfc5b16-4533-4a65-a8b1-2dbf0510ff32',NULL,NULL,0),('a6035e8f-c979-476d-9348-cda142dbffdc','2016-12-01',NULL,18000,0,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','BASE_PRICE',NULL,NULL,NULL,NULL,'ccb0798f-228b-4988-9b4c-894df9447739','08249304-a0a4-4532-9c08-79e9e9e32623','STANDARD_RETAIL_SALES','895f107c-991a-4173-8dba-f6a906e13cef','DODI','64865838-5b79-40ca-a1e4-663d7139895a',NULL,NULL,1),('af57fadf-6a8f-4a90-bcbe-5389b685376a','2016-12-01',NULL,23000,0,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','BASE_PRICE',NULL,NULL,NULL,NULL,'e6f40cdd-f872-4993-8744-1f684c21ae87','33052b93-a540-41fd-92d5-fb1dd0f47291','STANDARD_RETAIL_SALES','a685cde5-df6b-4430-babc-0ae846f8fa29','Rizky Chicken','64865838-5b79-40ca-a1e4-663d7139895a',NULL,NULL,1);
/*!40000 ALTER TABLE `price_component` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` char(50) NOT NULL,
  `name` varchar(150) DEFAULT NULL,
  `introduction_date` date DEFAULT NULL,
  `discontinuation_date` date DEFAULT NULL,
  `support_discontinuation_date` date DEFAULT NULL,
  `comment` varchar(250) DEFAULT NULL,
  `uom_id` char(50) DEFAULT NULL,
  `uom_value` varchar(250) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('17249794-ca76-467b-953f-a00a65404a77','Ayam Kota','2016-09-17',NULL,NULL,NULL,'eb23ea67-cdda-4668-8624-872fdf445a0c',NULL,'SUBASSEMBLY',0),('1e21e36a-4244-4eb3-bdbe-902cde4cf9b7','Ayam Kampung Goreng','2016-09-17','2016-12-07','2016-12-15','','46ff493b-776b-4b9c-b199-39b9ef3b5f19',NULL,'FINISH_GOODS',1),('5be2d7f3-649b-451c-b516-eb64323b11a7','Nangka Mentah','2016-09-18',NULL,NULL,NULL,'50584420-9995-477f-901d-880695e01602',NULL,'RAW_MATERIAL',0),('62c50fe6-2be9-41e5-a214-990c16022a22','Ayam Kampung','2016-09-17',NULL,NULL,NULL,'eb23ea67-cdda-4668-8624-872fdf445a0c',NULL,'SUBASSEMBLY',0),('64865838-5b79-40ca-a1e4-663d7139895a','Garang Asem Sapi','2016-12-10','2016-12-07','2016-12-08','','46ff493b-776b-4b9c-b199-39b9ef3b5f19','Potong','FINISH_GOODS',0),('65295971-29f6-40e1-a738-19ec55509987','ABC','2016-12-09',NULL,NULL,NULL,NULL,NULL,'SERVICE',0),('bcfc5b16-4533-4a65-a8b1-2dbf0510ff32','Pemeriksaan Dokter Umum','2017-01-22',NULL,NULL,'','d43b50b5-3819-45e6-822f-707c7d64cb5f','Visit','SERVICE',0),('da8ea73c-7639-44ab-bba3-8b78c9e234d6','Ayam Kampung Potong 4','2016-09-17',NULL,NULL,NULL,'46ff493b-776b-4b9c-b199-39b9ef3b5f19',NULL,'SUBASSEMBLY',0),('f2e41156-6eb1-4dc4-bd9a-05d38a712554','Ayam Kota Potong 4','2016-09-17',NULL,NULL,NULL,'46ff493b-776b-4b9c-b199-39b9ef3b5f19',NULL,'SUBASSEMBLY',0);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_category`
--

DROP TABLE IF EXISTS `product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_category` (
  `id` char(50) NOT NULL,
  `name` varchar(250) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_parent` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_category`
--

LOCK TABLES `product_category` WRITE;
/*!40000 ALTER TABLE `product_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_category_classification`
--

DROP TABLE IF EXISTS `product_category_classification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_category_classification` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `category_id` char(50) DEFAULT NULL,
  `category_value` varchar(150) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `is_primary` char(1) DEFAULT '0',
  `comment` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_category_classification`
--

LOCK TABLES `product_category_classification` WRITE;
/*!40000 ALTER TABLE `product_category_classification` DISABLE KEYS */;
INSERT INTO `product_category_classification` VALUES ('c23d44d3-b0ce-4835-9d7f-3b704fd7cdf8','2016-09-18',NULL,'19707584-050a-4abd-a958-d1f7dc3630c8',NULL,'5be2d7f3-649b-451c-b516-eb64323b11a7','1','',0);
/*!40000 ALTER TABLE `product_category_classification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_code`
--

DROP TABLE IF EXISTS `product_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_code` (
  `id` char(50) NOT NULL,
  `code` char(50) DEFAULT NULL,
  `type` char(10) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_component` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `product_id` char(50) DEFAULT NULL,
  `fk_product_parent` char(50) DEFAULT NULL,
  `product_value` varchar(250) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `type` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_component`
--

LOCK TABLES `product_component` WRITE;
/*!40000 ALTER TABLE `product_component` DISABLE KEYS */;
INSERT INTO `product_component` VALUES ('0103388f-bc0e-473b-810d-9a0a6365174a',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','2d1f7f21-4288-405b-9b35-188e668b1ba7',NULL,'',NULL,NULL,NULL,0),('01b5e47c-2eea-41d1-a405-8ff2da48d540',1,'c09495a7-c517-4a74-9eda-6433c9b681d1','87ba3d97-3c5e-4ad4-8a49-a4a61606747f',NULL,'',NULL,NULL,NULL,0),('033a0b72-c433-42cf-a2ba-d04491884ebd',1,'3a5ff044-420c-410c-a9e1-e5ddfe922c53','2d1f7f21-4288-405b-9b35-188e668b1ba7',NULL,'',NULL,NULL,NULL,0),('053d1644-da9c-4088-ae7a-792ab2579b31',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','e0c6c287-aca3-49ac-830d-28d5de8f4339',NULL,'',NULL,NULL,NULL,0),('07528956-53e5-4b7f-a080-1ab88c3edee8',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','aa5d68c4-ea05-41c0-b426-39cf527fa337',NULL,'',NULL,NULL,NULL,0),('0a1bc553-f96c-464a-b436-aa721865c15b',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','92733f9c-0645-43d4-a244-1c6f50047dc1',NULL,'',NULL,NULL,NULL,0),('0ec84a29-b58b-41c6-92cf-0891f927afab',1,'7a9d5b56-1430-4404-a4f0-732da0deeba6','17fb878a-6cbd-4605-8a1b-7d8ca8ffde21',NULL,'',NULL,NULL,NULL,0),('138dd687-9de7-449d-8183-0b1cff81afba',1,'8d0f9eaf-4a97-4569-a6e9-45dd8ec1ef80','3394c361-d913-4846-b886-46345d1ffb1a',NULL,'',NULL,NULL,NULL,0),('175be025-1cf2-4f72-ab64-b3ce2f479c10',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','fc4de6a2-5951-423b-82d2-bf2b84a6f3d0',NULL,'',NULL,NULL,NULL,0),('19930832-2364-4485-a70e-12c8d58bade4',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','92733f9c-0645-43d4-a244-1c6f50047dc1',NULL,'',NULL,NULL,NULL,0),('19fe9eb6-d8e0-4980-9da6-57765af4be06',1,'0f00e455-b398-402f-8fc7-8281844d8aac','6f38df8c-f40f-4b92-aba3-ac33873af6c2',NULL,'',NULL,NULL,NULL,0),('1a5742a5-1d65-447f-8f22-08762bdcbf43',1,'0f00e455-b398-402f-8fc7-8281844d8aac','3394c361-d913-4846-b886-46345d1ffb1a',NULL,'',NULL,NULL,NULL,0),('1ba4f291-d28c-4bc3-8b9e-ae3e398a1c9f',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','283f284e-9efb-45c9-84fd-5fcbd2293505',NULL,'',NULL,NULL,NULL,0),('1d024699-a51f-460f-88b1-8510578b7c7f',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','44965c88-3dfa-4645-b885-1003c53da8af',NULL,'',NULL,NULL,NULL,0),('1dfbf9e5-28ec-4d95-9cad-32abb39cb9e3',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','6f38df8c-f40f-4b92-aba3-ac33873af6c2',NULL,'',NULL,NULL,NULL,0),('1e22729b-2c0d-4965-82c9-baa5e79c168a',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','4e2b417e-0a3a-427d-aa82-9b44cf14fd22',NULL,'',NULL,NULL,NULL,0),('1ef56a02-13ca-44da-a83b-c9774de4500c',1,'797da746-ebd7-4b49-9f6d-aa363adf6333','2d20ed16-7959-430b-9582-d9161033cadf',NULL,'',NULL,NULL,NULL,0),('1f80ffff-66fa-45de-a834-0189e1c0e4ac',1,'c51063e0-bfeb-4cf1-abd5-4ec0df252483','64e5471b-d868-4f75-8e56-a7f1c76c31f9',NULL,'',NULL,NULL,NULL,0),('1fb6dea6-ea34-4782-8039-dd70fbade5d9',1,'797da746-ebd7-4b49-9f6d-aa363adf6333','302a98d2-e1a6-488e-b5bc-4589d058e056',NULL,'',NULL,NULL,NULL,0),('20b6c4ec-7773-46ce-9e54-abbadc606d83',1,'0f00e455-b398-402f-8fc7-8281844d8aac','44965c88-3dfa-4645-b885-1003c53da8af',NULL,'',NULL,NULL,NULL,0),('22978e94-f741-4c62-a310-585e571debdc',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','302a98d2-e1a6-488e-b5bc-4589d058e056',NULL,'',NULL,NULL,NULL,0),('2335b870-ba32-4a6e-b047-7d48ac0b26cf',1,'7a9d5b56-1430-4404-a4f0-732da0deeba6','0bc8361e-ed10-4cfb-b236-30183daa771c',NULL,'',NULL,NULL,NULL,0),('245a86ce-de88-475a-a86c-e191638fb120',1,'c51063e0-bfeb-4cf1-abd5-4ec0df252483','c4f99a41-737b-410e-a0ca-d0a8970ba7ae',NULL,'',NULL,NULL,NULL,0),('257017d8-4d27-4a00-9e32-29c4515b572a',1,'797da746-ebd7-4b49-9f6d-aa363adf6333','a60736b7-5b34-4aa9-ae77-e31207d69f80',NULL,'',NULL,NULL,NULL,0),('2625255b-43e2-4421-8498-c8648acf7c09',1,'7a9d5b56-1430-4404-a4f0-732da0deeba6','85dc7116-6c49-4821-a5e4-76cf774dbb92',NULL,'',NULL,NULL,NULL,0),('274fec34-27f4-4108-ad99-c8ed2bb6eb40',1,'7a9d5b56-1430-4404-a4f0-732da0deeba6','3d7f280c-a0cc-4959-91a4-7a42e2d7e86a',NULL,'',NULL,NULL,NULL,0),('2b26e040-ab1c-4719-b8e0-332a3f506c36',1,'8d0f9eaf-4a97-4569-a6e9-45dd8ec1ef80','6f38df8c-f40f-4b92-aba3-ac33873af6c2',NULL,'',NULL,NULL,NULL,0),('2fb76ee6-e232-4684-9ef6-171dc616de48',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','6f38df8c-f40f-4b92-aba3-ac33873af6c2',NULL,'',NULL,NULL,NULL,0),('3115234b-0e4b-4cd2-8396-dbe6827a71f2',1,'30ba8cf4-f749-49e3-9a64-cab4c7adaa0a','e02177e4-4b57-47e8-8fce-d684addf9ff5',NULL,'',NULL,NULL,NULL,0),('33cad4ad-44ce-4a64-8549-7986417f1a79',1,'c51063e0-bfeb-4cf1-abd5-4ec0df252483','44965c88-3dfa-4645-b885-1003c53da8af',NULL,'',NULL,NULL,NULL,0),('3480b0a2-8171-4189-a93c-9d05063ff11a',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','2d20ed16-7959-430b-9582-d9161033cadf',NULL,'',NULL,NULL,NULL,0),('35d1e6d7-0ed7-44b4-8cfe-97bfd4027c84',1,'3a5ff044-420c-410c-a9e1-e5ddfe922c53','85dc7116-6c49-4821-a5e4-76cf774dbb92',NULL,'',NULL,NULL,NULL,0),('3773c029-4852-4ea9-81c5-d9e3f6dc72b4',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','e0c6c287-aca3-49ac-830d-28d5de8f4339',NULL,'',NULL,NULL,NULL,0),('38bcf975-a04b-4cd9-b78c-d95b807f27ea',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','85dc7116-6c49-4821-a5e4-76cf774dbb92',NULL,'',NULL,NULL,NULL,0),('3977cf32-147e-485c-ac22-30f5f8867301',1,'3a5ff044-420c-410c-a9e1-e5ddfe922c53','92733f9c-0645-43d4-a244-1c6f50047dc1',NULL,'',NULL,NULL,NULL,0),('3d6d1d9e-1970-497c-aefb-35fd2def46ca',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','85dc7116-6c49-4821-a5e4-76cf774dbb92',NULL,'',NULL,NULL,NULL,0),('3ddb40a5-65bd-442c-b4c4-cfb2c7a776cc',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','817ac9c4-31d5-460e-9500-914719aee3b3',NULL,'',NULL,NULL,NULL,0),('3eeb6960-b00d-4a61-a64e-22bec81d5be3',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','3394c361-d913-4846-b886-46345d1ffb1a',NULL,'',NULL,NULL,NULL,0),('41d25bcc-47ca-4364-80b6-f05764f00b71',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','4e2b417e-0a3a-427d-aa82-9b44cf14fd22',NULL,'',NULL,NULL,NULL,0),('42644caf-75ca-40fa-9dd1-f5e3dd0a56b8',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','2d1f7f21-4288-405b-9b35-188e668b1ba7',NULL,'',NULL,NULL,NULL,0),('42bdfccf-c2eb-44b1-a8e4-58716e4f032a',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','ec04f800-1eb6-4c2c-ab2c-e2d835cb8982',NULL,'',NULL,NULL,NULL,0),('430568f3-3d85-4f78-9d71-09ab23df3c16',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','2d20ed16-7959-430b-9582-d9161033cadf',NULL,'',NULL,NULL,NULL,0),('442231de-119d-4439-9597-345b3742a798',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','3d7f280c-a0cc-4959-91a4-7a42e2d7e86a',NULL,'',NULL,NULL,NULL,0),('44e1c4fd-b1cc-4fd4-9dfc-3e94055fad61',1,'3a5ff044-420c-410c-a9e1-e5ddfe922c53','e0c6c287-aca3-49ac-830d-28d5de8f4339',NULL,'',NULL,NULL,NULL,0),('482be831-f944-4a16-916a-fbbd5ea9372c',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','0bc8361e-ed10-4cfb-b236-30183daa771c',NULL,'',NULL,NULL,NULL,0),('4c327976-0ebc-4a6c-9066-614fa17de227',1,'30ba8cf4-f749-49e3-9a64-cab4c7adaa0a','302a98d2-e1a6-488e-b5bc-4589d058e056',NULL,'',NULL,NULL,NULL,0),('4cee9487-e4a5-4f38-8c2b-5120860e831c',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','3394c361-d913-4846-b886-46345d1ffb1a',NULL,'',NULL,NULL,NULL,0),('4e1ba4cf-8ac6-4d9f-848e-baa0e114e6ec',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','0bc8361e-ed10-4cfb-b236-30183daa771c',NULL,'',NULL,NULL,NULL,0),('50b150e0-6a09-4e61-ac79-2d6f6e9f8395',1,'30ba8cf4-f749-49e3-9a64-cab4c7adaa0a','fc4de6a2-5951-423b-82d2-bf2b84a6f3d0',NULL,'',NULL,NULL,NULL,0),('558169f9-5ec8-492b-bbfe-20db5348c47c',1,'797da746-ebd7-4b49-9f6d-aa363adf6333','fc4de6a2-5951-423b-82d2-bf2b84a6f3d0',NULL,'',NULL,NULL,NULL,0),('57d352fe-b4a2-4216-a8c6-8e66128bd1b5',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','3d7f280c-a0cc-4959-91a4-7a42e2d7e86a',NULL,'',NULL,NULL,NULL,0),('5a8c1257-5265-421f-bff6-e3f11146539a',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','817ac9c4-31d5-460e-9500-914719aee3b3',NULL,'',NULL,NULL,NULL,0),('5a99475e-3933-4b15-a3e0-c532b4b01abf',1,'c09495a7-c517-4a74-9eda-6433c9b681d1','e02177e4-4b57-47e8-8fce-d684addf9ff5',NULL,'',NULL,NULL,NULL,0),('5dbfd153-dadc-41cf-aee8-f835a07ca4fe',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','44965c88-3dfa-4645-b885-1003c53da8af',NULL,'',NULL,NULL,NULL,0),('604ec4ee-4819-458e-be63-5b78b63106ce',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','a770715e-fdc0-430e-93db-bc513306b815',NULL,'',NULL,NULL,NULL,0),('611de6b0-8732-4b9d-b4ad-53a81cbeadea',1,'c51063e0-bfeb-4cf1-abd5-4ec0df252483','ec04f800-1eb6-4c2c-ab2c-e2d835cb8982',NULL,'',NULL,NULL,NULL,0),('613db0ef-1cb0-4871-bf67-6f6c0edae4fc',1,'3a5ff044-420c-410c-a9e1-e5ddfe922c53','7772edb9-c20a-4cae-af8c-af8eda5226af',NULL,'',NULL,NULL,NULL,0),('61fc20a9-35f2-4b85-a0ff-0d63f0740f96',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','87ba3d97-3c5e-4ad4-8a49-a4a61606747f',NULL,'',NULL,NULL,NULL,0),('625185cb-51c2-4691-ae90-2b5c67135c1c',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','87ba3d97-3c5e-4ad4-8a49-a4a61606747f',NULL,'',NULL,NULL,NULL,0),('625b6acc-eb94-4a5f-9d89-a9f4411ce16b',1,'0f00e455-b398-402f-8fc7-8281844d8aac','817ac9c4-31d5-460e-9500-914719aee3b3',NULL,'',NULL,NULL,NULL,0),('63c04f29-3a6e-4671-af8c-70c084a1ba0e',1,'7a9d5b56-1430-4404-a4f0-732da0deeba6','92733f9c-0645-43d4-a244-1c6f50047dc1',NULL,'',NULL,NULL,NULL,0),('67e35ac2-e0fa-49e3-bf7a-d2bef94f0d70',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','c4f99a41-737b-410e-a0ca-d0a8970ba7ae',NULL,'',NULL,NULL,NULL,0),('67f1298c-71aa-4f29-a9a8-04ec770d2beb',1,'3a5ff044-420c-410c-a9e1-e5ddfe922c53','c47da54f-b8ef-4d61-a5b0-79563bae587c',NULL,'',NULL,NULL,NULL,0),('6bf7c427-0d06-4b92-83a0-4139fafbc664',1,'c09495a7-c517-4a74-9eda-6433c9b681d1','302a98d2-e1a6-488e-b5bc-4589d058e056',NULL,'',NULL,NULL,NULL,0),('6c67ecad-4ad7-4c12-98d9-01a419dd33c8',1,'3a5ff044-420c-410c-a9e1-e5ddfe922c53','4e2b417e-0a3a-427d-aa82-9b44cf14fd22',NULL,'',NULL,NULL,NULL,0),('72f4a7d7-8987-4a16-9147-f2d5c2edd0c7',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','c4f99a41-737b-410e-a0ca-d0a8970ba7ae',NULL,'',NULL,NULL,NULL,0),('73d971d2-6c53-4cf0-a82b-2b4b0c25591b',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','a770715e-fdc0-430e-93db-bc513306b815',NULL,'',NULL,NULL,NULL,0),('757ee141-4022-466e-9df1-c4617cc257cb',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','7772edb9-c20a-4cae-af8c-af8eda5226af',NULL,'',NULL,NULL,NULL,0),('77ea9f77-ea25-4bb5-b658-a09523bc50ba',1,'c09495a7-c517-4a74-9eda-6433c9b681d1','2d20ed16-7959-430b-9582-d9161033cadf',NULL,'',NULL,NULL,NULL,0),('78966463-eda6-4378-850c-f9d08af4effc',1,'3a5ff044-420c-410c-a9e1-e5ddfe922c53','283f284e-9efb-45c9-84fd-5fcbd2293505',NULL,'',NULL,NULL,NULL,0),('7979f26e-c429-469c-8d7e-8adda1a95967',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','64e5471b-d868-4f75-8e56-a7f1c76c31f9',NULL,'',NULL,NULL,NULL,0),('8225ce70-fb88-490d-ad61-df29d0d2ccc2',1,'7a9d5b56-1430-4404-a4f0-732da0deeba6','2d1f7f21-4288-405b-9b35-188e668b1ba7',NULL,'',NULL,NULL,NULL,0),('843982b4-7243-41e6-96e0-914491a0eba7',1,'8d0f9eaf-4a97-4569-a6e9-45dd8ec1ef80','c4f99a41-737b-410e-a0ca-d0a8970ba7ae',NULL,'',NULL,NULL,NULL,0),('84ac5afc-8634-4d14-a69a-a90baad2bda5',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','64e5471b-d868-4f75-8e56-a7f1c76c31f9',NULL,'',NULL,NULL,NULL,0),('8684914a-7cf3-4e4a-ba55-b6b35f0b110c',1,'c09495a7-c517-4a74-9eda-6433c9b681d1','a60736b7-5b34-4aa9-ae77-e31207d69f80',NULL,'',NULL,NULL,NULL,0),('8740c503-dad3-4eff-966f-d7467feb2d07',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','44965c88-3dfa-4645-b885-1003c53da8af',NULL,'',NULL,NULL,NULL,0),('886478ab-2830-4af7-9964-9520d1aeaea2',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','4e2b417e-0a3a-427d-aa82-9b44cf14fd22',NULL,'',NULL,NULL,NULL,0),('8b524d72-153c-442e-a8ae-2a2b1b19b497',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','7772edb9-c20a-4cae-af8c-af8eda5226af',NULL,'',NULL,NULL,NULL,0),('8b93b9c0-d73e-4cd3-9834-ed4cab457a8b',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','e02177e4-4b57-47e8-8fce-d684addf9ff5',NULL,'',NULL,NULL,NULL,0),('8bee901c-d7b9-4b59-ab96-f494e466657b',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','3d7f280c-a0cc-4959-91a4-7a42e2d7e86a',NULL,'',NULL,NULL,NULL,0),('8c90c7cf-cdb2-4820-bf5d-c41bdfe12a57',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','ec04f800-1eb6-4c2c-ab2c-e2d835cb8982',NULL,'',NULL,NULL,NULL,0),('8ce37132-0e04-45d4-a620-afb1bb576133',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','aa5d68c4-ea05-41c0-b426-39cf527fa337',NULL,'',NULL,NULL,NULL,0),('8ce69408-d448-4733-84ed-adf652ffb8ee',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','e02177e4-4b57-47e8-8fce-d684addf9ff5',NULL,'',NULL,NULL,NULL,0),('8f2632a7-335a-4a29-8eb0-bdb00fda40ef',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','fc4de6a2-5951-423b-82d2-bf2b84a6f3d0',NULL,'',NULL,NULL,NULL,0),('8fad788f-b857-4dc1-81f3-17d1676401c2',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','6f38df8c-f40f-4b92-aba3-ac33873af6c2',NULL,'',NULL,NULL,NULL,0),('90058f03-eaa5-47a3-8e0f-4ab5ff3e2f99',1,'30ba8cf4-f749-49e3-9a64-cab4c7adaa0a','a60736b7-5b34-4aa9-ae77-e31207d69f80',NULL,'',NULL,NULL,NULL,0),('92337e29-1bf9-498e-b6fb-f391310ca083',1,'7a9d5b56-1430-4404-a4f0-732da0deeba6','7772edb9-c20a-4cae-af8c-af8eda5226af',NULL,'',NULL,NULL,NULL,0),('93238d7f-ed73-480c-b1bd-8edfb0d379d0',1,'8d0f9eaf-4a97-4569-a6e9-45dd8ec1ef80','44965c88-3dfa-4645-b885-1003c53da8af',NULL,'',NULL,NULL,NULL,0),('9381032f-339a-407b-b9c0-bd3f7fc28e48',1,'30ba8cf4-f749-49e3-9a64-cab4c7adaa0a','a770715e-fdc0-430e-93db-bc513306b815',NULL,'',NULL,NULL,NULL,0),('97cd9e18-9a88-4391-bf37-49c119c86588',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','3394c361-d913-4846-b886-46345d1ffb1a',NULL,'',NULL,NULL,NULL,0),('997c22fd-9fd2-4813-9411-68d620dcf4b8',1,'3a5ff044-420c-410c-a9e1-e5ddfe922c53','0bc8361e-ed10-4cfb-b236-30183daa771c',NULL,'',NULL,NULL,NULL,0),('9ae687e3-e2e7-45f7-ae1e-14abb77d574f',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','e02177e4-4b57-47e8-8fce-d684addf9ff5',NULL,'',NULL,NULL,NULL,0),('9afd579e-2356-4d75-9352-f2c01dfe4ed7',1,'c51063e0-bfeb-4cf1-abd5-4ec0df252483','3394c361-d913-4846-b886-46345d1ffb1a',NULL,'',NULL,NULL,NULL,0),('9d687d0f-76d1-4ceb-abf2-cf511ef891c6',1,'c51063e0-bfeb-4cf1-abd5-4ec0df252483','6f38df8c-f40f-4b92-aba3-ac33873af6c2',NULL,'',NULL,NULL,NULL,0),('9e5c0fb7-f1f2-4591-a765-540f7267f7e3',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','817ac9c4-31d5-460e-9500-914719aee3b3',NULL,'',NULL,NULL,NULL,0),('a00bdfd2-cc5e-40b3-928f-509e6bce4d2e',1,'30ba8cf4-f749-49e3-9a64-cab4c7adaa0a','87ba3d97-3c5e-4ad4-8a49-a4a61606747f',NULL,'',NULL,NULL,NULL,0),('a0a32e05-dc6f-4e8a-ac35-395f5d4c4175',1,'c09495a7-c517-4a74-9eda-6433c9b681d1','a770715e-fdc0-430e-93db-bc513306b815',NULL,'',NULL,NULL,NULL,0),('a5297380-f490-48a3-b759-535907aec1f9',1,'c51063e0-bfeb-4cf1-abd5-4ec0df252483','817ac9c4-31d5-460e-9500-914719aee3b3',NULL,'',NULL,NULL,NULL,0),('a58cc54f-d0be-4c8f-bc41-3e160854e8b0',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','64e5471b-d868-4f75-8e56-a7f1c76c31f9',NULL,'',NULL,NULL,NULL,0),('a670d917-e99f-45d7-be1d-6723ecaf2ed6',1,'7a9d5b56-1430-4404-a4f0-732da0deeba6','283f284e-9efb-45c9-84fd-5fcbd2293505',NULL,'',NULL,NULL,NULL,0),('a6c7a807-3f82-4b76-b92e-2b4874a44713',1,'0f00e455-b398-402f-8fc7-8281844d8aac','64e5471b-d868-4f75-8e56-a7f1c76c31f9',NULL,'',NULL,NULL,NULL,0),('ab4bcad3-87d6-4b09-947e-7a350c2d5932',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','302a98d2-e1a6-488e-b5bc-4589d058e056',NULL,'',NULL,NULL,NULL,0),('ac69a4f6-8558-4b45-bb73-973cbaa3fcc3',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','92733f9c-0645-43d4-a244-1c6f50047dc1',NULL,'',NULL,NULL,NULL,0),('ad98bc51-6c69-43b8-ac71-4fe303a1549f',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','aa5d68c4-ea05-41c0-b426-39cf527fa337',NULL,'',NULL,NULL,NULL,0),('b05de736-02f2-4ef2-8ca1-fa2b17737d47',1,'7a9d5b56-1430-4404-a4f0-732da0deeba6','aa5d68c4-ea05-41c0-b426-39cf527fa337',NULL,'',NULL,NULL,NULL,0),('b2cecac7-ede2-4a71-a01c-aaf8b84a2b31',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','c47da54f-b8ef-4d61-a5b0-79563bae587c',NULL,'',NULL,NULL,NULL,0),('b340bfa5-8d5e-4d5f-aa29-a7202026e499',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','283f284e-9efb-45c9-84fd-5fcbd2293505',NULL,'',NULL,NULL,NULL,0),('b3907d0a-9bf6-4184-8460-8a2644d60d02',1,'797da746-ebd7-4b49-9f6d-aa363adf6333','87ba3d97-3c5e-4ad4-8a49-a4a61606747f',NULL,'',NULL,NULL,NULL,0),('b3a24b48-b040-4f3e-b7f7-323a80740281',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','ec04f800-1eb6-4c2c-ab2c-e2d835cb8982',NULL,'',NULL,NULL,NULL,0),('b3eec394-9185-4527-b6ea-f5cc777ca858',1,'30ba8cf4-f749-49e3-9a64-cab4c7adaa0a','2d20ed16-7959-430b-9582-d9161033cadf',NULL,'',NULL,NULL,NULL,0),('b6083fa3-08dd-4099-9f50-2069a2af6537',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','7772edb9-c20a-4cae-af8c-af8eda5226af',NULL,'',NULL,NULL,NULL,0),('bd38f81a-2313-486a-8c9f-b3d9fefa11ae',1,'3a5ff044-420c-410c-a9e1-e5ddfe922c53','17fb878a-6cbd-4605-8a1b-7d8ca8ffde21',NULL,'',NULL,NULL,NULL,0),('c030d9e6-b975-499d-b97f-f592ec6e008d',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','c47da54f-b8ef-4d61-a5b0-79563bae587c',NULL,'',NULL,NULL,NULL,0),('c4a9a0df-69fd-454b-b4b3-3418035025af',1,'7a9d5b56-1430-4404-a4f0-732da0deeba6','c47da54f-b8ef-4d61-a5b0-79563bae587c',NULL,'',NULL,NULL,NULL,0),('cee6bbd6-a71b-486b-80c8-e99f433d8803',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','17fb878a-6cbd-4605-8a1b-7d8ca8ffde21',NULL,'',NULL,NULL,NULL,0),('cf5c254b-d28a-4cce-b6df-c761b465fcc6',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','a60736b7-5b34-4aa9-ae77-e31207d69f80',NULL,'',NULL,NULL,NULL,0),('d1e1d96f-ded2-4591-b235-1422ea55ad85',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','85dc7116-6c49-4821-a5e4-76cf774dbb92',NULL,'',NULL,NULL,NULL,0),('d22b92ce-ce61-4a4b-9902-6c6740b53b7b',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','17fb878a-6cbd-4605-8a1b-7d8ca8ffde21',NULL,'',NULL,NULL,NULL,0),('d2d2a90c-e1f8-4744-b95d-c7d3b702ca3b',1,'797da746-ebd7-4b49-9f6d-aa363adf6333','e02177e4-4b57-47e8-8fce-d684addf9ff5',NULL,'',NULL,NULL,NULL,0),('d3375103-fb9c-4fea-9946-88108d8b4515',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','ec04f800-1eb6-4c2c-ab2c-e2d835cb8982',NULL,'',NULL,NULL,NULL,0),('d405000d-d9d3-4805-9883-40182128c0cc',1,'797da746-ebd7-4b49-9f6d-aa363adf6333','a770715e-fdc0-430e-93db-bc513306b815',NULL,'',NULL,NULL,NULL,0),('d508fa7c-59d8-4e9a-943d-46a5df4c050c',1,'7a9d5b56-1430-4404-a4f0-732da0deeba6','e0c6c287-aca3-49ac-830d-28d5de8f4339',NULL,'',NULL,NULL,NULL,0),('d67397f4-1ef0-42ec-92c9-605639c44a46',1,'7a9d5b56-1430-4404-a4f0-732da0deeba6','4e2b417e-0a3a-427d-aa82-9b44cf14fd22',NULL,'',NULL,NULL,NULL,0),('d79b24b0-5921-4315-84db-453b31175355',1,'8d0f9eaf-4a97-4569-a6e9-45dd8ec1ef80','ec04f800-1eb6-4c2c-ab2c-e2d835cb8982',NULL,'',NULL,NULL,NULL,0),('d7a02e09-7359-4bc1-a0d4-e6b6f97b54fd',1,'8d0f9eaf-4a97-4569-a6e9-45dd8ec1ef80','817ac9c4-31d5-460e-9500-914719aee3b3',NULL,'',NULL,NULL,NULL,0),('d7f183b0-7d49-4c38-8556-e9de1decf2cd',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','a60736b7-5b34-4aa9-ae77-e31207d69f80',NULL,'',NULL,NULL,NULL,0),('d7f2a39a-76d6-472e-b0e9-482dc57e88b3',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','17fb878a-6cbd-4605-8a1b-7d8ca8ffde21',NULL,'',NULL,NULL,NULL,0),('d7f48464-7d9b-4144-9493-c0896cb9673a',1,'3a5ff044-420c-410c-a9e1-e5ddfe922c53','aa5d68c4-ea05-41c0-b426-39cf527fa337',NULL,'',NULL,NULL,NULL,0),('d93587f0-5c4e-4614-9cae-d56b537598f1',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','2d20ed16-7959-430b-9582-d9161033cadf',NULL,'',NULL,NULL,NULL,0),('da0ae132-31ed-479f-8f28-c46ea6063a39',1,'3a5ff044-420c-410c-a9e1-e5ddfe922c53','3d7f280c-a0cc-4959-91a4-7a42e2d7e86a',NULL,'',NULL,NULL,NULL,0),('dbceb2b1-5d4b-4769-a642-e497d13a7358',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','c4f99a41-737b-410e-a0ca-d0a8970ba7ae',NULL,'',NULL,NULL,NULL,0),('de186570-006e-460b-bbcb-8569902f78ba',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','fc4de6a2-5951-423b-82d2-bf2b84a6f3d0',NULL,'',NULL,NULL,NULL,0),('e3acb4a1-79da-4581-941d-3fe05613e950',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','a60736b7-5b34-4aa9-ae77-e31207d69f80',NULL,'',NULL,NULL,NULL,0),('e6bfc9e8-662d-4c37-a6ab-85dedaac4cd3',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','302a98d2-e1a6-488e-b5bc-4589d058e056',NULL,'',NULL,NULL,NULL,0),('ead0f449-a9f8-4f1b-8a6e-aeec4fdb411f',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','2d1f7f21-4288-405b-9b35-188e668b1ba7',NULL,'',NULL,NULL,NULL,0),('ecc29fa3-fb74-483d-9fa6-ba6a464f63a0',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','a770715e-fdc0-430e-93db-bc513306b815',NULL,'',NULL,NULL,NULL,0),('ed255728-4477-4ecd-8a64-7361615ae02f',1,'c09495a7-c517-4a74-9eda-6433c9b681d1','fc4de6a2-5951-423b-82d2-bf2b84a6f3d0',NULL,'',NULL,NULL,NULL,0),('ee8419a3-1f9a-4672-95b5-8bbca187a837',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','283f284e-9efb-45c9-84fd-5fcbd2293505',NULL,'',NULL,NULL,NULL,0),('eee04578-59bc-4ab8-ab7a-1fbe1a8e7fb5',1,'d75a699b-9cbd-4375-90e9-a249e1d99fb7','0bc8361e-ed10-4cfb-b236-30183daa771c',NULL,'',NULL,NULL,NULL,0),('f0c51cc7-2820-4438-b965-03e824daacc8',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','c47da54f-b8ef-4d61-a5b0-79563bae587c',NULL,'',NULL,NULL,NULL,0),('f76e25d6-0646-4fd0-9634-f4ed062016f7',1,'b94dbdf5-b424-4ae9-97d4-2eaf9d7265fa','87ba3d97-3c5e-4ad4-8a49-a4a61606747f',NULL,'',NULL,NULL,NULL,0),('f7d74cea-bbe8-4295-a673-a23ad84ba7a7',1,'c8c9eb3f-0bcb-4dd4-9ea3-7b4f9120651f','e0c6c287-aca3-49ac-830d-28d5de8f4339',NULL,'',NULL,NULL,NULL,0),('fc728e07-486a-4371-92ac-be62aba4ad9e',1,'8d0f9eaf-4a97-4569-a6e9-45dd8ec1ef80','64e5471b-d868-4f75-8e56-a7f1c76c31f9',NULL,'',NULL,NULL,NULL,0),('fe16c86c-8fa8-41ef-a838-71598cf1e535',1,'0f00e455-b398-402f-8fc7-8281844d8aac','c4f99a41-737b-410e-a0ca-d0a8970ba7ae',NULL,'',NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `product_component` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_cost`
--

DROP TABLE IF EXISTS `product_cost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_cost` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `estimated` decimal(10,0) DEFAULT NULL,
  `type` char(35) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `currency_id` char(50) DEFAULT NULL,
  `currency_value` varchar(250) DEFAULT NULL,
  `geographic_id` char(50) DEFAULT NULL,
  `geographic_value` varchar(250) DEFAULT NULL,
  `feature_id` char(50) DEFAULT NULL,
  `feature_value` varchar(250) DEFAULT NULL,
  `party_id` char(50) DEFAULT NULL,
  `party_value` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_cost`
--

LOCK TABLES `product_cost` WRITE;
/*!40000 ALTER TABLE `product_cost` DISABLE KEYS */;
INSERT INTO `product_cost` VALUES ('467e2367-79de-4dfe-acc2-1d46912dfcbd','2016-12-01',NULL,10000,'ESTIMATED_PURCHASE_COST','64865838-5b79-40ca-a1e4-663d7139895a','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah',NULL,NULL,NULL,NULL,NULL,NULL,0),('6dc5c086-c1f0-4484-b505-ffef873135e7','2016-12-01',NULL,12000,'ESTIMATED_PURCHASE_COST','64865838-5b79-40ca-a1e4-663d7139895a','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah',NULL,NULL,NULL,NULL,'895f107c-991a-4173-8dba-f6a906e13cef','DODI',0),('e954f343-b8f1-478e-9241-144e142122d6','2016-09-20',NULL,8000,'ESTIMATED_PURCHASE_COST','5be2d7f3-649b-451c-b516-eb64323b11a7','85c90912-97ff-47ce-9d6a-7d1650ab3ea9',NULL,'c4c10aee-a3a1-4e6c-a08b-62d4e26414df',NULL,'db6fc663-156d-4ed8-8646-dc3e04826136',NULL,NULL,NULL,2),('ec436393-726e-4506-877a-4b5c7dbf76ca','2016-09-20',NULL,7500,'ESTIMATED_MATERIAL_COST','1e21e36a-4244-4eb3-bdbe-902cde4cf9b7','85c90912-97ff-47ce-9d6a-7d1650ab3ea9',NULL,'c4c10aee-a3a1-4e6c-a08b-62d4e26414df',NULL,NULL,NULL,NULL,NULL,0),('f99043a6-fb80-49b1-b8dc-2e1772d7d484','2016-09-20',NULL,36000,'ESTIMATED_PURCHASE_COST','17249794-ca76-467b-953f-a00a65404a77','85c90912-97ff-47ce-9d6a-7d1650ab3ea9',NULL,'c4c10aee-a3a1-4e6c-a08b-62d4e26414df',NULL,'db6fc663-156d-4ed8-8646-dc3e04826136',NULL,NULL,NULL,2),('ffb4dd13-7cd6-464a-a9dc-5c74bd901ccc','2016-12-01','2016-12-07',15000,'ESTIMATED_PURCHASE_COST','64865838-5b79-40ca-a1e4-663d7139895a','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','Pontianak','db6fc663-156d-4ed8-8646-dc3e04826136','Reguler',NULL,NULL,2);
/*!40000 ALTER TABLE `product_cost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_feature`
--

DROP TABLE IF EXISTS `product_feature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_feature` (
  `id` char(50) NOT NULL,
  `value` varchar(150) DEFAULT NULL,
  `type` char(35) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_feature`
--

LOCK TABLES `product_feature` WRITE;
/*!40000 ALTER TABLE `product_feature` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_feature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_feature_applicability`
--

DROP TABLE IF EXISTS `product_feature_applicability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_feature_applicability` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `category` char(50) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `feature_id` char(50) DEFAULT NULL,
  `feature_value` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_feature_applicability`
--

LOCK TABLES `product_feature_applicability` WRITE;
/*!40000 ALTER TABLE `product_feature_applicability` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_feature_applicability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_identification`
--

DROP TABLE IF EXISTS `product_identification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_identification` (
  `id` char(50) NOT NULL,
  `value` char(50) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_identification`
--

LOCK TABLES `product_identification` WRITE;
/*!40000 ALTER TABLE `product_identification` DISABLE KEYS */;
INSERT INTO `product_identification` VALUES ('79de68d3-e18a-42be-9e4c-2105108dd987','SAYUR-00001','UPC','Sayuran','5be2d7f3-649b-451c-b516-eb64323b11a7',0);
/*!40000 ALTER TABLE `product_identification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_price`
--

DROP TABLE IF EXISTS `product_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_price`
--

LOCK TABLES `product_price` WRITE;
/*!40000 ALTER TABLE `product_price` DISABLE KEYS */;
INSERT INTO `product_price` VALUES ('026dd356-17a9-4bac-8eb0-2ca710b0d351','2016-01-01',NULL,4700000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','7772edb9-c20a-4cae-af8c-af8eda5226af','a19646c1-1a79-4b78-8d80-7127bb1b8003','0',0),('0351ff94-99fe-491a-8240-4a81fe05c59c','2016-01-01',NULL,4200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','2d1f7f21-4288-405b-9b35-188e668b1ba7','367315b3-145d-4276-aa20-2f555990ccd9','0',0),('0bd2621c-e138-4324-9f46-266169f820b9','2016-01-01',NULL,4700000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','85dc7116-6c49-4821-a5e4-76cf774dbb92','96385fa3-e2cd-44cc-b89f-a88c54864f5c','0',0),('0bdda2a8-f92b-4fc9-b9c5-9b6f81aacb47','2016-01-01',NULL,5200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','3394c361-d913-4846-b886-46345d1ffb1a','2c4d9431-9b7f-4045-aad0-6e57b0302dda','0',0),('0ccf5364-b62d-4ff1-9685-2d66c38f04b6','2016-01-01',NULL,2800000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','3394c361-d913-4846-b886-46345d1ffb1a','a28d8d7f-76d1-484d-8305-bc4191fd15f0','0',0),('18072182-686e-475e-ae76-c7377c0af664','2009-08-07',NULL,200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'1967553d-bda0-4a57-b9f5-356adf49c451','b0f891c2-b6cf-43c1-b51a-9d7a2cdc19d0','0',0),('183b54e4-8ea8-43d3-abed-b67db8f0282e','2016-01-01',NULL,4200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','aa5d68c4-ea05-41c0-b426-39cf527fa337','cc83844d-bd8d-4db8-8ca0-40cdbb82f6cf','0',0),('18d2dd57-6e5c-4fd8-bde9-64584da7d92d','2016-01-01',NULL,5200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','e02177e4-4b57-47e8-8fce-d684addf9ff5','6bc05d2d-25b3-445b-988c-2d5c2c20c427','0',0),('25448de8-b43c-4f2f-babc-6e53291185d9','2016-01-01',NULL,2800000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','ec04f800-1eb6-4c2c-ab2c-e2d835cb8982','44b02256-52c4-4842-ae5e-34b0d54f79ce','0',0),('29bbb9f1-cf10-4a43-acb5-751a0451b1f4','2016-01-01',NULL,2800000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','6f38df8c-f40f-4b92-aba3-ac33873af6c2','f3038527-6048-4ae6-8ffb-8b43868a9871','0',0),('2ed91c81-71eb-492c-9d8d-5c8090fc5c86','2016-01-01',NULL,3700000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','2d20ed16-7959-430b-9582-d9161033cadf','6e97c45e-2e7c-4816-94dd-342469da68f3','0',0),('329c3d9f-17b3-4ce5-b3dd-59827e4a325a','2016-01-01',NULL,7200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','c4f99a41-737b-410e-a0ca-d0a8970ba7ae','673c119f-9051-4281-abe0-b3c6bd0f25a1','0',0),('344a8048-ee0e-4efe-8343-cdf28cf52b45','2016-01-01',NULL,4200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','4e2b417e-0a3a-427d-aa82-9b44cf14fd22','4884c194-5bec-4575-b310-5f6f00e4488a','0',0),('35a402e7-b2cc-4a91-9bf4-009573b1ac40','2016-01-01',NULL,5200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','44965c88-3dfa-4645-b885-1003c53da8af','3ce9a5da-2717-47d2-bfc6-45a54fdd8335','0',0),('3ac928d8-e2d0-40ca-9167-cccd97e3b3e0','2016-01-01',NULL,2500000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','85dc7116-6c49-4821-a5e4-76cf774dbb92','a6024bf6-cad4-434c-8a65-057389a97731','0',0),('46340d92-2fbb-44b4-aa2a-b931ac09ca15','2016-01-01',NULL,2500000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','c47da54f-b8ef-4d61-a5b0-79563bae587c','557f0c90-cb32-437c-bcf7-632242622413','0',0),('46756792-7dff-46d1-901d-c13ae36f7b03','2016-01-01',NULL,5200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','a770715e-fdc0-430e-93db-bc513306b815','043c499b-0f22-41e6-a258-3b09e2e982fe','0',0),('4869f5fb-dbdb-442a-8e25-6c74ebbe45df','2016-01-01',NULL,2200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','aa5d68c4-ea05-41c0-b426-39cf527fa337','1e21b9c7-fbf5-4056-9255-d1f93dd71dff','0',0),('5502ccae-ce69-47e7-b86c-91ed5987a30b','2016-01-01',NULL,2500000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','0bc8361e-ed10-4cfb-b236-30183daa771c','3447add0-ee66-4cd5-b40d-268dca7d7d6a','0',0),('5a8fac0d-fb6d-46fd-8eec-e2dfe4fe705d','2016-01-01',NULL,2800000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','a60736b7-5b34-4aa9-ae77-e31207d69f80','938732e0-d8f3-47ee-af2d-d9b4abc962e7','0',0),('5eb9d254-1ee9-4195-8a61-1fbcd418c992','2016-01-01',NULL,2800000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','302a98d2-e1a6-488e-b5bc-4589d058e056','69d3fe52-ec11-450e-8e63-8a9747a484b7','0',0),('5f551538-fe3e-4eb2-8249-2c86b267650c','2016-01-01',NULL,2200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','17fb878a-6cbd-4605-8a1b-7d8ca8ffde21','263b82f0-1fb5-493f-b3cd-fab5cd5586f7','0',0),('61820217-91f7-4764-88c0-75bd4d16f06b','2016-01-01',NULL,2800000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','e02177e4-4b57-47e8-8fce-d684addf9ff5','8e0fc923-79c3-4115-8a23-e49c75fcb0d0','0',0),('6729fa04-f187-4501-a456-24380f018165','2016-01-01',NULL,2200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','3d7f280c-a0cc-4959-91a4-7a42e2d7e86a','45ac25bb-37a9-40b8-b5e5-d1813ea28c84','0',0),('67ea6c53-ca26-41e3-99fc-98b026c027d3','2016-01-01',NULL,4200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','283f284e-9efb-45c9-84fd-5fcbd2293505','86574b07-1dc7-4b53-9088-3d56ee288e0b','0',0),('68285ef1-88ce-48fd-88eb-e5b90047829e','2016-01-01',NULL,2800000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','64e5471b-d868-4f75-8e56-a7f1c76c31f9','3bc53d56-4fad-4e8c-b014-327042ef4703','0',0),('707975ec-2ff9-4a22-8180-1d2a28fbf34b','2016-01-01',NULL,5200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','64e5471b-d868-4f75-8e56-a7f1c76c31f9','bc634a40-eea0-4491-967f-d6b90b271df4','0',0),('799b81cb-bb97-4466-9876-cd628a9ebb14','2016-01-01',NULL,5200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','6f38df8c-f40f-4b92-aba3-ac33873af6c2','4a927e72-2fb4-4db2-9462-157a427ce4f5','0',0),('829bd894-59cd-4a92-b7cb-308a8f9a37b2','2016-01-01',NULL,2500000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','92733f9c-0645-43d4-a244-1c6f50047dc1','dfd0056d-d012-42c3-8903-fc927f87f55e','0',0),('83d34189-009d-4d25-a1c6-543786834412','2016-01-01',NULL,2500000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','7772edb9-c20a-4cae-af8c-af8eda5226af','a06190e3-0ac1-4116-922a-2fd2577307ca','0',0),('8a5009c5-f343-480e-b541-510d48aae17a','2016-01-01',NULL,2500000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','e0c6c287-aca3-49ac-830d-28d5de8f4339','ea372ab8-2f32-49b8-b225-3c2e18b3179b','0',0),('904ff6df-b176-4f92-ac9c-83e8403c2ed5','2016-01-01',NULL,4700000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','92733f9c-0645-43d4-a244-1c6f50047dc1','c0bda8a9-2013-477d-84d6-4077cba5e4b7','0',0),('98625a70-cff8-4aba-91d9-eb791e16a4a9','2016-01-01',NULL,4700000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','0bc8361e-ed10-4cfb-b236-30183daa771c','8f3f42ae-afd2-4185-b3d4-15c372e1bfe8','0',0),('a42142d3-2f43-49d4-b872-fd77f1d1922e','2016-01-01',NULL,4200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','3d7f280c-a0cc-4959-91a4-7a42e2d7e86a','93bbbc61-295c-4a62-a6ee-320bfb1c92a7','0',0),('a44a9ae3-f128-43d7-a3e1-2ee2a97e10cb','2016-01-01',NULL,5200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','87ba3d97-3c5e-4ad4-8a49-a4a61606747f','ced46d3e-ad88-47ba-9c4f-a0767ac05c3d','0',0),('a84df69e-8ce7-4ce9-9e68-84e6d2b7b3ca','2016-01-01',NULL,2800000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','87ba3d97-3c5e-4ad4-8a49-a4a61606747f','e7c5f355-9654-44b6-bb1a-dc6e3cf53893','0',0),('a8b0e05b-e599-4b47-a36f-9b9eec1abea4','2016-01-01',NULL,2200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','283f284e-9efb-45c9-84fd-5fcbd2293505','c211e6cd-ca5b-4ce3-84f6-c8def13fea3c','0',0),('b3403263-19d8-4f82-a733-f8e3ea06321d','2016-01-01',NULL,5200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','ec04f800-1eb6-4c2c-ab2c-e2d835cb8982','dfc383dc-ac63-48ad-b82b-9f0ad5ee0956','0',0),('b4e613c2-3e09-4de6-83f4-0fd4eac02bb0','2016-01-01',NULL,4700000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','e0c6c287-aca3-49ac-830d-28d5de8f4339','d50d8a83-075c-44b3-82b2-649636c6680f','0',0),('bc74f6a9-5f10-4716-98b7-6318894d7870','2016-01-01',NULL,4700000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','c47da54f-b8ef-4d61-a5b0-79563bae587c','0b185b17-1b31-4f71-8342-a792a1cbae38','0',0),('c14f201f-05b9-43a9-be4f-0ed5d6a9f64a','2016-01-01',NULL,2800000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','fc4de6a2-5951-423b-82d2-bf2b84a6f3d0','393ed2d7-40fd-4ef2-b301-7b3058f6a5e9','0',0),('c6084421-3cd5-4f96-8c8f-982fd4050ba9','2016-01-01',NULL,2800000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','44965c88-3dfa-4645-b885-1003c53da8af','51db4c1b-8a21-4d74-9821-a520cb5d86d3','0',0),('c8f0cdba-4efb-427f-9758-75ef9b55d795','2016-01-01',NULL,2200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','4e2b417e-0a3a-427d-aa82-9b44cf14fd22','051fb26f-9ef8-4b9b-a92e-d1f027f502b3','0',0),('c99c3f6e-3d23-4492-9a3a-56745f220f30','2016-01-01',NULL,4200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','17fb878a-6cbd-4605-8a1b-7d8ca8ffde21','69b94980-2f4b-478a-9d52-72d21cf6c311','0',0),('ca5e9302-8c1a-49a8-ba62-10316e551cec','2016-01-01',NULL,2200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','2d1f7f21-4288-405b-9b35-188e668b1ba7','ccda8048-d4dd-456d-900d-6bedcc916d4c','0',0),('daf6f611-4578-41c1-ad73-38b8faa3eaa6','2016-01-01',NULL,2800000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','817ac9c4-31d5-460e-9500-914719aee3b3','6255d582-58ad-4951-b6a7-d4b9979058d7','0',0),('df5d8304-b52a-4a57-a6d0-c71c79088ee0','2016-01-01',NULL,7200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','2d20ed16-7959-430b-9582-d9161033cadf','3b2d4b34-8b3d-4eda-9bc5-6482b0280894','0',0),('e1e9e364-50bf-4270-9406-8b7aa6a11ea3','2016-01-01',NULL,3700000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','c4f99a41-737b-410e-a0ca-d0a8970ba7ae','abe80c5f-70d1-4249-8a65-0bab9f168f18','0',0),('e2d8da7e-a1e0-4f5f-890d-ff0c99b55641','2016-01-01',NULL,5200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','fc4de6a2-5951-423b-82d2-bf2b84a6f3d0','8e715111-8c7e-4d53-89c2-fc4060083bfd','0',0),('f6601be8-444f-4a38-ae34-bc4db7f45d31','2016-01-01',NULL,2800000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','a770715e-fdc0-430e-93db-bc513306b815','6888cb76-757a-43bb-b6b4-435727085db9','0',0),('f7428e5e-93fb-4b13-9282-d36612f35e3a','2016-01-01',NULL,5200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','817ac9c4-31d5-460e-9500-914719aee3b3','ebc8f537-d2aa-4186-8e0a-eb8ce94ca391','0',0),('fa534dcb-561e-4f48-ab57-21a8e5d0148f','2009-08-07',NULL,100000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE',NULL,NULL,'1967553d-bda0-4a57-b9f5-356adf49c451','80a3e730-15e4-4329-be2e-74dce739e2d4','0',0),('faf1243d-4ec9-48b6-97e8-15731dd5ac77','2016-01-01',NULL,5200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','302a98d2-e1a6-488e-b5bc-4589d058e056','d0b7283c-2346-4912-8dfa-bbe6d064ea36','0',0),('fcef45d2-eb0a-4389-b0a3-e374b911bdcc','2016-01-01',NULL,5200000,'85c90912-97ff-47ce-9d6a-7d1650ab3ea9','BASE','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','329f661e-3386-46f8-8d3a-5fa704b6f533','a60736b7-5b34-4aa9-ae77-e31207d69f80','63c03f8f-d5ab-44a5-87c5-2ee874aa7743','0',0);
/*!40000 ALTER TABLE `product_price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_receivable`
--

DROP TABLE IF EXISTS `product_receivable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_receivable` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `number` char(50) DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `status` char(10) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_receivable`
--

LOCK TABLES `product_receivable` WRITE;
/*!40000 ALTER TABLE `product_receivable` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_receivable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_requirement`
--

DROP TABLE IF EXISTS `product_requirement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_requirement` (
  `id` char(50) DEFAULT NULL,
  `product_id` char(50) NOT NULL,
  `product_value` varchar(200) DEFAULT NULL,
  `feature_id` char(50) DEFAULT NULL,
  `feature_value` varchar(200) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT 1,
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `product_id_UNIQUE` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_requirement`
--

LOCK TABLES `product_requirement` WRITE;
/*!40000 ALTER TABLE `product_requirement` DISABLE KEYS */;
INSERT INTO `product_requirement` VALUES ('fd1a0364-e9d4-4979-9108-a4866f39d499','64865838-5b79-40ca-a1e4-663d7139895a','Garang Asem Sapi',NULL,NULL,10);
/*!40000 ALTER TABLE `product_requirement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_retur`
--

DROP TABLE IF EXISTS `product_retur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_retur` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `fk_supplier` char(50) DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `fk_facility` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_retur_item` (
  `id` char(50) NOT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `expired_date` date DEFAULT NULL,
  `fk_product_retur` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_supplier` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `supplier_id` char(50) DEFAULT NULL,
  `supplier_value` varchar(250) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_supplier`
--

LOCK TABLES `product_supplier` WRITE;
/*!40000 ALTER TABLE `product_supplier` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `production_info`
--

DROP TABLE IF EXISTS `production_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `production_info` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `product_id` char(50) DEFAULT NULL,
  `product_value` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `production_info`
--

LOCK TABLES `production_info` WRITE;
/*!40000 ALTER TABLE `production_info` DISABLE KEYS */;
INSERT INTO `production_info` VALUES ('1bfb8acf-779c-4a15-abe2-3ac055a8e565',1,NULL,NULL,0);
/*!40000 ALTER TABLE `production_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `production_run_properties`
--

DROP TABLE IF EXISTS `production_run_properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `production_run_properties` (
  `id` char(50) NOT NULL,
  `required_quantity` char(50) DEFAULT NULL,
  `produced_quantity` char(50) DEFAULT NULL,
  `rejected_quantity` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `production_run_properties`
--

LOCK TABLES `production_run_properties` WRITE;
/*!40000 ALTER TABLE `production_run_properties` DISABLE KEYS */;
/*!40000 ALTER TABLE `production_run_properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_invoice`
--

DROP TABLE IF EXISTS `purchase_invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchase_invoice` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_invoice`
--

LOCK TABLES `purchase_invoice` WRITE;
/*!40000 ALTER TABLE `purchase_invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_order`
--

DROP TABLE IF EXISTS `purchase_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchase_order` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_order`
--

LOCK TABLES `purchase_order` WRITE;
/*!40000 ALTER TABLE `purchase_order` DISABLE KEYS */;
INSERT INTO `purchase_order` VALUES ('7411fc95-25a0-458b-afe9-7d1505a3fda6'),('ec50085f-9f93-4a65-9d70-4be09ec927cc');
/*!40000 ALTER TABLE `purchase_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_order_item`
--

DROP TABLE IF EXISTS `purchase_order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchase_order_item` (
  `id` char(50) NOT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_purchase_order_request_item` char(50) DEFAULT NULL,
  `expired_date` date DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_order_item`
--

LOCK TABLES `purchase_order_item` WRITE;
/*!40000 ALTER TABLE `purchase_order_item` DISABLE KEYS */;
INSERT INTO `purchase_order_item` VALUES ('4afa09ca-4628-47e2-b3a0-f0040c6477c8',NULL,NULL,NULL,NULL,NULL,0),('8c9e24e2-7454-43fa-b091-823100d8aa2f',NULL,NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `purchase_order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_order_request`
--

DROP TABLE IF EXISTS `purchase_order_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchase_order_request` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchase_order_request_item` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `fk_purchase_order_request` char(50) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchase_order_request_review` (
  `id` char(50) NOT NULL,
  `fk_purchase_order_request` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchase_order_request_role` (
  `id` char(50) NOT NULL,
  `fk_purchase_order_request` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchase_order_request_status` (
  `id` char(50) NOT NULL,
  `fk_purchase_order_request` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_order_request_status`
--

LOCK TABLES `purchase_order_request_status` WRITE;
/*!40000 ALTER TABLE `purchase_order_request_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_order_request_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quantity_break`
--

DROP TABLE IF EXISTS `quantity_break`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quantity_break` (
  `id` char(50) NOT NULL,
  `min` decimal(10,0) DEFAULT NULL,
  `max` decimal(10,0) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quantity_break`
--

LOCK TABLES `quantity_break` WRITE;
/*!40000 ALTER TABLE `quantity_break` DISABLE KEYS */;
INSERT INTO `quantity_break` VALUES ('0676041f-d86f-4d82-95d5-e8cd227074b7',0,0,0),('232acb83-2c41-4384-8aea-2cbd458b0bc1',0,0,0),('31f3ff18-08b4-4911-bdb0-9755e60a8fbd',0,0,0),('375eb165-b064-4c35-8406-2c57f1479ca9',0,0,0),('3b8073e8-6077-4265-aebc-97aa07522e50',0,0,0),('4de5cbe0-f9cd-44f5-acb1-baf08e50c230',0,0,0),('507c6e5d-633d-436e-9013-b355dd361f99',0,0,0),('5e262173-e0e1-4c6b-8d9f-47c5f062ab73',0,0,0),('6667069c-ebaa-42d8-a21f-e454da0d736f',0,0,0),('74f9e21f-a155-4b8e-9cce-ff16e5f5544e',0,0,0),('8c4afb29-6e85-45fb-8f38-885d54fd2eaf',0,0,0),('8c8a0779-f1a6-4ee3-a6fe-69e1f2162609',0,0,0),('95843cfa-0c63-45a4-bcb4-424508caa858',0,0,0),('a53670a8-b8be-40c9-b6f0-8ae756bf4061',0,0,0),('b444d810-659d-42ce-b4d1-b20fdf7dea4e',0,0,0),('c77a3bc4-4503-427b-8305-005221fcc76c',0,0,0),('ccb0798f-228b-4988-9b4c-894df9447739',0,0,0),('dd10307b-ae29-4973-82a2-5b0e11b27a64',0,0,0),('deaa167e-6d5e-4827-b572-43964cf5c00d',0,0,0),('e152337f-cebb-493c-8b0c-8d61e23e4843',0,0,0),('e6f40cdd-f872-4993-8744-1f684c21ae87',0,0,0);
/*!40000 ALTER TABLE `quantity_break` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quick_launch`
--

DROP TABLE IF EXISTS `quick_launch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quick_launch` (
  `id` char(50) NOT NULL,
  `name` varchar(250) DEFAULT NULL,
  `username` varchar(250) DEFAULT NULL,
  `fisheye_enabled` char(1) DEFAULT '0',
  `menu_enabled` char(1) DEFAULT '0',
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quick_launch`
--

LOCK TABLES `quick_launch` WRITE;
/*!40000 ALTER TABLE `quick_launch` DISABLE KEYS */;
INSERT INTO `quick_launch` VALUES ('02039aec-a94d-4cd5-83cf-3a195460c0ee','Tax','DODI','0','0',1),('dc478a65-9021-4b52-ae2a-c1d081b86315','Currency','DODI','0','0',6),('dc478a65-9021-4b52-ae2a-c1d081b86316','Setting','DODI','1','1',0),('e047568c-0969-45bc-99ff-06fbd34bdadb','Company Structure','DODI','0','0',1);
/*!40000 ALTER TABLE `quick_launch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quote`
--

DROP TABLE IF EXISTS `quote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quote` (
  `id` char(50) NOT NULL,
  `issue_date` date DEFAULT NULL,
  `valid_from` date DEFAULT NULL,
  `valid_to` date DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `fk_issuer` char(50) DEFAULT NULL,
  `fk_receiver` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quote_item` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `unit_price` decimal(10,0) DEFAULT NULL,
  `delivery_date` date DEFAULT NULL,
  `fk_uom` char(50) DEFAULT NULL,
  `comment` char(50) DEFAULT NULL,
  `fk_request_item` char(50) DEFAULT NULL,
  `fk_quote` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quote_role` (
  `id` char(50) NOT NULL,
  `fk_person` char(50) DEFAULT NULL,
  `fk_quote` char(50) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quote_term` (
  `id` char(50) NOT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `fk_quote` char(50) DEFAULT NULL,
  `fk_quote_item` char(50) DEFAULT NULL,
  `fk_term_type` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receipt` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipt`
--

LOCK TABLES `receipt` WRITE;
/*!40000 ALTER TABLE `receipt` DISABLE KEYS */;
INSERT INTO `receipt` VALUES ('b94f43aa-464d-4ea3-9866-fcfa2bc2b04e');
/*!40000 ALTER TABLE `receipt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receivable_order`
--

DROP TABLE IF EXISTS `receivable_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receivable_order` (
  `id` char(50) NOT NULL,
  `received` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receivable_order`
--

LOCK TABLES `receivable_order` WRITE;
/*!40000 ALTER TABLE `receivable_order` DISABLE KEYS */;
INSERT INTO `receivable_order` VALUES ('8bb7baeb-dae6-4910-92ca-d3978fa9b232',0),('e6c53382-73d7-46a3-86b0-107907679c5f',0),('ff5beb2a-aba4-4c7a-ba11-eec9dc730d2a',0);
/*!40000 ALTER TABLE `receivable_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recurring_payment`
--

DROP TABLE IF EXISTS `recurring_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recurring_payment` (
  `id` char(50) NOT NULL,
  `name` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `request` (
  `id` char(50) NOT NULL,
  `entry_date` date DEFAULT NULL,
  `required_date` date DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `originator_id` char(50) DEFAULT NULL,
  `originator_value` varchar(250) DEFAULT NULL,
  `responding_id` char(50) DEFAULT NULL,
  `responding_value` varchar(250) DEFAULT NULL,
  `is_closed` varchar(45) DEFAULT '0',
  `number` varchar(50) DEFAULT NULL,
  `version` char(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
INSERT INTO `request` VALUES ('46d9422c-b39b-494c-ad2a-9b87c67a5444','2016-11-29','2016-11-30','2016-11-29','','QUOTATION','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA','895f107c-991a-4173-8dba-f6a906e13cef','DODI','0',NULL,'0'),('4e9133f1-2198-4cb1-943e-739a5a0f6846','2016-12-01','2016-12-07','2016-12-01','','QUOTATION','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA','a685cde5-df6b-4430-babc-0ae846f8fa29','Rizky Chicken','0','REQ2','0'),('581ee3cb-0f00-4b7d-8f27-e31110410681','2016-12-01','2016-12-07','2016-12-01','','QUOTATION','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA','a685cde5-df6b-4430-babc-0ae846f8fa29','Rizky Chicken','0','REQ4','0'),('9865b143-347c-4364-b592-970f968751c7','2016-12-01','2016-12-08','2016-12-01','','QUOTATION','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA','a685cde5-df6b-4430-babc-0ae846f8fa29','Rizky Chicken','0','REQ1','0'),('ba959186-7702-466d-94ac-a6e2e1ecd93c','2016-12-01','2016-12-02','2016-12-01','','INFORMATION','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA','a685cde5-df6b-4430-babc-0ae846f8fa29','Rizky Chicken','0','REQ3','0');
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request_item`
--

DROP TABLE IF EXISTS `request_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `request_item` (
  `id` char(50) NOT NULL,
  `required_date` date DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `max_allowable_price` decimal(10,0) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `fk_request` char(50) DEFAULT NULL,
  `product_id` char(50) DEFAULT NULL,
  `product_value` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request_item`
--

LOCK TABLES `request_item` WRITE;
/*!40000 ALTER TABLE `request_item` DISABLE KEYS */;
INSERT INTO `request_item` VALUES ('28db322d-d6d1-4674-9f4c-20632cc623ec','2016-12-01',1,18000,'','ba959186-7702-466d-94ac-a6e2e1ecd93c','1e21e36a-4244-4eb3-bdbe-902cde4cf9b7','Ayam Kampung Goreng',0),('4186981e-4a42-4201-a939-b178561927fa','2016-12-01',1,30000,'','4e9133f1-2198-4cb1-943e-739a5a0f6846','62c50fe6-2be9-41e5-a214-990c16022a22','Ayam Kampung',0),('b896f461-94df-4ce6-abcb-5fd97ffc86c7','2016-11-29',1,1,'','46d9422c-b39b-494c-ad2a-9b87c67a5444','1e21e36a-4244-4eb3-bdbe-902cde4cf9b7','Ayam Kampung Goreng',0),('d3852a99-c54d-4c36-b88f-f2b7752c71cd','2016-12-01',1,20000,'','581ee3cb-0f00-4b7d-8f27-e31110410681','17249794-ca76-467b-953f-a00a65404a77','Ayam Kota',0),('e4e1f181-036a-458d-9670-7176914fe2f2','2016-12-01',1,1,'','9865b143-347c-4364-b592-970f968751c7','17249794-ca76-467b-953f-a00a65404a77','Ayam Kota',0);
/*!40000 ALTER TABLE `request_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request_role`
--

DROP TABLE IF EXISTS `request_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `request_role` (
  `id` char(50) NOT NULL,
  `fk_request` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request_role`
--

LOCK TABLES `request_role` WRITE;
/*!40000 ALTER TABLE `request_role` DISABLE KEYS */;
INSERT INTO `request_role` VALUES ('09fa18d2-929a-48ac-bbe3-b060606fc030','9865b143-347c-4364-b592-970f968751c7'),('0e487a79-5393-476f-9ef8-c1c293a8f827','9865b143-347c-4364-b592-970f968751c7'),('1a3af1b9-af03-4feb-b01b-5201ccd6f952','4e9133f1-2198-4cb1-943e-739a5a0f6846'),('38f2e548-0873-4f49-b458-de6c73cec722','581ee3cb-0f00-4b7d-8f27-e31110410681'),('5084d7c7-9557-4b31-93a0-033ef7b13b22','9865b143-347c-4364-b592-970f968751c7'),('87350317-a5fa-44f2-9b66-aec9650f47de','ba959186-7702-466d-94ac-a6e2e1ecd93c'),('afe3868a-0a6b-418d-86e9-193aa304a964','581ee3cb-0f00-4b7d-8f27-e31110410681'),('c118f00c-eaf4-47e2-8ad4-9edf741823fd','4e9133f1-2198-4cb1-943e-739a5a0f6846'),('d27590ad-3690-47c7-985a-ab151b7ae699','46d9422c-b39b-494c-ad2a-9b87c67a5444'),('e5d1b9cf-7937-4235-9589-8098a186d429','46d9422c-b39b-494c-ad2a-9b87c67a5444'),('f41ddb17-fd5f-4c79-99d7-8dd43ac22ce8','ba959186-7702-466d-94ac-a6e2e1ecd93c');
/*!40000 ALTER TABLE `request_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requirement`
--

DROP TABLE IF EXISTS `requirement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `requirement` (
  `id` char(50) NOT NULL,
  `number` char(50) DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  `required_date` date DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `reason` varchar(250) DEFAULT NULL,
  `estimated_budget` decimal(10,0) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `organization_id` char(50) DEFAULT NULL,
  `organization_value` varchar(200) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requirement`
--

LOCK TABLES `requirement` WRITE;
/*!40000 ALTER TABLE `requirement` DISABLE KEYS */;
INSERT INTO `requirement` VALUES ('a012d70f-18a4-4178-beb9-ac2f0d947277','WRQ-26012017-1','2017-01-26','2017-01-26','buat kertas','perlu kertas',50000,'INTERNAL_REQUIREMENT','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA',0),('fd1a0364-e9d4-4979-9108-a4866f39d499','PRQ-26012017-1','2017-01-26','2017-01-26','Urgen','Ade yang nak beli',500000,'CUSTOMER_REQUIREMENT','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA',1);
/*!40000 ALTER TABLE `requirement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requirement_order_commitment`
--

DROP TABLE IF EXISTS `requirement_order_commitment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `requirement_order_commitment` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `fk_order_item` char(50) DEFAULT NULL,
  `requirement_id` char(50) DEFAULT NULL,
  `requirement_value` varchar(200) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requirement_order_commitment`
--

LOCK TABLES `requirement_order_commitment` WRITE;
/*!40000 ALTER TABLE `requirement_order_commitment` DISABLE KEYS */;
INSERT INTO `requirement_order_commitment` VALUES ('004ead01-039b-486e-aa34-b4c8a7808aec',10,'e19b02e9-b430-4f55-bf6a-8e35755d8203','fd1a0364-e9d4-4979-9108-a4866f39d499','26-01-2017',0);
/*!40000 ALTER TABLE `requirement_order_commitment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requirement_request`
--

DROP TABLE IF EXISTS `requirement_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `requirement_request` (
  `id` char(50) NOT NULL,
  `fk_request_item` char(50) DEFAULT NULL,
  `fk_requirement` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `requirement_role` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `type` char(15) DEFAULT NULL,
  `party_id` char(50) DEFAULT NULL,
  `party_value` varchar(250) DEFAULT NULL,
  `fk_requirement` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requirement_role`
--

LOCK TABLES `requirement_role` WRITE;
/*!40000 ALTER TABLE `requirement_role` DISABLE KEYS */;
INSERT INTO `requirement_role` VALUES ('77406370-bbcf-4849-8076-621761870ec7','2017-01-26',NULL,'INITIATOR','a685cde5-df6b-4430-babc-0ae846f8fa29','Rizky Chicken','fd1a0364-e9d4-4979-9108-a4866f39d499',0),('eabe0f8c-44d3-401a-8807-29abdba50c82','2017-01-26',NULL,'ENTERED_BY','c21873ef-3e29-43ca-92cd-45b5eb519c6e','Siti Komarudin','a012d70f-18a4-4178-beb9-ac2f0d947277',0),('eb062062-c340-40c1-8fe7-932d8caeab65','2017-01-26',NULL,'ENTERED_BY','c21873ef-3e29-43ca-92cd-45b5eb519c6e','Siti Komarudin','fd1a0364-e9d4-4979-9108-a4866f39d499',0);
/*!40000 ALTER TABLE `requirement_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requirement_status`
--

DROP TABLE IF EXISTS `requirement_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `requirement_status` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `fk_requirement` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requirement_status`
--

LOCK TABLES `requirement_status` WRITE;
/*!40000 ALTER TABLE `requirement_status` DISABLE KEYS */;
INSERT INTO `requirement_status` VALUES ('4f942949-fac2-465a-9eb6-21b2246b8743','2017-01-26','ACTIVE','a012d70f-18a4-4178-beb9-ac2f0d947277',0),('6f449e12-d17e-4943-9c16-12296d54b6fc','2017-01-26','ACTIVE','fd1a0364-e9d4-4979-9108-a4866f39d499',0);
/*!40000 ALTER TABLE `requirement_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `id` char(50) NOT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `result` varchar(250) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` char(50) NOT NULL,
  `code` varchar(150) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `Note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('096b0105-de76-492c-9bb0-5e518b46d69c','Sys Admin','System Administrator','System Administrator',NULL),('cecab92d-1762-4eb0-b45b-484e32e99fa3','XXX','ZZZ','',2);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roled`
--

DROP TABLE IF EXISTS `roled`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roled` (
  `id` char(50) NOT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `role_type` char(10) DEFAULT NULL,
  `is_done` char(1) DEFAULT '0',
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roled`
--

LOCK TABLES `roled` WRITE;
/*!40000 ALTER TABLE `roled` DISABLE KEYS */;
/*!40000 ALTER TABLE `roled` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_invoice`
--

DROP TABLE IF EXISTS `sales_invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales_invoice` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_invoice`
--

LOCK TABLES `sales_invoice` WRITE;
/*!40000 ALTER TABLE `sales_invoice` DISABLE KEYS */;
INSERT INTO `sales_invoice` VALUES ('3b695877-11a8-4ef6-8e27-7e0e99b3d2a0'),('68ec9160-400e-40e7-ab45-b9ced12330a5');
/*!40000 ALTER TABLE `sales_invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_order`
--

DROP TABLE IF EXISTS `sales_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales_order` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_order`
--

LOCK TABLES `sales_order` WRITE;
/*!40000 ALTER TABLE `sales_order` DISABLE KEYS */;
INSERT INTO `sales_order` VALUES ('388f9588-fddd-45ba-a328-bd41e24729e4'),('90fdcd0a-d324-4cab-a18c-25f27c06351f'),('ac5ef13a-c2ce-4ecb-9c3e-a911a7ad08f1'),('e9a8f83a-c00e-424c-957a-c15a81f5262e'),('ea69c005-d007-476d-931c-02e7b6daa147'),('eac4a1d1-454b-4a15-b35b-b631c595ed04');
/*!40000 ALTER TABLE `sales_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_order_item`
--

DROP TABLE IF EXISTS `sales_order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales_order_item` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_order_item`
--

LOCK TABLES `sales_order_item` WRITE;
/*!40000 ALTER TABLE `sales_order_item` DISABLE KEYS */;
INSERT INTO `sales_order_item` VALUES ('15403535-f3a1-4aa6-9db1-c1af69c4088d'),('2a45c16a-b549-4b23-9e20-81badf2e7749'),('65700f58-c5ca-45c4-9783-d09cca76a8f9'),('9dd39daa-4c00-4a07-853a-60e36312a838'),('a2251e43-bfd6-4ca4-8e92-ca1af78a70fd'),('b9974139-3c85-49d7-9418-f5a7800a7e00'),('e19b02e9-b430-4f55-bf6a-8e35755d8203');
/*!40000 ALTER TABLE `sales_order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequence_number`
--

DROP TABLE IF EXISTS `sequence_number`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sequence_number` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `person_id` char(50) DEFAULT NULL,
  `organization_id` char(50) DEFAULT NULL,
  `code` char(10) DEFAULT NULL,
  `sequence` bigint(20) DEFAULT 1,
  `year` int(11) DEFAULT NULL,
  `month` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence_number`
--

LOCK TABLES `sequence_number` WRITE;
/*!40000 ALTER TABLE `sequence_number` DISABLE KEYS */;
INSERT INTO `sequence_number` VALUES ('08f642d9-1072-4364-a921-c91df87db1a4','2016-07-08',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','CRS',3,0,0,1),('0f6c1237-c166-4224-9283-50118fe33c56','2016-06-04',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','CRS',5,0,0,3),('12eb0bd5-b47a-44cb-ba21-a456e60755b1','2017-01-26',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','PRQ',2,NULL,NULL,0),('15a8b327-002f-409f-a223-b7547c65b06e','2016-05-11',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','CRS',10,0,0,8),('1ef0e077-ac2c-47de-af92-bac0ae178b4a','2016-12-18',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','GRC',4,NULL,NULL,2),('1f667e97-ecc5-4b72-b2d9-955e1c92b6ad','2016-12-04',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','GRC',2,NULL,NULL,0),('25962de1-229e-452c-8537-b287070d756f','2016-08-07',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',3,0,0,1),('2aff62e9-55ba-46d9-a98b-07dc57b8b442','2016-12-20',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','PO',3,NULL,NULL,1),('2c8adbd8-d994-4f4b-92a0-cbdd57329bb2','2017-01-15',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','SHP',2,NULL,NULL,0),('3225a9fd-7df5-433b-9304-9c46a66620c4','2017-01-19',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','SIV',3,NULL,NULL,1),('33834a66-f5ba-4388-b9e2-bffd420d95c4','2016-08-18',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','CRS',2,0,0,0),('5448f8b5-472e-4329-bd3d-660594aa1173','2016-08-07',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','SDN',81,2016,7,79),('622a9914-f22a-4a61-ab6a-3f3bc16013cf','2016-12-20',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','SHP',3,NULL,NULL,1),('6b70a368-caa1-4353-a91c-bb532ddd9166','2016-12-15',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','PO',4,NULL,NULL,2),('6def02ff-cc03-4d0e-b5b3-fcc2fa4fd78e','2016-06-04',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',6,0,0,4),('725b432a-909d-41ee-85e8-f2e42791fcba','2016-12-27',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','SHP',2,NULL,NULL,0),('74989341-a57f-4a3f-aea3-4f6c50202835','2016-08-28',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','CRS',3,0,0,1),('764c213c-ad21-4140-a96c-fef2a89b3a82','2016-12-02',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','PO',2,NULL,NULL,0),('76ed745f-c4c6-4d81-94e0-529e9c1b57cd','2016-06-18',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',2,0,0,0),('77a03bb4-9cf9-45e0-aa7a-dc701730af46','2016-12-24',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','GRC',2,NULL,NULL,0),('7c12bd8d-f8d1-484f-85cd-99438ecadeb6','2016-12-01',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','GRC',9,NULL,NULL,7),('7d1b24aa-0925-4063-ab23-8f41506e088a','2016-07-04',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',2,0,0,0),('7e91abdc-b805-485d-af81-d2fd21f3c321','2016-08-18',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',13,0,0,11),('82cc60ee-fcf2-4ad7-9863-f91c00c19e9c','2017-01-23',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','WKR',3,NULL,NULL,1),('9351019e-e2f7-4a50-bec0-915db5634168','2017-01-05',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','WKR',2,NULL,NULL,0),('95f82a93-bd26-4118-8a7f-aaa4b49b7646','2016-12-01',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','REQ',5,NULL,NULL,3),('9650746d-f47d-42c5-99ac-209c836b5150','2016-09-04',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',2,0,0,0),('9792a185-3c61-4cd6-bb50-9398e81ec476','2016-08-07',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','CRS',5,0,0,3),('9a88a1a2-b757-4d9a-b68c-0d387372d6fc','2016-08-04',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',2,0,0,0),('9d00dad1-dc69-4e06-867a-1291f83b7dfc','2016-12-19',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','SO',3,NULL,NULL,1),('9dd3c758-5ee7-46bf-8d90-6ad373eb03b3','2017-01-04',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','WKR',5,NULL,NULL,3),('9e226682-2be1-4fce-a15d-6cd726be04fc','2016-08-16',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',11,0,0,9),('9e92dcf1-1655-43fb-b9d6-0ace1088b86b','2017-01-25',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','WEF',4,NULL,NULL,2),('a79bff05-5cfb-41e7-a9cb-5b375d507d15','2017-01-16',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','SHP',6,NULL,NULL,4),('b03f6c7c-dffa-401b-8065-528aeb5f87d7','2016-08-10',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',5,0,0,3),('b3de3142-f0bb-4464-b5be-30f2f1822aa8','2016-12-26',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','SHP',2,NULL,NULL,0),('bab6727b-7d04-472a-bf3f-ceb7985b974f','2017-01-09',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','WEF',8,NULL,NULL,6),('be086bbc-8ad1-42c3-b994-b10f58c53549','2017-01-14',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','SIV',3,NULL,NULL,1),('c230c8d2-05db-4164-844f-fa53f5912f17','2017-01-19',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','SHP',2,NULL,NULL,0),('c2a00197-2746-41a2-b53b-6c7155d9a519','2017-01-22',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','SO',2,NULL,NULL,0),('ca03ee00-7592-484e-9b68-371c2385e4ba','2016-07-08',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',2,0,0,0),('ca575756-d560-41ae-9482-409a8d83cfed','2016-12-08',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','GRC',2,NULL,NULL,0),('cb8bf571-fa7e-47f1-8120-a9ccf2bd2b0e','2016-07-22',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',2,0,0,0),('d0633e09-c294-4d2d-9e92-13ee0c068db1','2017-01-26',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','WRQ',2,NULL,NULL,0),('d54385aa-6c37-4a84-ac74-d41adeb6d0f9','2016-08-28',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',2,0,0,0),('d7ba3a61-4dcc-4d6e-8d87-eac62291719f','2017-01-15',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','SO',2,NULL,NULL,0),('d7ccfd5e-8b01-40ca-9b99-42288c1ffcf8','2016-12-16',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','PO',2,NULL,NULL,0),('e0364801-f875-4c88-a8a3-6b77b83640de','2016-12-26',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','SHI',4,NULL,NULL,2),('e65fd1c9-0d56-4d5e-b564-3dad3ccd42b5','2016-12-15',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','GRC',2,NULL,NULL,0),('e99c7b70-615b-454c-92c5-e9c45550203c','2016-08-16',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','CRS',6,0,0,4),('e9a1afb1-977d-43bc-80c2-bdea9e3f65cf','2017-01-18',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','SHP',3,NULL,NULL,1),('f2f0e932-8483-4db7-956c-71dcfa71fafc','2016-12-25',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','GRC',2,NULL,NULL,0),('f7e24049-f92f-4d00-9c06-77e3455d115a','2017-01-16',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','SO',2,NULL,NULL,0),('fddb349d-3c22-4952-ac14-0f5105584058','2016-05-11',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','INV',8,0,0,6);
/*!40000 ALTER TABLE `sequence_number` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment`
--

DROP TABLE IF EXISTS `shipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
  `number` varchar(100) DEFAULT NULL,
  `ship_from_party_id` char(50) DEFAULT NULL,
  `ship_from_party_value` varchar(150) DEFAULT NULL,
  `ship_from_address_id` char(50) DEFAULT NULL,
  `ship_from_address_value` varchar(250) DEFAULT NULL,
  `ship_from_contact_id` char(50) DEFAULT NULL,
  `ship_from_contact_value` varchar(150) DEFAULT NULL,
  `ship_to_party_id` char(50) DEFAULT NULL,
  `ship_to_party_value` varchar(150) DEFAULT '0',
  `ship_to_address_id` char(50) DEFAULT NULL,
  `ship_to_address_value` varchar(250) DEFAULT NULL,
  `ship_to_contact_id` char(50) DEFAULT NULL,
  `ship_to_contact_value` varchar(150) DEFAULT NULL,
  `fk_shipping_document` char(50) DEFAULT NULL,
  `last_status` char(25) DEFAULT 'SCHEDULED',
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment`
--

LOCK TABLES `shipment` WRITE;
/*!40000 ALTER TABLE `shipment` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment_issuance`
--

DROP TABLE IF EXISTS `shipment_issuance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipment_issuance` (
  `id` char(50) NOT NULL,
  `number` char(50) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `organization_id` char(50) DEFAULT NULL,
  `organization_value` varchar(250) DEFAULT NULL,
  `destination_party_id` char(50) DEFAULT NULL,
  `destination_party_value` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment_issuance`
--

LOCK TABLES `shipment_issuance` WRITE;
/*!40000 ALTER TABLE `shipment_issuance` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipment_issuance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment_issuance_item`
--

DROP TABLE IF EXISTS `shipment_issuance_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipment_issuance_item` (
  `id` char(50) NOT NULL,
  `accepted` decimal(10,0) DEFAULT NULL,
  `rejected` decimal(10,0) DEFAULT NULL,
  `expired` date DEFAULT NULL,
  `serial` varchar(150) DEFAULT NULL,
  `product_id` char(50) DEFAULT NULL,
  `product_value` varchar(250) DEFAULT NULL,
  `shipment_item_id` char(50) DEFAULT NULL,
  `shipment_item_value` varchar(250) DEFAULT NULL,
  `order_item_id` char(50) DEFAULT NULL,
  `order_item_value` varchar(250) DEFAULT NULL,
  `facility_id` char(50) DEFAULT NULL,
  `facility_value` varchar(250) DEFAULT NULL,
  `container_id` char(50) DEFAULT NULL,
  `container_value` varchar(250) DEFAULT NULL,
  `fk_shipment_issuance` char(50) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment_issuance_item`
--

LOCK TABLES `shipment_issuance_item` WRITE;
/*!40000 ALTER TABLE `shipment_issuance_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipment_issuance_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment_issuance_role`
--

DROP TABLE IF EXISTS `shipment_issuance_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipment_issuance_role` (
  `id` char(50) NOT NULL,
  `party_id` char(50) DEFAULT NULL,
  `party_value` varchar(250) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `fk_shipment_issuance` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment_issuance_role`
--

LOCK TABLES `shipment_issuance_role` WRITE;
/*!40000 ALTER TABLE `shipment_issuance_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipment_issuance_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment_item`
--

DROP TABLE IF EXISTS `shipment_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipment_item` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `processed` decimal(10,0) DEFAULT 0,
  `content` varchar(200) DEFAULT NULL,
  `fk_shipment` char(50) DEFAULT NULL,
  `fk_shipping_document` char(50) DEFAULT NULL,
  `product_id` char(50) DEFAULT NULL,
  `product_value` varchar(250) DEFAULT NULL,
  `invoiced` char(1) DEFAULT '0',
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment_item`
--

LOCK TABLES `shipment_item` WRITE;
/*!40000 ALTER TABLE `shipment_item` DISABLE KEYS */;
INSERT INTO `shipment_item` VALUES ('357f98ea-e4ef-4bde-8c4f-66deb821e490',15,0,'','fe1fe914-74c7-4ffe-af6b-855df8d217de',NULL,'64865838-5b79-40ca-a1e4-663d7139895a','Garang Asem Sapi','0',0),('38b3e150-202e-46ec-8bf6-089ea22c6167',10,10,'','96139fb4-dd5a-4733-8c9e-70a2bcc8a936',NULL,'64865838-5b79-40ca-a1e4-663d7139895a','Garang Asem Sapi','0',15),('6dcd1cce-2238-4b42-955e-936e626cadfc',55,0,'','3c09618e-e89e-4d3c-bbab-cdf8f91f1366',NULL,'64865838-5b79-40ca-a1e4-663d7139895a','Garang Asem Sapi','0',0);
/*!40000 ALTER TABLE `shipment_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment_order`
--

DROP TABLE IF EXISTS `shipment_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipment_order` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `unit_price` decimal(10,0) DEFAULT 0,
  `order_item_id` char(50) DEFAULT NULL,
  `order_item_value` varchar(100) DEFAULT NULL,
  `order_id` char(50) DEFAULT NULL,
  `order_value` varchar(200) DEFAULT NULL,
  `fk_shipment_item` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment_order`
--

LOCK TABLES `shipment_order` WRITE;
/*!40000 ALTER TABLE `shipment_order` DISABLE KEYS */;
INSERT INTO `shipment_order` VALUES ('9c9411e0-f83b-4b07-b3db-aeed9d8e561b',10,15000,'8c9e24e2-7454-43fa-b091-823100d8aa2f','Garang Asem Sapi',NULL,NULL,'38b3e150-202e-46ec-8bf6-089ea22c6167',0),('d98be8c8-c827-47e6-9485-16625b7a5e1c',15,25000,'45005eb6-7c25-4119-a449-9084e6cb6c39','Garang Asem Sapi',NULL,NULL,'357f98ea-e4ef-4bde-8c4f-66deb821e490',0),('eb2c8d2c-3109-42ca-b171-eeb5ff11f5bb',50,25000,'b9974139-3c85-49d7-9418-f5a7800a7e00','Garang Asem Sapi','ac5ef13a-c2ce-4ecb-9c3e-a911a7ad08f1','SO-16012017-1','6dcd1cce-2238-4b42-955e-936e626cadfc',0),('f2f1d7f3-51f3-4012-b2b5-3814087571c6',5,23000,'9dd39daa-4c00-4a07-853a-60e36312a838','Garang Asem Sapi','ea69c005-d007-476d-931c-02e7b6daa147','SO191120162','6dcd1cce-2238-4b42-955e-936e626cadfc',0);
/*!40000 ALTER TABLE `shipment_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment_receipt`
--

DROP TABLE IF EXISTS `shipment_receipt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipment_receipt` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `number` char(50) DEFAULT NULL,
  `organization_id` char(50) DEFAULT NULL,
  `organization_value` varchar(225) DEFAULT NULL,
  `source_party_id` char(50) DEFAULT '0',
  `source_party_value` varchar(225) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment_receipt`
--

LOCK TABLES `shipment_receipt` WRITE;
/*!40000 ALTER TABLE `shipment_receipt` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipment_receipt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment_receipt_item`
--

DROP TABLE IF EXISTS `shipment_receipt_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipment_receipt_item` (
  `id` char(50) NOT NULL,
  `accepted` decimal(10,0) DEFAULT NULL,
  `rejected` decimal(10,0) DEFAULT NULL,
  `shipment_item_id` char(50) DEFAULT NULL,
  `shipment_item_value` varchar(225) DEFAULT '0',
  `facility_id` char(50) DEFAULT NULL,
  `facility_value` varchar(225) DEFAULT NULL,
  `container_id` char(50) DEFAULT NULL,
  `container_value` varchar(225) DEFAULT NULL,
  `fk_shipment_receipt` char(50) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `expired` date DEFAULT NULL,
  `serial` varchar(100) DEFAULT NULL,
  `order_item_id` char(50) DEFAULT NULL,
  `order_item_value` varchar(250) DEFAULT NULL,
  `product_id` char(50) DEFAULT NULL,
  `product_value` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment_receipt_item`
--

LOCK TABLES `shipment_receipt_item` WRITE;
/*!40000 ALTER TABLE `shipment_receipt_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipment_receipt_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment_receipt_role`
--

DROP TABLE IF EXISTS `shipment_receipt_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipment_receipt_role` (
  `id` char(50) NOT NULL,
  `party_id` char(50) DEFAULT NULL,
  `party_value` varchar(150) DEFAULT NULL,
  `type` char(35) DEFAULT NULL,
  `fk_shipment_receipt` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment_receipt_role`
--

LOCK TABLES `shipment_receipt_role` WRITE;
/*!40000 ALTER TABLE `shipment_receipt_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipment_receipt_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment_route_segment`
--

DROP TABLE IF EXISTS `shipment_route_segment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
  `vehicle_id` char(50) DEFAULT NULL,
  `vehicle_value` varchar(150) DEFAULT NULL,
  `carrier_id` char(50) DEFAULT NULL,
  `carrier_value` varchar(250) DEFAULT NULL,
  `fk_shipment` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipment_status` (
  `id` char(50) NOT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `fk_shipment` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment_status`
--

LOCK TABLES `shipment_status` WRITE;
/*!40000 ALTER TABLE `shipment_status` DISABLE KEYS */;
INSERT INTO `shipment_status` VALUES ('0','2017-01-15 13:50:43','SCHEDULED','fe1fe914-74c7-4ffe-af6b-855df8d217de',0),('06387e65-2bc0-46ca-8038-12760163c153','2017-01-14 17:00:00','INROUTE','fe1fe914-74c7-4ffe-af6b-855df8d217de',0),('92269c30-7798-49b4-a825-a670fd279b91','2017-01-14 17:00:00','DELIVERED','fe1fe914-74c7-4ffe-af6b-855df8d217de',0),('9f37d5c8-1c12-4c43-9c7f-378d793c2896','2017-01-19 01:23:25','CANCELED','96139fb4-dd5a-4733-8c9e-70a2bcc8a936',0),('af4f9c82-26c9-4d75-9ffd-ca3ba2f7b608','2017-01-19 02:31:43','SCHEDULED','3c09618e-e89e-4d3c-bbab-cdf8f91f1366',0),('ca574017-ba5b-4017-8ba1-93bf1c4d9ad3','2017-01-19 01:23:19','SCHEDULED','96139fb4-dd5a-4733-8c9e-70a2bcc8a936',0),('d95308ef-5c48-4510-a610-71f52ecef6e4','2017-01-19 02:32:28','DELIVERED','3c09618e-e89e-4d3c-bbab-cdf8f91f1366',0);
/*!40000 ALTER TABLE `shipment_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipping_document`
--

DROP TABLE IF EXISTS `shipping_document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipping_document` (
  `id` char(50) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
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
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `simple_invoice_clinic_item` (
  `id` char(50) NOT NULL,
  `note` varchar(150) DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `fk_root` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `statuses` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `type` char(10) DEFAULT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock_adjustment` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `facility_id` char(50) DEFAULT NULL,
  `facility_value` varchar(250) DEFAULT NULL,
  `organization_id` char(50) DEFAULT NULL,
  `organization_value` varchar(250) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `creator` varchar(250) DEFAULT NULL,
  `editor` varchar(250) DEFAULT NULL,
  `created` timestamp NULL DEFAULT NULL,
  `last_edited` timestamp NULL DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_adjustment`
--

LOCK TABLES `stock_adjustment` WRITE;
/*!40000 ALTER TABLE `stock_adjustment` DISABLE KEYS */;
INSERT INTO `stock_adjustment` VALUES ('8879f7fa-436a-4da1-830f-09767836c57f','2016-09-30','11:26:16','Markas Nusa Indah',NULL,'e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA','',NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `stock_adjustment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_adjustment_item`
--

DROP TABLE IF EXISTS `stock_adjustment_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock_adjustment_item` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `fk_stock_adjustment` char(50) DEFAULT NULL,
  `product_id` char(50) DEFAULT NULL,
  `product_value` varchar(250) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `expired_date` date DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `container_value` varchar(250) DEFAULT NULL,
  `container_id` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_adjustment_item`
--

LOCK TABLES `stock_adjustment_item` WRITE;
/*!40000 ALTER TABLE `stock_adjustment_item` DISABLE KEYS */;
INSERT INTO `stock_adjustment_item` VALUES ('28afef19-12e6-43cb-b7e4-1571b3df8b78',100,'8879f7fa-436a-4da1-830f-09767836c57f','Ayam Kota Goreng',NULL,'',NULL,'ADDITION','Lemari 1','a87af5ed-2982-4f7d-8f90-2d4420f4aa78',0);
/*!40000 ALTER TABLE `stock_adjustment_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_admin`
--

DROP TABLE IF EXISTS `stock_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock_admin` (
  `id` char(50) NOT NULL,
  `fk_employee` char(50) DEFAULT NULL,
  `fk_internal_organization` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_admin`
--

LOCK TABLES `stock_admin` WRITE;
/*!40000 ALTER TABLE `stock_admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_history`
--

DROP TABLE IF EXISTS `stock_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock_history` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `stock_in` decimal(10,0) DEFAULT NULL,
  `stock_out` decimal(10,0) DEFAULT NULL,
  `fk_inventory_item` char(50) DEFAULT NULL,
  `creator` varchar(150) DEFAULT NULL,
  `editor` varchar(150) DEFAULT NULL,
  `created` timestamp NULL DEFAULT NULL,
  `last_edited` timestamp NULL DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_history`
--

LOCK TABLES `stock_history` WRITE;
/*!40000 ALTER TABLE `stock_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_opname`
--

DROP TABLE IF EXISTS `stock_opname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock_opname` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  `fk_facility` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` char(50) NOT NULL,
  `parent_name` varchar(150) DEFAULT NULL,
  `school_name` varchar(150) DEFAULT NULL,
  `source` char(15) DEFAULT 'Friend',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('013f6fbf-2c6b-4d7a-8b04-2ad181d02bd7','Lisnawati','SMA N 7 Pontianak','Friend'),('09890166-4ccc-41d4-a54c-5a0e5864f6e3','Sri Handayani','MTs N 2 Pontianak','Friend'),('14bd9c3f-7770-4b64-b195-1cf29b60e38a','Juliandry','SMP N 1 Pontianak','Friend'),('19056ce0-9e11-4d7f-a136-54002d343c99','Ari Susnindar, S.T.','SMA Negeri 7','Friend'),('1f85a637-34bd-46cc-b824-0c67154988a9','Suwarno','SD Muhammadiyah 1 Pontianak','Friend'),('206fbce2-5238-443b-9840-c8d98cd1b111','Sri Umi Nasfiyati','SMA N 7 Pontianak','Friend'),('20f5051d-a3c7-447f-97a7-178e033547a9','H. Sulaiman, S.E.','MAN 2 Pontianak','Friend'),('25e3817d-03ac-4c25-873c-589c911191b9','Indra Nauli Lubis','SDS Bawamai Pontianak','Friend'),('27ba0cef-80c1-4dd8-828b-c8a331bd8fe7','Heryadi','SMP N 17 Pontianak','Friend'),('2919f335-3ec9-40c0-bfd2-0dea0a3f465e','Suyatna','SMP N 3 Pontianak','Friend'),('2b21be03-bbbd-454f-a7aa-2cd75a76f2c8','Solha','SMA N 3 Pontianak','Friend'),('36395e06-fc13-4720-9466-ac6ee36099b0','Agus Raya','SMA N 9 Pontianak','Friend'),('3642b32d-8f15-45d9-adb6-3f325f9bb6c2','Uray Harun','SMP N 24 Negeri','Friend'),('3679901a-5145-4240-be19-f6693c9c3217','Hadi Prayitno & Eka Vitriani','SMP N 1 Pontianak','Friend'),('38a2b91d-a6b3-489a-a6cb-05acac001f99','Herry Aca','SMP N 1 Pontianak','Friend'),('3a579716-6a51-4bd5-a667-bdf6a174250f','Sumarseno','SMA Panca Bhakti','Friend'),('3b535b54-dba9-4067-a2a9-1af2e1696f85','Syf. Zaleha Eliza','MTs N 1 Pontianak','Friend'),('40e222c3-db79-436c-b58a-de537f99a0df','Nuryanti Malani','SMP N 10 Pontianak','Friend'),('41826c9d-5160-4912-995c-19a5b3700b45','Supriyadi','SMP N 1 Pontianak','Friend'),('4435f12f-3a1a-45c6-bce7-0db20cd97911','Ramli Salim','SMA N 3 Pontianak','Friend'),('4a79e394-7635-44c8-9aa0-d373e3f71990','Elmania','SMA N 10 Pontianak','Friend'),('51125d9e-8a12-40c1-8519-faad4b8065f2','Zulkarnain, S.Sos.','SMA N 8 Pontianak','Friend'),('518c3838-0f36-402f-9bad-652e93f1533c','Ridwan','MTs Negeri 1 Pontianak','Friend'),('51c3c592-434d-4aea-9c66-e33cefcce8a8','Roni Basuki','MTs Al-Ikhwah Pontianak / SMP N 3','Friend'),('58d04d5d-d3f8-43f8-b98e-09bb8afc4f54','Suherman','SMA N 3 Pontianak','Friend'),('59851383-6691-45c0-8330-10e86ac2342d','Limaisim','SMA N 2 Pontianak','Friend'),('5a6f3da9-5900-46aa-bac3-08ff13e6b0af','Udi Suyudi','SMP N 9 Pontianak','Friend'),('5cd4779d-3fb6-40cb-a532-e543734341d3','Sukandar','SMAN 3 Pontianak','Friend'),('607abfa1-d844-466b-8e1b-99e200e06cba','M. Darmawan','SD Plus Bina 45 Pontianak Timur','Friend'),('67a29453-75e5-427b-88d3-2dccb104f9b2','Edy Soegiono, S.E.','SMA N 2 Pontianak','Friend'),('6cec3c65-b6ff-4094-b90b-4748c634d508','Suwandi','SMA N 6 Pontianak','Friend'),('71ef3dc2-f4f1-48ed-b166-e2fa24fb7601','Suparji','SMP N 3 Pontianak','Friend'),('72301c4d-1c56-4fcd-84e7-c6cf1ff04308','Tri Wigianti','SMA Muhammadiyah 1 Pontianak','Friend'),('72833aed-7a0c-4a09-9049-35f0aab38458','Haris','SDN 6 Pontianak','Friend'),('743b9b7f-9292-407f-aa0d-9305b98becff','Hariyanto','MAN 2 Pontianak','Friend'),('7dd6af66-de94-49ff-ac9b-7dd42a15cb0b','Achmad Faisal','SMA N 7 Pontianak','Friend'),('7dd9fbae-3b38-446e-b2cc-64f1692eb4c0','Sri Margaretha Dayang','SMA N 2 Pontianak','Friend'),('7f4d7f25-a9e0-47f5-b8e3-47d8b492aa39','Tommy Hidayat','MAN 1 Pontianak','Friend'),('81411eb4-901e-47d6-a97d-eb6b2d09c917','Suharti','SMP N 10 Pontianak','Friend'),('81cebf95-2bc8-47ba-b782-84722ae48ab5','Belum Tau','SMP N 17 Pontianak','Friend'),('86cdb736-158a-43a1-97f6-92eb5a507a9b','Devi Herlinda','SMA Muhammadiyah 1 Pontianak','Friend'),('895c6562-c9c5-4b9e-8cd6-f34afa95238c','Selerina','SMA N 7 Pontianak','Friend'),('93d109dd-5451-4823-8cff-b9b1806a1ff8','Andy Hasiyadi','SMU Tunas Bakti','Friend'),('9575be3b-df71-4a73-ad13-91bd9f226ebb','Wiradhad / Erna Medina','SMA N 7 Pontianak','Friend'),('961de37e-d784-4190-9f3d-8b12781c3b4e','Roby Nazarudin, S.H.','SD Muhammadiyah 2 Pontianak','Friend'),('99aab9a3-69ed-4f66-9508-6e6dea71f5e7','Umy Hani','SMA N 2 Pontianak','Friend'),('9c003100-b652-498f-b4aa-4c3077667683','Agus Haryono, S.H.','SMP N 9 Pontianak','Friend'),('a2486b77-c0c8-441e-8ad3-16d213fada1f','Agus Hidayat','SMP N 10 Pontianak','Friend'),('a6d1bcd6-f39b-498b-a888-f3a14d76757c','Lina Rosanti AR','SMA N 2 Pontianak','Friend'),('aa0d0f9e-fa99-4964-a7c8-50837cfc95c4','Indra Nauli Lubis','SMP N 3 Pontianak','Friend'),('acd9ad82-15a8-4460-a437-9cf049aa6fdd','Ulung Alana','SMA N 2 Pontianak','Friend'),('b6e6b30b-1d19-4310-a4fa-27a7cc233f30','Oskandar','SMP N 9 Pontianak','Friend'),('b6e87fe4-9f31-4741-89a0-77530ba60d51','Sri Yanti','SDN 39 Pontianak','Friend'),('b899ae55-9627-4da2-a702-8adb2d908b0c','Heri Sutasno','SMA N 8 Pontianak','Friend'),('bed05b14-62dc-4c93-bc6b-825930e013fc','Debbie Savira Indrayabi','MTs Negeri 2','Friend'),('bf088633-0bdb-4285-976a-6c72652bbf15','Sunaryo','SMA N 6 Pontianak','Friend'),('bf336e36-5de1-43dc-90df-d6691ee37cb6','Nurhainah','MAN 1 Pontianak','Friend'),('c6429b9c-b534-462d-9de2-daf3a26d7782','Ferry Wigisono','SMP N 5 Pontianak','Friend'),('ca5f620c-7715-452c-a9ff-76dd4ec4268f','Belum Tau','SMP N 1 Pontianak','Friend'),('cc0772a2-3380-4f0a-ab00-3b1dd3f13606','Khalifudiansyah','MTs Negeri 1 Pontianak','Friend'),('ced63b0d-655c-4094-ba4c-3a36d11efe1a','Juliandri','SMP N 9 Pontianak','Friend'),('cee4b98e-b0ff-4ccd-b5f3-ab8f2ccc0d44','Supriadi Sino','SMA N 10 Pontianak','Friend'),('d107d701-77ab-46fa-b28b-7ca533b01835','Agus Haryono, S.H.','SMP N 9 Pontianak','Friend'),('d527a974-7114-4887-b2d0-ddb3995da945','Tommy Hidayat','SMP N 23 Pontianak','Friend'),('d5feeaa3-b34d-4495-b529-1e932e953ae0','M. Yusuf','MAN 2 Pontianak','Friend'),('d67d6382-c999-49d9-adc8-1d22214aa367','Bayu Waraswati','SMA N 1 Pontianak','Friend'),('db471402-1f99-403c-bbcc-fc0bc20f58b0','Supriaji','SMP N 1 Pontianak','Friend'),('dfc15c98-8c01-412e-beb0-904170908b5f','Istikharah Noor','MTs Negeri 1 Pontianak','Friend'),('e721b7c8-ab3f-4932-9688-6d2755cbf647','Wiradad / Erna Medina','SMP N 9 Pontianak','Friend'),('ed53f41a-18b9-41e5-a5f5-09de16da9609','Saiful Muslimin & Fitriawati','SMP N 9 Pontianak','Friend'),('f2b8de62-48db-4af6-a587-ce0257528679','Suparji','SMP N 3 Pontianak','Friend'),('f4b3800b-b0d5-4519-b86e-b5775184f4ab','Supriyadi','MTs Negeri 1','Friend'),('f971e4ae-b2eb-4572-ad76-ba60843880fc','Iskandar, S.E.','SMP Negeri 3 Pontianak','Friend');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_relationship`
--

DROP TABLE IF EXISTS `student_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_relationship` (
  `id` char(50) NOT NULL,
  `fk_student` char(50) DEFAULT NULL,
  `fk_organization` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_relationship`
--

LOCK TABLES `student_relationship` WRITE;
/*!40000 ALTER TABLE `student_relationship` DISABLE KEYS */;
INSERT INTO `student_relationship` VALUES ('032be2c3-cc2e-40e3-8b02-e9fdea941293','db471402-1f99-403c-bbcc-fc0bc20f58b0','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('076ce509-80f9-43a5-817f-dec95cc60c91','bf336e36-5de1-43dc-90df-d6691ee37cb6','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('08c4b3fc-4b19-4f1a-8c30-bd56fa568597','cc0772a2-3380-4f0a-ab00-3b1dd3f13606','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('0dbac322-1500-4363-b343-a62d13017a3b','895c6562-c9c5-4b9e-8cd6-f34afa95238c','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('0dff5e0d-4271-46a5-bc99-c553e54bdbff','607abfa1-d844-466b-8e1b-99e200e06cba','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('0f2e07d7-b23a-4716-8b30-636b72823f3f','b899ae55-9627-4da2-a702-8adb2d908b0c','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('135e4c98-33e0-4bf2-944b-de7b70fdcea0','81cebf95-2bc8-47ba-b782-84722ae48ab5','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('139c104e-21c3-42d0-a166-219f0849c3fb','206fbce2-5238-443b-9840-c8d98cd1b111','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('1c54f327-4edb-453f-bb66-d88b32c1a32b','d527a974-7114-4887-b2d0-ddb3995da945','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('1f39020a-3329-4285-b1ad-0c1f193b6070','38a2b91d-a6b3-489a-a6cb-05acac001f99','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('1ff2319f-5daf-412c-81d5-86cd4ee4c7e1','86cdb736-158a-43a1-97f6-92eb5a507a9b','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('23c55f7d-514e-48fe-a253-4ad962e4e8cf','f2b8de62-48db-4af6-a587-ce0257528679','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('28557ce2-861b-4928-b19a-3f2be3be3a8d','ca5f620c-7715-452c-a9ff-76dd4ec4268f','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('2925e2a8-8fb2-41ef-a097-99230aa39ae3','aa0d0f9e-fa99-4964-a7c8-50837cfc95c4','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('2926861b-df52-4312-bfbe-74cb6e48a6f4','bf088633-0bdb-4285-976a-6c72652bbf15','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('2b729014-d894-4d64-82ed-9ce3ea6908e5','d67d6382-c999-49d9-adc8-1d22214aa367','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('2bfc959f-896e-4fe9-8c54-dec324f57108','59851383-6691-45c0-8330-10e86ac2342d','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('30255c60-7b8d-4ac3-843c-ead85edd88e1','5a6f3da9-5900-46aa-bac3-08ff13e6b0af','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('30bd079b-e877-4e72-8c6c-a2b73804596a','19056ce0-9e11-4d7f-a136-54002d343c99','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('310c82dd-78ed-4942-b10e-5509034c7e8c','d107d701-77ab-46fa-b28b-7ca533b01835','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('329e54ac-e836-4686-96aa-c942597606e7','b6e87fe4-9f31-4741-89a0-77530ba60d51','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('34cf8129-bead-4a09-b104-df235436e2fa','cee4b98e-b0ff-4ccd-b5f3-ab8f2ccc0d44','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('34e0bd3e-d7f4-4485-a7a6-36328b1619d9','9575be3b-df71-4a73-ad13-91bd9f226ebb','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('37ea2be0-018e-4099-b8ef-e40856893fa4','67a29453-75e5-427b-88d3-2dccb104f9b2','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('384b5038-10f2-4a19-a6d4-584c3c3f7d29','20f5051d-a3c7-447f-97a7-178e033547a9','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('3a4619fd-3c77-450a-9797-7d08871076a8','961de37e-d784-4190-9f3d-8b12781c3b4e','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('3ef18a42-d035-484a-9aa6-f9fa1258598f','518c3838-0f36-402f-9bad-652e93f1533c','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('42c711be-69e3-49f4-91b7-690a47b284b8','1f85a637-34bd-46cc-b824-0c67154988a9','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('453d166a-07cf-4414-ba22-3f900a43ff4d','f971e4ae-b2eb-4572-ad76-ba60843880fc','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('48a551a0-476d-4512-b664-425de879cbf5','3b535b54-dba9-4067-a2a9-1af2e1696f85','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('4d51d260-8fcc-4bcd-babf-eac8fdf495ae','3642b32d-8f15-45d9-adb6-3f325f9bb6c2','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('52629dee-9f9b-4a8c-b01a-cdb3b76d122b','acd9ad82-15a8-4460-a437-9cf049aa6fdd','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('531b848c-499c-4e6f-ab4a-46cc96e58a04','f68bcc40-325f-4991-ad69-f6c87dd6d09c','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('601daaa4-e8f7-4e32-8adf-7fbd9f1a8dfd','99aab9a3-69ed-4f66-9508-6e6dea71f5e7','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('602ad1b2-57bf-4c0b-adb9-3d4c7c051a71','7f4d7f25-a9e0-47f5-b8e3-47d8b492aa39','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('6472b733-96d7-4de4-ba0d-9bf8e4ffc29e','7dd6af66-de94-49ff-ac9b-7dd42a15cb0b','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('65b6ae84-53c2-4903-839c-c5b5589e3cd5','a6d1bcd6-f39b-498b-a888-f3a14d76757c','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('65de20c0-f5df-46bd-b91e-a8de5b03a53c','b6e6b30b-1d19-4310-a4fa-27a7cc233f30','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('6788c207-ca1e-464d-b9eb-26d33c7a4068','14bd9c3f-7770-4b64-b195-1cf29b60e38a','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('68410bee-958e-4184-95b3-9e4ff71924a6','d5feeaa3-b34d-4495-b529-1e932e953ae0','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('6a19d48c-741b-4740-832f-a5dc80c13e91','72301c4d-1c56-4fcd-84e7-c6cf1ff04308','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('6f484743-b027-43b6-ba12-09e9dded155a','5cd4779d-3fb6-40cb-a532-e543734341d3','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('709f87d5-ade6-41b9-ac4a-cebd75e56b5c','4435f12f-3a1a-45c6-bce7-0db20cd97911','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('710d06f5-4191-4aea-88eb-14a3f53a6a64','93d109dd-5451-4823-8cff-b9b1806a1ff8','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('7fc21295-ab33-4c14-bc49-ddab440c46c3','81411eb4-901e-47d6-a97d-eb6b2d09c917','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('8b67df0e-b5de-46ca-ba28-4693af99881e','3a579716-6a51-4bd5-a667-bdf6a174250f','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('8e716d34-c6aa-406f-9119-227dbb3c4d90','9c003100-b652-498f-b4aa-4c3077667683','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('8f36a40e-83c1-4960-95bb-348fa34658b0','4a79e394-7635-44c8-9aa0-d373e3f71990','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('958a5554-bff8-484a-a30d-1e61c65efbf1','71ef3dc2-f4f1-48ed-b166-e2fa24fb7601','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('a7dd038f-31e2-40a2-b65d-07d43e44c587','7dd9fbae-3b38-446e-b2cc-64f1692eb4c0','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('ac406878-2721-4b1b-bda9-13a1d099960d','bed05b14-62dc-4c93-bc6b-825930e013fc','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('ad3b5b6b-1237-49bb-9a0f-7e08a5b4eb77','ed53f41a-18b9-41e5-a5f5-09de16da9609','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('c18bbd27-c31f-4498-b873-20628f13ce56','27ba0cef-80c1-4dd8-828b-c8a331bd8fe7','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('c2960a06-c18c-44ef-94d6-a6720ab9dc1c','2919f335-3ec9-40c0-bfd2-0dea0a3f465e','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('c2bc1638-71bd-4381-bee4-f18baa7eb5c5','2b21be03-bbbd-454f-a7aa-2cd75a76f2c8','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('c3785077-cbec-4ff1-9000-52bd087abdc2','ced63b0d-655c-4094-ba4c-3a36d11efe1a','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('c39e32af-9b46-4dce-957a-c04ed5f70696','3679901a-5145-4240-be19-f6693c9c3217','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('c74385e6-156f-4065-97ef-7c45a5de504d','013f6fbf-2c6b-4d7a-8b04-2ad181d02bd7','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('c929d858-e4e5-4c5e-92ba-1091e65c836c','dfc15c98-8c01-412e-beb0-904170908b5f','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('ca7ee52a-5bc5-4563-8303-16d590c6f7c0','72833aed-7a0c-4a09-9049-35f0aab38458','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('d30b1768-45bb-41ce-8561-0344d5388aa2','58d04d5d-d3f8-43f8-b98e-09bb8afc4f54','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('d470bf2b-bb5c-41bb-81a1-b93dbe00ba3a','36395e06-fc13-4720-9466-ac6ee36099b0','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('d74a2e88-800b-4cb6-ab5e-1d9ca31e4d7f','40e222c3-db79-436c-b58a-de537f99a0df','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('d98aa4c5-2875-4899-bd1f-407e48c345a2','c6429b9c-b534-462d-9de2-daf3a26d7782','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('dc0d6440-e5ac-40dc-8198-935b0acf5a37','25e3817d-03ac-4c25-873c-589c911191b9','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('dc760901-56e6-4edc-86e6-3157c00fcdf5','6cec3c65-b6ff-4094-b90b-4748c634d508','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('e21ce90b-da25-4be6-81d3-26e6b7a7efd8','e721b7c8-ab3f-4932-9688-6d2755cbf647','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('e65816bf-e384-49a6-a874-01cfc0db40f9','f4b3800b-b0d5-4519-b86e-b5775184f4ab','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('e757012c-967f-4b9f-851a-75792a157a3c','41826c9d-5160-4912-995c-19a5b3700b45','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('f04a6b9a-c638-4cdf-a1f5-09e6f48413bc','743b9b7f-9292-407f-aa0d-9305b98becff','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('f1501be0-3f40-4620-a8c7-20f2e03a1724','a2486b77-c0c8-441e-8ad3-16d213fada1f','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('f6fe4b06-975f-4582-bd8e-fe76cf3fdd0a','09890166-4ccc-41d4-a54c-5a0e5864f6e3','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('fafb7450-1dda-466a-b92d-5f5da89230d1','51125d9e-8a12-40c1-8519-faad4b8065f2','742fc487-8b9d-41d8-9a0c-b55772bc2c49'),('fb0e872e-b148-4c31-ae38-f2a3dbe1322a','51c3c592-434d-4aea-9c66-e33cefcce8a8','742fc487-8b9d-41d8-9a0c-b55772bc2c49');
/*!40000 ALTER TABLE `student_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `study_day`
--

DROP TABLE IF EXISTS `study_day`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `study_day` (
  `id` char(50) NOT NULL,
  `is_sunday` char(1) DEFAULT '0',
  `is_monday` char(1) DEFAULT '0',
  `is_tuesday` char(1) DEFAULT '0',
  `is_wednesday` char(1) DEFAULT '0',
  `is_thrusday` char(1) DEFAULT '0',
  `is_friday` char(1) DEFAULT '0',
  `is_saturday` char(1) DEFAULT '0',
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `study_day`
--

LOCK TABLES `study_day` WRITE;
/*!40000 ALTER TABLE `study_day` DISABLE KEYS */;
INSERT INTO `study_day` VALUES ('65732831-20a9-4870-8f5f-32d7e3b71edb','0','1','0','1','0','1','0',0),('c3681331-54b4-46cd-b119-ac0730c28b1c','0','0','1','0','1','0','1',0);
/*!40000 ALTER TABLE `study_day` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `study_period`
--

DROP TABLE IF EXISTS `study_period`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `study_period` (
  `id` char(50) NOT NULL,
  `name` varchar(150) NOT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `study_period`
--

LOCK TABLES `study_period` WRITE;
/*!40000 ALTER TABLE `study_period` DISABLE KEYS */;
INSERT INTO `study_period` VALUES ('e4c80e40-aaee-4127-9888-5e798aec080e','Tahun Ajaran 2016/2017','',0);
/*!40000 ALTER TABLE `study_period` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `study_room`
--

DROP TABLE IF EXISTS `study_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `study_time` (
  `id` char(50) NOT NULL,
  `start` time DEFAULT NULL,
  `end` time DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `study_time`
--

LOCK TABLES `study_time` WRITE;
/*!40000 ALTER TABLE `study_time` DISABLE KEYS */;
INSERT INTO `study_time` VALUES ('2dda14a2-c020-42b2-ba43-b663a86f30c5','15:00:00','17:00:00',1),('963b3b08-0dd2-4cba-8ea7-fc4f306748c1','19:10:00','21:10:00',0),('d127c85a-f4fb-4d3b-8f59-81d332ea481b','17:00:00','19:10:00',0);
/*!40000 ALTER TABLE `study_time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier_relationship` (
  `id` char(50) NOT NULL,
  `fk_supplier` char(50) DEFAULT NULL,
  `fk_internal_organization` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tax` (
  `id` char(50) NOT NULL,
  `code` char(50) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `is_default` char(1) DEFAULT '0',
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `term_type` (
  `id` char(50) NOT NULL,
  `description` varchar(150) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `term_type`
--

LOCK TABLES `term_type` WRITE;
/*!40000 ALTER TABLE `term_type` DISABLE KEYS */;
INSERT INTO `term_type` VALUES ('00000','Tempo Pembayaran (Hari)',1);
/*!40000 ALTER TABLE `term_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time_entry`
--

DROP TABLE IF EXISTS `time_entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `time_entry` (
  `id` char(50) NOT NULL,
  `start` timestamp NULL DEFAULT NULL,
  `end` timestamp NULL DEFAULT NULL,
  `hours` int(11) DEFAULT NULL,
  `fk_timesheet` char(50) DEFAULT NULL,
  `fk_work_effort` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time_entry`
--

LOCK TABLES `time_entry` WRITE;
/*!40000 ALTER TABLE `time_entry` DISABLE KEYS */;
/*!40000 ALTER TABLE `time_entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timesheet`
--

DROP TABLE IF EXISTS `timesheet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `timesheet` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `comment` varchar(250) DEFAULT NULL,
  `worker_id` char(50) DEFAULT NULL,
  `worker_value` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `timesheet_role` (
  `id` char(50) NOT NULL,
  `timesheet_role_type` char(30) DEFAULT NULL,
  `fk_timesheet` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transfer_order_request` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transfer_order_request_item` (
  `id` char(50) NOT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_transfer_order` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `treatment` (
  `id` char(50) NOT NULL,
  `is_bpjs` char(1) DEFAULT '0',
  `bpjs_payment_status` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `treatment_item` (
  `id` char(50) NOT NULL,
  `fk_product_treatment` char(50) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `discount` decimal(10,0) DEFAULT NULL,
  `charge` decimal(10,0) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_treatment` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unit_of_measure` (
  `id` char(50) NOT NULL,
  `code` char(25) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `type` char(10) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unit_of_measure`
--

LOCK TABLES `unit_of_measure` WRITE;
/*!40000 ALTER TABLE `unit_of_measure` DISABLE KEYS */;
INSERT INTO `unit_of_measure` VALUES ('46ff493b-776b-4b9c-b199-39b9ef3b5f19',NULL,'Potong','','MASS',0),('50584420-9995-477f-901d-880695e01602',NULL,'Kg','','MASS',0),('b116c0d8-0e2c-40bb-9c16-db3fde15cc4c',NULL,'Jam','Satuan Jam','TIME',2),('d43b50b5-3819-45e6-822f-707c7d64cb5f',NULL,'Visit','','MASS',0),('eb23ea67-cdda-4668-8624-872fdf445a0c',NULL,'Ekor','','MASS',0);
/*!40000 ALTER TABLE `unit_of_measure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uom_factor`
--

DROP TABLE IF EXISTS `uom_factor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `uom_factor` (
  `id` char(50) NOT NULL,
  `factor` decimal(10,0) DEFAULT NULL,
  `fk_uom_from` char(50) DEFAULT NULL,
  `fk_uom_to` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uom_factor`
--

LOCK TABLES `uom_factor` WRITE;
/*!40000 ALTER TABLE `uom_factor` DISABLE KEYS */;
INSERT INTO `uom_factor` VALUES ('2679d072-48ba-4816-afb3-d3c4b27359e0',176,'002e1b00-f0a8-4313-abf8-dbd3d863b1d8','be5ad391-0c12-4c0a-bad5-7ee5254abb56',0),('47faab1e-15be-4427-bb08-7eb78253b48f',4,'eb23ea67-cdda-4668-8624-872fdf445a0c','46ff493b-776b-4b9c-b199-39b9ef3b5f19',0),('6de49d0e-a662-433a-ae33-a3356422d1da',22,'002e1b00-f0a8-4313-abf8-dbd3d863b1d8','4906be4c-a7c6-4aef-a215-c68cc2a7de77',0),('a49172cd-35f1-4201-a29b-d23a8c4ab87a',5,'3744de49-a23d-4280-8f8f-b8a2218ffa2b','4906be4c-a7c6-4aef-a215-c68cc2a7de77',0),('e040fefe-b37a-403d-a005-afc2203547e6',4,'002e1b00-f0a8-4313-abf8-dbd3d863b1d8','3744de49-a23d-4280-8f8f-b8a2218ffa2b',0),('eb089afc-b624-4ce5-95b3-46360e9cb8ff',8,'4906be4c-a7c6-4aef-a215-c68cc2a7de77','be5ad391-0c12-4c0a-bad5-7ee5254abb56',0);
/*!40000 ALTER TABLE `uom_factor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id` char(50) NOT NULL,
  `fk_user` char(50) DEFAULT NULL,
  `fk_role` char(50) DEFAULT NULL,
  `role_name` varchar(200) DEFAULT NULL,
  `is_enabled` char(1) DEFAULT '1',
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES ('7c3f7341-bbfd-4f60-aca9-7672f83b1a77','97dc9715-47eb-45d5-96ba-0a582fabdf3b','cecab92d-1762-4eb0-b45b-484e32e99fa3',NULL,'0',0),('849138a5-4b4e-41ea-8f24-e4586e7f8ab9','97dc9715-47eb-45d5-96ba-0a582fabdf3b','096b0105-de76-492c-9bb0-5e518b46d69c','System Administrator','1',0);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_setting`
--

DROP TABLE IF EXISTS `user_setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_setting` (
  `id` char(50) NOT NULL,
  `organization_id` char(50) DEFAULT NULL,
  `organization_value` varchar(150) DEFAULT NULL,
  `location_id` char(50) DEFAULT NULL,
  `location_value` varchar(150) DEFAULT NULL,
  `currency_id` char(50) DEFAULT NULL,
  `currency_value` varchar(150) DEFAULT NULL,
  `tax_id` char(50) DEFAULT NULL,
  `tax_value` varchar(150) DEFAULT NULL,
  `language` varchar(250) DEFAULT NULL,
  `row_per_page` int(11) DEFAULT 25,
  `printer_type` char(10) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `facility_id` varchar(100) DEFAULT NULL,
  `facility_value` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_setting`
--

LOCK TABLES `user_setting` WRITE;
/*!40000 ALTER TABLE `user_setting` DISABLE KEYS */;
INSERT INTO `user_setting` VALUES ('28fc7f13-1777-47e3-94c8-8b54436b1e96',NULL,NULL,'c4c10aee-a3a1-4e6c-a08b-62d4e26414df','Pontianak','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah',NULL,NULL,'in_id',25,'STANDARD',14,NULL,NULL),('8a15a5cc-2549-42cc-9086-68ac948b5f74','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','Pontianak','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah',NULL,NULL,'en_us',25,'POS',5,NULL,NULL),('8c2cea76-1f03-4dbe-a2d0-31c86fce1c15','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA','c4c10aee-a3a1-4e6c-a08b-62d4e26414df','Pontianak','85c90912-97ff-47ce-9d6a-7d1650ab3ea9','Rupiah','d4921463-e9ff-4c8e-b6ff-9a1730688fbb','R-PPN','en_us',25,'POS',2,NULL,NULL);
/*!40000 ALTER TABLE `user_setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_effort`
--

DROP TABLE IF EXISTS `work_effort`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_effort` (
  `id` char(50) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `scheduled_start` date DEFAULT NULL,
  `scheduled_end` date DEFAULT NULL,
  `actual_start` date DEFAULT NULL,
  `actual_end` date DEFAULT NULL,
  `hours` decimal(10,0) DEFAULT NULL,
  `max_allowed_hours` decimal(10,0) DEFAULT NULL,
  `max_allowed_money` decimal(10,0) DEFAULT NULL,
  `purpose` char(35) DEFAULT NULL,
  `number` char(50) DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  `organization_id` char(50) DEFAULT NULL,
  `organization_value` varchar(200) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `requester_id` char(50) DEFAULT NULL,
  `requester_value` varchar(200) DEFAULT NULL,
  `invoiced` char(1) DEFAULT '0',
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_effort`
--

LOCK TABLES `work_effort` WRITE;
/*!40000 ALTER TABLE `work_effort` DISABLE KEYS */;
INSERT INTO `work_effort` VALUES ('b8e7e852-7995-4446-8ef0-a97d5021f7d0','Pemeriksaan Dokter Umum','','2017-01-25','2017-01-25','2017-01-25','2017-01-25',1,NULL,NULL,'WORKFLOW','WEF-25012017-3','2017-01-25','e29c7687-30f8-4201-af68-0a4a67541b86','SSC PANCASILA','TASK',NULL,NULL,'0',0);
/*!40000 ALTER TABLE `work_effort` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_effort_asset_assignment`
--

DROP TABLE IF EXISTS `work_effort_asset_assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_effort_asset_assignment` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `cost` decimal(10,0) DEFAULT NULL,
  `rate` decimal(10,0) DEFAULT 0,
  `type` char(25) DEFAULT NULL,
  `fk_asset` char(50) DEFAULT NULL,
  `fk_work_effort` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_effort_asset_assignment`
--

LOCK TABLES `work_effort_asset_assignment` WRITE;
/*!40000 ALTER TABLE `work_effort_asset_assignment` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_effort_asset_assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_effort_deliverable_produced`
--

DROP TABLE IF EXISTS `work_effort_deliverable_produced`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_effort_deliverable_produced` (
  `id` char(50) NOT NULL,
  `fk_work_effort` char(50) DEFAULT NULL,
  `fk_deliverable` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_effort_deliverable_produced`
--

LOCK TABLES `work_effort_deliverable_produced` WRITE;
/*!40000 ALTER TABLE `work_effort_deliverable_produced` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_effort_deliverable_produced` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_effort_info`
--

DROP TABLE IF EXISTS `work_effort_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_effort_info` (
  `id` char(50) NOT NULL,
  `name` varchar(250) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `hour` decimal(10,0) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_effort_info`
--

LOCK TABLES `work_effort_info` WRITE;
/*!40000 ALTER TABLE `work_effort_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_effort_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_effort_inventory_assignment`
--

DROP TABLE IF EXISTS `work_effort_inventory_assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_effort_inventory_assignment` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `fk_inventory_item` char(50) DEFAULT NULL,
  `fk_work_effort` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_effort_inventorys_produced` (
  `id` char(50) NOT NULL,
  `fk_work_effort` char(50) DEFAULT NULL,
  `fk_inventory_item` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_effort_party_assignment` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `rate` decimal(10,0) DEFAULT 0,
  `party_id` char(50) DEFAULT NULL,
  `party_value` varchar(200) DEFAULT '0',
  `facility_id` char(50) DEFAULT NULL,
  `facility_value` varchar(200) DEFAULT NULL,
  `fk_work_effort` char(50) DEFAULT NULL,
  `type` char(35) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_effort_party_assignment`
--

LOCK TABLES `work_effort_party_assignment` WRITE;
/*!40000 ALTER TABLE `work_effort_party_assignment` DISABLE KEYS */;
INSERT INTO `work_effort_party_assignment` VALUES ('e8b4c5b1-07cd-4007-b0b5-f067f7f277f8','2017-01-25',NULL,0,'c21873ef-3e29-43ca-92cd-45b5eb519c6e','Siti Komarudin','9081de22-1c08-4a10-9e18-b99b88d47885','Markas P. Aim','b8e7e852-7995-4446-8ef0-a97d5021f7d0','PERFORMER',0);
/*!40000 ALTER TABLE `work_effort_party_assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_effort_party_rate`
--

DROP TABLE IF EXISTS `work_effort_party_rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_effort_party_rate` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `commend` varchar(250) DEFAULT NULL,
  `rate` decimal(10,0) DEFAULT NULL,
  `type` char(30) DEFAULT NULL,
  `fk_work_effort` char(50) DEFAULT NULL,
  `party_id` char(50) DEFAULT NULL,
  `party_value` varchar(200) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_effort_party_rate`
--

LOCK TABLES `work_effort_party_rate` WRITE;
/*!40000 ALTER TABLE `work_effort_party_rate` DISABLE KEYS */;
INSERT INTO `work_effort_party_rate` VALUES ('832ad229-9230-4cb2-9cf6-1b33e2b8c2b8','2017-01-25',NULL,'',60000,'REGULAR_BILLING','b8e7e852-7995-4446-8ef0-a97d5021f7d0','c21873ef-3e29-43ca-92cd-45b5eb519c6e','Siti Komarudin',0);
/*!40000 ALTER TABLE `work_effort_party_rate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_effort_role`
--

DROP TABLE IF EXISTS `work_effort_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_effort_role` (
  `id` char(50) NOT NULL,
  `type` char(25) DEFAULT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `fk_work_effort` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_effort_role`
--

LOCK TABLES `work_effort_role` WRITE;
/*!40000 ALTER TABLE `work_effort_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_effort_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_effort_status`
--

DROP TABLE IF EXISTS `work_effort_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_effort_status` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `fk_work_effort` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_effort_status`
--

LOCK TABLES `work_effort_status` WRITE;
/*!40000 ALTER TABLE `work_effort_status` DISABLE KEYS */;
INSERT INTO `work_effort_status` VALUES ('749bd90e-0525-4fe3-9aba-1139cc7b36dd','2017-01-25',NULL,'FULFILLED','b8e7e852-7995-4446-8ef0-a97d5021f7d0',0);
/*!40000 ALTER TABLE `work_effort_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_order_item_fulfillment`
--

DROP TABLE IF EXISTS `work_order_item_fulfillment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_order_item_fulfillment` (
  `id` char(50) NOT NULL,
  `order_item_id` char(50) DEFAULT NULL,
  `order_item_value` varchar(200) DEFAULT NULL,
  `order_id` char(50) DEFAULT NULL,
  `order_value` varchar(200) DEFAULT NULL,
  `fk_work_effort` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_order_item_fulfillment`
--

LOCK TABLES `work_order_item_fulfillment` WRITE;
/*!40000 ALTER TABLE `work_order_item_fulfillment` DISABLE KEYS */;
INSERT INTO `work_order_item_fulfillment` VALUES ('217ecda7-d723-4dad-9c27-044e6a019ca3','a2251e43-bfd6-4ca4-8e92-ca1af78a70fd','Pemeriksaan Dokter Umum','388f9588-fddd-45ba-a328-bd41e24729e4','SO-22012017-1','b8e7e852-7995-4446-8ef0-a97d5021f7d0',0);
/*!40000 ALTER TABLE `work_order_item_fulfillment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_requirement`
--

DROP TABLE IF EXISTS `work_requirement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_requirement` (
  `id` char(50) NOT NULL,
  `fk_production_info` char(50) DEFAULT NULL,
  `asset_id` char(50) DEFAULT NULL,
  `asset_value` varchar(200) DEFAULT NULL,
  `work_type` char(15) DEFAULT 'PROJECT',
  `product_id` char(50) DEFAULT NULL,
  `product_value` varchar(200) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT 1,
  `fk_deliverable` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_requirement`
--

LOCK TABLES `work_requirement` WRITE;
/*!40000 ALTER TABLE `work_requirement` DISABLE KEYS */;
INSERT INTO `work_requirement` VALUES ('a012d70f-18a4-4178-beb9-ac2f0d947277',NULL,NULL,NULL,'PROJECT',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `work_requirement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_requirement_fulfillment`
--

DROP TABLE IF EXISTS `work_requirement_fulfillment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_requirement_fulfillment` (
  `id` char(50) NOT NULL,
  `requirement_id` char(50) DEFAULT NULL,
  `requirement_value` varchar(200) DEFAULT NULL,
  `fk_work_effort` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_requirement_fulfillment`
--

LOCK TABLES `work_requirement_fulfillment` WRITE;
/*!40000 ALTER TABLE `work_requirement_fulfillment` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_requirement_fulfillment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worker`
--

DROP TABLE IF EXISTS `worker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `worker` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `worker_relationship` (
  `id` char(50) NOT NULL,
  `fk_worker` char(50) DEFAULT NULL,
  `fk_internal_organization` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `working_shift` (
  `id` char(50) NOT NULL,
  `name` varchar(150) DEFAULT NULL,
  `start` time DEFAULT NULL,
  `end` time DEFAULT NULL,
  `is_active` char(1) DEFAULT NULL,
  `version` bigint(20) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `working_shift`
--

LOCK TABLES `working_shift` WRITE;
/*!40000 ALTER TABLE `working_shift` DISABLE KEYS */;
/*!40000 ALTER TABLE `working_shift` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'belian'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-22 13:12:57
