package com.wangyue.utils;
/**
 * JPA的工具类
 * @author WY
 *
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	//它相当于SessionFactory
	private static EntityManagerFactory factory;
	
	static{
		factory = Persistence.createEntityManagerFactory("myJPAUnit");
	}
	/**
	 * 获取JAP操作数据库的对象
	 * @return
	 */
	public static EntityManager createEntityManager(){
		return factory.createEntityManager();
	}
	
	public static void main(String[] args) {
		createEntityManager();
	}

}
