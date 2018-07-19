package com.wangyue.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangyue.domain.Account;
import com.wangyue.service.IAccountService;

import config.SpringConfiguration;

/**
 * ≤‚ ‘¿‡
 * @author WY
 *
 */
public class Client {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		IAccountService accountService = (IAccountService) ac.getBean("accountService");
//		Account account = accountService.findAccountById(1);
//		System.out.println(account);
		accountService.transfer("ccc", "bbb", 100f);

	}

}
