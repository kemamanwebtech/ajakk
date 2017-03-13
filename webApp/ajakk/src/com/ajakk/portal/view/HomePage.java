package com.ajakk.portal.view;

import org.gwtbootstrap3.client.ui.constants.Toggle;
import java.util.ArrayList;
import java.util.List;

import org.gwtbootstrap3.client.ui.Modal;

import com.ajakk.portal.AjakkRPC;
import com.ajakk.portal.AjakkRPCAsync;
import com.ajakk.portal.sharedview.EventCard;
import com.ajakk.shared.dto.EventDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class HomePage extends Composite {
    
    interface HomePageUiBinder extends UiBinder<Widget, HomePage> {
    }
    
    private static HomePageUiBinder uiBinder = GWT.create(HomePageUiBinder.class);
    private final AjakkRPCAsync     rpc      = GWT.create(AjakkRPC.class);
    
    

    @UiField
    HTMLPanel      eventContainerPanel;
    @UiField
    Modal          modal;
    
    Toggle         toggle;
    List<EventDTO> eventList = null;

    public HomePage() {
        System.out.println("creating UI for homepage...");

        initWidget(uiBinder.createAndBindUi(this));
        eventList = new ArrayList<EventDTO>();

        getAllEvents();

        FlexTable hp = new FlexTable();

        int column = 0;
        int row = 0;

        for (int i=0; i<eventList.size(); i++) {
            //Window.alert("Event " + eventList.get(i).getEventName());
        //for (int i=0; i<20; i++) {
            // EventCard eventCard = new EventCard("Event " + i);

            EventCard event = new EventCard("Event " +  eventList.get(i).getEventName());
            //EventCard event = new EventCard("Event " + i);

            // hp.add(eventCard);
            hp.setStyleName("page");
            hp.setCellSpacing(20);

            hp.setWidget(row, column, event);

            column++;
            if (column > 4) {
                column = 0;
                row++;
            }

        }

        eventContainerPanel.add(hp);

    }

    public void getAllEvents() {
        
        
        System.out.println("Calling rpc.getAllEvents()...");

        // call RPC to get data from db
        rpc.getAllEvents(new AsyncCallback<List<EventDTO>>() {
            
            public void onFailure(Throwable caught) {
                System.out.println("Errors in rpc.getAllEvents()...");
                System.out.println(caught.toString());
                
            }

            public void onSuccess(List<EventDTO> result) {
                eventList = result;
                System.out.println(result.size() + " events returned to Homepage");
                Window.alert(eventList.size() + " events returned to Homepage");

            }
        });
        
    }

    

}
