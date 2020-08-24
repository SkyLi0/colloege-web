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

 Date: 24/08/2020 09:59:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `messageId` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章ID',
  `messageTitle` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章标题',
  `messageType` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章类型',
  `messageContent` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '文章内容',
  `createDate` date DEFAULT NULL COMMENT '创建时间',
  `status` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '未审核' COMMENT '审核状态',
  PRIMARY KEY (`messageId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, '校领导检查', '学院新闻', '为引导学生学以致用，服务社会，2020年的暑假，信息学院学子积极投身社会实践，在不同的岗位上挥洒着青春的热血与汗水，收获了经历与成长。\r\n\r\n2020年是特殊的一年，受新冠肺炎疫情影响，学生社会实践活动无法大规模集中开展。信息学院学子充分调动自身积极性，在保证安全的前提下，采取就近原则开展了丰富多彩的社会实践活动。有的同学走进当地企业，在实习岗位上摸索着企业的经营之道；有的同学参与到人口普查活动之中，脚沾泥土走街串巷，感受着浓浓乡情；还有的同学走进供电公司，直观感受到了能源对现代生活的重要作用。广泛的社会实践活动帮助学生更真切的了解国情、了解社会，增强了学生的社会责任感。信息管理与信息系统2018级的赵雨柯谈到：“在村委会的实习让我感受到了基层工作的繁琐，也体会到了基层工作人员的艰辛。大学毕业之后想回到家乡，用自己的所学为家乡的发展助力。”\r\n\r\n本次社会实践活动让学生提前体验了职场的真实生活，既锻炼了能力，又增长了见识，为学生今后的职业发展奠定了现实基础。', '2020-08-23', '未审核');
INSERT INTO `message` VALUES (2, NULL, '学院新闻', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for web_address
-- ----------------------------
DROP TABLE IF EXISTS `web_address`;
CREATE TABLE `web_address`  (
  `address_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '链接地址名',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '链接地址',
  `ID` int(5) NOT NULL AUTO_INCREMENT,
  `AddressType` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '链接类型',
  `createDate` date DEFAULT NULL COMMENT '创建时间',
  `status` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '未审核' COMMENT '审核状态',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of web_address
-- ----------------------------
INSERT INTO `web_address` VALUES ('成都市郫都区统计局关于招聘编外用工人员的启事', 'http://aahz.pidu.gov.cn/pidu/c125561/2020-08/19/content_6dadf61ae7894d2786fd8053c3c43408.shtml', 1, '招生就业', '2020-08-24', '未审核');

SET FOREIGN_KEY_CHECKS = 1;
