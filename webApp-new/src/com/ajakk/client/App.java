package com.ajakk.client;

import java.util.List;

import com.ajakk.client.view.Message;
import com.ajakk.shared.EventDTO;
import com.ajakk.shared.UserDTO;
import com.google.gwt.user.client.ui.RootPanel;

public class App {
    
    Config config = null;
    static App app;
    
    // user data
    UserDTO user;
    String currentLoc;
    boolean isAdminUser;
    
    
    Message dialogBox;
    
    public static void showMessage(String message) {
        Message newDialogBox = new Message(message);
        RootPanel.get().add(newDialogBox);
        newDialogBox.show();
        
    }
    public Config getConfig() {
        return config;
    }

    public UserDTO getUser() {
        if (user == null) {
            user = new UserDTO();
        }
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getCurrentLoc() {
        return currentLoc;
    }

    public void setCurrentLoc(String currentLoc) {
        this.currentLoc = currentLoc;
    }

    public boolean isAdminUser() {
        return isAdminUser;
    }

    public void setAdminUser(boolean isAdminUser) {
        this.isAdminUser = isAdminUser;
    }

    public List<EventDTO> getJoinedEvent() {
        return joinedEvent;
    }

    public void setJoinedEvent(List<EventDTO> joinedEvent) {
        this.joinedEvent = joinedEvent;
    }

    List<EventDTO> joinedEvent;
    
    
    public App() {
        app = this;
        
        config = new Config();
        
    }
    
    public static App getApp() {
        return app;
    }

}
