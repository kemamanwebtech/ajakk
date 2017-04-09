package com.ajakk.portal.view;

import org.gwtbootstrap3.client.ui.*;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class RegisterPage extends Composite {
	

	private static RegisterPageUiBinder uiBinder = GWT.create(RegisterPageUiBinder.class);

	public RegisterPage() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiTemplate("RegisterPage.ui.xml")
	interface RegisterPageUiBinder extends UiBinder<Widget, RegisterPage> {	
	}
	
	@UiField
	TextBox userName;
	@UiField
	TextBox passwd;
	@UiField
	TextBox email;
	@UiField
	TextBox phoneNumber;
	
	@UiField
	Button bSignUp;
	@UiField
	Button bSgGP;
	@UiField
	Button bSgFB;
	
}
