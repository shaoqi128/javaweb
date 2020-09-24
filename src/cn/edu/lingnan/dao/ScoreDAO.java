package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.Program;
import cn.edu.lingnan.dto.Score;
import cn.edu.lingnan.util.DataAccess;

public class ScoreDAO {
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
		
		//�������з�����ļ�¼
		public Vector<Score> findAllScore(){
			Vector<Score> v = new Vector<Score>();
			Connection conn = null;
			Statement stat = null;
			ResultSet rs = null;
			try {
				conn = DataAccess.getConnection();
				stat = conn.createStatement();//����SQL������
				String sql = "select * from score";
				rs = stat.executeQuery(sql);//ִ�в�ѯ�õ����
				while(rs.next()) {
					Score s = new Score();
					s.setUid(rs.getString("uid"));
					s.setPid(rs.getString("pid"));
					s.setScore(rs.getInt("score"));
					v.add(s);	
				}	
			}catch (SQLException e) {
					e.printStackTrace();
			} finally {
				DataAccess.closeConnection(conn, stat, rs);
			}
			return v;
		}
		
	//�μӽ�Ŀ
	public boolean insertInfoToScore(Score _s) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement
				("insert into score values(?,?,?)");
			prep.setString(1, _s.getUid());
			prep.setString(2, _s.getPid());
			prep.setString(3, null);
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
	//�鿴�μӵĽ�Ŀ
	public Vector<Score> findScore(String _uid){
		Vector<Score> v = new Vector<Score>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement
			("select uid,pid from score where uid = ?");
			prep.setString(1, _uid);
			rs = prep.executeQuery();
			while(rs.next()) {
				Score s = new Score();
				s.setUid(rs.getString("uid"));
				s.setPid(rs.getString("pid"));
				v.add(s);	
			}	
		}catch (SQLException e) {
				e.printStackTrace();
		} finally {
			DataAccess.closeConnection(conn, prep, rs);
		}
		return v;
	}
	//�˳���Ŀ
	public boolean deleteScore(String _uid, String _pid){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement
					("delete from score where uid = ? and pid = ?");
			prep.setString(1, _uid);
			prep.setString(2, _pid);
			prep.executeUpdate();
			flag = true;
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//�ر����д򿪵����ӡ���䡢���������
			DataAccess.closeConnection(conn, prep);
		}
		return flag;
	}
//	public void deletePro(String _pid){
//		Connection conn = null;
//		PreparedStatement prep = null;
//		try {
//			conn = DataAccess.getConnection();
//			prep = conn.prepareStatement
//					("delete from score where pid = ?");
//			prep.setString(1, _pid);
//			prep.executeUpdate();	
//		}catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			//�ر����д򿪵����ӡ���䡢���������
//			DataAccess.closeConnection(conn, prep);
//		}
//	}

}
