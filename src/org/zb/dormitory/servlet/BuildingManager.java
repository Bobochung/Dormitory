package org.zb.dormitory.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zb.dormitory.entity.Building;
import org.zb.dormitory.service.BuildingService;
import org.zb.dormitory.service.serviceImpl.BuildingServiceImpl;

/**
 * Servlet implementation class BuildingManager
 */
@WebServlet("/BuildingManager")
public class BuildingManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BuildingService bs = new BuildingServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuildingManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Building> list = bs.pageList(request, response);
		request.getSession().setAttribute("buildinglist", list);
		for(Building building:list){
			System.out.println(building.getBuilding_name());
		}
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
