package com.gyb.spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AopMethodInterceptor implements MethodInterceptor {

	
	public Object invoke(MethodInvocation arg0) throws Throwable {
		// TODO Auto-generated method stub
		 
			System.out.println("环绕 around Advice�?");
	        Object rval = arg0.proceed();
	        System.out.println("环绕  around Advice�?");
	        return rval;
		
	}

	

}
