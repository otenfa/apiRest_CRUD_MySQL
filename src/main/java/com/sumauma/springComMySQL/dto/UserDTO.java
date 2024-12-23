package com.sumauma.springComMySQL.dto;

import com.sumauma.springComMySQL.entities.User;

public class UserDTO {

	private Integer id;
	private String userName;
	private String mobileNo;
	private String emailId;
	private String city;
	private String userPassword;
	
	public UserDTO() {		
	}

	public UserDTO(Integer id, String userName, String mobileNo, String emailId, String city, String userPassword) {
		super();
		this.id = id;
		this.userName = userName;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.city = city;
		this.userPassword = userPassword;
	}
	
	public UserDTO(User entity) {
		id = entity.getId();
		userName = entity.getUserName();
		mobileNo = entity.getMobileNo();
		emailId = entity.getEmailId();
		city = entity.getCity();
		userPassword = entity.getUserPassword();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
}
