package com.luowei.demo.proxy.dynamicproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomizeHandle implements InvocationHandler {
    private final static Logger LOGGER = LoggerFactory.getLogger(CustomizeHandle.class);

    private Object target;

    public CustomizeHandle(Class clazz) {
        try {
            this.target = clazz.newInstance();
        } catch (InstantiationException e) {
            LOGGER.error("InstantiationException", e);
        } catch (IllegalAccessException e) {
            LOGGER.error("IllegalAccessException",e);
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        before();
        Object result = method.invoke(target, args);
        after();

        LOGGER.info("proxy class={}", proxy.getClass());
        return result;
    }


    private void before() {
        LOGGER.info("代理前，我打印日志");
    }

    private void after() {
        LOGGER.info("代理后，我再打印一次");
    }
}
