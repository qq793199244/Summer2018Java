package com.wangyue.test;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.wangyue.domain.Customer;
import com.wangyue.utils.HibernateUtil;

/**
 * hibernate的CRUD操作
 * 		实现保存一个客户到数据库
 * @author WY
 *
 */

public class HibernateDemo3 {

	//关于事务的回滚问题
	@Test
	public void testSave1(){
		Customer c = new Customer();
		c.setCustName("测试保存功能");
		
		Transaction tx = null;
		Session s = null;
		try{
			s = HibernateUtil.openSession();
			tx = s.beginTransaction();
			//保存客户
			s.save(c);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			s.close();
		}
		
	}	
	
	@Test
	public void testSave(){
		Customer c = new Customer();
		c.setCustName("测试保存功能");
		
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		//保存客户
		s.save(c);
		tx.commit();
		s.close();
	}
	
	@Test
	public void testFindOne(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		//查询id为1的客户
		Customer c = s.get(Customer.class, 1L);
		System.out.println(c);
		tx.commit();
		s.close();
	}
	
	@Test
	public void testUpdate(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		//查询id为1的客户
		Customer c = s.get(Customer.class, 1L);
		//修改客户的地址
		c.setCustAddress("唐山市");
		s.update(c);
		tx.commit();
		s.close();
	}
	
	@Test
	public void testDelete(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		//删除id为2的客户
		Customer c = s.get(Customer.class, 2L);
		s.delete(c);
		tx.commit();
		s.close();
	}
	
	@Test
	public void testFindAll(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		//使用session对象，获取一个查询对象Query
		SQLQuery sqlquery = s.createSQLQuery("select * from cst_customer");
		//使用SQLQuery对象获取结果集
		List<Object[]> list = sqlquery.list();
		for(Object[] os : list){
			System.out.println("--------数组中的内容---------");
			for(Object o : os){
				System.out.println(o);
			}
		}
		tx.commit();
		s.close();
	}

}
