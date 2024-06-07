package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.app.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.tools.view.Dock;
import com.kratonsolution.belian.tools.view.KernelTask;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
public abstract class AbstractDock extends Toolbarbutton implements Dock, EventListener<Event>
{
	protected KernelTask kernel = Springs.get(KernelTask.class);
	
	protected Language lang = Springs.get(Language.class);
	
	protected SessionUtils utils = Springs.get(SessionUtils.class);
}
