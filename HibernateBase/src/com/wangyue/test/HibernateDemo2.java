package com.wangyue.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.wangyue.domain.Customer;

/**
 * hibernate的常用对象
 * 	Configuration
 * 	SessionFactory
 * 	Session
 * 	Transaction
 * @author WY
 *
 */

public class HibernateDemo2 {
	
	@Test
	public void test1(){
		Customer c = new Customer();
		c.setCustName("汪越_2");
		 // 1.解析主配置文件
		Configuration cfg = new Configuration();//只是创建，并不加载xml配置文件
		cfg.configure(); //加载默认位置和名称的配置文件（默认位置：类的根路径。默认名称：hibernate.cfg.xml）
		//cfg.addResource("com/wangyue/domain/Customer.hbm.xml");
		//cfg.addClass(Customer.class);
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
