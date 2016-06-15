/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import org.zkoss.zul.Listbox;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.Gender;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class GenderList extends Listbox
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	public GenderList()
	{
		setWidth("250px");
		setMold("select");
		
		for(Gender gender:Gender.values())
		{
			appendItem(gender.display(utils.getLanguage()), gender.name());
			setSelectedIndex(0);
		}
	}
}
