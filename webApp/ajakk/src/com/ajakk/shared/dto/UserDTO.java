package com.ajakk.shared.dto;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class UserDTO implements Serializable {
	int userID;
	String name;
	String status; 		// Status of the user : NotActive, Active, Blocked, Locked, Deleted
	int roleID; 		// Role assigned to the user
	Date created;
	Date updated;
	Date suspended; 	// Date and time until which the user is suspended
	String des; 		//Optional description for the user
	String photo; 		// Profile picture of this user
	
	public int getUserID() {
		return userID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getStatus() {
		return status;
	}
	
	public int getRoleID() {
		return roleID;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public Date getUpdated() {
		return updated;
	}
	
	public Date getSuspended() {
		return suspended;
	}
	
	public String getDes() {
		return des;
	}
	public String getPhoto() {
		return photo;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	public void setSuspended(Date suspended) {
		this.suspended = suspended;
	}
	
	public void setDes(String des) {
		this.des = des;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}	
}