package com.ajakk.portal;

import com.ajakk.portal.util.AjakkConfig;
import com.ajakk.shared.FieldVerifier;
import com.ajakk.shared.dto.LoginDTO;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class AjakkEntryPoint implements EntryPoint {
	
	private final AjakkRPCAsync ajakkService = GWT.create(AjakkRPC.class);

	/**
	 * the entry point method.
	 */
	public void onModuleLoad() {
		final Button sendButton = new Button("Send");
		final TextBox userNameField = new TextBox();
		userNameField.setText("GWT User");
		final TextBox passwordField = new TextBox();
		final Label errorLabel = new Label();

		// add style names to button
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		RootPanel.get("nameFieldContainer").add(userNameField);
		RootPanel.get("nameFieldContainer").add(passwordField);
		RootPanel.get("sendButtonContainer").add(sendButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);

		// Focus the cursor on the name field when the app loads
		userNameField.setFocus(true);
		userNameField.selectAll();

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				sendLoginToServer();
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendLoginToServer();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void sendLoginToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				String userNameToServer = userNameField.getText();
				if (!FieldVerifier.isValidUserName(userNameToServer)) {
					errorLabel.setText("Username is required.");
					return;
				}
				String passwdToServer = passwordField.getText();
				if (!FieldVerifier.isValidPasswd(passwdToServer)) {
					errorLabel.setText("Password is required.");
					return;
				}
				

				// Then, we send the input to the server.
				sendButton.setEnabled(false);
				textToServerLabel.setText(userNameToServer);
				serverResponseLabel.setText("");
				
				ajakkService.doLogin(userNameToServer, passwdToServer, new AsyncCallback<LoginDTO>() {
					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user
						dialogBox.setText("Remote Procedure Call - Failure");
						serverResponseLabel.addStyleName("serverResponseLabelError");
						serverResponseLabel.setHTML(AjakkConfig.SERVER_ERROR);
						dialogBox.center();
						closeButton.setFocus(true);
					}

					public void onSuccess(LoginDTO result) {
						
						if (result.getUserID() == 0) {
							dialogBox.setText(result.getUserStatus());
							serverResponseLabel.setHTML(result.getUserStatus());
							dialogBox.center();
							closeButton.setFocus(true);
						} else {
							dialogBox.setText("Your account is " + result.getUserStatus());
							serverResponseLabel.removeStyleName("serverResponseLabelError");
							serverResponseLabel.setHTML("USER ID : " + result.getUserID());
							dialogBox.center();
							closeButton.setFocus(true);
						}
					}
				});
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		userNameField.addKeyUpHandler(handler);
	}
}
