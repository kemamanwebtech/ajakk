package com.ajakk.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialTitle;

public class Message extends Composite {

    private static MessageUiBinder uiBinder = GWT.create(MessageUiBinder.class);

    interface MessageUiBinder extends UiBinder<Widget, Message> {
    }
    
    @UiField MaterialButton btnClose;
    @UiField MaterialTitle message;
    @UiField MaterialModal modal;
    
    static Message instance;

    public Message(String msg) {
        initWidget(uiBinder.createAndBindUi(this));
        instance = this;
        
        message.setDescription(msg);

        btnClose.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                RootPanel.get().remove(Message.get());
                
            }
            
        });
    }
    
    public static Message get() {
        return instance;
    }
    
    public void show() {
        modal.open();
    }
    
    

}
