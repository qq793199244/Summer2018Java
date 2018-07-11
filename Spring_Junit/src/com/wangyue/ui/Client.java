package com.wangyue.ui;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.wangyue.annotations.MyTest;
import com.wangyue.test.CustomerServiceTest;

/**
 * ��ȡ������ע���main����
 * @author WY
 *
 */

public class Client {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		//1.�õ���������ֽ���
		Class clazz = CustomerServiceTest.class;
		//2.��ȡ������ֽ��������еķ���
		Method[] ms = clazz.getMethods();
		//3.��������������
		for(Method method : ms){
			//4.�ж�method���Ƿ���ע��
			boolean bl = method.isAnnotationPresent(MyTest.class);
			//System.out.println(method.getName() +"==="+ bl);
			if(bl){
				method.invoke(clazz.newInstance(), null);
			}
		}

	}

}
