package com.reiuy.controller;

import com.reiuy.entity.Student;
import com.reiuy.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.security.Key;

public class RegisterServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //不添加这个,会接收到乱码的数据

        String strId = request.getParameter("id");
        String strName = request.getParameter("name");
        String strEmail = request.getParameter("email");
        String strAge = request.getParameter("age");


        //创建spring容器
        //String config = "applicationContext.xml";
        //ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        WebApplicationContext ctx = null;
        //获取servlet中的容器对象,创建好了,拿来用就行;
        //String key = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
        //Object attr = getServletContext().getAttribute(key);
        //if(attr != null){
            //说明我们在全局作用域中用key找到了value
            //把attr通过转换类型赋给ctx
            //ctx = (WebApplicationContext) attr;
        //}
        //spring同时也提供了工具类,让我们更快的直接拿到容器


        ServletContext sc = getServletContext();
        //getRequiredWebApplicationContext这个方法会直接返回容器
        //直接把他赋给ctx就行
        ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);




        System.out.println("容器对象的信息===="+ctx);


        //获取serivce
        StudentService studentService = (StudentService) ctx.getBean("studentService");

        Student student = new Student();
        student.setId(Integer.parseInt(strId));
        student.setName(strName);
        student.setEmail(strEmail);
        student.setAge(Integer.parseInt(strAge));


        studentService.addStudent(student);


        //给出结果页面
        request.getRequestDispatcher("/result.jsp").forward(request,response);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
