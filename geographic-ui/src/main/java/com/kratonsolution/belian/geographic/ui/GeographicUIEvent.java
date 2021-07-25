package com.kratonsolution.belian.geographic.ui;

import com.kratonsolution.belian.common.ui.event.UIEvent;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class GeographicUIEvent extends UIEvent {

	private static final long serialVersionUID = -5482938099623621988L;
	
	@Getter
	@Setter
	private String code;
	
	public GeographicUIEvent(@NonNull String type) {
		super(type);
	}
	
	public static GeographicUIEvent toGrid() {
		return new GeographicUIEvent(UIEvent.GRID);
	}
	
	public static GeographicUIEvent newForm() {
		return new GeographicUIEvent(UIEvent.ADD_FORM);
	}
	
	public static GeographicUIEvent editForm(@NonNull String code) {
		
		GeographicUIEvent ev = new GeographicUIEvent(UIEvent.EDIT_FORM);
		ev.setCode(code);
		
		return ev;
	}
}
