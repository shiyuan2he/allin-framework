该仓库是多个项目架构的合集,每个文件夹下存在一个Java项目。每个项目都采用不同的架构去设计，目的在于体验不同架构的区别之处

<!-- more -->

1,2,3...没有难易级别限制,每个架构项目都会不断更新优化到更复杂。
架构就是将简单技术组合在一起形成稳定的，协助作业的整体。

☆☆☆<b>此项目代码仅可用于个人自我学习,谢绝任何组织或个人用于学生毕业设计、商业性传播等一切功利性行为
****
                 
## 目录

### 1#java-jdbc-mariadb

#### 具备知识

- [x] 增删改查sql编写
- [x] JDBC增删改查操作
- [x] Java面向对象
- [x] mariadb数据库

#### 项目介绍

Java基础项目(商城购物管理系统)具有商品管理、前台收银、商品库存等功能。
本项目使用jdk8作为java开发版本，原生JDBC连接Mariadb数据库存储数据，可以有效地锻炼和加强开发者运用Java、mariadb数据库及基本sql编程开发的能力。
此项目仅是初版完成，后续会持续更新

详情：<br/>
csdn:[商城项目之jdk8+jdbc+mariadb](http://blog.csdn.net/u012806787/article/details/77084802)
博客：[商城项目之jdk8+jdbc+mariadb](https://shiyuan2he.github.io/2017/08/10/jdk8-jdbc-mariadb/)

****

### 2#spring+jdbcTemplate+servlet

具备知识

- [x] sql
- [x] jdbcTemplate增删改查
- [x] Jdk8
- [x] httpclient
- [x] junit+spring-test
- [x] Servlet
- [x] Mariadb数据库

持续更新中

****
  
### 3#spring+springmvc+mybatis

#### 具备知识

- [x] spring(DI)
- [x] springmvc（json请求及返回）
- [x] mybatis（增删改查）
- [x] aspectJ（切面日志，监控每一个请求）
- [x] quartz（定时任务）
- [x] exception（全局异常处理）
- [x] [redis使用及服务器搭建](https://shiyuan2he.github.io/2017/08/22/centos7%E8%87%AA%E5%AD%A6%E4%B9%8B6-redis-4-0-1%E5%8D%95%E4%BE%8B%E6%9C%8D%E5%8A%A1%E5%99%A8%E6%90%AD%E5%BB%BA/)
- [x] druid数据源配置
- [x] 线程池使用
- [x] Mariadb数据库
- [x] slf4f+logback日志框架

#### 项目介绍
aspectJ+多线程：实现对每一个controller请求监控并把请求信息入库。

slf4f+logback：实现日志系统

全局异常统一处理返回

quartz：实现定时操作数据库

aop+redis：查询结果集入库

持续更新中