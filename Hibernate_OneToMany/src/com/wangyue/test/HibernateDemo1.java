package com.wangyue.test;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.wangyue.domain.Customer;
import com.wangyue.domain.LinkMan;
import com.wangyue.utils.HibernateUtil;

/**
 * һ�Զ��ϵӳ���CUD����
 * @author WY
 *
 */
public class HibernateDemo1 {
	
	/**
	 * �������
	 * 		�����ı��棺����һ���µ���ϵ�ˣ���Ҫ����һ���ͻ�
	 */
	@Test
	public void test1(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//1.��ѯһ���ͻ�
		Customer c1 = s.get(Customer.class, 1L);
		//2.����һ���µ���ϵ��
		LinkMan l = new LinkMan();
		l.setLkmName("һ�Զ����ϵ��");
		//3.�����ͻ�����ϵ�˵Ĺ�����ϵ������ϵ��֪�������ĸ��ͻ����ɣ�
		l.setCustomer(c1);
		//4.������ϵ��
		s.save(l);
		
		tx.commit();
	}
	
	/**
	 * ����������
	 * 		����һ���ͻ���һ����ϵ��
	 * 		������ϵ�˺Ϳͻ���˫�������ϵ
	 *		ʹ�÷���ԭ��ı��棬ԭ���ǣ�
	 *			�ȱ�������ʵ�壬�ٱ���ӱ�ʵ��
	 * ��ʱ����������⣺��������ʵ�壬Ӧ��ֻ������insert���
	 * 				��ִ�н��ȴ����һ��update���
	 * ����취��
	 * 		�ÿͻ���ִ�в�����ʱ�򣬷���ά��������ϵ��Ȩ��
	 * 		���õķ�ʽ��
	 * 			��Customer��ӳ�������ļ��е�set��ǩ��ʹ��inverse����
	 * 			inverse�ĺ��壺�Ƿ����ά��������ϵ��Ȩ�� true���� false������
	 */
	@Test
	public void test2(){
		//1.����һ���ͻ�
		Customer c1 = new Customer();//˲ʱ̬
		c1.setCustName("һ�Զ�Ŀͻ�_4");
		//2.����һ���µ���ϵ��
		LinkMan l = new LinkMan();//˲ʱ̬
		l.setLkmName("һ�Զ����ϵ��_4");
		//3.�����ͻ�����ϵ�˵Ĺ�����ϵ��˫��ģ�
		l.setCustomer(c1);
		c1.getLinkmans().add(l);
		
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
	
		//4.����Ҫ����ԭ��
		s.save(c1);//�־�̬ ��һ������Ϳ���
		s.save(l);//�־�̬ ��һ������Ϳ���

		tx.commit();
	}
	
	/**
	 * �����������������
	 * ʹ�ü������棬���õķ�ʽ����Ȼ���ҵ�Customer��ӳ�������ļ���set��ǩ��Ҳ����������many-to-one��
	 * ���������cascade����
	 * cascade�����ü�������
	 * 		����������µ�ȡֵ��save-update
	 */
	@Test
	public void test3(){
		//1.����һ���ͻ�
		Customer c1 = new Customer();//˲ʱ̬
		c1.setCustName("һ�Զ�Ŀͻ�_5");
		//2.����һ���µ���ϵ��
		LinkMan l = new LinkMan();//˲ʱ̬
		l.setLkmName("һ�Զ����ϵ��_5");
		//3.�����ͻ�����ϵ�˵Ĺ�����ϵ��˫��ģ�
		l.setCustomer(c1);
		c1.getLinkmans().add(l);
		
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
	
		//4.����Ҫ����ԭ��
		s.save(c1);
		tx.commit();
	}
	
	/**
	 * 
	 */
	@Test
	public void test4(){
		//1.����һ���ͻ�
		Customer c1 = new Customer();//˲ʱ̬
		c1.setCustName("һ�Զ�Ŀͻ�_6");
		//2.����һ���µ���ϵ��
		LinkMan l = new LinkMan();//˲ʱ̬
		l.setLkmName("һ�Զ����ϵ��_6");
		//3.�����ͻ�����ϵ�˵Ĺ�����ϵ��˫��ģ�
		l.setCustomer(c1);
		c1.getLinkmans().add(l);
		
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
	
		//4.����Ҫ����ԭ��
		s.save(l);
		tx.commit();
	}
	
	/**
	 * ���²�����
	 * ����
	 * 		����һ���µ���ϵ�ˣ���ѯһ�����пͻ�
	 * 		��������ϵ�˺����пͻ���˫�������ϵ
	 * 		���¿ͻ�
	 */
	@Test
	public void test5(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//1.��ѯһ���ͻ�
		Customer c1 = s.get(Customer.class, 1L);
		//2.����һ���µ���ϵ��
		LinkMan l = new LinkMan();
		l.setLkmName("һ�Զ����ϵ��");
		//3.�����ͻ�����ϵ�˵Ĺ�����ϵ��˫��
		l.setCustomer(c1);
		c1.getLinkmans().add(l);
		//4.���¿ͻ�
		s.update(c1);
		
		tx.commit();
	}
	
	/**
	 * ɾ������
	 * 		ɾ���ӱ���ǵ���
	 * 		ɾ���������ݿ���û�дӱ���������
	 * 			�����ã���ɾ��ʱHibernate��Ѵӱ��е�����ֶ���Ϊnull��Ȼ����ɾ����������
	 * 				������ֶ��зǿ�Լ������hibernate���ܸ�������ֶ�Ϊnull���ᱨ��
	 * 					������ɾ������ʹ�ü���ɾ����ͬʱ��������inverse������true
	 * 			û���ã����ǵ���ֱ��ɾ
	 * ����ɾ����ʹ����ʵ�ʿ�����Ҫ����
	 */
	@Test
	public void test6(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//1.��ѯһ���ͻ�
		Customer c5 = s.get(Customer.class, 5L);
		s.delete(c5);
		
		tx.commit();
	}



}
