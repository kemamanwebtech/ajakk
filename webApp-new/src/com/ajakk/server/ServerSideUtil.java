/*
 * Server side utility class for easy debugging
 */

package com.ajakk.server;

import java.sql.Statement;

public class ServerSideUtil {

    public static void printQuery(Object context, Statement stmt) {
        String tempSQL = stmt.toString();
        int strStmt = tempSQL.indexOf(":") + 2;
        tempSQL = tempSQL.substring(strStmt);
        System.out.println(context.getClass().getSimpleName() + " : " + tempSQL);
    }

}
