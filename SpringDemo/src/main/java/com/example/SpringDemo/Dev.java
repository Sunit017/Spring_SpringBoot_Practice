package com.example.SpringDemo;

public class Dev {

//	private int age;
//	private Laptop laptop;

	private Computer com;

	public Computer getCom() {
		return com;
	}

	public void setCom(Computer com) {
		this.com = com;
	}

	public Dev()
	{

	}

//	public Dev(Laptop laptop) {
//		this.laptop = laptop;
//	}

//	public Laptop getLaptop() {
//		return laptop;
//	}
//
//	public void setLaptop(Laptop laptop) {
//		this.laptop = laptop;
//	}

//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//
//	public Dev(int age) {
//		this.age = age;
//	}

	public void work()
	{
		System.out.println("Developers are working");
		com.compile();
	}
}
