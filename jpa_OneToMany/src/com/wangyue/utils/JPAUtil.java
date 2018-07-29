package com.wangyue.utils;
/**
 * JPA�Ĺ�����
 * @author WY
 *
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	//���൱��SessionFactory
	private static EntityManagerFactory factory;
	
	static{
		factory = Persistence.createEntityManagerFactory("myJPAUnit");
	}
	/**
	 * ��ȡJAP�������ݿ�Ķ���
	 * @return
	 */
	public static EntityManager createEntityManager(){
		return factory.createEntityManager();
	}
	
	public static void main(String[] args) {
		createEntityManager();
	}

}
