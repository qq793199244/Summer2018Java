package com.wangyue.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * ģ��һ������
 * @author WY
 *---------�����Ŀ��jar���кܴ�Ĺ�ϵ��ֱ���һ�����cglib-full-2.0.2.jar�Ų������ˡ�-----------
 */

public class Client {

	public static void main(String[] args) {
		final Actor actor = new Actor();
		
		Actor cglibActor  =  (Actor) Enhancer.create(actor.getClass(), new MethodInterceptor() {
			/**
			 * ִ�б����������κη��������ᾭ���÷�����
			 * ���ͻ��ڽӿڶ�̬�����invoke������������һģһ����
			 * �����Ĳ�����
			 * 		ǰ��������invoke�����Ĳ�����������ö�һ��
			 * 		MethodProxy methodProxy:��ǰִ�з����Ĵ������һ�㲻��
			 */
			@Override
			public Object intercept(Object proxy, Method method, Object[] args,MethodProxy methodProxy) throws Throwable {
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
		cglibActor.basicAct(50000);
		cglibActor.dangerAct(100000);

	}

}
