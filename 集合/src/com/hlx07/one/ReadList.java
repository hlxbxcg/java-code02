package com.hlx07.one;

/**
 * 引包
 */
import java.util.*;
import java.lang.*;
import java.lang.reflect.*;

/**
 * 读取任意的集合
 * @author guoqiang
 * @date 2017/12/12
 */
public class ReadList {
	List<?> listSet = null;
	
	/**
	 * 还原初始的构造函数
	 */
	public ReadList() {}
	
	/**
	 * 初始化变量
	 * @param listSet 传入的集合
	 */
	public ReadList(List<?> listSet) {
		this.listSet = listSet;
	}
	
	/**
	 * 读取list集合，并且打印
	 */
	public void printList() {
		Class clazz = listSet.get(0).getClass();	// 达到集合中具体对象的类型
		
		System.out.println("传入的集合是："+listSet.getClass());			// 输出传入具体的集合类型
		System.out.println("集合中的对象类型是：" + clazz);					// 输出集合中具体对象类型
		
		/* 遍历集合中的对象 */
		for (Object object : listSet) {
			Field[] fields = object.getClass().getDeclaredFields();
			for (Field field : fields) {
				String fieldName = field.getName();
				System.out.print(fieldName+":");
				// 如果要获取该属性的值,就要通过该属性名,拼凑出该属性的get方法名getMethodName
                // 然后反射调用.
				// 拼凑方法名
				String getMethodName = "get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
//				System.out.println(getMethodName);

					Object value = null;
					try {
						value = object.getClass().getMethod(getMethodName, new Class[] {}).invoke(object, new Object[] {});
						
						System.out.println(value);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
	}
}


