package com.study.aop.dynamicPc;

import com.study.aop.staticPc.GoodGuitarist;
import com.study.aop.staticPc.SimpleAdvice;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class AspectjexpPointcutDemo {
    public static void main(String[] args) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* sing*(..))");
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAdvice());

        ProxyFactory factory = new ProxyFactory();
        factory.addAdvisor(advisor);
        factory.setTarget(new GoodGuitarist());
        GoodGuitarist proxy = (GoodGuitarist) factory.getProxy();

        proxy.sing();
    }
}
