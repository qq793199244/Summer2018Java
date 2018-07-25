package com.wangyue.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.wangyue.utils.HibernateUtil;

/**
 * Hibernate�е�HQL��ѯ
 *  �漰�Ķ���Query
 *  ��λ�ȡ�ö���session.createQuery(String hql)
 *  �����ĺ��壺ʹ��HQL����ѯ���ݿ�
 *  HQL����д�����ѱ��������������ֶ������������� 
 *  
 *  HQL��ѯ��ʵ�ֵ�Criteria��ѯҲ��ʵ�֣���֮��Ȼ
 *  ����hibernate�������Ƽ��Ĳ�ѯ��ʽ ��HQL
 * @author WY
 *
 */
public class HibernateDemo5 {
	//������ѯ
	@Test
	public void test1(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//1.��ȡQuery����
		Query query = s.createQuery("from Customer");
		//2.ִ�л�ȡ�����
		List list = query.list();
		for(Object o : list){
			System.out.println(o);
		}
		tx.commit();
	}
	//������ѯ
	@Test
	public void test2(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//1.��ȡQuery����
		Query query = s.createQuery("from Customer where custLevel=? and custName like ?");
		//������ռλ����ֵ
		query.setString(0, "23");//hibernate�Ĳ���ռλ���Ǵ�0��ʼ��
		query.setString(1, "%��%");
		//2.ִ�л�ȡ�����
		List list = query.list();
		for(Object o : list){
			System.out.println(o);
		}
		tx.commit();
	}
	
	@Test
	public void test3(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//1.��ȡQuery����
		//������������Ҫʹ��:��������
		Query query = s.createQuery("from Customer where custName like :custName and custLevel=:custLevel");
		//������ռλ����ֵ
//		query.setString("custLevel", "23");//hibernate�Ĳ���ռλ���Ǵ�0��ʼ��
//		query.setString("custName", "%��%");
		query.setParameter("custLevel", "23");
		query.setParameter("custName", "%��%");
		//2.ִ�л�ȡ�����
		List list = query.list();
		for(Object o : list){
			System.out.println(o);
		}
		tx.commit();
	}
	//�����ѯ
	@Test
	public void test4(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//1.��ȡQuery����
		Query query = s.createQuery("from Customer order by custId desc");
		//2.ִ�л�ȡ�����
		List list = query.list();
		for(Object o : list){
			System.out.println(o);
		}
		tx.commit();
	}
	//��ҳ��ѯ
	/**
	 * MySQL��ҳ�ؼ���limit
	 * limit��������������
	 * 		��һ������ѯ�Ŀ�ʼ��¼����
	 * 		�ڶ�����ÿ�β�ѯ������
	 * hibernateΪ�����ṩ����������
	 * 		setFirstResult�����ò�ѯ�Ŀ�ʼ��¼����
	 * 		setMaxResults������ÿ�β�ѯ������
	 * ������ʲô���ݿ⣬�漰��ҳ�Ķ�����������������ΪSQL���������Ѿ���hibernate������
	 */
	@Test
	public void test5(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//1.��ȡQuery����
		Query query = s.createQuery("from Customer");
		query.setFirstResult(2);
		query.setMaxResults(2);
		//2.ִ�л�ȡ�����
		List list = query.list();
		for(Object o : list){
			System.out.println(o);
		}
		tx.commit();
	}
	//ͳ�Ʋ�ѯ
	/**
	 * ��HQL��ʹ�þۺϺ���
	 * �ۺϺ�����
	 * 		count sum max min avg
	 */
	@Test
	public void test6(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//1.��ȡQuery����
		Query query = s.createQuery("select count(*) from Customer");
		
		//2.ִ�л�ȡ�����
//		List list = query.list();
//		for(Object o : list){
//			System.out.println(o);
//		}
		Long count = (Long) query.uniqueResult();//�����صĽ��Ψһʱ����ʹ�ô˷����������صĽ����Ψһ��ʹ�ô˷��������쳣��
		System.out.println(count);
		tx.commit();
	}
	//ͶӰ��ѯ
	/**
	 * �ڲ�ѯʵ��ʱ��ֻ��Ҫ�����ֶΣ�������ȫ��������ϣ�����ķ��ؽ��ʹ��ʵ��������װ��������Object[]����
	 * ���ʱ�����ǳ�֮Ϊ����ʵ�����ͶӰ
	 * 
	 * ͶӰ��ѯ���÷���
	 * 		1.��ѯ�����Ҫʹ��new�ؼ���
	 * 		2.��ʵ��������Ӷ�Ӧ�����б�Ĺ��캯��
	 */		
	
	@Test
	public void test8(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//1.��ȡQuery����
		Query query = s.createQuery("select new com.wangyue.domain.Customer(custId,custName) from Customer");
		//2.ִ�л�ȡ�����
		List list = query.list();
		for(Object o : list){
			System.out.println(o);
		}
		tx.commit();
	}
	
	
	
	@Test
	public void test7(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//1.��ȡQuery����
		Query query = s.createQuery("select custId,custName from Customer");
		//2.ִ�л�ȡ�����
		List<Object[]> list = query.list();
		for(Object[] os : list){
			System.out.println("--------�����е�����----------");
			for(Object o : os){
				System.out.println(o);
			}
		}
		tx.commit();
	}

}
