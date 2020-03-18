package com.kratonsolution.belian.common.ui.util;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;

import com.kratonsolution.belian.common.ui.AbstractScreen;
import com.kratonsolution.belian.common.ui.DefaultSettings;
import com.kratonsolution.belian.common.ui.Fisheyes;
import com.kratonsolution.belian.common.ui.UISetting;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class UIHelper {
	
	public static Desktop getDesktop() {
		return Executions.getCurrent().getDesktop();
	}
	
	public static Page getPage() {
		return Executions.getCurrent().getDesktop().getFirstPage();
	}
	
	public static Fisheyes getFisheye() {
		
		for(Component com:getPage().getRoots()) {
			if(com instanceof AbstractScreen) {
				return ((AbstractScreen)com).getFisheye();
			}
		}
		
		return null;
	}
	
	public static UISetting getSetting() {
		
		Desktop desktop = getDesktop();
		if(desktop != null && desktop.getAttributes().containsKey(UISetting.UI_SETTING_KEY)) {
			return (UISetting)desktop.getAttribute(UISetting.UI_SETTING_KEY);
		}
		
		return new DefaultSettings();
	}
}
