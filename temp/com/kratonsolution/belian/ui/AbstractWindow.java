/**
 * 
 */
package com.kratonsolution.belian.ui;

import org.zkoss.zul.Window;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public abstract class AbstractWindow extends Window implements HasStatus
{	
	protected Language lang = Springs.get(Language.class);
	
	protected SessionUtils utils = Springs.get(SessionUtils.class);
	
	public AbstractWindow()
	{
		setWidth("625px");
		setHeight("525px");
		setMode(Mode.OVERLAPPED);
		setClosable(true);
		setMinimizable(true);
		setMaximizable(true);
		setSizable(true);
		setPosition("center");
	}
}
