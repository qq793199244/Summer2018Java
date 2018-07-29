package com.wangyue.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.wangyue.domain.Customer;
import com.wangyue.domain.LinkMan;
import com.wangyue.utils.JPAUtil;

import sun.java2d.loops.CustomComponent;

/**
 * JPA��һ�Զ����ز���
 * @author WY
 *
 */
public class JPADemo1 {
	/**
	 * �������
	 * 	 ����һ���ͻ���һ����ϵ��
	 * 	�����ͻ�����ϵ�˵�˫�������ϵ
	 *  �ȱ���ͻ����ٱ�����ϵ��
	 */
	@Test
	public void test1(){
		Customer c = new Customer();
		LinkMan l = new LinkMan();
		c.setCustName("JPA One To Many Customer");
		l.setLkmName("JPA One To Many LinkMan");
		
		c.getLinkmans().add(l);
		l.setCustomer(c);
		
		EntityManager em = JPAUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		em.persist(l);
		tx.commit();
		em.close();
		
	}
	
	/**
	 * ���²���
	 * 	����һ����ϵ��
	 * 	��ѯidΪ5�Ŀͻ�
	 * 	Ϊ5����ͷ��������ϵ��
	 * 	���¿ͻ�
	 */
	@Test
	public void test2(){
		LinkMan l = new LinkMan();
		l.setLkmName("JPA One To Many LinkMan 2");
		
		EntityManager em = JPAUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Customer c = em.find(Customer.class, 5L);
		
		c.getLinkmans().add(l);
		l.setCustomer(c);
		
		tx.commit();
		em.close();
	}
	
	/**
	 * ɾ������
	 */
	@Test
	public void test3(){
	
		EntityManager em = JPAUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
				
		Customer c = em.find(Customer.class, 5L);
		em.remove(c);
				
		tx.commit();
		em.close();
	}

}
