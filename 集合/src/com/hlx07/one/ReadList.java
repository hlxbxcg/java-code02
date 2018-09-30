package com.hlx07.one;

/**
 * ����
 */
import java.util.*;
import java.lang.*;
import java.lang.reflect.*;

/**
 * ��ȡ����ļ���
 * @author guoqiang
 * @date 2017/12/12
 */
public class ReadList {
	List<?> listSet = null;
	
	/**
	 * ��ԭ��ʼ�Ĺ��캯��
	 */
	public ReadList() {}
	
	/**
	 * ��ʼ������
	 * @param listSet ����ļ���
	 */
	public ReadList(List<?> listSet) {
		this.listSet = listSet;
	}
	
	/**
	 * ��ȡlist���ϣ����Ҵ�ӡ
	 */
	public void printList() {
		Class clazz = listSet.get(0).getClass();	// �ﵽ�����о�����������
		
		System.out.println("����ļ����ǣ�"+listSet.getClass());			// ����������ļ�������
		System.out.println("�����еĶ��������ǣ�" + clazz);					// ��������о����������
		
		/* ���������еĶ��� */
		for (Object object : listSet) {
			Field[] fields = object.getClass().getDeclaredFields();
			for (Field field : fields) {
				String fieldName = field.getName();
				System.out.print(fieldName+":");
				// ���Ҫ��ȡ�����Ե�ֵ,��Ҫͨ����������,ƴ�ճ������Ե�get������getMethodName
                // Ȼ�������.
				// ƴ�շ�����
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


