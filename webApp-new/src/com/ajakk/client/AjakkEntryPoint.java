package com.ajakk.client;

import com.ajakk.client.view.HomePage;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class AjakkEntryPoint implements EntryPoint {
    
    @Override
    public void onModuleLoad() {
        HomePage loginPage = new HomePage();
        RootPanel.get().add(loginPage);
    }
}
