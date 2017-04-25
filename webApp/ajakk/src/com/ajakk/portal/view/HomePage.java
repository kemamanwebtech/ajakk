package com.ajakk.portal.view;

import java.util.ArrayList;
import java.util.List;

import org.gwtbootstrap3.client.ui.Anchor;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.ListGroupItem;
import org.gwtbootstrap3.client.ui.Modal;
import org.gwtbootstrap3.client.ui.constants.Toggle;
import org.gwtbootstrap3.extras.notify.client.ui.Notify;

import com.ajakk.portal.AjakkRPC;
import com.ajakk.portal.AjakkRPCAsync;
import com.ajakk.portal.App;
import com.ajakk.shared.dto.EventDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class HomePage extends Composite {
	@UiField	Modal  modal;
	@UiField	Anchor linkProfile;
	@UiField	ListGroupItem eventContainerPanel;
	@UiField 	Anchor btnAddEvent;
	
	interface HomePageUiBinder extends UiBinder<Widget, HomePage> {
	}

	private static HomePageUiBinder uiBinder = GWT.create(HomePageUiBinder.class);
	private final AjakkRPCAsync     rpc      = GWT.create(AjakkRPC.class);
	Toggle         toggle;
	List<EventDTO> eventList = null;
	static EventDTO selectedEvent = null;

	public HomePage() {
		initWidget(uiBinder.createAndBindUi(this));
		eventList = new ArrayList<EventDTO>();
		
		linkProfile.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Modal modal = new Modal();
				modal.add(App.getUserProfilePage());
				modal.remove(0);
				RootPanel.get().add(modal);
				modal.show();	
			}
		});
		
		 getAllEvents();
	}

	/**
	 * get all events without filters
	 */
	 public void getAllEvents() {
		rpc.getAllEvents(new AsyncCallback<List<EventDTO>>() {
			
			public void onFailure(Throwable caught) {
				RootPanel.get().add(App.getDialogBox(caught.toString()));
			}

			public void onSuccess(List<EventDTO> result) {
				eventList = result;
				EventPanel eventPanel = new EventPanel();
				eventContainerPanel.add(eventPanel);
				Notify.notify("Successfully loaded all available events!");
			}
		});
	 }

	 /**
	  * Panels which contains all retrieved events
	  * 
	  */
	 public class EventPanel extends DecoratorPanel {
		 public EventPanel() {
			 for (EventDTO event : eventList) {
				 EventCard eventCard = new EventCard(event);
				 eventContainerPanel.add(eventCard);
			 }
		 }
	 }
	 
	 /**
	  * Display event details 
	  */
	 public static void popOutEventDetails(EventDTO selectedEvent) {
		 Modal modal = new Modal();
		 modal.add(App.createEventDetails(selectedEvent));
		 modal.remove(0);
		 modal.setMarginTop(100);
		 RootPanel.get().add(modal);
		 modal.show();
	 }

	 @UiHandler("btnAddEvent")
	 void onCreateEventClick(ClickEvent e){
		 Modal modal = new Modal();
		 modal.add(App.getCreateEventPage());
		 modal.remove(0);
		 modal.setMarginTop(100);
		 RootPanel.get().add(modal);
		 modal.show();
	 }

	 public static EventDTO getSelectedEvent() {
		 return selectedEvent;
	 }


}
