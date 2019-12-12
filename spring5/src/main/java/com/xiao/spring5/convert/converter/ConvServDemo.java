package com.study.convert.converter;

import com.study.convert.editor.Singer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class ConvServDemo {
    public static void main(String[] args) {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Singer singer = context.getBean("John", Singer.class);
        System.out.println(singer.toString());
        context.close();
    }
}
