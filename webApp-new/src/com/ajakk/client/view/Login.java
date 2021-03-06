package com.ajakk.client.view;
import com.ajakk.client.App;
import com.ajakk.client.Config;
import com.ajakk.client.Rpc;
import com.ajakk.client.RpcAsync;
import com.ajakk.shared.FieldValidator;
import com.ajakk.shared.LoginDTO;
import com.ajakk.shared.UserDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialTextBox;

public class Login extends Composite {
    private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);

    interface LoginUiBinder extends UiBinder<Widget, Login> {}

    private final RpcAsync   rpc = GWT.create(Rpc.class);
    @UiField MaterialModal   modal;
    @UiField MaterialButton  btnLogin;
/*    @UiField MaterialButton  btnLoginGmail;
    @UiField MaterialButton  btnLoginFb;*/
    @UiField MaterialTextBox txtEmail;
    @UiField MaterialTextBox txtPassword;

    public Login() {
        initWidget(uiBinder.createAndBindUi(this));
        modal.setDismissible(true);
        modal.setPixelSize(500, 270);
        modal.getWidget(0).setHeight("100%");
        
        txtEmail.setText("mrafsyam@gmail.com");
        txtPassword.setText("password");
        btnLogin.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (!FieldValidator.isValidUserName(txtEmail.getText())) {
                    txtEmail.setError("Please provide your email");
                    return;
                }
                if (!FieldValidator.isValidPasswd(txtPassword.getText())) {
                    txtPassword.setError("Please provide your password");
                    return;
                }
                rpc.doLogin(txtEmail.getText(), txtPassword.getText(), new AsyncCallback<LoginDTO>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        App.showMessage("Error", Config.SERVER_ERROR, "", 500, 500);
                        System.out.println(caught.toString());
                    }

                    @Override
                    public void onSuccess(LoginDTO result) {
                        switch (result.getUserStatus()) {
                        case "NotActive" :
                            App.showMessage("Error", Config.ACC_NOTACTIVE, "", 500, 500);
                            break;
                        case "Blocked" :
                            App.showMessage("Error", Config.ACC_BLOCKED, "", 500, 500);
                            break;
                        case "Locked" :
                            App.showMessage("Error", Config.ACC_LOCKED, "", 500, 500);
                            break;
                        case "Deleted" :
                            App.showMessage("Error", Config.ACC_DELETED, "", 500, 500);
                            break;
                        case "Invalid" :
                            App.showMessage("Uh oh!", Config.AUTH_ERROR, "", 450, 250);
                            break;
                        case "Active" :
                            
                            
                            rpc.getUser(txtEmail.getText(), new AsyncCallback<UserDTO>() {
                                @Override
                                public void onFailure(Throwable caught) {
                                    App.showMessage("Error", caught.getMessage().toString(), "", 500, 500);
                                }

                                @Override
                                public void onSuccess(UserDTO result) {
                                    if (result != null) {
                                        App.loggedInUser = result;
                                        Dashboard dashboard = new Dashboard();
                                        RootPanel.get().clear();
                                        RootPanel.get().add(dashboard);
                                    } else App.showMessage("Error", "Failed to get user.", "", 500, 500);
                                }
                            });
                            break;
                        }
                    }
                });
            }
        });
    }

    public void show() {
        modal.open();
    }
}
