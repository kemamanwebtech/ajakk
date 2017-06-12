package com.ajakk.client.view;
import java.util.Date;
import com.ajakk.client.App;
import com.ajakk.client.Config;
import com.ajakk.client.Rpc;
import com.ajakk.client.RpcAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
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
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialListBox;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialTextBox;

public class CreateEvent2 extends Composite {
    private static CreateEventUiBinder uiBinder = GWT.create(CreateEventUiBinder.class);
    
    CreateEvent2 instance = null;

    interface CreateEventUiBinder extends UiBinder<Widget, CreateEvent2> {}

    @UiField MaterialModal    modal;
//    @UiField MaterialTextArea title;
//    
//    
//    @UiField MaterialImage    imgName;
//    @UiField MaterialTextBox txtName;
//    
//    @UiField MaterialImage    imgType;
//    @UiField MaterialListBox type;
//    
//    @UiField MaterialImage    imgDatetime;
//    @UiField MaterialDatePicker date;
//    @UiField MaterialTimePicker time;
//
//    @UiField MaterialImage    imgLoc;
//    @UiField MaterialTextBox txtLoc;
//    
//    @UiField MaterialButton   btnCancel;
//    @UiField MaterialButton   btnSave;
//    
//    private final RpcAsync    rpc   = GWT.create(Rpc.class);
//    String                    email = "";
//
//    @UiHandler("btnSave")
//    void onCreateEventClick(ClickEvent e) {
//        
//        String dated = DateTimeFormat.getFormat("yyyy-MM-dd").format(date.getDate());
//        String timed = DateTimeFormat.getFormat("HH:mm").format(time.getValue());
//        String datetime = dated + " " + timed;
//        
//        rpc.createEvent(txtName.getText(), type.getSelectedItemText(), datetime , 
//            txtLoc.getText(), App.loggedInUser, new AsyncCallback<String>() {
//            
//            @Override
//            public void onFailure(Throwable caught) {
//                App.showMessage(caught.getMessage());
//            }
//
//            @Override
//            public void onSuccess(String result) {
//                if (result.equals("success")) {
//                    App.showMessage("Your activity is created!");
//                    RootPanel.get().remove(instance);
//                } else {
//                    App.showMessage(result);
//                }
//            }
//        });
//    }
//
    public CreateEvent2() {
        initWidget(uiBinder.createAndBindUi(this));
        instance = this;
        modal.setDismissible(true);
    }

    public void show() {
        modal.open();
    }
    
}
