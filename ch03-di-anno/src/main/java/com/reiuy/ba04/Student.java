package com.reiuy.ba04;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



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
     *
     *  属性 required 是一个boolean类型,默认true
     *       required=true 表示如果引用类型赋值失败,程序报错并终止
     *       required=false 表示如果引用类型赋值失败,则赋null 程序正常执行,
     *       实际开发中更多情况下为true,易于暴露错误和进行调试解决
     *
     *
     *   位置:1.在属性定义的上面,无需set方法,推荐
     *       2.在set方法上面,无需使用
     *  如果需要使用byName方式,需要做的是
     *  1.在属性的上面加入@Autowired
     *  2.在属性的上面加入@Qualifier(value="bean的id") 当然value是可省略的
     *   表示使用指定名称的bean来完成赋值
     *   注意 @Autowired 和 @Qualifier两个注解没有严格的前后关系
     *          但是习惯上是先auto在qua
     */

    @Autowired
    @Qualifier("mySchool")
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

