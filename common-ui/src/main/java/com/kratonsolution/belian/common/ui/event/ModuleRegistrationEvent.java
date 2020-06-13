package com.kratonsolution.belian.common.ui.event;

import org.springframework.context.ApplicationEvent;

import com.kratonsolution.belian.common.ui.ModuleRegistryInformation;

import lombok.Getter;
import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Getter
public class ModuleRegistrationEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	
	private ModuleRegistryInformation moduleInformation;
	
	public ModuleRegistrationEvent(Object source, @NonNull ModuleRegistryInformation moduleInformation) {

		super(source);
		this.moduleInformation = moduleInformation;
	}
}
