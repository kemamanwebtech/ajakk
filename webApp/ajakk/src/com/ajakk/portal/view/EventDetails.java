/**
 * 
 */
package com.ajakk.portal.view;

import com.ajakk.shared.dto.EventDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author raf
 */
public class EventDetails extends Composite {
	
	@UiField Label lblEventName;
	@UiField Label lblEventDesc;
	@UiField Label lblEventType;
	@UiField Label lblEventLoc;
	@UiField Label lblEventOrganizer;
	@UiField Label lblEventDateTime;
	
	public EventDTO event;

    private static EventDetailsUiBinder uiBinder = GWT.create(EventDetailsUiBinder.class);

    interface EventDetailsUiBinder extends UiBinder<Widget, EventDetails> {
    }

    public EventDetails(EventDTO selectedEvent) {
        initWidget(uiBinder.createAndBindUi(this));
        this.event = selectedEvent;
        lblEventName.setText(event.getEventName());
        lblEventDesc.setText(event.getEventDes());
        lblEventType.setText(event.getEventType());
        lblEventLoc.setText(event.getEventLoc());
        lblEventOrganizer.setText(Integer.toString(event.getEventID())); 
        //lblEventDateTime.setText(event.getFromDate().toString());   
    }
}
