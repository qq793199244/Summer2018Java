package com.wangyue.service.impl;

import com.wangyue.service.Axe;
import com.wangyue.service.Person;

public class Chinese implements Person {
	
	private Axe axe;

	public void setAxe(Axe axe) {
		this.axe = axe;
	}
	
	public void useAxe(){
		System.out.println(axe.chop());
	}

}
