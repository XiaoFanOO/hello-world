/** 新增帐号数据表 */
CREATE TABLE `te_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '乐观锁',
  `creation` datetime DEFAULT NULL COMMENT '创建时间',
  `type` int(5) DEFAULT NULL COMMENT '类型',
  `state` int(5) DEFAULT NULL COMMENT '状态',
  `username` varchar(128) DEFAULT NULL COMMENT '用户名',
  `password` varchar(128) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(128) DEFAULT NULL COMMENT '昵称',
  `creator` varchar(128) DEFAULT NULL COMMENT '创建者',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/** 初始化超级管理员帐号 */
INSERT INTO `te_account` VALUES (NULL, NOW(), NOW(), 0, 0, 'admin', '0992544eb78868cc056dee57947b2947', '超级管理员', 'System');

/** 新增资产状态数据表*/
DROP TABLE IF EXISTS `asset_state`;
CREATE TABLE `asset_state` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `timestamp` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '乐观锁',
  `creation` DATETIME DEFAULT NULL COMMENT '创建时间',
  `name` VARCHAR(512) DEFAULT NULL COMMENT '状态名',
  `description` TEXT COMMENT '状态描述',
  `level` VARCHAR(128) DEFAULT NULL COMMENT '紧急程度',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/** 新增资产数据表*/
DROP TABLE IF EXISTS `asset`;
CREATE TABLE `asset` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `timestamp` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '乐观锁',
  `creation` DATETIME DEFAULT NULL COMMENT '创建时间',
  `warranty` DATETIME DEFAULT NULL COMMENT '保修截至日期',
  `assetname` VARCHAR(512) DEFAULT NULL COMMENT '资产名称',
  `state` BIGINT(20) NOT NULL DEFAULT 0  COMMENT       '资产状态',
  `type` BIGINT(20) DEFAULT NULL   COMMENT     '资产类型',
  `address` VARCHAR(60) DEFAULT NULL   COMMENT   '存放地址',
  `person` VARCHAR(20) DEFAULT NULL COMMENT     '负责人',
  `madetime` DATETIME DEFAULT NULL  COMMENT      '出厂日期',
  `note` VARCHAR(2048) DEFAULT NULL   COMMENT    '备注',
  `amount` INT(20) DEFAULT NULL     COMMENT      '数量',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/** 新增资产类型*/
DROP TABLE IF EXISTS `asset_stype`;
CREATE TABLE `asset_stype` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `timestamp` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '乐观锁',
  `name` VARCHAR(512) DEFAULT NULL COMMENT '类型名',
  `description` VARCHAR(1024) DEFAULT NULL COMMENT '类型描述',
  PRIMARY KEY (`id`)`asset_stype`
) ENGINE=INNODB  DEFAULT CHARSET=utf8;
