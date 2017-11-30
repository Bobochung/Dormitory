package org.zb.dormitory.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.zb.dormitory.dao.AdminDao;
import org.zb.dormitory.entity.Admin;
import org.zb.dormitory.utils.DBUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public boolean addAdmin(String username, String password) {
		
		String sql="insert into admin(Admin_Username,Admin_Password) values(?,?)";		
		Connection connection=new DBUtil().getConn();
		PreparedStatement ps=null;
		try {
			ps=connection.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.execute();			
			return true;			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;		
		

	}

	@Override
	public Admin getAdminByUsername(String username) {
		String sql="select * from admin where Admin_Username = ?";
		Connection c = null;
		PreparedStatement pstm=null;
		try {
			c = new DBUtil().getConn();
			pstm= c.prepareStatement(sql);
			pstm.setString(1, username);
			ResultSet rs = pstm.executeQuery();
			Admin admin = new Admin();
			while(rs.next()) {
				admin.setAdmin_id(rs.getInt(1));
				admin.setAdmin_username(rs.getString(2));
				admin.setAdmin_password(rs.getString(3));	
				admin.setAdmin_name(rs.getString(4));
				admin.setAdmin_sex(rs.getString(5));
				admin.setAdmin_tel(rs.getString(6));
			}			
			return admin;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();			
		}	
		finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

}

	@Override
	public Admin getAdminByUsernameAndPassword(String username, String password) {
		String sql="select * from admin where Admin_Username = ? and Admin_Password = ?";
		Connection c = null;
		PreparedStatement pstm=null;
		try {
			c = new DBUtil().getConn();
			pstm= c.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, password);
			ResultSet rs = pstm.executeQuery();
			Admin admin = new Admin();
			while(rs.next()) {
				admin.setAdmin_username(rs.getString("Admin_Username"));
				admin.setAdmin_password(rs.getString("Admin_Password"));				
			}			
			return admin;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();			
		}	
		finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
}
//	测试
//	public static void main(String[] args) {
//		AdminDao adminDao=new AdminDaoImpl();
//		System.out.println(adminDao.addAdmin("admin", MD5Util.MD5("123")));
//		
//	}
}
