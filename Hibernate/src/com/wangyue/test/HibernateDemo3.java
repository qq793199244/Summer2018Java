package com.wangyue.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.wangyue.domain.Customer;
import com.wangyue.utils.HibernateUtil;

/**
 * hibernate�Ķ���״̬
 * @author WY
 *
 */

public class HibernateDemo3 {	
	/**
	 
	 */
	@Test
	public void test1(){
		Customer c = new Customer(); //˲ʱ״̬
		c.setCustName("��Խ_����״̬_���Բ鲻��");

		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		session.save(c); //�־û�״̬
//		Customer c1 = session.get(Customer.class, c.getCustId());
//		System.out.println(c1);
		tx.commit();
		session.close();//session�ر���
		
		c.setCustAddress("��ɽ��"); //�ѹ�״̬(������session�Ĺ���)
		
		Session s1 = HibernateUtil.openSession();
		Transaction tx1 = s1.beginTransaction();
		s1.update(c); //�־û�״̬
		tx1.commit();
		s1.close(); //session�ر���
		
		System.out.println(c); //�ѹ�״̬
	}
	
	/**
	 * saveOrUpdate
	 */
	@Test
	public void test2(){
		Customer c = new Customer(); //˲ʱ״̬
		c.setCustName("��Խ_saveOrUpdate");
		
		Session s1 = HibernateUtil.openSession();
		Transaction tx1 = s1.beginTransaction();
		s1.saveOrUpdate(c); //
		tx1.commit();
		s1.close(); //session�ر���

	}
	
	@Test
	public void test3(){
		Session s1 = HibernateUtil.openSession();
		Transaction tx1 = s1.beginTransaction();
		Customer c = s1.get(Customer.class, 11L);//�־û�״̬
	
		tx1.commit();
		s1.close(); //session�ر���
		
		c.setCustAddress("�ӱ�ʡ");
		System.out.println(c); //�ѹ�״̬
		
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(c); //�־û�״̬
		tx.commit();
		session.close();

	}

}
