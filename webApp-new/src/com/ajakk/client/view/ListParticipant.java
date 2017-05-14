package com.ajakk.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialTitle;

public class ListParticipant extends Composite {
    private static ListParticipantUiBinder uiBinder = GWT.create(ListParticipantUiBinder.class);

    interface ListParticipantUiBinder extends UiBinder<Widget, ListParticipant> {}

    
    @UiField MaterialTitle message;
    @UiField MaterialModal modal;
    
    
    public ListParticipant(String msg) {
        initWidget(uiBinder.createAndBindUi(this));
        message.setDescription(msg);
        modal.setBackgroundColor(Color.TRANSPARENT);
        modal.setDismissible(true);
    }
    
    public void show() {
        modal.open();
    }
}