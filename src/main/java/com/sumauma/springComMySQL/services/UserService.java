package com.sumauma.springComMySQL.services;

import java.util.List;

import com.sumauma.springComMySQL.entities.User;

public interface UserService {

	public List<User> getUser();
	public void saveUser(User user);
	public User findById(Integer id);
	public void deleteUser(User user);
}
