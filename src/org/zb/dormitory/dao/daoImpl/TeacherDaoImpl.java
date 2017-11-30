package org.zb.dormitory.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.zb.dormitory.dao.TeacherDao;
import org.zb.dormitory.entity.Teacher;
import org.zb.dormitory.utils.DBUtil;


public class TeacherDaoImpl implements TeacherDao {

	@Override
	public List<Teacher> getAllTeacher(String strwhere, String strorder) {
		
		String sql="select * from teacher";
		if(!(isInvalid(strwhere)))
		{
			sql+=" where "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
		System.out.println(strwhere);
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBUtil().getConn();
		List<Teacher> list = new ArrayList<>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				Teacher teacher=new Teacher();
				teacher.setTeacher_id(rs.getInt("Teacher_ID"));
				teacher.setTeacher_username(rs.getString("Teacher_Username"));
				teacher.setTeacher_password(rs.getString("Teacher_Password"));
				teacher.setTeacher_name(rs.getString("Teacher_Name"));
				teacher.setTeacher_sex(rs.getString("Teacher_Sex"));
				teacher.setTeacher_tel(rs.getString("Teacher_Tel"));
				list.add(teacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	private boolean isInvalid(String value) {
		// TODO Auto-generated method stub
		return (value == null || value.length() == 0);
	}

	@Override
	public String CheckLogin(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean CheckPassword(String id, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Teacher GetBean(int id) {
		Teacher teacher = null;
		String sql = "select * from teacher where Teacher_ID ="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBUtil().getConn();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				teacher = new Teacher();
				teacher.setTeacher_id(id);
				teacher.setTeacher_username(rs.getString(2));
				teacher.setTeacher_password(rs.getString(3));
				teacher.setTeacher_name(rs.getString(4));
				teacher.setTeacher_sex(rs.getString(5));
				teacher.setTeacher_tel(rs.getString(6));
			}
		}
		catch (Exception e) {
				// TODO: handle exception
			}		
		return teacher;
	}

	@Override
	public boolean Add(Teacher teacher) {
		String sql = "insert into teacher values(null,?,?,?,?,?)";		
		Connection conn = new DBUtil().getConn();
		PreparedStatement pstm = null;
		try{
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, teacher.getTeacher_username());
			pstm.setString(2, teacher.getTeacher_password());
			pstm.setString(3, teacher.getTeacher_name());
			pstm.setString(4, teacher.getTeacher_sex());
			pstm.setString(5, teacher.getTeacher_tel());
			return pstm.execute();
		}
		catch (Exception e) {
				e.printStackTrace();
		}
		return false;		
		
	}

	@Override
	public boolean Update(Teacher teacher) {
		String sql = "update teacher set Teacher_Username= ?,"
				+ "Teacher_Password = ?,"
				+ "Teacher_Name = ?,"
				+ "Teacher_Sex = ?,"
				+ "Teacher_Tel = ?"
				+ "where Teacher_ID = ?";		
		Connection conn = new DBUtil().getConn();
		PreparedStatement pstm = null;
		try{
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, teacher.getTeacher_username());
			pstm.setString(2, teacher.getTeacher_password());
			pstm.setString(3, teacher.getTeacher_name());
			pstm.setString(4, teacher.getTeacher_sex());
			pstm.setString(5, teacher.getTeacher_tel());
			pstm.setInt(6, teacher.getTeacher_id());
			return pstm.execute();
		}
		catch (Exception e) {
				e.printStackTrace();
		}
		return false;
		
		
	}

	@Override
	public boolean Delete(int id) {
		String sql = "delete from teacher where Teacher_ID = "+id;		
		Connection conn = new DBUtil().getConn();
		try {
			Statement st = conn.createStatement();
			return st.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;		
	}

	@Override
	public int countTeacher() {
		String sql="select count(*) from teacher";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBUtil().getConn();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				return rs.getInt(1);
			}
		}
		catch (Exception e) {
				// TODO: handle exception
			}		
		return 0;
	}

	@Override
	public List<Teacher> list(int start, int count){
		// TODO Auto-generated method stub
		 List<Teacher> teachers = new ArrayList<>();
		 
	        try {
	           
	 
	            Connection c = new DBUtil().getConn();
	 
	            String sql = "select * from teacher order by Teacher_ID asc limit ?,? ";
	 
	            PreparedStatement ps = c.prepareStatement(sql);
	            ps.setInt(1, start);
	            ps.setInt(2, count);
	 
	            ResultSet rs = ps.executeQuery();
	 
	            while (rs.next()) {
	            	Teacher teacher = new Teacher();
	            	teacher.setTeacher_id(rs.getInt(1));
	            	teacher.setTeacher_username(rs.getString(2));
	            	teacher.setTeacher_name(rs.getString(4));
	            	teacher.setTeacher_sex(rs.getString(5));
	            	teacher.setTeacher_tel(rs.getString(6));	                
	            	teachers.add(teacher);
	            }
	 
	            ps.close();	 
	            c.close();	 
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return teachers;
	   
	}
	

}
