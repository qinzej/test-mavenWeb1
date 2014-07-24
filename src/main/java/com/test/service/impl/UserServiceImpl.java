package com.test.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.UserDaoI;
import com.test.model.User;
import com.test.service.IUserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserDaoI<User> userDao;
	
	public void addUser(User user)
	{
		userDao.save(user);
	}
	
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
}
