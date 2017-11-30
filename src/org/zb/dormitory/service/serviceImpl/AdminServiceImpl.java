package org.zb.dormitory.service.serviceImpl;

import javax.servlet.http.HttpServletRequest;

import org.zb.dormitory.dao.AdminDao;
import org.zb.dormitory.dao.daoImpl.AdminDaoImpl;
import org.zb.dormitory.entity.Admin;
import org.zb.dormitory.keys.Keys;
import org.zb.dormitory.service.AdminService;
import org.zb.dormitory.utils.MD5Util;

public class AdminServiceImpl implements AdminService{
	
	
	private AdminDao ad = new AdminDaoImpl();
//	登录
	@Override
	public boolean login(String username, String password, HttpServletRequest request) {
		if(ad.getAdminByUsername(username)!=null){
			Admin admin=ad.getAdminByUsernameAndPassword(username, password);			
			if(admin.getAdmin_username().equals(username) && admin.getAdmin_password().equals(password)){
				Admin sessionAdmin = new Admin(username,password);
				request.getSession().setAttribute(Keys.ADMIN_KEY, sessionAdmin);				
				Keys.onlineSession.put(username, request.getSession());
				return true;		
			}
			
		}		
		return false;
	}
//注册
	@Override
	public boolean register(String username, String password,HttpServletRequest request) {		
		return ad.addAdmin(username, MD5Util.MD5(password));
	}
	
	
//得到登陆用户
	@Override
	public Admin getAdmin(String username, String password) {
		Admin admin = null;
		if(ad.getAdminByUsername(username)!=null){
			admin=ad.getAdminByUsername(username);
		}
		return admin;
	}
	

}
