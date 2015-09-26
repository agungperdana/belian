/**
 * 
 */
package com.kratonsolution.belian.ui.companystructure;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.general.dm.CompanyStructure;
import com.kratonsolution.belian.general.svc.CompanyStructureService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class CompanyStructureModel implements ListModel<CompanyStructure>
{
	private final CompanyStructureService controller = Springs.get(CompanyStructureService.class);
	
	private List<CompanyStructure> data = new ArrayList<CompanyStructure>();
	
	public CompanyStructureModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public CompanyStructure getElementAt(int index)
	{
		if(index >= data.size())
			return null;
		
		return data.get(index);
	}

	@Override
	public int getSize()
	{
		return controller.size();
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
		data.addAll(controller.findAll(0, (itemSize*pageIndex)+itemSize));
	}
}