package com.wangyue.test;

import com.wangyue.annotations.MyTest;
import com.wangyue.service.ICustomerService;
import com.wangyue.service.impl.CustomerServiceImpl;

/**
 * �ͻ�ҵ��������
 * @author WY
 *
 */

public class CustomerServiceTest {
	
	@MyTest
	public void saveCustomerTest(){
		System.out.println("���Է���ִ����");
		ICustomerService cs = new CustomerServiceImpl();
		cs.saveCustomer();
	}

}
