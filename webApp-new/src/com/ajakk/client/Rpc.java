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
            String userName, 
            String passwd) throws IllegalArgumentException;

    List<EventDTO> getAllEvents();
    
    String doSignup(
            String username, 
            String password, 
            String email, 
            String phoneNumber);
    
    String createEvent(
            String eventName, 
            String eventDesc, 
            String eventType, 
            String eventLocation, 
            String userName);

    UserDTO getUser(String email);
}
