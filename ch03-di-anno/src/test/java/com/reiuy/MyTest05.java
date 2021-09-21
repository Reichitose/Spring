package com.reiuy;

import com.reiuy.ba05.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest05 {
    @Test
    public void testComponent(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);


        //从容器中获取对象
        Student student = (Student) ac.getBean("myStudent");
        System.out.println("student = "+student);
    }
}
