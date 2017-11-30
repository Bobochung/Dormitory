package org.zb.dormitory.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zb.dormitory.entity.Building;
import org.zb.dormitory.keys.Keys;

/**
 * Servlet implementation class showBuilding
 */
public class showBuilding extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showBuilding() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int buildingid = Integer.parseInt(request.getParameter("buildingid"));
		@SuppressWarnings("unchecked")
		List<Building> listBefore = (List<Building>) request.getSession().getAttribute("buildinglist");

        if(null!=listBefore){
        	for (Building building : listBefore) {
				if(building.getBuilding_id()==buildingid){
					request.getSession().setAttribute(Keys.BUILDING_ITEM, building);
				}
			}
        }        
        request.getRequestDispatcher("showBuilding.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
