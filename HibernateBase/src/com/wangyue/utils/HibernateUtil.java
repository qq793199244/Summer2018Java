package com.wangyue.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * ��ȡhibernate�Ĺ�����
 * @author WY
 *
 */
public class HibernateUtil {
	private static SessionFactory factory;
	//hibernate�ѿ���Ԥ�����쳣��ת��������ʱ�쳣
	static{
		try {
			Configuration cfg = new Configuration();
			cfg.configure();
			factory = cfg.buildSessionFactory();
			//System.out.println(factory);
		} catch (ExceptionInInitializerError e) {
			throw new ExceptionInInitializerError("��ʼ��SessionFactoryʧ�ܣ����������ļ�");
		}
	}
	/**
	 * ��ȡһ���µ�session����
	 * @return
	 */
	public static Session openSession(){
		return factory.openSession();
	}
}
