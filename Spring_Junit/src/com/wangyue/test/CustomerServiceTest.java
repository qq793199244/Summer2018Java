package com.wangyue.test;

import com.wangyue.annotations.MyTest;
import com.wangyue.service.ICustomerService;
import com.wangyue.service.impl.CustomerServiceImpl;

/**
 * 客户业务层测试类
 * @author WY
 *
 */

public class CustomerServiceTest {
	
	@MyTest
	public void saveCustomerTest(){
		System.out.println("测试方法执行了");
		ICustomerService cs = new CustomerServiceImpl();
		cs.saveCustomer();
	}

}
