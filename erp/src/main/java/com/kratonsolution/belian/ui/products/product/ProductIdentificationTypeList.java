
package com.kratonsolution.belian.ui.products.product;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.product.impl.orm.ProductIdentificationType;
import com.kratonsolution.belian.ui.util.Springs;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductIdentificationTypeList extends Listbox
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private Map<String,ProductIdentificationType> maps = new HashMap<String, ProductIdentificationType>();
	
	public ProductIdentificationTypeList(boolean fullspan)
	{
		this(fullspan,null);
	}
	
	public ProductIdentificationTypeList(boolean fullspan,ProductIdentificationType con)
	{
		if(fullspan)
			setWidth("100%");
		else
			setWidth("300px");
		
		setMold("select");
		
		for(ProductIdentificationType type:ProductIdentificationType.values())
		{
			Listitem listitem = appendItem(type.display(utils.getLanguage()), type.name());
			if(con != null && con.equals(type))
				setSelectedItem(listitem);
			
			if(!maps.containsKey(type.name()))
				maps.put(type.name(), type);
		}
	}
	
	public ProductIdentificationType getProductIdentificationType()
	{
		if(getSelectedItem() != null && maps.containsKey(getSelectedItem().getValue().toString()))
			return maps.get(getSelectedItem().getValue().toString());
		
		return null;
	}
	
	public void setProductIdentificationType(ProductIdentificationType type)
	{
		if(type != null)
		{
			if(!maps.containsKey(type.name()))
				maps.put(type.name(), type);
			
			getItems().clear();
			
			for(ProductIdentificationType cache:maps.values())
			{
				Listitem listitem = appendItem(cache.display(utils.getLanguage()), type.name());
				if(cache.equals(type))
					setSelectedItem(listitem);
			}
		}
	}
}
