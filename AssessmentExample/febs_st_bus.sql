/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : febs_st_bus

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 15/05/2020 14:22:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for assessment
-- ----------------------------
DROP TABLE IF EXISTS `assessment`;
CREATE TABLE `assessment`  (
  `no` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `name` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `sex` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `age` int(11) NOT NULL,
  `level` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `userPhotos` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of assessment
-- ----------------------------
INSERT INTO `assessment` VALUES ('412725199804043917', '张三', '男', 15, '良好', '/img/zs.jpg');
INSERT INTO `assessment` VALUES ('412725199804043918', '李四', '男', 36, '良好', '/img/ls.jpg');
INSERT INTO `assessment` VALUES ('412725199804043919', '王二', '女', 20, '不及格', '/img/wr.jpg');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `salesman_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `loan` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('412725199804043917', 'salesman2', '500000');
INSERT INTO `record` VALUES ('412725199804043919', 'salesman1', '300000');
INSERT INTO `record` VALUES ('412725199804043931', 'salesman33', '1000000000');

-- ----------------------------
-- Table structure for user_admin
-- ----------------------------
DROP TABLE IF EXISTS `user_admin`;
CREATE TABLE `user_admin`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `photo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_admin
-- ----------------------------
INSERT INTO `user_admin` VALUES ('admin1', 'admin1', '管理员一号', '/img/zs.jpg');
INSERT INTO `user_admin` VALUES ('admin2', 'admin2', '管理员二号', '/img/ls.jpg');

-- ----------------------------
-- Table structure for user_salesman
-- ----------------------------
DROP TABLE IF EXISTS `user_salesman`;
CREATE TABLE `user_salesman`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `photo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_salesman
-- ----------------------------
INSERT INTO `user_salesman` VALUES ('salesman1', 'salesman1', '业务员1号', '/img/ls.jpg');
INSERT INTO `user_salesman` VALUES ('salesman2', 'salesman2', '业务员2号', '/img/ls.jpg');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(10) NULL DEFAULT NULL,
  `providentFunRatio` float NULL DEFAULT NULL,
  `monthlyIncome` float NULL DEFAULT NULL,
  `monthlySpending` float NULL DEFAULT NULL,
  `defaultRecord` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userPhotos` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('412725199804043917', '张三', '男', 15, 0.07, 4000, 1000, 'N', '/img/zs.jpg');
INSERT INTO `userinfo` VALUES ('412725199804043918', '李四', '男', 36, 0.09, 5000, 2000, 'N', '/img/ls.jpg');
INSERT INTO `userinfo` VALUES ('412725199804043919', '王二', '女', 20, 0.05, 5000, 1500, 'Y', '/img/wr.jpg');

SET FOREIGN_KEY_CHECKS = 1;
