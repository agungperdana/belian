/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.journalentry;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class JournalEntrybutton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public JournalEntrybutton()
	{
		setImage("/icons/journalentry.png");
		setTooltiptext(lang.get("navbar.menu.accounting.journal"));
		setHeight("38px");
	}
}
