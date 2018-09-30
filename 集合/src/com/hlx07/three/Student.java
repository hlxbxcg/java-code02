package com.hlx07.three;

public class Student {
	private int stuNo;
	private String stuName;
	public Student(int stuNo,String stuName){
		this.stuNo=stuNo;
		this.stuName=stuName;
	}
	private void sayName(){
		System.out.println("学生学号："+this.stuNo+",学生姓名"+this.stuName);
		
	}

}
