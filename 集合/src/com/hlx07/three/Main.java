package com.hlx07.three;


import java.util.ArrayList;
import java.util.List;


import com.hlx07.two.Util;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Student stu=null;
//		List<Student> stuList=new ArrayList<Student>();
//		for(int i=0;i<5;i++){
//			float score=90f+i;
//			stu=new Student(1000+i,"lanzhou");
//			stuList.add(stu);
//		}
//		Util u=new Util();
//		u.myPringList(stuList);
		Student stu=null;
		List<Student> stuList=new ArrayList<Student>();
		for(int i=0;i<5;i++){
			float score=90f+i;
			stu=new Student(1000+i,"lanzhou");
			stuList.add(stu);
			
		}
		Util u=new Util();
		u.myPringList(stuList);

	}

}
