package com.wangyue.utils;
/**
 * JPA�Ĺ�����
 * @author WY
 *
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.SynchronizationType;

public class JPAUtil {
	
	//���൱��SessionFactory
	private static EntityManagerFactory factory;
	private static ThreadLocal<EntityManager> tl;	
	
	static{
		factory = Persistence.createEntityManagerFactory("myJPAUnit");
		tl = new ThreadLocal<EntityManager>();
	}
	/**
	 * ��ȡJAP�������ݿ�Ķ���
	 * @return
	 */
//	private static EntityManager createEntityManager(){
//		//factory.createEntityManager(SynchronizationType.SYNCHRONIZED);
//		return factory.createEntityManager();
//	}
	
	/**
	 * ��ȡEntityManager����
	 * @return
	 */
	public static EntityManager createEntityManager(){
		//1.�ӵ�ǰ�߳��ϻ�ȡEntityManager����
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
