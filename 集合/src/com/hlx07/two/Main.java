package com.hlx07.two;

/**
 * ����
 */
import java.util.*;

/**
 * ����
 * @author guoqiang
 *
 */
public class Main {
	public static void main(String[] args) {
		Student stu = null;
		List<Student> stuList = new ArrayList<Student>();
		
		/*
		 * ��������
		 */
		for (int i = 0; i < 5; i++) {
			float score = 90f+i;
			stu = new Student(10000+i, "���ݳ���ѧԺ"+i);
			stuList.add(stu);
		}
		
		/*
		 * ʹ�ù�����
		 */
		Util u = new Util();
		u.myPringList(stuList);
	}
}




















