package com.kratonsolution.belian.common.ui.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
public class WindowContentEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	private String key;
	
	public WindowContentEvent(Object source) {
		super(source);
	}
}
