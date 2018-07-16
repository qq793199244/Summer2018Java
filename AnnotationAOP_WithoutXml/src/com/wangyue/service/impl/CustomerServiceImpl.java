package com.wangyue.service.impl;

import org.springframework.stereotype.Service;

/**
 * 模拟客户业务层的实现类
 */

import com.wangyue.service.ICustomerService;
import com.wangyue.utils.Logger;

@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {

	@Override
	public void saveCustomer() {
		//new Logger().printLog();
		System.out.println("保存了客户。。");

	}

	@Override
	public void updateCustomer(int i) {
		System.out.println("更新了客户。。" + i);

	}

	@Override
	public int deleteCustomer() {
		System.out.println("删除了客户。。");
		return 0;
	}

}
