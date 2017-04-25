package com.ajakk.portal.view;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Image;

import org.gwtbootstrap3.extras.card.client.ui.Card;

import com.ajakk.shared.dto.EventDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class EventCard extends Composite {
	
	public EventDTO event;

    private static EventCardUiBinder uiBinder = GWT.create(EventCardUiBinder.class);

    interface EventCardUiBinder extends UiBinder<Widget, EventCard> {
    }

    public EventCard() {
        initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField Button btnEventInfoFront;
	@UiField Label lblEventFront;
	@UiField Image imgEventFront;
	@UiField Card card;

	public EventCard(EventDTO event) {
        initWidget(uiBinder.createAndBindUi(this));
        setEvent(event);
        
        // set image source
        imgEventFront.setUrl("http://www.iconshock.com/img_jpg/REALVISTA/sports/jpg/256/soccer_icon.jpg");
        imgEventFront.setPixelSize(150, 100);
        
        card.removeStyleName("fa");
        card.removeStyleName("fa-exchange");
        card.removeStyleName("trigger");
    }

    @UiHandler("btnEventInfoFront")
    void onClick(ClickEvent e) {
        HomePage.popOutEventDetails(event);
    }
    
    public void setEvent(EventDTO event) {
    	this.event = event;
    }
    
    public EventDTO getEvent() {
    	return this.event;
    }
}
