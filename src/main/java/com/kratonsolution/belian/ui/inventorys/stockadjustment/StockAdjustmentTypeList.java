/**
 * 
 */
package com.kratonsolution.belian.ui.inventorys.stockadjustment;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.inventory.dm.StockAdjustmentType;
import com.kratonsolution.belian.ui.util.Springs;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StockAdjustmentTypeList extends Listbox
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private Map<String,StockAdjustmentType> maps = new HashMap<String, StockAdjustmentType>();
	
	public StockAdjustmentTypeList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public StockAdjustmentTypeList(boolean fullspan,StockAdjustmentType con)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setMold("select");
		setSelectedItem(null);

		getItems().clear();
		
		for(StockAdjustmentType type:StockAdjustmentType.values())
		{
			Listitem listitem = appendItem(type.display(utils.getLanguage()), type.name());
			if(con != null && con.equals(type))
				setSelectedItem(listitem);
			
			if(!maps.containsKey(type.name()))
				maps.put(type.name(), type);
		}
	}
	
	public StockAdjustmentType getStockAdjustmentType()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
			return maps.get(getSelectedItem().getValue().toString());
		
		return null;
	}
	
	public void setStockAdjustmentType(StockAdjustmentType type)
	{
		if(type != null)
		{
			getItems().clear();
			setSelectedItem(appendItem(type.display(utils.getLanguage()), type.name()));
			
			if(!maps.containsKey(type.name()))
				maps.put(type.name(), type);
		}
	}
}
