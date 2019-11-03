package com.example.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.dao.UserDao;
import com.example.entity.User;

@Repository
public class UserDaoImpl extends NamedParameterJdbcDaoSupport implements
UserDao {
	
	@Autowired
	UserDaoImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	public final static String GET_USERS = "SELECT id, name, phoneNumber, createTime FROM user";
	public final static String GET_USER_BY_ID = "SELECT * FROM user where id = :id";
	public final static String INSERT_USER = "INSERT INTO user (name, phoneNumber) VALUES (:name, :phoneNumber)";
	public final static String UPDATE_USER_BY_ID = "UPDATE user SET name=:name, phoneNumber=:phoneNumber WHERE id=:id";
	public final static String DELETE_USER_BY_ID = "DELETE FROM user WHERE id=:id";
	
	@Override
	public List<User> getUsers() {
		List<User> rtnValue = new ArrayList<User>();
		SqlParameterSource parameters = new MapSqlParameterSource();
		rtnValue = this.getNamedParameterJdbcTemplate().query(GET_USERS,
				parameters, new BeanPropertyRowMapper<User>(User.class));
		return rtnValue;
	}

	@Override
	public User getUserById(int id) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(
				"id", id);
		User rtnValue = this.getNamedParameterJdbcTemplate().queryForObject(
				GET_USER_BY_ID, parameters,
				new BeanPropertyRowMapper<User>(User.class));
		return rtnValue;
	}

	@Override
	public int insertUser(User user) {
		SqlParameterSource parameters = new BeanPropertySqlParameterSource(user);
		this.getNamedParameterJdbcTemplate().update(INSERT_USER, parameters);
		int id = this.getJdbcTemplate().queryForObject(
				"select last_insert_id()", Integer.class);
		user.setId(id);
		return id;
	}

	@Override
	public int updateUserById(User user) {
		SqlParameterSource parameters = new BeanPropertySqlParameterSource(user);
		int result = this.getNamedParameterJdbcTemplate().update(
				UPDATE_USER_BY_ID, parameters);
		return result;
	}

	@Override
	public int deleteUserById(int id) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(
				"id", id);
		int result = this.getNamedParameterJdbcTemplate().update(
				DELETE_USER_BY_ID, parameters);
		return result;
	}

}
