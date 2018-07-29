package com.wangyue.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * �ͻ���ʵ����
 * @author WY
 * ʹ�õ�ע�ⶼ��jpa�淶�ģ����Ե�������Ҫ����javax.persistence���µ�
 *
 */
@Entity //����������һ��ʵ����
@Table(name="cst_customer") //������ǰ������ݿ��Ķ�Ӧ��ϵ
public class Customer implements Serializable {
	
	@Id //������ǰ�ֶ�������
	@Column(name="cust_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY) //ָ���������ɲ��ԡ�strategy��ʹ��JPA���ṩ���������ɲ��ԣ������Բ����ˡ�generator���Կ���ʹ��hibernate�е��������ɲ���
	private Long custId;
	
	@Column(name="cust_name")
	private String custName;
	
	@Column(name="cust_source")
	private String custSource;
	
	@Column(name="cust_industry")
	private String custIndustry;
	
	@Column(name="cust_level")
	private String custLevel;
	
	@Column(name="cust_address")
	private String custAddress;
	
	@Column(name="cust_phone")
	private String custPhone;
	
	//һ�Զ��ϵӳ�䣺һ���ͻ������ж����ϵ��
	@OneToMany(targetEntity=LinkMan.class,mappedBy="customer",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<LinkMan> linkmans = new HashSet<LinkMan>(0);
	
	
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustIndustry() {
		return custIndustry;
	}
	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	
	
	public Set<LinkMan> getLinkmans() {
		return linkmans;
	}
	public void setLinkmans(Set<LinkMan> linkmans) {
		this.linkmans = linkmans;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custSource=" + custSource
				+ ", custIndustry=" + custIndustry + ", custLevel=" + custLevel + ", custAddress=" + custAddress
				+ ", custPhone=" + custPhone + "]";
	}
	
	

}
