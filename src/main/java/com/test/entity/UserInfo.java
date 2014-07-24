package com.test.entity;

public class UserInfo {
	private String userName;
	private String age;
	public UserInfo(String name, String age)
	{
		this.userName = name;
		this.age = age;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
}
