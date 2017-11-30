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

/**
 * Servlet implementation class showStdent
 */
@WebServlet("/showStudent")
public class showStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentid = Integer.parseInt(request.getParameter("studentid"));
		@SuppressWarnings("unchecked")
		List<Student> listBefore = (List<Student>) request.getSession().getAttribute("studentlist");

        if(null!=listBefore){
        	for (Student student : listBefore) {
				if(student.getStudent_id()==studentid){
					request.getSession().setAttribute(Keys.STUDENT_ITEM, student);
				}
			}
        }        
        request.getRequestDispatcher("showStudent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
