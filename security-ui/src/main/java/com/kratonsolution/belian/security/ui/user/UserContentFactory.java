package com.kratonsolution.belian.security.ui.user;

import org.zkoss.zk.ui.Component;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
public class UserContentFactory {
	
	public static Component createGridContent() {
		return new UserGridContent();
	}
	
	public static Component createAddFormContent() {
		return new UserGridContent();
	}
	
	public static Component createEditFormContent() {
		return new UserGridContent();
	}
}
