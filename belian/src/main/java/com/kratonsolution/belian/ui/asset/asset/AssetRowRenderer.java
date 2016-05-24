/**
 * 
 */
package com.kratonsolution.belian.ui.asset.asset;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.asset.dm.Asset;
import com.kratonsolution.belian.common.DateTimes;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class AssetRowRenderer implements RowRenderer<Asset>
{

	@Override
	public void render(Row row, Asset data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getCode()));
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(DateTimes.format(data.getAcquired())));
			row.appendChild(new Label(data.isActive()?"Yes":"No"));
			row.appendChild(new Label(data.isDisposed()?"Yes":"No"));
			row.appendChild(new Label(data.getId()));
		}
	}
}
