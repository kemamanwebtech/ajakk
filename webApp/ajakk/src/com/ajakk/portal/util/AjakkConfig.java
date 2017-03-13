/*
 * To keep configuration, properties, common messages etc
 */
package com.ajakk.portal.util;

import java.sql.DriverManager;
import java.sql.SQLException;

public class AjakkConfig {
	/**
	 * List of static Strings
	 */
	public static final String SERVER_ERROR = 
		"<p>An error occurred while attempting to contact the</p>"
	+   "<p>server. Please check your network connection and try again.</p>";
	
	public static final String AUTH_ERROR = 
			"<p>The username and password combination that</p>"
		  + "<p>you've entered doesn't match any account.</p>";
	
	public static final String ACC_BLOCKED = 
			"<p>Your account has been blocked. Please contact</p>"
		  + "<p>Ajakk support team for more information.</p>";
	
	public static final String ACC_LOCKED = 
			"<p>Your account has been locked for an hour due to </p>"
		  + "<p>multiple invalid login attempts.</p>";
	
	public static final String ACC_DELETED = 
			"<p>Your account apparently has been deleted. If you think</p>"
		  + "<p>this is wrong, please contact Ajakk support team immediately.</p>";

	public static final String ACC_NOTACTIVE = 
			"<p>Your account has been set to inactive. Please contact</p>"
		  + "<p>Ajakk support team for more information.</p>";
					
	// database connection properties
	String dbHost;
	String dbName;
	String dbUserName;
	String dbPasswd;
	
	public AjakkConfig(){
		
		// TODO : load the configs from file system instead of hardcode here
		// initiate properties here
	    
	    // local db
		dbHost="localhost";
		dbName="ajakk";
		dbUserName="root";
		dbPasswd="Enter_123";
		
		// kwt
//		dbHost="localhost";
//        dbName="ajakk";
//        dbUserName="root";
//        dbPasswd="Enter_123";
		
	        
	}

	public String getDbHost() {
		return dbHost;
	}

	public String getDbName() {
		return dbName;
	}

	public String getDbUserName() {
		return dbUserName;
	}

	public String getDbPasswd() {
		return dbPasswd;
	}

	public void setDbHost(String dbHost) {
		this.dbHost = dbHost;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public void setDbUserName(String dbUserName) {
		this.dbUserName = dbUserName;
	}

	public void setDbPasswd(String dbPasswd) {
		this.dbPasswd = dbPasswd;
	}
}
