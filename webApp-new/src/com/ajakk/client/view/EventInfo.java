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

public class EventInfo extends Composite {
	
    @UiField MaterialModal modal;


	private static EventInfoUiBinder uiBinder = GWT.create(EventInfoUiBinder.class);

	interface EventInfoUiBinder extends UiBinder<Widget, EventInfo> {
	}

	public EventInfo() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	
	public void show() {
        modal.open();
    }


}
