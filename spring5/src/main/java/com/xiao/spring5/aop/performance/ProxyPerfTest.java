package com.study.aop.performance;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class ProxyPerfTest {
    public static void main(String[] args) {
        SimpleBean target = new DefaultSimpleBean();
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(new TestPointcut(), new NoOpBeforeAdvice());
        runCGLibTests(advisor, target);
        runCGLibFrozenTests(advisor, target);
        runJdkTests(advisor, target);
    }

    private static void runCGLibTests(Advisor advisor, SimpleBean target) {
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvisor(advisor);
        factory.setProxyTargetClass(true);

        SimpleBean proxy = (SimpleBean) factory.getProxy();
        System.out.println("Running CGLib (Standard)Tests");
        test(proxy);
    }

    private static void runCGLibFrozenTests(Advisor advisor, SimpleBean target) {
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvisor(advisor);
        factory.setProxyTargetClass(true);
        factory.setFrozen(true);

        SimpleBean proxy = (SimpleBean) factory.getProxy();
        System.out.println("Running CGLib(FROZEN) (Standard)Tests");
        test(proxy);
    }

    private static void runJdkTests(Advisor advisor, SimpleBean target) {
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvisor(advisor);
        factory.setInterfaces(SimpleBean.class);

        SimpleBean proxy = (SimpleBean) factory.getProxy();
        System.out.println("Running JDK (Standard)Tests");
        test(proxy);
    }

    private static void test(SimpleBean bean) {
        long before = 0;
        long after = 0;
        System.out.println("Testing Adviced Method");
        before = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            bean.advised();
        }
        after = System.currentTimeMillis();

        System.out.println("Took " + (after - before) + " ms");

        System.out.println("Testing Unadvice Method");
        before = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            bean.unadvised();
        }
        after = System.currentTimeMillis();
        System.out.println("Took " + (after - before) + " ms");
    }
}
