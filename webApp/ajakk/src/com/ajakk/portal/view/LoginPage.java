package com.ajakk.portal.view;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Modal;
import org.gwtbootstrap3.client.ui.TextBox;

import com.ajakk.portal.AjakkRPC;
import com.ajakk.portal.AjakkRPCAsync;
import com.ajakk.portal.App;
import com.ajakk.portal.util.AjakkConfig;
import com.ajakk.portal.util.FieldValidator;
import com.ajakk.shared.dto.LoginDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
//import com.allen_sauer.gwt.log.client.Log;


public class LoginPage extends Composite {

    private final AjakkRPCAsync rpc = GWT.create(AjakkRPC.class);

    private static LoginPageUiBinder uiBinder = GWT.create(LoginPageUiBinder.class);

    @UiTemplate("LoginPage.ui.xml")
    interface LoginPageUiBinder extends UiBinder<Widget, LoginPage> {
    }

	@UiField TextBox userName;
	@UiField TextBox passwd;
	@UiField Button loginButton;
	@UiField Button regButton;
	@UiField Label errorLabel;
	@UiField Button ajakkButton;
	@UiField Button joinButton;

    DialogBox     dialogBox           = null;
    Button        closeButton         = null;
    Label         textToServerLabel   = null;
    HTML          serverResponseLabel = null;
    VerticalPanel dialogVPanel        = null;
    static Modal regpage = null;

    public LoginPage() {
//    	Log.debug("Launching LoginPage.java...");
        initWidget(uiBinder.createAndBindUi(this));

        setStyleName("body");

        // set focus to username textbox upon load
        userName.setFocus(true);
        userName.selectAll();
        userName.setText("active");
        passwd.setText("password");
    }

    @UiHandler("regButton")
    void onregButtonClicked(ClickEvent e) {
        // set register page as a modal instead of a new page itself
    	regpage = new Modal();
    	regpage.add(App.getRegPage());
    	regpage.remove(0);
        RootPanel.get().add(regpage);
        regpage.show();
    }
    
    public static void removeRegPage() {
    	regpage.hide();
    	RootPanel.get().remove(regpage);
    }

    @UiHandler("loginButton")
    void onloginButtonClicked(ClickEvent e) {
        if (!FieldValidator.isValidUserName(userName.getText())) {
            errorLabel.setText("Username is required.");
            return;
        }

        if (!FieldValidator.isValidPasswd(passwd.getText())) {
            errorLabel.setText("Password is required.");
            return;
        }

        rpc.doLogin(userName.getText(), passwd.getText(), new AsyncCallback<LoginDTO>() {
            public void onFailure(Throwable caught) {
                RootPanel.get().add(App.getDialogBox(AjakkConfig.SERVER_ERROR));
            }

            public void onSuccess(LoginDTO result) {

                switch (result.getUserStatus()) {

                    case "NotActive":
                        RootPanel.get().add(App.getDialogBox(AjakkConfig.ACC_NOTACTIVE));
                        break;

                    case "Blocked":
                        RootPanel.get().add(App.getDialogBox(AjakkConfig.ACC_BLOCKED));
                        break;

                    case "Locked":
                        RootPanel.get().add(App.getDialogBox(AjakkConfig.ACC_LOCKED));
                        break;

                    case "Deleted":
                        RootPanel.get().add(App.getDialogBox(AjakkConfig.ACC_DELETED));
                        break;

                    case "Invalid":
                        RootPanel.get().add(App.getDialogBox(AjakkConfig.AUTH_ERROR));
                        break;

                    case "Active":
                    	App.username = userName.getText();
                    	
                    	rpc.getUserIDFromUsername(App.username, new AsyncCallback<Integer>() {

							@Override
							public void onFailure(Throwable caught) {
								RootPanel.get().add(App.getDialogBox(caught.getMessage().toString()));	
							}

							@Override
							public void onSuccess(Integer result) {
								if (result > 0)
									App.userID = result;
								else 
									RootPanel.get().add(App.getDialogBox("Error : Failed to get userID"));	
							}
                    		
                    	});
                    	
                    	
                        RootPanel.get().clear();
                        RootPanel.get().setStyleName("fullWidth");
                        RootPanel.get().add(App.getHomePage());
                        break;
                }
            }
        });
    }
    
    @UiHandler("ajakkButton")
    public void onAjakkButtonClicked(ClickEvent e) {
    	RootPanel.get().add(App.getDialogBox("Ajak your friends!"));
    }
    
    @UiHandler("joinButton")
    public void onjoinButtonClicked(ClickEvent e) {
    	RootPanel.get().add(App.getDialogBox("Join your friends!"));
    }
}
