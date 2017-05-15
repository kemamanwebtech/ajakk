package com.ajakk.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.ajakk.server.ServerSideUtil;
import com.ajakk.shared.EventDTO;
import com.ajakk.shared.UserDTO;
import com.google.gwt.i18n.client.DateTimeFormat;

public class EventDAO {

    List<EventDTO> eventList = null;

    Connection con  = null;
    Statement  stmt = null;

    /**
     * Get all events (no filter)
     * 
     * No filter, hence no params needed. Connection will be provided by
     * FactoryDAO
     */
    public List<EventDTO> getAllEvents(Connection con) {
        
        eventList = new ArrayList<EventDTO>();
        
        // be specific of what fields we want, avoid using *
        String sql = " SELECT EVENT_ID, NAME, DES, TYPE, OWNER_ID, CONFIRMED_DATE, LOC FROM EVENT ";
        
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            System.out.println(stmt.toString());

            while (rs.next()) {
                EventDTO event  = new EventDTO();
                event.setEventID(rs.getInt(1));
                event.setEventName(rs.getString(2));
                event.setEventDes(rs.getString(3));
                event.setEventType(rs.getString(4));
                event.setOwnerID(rs.getInt(5));
                event.setFromDate(rs.getDate(6));
                event.setEventLoc(rs.getString(7));
                eventList.add(event);
            }

            System.out.println("Events selected : " + eventList.size());
            return eventList;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } // no need to close connection from here. That will be taken care by
          // FactoryDAO
        return eventList;
        
    }
    
    public boolean createEvent(EventDTO event, Connection con) {
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO EVENT " 
                + "(NAME, TYPE, CONFIRMED_DATE, LOC, OWNER_ID) VALUES " 
                + "(? 	  , ?   ,?            ,?  ,?  )");
            
            stmt.setString(1, event.getEventName());
            stmt.setString(2, event.getEventType());
            stmt.setString(3, event.getEventDate());
            stmt.setString(4, event.getEventLoc());
            stmt.setInt(5, event.getOwnerID());
            stmt.executeUpdate();
            System.out.println(ServerSideUtil.getQuery(stmt));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public void updateEvent(EventDTO event) {
    	
    	try {            
		
            PreparedStatement stmt = con
                   .prepareStatement("UPDATE EVENT SET NAME=?, DES=?" + "WHERE EVENT_ID=?");
            stmt.setString(1, event.getEventName());
            stmt.setString(2, event.getEventDes());
            stmt.setInt(3, event.getEventID());
            	
            stmt.executeUpdate();
            
    		
    	}catch (SQLException e) {
            e.printStackTrace();
        }
    	
    }
    
    public void deleteEvent (EventDTO event) {
    	
    	try {            
		
            PreparedStatement stmt = con
                    .prepareStatement("DELETE FROM EVENT WHERE EVENT_ID=?");
                        
            stmt.setInt(1, event.getEventID());
            stmt.executeUpdate();
            
    		
    	}catch (SQLException e) {
            e.printStackTrace();
        }
    	
    }
    
    public boolean checkParticipation(EventDTO event, UserDTO user, Connection con) {
        PreparedStatement stmt = null;
        boolean result = false;
        try {            
            stmt = con.prepareStatement("SELECT EVENT_ID FROM EVENT_PARTICIPANT "
                + " WHERE EVENT_ID = ? "
                + " AND AJAKK_USER_ID = ? ");
            
            stmt.setInt(1, event.getEventID());
            stmt.setInt(2, user.getUserID());
            
            ResultSet rs = stmt.executeQuery();
            System.out.println(ServerSideUtil.getQuery(stmt));
            
            if (rs.next()) {
                result = true;
            } else result = false;
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    @SuppressWarnings("resource")
    public boolean joinEvent(EventDTO event, UserDTO user, Connection con) {
        boolean result = false;
        PreparedStatement stmt = null;
        try {            
           if (checkParticipation(event, user, con)) {
               stmt = con.prepareStatement("UPDATE EVENT_PARTICIPANT SET STATUS = 'Attending' "
                   + " WHERE EVENT_ID = ? "
                   + " AND AJAKK_USER_ID = ? ");
               
               stmt.setInt(1, event.getEventID());
               stmt.setInt(2, user.getUserID());
               stmt.executeUpdate();
               return true;
            }
           
            stmt = con.prepareStatement("INSERT INTO EVENT_PARTICIPANT "
                + " (EVENT_ID, AJAKK_USER_ID, STATUS) "
                + " VALUES (?, ?, ?)");
                        
            stmt.setInt(1, event.getEventID());
            stmt.setInt(2, user.getUserID());
            stmt.setString(3, "Attending");
            System.out.println(ServerSideUtil.getQuery(stmt));
            stmt.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return result;
    }

    public List<UserDTO> viewParticipant(EventDTO event, UserDTO loggedInUser, Connection con) {
        List<UserDTO> userList = new ArrayList<UserDTO>();
        
        // be specific of what fields we want, avoid using *
        String sql = " select a.AJAKK_USER_ID, a.USER_NAME, a.DES, a.EMAIL, a.PHONE_NO from AJAKK_USER a " + 
                        " join EVENT_PARTICIPANT b " + 
                        " on a.AJAKK_USER_ID = b.AJAKK_USER_ID " + 
                        " where b.EVENT_ID = ? ";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, event.getEventID());
            ResultSet rs = stmt.executeQuery();
            
            System.out.println(ServerSideUtil.getQuery(stmt));

            while (rs.next()) {
                UserDTO user = new UserDTO();
                user = new UserDTO();
                user.setUserID(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setDes(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setPhoneNumber(rs.getString(5));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } 
        return userList;
    }

}
