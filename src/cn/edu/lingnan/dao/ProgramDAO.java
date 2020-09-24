package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

import com.mysql.cj.protocol.Resultset;

import cn.edu.lingnan.dto.Program;
import cn.edu.lingnan.util.DataAccess;

public class ProgramDAO {
	//����Ŀ�Ų��ҽ�Ŀ��Ϣ
	public Program findProgramByPid(String _pid) {
		Program pro = null;
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stat = conn.createStatement();//����SQL������
			String sql = "select * from program where pid = '" + _pid + "'";
			rs = stat.executeQuery(sql);//ִ�в�ѯ�õ����
			while(rs.next()) {
//				String pid = rs.getString("pid");
//				String pname = rs.getString("pname");
//				String performer = rs.getString("performer");
//				System.out.println(pid + " " + pname + " " + performer);
				pro = new Program();
				pro.setPid(rs.getString("pid"));
				pro.setPname(rs.getString("pname"));
				pro.setShowtime(rs.getString("showtime"));
			}
		}catch (SQLException e) {
				e.printStackTrace();
		} finally {
			DataAccess.closeConnection(conn, stat, rs);
		}
		return pro;
	}
	
	//�������н�Ŀ��Ϣ
	public Vector<Program> findAllProgram(){
		Vector<Program> v = new Vector<Program>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stat = conn.createStatement();//����SQL������
			String sql = "select * from program";
			rs = stat.executeQuery(sql);//ִ�в�ѯ�õ����
			while(rs.next()) {
				Program p = new Program();
				p.setPid(rs.getString("Pid"));
				p.setPname(rs.getString("Pname"));
				p.setShowtime(rs.getString("showtime"));
				v.add(p);	
			}	
		}catch (SQLException e) {
				e.printStackTrace();
		} finally {
			DataAccess.closeConnection(conn, stat, rs);
		}
		return v;
	}
	
	//����һ����Ŀ��¼���൱��ע��һ����Ŀ��Ϣ
	public boolean insertInfoToProgram(Program _p) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement
				("insert into program values(?,?,?)");
			prep.setString(1, _p.getPid());
			prep.setString(2, _p.getPname());
			prep.setString(3, _p.getShowtime());
			prep.executeUpdate();
			flag = true;
		}catch (SQLException e) {
				e.printStackTrace();
	}
		finally {
			DataAccess.closeConnection(conn, prep);
		}	
		return flag;
	}
//	public void insertInfoToProgram(Program _p) {
//		Connection conn = null;
//		PreparedStatement prep = null;
//		try {
//			conn = DataAccess.getConnection();
//			prep = conn.prepareStatement
//				("insert into program values(?,?,?)");
//			prep.setString(1, _p.getPid());
//			prep.setString(2, _p.getPname());
//			prep.setString(3, _p.getShowtime());
//			prep.executeUpdate();
//		}catch (SQLException e) {
//				e.printStackTrace();
//	}
//		finally {
//			DataAccess.closeConnection(conn, prep);
//		}	
//	}
	
	
	
	//����ĿIDɾ��һ����¼  //����Ҫ����ֻ�н�Ŀ���м�¼ʱɾ����Ŀ��
	public boolean deletePro(String _pid){
		boolean flag = false;  //��Ϊvoid�޷���ֵʱע�͵�
		Connection conn = null;
		PreparedStatement prep1 = null;
		PreparedStatement prep2 = null;
		PreparedStatement prep3 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try {
			conn = DataAccess.getConnection();
			//������Ҫɾ����PID
			prep1 = conn.prepareStatement
					("select * from score where pid = ?");
			prep1.setString(1, _pid);
			rs1 = prep1.executeQuery();
			HashSet<String> h = new HashSet<String>();
			while(rs1.next()) {
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
					("delete from score where pid = ?");
			prep3.setString(1, _pid);
			prep3.executeUpdate();	
			//���ɾ��Ŀ��
			Iterator<String> it = h.iterator();
			while(it.hasNext()) {
				prep3 = conn.prepareStatement
					("delete from program where pid = ?");
				prep3.setString(1, it.next());
				prep3.executeUpdate();
			}
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
	public boolean updateStu(Program _p){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement
				("update program set pname=?,showtime=? where pid=?");
			prep.setString(1, _p.getPname());
			prep.setString(2, _p.getShowtime());
			prep.setString(3, _p.getPid());
			prep.executeUpdate();
			flag = true;
		}catch (SQLException e) {
				e.printStackTrace();
		} finally {
			DataAccess.closeConnection(conn, prep);
		}
		return flag;
	}
//	public void updateStu(Program _s){
//		Connection conn = null;
//		PreparedStatement prep = null;
//		try {
//			conn = DataAccess.getConnection();
//			prep = conn.prepareStatement
//				("update program set pname=?,showtime=? where pid=?");
//			prep.setString(1, _s.getPname());
//			prep.setString(2, _s.getPid());
//			prep.setString(3, _s.getShowtime());
//			prep.executeUpdate();
//		}catch (SQLException e) {
//				e.printStackTrace();
//		} finally {
//			DataAccess.closeConnection(conn, prep);
//		}
//	}
}
