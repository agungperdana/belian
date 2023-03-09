
package com.kratonsolution.belian.ui.orders;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.orders.dm.OrderAdjustmentType;
import com.kratonsolution.belian.ui.util.Springs;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class OrderAdjustmentTypeList extends Listbox
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private Map<String,OrderAdjustmentType> maps = new HashMap<String, OrderAdjustmentType>();
	
	public OrderAdjustmentTypeList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public OrderAdjustmentTypeList(boolean fullspan,OrderAdjustmentType con)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setMold("select");
		setSelectedItem(null);

		getItems().clear();
		
		for(OrderAdjustmentType type:OrderAdjustmentType.values())
		{
			Listitem listitem = appendItem(type.display(utils.getLanguage()), type.name());
			if(con != null && con.equals(type))
				setSelectedItem(listitem);
			
			if(!maps.containsKey(type.name()))
				maps.put(type.name(), type);
		}
	}
	
	public OrderAdjustmentType getOrderAdjustmentType()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
			return maps.get(getSelectedItem().getValue().toString());
		
		return null;
	}
	
	public void setOrderAdjustmentType(OrderAdjustmentType type)
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
