/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.216.129-root
 Source Server Type    : MariaDB
 Source Server Version : 100117
 Source Host           : 192.168.216.129:3306
 Source Schema         : niubility_ssm

 Target Server Type    : MariaDB
 Target Server Version : 100117
 File Encoding         : 65001

 Date: 23/08/2017 18:15:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_log
-- ----------------------------
DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log` (
  `id` bigint(20) DEFAULT NULL,
  `request_url` varchar(100) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `request_action` varchar(0) DEFAULT NULL,
  `timing` varchar(0) DEFAULT NULL,
  `request_method_type` varchar(0) DEFAULT NULL,
  `request_param` varchar(0) DEFAULT NULL,
  `user_remark` varchar(0) DEFAULT NULL,
  `request_ip` varchar(0) DEFAULT NULL,
  `request_address` varchar(0) DEFAULT NULL,
  `request_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_user_id` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_user_id` bigint(20) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `tel` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;;

SET FOREIGN_KEY_CHECKS = 1;
