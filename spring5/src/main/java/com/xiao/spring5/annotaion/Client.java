package com.study.ioc.annotaion;

import com.study.Bootstrap;
import junit.framework.Assert;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 使用注解的方式实现IOC
 */
public class Client {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(Bootstrap.class);
        HelloWorldMeesageRender helloWorldMessageRender = acac.getBean("helloWorldMessageRender", HelloWorldMeesageRender.class);
        Assert.assertNotNull(helloWorldMessageRender);
    }
}
