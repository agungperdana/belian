package com.kratonsolution.belian.security.ui.role;

import com.kratonsolution.belian.common.ui.event.UIEvent;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class RoleUIEvent extends UIEvent {

	private static final long serialVersionUID = 4295079169701155035L;

	@Getter
	@Setter
	private String code;
	
	public RoleUIEvent(@NonNull String type) {
		super(type);
	}
	
	public static RoleUIEvent toGrid() {
		return new RoleUIEvent(UIEvent.GRID);
	}
	
	public static RoleUIEvent newForm() {
		return new RoleUIEvent(UIEvent.ADD_FORM);
	}
	
	public static RoleUIEvent editForm(@NonNull String code) {
		
		RoleUIEvent ev = new RoleUIEvent(UIEvent.EDIT_FORM);
		ev.setCode(code);
		
		return ev;
	}


}
