package com.example.entity;

import java.sql.Timestamp;

public class User {
	private int id;
	private String name;
	private String phoneName;
	private Timestamp createTime;
	
	public User() {
		super();
	}
	
	public User(String name, String phoneName) {
		this.name = name;
		this.phoneName = phoneName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneName() {
		return phoneName;
	}

	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	
}
