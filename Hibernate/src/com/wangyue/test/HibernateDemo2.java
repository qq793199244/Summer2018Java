package com.wangyue.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.wangyue.domain.Customer;
import com.wangyue.utils.HibernateUtil;

/**
 * hibernate的一级缓存
 * @author WY
 *
 */

public class HibernateDemo2 {
	/**
	 * 证明一级缓存确实存在
	 */
	@Test
	public void test1(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		//1.根据id查询客户
		Customer c1 = s.get(Customer.class, 1L); //先去数据库查询，并把查询的结果存入了一级缓存之中
		System.out.println(c1);
		//1.根据id再次查询客户
		Customer c2 = s.get(Customer.class, 1L);//先去一级缓存看看有没有，若有直接拿过来用，若没有再去查询。
		System.out.println(c2);
		System.out.println(c1==c2);
		tx.commit();
		s.close(); //session关闭 一级缓存就消失了
	}
	
	/**
	 * 
	 */
	@Test
	public void test2(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		//1.根据id查询客户
		Customer c1 = s.get(Customer.class, 1L);
		System.out.println(c1.getCustAddress());//输出客户的地址
		//2.修改客户的地址
		c1.setCustAddress("乐亭县");
		System.out.println(c1.getCustAddress());//输出客户的地址
		
		tx.commit();
		s.close(); //session关闭 一级缓存就消失了
		System.out.println(c1.getCustAddress());//此时输出的地址是什么
	}
}
