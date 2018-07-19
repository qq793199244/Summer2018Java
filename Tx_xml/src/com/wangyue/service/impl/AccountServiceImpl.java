package com.wangyue.service.impl;

import com.wangyue.dao.IAccountDao;
import com.wangyue.domain.Account;
import com.wangyue.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
	
	private IAccountDao accountDao;

	public void setAccountDao(IAccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void transfer(String sourceName, String targetName, Float money) {
		Account source = accountDao.findAccountByName(sourceName);
		Account target = accountDao.findAccountByName(targetName);
		
		source.setMoney(source.getMoney()-money);
		target.setMoney(target.getMoney()+money);
		
		accountDao.updateAccount(source);
		//int i =1/0;
		accountDao.updateAccount(target);

	}

	@Override
	public Account findAccountById(Integer accountId) {
		
		return accountDao.findAccountById(accountId);
	}

}
