package com.ajakk.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialModal;

public class Login extends Composite {

    private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);

    interface LoginUiBinder extends UiBinder<Widget, Login> {
    }
    
    @UiField MaterialModal modal;
    @UiField MaterialButton btnLogin;
    @UiField MaterialButton btnLoginGmail;
    @UiField MaterialButton btnLoginFb;

    public Login() {
        initWidget(uiBinder.createAndBindUi(this));
        modal.setDismissible(true);
        modal.setPixelSize(500, 400);
        modal.getWidget(0).setHeight("100%");
        
        btnLogin.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Dashboard dashboard = new Dashboard();
                RootPanel.get().clear();
                RootPanel.get().add(dashboard);
                
            }
            
        });
    }
    
    public void show() {
        modal.open();
    }
}
