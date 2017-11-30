package org.zb.dormitory.dao;

import java.util.List;
import org.zb.dormitory.entity.Dormitory;

public interface DormitoryDao {


	/**
	 * 得到宿舍列表
	 * @param strwhere 查询条件
	 * @param strorder 排列顺序
	 * @return 返回宿舍列表
	 */
	public List<Dormitory> getAllDormitory(String strwhere,String strorder);
	/**
	 * 分页查询
	 * @param start 表示开始的个数
	 * @param count 表示取多少条
	 * @return
	 */	
	public List<Dormitory> list(int start, int count);
	/**
	 * 获取所有宿舍数量
	 * @return
	 */
	public int countDormitory();
	
	
	//	根据ID获取宿舍实体
	public Dormitory GetDormitory(int id);	

	//添加大楼
	public void Add(Dormitory dormitory);
	//修改
	public void Update(Dormitory dormitory);	
	//删除
	public void Delete(String strwhere);
}
