package com.test;

import org.testng.annotations.Test;

public class InvocationCountTest {

	@Test(invocationCount = 5,invocationTimeOut = 2)
	public void sum() {
		while(true) {
		int a=4;
		int b=6;
		int sum=a+b;
		System.out.println(sum);
	}
		}
}
