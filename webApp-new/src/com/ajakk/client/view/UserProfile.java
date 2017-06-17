package com.ajakk.client.view;

import com.ajakk.client.App;
import com.ajakk.client.Rpc;
import com.ajakk.client.RpcAsync;
import com.ajakk.shared.UserDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialModal;

public class UserProfile extends Composite {
	
	public UserDTO 	user;
    @UiField MaterialModal	modal;
    @UiField MaterialButton	editBtn;
    @UiField MaterialLabel	userName;
    @UiField MaterialLabel	dateJoined;
    @UiField MaterialLabel	userLocation;
    @UiField MaterialLabel	userActivity;
    @UiField MaterialLabel	userDescription;
    @UiField MaterialLabel	userPhone;
    @UiField MaterialLabel	userEmail;


	private static UserProfileUiBinder uiBinder = GWT.create(UserProfileUiBinder.class);
    private final RpcAsync   rpc = GWT.create(Rpc.class);

	interface UserProfileUiBinder extends UiBinder<Widget, UserProfile> {
	}

	public UserProfile() {
		initWidget(uiBinder.createAndBindUi(this));
		modal.setDismissible(true);
		
	}
	
	public UserProfile(UserDTO user) {
		modal.setDismissible(true);
        this.user = user;
      
        
        userName.setText(user.getName());
        userDescription.setText(user.getDes());
        userActivity.setText(user.getSport());
        userLocation.setText(user.getLocation());
        userPhone.setText(user.getPhoneNumber());
        userEmail.setText(user.getEmail());
		
	}
	
	@UiHandler("editBtn")
    void onEditProfileClicked(ClickEvent e) {
        // call here
        EditUserProfile EditUserProfile = new EditUserProfile();
        RootPanel.get().add(EditUserProfile);
        EditUserProfile.show();
    }

	
	public void show() {
//		modal.setWidth("400px");
//		modal.setHeight("280px");
        modal.open();
    }

}
