package com.wangyue.service;

import com.wangyue.domain.Account;

/**
 * �˻���ҵ���ӿ�
 * @author WY
 *
 */
public interface IAccountService {
	
	Account findAccountById(Integer accountId);
	
	void transfer(String sourceName,String tragetName,Float money);

}
