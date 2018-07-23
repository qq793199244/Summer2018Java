package com.wangyue.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.wangyue.domain.Customer;

/**
 * hibernate�ĳ��ö���
 * 	Configuration
 * 	SessionFactory
 * 	Session
 * 	Transaction
 * @author WY
 *
 */

public class HibernateDemo2 {
	
	@Test
	public void test1(){
		Customer c = new Customer();
		c.setCustName("��Խ_2");
		 // 1.�����������ļ�
		Configuration cfg = new Configuration();//ֻ�Ǵ�������������xml�����ļ�
		cfg.configure(); //����Ĭ��λ�ú����Ƶ������ļ���Ĭ��λ�ã���ĸ�·����Ĭ�����ƣ�hibernate.cfg.xml��
		//cfg.addResource("com/wangyue/domain/Customer.hbm.xml");
		//cfg.addClass(Customer.class);
		 // 2.�����������ļ�����SessionFactory����
		SessionFactory factory = cfg.buildSessionFactory();
		 // 3.����SessionFactory����session
		Session session = factory.openSession(); 
		 // 4.��������
		Transaction tx = session.beginTransaction();
		 // 5.ִ�в���(����)
		session.save(c);
		 // 6.�ύ����
		tx.commit();
		 // 7.�ͷ���Դ
		session.close();
		factory.close();
	}

}
