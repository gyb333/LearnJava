package com.gyb.spring;

public class AopService implements IService ,IService1{

	private String name;
	
	private int age;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	public boolean GetData() {
		// TODO Auto-generated method stub
		System.out.println("GetData");
//		int i= 9/0;
		return false;
	}


	public void SayHello() {
		// TODO Auto-generated method stub
		System.out.println("SayHello"+name+age);
	}

	public void Say() {
		// TODO Auto-generated method stub
		System.out.println("Say"+name+age);
	}

 

}
