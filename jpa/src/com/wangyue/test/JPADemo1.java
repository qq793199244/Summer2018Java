package com.wangyue.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.Test;

import com.wangyue.domain.Customer;
import com.wangyue.utils.JPAUtil;

/**
 * JPA�����Ű���
 * 	JPA�������ݿ⣨���������
 * @author WY
 *
 */
public class JPADemo1 {

	//����
	@Test
	public void test1(){
		//�����ͻ�����
		Customer c = new Customer();
		c.setCustName("JPA Customer");
		
		//1.��ȡEntityManager����
		EntityManager em = JPAUtil.createEntityManager();
		//2.��ȡ������󣬲���������
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//3.ִ�б������
		em.persist(c);
		//4.�ύ����
		tx.commit();
		//5.�ر���Դ
		em.close();
	}
	
	
	//��ѯһ��ʵ��	��������
	@Test
	public void test2(){
		//1.��ȡEntityManager����
		EntityManager em = JPAUtil.createEntityManager();
		//2.��ȡ������󣬲���������
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//3.ִ�и��²�������Ҫ�Ѹ��µĶ����Ȳ�ѯ������
		Customer c = em.find(Customer.class, 1L);
		System.out.println(c);
		//4.�ύ����
		tx.commit();
		//5.�ر���Դ
		em.close();
	}
	
	
	//��ѯһ��ʵ��	�ӳټ���
	@Test
	public void test2_1(){
		//1.��ȡEntityManager����
		EntityManager em = JPAUtil.createEntityManager();
		//2.��ȡ������󣬲���������
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//3.ִ�и��²�������Ҫ�Ѹ��µĶ����Ȳ�ѯ������
		Customer c = em.getReference(Customer.class, 1L);
		System.out.println(c);
		//4.�ύ����
		tx.commit();
		//5.�ر���Դ
		em.close();
	}
	
	
	//���²���
	@Test
	public void test3(){	
		//1.��ȡEntityManager����
		EntityManager em = JPAUtil.createEntityManager();
		//2.��ȡ������󣬲���������
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//3.ִ�и��²�������Ҫ�Ѹ��µĶ����Ȳ�ѯ������
		Customer c = em.find(Customer.class, 1L);
		//�޸Ŀͻ��ĵ�ַΪ��˳����
		c.setCustAddress("˳����");
		//4.�ύ����
		tx.commit();
		//5.�ر���Դ
		em.close();
	}
	
	//���µ���һ�ֲ�����ʽ
	//merge�Ǻϲ�  ������ʵ��ϲ���
	@Test
	public void test4(){	
		//1.��ȡEntityManager����
		EntityManager em = JPAUtil.createEntityManager();
		//2.��ȡ������󣬲���������
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//3.ִ�и��²�������Ҫ�Ѹ��µĶ����Ȳ�ѯ������
		Customer c = em.find(Customer.class, 1L);
		//�޸Ŀͻ��ĵ�ַΪ��˳����
		c.setCustAddress("������˳����");
		
		em.merge(c);
		//4.�ύ����
		tx.commit();
		//5.�ر���Դ
		em.close();
	}
	
	//ɾ������
	@Test
	public void test5(){	
		//1.��ȡEntityManager����
		EntityManager em = JPAUtil.createEntityManager();
		//2.��ȡ������󣬲���������
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//3.ִ�и��²�������Ҫ�Ѹ��µĶ����Ȳ�ѯ������
		Customer c = em.find(Customer.class, 1L);
		//ɾ������
		em.remove(c);
		
		//4.�ύ����
		tx.commit();
		//5.�ر���Դ
		em.close();
	}
	
	/*
	 * ��ѯ����
	 * 
	 * 	�漰�Ķ����ǣ�
	 * 		JPA��Query
	 * 	��λ�ȡ�ö���
	 * 		EntityManager��createQuery(String jpql)
	 * 	�������壺
	 * 		JPQL��Java Persistence Query Language
	 * 		����д����HQL�����ơ�Ҳ�ǰѱ����������������ֶ���������������
	 * 		����д��ѯ����ʱ������ֱ����		from ʵ����
	 * 		��Ҫʹ��select�ؼ���
	 * 			select c from Customer c
	 */
	@Test
	public void test6(){	
		//1.��ȡEntityManager����
		EntityManager em = JPAUtil.createEntityManager();
		//2.��ȡ������󣬲���������
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//3.��ȡJPA�Ĳ�ѯ����Query
		Query query = em.createQuery("select c from Customer c where custName like ? and custLevel = ? ");
		//��ռλ����ֵ
		query.setParameter(1, "%��%");
		query.setParameter(2,"23");
		//ִ�з�����ȡ�����
		List list = query.getResultList();
		for(Object o : list){
			System.out.println(o);
		}
		//4.�ύ����
		tx.commit();
		//5.�ر���Դ
		em.close();
	}
	
}
