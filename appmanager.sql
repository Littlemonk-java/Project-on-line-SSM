/*
Navicat MySQL Data Transfer

Source Server         : Wait
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : appmanager

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2017-09-20 18:23:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for auction
-- ----------------------------
DROP TABLE IF EXISTS `auction`;
CREATE TABLE `auction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectid` int(11) DEFAULT NULL,
  `contributive` varchar(255) DEFAULT NULL,
  `contributiveuserid` int(255) DEFAULT NULL,
  `contributivetime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `projectid` (`projectid`),
  KEY `contributiveuserid` (`contributiveuserid`),
  CONSTRAINT `contributiveuserid` FOREIGN KEY (`contributiveuserid`) REFERENCES `user` (`id`),
  CONSTRAINT `projectid` FOREIGN KEY (`projectid`) REFERENCES `project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auction
-- ----------------------------
INSERT INTO `auction` VALUES ('1', '2', '2000', '2', '2017-09-01 23:39:43');
INSERT INTO `auction` VALUES ('12', '8', '100', '2', '2017-09-19 16:42:17');
INSERT INTO `auction` VALUES ('13', '12', '11111', '2', '2017-09-19 16:44:48');
INSERT INTO `auction` VALUES ('14', '5', '100', '2', '2017-09-19 17:01:29');
INSERT INTO `auction` VALUES ('15', '5', '100', '2', '2017-09-19 17:10:40');

-- ----------------------------
-- Table structure for financial
-- ----------------------------
DROP TABLE IF EXISTS `financial`;
CREATE TABLE `financial` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `income` varchar(255) DEFAULT NULL,
  `incomepeojectid` int(11) DEFAULT NULL,
  `incometime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `incomepeojectid` (`incomepeojectid`),
  CONSTRAINT `incomepeojectid` FOREIGN KEY (`incomepeojectid`) REFERENCES `project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of financial
-- ----------------------------
INSERT INTO `financial` VALUES ('2', '6', '2', '2017-09-05 00:00:00');
INSERT INTO `financial` VALUES ('3', '5', '3', '2017-09-06 00:00:00');
INSERT INTO `financial` VALUES ('4', '4', '2', '2017-09-07 00:00:00');
INSERT INTO `financial` VALUES ('5', '3', '5', '2017-09-08 00:00:00');
INSERT INTO `financial` VALUES ('6', '2', '2', '2017-09-09 00:00:00');
INSERT INTO `financial` VALUES ('7', '11', '2', '2017-09-10 00:00:00');
INSERT INTO `financial` VALUES ('9', '100', '2', '2017-09-11 00:00:00');
INSERT INTO `financial` VALUES ('10', '6.0', '6', '2017-09-12 01:18:45');
INSERT INTO `financial` VALUES ('11', '50.0', '8', '2017-09-13 16:36:55');
INSERT INTO `financial` VALUES ('13', '6', '12', '2017-09-14 13:50:50');
INSERT INTO `financial` VALUES ('14', '36', '21', '2017-09-15 13:59:15');
INSERT INTO `financial` VALUES ('15', '36', '23', '2017-09-16 15:13:22');
INSERT INTO `financial` VALUES ('16', '6', '3', '2017-09-17 17:06:04');
INSERT INTO `financial` VALUES ('17', '30', '2', '2017-09-18 00:00:00');
INSERT INTO `financial` VALUES ('18', '30.0', '2', '2017-09-19 00:00:00');

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `userid` int(11) DEFAULT NULL,
  `bzmoney` varchar(255) DEFAULT NULL,
  `projectname` varchar(255) DEFAULT NULL,
  `projecttype` varchar(255) DEFAULT NULL,
  `projectintr` varchar(255) DEFAULT NULL,
  `examine` varchar(255) DEFAULT NULL,
  `auctionstart` datetime DEFAULT NULL,
  `auctionend` datetime DEFAULT NULL,
  `auctionnum` int(255) DEFAULT NULL,
  `auctionmoney` varchar(255) DEFAULT NULL,
  `buyer` varchar(255) DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `notice` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `filepor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  CONSTRAINT `userid` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('2', '6', '200', '探索者互联网舆情监测系统', '工具', '1505800836460_Personal.jpg', '通过', '2017-09-15 00:00:00', '2017-09-17 00:00:00', '5', '2000', 'aaa', '2017-09-07 00:00:00', null, '完成', 'G:\\apache-tomcat-6.0.44-windows-x64\\apache-tomcat-6.0.44\\webapps\\AppinfoManagerMent\\assets\\uploadfiles\\1505800144979_Personal.jpg');
INSERT INTO `project` VALUES ('3', '3', '200', '物流仓储管理系统', '工具', '8fe3d762f63914ec170ba71f8166edb7.jpg', '通过', '2017-09-19 00:00:00', '2017-09-26 00:00:00', '5', null, null, '2017-09-07 00:00:00', null, null, null);
INSERT INTO `project` VALUES ('5', '3', '200', '视频解码系统', '工具', '1505800836460_Personal.jpg', '通过', '2017-09-15 00:00:00', '2017-09-22 00:00:00', '4', null, null, '2017-09-07 00:00:00', null, null, null);
INSERT INTO `project` VALUES ('6', '2', '200', '物业客服管理系统', '工具', '1505800836460_Personal.jpg', '通过', '2017-09-16 00:00:00', '2017-09-06 00:00:00', '5', null, null, '2017-09-07 00:00:00', '', null, null);
INSERT INTO `project` VALUES ('7', '4', '200', '技能鉴定考证管理系统', '工具', '1505800836460_Personal.jpg', '通过', '2017-09-16 00:00:00', '2017-09-16 00:00:00', '5', null, null, '2017-09-07 00:00:00', '', null, null);
INSERT INTO `project` VALUES ('8', '3', '300', '新闻发布系统', '网站', '1505799039427_Personal.jpg', '通过', '2017-09-18 00:00:00', '2017-09-21 00:00:00', '4', null, null, '2017-09-07 00:00:00', '', null, null);
INSERT INTO `project` VALUES ('9', '2', '200', '农产品质量安全追溯系统', '工具', 'bcbc2bf4702da32658b7e2a9abf02390.png', '通过', '2017-09-19 00:00:00', '2017-09-26 00:00:00', '3', null, null, '2017-09-07 00:00:00', null, null, null);
INSERT INTO `project` VALUES ('10', '2', '200', '港口设备管理信息系统', '工具', '1505800836460_Personal.jpg', '未审核', null, null, null, null, null, '2017-09-07 00:00:00', '', null, null);
INSERT INTO `project` VALUES ('11', '2', '200', '财务信息管理系统', '工具', '1505800836460_Personal.jpg', '未审核', null, null, null, null, null, '2017-09-07 00:00:00', null, null, null);
INSERT INTO `project` VALUES ('12', '2', '200', '药店管理系统', '工具', '01a0052691bdc9a9f9dbb22607382b0a.png', '通过', '2017-09-19 00:00:00', '2017-09-26 00:00:00', null, null, null, '2017-09-07 00:00:00', null, null, null);
INSERT INTO `project` VALUES ('21', '2', '1200', '科研学术管理系统', '网站', '36c9fc7574495d06d0e25be1479910ae.jpg', '通过', '2017-09-19 00:00:00', '2017-09-22 00:00:00', null, null, null, '2017-09-19 13:55:56', null, null, 'G:\\apache-tomcat-6.0.44-windows-x64\\apache-tomcat-6.0.44\\webapps\\AppinfoManagerMent\\assets\\uploadfiles\\1505800836460_Personal.jpg');
INSERT INTO `project` VALUES ('23', '2', '1200', '分布式本体模型', '网站', '1505805371777_Personal.jpg', '通过', '2017-09-19 00:00:00', '2017-09-22 00:00:00', null, null, null, '2017-09-19 15:12:55', null, null, 'G:\\apache-tomcat-6.0.44-windows-x64\\apache-tomcat-6.0.44\\webapps\\AppinfoManagerMent\\assets\\uploadfiles\\1505805176569_Personal.jpg');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `jurisdiction` varchar(255) DEFAULT NULL,
  `balance` varchar(255) DEFAULT NULL,
  `registration` date DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `picture` varchar(2550) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '2263669745@qq.com', '18393705838', '19', '管理员', '10000', '2017-09-13', '123456', '1505900820595_Personal.png');
INSERT INTO `user` VALUES ('2', 'liming', '2263669745@qq.com', '18393705838', '19', '普通', '8000', '2017-03-03', '123456', '1505901665594_Personal.png');
INSERT INTO `user` VALUES ('3', 'zhangsan', '2263669745@qq.com', '18393705838', '1', '普通', '100', '2017-03-03', '123456', '1505901178517_Personal.png');
INSERT INTO `user` VALUES ('4', 'jone', '2263669745@qq.com', '18393705838', '16', '普通', '100', '2017-03-03', '123456', '1505901395258_Personal.png');
INSERT INTO `user` VALUES ('6', 'frank', '2263669745@qq.com', '18393705838', '22', '普通', '12000', '2017-03-03', '123456', '1505901311406_Personal.png');
SET FOREIGN_KEY_CHECKS=1;
