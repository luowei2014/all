package com.luowei.demo.proxy.dynamicproxy;

public class ISubjectImpl implements ISubject{
    @Override
    public void execute() {
        System.out.println("实现接口的方法执行了");
    }

    @Override
    public void sayHi(String name) {
        System.out.println("hi!"+name);
    }
}
