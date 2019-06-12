/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : sts

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2019-05-17 16:55:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) NOT NULL,
  `admin_pwd` varchar(255) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '闲置数码');
INSERT INTO `category` VALUES ('2', '校园代步');
INSERT INTO `category` VALUES ('3', '电器日用');
INSERT INTO `category` VALUES ('4', '图书教材');
INSERT INTO `category` VALUES ('5', '美妆衣物');
INSERT INTO `category` VALUES ('6', '运动棋牌');
INSERT INTO `category` VALUES ('7', '票券小物');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` varchar(255) NOT NULL,
  `user_id` int(11) NOT NULL,
  `good_id` int(11) NOT NULL,
  `seller_id` int(11) NOT NULL,
  `order_status` int(11) DEFAULT NULL COMMENT '订单状态1.未完成，2.待评价，3.完成',
  `order_price` double(11,1) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `meet_time` datetime DEFAULT NULL,
  `meet_address` varchar(255) DEFAULT NULL,
  `evaluation_info` varchar(255) DEFAULT NULL COMMENT '评价详情',
  `evaluation_grade` int(100) DEFAULT NULL COMMENT '交易评分',
  PRIMARY KEY (`order_id`),
  KEY `FK_k8kupdtcdpqd57b6j4yq9uvdj` (`user_id`),
  KEY `FK_j5l9n06x7eayt7298td5dt7ad` (`good_id`),
  CONSTRAINT `FK_k8kupdtcdpqd57b6j4yq9uvdj` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('160C972FDEF8468989AEB503F5E7EE76', '5', '22', '2', '3', '333.0', '2019-05-01 15:40:14', '2019-05-03 21:21:00', '武汉商学院', '好', '80');
INSERT INTO `orders` VALUES ('584B2A6BA81C40638F408AD1E54DFBF4', '5', '19', '2', '3', '888.0', '2019-05-01 15:40:13', '2019-05-02 21:21:00', '武汉商学院', '好', '80');
INSERT INTO `orders` VALUES ('C84D4894F17549DE816B0735F5C75536', '5', '29', '2', '1', '666.0', '2019-05-08 21:40:00', null, null, null, null);

-- ----------------------------
-- Table structure for preorder
-- ----------------------------
DROP TABLE IF EXISTS `preorder`;
CREATE TABLE `preorder` (
  `preorder_id` int(22) NOT NULL AUTO_INCREMENT,
  `good_id` int(22) NOT NULL,
  `money` double(22,0) NOT NULL,
  `user_id` int(22) NOT NULL,
  PRIMARY KEY (`preorder_id`),
  KEY `good_id` (`good_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `preorder_ibfk_1` FOREIGN KEY (`good_id`) REFERENCES `product` (`good_id`),
  CONSTRAINT `preorder_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of preorder
-- ----------------------------
INSERT INTO `preorder` VALUES ('1', '29', '666', '5');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `good_id` int(11) NOT NULL AUTO_INCREMENT,
  `good_name` varchar(255) NOT NULL,
  `good_type` int(11) NOT NULL COMMENT '1.非拍卖。2.拍卖商品',
  `good_price` double(11,1) NOT NULL,
  `good_describe` varchar(255) DEFAULT NULL,
  `good_image` varchar(255) NOT NULL,
  `good_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `good_click` int(11) NOT NULL DEFAULT '0',
  `good_status` int(11) NOT NULL DEFAULT '1' COMMENT '商品状态，1.正常；2.卖出；3被锁定；4.用户下架',
  `end_time` datetime DEFAULT NULL COMMENT '拍卖截止时间',
  `user_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  PRIMARY KEY (`good_id`),
  KEY `FK_dmjsbs5v5w7nr2pvr45mlb1wo` (`user_id`),
  KEY `FK_ge6evitg0h93lger4jksfx157` (`category_id`),
  CONSTRAINT `FK_dmjsbs5v5w7nr2pvr45mlb1wo` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_ge6evitg0h93lger4jksfx157` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('19', '商品1', '1', '888.0', '买到就是赚到~', '001.png', '2019-04-18 18:07:58', '2', '2', null, '2', '1');
INSERT INTO `product` VALUES ('20', '商品2', '1', '888.0', '买到就是赚到', '002.png', '2019-04-18 18:09:18', '1', '2', null, '2', '1');
INSERT INTO `product` VALUES ('21', '榨汁机', '1', '88.0', '好用', 'BDB63A581E8046A5A78D430A6CD99E7B.png', '2019-05-01 15:00:27', '4', '1', null, '2', '3');
INSERT INTO `product` VALUES ('22', '相机', '1', '333.0', '好用', '9E93A14BF7FE4BE0B1DFFA61824B4A1C.png', '2019-05-01 15:01:03', '1', '2', null, '2', '1');
INSERT INTO `product` VALUES ('23', '手机', '1', '555.0', '好用', '182FB5A3132B41F2928EACFAA2353E39.png', '2019-05-01 15:01:48', '0', '1', null, '2', '1');
INSERT INTO `product` VALUES ('24', 'iPhone', '1', '222.0', '好用', '9D54DB6190BD4617A60ABEBEC93421D1.png', '2019-05-01 15:02:19', '3', '3', null, '2', '1');
INSERT INTO `product` VALUES ('25', '鼠标', '1', '11.0', '好用', 'EF7F7CD7F81242149FAD1879C04E7C3D.png', '2019-05-01 15:02:39', '0', '1', null, '2', '1');
INSERT INTO `product` VALUES ('26', '笔记本', '1', '777.0', '好用', '59EB571A064A4D939564ECBB306715CE.png', '2019-05-01 15:03:06', '5', '3', null, '2', '1');
INSERT INTO `product` VALUES ('27', '吹风机', '1', '22.0', '好用', 'A2B0532C3F3B44DDB74B90BEC01FFA03.png', '2019-05-01 15:03:35', '4', '1', null, '2', '3');
INSERT INTO `product` VALUES ('28', '榨汁机', '2', '88.0', '好用', '176FDAE2E213460599E61725A97D847B.png', '2019-05-01 15:04:36', '3', '2', '2019-05-02 21:21:00', '2', '3');
INSERT INTO `product` VALUES ('29', '相机', '2', '555.0', '好用', '083D428F6FE9404D98F74C02B07056C6.png', '2019-05-01 15:05:12', '2', '2', '2019-05-03 11:11:00', '2', '1');
INSERT INTO `product` VALUES ('30', '手机1', '1', '555.0', '好用', '07D80BF07543451AB8A0185676493D3C.png', '2019-05-01 15:22:35', '3', '1', null, '4', '1');
INSERT INTO `product` VALUES ('31', '相机1', '2', '555.0', '好用', '46B611A42A8144ECB684E628E5A79CE3.png', '2019-05-01 15:23:27', '1', '2', '2019-05-02 21:21:00', '4', '1');
INSERT INTO `product` VALUES ('32', '相机1', '1', '555.0', '好用', '7716692B763547A79A44CB85E2E015DB.png', '2019-05-01 15:37:50', '2', '1', null, '5', '1');
INSERT INTO `product` VALUES ('33', 'iPhone 1', '2', '333.0', '好用', '7FBF65A3F49448EF875FF02C1F5A47A6.png', '2019-05-01 15:38:36', '1', '2', '2019-05-02 21:21:00', '5', '1');
INSERT INTO `product` VALUES ('34', '榨汁机1', '2', '32.0', 'fasdfasd', '8ABD64D034F349799E235D9BB2AA1E20.png', '2019-05-10 09:37:02', '1', '1', '2019-05-11 21:21:00', '1', '3');

-- ----------------------------
-- Table structure for reporte
-- ----------------------------
DROP TABLE IF EXISTS `reporte`;
CREATE TABLE `reporte` (
  `reporte_id` int(11) NOT NULL AUTO_INCREMENT,
  `reporte_info` varchar(255) NOT NULL,
  `reporte_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  `good_id` int(11) NOT NULL,
  PRIMARY KEY (`reporte_id`),
  KEY `FK_t8rgpjcemni8ra15qse971adv` (`user_id`),
  KEY `FK_49sbktdsxl4ck8w0un44ptpon` (`good_id`),
  CONSTRAINT `FK_49sbktdsxl4ck8w0un44ptpon` FOREIGN KEY (`good_id`) REFERENCES `product` (`good_id`),
  CONSTRAINT `FK_t8rgpjcemni8ra15qse971adv` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reporte
-- ----------------------------
INSERT INTO `reporte` VALUES ('1', '没理由', '2019-05-01 15:44:04', '5', '26');
INSERT INTO `reporte` VALUES ('2', '没理由', '2019-05-01 15:44:16', '5', '24');
INSERT INTO `reporte` VALUES ('3', '没理由', '2019-05-01 15:44:30', '5', '21');

-- ----------------------------
-- Table structure for shopcart
-- ----------------------------
DROP TABLE IF EXISTS `shopcart`;
CREATE TABLE `shopcart` (
  `shopcart_id` int(11) NOT NULL AUTO_INCREMENT,
  `buyNum` int(11) DEFAULT NULL,
  `good_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`shopcart_id`),
  KEY `FK_efooo3w5r8bsfimwjspas51tr` (`good_id`),
  KEY `FK_32p2kvdguwyodbsqvmr8hh7x2` (`user_id`),
  CONSTRAINT `FK_32p2kvdguwyodbsqvmr8hh7x2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopcart
-- ----------------------------
INSERT INTO `shopcart` VALUES ('14', null, '20', '1');
INSERT INTO `shopcart` VALUES ('15', null, '19', '1');
INSERT INTO `shopcart` VALUES ('16', null, '27', '3');
INSERT INTO `shopcart` VALUES ('17', null, '30', '5');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `user_phone` varchar(11) NOT NULL,
  `user_pwd` varchar(20) NOT NULL,
  `user_credit` double(200,1) DEFAULT '60.0',
  `user_status` int(11) DEFAULT '1',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_phone` (`user_phone`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '111', '11111111111', '111111', '60.0', '1');
INSERT INTO `user` VALUES ('2', '222', '11111111112', '222', '60.0', '2');
INSERT INTO `user` VALUES ('3', '333', '18151912737', '333333', null, null);
INSERT INTO `user` VALUES ('4', '555', '17607193059', '555555', null, null);
INSERT INTO `user` VALUES ('5', '666', '18151912738', '111111', '60.0', '1');
