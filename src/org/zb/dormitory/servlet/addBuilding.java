package org.zb.dormitory.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zb.dormitory.service.BuildingService;
import org.zb.dormitory.service.serviceImpl.BuildingServiceImpl;

/**
 * Servlet implementation class addBuilding
 */
@WebServlet("/addBuilding")
public class addBuilding extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BuildingService bs = new BuildingServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addBuilding() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bs.addBuilding(request, response);
		request.getRequestDispatcher("form.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
