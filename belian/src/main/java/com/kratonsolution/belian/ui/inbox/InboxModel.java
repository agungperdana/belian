/**
 * 
 */
package com.kratonsolution.belian.ui.inbox;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.tools.dm.Inbox;
import com.kratonsolution.belian.tools.svc.InboxService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class InboxModel implements ListModel<Inbox>
{
	private final InboxService service = Springs.get(InboxService.class);
	
	private List<Inbox> data = new ArrayList<Inbox>();
	
	public InboxModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public Inbox getElementAt(int index)
	{
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		return service.size();
	}

	@Override
	public void addListDataListener(ListDataListener l)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListDataListener(ListDataListener l)
	{
		// TODO Auto-generated method stub
		
	}

	public void next(int pageIndex,int itemSize)
	{
		data.clear();
		data.addAll(service.findAll(0, (itemSize*pageIndex)+itemSize));
	}
}
