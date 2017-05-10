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
    public List<EventDTO> getAllEvents() {
        List<EventDTO> eventList = new ArrayList<EventDTO>();
        Connection con = daoFactory.getConnection();

        EventDAO eventDAO = daoFactory.getEventDAO();

        eventList = eventDAO.getAllEvents(con);
        return eventList;
    }

    @Override
    public String doSignup(String name, String email, String password,
            String phone) {

        UserDTO user = new UserDTO(name, email, phone);
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
    public String createEvent(String eventName, String eventDesc,
            String eventDate, String eventLocation, String userName) {

        Connection con = daoFactory.getConnection();

        UserDAO userDAO = daoFactory.getUserDAO();

        int userID = Integer
                .parseInt(userDAO.getUserIdByUsername(userName, con));
        EventDTO event = new EventDTO(eventName, eventDesc, eventDate,
                eventLocation, userID);
        EventDAO eventDAO = daoFactory.getEventDAO();

        if (eventDAO.createEvent(event, con)) {
            return "success";
        } else {
            return "Error : failed to create event.";
        }
    }

    @Override
    public UserDTO getUser(String email) {
        Connection con = daoFactory.getConnection();
        UserDAO userDAO = daoFactory.getUserDAO();
        UserDTO user = new UserDTO();
        user = userDAO.getUserByEmail(email, con);

        return user;
    }
}
