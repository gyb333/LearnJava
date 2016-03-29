package com.gyb.spring;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class AopAfterReturningAdvice implements AfterReturningAdvice {


	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("后置通知");
	}

}
