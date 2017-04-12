package com.ajakk.portal.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class UserProfile extends Composite {
	
	@UiField
	Button cBtn;
	
	private static UserProfileUiBinder uiBinder = GWT.create(UserProfileUiBinder.class);

	interface UserProfileUiBinder extends UiBinder<Widget, UserProfile> {
	}

	public UserProfile() {
		initWidget(uiBinder.createAndBindUi(this));
		
		
		
		
		//buttonTest.setStyleName("btn-danger");
//		buttonTest.getElement().addClassName("btn-danger");
	}

}
