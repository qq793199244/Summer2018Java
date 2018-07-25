package com.wangyue.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.wangyue.domain.Customer;
import com.wangyue.utils.HibernateUtil;

/**
 * 验证session和线程绑定的配置
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
	 * 当把Session和线程绑定之后，hibernate会在提交或回滚事务之后，自动帮我们关闭session
	 */
	@Test
	public void test2(){
		Customer c = new Customer(); //瞬时状态
		c.setCustName("汪越_getCurrentSession");
		
		Session s1 = HibernateUtil.getCurrentSession();
		Transaction tx1 = s1.beginTransaction();
		s1.saveOrUpdate(c); //
		tx1.commit();
//		s1.close(); //session关闭了
	}

}
