package com.kratonsolution.belian.security.ui.user;

import org.zkoss.zk.ui.Component;

import lombok.NonNull;

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
		return new UserFormContent();
	}
	
	public static Component createEditFormContent(@NonNull String key) {
		return new UserEditContent(key);
	}
}
