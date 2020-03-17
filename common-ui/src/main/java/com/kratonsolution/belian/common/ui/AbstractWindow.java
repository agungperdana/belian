package com.kratonsolution.belian.common.ui;

import org.zkoss.zul.Caption;
import org.zkoss.zul.Window;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
public abstract class AbstractWindow extends Window
{		
	private static final long serialVersionUID = 1L;
	
	protected Caption caption = new Caption();
	
	public AbstractWindow()
	{
		appendChild(caption);
		
		setWidth("80%");
		setHeight("75%");
		setClosable(true);
		setMinimizable(true);
		setMaximizable(true);
		setSizable(true);
		setPosition("center");
		
		setSclass("frmaedisplay");
	}
}
