package com.reiuy.ba01;


public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name,Integer age) {
        //给doSome方法增加一个功能
        //在doSome执行之前输出执行方法的时间

        System.out.println("目标方法doSome");
    }
}
