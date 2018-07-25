package com.wangyue.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.wangyue.domain.Customer;
import com.wangyue.utils.HibernateUtil;

/**
 * ��֤session���̰߳󶨵�����
 * @author WY
 *
 */
public class HibernateDemo4 {
	@Test
	public void test1(){
		Session s1 = HibernateUtil.getCurrentSession();
		Session s2 = HibernateUtil.getCurrentSession();
		System.out.println(s1==s2);
		
	}
	
	/**
	 * ����Session���̰߳�֮��hibernate�����ύ��ع�����֮���Զ������ǹر�session
	 */
	@Test
	public void test2(){
		Customer c = new Customer(); //˲ʱ״̬
		c.setCustName("��Խ_getCurrentSession");
		
		Session s1 = HibernateUtil.getCurrentSession();
		Transaction tx1 = s1.beginTransaction();
		s1.saveOrUpdate(c); //
		tx1.commit();
//		s1.close(); //session�ر���
	}

}
