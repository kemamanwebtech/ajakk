package com.ajakk.portal;

import java.util.List;

import com.ajakk.shared.dto.EventDTO;
import com.ajakk.shared.dto.LoginDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>AjakkRPC</code>.
 */
public interface AjakkRPCAsync {

    void doLogin(String userName, String passwd, AsyncCallback<LoginDTO> callback) throws IllegalArgumentException;

    /**
     * Get all events from database (no filter)
     * 
     * @param asyncCallback
     */
    @SuppressWarnings("rawtypes")
    void getAllEvents(AsyncCallback asyncCallback);

}
