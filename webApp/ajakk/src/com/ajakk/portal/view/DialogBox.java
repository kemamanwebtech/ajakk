package com.ajakk.portal.view;

import org.gwtbootstrap3.client.ui.Modal;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class DialogBox extends Composite {
	
	@UiField Label lblMessage;
	@UiField Modal modal;

	private static DialogBoxUiBinder uiBinder = GWT.create(DialogBoxUiBinder.class);

	interface DialogBoxUiBinder extends UiBinder<Widget, DialogBox> {
	}

	public DialogBox(String message) {
		initWidget(uiBinder.createAndBindUi(this));
		lblMessage.setText(message);  
		modal.setSize("300px", "400px");
		modal.setMarginBottom(200);
		modal.setMarginTop(200);
		modal.show();
	    
	}
}
