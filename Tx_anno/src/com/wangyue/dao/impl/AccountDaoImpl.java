package com.wangyue.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.wangyue.dao.IAccountDao;
import com.wangyue.domain.Account;


@Repository("accountDao")
public class AccountDaoImpl  implements IAccountDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Account findAccountById(Integer accountId) {
		List<Account> list = jdbcTemplate.query("select * from account where id=?",new BeanPropertyRowMapper<Account>(Account.class),accountId);
		return list.isEmpty()?null:list.get(0);
	}

	@Override
	public Account findAccountByName(String name) {
		List<Account> list = jdbcTemplate.query("select * from account where name=?",new BeanPropertyRowMapper<Account>(Account.class),name);
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
		jdbcTemplate.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());

	}

}
