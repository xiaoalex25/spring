package com.study.ioc.annotaion;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class HelloWorldMeesageRender {

    private MessageRender messageRender;

    public HelloWorldMeesageRender(MessageRender messageRender) {
        this.messageRender = messageRender;
    }

    @PostConstruct
    public void initMethod() {
        System.out.println("实例化helloWorldMessageRender的初始化方法");
    }

    @PreDestroy
    public void destroyMethod() {
        System.out.println("销毁helloWorldMessageRender前执行的方法");
    }

    /**
     * 落后于@PostConstruct
     */
    public void init() {
        System.out.println("@Bean中声明的初始化方法");
    }

    public void destroy() {
        System.out.println("@Bean声明的destroy方法");
    }
}
