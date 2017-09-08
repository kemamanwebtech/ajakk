package com.ajakk.client.view;
import java.util.Date;

import com.ajakk.client.Rpc;
import com.ajakk.client.RpcAsync;
import com.ajakk.shared.UserDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialModal;

public class UserProfile extends Composite {
    public UserDTO                     user;
    @UiField MaterialModal             modal;
    @UiField MaterialButton            editBtn;
    @UiField MaterialLabel             userName;
    @UiField MaterialLabel             dateJoined;
    @UiField MaterialLabel             userLocation;
    @UiField MaterialLabel             userActivity;
    @UiField MaterialLabel             userDescription;
    @UiField MaterialLabel             userPhone;
    @UiField MaterialLabel             userEmail;
    @UiField MaterialImage             userProfilePic;
    
    private static UserProfileUiBinder uiBinder = GWT.create(UserProfileUiBinder.class);
    private final RpcAsync             rpc      = GWT.create(Rpc.class);
    UserProfile instance = null;

    interface UserProfileUiBinder extends UiBinder<Widget, UserProfile> {}

    public UserProfile() {
        initWidget(uiBinder.createAndBindUi(this));
        modal.setDismissible(true);
        instance = this;
    }

    public void setUser(UserDTO user) {
        modal.setDismissible(true);
        this.user = user;
        userName.setText(user.getName());
        
        if (user.getDes().equals("") || user.getDes() == null) {
            userDescription.setText("Say something funny here");
        } else {
            userDescription.setText(user.getDes());
        }
        
        if (user.getSport().equals("") || user.getSport() == null) {
            userActivity.setText("List your favourite activities here");
        } else {
            userActivity.setText(user.getSport());
        }
        
        
        
        userLocation.setText(user.getLocation());
        userPhone.setText(user.getPhoneNumber());
        userEmail.setText(user.getEmail());
        
        // get date the user joined
        DateTimeFormat format = DateTimeFormat.getFormat("MMM yyyy");
        dateJoined.setText("Joined since " + format.format(user.getCreated()));
        
        
        
//        userProfilePic.setPadding(30);
//        userProfilePic.setMargin(50);
//        userProfilePic.setBackgroundColor(Color.BLUE);
    }

    @UiHandler("editBtn")
    void onEditProfileClicked(ClickEvent e) {
        // call here
        EditUserProfile EditUserProfile = new EditUserProfile();
        RootPanel.get().add(EditUserProfile);
        instance.modal.close();
        EditUserProfile.show();
    }

    public void show(UserDTO user) {
        setUser(user);
        modal.setWidth("505px");
        modal.setHeight("450px");
        modal.open();
    }
}
