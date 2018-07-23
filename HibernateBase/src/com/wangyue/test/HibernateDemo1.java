package com.wangyue.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.wangyue.domain.Customer;

/**
 * hibernate的入门案例
 * 需求：
 * 		实现保存一个客户到数据库
 * @author WY
 *
 */

public class HibernateDemo1 {
	
	/**
	 * 步骤分析：
	 * 1.解析主配置文件
	 * 2.根据主配置文件创建SessionFactory对象
	 * 3.根据SessionFactory创建session
	 * 4.开启事务
	 * 5.执行操作(保存)
	 * 6.提交事务
	 * 7.释放资源
	 */
	@Test
	public void test1(){
		Customer c = new Customer();
		c.setCustName("汪越");
		 // 1.解析主配置文件
		Configuration cfg = new Configuration();
		cfg.configure();
		 // 2.根据主配置文件创建SessionFactory对象
		SessionFactory factory = cfg.buildSessionFactory();
		 // 3.根据SessionFactory创建session
		Session session = factory.openSession(); 
		 // 4.开启事务
		Transaction tx = session.beginTransaction();
		 // 5.执行操作(保存)
		session.save(c);
		 // 6.提交事务
		tx.commit();
		 // 7.释放资源
		session.close();
		factory.close();
	}

}
