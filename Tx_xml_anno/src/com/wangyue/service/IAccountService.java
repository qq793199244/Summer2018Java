package com.wangyue.service;

import com.wangyue.domain.Account;

/**
 * 账户的业务层接口
 * @author WY
 *
 */
public interface IAccountService {
	
	Account findAccountById(Integer accountId);
	
	void transfer(String sourceName,String tragetName,Float money);

}
