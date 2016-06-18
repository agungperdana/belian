/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.inventory.goodsissue.GoodsIssueWindow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class GoodsIssueMenu extends Menu
{
	private Language language = Springs.get(Language.class);
	
	public GoodsIssueMenu()
	{
		init();
	}
	
	public void init()
	{
		setLabel(language.get("navbar.menu.inventory.goodsissue"));
		setImage("/icons/goods_issue.png");
		
		addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				showSysadminBlockMessage();
				
				GoodsIssueWindow window = null;
				
				for(Component component:getPage().getRoots())
				{
					if(component instanceof GoodsIssueWindow)
						window = (GoodsIssueWindow)component;
				}
				
				if(window == null)
					window = GoodsIssueWindow.injectInto(getPage());
				
				else if(!window.isVisible())
				{
					window.setVisible(true);
					window.setTopmost();
				}
				else
					window.setTopmost();
			}
		});
	}
}
