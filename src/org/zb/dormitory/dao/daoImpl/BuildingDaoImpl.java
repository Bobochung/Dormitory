package org.zb.dormitory.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.zb.dormitory.dao.BuildingDao;
import org.zb.dormitory.entity.Building;
import org.zb.dormitory.utils.DBUtil;

public class BuildingDaoImpl implements BuildingDao {


	private boolean isInvalid(String value) {
		// TODO Auto-generated method stub
		return (value == null || value.length() == 0);
	}

	@Override
	public List<Building> getAllBuilding(String strwhere, String strorder) {
		String sql="select * from building";
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
		List<Building> list = new ArrayList<>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				Building building=new Building();
				building.setBuilding_id(rs.getInt(1));
            	building.setBuilding_name(rs.getString(2));
            	building.setBuilding_introduction(rs.getString(3));  			
				list.add(building);
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
	public List<Building> list(int start, int count) {
		List<Building> buildings = new ArrayList<>();		 
        try {
            Connection c = new DBUtil().getConn();
 
            String sql = "select * from building order by Building_ID asc limit ?,? ";
 
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, count);
 
            ResultSet rs = ps.executeQuery();
 
            while (rs.next()) {
            	Building building = new Building();
            	building.setBuilding_id(rs.getInt(1));
            	building.setBuilding_name(rs.getString(2));
            	building.setBuilding_introduction(rs.getString(3));           	           		                
            	buildings.add(building);
            } 
            ps.close();	 
            c.close();	 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return buildings;
	}

	@Override
	public int countBuilding() {
		String sql="select count(*) from building";
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
	public Building GetBuilding(int id) {
		String sql="select * from building where Building_ID ="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBUtil().getConn();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				Building building = new Building();
				building.setBuilding_id(rs.getInt(1));
				building.setBuilding_name(rs.getString(2));
				building.setBuilding_introduction(rs.getString(3));
				return building;
			}
		}
		catch (Exception e) {
				// TODO: handle exception
			}		
		return null;
	}

	@Override
	public void Add(Building building) {
		String sql="insert into building values(null,?,?);";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new DBUtil().getConn();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, building.getBuilding_name());
			pstm.setString(2, building.getBuilding_introduction());
			pstm.execute();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void Update(Building building) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(String strwhere) {
		// TODO Auto-generated method stub
		
	}
//	测试
//	public static void main(String[] args) {
//		BuildingDao bd = new BuildingDaoImpl();
//		
//		for(Building building:bd.getAllBuilding("1=1", "Building_ID")){
//			System.out.println(building.getBuilding_name());
//		}
//		System.out.println(bd.countBuilding());
//	}

}
