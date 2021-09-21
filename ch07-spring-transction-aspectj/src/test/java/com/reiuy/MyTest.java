package com.reiuy;

import com.reiuy.service.BuyGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        //从容器中获取service
        BuyGoodsService buyGoodsService = (BuyGoodsService) ctx.getBean("buyService");


        //调用方法
        buyGoodsService.buy(1001,10);
        //1001号商品,10个

    }
}
