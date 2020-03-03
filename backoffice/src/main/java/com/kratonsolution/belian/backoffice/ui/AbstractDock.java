package com.kratonsolution.belian.backoffice.ui;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Toolbarbutton;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public abstract class AbstractDock extends Toolbarbutton implements Dock,EventListener<Event>
{
	private static final long serialVersionUID = 1L;

	protected KernelTask kernel = Springs.get(KernelTask.class);
	
	protected Language lang = Springs.get(Language.class);
	
}
