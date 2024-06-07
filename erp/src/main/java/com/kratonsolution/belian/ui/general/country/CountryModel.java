
package com.kratonsolution.belian.ui.general.country;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;

import com.kratonsolution.belian.core.country.impl.orm.Country;
import com.kratonsolution.belian.core.country.impl.application.CountryService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CountryModel implements ListModel<Country>
{
	private CountryService controller = Springs.get(CountryService.class);
	
	private List<Country> data = new ArrayList<Country>();
	
	private String key;
	
	public CountryModel(int itemSize)
	{
		next(0, itemSize,null);
	}
	
	public CountryModel(int itemSize,String key)
	{
		this.key = key;
		next(0, itemSize,key);
	}
	
	@Override
	public Country getElementAt(int index)
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
	}

	@Override
	public void removeListDataListener(ListDataListener l)
	{
	}

	public void next(int pageIndex,int itemSize,String key)
	{
		data.clear();
		data.addAll(controller.findAll(0, (itemSize*pageIndex)+itemSize));
	}
}
