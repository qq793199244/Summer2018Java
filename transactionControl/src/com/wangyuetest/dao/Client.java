package com.wangyuetest.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangyue.domain.Account;
import com.wangyue.service.IAccountService;

/**
 * ≤‚ ‘¿‡
 * @author WY
 *
 */
public class Client {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		IAccountService accountService = (IAccountService) ac.getBean("accountService");
//		Account account = accountService.findAccountById(1);
//		System.out.println(account);
		accountService.transfer("ccc", "bbb", 100f);

	}

}
