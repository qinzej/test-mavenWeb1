package com.test.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.UserDaoI;
import com.test.model.User;

@Repository("userDao")
public class UserDaoImpl<T> implements UserDaoI<T>{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Serializable save(T o) {
		return sessionFactory.getCurrentSession().save(o);
	}

	@Override
	public User getUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		Query query = sessionFactory.getCurrentSession().createQuery("from User");
		return query.list();
	}

	@Override
	public boolean delUser(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
