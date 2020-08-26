/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50528
 Source Host           : localhost:3306
 Source Schema         : college_project

 Target Server Type    : MySQL
 Target Server Version : 50528
 File Encoding         : 65001

 Date: 26/08/2020 18:54:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `messageId` int(10) NOT NULL AUTO_INCREMENT,
  `messageTitle` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章标题',
  `messageType` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章类型',
  `messageContent` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '文章内容',
  `messageAddress` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址链接',
  `createDate` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `formatDate` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '格式化时间',
  `author` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '信息学院' COMMENT '作者',
  `status` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '未审核' COMMENT '审核状态',
  PRIMARY KEY (`messageId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (2, '信息学院2020级班导生拟聘名单公示', '通知公告', '为了加强学生自我管理、自我服务意识，进一步锻炼学生的管理水平和组织能力，同时帮助我院2020级新生更好更快地适应大学生活与学习。经提交申请、初试、复试以及信息学院老师综合评定等环节，现将拟聘名单公示如下：', '', '2020-08-26 18:44:24', '2020-08-25', '信息学院', '未审核');
INSERT INTO `message` VALUES (3, '成都市郫都区统计局关于招聘编外用工人员的启事', '招生就业', NULL, 'http://aahz.pidu.gov.cn/pidu/c125561/2020-08/19/content_6dadf61ae7894d2786fd8053c3c43408.shtml', '2020-08-26 18:44:32', '2020-08-25', '信息学院', '未审核');
INSERT INTO `message` VALUES (4, '测试使用', '测试使用', NULL, NULL, '2020-08-26 18:44:15', '2020-08-26', '信息学院', '未审核');
INSERT INTO `message` VALUES (9, '测试2', '测试2', NULL, NULL, '2020-08-26 18:44:19', '2020-08-26', '信息学院', '未审核');
INSERT INTO `message` VALUES (13, '今日将有大批学生返校', '今日热讯', NULL, NULL, '2020-08-26 18:43:53', '2020-08-26', NULL, '未审核');

-- ----------------------------
-- Table structure for school_teacher
-- ----------------------------
DROP TABLE IF EXISTS `school_teacher`;
CREATE TABLE `school_teacher`  (
  `teacherId` int(5) NOT NULL AUTO_INCREMENT,
  `teacherName` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '教师名称',
  `teacherTitle` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '教师职务',
  `teacherHonor` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '教师荣誉',
  `teacherTeam` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属教研室',
  `teacherTeamTitle` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '教研室职务',
  PRIMARY KEY (`teacherId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of school_teacher
-- ----------------------------
INSERT INTO `school_teacher` VALUES (1, '梁军刚', '副院长', '暂时未知', '暂时未知', '暂时未知');

-- ----------------------------
-- Table structure for web_address
-- ----------------------------
DROP TABLE IF EXISTS `web_address`;
CREATE TABLE `web_address`  (
  `address_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '链接地址名',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '链接地址',
  `ID` int(5) NOT NULL AUTO_INCREMENT,
  `AddressType` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '链接类型',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `status` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '未审核' COMMENT '审核状态',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of web_address
-- ----------------------------
INSERT INTO `web_address` VALUES ('成都市郫都区统计局关于招聘编外用工人员的启事', 'http://aahz.pidu.gov.cn/pidu/c125561/2020-08/19/content_6dadf61ae7894d2786fd8053c3c43408.shtml', 1, '', '2020-08-24 00:00:00', '未审核');

SET FOREIGN_KEY_CHECKS = 1;
