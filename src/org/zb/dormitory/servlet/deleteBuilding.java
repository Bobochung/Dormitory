package org.zb.dormitory.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class deleteBuilding
 */
@WebServlet("/deleteBuilding")
public class deleteBuilding extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BuildingService bs = new BuildingServiceImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteBuilding() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int buildingid=Integer.parseInt(request.getParameter("buildingid"));
		
		@SuppressWarnings("unchecked")
		List<Building> listBeforeDelete = (List<Building>) request.getSession().getAttribute("buildinglist");
//		只是从当前页面删除，并未从数据库删除
		List<Building> listAfterDelete =new ArrayList<>();
        if(null!=listBeforeDelete){
        	for (Building building : listBeforeDelete) {
				if(building.getBuilding_id()==buildingid){
					listAfterDelete.add(building);
//					//将教师从数据库删除
//					bs.deleteBuilding(buildingid);
				}
			}
        }
        listBeforeDelete.removeAll(listAfterDelete);
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
