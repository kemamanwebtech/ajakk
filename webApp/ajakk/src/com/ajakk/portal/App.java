/**
 * A main factory class for all pages 
 */
package com.ajakk.portal;

import com.ajakk.portal.view.LoginPage;
import com.ajakk.portal.view.HomePage;

/**
 * @author raf
 *
 */
public class App {

    static LoginPage loginPage = null;
    static HomePage  homePage  = null;

    public App() {
        loginPage = new LoginPage();
        homePage = new HomePage();
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

}
