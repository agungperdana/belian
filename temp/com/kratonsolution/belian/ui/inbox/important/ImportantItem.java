/**
 * 
 */
package com.kratonsolution.belian.ui.inbox.important;

import org.zkoss.zul.Treeitem;

import com.kratonsolution.belian.tools.svc.ImportantService;
import com.kratonsolution.belian.ui.inbox.MessageListener;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ImportantItem extends Treeitem implements MessageListener
{
	private ImportantService service = Springs.get(ImportantService.class);
	
	public ImportantItem()
	{
		fireMesasgeEvent();
	}
	
	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.ui.inbox.MessageListener#fireDraftCreated()
	 */
	@Override
	public void fireMesasgeEvent()
	{
		setLabel("Important("+service.size()+")");
	}
}
