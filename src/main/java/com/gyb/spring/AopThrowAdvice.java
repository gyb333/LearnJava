package com.gyb.spring;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class AopThrowAdvice  implements ThrowsAdvice {
	
	public void afterThrowing(Exception ex) throws Throwable {
        // Do something with remote exception
		System.out.println(" afterThrowing(Exception ex) throws Throwable");
    }

    public void afterThrowing(Method m, Object[] args, Object target, Exception ex) {
        // Do something with all arguments
    	System.out.println(" Method m, Object[] args, Object target, Exception ex");
    }

}
