package com.wangyue.service.impl;

/**
 * ģ��ͻ�ҵ����ʵ����
 */

import com.wangyue.service.ICustomerService;
import com.wangyue.utils.Logger;

public class CustomerServiceImpl implements ICustomerService {

	@Override
	public void saveCustomer() {
		//new Logger().printLog();
		System.out.println("�����˿ͻ�����");

	}

	@Override
	public void updateCustomer(int i) {
		System.out.println("�����˿ͻ�����" + i);

	}

	@Override
	public int deleteCustomer() {
		System.out.println("ɾ���˿ͻ�����");
		return 0;
	}

}
