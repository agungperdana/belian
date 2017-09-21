/**
 * 
 */
package com.kratonsolution.belian.ui.financial.generalledger;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class GeneralLedgerReportButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public GeneralLedgerReportButton()
	{
		setImage("/icons/general-journal.png");
		setHeight("38px");
		setTooltiptext(lang.get("navbar.menu.finance.generalledger"));
	}
}
