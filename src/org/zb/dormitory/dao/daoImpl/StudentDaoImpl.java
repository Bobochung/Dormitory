package org.zb.dormitory.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.zb.dormitory.dao.StudentDao;
import org.zb.dormitory.entity.Student;
import org.zb.dormitory.utils.DBUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> getAllStudent(String strwhere, String strorder) {
		String sql="select * from student";
		if(!(isInvalid(strwhere)))
		{
			sql+=" where "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBUtil().getConn();
		List<Student> list = new ArrayList<>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				Student student=new Student();
				student.setStudent_id(rs.getInt(1));
            	student.setStudent_dormitoryid(rs.getInt(2));
            	student.setStudent_username(rs.getString(3));
            	student.setStudent_password(rs.getString(4));
            	student.setStudent_name(rs.getString(5));
            	student.setStudent_sex(rs.getString(6));
            	student.setStudent_class(rs.getString(7));
            	student.setStudent_state(rs.getString(8));				
				list.add(student);
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

	@Override
	public List<Student> list(int start, int count) {
		List<Student> students = new ArrayList<>();
		 
        try {
            Connection c = new DBUtil().getConn();
 
            String sql = "select * from student order by Student_ID asc limit ?,? ";
 
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, count);
 
            ResultSet rs = ps.executeQuery();
 
            while (rs.next()) {
            	Student student = new Student();
            	student.setStudent_id(rs.getInt(1));
            	student.setStudent_dormitoryid(rs.getInt(2));
            	student.setStudent_username(rs.getString(3));
            	student.setStudent_password(rs.getString(4));
            	student.setStudent_name(rs.getString(5));
            	student.setStudent_sex(rs.getString(6));
            	student.setStudent_class(rs.getString(7));
            	student.setStudent_state(rs.getString(8));           		                
            	students.add(student);
            }
 
            ps.close();	 
            c.close();	 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return students;
	}

	@Override
	public int countStudent() {
		String sql="select count(*) from student";
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
	public Student GetBean(int id) {
		// TODO Auto-generated method stub
		return null;
	}
//
	@Override
	public void Add(Student student) {
		String sql = "insert into student values(null,?,?,null,?,?,?,?);";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new DBUtil().getConn();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, student.getStudent_dormitoryid());
			pstm.setString(2, student.getStudent_username());
			pstm.setString(3, student.getStudent_name());
			pstm.setString(4, student.getStudent_sex());
			pstm.setString(5, student.getStudent_class());
			pstm.setString(6, student.getStudent_state());
			pstm.execute();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void Update(Student teacher) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Delete(String strwhere) {
		// TODO Auto-generated method stub

	}
	private boolean isInvalid(String value) {
		// TODO Auto-generated method stub
		return (value == null || value.length() == 0);
	}
//	测试
//	public static void main(String[] args) {
//		StudentDao sd = new StudentDaoImpl();
//		for(Student student:sd.getAllStudent("", "Student_ID")){
//			System.out.println(student.getStudent_name());
//			
//		}
//	}

	@Override
	public Student GetBean(String username) {
		Student student = null;
		String sql = "select * from student where Student_Username = "+username;
		Statement statement = null;
		Connection connection = new DBUtil().getConn();
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				student = new Student(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
				return student;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
				
		
		return null;
	}

}
