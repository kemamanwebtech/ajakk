package com.ajakk.portal.view;

import org.gwtbootstrap3.client.ui.NavbarBrand;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.gwt.HTMLPanel;
import org.gwtbootstrap3.extras.card.client.ui.Card;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

public class HomePage extends Composite {

	private static HomePageUiBinder uiBinder = GWT.create(HomePageUiBinder.class);
	
	@UiField NavbarBrand brand;
	@UiField HTMLPanel eventContainer;
	
	interface HomePageUiBinder extends UiBinder<Widget, HomePage> {
	}

	public HomePage() {
		initWidget(uiBinder.createAndBindUi(this));
		//addStyleName("fullWidth");
		//RootPanel.get().addStyleName("page");
		//RootPanel.get().setHeight(Window.getClientHeight()+"px"); 
		Window.setMargin("0px");
		
		for (int i=0; i<30; i++){
			Card card = new Card();
			card.setWidth("200px");
			card.setHeight("200px");
			eventContainer.
		}
		

	}


	public HomePage(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}


}
