/*
 * DAO Factory - to share & manage a single connection among DAOs
 * using Factory pattern
 */
package com.ajakk.server.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ajakk.portal.util.AjakkConfig;

public class FactoryDAO {
    AjakkConfig       config = null;
    static Connection con    = null;

    public FactoryDAO() {
        // load configuration
        config = new AjakkConfig();
    }

    /**
     * Return connection object to db
     */
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + config.getDbHost() + ":3306/" + config.getDbName(),
                    config.getDbUserName(), config.getDbPasswd());
        } catch (Exception e) {
            System.out.println("ERROR : getConnection");
            e.printStackTrace();
        }
        return con;
    }

    /**
     * Return true if there is current connection to db
     */
    public boolean haveConnection() {
        if (con == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Close connection
     */
    public void closeConnection() {
        if (con == null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("ERROR : closeConnection");
                e.printStackTrace();
            }
        }
    }

    /**
     * get LoginDAO
     */
    public LoginDAO getLoginDAO() {
        LoginDAO loginDAO = new LoginDAO();
        return loginDAO;
    }

    /**
     * get EventDAO
     * 
     * @return
     */
    public EventDAO getEventDAO() {
        EventDAO eventDAO = new EventDAO();
        return eventDAO;
    }

}
