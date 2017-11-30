package org.zb.dormitory.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zb.dormitory.entity.Dormitory;

public interface DormitoryService {
//	得到所有宿舍
	public List<Dormitory> listAllDormitory(HttpServletRequest request);
//	分页显示宿舍
	public List<Dormitory> pageList(HttpServletRequest request,HttpServletResponse response);
//	获取宿舍总数
	public int countDormitory();
}
