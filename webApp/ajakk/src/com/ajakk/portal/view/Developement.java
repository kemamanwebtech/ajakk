/**
 * 
 */
package com.ajakk.portal.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author raf
 *
 */
public class Developement extends Composite implements HasText {

    private static DevelopementUiBinder uiBinder = GWT.create(DevelopementUiBinder.class);

    interface DevelopementUiBinder extends UiBinder<Widget, Developement> {
    }

    /**
     * Because this class has a default constructor, it can
     * be used as a binder template. In other words, it can be used in other
     * *.ui.xml files as follows:
     * <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
      *   xmlns:g="urn:import:**user's package**">
     *  <g:**UserClassName**>Hello!</g:**UserClassName>
     * </ui:UiBinder>
     * Note that depending on the widget that is used, it may be necessary to
     * implement HasHTML instead of HasText.
     */
    public Developement() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiField
    Button button;

    public Developement(String firstName) {
        initWidget(uiBinder.createAndBindUi(this));

        // Can access @UiField after calling createAndBindUi
        button.setText(firstName);
    }

    @UiHandler("button")
    void onClick(ClickEvent e) {
        Window.alert("Hello!");
    }

    public void setText(String text) {
        button.setText(text);
    }

    /**
     * Gets invoked when the default constructor is called
     * and a string is provided in the ui.xml file.
     */
    public String getText() {
        return button.getText();
    }

}