package com.wangyue.proxy;

/**
 * һ����Ա
 * @author WY
 *
 */

public class Actor implements IActor {
	//�����ı��� @param money
	public void basicAct(float money){
		System.out.println("�õ�Ǯ����ʼ�����ı���" + money);
	}
	
	//Σ�յı���
	public void dangerAct(float money){
		System.out.println("�õ�Ǯ����ʼΣ�յı���" + money);
	}
	

}
