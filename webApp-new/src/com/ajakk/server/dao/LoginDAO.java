/*
 *  DAO for login
 */

package com.ajakk.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ajakk.server.ServerSideUtil;
import com.ajakk.shared.LoginDTO;

public class LoginDAO {
    LoginDTO result = null;

    /*
     * check username and password returns LoginDTO object with user ID (0 if
     * not existed) and status.
     */
    public LoginDTO checkLogin(Connection con, String email, String passwd) {

        String sql = " SELECT A.AJAKK_USER_ID, A.STATUS "
                + " FROM AJAKK_USER A " + " JOIN AJAKK_PASS B "
                + " ON A.AJAKK_USER_ID = B.AJAKK_USER_ID "
                + " WHERE A.EMAIL = ? " + " AND B.ACCESS_PASS = ? ";

        result = new LoginDTO();

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, passwd);

            ResultSet rs = pstmt.executeQuery();
            System.out.println("In checkLogin : " + ServerSideUtil.getQuery(pstmt));

            if (rs.next()) {
                System.out.println("INFO : " + result.toString());
                result.setUserID(rs.getInt("AJAKK_USER_ID"));
                result.setUserStatus(rs.getString("STATUS"));
                return result;
            }
        } catch (SQLException e) {
            System.out.println("ERROR : checkLogin");
            e.printStackTrace();
        }

        // for invalid login,
        result.setUserID(0);
        result.setUserStatus("Invalid");
        return result;
    }
}
