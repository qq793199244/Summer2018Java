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
 * һ�����ڼ�¼��־����
 * @author WY
 *
 */

@Component("logger")
@Aspect //����������
public class Logger {
	
	@Pointcut("execution(* com.wangyue.service.impl.*.*(..))")
	private void pt1(){}
	
	/**
	 * ǰ��֪ͨ
	 */
	//@Before("pt1()")
	public void beforePrintLog(){
		System.out.println("ǰ�ã�Logger�е�beforePrintLog������ʼ��¼��־�ˡ�����");
	}
	
	/**
	 * ����֪ͨ
	 */
	//@AfterReturning("pt1()")
	public void afterReturningPrintLog(){
		System.out.println("���ã�Logger�е�afterReturningPrintLog������ʼ��¼��־�ˡ�����");
	}
	
	/**
	 * �쳣֪ͨ
	 */
	//@AfterThrowing("pt1()")
	public void afterThrowingPrintLog(){
		System.out.println("�쳣��Logger�е�afterThrowingPrintLog������ʼ��¼��־�ˡ�����");
	}
	
	/**
	 * ����֪ͨ
	 */
	//@After("pt1()")
	public void afterPrintLog(){
		System.out.println("���գ�Logger�е�afterPrintLog������ʼ��¼��־�ˡ�����");
	}
	
	
	
	/**
	 * ����֪ͨ
	 */
	@Around("pt1()")
	public Object aroundPrintLog(ProceedingJoinPoint pjp){
		Object rtValue = null;
		try {
			System.out.println("Logger�е�aroundPrintLog������ʼ��¼��־�ˡ�����ǰ��");
			rtValue = pjp.proceed();
			System.out.println("Logger�е�aroundPrintLog������ʼ��¼��־�ˡ���������");
		} catch (Throwable e) {
			System.out.println("Logger�е�aroundPrintLog������ʼ��¼��־�ˡ������쳣");
			e.printStackTrace();
		}finally{
			System.out.println("Logger�е�aroundPrintLog������ʼ��¼��־�ˡ���������");
		}
		return rtValue;
	}
	
	

}
