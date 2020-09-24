package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import cn.edu.lingnan.dto.Program;
import cn.edu.lingnan.dto.User;
import cn.edu.lingnan.util.DataAccess;


public class UserDAO {
	//���û�������������û�
//		public User findUserByNameAndPassword
//		    (String _name,String _password){
//			User ur = null;
//			Connection conn = null;
//			Statement stat = null;
//			ResultSet rs = null;
//			try {
//				conn = DataAccess.getConnection();
//				stat = conn.createStatement();//����SQL������
//				String sql = "select * from user where uname = '"
//						+ _name +"' and password = '" + _password +"'";
//				rs = stat.executeQuery(sql);//ִ�в�ѯ�õ����
//				while(rs.next()) {
//					ur = new User();
//					ur.setUid(rs.getString("uid"));
//					ur.setUname(rs.getString("uname"));
//					ur.setPassword(rs.getString("password"));
//					ur.setSuperuser(rs.getInt("superuser"));
//				}
//			}catch (SQLException e) {
//					e.printStackTrace();
//			} finally {
//				DataAccess.closeConnection(conn, stat, rs);
//			}
//			return ur;
//		}
	
	    //���û�������������û��Ƿ����
		//������ڣ������û���id����������ڣ�����0
		public String findStudentByNameAndPassword2(String _name){
			String id = null;
			Connection conn = null;
			Statement stat = null;
			ResultSet rs = null;
			try {
				conn = DataAccess.getConnection();
				stat = conn.createStatement();//����SQL������
				String sql = "select * from user where uname = '"+ _name +"'";
				rs = stat.executeQuery(sql);//ִ�в�ѯ�õ����
				if(rs.next())
					id = rs.getString("uid");
			}catch (SQLException e) {
					e.printStackTrace();
			} finally {
				DataAccess.closeConnection(conn, stat, rs);
			}
			return id;
		}
		
		//���û�������������û��Ƿ����
	    //������ڣ������û���Ȩ�ޣ���������ڣ�����0
		public int findUserByNameAndPassword
		    (String _name,String _password){
			int flag = 0;
			Connection conn = null;
			Statement stat = null;
			ResultSet rs = null;
			try {
				conn = DataAccess.getConnection();
				stat = conn.createStatement();//����SQL������
				String sql = "select * from user where uname = '"
						+ _name +"' and password = '" + _password +"'";
				rs = stat.executeQuery(sql);//ִ�в�ѯ�õ����
				if(rs.next())
					flag = rs.getInt("superuser");
			}catch (SQLException e) {
					e.printStackTrace();
			} finally {
				DataAccess.closeConnection(conn, stat, rs);
			}
			return flag;
		}
		
		//���û�id�����û��Ƿ����
	    //������ڣ������û������֣���������ڣ�����0
//		public User findUserNameById(String _uid){
//			User ur = null;
//			Connection conn = null;
//			Statement stat = null;
//			ResultSet rs = null;
//			try {
//				conn = DataAccess.getConnection();
//				stat = conn.createStatement();//����SQL������
//				String sql = "select * from user where uid = '" + _uid + "'";
//				rs = stat.executeQuery(sql);//ִ�в�ѯ�õ����
//				while(rs.next()) {
//					ur = new User();
//					ur.setUid(rs.getString("uid"));
//					ur.setUname(rs.getString("uid"));
//				}
//			}catch (SQLException e) {
//					e.printStackTrace();
//			} finally {
//				DataAccess.closeConnection(conn, stat, rs);
//			}
//			return ur;
//		}
		
		public String findUserNameById(String _uid){
			String name = null;
			Connection conn = null;
			Statement stat = null;
			ResultSet rs = null;
			try {
				conn = DataAccess.getConnection();
				stat = conn.createStatement();//����SQL������
				String sql = "select uname from user where uid = '"+ _uid +"'";
				rs = stat.executeQuery(sql);//ִ�в�ѯ�õ����
				if(rs.next())
					name = rs.getString("uname");
			}catch (SQLException e) {
					e.printStackTrace();
			} finally {
				DataAccess.closeConnection(conn, stat, rs);
			}
			return name;
	 	}
		
		//���������û���Ϣ
		public Vector<User> findAllUser(){
			Vector<User> v = new Vector<User>();
			Connection conn = null;
			Statement stat = null;
			ResultSet rs = null;
			try {
				conn = DataAccess.getConnection();
				stat = conn.createStatement();//����SQL������
				String sql = "select * from user";
				rs = stat.executeQuery(sql);//ִ�в�ѯ�õ����
				while(rs.next()) {
					User u = new User();
					u.setUid(rs.getString("uid"));
					u.setUname(rs.getString("uname"));
					u.setPassword(rs.getString("password"));
					u.setSuperuser(rs.getInt("superuser"));
					v.add(u);	
				}	
			}catch (SQLException e) {
					e.printStackTrace();
			} finally {
				DataAccess.closeConnection(conn, stat, rs);
			}
			return v;
		}
		
		//�洢�����û���
		public ArrayList<String> findAllUserName(){
			ArrayList<String> username = new ArrayList<String>();
			Connection conn = null;
			Statement stat = null;
			ResultSet rs = null;
			try {
				conn = DataAccess.getConnection();
				stat = conn.createStatement();//����SQL������
				String sql = "select uname from user";
				rs = stat.executeQuery(sql);//ִ�в�ѯ�õ����
				while(rs.next()) {
					username.add(rs.getString(1));
				}	
			}catch (SQLException e) {
					e.printStackTrace();
			} finally {
				DataAccess.closeConnection(conn, stat, rs);
			}
			return username;
		}
		
		//����һ���û���¼���൱��ע��һ���û���Ϣ
		public boolean insertInfoToUser(User _u) {
			boolean flag = false;
			Connection conn = null;
			PreparedStatement prep = null;
			try {
				conn = DataAccess.getConnection();
				prep = conn.prepareStatement
					("insert into user values(?,?,?,?)");
				prep.setString(1, _u.getUid());
				prep.setString(2, _u.getUname());
				prep.setString(3, _u.getPassword());
				prep.setInt(4, _u.getSuperuser());
				prep.executeUpdate();
				flag = true;
			}catch (SQLException e) {
					e.printStackTrace();
			} finally {
				DataAccess.closeConnection(conn, prep);
			}	
			return flag;
		}
		
//		public void insertInfoToUser(User _u) {
//			Connection conn = null;
//			PreparedStatement prep = null;
//			try {
//				conn = DataAccess.getConnection();
//				prep = conn.prepareStatement
//					("insert into user values(?,?,?,?)");
//				prep.setString(1, _u.getUid());
//				prep.setString(2, _u.getUname());
//				prep.setString(3, _u.getPassword());
//				prep.setInt(4, _u.getSuperuser());
//				prep.executeUpdate();
//			}catch (SQLException e) {
//					e.printStackTrace();
//			} finally {
//				DataAccess.closeConnection(conn, prep);
//			}	
//		}
		
		
		//����Ľ�
		//���û�IDɾ��һ����¼
		public boolean deleteUser(String _uid){//��Ϊvoid�޷���ֵʱ��boolean��Ϊvoid
			boolean flag = false;  //��Ϊvoid�޷���ֵʱע�͵�
			Connection conn = null;
			PreparedStatement prep1 = null;
			PreparedStatement prep2 = null;
			PreparedStatement prep3 = null;
			ResultSet rs1 = null;
			ResultSet rs2 = null;
			try {
				conn = DataAccess.getConnection();
				//������Ҫɾ����CID
				prep1 = conn.prepareStatement
						("select * from score where uid = ?");
				prep1.setString(1, _uid);
				rs1 = prep1.executeQuery();
				HashSet<String> h = new HashSet<String>();
				while(rs1.next()) {
					//System.out.println(rs1.getString("cid"));
					//�ж����Ŀ�ܲ���ɾ����������Ŀֻ��_uidһ���˱��ˣ����ĿҪɾ��
					prep2 = conn.prepareStatement
							("select count(*) as num from score where pid = ?");
					prep2.setString(1, rs1.getString("pid"));
					rs2 = prep2.executeQuery();
					while(rs2.next()) {			
						if(Integer.parseInt(rs2.getString("num"))==1) {
							System.out.println(rs1.getString("pid")+"    "+rs2.getString("num"));
							h.add(rs1.getString("pid"));
						}
					}			
				}
				conn.setAutoCommit(false);
				//��ɾ������ (��ʱ��ĳ�update��־��)
				prep3 = conn.prepareStatement
						("delete from score where uid = ?");
				prep3.setString(1, _uid);
				prep3.executeUpdate();	
				//��ɾ�û���
				prep3 = conn.prepareStatement
					("delete from user where uid = ?");
				prep3.setString(1, _uid);
				prep3.executeUpdate();	
//				//���ɾ��Ŀ��
//				Iterator<String> it = h.iterator();
//				while(it.hasNext()) {
//					prep3 = conn.prepareStatement
//						("delete from program where pid = ?");
//					prep3.setString(1, it.next());
//					prep3.executeUpdate();
//				}
				conn.commit();
				conn.setAutoCommit(true);
				flag = true;  //��Ϊvoid�޷���ֵʱע�͵�
			}catch (SQLException e) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			} finally {
				//�ر����д򿪵����ӡ���䡢���������
				DataAccess.closeConnection(conn, prep1, prep2, prep3, rs1, rs2);
			}
			return flag; //��Ϊvoid�޷���ֵʱע�͵�
		}
		
		//���½�Ŀ��Ϣ
		public boolean updateUser(User _u){
			boolean flag = false;
			Connection conn = null;
			PreparedStatement prep = null;
			try {
				conn = DataAccess.getConnection();
				prep = conn.prepareStatement
					("update user set uname=?,password=?,superuser=? where uid=?");
				prep.setString(1, _u.getUname());
				prep.setString(2, _u.getPassword());
				prep.setInt(3, _u.getSuperuser());
				prep.setString(4, _u.getUid());
				prep.executeUpdate();
				flag = true;
			}catch (SQLException e) {
					e.printStackTrace();
			} finally {
				DataAccess.closeConnection(conn, prep);
			}
			return flag;
		}	
		
//		public void updateUser(User _u){
//			Connection conn = null;
//			PreparedStatement prep = null;
//			try {
//				conn = DataAccess.getConnection();
//				prep = conn.prepareStatement
//					("update user set uname=?,password=?,superuser=? where uid=?");
//				prep.setString(1, _u.getUname());
//				prep.setString(2, _u.getPassword());
//				prep.setInt(3, _u.getSuperuser());
//				prep.setString(4, _u.getUid());
//				prep.executeUpdate();
//			}catch (SQLException e) {
//					e.printStackTrace();
//			} finally {
//				DataAccess.closeConnection(conn, prep);
//			}
//		}	
}
