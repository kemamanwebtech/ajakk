package com.ajakk.client.view;

import com.ajakk.shared.EventDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialFAB;

public class EventCard extends Composite {
    private static EventCardUiBinder uiBinder = GWT.create(EventCardUiBinder.class);

    interface EventCardUiBinder extends UiBinder<Widget, EventCard> {}
    
    public EventDTO event;
    @UiField MaterialButton btnActivityInfo;

    public EventCard(EventDTO event) {
        initWidget(uiBinder.createAndBindUi(this));
        setEvent(event);
    }
    
    public void setEvent(EventDTO event) {
        this.event = event;
    }
    
    @UiHandler("btnActivityInfo")
    void onBtnActivityInfoClicked(ClickEvent e) {
        EventInfo eventInfo = new EventInfo(this.event);
        RootPanel.get().add(eventInfo);
        eventInfo.show();
    }
    
    
}
