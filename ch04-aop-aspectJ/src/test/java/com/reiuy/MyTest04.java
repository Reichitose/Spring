package com.reiuy;

import com.reiuy.ba04.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest04 {
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //从容器中获取目标对象

        SomeService proxy = (SomeService) ac.getBean("someService");
        proxy.doSecond("张三",20);

    }
}
