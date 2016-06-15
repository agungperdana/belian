/**
 * 
 */
package com.kratonsolution.belian.ui.inbox.inbox;

import org.zkoss.zul.Treeitem;

import com.kratonsolution.belian.tools.svc.InboxService;
import com.kratonsolution.belian.ui.inbox.MessageListener;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class InboxItem extends Treeitem implements MessageListener
{
	private InboxService service = Springs.get(InboxService.class);
	
	public InboxItem()
	{
		fireMesasgeEvent();
	}
	
	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.ui.inbox.MessageListener#fireDraftCreated()
	 */
	@Override
	public void fireMesasgeEvent()
	{
		setLabel("Inbox("+service.size()+")");
	}
}
