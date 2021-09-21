package com.reiuy;

import com.reiuy.dao.StudentDao;
import com.reiuy.entity.Student;
import com.reiuy.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void Test01(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        String names[] = ctx.getBeanDefinitionNames();
        for (String name:names){
            System.out.println("容器中存在对象: "+name);
        }
    }

    @Test
    public void TestServiceInsert(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        //获取spring容器中的dao对象
        StudentService studentService= (StudentService) ctx.getBean("studentService");
        Student student = new Student();
        student.setId(1010);
        student.setName("牛犇四号");
        student.setEmail("niuben4@qq.com");
        student.setAge(22);

        int num = studentService.addStudent(student);
        //spring和mybatis整合时事务会自动提交的,无需执行sqlSession.commit()
        System.out.println("有"+num+"条记录被添加");
    }


    @Test
    public void TestServiceSelect(){
        String config = "applicationContext.xml";
        ApplicationContext ctx =  new ClassPathXmlApplicationContext(config);


        StudentService studentService = (StudentService) ctx.getBean("studentService");
        List<Student> students= studentService.queryStudents();
        for(Student stu:students){
            System.out.println("学生 : "+stu);
        }

    }
}
