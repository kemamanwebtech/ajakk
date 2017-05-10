package com.ajakk.server;

import java.sql.PreparedStatement;

public class ServerSideUtil {
    
    public static String getQuery (PreparedStatement stmt){
        String tempSQL = stmt.toString();
        int strStmt = tempSQL.indexOf(":")+2;
        tempSQL = tempSQL.substring(strStmt);
        return tempSQL;
    }
    
    
}
