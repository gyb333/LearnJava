package com.gyb.spring;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class AopMethodBeforeAdvice implements MethodBeforeAdvice {


	public void before(Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("前置通知");
	}	 
}
