package com.study.aop.dynamicPc;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {

	/**
	 * use static matcher to check static param like method name,
	 * this method invoked only once
	 *
	 * @param method
	 * @param targetClass
	 * @return
	 */
	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		System.out.println("Static check for " + method.getName());
		return "foo".equals(method.getName());
	}

	/**
	 * use dynamic matcher to check dynamic param, this method invoked after static matcher.
	 * it may be invoked more than once, if static matching failed, this method won't be invoked.
	 *
	 * @param method      the candidate method
	 * @param targetClass the target class
	 * @param args        arguments to the method
	 * @return
	 */
	@Override
	public boolean matches(Method method, Class<?> targetClass, Object... args) {
		System.out.println("Dynamic check for " + method.getName());
		int i = ((Integer) args[0]).intValue();
		return (i != 100);
	}

	@Override
	public ClassFilter getClassFilter() {
		return cls -> (cls == SimpleBean.class);
	}
}
