package com.ajakk.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ajakk.shared.dto.EventDTO;

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
        String sql = " SELECT EVENT_ID, NAME, DES FROM EVENT ";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            System.out.println(stmt.toString());

            while (rs.next()) {
                EventDTO event  = new EventDTO();
                
                event.setEventID(rs.getInt(1));
                event.setEventName(rs.getString(2));
                event.setEventDes(rs.getString(3));
                
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
    
    public boolean createEvent (EventDTO event, Connection con) {
    	
    	try {            
    		PreparedStatement stmt = con.prepareStatement("INSERT INTO EVENT (NAME, DES) VALUES (? , ?)");
            stmt.setString(1, event.getEventName());
            stmt.setString(2, event.getEventDes());
            stmt.setInt(3, event.getEventID());
            stmt.executeUpdate();	
            return true;
    	} catch (SQLException e) {
            e.printStackTrace();
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
    
    

}
