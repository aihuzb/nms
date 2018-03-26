/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50517
Source Host           : localhost:3306
Source Database       : heartcloud

Target Server Type    : MYSQL
Target Server Version : 50517
File Encoding         : 65001

Date: 2018-02-24 10:24:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(10) NOT NULL,
  `department_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '部门名称',
  `department_scale` int(7) DEFAULT NULL COMMENT '部门规模',
  `department_contacts` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '部门联系人',
  `department_phone` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '联系人电话',
  `department_email` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '部门邮箱',
  `department_remark` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '部门介绍',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of department
-- ----------------------------

-- ----------------------------
-- Table structure for enterprise
-- ----------------------------
DROP TABLE IF EXISTS `enterprise`;
CREATE TABLE `enterprise` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `enterprise_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '企业名称',
  `enterprise_contacts` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '联系人',
  `enterprise_phone` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '联系人电话',
  `enterprise_email` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '企业邮箱',
  `enterprise_scale` int(7) DEFAULT NULL COMMENT '企业规模',
  `enterprise_type` int(2) DEFAULT NULL COMMENT '企业性质',
  `enterprise_icon` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '企业图标地址',
  `enterprise_remark` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '企业介绍',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of enterprise
-- ----------------------------

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '员工ID',
  `staff_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '员工姓名',
  `staff_age` int(3) DEFAULT NULL COMMENT '员工年龄',
  `staff_sex` int(2) DEFAULT NULL COMMENT '性别 1：男，2：女',
  `staff_bron` date DEFAULT NULL COMMENT '出生年月',
  `phone_number` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '电话号码',
  `staff_email` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `staff_address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '居住地址',
  `companyId_id` int(10) DEFAULT NULL COMMENT '所属企业ID',
  `staff_seniority` double DEFAULT NULL COMMENT '工龄',
  `staff_homeInfo` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '家庭情况',
  `staff_icon` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '头像连接',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of staff
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `pass_word` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `type` int(2) DEFAULT NULL COMMENT '用户类型',
  `rel_id` int(10) DEFAULT NULL COMMENT '关联数据ID',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '用户创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'huzhibin', '123456', '1', '1', '2018-02-22 00:00:00', '2018-02-24 10:16:26');
