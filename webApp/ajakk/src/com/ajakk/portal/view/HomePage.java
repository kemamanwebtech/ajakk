package com.ajakk.portal.view;

import org.gwtbootstrap3.client.ui.constants.Toggle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.gwtbootstrap3.client.ui.AnchorListItem;
import org.gwtbootstrap3.client.ui.ListGroupItem;
import org.gwtbootstrap3.client.ui.Modal;
import com.ajakk.portal.AjakkRPC;
import com.ajakk.portal.AjakkRPCAsync;
import com.ajakk.portal.App;
import com.ajakk.portal.sharedview.EventCard;
import com.ajakk.shared.dto.EventDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.Widget;

public class HomePage extends Composite {
    
    interface HomePageUiBinder extends UiBinder<Widget, HomePage> {
    }
    
    private static HomePageUiBinder uiBinder = GWT.create(HomePageUiBinder.class);
    private final AjakkRPCAsync     rpc      = GWT.create(AjakkRPC.class);
    
    

    @UiField    Modal          modal;
    @UiField	ListGroupItem eventContainerPanel;
    @UiField	AnchorListItem uProfile;
    
    
    Toggle         toggle;
    List<EventDTO> eventList = null;

    public HomePage() {
        initWidget(uiBinder.createAndBindUi(this));
        eventList = new ArrayList<EventDTO>();
        
        // get all events immediately
        rpc.getAllEvents(new AsyncCallback<List<EventDTO>>() {
            
            public void onFailure(Throwable caught) {
                System.out.println("Errors in rpc.getAllEvents()..." + caught.toString());
            }

            public void onSuccess(List<EventDTO> result) {
                eventList = result;
                EventPanel eventPanel = new EventPanel();
                eventContainerPanel.add(eventPanel);
                
            }
        });

        
    
    }
    
    /**
     * Panels which contains all retrieved events
     * @author raf
     *
     */
    public class EventPanel extends DecoratorPanel {
        
        public EventPanel() {
            for (EventDTO event : eventList) {
                EventCard eventCard = new EventCard("Event " +  event.getEventName());
                eventContainerPanel.add(eventCard);
            }
        }
    }
    
    public void showModal() {
        modal.show();
        
    }
    
    
//    	// set register page as a modal instead of a new page itself
//    	Modal modal = new Modal();
//    	modal.add(App.getRegPage());
//    	RootPanel.get().add(modal);
//    	modal.show();	
//    }
    @UiHandler("uProfile")
    void onRegClick(ClickEvent e) {
    	RootPanel.get().clear();
    	RootPanel.get().add(App.getUserProfilePage());
    	
    }
    
}

