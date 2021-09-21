package com.reiuy;

import com.reiuy.service.SomeService;
import com.reiuy.service.impl.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest {
    @Test
    //这种方式就是正转方式
    public void test01(){
        SomeService service = new SomeServiceImpl();
        service.doSome();
    }


    /**
     * spring创建对象的时间 ：在创建spring的容器时，会创建配置文件中所有的对象
     * spring创建对象默认调用的是无参数构造方法
     */

    @Test
    public void test02(){
        //使用spring容器创建的对象
        //1.指定spring配置文件的名称
        String config = "beans.xml";

        //2.创建表示spring容器的对象，ApplicationContext
        //这个ApplicationContext就表示Spring容器，通过这个容器对象就能获取对象了
        //ClassPathXmlApplicationContext表示从类路径（编译后的classes）中加载spring的配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //从容器中获取某个对象,调用对象的方法
        //getBean("")中的值是配置文件中bean的id值
        //需要把返回object转换为需要的类
        //此处的service就是spring帮你创建的
        SomeService service = (SomeService) ac.getBean("someService");

        //使用spring创建好的对象
        service.doSome();

    }


    /**
     * 获取spring容器中java对象的信息
     */
    @Test
    public void  test03(){
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //使用spring提供的方法来获得容器中定义的对象的数量
        int nums = ac.getBeanDefinitionCount();
        System.out.println("在spring中定义了"+nums+"个对象");

        //容器中定义的每个对象的名称
        String names[] = ac.getBeanDefinitionNames();
        for (String name:names){
            System.out.println("容器中的对象叫做"+name);
        }
    }


    /**
     * 获取创建的非自定义类的对象
     */
    @Test
    public void test04(){
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        Date my = (Date)ac.getBean("mydate");
        System.out.println("Date:"+my);
    }


}
