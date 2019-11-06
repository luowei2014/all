package com.luowei.demo.testpackage;

public abstract class Hello {
    private int i;
    public Hello(){
        System.out.println("sss");
        i=222;
    }
    public void setI(int arg){
        this.i=arg;
    }

    public abstract int getI();
}
