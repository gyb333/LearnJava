package com.gyb.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac =  new ClassPathXmlApplicationContext("com/gyb/aop/aop.xml");
		IService is =  (IService) ac.getBean("proxyFactoryBean");
		is.GetData();
		System.out.println("*************************");
		is.Say();
		System.out.println("*************************");
		IService1 is1 = (IService1) is;
		is1.SayHello();

	}

}
