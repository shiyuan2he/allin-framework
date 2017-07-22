/*
Navicat MySQL Data Transfer

Source Server         : 192.168.6.101
Source Server Version : 50546
Source Host           : 192.168.6.101:3306
Source Database       : test_shopping

Target Server Type    : MYSQL
Target Server Version : 50546
File Encoding         : 65001

Date: 2017-07-20 20:27:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '商品名称',
  `price` double(10,0) DEFAULT NULL COMMENT '价钱',
  `number` int(11) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES ('46550930', 'iphone6', '4444', '8');
INSERT INTO `t_goods` VALUES ('71776349', 'iphone7', '22222', '20');
INSERT INTO `t_goods` VALUES ('84700252', 'iphone7', '2222', '27');

-- ----------------------------
-- Table structure for t_r_goods_salesperson
-- ----------------------------
DROP TABLE IF EXISTS `t_r_goods_salesperson`;
CREATE TABLE `t_r_goods_salesperson` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `goods_id` bigint(20) NOT NULL COMMENT '商品表外键',
  `salesperosn_id` bigint(20) NOT NULL COMMENT '销售员外键',
  `number` int(10) NOT NULL COMMENT '销售量',
  `sales_time` datetime NOT NULL COMMENT '商品卖出时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_r_goods_salesperson
-- ----------------------------
INSERT INTO `t_r_goods_salesperson` VALUES ('9402055', '46550930', '49972586', '2', '2017-07-20 12:12:12');
INSERT INTO `t_r_goods_salesperson` VALUES ('9839286', '84700252', '49972586', '3', '2017-07-20 10:53:15');

-- ----------------------------
-- Table structure for t_salesperson
-- ----------------------------
DROP TABLE IF EXISTS `t_salesperson`;
CREATE TABLE `t_salesperson` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(4) DEFAULT NULL COMMENT '销售员姓名',
  `password` varchar(30) DEFAULT NULL COMMENT '销售员密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_salesperson
-- ----------------------------
INSERT INTO `t_salesperson` VALUES ('49972586', '王五一', '1234');
INSERT INTO `t_salesperson` VALUES ('70072630', '李四', '1234');
