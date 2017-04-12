/**
 * 
 */
package com.ajakk.portal.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author raf-32
 */
public class EventDetails extends Composite {

    private static EventDetailsUiBinder uiBinder = GWT.create(EventDetailsUiBinder.class);

    interface EventDetailsUiBinder extends UiBinder<Widget, EventDetails> {
    }

    public EventDetails() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
