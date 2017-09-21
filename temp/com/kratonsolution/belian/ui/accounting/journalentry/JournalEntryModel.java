/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.journalentry;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.accounting.dm.JournalEntry;
import com.kratonsolution.belian.accounting.svc.JournalEntryService;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class JournalEntryModel implements ListModel<JournalEntry>
{
	private JournalEntryService service = Springs.get(JournalEntryService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private List<JournalEntry> data = new ArrayList<JournalEntry>();
	
	private String key;
	
	public JournalEntryModel(int itemSize)
	{
		next(0, itemSize,null);
	}
	
	public JournalEntryModel(int itemSize,String key)
	{
		this.key = key;
		next(0, itemSize,key);
	}
	
	@Override
	public JournalEntry getElementAt(int index)
	{
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		return service.size(this.key);
	}

	@Override
	public void addListDataListener(ListDataListener l)
	{
	}

	@Override
	public void removeListDataListener(ListDataListener l)
	{
	}

	public void next(int pageIndex,int itemSize,String key)
	{
		data.clear();
		data.addAll(service.findAll(0, (itemSize*pageIndex)+itemSize,key));
	}
}
