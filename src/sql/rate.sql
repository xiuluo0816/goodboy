drop table if exists rate;

CREATE TABLE `rate` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `organization_code` varchar(100) DEFAULT '' COMMENT '机构号',
  `organization_name` varchar(100) DEFAULT '' COMMENT '机构名称',
  `rate_type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '利率种类,0：活期，1：定期',
  `year_terminable` tinyint(4) NOT NULL DEFAULT '0' COMMENT '利率期限(年)',
  `month_terminable` tinyint(4) NOT NULL DEFAULT '0' COMMENT '利率期限(月)',
  `day_terminable` tinyint(4) NOT NULL DEFAULT '0' COMMENT '利率期限(日)',
  `annual_interestRate` varchar(100) DEFAULT '' COMMENT '年利率',
  `created_by` varchar(150) NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_by` varchar(150) NOT NULL DEFAULT '' COMMENT '修改人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否已经删除,0：未删除，1：删除',
  PRIMARY KEY (`id`),
  KEY `idx_org_code` (`organization_code`),
  KEY `idx_update_time` (`update_time`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='存款利率基本信息表';