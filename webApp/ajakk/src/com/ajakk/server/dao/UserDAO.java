package com.ajakk.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ajakk.shared.dto.UserDTO;

@SuppressWarnings("serial")
public class UserDAO extends UserDTO {
	
	Connection con  = null;
	Statement  stmt = null;
	
	
	public void registerUser(Connection con){
		
		String sql1 = " INSERT INTO AJAKK_USER (USER_NAME, STATUS, UPDATED, ROLE_ID)" + "VALUES (?, ? , ? ,?)";  
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql1);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
            	UserDAO user = new UserDAO();
            	
           
            	user.setName(rs.getString(1));
            	user.setStatus(rs.getString(2));
            	user.setUpdated(rs.getDate(3));
            	user.setRoleID(rs.getInt(4));
            	
            	stmt.executeQuery();
            }
            
		} catch (SQLException e) {
            e.printStackTrace();
        }
		
//		String sql2 = " INSERT INTO AJAKK_PASS (AJAKK_USER_ID, ACCESS_PASS)" + "VALUES (? , ?)"; 
//		
//		try {
//			PreparedStatement stmt = con.prepareStatement(sql2);
//            ResultSet rs = stmt.executeQuery();
//            
//            while (rs.next()){
//            	UserDAO pass = new UserDAO();
//            	
//            	pass.setUserID(rs.getInt(1);
//            	pass.set
//            	
//            }
//            
//		} catch (SQLException e) {
//            e.printStackTrace();
//        }
//		INSERT INTO AJAKK_PASS 
//		(AJAKK_USER_ID, ACCESS_PASS)
//		VALUES 
//		(3, "password")
		
	}
}
