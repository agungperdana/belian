/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import org.zkoss.zul.Listbox;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.MaritalStatus;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class MaritalStatusList extends Listbox
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	public MaritalStatusList()
	{
		setWidth("250px");
		setMold("select");
		
		for(MaritalStatus marital:MaritalStatus.values())
		{
			appendItem(marital.display(utils.getLanguage()), marital.name());
			setSelectedIndex(0);
		}
	}
}
