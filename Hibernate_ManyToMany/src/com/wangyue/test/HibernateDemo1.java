package com.wangyue.test;




import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.wangyue.domain.SysRole;
import com.wangyue.domain.SysUser;
import com.wangyue.utils.HibernateUtil;

/**
 * ��Զ�ı����ɾ������
 * @author WY
 *
 */
public class HibernateDemo1 {
	/**
	 * �������
	 * 	����
	 * 		����2���û���3����ɫ
	 * 		��1���û��߱�1�ź�2�Ž�ɫ
	 * 		��2���û��߱�2�ź�3�Ž�ɫ
	 * 		�����û��ͽ�ɫ
	 */
	@Test
	public void test1(){
		SysUser u1 = new SysUser();
		u1.setUserName("�û�1");
		SysUser u2 = new SysUser();
		u2.setUserName("�û�2");
		
		SysRole r1 = new SysRole();
		r1.setRoleName("��ɫ1");
		SysRole r2 = new SysRole();
		r2.setRoleName("��ɫ2");
		SysRole r3 = new SysRole();
		r3.setRoleName("��ɫ3");
		
		//����˫�������ϵ
		//�Ƚ����û���
		u1.getRoles().add(r1);
		u1.getRoles().add(r2);
		u2.getRoles().add(r2);
		u2.getRoles().add(r3);
		//�ٽ�����ɫ
		r1.getUsers().add(u1);
		r2.getUsers().add(u1);
		r2.getUsers().add(u2);
		r3.getUsers().add(u2);
		
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		
		s.save(u1);
		s.save(u2);
		s.save(r1);
		s.save(r2);
		s.save(r3);
		
		tx.commit();	
	}
	
	/**
	 * ɾ������
	 * ��ʵ�ʿ����У���Զ��˫����ɾ���ǽ�ֹʹ�õġ�
	 */
	public void test2(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//��ѯidΪ1���û�
		SysUser u3 = s.get(SysUser.class, 3L);
		//ɾ��
		s.delete(u3);
		tx.commit();	
	}

}
