package com.ajakk.shared.dto;

import java.sql.Date;

public class RelationshipDTO {
	int userID_1;
	int userID_2;
	String status; //relationship status : friend, blocked, not-friend 
	boolean request; // true if friend-request is sent
	Date created;
	Date updated;
	
	public int getUserID_1() {
		return userID_1;
	}
	
	public int getUserID_2() {
		return userID_2;
	}
	
	public String getStatus() {
		return status;
	}
	
	public boolean isRequest() {
		return request;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public Date getUpdated() {
		return updated;
	}
	
	public void setUserID_1(int userID_1) {
		this.userID_1 = userID_1;
	}
	
	public void setUserID_2(int userID_2) {
		this.userID_2 = userID_2;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setRequest(boolean request) {
		this.request = request;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public void setUpdated(Date updated) {
		this.updated = updated;
	}	
}
