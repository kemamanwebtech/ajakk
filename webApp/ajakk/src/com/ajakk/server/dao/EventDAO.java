package com.ajakk.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ajakk.shared.dto.EventDTO;

@SuppressWarnings("serial")
public class EventDAO {

    List<EventDTO> eventList = new ArrayList<EventDTO>();

    Connection con  = null;
    Statement  stmt = null;

    /**
     * Get all events (no filter)
     * 
     * No filter, hence no params needed. Connection will be provided by
     * FactoryDAO
     */
    public List<EventDTO> getAllEvents(Connection con) {
        
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

        } catch (SQLException e) {
            e.printStackTrace();
        } // no need to close connection from here. That will be taken care by
          // FactoryDAO
        
        System.out.println("retuning eventList..");
        return eventList;
        
    }
    
    
    

}
