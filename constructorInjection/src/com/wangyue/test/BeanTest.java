package com.wangyue.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangyue.service.Person;

public class BeanTest {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		Person p = (Person) ac.getBean("chinese");
		p.useAxe();

	}

}
