package com.kratonsolution.belian.security.ui.role;

import org.zkoss.zk.ui.Component;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
public class RoleContentFactory {
	
	public static Component createGridContent() {
		return new RoleGridContent();
	}
	
//	public static Component createAddFormContent() {
//		return new UserFormContent();
//	}
//	
//	public static Component createEditFormContent(@NonNull String key) {
//		return new UserEditContent(key);
//	}
//	
//	public static Component createChangePasswordFormContent(@NonNull String key) {
//		return new ChangePassword(key);
//	}
}
