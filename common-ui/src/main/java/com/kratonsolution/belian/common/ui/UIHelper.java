package com.kratonsolution.belian.common.ui;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;

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
}
