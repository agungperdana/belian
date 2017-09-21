/**
 * 
 */
package com.kratonsolution.belian.ui.orders.requirements.product;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.requirement.dm.ProductRequirement;
import com.kratonsolution.belian.requirement.svc.ProductRequirementService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductRequirementModel implements ListModel<ProductRequirement>
{
	private ProductRequirementService service = Springs.get(ProductRequirementService.class);
	
	private List<ProductRequirement> data = new ArrayList<ProductRequirement>();
	
	public ProductRequirementModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public ProductRequirement getElementAt(int index)
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
