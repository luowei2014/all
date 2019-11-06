package com.luowei.demo.testpackage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class AnnotationBean  implements InitializingBean, DisposableBean {
    private final static Logger LOGGER = LoggerFactory.getLogger(AnnotationBean.class);

    @PostConstruct
    public void start(){
        LOGGER.info("AnnotationBean start");
    }

    @PreDestroy
    public void destroy(){
        LOGGER.info("AnnotationBean destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("SpringLifeCycleService start");
    }
}
