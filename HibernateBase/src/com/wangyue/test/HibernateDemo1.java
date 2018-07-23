package com.wangyue.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.wangyue.domain.Customer;

/**
 * hibernate�����Ű���
 * ����
 * 		ʵ�ֱ���һ���ͻ������ݿ�
 * @author WY
 *
 */

public class HibernateDemo1 {
	
	/**
	 * ���������
	 * 1.�����������ļ�
	 * 2.�����������ļ�����SessionFactory����
	 * 3.����SessionFactory����session
	 * 4.��������
	 * 5.ִ�в���(����)
	 * 6.�ύ����
	 * 7.�ͷ���Դ
	 */
	@Test
	public void test1(){
		Customer c = new Customer();
		c.setCustName("��Խ");
		 // 1.�����������ļ�
		Configuration cfg = new Configuration();
		cfg.configure();
		 // 2.�����������ļ�����SessionFactory����
		SessionFactory factory = cfg.buildSessionFactory();
		 // 3.����SessionFactory����session
		Session session = factory.openSession(); 
		 // 4.��������
		Transaction tx = session.beginTransaction();
		 // 5.ִ�в���(����)
		session.save(c);
		 // 6.�ύ����
		tx.commit();
		 // 7.�ͷ���Դ
		session.close();
		factory.close();
	}

}
