package com.wangyue.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 一个用于记录日志的类
 * @author WY
 *
 */

public class Logger {
	
	/**
	 * 前置通知
	 */
	public void beforePrintLog(){
		System.out.println("Logger中的beforePrintLog方法开始记录日志了。。。");
	}
	
	/**
	 * 后置通知
	 */
	public void afterReturningPrintLog(){
		System.out.println("Logger中的afterReturningPrintLog方法开始记录日志了。。。");
	}
	
	/**
	 * 异常通知
	 */
	public void afterThrowingPrintLog(){
		System.out.println("Logger中的afterThrowingPrintLog方法开始记录日志了。。。");
	}
	
	/**
	 * 最终通知
	 */
	public void afterPrintLog(){
		System.out.println("Logger中的afterPrintLog方法开始记录日志了。。。");
	}
	
	
	
	/**
	 * 环绕通知
	 */
	public Object aroundPrintLog(ProceedingJoinPoint pjp){
		Object rtValue = null;
		try {
			System.out.println("Logger中的aroundPrintLog方法开始记录日志了。。。前置");
			rtValue = pjp.proceed();
			System.out.println("Logger中的aroundPrintLog方法开始记录日志了。。。后置");
		} catch (Throwable e) {
			System.out.println("Logger中的aroundPrintLog方法开始记录日志了。。。异常");
			e.printStackTrace();
		}finally{
			System.out.println("Logger中的aroundPrintLog方法开始记录日志了。。。最终");
		}
		return rtValue;
	}
	
	

}
