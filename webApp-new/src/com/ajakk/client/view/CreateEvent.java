package com.ajakk.client.view;


import com.ajakk.client.App;
import com.ajakk.client.Rpc;
import com.ajakk.client.RpcAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.addins.client.timepicker.MaterialTimePicker;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialTextArea;

public class CreateEvent extends Composite {
    private static CreateEventUiBinder uiBinder = GWT.create(CreateEventUiBinder.class);

    interface CreateEventUiBinder extends UiBinder<Widget, CreateEvent> {}
    
    @UiField MaterialModal modal;
    @UiField MaterialTextArea postedBy;
    @UiField MaterialImage imageDesc;
    @UiField MaterialTextArea description;
    @UiField MaterialImage imageTime;
    @UiField MaterialTextArea time;
//    @UiField MaterialTimePicker time;
    @UiField MaterialImage imageLoc;
    @UiField MaterialTextArea location;
    @UiField MaterialImage imageExtra;
    @UiField MaterialTextArea extra;
    @UiField MaterialImage imageWhatsapp;
    @UiField MaterialTextArea whatsapp;
    @UiField MaterialButton btnCancel;
    @UiField MaterialButton btnSave;
    
    private final RpcAsync	rpc	= GWT.create(Rpc.class);

    
    @UiHandler("btnSave")
    void onCreateEventClick(ClickEvent e){
    	
    	rpc.createEvent(
    			description.getText(),
    			time.getText(),
    			location.getText(),
    			extra.getText(),
    			App.username,
    			new AsyncCallback<String>(){
    				@Override
    				public void onFailure(Throwable caught) {
    				}

    				@Override
    				public void onSuccess(String result) {
    					if (result.equals("success")) {
    					}		
    				}
    			}	
    			
    			
    			
    			
    			);
    }
    
    
    
    public CreateEvent() {
        initWidget(uiBinder.createAndBindUi(this));
        modal.setDismissible(true);

    }
    
    public void show() {
        modal.open();
    }
}
