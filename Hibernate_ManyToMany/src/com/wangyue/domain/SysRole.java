package com.wangyue.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * ��ɫ��ʵ����
 * @author WY
 *
 */
public class SysRole implements Serializable {
	
	private Long roleId;
	private String roleName;
	private String roleMemo;
	//��Զ��ϵӳ�䣬һ����ɫ���Ը������û�
	private Set<SysUser> users = new HashSet<SysUser>(0);
	
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleMemo() {
		return roleMemo;
	}
	public void setRoleMemo(String roleMemo) {
		this.roleMemo = roleMemo;
	}
	
	
	
	public Set<SysUser> getUsers() {
		return users;
	}
	public void setUsers(Set<SysUser> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "SysRole [roleId=" + roleId + ", roleName=" + roleName + ", roleMemo=" + roleMemo + "]";
	}
	
	

}
