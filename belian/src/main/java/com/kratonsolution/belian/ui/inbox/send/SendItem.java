/**
 * 
 */
package com.kratonsolution.belian.ui.inbox.send;

import org.zkoss.zul.Treeitem;

import com.kratonsolution.belian.tools.svc.SendService;
import com.kratonsolution.belian.ui.inbox.MessageListener;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SendItem extends Treeitem implements MessageListener
{
	private SendService service = Springs.get(SendService.class);
	
	public SendItem()
	{
		fireMesasgeEvent();
	}
	
	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.ui.inbox.MessageListener#fireDraftCreated()
	 */
	@Override
	public void fireMesasgeEvent()
	{
		setLabel("Send("+service.size()+")");
	}
}
