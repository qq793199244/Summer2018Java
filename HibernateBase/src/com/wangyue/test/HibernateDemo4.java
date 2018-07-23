package com.wangyue.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.junit.Test;

import com.wangyue.utils.HibernateUtil;

/**
 * 验证连接池是否配置成功
 * @author WY
 *
 */
public class HibernateDemo4 {
	/**
	 * Hibernate中如何使用原始JDBC API
	 * JDBC的API
	 *    Connection  Statement PreparedStatement ResultSet
	 */
	@Test
	public void test1(){
		//1.获取session对象
		Session s = HibernateUtil.openSession();
		//2.调用doWork方法
		s.doWork(new Work() {
			
			@Override
			public void execute(Connection conn) throws SQLException {
				System.out.println(conn.getClass().getName());
				
			}
		});
	}
}
