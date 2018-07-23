package com.wangyue.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.wangyue.domain.Customer;
import com.wangyue.utils.HibernateUtil;

/**
 * Hibernate�в�ѯһ���ķ���
 * get����
 * 		get(Class clazz, Serializable id)
 * load����
 * 		load(Class clazz, Serializable id)
 * 
 * ��ͬ�㣺���Ǹ���id��ѯʵ��
 * 
 * ����
 *  	1����ѯ��ʱ����һ����
 *  		get�Ĳ�ѯʱ����ÿ�ε���get����ʱ�����Ϸ����ѯ��		��������
 *  		load�Ĳ�ѯʱ����ÿ������ʹ�õ�ʱ�򣬷����ѯ��			�ӳټ��� 	������   ���Լ���
 *  	2�����صĽ����һ����
 * 			get�������صĶ�����ʵ��������
 * 			load�������صĶ�����ʵ�������͵Ĵ������
 *  
 *  load����Ĭ����������ӳ٣�����ͨ�����õķ�ʽ��Ϊ�������ء�
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
