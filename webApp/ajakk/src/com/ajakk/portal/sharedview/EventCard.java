package com.ajakk.portal.sharedview;

import org.gwtbootstrap3.client.ui.Image;
import org.gwtbootstrap3.client.ui.Label;
import org.gwtbootstrap3.client.ui.Modal;
import org.gwtbootstrap3.client.ui.base.modal.ModalDialog;
import org.gwtbootstrap3.client.ui.Button;

import com.ajakk.portal.App;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class EventCard extends Composite {

    private static EventCardUiBinder uiBinder = GWT.create(EventCardUiBinder.class);

    interface EventCardUiBinder extends UiBinder<Widget, EventCard> {
    }

    public EventCard() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiField    Button btnEventInfo;
    @UiField    Label lblEvent;
    @UiField    Image imgEvent;
    
    public EventCard(String firstName) {
        initWidget(uiBinder.createAndBindUi(this));
        btnEventInfo.setText(firstName);
        btnEventInfo.setStylePrimaryName("btn-primary");
        
        //set image source
        imgEvent.setUrl("http://harbourfutsal.org/wp-content/uploads/2014/08/upcoming-league-icon1.png");
        imgEvent.setPixelSize(150, 100);
       
    }

    @UiHandler("btnEventInfo")
    void onClick(ClickEvent e) {
        ModalDialog modal = new ModalDialog();
        modal.setVisible(true);
        App.getHomePage().showModal();
    }
}
