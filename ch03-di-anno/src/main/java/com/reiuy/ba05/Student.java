package com.reiuy.ba05;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;


@Component("myStudent")

public class Student {
    //@Value(value = "马哲")
    //@Value("马哲")


    //同样的也可以在注解中使用${}
    @Value("${myName}")
    private String name;


    //@Value(value = "20")
    //@Value("20")
    @Value("${myAge}")
    private Integer age;


    /**
     *引用类型
     * @Resource: 是来自于jdk的注解,spring框架提供了对这个注解的功能支持
     *             可以使用它给引用类型赋值,使用的也是自动注入
     *             支持byName,byType ,默认byName
     *             和@AutoWired类似
     *
     *     位置:  属性定义的上方,无需set方法,推荐
     *           set方法的上方
     *
     *      默认是byName自动注入,如果失败会使用byType
     *      如果只使用byName,需要增加一个属性叫name
     *      name的值是bean的id
     */
    //@Resource
    @Resource(name = "mySchool")
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

