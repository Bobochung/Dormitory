package org.zb.dormitory.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zb.dormitory.entity.Student;
import org.zb.dormitory.keys.Keys;
import org.zb.dormitory.service.StudentService;
import org.zb.dormitory.service.serviceImpl.StudentServiceImpl;


/**
 * Servlet implementation class StudentManager
 */
@WebServlet("/StudentManager")
public class StudentManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
    StudentService ss = new StudentServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> list = ss.pageList(request,response);
		request.getSession().setAttribute(Keys.STUDENTLIST_KEY, list);
		request.getRequestDispatcher("imgtable.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
