package com.ajakk.shared.dto;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class ParticipantDTO implements Serializable {
	int userID;
	Date repliedDate;
	String status; // status of the participants : confirmed, maybe, declined
	
	public ParticipantDTO(int userID, Date repliedDate, String status){
		this.userID = userID;
		this.repliedDate = repliedDate;
		this.status = status;	
	}
	
	public int getUserID() {
		return userID;
	}
	
	public Date getRepliedDate() {
		return repliedDate;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public void setRepliedDate(Date repliedDate) {
		this.repliedDate = repliedDate;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
