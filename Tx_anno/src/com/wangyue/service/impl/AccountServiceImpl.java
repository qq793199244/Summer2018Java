package com.wangyue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wangyue.dao.IAccountDao;
import com.wangyue.domain.Account;
import com.wangyue.service.IAccountService;


@Service("accountService")
@Transactional(propagation=Propagation.REQUIRED,readOnly=false) //¶ÁÐ´ÐÍ
//@Transactional(propagation=Propagation.SUPPORTS,readOnly=true) //Ö»¶ÁÐÍ

public class AccountServiceImpl implements IAccountService {
	
	@Autowired
	private IAccountDao accountDao;

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
