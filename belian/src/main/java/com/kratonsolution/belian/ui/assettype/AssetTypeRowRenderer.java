/**
 * 
 */
package com.kratonsolution.belian.ui.assettype;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.asset.dm.AssetType;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class AssetTypeRowRenderer implements RowRenderer<AssetType>
{
	@Override
	public void render(Row row, AssetType data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getCode()));
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(data.getParent()!=null?data.getParent().getName():""));
			row.appendChild(new Label(data.getId()));
		}
	}
}
