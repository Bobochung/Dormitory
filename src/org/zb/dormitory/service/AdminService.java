package org.zb.dormitory.service;

import javax.servlet.http.HttpServletRequest;

import org.zb.dormitory.entity.Admin;

public interface AdminService {
	public boolean login(String username,String password,HttpServletRequest request);
	public boolean register(String username,String password,HttpServletRequest request);
	public Admin getAdmin(String username,String password);
}
