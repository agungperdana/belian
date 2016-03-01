/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.familyfolder;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.healtcare.dm.FamilyFolder;
import com.kratonsolution.belian.healtcare.svc.FamilyFolderService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class FamilyFolderModel implements ListModel<FamilyFolder>
{
	private final FamilyFolderService service = Springs.get(FamilyFolderService.class);
	
	private List<FamilyFolder> data = new ArrayList<FamilyFolder>();
	
	public FamilyFolderModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public FamilyFolder getElementAt(int index)
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
