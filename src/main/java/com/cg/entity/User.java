package com.cg.entity;

public class User {
	// STATE
	private String userRole;
	private String emailId;
	private Integer age;
	private String gender;
	private String userId;
	private String userName;
	private String contactNumber;

	// Constructor
	public User(String userRole, String emailId, Integer age, String gender, String userId, String userName,
			String contactNumber) {
		super();
		this.userRole = userRole;
		this.emailId = emailId;
		this.age = age;
		this.gender = gender;
		this.userId = userId;
		this.userName = userName;
		this.contactNumber = contactNumber;
	}
	//No ArgumentConstructor
	public User() {
		super();
	}
	
	
	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "User [userRole=" + userRole + ", emailId=" + emailId + ", age=" + age + ", gender=" + gender
				+ ", userId=" + userId + ", userName=" + userName + ", contactNumber=" + contactNumber + "]";
	}

}
