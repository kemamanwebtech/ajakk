package com.ajakk.shared;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class EventDTO implements Serializable {
	
	int eventID;
	int ownerID;
	int secondOwnerID;
	String eventName;
	String eventDes;
	String image;
	String eventLoc;
	String eventLocName;
	String eventType; // type of event
	String eventDate;
	Date createdDate;
	Date fromDate;
	Date toDate;
	String status; // status of event : active, passed, deleted
	boolean inviteOnly; // invite only or open to join
	boolean commentable; // set if event is commentable
	
	
	List<ParticipantDTO> listParticipant;
	List<commentDTO> comments;
	
	public EventDTO() {
		
	}
	
	public EventDTO(
			String name, 
			String type, 
			String datetime,
			String location,
			int userID) {
		
		this.eventName = name;
		this.eventType = type;
		this.eventDate = datetime;;
		this.eventLoc = location;
		this.ownerID = userID;	
	}
	
	
	public int getEventID() {
		return eventID;
	}
	
	public int getOwnerID() {
		return ownerID;
	}
	
	public int getSecondOwnerID() {
		return secondOwnerID;
	}
	
	public String getEventName() {
		return eventName;
	}
	
	public String getEventDes() {
		return eventDes;
	}
	
	public String getImage() {
		return image;
	}
	
	public String getEventLoc() {
		return eventLoc;
	}
	
	public String getEventLocName() {
		return eventLocName;
	}
	
	public String getEventType() {
		return eventType;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public Date getFromDate() {
		return fromDate;
	}
	
	public Date getToDate() {
		return toDate;
	}
	
	public String getStatus() {
		return status;
	}
	

	
	public List<ParticipantDTO> getListParticipant() {
		return listParticipant;
	}
	
	public void setEventID(int eventID) {
		this.eventID = eventID;
	}
	
	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}
	
	public void setSecondOwnerID(int secondOwnerID) {
		this.secondOwnerID = secondOwnerID;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public void setEventDes(String eventDes) {
		this.eventDes = eventDes;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public void setEventLoc(String eventLoc) {
		this.eventLoc = eventLoc;
	}
	
	public void setEventLocName(String eventLocName) {
		this.eventLocName = eventLocName;
	}
	
	public void setEventType(String type) {
		this.eventType = type;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setInviteOnly(boolean set) {
		this.inviteOnly = set;
	}
	
	public void setListParticipant(ArrayList<ParticipantDTO> listParticipant) {
		this.listParticipant = listParticipant;
	}
	
	/**
	 * Add new participant to the list 
	 * @param newJoiner
	 */
	public void addParticipant(ParticipantDTO newJoiner) {
		this.listParticipant.add(newJoiner);
	}
	
	/**
	 * Check if the event is by invitation only
	 * @return
	 */
	public boolean isInviteOnly() {
		return inviteOnly;
	}
	
	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}


	
	
	
	
}
