package com.reiuy.ba02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.sql.PreparedStatement;
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
     *后置通知定义方法,方法是用来实现切面功能的
     * 方法的定义要求
     *  1.必须是一个公共方法
     *  2.没有返回值
     *  3.方法名称自定义
     *  4.方法是有参数的,参数推荐使用Object 参数名自定义
     */

    /**
     * @AfterReturning  后置通知
     *  有两个属性
     *          1.value 切入点表达式
     *          2.returning 自定义的变量,表示目标方法的返回值
     *          自定义的变量名必须和通知方法的形参名一致
     *   位置:在方法定义的上方
     *
     *   特点
     *          1.在方法之后执行
     *          2.能获取到目标方法的返回值,可以根据这个返回值做不同的处理
     *          Object res = doOther()
     *          3.可以修改这个返回值
     *
     *
     *   后置通知的执行
     *   Object res = doOther();
     *   myAfterReturning(Object res)
     *   res传入myAfterReturning
     *
     *
     */
    @AfterReturning(value = "execution(* *..SomeServiceImpl.doOther(..))",returning = "res")
    public void myAfterReturning(Object res){

        //Object res 是目标方法执行后的返回值,根据返回值做你的切片功能处理
        System.out.println("后置通知,在目标方法之后执行,获取的返回值是"+res);
        if("abc".equals(res)){
            //一些功能
        }else{
            //其他功能
        }

        //修改返回值res不会有影响

    }






}
