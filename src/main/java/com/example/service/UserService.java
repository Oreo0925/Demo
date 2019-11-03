package com.example.service;

import java.util.List;

import com.example.entity.User;
import com.example.exception.CustmerException;

public interface UserService {
	// 取得 User
	public List<User> getUsers();
	
	// 依 id 取得 User
	public User getUserById(int id);
	
	// 新增 User
	public int insertUser(User user) throws CustmerException;
	
	// 修改 User
	public int updateUserById(User user) throws CustmerException;
	
	// 依 id 刪除 User
	public int deleteUserById(int id) throws CustmerException;
}
