package com.reiuy.ba01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

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

    /**
     *
     *前置通知定义方法,方法是用来实现切面功能的
     * 方法的定义要求
     *  1.必须是一个公共方法
     *  2.没有返回值
     *  3.方法名称自定义
     *  4.可以有参数 也可以无参数
     *      如果有,参数不是自定义的,有几个参数类型可以使用
     */

    /**
     * 加入一个@Before 前置通知注解
     * 属性是value,是切入点表达式,表示切面的功能执行位置
     *
     * 位置是在方法的上面
     *
     * 特点
     *  1.在目标方法之前先执行
     *  2.不会改变目标方法的执行结果
     *  3.不会影响目标方法的执行
     *
     * 通知方法中有一个JoinPoint参数
     * JoinPoint 业务方法,要加入切面功能的业务方法
     * 作用是可以在通知方法中获得方法执行时的信息
     * 如果你的切面功能中需要用到方法信息,就可以加入JoinPoint
     * 参数的值由框架赋予的,必须是第一个位置的参数
     */
    //@Before(value = "execution(public void com.reiuy.ba01.SomeServiceImpl.doSome(String,Integer))")
                   //execution(访问权限修饰符 返回类型 全限定包名.类名.方法名(参数类型))
                   //原则上讲,只有返回值类型和方法名及参数是不可缺少的
                    //*代表任意长的字符串
                    // ..用在方法参数后,表示任意多个参数
                    //   用在包名后,表示当前包和其子包路径
    //同一个业务也可以加入多个通知

    @Before("execution(* *..SomeServiceImpl.doSome(..))")
    public void myBefore(JoinPoint joinPoint){
        //获取方法的完整定义
        System.out.println("方法的签名(就是定义) = "+joinPoint.getSignature());
        System.out.println("方法的名称 = "+joinPoint.getSignature().getName());

        //获取实参,实参是储存在数组中的
        Object args[] = joinPoint.getArgs();
        for (Object arg:args){
            System.out.println("实参 = "+arg);
        }
        //切面要执行的功能代码
        System.out.println("前置通知,切面功能,在目标方法输出之前执行时间:"+ new Date());
    }



}
