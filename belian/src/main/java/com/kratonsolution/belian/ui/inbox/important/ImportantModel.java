/**
 * 
 */
package com.kratonsolution.belian.ui.inbox.important;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.tools.dm.Inbox;
import com.kratonsolution.belian.tools.svc.ImportantService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ImportantModel implements ListModel<Inbox>
{
	private ImportantService service = Springs.get(ImportantService.class);
	
	private List<Inbox> data = new ArrayList<Inbox>();
	
	public ImportantModel(int itemSize)
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
		return data.size();
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