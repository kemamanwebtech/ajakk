package com.ajakk.client;

import java.util.List;

import com.ajakk.shared.LoginDTO;
import com.ajakk.shared.UserDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface RpcAsync {
    void doLogin(
            String userName, 
            String passwd, 
            AsyncCallback<LoginDTO> callback) throws IllegalArgumentException;

    /**
     * Get all events from database (no filter)
     * 
     * @param asyncCallback
     */
    @SuppressWarnings("rawtypes")
    void getAllEvents(AsyncCallback asyncCallback);
    
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
            String username, 
            String password, 
            String email, 
            String phoneNumber,
            AsyncCallback<String> asyncCallback);

    void createEvent(
            String eventName, 
            String eventDesc, 
            String eventType, 
            String eventLocation, 
            String userName,
            AsyncCallback<String> asyncCallback);
    
    void getUser(String email, AsyncCallback<UserDTO> asyncCallback);

}
