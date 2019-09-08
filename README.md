# 数据库设计

数据库名为blog，设置字符集为utf-8
```sql
-- sql代码 --

--  创建用户表 --
CREATE TABLE `user`
(
    `uuid`          varchar(24) NOT NULL COMMENT '用户id',
    `user_name`     varchar(24) NOT NULL COMMENT '用户名',
    `user_password` varchar(24) NOT NULL COMMENT '用户密码',
    `phone`         varchar(11) NOT NULL COMMENT '手机号',
    `create_date`   varchar(24) NOT NULL,
    `edit_date`     varchar(24) NOT NULL,
    PRIMARY KEY (`uuid`),unique (`user_name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8  

-- 创建博客表 --
CREATE TABLE `article`
(
    `a_id`        varchar(24) NOT NULL COMMENT '博客id',
    `title`       varchar(50) NOT NULL COMMENT '博客标题',
    `category`    varchar(24) NOT NULL COMMENT '博客类型id',
    `content`     text        NOT NULL COMMENT '博客内容',
    `summary`     varchar(40) NOT NULL COMMENT '博客摘要',
    `create_date` varchar(24) NOT NULL COMMENT '创建时间',
    `edit_date`   varchar(24) DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`a_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 

-- 创建博客类型表 --
CREATE TABLE `category`
(
    `c_id`          varchar(24) NOT NULL COMMENT '博客类型id',
    `category_name` varchar(24) NOT NULL COMMENT '博客类型',
    `display_name`  varchar(24) NOT NULL COMMENT '显示类型',
    PRIMARY KEY (`c_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8   

```

表结构设计：用户表user，博客表article，和类别表category

**user表**：

字段名| 属性名 | 类型 | 长度 | nulll | PRI | UNI | 注释  
---------|----------|---------|---------|---------|---------|---------|---------
uuid | uuid | varchar | 24 | N | Y | N | id 
 user_name |  userName | varchar | 24 | N | N |  Y | 用户名
 user_password | userPassword | varchar | 24 | N | N | N  | 用户密码
 register_date | registerDate  | varchar | 24 | N | N | N  |创建时间
  edit_date | editDate | varchar | 24 | N | N |N |  修改时间


**article表**：


 字段名 | 类型 | 长度 |  null  | 主键 | 注释
---------|----------|---------|---------|---------|---------
 a_id | varchar | 24 | N | Y | 博客id
 title | varchar | 50|N | N | 博客标题
 category | varchar | 24 | N | N | 博客类型 
 content | mediumtext |  | N | N | 博客内容
 summary | varcahr | 40 | N | N | 博客摘要
 create_date |  varchar  | 24 | N | N | 创建时间
 edite_date | varchar | 24 |  Y | N | 修改时间 

**category表**：

字段名 | 类型 | 长度 |  null |  主键 | 注释
---------|----------|---------|---------|---------|---------
 c_id | varchar | 24  | N | Y | 类型id 
 category_name | varchar | 24 | N| N | 博客类型 
 display_name | varchar | 24 | N| N | 博客类型 


博客类型结构
```sql
insert into category(c_id, category_name, display_name)
VALUES ('1', 'javaPage', 'Java专栏'),
       ('2', 'computerPage', '计算机基础专栏'),
       ('3', 'DSAPage', '数据结构与算法'),
       ('4', 'notePage', '内功修炼')
```








# 问题

1. 在mysql5.0版本之后varchar类型存储的是字符，与字符编码无关，与中英文数字无关

2. 关于mysql中varchar编码限制与行限制的关系



未完。。。

