package com.kratonsolution.belian.common.ui;

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
}
