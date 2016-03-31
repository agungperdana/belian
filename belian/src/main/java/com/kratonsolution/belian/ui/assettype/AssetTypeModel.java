/**
 * 
 */
package com.kratonsolution.belian.ui.assettype;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.asset.dm.AssetType;
import com.kratonsolution.belian.asset.svc.AssetTypeService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class AssetTypeModel implements ListModel<AssetType>
{
	private AssetTypeService service = Springs.get(AssetTypeService.class);
	
	private List<AssetType> data = new ArrayList<AssetType>();
	
	public AssetTypeModel(int itemSize)
	{
		next(0, itemSize);
	}
	
	@Override
	public AssetType getElementAt(int index)
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
	public void addListDataListener(ListDataListener l){}

	@Override
	public void removeListDataListener(ListDataListener l){}

	public void next(int pageIndex,int itemSize)
	{
		data.clear();
		data.addAll(service.findAll(0, (itemSize*pageIndex)+itemSize));
	}
}
