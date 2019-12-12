package com.study.aop.annotationPc;

import com.study.aop.staticPc.SimpleAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

public class AnnotationMatchingPointcutDemo {
    public static void main(String[] args) {
        AnnotationMatchingPointcut pointcut = AnnotationMatchingPointcut.forMethodAnnotation(AdviceRequired.class);
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAdvice());
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new Guitarist());
        proxyFactory.addAdvisor(advisor);
        Guitarist proxy = (Guitarist) proxyFactory.getProxy();

        proxy.sing("i am genius");
        proxy.reset();
    }
}
