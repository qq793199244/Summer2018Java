package com.wangyue.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟一个剧组
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
				 * 执行被代理对象的任何方法都会经过该方法，该方法有拦截的功能
				 * 方法的参数
				 * 		Object proxy:代理对象的引用。不一定每次都会有
				 * 		Method method:当前执行的方法
				 * 		Object[] args:当前执行方法所需的参数
				 * 返回值：
				 * 		当前返回方法的返回值	
				 */
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						
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
	 	proxyActor.basicAct(50000);
	 	proxyActor.dangerAct(100000);
	 	

	}

}
