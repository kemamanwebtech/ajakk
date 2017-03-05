package com.ajakk.server;

import java.sql.Connection;

import com.ajakk.portal.AjakkRPC;
import com.ajakk.server.dao.FactoryDAO;
import com.ajakk.server.dao.LoginDAO;
import com.ajakk.shared.FieldVerifier;
import com.ajakk.shared.dto.LoginDTO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class AjakkRPCImpl extends RemoteServiceServlet implements AjakkRPC {
	FactoryDAO daoFactory = new FactoryDAO();
	
	public LoginDTO doLogin(String userName, String passwd) throws IllegalArgumentException {
		
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidUserName(userName) || !FieldVerifier.isValidPasswd(passwd)) {
			throw new IllegalArgumentException("Fields must not be empty");
		}
		
		LoginDAO loginDAO = daoFactory.getLoginDAO();
		return loginDAO.checkLogin(daoFactory.getConnection(),userName, passwd);
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to prevent cross-site script vulnerabilities.
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}
}
