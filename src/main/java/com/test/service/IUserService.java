package com.test.service;

import java.util.List;

import com.test.model.User;

public interface IUserService {
	public void addUser(User user);
	public List<User> getAllUsers();
}
