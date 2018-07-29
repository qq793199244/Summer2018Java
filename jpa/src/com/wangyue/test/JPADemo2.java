package com.wangyue.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.junit.Test;

import com.wangyue.utils.JPAUtil;

/**
 * JPA��ʹ��C3P0���ӳ�
 * @author WY
 *
 */
public class JPADemo2 {
	
	/**
	 * ��֤c3p0���ӳ��Ƿ����óɹ�
	 */
	@Test
	public void test1(){
		//1.��ȡjpa�еĲ�������
		EntityManager em = JPAUtil.createEntityManager();
		//2.
		Session session = em.unwrap(Session.class);
		//3.ִ��session��doWork����
		session.doWork(new Work() {
			@Override
			public void execute(Connection conn) throws SQLException {
				System.out.println(conn.getClass().getName());
			}
		});
	}
	
	//�ж��̰߳�
	@Test
	public void test2(){
		//1.��ȡjpa�еĲ�������
		EntityManager em1 = JPAUtil.createEntityManager();
		EntityManager em2 = JPAUtil.createEntityManager();
		System.out.println(em1 == em2);
	}
}
