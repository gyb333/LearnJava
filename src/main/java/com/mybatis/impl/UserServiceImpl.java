package com.mybatis.impl;

import java.util.List;

import com.mybatis.dao.UserDao;
import com.mybatis.entity.User;
import com.mybatis.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(String id, String username, String password) {
		// TODO Auto-generated method stub
		 userDao.add(id, username, password);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}

	@Override
	public int update(String username, String password, String id) {
		// TODO Auto-generated method stub
		
		return userDao.update(username, password, id);
	}

	@Override
	public User getUser(String id) {
		// TODO Auto-generated method stub
		return userDao.getUser(id);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userDao.getUsers();
	}

	@Override
	public List<User> getUsersByPage(int offset, int pageSize) {
		// TODO Auto-generated method stub
		return userDao.getUsers(offset, pageSize);
	}

}
