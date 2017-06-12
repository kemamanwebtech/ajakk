package com.ajakk.client.view;
import java.util.ArrayList;
import java.util.List;
import com.ajakk.client.App;
import com.ajakk.client.Rpc;
import com.ajakk.client.RpcAsync;
import com.ajakk.shared.EventDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialDropDown;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialFAB;
import gwt.material.design.client.ui.MaterialRow;

public class Dashboard extends Composite {
    private static DashboardUiBinder uiBinder = GWT.create(DashboardUiBinder.class);

    interface DashboardUiBinder extends UiBinder<Widget, Dashboard> {}

    private final RpcAsync     rpc           = GWT.create(Rpc.class);
    List<EventDTO>             eventList     = null;
    static EventDTO            selectedEvent = null;
    @UiField MaterialContainer cardContainer;
    @UiField MaterialLink	   profile;
    @UiField MaterialFAB btnCreateActivity;
    @UiField MaterialButton btnReload;
    @UiField MaterialButton btnClearFilters;
    @UiField MaterialDropDown    type;
    @UiField MaterialButton typeButton;
    @UiField MaterialDropDown    loc;
    @UiField MaterialButton locButton;

    public Dashboard() {
        initWidget(uiBinder.createAndBindUi(this));
        eventList = new ArrayList<EventDTO>();
        getAllEvents();
        
        type.addSelectionHandler(new SelectionHandler<Widget>() {
            @Override
            public void onSelection(SelectionEvent<Widget> event) {
                MaterialLink a = (MaterialLink) event.getSelectedItem();
                typeButton.setText(a.getElement().getInnerText());
            }
        });
        
        loc.addSelectionHandler(new SelectionHandler<Widget>() {
            @Override
            public void onSelection(SelectionEvent<Widget> event) {
                MaterialLink a = (MaterialLink) event.getSelectedItem();
                locButton.setText(a.getText());
            }
        });
    }

    public void getAllEvents() {
        rpc.getAllEvents(new AsyncCallback<List<EventDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                App.showMessage(caught.toString());
            }

            @Override
            public void onSuccess(List<EventDTO> result) {
                eventList = result;
                int i = 0;
                MaterialRow currentRow = new MaterialRow();
                cardContainer.add(currentRow);
                for (EventDTO event : eventList) {
                    EventCard card = new EventCard(event);
                    currentRow.add(card);
                    i++;
                    if (i > 3) {
                        MaterialRow newRow = new MaterialRow();
                        cardContainer.add(newRow);
                        currentRow = newRow;
                        i = 0;
                    }
                }
            }
        });
    }
    
    @UiHandler("profile")
    void onLinkProfileClicked(ClickEvent e) {
        // call here
         UserProfile userProfile = new UserProfile();
    	RootPanel.get().add(userProfile);
        userProfile.show();
    }

    @UiHandler("btnCreateActivity")
    public void onBtnCreate(ClickEvent e) {
        CreateEvent newActivity = new CreateEvent();
        RootPanel.get().add(newActivity);
        newActivity.show();
    }
    
    @UiHandler("btnReload")
    public void onBtnReload(ClickEvent e) {
        cardContainer.clear();
        getAllEvents();
    }
    
    
}
