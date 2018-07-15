package com.wangyue.ui;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangyue.service.ICustomerService;

public class Client {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		ICustomerService cs = (ICustomerService) ac.getBean("customerService");
		cs.saveCustomer();
//		cs.updateCustomer(1);
//		cs.deleteCustomer();

	}

}
