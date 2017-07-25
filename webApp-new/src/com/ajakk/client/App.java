/**
 *  Class that hold most static objects, including current user data
 */

package com.ajakk.client;

import java.util.List;
import com.ajakk.client.view.Message;
import com.ajakk.shared.EventDTO;
import com.ajakk.shared.UserDTO;
import com.google.gwt.user.client.ui.RootPanel;

public class App {
    // static variables
    public static Config config = null;
    public static App instance = null;

    // user data
    public static UserDTO loggedInUser = null;
    public static String currentLoc = null;
    public static boolean isAdminUser = false;
    public static List<EventDTO> joinedEvent = null;

    // others
    Message dialogBox;

    public static void showMessage(String topMsg, String btmMsg, String imageUrl) {
        Message newDialogBox = new Message(topMsg, btmMsg, imageUrl);
        RootPanel.get().add(newDialogBox);
        newDialogBox.show();
    }

    // probably not needed later. leave it here as it is for now
    public App() {
        instance = this;
        config = new Config();
    }

    public static App getApp() {
        return instance;
    }
}
