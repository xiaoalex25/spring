package com.study.aop.introduction;

import org.springframework.aop.framework.ProxyFactory;

public class IntroductionDemo {
    public static void main(String[] args) {
        Contact target = new Contact();
        target.setName("John Mayer");

        IsModifiedAdvisor advisor = new IsModifiedAdvisor();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        pf.setOptimize(true);
        Contact proxy = (Contact) pf.getProxy();
        IsModify proxyInterface = (IsModify) proxy;

        System.out.println("Is Contact?: " + (proxy instanceof Contact));
        System.out.println("Is Ismodified?: " + (proxy instanceof IsModify));

        System.out.println("Has bean modified?: " + proxyInterface.isModify());
        proxy.setName("John Mayer");
        System.out.println("Has bean modified?: " + proxyInterface.isModify());
        proxy.setName("Eric Clapton");
        System.out.println("Has bean modified?: " + proxyInterface.isModify());
    }
}
