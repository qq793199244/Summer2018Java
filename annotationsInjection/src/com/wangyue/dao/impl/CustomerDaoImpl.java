package com.wangyue.dao.impl;

import com.wangyue.dao.ICustomerDao;

public class CustomerDaoImpl implements ICustomerDao {

	@Override
	public void saveCustomer() {
		System.out.println("持久层保存了客户");

	}

}
