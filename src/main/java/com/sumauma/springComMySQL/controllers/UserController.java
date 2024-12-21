package com.sumauma.springComMySQL.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumauma.springComMySQL.entities.User;
import com.sumauma.springComMySQL.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<?> getUser() {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		List<User> userList = userService.getUser();
		if (!userList.isEmpty()) {
			map.put("status", 1);
			map.put("data", userList);
			return new ResponseEntity<>(map, HttpStatus.OK);
		} else {
			map.clear();
			map.put("status", 0);
			map.put("message", "Data is not found");
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		userService.saveUser(user);
		map.put("status", 1);
		map.put("message", "Record is Saved Successfully!");
		return new ResponseEntity<>(map, HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Integer id) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		try {
			User user = userService.findById(id);
			map.put("status", 1);
			map.put("data", user);
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception ex) {
			map.clear();
			map.put("status", 0);
			map.put("message", "Data is not found");
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		try {
			User user = userService.findById(id);
			userService.deleteUser(user);
			map.put("status", 1);
			map.put("message", "Record is deleted successfully!");
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception ex) {
			map.clear();
			map.put("status", 0);
			map.put("message", "Data is not found");
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUserById(@PathVariable Integer id, @RequestBody User userDetail) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		try {
			User user = userService.findById(id);
			user.setUserName(userDetail.getUserName());
			user.setMobileNo(userDetail.getMobileNo());
			user.setEmailId(userDetail.getEmailId());
			user.setCity(userDetail.getCity());
			user.setUserPassword(userDetail.getUserPassword());
			userService.saveUser(user);
			map.put("status", 1);
			map.put("data", userService.findById(id));
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception ex) {
			map.clear();
			map.put("status", 0);
			map.put("message", "Data is not found");
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
	}
	
}
