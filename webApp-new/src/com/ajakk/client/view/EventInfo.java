package com.ajakk.client.view;

import java.util.Date;
import java.util.List;
import com.ajakk.client.App;
import com.ajakk.client.Rpc;
import com.ajakk.client.RpcAsync;
import com.ajakk.shared.EventDTO;
import com.ajakk.shared.UserDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialTextArea;

public class EventInfo extends Composite {
    @UiField MaterialModal           modal;
    @UiField MaterialLabel           postedBy;
//    @UiField MaterialButton          btnJoin;
    @UiField MaterialImage           imageWhatsap;
    @UiField MaterialButton          btnContactMe;
    
    @UiField MaterialLabel           name;
    @UiField MaterialLabel           dateTime;
    @UiField MaterialLabel           location;
    
    public EventDTO                  event;
    private static EventInfoUiBinder uiBinder = GWT.create(EventInfoUiBinder.class);
    private final RpcAsync   rpc = GWT.create(Rpc.class);
    private String linkToWhatsapp = "https://api.whatsapp.com/send?phone=";
    private UserDTO ownerEvent =  null;
    StringBuilder fullLinkToWhatsapp = null;

    interface EventInfoUiBinder extends UiBinder<Widget, EventInfo> {}

    public EventInfo(EventDTO event) {
        initWidget(uiBinder.createAndBindUi(this));
        modal.setDismissible(true);
        this.event = event;
        
        // get Owner of this event
        rpc.getUserFromID(event.getOwnerID(), new AsyncCallback<UserDTO>() {
            @Override
            public void onFailure(Throwable caught) {
                App.showMessage("Error", caught.getMessage(), "", 500, 500);
            }

            @Override
            public void onSuccess(UserDTO ownerEvent) {
                fullLinkToWhatsapp = new StringBuilder(linkToWhatsapp);
                fullLinkToWhatsapp.append(ownerEvent.getPhoneNumber());
                postedBy.setText("Ajakk by : " + ownerEvent.getName());
            }
            
        });
        name.setText(event.getEventName());
        location.setText(event.getEventLoc());
        Date date = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(event.getEventDate());
        DateTimeFormat format = DateTimeFormat.getFormat("EEEE, MMM d");
        dateTime.setText(format.format(date));
    }

    public void show() {
        modal.open();
    }
    
//    @UiHandler("btnJoin")
//    public void onBtnJoinClicked(ClickEvent e){
//        rpc.joinEvent(event, App.loggedInUser, new AsyncCallback<String>() {
//            @Override
//            public void onFailure(Throwable caught) {
//                App.showMessage("Error", caught.getMessage(),"", 500, 500);
//            }
//
//            @Override
//            public void onSuccess(String result) {
//                App.showMessage("", "Successfully added you to the list of participants.", "", 500, 500);
//            }
//        });
//    }
    
//    @UiHandler("btnViewParticipant")
//    public void onViewParticipantClicked(ClickEvent e){
//        rpc.viewParticipant(event, App.loggedInUser, new AsyncCallback<List<UserDTO>>() {
//            @Override
//            public void onFailure(Throwable caught) {
//                App.showMessage("Error", caught.getMessage(), "", 500, 500);
//            }
//
//            @Override
//            public void onSuccess(List<UserDTO> result) {
//                String list = "";
//                for (UserDTO user : result) {
//                    list = list + user.getName() + "\n";
//                }
//                ListParticipant listUsers = new ListParticipant(list);
//                RootPanel.get().add(listUsers);
//                listUsers.show();
//            }
//        });
//    }
    
    @UiHandler("imageWhatsap")
    public void onImageWhatsapClicked(ClickEvent e){
        Window.open(fullLinkToWhatsapp.toString(),"_blank","");
    }
    
    
    @UiHandler("btnContactMe")
    public void onContactMeClicked(ClickEvent e){
        Window.open(fullLinkToWhatsapp.toString(),"_blank","");
    }
}
