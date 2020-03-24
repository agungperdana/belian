package com.kratonsolution.belian.security.ui.module;

import org.zkoss.zk.ui.Component;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
public class ModuleContentFactory {
	
	public static Component createGridContent() {
		return new ModuleGridContent();
	}
	
	public static Component createEditFormContent(@NonNull String code) {
		return new ModuleEditContent(code);
	}
	
	public static Component createAddFormContent() {
		return new ModuleFormContent();
	}
}
