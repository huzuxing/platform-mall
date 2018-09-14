/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50641
Source Host           : localhost:3306
Source Database       : platform-mall

Target Server Type    : MYSQL
Target Server Version : 50641
File Encoding         : 65001

Date: 2018-09-14 18:43:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cyc_announcement
-- ----------------------------
DROP TABLE IF EXISTS `cyc_announcement`;
CREATE TABLE `cyc_announcement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `position_id` int(11) NOT NULL COMMENT '公告位置ID',
  `title` varchar(125) NOT NULL COMMENT '公告标题',
  `content` longtext COMMENT '内容',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态',
  `time_create` int(10) NOT NULL COMMENT '创建时间',
  `time_update` int(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='公告内容';

-- ----------------------------
-- Records of cyc_announcement
-- ----------------------------
INSERT INTO `cyc_announcement` VALUES ('1', '1', '欢迎新同学加入', '欢迎新同学加入，请注意一下事项', '1', '0', '1536831483', '0');

-- ----------------------------
-- Table structure for cyc_announcement_position
-- ----------------------------
DROP TABLE IF EXISTS `cyc_announcement_position`;
CREATE TABLE `cyc_announcement_position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(125) NOT NULL COMMENT '公告位置名称',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态',
  `time_create` int(10) NOT NULL COMMENT '创建时间',
  `time_update` int(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='公告位置';

-- ----------------------------
-- Records of cyc_announcement_position
-- ----------------------------
INSERT INTO `cyc_announcement_position` VALUES ('1', '首页公告', '0', '0', '1536828344', '0');
INSERT INTO `cyc_announcement_position` VALUES ('2', '首页公告', '0', '0', '1536828397', '0');

-- ----------------------------
-- Table structure for cyc_comment
-- ----------------------------
DROP TABLE IF EXISTS `cyc_comment`;
CREATE TABLE `cyc_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_id` int(11) NOT NULL COMMENT '评论主题ID',
  `topic_type` tinyint(4) DEFAULT '0' COMMENT '主题类型',
  `content` longtext COMMENT '评论内容',
  `from_uid` int(11) NOT NULL COMMENT '评论者ID',
  `nickname` varchar(60) NOT NULL COMMENT '冗余用户昵称',
  `thumb_img` varchar(255) NOT NULL COMMENT '冗余用户头像',
  `praise_count` int(11) DEFAULT '0' COMMENT '评论被点赞次数',
  `reply_count` int(11) DEFAULT '0' COMMENT '评论被回复次数',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  `is_top` tinyint(4) DEFAULT '0' COMMENT '是否置顶0-否，1-是',
  `is_hot` tinyint(4) DEFAULT '0' COMMENT '是否热评0-否，1-是',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态',
  `time_create` int(10) NOT NULL COMMENT '创建时间',
  `time_update` int(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论';

-- ----------------------------
-- Records of cyc_comment
-- ----------------------------

-- ----------------------------
-- Table structure for cyc_comment_parentchildren
-- ----------------------------
DROP TABLE IF EXISTS `cyc_comment_parentchildren`;
CREATE TABLE `cyc_comment_parentchildren` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL COMMENT '父级ID',
  `child_id` int(11) NOT NULL COMMENT '子级ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论父子关系';

-- ----------------------------
-- Records of cyc_comment_parentchildren
-- ----------------------------

-- ----------------------------
-- Table structure for cyc_info_channel
-- ----------------------------
DROP TABLE IF EXISTS `cyc_info_channel`;
CREATE TABLE `cyc_info_channel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT '0' COMMENT '父级ID',
  `name` varchar(10) NOT NULL COMMENT '分类名称',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  `time_create` int(10) NOT NULL,
  `time_update` int(10) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='信息分类';

-- ----------------------------
-- Records of cyc_info_channel
-- ----------------------------
INSERT INTO `cyc_info_channel` VALUES ('5', '6', 'update66', '1', '1536809050', '1536811858');
INSERT INTO `cyc_info_channel` VALUES ('6', '0', '商家招聘', '1', '1536809096', '0');
INSERT INTO `cyc_info_channel` VALUES ('7', '0', '餐饮食材', '1', '1536809118', '0');
INSERT INTO `cyc_info_channel` VALUES ('8', '7', '酒水', '1', '1536809196', '0');

-- ----------------------------
-- Table structure for cyc_info_contacts
-- ----------------------------
DROP TABLE IF EXISTS `cyc_info_contacts`;
CREATE TABLE `cyc_info_contacts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL COMMENT '姓名',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  `contact` varchar(125) NOT NULL COMMENT '联系方式',
  `province` varchar(50) NOT NULL COMMENT '省份',
  `city` varchar(50) NOT NULL COMMENT '城市',
  `district` varchar(50) NOT NULL COMMENT '区',
  `address` varchar(255) NOT NULL COMMENT '详细地址',
  `time_create` int(10) NOT NULL,
  `time_update` int(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='信息联系人';

-- ----------------------------
-- Records of cyc_info_contacts
-- ----------------------------
INSERT INTO `cyc_info_contacts` VALUES ('3', '张三', '1', '13808551062', '四川省', '成都市', '高新区', '双宿双飞路', '1536910040', '0');
INSERT INTO `cyc_info_contacts` VALUES ('4', '张三', '1', '13808551062', '四川省', '成都市', '高新区', '双宿双飞路', '1536910083', '0');
INSERT INTO `cyc_info_contacts` VALUES ('5', '张三', '1', '13808551062', '四川省', '成都市', '高新区', '双宿双飞路', '1536910142', '0');
INSERT INTO `cyc_info_contacts` VALUES ('6', '张三', '1', '13808551062', '四川省', '成都市', '高新区', '双宿双飞路', '1536916556', '0');

-- ----------------------------
-- Table structure for cyc_info_content
-- ----------------------------
DROP TABLE IF EXISTS `cyc_info_content`;
CREATE TABLE `cyc_info_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(125) DEFAULT NULL COMMENT '标题',
  `short_title` varchar(70) DEFAULT NULL COMMENT '简短标题',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `content` longtext COMMENT '内容',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  `is_sticked` tinyint(4) DEFAULT '0' COMMENT '是否置顶，0-否，1-是',
  `channel_id` int(11) NOT NULL COMMENT '栏目ID',
  `contact_id` int(11) DEFAULT NULL COMMENT '联系人ID',
  `user_id` int(11) NOT NULL COMMENT '发布者ID',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态',
  `time_create` int(10) NOT NULL,
  `time_publish` int(10) NOT NULL,
  `time_update` int(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='信息内容';

-- ----------------------------
-- Records of cyc_info_content
-- ----------------------------
INSERT INTO `cyc_info_content` VALUES ('5', null, null, null, '测试内容', '1', '1', '2', '5', '0', '0', '1536910142', '1536910142', '0');
INSERT INTO `cyc_info_content` VALUES ('6', null, null, null, '测试内容', '1', '1', '1', '6', '0', '0', '1536916556', '1536916556', '0');

-- ----------------------------
-- Table structure for cyc_info_content_ext
-- ----------------------------
DROP TABLE IF EXISTS `cyc_info_content_ext`;
CREATE TABLE `cyc_info_content_ext` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info_id` int(11) NOT NULL COMMENT '信息ID',
  `view_count` int(11) DEFAULT '0' COMMENT '浏览次数',
  `praise_count` int(11) DEFAULT '0' COMMENT '点赞次数',
  `forward_count` int(11) DEFAULT '0' COMMENT '转发次数',
  `collect_count` int(11) DEFAULT '0' COMMENT '收藏次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='信息扩展表';

-- ----------------------------
-- Records of cyc_info_content_ext
-- ----------------------------

-- ----------------------------
-- Table structure for cyc_info_picture
-- ----------------------------
DROP TABLE IF EXISTS `cyc_info_picture`;
CREATE TABLE `cyc_info_picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info_id` int(11) NOT NULL COMMENT '信息ID',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  `url` longtext COMMENT '图片地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='信息图片';

-- ----------------------------
-- Records of cyc_info_picture
-- ----------------------------
INSERT INTO `cyc_info_picture` VALUES ('1', '5', '1', 'feeadefe.jpg');
INSERT INTO `cyc_info_picture` VALUES ('2', '5', '1', 'fadffdadfd.jpg');

-- ----------------------------
-- Table structure for cyc_info_public_region
-- ----------------------------
DROP TABLE IF EXISTS `cyc_info_public_region`;
CREATE TABLE `cyc_info_public_region` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL COMMENT '区域名称',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  `fee` double DEFAULT '0' COMMENT '区域发布费用',
  `time_create` int(10) NOT NULL,
  `time_update` int(10) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='信息发布区域';

-- ----------------------------
-- Records of cyc_info_public_region
-- ----------------------------
INSERT INTO `cyc_info_public_region` VALUES ('1', '本地', '1', '0', '1536812558', '0');
INSERT INTO `cyc_info_public_region` VALUES ('2', '全国', '2', '10', '1536812605', '0');

-- ----------------------------
-- Table structure for cyc_info_stick
-- ----------------------------
DROP TABLE IF EXISTS `cyc_info_stick`;
CREATE TABLE `cyc_info_stick` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL COMMENT '名称',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  `fee` double DEFAULT '0' COMMENT '区域发布费用',
  `days` int(11) DEFAULT '0' COMMENT '置顶天数',
  `time_create` int(10) NOT NULL,
  `time_update` int(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='信息置顶信息';

-- ----------------------------
-- Records of cyc_info_stick
-- ----------------------------
INSERT INTO `cyc_info_stick` VALUES ('1', '置顶7一周', '1', '10', '0', '1536817116', '0');

-- ----------------------------
-- Table structure for cyc_user
-- ----------------------------
DROP TABLE IF EXISTS `cyc_user`;
CREATE TABLE `cyc_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL COMMENT '会员姓名',
  `nickname` varchar(60) NOT NULL COMMENT '用户昵称',
  `thumb_img` varchar(255) NOT NULL COMMENT '用户头像',
  `phone` int(11) unsigned NOT NULL COMMENT '会员手机号',
  `gender` tinyint(4) NOT NULL COMMENT '性别，0-男，1-女',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态,0-启用',
  `time_create` int(10) NOT NULL,
  `time_update` int(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员表';

-- ----------------------------
-- Records of cyc_user
-- ----------------------------
