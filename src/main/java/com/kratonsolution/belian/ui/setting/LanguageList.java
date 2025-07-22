
package com.kratonsolution.belian.ui.setting;

import java.util.Locale;

import org.assertj.core.util.Strings;
import org.zkoss.zul.Listbox;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class LanguageList extends Listbox
{
	public LanguageList()
	{
		setMold("select");
		setWidth("250px");
		
		appendItem("Bahasa Indonesia", "in_id");
		appendItem("English", "en_us");
	
		SessionUtils utils = Springs.get(SessionUtils.class);
		if(utils != null && !Strings.isNullOrEmpty(utils.getLanguage()) && utils.getLanguage().equalsIgnoreCase("in_id"))
			setSelectedIndex(0);
		else
			setSelectedIndex(1);
	}
	
	public void setLocale(Locale locale)
	{
		if(locale.getLanguage().equalsIgnoreCase("in_id"))
			setSelectedIndex(0);
		else
			setSelectedIndex(1);
	}
	
	public Locale getLocale()
	{
		if(getSelectedItem() != null)
			return new Locale(getSelectedItem().getValue().toString());
		
		return new Locale("en_us");
	}
	
	public String getLocaleCode()
	{
		if(getSelectedItem() != null)
			return getSelectedItem().getValue().toString();
	
		return "en_us";
	}
}
