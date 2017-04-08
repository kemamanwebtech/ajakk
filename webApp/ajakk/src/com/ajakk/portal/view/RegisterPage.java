package com.ajakk.portal.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class RegisterPage extends Composite {

	private static RegisterPageUiBinder uiBinder = GWT.create(RegisterPageUiBinder.class);

	interface RegisterPageUiBinder extends UiBinder<Widget, RegisterPage> {
	}

	public RegisterPage() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
