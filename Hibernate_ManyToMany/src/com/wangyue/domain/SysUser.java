package com.wangyue.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * �û���ʵ����
 * @author WY
 *
 */
public class SysUser implements Serializable {
	private Long userId;
	private String userName;
	private String userPassword;
	private Integer userState;
	
	//��Զ��ϵӳ�䣬һ���û����Ծ߱������ɫ
	private Set<SysRole> roles = new HashSet<SysRole>(0);
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Integer getUserState() {
		return userState;
	}
	public void setUserState(Integer userState) {
		this.userState = userState;
	}
	
	
	
	public Set<SysRole> getRoles() {
		return roles;
	}
	public void setRoles(Set<SysRole> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "SysUser [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userState=" + userState + "]";
	}
	
	
}
