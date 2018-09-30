package com.hlx07.two;

public class Student {
	private int stuNo;
	private String stuName;

	public Student(int stuNo, String stuName) {
		this.stuNo = stuNo;
		this.stuName = stuName;
	}
	
	private void sayName() {
		System.out.println("我是私有方法，学生的学号是："+this.stuNo+"，学生的姓名是："+this.stuName);
	}
}






















