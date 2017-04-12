package com.ajakk.portal.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class EditUserProfile extends Composite {

    @UiField
    Button buttonTest;

    private static UserProfileUiBinder uiBinder = GWT.create(UserProfileUiBinder.class);

    interface UserProfileUiBinder extends UiBinder<Widget, EditUserProfile> {
    }

    public EditUserProfile() {
        initWidget(uiBinder.createAndBindUi(this));

        // buttonTest.setStyleName("btn-danger");
        buttonTest.setText("Testing Button");
        buttonTest.getElement().addClassName("btn-danger");
    }

}
