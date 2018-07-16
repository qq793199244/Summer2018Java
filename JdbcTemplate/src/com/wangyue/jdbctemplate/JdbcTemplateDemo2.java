package com.wangyue.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTemplate������
 * @author WY
 *
 */
public class JdbcTemplateDemo2 {

	public static void main(String[] args) {
		//1.��ȡ����
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		//2.��id��ȡbean����
		JdbcTemplate jt = (JdbcTemplate) ac.getBean("jdbcTemplate");
		//3.ִ�в���
		jt.execute("insert into account(name,money)values('eee',2345)");
		
		
		
//-------------------------------------------------------------------------------
//		//��������Դ
//		DriverManagerDataSource ds = new DriverManagerDataSource();
//		ds.setDriverClassName("com.mysql.jdbc.Driver");
//		ds.setUrl("jdbc:mysql://localhost:3306/jdbctemplate");
//		ds.setUsername("root");
//		ds.setPassword("root");
//		
//		
//		//1.��ȡ����
//		//JdbcTemplate jt = new JdbcTemplate(ds);
//		JdbcTemplate jt = new JdbcTemplate();
//		jt.setDataSource(ds);
//		//2.ִ�в���
//		jt.execute("insert into account(name,money)values('ddd',1234)");

	}

}
