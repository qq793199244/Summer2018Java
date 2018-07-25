package com.wangyue.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.wangyue.domain.Customer;
import com.wangyue.utils.HibernateUtil;

/**
 * Hibernate�е�QBC��ѯ
 * QBC��ȫ�ƣ�Query By Criteria
 * ����һ�ָ����������Ĳ�ѯ��ʽ�������������Ĺ���ȫ�����뵽����֮����
 * @author WY
 */
public class HibernateDemo6 {
	//������ѯ
	@Test
	public void test1(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//��ȡCriteria����
		Criteria c = s.createCriteria(Customer.class);
		//��ȡ�����
		List list = c.list();
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
		//��ȡCriteria����
		Criteria c = s.createCriteria(Customer.class);
		//ʹ��Criteria�����add�������������
		c.add(Restrictions.eq("custLevel", "23"));
		c.add(Restrictions.like("custName", "%��%"));
		//��ȡ�����
		List list = c.list();
		for(Object o : list){
			System.out.println(o);
		}
		tx.commit();
	}
	//�����ѯ
	@Test
	public void test3(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//��ȡCriteria����
		Criteria c = s.createCriteria(Customer.class);
		//�������
		c.addOrder(Order.desc("custId"));
		//��ȡ�����
		List list = c.list();
		for(Object o : list){
			System.out.println(o);
		}
		tx.commit();
	}
	
	//��ҳ��ѯ
	/**
	 * QBC�ķ�ҳ��ѯ��HQL�ķ�ҳ��ѯ �ķ����ͺ��嶼��һģһ����
	 */
	@Test
	public void test4(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//��ȡCriteria����
		Criteria c = s.createCriteria(Customer.class);
		//���÷�ҳ����
		c.setFirstResult(2);
		c.setMaxResults(2);
		//��ȡ�����
		List list = c.list();
		for(Object o : list){
			System.out.println(o);
		}
		tx.commit();
	}
	
	//ͳ�ƣ�ͶӰ����ѯ
	@Test
	public void test5(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//��ȡCriteria����
		Criteria c = s.createCriteria(Customer.class);
		//����ʹ�þۺϺ���
//		c.setProjection(Projections.rowCount());
		c.setProjection(Projections.count("custId"));
		//��ȡ�����
//		List list = c.list();
//		for(Object o : list){
//			System.out.println(o);
//		}
		Long count = (Long) c.uniqueResult();
		System.out.println(count);
		tx.commit();
	}
	
	//���߲�ѯ
	@Test
	public void testServlet(){
		//1.��ȡ���߶��󣬲���Ҫsession
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		//2.��װ��ѯ����
		dc.add(Restrictions.eq("custLevel", "23"));
		dc.add(Restrictions.like("custName", "%��%"));
		
		List list = testService(dc);
		for(Object o : list ){
			System.out.println(o);
		}
	}

	private List testService(DetachedCriteria dc) {
		Session s = null;
		Transaction tx = null;
		try{
			s = HibernateUtil.getCurrentSession();
			tx = s.beginTransaction();
			List list = testDao(dc);
			tx.commit();
			return list;
		}catch(Exception e){
			tx.rollback();
		}
		return null;
	}

	private List testDao(DetachedCriteria dc) {
		Session s = HibernateUtil.getCurrentSession();
		//�����߶���ת�����߶���
		Criteria c = dc.getExecutableCriteria(s);
		
		return c.list();
	}
}
