package com.ajakk.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ajakk.shared.dto.EventDTO;
import com.ajakk.shared.dto.UserDTO;

@SuppressWarnings("serial")
public class UserDAO extends UserDTO {
	
	Connection con  = null;
	Statement  stmt = null;
	List<UserDTO> userList = new ArrayList<UserDTO>();
	
	public List<UserDTO> getAllUsers(Connection con){
		
		String sql = " SELECT AJAKK_USER_ID, USER_NAME, DES FROM AJAKK_USER ";
		
		try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            System.out.println(stmt.toString());

            while (rs.next()) {
                
            	UserDTO user =  new UserDTO();
            	
            	user.setUserID(rs.getInt(1));
            	user.setName(rs.getString(2));
            	user.setDes(rs.getString(3));
            	
                userList.add(user);
            }
            
		} catch (SQLException e) {
            e.printStackTrace();
        }
		
		System.out.println("retuning userList..");
        return userList;
		
	}
	
	public void registerUser(UserDTO user){ 
		
		try {
		
            
            PreparedStatement stmt = con
                    .prepareStatement("INSERT INTO AJAKK_USER (USER_NAME, STATUS, UPDATED, ROLE_ID)" 
            + "VALUES (? , ? , ? , ?)");
            
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getStatus());
            stmt.setDate(3, user.getUpdated());
            stmt.setInt(4, user.getRoleID());
            stmt.executeUpdate();
     
            
		} catch (SQLException e) {
            e.printStackTrace();
        }
	
		
//		try {
//			PreparedStatement stmt = con
//                    .prepareStatement("INSERT INTO AJAKK_PASS (AJAKK_USER_ID, ACCESS_PASS)" 
//            + "VALUES (? , ?)");
//            
//            stmt.setInt(1, user.getUserID());
//            stmt.setInt(2, user.get);
//            
//		} catch (SQLException e) {
//            e.printStackTrace();
//		}
		
	}
	
    public void updateUser(UserDTO user) {
    	
    	try {            
		
            PreparedStatement stmt = con
                   .prepareStatement("UPDATE AJAKK_USER SET USERNAME=?, ROLE_ID=?" + "WHERE USER_ID=?");
            stmt.setString(1, user.getName());
            stmt.setInt(2, user.getRoleID());
            	
            stmt.executeUpdate();
            
    		
    	}catch (SQLException e) {
            e.printStackTrace();
        }
    	
    }
    
    public void deleteUser(UserDTO user) {
    	
    	try {            
		
            PreparedStatement stmt = con
                    .prepareStatement("DELETE FROM AJAKK WHERE USER_ID=?");
                        
            stmt.setInt(1, user.getUserID());
            stmt.executeUpdate();
            
    		
    	}catch (SQLException e) {
            e.printStackTrace();
        }
    	
    }
    
    
}
