package com.reiuy;

import com.reiuy.ba02.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest02 {
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //从容器中获取目标对象

        SomeService proxy = (SomeService) ac.getBean("someService");
        String str = proxy.doOther("张三",20);
        System.out.println("str = "+str);
    }
}
