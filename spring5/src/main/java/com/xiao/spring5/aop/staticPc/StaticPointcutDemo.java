package com.study.aop.staticPc;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class StaticPointcutDemo {

	public static void main(String[] args) {
		GoodGuitarist johnmayer = new GoodGuitarist();
		GreatGuitarist capton = new GreatGuitarist();

		Singer proxyOne;
		Singer proxyTwo;
		SimpleStaticPointcut pc = new SimpleStaticPointcut();//pointcut
		SimpleAdvice advice = new SimpleAdvice();
		DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pc, advice);// a wrapper class of advice

		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(johnmayer);
		proxyFactory.addAdvisor(advisor);
		proxyOne = (Singer) proxyFactory.getProxy();

		proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(capton);
		proxyFactory.addAdvisor(advisor);
		proxyTwo = (Singer) proxyFactory.getProxy();

		proxyOne.sing();
		proxyTwo.sing();

	}
}
