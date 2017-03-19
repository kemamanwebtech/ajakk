package com.ajakk.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ajakk.shared.dto.VenueDTO;

public class VenueDAO {
	
	List<VenueDTO> venueList = new ArrayList<VenueDTO>();

    Connection con  = null;
    Statement  stmt = null;
    
    public List<VenueDTO> getAllVenues(Connection con){
    	
    	
    	String sql = " SELECT VENUE_ID, OWNER_NAME, VENUE_RATE, VENUE_DES, VENUE_PHOTO FROM VENUE ";
    	
    	 try {
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery();
             
             System.out.println(stmt.toString());

             while (rs.next()) {
                 VenueDTO venue  = new VenueDTO();
                 
                 venue.setVenueID(rs.getInt(1));
                 venue.setOwnerName(rs.getString(2));
                 venue.setVenueRate(rs.getString(3));
                 venue.setVenueDes(rs.getString(4));
                 venue.setVenuePhoto(rs.getString(5));
                 
                 venueList.add(venue);
                 
             }

             System.out.println("venue selected : " + venueList.size());

         } catch (SQLException e) {
             e.printStackTrace();
         } 
         
         System.out.println("retuning venueList..");
         return venueList;
    }
    
    	public void createVenue (VenueDTO venue) {
    	
    	try {            
		
            PreparedStatement stmt = con
                    .prepareStatement("INSERT INTO VENUE(OWNER_NAME, OWNER_HP, PAYMENT_DETAILS, VENUE_RATE, LOCATION, LOC_GPS, LOC_ADDRESS, VENUE_PHOTO, VENUE_DES) VALUES (?,?,?,?,?,?,?,?,?)");
            
        	
            stmt.setString(1, venue.getOwnerName());
            stmt.setInt(2, venue.getOwnerHP());
            stmt.setString(3, venue.getPaymentDetails());
            stmt.setString(4, venue.getVenueRate());
            stmt.setString(5, venue.getLocation());
            stmt.setString(6, venue.getLocGPS());
            stmt.setString(7, venue.getLocAddress());
            stmt.setString(8, venue.getVenuePhoto());
            stmt.setString(9, venue.getVenueDes());

            stmt.executeUpdate();
            
    		
    	}catch (SQLException e) {
            e.printStackTrace();
        }
    	
    }
    	
    	public void updateVenue (VenueDTO venue){
    		
    		try {
    			PreparedStatement stmt = con
                        .prepareStatement("INSERT INTO VENUE(OWNER_HP, PAYMENT_DETAILS, VENUE_RATE, VENUE_PHOTO, VENUE_DES) VALUES (?,?,?,?,?)");
                
    			stmt.setInt(1, venue.getOwnerHP());
    			stmt.setString(2, venue.getPaymentDetails());
    			stmt.setString(3, venue.getVenueRate());
    			stmt.setString(4, venue.getVenuePhoto());
    			stmt.setString(5, venue.getVenueDes());
    			stmt.executeUpdate();
    		
	    	}catch (SQLException e) {
	            e.printStackTrace();
	        }
    	}
    	
    	public void deleteVenue (VenueDTO venue){
    		
    		try {            
    			
                PreparedStatement stmt = con
                        .prepareStatement("DELETE FROM VENUE WHERE VENUE_ID=?");
                            
                stmt.setInt(1, venue.getVenueID());
                stmt.executeUpdate();
                
        		
        	}catch (SQLException e) {
                e.printStackTrace();
            }
    	}
}
