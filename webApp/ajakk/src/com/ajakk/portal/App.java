/**
 * A main factory class for all pages 
 */
package com.ajakk.portal;

import com.ajakk.portal.view.EventDetails;
import com.ajakk.portal.view.HomePage;
import com.ajakk.portal.view.LoginPage;
import com.ajakk.portal.view.RegisterPage;
import com.ajakk.portal.view.EditUserProfile;

/**
 * @author raf
 */
public class App {

    static LoginPage    loginPage    = null;
    static HomePage     homePage     = null;
    static RegisterPage regPage      = null;
    static EditUserProfile  userPage     = null;
    static EventDetails eventDetails = null;

    public App() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        regPage = new RegisterPage();
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

    public static EventDetails createEventDetails() {
        eventDetails = new EventDetails();
        return eventDetails;
    }

    public static RegisterPage getRegPage() {
        regPage = new RegisterPage();
        return regPage;
    }

    public static EditUserProfile getUserProfilePage() {
        userPage = new EditUserProfile();
        return userPage;
    }
}
