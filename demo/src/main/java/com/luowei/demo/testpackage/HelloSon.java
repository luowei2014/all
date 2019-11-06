package com.luowei.demo.testpackage;

public class HelloSon extends Hello {
    @Override
    public int getI() {
        return 0;
    }

    public HelloSon(){
        super();
    }

    public void sonSay(){
        System.out.println("son");
    }
}
