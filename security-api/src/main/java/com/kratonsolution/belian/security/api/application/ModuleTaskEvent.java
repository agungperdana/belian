package com.kratonsolution.belian.security.api.application;

import com.kratonsolution.belian.common.application.EventType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Getter
@Setter
public class ModuleTaskEvent {
	
	private String moduleCode;
	
	private EventType type;
}
