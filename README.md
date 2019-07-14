# 数据库设计

表结构设计：用户表user，博客表article，和类别表category

user表：

字段名 | 类型 | 长度 | 是否为nulll | 是否为主键 | 注释 
---------|----------|---------|---------|---------|---------
 id | varchar | C1 |  N | Y  | 用户id
 user_name | varchar | N | N | N | 用户名
 user_password | varchar | C3 | N | N  | 用户密码


 article表：

 字段名 | 类型 | 长度 |  是否为null  | 是否为主键 | 注释
---------|----------|---------|---------|---------|---------
 a_id | varchar | C1 | N | Y | 博客id
 title | varchar | C2 |24 | N | 博客标题
 catagery | varchar | 24 | N | N | 博客类型 
 content | varchar | 65535 | N | N | 博客内容
 summary | varcahr | 40 | N | N | 博客摘要
 create_date |  varchar  | 20 | N | N | 创建时间
 edite_date | varchar | 20 |  Y | N | 修改时间 

category表：

字段名 | 类型 | 长度 | 是否为null | 是否为主键 | 注释
---------|----------|---------|---------|---------|---------
 c_id | varchar | c  | N | Y | 类型id 
 category_name | varchar | 24 | N| N | 博客类型 
 display_name | varchar | 24 | N| N | 博客类型 


 