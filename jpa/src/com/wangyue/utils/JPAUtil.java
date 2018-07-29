package com.wangyue.utils;
/**
 * JPA的工具类
 * @author WY
 *
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.SynchronizationType;

public class JPAUtil {
	
	//它相当于SessionFactory
	private static EntityManagerFactory factory;
	private static ThreadLocal<EntityManager> tl;	
	
	static{
		factory = Persistence.createEntityManagerFactory("myJPAUnit");
		tl = new ThreadLocal<EntityManager>();
	}
	/**
	 * 获取JAP操作数据库的对象
	 * @return
	 */
//	private static EntityManager createEntityManager(){
//		//factory.createEntityManager(SynchronizationType.SYNCHRONIZED);
//		return factory.createEntityManager();
//	}
	
	/**
	 * 获取EntityManager对象
	 * @return
	 */
	public static EntityManager createEntityManager(){
		//1.从当前线程上获取EntityManager对象
		EntityManager em = tl.get();
		if(em == null){
			em = factory.createEntityManager();
			tl.set(em);
		}
		return tl.get();
	}
	
	public static void main(String[] args) {
		createEntityManager();
	}

}
