package org.zb.dormitory.service.serviceImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zb.dormitory.dao.BuildingDao;
import org.zb.dormitory.dao.daoImpl.BuildingDaoImpl;
import org.zb.dormitory.entity.Building;
import org.zb.dormitory.keys.Keys;
import org.zb.dormitory.service.BuildingService;

public class BuildingServiceImpl implements BuildingService {

	BuildingDao bd = new BuildingDaoImpl();
	private String SearchKey;
	@Override
	public List<Building> listAllBuilding(HttpServletRequest request) {
		String strWhere="1=1";
		if(!(isInvalid(SearchKey)))
		{
			strWhere+=" and Building_Name = '"+SearchKey+"'";
		}		
		List<Building> list =bd.getAllBuilding(strWhere, "Building_ID");				
		return list;
	}

	@Override
	public List<Building> pageList(HttpServletRequest request, HttpServletResponse response) {
		List<Building> list	= null;
		SearchKey=request.getParameter("SearchKey");
		String strWhere="1=1";		
		int start = 0;
		int count = 5;
		int total = 0;
		try {
		    start = Integer.parseInt(request.getParameter("start"));
		   } catch (NumberFormatException e) {
		     // 当浏览器没有传参数start时
		   }		 		

		if(!(isInvalid(request.getParameter("SearchKey"))))
		{
		strWhere+=" and Building_Name = '"+SearchKey+"'";
		
		list = bd.getAllBuilding(strWhere, "Building_ID");
		request.getSession().setAttribute(Keys.BUILDING_NUMBER, list.size());
		total = list.size();
		}
		else
		{
		list = bd.list(start, count);
		request.getSession().setAttribute(Keys.BUILDING_NUMBER,countBuilding());
		total = list.size();
		}
		
		//上边界设置		
		int pre = start - count>0?start - count:0;
			
		int last;
		// 假设总数是50，是能够被5整除的，那么最后一页的开始就是45
		if (0 == total % count)
		last = total - count;
		// 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
		else
		last = total - total % count;
		//下边界设置        
		int next =(start + count)>total?start:(start + count);
		int currerntPage=(start + count)/count;
		
		request.getSession().setAttribute(Keys.CURRENTPAGE, currerntPage);
		request.getSession().setAttribute(Keys.NEXT, next);
		request.getSession().setAttribute(Keys.PRE, pre);
		request.getSession().setAttribute(Keys.LAST, last);
		return list;
	}

	@Override
	public int countBuilding() {
		// TODO Auto-generated method stub
		return bd.countBuilding();
	}
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	@Override
	public void addBuilding(HttpServletRequest request, HttpServletResponse response) {
		Building building = new Building();
		building.setBuilding_name(request.getParameter("building_name"));
		building.setBuilding_introduction(request.getParameter("building_introduction"));
		bd.Add(building);
		
	}	

}
