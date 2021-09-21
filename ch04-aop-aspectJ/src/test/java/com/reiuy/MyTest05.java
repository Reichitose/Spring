package com.reiuy;

import com.reiuy.ba05.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest05 {
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //从容器中获取目标对象

        SomeServiceImpl proxy = (SomeServiceImpl) ac.getBean("someService");

        System.out.println("proxy : "+proxy.getClass().getName() );
        //proxy : com.reiuy.ba05.SomeServiceImpl$$EnhancerBySpringCGLIB$$5d4d6a9
        //对于没有接口的目标类,就会使用cglib动态代理,spring框架会自动应用cglib
        //有接口也可以使用cglib动态代理

        proxy.doSome();




    }
}
