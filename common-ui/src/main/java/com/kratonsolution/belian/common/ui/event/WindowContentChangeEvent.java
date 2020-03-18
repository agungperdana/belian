package com.kratonsolution.belian.common.ui.event;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class WindowContentChangeEvent extends ApplicationEvent {

	private static final long serialVersionUID = 6718613562487127926L;

	public static enum Type {GRID, EDIT_FORM, ADD_FORM}

	@Getter
	private Type type;
	
	public WindowContentChangeEvent(Object source, Type type) {

		super(source);
		this.type = type;
	}
}
