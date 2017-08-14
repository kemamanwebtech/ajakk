package com.ajakk.server;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.ajakk.client.Rpc;
import com.ajakk.server.dao.EventDAO;
import com.ajakk.server.dao.FactoryDAO;
import com.ajakk.server.dao.LoginDAO;
import com.ajakk.server.dao.UserDAO;
import com.ajakk.shared.EventDTO;
import com.ajakk.shared.LoginDTO;
import com.ajakk.shared.UserDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;


/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class RpcImpl extends RemoteServiceServlet implements Rpc {

    FactoryDAO daoFactory = new FactoryDAO();

    @Override
    public LoginDTO doLogin(String email, String passwd)
            throws IllegalArgumentException {

        LoginDAO loginDAO = daoFactory.getLoginDAO();
        return loginDAO.checkLogin(daoFactory.getConnection(), email,
                passwd);
    }

    @SuppressWarnings("unused")
    private String escapeHtml(String html) {
        if (html == null) {
            return null;
        }
        return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;");
    }

    @Override
    public List<EventDTO> getAllEvents(String typeFilter, String locFilter, String dateFilter) {
        List<EventDTO> eventList = new ArrayList<EventDTO>();
        Connection con = daoFactory.getConnection();

        EventDAO eventDAO = daoFactory.getEventDAO();

        eventList = eventDAO.getAllEvents(typeFilter, locFilter, dateFilter, con);
        return eventList;
    }

    @Override
    public String doSignup(String name, String email, String password,
            String phone, String location) {

        UserDTO user = new UserDTO(name, email, phone, location);
        Connection con = daoFactory.getConnection();
        UserDAO userDAO = daoFactory.getUserDAO();

        try {
            userDAO.registerUser(user, password, con);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR : In RpcImpl.doSignUp.." + e.getMessage());
        }
        return "failed";
    }

    @Override
    public String createEvent(String name, String type,
            String datetime, String loc, 
            String lookFor, UserDTO user) {
        
        String result = "";
        System.out.println("INFO : In RpcImpl.createEvent().." + "User : " + user.getName() );
        
        Connection con = null;
        UserDAO userDAO = null;
        EventDAO eventDAO = null;
        EventDTO event = null;
        
        try {
            con = daoFactory.getConnection();
            event = new EventDTO(name, type, datetime, loc, Integer.parseInt(lookFor), user.getUserID());
            eventDAO = daoFactory.getEventDAO();
            
            if (eventDAO.createEvent(event, con)) {
                result = "success";
            } else {
                result = "Error : failed to create event.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR : In RpcImpl.createEvent().." + e.toString());
        }
        return result;
    }

    @Override
    public UserDTO getUser(String email) {
        Connection con = daoFactory.getConnection();
        UserDAO userDAO = daoFactory.getUserDAO();
        UserDTO user = new UserDTO();
        user = userDAO.getUserByEmail(email, con);

        return user;
    }
    
    @Override
    public UserDTO getUserFromID(int id) {
        Connection con = daoFactory.getConnection();
        UserDAO userDAO = daoFactory.getUserDAO();
        UserDTO user = new UserDTO();
        user = userDAO.getUserByID(id, con);

        return user;
    }

    @Override
    public String joinEvent(EventDTO event, UserDTO loggedInUser) {
        Connection con = daoFactory.getConnection();
        EventDAO eventDAO = daoFactory.getEventDAO();

        if (eventDAO.joinEvent(event, loggedInUser, con)) {
            return "success";
        } else {
            return "Error : failed to join event.";
        }
    }

    @Override
    public List<UserDTO> viewParticipant(EventDTO event, UserDTO loggedInUser) {
        Connection con = daoFactory.getConnection();
        EventDAO eventDAO = daoFactory.getEventDAO();

        return eventDAO.viewParticipant(event, loggedInUser, con);
    }
}
