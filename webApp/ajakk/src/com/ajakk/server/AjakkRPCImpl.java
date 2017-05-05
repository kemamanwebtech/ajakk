package com.ajakk.server;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.ajakk.portal.AjakkRPC;
import com.ajakk.server.dao.EventDAO;
import com.ajakk.server.dao.FactoryDAO;
import com.ajakk.server.dao.LoginDAO;
import com.ajakk.server.dao.UserDAO;
import com.ajakk.shared.dto.EventDTO;
import com.ajakk.shared.dto.LoginDTO;
import com.ajakk.shared.dto.UserDTO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class AjakkRPCImpl extends RemoteServiceServlet implements AjakkRPC {
    FactoryDAO daoFactory = new FactoryDAO();

    @Override
	public LoginDTO doLogin(String userName, String passwd) throws IllegalArgumentException {

        // // Verify that the input is valid.
        // if (!FieldVerifier.isValidUserName(userName) ||
        // !FieldVerifier.isValidPasswd(passwd)) {
        // throw new IllegalArgumentException("Fields must not be empty");
        // }

        LoginDAO loginDAO = daoFactory.getLoginDAO();
        return loginDAO.checkLogin(daoFactory.getConnection(), userName, passwd);
    }

    /**
     * Escape an html string. Escaping data received from the client helps to
     * prevent cross-site script vulnerabilities.
     * 
     * @return the escaped string
     */
    @SuppressWarnings("unused")
    private String escapeHtml(String html) {
        if (html == null) {
            return null;
        }
        return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }
    
    /**
     * Get all events (no filter)
     * 
     */
    @Override
    public List<EventDTO> getAllEvents() {
        List<EventDTO> eventList = new ArrayList<EventDTO>();
        Connection con = daoFactory.getConnection();
                
        EventDAO eventDAO = daoFactory.getEventDAO();
        
        eventList = eventDAO.getAllEvents(con);
        return eventList;

    }

	@Override
	public String doSignup(
			String username, 
			String password, 
			String email,
			String phoneNumber) {
		
		UserDTO user = new UserDTO(username, email, phoneNumber);
		Connection con = daoFactory.getConnection();
		UserDAO userDAO = daoFactory.getUserDAO();
		
		try {
			userDAO.registerUser(user, password, con);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return "failed";
	}

	@Override
	public String createEvent(
			String eventName, 
			String eventDesc,
			String eventType, 
			String eventLocation, 
			String userName) {
		
		Connection con = daoFactory.getConnection();
		
		UserDAO userDAO = daoFactory.getUserDAO();
		
		int userID = Integer.parseInt(userDAO.getUserIdByUsername(userName, con));
		EventDTO event = new EventDTO(eventName, eventDesc, eventType, eventLocation, userID);
		EventDAO eventDAO = daoFactory.getEventDAO();
		
		if (eventDAO.createEvent(event, con)) {
			return "success";
		} else {
			return "Error : failed to create event.";
		}
	}
	
	@Override
	public int getUserIDFromUsername(String userName) {
		int userID = 0;
		Connection con = daoFactory.getConnection();
		UserDAO userDAO = daoFactory.getUserDAO();
		userID = Integer.parseInt(userDAO.getUserIdByUsername(userName, con));
		
		return userID;
	}

	@Override
	public List<UserDTO> getUserIDFromUsername() {
		return null;
	}

	@Override
	public List<UserDTO> getUserInfoFromUserID() {
		List<UserDTO> userInfo = new ArrayList<UserDTO>();
        Connection con = daoFactory.getConnection();
                
        EventDAO eventDAO = daoFactory.getEventDAO();
        
//        userInfo = eventDAO.getAllEvents(con);
        userInfo = UserDAO.getAllInfo(con);
        return userInfo;
	}
}
