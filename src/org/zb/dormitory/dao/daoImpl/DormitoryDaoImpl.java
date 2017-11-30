package org.zb.dormitory.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.zb.dormitory.dao.BuildingDao;
import org.zb.dormitory.dao.DormitoryDao;
import org.zb.dormitory.entity.Dormitory;
import org.zb.dormitory.utils.DBUtil;

public class DormitoryDaoImpl implements DormitoryDao {
	
	BuildingDao bd = new BuildingDaoImpl();

	private boolean isInvalid(String value) {
		// TODO Auto-generated method stub
		return (value == null || value.length() == 0);
	}
	@Override
	public List<Dormitory> getAllDormitory(String strwhere, String strorder) {
		String sql="select * from domitory";
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
		List<Dormitory> list = new ArrayList<>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				Dormitory dormitory=new Dormitory();
//				编号
				dormitory.setDomitory_id(rs.getInt(1));
//				楼宇
				dormitory.setBuilding_name(bd.GetBuilding(rs.getInt(2)).getBuilding_name());
//				寝室号
				dormitory.setDomitory_name(rs.getString(3));
//				寝室类型
				dormitory.setDomitory_type(rs.getString(4));
//				寝室人数
				dormitory.setDomitory_number(rs.getString(5));
//				电话
				dormitory.setDomitory_tel(rs.getString(6));
								 			
				list.add(dormitory);
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
	public List<Dormitory> list(int start, int count) {
		List<Dormitory> dormitories = new ArrayList<>();		 
        try {
            Connection c = new DBUtil().getConn();
 
            String sql = "select * from domitory order by Domitory_ID asc limit ?,? ";
 
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, count);
 
            ResultSet rs = ps.executeQuery();
 
            while (rs.next()) {
            	Dormitory dormitory = new Dormitory();
//				编号
				dormitory.setDomitory_id(rs.getInt(1));
//				楼宇
				dormitory.setBuilding_name(bd.GetBuilding(rs.getInt(2)).getBuilding_name());
//				寝室号
				dormitory.setDomitory_name(rs.getString(3));
//				寝室类型
				dormitory.setDomitory_type(rs.getString(4));
//				寝室人数
				dormitory.setDomitory_number(rs.getString(5));
//				电话
				dormitory.setDomitory_tel(rs.getString(6));         	           		                
            	dormitories.add(dormitory);
            } 
            ps.close();	 
            c.close();	 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dormitories;
	}

	@Override
	public int countDormitory() {
		String sql="select count(*) from domitory";
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
	public Dormitory GetDormitory(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void Add(Dormitory dormitory) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update(Dormitory dormitory) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Delete(String strwhere) {
		// TODO Auto-generated method stub

	}
//	测试
	public static void main(String[] args) {
		DormitoryDao dd = new DormitoryDaoImpl();
		
		for(Dormitory dormitory:dd.list(0, 5)){
			System.out.println(dormitory.toString());
		}
		System.out.println(dd.countDormitory());
	}

}
