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
-- Table structure for table `acknowledgement`
--

DROP TABLE IF EXISTS `acknowledgement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acknowledgement` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `approver_status` char(10) DEFAULT NULL,
  `person_id` char(50) DEFAULT NULL,
  `person_value` varchar(250) DEFAULT '0',
  `type` char(30) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `fk_city` char(50) DEFAULT NULL,
  `fk_province` char(50) DEFAULT NULL,
  `fk_country` char(50) DEFAULT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `citizenship`
--

DROP TABLE IF EXISTS `citizenship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `citizenship` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `nopassport` varchar(150) DEFAULT NULL,
  `fk_person` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `container`
--

DROP TABLE IF EXISTS `container`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `id` char(50) NOT NULL,
  `code` char(25) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `currency_exchange_factor`
--

DROP TABLE IF EXISTS `currency_exchange_factor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `currency_exchange_factor` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `fk_currency_from` char(50) DEFAULT NULL,
  `fk_currency_to` char(50) DEFAULT NULL,
  `value` decimal(10,0) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `deliverable`
--

DROP TABLE IF EXISTS `deliverable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deliverable` (
  `id` char(50) NOT NULL,
  `name` varchar(250) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `type` char(15) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` char(50) NOT NULL,
  `username` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employer`
--

DROP TABLE IF EXISTS `employer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employer` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employment`
--

DROP TABLE IF EXISTS `employment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employment` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `facility_organization`
--

DROP TABLE IF EXISTS `facility_organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facility_organization` (
  `id` char(50) NOT NULL,
  `enabled` char(1) DEFAULT NULL,
  `fk_facility` char(50) DEFAULT NULL,
  `organization_id` char(50) DEFAULT NULL,
  `organization_value` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `inventory_item`
--

DROP TABLE IF EXISTS `inventory_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  `on_order` decimal(10,0) DEFAULT '0',
  `control` bigint(20) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `invoice_item`
--

DROP TABLE IF EXISTS `invoice_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `invoice_order_item_billing`
--

DROP TABLE IF EXISTS `invoice_order_item_billing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice_order_item_billing` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `order_item_id` char(50) DEFAULT NULL,
  `order_item_value` varchar(200) DEFAULT NULL,
  `order_id` char(50) DEFAULT NULL,
  `order_value` varchar(200) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `invoice_role`
--

DROP TABLE IF EXISTS `invoice_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice_role` (
  `id` char(50) NOT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `type` char(15) DEFAULT NULL,
  `party_id` char(50) DEFAULT NULL,
  `party_value` varchar(200) DEFAULT NULL,
  `fk_invoice` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `invoice_shipment_item_billing`
--

DROP TABLE IF EXISTS `invoice_shipment_item_billing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice_shipment_item_billing` (
  `id` char(50) NOT NULL,
  `shipment_item_id` char(50) DEFAULT NULL,
  `shipment_item_value` varchar(200) DEFAULT NULL,
  `fk_invoice_item` char(50) DEFAULT NULL,
  `shipment_id` char(50) DEFAULT NULL,
  `shipment_value` varchar(200) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `invoice_status`
--

DROP TABLE IF EXISTS `invoice_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice_status` (
  `id` char(50) NOT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `type` char(10) DEFAULT NULL,
  `fk_invoice` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `invoice_term`
--

DROP TABLE IF EXISTS `invoice_term`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice_term` (
  `id` char(50) NOT NULL,
  `value` decimal(10,0) DEFAULT NULL,
  `type` char(15) DEFAULT NULL,
  `fk_invoice` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `invoice_time_entry_billing`
--

DROP TABLE IF EXISTS `invoice_time_entry_billing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice_time_entry_billing` (
  `id` char(50) NOT NULL,
  `hour` decimal(10,0) DEFAULT NULL,
  `time_entry_id` char(50) DEFAULT NULL,
  `time_entry_value` varchar(200) DEFAULT '0',
  `fk_invoice_item` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `invoice_work_effort_billing`
--

DROP TABLE IF EXISTS `invoice_work_effort_billing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice_work_effort_billing` (
  `id` char(50) NOT NULL,
  `percent` decimal(10,0) DEFAULT NULL,
  `work_effort_id` char(50) DEFAULT NULL,
  `work_effort_value` varchar(200) DEFAULT NULL,
  `fk_invoice_item` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `marital_status`
--

DROP TABLE IF EXISTS `marital_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marital_status` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `type` char(25) DEFAULT 'SINGLE',
  `fk_person` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notification` (
  `id` char(50) NOT NULL,
  `new_message` int(11) DEFAULT '0',
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_adjustment`
--

DROP TABLE IF EXISTS `order_adjustment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_adjustment` (
  `id` char(50) NOT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `percent` decimal(10,0) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `fk_order` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `processed` decimal(10,0) DEFAULT '0',
  `invoiced` char(1) DEFAULT '0',
  `requirement` char(1) DEFAULT '0',
  `workeffort` char(1) DEFAULT '0',
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `order_role`
--

DROP TABLE IF EXISTS `order_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_role` (
  `id` char(50) NOT NULL,
  `person_id` char(50) DEFAULT NULL,
  `person_value` varchar(250) DEFAULT NULL,
  `type` char(50) DEFAULT NULL,
  `fk_order` char(50) DEFAULT NULL,
  `percent_contribution` decimal(10,0) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `order_term`
--

DROP TABLE IF EXISTS `order_term`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_value`
--

DROP TABLE IF EXISTS `order_value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_value` (
  `id` char(50) NOT NULL,
  `min` decimal(10,0) DEFAULT NULL,
  `max` decimal(10,0) DEFAULT NULL,
  `value` bigint(20) DEFAULT '0',
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `code` varchar(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `party_classification`
--

DROP TABLE IF EXISTS `party_classification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `party_classification` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `type` char(35) DEFAULT NULL,
  `value` char(50) DEFAULT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `party_relationship`
--

DROP TABLE IF EXISTS `party_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `party_role`
--

DROP TABLE IF EXISTS `party_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `party_role` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `fk_party` char(50) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `passport`
--

DROP TABLE IF EXISTS `passport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passport` (
  `id` char(50) NOT NULL,
  `number` char(50) DEFAULT NULL,
  `issued_date` date DEFAULT NULL,
  `expiration_date` date DEFAULT NULL,
  `fk_country` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `physical_characteristic`
--

DROP TABLE IF EXISTS `physical_characteristic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `physical_characteristic` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `value` char(15) DEFAULT NULL,
  `fk_person` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `pos_sales_order`
--

DROP TABLE IF EXISTS `pos_sales_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pos_sales_order` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `price_component`
--

DROP TABLE IF EXISTS `price_component`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `price_component` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `percent` decimal(10,0) DEFAULT '0',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product_category`
--

DROP TABLE IF EXISTS `product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_category` (
  `id` char(50) NOT NULL,
  `name` varchar(250) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_parent` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product_category_classification`
--

DROP TABLE IF EXISTS `product_category_classification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_category_classification` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `category_id` char(50) DEFAULT NULL,
  `category_value` varchar(150) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `is_primary` char(1) DEFAULT '0',
  `comment` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `product_component`
--

DROP TABLE IF EXISTS `product_component`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product_cost`
--

DROP TABLE IF EXISTS `product_cost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product_feature`
--

DROP TABLE IF EXISTS `product_feature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_feature` (
  `id` char(50) NOT NULL,
  `value` varchar(150) DEFAULT NULL,
  `type` char(35) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product_feature_applicability`
--

DROP TABLE IF EXISTS `product_feature_applicability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_feature_applicability` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `category` char(50) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `feature_id` char(50) DEFAULT NULL,
  `feature_value` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product_identification`
--

DROP TABLE IF EXISTS `product_identification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_identification` (
  `id` char(50) NOT NULL,
  `value` char(50) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `product_requirement`
--

DROP TABLE IF EXISTS `product_requirement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_requirement` (
  `id` char(50) DEFAULT NULL,
  `product_id` char(50) NOT NULL,
  `product_value` varchar(200) DEFAULT NULL,
  `feature_id` char(50) DEFAULT NULL,
  `feature_value` varchar(200) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT '1',
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `product_id_UNIQUE` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `product_supplier`
--

DROP TABLE IF EXISTS `product_supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_supplier` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `supplier_id` char(50) DEFAULT NULL,
  `supplier_value` varchar(250) DEFAULT NULL,
  `fk_product` char(50) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `production_info`
--

DROP TABLE IF EXISTS `production_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `production_info` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `product_id` char(50) DEFAULT NULL,
  `product_value` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `production_run_properties`
--

DROP TABLE IF EXISTS `production_run_properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `production_run_properties` (
  `id` char(50) NOT NULL,
  `required_quantity` char(50) DEFAULT NULL,
  `produced_quantity` char(50) DEFAULT NULL,
  `rejected_quantity` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `purchase_invoice`
--

DROP TABLE IF EXISTS `purchase_invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_invoice` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `purchase_order`
--

DROP TABLE IF EXISTS `purchase_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_order` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `quantity_break`
--

DROP TABLE IF EXISTS `quantity_break`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quantity_break` (
  `id` char(50) NOT NULL,
  `min` decimal(10,0) DEFAULT NULL,
  `max` decimal(10,0) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `quick_launch`
--

DROP TABLE IF EXISTS `quick_launch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quick_launch` (
  `id` char(50) NOT NULL,
  `name` varchar(250) DEFAULT NULL,
  `username` varchar(250) DEFAULT NULL,
  `fisheye_enabled` char(1) DEFAULT '0',
  `menu_enabled` char(1) DEFAULT '0',
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `fk_quote` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `receivable_order`
--

DROP TABLE IF EXISTS `receivable_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receivable_order` (
  `id` char(50) NOT NULL,
  `received` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `product_id` char(50) DEFAULT NULL,
  `product_value` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `request_role`
--

DROP TABLE IF EXISTS `request_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request_role` (
  `id` char(50) NOT NULL,
  `fk_request` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `requirement`
--

DROP TABLE IF EXISTS `requirement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `requirement_order_commitment`
--

DROP TABLE IF EXISTS `requirement_order_commitment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requirement_order_commitment` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `fk_order_item` char(50) DEFAULT NULL,
  `requirement_id` char(50) DEFAULT NULL,
  `requirement_value` varchar(200) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `party_id` char(50) DEFAULT NULL,
  `party_value` varchar(250) DEFAULT NULL,
  `fk_requirement` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `requirement_status`
--

DROP TABLE IF EXISTS `requirement_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requirement_status` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `fk_requirement` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `sales_invoice`
--

DROP TABLE IF EXISTS `sales_invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sales_invoice` (
  `id` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shipment_issuance`
--

DROP TABLE IF EXISTS `shipment_issuance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipment_issuance` (
  `id` char(50) NOT NULL,
  `number` char(50) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `organization_id` char(50) DEFAULT NULL,
  `organization_value` varchar(250) DEFAULT NULL,
  `destination_party_id` char(50) DEFAULT NULL,
  `destination_party_value` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shipment_issuance_item`
--

DROP TABLE IF EXISTS `shipment_issuance_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shipment_issuance_role`
--

DROP TABLE IF EXISTS `shipment_issuance_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipment_issuance_role` (
  `id` char(50) NOT NULL,
  `party_id` char(50) DEFAULT NULL,
  `party_value` varchar(250) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `fk_shipment_issuance` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shipment_item`
--

DROP TABLE IF EXISTS `shipment_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipment_item` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `processed` decimal(10,0) DEFAULT '0',
  `content` varchar(200) DEFAULT NULL,
  `fk_shipment` char(50) DEFAULT NULL,
  `fk_shipping_document` char(50) DEFAULT NULL,
  `product_id` char(50) DEFAULT NULL,
  `product_value` varchar(250) DEFAULT NULL,
  `invoiced` char(1) DEFAULT '0',
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shipment_order`
--

DROP TABLE IF EXISTS `shipment_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipment_order` (
  `id` char(50) NOT NULL,
  `quantity` decimal(10,0) DEFAULT NULL,
  `unit_price` decimal(10,0) DEFAULT '0',
  `order_item_id` char(50) DEFAULT NULL,
  `order_item_value` varchar(100) DEFAULT NULL,
  `order_id` char(50) DEFAULT NULL,
  `order_value` varchar(200) DEFAULT NULL,
  `fk_shipment_item` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shipment_receipt`
--

DROP TABLE IF EXISTS `shipment_receipt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipment_receipt` (
  `id` char(50) NOT NULL,
  `date` date DEFAULT NULL,
  `number` char(50) DEFAULT NULL,
  `organization_id` char(50) DEFAULT NULL,
  `organization_value` varchar(225) DEFAULT NULL,
  `source_party_id` char(50) DEFAULT '0',
  `source_party_value` varchar(225) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED KEY_BLOCK_SIZE=8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shipment_receipt_item`
--

DROP TABLE IF EXISTS `shipment_receipt_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED KEY_BLOCK_SIZE=8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shipment_receipt_role`
--

DROP TABLE IF EXISTS `shipment_receipt_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipment_receipt_role` (
  `id` char(50) NOT NULL,
  `party_id` char(50) DEFAULT NULL,
  `party_value` varchar(150) DEFAULT NULL,
  `type` char(35) DEFAULT NULL,
  `fk_shipment_receipt` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `vehicle_id` char(50) DEFAULT NULL,
  `vehicle_value` varchar(150) DEFAULT NULL,
  `carrier_id` char(50) DEFAULT NULL,
  `carrier_value` varchar(250) DEFAULT NULL,
  `fk_shipment` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shipment_status`
--

DROP TABLE IF EXISTS `shipment_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipment_status` (
  `id` char(50) NOT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `fk_shipment` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `stock_adjustment`
--

DROP TABLE IF EXISTS `stock_adjustment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `product_id` char(50) DEFAULT NULL,
  `product_value` varchar(250) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `expired_date` date DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `container_value` varchar(250) DEFAULT NULL,
  `container_id` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `stock_history`
--

DROP TABLE IF EXISTS `stock_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `time_entry`
--

DROP TABLE IF EXISTS `time_entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `time_entry` (
  `id` char(50) NOT NULL,
  `start` timestamp NULL DEFAULT NULL,
  `end` timestamp NULL DEFAULT NULL,
  `hours` int(11) DEFAULT NULL,
  `fk_timesheet` char(50) DEFAULT NULL,
  `fk_work_effort` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `comment` varchar(250) DEFAULT NULL,
  `worker_id` char(50) DEFAULT NULL,
  `worker_value` varchar(250) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `timesheet_role`
--

DROP TABLE IF EXISTS `timesheet_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timesheet_role` (
  `id` char(50) NOT NULL,
  `timesheet_role_type` char(30) DEFAULT NULL,
  `fk_timesheet` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `user_setting`
--

DROP TABLE IF EXISTS `user_setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  `row_per_page` int(11) DEFAULT '25',
  `printer_type` char(10) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `work_effort`
--

DROP TABLE IF EXISTS `work_effort`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `rate` decimal(10,0) DEFAULT '0',
  `type` char(25) DEFAULT NULL,
  `fk_asset` char(50) DEFAULT NULL,
  `fk_work_effort` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `work_effort_info`
--

DROP TABLE IF EXISTS `work_effort_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_effort_info` (
  `id` char(50) NOT NULL,
  `name` varchar(250) DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `hour` decimal(10,0) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `work_effort_party_assignment`
--

DROP TABLE IF EXISTS `work_effort_party_assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_effort_party_assignment` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `rate` decimal(10,0) DEFAULT '0',
  `party_id` char(50) DEFAULT NULL,
  `party_value` varchar(200) DEFAULT '0',
  `facility_id` char(50) DEFAULT NULL,
  `facility_value` varchar(200) DEFAULT NULL,
  `fk_work_effort` char(50) DEFAULT NULL,
  `type` char(35) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `work_effort_party_rate`
--

DROP TABLE IF EXISTS `work_effort_party_rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `work_effort_status`
--

DROP TABLE IF EXISTS `work_effort_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_effort_status` (
  `id` char(50) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `type` char(25) DEFAULT NULL,
  `fk_work_effort` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `work_order_item_fulfillment`
--

DROP TABLE IF EXISTS `work_order_item_fulfillment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_order_item_fulfillment` (
  `id` char(50) NOT NULL,
  `order_item_id` char(50) DEFAULT NULL,
  `order_item_value` varchar(200) DEFAULT NULL,
  `order_id` char(50) DEFAULT NULL,
  `order_value` varchar(200) DEFAULT NULL,
  `fk_work_effort` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `work_requirement`
--

DROP TABLE IF EXISTS `work_requirement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_requirement` (
  `id` char(50) NOT NULL,
  `fk_production_info` char(50) DEFAULT NULL,
  `asset_id` char(50) DEFAULT NULL,
  `asset_value` varchar(200) DEFAULT NULL,
  `work_type` char(15) DEFAULT 'PROJECT',
  `product_id` char(50) DEFAULT NULL,
  `product_value` varchar(200) DEFAULT NULL,
  `quantity` decimal(10,0) DEFAULT '1',
  `fk_deliverable` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `work_requirement_fulfillment`
--

DROP TABLE IF EXISTS `work_requirement_fulfillment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_requirement_fulfillment` (
  `id` char(50) NOT NULL,
  `requirement_id` char(50) DEFAULT NULL,
  `requirement_value` varchar(200) DEFAULT NULL,
  `fk_work_effort` char(50) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-26 19:44:49
