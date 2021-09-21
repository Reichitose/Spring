package com.reiuy.ba02;


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


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
