package com.ajakk.portal.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class HomePage extends Composite {

	private static PickPageUiBinder uiBinder = GWT.create(PickPageUiBinder.class);

	interface PickPageUiBinder extends UiBinder<Widget, HomePage> {
	}

	public HomePage() {
		initWidget(uiBinder.createAndBindUi(this));
		ajakkButton.setText("Ajakk");
		joinButton.setText("Join");
	}

	@UiField Button ajakkButton;
	@UiField Button joinButton;

	public HomePage(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("ajakkButton")
	void onClickAjakkButton(ClickEvent e) {
		Window.alert("Ajakk!");
	}
	
	@UiHandler("joinButton")
	void onClickJoinButton(ClickEvent e) {
		Window.alert("Join!");
		// TODO : Joine event page
	}
}
