package com.ajakk.server.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ajakk.shared.dto.EventDTO;

@SuppressWarnings("serial")
public class EventDAO extends EventDTO {

    List<EventDAO> eventList = new ArrayList<EventDAO>();

    Connection con  = null;
    Statement  stmt = null;

    /**
     * Get all events (no filter)
     * 
     * No filter, hence no params needed. Connection will be provided by
     * FactoryDAO
     */
    public List<EventDAO> getEvents(Connection con) {

        try {

            stmt = con.createStatement();
            String sql = "SELECT * FROM event";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                EventDAO uf = new EventDAO();
                uf.setEventID(rs.getInt(1));
                uf.setOwnerID(rs.getInt(2));
                uf.setSecondOwnerID(rs.getInt(3));
                uf.setEventName(rs.getString(4));
                uf.setEventDes(rs.getString(5));
                uf.setImage(rs.getString(6));
                uf.setEventLoc(rs.getString(7));
                uf.setEventType(rs.getString(8));
                uf.setStatus(rs.getString(9));
                uf.setInviteOnly(rs.getBoolean(10));
                uf.setCreatedDate(getCreatedDate());
                uf.setFromDate(getFromDate());
                uf.setToDate(getToDate());
                eventList.add(uf);
            }

            System.out.println("Events selected : " + eventList.size());

        } catch (Exception e) {
            e.printStackTrace();
        } // no need to close connection from here. That will be taken care by
          // FactoryDAO

        return eventList;
    }

}
