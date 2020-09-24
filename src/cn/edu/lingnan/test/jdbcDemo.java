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
		Statement prep = null;//������
		ResultSet rs = null;
		try {
			//com.mysql.cj.jdbc.Driver
			Class.forName("com.mysql.cj.jdbc.Driver");//ע����������
			//jdbc:mysql://localhost:3306/test?serverTimezone=UTC&characterEncoding=utf-8
			conn = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/school?serverTimezone=UTC&characterEncoding=utf-8","root","root");//��ȡ���ݿ����ӣ���ʱ���text�Ļ��Լ������ݿ������������û���������
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
			
			
//			����������			
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
			//����ɹ��������
			
			
			/*
			stat = conn.createStatement();//����SQL������
			rs = stat.executeQuery("select * from jk");//ִ�в�ѯ�õ����
			while(rs.next()) {
				System.out.println(rs.getString("id"));
			}
			*/
		} catch (ClassNotFoundException e) {
			System.out.println("MySql��jar��û�м��سɹ�������������");
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
				System.out.println("�ر�����ʱ�������쳣������������");
				e.printStackTrace();
			}
		}
	} 
}


