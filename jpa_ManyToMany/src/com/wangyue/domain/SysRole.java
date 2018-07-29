package com.wangyue.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * ��ɫ��ʵ����
 * @author WY
 *
 */
@Entity
@Table(name="sys_role")
public class SysRole implements Serializable {
	
	@Id
	@Column(name="role_id")
	@GenericGenerator(name="uuid",strategy="uuid")//����һ������������. name���ԣ���������������֡�strategy��ָ���ľ���hibernate�а��������ɲ���
	@GeneratedValue(generator="uuid")
	private String roleId;
	
	@Column(name="role_name")
	private String roleName;
	
	@Column(name="role_memo")
	private String roleMemo;
	//��Զ��ϵӳ�䣬һ����ɫ���Ը������û�
	@ManyToMany(cascade=CascadeType.ALL)
	//����һ�ű�
	@JoinTable( name="user_role_ref",
				joinColumns={@JoinColumn(name="role_id",referencedColumnName="role_id")},//д���ǵ�ǰʵ�����м�������ֶ�
				inverseJoinColumns={@JoinColumn(name="user_id",referencedColumnName="user_id")}//д���ǶԷ�ʵ�����м�������ֶ�
			)
	private Set<SysUser> users = new HashSet<SysUser>(0);
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
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
