package com.wangyue.service.impl;

import com.wangyue.service.Axe;
import com.wangyue.service.Person;

public class Chinese implements Person {
	
	private Axe axe;
	
	//����ע������Ĵ������Ĺ�����
	public Chinese(Axe axe){
		this.axe = axe;
	}
	
	//����axe��chop()����
	//����Person����������axe����
	public void useAxe(){
		System.out.println(axe.chop());
	}

}
