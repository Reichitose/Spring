package com.reiuy.ba03;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

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
     *  环绕通知定义方法,方法是用来实现切面功能的
     * 方法的定义要求
     *  1.必须是一个公共方法
     *  2.必须有一个返回值,推荐使用Obejct类型
     *  3.方法名称自定义
     *  4.方法是有参数的,参数是固定的 叫ProceedingJoinPoint
     */

    /**
     *
     * @Around 是环绕通知
     *
     * 属性 value 切入点表达式
     * 位置  在方法定义的上方
     *
     * 特点
     *      1.功能最强的通知
     *      2.在目标方法的前和后都能增强功能
     *      3.能控制目标方法是否被调用执行
     *      4.能够修改原来的目标方法的执行结果,影响最后的调用结果
     *
     *
     *      环绕通知就等同于jdk动态代理的invocationHandler
     *
     *
     *   参数 proceedingJoinPoint等同于jdk动态代理的method
     *          作用:执行目标方法
     *
     *   返回值:就是目标方法的执行结果,可以被修改
     *
     *
     *
     *   环绕通知经常做事务,在目标方法之前开启,在目标之后提交
     */
    @Around(value = "execution(* *..SomeServiceImpl.doFirst(..))")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {

        String name = "";
        //获取第一个参数值
        Object args[] = pjp.getArgs();
        if(args != null && args.length > 1){
            Object arg = args[0];
            name = (String) arg;
        }


        //实现环绕通知
        Object result = null;

        System.out.println("环绕通知:在目标方法之前输出时间:"+ new Date());
        //1.目标方法调用

        if("张三".equals(name)) {
            //根据条件控制方法的执行
            result = pjp.proceed();    //Object result = doFirst()
        }

        System.out.println("环绕通知:在目标方法之后,模拟一个提交事务");

        //2.在目标方法的前或者后添加功能


        //修改目标方法的执行结果,影响方法最后的调用结果
        if(result != null){
            result = "这是被修改后的结果";
        }

        //返回目标方法的执行结果
        return result;
    }






}
