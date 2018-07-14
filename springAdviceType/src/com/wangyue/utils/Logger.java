package com.wangyue.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * һ�����ڼ�¼��־����
 * @author WY
 *
 */

public class Logger {
	
	/**
	 * ǰ��֪ͨ
	 */
	public void beforePrintLog(){
		System.out.println("Logger�е�beforePrintLog������ʼ��¼��־�ˡ�����");
	}
	
	/**
	 * ����֪ͨ
	 */
	public void afterReturningPrintLog(){
		System.out.println("Logger�е�afterReturningPrintLog������ʼ��¼��־�ˡ�����");
	}
	
	/**
	 * �쳣֪ͨ
	 */
	public void afterThrowingPrintLog(){
		System.out.println("Logger�е�afterThrowingPrintLog������ʼ��¼��־�ˡ�����");
	}
	
	/**
	 * ����֪ͨ
	 */
	public void afterPrintLog(){
		System.out.println("Logger�е�afterPrintLog������ʼ��¼��־�ˡ�����");
	}
	
	
	
	/**
	 * ����֪ͨ
	 */
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
