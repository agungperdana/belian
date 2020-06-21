package com.kratonsolution.belian.security.ui.module;

import org.zkoss.zul.Listbox;

import com.kratonsolution.belian.security.api.ModuleGroup;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ModuleGroupUIHelper {

	public static Listbox get() {
		
		Listbox listbox = new Listbox();
		listbox.setMold("select");
		listbox.setMultiple(false);
		
		for(ModuleGroup group:ModuleGroup.values()) {
			listbox.appendItem(group.name(), group.name());
		}
		
		listbox.setSelectedIndex(0);
		return listbox;
	}
	
	public static void select(@NonNull Listbox box, @NonNull ModuleGroup group) {
		box.getItems().forEach(item -> {
			if(item.getLabel().equals(group.name())) {
				box.setSelectedItem(item);
			}
		});
	}
	
	public static ModuleGroup get(@NonNull Listbox box) {
		
		if(box.getSelectedItem() != null) {
			return ModuleGroup.valueOf(box.getSelectedItem().getValue());
		}
		
		return null;
	}
}
