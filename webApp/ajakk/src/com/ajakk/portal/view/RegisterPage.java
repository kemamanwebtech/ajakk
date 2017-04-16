package com.ajakk.portal.view;

import org.gwtbootstrap3.client.ui.*;

import com.ajakk.portal.AjakkRPC;
import com.ajakk.portal.AjakkRPCAsync;
import com.ajakk.portal.App;
import com.ajakk.portal.util.AjakkConfig;
import com.ajakk.shared.dto.LoginDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class RegisterPage extends Composite {
	
	private final AjakkRPCAsync rpc = GWT.create(AjakkRPC.class);
	private static RegisterPageUiBinder uiBinder = GWT.create(RegisterPageUiBinder.class);
	
	DialogBox     dialogBox           = null;
    Button        closeButton         = null;
    Label         textToServerLabel   = null;
    HTML          serverResponseLabel = null;
    VerticalPanel dialogVPanel        = null;

	public RegisterPage() {
		initWidget(uiBinder.createAndBindUi(this));
		
		// Create the popup dialog box
        dialogBox = new DialogBox();
        dialogBox.hide();
        dialogBox.setText("Login failed.");
        dialogBox.setAnimationEnabled(true);
        closeButton = new Button("Close");
        closeButton.getElement().setId("closeButton");
        textToServerLabel = new Label();
        serverResponseLabel = new HTML();
        VerticalPanel dialogVPanel = new VerticalPanel();
        dialogVPanel.addStyleName("dialogVPanel");
        dialogVPanel.add(serverResponseLabel);
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
        dialogVPanel.add(closeButton);
        dialogBox.setWidget(dialogVPanel);

        // Add a handler to close the DialogBox
        closeButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                dialogBox.hide();
            }
        });
		
	}
	
	@UiTemplate("RegisterPage.ui.xml")
	interface RegisterPageUiBinder extends UiBinder<Widget, RegisterPage> {	
	}
	
	@UiField TextBox userName;
	@UiField TextBox passwd;
	@UiField TextBox email;
	@UiField TextBox phoneNumber;
	@UiField Button bSignUp;
	@UiField Button bSgGP;
	@UiField Button bSgFB;
	
    @UiHandler("bSignUp")
    void onSignUpClicked(ClickEvent e) {
        
    	rpc.doSignup(
    			userName.getText(), 
    			passwd.getText(), 
    			email.getText(), 
    			phoneNumber.getText(), 
    		new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO : Raf - add dialog box for error
				dialogBox.setText("Creating a new user...");
                serverResponseLabel.setHTML(caught.getMessage().toString());
                dialogBox.center();
                closeButton.setFocus(true);			
			}

			@Override
			public void onSuccess(String result) {
				
				if (result.equals("success")) {
					// TODO Auto-generated method stub
					RootPanel.get().add(App.getDialogBox("Successfully created new user"));
				} else {
					// TODO Auto-generated method stub
					dialogBox.center();
	                closeButton.setFocus(true);
	                dialogBox.setText(result);
	                serverResponseLabel.setHTML("Failed to create new user");
				}
				
			}
    		
    	});
    }
	
	
	
}
