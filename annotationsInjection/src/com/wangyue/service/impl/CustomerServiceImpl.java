package com.wangyue.service.impl;


import org.springframework.stereotype.Component;

import com.wangyue.dao.ICustomerDao;
import com.wangyue.service.ICustomerService;

@Component
public class CustomerServiceImpl implements ICustomerService {

	private ICustomerDao customerDao = null;
	
	public void setCustomerDao(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void saveCustomer() {
		System.out.println("业务层调用持久层");
		customerDao.saveCustomer();

	}

}
