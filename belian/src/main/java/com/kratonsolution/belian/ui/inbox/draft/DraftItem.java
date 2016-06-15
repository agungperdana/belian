/**
 * 
 */
package com.kratonsolution.belian.ui.inbox.draft;

import org.zkoss.zul.Treeitem;

import com.kratonsolution.belian.tools.svc.DraftService;
import com.kratonsolution.belian.ui.inbox.MessageListener;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DraftItem extends Treeitem implements MessageListener
{
	private DraftService service = Springs.get(DraftService.class);
	
	public DraftItem()
	{
		fireMesasgeEvent();
	}
	
	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.ui.inbox.MessageListener#fireDraftCreated()
	 */
	@Override
	public void fireMesasgeEvent()
	{
		setLabel("Draft("+service.size()+")");
	}
}
