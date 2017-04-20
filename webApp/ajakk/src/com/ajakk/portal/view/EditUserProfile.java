package com.ajakk.portal.view;

import org.gwtbootstrap3.client.ui.Heading;
import org.gwtbootstrap3.client.ui.ImageAnchor;
import org.gwtbootstrap3.client.ui.Panel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class EditUserProfile extends Composite {

	@UiField Heading name;
	@UiField Panel panel;
	@UiField ImageAnchor profileImage;

    private static UserProfileUiBinder uiBinder = GWT.create(UserProfileUiBinder.class);

    interface UserProfileUiBinder extends UiBinder<Widget, EditUserProfile> {
    }

    public EditUserProfile() {
        initWidget(uiBinder.createAndBindUi(this));
        
        name.setMarginTop(20);

    }

}
