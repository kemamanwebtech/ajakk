/*
* UI class to perform edit on User Profile
* @author  Raf
*/

// TODO : implement update profile image

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
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialTextBox;

public class EditUserProfile extends Composite {
    @UiField MaterialModal   modal;
    @UiField MaterialButton  saveBtn;
    @UiField MaterialButton  cancelBtn;
    @UiField MaterialTextBox name;
    @UiField MaterialTextBox location;
    @UiField MaterialTextBox email;
    @UiField MaterialTextBox phoneNo;
    @UiField MaterialTextBox activities;
    @UiField MaterialTextBox aboutMe;
    @UiField MaterialImage   userProfilePic;

    private static EditUserProfileUiBinder uiBinder = GWT.create(EditUserProfileUiBinder.class);

    interface EditUserProfileUiBinder extends UiBinder<Widget, EditUserProfile> {
    }

    private final RpcAsync rpc = GWT.create(Rpc.class);

    public EditUserProfile() {
        initWidget(uiBinder.createAndBindUi(this));
        modal.setDismissible(true);
        modal.setPixelSize(500, 660);
        modal.getWidget(0).setHeight("100%");

        // TODO : remove test data here
        name.setValue("name");
        location.setValue("Cyberjaya");
        email.setValue("mrafsyam@gmail.com");
        phoneNo.setValue("0182308888");
        activities.setValue("Makan, makan, makan");
        aboutMe.setValue("Suka makan. Very suka makan");
    }

    public void show() {
        name.setValue(App.loggedInUser.getName());
        location.setValue(App.loggedInUser.getLocation());
        email.setValue(App.loggedInUser.getEmail());
        phoneNo.setValue(App.loggedInUser.getPhoneNumber());
        activities.setValue(App.loggedInUser.getSport());
        aboutMe.setValue(App.loggedInUser.getDes());

        modal.open();
    }

    @UiHandler("saveBtn")
    public void onBtnSave(ClickEvent e) {
        UserDTO user = App.loggedInUser;
        user.setName(name.getValue());
        user.setLocation(location.getValue());
        user.setEmail(email.getValue());
        user.setPhoneNumber(phoneNo.getValue());
        user.setSport(activities.getValue());
        user.setDes(aboutMe.getValue());

        rpc.saveUserProfile(user, new AsyncCallback<Integer>() {
            @Override
            public void onFailure(Throwable caught) {
                App.showMessage("Error", caught.getMessage(), "", 500, 500);
            }

            @Override
            public void onSuccess(Integer result) {
                if (result == 1) {
                    showProfile();
                }
            }
        });
    }

    @UiHandler("cancelBtn")
    public void onBtnCancel(ClickEvent e) {
        showProfile();
    }

    public void showProfile() {
        UserProfile userProfile = new UserProfile();
        RootPanel.get().add(userProfile);
        userProfile.show(App.loggedInUser);
        modal.close();
    }
}
