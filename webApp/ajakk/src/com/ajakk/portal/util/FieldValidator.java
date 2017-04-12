package com.ajakk.portal.util;

/**
 * Validate user input against common pattern and requirement
 */
public class FieldValidator {

	/**
	 * Validate user username
	 * return true if valid, false if invalid
	 */
	public static boolean isValidUserName(String userName) {
		if (userName == null) {
			return false;
		}
		return userName.length() > 0;
	}
	
	/**
	 * Validate user password
	 * return true if valid, false if invalid
	 */
	public static boolean isValidPasswd(String passwd) {
		if (passwd == null) {
			return false;
		}
		return passwd.length() > 0;
	}
}
