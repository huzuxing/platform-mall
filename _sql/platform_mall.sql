/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50631
Source Host           : localhost:3306
Source Database       : platform_mall

Target Server Type    : MYSQL
Target Server Version : 50631
File Encoding         : 65001

Date: 2018-09-12 22:35:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cyc_annuoncement`
-- ----------------------------
DROP TABLE IF EXISTS `cyc_annuoncement`;
CREATE TABLE `cyc_annuoncement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(125) NOT NULL COMMENT '公告标题',
  `content` longtext COMMENT '内容',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态',
  `time_create` int(10) NOT NULL COMMENT '创建时间',
  `time_update` int(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告内容';

-- ----------------------------
-- Records of cyc_annuoncement
-- ----------------------------

-- ----------------------------
-- Table structure for `cyc_annuoncement_position`
-- ----------------------------
DROP TABLE IF EXISTS `cyc_annuoncement_position`;
CREATE TABLE `cyc_annuoncement_position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(125) NOT NULL COMMENT '公告位置名称',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态',
  `time_create` int(10) NOT NULL COMMENT '创建时间',
  `time_update` int(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告位置';

-- ----------------------------
-- Records of cyc_annuoncement_position
-- ----------------------------

-- ----------------------------
-- Table structure for `cyc_comment`
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
-- Table structure for `cyc_comment_parentchildren`
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
-- Table structure for `cyc_info_classify`
-- ----------------------------
DROP TABLE IF EXISTS `cyc_info_classify`;
CREATE TABLE `cyc_info_classify` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL COMMENT '分类名称',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  `time_create` int(10) NOT NULL,
  `time_update` int(10) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='信息分类';

-- ----------------------------
-- Records of cyc_info_classify
-- ----------------------------

-- ----------------------------
-- Table structure for `cyc_info_contacts`
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='信息联系人';

-- ----------------------------
-- Records of cyc_info_contacts
-- ----------------------------

-- ----------------------------
-- Table structure for `cyc_info_content`
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
  `status` tinyint(4) DEFAULT '0' COMMENT '状态',
  `district` varchar(50) NOT NULL COMMENT '区',
  `address` varchar(255) NOT NULL COMMENT '详细地址',
  `time_create` int(10) NOT NULL,
  `time_publish` int(10) NOT NULL,
  `time_update` int(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='信息内容';

-- ----------------------------
-- Records of cyc_info_content
-- ----------------------------

-- ----------------------------
-- Table structure for `cyc_info_content_ext`
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
-- Table structure for `cyc_info_picture`
-- ----------------------------
DROP TABLE IF EXISTS `cyc_info_picture`;
CREATE TABLE `cyc_info_picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info_id` int(11) NOT NULL COMMENT '信息ID',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  `url` longtext COMMENT '图片地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='信息图片';

-- ----------------------------
-- Records of cyc_info_picture
-- ----------------------------

-- ----------------------------
-- Table structure for `cyc_info_public_region`
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='信息发布区域';

-- ----------------------------
-- Records of cyc_info_public_region
-- ----------------------------

-- ----------------------------
-- Table structure for `cyc_info_stick`
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='信息置顶信息';

-- ----------------------------
-- Records of cyc_info_stick
-- ----------------------------

-- ----------------------------
-- Table structure for `cyc_user`
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
