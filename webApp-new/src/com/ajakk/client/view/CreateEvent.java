package com.ajakk.client.view;

import com.ajakk.client.App;
import com.ajakk.client.Rpc;
import com.ajakk.client.RpcAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.timepicker.MaterialTimePicker;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialDatePicker;
import gwt.material.design.client.ui.MaterialDropDown;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialListBox;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialTextBox;

public class CreateEvent extends Composite {
    private static CreateEventUiBinder uiBinder = GWT.create(CreateEventUiBinder.class);
    CreateEvent                        instance = null;

    interface CreateEventUiBinder extends UiBinder<Widget, CreateEvent> {}

    @UiField MaterialModal      modal;
    @UiField MaterialImage      imgName;
    @UiField MaterialTextBox    txtName;
    @UiField MaterialImage      imgType;
    @UiField MaterialDropDown    type;
    @UiField MaterialButton typeButton;
    @UiField MaterialImage      imgDatetime;
    @UiField MaterialDatePicker date;
    @UiField MaterialTimePicker time;
    @UiField MaterialImage      imgLoc;
    @UiField MaterialDropDown    loc;
    @UiField MaterialButton locBtn;
    @UiField MaterialButton     btnCancel;
    @UiField MaterialButton     btnSave;
    private final RpcAsync      rpc   = GWT.create(Rpc.class);
    String                      email = "";
 
    
    
   
    
    @UiHandler("btnSave")
    void onCreateEventClick(ClickEvent e) {
        String dated = DateTimeFormat.getFormat("yyyy-MM-dd").format(date.getDate());
        String timed = DateTimeFormat.getFormat("HH:mm").format(time.getValue());
        String datetime = dated + " " + timed;
        rpc.createEvent(txtName.getText(), typeButton.getText(), datetime, locBtn.getText(), App.loggedInUser, new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable caught) {
                App.showMessage(caught.getMessage());
            }

            @Override
            public void onSuccess(String result) {
                if (result.equals("success")) {
                    App.showMessage("Your activity is created!");
                    RootPanel.get().remove(instance);
                } else {
                    App.showMessage(result);
                }
            }
        });
    }

    public CreateEvent() {
        initWidget(uiBinder.createAndBindUi(this));
        instance = this;
        modal.setDismissible(true);
        email = App.loggedInUser.getEmail();
        if (email == "") {
            App.showMessage("Email is empty?");
        }
        
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
                locBtn.setText(a.getText());
            }
        });
    }

    public void show() {
        modal.open();
    }
    

    
}
