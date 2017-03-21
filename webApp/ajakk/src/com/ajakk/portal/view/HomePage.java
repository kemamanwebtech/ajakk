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
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
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

        rpc.getAllEvents(new AsyncCallback<List<EventDTO>>() {
            
            public void onFailure(Throwable caught) {
                System.out.println("Errors in rpc.getAllEvents()..." + caught.toString());
            }

            public void onSuccess(List<EventDTO> result) {
                
                eventList = result;
                Window.alert("size inside onSuccess " + Integer.toString(eventList.size()));
                EventGridPanel eventGrid = new EventGridPanel();
                eventContainerPanel.add(eventGrid);
                
            }
        });

        
    
    }
    
    public class EventGridPanel extends Grid {
        
        public EventGridPanel() {
            super(5,4);
            getCellFormatter().setWidth(0, 2, "256px");
            
            
            Window.alert("size otuside onSuccess " + Integer.toString(eventList.size()));
            int column = 0;
            int row = 0;
            for (EventDTO event : eventList) {
       
                EventCard eventCard = new EventCard("Event " +  event.getEventName());
                setWidget(row, column, new Button("test"));

                column++;
                if (column > 4) {
                    column = 0;
                    row++;
                }

            }
        }
    }
    
}
