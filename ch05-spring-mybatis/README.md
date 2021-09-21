spring和mybatis集成

步骤

1.新建maven项目

2.加入依赖

    1)spring依赖

    2)mybatis依赖

    3)mysql驱动

    4)spring事务依赖

    5)mybatis和spring的集成依赖,mybatis官方提供的

3.创建实体类

4.创建dao接口和mapper文件

5.创建mybatis主配置文件

6.创建service接口和实现类,属性是dao

7.创建spring的配置文件,声明mybatis的对象交给spring创建
    
    1)数据库源DataSource
    
    2)sqlSessionFactory
    
    3)dao对象
    
    4)声明自定义的service
    
8.创建测试类,获取service对象,通过service调用dao
完成数据库访问