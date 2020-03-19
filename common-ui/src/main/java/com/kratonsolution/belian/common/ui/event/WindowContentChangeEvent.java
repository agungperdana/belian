package com.kratonsolution.belian.common.ui.event;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class WindowContentChangeEvent extends ApplicationEvent {

	private static final long serialVersionUID = 6718613562487127926L;

	public static String GRID = "GRID";
	
	public static String ADD_FORM = "ADD_FORM";
	
	public static String EDIT_FORM = "EDIT_FORM";
	
	@Getter
	private String type;
	
	public WindowContentChangeEvent(Object source, String type) {

		super(source);
		this.type = type;
	}
}
