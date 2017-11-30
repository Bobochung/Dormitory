package org.zb.dormitory.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zb.dormitory.entity.Teacher;
import org.zb.dormitory.service.TeacherService;
import org.zb.dormitory.service.serviceImpl.TeacherServiceImpl;

/**
 * Servlet implementation class deleteTeacher
 */
public class deleteTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
    TeacherService ts = new TeacherServiceImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int teacherid=Integer.parseInt(request.getParameter("teacherid"));
		
		@SuppressWarnings("unchecked")
		List<Teacher> listBeforeDelete = (List<Teacher>) request.getSession().getAttribute("teacherlist");
//		只是从当前页面删除，并未从数据库删除
		List<Teacher> listAfterDelete =new ArrayList<>();
        if(null!=listBeforeDelete){
        	for (Teacher teacher : listBeforeDelete) {
				if(teacher.getTeacher_id()==teacherid){
					listAfterDelete.add(teacher);
//					//将教师从数据库删除
//					ts.deleteTeacher(teacherid);
				}
			}
        }
        listBeforeDelete.removeAll(listAfterDelete);
        request.getRequestDispatcher("right.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
