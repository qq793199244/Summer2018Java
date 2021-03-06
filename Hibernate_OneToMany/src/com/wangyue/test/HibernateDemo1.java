package com.wangyue.test;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.wangyue.domain.Customer;
import com.wangyue.domain.LinkMan;
import com.wangyue.utils.HibernateUtil;

/**
 * 一对多关系映射的CUD操作
 * @author WY
 *
 */
public class HibernateDemo1 {
	
	/**
	 * 保存操作
	 * 		正常的保存：创建一个新的联系人，需要关联一个客户
	 */
	@Test
	public void test1(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//1.查询一个客户
		Customer c1 = s.get(Customer.class, 1L);
		//2.创建一个新的联系人
		LinkMan l = new LinkMan();
		l.setLkmName("一对多的联系人");
		//3.建立客户和联系人的关联关系（让联系人知道属于哪个客户即可）
		l.setCustomer(c1);
		//4.保存联系人
		s.save(l);
		
		tx.commit();
	}
	
	/**
	 * 特殊的情况：
	 * 		创建一个客户和一个联系人
	 * 		建立联系人和客户的双向关联关系
	 *		使用符合原则的保存，原则是：
	 *			先保存主表实体，再保存从表实体
	 * 此时保存会有问题：保存两个实体，应该只有两条insert语句
	 * 				而执行结果却多了一条update语句
	 * 解决办法：
	 * 		让客户在执行操作的时候，放弃维护关联关系的权利
	 * 		配置的方式：
	 * 			在Customer的映射配置文件中的set标签上使用inverse属性
	 * 			inverse的含义：是否放弃维护关联关系的权利 true放弃 false不放弃
	 */
	@Test
	public void test2(){
		//1.创建一个客户
		Customer c1 = new Customer();//瞬时态
		c1.setCustName("一对多的客户_4");
		//2.创建一个新的联系人
		LinkMan l = new LinkMan();//瞬时态
		l.setLkmName("一对多的联系人_4");
		//3.建立客户和联系人的关联关系（双向的）
		l.setCustomer(c1);
		c1.getLinkmans().add(l);
		
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
	
		//4.保存要符合原则：
		s.save(c1);//持久态 有一级缓存和快照
		s.save(l);//持久态 有一级缓存和快照

		tx.commit();
	}
	
	/**
	 * 保存操作：级联保存
	 * 使用级联保存，配置的方式，仍然是找到Customer的映射配置文件的set标签，也可以配置在many-to-one上
	 * 在上面加入cascade属性
	 * cascade：配置级联操作
	 * 		级联保存更新的取值：save-update
	 */
	@Test
	public void test3(){
		//1.创建一个客户
		Customer c1 = new Customer();//瞬时态
		c1.setCustName("一对多的客户_5");
		//2.创建一个新的联系人
		LinkMan l = new LinkMan();//瞬时态
		l.setLkmName("一对多的联系人_5");
		//3.建立客户和联系人的关联关系（双向的）
		l.setCustomer(c1);
		c1.getLinkmans().add(l);
		
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
	
		//4.保存要符合原则：
		s.save(c1);
		tx.commit();
	}
	
	/**
	 * 
	 */
	@Test
	public void test4(){
		//1.创建一个客户
		Customer c1 = new Customer();//瞬时态
		c1.setCustName("一对多的客户_6");
		//2.创建一个新的联系人
		LinkMan l = new LinkMan();//瞬时态
		l.setLkmName("一对多的联系人_6");
		//3.建立客户和联系人的关联关系（双向的）
		l.setCustomer(c1);
		c1.getLinkmans().add(l);
		
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
	
		//4.保存要符合原则：
		s.save(l);
		tx.commit();
	}
	
	/**
	 * 更新操作：
	 * 需求：
	 * 		创建一个新的联系人，查询一个已有客户
	 * 		建立新联系人和已有客户的双向关联关系
	 * 		更新客户
	 */
	@Test
	public void test5(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//1.查询一个客户
		Customer c1 = s.get(Customer.class, 1L);
		//2.创建一个新的联系人
		LinkMan l = new LinkMan();
		l.setLkmName("一对多的联系人");
		//3.建立客户和联系人的关联关系（双向）
		l.setCustomer(c1);
		c1.getLinkmans().add(l);
		//4.更新客户
		s.update(c1);
		
		tx.commit();
	}
	
	/**
	 * 删除操作
	 * 		删除从表就是单表
	 * 		删除主表数据看有没有从表数据引用
	 * 			有引用：在删除时Hibernate会把从表中的外键字段置为null，然后再删除主表数据
	 * 				若外键字段有非空约束，则hibernate不能更新外键字段为null，会报错
	 * 					若仍想删除，需使用级联删除。同时必须配置inverse属性是true
	 * 			没引用：就是单表直接删
	 * 级联删除的使用在实际开发中要慎重
	 */
	@Test
	public void test6(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//1.查询一个客户
		Customer c5 = s.get(Customer.class, 5L);
		s.delete(c5);
		
		tx.commit();
	}



}
