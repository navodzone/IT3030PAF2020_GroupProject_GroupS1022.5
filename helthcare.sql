-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: helthcare
-- ------------------------------------------------------
-- Server version	5.7.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment` (
  `appointId` int(11) NOT NULL,
  `patientId` varchar(10) DEFAULT NULL,
  `patientName` varchar(45) DEFAULT NULL,
  `appointDate` varchar(10) DEFAULT NULL,
  `appointTime` varchar(5) DEFAULT NULL,
  `appointDoct` varchar(20) DEFAULT NULL,
  `hospital` varchar(20) DEFAULT NULL,
  `specialization` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`appointId`),
  UNIQUE KEY `appointId_UNIQUE` (`appointId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (100325,'1001','Mr.Nimal Perea','20-04-2020','12.30','Dr.Rajapakshe','Nawaloka, Colombo','General');
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor` (
  `dID` varchar(25) NOT NULL,
  `dName` varchar(25) NOT NULL,
  `specialization` varchar(25) NOT NULL,
  `hName` varchar(25) NOT NULL,
  PRIMARY KEY (`dID`),
  UNIQUE KEY `dName_UNIQUE` (`dName`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES ('01','Joe','Cardiology','Central Hospital');
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `Patient_ID` int(11) NOT NULL,
  `FirstName` varchar(45) DEFAULT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `NIC` varchar(20) DEFAULT NULL,
  `DOB` varchar(20) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Mobile` varchar(15) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `BloodGroup` varchar(10) DEFAULT NULL,
  `Allergy` varchar(45) DEFAULT NULL,
  `Gender` varchar(5) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `ConfirmPassword` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Patient_ID`),
  UNIQUE KEY `Patient_ID_UNIQUE` (`Patient_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (4,'Pamod','Madushan','985215454V','15-12-1998','test@gmail.com','5554441','Sample Street','A+','No','Male','test123','test123'),(8,'Pamod','Madhushan','983201168V','15-12-1998','pamod@gmail.com','0766452256','Colombo','A','No','M','789*!','789*!'),(5,'Dilanka','Gunathilaka','964567849V','5-1-1996','Gunathilaka@gmail.com','076-67-45612','Gampha','AB','No','M','123*','123*'),(6,'Nissanka','Navodha','974567849V','10-8-1997','Nissanka@gmail.com','076-67-12345','Kandy','A','No','M','123*5','123*5'),(7,'Dinuka','Navodha','954567849V','10-8-1995','Dinuka@gmail.com','076-67-12378','Matara','O','No','M','123*5#','123*5#');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `Id` int(11) NOT NULL,
  `appointmentID` varchar(10) DEFAULT NULL,
  `paymentAmount` double DEFAULT NULL,
  `paymentDate` varchar(10) DEFAULT NULL,
  `paymentType` varchar(15) DEFAULT NULL,
  `cardNumber` varchar(25) DEFAULT NULL,
  `expDate` varchar(5) DEFAULT NULL,
  `cvv` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1001,'AIE30005',6500,'14/04/2020','Credit Card','4800223489652314','02/05','69'),(1002,'ABB30006',1500,'15/04/2020','Debit Card','4300022254587462','02/26','113'),(1003,'AGG6654',2130,'20/05/2020','Credit Card','4322556256884622','05/25','265'),(1007,'BCC6654',1130,'20/06/2020','Debit Card','4322558936884622','06/25','865');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('test','test');
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

-- Dump completed on 2020-04-19 23:57:13
