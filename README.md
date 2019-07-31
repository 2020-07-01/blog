# 数据库设计

数据库名为blog，设置字符集为utf-8
```sql
-- sql代码 --

--  创建用户表 --
create table if not exists user
(
    `user_name`     varchar(24) not null comment '用户名',
    `user_password` varchar(24) not null comment '用户密码',
    primary key (`user_name`)
) default charset = utf8;

-- 创建博客表 --
create table if not exists article
(
    `a_id`        varchar(24)    not null comment '博客id',
    `title`       varchar(50)    not null comment '博客标题',
    `category`    varchar(24)    not null comment '博客类型id',
    `content`     text(65535) not null comment '博客内容',
    `summary`     varchar(40)    not null comment '博客摘要',
    `create_date` varchar(24)    not null comment '创建时间',
    `edit_date`   varchar(24)   default null comment '修改时间',
    primary key (`a_id`)
) default charset = utf8;

-- 创建博客类型表 --
create table if not exists category
(
    `c_id`          varchar(24) not null comment '博客类型id',
    `category_name` varchar(24) not null comment '博客类型',
    `display_name`  varchar(24) not null comment '显示类型',
    primary key (`c_id`)
) default charset = utf8;


```

表结构设计：用户表user，博客表article，和类别表category

user表：

字段名 | 类型 | 长度 | nulll | 主键 | 注释 
---------|----------|---------|---------|---------|---------
 user_name | varchar | 24 | N | Y | 用户名
 user_password | varchar | 24 | N | N  | 用户密码


 article表：

 字段名 | 类型 | 长度 |  null  | 主键 | 注释
---------|----------|---------|---------|---------|---------
 a_id | varchar | 24 | N | Y | 博客id
 title | varchar | 50|N | N | 博客标题
 category | varchar | 24 | N | N | 博客类型 
 content | text | 65535 | N | N | 博客内容
 summary | varcahr | 40 | N | N | 博客摘要
 create_date |  varchar  | 24 | N | N | 创建时间
 edite_date | varchar | 24 |  Y | N | 修改时间 

category表：

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

未完。。。

