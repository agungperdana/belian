package com.kratonsolution.belian.security.ui.module;

import com.kratonsolution.belian.common.ui.event.ContentEvent;

import lombok.Getter;
import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class OrganizationUIEvent extends ContentEvent {

	private static final long serialVersionUID = 3276392804375094816L;
	
	@Getter
	private String code;
	
	public OrganizationUIEvent(@NonNull String type, @NonNull String code) {
		super(type);
		this.code = code;
	}
}
