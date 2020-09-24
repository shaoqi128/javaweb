 package cn.edu.lingnan.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDemo {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		Statement prep = null;//批处理
		ResultSet rs = null;
		try {
			//com.mysql.cj.jdbc.Driver
			Class.forName("com.mysql.cj.jdbc.Driver");//注册驱动程序
			//jdbc:mysql://localhost:3306/test?serverTimezone=UTC&characterEncoding=utf-8
			conn = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/school?serverTimezone=UTC&characterEncoding=utf-8","root","root");//获取数据库连接；到时候把text改回自己的数据库名，后面是用户名和密码
			stat = conn.createStatement
					(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stat.executeQuery("select * from student");
			//System.out.println(rs.isBeforeFirst());
			rs.absolute(5);
			rs.relative(-2);
			//System.out.println(rs.getString("sid"));
			rs.last();
			//System.out.println(rs.getString("sid"));
			rs.beforeFirst();
			while(rs.next()) {
				System.out.println(rs.getString("sid"));
			}
			System.out.println(rs.isAfterLast());
			//-------------------------
			rs.moveToInsertRow();
			rs.updateString("sid", "s08");
			rs.updateString("sname", "s08");
			rs.updateString("password", "s08");
			rs.insertRow();
			rs.absolute(5);
			rs.updateString("sname", "zhangsan");
			rs.updateRow();
			rs.absolute(6);
			rs.deleteRow();
			
			
//			进行批处理			
//			prep = conn.prepareStatement
//				("insert into student values(?,?,?)");			
//			prep.setString(1, "s05");
//			prep.setString(2, "s05");
//			prep.setString(3, "s05");
//			prep.addBatch();
//			prep.setString(1, "s06");
//			prep.setString(2, "s06");
//			prep.setString(3, "s06");
//			prep.addBatch();
//			prep.setString(1, "s07");
//			prep.setString(2, "s07");
//			prep.setString(3, "s07");
//			prep.addBatch();
//			int [] a =prep.executeBatch();
//			for(int b : a)
//				System.out.println(b);
			//输出成功语句条数
			
			
			/*
			stat = conn.createStatement();//创建SQL语句对象
			rs = stat.executeQuery("select * from jk");//执行查询得到结果
			while(rs.next()) {
				System.out.println(rs.getString("id"));
			}
			*/
		} catch (ClassNotFoundException e) {
			System.out.println("MySql的jar包没有加载成功······");
			e.printStackTrace();
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
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
	} 
}


