/*
Navicat MySQL Data Transfer

Source Server         : Jason
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : happygym

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-12-10 10:53:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gym_manager
-- ----------------------------
DROP TABLE IF EXISTS `gym_manager`;
CREATE TABLE `gym_manager` (
  `name` varchar(20) NOT NULL,
  `psw` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gym_manager
-- ----------------------------
INSERT INTO `gym_manager` VALUES ('gym', '1111');

-- ----------------------------
-- Table structure for match
-- ----------------------------
DROP TABLE IF EXISTS `match`;
CREATE TABLE `match` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `xm_name` varchar(50) NOT NULL,
  `yjs`   varchar(1) NOT NULL,
  `p_no1` varchar(50) NOT NULL,
  `p_no2` varchar(50) NOT NULL,
  `p_no3` varchar(50) NOT NULL,
  `p_no4` varchar(50) NOT NULL,
  `p_no5` varchar(50) NOT NULL,
  `p_no6` varchar(50) NOT NULL,
  `p_no7` varchar(50) NOT NULL,
  `p_no8` varchar(50) NOT NULL,
  `judge1` varchar(50) NOT NULL,
  `judge2` varchar(50) NOT NULL,
  `judge3` varchar(50) NOT NULL,
  `judge4` varchar(50) NOT NULL,
  `judge5` varchar(50) NOT NULL,
  `Judge` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of match
-- ----------------------------

-- ----------------------------
-- Table structure for p_group
-- ----------------------------
DROP TABLE IF EXISTS `p_group`;
CREATE TABLE `p_group` (
  `groupname` varchar(50) NOT NULL,
  `account` varchar(20) NOT NULL,
  `psw` varchar(20) NOT NULL,
  `groupno` varchar(50) NOT NULL,
  PRIMARY KEY (`groupno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_group
-- ----------------------------
INSERT INTO `p_group` VALUES ('湖北武汉', '123456', '123456', '001');
INSERT INTO `p_group` VALUES ('湖北黄冈', '12345', '12345', '002');
INSERT INTO `p_group` VALUES ('湖北2', '1234567', '1234567', '003');

-- ----------------------------
-- Table structure for p_group_player
-- ----------------------------
DROP TABLE IF EXISTS `p_group_player`;
CREATE TABLE `p_group_player` (
  `name` varchar(50) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `age` int(10) NOT NULL,
  `pno` varchar(50) NOT NULL,
  `groupno` varchar(50) NOT NULL,
  `dangang` varchar(1) DEFAULT NULL,
  `shuanggang` varchar(1) DEFAULT NULL,
  `diaohuan` varchar(1) DEFAULT NULL,
  `tiaoma` varchar(1) DEFAULT NULL,
  `freeticao` varchar(1) DEFAULT NULL,
  `anma` varchar(1) DEFAULT NULL,
  `benbed` varchar(1) DEFAULT NULL,
  `gaodigang` varchar(1) DEFAULT NULL,
  `pinghengmu` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_group_player
-- ----------------------------
INSERT INTO `p_group_player` VALUES ('王小明', '男', '8', '001', '001', '1', '1', '1', '0', '0', '0', '0', null, null);
INSERT INTO `p_group_player` VALUES ('小红', '女', '6', '005', '001', null, null, null, '1', '0', null, '1', '1', '1');

-- ----------------------------
-- Table structure for p_group_role
-- ----------------------------
DROP TABLE IF EXISTS `p_group_role`;
CREATE TABLE `p_group_role` (
  `name` varchar(20) NOT NULL,
  `idcard` varchar(50) NOT NULL,
  `role` varchar(20) NOT NULL,
  `groupno` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_group_role
-- ----------------------------
INSERT INTO `p_group_role` VALUES ('章伟', '153203199506216594', 'leader', '001');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `p_no` varchar(50) NOT NULL,
  `score1` varchar(50) NOT NULL,
  `score2` varchar(50) NOT NULL,
  `score3` varchar(50) NOT NULL,
  `score4` varchar(50) NOT NULL,
  `score5` varchar(50) NOT NULL,
  `final` varchar(50) NOT NULL,
  `score_d` varchar(50) NOT NULL,
  `score_p` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------

-- ----------------------------
-- Table structure for sys_manager
-- ----------------------------
DROP TABLE IF EXISTS `sys_manager`;
CREATE TABLE `sys_manager` (
  `name` varchar(20) NOT NULL,
  `psw` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_manager
-- ----------------------------
INSERT INTO `sys_manager` VALUES ('sys', '0000');
