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
	//获取数据库连接
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
			Class.forName(driver);//注册驱动程序
			conn = DriverManager.getConnection(url,user,password);//获取数据库连接
		} catch (ClassNotFoundException e) {
			System.out.println("数据库连接用的Jar包加载有问题······");
		} catch (SQLException e) {
			System.out.println("数据库连接参数（用户密码还是数据库名？）有问题······");
		}
		return conn;
	}
	
	
//	//获取数据库连接
//		public static Connection getConnection(){
//			Connection conn = null;
//			try {
//				Class.forName("com.mysql.cj.jdbc.Driver");//注册驱动程序
//				conn = DriverManager.getConnection
//						("jdbc:mysql://localhost:3306/test?serverTimezone=UTC&characterEncoding=utf-8","root","root");//获取数据库连接；到时候把text改回自己的数据库名，后面是用户名和密码
//			} catch (ClassNotFoundException e) {
//				System.out.println("数据库连接用的Jar包加载有问题······");
//			} catch (SQLException e) {
//				System.out.println("数据库连接参数（用户密码还是数据库名？）有问题······");
//			}
//			return conn;
//		}
	
	//关闭数据库连接
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
			System.out.println("关闭连接时发生了异常······");
			e.printStackTrace();
		}
	}
	
	//关闭数据库连接
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
			System.out.println("关闭连接时发生了异常······");
			e.printStackTrace();
		}
	}
	
	//关闭数据库连接
	public static void closeConnection
	    (Connection conn, PreparedStatement prep){
		try {
			if(prep!=null)
				prep.close();
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			System.out.println("关闭连接时发生了异常······");
			e.printStackTrace();
		}
	}
	
	//关闭数据库连接
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
				System.out.println("关闭连接时发生了异常······");
				e.printStackTrace();
			}
		}

}
