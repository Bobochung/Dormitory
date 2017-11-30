package org.zb.dormitory.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zb.dormitory.entity.Student;

public interface StudentService {
//	得到所有学生
	public List<Student> listAllStudent(HttpServletRequest request);
//	分页显示学生
	public List<Student> pageList(HttpServletRequest request,HttpServletResponse response);
//	获取学生总数
	public int countStudent();
//	添加入住的学生
	public void addStudent(HttpServletRequest request,HttpServletResponse response);
	
}
