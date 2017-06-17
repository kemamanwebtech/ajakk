package com.ajakk.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialTextBox;

public class EditUserProfile extends Composite {
	
    @UiField MaterialModal modal;
    @UiField MaterialButton	editBtn;
    @UiField MaterialLabel	userName;
    @UiField MaterialLabel	dateJoined;
    @UiField MaterialTextBox	userLocation;
    @UiField MaterialTextBox	userActivity;


	private static EditUserProfileUiBinder uiBinder = GWT.create(EditUserProfileUiBinder.class);

	interface EditUserProfileUiBinder extends UiBinder<Widget, EditUserProfile> {
	}

	public EditUserProfile() {
		initWidget(uiBinder.createAndBindUi(this));
		modal.setDismissible(true);
	}

	public void show() {
		modal.setWidth("400px");
		modal.setHeight("260px");
		modal.setDismissible(true);
        modal.open();
    }


}
