package com.kratonsolution.belian.common.ui.event;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Getter
public class ModuleEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	
	private String moduleName;
	
	public ModuleEvent(Object source, @NonNull String moduleName) {

		super(source);
		this.moduleName = moduleName;
	}
}
