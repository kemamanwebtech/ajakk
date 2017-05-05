package com.ajakk.portal.view;

import org.gwtbootstrap3.client.ui.*;
import com.ajakk.portal.AjakkRPC;
import com.ajakk.portal.AjakkRPCAsync;
import com.ajakk.portal.App;
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
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
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
        dialogVPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
        dialogVPanel.add(closeButton);
        dialogBox.setWidget(dialogVPanel);

        // Add a handler to close the DialogBox
        closeButton.addClickHandler(new ClickHandler() {
            @Override
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
                RootPanel.get().add(App.getDialogBox(caught.getMessage().toString()));
			}

			@Override
			public void onSuccess(String result) {
				if (result.equals("success")) {
					RootPanel.get().add(App.getDialogBox("Successfully registered your ajakk acount!"));
					LoginPage.removeRegPage();
				} else {
					RootPanel.get().add(App.getDialogBox("Failed to create a new user"));
				}
				
			}
    		
    	});
    }
	
	
	
}
