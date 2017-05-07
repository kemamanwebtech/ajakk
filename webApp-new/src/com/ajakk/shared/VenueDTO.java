package com.ajakk.shared;

import java.io.Serializable;


@SuppressWarnings("serial")
public class VenueDTO implements Serializable {
	
	int venueID;
	String ownerName;
	int ownerHP;
	String paymentDetails;
	String venueRate;
	String location;
	String locGPS;
	String locAddress;
	String venuePhoto;
	String venueDes;
	
	public int getVenueID() {
		return venueID;
	}
	public void setVenueID(int venueID) {
		this.venueID = venueID;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public int getOwnerHP() {
		return ownerHP;
	}
	public void setOwnerHP(int ownerHP) {
		this.ownerHP = ownerHP;
	}
	public String getPaymentDetails() {
		return paymentDetails;
	}
	public void setPaymentDetails(String paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	public String getVenueRate() {
		return venueRate;
	}
	public void setVenueRate(String venueRate) {
		this.venueRate = venueRate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLocGPS() {
		return locGPS;
	}
	public void setLocGPS(String locGPS) {
		this.locGPS = locGPS;
	}
	public String getLocAddress() {
		return locAddress;
	}
	public void setLocAddress(String locAddress) {
		this.locAddress = locAddress;
	}
	public String getVenuePhoto() {
		return venuePhoto;
	}
	public void setVenuePhoto(String venuePhoto) {
		this.venuePhoto = venuePhoto;
	}
	public String getVenueDes() {
		return venueDes;
	}
	public void setVenueDes(String venueDes) {
		this.venueDes = venueDes;
	}
	
}
