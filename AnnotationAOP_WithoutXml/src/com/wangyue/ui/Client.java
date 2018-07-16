package com.wangyue.ui;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangyue.service.ICustomerService;

import config.SpringConfiguration;

public class Client {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		ICustomerService cs = (ICustomerService) ac.getBean("customerService");
		cs.saveCustomer();
//		cs.updateCustomer(1);
//		cs.deleteCustomer();

	}

}
