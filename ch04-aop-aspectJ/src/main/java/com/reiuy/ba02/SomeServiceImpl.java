package com.reiuy.ba02;


public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name,Integer age) {
        //给doSome方法增加一个功能
        //在doSome执行之前输出执行方法的时间

        System.out.println("目标方法doSome");
    }

    @Override
    public String doOther(String name, Integer age) {
        System.out.println("目标方法doOther");
        return "abc";
    }
}
