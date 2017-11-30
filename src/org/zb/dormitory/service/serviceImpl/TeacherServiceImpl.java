package org.zb.dormitory.service.serviceImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zb.dormitory.dao.TeacherDao;
import org.zb.dormitory.dao.daoImpl.TeacherDaoImpl;
import org.zb.dormitory.entity.Teacher;
import org.zb.dormitory.keys.Keys;
import org.zb.dormitory.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {

	TeacherDao td = new TeacherDaoImpl();
	private String SearchRow;
	private String SearchKey;

	@Override
	public List<Teacher> listAllTeacher(HttpServletRequest request) {
		String strWhere="1=1";
		if(!(isInvalid(SearchKey)))
		{
			strWhere+=" and "+SearchRow+"='"+SearchKey+"'";
		}		
		List<Teacher> list = td.getAllTeacher(strWhere, "Teacher_ID");				
//		for(Teacher teacher:list){
//			System.out.println(teacher.getTeacher_name());
//		}	
		return list;
			
	}
	
	//判断是否空值
		private boolean isInvalid(String value) {
			return (value == null || value.length() == 0);
		}
		@Override
	public List<Teacher> pageList(HttpServletRequest request,HttpServletResponse response) {
		List<Teacher> list	= null;
		SearchRow=request.getParameter("SearchRow");
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
		strWhere+=" and "+request.getParameter("SearchRow")+"='"+request.getParameter("SearchKey")+"'";
		
		list = td.getAllTeacher(strWhere, "Teacher_ID");
		request.getSession().setAttribute(Keys.TEACHER_NUMBER, list.size());
		total = list.size();
		}else {
		list = td.list(start, count);
		request.getSession().setAttribute(Keys.TEACHER_NUMBER,countTeacher());
		total = td.countTeacher();
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
		request.setAttribute(Keys.CURRENTPAGE, currerntPage);
		request.setAttribute(Keys.NEXT, next);
		request.setAttribute(Keys.PRE, pre);
		request.setAttribute(Keys.LAST, last);
		return list;
		}
		@Override
		public int countTeacher() {			
			return td.countTeacher();
		}

		@Override
		public void deleteTeacher(int id) {			
			td.Delete(id);	
		}
	

}
