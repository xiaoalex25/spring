package com.study.aop.dynamicPc;

public class SimpleBean {

	public void foo(int x) {
		System.out.println("Invoked foo with:" + x);
	}

	public void bar() {
		System.out.println("Invoked bar()");
	}
}
