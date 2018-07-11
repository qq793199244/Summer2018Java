package com.wangyue.ui;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.wangyue.annotations.MyTest;
import com.wangyue.test.CustomerServiceTest;

/**
 * 读取测试类注解的main函数
 * @author WY
 *
 */

public class Client {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		//1.得到测试类的字节码
		Class clazz = CustomerServiceTest.class;
		//2.获取该类的字节码中所有的方法
		Method[] ms = clazz.getMethods();
		//3.遍历方法的数组
		for(Method method : ms){
			//4.判断method上是否有注解
			boolean bl = method.isAnnotationPresent(MyTest.class);
			//System.out.println(method.getName() +"==="+ bl);
			if(bl){
				method.invoke(clazz.newInstance(), null);
			}
		}

	}

}
