/*
Navicat MySQL Data Transfer

Source Server         : LOCAL
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : ems

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2021-11-08 10:02:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `emp`
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `eid` int(4) NOT NULL AUTO_INCREMENT,
  `ename` varchar(20) NOT NULL,
  `salary` double(7,2) NOT NULL,
  `age` int(2) NOT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 CHECKSUM=1;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('1', '张三', '1000.00', '11');
INSERT INTO `emp` VALUES ('2', '李四', '2333.00', '23');
INSERT INTO `emp` VALUES ('3', '王五', '9999.00', '1');
INSERT INTO `emp` VALUES ('4', '赵六', '4444.00', '44');
INSERT INTO `emp` VALUES ('5', '丁凌珍', '1111.00', '12');
INSERT INTO `emp` VALUES ('6', '韩音景', '2333.00', '23');
INSERT INTO `emp` VALUES ('7', '谢照红', '2333.00', '23');
INSERT INTO `emp` VALUES ('8', '金方仪', '5555.00', '55');
INSERT INTO `emp` VALUES ('9', '夏修洁', '4444.00', '233');
INSERT INTO `emp` VALUES ('10', '璩博丽', '6666.00', '55');
INSERT INTO `emp` VALUES ('11', '冯凡旋', '4232.00', '23');
INSERT INTO `emp` VALUES ('12', '朱晏如', '8888.00', '77');
INSERT INTO `emp` VALUES ('13', '班芳茵', '2323.00', '34');
INSERT INTO `emp` VALUES ('14', '敖舒兰', '6666.00', '77');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(4) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `realname` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `gender` int(2) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '张三', '123456', '1');
INSERT INTO `user` VALUES ('2', 'caocao', '曹操', '111111', '1');
INSERT INTO `user` VALUES ('3', 'zz', 'zz', '123456', '1');
INSERT INTO `user` VALUES ('4', 'aaa', '小红', '123', '1');
INSERT INTO `user` VALUES ('5', 'admin1', 'admin', '123456', '0');
INSERT INTO `user` VALUES ('6', 'a', 'admin', '123456', '0');
INSERT INTO `user` VALUES ('7', 'b', 'admin', '123456', '0');
INSERT INTO `user` VALUES ('8', 'sss', '11', '111', '0');
INSERT INTO `user` VALUES ('9', 'uuuu', 'aaa', '123', '1');
INSERT INTO `user` VALUES ('11', 'acg', 'aaa', '123', '1');
