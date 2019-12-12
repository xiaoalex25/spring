package com.study.convert.editor;

import org.springframework.context.support.GenericXmlApplicationContext;

public class PropEditorDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("ApplicationContext.xml");
        ctx.refresh();
        Singer eric = ctx.getBean("eric",Singer.class);
        System.out.println(eric);
        Singer countrySinger = ctx.getBean("countrySinger", Singer.class);
        System.out.println(countrySinger);
        ctx.close();
    }
}
