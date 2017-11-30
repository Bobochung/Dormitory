package org.zb.dormitory.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zb.dormitory.entity.Building;

public interface BuildingService {
//	得到所有大楼
	public List<Building> listAllBuilding(HttpServletRequest request);
//	分页显示大楼
	public List<Building> pageList(HttpServletRequest request,HttpServletResponse response);
//	获取大楼总数
	public int countBuilding();
//	添加楼宇
	public void addBuilding(HttpServletRequest request,HttpServletResponse response);
}
