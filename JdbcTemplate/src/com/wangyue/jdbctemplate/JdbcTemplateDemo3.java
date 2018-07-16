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
 * JdbcTemplate������
 * @author WY
 *
 */
public class JdbcTemplateDemo3 {

	public static void main(String[] args) {
		//1.��ȡ����
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		//2.��id��ȡbean����
		JdbcTemplate jt = (JdbcTemplate) ac.getBean("jdbcTemplate");
		//3.ִ�в���		
		//����
//		jt.update("insert into account(name,money)values(?,?)", "fff",3456);
		//����
//		jt.update("update account set money=? where id=?", 4567,3);
		//ɾ��
		jt.update("delete from account where id=?",5);
		//��ѯ����
		//RowMapper rm = null;
//		List<Account> accounts = jt.query("select * from account where money > ?",new BeanPropertyRowMapper<Account>(Account.class) , 1000);
//		for(Account account : accounts){
//			System.out.println(account);
//		}
		//��ѯһ��
		List<Account> accounts = jt.query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class) , 1);
		System.out.println(accounts.isEmpty()?"û�н��":accounts.get(0));
		//��ѯ����һ��һ�У��ۺϺ�����ʹ��
		Integer count1 = jt.queryForObject("select count(*) from account where money > ?", Integer.class,1000);
		Long count2 = jt.queryForObject("select count(*) from account where money > ?", Long.class,1000);
		System.out.println(count1);
		System.out.println(count2);

	}

}
