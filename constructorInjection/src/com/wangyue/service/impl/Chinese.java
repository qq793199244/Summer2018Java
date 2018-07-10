package com.wangyue.service.impl;

import com.wangyue.service.Axe;
import com.wangyue.service.Person;

public class Chinese implements Person {
	
	private Axe axe;
	
	//构造注入所需的带参数的构造器
	public Chinese(Axe axe){
		this.axe = axe;
	}
	
	//调用axe的chop()方法
	//表明Person对象依赖于axe对象
	public void useAxe(){
		System.out.println(axe.chop());
	}

}
