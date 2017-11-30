package org.zb.dormitory.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zb.dormitory.entity.Teacher;

public interface TeacherService {
//	得到所有教师
	public List<Teacher> listAllTeacher(HttpServletRequest request);
//	分页显示教师
	public List<Teacher> pageList(HttpServletRequest request,HttpServletResponse response);
//	获取教师总数
	public int countTeacher();
	
//	根据ID删除教师
	public void deleteTeacher(int id);

}
