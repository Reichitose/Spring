package com.reiuy.service.impl;

import com.reiuy.service.SomeService;

public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
        System.out.println("someServiceImpl的doSome()方法被执行了");
    }
}
