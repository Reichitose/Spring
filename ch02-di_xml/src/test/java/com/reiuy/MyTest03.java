package com.reiuy;

import com.reiuy.ba03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class MyTest03 {


    /**
     * 从容器中获取Student对象
     */
    @Test
    public void test01() {
        String config = "ba03/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //从容器中获取Student对象
        Student myStudent = (Student) ac.getBean("myStudent");
        Student myStudent2 = (Student) ac.getBean("myStudent2");
        System.out.println("student对象" + myStudent);
        System.out.println("student对象" + myStudent2);

        File myfile = (File) ac.getBean("myFile");
        System.out.println("filename is "+myfile.getName());
    }
}
