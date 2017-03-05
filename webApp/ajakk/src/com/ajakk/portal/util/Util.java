/*
 *  Utility class to for common functions 
 *  i.e. configurations, db connection properties
 */

package com.ajakk.portal.util;

import com.ajakk.portal.util.AjakkConfig;

public class Util {
	AjakkConfig config = null;
	
	public Util() {
		// load configuration
		config = new AjakkConfig();
	}
	
	
}
