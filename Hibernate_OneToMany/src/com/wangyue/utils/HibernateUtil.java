package com.wangyue.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 抽取hibernate的工具类
 * @author WY
 *
 */
public class HibernateUtil {
	private static SessionFactory factory;
	
//	private static ThreadLocal<Session> tl = new ThreadLocal<Session>();
	
	//hibernate把可以预见的异常都转成了运行时异常
	static{
		try {
			Configuration cfg = new Configuration();
			cfg.configure();
			factory = cfg.buildSessionFactory();
			//System.out.println(factory);
		} catch (ExceptionInInitializerError e) {
			throw new ExceptionInInitializerError("初始化SessionFactory失败，请检查配置文件");
		}
	}
	/**
	 * 获取一个新的session对象
	 * 每次使用openSession方法，每次得到的都是一个新的session
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
	 * 从当前线程上获取session对象
	 */
	public static Session getCurrentSession(){
		return factory.getCurrentSession();//只有配置了把session和线程绑定之后，才能使用此方法，否则返回值为null
	}
	
	public static void main(String[] args) {
		getCurrentSession();
	}
}
