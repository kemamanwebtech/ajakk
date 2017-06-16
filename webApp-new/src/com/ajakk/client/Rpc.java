package com.ajakk.client;

import java.util.List;

import com.ajakk.shared.EventDTO;
import com.ajakk.shared.LoginDTO;
import com.ajakk.shared.UserDTO;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("servlet")
public interface Rpc extends RemoteService {
    LoginDTO doLogin(
            String email, 
            String passwd) throws IllegalArgumentException;

    List<EventDTO> getAllEvents(
            String typeFilter,
            String locFilter,
            String dateFilter);
    
    String doSignup(
            String name, 
            String email, 
            String password, 
            String phone);
    
    String createEvent(
            String name, 
            String type, 
            String datetime, 
            String local, 
            UserDTO user);

    UserDTO getUser(String email);
    
    UserDTO getUserFromID(int id);

    String joinEvent(EventDTO event, UserDTO loggedInUser);

    List<UserDTO> viewParticipant(EventDTO event, UserDTO loggedInUser);
}
