/**
 * 
 */
package com.ajakk.portal.view;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.ListBox;
import org.gwtbootstrap3.client.ui.TextArea;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.extras.notify.client.ui.Notify;

import com.ajakk.portal.AjakkRPC;
import com.ajakk.portal.AjakkRPCAsync;
import com.ajakk.portal.App;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author raf
 *
 */
public class createEvent extends Composite {
	
	@UiField TextBox	txtEventName;
	@UiField TextArea	txtEventDesc;
	@UiField ListBox	listEventType;
	@UiField TextBox	txtEventLocation;
	@UiField Button 	btnCreateEvent;
	
    private static createEventUiBinder uiBinder		= GWT.create(createEventUiBinder.class);
    private final AjakkRPCAsync     	rpc			= GWT.create(AjakkRPC.class);
    

    interface createEventUiBinder extends UiBinder<Widget, createEvent> {
    }
    
    public createEvent() {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    @UiHandler("btnCreateEvent")
	 void onCreateEventClick(ClickEvent e){
    	
    	rpc.createEvent(
    			txtEventName.getText(),
    			txtEventDesc.getText(),
    			listEventType.getSelectedItemText(),
    			txtEventLocation.getText(),
    			App.username,
    			new AsyncCallback<String>() {
			@Override
			public void onFailure(Throwable caught) {
				RootPanel.get().add(App.getDialogBox(caught.toString()));
			}

			@Override
			public void onSuccess(String result) {
				if (result.equals("success")) {
					Notify.notify("Successfully create events!");
				}		
			}
		});
    	
	 }
    
    
    
    

}
