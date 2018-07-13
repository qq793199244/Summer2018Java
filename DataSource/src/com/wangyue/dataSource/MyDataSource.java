package com.wangyue.dataSource;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.wangyue.utils.JDBCUtil;

public class MyDataSource {
	//����һ���أ����ڴ������
	//��ArrayListת���̰߳�ȫ��
	private static List<Connection> pool = Collections.synchronizedList( new ArrayList<Connection>());
	
	//ʹ�þ�̬���������м�������
	static{
		for(int i=0;i<10;i++){
			Connection conn = JDBCUtil.getConnection();
			pool.add(conn);
		}
	}
	
	
	/**
	 * ��ȡһ������
	 * @return
	 */
	public static Connection getConnection(){
		final Connection conn = pool.remove(0);
		//�����������
		Connection proxyConn = (Connection) Proxy.newProxyInstance(conn.getClass().getClassLoader(),
				conn.getClass().getInterfaces(),
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						Object rtValue = null;
						// 1.�жϵ�ǰ�����ǲ���close����
						if("close".equals(method.getName())){
							//����ֱ�ӹر�
							pool.add(conn);//���س���
						}else{
							rtValue = method.invoke(conn, args);		
						}
						return rtValue;
					}
				});
		return proxyConn;
		
	}
	
	/**
	 * ��ȡ���е�������
	 * @return
	 */
	public static int getPoolSize(){
		int conn = pool.size();
		return conn;
		
	}

}
