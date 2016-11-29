/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : hrs

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2016-11-29 09:59:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `attendance`
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance` (
  `aId` int(4) NOT NULL auto_increment,
  `aNo` varchar(10) NOT NULL,
  `aName` varchar(20) NOT NULL,
  `aTime` datetime NOT NULL,
  `aState` int(4) NOT NULL,
  `aDate` datetime NOT NULL,
  `aMonthNo` int(4) default NULL,
  PRIMARY KEY  (`aId`),
  KEY `aNo` (`aNo`,`aName`),
  KEY `attendance_ibfk_2` (`aName`,`aNo`),
  CONSTRAINT `attendance_ibfk_2` FOREIGN KEY (`aName`, `aNo`) REFERENCES `employee` (`eName`, `eNo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of attendance
-- ----------------------------
INSERT INTO `attendance` VALUES ('1', '2014030', 'BigZhou', '2016-09-01 20:18:40', '1', '2016-11-01 20:18:47', '23');

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `dId` int(4) NOT NULL auto_increment,
  `dName` varchar(20) NOT NULL,
  `dState` int(10) NOT NULL,
  `dSuperior` varchar(20) NOT NULL,
  PRIMARY KEY  (`dId`),
  KEY `dName` (`dName`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', 'Leader', '1', 'Leader');
INSERT INTO `department` VALUES ('2', 'Tech', '1', 'Leader');
INSERT INTO `department` VALUES ('3', 'Hr', '1', 'Leader');

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `eId` int(4) NOT NULL auto_increment,
  `eNo` varchar(10) NOT NULL,
  `ePwd` varchar(20) NOT NULL,
  `eName` varchar(20) NOT NULL,
  `eSex` int(4) NOT NULL,
  `eAddress` varchar(30) default NULL,
  `eDepartment` varchar(20) NOT NULL,
  `eTitle` varchar(20) NOT NULL,
  `eRecord` int(2) default NULL,
  `eJointime` datetime default NULL,
  `eIntroduction` varchar(200) default NULL,
  `eState` int(2) NOT NULL,
  `eTele` varchar(20) NOT NULL,
  `eMail` varchar(30) NOT NULL,
  `eBeiZhu` varchar(30) default NULL,
  `role` int(2) NOT NULL default '1',
  PRIMARY KEY  (`eId`),
  KEY `eDepartment` (`eDepartment`),
  KEY `eTitle` (`eTitle`),
  KEY `eNo` (`eNo`),
  KEY `eName` (`eName`),
  KEY `eNo_2` (`eNo`,`eName`),
  KEY `eName_2` (`eName`,`eNo`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`eDepartment`) REFERENCES `department` (`dName`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`eTitle`) REFERENCES `position` (`pName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '2014030', '123', 'BigZhou', '0', 'Chengdu', 'Leader', 'Cleaner', '3', '2014-09-01 20:09:33', 'beautiful,smart,strong the most', '1', '18588888888', '1234@qq.com', null, '1');
INSERT INTO `employee` VALUES ('2', '2014029', '123', 'TanYao', '0', 'Chengdu', 'Hr', 'Dean', '3', '2016-11-02 20:14:34', 'fashion', '1', '17788888888', '4321@qq.com', 'hehe', '1');

-- ----------------------------
-- Table structure for `leave`
-- ----------------------------
DROP TABLE IF EXISTS `leave`;
CREATE TABLE `leave` (
  `lId` int(4) NOT NULL auto_increment,
  `lNo` varchar(10) NOT NULL,
  `lName` varchar(20) NOT NULL,
  `lReason` varchar(200) NOT NULL,
  `lStartTime` datetime NOT NULL,
  `lEndTime` datetime NOT NULL,
  `lApplyTime` datetime NOT NULL,
  `lApproveTime` datetime NOT NULL,
  `lApproveState` int(2) NOT NULL,
  `lApproveAdvice` varchar(200) NOT NULL,
  `lApprovePass` int(2) NOT NULL,
  `lApprover` varchar(20) NOT NULL,
  PRIMARY KEY  (`lId`),
  KEY `lNo` (`lNo`),
  KEY `lName` (`lName`),
  KEY `lNo_2` (`lNo`,`lName`),
  CONSTRAINT `leave_ibfk_1` FOREIGN KEY (`lNo`, `lName`) REFERENCES `employee` (`eNo`, `eName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of leave
-- ----------------------------
INSERT INTO `leave` VALUES ('1', '2014029', 'TanYao', 'eat', '2016-11-07 20:20:25', '2016-11-07 20:59:30', '2016-11-04 20:20:38', '2016-11-05 20:20:42', '1', 'go', '1', 'zhou');

-- ----------------------------
-- Table structure for `overtime`
-- ----------------------------
DROP TABLE IF EXISTS `overtime`;
CREATE TABLE `overtime` (
  `oId` int(4) NOT NULL auto_increment,
  `oNo` varchar(10) NOT NULL,
  `oName` varchar(20) NOT NULL,
  `oReason` varchar(200) NOT NULL,
  `oStartTime` datetime NOT NULL,
  `oEndTime` datetime NOT NULL,
  `oApplyTime` datetime NOT NULL,
  `oApproveTime` datetime NOT NULL,
  `oApproveState` int(2) NOT NULL,
  `oApproveAdvice` varchar(200) NOT NULL,
  `oApprovePass` int(2) NOT NULL,
  `oApprover` varchar(20) NOT NULL,
  PRIMARY KEY  (`oId`),
  KEY `oNo` (`oNo`),
  KEY `oName` (`oName`),
  CONSTRAINT `overtime_ibfk_1` FOREIGN KEY (`oNo`) REFERENCES `employee` (`eNo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `overtime_ibfk_2` FOREIGN KEY (`oName`) REFERENCES `employee` (`eName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of overtime
-- ----------------------------

-- ----------------------------
-- Table structure for `position`
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `pId` int(4) NOT NULL auto_increment,
  `pName` varchar(20) NOT NULL,
  `pState` int(10) NOT NULL,
  PRIMARY KEY  (`pId`),
  KEY `pName` (`pName`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES ('1', 'Dean', '1');
INSERT INTO `position` VALUES ('2', 'Cleaner', '1');
INSERT INTO `position` VALUES ('3', 'Normal', '1');
INSERT INTO `position` VALUES ('4', 'Dalao', '1');

-- ----------------------------
-- Table structure for `salary`
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary` (
  `sId` int(4) NOT NULL auto_increment,
  `sNo` varchar(10) NOT NULL,
  `sName` varchar(20) NOT NULL,
  `sBasic` int(5) NOT NULL,
  `sLeaveNo` int(4) NOT NULL,
  `sOvertimeNo` int(4) NOT NULL,
  `sReal` int(5) NOT NULL,
  `sDate` datetime NOT NULL,
  `sBeizhu` varchar(30) default NULL,
  PRIMARY KEY  (`sId`),
  KEY `sNo` (`sNo`),
  KEY `sName` (`sName`),
  KEY `sLeaveNo` (`sLeaveNo`),
  KEY `sOvertimeNo` (`sOvertimeNo`),
  CONSTRAINT `salary_ibfk_1` FOREIGN KEY (`sNo`) REFERENCES `employee` (`eNo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `salary_ibfk_2` FOREIGN KEY (`sName`) REFERENCES `employee` (`eName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of salary
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `USER_ID` int(11) NOT NULL auto_increment,
  `USER_NAME` char(30) NOT NULL,
  `USER_PASSWORD` char(10) NOT NULL,
  PRIMARY KEY  (`USER_ID`),
  KEY `IDX_NAME` (`USER_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'zhou', '123456');
INSERT INTO `t_user` VALUES ('2', 'tan', '123456');
