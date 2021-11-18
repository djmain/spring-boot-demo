
-- 普通索引，建表时添加，用index或key关键字创建：
create table m1 (
id int,
index(id)
) ;

-- 普通索引，建表后添加：
ALTER TABLE table_name ADD INDEX index_name(column);

-- 唯一索引，建表时创建，用unique index或unique key创建：
create table m2 (
id int,
unique index(id)
);

-- 主键索引，用primay key创建

-- 全文索引，用fulltext index或者fulltext key创建。
create table m3 (
name varchar(50),
fulltext index(name)
);

-- name字段创建索引
ALTER TABLE user_innodb DROP INDEX idx_user_name;
ALTER TABLE user_innodb ADD INDEX idx_user_name (name);

-- gender字段创建索引
ALTER TABLE user_innodb DROP INDEX idx_user_gender;
ALTER TABLE user_innodb ADD INDEX idx_user_gender 

-- name和phone创建联合索引
ALTER TABLE user_innodb DROP INDEX comidx_name_phone;
ALTER TABLE user_innodb add INDEX comidx_name_phone (name,phone);

-- 联合索引最左匹配
EXPLAIN SELECT * FROM user_innodb WHERE name= '青山' AND phone = '13666666666';
EXPLAIN SELECT * FROM user_innodb WHERE name= '青山';
EXPLAIN SELECT * FROM user_innodb WHERE phone = '13666666666';

--覆盖索引
EXPLAIN SELECT name,phone FROM user_innodb WHERE name= '青山' AND phone = '13666666666';
EXPLAIN SELECT name FROM user_innodb WHERE name= '青山' AND phone = '13666666666';
EXPLAIN SELECT phone FROM user_innodb WHERE name= '青山' AND phone = '13666666666';

-- 索引下推
drop table employees;
CREATE TABLE `employees` (
 `emp_no` int(11) NOT NULL,
 `birth_date` date  NULL,
 `first_name` varchar(14) NOT NULL,
 `last_name` varchar(16) NOT NULL,
 `gender` enum('M','F') NOT NULL,
 `hire_date` date  NULL,
 PRIMARY KEY (`emp_no`)
) ENGINE=InnoDB ;

alter table employees add index idx_lastname_firstname(last_name,first_name);

INSERT INTO `employees` (`emp_no`, `birth_date`, `first_name`, `last_name`, `gender`, `hire_date`) VALUES (1, NULL, '698', 'liu', 'F', NULL);
INSERT INTO `employees` (`emp_no`, `birth_date`, `first_name`, `last_name`, `gender`, `hire_date`) VALUES (2, NULL, 'd99', 'zheng', 'F', NULL);
INSERT INTO `employees` (`emp_no`, `birth_date`, `first_name`, `last_name`, `gender`, `hire_date`) VALUES (3, NULL, 'e08', 'huang', 'F', NULL);
INSERT INTO `employees` (`emp_no`, `birth_date`, `first_name`, `last_name`, `gender`, `hire_date`) VALUES (4, NULL, '59d', 'lu', 'F', NULL);
INSERT INTO `employees` (`emp_no`, `birth_date`, `first_name`, `last_name`, `gender`, `hire_date`) VALUES (5, NULL, '0dc', 'yu', 'F', NULL);
INSERT INTO `employees` (`emp_no`, `birth_date`, `first_name`, `last_name`, `gender`, `hire_date`) VALUES (6, NULL, '989', 'wang', 'F', NULL);
INSERT INTO `employees` (`emp_no`, `birth_date`, `first_name`, `last_name`, `gender`, `hire_date`) VALUES (7, NULL, 'e38', 'wang', 'F', NULL);
INSERT INTO `employees` (`emp_no`, `birth_date`, `first_name`, `last_name`, `gender`, `hire_date`) VALUES (8, NULL, '0zi', 'wang', 'F', NULL);
INSERT INTO `employees` (`emp_no`, `birth_date`, `first_name`, `last_name`, `gender`, `hire_date`) VALUES (9, NULL, 'dc9', 'xie', 'F', NULL);
INSERT INTO `employees` (`emp_no`, `birth_date`, `first_name`, `last_name`, `gender`, `hire_date`) VALUES (10, NULL, '5ba', 'zhou', 'F', NULL);
-- 关闭ICP
set optimizer_switch='index_condition_pushdown=off';
-- 开启ICP
set optimizer_switch='index_condition_pushdown=on';
-- 查看ICP参数
show variables like 'optimizer_switch';
-- 执行计划
explain select * from employees where last_name='wang' and first_name LIKE '%zi' ;

-- 是否能用到索引
explain select *from employees where emp_no not in (1)
explain select *from employees where emp_no <> 1

-- 前缀索引：
CREATE TABLE `pre_test` (
  `content` varchar(20) DEFAULT NULL,
  KEY `pre_idx` (`content`(6))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;