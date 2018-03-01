SELECT * FROM FundInfo.aniu;

TRUNCATE FundInfo.aniu;

delete from FundInfo.zhushuvalue where fundDate = "2018-01-01" limit 3;

SELECT * FROM FundInfo.aniu WHERE fundDate = "2018-01-29";

show create database FundInfo;
show create table zhushuvalue;

CREATE TABLE `zhushuvalue` (
  `fundDate` varchar(45) DEFAULT NULL COMMENT '日期',
  `fundInfo` mediumtext COMMENT '信息'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

show variables like 'character%';

alter database FundInfo charset utf8;
alter table zhushuvalue charset utf8;

ALTER TABLE `FundInfo`.`zhushuvalue` 
CHANGE COLUMN `fundDate` `fundDate` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL ,
CHANGE COLUMN `fundInfo` `fundInfo` MEDIUMTEXT CHARACTER SET 'utf8' NULL DEFAULT NULL ;
