package org.zb.dormitory.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zb.dormitory.entity.Admin;
import org.zb.dormitory.keys.Keys;
import org.zb.dormitory.service.AdminService;
import org.zb.dormitory.service.serviceImpl.AdminServiceImpl;
import org.zb.dormitory.utils.MD5Util;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService as;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = MD5Util.MD5(request.getParameter("password"));	
		as = new AdminServiceImpl();
		if(as.login(username, password, request)){
			Admin admin = as.getAdmin(username, password);
			request.getSession().setAttribute(Keys.ADMIN_KEY, admin);			
			Keys.onlineSession.put(username, request.getSession());
			response.sendRedirect("main.jsp");
		}
		else{
			response.sendRedirect("login.jsp");
		}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
