package com.reiuy;

import com.reiuy.ba01.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //从容器中获取目标对象

        SomeService proxy = (SomeService) ac.getBean("someService");
        //通过代理对象执行方法,实现了目标方法的执行,增强了功能
        proxy.doSome("张三",20);
    }
}
