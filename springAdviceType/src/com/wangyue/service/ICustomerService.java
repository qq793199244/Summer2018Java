package com.wangyue.service;

/**
 * ģ��һ���ͻ���ҵ���ӿ�
 * @author WY
 *
 */

public interface ICustomerService {
	
	/**
	 * ����ͻ�
	 */
	void saveCustomer();
	
	/**
	 * ���¿ͻ�
	 * @param i
	 */
	void updateCustomer(int i);
	
	/**
	 * ɾ���ͻ�
	 * @return
	 */
	int deleteCustomer();

}
