/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.tools.ImportWindow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ImportToolMenu extends Listitem
{
	private Language language = Springs.get(Language.class);
	
	public ImportToolMenu()
	{
		init();
	}
	
	public void init()
	{
		setLabel("Import Excel");
		setImage("/icons/imports.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				ImportWindow menu = new ImportWindow();
				menu.setPage(getPage());
				menu.doModal();
			}
		});
	}
}
