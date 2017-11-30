package org.zb.dormitory.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zb.dormitory.entity.Dormitory;
import org.zb.dormitory.keys.Keys;
import org.zb.dormitory.service.DormitoryService;
import org.zb.dormitory.service.serviceImpl.DormitoryServiceImpl;

/**
 * Servlet implementation class DormitoryManager
 */
@WebServlet("/DormitoryManager")
public class DormitoryManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DormitoryService ds = new DormitoryServiceImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DormitoryManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Dormitory> list = ds.pageList(request, response);
		request.getSession().setAttribute(Keys.DORMITORYLIST_KEY, list);
		request.getRequestDispatcher("imglist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
