package org.zb.dormitory.dao;

import java.util.List;

import org.zb.dormitory.entity.Student;

public interface StudentDao {

	/**
	 * 得到学生列表
	 * @param strwhere 查询条件
	 * @param strorder 排列顺序
	 * @return 返回学生列表
	 */
	public List<Student> getAllStudent(String strwhere,String strorder);
	/**
	 * 分页查询
	 * @param start 表示开始的个数
	 * @param count 表示取多少条
	 * @return
	 */	
	public List<Student> list(int start, int count);
	/**
	 * 获取所有学生数量
	 * @return
	 */
	public int countStudent();
	/**
	 * 验证登录
	 * @param username
	 * @param password
	 * @return
	 */
	public String CheckLogin(String username, String password);

	//验证密码
	public boolean CheckPassword(String id, String password);
	//	根据ID获取学生实体
	public Student GetBean(int id);	
//	根据username获取学生实体
	public Student GetBean(String username);	

	//添加教师
	public void Add(Student student);
	//修改
	public void Update(Student student);	
	//删除
	public void Delete(String strwhere);
}
