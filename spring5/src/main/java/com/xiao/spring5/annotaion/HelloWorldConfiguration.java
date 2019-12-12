package com.study.ioc.annotaion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;


@Configuration
public class HelloWorldConfiguration {

    @Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    @DependsOn("messageRender")//控制加载顺序
    public HelloWorldMeesageRender helloWorldMessageRender(MessageRender messageRender) {//需要的依赖用参数注入
        return new HelloWorldMeesageRender(messageRender);
    }

    @Bean
    public MessageRender messageRender() {
        return new MessageRender();
    }
}
