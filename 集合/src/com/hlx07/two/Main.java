package com.hlx07.two;

/**
 * 引包
 */
import java.util.*;

/**
 * 主类
 * @author guoqiang
 *
 */
public class Main {
	public static void main(String[] args) {
		Student stu = null;
		List<Student> stuList = new ArrayList<Student>();
		
		/*
		 * 创建集合
		 */
		for (int i = 0; i < 5; i++) {
			float score = 90f+i;
			stu = new Student(10000+i, "兰州城市学院"+i);
			stuList.add(stu);
		}
		
		/*
		 * 使用工具类
		 */
		Util u = new Util();
		u.myPringList(stuList);
	}
}




















