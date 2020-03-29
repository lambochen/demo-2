-- 数据库
create database imooc_homepage_sc;

-- 用户信息表
create table if not exists `imooc_homepage_sc`.`homepage_user` (
`id` bigint(20) not null auto_increment comment '自增ID',
`username` varchar(128) not null default '' comment '用户名',
`email` varchar(128) not null default '' comment '邮箱',
`create_time` datetime not null default '1970-01-01 08:00:00' comment '创建时间',
`update_time` datetime not null default '1970-01-01 08:00:00' comment '更新时间'
primary key(`id`),
unique key `key_username` (`username`)
) engine=InnoDB auto_increment=1 default charset=utf8mb4 row_format=compact comment='用户信息';

-- 用户课程表
create table if not exists `imooc_homepage_sc`.`homepage_user_course` (
`id` bigint(20) not null auto_increment comment '自增ID',
`user_id` bigint(20) not null default 0 comment 'user ID',
`course_id` bigint(20) not null default 0 comment 'course ID',
`create_time` datetime not null default '1970-01-01 08:00:00' comment '创建时间',
`update_time` datetime not null default '1970-01-01 08:00:00' comment '更新时间'
primary key(`id`),
unique key `key_user_course` (`user_id`, `course_id`)
) engine=InnoDB auto_increment=1 default charset=utf8mb4 row_format=compact comment='用户课程';

-- 课程表
create table if not exists `imooc_homepage_sc`.`homepage_course` (
`id` bigint(20) not null auto_increment comment '自增ID',
`cource_name` varchar(128) not null default '' comment '课程名称',
`cource_type` varchar(128) not null default '' comment '课程类型',
`cource_icon` varchar(128) not null default '' comment '课程图标',
`cource_intro` varchar(128) not null default '' comment '课程介绍',
`create_time` datetime not null default '1970-01-01 08:00:00' comment '创建时间',
`update_time` datetime not null default '1970-01-01 08:00:00' comment '更新时间'
primary key(`id`),
unique key `key_course` (`cource_name`)
) engine=InnoDB auto_increment=1 default charset=utf8mb4 row_format=compact comment='课程';



