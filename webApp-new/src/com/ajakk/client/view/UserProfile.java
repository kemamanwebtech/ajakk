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

import gwt.material.design.client.ui.MaterialModal;

public class UserProfile extends Composite {
	
    @UiField MaterialModal modal;


	private static UserProfileUiBinder uiBinder = GWT.create(UserProfileUiBinder.class);

	interface UserProfileUiBinder extends UiBinder<Widget, UserProfile> {
	}

	public UserProfile() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public void show() {
		modal.setWidth("400px");
		modal.setDismissible(true);
        modal.open();
    }

}
