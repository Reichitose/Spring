package com.reiuy.ba03;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 *
 * @Value 简单类型的赋值
 *          属性 value 是一个String类型的,是表示简单类型的属性值
 *              同样的可以省略
 *          位置 1.在属性定义的上面,无需set方法,推荐
 *              2.在set方法上面,不推荐
 */


@Component("myStudent")

public class Student {
    //@Value(value = "马哲")
    @Value("马哲")
    private String name;


    //@Value(value = "20")
    @Value("20")
    private Integer age;


    /**引用类型
     * @Autowired  spring框架提供注解,实现引用类型的赋值
     * spring中通过注解给引用类型赋值,使用的是自动注入原理
     * 支持byName byType   默认使用byType自动注入
     *
     *   位置:1.在属性定义的上面,无需set方法,推荐
     *       2.在set方法上面,无需使用
     *
     *
     */

    @Autowired
    private School school;


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}

