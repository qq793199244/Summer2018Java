package com.wangyue.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangyue.service.Person;

public class Test {

	public static void main(String[] args) {
		//1.创建spring容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		//2.获取id为person的bean
		Person p = (Person) ac.getBean("person");
		//调用useAxe()方法
		p.useAxe();
	}

}
