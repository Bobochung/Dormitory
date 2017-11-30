/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : rimidormitory

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-11-30 18:54:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `Admin_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `Admin_Username` varchar(20) DEFAULT NULL COMMENT '管理员用户名',
  `Admin_Password` varchar(50) DEFAULT NULL COMMENT '管理员密码',
  `Admin_Name` varchar(20) DEFAULT NULL COMMENT '管理员姓名',
  `Admin_Sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `Admin_Tel` varchar(11) DEFAULT NULL COMMENT '电话',
  PRIMARY KEY (`Admin_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('2', 'admin', '202CB962AC59075B964B07152D234B70', 'admin', '男', '176666999');
INSERT INTO `admin` VALUES ('25', 'aa', '4124BC0A9335C27F086F24BA207A4912', null, null, null);
INSERT INTO `admin` VALUES ('26', 'zb', '78B269619F0723E8037A282F7FE8364B', null, null, null);
INSERT INTO `admin` VALUES ('27', 'qq', '099B3B060154898840F0EBDFB46EC78F', null, null, null);
INSERT INTO `admin` VALUES ('28', 'ww', 'AD57484016654DA87125DB86F4227EA3', null, null, null);
INSERT INTO `admin` VALUES ('29', 'aaa', '202CB962AC59075B964B07152D234B70', null, null, null);
INSERT INTO `admin` VALUES ('30', 'qq', '202CB962AC59075B964B07152D234B70', null, null, null);

-- ----------------------------
-- Table structure for `building`
-- ----------------------------
DROP TABLE IF EXISTS `building`;
CREATE TABLE `building` (
  `Building_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Building_Name` varchar(50) DEFAULT NULL,
  `Building_Introduction` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`Building_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of building
-- ----------------------------
INSERT INTO `building` VALUES ('1', '学苑1栋', '13100002222');
INSERT INTO `building` VALUES ('2', '学苑2栋', '15900008888');
INSERT INTO `building` VALUES ('3', '学苑3栋', '男生公寓');

-- ----------------------------
-- Table structure for `domitory`
-- ----------------------------
DROP TABLE IF EXISTS `domitory`;
CREATE TABLE `domitory` (
  `Domitory_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Domitory_BuildingID` int(11) DEFAULT NULL,
  `Domitory_Name` varchar(20) DEFAULT NULL,
  `Domitory_Type` varchar(20) DEFAULT NULL,
  `Domitory_Number` varchar(20) DEFAULT NULL,
  `Domitory_Tel` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Domitory_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of domitory
-- ----------------------------
INSERT INTO `domitory` VALUES ('1', '1', '202', '豪华型', '1', '4008899');
INSERT INTO `domitory` VALUES ('2', '2', '202', '普通型', '6', '4011236');
INSERT INTO `domitory` VALUES ('3', '1', '404', '豪华型', '1', '4009990');

-- ----------------------------
-- Table structure for `log`
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `Log_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Log_StudentID` int(11) DEFAULT NULL,
  `Log_TeacherID` int(11) DEFAULT NULL,
  `Log_Date` varchar(50) DEFAULT NULL,
  `Log_Remark` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`Log_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('1', '2', '1', '2013-04-10', 'we');
INSERT INTO `log` VALUES ('2', '2', '1', '2017-08-07', '');
INSERT INTO `log` VALUES ('3', '2', '1', '2017-09-09', '整夜未归');

-- ----------------------------
-- Table structure for `out1`
-- ----------------------------
DROP TABLE IF EXISTS `out1`;
CREATE TABLE `out1` (
  `Out_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Out_StudentID` varchar(11) DEFAULT NULL,
  `Out_Date` varchar(50) DEFAULT NULL,
  `Out_Remark` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`Out_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of out1
-- ----------------------------
INSERT INTO `out1` VALUES ('1', '2', '2013-4-28', '13');
INSERT INTO `out1` VALUES ('2', '1', '2013-4-28', '搜索');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `Student_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Student_DomitoryID` int(11) DEFAULT NULL,
  `Student_Username` varchar(20) DEFAULT NULL,
  `Student_Password` varchar(20) DEFAULT NULL,
  `Student_Name` varchar(20) DEFAULT NULL,
  `Student_Sex` varchar(20) DEFAULT NULL,
  `Student_Class` varchar(20) DEFAULT NULL,
  `Student_State` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Student_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '2', '201700105005', '123', '王宝强', '男', '1705', '入住');
INSERT INTO `student` VALUES ('2', '1', '201700205005', '444', '王小花', '女', '1703', '入住');
INSERT INTO `student` VALUES ('3', '3', '201700105002', '123', '赵铁柱', '男', '1705', '入住');
INSERT INTO `student` VALUES ('4', '2', '201700105001', '123', '王尼玛', '男', '1705', '入住');
INSERT INTO `student` VALUES ('5', '2', '201700203002', '123', '李华', '男', '1707', '未入住');
INSERT INTO `student` VALUES ('6', '3', '201700203005', '234', '何光', '男', '1706', '入住');
INSERT INTO `student` VALUES ('7', '2', '201700203007', '563', '张明', '男', '1705', '入住');
INSERT INTO `student` VALUES ('8', '1', '20170001', '234', '张明明', '男', '1706', '入住');
INSERT INTO `student` VALUES ('9', '2', '2017009832', null, '小沈阳', '男', '1705', '入住');

-- ----------------------------
-- Table structure for `tb`
-- ----------------------------
DROP TABLE IF EXISTS `tb`;
CREATE TABLE `tb` (
  `TB_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TB_TeacherID` int(11) DEFAULT NULL,
  `TB_BuildingID` int(11) DEFAULT NULL,
  PRIMARY KEY (`TB_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb
-- ----------------------------
INSERT INTO `tb` VALUES ('1', '1', '1');
INSERT INTO `tb` VALUES ('4', '3', '2');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `Teacher_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Teacher_Username` varchar(20) DEFAULT NULL,
  `Teacher_Password` varchar(20) DEFAULT NULL,
  `Teacher_Name` varchar(20) DEFAULT NULL,
  `Teacher_Sex` varchar(10) DEFAULT NULL,
  `Teacher_Tel` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Teacher_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', 'zhengbing', '123', '郑兵', '男', '17628284449');
INSERT INTO `teacher` VALUES ('2', 'zhangsan', '123', '张三', '男', '13122223333');
INSERT INTO `teacher` VALUES ('3', 'lisi', '123', '李四', '男', '13299990000');
INSERT INTO `teacher` VALUES ('4', 'limin', '123', '李明', '男', '11019210221');
INSERT INTO `teacher` VALUES ('5', 'wangwu', '123', '王武', '男', '12321321412');
INSERT INTO `teacher` VALUES ('6', 'yanran', '123', '嫣然', '女', '17892389134');
INSERT INTO `teacher` VALUES ('7', 'hehua', '123', '何华', '男', '17777777777');
