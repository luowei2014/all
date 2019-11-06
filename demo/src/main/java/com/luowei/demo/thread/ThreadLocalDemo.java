package com.luowei.demo.thread;

public class ThreadLocalDemo {
    private ThreadLocal<Integer> threadLocal=new ThreadLocal<>();

    public void  start(){
        for (int i =0 ;i<20;i++){
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    threadLocal.set(finalI);
                    System.out.println(threadLocal.get());
                    threadLocal.remove();
                }
            }).start();
        }
    }
}
