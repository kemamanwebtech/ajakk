package com.ajakk.portal;

import java.util.List;

import com.ajakk.shared.dto.EventDTO;
import com.ajakk.shared.dto.LoginDTO;
import com.ajakk.shared.dto.UserDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("service")
public interface AjakkRPC extends RemoteService {

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

	List<UserDTO> getUserIDFromUsername();

	int getUserIDFromUsername(String username);

	List<UserDTO> getUserInfoFromUserID();
}
