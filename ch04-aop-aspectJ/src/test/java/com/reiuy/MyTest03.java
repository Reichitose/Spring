package com.reiuy;

import com.reiuy.ba03.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest03 {
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //从容器中获取目标对象

        SomeService proxy = (SomeService) ac.getBean("someService");
        String str = proxy.doFirst("张三",20);
        //如果目标方法执行的结果被修改了,那么此处str也会发生变化
        System.out.println("str = "+str);
    }
}
