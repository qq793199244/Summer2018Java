package com.wangyue.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.wangyue.dataSource.MyDataSource;

public class DataSourceTest {

	public static void main(String[] args) throws Exception {
		int size = MyDataSource.getPoolSize();
		System.out.println("ʹ������֮ǰ��"+size);
		Connection conn = MyDataSource.getConnection();
		System.out.println(conn);
		conn.close();//��ʱ���ܹرգ���������ӷŻس���
		
		int size1 = MyDataSource.getPoolSize();
		System.out.println("ʹ������֮��"+size1);

	}

}
