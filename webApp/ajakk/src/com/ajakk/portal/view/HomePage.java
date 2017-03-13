package com.ajakk.portal.view;

import org.gwtbootstrap3.client.ui.NavbarBrand;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.constants.Toggle;
import org.gwtbootstrap3.extras.card.client.ui.Back;
import org.gwtbootstrap3.extras.card.client.ui.Card;
import org.gwtbootstrap3.extras.card.client.ui.CardStyles;
import org.gwtbootstrap3.extras.card.client.ui.Front;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Modal;

import com.ajakk.portal.sharedview.EventCard;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

public class HomePage extends Composite {

    private static HomePageUiBinder uiBinder = GWT.create(HomePageUiBinder.class);

    @UiField
    HTMLPanel   eventContainerPanel;
    @UiField
    Modal       modal;

    Toggle toggle;

    interface HomePageUiBinder extends UiBinder<Widget, HomePage> {
    }

    public HomePage() {
        initWidget(uiBinder.createAndBindUi(this));
  

        FlexTable hp = new FlexTable();
        
        int column = 0;
        int row = 0;
        for (int i = 0; i < 40; i++) {
            // EventCard eventCard = new EventCard("Event " + i);
            
            
            EventCard event = new EventCard("Event " + i);
     
            //hp.add(eventCard);
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

    public HomePage(String firstName) {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
