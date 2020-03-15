package com.kratonsolution.belian.commonspring;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class ModuleRegistrationEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	
	private String moduleName;
	
	public ModuleRegistrationEvent(Object source, @NonNull String moduleName) {

		super(source);
		this.moduleName = moduleName;
	}
}
