package com.kratonsolution.belian.security.ui.module;

import com.kratonsolution.belian.common.ui.event.UIEvent;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class ModuleUIEvent extends UIEvent {

	private static final long serialVersionUID = 4510223896199093865L;
	
	@Getter
	@Setter
	private String code;
	
	public ModuleUIEvent(@NonNull String type) {
		super(type);
	}
	
	public static ModuleUIEvent toGrid() {
		return new ModuleUIEvent(UIEvent.GRID);
	}
	
	public static ModuleUIEvent newForm() {
		return new ModuleUIEvent(UIEvent.ADD_FORM);
	}
	
	public static ModuleUIEvent editForm(@NonNull String code) {
		
		ModuleUIEvent ev = new ModuleUIEvent(UIEvent.EDIT_FORM);
		ev.setCode(code);
		
		return ev;
	}
}
