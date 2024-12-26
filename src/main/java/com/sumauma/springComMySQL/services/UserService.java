package com.sumauma.springComMySQL.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sumauma.springComMySQL.dto.UserDTO;
import com.sumauma.springComMySQL.dto.UserMinDTO;
import com.sumauma.springComMySQL.entities.User;
import com.sumauma.springComMySQL.repositories.UserRepository;
import com.sumauma.springComMySQL.services.handlerExceptions.RessourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	/*
	public List<User> getUser() {
		return userRepository.findAll();
	}

	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	*/
	
	@Transactional(readOnly = true)
	public UserDTO findById(Integer id) {
		User user = userRepository.findById(id).orElseThrow(
				() -> new RessourceNotFoundException("recurso não entrado"));
		return new UserDTO(user);
		
	}
	
	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		List<User> userList = userRepository.findAll();
		return userList.stream().map(x -> new UserDTO(x)).toList();
		
	}

	@Transactional(readOnly = true)
	public List<UserMinDTO> findAllMin() {
		List<User> userList = userRepository.findAll();
		return userList.stream().map(x -> new UserMinDTO(x.getId(), 
				x.getCity(),
				x.getUserName(), 
				x.getMobileNo(), 
				x.getEmailId())).toList();
		
	}

	
	/*
	public void deleteUser(User user) {
		userRepository.delete(user);
		
	}
	*/
}
