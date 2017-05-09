package com.ajakk.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialModal;

public class CreateEvent extends Composite {
    private static CreateEventUiBinder uiBinder = GWT.create(CreateEventUiBinder.class);

    interface CreateEventUiBinder extends UiBinder<Widget, CreateEvent> {}
    
    @UiField MaterialModal modal;
    
    public CreateEvent() {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    public void show() {
        modal.open();
    }
}
