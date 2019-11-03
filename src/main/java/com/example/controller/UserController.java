package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.exception.CustmerException;
import com.example.service.UserService;
import com.example.pojo.SingleResponseObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/")
@Api(tags = { "User API" })
public class UserController {
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "取得全部 User", notes = "")
	@GetMapping("/users")
	public SingleResponseObject<List<User>> getUser() {
		SingleResponseObject<List<User>> ero = new SingleResponseObject<List<User>>();
		List<User> userList = userService.getUsers();
		ero.setData(userList);
		return ero;
	}
	
	@ApiOperation(value = "依 id 取得 User", notes = "")
	@CrossOrigin
	@GetMapping("/device/{id}")
	public SingleResponseObject<User> getDeviceById(
			@ApiParam(value = "userId", required = true, example = "1") @PathVariable("id") Integer id) {
		SingleResponseObject<User> ero = new SingleResponseObject<User>();
		try {
			User user = userService.getUserById(id);
			ero.setData(user);
		} catch (EmptyResultDataAccessException e) {
			ero.setMessage("查無資料");
		}
		return ero;
	}
	
	@ApiOperation(value = "新增單一筆 User", notes = "")
	@PostMapping("/user")
	public SingleResponseObject<User> insertDevice(@RequestBody User user) {
		SingleResponseObject<User> ero = new SingleResponseObject<User>();
		try {
			userService.insertUser(user);
			ero.setData(user);
		} catch (CustmerException ce) {
			ero.setErrorMessage(ce);
		}
		return ero;
	}
	
	@ApiOperation(value = "更新 User 資料", notes = "")
	@PutMapping("/user/{id}")
	public SingleResponseObject<User> updateDevice(
			@ApiParam(value = "userId", required = true, example = "1") @PathVariable("id") Integer id,
			@RequestBody User user) {
		SingleResponseObject<User> ero = new SingleResponseObject<User>();
		try {
			user.setId(id);
			userService.updateUserById(user);
			ero.setData(user);
		} catch (CustmerException ce) {
			ero.setErrorMessage(ce);
		}
		return ero;
	}

	@ApiOperation(value = "刪除單一裝置", notes = "")
	@DeleteMapping("/user/{id}")
	public SingleResponseObject<Integer> deletedDeviceList(
			@ApiParam(value = "UserId", required = true, example = "1") @PathVariable("id") Integer id) {
		SingleResponseObject<Integer> ero = new SingleResponseObject<Integer>();
		try {
			int rs = userService.deleteUserById(id);
			ero.setTotal(rs);
		} catch (CustmerException ce) {
			ero.setErrorMessage(ce);
		}
		return ero;
	}
}
