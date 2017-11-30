package org.zb.dormitory.service.serviceImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zb.dormitory.dao.BuildingDao;
import org.zb.dormitory.dao.DormitoryDao;
import org.zb.dormitory.dao.daoImpl.BuildingDaoImpl;
import org.zb.dormitory.dao.daoImpl.DormitoryDaoImpl;
import org.zb.dormitory.entity.Building;
import org.zb.dormitory.entity.Dormitory;
import org.zb.dormitory.keys.Keys;
import org.zb.dormitory.service.DormitoryService;

public class DormitoryServiceImpl implements DormitoryService {
	DormitoryDao dd = new DormitoryDaoImpl();
	BuildingDao bd = new BuildingDaoImpl();
 	private String SearchRow;
	private String SearchKey;
	private String dormitory_id;	
	@Override
	public List<Dormitory> listAllDormitory(HttpServletRequest request) {
		String strWhere="1=1";
		if(!(isInvalid(SearchKey)))
		{
			strWhere+=" and "+SearchRow+"='"+SearchKey+"'";
		}		
		List<Dormitory> list = dd.getAllDormitory(strWhere, "Domitory_ID");				
		return list;
	}
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}


	@Override
	public List<Dormitory> pageList(HttpServletRequest request, HttpServletResponse response) {
		List<Dormitory> list = null;
		SearchRow = request.getParameter("SearchRow");
		SearchKey = request.getParameter("SearchKey");
		dormitory_id = request.getParameter("Domitory_BuildingID");
		String strWhere="1=1";		
		int start = 0;
		int count = 5;
		int total = 0;
		try {
		    start = Integer.parseInt(request.getParameter("start"));
		   } catch (NumberFormatException e) {
		     // 当浏览器没有传参数start时
		   }		 		
//		查询条件不为空，则查询所有，按条件查询
		if(!(isInvalid(request.getParameter("SearchKey"))))
		{
		strWhere+=" and "+request.getParameter("SearchRow")+" = "+request.getParameter("SearchKey");		
		list = dd.getAllDormitory(strWhere, "Domitory_ID");
		request.getSession().setAttribute(Keys.DORMITORY_NUMBER, list.size());
		total = list.size();
		}
//		查询条件为空，查询楼宇不为空
		else
		{
		if(!(isInvalid(dormitory_id))){
			strWhere+=" and Domitory_ID ="+dormitory_id;
			list = dd.getAllDormitory(strWhere, "Domitory_ID");
			request.getSession().setAttribute(Keys.DORMITORY_NUMBER, list.size());
			total = list.size();
//		查询条件为空，查询楼宇为空		
		}else{
		list = dd.list(start, count);
		request.getSession().setAttribute(Keys.DORMITORY_NUMBER,countDormitory());
		total = list.size();
		}
		}
		
//		for(Teacher teacher:list){
//			System.out.println(teacher.getTeacher_name());
//		}	
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
		List<Building> buildingList = bd.list(0, bd.countBuilding());
		request.getSession().setAttribute(Keys.BUILDINGLIST_KEY, buildingList);
		request.getSession().setAttribute(Keys.CURRENTPAGE, currerntPage);
		request.getSession().setAttribute(Keys.NEXT, next);
		request.getSession().setAttribute(Keys.PRE, pre);
		request.getSession().setAttribute(Keys.LAST, last);
		return list;
	}

	@Override
	public int countDormitory() {
		
		return dd.countDormitory();
	}

}
