/**
 * 
 */
package com.kratonsolution.belian.ui.inbox.draft;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.tools.dm.Message;
import com.kratonsolution.belian.tools.svc.DraftService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DraftModel implements ListModel<Message>
{
	private DraftService service = Springs.get(DraftService.class);
	
	private List<Message> data = new ArrayList<Message>();
	
	public DraftModel(int itemSize)
	{
		next(0, itemSize);
	}

	@Override
	public Message getElementAt(int index)
	{
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		return data.size();
	}

	@Override
	public void addListDataListener(ListDataListener l)
	{
	}

	@Override
	public void removeListDataListener(ListDataListener l)
	{
	}

	public void next(int pageIndex,int itemSize)
	{
		data.clear();
		data.addAll(service.findAll(0, (itemSize*pageIndex)+itemSize));
	}
}
