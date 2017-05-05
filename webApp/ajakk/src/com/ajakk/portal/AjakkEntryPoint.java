/* 
 * Entry point of the web app
 */

package com.ajakk.portal;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class AjakkEntryPoint implements EntryPoint {

	@Override
	public void onModuleLoad() {

		RootPanel.get().add(App.getLoginPage());
	}
}
