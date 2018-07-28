package com.wangyue.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.wangyue.domain.Customer;
import com.wangyue.domain.LinkMan;
import com.wangyue.utils.HibernateUtil;

/**
 * һ�Զ�Ĳ�ѯ����
 * 		OID��ѯ��HQL��ѯ��QBC��ѯ��SQL��ѯ
 * 	Hibernate�е����һ�ֲ�ѯ�����󵼺���ѯ
 * 	������ʵ��֮���й�����ϵʱ��������ϵ������4���е�����һ�֣�
 * 	ͨ������getXXX��������ʵ�ֲ�ѯ���ܣ���������hibernate�ṩ�ģ�
 * 	���磺
 * 		customer.getLinkMans()�Ϳ��Եõ���ǰ�ͻ��µ�������ϵ��
 * 		linkman.getCustomer()�Ϳ��Եõ���ǰ��ϵ�˵������ͻ�
 * 
 * class��ǩ��lazy����ֻ�ܹ�load�����Ƿ����ӳټ��ء�
 * set��ǩ��lazy�����ܲ�ѯ�����ļ��϶����Ƿ����ӳټ��ء�
 * many-to-one��lazy�����ܲ�ѯ����������ʵ���Ƿ����������ء�
 * 
 * @author WY
 *
 */
public class HibernateDemo2 {
	
	/**
	 * ��ѯidΪ1�Ŀͻ���������ϵ��
	 * һ�Զ�ʱ������һ��һ����ѯ���һ��ʱ����Ҫʹ���ӳټ��أ�Ĭ�����ü��ɣ�
	 */
	@Test
	public void test1(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Customer c = s.get(Customer.class, 1L);//��ѯidΪ1�Ŀͻ�
		System.out.println(c);
		Set<LinkMan> linkmans =c.getLinkmans();
		System.out.println(linkmans);
		
		tx.commit();
	}
	
	/**
	 * ��ѯidΪ5����ϵ�������ĸ��ͻ�
	 * ���һʱ�����ݶ��һ����ѯһ��һ��ʱ������Ҫʹ���ӳټ��أ���Ҫ����һ��
	 * ��Ҫ�ҵ���ϵ�˵�ӳ�������ļ�����many-to-one��ǩ��ʹ��lazy����
	 * ȡֵ�У�
	 * false ʹ����������
	 * proxy ��load�������ӳټ��ػ�����������
	 * no-proxy ����
	 */
	@Test
	public void test2(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		LinkMan l = s.get(LinkMan.class, 5L);
		System.out.println(l);
		Customer c = l.getCustomer();
		System.out.println(c);
		
		tx.commit();
	}	
	
	/**
	 * ����load������Ϊ�������صķ�ʽ
	 * �ҵ���ѯʵ���ӳ�������ļ�������class��ǩ��Ҳ��lazy���ԡ������ǣ��Ƿ��ӳټ���
	 *  true�ӳټ���(Ĭ��ֵ)   false��������
	 */
	@Test
	public void test3(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Customer c = s.load(Customer.class, 1L);
		System.out.println(c);
		tx.commit();
	}
}
