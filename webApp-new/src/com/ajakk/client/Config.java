package com.ajakk.client;

public class Config {
    /**
     * List of static Strings
     */
    public static final String SERVER_ERROR = 
        "An error occurred while attempting to contact the server. Please check your network connection and try again.";
    
    public static final String AUTH_ERROR = 
            "The username and password combination that "
          + "you've entered doesn't match any account.";
    
    public static final String ACC_BLOCKED = 
            "Your account has been blocked. Please contact"
          + "Ajakk support team for more information.";
    
    public static final String ACC_LOCKED = 
            "Your account has been locked for an hour due to "
          + "multiple invalid login attempts.";
    
    public static final String ACC_DELETED = 
            "Your account apparently has been deleted. If you think"
          + "this is wrong, please contact Ajakk support team immediately.";

    public static final String ACC_NOTACTIVE = 
            "Your account has been set to inactive. Please contact"
          + "Ajakk support team for more information.";
                    
    // database connection properties
    String dbHost;
    String dbName;
    
    public String getDbHost() {
        return dbHost;
    }

    public void setDbHost(String dbHost) {
        this.dbHost = dbHost;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbUserName() {
        return dbUserName;
    }

    public void setDbUserName(String dbUserName) {
        this.dbUserName = dbUserName;
    }

    public String getDbPasswd() {
        return dbPasswd;
    }

    public void setDbPasswd(String dbPasswd) {
        this.dbPasswd = dbPasswd;
    }

    String dbUserName;
    String dbPasswd;
    
    public Config() {
        getConnectionConfig();
    }
    
    public void getConnectionConfig() {
        dbHost="localhost";
        dbName="ajakk";
        dbUserName="kwt";
        dbPasswd="Enter_123";
    }
}
