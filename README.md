# 1.Spring概述

spring出现在2002年左右，主要的目的是为了解决企业级开发的难度，减轻对项目模块之前的管理，类和类之间的管理，帮助开发人员去创建对象，管理对象之间的关系

spring有两个核心技术，ioc控制反转和aop面向切面编程，实现模块和类之间的解耦合，使得关系更为松散

那么什么是解耦合？

类似于如果你找了个女朋友，如果你的家庭关系比较紧密，即耦合度较高，这就会导致你的家里人和亲戚都会对这个女朋友有一些评价和考量，这些因素会可能导致你和她的进展受阻；而如果情况有所变化，你是一个孤儿，那自然不会有这些因素来干预你和她的交往进展，这就是解耦合

依赖：类a中使用了类b的属性或者方法，那么我们成类a依赖类b

spring可以管理依赖

题外话，框架怎么学：

框架的本质是一个由其他开发者编写好的软件

1.需要知道框架能做什么，比如mybatis是个框架，他用来访问操作数据库，执行CRUD

2.框架的语法，因为框架是其他开发者写的，框架需要完成功能，是需要一写步骤进行支持的，学习的内容就是如何依据自己需要的功能选取步骤

3.学习框架的内部实现（最高级），也就是框架是如何实现这些功能的，原理是什么

4.通过学习，进行框架的编写和实现，使得框架为你所用

# 2.Spring的第一个核心功能IoC（控制反转）

## 什么是Inversion of Control

是一个理论，是一个概念，是一种思想

这种想法描述的是，把对象的创建，赋值，管理工作都交给代码之外的容器实现，也就是说对象的创建由其他外部资源完成

spring是一个容器



## 控制

创建对象，对象的属性赋值，对象之间的关系管理

## 正转和反转

正转 由开发人员在代码中，使用new构造方法创建对象，开发人员主动管理对象

反转  把原来的开发人员管理，创建对象的权力，转移给代码之外的容器来实现，由容器来代替开发人员创建对象，管理对象

## 容器

可以是一个服务器，是一个软件，也可以是一个框架（例如Spring）

## 为什么要控制反转

目的就是能够减少对代码的改动，也能实现不同的功能，解耦合

java中创建对象的方式

1.构造方法   2.反射   3.序列化   4.克隆   5.IoC 容器创建 

IoC区别于其他所有的方法

IoC类似于servlet  中从来没有创建过servlet而能使用，而Servlet对象是tomcat服务器帮你创建的，tomcat也是容器，tomcat作为容器，里面存放着servlet对象，Listener对象   Filter对象

## IoC的技术实现(Dependency injection 依赖注入)

DI是IoC的技术实现，叫做依赖注入 Dependency injection

我们只需要在程序中提供要使用的对象的名称就可以了，至于对象如何在容器中创建，赋值，查找 都由容器内部实现

Spring也是使用DI实现IoC功能，spring底层创建对象使用的是反射机制

创建对象本质上我们在spring的beans配置文件中，通过bean标签告诉了spring要创建什么对象，每一行bean标签对应着一个对象

## 使用spring的步骤

1.加入依赖

2.创建类包括接口和实现类，也可以没有接口

3.创建spring的配置文件，使用bean标签声明对象

4.在项目中使用容器中的对象

通过applicationContext接口和他的ClassPathXmlApplicationContext实现类的getBean方法拿到类





## 基于xml配置文件的di



基本数据类型的分为设值注入和构造注入

如果属性中存在引用对象,自动注入和手动注入



## 基于注解的di

通过注解完成java对象创建, 属性的赋值

使用注解的步骤

1.加入maven中spring依赖 spring-context,在加入spring-context的同时

会间接的加入spring-aop依赖,使用注解必须要求aop依赖

2.在类中加入spring注解(有多个不同功能)

3.在spring的配置文件中加入一个组件扫描器的标签, 来说明注解在项目中的位置



学习的注解有以下

1.@Component 创建对象

2.@Repository 创建dao对象,访问数据库

3.@Service 创建service对象,处理逻辑,事务

4.@Controller  创建控制器对象,处理结果请求

前四个都是用于创建对象的,根据情形有所不同



5.@Value 用于对对象进行基本数据类型的赋值

6.@Autowired 对于对象的引用类型属性进行赋值

​	@Qualifier用来确定使用byName和byType

7.@Resource 和Autowired类似



## 配置文件和注解的优劣

配置文件的值和代码分离 经常修改的建议使用,劣势是代码量较大,效率低,由于分离导致可读性不高

注解编写较快 , 浏览代码时较为直观,可读性高 在代码块中还有书写提示, 但劣势是注解嵌入在源代码中,代码会显得结构混乱,在修改时需要重新修改源代码和重新编译,不利于修改,有侵入性

注解为主,配置文件为辅



## 多配置文件策略

多配置文件优势

​	1)每个文件会比较小,效率较高

​	2)避免多人竞争带来的冲突

如果项目有多个模块(相关的功能组合), 我们会使用一个模块一个配置文件的策略, 就可以根据开发人员的分工进行配置文件的分配,以免出现竞争和混用

分配方式有按模块 , 按类, 例如数据库相关的一个配置文件, 事务相关的一个配置文件, service相关的一个配置文件

# 3.Spring的第二个核心功能AOP

## 动态代理

jdk 动态代理,使用jdk中的proxy method Invocationhandler

cglib  Code Generation Library  动态代理 第三方 的工具库,创建代理对象,原理是继承 ,通过继承目标类,创建子类,子类就是代理对象,要求目标类不能是final的,方法也不能是final的

## 动态代理的作用

1.可以在目标类源代码不改动的情况下增加功能

2.减少代码的重复冗余

3.使得开发人员专注于业务逻辑

4.解耦合,让业务功能和非业务功能分离



## 什么是Aspect Orient Programming(面向切面编程)

本质是规范化的动态代理,把动态代理使用 的步骤和方式定义好了,让开发人员用一种统一的方式去用动态代理



Aspect 给目标类额外增加的功能就是切面,日志,事务,都是切面

​			切面的特点是: 一般都是非业务方法,一般是独立使用的

怎么理解面向切面编程: 

1.需要在分析项目功能时, 找出切面

2.合理地安排切面的执行时间  目标方法前还是后

3.合理地安排切面执行的位置, 在哪个类,哪个方法增加增强功能

## 术语

Aspect 切面  表示增强的功能, 就是一堆代码, 用以完成某一个功能,一般是非业务功能, 常见的切面功能有日志,事务,统计信息,参数检查, 权限验证

JoinPoint 连接点, 连接业务方法和切面的位置,实际上是某个类中的业务方法

Pointcut 切入点 指多个连接点方法的集合, 是多个方法,这些方法都要加入切面的功能呢

目标对象  给哪个类的方法增加功能,这个类就是目标对象

Advice 通知,用来表示切面的功能执行的时间





一个切面有三个关键的要素

1.切面的功能代码  干什么

2.切面的执行位置 Pointcut 在哪干

3.切面的执行时间  Advice 什么时候干,在目标方法之前还是之后

aop的实现

是规范,是动态代理的规范化和标准

技术实现框架:

​		spring内部实现了aop规范,能做aop的工作,spring主要在事务处理时使用aop,这是spring框架自己实现的,我们开发很少用,因为spring的aop比较笨重

​		aspectJ  开源的专门做aop的框架, 业内权威, 实际开发都用, spring中集成了aspectJ框架,通过spring就能使用aspectJ的功能

有两种方式

1.使用xml配置文件 配置全局事务时会使用

2.使用注解,项目中一般都使用注解,aspectJ有五个主要的注解

## aspectJ框架的使用

1.切面的执行时间,这个执行时间在规范中叫做通知Advice也叫做增强

在aspectJ框架中使用注解表示的,也可以使用xml配置文件中的标签

@Before 前置通知,在目标方法之前

@AfterReturning 后置通知

@Around环绕通知,最强大

@AfterThrowing异常通知,抛出异常时执行

@After最终通知,无论如何,总是会被执行

2.表示切面执行的位置,使用的是切入点表达式.

## 什么时候使用AOP

1.当你要给一个系统中存在的类修改功能,但原有类的功能不完善,但是不能修改源代码,就需要aop增加功能呢

2.你要给项目中的多个类,增加一个相同的功能

3.实际开发中日志和事务一般都会使用aop



# 4.Spring和Mybatis的结合

用到的技术是IoC将Mybatis和Spring结合在一起

为什么IoC可以,因为IoC能创建对象,我们可以把mybatis框架中的对象交给Spring统一创建,然后开发人员从Spring中获取对象

就不用同时面对两个或多个框架了,只需要面对spring即可,开发难度就降低了

会使用独立的连接池类,替换mybatis,把连接池交给spring



## 需要spring创建的对象

1.独立的连接池对象,使用阿里的druid连接池

2.使用SqlSessionFactoryBean创建SqlSessionFactoryBean

3.dao对象

需要学习的就是上述三个的创建语法,使用xml的bean标签.因为没有源代码所以不能使用注解

# 5.Spring的事务处理

**什么是事务**

mysql时,事务是一组sql语句的集合,集合 中有多条sql语句,可能是insert可能是update可能是select也可能是delete,我们希望这些多个sql语句都能成功,或者都失败,这些sql语句的执行是一致的,作为整体执行

**什么时候会想到事务**

当我们的操作涉及到多个表,或者多条sql语句的CRUD行为,需要保证这些语句都成功或者都失败才能完成功能

在java代码中写程序来控制事务,事务应该放在哪里呢?

应该放在service类的业务方法上的,因为业务会调用多个dao方法执行多个sql语句

**通常使用jdbc和mybatis访问数据库,怎么处理事务**

,commit和.rollback

**上一个问题中事务处理方式有什么不足**

1.不同的数据库访问技术,处理事务的对象,方法都不同,需要了解不同数据库访问技术和使用事务的原理

2.掌握多种数据库中事务的处理逻辑,什么时候提交,什么时候回滚

3.处理事务的多种方式

多种数据库的访问技术和不同事务处理的机制和方法

**如何解决**

1.spring提供了一种处理事务的统一模型,可以统一的处理多种事务,能使用统一的步骤和方式完成多种不同数据库访问技术的事务处理

使用spring的事务处理机制可以完成多种不同数据库的事务处理机制

声明式事务 把事务相关的资源提供给spring 就可以处理事务提交

**处理事务需要怎么做,做什么**

spring处理事务的模型和步骤是固定的,把事务信息提供给spring就行了

1. 事务内部提交和回滚使用事务管理器对象,事务管理器是一个接口和它的众多实现类

   接口叫PlatformTransctionManager,定义了方法能commit和rollback

   spring把每一种数据库访问事务技术都创建了一个处理类

   mybatis  创建了一个DataSourceTranscationManager

   怎么使用:告诉spring 使用哪种数据库访问技术

   声明对应的管理器实现类,在配置 文件中

   使用mybatis就该在xml中声明

   ```
   <bean id="xxx" class="...DataSourceTranscationManager">
   ```

2. 业务方法需要什么样的事务,说明需要事务的类型.

   说明方法需要的事务,事务定义接口TransctionDefinition

   1.隔离级别   有四级 以ISOLATION为开头

   ISOLATION_DEFAULT mysql默认的值为可重复读

   ISOLATION_READ_UNCOMMIT 读未提交

   ISOLATION_READ_COMMIT	读已提交

   ISOLATION_REPEATABLE  可重复读

   ISOLATION_SERIALIZABLE 串行化

   

   2.事务的超时时间,表示一个方法的最长执行时间, 如果一个方法执行时超过了时间,如果超过了时间,事务会回滚,单位是秒,整数值,默认是-1,指永不限制,但数据库会有自己的超时时间

   TIMEOUT

   

   3.事务的传播行为 控制业务方法是否有事务,什么样的事务

   一共七个       表示业务方法调用时,事务在方法之间是如何使用的

   以PROPAGETION开头的

   PROPAGETION_REQUIRED默认值也是这个

   方法必须在事务中执行,存在事务就加入事务,不存在事务则创建事务

   PROPAGETION_REQUIRES_NEW

   总是新建一个事务

   PROPAGETION_SUPPORTS

   有事务情况会在事务中执行,无事务的情况下也可以

   

   以上三个较为重要

3. spring提交事务和回滚事务的时机

   1.当你的业务方法执行成功,没有异常,执行完毕后调用事务管理器提交事务

   2.当你的业务方法抛出运行时异常或者Error,调用事务管理器执行回滚

   ​	RuntimeExpection和其子类都是运行时异常

   3.非运行时异常,主要是受查异常时,提交事务,但也可以通过更改配置使得

   ​	受查异常指在写代码时必须处理的异常,比如IOExpection和SQLExpection

   

   **总结**

   1.管理事务的是事务管理器和他的实现类

   2.spring的事务机制是一个统一的模型

   ​	1.指定要使用的事务管理器实现类 <bean>

   ​	2.指定哪些类,哪些方法需要加入事务的功能

   ​	3.指定方法需要的隔离级别传播行为和超时

   你只需要告诉spring你的项目中类的信息,方法的名称,和方法的事务传播行为

   

   **spring框架中对于事务的处理方案**
   
   **中小项目使用的:注解方案**
   
   ​	spring框架自己用aop实现给业务方法增加事务的功能,使用@Transactional注解,这是spring框架提供的,放在public上方,表示具有事务,可以给注解的属性赋值,表示具体的隔离级别,传播行为和异常信息等
   
   propagation 默认是REQUIRED
   
   isolation 默认是default
   
   readOnly 设置方法对于数据库是否是只读的,属性为boolean
   
   timeout 超时时间
   
   rollbackFor 指定需要回滚的异常类,类型是Class[],默认为空
   
   rollbackForClassName 和上面一样类型是string[],默认为空数组
   
   使用@Transactional的步骤
   
   ​	1.声明事务管理器对象
   
   ​		<bean id="xx" class="DataSourceTransactionManager">
   
   ​	2.开启事务注解驱动,告诉spring,要使用注解管理事务
   
   ​	spring会使用aop,创建@Transactional所在的类代理对象,给方法加入事务
   
   ​	spring给业务方法加入事务,在你的业务方法执行之前,,先开启事务,在业务	方法 之后提交或回滚,使用的是aop环绕通知@Around
   
   ​	3.在方法上面加入注解

**大型项目使用的:注解方案**

有很多的类,和方法,需要大量的配置事务,需要aspectj的框架功能,在spring配置文件中声明类,方法需要的事务,这种方法业务方法和事务完全分离.

实现步骤,都是在xml配置文件中实现

1.要使用的是aspectj框架,首先需要依赖

2.声明事务管理器对象

3.声明方法需要的事务类型(配置方法的事务属性 [ 隔离级别, 传播行为, 超时 ] )

4.配置aop,指定哪些类需要创建代理



# 6.WEB项目中使用容器对象

之前是javase项目,存在main方法,执行代码是执行main方法,在main里面创建ApplicationContext ctx = new ClassPathXmlApplicationContext(config);



web项目是在tomcat服务器上运行的,tomcat启动时,项目是一直运行的



web项目该怎么做

需求

web项目中容器只需要创建一次就够了

把容器对象放入到全局作用域中就可以使得容器在多个servlet中公用

使用监听器,当全局作用域对象被创建时,创建容器并存入ServletContext

1.创建容器对象执行ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

2.把容器对象放入全局作用域

监听器可以自己创建,也可以使用写好了ContextLoaderListener

javase项目中使用的是ApplicationContext

javaweb项目中使用的是WebApplicationContext

两个之间是继承关系

把spring自带监听器创建好的容器对象放到全局作用域

key=WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE

value = this.context

```
getServletContext().getAttribute(key);

```

Spring为我们准备好了直接通过工具类调用容器的方法

```java
WebApplicationContext ctx = null;
ServletContext sc = getServletContext();
//getRequiredWebApplicationContext这个方法会直接返回容器
//直接把他赋给ctx就行
ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
```

这样我们就直接可以获得ctx作为在全局作用域中的容器
