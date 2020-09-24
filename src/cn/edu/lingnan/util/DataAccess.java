package cn.edu.lingnan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DataAccess {
	
	public static String driver = null;
	public static String url = null;
	public static String user = null;
	public static String password = null;
	public static String xsdPath = "database.conf.xsd";
	public static String xmlPath = "database.conf.xml";
	
	static {
		String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		xsdPath = basePath + xsdPath;
		xmlPath = basePath + xmlPath;
	}
	//��ȡ���ݿ�����
	public static Connection getConnection(){
		Connection conn = null;
		if(XmlValidator.validate(xsdPath, xmlPath)) {
			HashMap<String,String> hm = XmlParser.parser(xmlPath);
			driver = hm.get("driver");
			url = hm.get("url");
			user = hm.get("user");
			password = hm.get("password");
//			System.out.println(driver);
//			System.out.println(url);
//			System.out.println(user);
//			System.out.println(password);
		}
		try {
			Class.forName(driver);//ע����������
			conn = DriverManager.getConnection(url,user,password);//��ȡ���ݿ�����
		} catch (ClassNotFoundException e) {
			System.out.println("���ݿ������õ�Jar�����������⡤����������");
		} catch (SQLException e) {
			System.out.println("���ݿ����Ӳ������û����뻹�����ݿ������������⡤����������");
		}
		return conn;
	}
	
	
//	//��ȡ���ݿ�����
//		public static Connection getConnection(){
//			Connection conn = null;
//			try {
//				Class.forName("com.mysql.cj.jdbc.Driver");//ע����������
//				conn = DriverManager.getConnection
//						("jdbc:mysql://localhost:3306/test?serverTimezone=UTC&characterEncoding=utf-8","root","root");//��ȡ���ݿ����ӣ���ʱ���text�Ļ��Լ������ݿ������������û���������
//			} catch (ClassNotFoundException e) {
//				System.out.println("���ݿ������õ�Jar�����������⡤����������");
//			} catch (SQLException e) {
//				System.out.println("���ݿ����Ӳ������û����뻹�����ݿ������������⡤����������");
//			}
//			return conn;
//		}
	
	//�ر����ݿ�����
	public static void closeConnection
	    (Connection conn, Statement stat, ResultSet rs){
		try {
			if (rs!=null)
				rs.close();
		    if(stat!=null)
		    	stat.close();
		    if(conn!=null)
		    	conn.close();
		} catch (SQLException e) {
			System.out.println("�ر�����ʱ�������쳣������������");
			e.printStackTrace();
		}
	}
	
	//�ر����ݿ�����
	public static void closeConnection
		(Connection conn, PreparedStatement prep, ResultSet rs){
		try {
			if (rs!=null)
				rs.close();
			if(prep!=null)
			    prep.close();
			if(conn!=null)
			    conn.close();
		} catch (SQLException e) {
			System.out.println("�ر�����ʱ�������쳣������������");
			e.printStackTrace();
		}
	}
	
	//�ر����ݿ�����
	public static void closeConnection
	    (Connection conn, PreparedStatement prep){
		try {
			if(prep!=null)
				prep.close();
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			System.out.println("�ر�����ʱ�������쳣������������");
			e.printStackTrace();
		}
	}
	
	//�ر����ݿ�����
		public static void closeConnection
			(Connection conn, PreparedStatement prep1, PreparedStatement prep2, PreparedStatement prep3, ResultSet rs1, ResultSet rs2){
			try {
				if (rs2!=null)
					rs2.close();
				if (rs1!=null)
					rs1.close();
				if(prep3!=null)
				    prep3.close();
				if(prep2!=null)
				    prep2.close();
				if(prep1!=null)
				    prep1.close();
				if(conn!=null)
				    conn.close();
			} catch (SQLException e) {
				System.out.println("�ر�����ʱ�������쳣������������");
				e.printStackTrace();
			}
		}

}
