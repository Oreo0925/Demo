package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.service.UserService;

public class UserSericeImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getUsers() {
		List<User> userList = userDao.getUsers();
		return userList;
	}

	@Override
	public User getUserById(int id) {
		User user = userDao.getUserById(id);
		return user;
	}

	@Override
	public int insertUser(User user) {
		int id = userDao.insertUser(user);
		return id;
	}

	@Override
	public int updateUserById(User user) {
		int count = userDao.updateUserById(user);
		return count;
	}

	@Override
	public int deleteUserById(int id) {
		int count = userDao.deleteUserById(id);
		return count;
	}
	
}
