package com.hlx07.one;
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
			stu = new Student(10000+i, "���ݳ���ѧԺ"+i, score);
			stuList.add(stu);
		}
		
		/*
		 * ʹ�ù�����
		 */
		ReadList rl = new ReadList(stuList);
		rl.printList();
	}
}






