package com.hlx07.one;

/**
 * ѧ���࣬����ѧ������
 * @author guoqiang
 *
 */
public class Student {
	private int stuNo;
	private String stuName;
	private float score;
	
	/**
	 * ��ԭ��ʼ���캯��
	 */
	public Student() {}
	
	/**
	 * �Զ��幹�캯�������ڳ�ʼ������
	 * @param stuNo ѧ��
	 * @param stuName ѧ������
	 */
	public Student(int stuNo, String stuName, float score) {
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.score = score;
	}

	/**
	 * �˴�δдgetters and setters�� ����ԭ���Լ��²¿�
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























