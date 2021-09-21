package com.reiuy.ba01;


import org.springframework.stereotype.Component;

/**
 *
 * @Component 用来创建对象的 等同于<bean>的功能,使用的仍然是无参构造方法
 *          属性 value:就是对象的名称,也就是个bean的id值
 *              这个值是唯一的,创建的对象在整个spring的容器中就一个
 *
 *          位置 在类的上方,表示要创建底下这个类的对象
 *
 *   spring中和Component功能一致,可以创建对象的注解还有
 *   1.@Respository(应用于持久层的) 放在dao实现类上,表示创建dao对象,
 *                 dao对象是能访问数据库的
 *
 *   2.@Service(应用于业务层类的上面) 放在service的实现类上,
 *             表示创建service对象,service是做业务处理的,可以有事务功能
 *
 *   3.@Controller(用在控制器上面的) 放在控制器类的上面的,用来创建控制器对象
 *              控制器对象能够接受用户提交的参数,显示请求的处理结果
 *
 *   以上三个注解的使用语法和Component是一样的,都能够创建对象
 *   但是都各自有额外的功能
 *
 *   @Respository,@Service,@Controller 是给项目分层的
 *
 */


//使用value属性去指定对象名称
//@Component(value = "myStudent")


//同样因为参数只有value,故省去value(这是最常用 的方式)
@Component("myStudent")

//不指定对象名称,由spring提供默认名称,会默认使用类的首字母小写作为对象名称
//@Component

public class Student {
    private String name;
    private Integer age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
