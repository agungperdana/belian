package com.kratonsolution.belian.backoffice.ui;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Menuitem;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public abstract class AbstractMenuItem extends Menuitem implements EventListener<Event>
{
	private static final long serialVersionUID = 1L;

	protected Language lang = Springs.get(Language.class);
	
	protected KernelTask kernel = Springs.get(KernelTask.class);
}
