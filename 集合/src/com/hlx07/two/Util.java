package com.hlx07.two;

import java.util.*;
import java.lang.reflect.*;

public class Util {
	public <T> void myPringList(List<T> listSet) {

		for (T t : listSet) {
			Field[] fields = t.getClass().getDeclaredFields();
			for (Field field : fields) {
				Method[] methods = t.getClass().getDeclaredMethods();
				
				for (Method method : methods) {
					if (Modifier.isPublic(method.getModifiers())) {
						continue;
					}
					method.setAccessible(true);
					try {
						method.invoke(t);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}

























