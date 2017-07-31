    
    /*
     * A generic message with text and image to notify the user
     */

package com.ajakk.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialModal;

public class Message extends Composite {

    private static MessageUiBinder uiBinder = GWT.create(MessageUiBinder.class);

    interface MessageUiBinder extends UiBinder<Widget, Message> {
    }

    @UiField MaterialLabel topText;
    @UiField MaterialLabel btmText;
    @UiField MaterialModal modal;
    @UiField MaterialImage image;
    
    static Message instance;

    public Message(String topMsg, String btmMsg, String imageUrl, int width, int height) {
        initWidget(uiBinder.createAndBindUi(this));
        instance = this;
        topText.setText(topMsg);
        btmText.setText(btmMsg);
        
        if (!imageUrl.equals("")) {
            image.setUrl(imageUrl);
        } else {
            image.setVisible(false);
        }
        modal.setBackgroundColor(Color.TRANSPARENT);
        modal.setDismissible(true);
        modal.setPixelSize(width, height);
        modal.getWidget(0).setHeight("100%");
    }
    
    public static Message get() {
        return instance;
    }
    
    public void show() {
        modal.open();
    }

}
