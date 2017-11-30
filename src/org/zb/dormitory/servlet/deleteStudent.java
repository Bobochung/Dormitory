package org.zb.dormitory.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zb.dormitory.entity.Student;
import org.zb.dormitory.service.StudentService;
import org.zb.dormitory.service.serviceImpl.StudentServiceImpl;


/**
 * Servlet implementation class deleteStudent
 */
public class deleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    StudentService ss = new StudentServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int studentid=Integer.parseInt(request.getParameter("studentid"));
		
		@SuppressWarnings("unchecked")
		List<Student> listBeforeDelete = (List<Student>) request.getSession().getAttribute("studentlist");
//		只是从当前页面删除，并未从数据库删除
		List<Student> listAfterDelete =new ArrayList<>();
        if(null!=listBeforeDelete){
        	for (Student student : listBeforeDelete) {
				if(student.getStudent_id()==studentid){
					listAfterDelete.add(student);
//					//将教师从数据库删除
//					ss.deleteStudent(studentid);
				}
			}
        }
        listBeforeDelete.removeAll(listAfterDelete);
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
