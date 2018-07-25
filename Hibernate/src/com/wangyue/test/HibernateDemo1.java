package com.wangyue.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.wangyue.domain.Customer;
import com.wangyue.utils.HibernateUtil;

/**
 * hibernate���������ɲ���
 * @author WY
 *
 */

public class HibernateDemo1 {
	
	/**
	 
	 */
	@Test
	public void test1(){
		Customer c = new Customer();
		c.setCustName("��Խ");


		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		session.save(c);
		tx.commit();
		session.close();
		
	}

}
