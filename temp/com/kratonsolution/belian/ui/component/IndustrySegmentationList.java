/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.IndustrySegmentation;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class IndustrySegmentationList extends Listbox
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	public IndustrySegmentationList()
	{
		setWidth("250px");
		setMold("select");
		
		for(IndustrySegmentation segmentation:IndustrySegmentation.values())
		{
			Listitem listitem = appendItem(segmentation.display(utils.getLanguage()), segmentation.name());
			if(segmentation.equals(IndustrySegmentation.GENERAL))
				setSelectedItem(listitem);
		}
	}
}
