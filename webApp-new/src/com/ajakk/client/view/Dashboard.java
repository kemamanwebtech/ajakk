package com.ajakk.client.view;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.ajakk.client.App;
import com.ajakk.client.Rpc;
import com.ajakk.client.RpcAsync;
import com.ajakk.shared.EventDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DatePicker;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialDatePicker;
import gwt.material.design.client.ui.MaterialDropDown;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialFAB;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialSplashScreen;

public class Dashboard extends Composite {
    private static DashboardUiBinder uiBinder = GWT.create(DashboardUiBinder.class);

    interface DashboardUiBinder extends UiBinder<Widget, Dashboard> {}

    private final RpcAsync     rpc           = GWT.create(Rpc.class);
    List<EventDTO>             eventList     = null;
    static EventDTO            selectedEvent = null;
    Date selectedDate = null;
    
    @UiField MaterialContainer cardContainer;
    @UiField MaterialLink      profile;
    @UiField MaterialFAB       btnCreateActivity;
    @UiField MaterialButton    btnReload;
    @UiField MaterialButton    btnClearFilters;
    @UiField MaterialDropDown  type;
    @UiField MaterialButton    typeButton;
    @UiField MaterialButton    dateButton;
    @UiField MaterialDatePicker datePicker;
    @UiField MaterialDropDown  loc;
    @UiField MaterialButton    locButton;
    @UiField MaterialSplashScreen splash;

    

    public Dashboard() {
        initWidget(uiBinder.createAndBindUi(this));
        
        splash.show();
        Timer t = new Timer() {
        @Override
        public void run() {
            splash.hide();
            }
        };
        t.schedule(1000);
        
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
        selectedDate = new Date();
        datePicker.addValueChangeHandler(new ValueChangeHandler<Date>() {
            @Override
            public void onValueChange(ValueChangeEvent<Date> event) {
                selectedDate = event.getValue();
                String dated = DateTimeFormat.getFormat("MMM d, yyyy").format(selectedDate);
                dateButton.setText(dated);
            }
        });
        
        datePicker.addCloseHandler(new CloseHandler<MaterialDatePicker>() {
            @Override
            public void onClose(CloseEvent<MaterialDatePicker> event) {
                datePicker.getElement().getStyle().setProperty("display", "none");
                dateButton.getElement().getStyle().setDisplay(Display.INITIAL);
                
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
    
    
    @UiHandler("dateButton")
    void onDateButtonClicked(ClickEvent e) {
        //widget.getElement().getStyle().setProperty("align", "right");
        datePicker.getElement().getStyle().setDisplay(Display.FLEX);
        datePicker.getChildren().get(0).getElement().getStyle().setProperty("display", "none");
        datePicker.getChildren().get(1).getElement().getStyle().setProperty("display", "none");
        datePicker.getChildren().get(2).getElement().getStyle().setProperty("display", "none");
        dateButton.getElement().getStyle().setDisplay(Display.NONE);
        //datePicker.removeStyleName("hidden");
        datePicker.open();
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
