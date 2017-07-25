package com.ajakk.client.view;

import com.google.gwt.i18n.client.DateTimeFormat;
import java.util.Date;
import com.ajakk.client.App;
import com.ajakk.client.Rpc;
import com.ajakk.client.RpcAsync;
import com.ajakk.shared.EventDTO;
import com.ajakk.shared.UserDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialRow;

public class EventCard extends Composite {
    private static EventCardUiBinder uiBinder = GWT.create(EventCardUiBinder.class);
    interface EventCardUiBinder extends UiBinder<Widget, EventCard> {}
    private final RpcAsync   rpc = GWT.create(Rpc.class);
    
    public EventDTO event;
    @UiField MaterialButton btnActivityInfo;
    @UiField MaterialLabel lblEventDesc;
    @UiField MaterialRow cardBg;
    @UiField MaterialImage imageCard;
    @UiField MaterialLabel lblEventName;
    String ownerName = "";

    public EventCard(EventDTO event) {
        initWidget(uiBinder.createAndBindUi(this));
        setEvent(event);

        Date date = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(event.getEventDate());
        DateTimeFormat format = DateTimeFormat.getFormat("MMM d");
        String dateStr = format.format(date);
        format = DateTimeFormat.getFormat("EEE");
        String dayStr = format.format(date);
        
     // get Owner of this event
        rpc.getUserFromID(event.getOwnerID(), new AsyncCallback<UserDTO>() {
            @Override
            public void onFailure(Throwable caught) {
                App.showMessage("Error", caught.getMessage(), "");
            }

            @Override
            public void onSuccess(UserDTO ownerEvent) {
                ownerName = ownerEvent.getName();
                lblEventName.setText(ownerName + " ajakk " + event.getEventType() + " in " + event.getEventLoc());
                lblEventDesc.setText(" on " + dayStr + ", " + dateStr);
                randomColor();
                changeBg();
            }
            
        });
    }

    private void changeBg() {
        switch (event.getEventType()) {
        case "Futsal":
            imageCard.setUrl("images/futsal.png");
            break;
        case "Basketball":
            imageCard.setUrl("images/basketball.png");
            break;
        case "Volunteer":
            imageCard.setUrl("images/volunteer.png");
            break;
        }
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
    
    public void randomColor() {
        
        switch(1 + Random.nextInt(8)) {
        case 1: 
            cardBg.setBackgroundColor(Color.LIGHT_BLUE_DARKEN_4);
            break;
        case 2:
            cardBg.setBackgroundColor(Color.TEAL_DARKEN_3);
            break;
        case 3:
            cardBg.setBackgroundColor(Color.GREEN_DARKEN_4);
            break;
        case 4:
            cardBg.setBackgroundColor(Color.BROWN_DARKEN_1);
            break;
        case 5:
            cardBg.setBackgroundColor(Color.BLUE_GREY_DARKEN_2);
            break;
        case 6:
            cardBg.setBackgroundColor(Color.CYAN_DARKEN_4);
            break;
        case 7:
            cardBg.setBackgroundColor(Color.INDIGO_DARKEN_4);
            break;
        case 8:
            cardBg.setBackgroundColor(Color.PURPLE_DARKEN_1);
            break;
        case 9:
            cardBg.setBackgroundColor(Color.RED_DARKEN_2);
            break;
        }
    }
}
