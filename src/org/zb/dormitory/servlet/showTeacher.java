package org.zb.dormitory.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zb.dormitory.entity.Teacher;
import org.zb.dormitory.keys.Keys;

/**
 * Servlet implementation class showTeacher
 */
@WebServlet("/showTeacher")
public class showTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int teacherid = Integer.parseInt(request.getParameter("teacherid"));
		@SuppressWarnings("unchecked")
		List<Teacher> listBefore = (List<Teacher>) request.getSession().getAttribute("teacherlist");

        if(null!=listBefore){
        	for (Teacher teacher : listBefore) {
				if(teacher.getTeacher_id()==teacherid){
					request.getSession().setAttribute(Keys.TEACHER_ITEM, teacher);
				}
			}
        }        
        request.getRequestDispatcher("showTeacher.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
