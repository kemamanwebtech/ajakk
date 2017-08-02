package com.ajakk.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialTextBox;

public class EditUserProfile extends Composite {
	
    @UiField MaterialModal modal;
    @UiField MaterialButton	saveBtn;
    @UiField MaterialTextBox	name;
    @UiField MaterialTextBox	location;
    @UiField MaterialTextBox    email;
    @UiField MaterialTextBox    phoneNo;
    @UiField MaterialTextBox	activities;
    @UiField MaterialTextArea    aboutMe;



	private static EditUserProfileUiBinder uiBinder = GWT.create(EditUserProfileUiBinder.class);

	interface EditUserProfileUiBinder extends UiBinder<Widget, EditUserProfile> {
	}

	public EditUserProfile() {
		initWidget(uiBinder.createAndBindUi(this));
		modal.setDismissible(true);
//		name.setSize("50px", "25px");
//		location.setSize("50px", "25px");
//		email.setSize("50px", "25px");
//		phoneNo.setSize("50px", "25px");
//		activities.setSize("50px", "25px");
//		aboutMe.setSize("50px", "25px");
	}

	public void show() {
//		modal.setWidth("400px");
//		modal.setHeight("500px");
		modal.setDismissible(true);
        modal.open();
    }


}
