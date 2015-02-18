/**
 * 
 */
package com.kratonsolution.belian.ui;

import org.zkoss.zul.Window;

/**
 * @author agungdodiperdana
 *
 */
public abstract class AbstractWindow extends Window implements HasStatus
{	
	public AbstractWindow()
	{
		setWidth("500px");
		setHeight("450px");
		setMode(Mode.OVERLAPPED);
		setClosable(true);
		setMinimizable(true);
		setMaximizable(true);
		setSizable(true);
		setPosition("center");
	}
}
