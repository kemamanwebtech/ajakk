package com.ajakk.portal.view;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Image;
import org.gwtbootstrap3.client.ui.Label;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class EventCard extends Composite {

    private static EventCardUiBinder uiBinder = GWT.create(EventCardUiBinder.class);

    interface EventCardUiBinder extends UiBinder<Widget, EventCard> {
    }

    public EventCard() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiField
    Button btnEventInfoFront;
    @UiField
    Label  lblEventFront;
    @UiField
    Image  imgEventFront;

    public EventCard(String firstName) {
        initWidget(uiBinder.createAndBindUi(this));
        btnEventInfoFront.setText(firstName);
        btnEventInfoFront.getElement().setClassName("btn btn-success btn-sm");

        // set image source
        imgEventFront.setUrl("http://www.iconshock.com/img_jpg/REALVISTA/sports/jpg/256/soccer_icon.jpg");
        imgEventFront.setPixelSize(150, 100);

    }

    @UiHandler("btnEventInfoFront")
    void onClick(ClickEvent e) {
        HomePage.popOutEventDetails();
    }
}
