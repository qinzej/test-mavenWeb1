package com.test.dao;

import java.io.Serializable;
import java.util.List;

import com.test.model.User;

public interface UserDaoI<T> {
    public Serializable save(T o);
    public User getUser(String id);
    public List<User> getAllUsers();
    public boolean delUser(String id);
}
