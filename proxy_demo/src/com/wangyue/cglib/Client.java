package com.wangyue.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 模拟一个剧组
 * @author WY
 *---------这个项目跟jar包有很大的关系。直到我换成了cglib-full-2.0.2.jar才不报错了。-----------
 */

public class Client {

	public static void main(String[] args) {
		final Actor actor = new Actor();
		
		Actor cglibActor  =  (Actor) Enhancer.create(actor.getClass(), new MethodInterceptor() {
			/**
			 * 执行被代理对象的任何方法，都会经过该方法。
			 * 它和基于接口动态代理的invoke方法的作用是一模一样的
			 * 方法的参数：
			 * 		前面三个和invoke方法的参数含义和作用都一样
			 * 		MethodProxy methodProxy:当前执行方法的代理对象。一般不用
			 */
			@Override
			public Object intercept(Object proxy, Method method, Object[] args,MethodProxy methodProxy) throws Throwable {
				Object rtValue = null;
				//1.取出执行方法中的参数：给的多少钱
				Float money = (Float) args[0];
				//2.判断当前执行的是什么方法
				if("basicAct".equals(method.getName())){
					//基本演出
					if(money>10000){
						//执行方法，开始表演
						rtValue = method.invoke(actor, money);
					}
				}
				if("dangerAct".equals(method.getName())){
					//危险演出
					if(money>50000){
							//执行方法，开始表演
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
