package com.wangyue.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTemplate�Ļ����÷�
 * @author WY
 *
 */
public class JdbcTemplateDemo1 {

	public static void main(String[] args) {
		//��������Դ
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/jdbctemplate");
		ds.setUsername("root");
		ds.setPassword("root");
		
		
		//1.��ȡ����
		//JdbcTemplate jt = new JdbcTemplate(ds);
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(ds);
		//2.ִ�в���
		jt.execute("insert into account(name,money)values('ddd',1234)");

	}

}
