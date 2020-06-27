package com.kratonsolution.belian.partys.ui.organization;

import com.kratonsolution.belian.common.ui.event.UIEvent;

import lombok.Getter;
import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class OrganizationUIEvent extends UIEvent {

	private static final long serialVersionUID = 3276392804375094816L;
	
	@Getter
	private String code;
	
	public OrganizationUIEvent(@NonNull String type, @NonNull String code) {
		
		super(OrganizationUIEvent.class.getName(), type);
		this.code = code;
	}
}
