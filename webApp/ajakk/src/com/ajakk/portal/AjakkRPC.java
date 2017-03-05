package com.ajakk.portal;

import com.ajakk.shared.dto.LoginDTO;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("service")
public interface AjakkRPC extends RemoteService {
	LoginDTO doLogin(String userName, String passwd) throws IllegalArgumentException;
}
