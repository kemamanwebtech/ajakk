package com.ajakk.client.view;

import com.ajakk.client.Config;
import com.ajakk.client.Rpc;
import com.ajakk.client.RpcAsync;
import com.ajakk.client.App;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialTextBox;

public class Register extends Composite {

    private static RegisterUiBinder uiBinder = GWT
            .create(RegisterUiBinder.class);

    interface RegisterUiBinder extends UiBinder<Widget, Register> {
    }

    private final RpcAsync rpc = GWT.create(Rpc.class);

    @UiField MaterialModal modal;
    @UiField MaterialButton btnReg;
    @UiField MaterialButton btnRegGmail;
    @UiField MaterialButton btnRegFb;
    @UiField MaterialTextBox txtName;
    @UiField MaterialTextBox txtEmail;
    @UiField MaterialTextBox txtPassword;
    @UiField MaterialTextBox txtPhone;
    @UiField MaterialTextBox txtLocation;

    public Register() {
        initWidget(uiBinder.createAndBindUi(this));
        modal.setDismissible(true);
        modal.setPixelSize(600, 630);
        modal.getWidget(0).setHeight("100%");
    }

    @UiHandler("btnReg")
    void onSignUpClicked(ClickEvent e) {

        rpc.doSignup(txtName.getText(), txtEmail.getText(),
                txtPassword.getText(), txtPhone.getText(),
                txtLocation.getText(),
                new AsyncCallback<String>() {

                    @Override
                    public void onFailure(Throwable caught) {
                        App.showMessage(caught.getMessage().toString());
                    }

                    @Override
                    public void onSuccess(String result) {
                        if (result.equals("success")) {
                            App.showMessage(
                                    "Successfully registered your ajakk acount.");
                            showDashboard();
                        } else {
                            App.showMessage(
                                    "Failed to contact server. Check your connectivity.");
                        }

                    }

                });

    }

    public void show() {
        modal.open();
    }

    public void showDashboard() {
        Login login = new Login();
        //RootPanel.get().clear();
        RootPanel.get().add(login);
        RootPanel.get().remove(this);
    }

}
