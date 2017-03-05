package com.ajakk.portal.util;

public class AjakkConfig {
	/**
	 * List of static Strings
	 */
	public static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " 
			+ "connection and try again.";
	
	String dbHost;
	String dbName;
	String dbUserName;
	String dbPasswd;
	
	public AjakkConfig(){
		
		// TODO : load the configs from file system instead of hardcode here
		
		dbHost="localhost";
		dbName="ajakk";
		dbUserName="root";
		dbPasswd="Enter_123";
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
