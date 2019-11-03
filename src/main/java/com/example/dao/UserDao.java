package com.example.dao;

import java.util.List;

import com.example.entity.User;

public interface UserDao {
	// 取得 User
	public List<User> getUsers();
	
	// 依 id 取得 User
	public User getUserById(int id);
	
	// 新增 User
	public int insertUser(User user);
	
	// 修改 User
	public int updateUserById(User user);
	
	// 依 id 刪除 User
	public int deleteUserById(int id);
}
