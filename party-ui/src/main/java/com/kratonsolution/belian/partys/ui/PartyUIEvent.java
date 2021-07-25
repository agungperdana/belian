package com.kratonsolution.belian.partys.ui;

import com.kratonsolution.belian.common.ui.event.UIEvent;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class PartyUIEvent extends UIEvent {

	private static final long serialVersionUID = 3276392804375094816L;
	
	@Getter
	@Setter
	private String code;
	
	public PartyUIEvent(@NonNull String type) {
		
		super(PartyUIEvent.class.getName(), type);
	}
	
	public PartyUIEvent(@NonNull String type, @NonNull String code) {
		
		this(type);
		setCode(code);
	}
}
