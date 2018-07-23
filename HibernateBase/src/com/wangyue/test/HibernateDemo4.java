package com.wangyue.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.junit.Test;

import com.wangyue.utils.HibernateUtil;

/**
 * ��֤���ӳ��Ƿ����óɹ�
 * @author WY
 *
 */
public class HibernateDemo4 {
	/**
	 * Hibernate�����ʹ��ԭʼJDBC API
	 * JDBC��API
	 *    Connection  Statement PreparedStatement ResultSet
	 */
	@Test
	public void test1(){
		//1.��ȡsession����
		Session s = HibernateUtil.openSession();
		//2.����doWork����
		s.doWork(new Work() {
			
			@Override
			public void execute(Connection conn) throws SQLException {
				System.out.println(conn.getClass().getName());
				
			}
		});
	}
}
