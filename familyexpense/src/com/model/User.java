package com.model;

public class User {
	
	//public int userID;
	public String userName;
	public String userEmail;
	public String userPhone;
	public String userPassword;
	public String userSecurityQuestion;

	public User(){
		
	}
	
	public User(String userName, String userEmail, String userPhone,String userPassword,String userSecurityQuestion) {
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone=userPhone;
		this.userPassword = userPassword;
		this.userSecurityQuestion=userSecurityQuestion;
	}

	@Override
	public String toString() {
		return "User [ userName=" + userName + ", userEmail=" + userEmail + ", userPhone="
				+ userPhone + ", userPassword=" + userPassword + ", userSecurityQuestion=" + userSecurityQuestion + "]";
	}

	

	
	
}	