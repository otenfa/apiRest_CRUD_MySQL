package com.sumauma.springComMySQL.dto;

public class UserMinDTO {

	private Integer id;
	private String userName;
	private String mobileNo;
	private String emailId;
	private String city;

	public UserMinDTO() {		
	}

	public UserMinDTO(Integer id, String userName, String mobileNo, String emailId, String city) {
		super();
		this.id = id;
		this.userName = userName;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.city = city;
	}

	public Integer getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getCity() {
		return city;
	}
	
	
}
