package com.ajakk.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.ajakk.server.NamedParameterStatement;
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
     * @param dateFilter 
     * @param locFilter 
     * @param typeFilter 
     */
    public List<EventDTO> getAllEvents(String typeFilter, String locFilter, String dateFilter, Connection con) {
        
        eventList = new ArrayList<EventDTO>();
        Boolean typeF = false;
        Boolean locF = false;
        Boolean dateF = false;
        
        // be specific of what fields we want, avoid using *
        String sql = " SELECT EVENT_ID, NAME, DES, TYPE, OWNER_ID, CONFIRMED_DATE, LOOKING_FOR, LOC FROM EVENT ";
        
        if (!typeFilter.isEmpty() || !(typeFilter.equals(""))
            || !locFilter.isEmpty() || !(locFilter.equals("")) 
            || !dateFilter.isEmpty() || !(dateFilter.equals(""))) {
            String where = " WHERE ";
            sql += where;
            Boolean i = false;
            
            if (!typeFilter.isEmpty() || !(typeFilter.equals(""))){
                sql += " TYPE=:TYPE ";
                i = true;
                typeF = true;
            }
            
            if (!locFilter.isEmpty() || !(locFilter.equals(""))){
                if (i) {
                    sql += " and LOC=:LOC ";
                } else {
                    sql += " LOC=:LOC ";
                    i = true;
                }
                locF = true;
            }
            
            if (!dateFilter.isEmpty() || !(dateFilter.equals(""))){
                if (i) {
                    sql += " and CONFIRMED_DATE>:CONFIRMED_DATE ";
                } else {
                    sql += " CONFIRMED_DATE>:CONFIRMED_DATE ";
                }
                dateF = true;
            }
        }
        
        try {
            NamedParameterStatement stmt = new NamedParameterStatement(con, sql);
            if (typeF) stmt.setString("TYPE", typeFilter);
            if (locF) stmt.setString("LOC", locFilter);
            if (dateF) stmt.setString("CONFIRMED_DATE", dateFilter + "%");
            
            ResultSet rs = stmt.executeQuery();
            
            System.out.println(stmt.getStatement());

            while (rs.next()) {
                EventDTO event  = new EventDTO();
                event.setEventID(rs.getInt(1));
                event.setEventName(rs.getString(2));
                event.setEventDes(rs.getString(3));
                event.setEventType(rs.getString(4));
                event.setOwnerID(rs.getInt(5));
                event.setEventDate(rs.getString(6));
                event.setLookFor(rs.getInt(7));
                event.setEventLoc(rs.getString(8));
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
                + "(NAME, TYPE, CONFIRMED_DATE, LOC, LOOKING_FOR, OWNER_ID) VALUES " 
                + "(? 	  , ?   ,?            ,?     ,?           ,?  )");
            
            stmt.setString(1, event.getEventName());
            stmt.setString(2, event.getEventType());
            stmt.setString(3, event.getEventDate());
            stmt.setString(4, event.getEventLoc());
            stmt.setInt(5, event.getLookFor());
            stmt.setInt(6, event.getOwnerID());
            stmt.executeUpdate();
            ServerSideUtil.printQuery(this, stmt);
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
            ServerSideUtil.printQuery(this, stmt);
            
            if (rs.next()) {
                result = true;
            } else result = false;
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return result;
    }

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
            ServerSideUtil.printQuery(this, stmt);
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
            
            ServerSideUtil.printQuery(this, stmt);

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
