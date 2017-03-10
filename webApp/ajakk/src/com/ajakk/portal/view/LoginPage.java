package com.ajakk.portal.view;

import com.ajakk.portal.AjakkRPC;
import com.ajakk.portal.AjakkRPCAsync;
import com.ajakk.portal.App;
import com.ajakk.portal.util.AjakkConfig;
import com.ajakk.shared.FieldValidator;
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
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.TextBox;

public class LoginPage extends Composite {
	
	private final AjakkRPCAsync rpc = GWT.create(AjakkRPC.class);

	private static LoginPageUiBinder uiBinder = GWT.create(LoginPageUiBinder.class);
	
	@UiTemplate("LoginPage.ui.xml")
	interface LoginPageUiBinder extends UiBinder<Widget, LoginPage> {
	}
	
	@UiField TextBox userName;
	@UiField TextBox passwd;
	@UiField Button loginButton;
	@UiField Button regButton;
	@UiField Label errorLabel;
	
	@UiField Button ajakkButton;
	@UiField Button joinButton;
	
	DialogBox dialogBox = null;
	Button closeButton = null;
	Label textToServerLabel = null;
	HTML serverResponseLabel = null;
	VerticalPanel dialogVPanel = null;

	public LoginPage() {
		initWidget(uiBinder.createAndBindUi(this));
		
		setStyleName("body");
		
		// set focus to username textbox upon load
		userName.setFocus(true);
		userName.selectAll();
		userName.setText("active");
		passwd.setText("password");
		
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
				loginButton.setEnabled(true);
				loginButton.setFocus(true);
			}
		});
	}


	@UiHandler("loginButton")
	void onClick(ClickEvent e) {
		if (!FieldValidator.isValidUserName(userName.getText())) {
			errorLabel.setText("Username is required.");
			return;
		}
	
		if (!FieldValidator.isValidPasswd(passwd.getText())) {
			errorLabel.setText("Password is required.");
			return;
		}	
		
		rpc.doLogin(userName.getText(), passwd.getText(), new AsyncCallback<LoginDTO>() {
			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user
				dialogBox.setText("Authenticating user...");
				serverResponseLabel.setHTML(AjakkConfig.SERVER_ERROR);
				dialogBox.center();
				closeButton.setFocus(true);
			}

			public void onSuccess(LoginDTO result) {
				
				
				switch (result.getUserStatus()){
					
					case "NotActive":
						dialogBox.center();
						closeButton.setFocus(true);
						dialogBox.setText(result.getUserStatus());
						serverResponseLabel.setHTML(AjakkConfig.ACC_NOTACTIVE);
						break;
					
					case "Blocked":
						dialogBox.center();
						closeButton.setFocus(true);
						dialogBox.setText("Your account has been " + result.getUserStatus());
						serverResponseLabel.setHTML(AjakkConfig.ACC_BLOCKED);	
						break;
						
					case "Locked":
						dialogBox.center();
						closeButton.setFocus(true);
						dialogBox.setText("Your account is currently " + result.getUserStatus());
						serverResponseLabel.setHTML(AjakkConfig.ACC_LOCKED);	
						break;
						
					case "Deleted":
						dialogBox.center();
						closeButton.setFocus(true);
						dialogBox.setText("Your account has been " + result.getUserStatus());
						serverResponseLabel.setHTML(AjakkConfig.ACC_DELETED);	
						break;
						
					case "Invalid":
						dialogBox.center();
						closeButton.setFocus(true);
						dialogBox.setText(result.getUserStatus());
						serverResponseLabel.setHTML(AjakkConfig.AUTH_ERROR);
						break;
						
					case "Active":
						dialogBox.hide();
						RootPanel.get().clear();
						RootPanel.get().setStyleName("fullWidth");
						RootPanel.get().add(App.getHomePage());
						break;					
				}			
			}
		});
		
	}
}
