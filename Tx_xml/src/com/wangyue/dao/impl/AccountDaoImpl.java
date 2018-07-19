package com.wangyue.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import com.wangyue.dao.IAccountDao;
import com.wangyue.domain.Account;

public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {
	

	@Override
	public Account findAccountById(Integer accountId) {
		List<Account> list = getJdbcTemplate().query("select * from account where id=?",new BeanPropertyRowMapper<Account>(Account.class),accountId);
		return list.isEmpty()?null:list.get(0);
	}

	@Override
	public Account findAccountByName(String name) {
		List<Account> list = getJdbcTemplate().query("select * from account where name=?",new BeanPropertyRowMapper<Account>(Account.class),name);
		if(list.isEmpty()){
			System.out.println("没有这个账户");
		}
		if(list.size()>1){
			throw new RuntimeException("结果集不唯一，请检查数据");
		}
		return list.get(0);
	}

	@Override
	public void updateAccount(Account account) {
		getJdbcTemplate().update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());

	}

}
