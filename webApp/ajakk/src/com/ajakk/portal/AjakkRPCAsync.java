package com.ajakk.portal;

import com.ajakk.shared.dto.LoginDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface AjakkRPCAsync {
	void doLogin(String userName, String passwd, AsyncCallback<LoginDTO> callback) throws IllegalArgumentException;
}
