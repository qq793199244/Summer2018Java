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
 * hibernate��CRUD����
 * 		ʵ�ֱ���һ���ͻ������ݿ�
 * @author WY
 *
 */

public class HibernateDemo3 {

	//��������Ļع�����
	@Test
	public void testSave1(){
		Customer c = new Customer();
		c.setCustName("���Ա��湦��");
		
		Transaction tx = null;
		Session s = null;
		try{
			s = HibernateUtil.openSession();
			tx = s.beginTransaction();
			//����ͻ�
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
		c.setCustName("���Ա��湦��");
		
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		//����ͻ�
		s.save(c);
		tx.commit();
		s.close();
	}
	
	@Test
	public void testFindOne(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		//��ѯidΪ1�Ŀͻ�
		Customer c = s.get(Customer.class, 1L);
		System.out.println(c);
		tx.commit();
		s.close();
	}
	
	@Test
	public void testUpdate(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		//��ѯidΪ1�Ŀͻ�
		Customer c = s.get(Customer.class, 1L);
		//�޸Ŀͻ��ĵ�ַ
		c.setCustAddress("��ɽ��");
		s.update(c);
		tx.commit();
		s.close();
	}
	
	@Test
	public void testDelete(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		//ɾ��idΪ2�Ŀͻ�
		Customer c = s.get(Customer.class, 2L);
		s.delete(c);
		tx.commit();
		s.close();
	}
	
	@Test
	public void testFindAll(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		//ʹ��session���󣬻�ȡһ����ѯ����Query
		SQLQuery sqlquery = s.createSQLQuery("select * from cst_customer");
		//ʹ��SQLQuery�����ȡ�����
		List<Object[]> list = sqlquery.list();
		for(Object[] os : list){
			System.out.println("--------�����е�����---------");
			for(Object o : os){
				System.out.println(o);
			}
		}
		tx.commit();
		s.close();
	}

}
