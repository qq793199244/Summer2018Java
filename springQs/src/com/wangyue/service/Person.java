package com.wangyue.service;

public class Person {
	private Axe axe;

	public void setAxe(Axe axe) {
		this.axe = axe;
	}
	
	public void useAxe(){
		System.out.println("�Ҵ���ȥ������");
		
		System.out.println(axe.chop());
	}

}
