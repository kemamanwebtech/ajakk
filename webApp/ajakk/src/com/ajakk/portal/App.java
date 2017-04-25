/**
 * A main factory class for all pages 
 */
package com.ajakk.portal;

import com.ajakk.portal.view.EventDetails;
import com.ajakk.portal.view.HomePage;
import com.ajakk.portal.view.LoginPage;
import com.ajakk.portal.view.RegisterPage;
import com.ajakk.portal.view.UserProfile;
import com.ajakk.portal.view.DialogBox;
import com.ajakk.portal.view.EditUserProfile;
import com.ajakk.portal.view.createEvent;
import com.ajakk.shared.dto.EventDTO;

/**
 * @author raf
 */
public class App {

    static LoginPage    loginPage    = null;
    static HomePage     homePage     = null;
    static RegisterPage regPage      = null;
    static UserProfile  userPage     = null;
    static EditUserProfile editUserPage = null;
    static EventDetails eventDetails = null;
    static createEvent createEventPage = null;
    static DialogBox dialogBox = null;
	public static String username;
	public static int userID;

    public App() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        regPage = new RegisterPage();
        createEventPage = new createEvent();
    }

    public static LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
            return loginPage;
        } else {
            return loginPage;
        }
    }

    public static HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
            return homePage;
        } else {
            return homePage;
        }
    }

    public static EventDetails createEventDetails(EventDTO selectedEvent) {
        eventDetails = new EventDetails(selectedEvent);
        return eventDetails;
    }

    public static RegisterPage getRegPage() {
        regPage = new RegisterPage();
        return regPage;
    }

    public static UserProfile getUserProfilePage() {
        userPage = new UserProfile();
        return userPage;
    }
    
    public static EditUserProfile getEditUserProfilePage() {
    	editUserPage = new EditUserProfile();
    	return editUserPage;
    }
    
    public static createEvent getCreateEventPage() {
		createEventPage = new createEvent();
		return createEventPage;	
    }
    
    public static DialogBox getDialogBox(String message) {
    	dialogBox = new DialogBox(message);
    	return dialogBox;
    }
}
