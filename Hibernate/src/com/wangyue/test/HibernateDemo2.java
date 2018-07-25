package com.wangyue.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.wangyue.domain.Customer;
import com.wangyue.utils.HibernateUtil;

/**
 * hibernate��һ������
 * @author WY
 *
 */

public class HibernateDemo2 {
	/**
	 * ֤��һ������ȷʵ����
	 */
	@Test
	public void test1(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		//1.����id��ѯ�ͻ�
		Customer c1 = s.get(Customer.class, 1L); //��ȥ���ݿ��ѯ�����Ѳ�ѯ�Ľ��������һ������֮��
		System.out.println(c1);
		//1.����id�ٴβ�ѯ�ͻ�
		Customer c2 = s.get(Customer.class, 1L);//��ȥһ�����濴����û�У�����ֱ���ù����ã���û����ȥ��ѯ��
		System.out.println(c2);
		System.out.println(c1==c2);
		tx.commit();
		s.close(); //session�ر� һ���������ʧ��
	}
	
	/**
	 * 
	 */
	@Test
	public void test2(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		//1.����id��ѯ�ͻ�
		Customer c1 = s.get(Customer.class, 1L);
		System.out.println(c1.getCustAddress());//����ͻ��ĵ�ַ
		//2.�޸Ŀͻ��ĵ�ַ
		c1.setCustAddress("��ͤ��");
		System.out.println(c1.getCustAddress());//����ͻ��ĵ�ַ
		
		tx.commit();
		s.close(); //session�ر� һ���������ʧ��
		System.out.println(c1.getCustAddress());//��ʱ����ĵ�ַ��ʲô
	}
}
