package com.ajakk.client;

import java.util.List;
import com.ajakk.shared.EventDTO;
import com.ajakk.shared.LoginDTO;
import com.ajakk.shared.UserDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface RpcAsync {
    
    void doLogin(
            String email, 
            String passwd, 
            AsyncCallback<LoginDTO> callback) throws IllegalArgumentException;

    @SuppressWarnings("rawtypes")
    void getAllEvents(String typeFilter, String locFilter, String dateFilter, AsyncCallback asyncCallback);
    
    /**
     * Register a user
     * 
     * @param text
     * @param text2
     * @param text3
     * @param text4
     * @param asyncCallback
     */
    void doSignup(
            String name, 
            String email, 
            String password, 
            String phone,
            AsyncCallback<String> asyncCallback);

    void createEvent(
            String name, 
            String type, 
            String datetime, 
            String loc, 
            UserDTO user,
            AsyncCallback<String> asyncCallback);
    
    void getUser(String email, AsyncCallback<UserDTO> asyncCallback);

    void getUserFromID(int id, AsyncCallback<UserDTO> asyncCallback);

    void joinEvent(EventDTO event, UserDTO loggedInUser, AsyncCallback<String> asyncCallback);

    void viewParticipant(EventDTO event, UserDTO loggedInUser, AsyncCallback<List<UserDTO>> asyncCallback);

}
