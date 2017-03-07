package com.ajakk.shared.dto;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class commentDTO implements Serializable {
	int commentID;
	int eventID;
	int userID;
	Date added;
	boolean deleted;
	boolean approved;
	
	/**
	 * Constructor for always approved comments
	 * @param commentID
	 * @param eventID
	 * @param userID
	 * @param added
	 */
	public commentDTO(int commentID, int eventID, int userID, Date added) {
		this.commentID = commentID;
		this.eventID = eventID;
		this.userID = userID;
		this.added = added;
		
		deleted = false; // not deleted by default
		approved = true; // approved by default
	}
	
	/**
	 *  Constructor with approved control
	 * @param commentID
	 * @param eventID
	 * @param userID
	 * @param added
	 * @param approved
	 */
	public commentDTO(int commentID, int eventID, int userID, Date added, boolean approved) {
		this.commentID = commentID;
		this.eventID = eventID;
		this.userID = userID;
		this.added = added;
		
		deleted = false; // not deleted by default
		this.approved = approved; // approved if assigned
	}
	
	
	public int getCommentID() {
		return commentID;
	}
	
	public int getEventID() {
		return eventID;
	}
	
	public int getUserID() {
		return userID;
	}
	
	public Date getAdded() {
		return added;
	}
	
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	
	public void setEventID(int eventID) {
		this.eventID = eventID;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public void setAdded(Date added) {
		this.added = added;
	}
	
	public void deleteComment() {
		this.deleted = true;
	}
	
	public void approveComment() {
		this.approved = true;
	}
	
	
	
}
