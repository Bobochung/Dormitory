package org.zb.dormitory.dao;

import java.util.List;

import org.zb.dormitory.entity.Teacher;

public interface TeacherDao {
	/**
	 * 得到教师列表
	 * @param strwhere 查询条件
	 * @param strorder 排列顺序
	 * @return 返回教师列表
	 */
	public List<Teacher> getAllTeacher(String strwhere,String strorder);
	/**
	 * 验证登录
	 * @param username
	 * @param password
	 * @return
	 */
	public String CheckLogin(String username, String password);
	/**
	 * 分页查询
	 * @param start 表示开始的个数
	 * @param count 表示取多少条
	 * @return
	 */	
	public List<Teacher> list(int start, int count);
	//验证密码
	public boolean CheckPassword(String id, String password);
	//	根据ID获取教师实体
	public Teacher GetBean(int id);	
	/**
	 * 获取所有教师数量
	 * @return
	 */
	public int countTeacher();
	//添加教师
	public boolean Add(Teacher teacher);
	//修改
	public boolean Update(Teacher teacher);	
	//删除
	public boolean Delete(int id);
}
