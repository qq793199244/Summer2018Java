package com.wangyue.test;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.wangyue.domain.Customer;
import com.wangyue.domain.LinkMan;
import com.wangyue.utils.JPAUtil;

/**
 * JPA�Ĳ�ѯ����
 * 
 * 	������ʹ�ö��󵼺��ķ�ʽ
 * @author WY
 *
 */
public class JPADemo2 {
	
	/**
	 * ���ݿͻ���ѯ�ͻ��µ���ϵ��
	 */
	@Test
	public void test1(){
		EntityManager em = JPAUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//1.��ѯidΪ1�Ŀͻ�
		Customer c = em.find(Customer.class, 1L);
		System.out.println(c);
		//��ѯ��ǰ�ͻ��µ���ϵ��
		Set<LinkMan> linkmans = c.getLinkmans();
		System.out.println(linkmans);
		
		tx.commit();
		em.close();
	}
	
	/**
	 * ������ϵ�ˣ���ѯ��ϵ�˵������ͻ�
	 */
	@Test
	public void test2(){
		EntityManager em = JPAUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//1.��ѯidΪ1�Ŀͻ�
		LinkMan l = em.find(LinkMan.class, 1L);
		System.out.println(l);
		//��ѯ��ǰ�ͻ��µ���ϵ��
		Customer c = l.getCustomer();
		System.out.println(c);
		
		tx.commit();
		em.close();
	}
}
