package com.reiuy.ba05;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Date;

/**
 * @Aspect 这是aspectJ框架中的注解,
 *          作用:用来表示当前类是切面类
 *              切面类是用来给业务方法增加功能的类
 *              这个类中有切面的功能代码
 *          位置:在类定义的上方
 */

@Aspect
public class MyAspect {


    @Before(value = "mypc()")
    public  void myBefore(){
        System.out.println("前置通知,模拟生成时间戳"+new Date());
    }

    @After(value = "mypc()")
    public  void myAfter(){
        System.out.println("最终通知,无论如何都会执行");
    }

    /**
     * @Pointcut
     * 项目中如果有多个切入点表达式是重复的,被复用的,就可以使用该标签
     *
     * 属性: value 切入点表达式
     *
     * 位置:在自定义的方法的上方,
     *
     * 特点
     *      当我们使用Pointcut定义在了一个方法的上方,此时这个方法的名称
     *      就是该切入点表达式的别名,其他的通知中value就可以使用这个方法
     *      的名称代表表达式
     */

    @Pointcut(value = "execution(* *..SomeServiceImpl.doSome(..))")
    //此时mypc就代表了这个表达式
    private void mypc(){
        //不需要代码.只需要命名,这个方法一般是私有的
    }



}
