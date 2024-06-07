
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Menuitem;

import com.kratonsolution.belian.common.app.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.tools.view.KernelTask;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public abstract class AbstractMenuItem extends Menuitem implements EventListener<Event>
{
	protected Language lang = Springs.get(Language.class);
	
	protected SessionUtils utils = Springs.get(SessionUtils.class);
	
	protected KernelTask kernel = Springs.get(KernelTask.class);
}
