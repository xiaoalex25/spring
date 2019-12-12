package com.study.aop.staticPc;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleAdvice implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("*******invoking method " + invocation.getMethod().getName() + "********");
		Object ret = invocation.proceed();
		System.out.println("*********done*****************");
		return ret;
	}
}
