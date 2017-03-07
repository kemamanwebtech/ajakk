package com.ajakk.shared.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LoginDTO implements Serializable {
	int userID;
	String userStatus;
	
	public int getUserID() {
		return userID;
	}
	
	public String getUserStatus() {
		return userStatus;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
}
