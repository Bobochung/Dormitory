package org.zb.dormitory.dao;

import java.util.List;

import org.zb.dormitory.entity.Building;

public interface BuildingDao {

	/**
	 * 得到大楼列表
	 * @param strwhere 查询条件
	 * @param strorder 排列顺序
	 * @return 返回大楼列表
	 */
	public List<Building> getAllBuilding(String strwhere,String strorder);
	/**
	 * 分页查询
	 * @param start 表示开始的个数
	 * @param count 表示取多少条
	 * @return
	 */	
	public List<Building> list(int start, int count);
	/**
	 * 获取所有大楼数量
	 * @return
	 */
	public int countBuilding();
	/**
	 * 验证登录
	 * @param username
	 * @param password
	 * @return
	 */
	
	//	根据ID获取大楼实体
	public Building GetBuilding(int id);	

	//添加大楼
	public void Add(Building building);
	//修改
	public void Update(Building building);	
	//删除
	public void Delete(String strwhere);
}
