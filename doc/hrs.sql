-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: 127.0.0.1    Database: hrs
-- ------------------------------------------------------
-- Server version	5.7.12

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
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `dId` int(4) NOT NULL,
  `dName` varchar(20) NOT NULL,
  `dState` int(10) NOT NULL,
  `dSuperior` varchar(20) NOT NULL,
  PRIMARY KEY (`dId`),
  KEY `dName` (`dName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (4,'/',1,''),(5,'人事部',1,'/'),(6,'策划部',1,'/'),(7,'后勤部',1,'');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `eId` int(4) NOT NULL AUTO_INCREMENT,
  `eNo` varchar(10) NOT NULL,
  `ePwd` varchar(20) NOT NULL,
  `eName` varchar(20) NOT NULL,
  `eSex` int(4) NOT NULL,
  `eBasicSalary` int(5) NOT NULL,
  `eAddress` varchar(30) DEFAULT NULL,
  `eDepartment` varchar(20) NOT NULL,
  `eTitle` varchar(20) NOT NULL,
  `eRecord` int(2) DEFAULT NULL,
  `eJointime` datetime DEFAULT NULL,
  `eIntroduction` varchar(200) DEFAULT NULL,
  `eState` int(2) NOT NULL,
  `eTele` varchar(20) NOT NULL,
  `eMail` varchar(30) NOT NULL,
  `eBeiZhu` varchar(30) DEFAULT NULL,
  `role` int(2) NOT NULL DEFAULT '1',
  `dId` int(11) DEFAULT NULL,
  PRIMARY KEY (`eId`),
  KEY `eDepartment` (`eDepartment`),
  KEY `eTitle` (`eTitle`),
  KEY `eNo` (`eNo`),
  KEY `eName` (`eName`),
  KEY `eNo_2` (`eNo`,`eName`),
  KEY `eName_2` (`eName`,`eNo`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`eDepartment`) REFERENCES `department` (`dName`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`eTitle`) REFERENCES `position` (`pName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (4,'2014029','123','谭尧尧',0,3000,'131','人事部','员工',NULL,'2000-01-01 00:00:00',NULL,1,'12344444444','1234@gmail.com',NULL,1,5),(5,'2014030','123','周琳琳',0,5000,'131','/','总经理',NULL,'1999-01-01 00:00:00',NULL,1,'12355556666','12334@gmail.com',NULL,1,4),(6,'2014028','123','史可可',0,3000,'131','策划部','员工',NULL,'2000-01-01 00:00:00',NULL,1,'1233334444','33333@gmail.com',NULL,1,6),(7,'2014024','123','戴丫丫',0,5000,'131','后勤部','经理',NULL,'2000-01-01 00:00:00',NULL,1,'1235555666','12345@gmail.com',NULL,1,7);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave`
--

DROP TABLE IF EXISTS `leave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leave` (
  `lId` int(4) NOT NULL AUTO_INCREMENT,
  `lNo` varchar(10) DEFAULT NULL,
  `lName` varchar(20) DEFAULT NULL,
  `lReason` varchar(200) DEFAULT NULL,
  `lStartTime` datetime DEFAULT NULL,
  `lEndTime` datetime DEFAULT NULL,
  `lApplyTime` datetime DEFAULT NULL,
  `lApproveTime` datetime DEFAULT NULL,
  `lApproveState` int(2) DEFAULT NULL,
  `lApproveAdvice` varchar(200) DEFAULT NULL,
  `lApprovePass` int(2) DEFAULT NULL,
  `lApprover` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`lId`),
  KEY `lNo` (`lNo`),
  KEY `lName` (`lName`),
  KEY `lNo_2` (`lNo`,`lName`),
  CONSTRAINT `leave_ibfk_1` FOREIGN KEY (`lNo`, `lName`) REFERENCES `employee` (`eNo`, `eName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave`
--

LOCK TABLES `leave` WRITE;
/*!40000 ALTER TABLE `leave` DISABLE KEYS */;
/*!40000 ALTER TABLE `leave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `overtime`
--

DROP TABLE IF EXISTS `overtime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `overtime` (
  `oId` int(4) NOT NULL AUTO_INCREMENT,
  `oNo` varchar(10) DEFAULT NULL,
  `oName` varchar(20) DEFAULT NULL,
  `oReason` varchar(200) DEFAULT NULL,
  `oStartTime` datetime DEFAULT NULL,
  `oEndTime` datetime DEFAULT NULL,
  `oApplyTime` datetime DEFAULT NULL,
  `oApproveTime` datetime DEFAULT NULL,
  `oApproveState` int(2) DEFAULT NULL,
  `oApproveAdvice` varchar(200) DEFAULT NULL,
  `oApprovePass` int(2) DEFAULT NULL,
  `oApprover` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`oId`),
  KEY `oNo` (`oNo`),
  KEY `oName` (`oName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `overtime`
--

LOCK TABLES `overtime` WRITE;
/*!40000 ALTER TABLE `overtime` DISABLE KEYS */;
/*!40000 ALTER TABLE `overtime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `position` (
  `pId` int(4) NOT NULL AUTO_INCREMENT,
  `pName` varchar(20) NOT NULL,
  `pState` int(10) NOT NULL,
  PRIMARY KEY (`pId`),
  KEY `pName` (`pName`)
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
-- Table structure for table `salary`
--

DROP TABLE IF EXISTS `salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salary` (
  `sId` int(4) NOT NULL AUTO_INCREMENT,
  `sNo` varchar(10) NOT NULL,
  `sName` varchar(20) NOT NULL,
  `sBasic` int(5) NOT NULL,
  `sLeaveNo` int(4) NOT NULL,
  `sOvertimeNo` int(4) NOT NULL,
  `sReal` int(5) NOT NULL,
  `sDate` datetime NOT NULL,
  `sBeizhu` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`sId`),
  KEY `sNo` (`sNo`),
  KEY `sName` (`sName`),
  KEY `sLeaveNo` (`sLeaveNo`),
  KEY `sOvertimeNo` (`sOvertimeNo`),
  CONSTRAINT `salary_ibfk_1` FOREIGN KEY (`sNo`) REFERENCES `employee` (`eNo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary`
--

LOCK TABLES `salary` WRITE;
/*!40000 ALTER TABLE `salary` DISABLE KEYS */;
INSERT INTO `salary` VALUES (6,'2014030','Bigzhou',5000,0,0,5000,'2016-12-12 20:12:05',NULL),(8,'2014030','Bigzhou',5000,0,0,5000,'2016-12-12 20:20:58',NULL),(13,'2014030','Bigzhou',5000,0,0,5000,'2016-12-12 20:40:57',NULL),(18,'2014028','史可可',3000,0,0,3000,'2016-12-12 20:50:31',NULL),(19,'2014028','史可可',3000,0,0,3000,'2016-12-12 20:50:38',NULL),(20,'2014028','史可可',3000,0,0,3000,'2016-12-12 20:50:45',NULL),(21,'2014024','戴丫丫',5000,0,0,5000,'2016-12-12 20:50:52',NULL),(22,'2014029','谭尧尧',3000,0,0,3000,'2016-12-12 20:50:57',NULL),(23,'2014029','谭尧尧',3000,0,0,3000,'2016-12-12 20:51:06',NULL);
/*!40000 ALTER TABLE `salary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` char(30) NOT NULL,
  `USER_PASSWORD` char(10) NOT NULL,
  PRIMARY KEY (`USER_ID`),
  KEY `IDX_NAME` (`USER_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-12 21:03:28
