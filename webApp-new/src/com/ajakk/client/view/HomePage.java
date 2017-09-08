package com.ajakk.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.animate.MaterialAnimator;
import gwt.material.design.client.ui.animate.Transition;

public class HomePage extends Composite {
	private static LoginPageUiBinder uiBinder = GWT.create(LoginPageUiBinder.class);

	interface LoginPageUiBinder extends UiBinder<Widget, HomePage> {
	}

	@UiField
	MaterialColumn hiking;
	@UiField
	MaterialColumn volunteer;
	@UiField
	MaterialColumn futsal;
	@UiField
	MaterialColumn basketball;
	@UiField
	MaterialButton btnLogin;
	@UiField
	MaterialButton btnRegister;

	public HomePage() {
		initWidget(uiBinder.createAndBindUi(this));
		MouseOverHandler hoverHandler = new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				MaterialAnimator.animate(Transition.PULSE, (Widget) event.getSource(), 300);
			}
		};
		hiking.addMouseOverHandler(hoverHandler);
		volunteer.addMouseOverHandler(hoverHandler);
		futsal.addMouseOverHandler(hoverHandler);
		basketball.addMouseOverHandler(hoverHandler);
		btnLogin.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Login login = new Login();
				RootPanel.get().add(login);
				login.show();
			}
		});
		btnRegister.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Register register = new Register();
				RootPanel.get().add(register);
				register.show();
			}
		});
		hiking.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				DashboardNotRegUser dashboard = new DashboardNotRegUser();
				RootPanel.get().clear();
				RootPanel.get().add(dashboard);
			}
		});
	}
}
