package com.kratonsolution.belian.common.ui;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class ModuleCommunicationEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	
	public static enum Type {OPEN, CLOSE, REFRESH}
	
	private String moduleName;
	
	private Type type = Type.OPEN;
	
	public ModuleCommunicationEvent(Object source, @NonNull String moduleName,@NonNull Type type) {
		super(source);
		
		this.moduleName = moduleName;
		this.type = type;
	}

}
