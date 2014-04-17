package com.controller;

import com.dao.UserDao;
import com.model.User;

public class UserController {
	private static UserDao userDao = new UserDao();
	
	public User retrieveUser(String username){
		return userDao.retrieveUser(username);
	}
	
	public boolean checkPassword (String username, String password) {
		User user = userDao.retrieveUser(username);
		
		//neu username khong ton tai trong he thong
		if(user == null) {	
			return false;
		}
		
		// neu ton tai trong he thong thi tien hanh kiem tra username,
		// password xem co khop voi csdl ko
		if(!password.equals(user.getPassword())) {
			return false;
		}
		
		return true;
	}  
	
	//kiem tra su ton tai cua 1 username
	public boolean checkUser(String username){
		User user = userDao.retrieveUser(username);
		
		//neu username khong ton tai trong he thong
		if(user == null) {
			
			return false;
		}
		return true;
	}
	
	public void insertUser(String name, String pass, String mail, String keyword){
		
		userDao.insertUser(name, pass, mail, keyword);
		
	}
	public static UserDao getUserDao() {
		return userDao;
	}

	public static void setUserDao(UserDao userDao) {
		UserController.userDao = userDao;
	}
	
	
	
}
