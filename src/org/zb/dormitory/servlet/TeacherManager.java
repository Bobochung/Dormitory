package org.zb.dormitory.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zb.dormitory.entity.Teacher;
import org.zb.dormitory.keys.Keys;
import org.zb.dormitory.service.TeacherService;
import org.zb.dormitory.service.serviceImpl.TeacherServiceImpl;

/**
 * Servlet implementation class TeacherManager
 */
public class TeacherManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
    TeacherService ts = new TeacherServiceImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
//全部查询
//		List<Teacher> list = ts.listAllTeacher(request);
//	分页查询
		List<Teacher> teacherlist = ts.pageList(request,response);
		request.getSession().setAttribute(Keys.TEACHERLIST_KEY, teacherlist);
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
