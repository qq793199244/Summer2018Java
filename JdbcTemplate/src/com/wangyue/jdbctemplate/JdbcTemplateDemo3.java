package com.wangyue.jdbctemplate;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.wangyue.domain.Account;

/**
 * JdbcTemplate的入门
 * @author WY
 *
 */
public class JdbcTemplateDemo3 {

	public static void main(String[] args) {
		//1.获取容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		//2.跟id获取bean对象
		JdbcTemplate jt = (JdbcTemplate) ac.getBean("jdbcTemplate");
		//3.执行操作		
		//保存
//		jt.update("insert into account(name,money)values(?,?)", "fff",3456);
		//更新
//		jt.update("update account set money=? where id=?", 4567,3);
		//删除
		jt.update("delete from account where id=?",5);
		//查询所有
		//RowMapper rm = null;
//		List<Account> accounts = jt.query("select * from account where money > ?",new BeanPropertyRowMapper<Account>(Account.class) , 1000);
//		for(Account account : accounts){
//			System.out.println(account);
//		}
		//查询一个
		List<Account> accounts = jt.query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class) , 1);
		System.out.println(accounts.isEmpty()?"没有结果":accounts.get(0));
		//查询返回一行一列：聚合函数的使用
		Integer count1 = jt.queryForObject("select count(*) from account where money > ?", Integer.class,1000);
		Long count2 = jt.queryForObject("select count(*) from account where money > ?", Long.class,1000);
		System.out.println(count1);
		System.out.println(count2);

	}

}
