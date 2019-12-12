package com.study.aop.staticPc;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * pointcut is used to define where to weave advisor, which class and which method
 */
public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {
	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return "sing".equals(method.getName());
	}

	@Override
	public ClassFilter getClassFilter() {
		return cls -> ( cls == GoodGuitarist.class);
	}
}
