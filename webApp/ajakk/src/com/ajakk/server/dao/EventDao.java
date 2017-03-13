package com.ajakk.server.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ajakk.shared.dto.EventDTO;
import com.ajakk.portal.util.AjakkConfig;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;


public class EventDao extends EventDTO {
	List<EventDao> listofevent = new ArrayList<EventDao>();
	
	Connection con = null;
	Statement stmt = null;
	String url = "jdbc:mysql://127.0.0.1:3306/db_test";

	public void getDBConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, "root","Enter123");
	}
	
	public List<EventDao> selectEvent(int eventID, int ownerID, int secondOwnerID, String eventName, String eventDes,
			String image, String eventLoc, String eventLocName, String eventType, String Status, Boolean InviteOnly){
		try {
			getDBConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM event";
			ResultSet rs = stmt.executeQuery(sql);

//			int eventID;
//			int ownerID;
//			int secondOwnerID;
//			String eventName;
//			String eventDes;
//			String image;
//			String eventLoc;
//			String eventLocName;
//			String eventType; // type of event
//			Date createdDate;
//			Date fromDate;
//			Date toDate;
//			String status; // status of event : active, passed, deleted
//			boolean inviteOnly; // invite only or open to join
//			boolean commentable; // set if event is commentable
			
			while (rs.next()) {
				EventDao uf = new EventDao();
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
//				uf.setListParticipant(getListParticipant()); Not sure
				uf.setCreatedDate(getCreatedDate());
				uf.setFromDate(getFromDate());
				uf.setToDate(getToDate());
				listofevent.add(uf);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listofevent;
	}
	
}
