package com.sumauma.springComMySQL.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sumauma.springComMySQL.entities.User;
import com.sumauma.springComMySQL.repositories.UserRepository;

@Service
public class UserServiceImplement implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getUser() {
		return userRepository.findAll();
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public User findById(Integer id) {
		return userRepository.findById(id).get();
	}

	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
		
	}

}
