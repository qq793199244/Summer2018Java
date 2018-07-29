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
	
//	private static ThreadLocal<Session> tl = new ThreadLocal<Session>();
	
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
	 * ÿ��ʹ��openSession������ÿ�εõ��Ķ���һ���µ�session
	 * @return
	 */
	public static Session openSession(){
//		Session s = tl.get();
//		if(s==null){
//			tl.set(factory.openSession());
//		}
//		s = tl.get();
//		return s;
		return factory.openSession();
	}
	
	/**
	 * �ӵ�ǰ�߳��ϻ�ȡsession����
	 */
	public static Session getCurrentSession(){
		return factory.getCurrentSession();//ֻ�������˰�session���̰߳�֮�󣬲���ʹ�ô˷��������򷵻�ֵΪnull
	}
	
	public static void main(String[] args) {
		getCurrentSession();
	}
}
