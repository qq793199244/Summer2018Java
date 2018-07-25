package com.wangyue.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.wangyue.domain.Customer;
import com.wangyue.utils.HibernateUtil;

/**
 * hibernate的对象状态
 * @author WY
 *
 */

public class HibernateDemo3 {	
	/**
	 
	 */
	@Test
	public void test1(){
		Customer c = new Customer(); //瞬时状态
		c.setCustName("汪越_对象状态_测试查不查");

		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		session.save(c); //持久化状态
//		Customer c1 = session.get(Customer.class, c.getCustId());
//		System.out.println(c1);
		tx.commit();
		session.close();//session关闭了
		
		c.setCustAddress("唐山市"); //脱管状态(脱离了session的管理)
		
		Session s1 = HibernateUtil.openSession();
		Transaction tx1 = s1.beginTransaction();
		s1.update(c); //持久化状态
		tx1.commit();
		s1.close(); //session关闭了
		
		System.out.println(c); //脱管状态
	}
	
	/**
	 * saveOrUpdate
	 */
	@Test
	public void test2(){
		Customer c = new Customer(); //瞬时状态
		c.setCustName("汪越_saveOrUpdate");
		
		Session s1 = HibernateUtil.openSession();
		Transaction tx1 = s1.beginTransaction();
		s1.saveOrUpdate(c); //
		tx1.commit();
		s1.close(); //session关闭了

	}
	
	@Test
	public void test3(){
		Session s1 = HibernateUtil.openSession();
		Transaction tx1 = s1.beginTransaction();
		Customer c = s1.get(Customer.class, 11L);//持久化状态
	
		tx1.commit();
		s1.close(); //session关闭了
		
		c.setCustAddress("河北省");
		System.out.println(c); //脱管状态
		
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(c); //持久化状态
		tx.commit();
		session.close();

	}

}
