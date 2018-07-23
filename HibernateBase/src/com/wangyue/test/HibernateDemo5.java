package com.wangyue.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.wangyue.domain.Customer;
import com.wangyue.utils.HibernateUtil;

/**
 * Hibernate中查询一个的方法
 * get方法
 * 		get(Class clazz, Serializable id)
 * load方法
 * 		load(Class clazz, Serializable id)
 * 
 * 共同点：都是根据id查询实体
 * 
 * 区别：
 *  	1、查询的时机不一样。
 *  		get的查询时机：每次调用get方法时，马上发起查询。		立即加载
 *  		load的查询时机：每次真正使用的时候，发起查询。			延迟加载 	懒加载   惰性加载
 *  	2、返回的结果不一样。
 * 			get方法返回的对象是实体类类型
 * 			load方法返回的对象是实体类类型的代理对象
 *  
 *  load方法默认情况下是延迟，可以通过配置的方式改为立即加载。
 * @author WY
 *
 */
public class HibernateDemo5 {
	
	@Test
	public void testGet(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		Customer c = s.get(Customer.class, 3L);
		System.out.println("get:"+c.toString());
		tx.commit();
	}
	
	@Test
	public void loadGet(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		Customer c = s.load(Customer.class, 3L);
		System.out.println("load:"+c.toString());
		tx.commit();
	}

}
