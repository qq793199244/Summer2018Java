package com.wangyue.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangyue.service.Person;

public class Test {

	public static void main(String[] args) {
		//1.����spring����
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		//2.��ȡidΪperson��bean
		Person p = (Person) ac.getBean("person");
		//����useAxe()����
		p.useAxe();
	}

}
