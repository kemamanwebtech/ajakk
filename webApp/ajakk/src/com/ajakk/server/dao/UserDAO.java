package com.ajakk.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ajakk.shared.dto.UserDTO;

@SuppressWarnings("serial")
public class UserDAO extends UserDTO {
	
	static Connection con  = null;
	Statement  stmt = null;
	static List<UserDTO> userList = new ArrayList<UserDTO>();
	
	public List<UserDTO> getAllUsers(Connection con){
		
		String sql = " SELECT AJAKK_USER_ID, USER_NAME, DES, EMAIL, PHONE_NO, SPORT FROM AJAKK_USER ";
		
		try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            System.out.println(stmt.toString());

            while (rs.next()) {
                
            	UserDTO user =  new UserDTO();
            	
            	user.setUserID(rs.getInt(1));
            	user.setName(rs.getString(2));
            	user.setDes(rs.getString(3));
            	user.setEmail(rs.getString(4));
            	user.setPhoneNumber(rs.getString(5));
            	user.setSport(rs.getString(6));
            	
                userList.add(user);
            }
            
		} catch (SQLException e) {
            e.printStackTrace();
        }
		
		System.out.println("retuning userList..");
        return userList;
		
	}
	
	public void registerUser(UserDTO user, String password, Connection con){ 
		String id = "";
		try {
			String sql = " INSERT INTO AJAKK_USER (USER_NAME, EMAIL, PHONE_NO, STATUS, UPDATED, ROLE_ID) "
						+ " VALUES (		       ? ,        ? ,    ? ,       'Active',      ?,       ?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);            
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPhoneNumber());
            stmt.setDate(4, user.getUpdated());
            stmt.setInt(5, user.getRoleID());
            
            System.out.println(stmt.toString());
            stmt.executeUpdate();  
		} catch (SQLException e) {
            e.printStackTrace();
        }
		
		try {
			String sql = " SELECT LAST_INSERT_ID() as AJAKK_USER_ID";
			PreparedStatement stmt = con.prepareStatement(sql); 
			ResultSet rs = stmt.executeQuery();
			System.out.println(stmt.toString());
			while (rs.next()) {
				id = rs.getString("AJAKK_USER_ID");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		insertPassword(id, password, con);
	}
	
	public void insertPassword(String id, String password, Connection con) {
		try {
			String sql = " INSERT INTO AJAKK_PASS (AJAKK_USER_ID, ACCESS_PASS) "
						+ " VALUES (				  ? ,        	 ? )";
            
            PreparedStatement stmt = con.prepareStatement(sql);            
            stmt.setString(1, id);
            stmt.setString(2, password);
            stmt.execute(); 
            System.out.println(stmt.toString());
		} catch (SQLException e) {
            e.printStackTrace();
        }
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
    
    public String getUserIdByUsername(String username, Connection con) {
    	
    	String result = "";
    	String sql = " SELECT AJAKK_USER_ID FROM AJAKK_USER WHERE USER_NAME = ? ";
		
		try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            
            System.out.println(stmt.toString());

            while (rs.next()) {
            	result = rs.getString("AJAKK_USER_ID");
            }  
		} catch (SQLException e) {
            e.printStackTrace();
        }
		return result;
    }

	public static List<UserDTO> getAllInfo(Connection con2) {
		String sql = " SELECT AJAKK_USER_ID, USER_NAME, DES, EMAIL, PHONE_NO, SPORT FROM AJAKK_USER ";
		
		try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            System.out.println(stmt.toString());

            while (rs.next()) {
                
            	UserDTO user =  new UserDTO();
            	
            	user.setUserID(rs.getInt(1));
            	user.setName(rs.getString(2));
            	user.setDes(rs.getString(3));
            	user.setEmail(rs.getString(4));
            	user.setPhoneNumber(rs.getString(5));
            	user.setSport(rs.getString(6));
            	
                userList.add(user);
            }
            
		} catch (SQLException e) {
            e.printStackTrace();
        }
		
		System.out.println("retuning userList..");
        return userList;
	}
}
