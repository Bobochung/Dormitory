package org.zb.dormitory.dao;

import org.zb.dormitory.entity.Admin;

public interface AdminDao {
/**
 * 添加用户(管理员)
 * @param username 用户名
 * @param password 密码
 * @return 成功返回true
 */
	public boolean addAdmin(String username,String password);
/**
* 根据用户名查找用户
* @param username 用户名
* 
* @return 查找到返回用户，没有返回null
*/
	public Admin getAdminByUsername(String username);
	
/**
 * 根据用户名和密码查找用户
 * @param username 用户名
 * @param password 密码
 * @return 查找到返回用户，没有返回null
 */
	public Admin getAdminByUsernameAndPassword(String username,String password);
}
