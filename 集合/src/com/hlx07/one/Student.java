package com.hlx07.one;

/**
 * 学生类，定义学生属性
 * @author guoqiang
 *
 */
public class Student {
	private int stuNo;
	private String stuName;
	private float score;
	
	/**
	 * 还原初始构造函数
	 */
	public Student() {}
	
	/**
	 * 自定义构造函数，用于初始化变量
	 * @param stuNo 学号
	 * @param stuName 学生姓名
	 */
	public Student(int stuNo, String stuName, float score) {
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.score = score;
	}

	/**
	 * 此处未写getters and setters， 具体原因自己猜猜看
	 */
	public int getStuNo() {
		return stuNo;
	}

	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
}























