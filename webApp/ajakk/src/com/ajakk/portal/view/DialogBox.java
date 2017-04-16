package com.ajakk.portal.view;

import org.gwtbootstrap3.client.ui.Button;

import org.gwtbootstrap3.client.ui.Modal;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class DialogBox extends Composite {
	
	@UiField Label lblMessage;
	//@UiField Button btnClose;
	@UiField Modal modal;

	private static DialogBoxUiBinder uiBinder = GWT
			.create(DialogBoxUiBinder.class);

	interface DialogBoxUiBinder extends UiBinder<Widget, DialogBox> {
	}

	public DialogBox(String message) {
		initWidget(uiBinder.createAndBindUi(this));
		lblMessage.setText(message);  
		modal.setSize("300px", "400px");
		modal.show();
	    
	}
	
//	@UiHandler("btnClose")
//	public void onCloseBtnClicked(ClickEvent event) {
//		this.removeFromParent();
//	}
}
