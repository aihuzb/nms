/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50517
Source Host           : 127.0.0.1:3306
Source Database       : spacebroad_nms

Target Server Type    : MYSQL
Target Server Version : 50517
File Encoding         : 65001

Date: 2018-04-18 22:48:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_entity
-- ----------------------------
DROP TABLE IF EXISTS `t_entity`;
CREATE TABLE `t_entity` (
  `entity_id` int(5) NOT NULL AUTO_INCREMENT,
  `entity_key` varchar(50) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `name_us` varchar(20) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `parent` int(5) DEFAULT NULL,
  `icon` varchar(100) DEFAULT NULL,
  `sort` int(4) DEFAULT NULL,
  `type` int(2) DEFAULT NULL COMMENT '1：菜单，2：按钮，3：操作',
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`entity_id`),
  KEY `FK_ahevo3im3pnpk8ke9tqyuiaxh` (`parent`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_entity
-- ----------------------------
INSERT INTO `t_entity` VALUES ('1', 'netWork', '网络管理', 'NetManage', '#', null, 'images/network-icon.png', '1', '1', '');
INSERT INTO `t_entity` VALUES ('2', 'qos', 'Qos配置', 'QOS', 'qos', '1', 'images/qos.png', '1', '1', '');
INSERT INTO `t_entity` VALUES ('3', 'userList', '用户管理', 'UserAndAuthority', 'user', null, 'images/user.png', '2', '1', null);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `role_id` int(4) NOT NULL,
  `name` varchar(50) NOT NULL,
  `type` int(2) DEFAULT NULL COMMENT '1：Administrator，2：Operator，3：SVNO',
  `ncs_id` varchar(5) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'Administrator', '1', null, 'Administrator');
INSERT INTO `t_role` VALUES ('2', 'Operator', '2', '', 'Operator');
INSERT INTO `t_role` VALUES ('3', 'SVNO', '3', '', 'SVNO');

-- ----------------------------
-- Table structure for t_role_entity
-- ----------------------------
DROP TABLE IF EXISTS `t_role_entity`;
CREATE TABLE `t_role_entity` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '1111:增删改查',
  `role` int(5) NOT NULL,
  `entity` int(5) NOT NULL,
  `authority` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_s9kax3j35t9jixav8ltr1cuuf` (`entity`) USING BTREE,
  KEY `FK_pdc8qfs1vduuod25ktqid2qta` (`role`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_entity
-- ----------------------------
INSERT INTO `t_role_entity` VALUES ('1', '1', '1', '1');
INSERT INTO `t_role_entity` VALUES ('2', '1', '2', '1');
INSERT INTO `t_role_entity` VALUES ('3', '1', '3', '1');
INSERT INTO `t_role_entity` VALUES ('4', '2', '1', '1');
INSERT INTO `t_role_entity` VALUES ('5', '2', '2', '1');
INSERT INTO `t_role_entity` VALUES ('6', '2', '3', '1');
INSERT INTO `t_role_entity` VALUES ('7', '3', '1', '1');
INSERT INTO `t_role_entity` VALUES ('8', '3', '2', '1');
INSERT INTO `t_role_entity` VALUES ('9', '3', '3', '1');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(6) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mobile` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `sex` char(1) NOT NULL COMMENT '1：男，2：女',
  `state` int(2) NOT NULL COMMENT '1：正常，2：锁定',
  `count` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'admin@qq.com', '15884865813', 'admin', '1', '1', '0', '', '2016-09-12 11:21:48');
INSERT INTO `t_user` VALUES ('2', 'huzhibin', 'e10adc3949ba59abbe56e057f20f883e', 'oper@qq.com', '18608001109', 'oper', '1', '1', '0', '', '2017-01-17 13:23:54');
INSERT INTO `t_user` VALUES ('3', 'svno', 'e10adc3949ba59abbe56e057f20f883e', 'svno@qq.com', '18608001109', 'svno', '1', '1', '0', '', '2017-01-17 13:23:54');

-- ----------------------------
-- Table structure for t_user_entity
-- ----------------------------
DROP TABLE IF EXISTS `t_user_entity`;
CREATE TABLE `t_user_entity` (
  `id` int(5) NOT NULL,
  `user` int(5) NOT NULL,
  `entity` int(5) NOT NULL,
  `authority` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_entity
-- ----------------------------
INSERT INTO `t_user_entity` VALUES ('1', '1', '1', '1');
INSERT INTO `t_user_entity` VALUES ('2', '1', '2', '1');
INSERT INTO `t_user_entity` VALUES ('3', '1', '3', '15');
INSERT INTO `t_user_entity` VALUES ('4', '2', '1', '1');
INSERT INTO `t_user_entity` VALUES ('5', '2', '2', '1');
INSERT INTO `t_user_entity` VALUES ('6', '2', '3', '1');
INSERT INTO `t_user_entity` VALUES ('7', '3', '1', '1');
INSERT INTO `t_user_entity` VALUES ('8', '3', '2', '1');
INSERT INTO `t_user_entity` VALUES ('9', '3', '3', '1');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(5) NOT NULL,
  `role` int(5) NOT NULL,
  `user` int(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1', '1');
INSERT INTO `t_user_role` VALUES ('2', '2', '2');
INSERT INTO `t_user_role` VALUES ('3', '3', '3');
