package org.zb.dormitory.service.serviceImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zb.dormitory.dao.StudentDao;
import org.zb.dormitory.dao.daoImpl.StudentDaoImpl;
import org.zb.dormitory.entity.Student;
import org.zb.dormitory.keys.Keys;
import org.zb.dormitory.service.StudentService;

public class StudentServiceImpl implements StudentService {
	StudentDao sd = new StudentDaoImpl();
	private String SearchRow;
	private String SearchKey;
	private String State;
	@Override
	public List<Student> listAllStudent(HttpServletRequest request) {
		String strWhere="1=1";
		if(!(isInvalid(SearchKey)))
		{
			strWhere+=" and "+SearchRow+"='"+SearchKey+"'";
		}		
		List<Student> list = sd.getAllStudent(strWhere, "Student_ID");				
	
		return list;
	}

	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	@Override
	public List<Student> pageList(HttpServletRequest request, HttpServletResponse response) {
		List<Student> list	= null;
		SearchRow=request.getParameter("SearchRow");
		SearchKey=request.getParameter("SearchKey");
		State = request.getParameter("State");
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
		list = sd.getAllStudent(strWhere, "Student_ID");
		request.getSession().setAttribute(Keys.STUDENT_NUMBER, list.size());
		total = list.size();
		}
//		查询条件为空，查询楼宇不为空
		else
		{
		if(!(isInvalid(State))){
			strWhere+=" and Student_State = '"+State+"'";
			list = sd.getAllStudent(strWhere, "Student_ID");
			request.getSession().setAttribute(Keys.STUDENT_NUMBER, list.size());
			total = list.size();
//		查询条件为空，查询楼宇为空		
		}else{
		list = sd.list(start, count);
		request.getSession().setAttribute(Keys.STUDENT_NUMBER,countStudent());
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
		
		request.getSession().setAttribute(Keys.CURRENTPAGE, currerntPage);
		request.getSession().setAttribute(Keys.NEXT, next);
		request.getSession().setAttribute(Keys.PRE, pre);
		request.getSession().setAttribute(Keys.LAST, last);
		return list;
	}

	@Override
	public int countStudent() {
		// TODO Auto-generated method stub
		return sd.countStudent();
	}

	@Override
	public void addStudent(HttpServletRequest request, HttpServletResponse response) {
		Student student = new Student();
		student.setStudent_dormitoryid(Integer.parseInt(request.getParameter("building_name")));
		student.setStudent_username(request.getParameter("student_id"));
		student.setStudent_name(request.getParameter("student_name"));
		student.setStudent_sex(request.getParameter("student_sex"));
		student.setStudent_class(request.getParameter("student_class"));
		student.setStudent_state("入住");		
		sd.Add(student);		
	}

}
