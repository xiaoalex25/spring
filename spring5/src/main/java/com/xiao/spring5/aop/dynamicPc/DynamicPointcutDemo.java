package com.study.aop.dynamicPc;

import com.study.aop.staticPc.SimpleAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class DynamicPointcutDemo {
	public static void main(String[] args) {
		SimpleBean target = new SimpleBean();
		DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(new SimpleDynamicPointcut(), new SimpleAdvice());
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(target);
		proxyFactory.addAdvisor(advisor);
		SimpleBean proxy = (SimpleBean) proxyFactory.getProxy();

		proxy.foo(1);
		proxy.foo(100);
		proxy.foo(1000);

		proxy.bar();
		proxy.bar();
		proxy.bar();
	}
}
