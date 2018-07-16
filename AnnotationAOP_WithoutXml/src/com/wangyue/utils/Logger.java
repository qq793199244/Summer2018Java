package com.wangyue.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * 一个用于记录日志的类
 * @author WY
 *
 */

@Component("logger")
@Aspect //配置了切面
public class Logger {
	
	@Pointcut("execution(* com.wangyue.service.impl.*.*(..))")
	private void pt1(){}
	
	/**
	 * 前置通知
	 */
	//@Before("pt1()")
	public void beforePrintLog(){
		System.out.println("前置：Logger中的beforePrintLog方法开始记录日志了。。。");
	}
	
	/**
	 * 后置通知
	 */
	//@AfterReturning("pt1()")
	public void afterReturningPrintLog(){
		System.out.println("后置：Logger中的afterReturningPrintLog方法开始记录日志了。。。");
	}
	
	/**
	 * 异常通知
	 */
	//@AfterThrowing("pt1()")
	public void afterThrowingPrintLog(){
		System.out.println("异常：Logger中的afterThrowingPrintLog方法开始记录日志了。。。");
	}
	
	/**
	 * 最终通知
	 */
	//@After("pt1()")
	public void afterPrintLog(){
		System.out.println("最终：Logger中的afterPrintLog方法开始记录日志了。。。");
	}
	
	
	
	/**
	 * 环绕通知
	 */
	@Around("pt1()")
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
