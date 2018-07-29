package com.wangyue.test;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.wangyue.domain.Customer;
import com.wangyue.utils.HibernateUtil;

/**
 * ʹ��JPA����ӳ�� ʹ��Hibernate����
 * @author WY
 *
 */

public class HibernateDemo1 {
	
	/**
	 * ����
	 */
	@Test
	public void test1(){
		Customer c = new Customer();
		c.setCustName("hibernate jpa customer");
		
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.save(c);
		tx.commit();
	}
	
	/**
	 * ��ѯһ��
	 */
	@Test
	public void test2(){
		
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Customer c = s.get(Customer.class, 6L);
		System.out.println(c);
		tx.commit();
	}
	
	/**
	 * �޸�
	 */
	@Test
	public void test3(){
		
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Customer c = s.get(Customer.class, 6L);
		c.setCustAddress("��ɽ");
		tx.commit();
	}
	
	
	/**
	 * ɾ������
	 */
	@Test
	public void test4(){
		
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Customer c = s.get(Customer.class, 6L);
		s.delete(c);
		tx.commit();
	}


}
