package com.kratonsolution.belian.common.ui.event;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class GeographicUIContentEvent extends UIEvent {

	private static final long serialVersionUID = -5482938099623621988L;
	
	@Getter
	@Setter
	private String code;
	
	public GeographicUIContentEvent(@NonNull String type) {
		super(type);
	}
	
	public static GeographicUIContentEvent toGrid() {
		return new GeographicUIContentEvent(UIEvent.GRID);
	}
	
	public static GeographicUIContentEvent newForm() {
		return new GeographicUIContentEvent(UIEvent.ADD_FORM);
	}
	
	public static GeographicUIContentEvent editForm(@NonNull String code) {
		
		GeographicUIContentEvent ev = new GeographicUIContentEvent(UIEvent.EDIT_FORM);
		ev.setCode(code);
		
		return ev;
	}
}
