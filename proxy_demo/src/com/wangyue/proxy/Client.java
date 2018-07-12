package com.wangyue.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ģ��һ������
 * @author WY
 *
 */

public class Client {

	public static void main(String[] args) {
		final Actor actor = new Actor();
//		actor.basicAct(100f);
//		actor.dangerAct(500f);
	 	IActor proxyActor = (IActor) Proxy.newProxyInstance(actor.getClass().getClassLoader(),
				actor.getClass().getInterfaces(),
				new InvocationHandler() {
				/**
				 * ִ�б����������κη������ᾭ���÷������÷��������صĹ���
				 * �����Ĳ���
				 * 		Object proxy:�����������á���һ��ÿ�ζ�����
				 * 		Method method:��ǰִ�еķ���
				 * 		Object[] args:��ǰִ�з�������Ĳ���
				 * ����ֵ��
				 * 		��ǰ���ط����ķ���ֵ	
				 */
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						
						Object rtValue = null;
						//1.ȡ��ִ�з����еĲ��������Ķ���Ǯ
						Float money = (Float) args[0];
						//2.�жϵ�ǰִ�е���ʲô����
						if("basicAct".equals(method.getName())){
							//�����ݳ�
							if(money>10000){
								//ִ�з�������ʼ����
								rtValue = method.invoke(actor, money);
							}
						}
						if("dangerAct".equals(method.getName())){
							//Σ���ݳ�
							if(money>50000){
									//ִ�з�������ʼ����
									rtValue = method.invoke(actor, money);
							}	
						}
						
						return rtValue;
					}
				});
	 	proxyActor.basicAct(50000);
	 	proxyActor.dangerAct(100000);
	 	

	}

}
