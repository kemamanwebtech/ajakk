package com.ajakk.portal.view;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.FormLabel;
import org.gwtbootstrap3.client.ui.Modal;

import com.ajakk.shared.dto.UserDTO;
import java.util.ArrayList;
import java.util.List;
import com.ajakk.portal.AjakkRPC;
import com.ajakk.portal.AjakkRPCAsync;
import com.ajakk.portal.App;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class UserProfile extends Composite {
	
	@UiField	Button btnEdit;
	@UiField	FormLabel userName;
	@UiField	FormLabel email;
	@UiField	FormLabel phoneNumber;
	@UiField	FormLabel location;
	@UiField	FormLabel sport;
	
	
	private static UserProfileUiBinder uiBinder = GWT.create(UserProfileUiBinder.class);

	interface UserProfileUiBinder extends UiBinder<Widget, UserProfile> {
	}
	
	private final AjakkRPCAsync     rpc      = GWT.create(AjakkRPC.class);
	List<UserDTO> userList = null;

	
	public UserProfile() {
		initWidget(uiBinder.createAndBindUi(this));
		
		userList = new ArrayList<UserDTO>();
		
		btnEdit.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Modal modal = new Modal();
				modal.add(App.getEditUserProfilePage());
				modal.remove(0);
				RootPanel.get().add(modal);
				modal.show();
				
			}
		});
		
		getUserDetails();


	}


	private void getUserDetails() {
		rpc.getUserInfoFromUserID(new AsyncCallback<List<UserDTO>>() {

			@Override
			public void onFailure(Throwable caught) {
				RootPanel.get().add(App.getDialogBox(caught.getMessage().toString()));	
			}

			@Override
			public void onSuccess(List<UserDTO> result) {
				userName.setText(result.toString());
			}

    		
    	});
	}


	
	

}
