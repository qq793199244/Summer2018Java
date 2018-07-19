package com.wangyue.dao;

import com.wangyue.domain.Account;

/**
 * �˻��ĳ־ò�ӿ�
 * @author WY
 */
public interface IAccountDao {
	
	
	/**
	 * ����id��ѯ�˻���Ϣ
	 * @param accountId
	 * @return
	 */
	Account findAccountById(Integer accountId);
	
	/**
	 * �������Ʋ�ѯ�˻���Ϣ
	 * @param accountName
	 * @return  Ҫ���˻����Ʊ���Ψһ������Ψһ��Ӧ���׳��쳣
	 */
	Account findAccountByName(String accountName);
	
	/**
	 * �����˻���Ϣ
	 * @param account
	 */
	void updateAccount(Account account);

}
