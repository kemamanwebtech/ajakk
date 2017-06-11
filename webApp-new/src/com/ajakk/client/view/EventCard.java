package com.ajakk.client.view;

import com.google.gwt.i18n.client.DateTimeFormat;
import java.util.Date;
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
import gwt.material.design.client.ui.MaterialLabel;

public class EventCard extends Composite {
    private static EventCardUiBinder uiBinder = GWT.create(EventCardUiBinder.class);

    interface EventCardUiBinder extends UiBinder<Widget, EventCard> {}
    
    public EventDTO event;
    @UiField MaterialButton btnActivityInfo;
    @UiField MaterialLabel lblDate;
    @UiField MaterialLabel lblDay;
    @UiField MaterialLabel lblLocation;

    public EventCard(EventDTO event) {
        initWidget(uiBinder.createAndBindUi(this));
        setEvent(event);

        lblLocation.setText(event.getEventLocName());
        lblDate.setText(event.getEventDate());

        Date date = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse(event.getEventDate());
        DateTimeFormat format = DateTimeFormat.getFormat("EEE");
        lblDay.setText(format.format(date));
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
