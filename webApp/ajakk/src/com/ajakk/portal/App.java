/**
 * A main factory class for all pages 
 */
package com.ajakk.portal;

import com.ajakk.portal.view.LoginPage;
import com.ajakk.portal.view.RegisterPage;
import com.ajakk.portal.view.HomePage;

/**
 * @author raf
 *
 */
public class App {

    static LoginPage loginPage = null;
    static HomePage  homePage  = null;
    static RegisterPage regPage = null;

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
        homePage = new HomePage();
        return homePage;
    }
    
    public static RegisterPage getRegPage(){
    	regPage = new RegisterPage();
    	return regPage;
    }
}
