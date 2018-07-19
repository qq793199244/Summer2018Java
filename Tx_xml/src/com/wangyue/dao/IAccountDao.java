package com.wangyue.dao;

import com.wangyue.domain.Account;

/**
 * 账户的持久层接口
 * @author WY
 */
public interface IAccountDao {
	
	
	/**
	 * 根据id查询账户信息
	 * @param accountId
	 * @return
	 */
	Account findAccountById(Integer accountId);
	
	/**
	 * 根据名称查询账户信息
	 * @param accountName
	 * @return  要求：账户名称必须唯一，若不唯一，应该抛出异常
	 */
	Account findAccountByName(String accountName);
	
	/**
	 * 更新账户信息
	 * @param account
	 */
	void updateAccount(Account account);

}
